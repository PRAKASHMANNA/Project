import React from 'react';
import { Link, Outlet } from 'react-router-dom';

export default function PersonalInfo() {
  return (
    <div className='bg-personalInfo p-4'>
      <section className='container-fluid mt-3'>
        <div className="row">
          <div className="col">
            <h1 className='display-4'>Personal Information</h1>
            <p className='lead'>
              Manage your account details, orders, and profile information from here.
            </p>
            <div className="d-flex gap-3 mt-3">
              <Link to="order" className='btn btn-info'>My Orders</Link>
              <Link to="profile" className='btn btn-info'>My Profile</Link>
            </div>
          </div>
        </div>

        
        <div className="row mt-4">
          <div className="col">
            <Outlet />
          </div>
        </div>
      </section>
    </div>
  );
}
