import "./courseCard.css";

function CourseCard({ courseName, trainer, duration, fee, onEnroll }) {
  return (
    <>
      <div className="card">
        <h2>{courseName}</h2>
        <p>
          <strong>Trainer :</strong>
          {trainer}
        </p>
        <p>
          <strong>Duration :</strong>
          {duration}
        </p>
        <p>
          <strong>Fee :</strong>
          {fee}
        </p>

        <button onClick={() => onEnroll(courseName)}>Enroll Now</button>
      </div>
    </>
  );
}

export default CourseCard;
