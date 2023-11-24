import React, { useState } from "react";
import axios from 'axios';
import swal from 'sweetalert'


const NewLogin = () => {

    const loginBaseURL = `http://localhost:8080/PracticeProject-1.0-SNAPSHOT/api/student/login`

    const [user_id, setUser_id] = useState('')
    const [password, setPassword] = useState('')
    

    const loginHandler = (event) => {
        event.preventDefault();
        login();
    }
    const login = async() => {
        await axios.post(loginBaseURL, {
            studentID:user_id,
            password:password
        })
        .then(function (response) {
            console.log(response.data);
            window.sessionStorage.setItem('loginuser',JSON.stringify(response.data))
            window.sessionStorage.setItem('isLoggedIn',1)
            window.location.reload(true)
            // var reply = JSON.parse(window.localStorage.getItem('loginuser'))
            // console.log("from local storage", reply)
        })
        .catch(function (error) {
            console.log(error);
            swal({
                title: "Login Failed",
                text: "check your userID password",
                icon: "error",
                button: "Try Again!!",
            });
            setUser_id('')
            setPassword('')
        });
    }

    return (
        <form onSubmit={loginHandler} id='login-form'>
        <section className="vh-80 gradient-custom">
            <div className="container py-3 h-100">
                <div className="row d-flex justify-content-center align-items-center h-100">
                    <div className="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div className="card bg-dark text-white" style={{ borderRadius: "1rem" }}>
                            <div className="card-body p-5 text-center">

                                <div className="mb-md-5 mt-md-4 pb-5">

                                    <h2 className="fw-bold mb-2 text-uppercase">Login</h2>
                                    <p className="text-white-50 mb-5">Please enter your login and password!</p>

                                    <div className="form-outline form-white mb-4">
                                        <input type="id"
                                            placeholder="Student ID......"
                                            value={user_id}
                                            onChange={event => setUser_id(event.target.value)}
                                            id="form2Example1"
                                            className="form-control form-control-lg" required/>
                                        <label className="form-label" htmlFor="form2Example1">Student ID</label>
                                    </div>

                                    <div className="form-outline form-white mb-4">
                                        <input type="password"
                                            placeholder="Password....."
                                            value={password}
                                            onChange={event => setPassword(event.target.value)}
                                            id="form2Example2"
                                            className="form-control form-control-lg" required />
                                        <label className="form-label" htmlFor="form2Example2">Password</label>
                                    </div>

                                    <p className="small mb-5 pb-lg-2"><a className="text-white-50" href="#!">Forgot password?</a></p>

                                    <button className="btn btn-outline-light btn-lg px-5" type="submit">Login</button>


                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        </form>
    );

}
export default NewLogin;