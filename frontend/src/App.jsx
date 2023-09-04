import "bootstrap/dist/css/bootstrap.min.css";
import Register from "./components/Register.jsx";
import Signin from "./components/Signin.jsx";
import Routebuttons from "./components/Routebuttons.jsx";
import Main from "./components/Main.jsx";
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  return (
    <BrowserRouter>
      <Routebuttons />
      <Routes>
        <Route path="/" element={<Signin />} />
        <Route path="/register" element={<Register />} />
        <Route path="/main" element={<Main />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
