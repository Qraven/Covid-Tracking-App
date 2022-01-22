import React from 'react'
import './App.css';
import axios from 'axios';

const TotalCases = () => {

    const [amount, setAmount] = React.useState([]);

    React.useEffect(() => {
      getData();
    }, []);
  
    let response =0;
  
    const getData = () => {
      const ENDPOINT = "http://localhost:8080/totalCases";
      axios(ENDPOINT).then((response) => {

        var count = response.data;
        var countFormat = count.substring(1);
  
        setAmount(countFormat);
      }).catch(error => {
        console.log("error rip");
        console.log(error);
      })
    }

    return (
        <div>
            <div class="header">Covid-19 cases today in the world</div>
            <hr></hr>
            <div class="amount"><p>{amount}</p></div>
        </div>
    )
}

export default TotalCases
