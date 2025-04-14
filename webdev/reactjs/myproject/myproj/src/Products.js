import {Outlet,useParams} from "react-router-dom";
function Products()
{
    let routeValue= useParams();
    return(
        <>
        {console.log(routeValue.id)}
        <h3>Birayni Product</h3>
        <Outlet />
        </>
    );
}
export default Products;