import React from 'react';

//named function
export function List()
{
    return(
    <>
    <li>Doc</li>
    <li>Pdf</li>
    <li>Xml</li>
    </>
    );
}
export function Order()
{
    return(
    <>
    <li>Pizza</li>
    <li>Biryani</li>
    </>
    );
}


export class Address extends React.Component{
    render()
    {
        return(
            <>
            <h4>Haleem, JNTU</h4>
            </>
        );
    }
}


let a=25;
export default a //inside this only one default can be created.



