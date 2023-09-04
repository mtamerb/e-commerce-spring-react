import { AiOutlineUser } from "react-icons/ai";
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
  return (
    <div className="d-flex justify-content-center">
      <article className="col-12 col-md-6 card">
        <h2 className="form-check-label">
          <b>Sign in </b>
        </h2>
        <p className="text-center text-muted">Fill out this form</p>
        <form
          action="#"
          method="post"
          autoComplete="on"
          onSubmit={handleSubmit}
          onReset={handleReset}
        >
          <div className="input-group mb-2">
            <span className="input-group-text">
              <AiOutlineUser />
            </span>
            <input
              onChange={handleChange}
              value={values.username}
              id="username"
              type="username"
              name="username"
              className="form-control "
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
              className="form-control "
              required
              onChange={handleChange}
              value={values.password}
              placeholder="Password"
            />
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
          >
            Sign in
          </button>
        </form>
      </article>
    </div>
  );
}

export default Signin;
