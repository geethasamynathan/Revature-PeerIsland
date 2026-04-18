import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import App from "./App";
import React from "react";
test("user logs in and sees dashboard", async () => {
  const user = userEvent.setup();
  render(<App />);

  await user.type(screen.getByLabelText(/email/i), "admin@gmail.com");
  await user.type(screen.getByLabelText(/password/i), "12345");
  await user.click(screen.getByRole("button", { name: /login/i }));

  expect(screen.getByText(/welcome to dashboard/i)).toBeInTheDocument();
  expect(screen.getByText(/addition/i)).toBeInTheDocument();
});
