import "bootstrap/dist/css/bootstrap.min.css";
import Routebuttons from "./components/Navbar.jsx";
import Main from "./components/Main.jsx";
import Signin from "./Auth/Signin.jsx";
import Register from "./Auth/Register.jsx";
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  return (
    <BrowserRouter>
      <Routebuttons />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="auth/signin" element={<Signin />} />
        <Route path="/auth/register" element={<Register />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
