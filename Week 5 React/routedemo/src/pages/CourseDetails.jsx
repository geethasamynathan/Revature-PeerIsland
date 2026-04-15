import { Outlet, useParams } from "react-router";
import { Link } from "react-router";
export default function CourseDetails() {
  const { courseId } = useParams();
  const courses = [
    {
      id: 101,
      name: "React Js",
      trainer: "Geetha",
      duration: "3 Months",
      fee: 15000,
    },
    {
      id: 102,
      name: "Python",
      trainer: "Ram",
      duration: "2 Months",
      fee: 12000,
    },
    {
      id: 103,
      name: "Cloud AWS",
      trainer: "Monisha",
      duration: "2.5 Months",
      fee: 18000,
    },
    {
      id: 104,
      name: "Data Engineering",
      trainer: "Anitha",
      duration: "4 Months",
      fee: 25000,
    },
  ];
  console.log("courseId " + courseId);
  const selectedCourse = courses.find((course) => course.id == courseId);
  console.log(selectedCourse);
  if (!selectedCourse) return <h2>Course Not Found</h2>;
  return (
    <>
      <h2>Course DetaisPage ➡️ {courseId}</h2>
      <nav>
        <Link to="syllabus">Syllabus</Link> | <Link to="trainer">Trainer</Link>
      </nav>

      <hr />
      <Outlet />
    </>
    // <>
    //   <div>
    //     <h1>{selectedCourse.name}</h1>
    //     <p>Trainer : {selectedCourse.trainer} </p>
    //     <p>Duration : {selectedCourse.duration} </p>
    //     <p>Fee : {selectedCourse.fee} </p>
    //   </div>
    // </>
  );
}
