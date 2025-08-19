import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav className='navbar navbar-dark navbar-expand-xl bg-mix'>
      <div className="container-fluid">
        <Link to="/" className='navbar-brand hover-border border-light'>
          <i className="fa-solid fa-snowflake me-2"></i>
          React Routing
        </Link>

        <button 
          className="navbar-toggler " 
          type="button" 
          data-bs-toggle="collapse" 
          data-bs-target="#navbarNav" 
          aria-controls="navbarNav" 
          aria-expanded="false" 
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse text-center" id="navbarNav">
          <ul className="navbar-nav me-auto mb-2 mb-xl-0">
            <li className="nav-item">
              <Link to="/about" className="nav-link text-white hover-border">About</Link>
            </li>
            <li className="nav-item">
              <Link to="/contact" className="nav-link text-white hover-border">Contact</Link>
            </li>
            <li className="nav-item">
              <Link to="/ProductList" className="nav-link text-white hover-border">Products</Link>
            </li>
            <li className="nav-item">
              <Link to="/personalInfo" className="nav-link text-white hover-border">Personal Info</Link>
            </li>
          </ul>

          <div className="d-flex gap-2">
            <Link to="/UserRegistration" className="btn btn-card btn-sm">Registration</Link>
            <Link to="/UserLogin" className="btn btn-card btn-sm">Login</Link>
          </div>
        </div>
      </div>
    </nav>
  );
}
