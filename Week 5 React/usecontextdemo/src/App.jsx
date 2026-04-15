import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import Layout from "./components/Layout";
import "./App.css";
import UserContext from "./components/useContext";
import ThemeContext from "./components/ThemeContext";

function App() {
  const [count, setCount] = useState(0);
  const user = {
    name: "Geetha",
    role: "Senior Consultant",
  };

  const [theme, setTheme] = useState("light");
  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  };
  return (
    <UserContext.Provider value={user}>
      <ThemeContext.Provider value={{ theme, toggleTheme }}>
        <div className={theme}>
          <h1> Employee Portal </h1>
          <Layout />
        </div>
      </ThemeContext.Provider>
    </UserContext.Provider>
  );
}

export default App;
