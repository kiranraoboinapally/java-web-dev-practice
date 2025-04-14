import React, { useState } from 'react';
import './Menu.css';
import xyz, { List, Order} from './List.js';
import {Link } from 'react-router-dom'

function Menu(props) {
  const n = 100;
  const [isLogged] = useState(true);  
  const username = "Kiran Logged in";  
  return (
    <React.Fragment>
        <ul>
            <li><Link className="nav-link" to='/Home'><i className="fas fa-house" style={{ marginRight: '8px',cursor:'pointer' }}></i>Home</Link></li>
            <li><Link className="nav-link" to='/Products'>Products</Link></li>
            <li><Link className="nav-link" to='/Services'>Services</Link></li>
            <li><Link className="nav-link" to='/About'>About</Link></li>
            <li><Link className="nav-link" to='/UseState'>UseState</Link></li>
            <li><Link className="nav-link" to='/ApiFile'>API File</Link></li>
            <li><Link className="nav-link" to='/Mine'>Mine</Link></li>
            <li>Contact</li>
            <List />
            <Order />
            {xyz}
            <li>{isLogged ? username : "Login"}</li>  
        </ul>
        {console.log(props)}
        <p>My name is: {props.name}</p>
        <p>My age is: {props.age}</p>
        <p>{props.children}</p>
        <button onClick={() => { props.passData(n); }} className="button">Send</button><br/><br/>
        
    </React.Fragment>
  );
}

export default Menu;
