import {React} from 'react';
import './App.css';
// import Header from './Components/Header';
// import Heading from './Components/Heading';
import Login from './components/Login'
import Payments from './components/Payments';
import Navbar from './components/Navbar';

function App() {
 
  // var reply = JSON.parse(window.localStorage.getItem('loginuser')) 
  var reply = window.sessionStorage.getItem('isLoggedIn')
  console.log("from local storage at app js", reply)


  return (
    <div>
      {/* <Header /> */}
      {/* <Heading/> */}
      {
        (reply === null) && <Login />
      }
      {
         (reply !== null) && (
          <>
            <Navbar />
            <Payments/>
          </>
          )
      }
    </div>
  );


}

export default App;
