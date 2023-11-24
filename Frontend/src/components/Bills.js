import axios from 'axios';
import React, { useEffect, useState } from 'react'


const Bills = ({pid}) => {

let printDiv = (key) => {
    // console.log("I am in printDiv", key)
    var printContents = document.getElementById(key).innerHTML;
    var originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
    window.location.reload(true)
}

  const [res, setRes] = useState([]);
  const callApi = async()=>{
    await axios.get(`http://localhost:8080/PracticeProject-1.0-SNAPSHOT/api/bill?paymentId=${pid}`)
    .then((response)=>{
        console.log("api",response.data);
        setRes(response.data);//saving the response to local state of component
    })
    .catch(function(error)
    {
        console.log(error);
    });
  }

useEffect(()=> {
    console.log("I'm here");
    callApi();
  },[]);

  return (
    <>
        {res.map((val, key) => 
            {
                        return (
                            <div key ={key}>
                            <div className="container p-3 my-3 border"  id={key.toString()}>
                                <p className= 'h1'><u>
                                    Bill Receipt
                                    </u>
                                </p>

                    <table className="table">
                    <thead className="thead-dark">
                        <tr>
                            <th scope="col">Bill ID</th>
                            <th scope="col">Bill Date</th>
                            <th scope="col">Bill Amount</th>
                            <th scope="col">Student ID</th>
                        </tr>
                    </thead>
                    <tbody>
                                <tr key={key}>
                                <th scope = "row">{val.billId}</th>
                                <td>{val.billDate}</td>
                                <td>{val.amount}</td>
                                <td>{val.studentPayments.stud.studentID}</td>
                                <td>{val.paidAmount}</td>
                                </tr>
                        
                        </tbody>
                </table>
                            
                            </div>
                            <button 
                            onClick={() => {
                            printDiv(key.toString());
                            }}> 
                            Download Bill</button> 

                                {/* <button
                                onClick={printDiv}>
                                Download Bill</button> */}
                                </div>

                        )}
            )}
        

    </>
  )
}

export default Bills
