function PrivateAdmin({ children }) {
  //burda eğer giriş yapılmış ise yönlendiricez
  //eğer giriş  yapmamış ise navigate ile yönlendir
  return children;
}

export default PrivateAdmin;
