import { useParams } from "react-router";
export default function TrainerInfo() {
  const { courseId } = useParams();

  return (
    <div>
      <h2> Trainer for this course is {courseId}</h2>
      <p> Tranier Name : Geetha</p>
      <p> Experiece : 19 Years</p>
    </div>
  );
}
