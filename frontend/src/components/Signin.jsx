import { AiOutlineUser, AiOutlineEye } from "react-icons/ai";
import { RiLockPasswordLine } from "react-icons/ri";
import { useFormik } from "formik";
import { Schema } from "../schema/signRegister";
function Signin() {
  const {
    values,
    errors,
    handleChange,
    handleReset,
    handleSubmit,
    isSubmitting,
  } = useFormik({
    initialValues: {
      username: "",
      password: "",
    },
    onSubmit: (values, action) => {
      action.resetForm();
      console.log(values);
    },
    validationSchema: Schema,
  });
  const typChange = () => {
    if (document.getElementById("password").type === "password") {
      document.getElementById("password").type = "text";
    } else {
      document.getElementById("password").type = "password";
    }
  };
  return (
    <div className="d-flex justify-content-center">
      <article className="col-12 col-md-6 card">
        <h2 className="form-check-label">
          <b>Sign in </b>
        </h2>

        <form
          action="#"
          method="post"
          autoComplete="on"
          onSubmit={handleSubmit}
          onReset={handleReset}
        >
          <div className="input-group mb-2       ">
            <span className="input-group-text">
              <AiOutlineUser />
            </span>
            <input
              onChange={handleChange}
              value={values.username}
              id="username"
              type="username"
              name="username"
              className={`form-control ${
                errors.username ? "border border-danger border-3" : ""
              }`}
              required
              placeholder="User Name"
            />
          </div>
          {errors.username && (
            <span className="text-danger">{errors.username}</span>
          )}
          <div className="input-group mb-2 ">
            <span className="input-group-text ">
              <RiLockPasswordLine />
            </span>
            <input
              id="password"
              type="password"
              name="password"
              className={`form-control  ${
                errors.password ? "border border-3 border-danger" : ""
              }`}
              required
              onChange={handleChange}
              value={values.password}
              placeholder="Password"
            />
            <span className="input-group-text ">
              <AiOutlineEye onClick={() => typChange()} />
            </span>
          </div>
          {errors.password && (
            <span className="text-danger">{errors.password}</span>
          )}
          <button
            id="button"
            type="submit"
            name="button"
            className="btn btn-info btn-block w-100"
            disabled={isSubmitting}
            onBlur={() => console.log("blur")}
          >
            Sign in
          </button>
        </form>
      </article>
    </div>
  );
}

export default Signin;
