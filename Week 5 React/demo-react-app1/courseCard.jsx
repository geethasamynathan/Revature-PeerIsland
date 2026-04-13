export function CourseCard(course) {
  return `
    <div class="course-card">
        <h3>${course.courseName}</h3>
        <p><strong> Trainer : </strong> ${course.trainer}</p>
        <p><strong> Duration : </strong> ${course.duration}</p>
        <p><strong> Fee : </strong> ${course.fee}</p>
        </div>
    `;
}
