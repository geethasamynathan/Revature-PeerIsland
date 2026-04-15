import { useState } from "react";

export default function ProductStock() {
  const [quantity, setQuantity] = useState(0);
  const increaseQty = () => {
    setQuantity(quantity + 1);
  };
  const decreaseQty = () => {
    setQuantity(quantity - 1);
  };
  return (
    <>
      <div>
        <h1>Product Quantity</h1>
        <button onClick={decreaseQty}> - </button>
        <span style={{ margin: "0 15px" }}>{quantity}</span>
        <button onClick={increaseQty}> + </button>
      </div>
    </>
  );
}
