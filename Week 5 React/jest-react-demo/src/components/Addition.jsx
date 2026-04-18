import { useState } from "react";
import React from "react";
function Addition() {
  const [num1, setNum1] = useState("");
  const [num2, setNum2] = useState("");
  const [result, setResult] = useState("");

  const handleAdd = () => {
    setResult(Number(num1) + Number(num2));
  };

  return (
    <div>
      <h2>Addition</h2>

      <label htmlFor="add1">First Number </label>
      <input
        type="number"
        id="add1"
        value={num1}
        onChange={(e) => setNum1(e.target.value)}
      />

      <label htmlFor="add2">Second Number </label>
      <input
        type="number"
        id="add2"
        value={num2}
        onChange={(e) => setNum2(e.target.value)}
      />

      <button onClick={handleAdd}>Add</button>

      {result !== "" && <p>Result: {result}</p>}
    </div>
  );
}

export default Addition;
