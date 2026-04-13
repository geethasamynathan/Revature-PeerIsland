import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";
import CourseCard from "./components/courseCard";

function App() {
  const courses = [
    {
      id: 1,
      courseName: "React Js",
      trainer: "Peter",
      duration: "2 Months",
      fee: "9000",
    },
    {
      id: 2,
      courseName: "Angular",
      trainer: "Sam",
      duration: "2 Months",
      fee: "19000",
    },
    {
      id: 3,
      courseName: "Data Engineering",
      trainer: "Geetha",
      duration: "2 Months",
      fee: "13000",
    },
  ];

  function handleEnroll(courseName) {
    alert(`sucessfully enrolled in ${courseName}`);
  }
  return (
    <>
      {courses.map((course) => (
        <CourseCard key={course.id} {...course} onEnroll={handleEnroll} />
      ))}
    </>
  );
}

export default App;
