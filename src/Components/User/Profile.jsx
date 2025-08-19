import React, { useState } from 'react';

export default function Profile() {
  const [profile, setProfile] = useState({
    username: 'Prakash',
    email: 'prakashmanna33@gmail.com',
    phone: '+91 7008624072'
  });

  return (
    <div className='mt-3'>
      <h2 className='display-5 mb-3'>My Profile</h2>
      <div className="card p-3" style={{ maxWidth: '500px' }}>
        <h5>Username:</h5>
        <p>{profile.username}</p>
        <h5>Email:</h5>
        <p>{profile.email}</p>
        <h5>Phone:</h5>
        <p>{profile.phone}</p>
        <button 
          className='btn btn-info mt-2'
          onClick={() => alert('Edit profile feature coming soon!')}
        >
          Edit Profile
        </button>
      </div>
    </div>
  );
}
