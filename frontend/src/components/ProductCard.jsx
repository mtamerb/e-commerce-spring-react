function ProductCard({ product }) {
  return (
    <div className="card m-1 mt-4 me-2" style={{ width: "20rem" }}>
      <div className="d-flex justify-content-center align-items-center">
        <img
          src={product.imageUrl}
          style={{ width: "200px", height: "200px" }}
        ></img>
      </div>
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
