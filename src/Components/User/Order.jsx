import React from 'react';

export default function Order() {
  // Sample orders data
  const orders = [
    { id: 1, item: 'Laptop', price: 55000, status: 'Delivered' },
    { id: 2, item: 'Headphones', price: 1200, status: 'Shipped' },
    { id: 3, item: 'Smartphone', price: 22000, status: 'Processing' },
  ];

  return (
    <div className='mt-3'>
      <h2 className='display-5 mb-3'>My Orders</h2>
      {orders.length === 0 ? (
        <p>No orders found.</p>
      ) : (
        <table className='table table-striped'>
          <thead>
            <tr>
              <th>#</th>
              <th>Item</th>
              <th>Price (₹)</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {orders.map(order => (
              <tr key={order.id}>
                <td>{order.id}</td>
                <td>{order.item}</td>
                <td>{order.price}</td>
                <td>{order.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
