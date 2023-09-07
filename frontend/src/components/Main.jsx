import { Outlet } from "react-router-dom";
import api from "../assets/example.json";
import ProductCard from "./ProductCard";
import Search from "./Search";
import Navbar from "./Navbar";
function Main() {
  console.log(api);
  return (
    <div>
      <Navbar />
      <div className="d-flex justify-content-center">
        <Search />
      </div>
      <div className="d-flex justify-content-center flex-wrap">
        {api.map((item, key) => (
          <ProductCard key={key} product={item} />
        ))}
      </div>

      <Outlet />
    </div>
  );
}

export default Main;
