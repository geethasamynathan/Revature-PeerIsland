import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import LoginForm from "./LoginForm";
import React from "react";

test("show success message for valid login", async () => {
  const user = userEvent.setup();
  const mockLoginSuccess = jest.fn();
  render(<LoginForm onLoginSuccess={mockLoginSuccess} />);

  await user.type(screen.getByLabelText(/email/i), "admin@gmail.com");
  await user.type(screen.getByLabelText(/password/i), "12345");
  await user.click(screen.getByRole("button", { name: /login/i }));

  expect(screen.getByText("Login Successful")).toBeInTheDocument();
});

test("show error message for invalid login", async () => {
  const user = userEvent.setup();
  render(<LoginForm />);

  await user.type(screen.getByLabelText(/email/i), "sample@gmail.com");
  await user.type(screen.getByLabelText(/password/i), "9999");
  await user.click(screen.getByRole("button", { name: /login/i }));

  expect(screen.getByText("Invalid credentials")).toBeInTheDocument();
});
