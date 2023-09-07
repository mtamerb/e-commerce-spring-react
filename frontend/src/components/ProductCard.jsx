function ProductCard(item) {
  return (
    <div className="card m-4" style={{ width: "20rem" }}>
      <img src={item.avatar} className="card-img-top" alt="..." />
      <div className="card-body"></div>
      <ul className="list-group list-group-flush">
        <li className="list-group-item">A second item</li>
        <li className="list-group-item">A third item</li>
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
