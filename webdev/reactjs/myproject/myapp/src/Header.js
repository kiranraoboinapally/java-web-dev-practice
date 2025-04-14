import './Header.css';
import {List} from './List';

function Header()
{
    let lists=[
        {id:1,itemName:"Chicken Biryani",itemCost:180},
        {id:2,itemName:"Mutton Biryani",itemCost:200},
        {id:3,itemName:"Special Biryani",itemCost:300}
    ];
    return (
        <>
        {
        lists.map(
            (x)=>{
                return <List key={x.id} itemName={x.itemName} itemCost={x.itemCost}></List>
            }
        )
        }
        <ul>
            <li>Home1</li>
            <li>Home2</li>
            <li>Home3</li>
        </ul>
        </>
    );
}
export default Header;