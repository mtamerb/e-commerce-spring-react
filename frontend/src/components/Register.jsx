import "../sass/register.sass";
import { AiOutlineUser, AiOutlineMail } from "react-icons/ai";
import { RiLockPasswordLine } from "react-icons/ri";
function Registor() {
  return (
    <div className="d-flex justify-content-center">
      <article className="col-12 col-md-6 card">
        <h2 className="form-check-label">
          <b>Register</b>
        </h2>

        <form action="#" method="post" autoComplete="on">
          <div className="input-group mb-2">
            <div className="input-group mb-1">
              <input
                type="text"
                className="form-control mr-2"
                required
                placeholder="First Name"
              />
              <input
                type="text"
                className="form-control"
                required
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
              type="username"
              name="username"
              className="form-control "
              required
              placeholder="User Name"
            />
          </div>
          <div className="input-group mb-2">
            <span className="input-group-text ">
              <AiOutlineMail />
            </span>
            <input
              id="email"
              type="text"
              name="button"
              className="form-control "
              required
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
              className="form-control "
              required
              placeholder="Password"
            />
          </div>
          <div className="form-check mt-2 mb-2">
            <input
              className="form-check-input"
              name="checkbox"
              type="checkbox"
              defaultValue
              id="agreeCheckbox"
            />
            <label className="form-check-chekbox" htmlFor="agreeCheckbox">
              I agree with the <b>Terms and Conditions</b> and the{" "}
              <b>Privacy Policy</b>
            </label>
          </div>
          <div className="btn btn-info btn-block w-100">
            <button
              id="button"
              type="submit"
              name="button"
              className="btn btn-info"
            >
              Create Account
            </button>
          </div>
        </form>
      </article>
    </div>
  );
}

export default Registor;
