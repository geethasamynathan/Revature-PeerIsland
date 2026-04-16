function Cart({ cartItems, onIncrease, onDecrease, totalAmount }) {
  return (
    <div className="cart">
      <h3>Cart</h3>
      {cartItems.length === 0 ? (
        <p> your cart is Empty.</p>
      ) : (
        <>
          {cartItems.map((item) => (
            <div key={item.id} className="cart-item">
              <p>{item.name}</p>
              <p> ₹ {item.price}</p>
              <div className="cart-actions">
                <button onClick={() => onDecrease(item.id)}>-</button>
                <span>{item.quantity}</span>
                <button onClick={() => onIncrease(item.id)}>+</button>
              </div>
              <p> subTotal : ₹ {item.price * item.quantity}</p>
            </div>
          ))}
          <h4> Total : ₹{totalAmount} </h4>
        </>
      )}
    </div>
  );
}

export default Cart;
