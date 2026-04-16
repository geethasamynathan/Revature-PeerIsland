function Sidebar({ categories, selectedCategory, onselectCategory }) {
  return (
    <aside className="sidebar">
      <h3>Categories </h3>
      <ul>
        <li
          className={selectedCategory === "All" ? "active-category" : ""}
          onClick={() => onselectCategory("All")}
        >
          All
        </li>
        {categories.map((category) => (
          <li
            key={category}
            className={selectedCategory === "category" ? "active-category" : ""}
            onClick={() => onselectCategory(category)}
          >
            {category}
          </li>
        ))}
      </ul>
    </aside>
  );
}

export default Sidebar;
