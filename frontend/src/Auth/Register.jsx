import "../sass/register.sass";
import { AiOutlineUser, AiOutlineMail, AiOutlineEye } from "react-icons/ai";
import { RiLockPasswordLine } from "react-icons/ri";
import { typChange, registerSchema } from "../schema/signRegister";
import { useFormik } from "formik";
import { Link } from 'react-router-dom';

function Register() {
  const {
    values,
    errors,
    handleChange,
    handleReset,
    handleSubmit,
    isSubmitting,
  } = useFormik({
    initialValues: {
      firstName: "",
      lastName: "",
      username: "",
      email: "",
      password: "",
    },
    onSubmit: (values, action) => {
      action.resetForm();
      console.log(values);
    },
    validationSchema: registerSchema,
  });
  return (
    <div className="d-flex justify-content-center">
      <article className="col-12 col-md-6 card">
        <h2 className="form-check-label">
          <b>Register</b>
        </h2>

        <form
          action="#"
          method="post"
          autoComplete="on"
          onSubmit={handleSubmit}
          onReset={handleReset}
        >
          <div className="input-group mb-2">
            <div className="input-group mb-1">
              <input
                type="text"
                className="form-control mr-2 "
                required
                name="firstName"
                id="firstName"
                placeholder="First Name"
                value={values.firstName}
                onChange={handleChange}
              />
              <input
                type="text"
                className="form-control"
                required
                id="lastName"
                name="lastName"
                value={values.lastName}
                onChange={handleChange}
                placeholder="Last Name"
              />
            </div>
          </div>
          <div className="input-group mb-2">
            <span className="input-group-text">
              <AiOutlineUser />
            </span>
            <input
              id="username"
              type="text"
              name="username"
              className={`form-control ${errors.username ? "border border-danger border-3" : ""
                }`}
              value={values.username}
              required
              onChange={handleChange}
              placeholder="User Name"
            />
          </div>
          <div className="input-group mb-2">
            <span className="input-group-text ">
              <AiOutlineMail />
            </span>
            <input
              id="email"
              type="email"
              name="email"
              className={`form-control ${errors.email ? "border border-danger border-3" : ""
                }`}
              required
              value={values.email}
              onChange={handleChange}
              placeholder="E-mail Address"
            />
          </div>
          <div className="input-group mb-2">
            <span className="input-group-text ">
              <RiLockPasswordLine />
            </span>
            <input
              id="password"
              type="password"
              name="password"
              className={`form-control ${errors.password ? "border border-danger border-3" : ""
                }`}
              required
              value={values.password}
              onChange={handleChange}
              placeholder="Password"
            />
            <span className="input-group-text ">
              <AiOutlineEye onClick={() => typChange()} />
            </span>
          </div>
          <div className="form-check mt-2 mb-2">
            <input
              className="form-check-input"
              name="checkbox"
              type="checkbox"
              defaultValue
              required
              id="agreeCheckbox"
            />
            <label className="form-check-chekbox" htmlFor="agreeCheckbox">
              I agree with the <b>Terms and Conditions</b> and the
              <b>Privacy Policy</b>
            </label>
          </div>
          <div className="d-flex align-items-center">
            <button
              id="button"
              type="submit"
              name="button"
              className="btn btn-info btn-block w-100"
              disabled={isSubmitting}
            >
              Create Account
            </button>
          </div>
          <div className="link-sign">
            <Link to="/Signin">
              <button type="button">Already registered? Sign in.</button>
            </Link>
          </div>
        </form>
      </article>
    </div>
  );
}

export default Register;
