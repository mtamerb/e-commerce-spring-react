import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist//js/bootstrap.bundle.js";
import Routebuttons from "./components/Navbar.jsx";
import Main from "./components/Main.jsx";
import Signin from "./Auth/Signin.jsx";
import Admin from "./Auth/Admin.jsx";
import AdminMain from "./admin/AdminMain.jsx";
import PrivateAdmin from "./admin/PrivateAdmin.jsx";
import Register from "./Auth/Register.jsx";
import Users from "./admin/Users.jsx";
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  const admin = true;
  return (
    <BrowserRouter>
      {admin ? "" : <Routebuttons />}

      <Routes>
        <Route path="/" element={<Main />} />
        <Route
          path="/adminmain"
          element={
            <PrivateAdmin>
              <AdminMain />
            </PrivateAdmin>
          }
        />
        <Route path="/auth/admin" element={<Admin />} />
        <Route path="/auth/signin" element={<Signin />} />
        <Route path="/auth/register" element={<Register />} />
        <Route path="/adminmain/users" element={<Users />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
