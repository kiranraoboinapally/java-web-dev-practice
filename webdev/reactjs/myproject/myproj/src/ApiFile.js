import {useEffect} from 'react';
import axios from 'axios';
import {useState} from 'react';
export default function ApiFile()

{
    /*let api=axios.create({
    baseURL:'https://fakestoreapi.com/'})*/
    let [prices,updatePrices]=useState([]);
    useEffect(()=>
    {
        getPrices();
    }, []);
    if(prices.length===0)
    {
    return(
    <>
    <h1 style={{color:'ActiveBorder'}}>Loading...This Page</h1>
    </>)}
    async function getPrices()
    {
        let response= await axios.get('https://fakestoreapi.com/products');
        console.log(response.data);
        updatePrices(response.data);
    }
return(
    <>
    {
        prices.map((product)=>
        {
            return(
                <div key={product.id}>
                <h2 style={{cursor:'pointer'}}>{product.title}</h2>
                <h4 style={{width:'10px',cursor:'pointer'}}>{product.price}</h4>
                <img src={product.image} alt={product.title} style={{width:'100px',cursor:'pointer'}}/>
                </div>
            )
        })
    }
    </>
)
}