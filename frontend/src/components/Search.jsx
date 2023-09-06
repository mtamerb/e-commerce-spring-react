import { AiOutlineSearch } from "react-icons/ai";
function Search() {
  return (
    <form className="w-50 mt-5 d-flex align-items-center bg-white rounded-3">
      <input
        className="w-100  border border-0 rounded-3 p-2"
        placeholder="search..."
      />
      <AiOutlineSearch className="text-black  cursor-pointer m-2" />
    </form>
  );
}

export default Search;
