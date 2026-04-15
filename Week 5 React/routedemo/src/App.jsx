import { useState } from "react";
import { Routes, Route, Link } from "react-router";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";
import Home from "./pages/Home";
import Contact from "./pages/Contact";
import Course from "./pages/Course";
import CourseDetails from "./pages/CourseDetails";
import CourseSyllabus from "./pages/CourseSyllabus";
import TrainerInfo from "./pages/TrainerInfo";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <div>
        <nav>
          <Link to="/">Home</Link> |<Link to="/courses">Courses </Link> |{" "}
          {/* <Link to="/courses/101">React Courses </Link> |{" "} */}
          <Link to="/contact">Contact</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/courses" element={<Course />} />
          <Route path="/courses/:courseId" element={<CourseDetails />}>
            <Route path="syllabus" element={<CourseSyllabus />} />
            <Route path="trainer" element={<TrainerInfo />} />
          </Route>
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </div>
    </>
  );
}

export default App;
