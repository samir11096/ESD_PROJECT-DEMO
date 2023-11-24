import React from 'react'

const Navbar = () => {

  const deleteSession=()=>{
    sessionStorage.clear();
    window.location.reload(true);
  }

  const reloadStates=()=>{
    window.location.reload(true);
  }
  return (
    <div>
    <nav className="navbar navbar-dark bg-dark ml-auto">
    <button type="button" className="btn btn-secondary btn-lg" onClick={deleteSession}>Logout</button>
    <button type = "button" className="btn btn-secondary btn-lg" onClick={reloadStates}>Back</button>

     </nav>
</div>
  )
}

export default Navbar