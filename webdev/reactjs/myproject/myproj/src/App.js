import Menu from './Menu.js'
import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Home from './Home.js';
import Products from './Products.js';
import Nopage from './Nopage.js';
import Services from './Services.js';
import {lazy,Suspense} from 'react';
import UseState from './UseState.js';
import Mine from './Mine.js';
import ApiFile from './ApiFile.js';



let About=lazy(()=>import('./About'));


function display()
{
  alert("Hi");
}

function disc(num)
{
  alert(num);
}


function receiveData(data){
  alert(data);
}

function App() {
  let name="kiran";
  return (
    <>
    <button onClick={display} className="button">Submit</button>
    <button onClick={()=>{disc(10)}} className="button">Save</button><br/><br/>
    <h3 className="textColor">App Component</h3><br/><br/>
    <BrowserRouter>
    <Menu name={name} age="24" passData={receiveData}></Menu>
    <Suspense>
    <Routes>
      <Route path="/home" element={<Home></Home>}/>
      <Route path="/products/:id" element={<Products/>}/>
      <Route path="/services/" element={<Services/>}/> 
      <Route path="/about/" element={<About/>}/> 
      <Route path="/usestate/" element={<UseState/>}/> 
      <Route path="/mine" element={<Mine/>}/>
      <Route path="/apifile" element={<ApiFile/>}/>
      <Route path="*" element={<Nopage/>}/>
    </Routes>
    </Suspense>
    </BrowserRouter>
    
    </>
  );
}

export default App;
