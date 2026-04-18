import { useState } from "react";
import LoginForm from "./components/LoginForm";
import Dashboard from "./components/Dashboard";
import React from "react";
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div>
      {isLoggedIn ? (
        <Dashboard />
      ) : (
        <LoginForm onLoginSuccess={() => setIsLoggedIn(true)} />
      )}
    </div>
  );
}

export default App;
