import { useState } from "react";

function CourseCard() {
  const [courseName, setCourseName] = useState("");
  const handleEnroll = (courseName) => {
    alert(`you enrolled in ${courseName}  Course`);
  };

  const handleChange = (event) => {
    setCourseName(event.target.value);
  };
  return (
    <div>
      <h2> React Js</h2>
      <input
        type="text"
        placeholder="Enter your name"
        onChange={handleChange}
      />
      <p>
        <strong> {courseName}</strong>
      </p>
      <button onClick={() => handleEnroll(courseName)}>Enroll Now</button>
    </div>
  );
}

export default CourseCard;
