function ProductCard({ product }) {
  console.log(product.avatar);
  return (
    <div className="card m-4" style={{ width: "20rem" }}>
      <img src={product.imageUrl} className="w-100 h-50" alt="..." />
      <div className="card-body"></div>
      <ul className="list-group list-group-flush">
        <li className="list-group-item">{product.name}</li>
        <li className="list-group-item">{product.price}$</li>
      </ul>
      <div className="card-body d-flex justify-content-between">
        <button type="button" className="btn btn-success ">
          add to basket
        </button>
        <button type="button" className="btn btn-info ">
          detail
        </button>
      </div>
    </div>
  );
}

export default ProductCard;
