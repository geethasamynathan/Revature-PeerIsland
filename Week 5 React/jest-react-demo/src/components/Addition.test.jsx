import React from "react";
import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import Addition from "./Addition";

test("adds two numbers correctly", async () => {
  const user = userEvent.setup();
  render(<Addition />);

  const inputs = screen.getAllByRole("spinbutton");

  await user.type(inputs[0], "10");
  await user.type(inputs[1], "20");
  await user.click(screen.getByRole("button", { name: /add/i }));

  expect(screen.getByText("Result: 30")).toBeInTheDocument();
});
