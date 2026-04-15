import { useContext } from "react";
import UserContext from "./useContext";
import ThemeContext from "./ThemeContext";
export default function UserProfile() {
  const user = useContext(UserContext);
  const { theme, toggleTheme } = useContext(ThemeContext);
  return (
    <div className="profile-card">
      <h2>Welcome, {user.name}</h2>
      <p> Role : {user.role} </p>
      <p>Current Theme : {theme}</p>

      <button onClick={toggleTheme}>
        switch to {theme === "light" ? "Dark" : "Light"} Mode
      </button>
    </div>
  );
}
