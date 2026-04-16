import ProductCard from "./ProductCard";
function ProductList({ products, onAddToCart }) {
  return (
    <div className="product-list">
      {products.length > 0 ? (
        products.map((product) => (
          <ProductCard
            key={product.id}
            product={product}
            onAdToCart={onAddToCart}
          />
        ))
      ) : (
        <p> No Products Found.</p>
      )}
    </div>
  );
}

export default ProductList;
