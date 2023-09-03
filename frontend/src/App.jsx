import "bootstrap/dist/css/bootstrap.min.css";
import Register from "./components/Register.jsx";
import Signin from "./components/Signin.jsx";
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Signin />} />
        <Route path="/login" element={<Register />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
