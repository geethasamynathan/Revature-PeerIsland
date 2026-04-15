import { useState } from "react";
import "./LoginForm.css";
function LoginForm() {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});
  const [success, setSuccess] = useState("");

  const handleChange = (event) => {
    const { name, value } = event.target;

    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const validateForm = () => {
    let newErrors = {};

    if (!formData.email.includes("@")) {
      newErrors.email = "Enter valid Email.";
    }

    if (formData.password.length < 6) {
      newErrors.password = "Password must be atleast 6 characters.";
    }
    return newErrors;
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
      setSuccess("");
    } else {
      setErrors({});
      setSuccess("Login Successful. ✅");
      console.log(formData);
    }
  };

  return (
    <>
      <div className="login-container">
        <form className="login-form" onSubmit={handleSubmit}>
          <h2> Login Form </h2>
          <div>
            <label>Email</label>
            <input
              type="text"
              name="email"
              onChange={handleChange}
              className={errors.email ? "error-input" : ""}
            />
            {errors.email && <p className="error">{errors.email}</p>}
          </div>

          <div>
            <label>Password</label>
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              className={errors.password ? "error-input" : ""}
            />
            {errors.password && <p className="error">{errors.password}</p>}
          </div>

          <button type="submit">Login</button>
          {success && <p className="success">{success}</p>}
        </form>
      </div>
    </>
  );
}

export default LoginForm;
