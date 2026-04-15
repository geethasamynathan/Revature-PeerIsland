import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";
import CourseCard from "./components/courseCard";
import ProductStock from "./components/productStock";
import LoginForm from "./components/Login/LoginForm";

function App() {
  const [count, setCount] = useState(0);

  const incrementCount = () => {
    setCount(count + 1);
  };

  return (
    <>
      <LoginForm />
      {/* <CourseCard />
      <div>
        <h1> Count : {count}</h1>
        <button onClick={incrementCount}>Increment</button>
      </div>
      <ProductStock /> */}
    </>
  );
}

export default App;
