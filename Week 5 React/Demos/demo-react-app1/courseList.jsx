import { CourseCard } from "./courseCard";

export function CourseList(courseArray) {
  return `
    <section class="course-list">
    <h2>Available Courses</h2>
    <div class="course-container">
    ${courseArray.map((course) => CourseCard(course)).join("")}
    </div>
    </section>
    `;
}
