export function StudentCard() {
  let name = "Fransy";
  let course = " Java Full Stack with AWS";
  let institute = "Nivedha Infotec";

  return `
    <div class="student-card">
    <h2>${name}</h2>
    <p> Course : ${course} </p>
    <p> Insititute :${institute} </p>
    </div>
    `;
}
