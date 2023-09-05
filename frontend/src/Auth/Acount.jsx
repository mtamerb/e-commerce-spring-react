function Acount() {
  return (
    <div className="btn group dropdown p-0 me-5">
      <button
        type="button"
        className="btn  m-0 p-0 text-info"
        data-bs-toggle="dropdown"
        aria-expanded="false"
      >
        Acount
      </button>
      <ul className="dropdown-menu text-info ">
        <li className="dropdown-item">profile</li>
        <li className="dropdown-item">basket</li>
        <li className="dropdown-item">settings</li>
      </ul>
    </div>
  );
}
export default Acount;
