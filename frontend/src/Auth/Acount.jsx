function Acount() {
  return (
    <div className="btn group p-0">
      <button
        type="button"
        className="btn   text-info"
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
