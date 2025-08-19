import React from 'react';
import { Link } from 'react-router-dom';

export default function Footer() {
  return (
    <footer className="bg-dark text-white p-4 text-center">
      <div className="container">
        <p>&copy; 2025 My E-commerce Website. All Rights Reserved.</p>
        <div className="d-flex justify-content-center gap-3">
          <Link to="/" className="text-white">Home</Link>
          <Link to="/about" className="text-white">About</Link>
          <Link to="/contact" className="text-white">Contact</Link>
          <Link to="/productList" className="text-white">Products</Link>
        </div>
        <div className="mt-2">
          <a href="#" className="text-white me-2"><i className="fab fa-facebook"></i></a>
          <a href="#" className="text-white me-2"><i className="fab fa-twitter"></i></a>
          <a href="#" className="text-white"><i className="fab fa-instagram"></i></a>
        </div>
      </div>
    </footer>
  );
}
