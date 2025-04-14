import React, { useState } from "react";
import axios from "axios";

function App() {
  const [message, setMessage] = useState("");

  const fetchMessage = () => {
    axios.get("http://localhost:8080/api/hello")
      .then(response => {
        setMessage(response.data); 
      })
      .catch(error => {
        console.error("Error calling the API!", error);
      });
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <button onClick={fetchMessage} style={{ padding: "10px 20px", fontSize: "16px" }}>
        Get Message from Backend
      </button>
      <h1>{message}</h1>
    </div>
  );
}

export default App;
