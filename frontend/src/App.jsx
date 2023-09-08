import "./sass/app.sass";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist//js/bootstrap.bundle.js";
import Main from "./components/Main.jsx";
import Signin from "./Auth/Signin.jsx";
import Categories from "./admin/Categories.jsx";
import Admin from "./Auth/Admin.jsx";
import AdminMain from "./admin/AdminMain.jsx";
import PrivateAdmin from "./admin/PrivateAdmin.jsx";
import Register from "./Auth/Register.jsx";
import Users from "./admin/Users.jsx";
import About from "./components/About.jsx";
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />}>
          <Route path="about" element={<About />} />
        </Route>
        <Route path="register" element={<Register />} />
        <Route path="signin" element={<Signin />} />
        <Route path="/admin" element={<Admin />}></Route>
        <Route
          path="/adminmain"
          element={
            <PrivateAdmin>
              <AdminMain />
            </PrivateAdmin>
          }
        >
          <Route path="users" element={<Users />} />
          <Route path="categories" element={<Categories />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
export default App;
