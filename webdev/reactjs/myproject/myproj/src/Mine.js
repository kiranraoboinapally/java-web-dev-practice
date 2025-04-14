import React from "react";
export default class Mine extends React.Component
{
    state={counter:0}
    render()
    {
        return(
            <>
            <h3>Counter Value is:{this.state.counter}</h3>
            <button className="btn btn-primary" onClick={
                ()=>{
                    this.setState({
                        counter:this.state.counter+1
                    })
                }
            }>Its a class Click state</button>
            </>
        )
    }
}