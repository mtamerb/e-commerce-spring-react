import { Outlet } from "react-router-dom";
import Search from "./Search";
import Navbar from "./Navbar";
function Main() {
  return (
    <div>
      <Navbar />
      <div className="d-flex justify-content-center">
        <Search />
      </div>

      <Outlet />
    </div>
  );
}

export default Main;
