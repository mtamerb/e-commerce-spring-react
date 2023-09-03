import { AiOutlineUser } from "react-icons/ai";
import { RiLockPasswordLine } from "react-icons/ri";
function Signin() {
  return (
    <div className="d-flex justify-content-center">
      <article className="col-12 col-md-6 card">
        <h2 className="form-check-label">
          <b>Sign in </b>
        </h2>
        <p className="text-center text-muted">Fill out this form</p>
        <form action="#" method="post" autoComplete="on">
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

          <div className="btn btn-info btn-block w-100">
            <button
              id="button"
              type="submit"
              name="button"
              className="btn btn-info"
            >
              Sign in
            </button>
          </div>
        </form>
      </article>
    </div>
  );
}

export default Signin;
