import logo from "../assets/eshop.png";
function Header() {
  return (
    <header className="header">
      <div className="logo-section">
        <img
          src={logo}
          alt="logo"
          className="logo"
          width="150px"
          height="150px"
        />

        <h1>ShopEasy</h1>
      </div>

      <nav className="navbar">
        <a href="#">Home</a>
        <a href="#">Products</a>
        <a href="#">Cart</a>
        <a href="#">Invoice</a>
      </nav>
    </header>
  );
}

export default Header;
