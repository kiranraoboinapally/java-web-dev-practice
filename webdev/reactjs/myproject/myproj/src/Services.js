import { useLocation } from "react-router-dom";
export default function Services()
{
    let data=useLocation();
    let x=new URLSearchParams(data.search);
    console.log(x);
    let y=x.get('id');
    console.log(y);
    return(
        <>
        <h3>Services Page for Query or Optimal Search or ? Mark i.e, ?id=12&name="kiran"</h3>
        </>
    );
}