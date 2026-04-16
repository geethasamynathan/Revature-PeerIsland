import { useState, useRef } from "react";
import "./JobRegistration.css";
export default function JobRegistration() {
  //controlled
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [skill, setSkill] = useState("");

  //Error state
  const [errors, setErrors] = useState({});
  const [successMessage, setSuccessMessage] = useState("");
  //uncontrolled
  const resumeRef = useRef();
  const photoRef = useRef();

  const validateForm = () => {
    let newErrors = {};

    if (name.trim() === "") {
      newErrors.name = "Name is Required";
    } else if (name.trim().length < 3) {
      newErrors.name = "Name must be at least 3 characters";
    }

    if (email.trim() === "") {
      newErrors.email = "Email is Required";
    } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email)) {
      newErrors.email = "Enter a vaid Email Address";
    }

    if (skill.trim() === "") {
      newErrors.skill = "Please Select skill";
    }

    const resumeFile = resumeRef.current.files[0];
    if (!resumeFile) {
      newErrors.resume = "Resume is Required";
    } else {
      const allowedResumeTypes = ["application/pdf"];
      if (!allowedResumeTypes.includes(resumeFile.type)) {
        newErrors.resume = "REsume must be a PDF file";
      }
    }

    const photoFile = photoRef.current.files[0];
    if (!photoFile) {
      newErrors.photo = "ProfilePhoto is Required";
    } else {
      const allowedPhotoTypes = ["image/jpeg", "image/png"];
      if (!allowedPhotoTypes.includes(photoFile.type)) {
        newErrors.photo = "Photo must be a JPEG or PNG";
      }
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSuccessMessage("");

    if (validateForm()) {
      const resume = resumeRef.current.files[0];
      const photo = photoRef.current.files[0];
      setSuccessMessage(`Registration successful!
    Name : ${name}
        Email : ${email}
        Skill :${skill}
        Resume: ${resume?.name}
        Photo : ${photo?.name}
        `);

      setName("");
      setEmail("");
      setSkill("");
      resumeRef.current.value = "";
      photoRef.current.value = "";
      setErrors({});
    }
  };

  return (
    <div className="form-container">
      <form className="job-form" onSubmit={handleSubmit}>
        <h2>Student Job registration </h2>
        <p className="subtitle">Fill your details to apply for placement</p>
        {/* controlled */}
        <div className="form-group">
          <label>Full Name</label>
          <input
            type="text"
            placeholder="Enter Name"
            value={name}
            onChange={(e) => {
              setName(e.target.value);
            }}
          />
          {errors.name && <p className="error">{errors.name}</p>}
        </div>

        {/* controlled */}
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            placeholder="Enter email"
            value={email}
            onChange={(e) => {
              setEmail(e.target.value);
            }}
          />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>
        {/* controlled */}
        <div className="form-group">
          <label>Select SKill</label>
          <select value={skill} onChange={(e) => setSkill(e.target.value)}>
            <option value="">Select skill</option>
            <option value="React">React</option>
            <option value="Java">Java</option>
            <option value="Python">Python</option>
          </select>
          {errors.skill && <p className="error">{errors.skill}</p>}
        </div>
        {/* uncontrolled */}
        <div className="form-group">
          <label> Upload Resume : </label>
          <input type="file" ref={resumeRef} />
          {errors.resume && <p className="error">{errors.resume}</p>}
        </div>
        {/* uncontrolled */}
        <div className="form-group">
          <label> Upload Photo : </label>
          <input type="file" ref={photoRef} />
          {errors.photo && <p className="error">{errors.photo}</p>}
        </div>

        <button type="submit">Register</button>
        {successMessage && <p className="success">{successMessage}</p>}
      </form>
    </div>
  );
}
