function ProductCard({ product, onAdToCart }) {
  return (
    <div className="product-card">
      <img src={product.image} alt={product.name} />
      <h4>{product.name}</h4>
      <p>Category :{product.category}</p>
      <p> ₹ {product.price}</p>

      <button onClick={() => onAdToCart(product)}>Add to Cart</button>
    </div>
  );
}

export default ProductCard;
