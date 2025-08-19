import React from 'react';
import { Link } from 'react-router-dom';

export default function Login() {
  return (
    <div className="bg-login d-flex align-items-center justify-content-center ">
      <div className="container">
        <div className="row ">
          
          <div className="col-md-4 d-flex align-items-center justify-content-center p-4">
            <div className="text-white text-center">
              <h2>Welcome Back!</h2>
              <p>Login to continue exploring amazing deals.</p>
            </div>
          </div>
          <div className='col-md-2'></div>
          <div className="col-sm-5 bg-transparent p-4 glass-card">
            <div className="text-center">
              <h1 className="mb-4 text-white">
                <i className="fa-solid fa-circle-user"></i>
              </h1>
              <input type="text" className="form-control mb-3" placeholder="Enter Email/Username" />
              <input type="password" className="form-control mb-3" placeholder="Enter Password" />
              <input type="submit" className="btn btn-info w-100 mb-2" />
              <p className="mt-3 text-white">
                Don't have an account? <Link to="/userRegistration">Register</Link>
              </p>
            </div>
          </div>

        </div>
      </div>
    </div>
  );
}
