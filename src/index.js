import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';


// External styles
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'mdbootstrap/css/mdb.min.css'; 
// Use mdb.min.css instead of bootstrap.css for MDB
import '@fortawesome/fontawesome-free/css/all.min.css';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  
    
  </React.StrictMode>
);
