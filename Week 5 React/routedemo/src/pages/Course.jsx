import { Link } from "react-router";
import { useNavigate } from "react-router";

export default function Course() {
  const navigate = useNavigate();
  const courses = [
    { id: 101, name: "React Js", trainer: "Geetha" },
    { id: 102, name: "Python", trainer: "Ram" },
    { id: 103, name: "Cloud AWS", trainer: "Monisha" },
    { id: 104, name: "Data Engineering", trainer: "Anitha" },
  ];

  const handleViewDetails = (id) => {
    navigate(`${id}`);
  };
  return (
    <>
      <h2>Our Courses </h2>\
      {courses.map((course) => (
        <div key={course.id} style={{ marginBottom: "12px" }}>
          <h3>{course.name}</h3>
          <p>Trainer: {course.trainer}</p>

          <button onClick={() => handleViewDetails(course.id)}>
            View Details
          </button>
        </div>
      ))}
      {/* {courses.map((course) => (
        <div key={course.id}>
          <Link to={`/courses/${course.id}`}>
            {course.name} - {course.trainer}
          </Link>
        </div>
      ))} */}
    </>
  );
}
