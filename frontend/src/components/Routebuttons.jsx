import { Link } from "react-router-dom";
function Routebuttons() {
  console.log("rendered");
  return (
    <div className="">
      <button type="button" className="btn bg-light m-2 ">
        <Link to="/" className="text-decoration-none">
          Sign in
        </Link>
      </button>

      <button type="button" className="btn bg-light m-2 ">
        <Link to="/register" className="text-decoration-none">
          Register
        </Link>
      </button>
    </div>
  );
}

export default Routebuttons;
