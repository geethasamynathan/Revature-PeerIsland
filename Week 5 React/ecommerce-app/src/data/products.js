const products = [
  // Electronics
  {
    id: 1,
    name: "iPhone 15",
    category: "Electronics",
    price: 80000,
    image: "https://dummyjson.com/image/400x300/000/fff&text=iPhone+15",
  },
  {
    id: 2,
    name: "Samsung TV",
    category: "Electronics",
    price: 45000,
    image: "https://dummyjson.com/image/400x300/222/fff&text=Samsung+TV",
  },
  {
    id: 3,
    name: "Sony Headphones",
    category: "Electronics",
    price: 5000,
    image: "https://dummyjson.com/image/400x300/333/fff&text=Headphones",
  },
  {
    id: 4,
    name: "Dell Laptop",
    category: "Electronics",
    price: 65000,
    image: "https://dummyjson.com/image/400x300/444/fff&text=Dell+Laptop",
  },
  {
    id: 5,
    name: "Smart Watch",
    category: "Electronics",
    price: 7000,
    image: "https://dummyjson.com/image/400x300/555/fff&text=Watch",
  },

  // Clothing
  {
    id: 6,
    name: "Men T-Shirt",
    category: "Clothing",
    price: 1200,
    image: "https://dummyjson.com/image/400x300/666/fff&text=Men+TShirt",
  },
  {
    id: 7,
    name: "Women Jacket",
    category: "Clothing",
    price: 2500,
    image: "https://dummyjson.com/image/400x300/777/fff&text=Women+Jacket",
  },
  {
    id: 8,
    name: "Kids Jeans",
    category: "Clothing",
    price: 900,
    image: "https://dummyjson.com/image/400x300/888/fff&text=Kids+Jeans",
  },
  {
    id: 9,
    name: "Formal Shirt",
    category: "Clothing",
    price: 1500,
    image: "https://dummyjson.com/image/400x300/999/fff&text=Formal+Shirt",
  },
  {
    id: 10,
    name: "Sports Shoes",
    category: "Clothing",
    price: 3000,
    image: "https://dummyjson.com/image/400x300/123/fff&text=Shoes",
  },

  // Books
  {
    id: 11,
    name: "React Book",
    category: "Books",
    price: 900,
    image: "https://dummyjson.com/image/400x300/234/fff&text=React+Book",
  },
  {
    id: 12,
    name: "JavaScript Guide",
    category: "Books",
    price: 700,
    image: "https://dummyjson.com/image/400x300/345/fff&text=JS+Guide",
  },
  {
    id: 13,
    name: "Python Basics",
    category: "Books",
    price: 800,
    image: "https://dummyjson.com/image/400x300/456/fff&text=Python",
  },
  {
    id: 14,
    name: "SQL Mastery",
    category: "Books",
    price: 950,
    image: "https://dummyjson.com/image/400x300/567/fff&text=SQL",
  },
  {
    id: 15,
    name: "CSS Design",
    category: "Books",
    price: 600,
    image: "https://dummyjson.com/image/400x300/678/fff&text=CSS",
  },

  // Groceries
  {
    id: 16,
    name: "Rice Bag",
    category: "Groceries",
    price: 1500,
    image: "https://dummyjson.com/image/400x300/789/fff&text=Rice",
  },
  {
    id: 17,
    name: "Cooking Oil",
    category: "Groceries",
    price: 250,
    image: "https://dummyjson.com/image/400x300/890/fff&text=Oil",
  },
  {
    id: 18,
    name: "Sugar",
    category: "Groceries",
    price: 60,
    image: "https://dummyjson.com/image/400x300/901/fff&text=Sugar",
  },
  {
    id: 19,
    name: "Salt",
    category: "Groceries",
    price: 20,
    image: "https://dummyjson.com/image/400x300/112/fff&text=Salt",
  },
  {
    id: 20,
    name: "Tea Powder",
    category: "Groceries",
    price: 180,
    image: "https://dummyjson.com/image/400x300/223/fff&text=Tea",
  },

  // Home Appliances
  {
    id: 21,
    name: "Mixer Grinder",
    category: "Home",
    price: 3500,
    image: "https://dummyjson.com/image/400x300/334/fff&text=Mixer",
  },
  {
    id: 22,
    name: "Microwave Oven",
    category: "Home",
    price: 9000,
    image: "https://dummyjson.com/image/400x300/445/fff&text=Microwave",
  },
  {
    id: 23,
    name: "Refrigerator",
    category: "Home",
    price: 25000,
    image: "https://dummyjson.com/image/400x300/556/fff&text=Fridge",
  },
  {
    id: 24,
    name: "Washing Machine",
    category: "Home",
    price: 28000,
    image: "https://dummyjson.com/image/400x300/667/fff&text=Washing",
  },
  {
    id: 25,
    name: "Vacuum Cleaner",
    category: "Home",
    price: 5000,
    image: "https://dummyjson.com/image/400x300/778/fff&text=Vacuum",
  },

  // Continue similar pattern up to 50
  ...Array.from({ length: 25 }, (_, i) => ({
    id: 26 + i,
    name: `Product ${26 + i}`,
    category: i % 2 === 0 ? "Accessories" : "Fashion",
    price: 500 + i * 100,
    image: `https://dummyjson.com/image/400x300/${100 + i}/fff&text=Product+${
      26 + i
    }`,
  })),
];

export default products;
