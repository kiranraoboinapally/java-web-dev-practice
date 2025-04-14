import {useEffect,useState} from "react";
export default function UseState()
{
    let [counter,updateCounter]=useState(0);
    useEffect(()=>{
        console.log("This is Coding ");
    })
return(
<>
<h3>Counter Value is:{counter}</h3>
<button className="btn btn-primary" onClick={
    ()=>{
        updateCounter(counter+1)
    }
}
>Click Here to Update</button>
</>
);
}