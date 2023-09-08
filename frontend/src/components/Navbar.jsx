import { Link } from "react-router-dom";
import { SlBasket } from "react-icons/sl";
import Acount from "../Auth/Acount";
const hesap = false;
function Routebuttons() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link className="nav-link text-info" aria-current="page" to="/">
                main
              </Link>
            </li>
            <li className="nav-item">
              <Link
                className="nav-link text-info"
                aria-current="page"
                to="/about"
              >
                about
              </Link>
            </li>
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle text-info"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Dropdown
              </a>
              <ul className="dropdown-menu">
                <li>
                  <a className="dropdown-item text-info" href="#">
                    eşya
                  </a>
                </li>
                <li>
                  <a className="dropdown-item text-info" href="#">
                    ayyakkabı
                  </a>
                </li>
                <li>
                  <a className="dropdown-item text-info">teknoloji</a>
                </li>
              </ul>
            </li>
            <li
              className="nav-item dropdown"
              style={{ height: "40px", width: "40px" }}
            >
              <Link to="/" className="position-relative">
                <SlBasket className="text-info w-100 h-100 " />
                <span className="badge badge-pill badge-success position-absolute  text-info sticky-top">
                  0
                </span>
              </Link>
            </li>
          </ul>
          {hesap ? (
            <Acount />
          ) : (
            <div className="text-center auth">
              <button
                type="button"
                className="btn text-info p-0 text-start me-2  "
              >
                <Link to="/register" className="text-decoration-none text-info">
                  Register
                </Link>
              </button>
              <button
                type="button"
                className="btn text-info  text-left  text-start p-0"
              >
                <Link to="/signin" className="text-decoration-none text-info">
                  Sign in
                </Link>
              </button>
            </div>
          )}
        </div>
      </div>
    </nav>
  );
}

export default Routebuttons;
