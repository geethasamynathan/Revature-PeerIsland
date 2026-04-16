function Searchbar({ searchTerm, onsearchChange }) {
  return (
    <div className="search-bar">
      <input
        type="text"
        placeholder="search Text..."
        value={searchTerm}
        onChange={(e) => onsearchChange(e.target.value)}
      />
    </div>
  );
}

export default Searchbar;
