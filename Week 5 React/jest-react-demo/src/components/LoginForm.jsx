import { useState } from "react";
import React from "react";
function LoginForm({ onLoginSuccess }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleLogin = () => {
    if (email === "admin@gmail.com" && password === "12345") {
      setMessage("Login Successful");
      onLoginSuccess();
    } else {
      setMessage("Invalid credentials");
    }
  };

  return (
    <div>
      <h2>Login Form</h2>

      <label htmlFor="email">Email</label>
      <input
        type="email"
        id="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <label htmlFor="password">Password</label>
      <input
        type="password"
        id="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={handleLogin}>Login</button>

      {message && <p>{message}</p>}
    </div>
  );
}

export default LoginForm;
