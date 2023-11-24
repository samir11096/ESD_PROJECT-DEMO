import React, { useEffect, useState } from 'react'
// import Navbar from './Navbar';


import axios from 'axios';

import Bills from './Bills';

const Payments = () => {

const [res,setRes]=useState([]);
const [pid, setPid]=useState('');
const [showbills, setShowbills] = useState(false);
const user= JSON.parse(window.sessionStorage.getItem('loginuser'));
// console.log("user data",user.studentID)


const Fetch_data = async()=>{
    await axios.get(`http://localhost:8080/PracticeProject-1.0-SNAPSHOT/api/studentPayment?studentId=${user.studentID}`)
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
    Fetch_data();
  },[]);


return (<>
        {
            (showbills===false) &&
            (<>
            {/* <div className="container-fluid">
                <div className="row">
                    <div className="col-sm">
                        Student ID 
                    </div>
                <div className="col-sm">
                        Student Name
                </div>
                <div className="col-sm">
                        Student Email
                </div>
                </div>
            </div> */}
                <div className='paidBills mt-5'>
                <table className="table">
                    <thead className="thead-dark">
                        <tr>
                            <th scope="col">Payment ID</th>
                            <th scope="col">Payment Type</th>
                            <th scope="col">Total Emi</th>
                            <th scope ="col"> Paid Emi</th>
                            <th scope="col">Status</th>
                            <th scope="col">Total Amount</th>
                            <th scope="col">Paid Amount </th>
                        </tr>
                    </thead>
                    <tbody>

                        {res.map((val, key) => 
                        {
                            // if(val.type==="pending")
                            // {
                                return (
                                <tr key={key}>
                                <th scope = "row">{val.paymentID}</th>
                                <td>{val.type}</td>
                                <td>{val.totalEmi}</td>
                                <td>{val.paidEmi}</td>
                                <td>{val.status}</td>
                                <td>{val.totalAmount}</td>
                                <td>{val.paidAmount}</td>
                                <td><button
                                onClick={()=>{
                                    setShowbills(true);
                                    setPid(val.paymentID);
                                }}
                                >View Bill</button></td>

                                </tr>
                        )
                    // }
                                })}
                        </tbody>
                    </table>
                
                </div>
            </>)
        }
        {
            (showbills===true) && (<Bills pid={pid}/>)
        }
        </>
    );

}

export default Payments