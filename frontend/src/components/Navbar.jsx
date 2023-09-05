import { Link } from "react-router-dom";
import Acount from "../Auth/Acount";
const hesap = false;
function Routebuttons() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <div>
          <button type="button" className="btn text-info m-2 ">
            <Link to="/" className="text-decoration-none text-info">
              Main
            </Link>
          </button>
          <button type="button" className="btn text-info m-2 ">
            <Link to="/about" className="text-decoration-none text-info">
              About
            </Link>
          </button>
          <div className="btn-group">
            <button
              type="button"
              className="btn  m-2 dropdown-toggle text-info"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Categories
            </button>
            <ul className="dropdown-menu text-info">
              <li>eşya</li>
              <li>ayyakkabı</li>
              <li>teknoloji</li>
            </ul>
          </div>
        </div>
        {hesap ? (
          <Acount />
        ) : (
          <div>
            <button type="button" className="btn text-info m-2 ">
              <Link
                to="/auth/register"
                className="text-decoration-none text-info"
              >
                Register
              </Link>
            </button>
            <button type="button" className="btn text-info m-2 ">
              <Link
                to="/auth/signin"
                className="text-decoration-none text-info"
              >
                Sign in
              </Link>
            </button>
          </div>
        )}
      </div>
    </nav>
  );
}

export default Routebuttons;
