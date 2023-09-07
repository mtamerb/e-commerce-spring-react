import { Outlet } from "react-router-dom";
import { useEffect, useState } from "react";
import ProductCard from "./ProductCard";
import Search from "./Search";
import Navbar from "./Navbar";
function Main() {
  const [pro, setPro] = useState();
  const allProducts = async () => {
    await fetch("https://64f5eb292b07270f705de61f.mockapi.io/products")
      .then((res) => res.json())
      .then((data) => setPro(data));
  };
  useEffect(() => {
    allProducts();
  }, []);
  console.log(pro);
  return (
    <div>
      <Navbar />
      <div className="d-flex justify-content-center">
        <Search />
      </div>
      <div className="d-flex justify-content-center flex-wrap">
        {pro && pro.map((item, key) => <ProductCard key={key} item={item} />)}
      </div>

      <Outlet />
    </div>
  );
}

export default Main;
