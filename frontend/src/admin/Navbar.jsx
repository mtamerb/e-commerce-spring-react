import { AiOutlineMail } from "react-icons/ai";
import { Link } from "react-router-dom";
function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <Link to="/adminmain" className="nav-link text-info">
          Admin
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link to="users" className="nav-link text-info">
                Users
              </Link>
            </li>
            <li className="nav-item">
              <Link to="categories" className="nav-link text-info">
                Categories
              </Link>
            </li>
            <li className="nav-item">
              <Link to="products" className="nav-link text-info">
                Products
              </Link>
            </li>
            <li className="nav-item">
              <a className="nav-link text-info" aria-disabled="true">
                <AiOutlineMail />
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}
export default Navbar;
