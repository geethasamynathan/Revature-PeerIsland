import { useParams } from "react-router";

export default function CourseSyllabus() {
  const { courseId } = useParams();
  return (
    <div>
      <h3> Syllabus for Course {courseId}</h3>
      <ul>
        <li>Introduction</li>
        <li>Hooks</li>
        <li>Routing</li>
        <li>Consuming API</li>
      </ul>
    </div>
  );
}
