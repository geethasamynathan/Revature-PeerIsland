import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";
import Invoice from "./components/Invoice";
import productsData from "./data/products";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";
import Searchbar from "./components/SearchBar";

function App() {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [cartItems, setCartItems] = useState([]);

  const categories = [
    ...new Set(productsData.map((product) => product.category)),
  ];

  const filteredProducts = productsData.filter((product) => {
    const matchesSearch = product.name
      .toLowerCase()
      .includes(searchTerm.toLowerCase());

    const matchesCategory =
      selectedCategory === "All" || product.category === selectedCategory;

    return matchesSearch && matchesCategory;
  });

  const handleAddToCart = (product) => {
    const existingProduct = cartItems.find((item) => item.id === product.id);

    if (existingProduct) {
      const updatedCart = cartItems.map((item) =>
        item.id === product.id
          ? { ...item, quantity: item.quantity + 1 }
          : item,
      );
      setCartItems(updatedCart);
    } else {
      setCartItems([...cartItems, { ...product, quantity: 1 }]);
    }
  };

  const handleIncrease = (id) => {
    const updatedCart = cartItems.map((item) =>
      item.id === id ? { ...item, quantity: item.quantity + 1 } : item,
    );
    setCartItems(updatedCart);
  };

  const handleDecrease = (id) => {
    const updatedCart = cartItems
      .map((item) =>
        item.id === id ? { ...item, quantity: item.quantity - 1 } : item,
      )
      .filter((item) => item.quantity > 0);
    setCartItems(updatedCart);
  };

  const totalAmount = cartItems.reduce(
    (total, item) => total + item.price * item.quantity,
    0,
  );

  return (
    <div className="app-container">
      <Header />
      <div className="main-layout">
        <Sidebar
          categories={categories}
          selectedCategory={selectedCategory}
          onselectCategory={setSelectedCategory}
        />

        <main className="content">
          <Searchbar searchTerm={searchTerm} onsearchChange={setSearchTerm} />

          <ProductList
            products={filteredProducts}
            onAddToCart={handleAddToCart}
          />
        </main>

        <div className="right-panel">
          <Cart
            cartItems={cartItems}
            onIncrease={handleIncrease}
            onDecrease={handleDecrease}
            totalAmount={totalAmount}
          />

          <Invoice cartItems={cartItems} totalAmount={totalAmount} />
        </div>
      </div>
    </div>
  );
}
export default App;
