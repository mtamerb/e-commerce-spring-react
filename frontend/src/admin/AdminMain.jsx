import Navbar from "./Navbar";
import { Outlet } from "react-router-dom";
function AdminMain() {
  return (
    <div>
      <Navbar />
      <Outlet />
    </div>
  );
}

export default AdminMain;
