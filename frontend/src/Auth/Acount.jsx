function Acount() {
  return (
    <div className="btn group">
      <button
        type="button"
        className="btn  m-2  text-info"
        data-bs-toggle="dropdown"
        aria-expanded="false"
      >
        Acount
      </button>
      <ul className="dropdown-menu text-info ">
        <li>profile</li>
        <li>basket</li>
        <li>settings</li>
      </ul>
    </div>
  );
}
export default Acount;
