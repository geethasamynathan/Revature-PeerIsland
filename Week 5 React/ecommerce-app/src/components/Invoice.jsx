function Invoice({ cartItems, totalAmount }) {
  const generateInvoice = () => {
    let invoiceText = " --------------- SHOP EASY INVOICE ---------\n\n";
    cartItems.forEach((item) => {
      invoiceText += `${item.name}  | Qty : ${item.quantity} | Price : ₹${item.price} 
            |subTotal : ${item.price}* ${item.quantity} \n`;
    });
    invoiceText += `\n Total Amount : ₹ ${totalAmount} `;
    alert(invoiceText);
  };

  return (
    <div className="invoice-section">
      <button onClick={generateInvoice} disabled={cartItems.length === 0}>
        Generate Invoice
      </button>
    </div>
  );
}

export default Invoice;
