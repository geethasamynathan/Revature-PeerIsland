import { useEffect, useState } from "react";
import { getProducts } from "../services/productService";

export default function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  async function loadProducts() {
    const data = await getProducts();
    setProducts(data);
  }

  return (
    <div>
      <h1>Product List </h1>
      {products.map((item) => (
        <div key={item.id}>
          <img src={item.image} width="150" />
          <p>{item.firstName}</p>
        </div>
      ))}
    </div>
  );
}
