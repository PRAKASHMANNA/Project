import React from 'react'
import { Link } from 'react-router-dom'

export default function About() {
  return (
    <>
    <nav className='navbar bg-warning shadow-sm mt-3'>
        <div className='container-fluid'>
          <div className='d-flex flex-column'>
            <span className='navbar-brand mb-0 h5 text-dark'>
              This E-commerce Website has all the shopping essentials!
            </span>
            <Link to="/about-details" className='text-primary small fw-semibold'>
              Read more →
            </Link>
          </div>
        </div>
      </nav>

    <section className="container mt-5">
        <div className="row  shadow-lg bg-light p-3">
        
          <div className="col-md-4">
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam ab aliquid quos odit quidem,
              ex quia magni repellat temporibus omnis dolorem delectus nobis tenetur ratione ipsa facilis vel deleniti beatae!
            </p>
            <img src="https://www.tigren.com/blog/wp-content/uploads/2021/11/ecommerce-design-strategies.png" alt="" className="img-fluid mt-4" />
          </div>

          {/* Center Image */}
          <div className="col-md-4 text-center">
            <img
              src="https://assets.aboutamazon.com/dims4/default/9f193cf/2147483647/strip/true/crop/1600x900+0+0/resize/1376x774!/format/webp/quality/90/?url=https%3A%2F%2Famazon-blogs-brightspot.s3.amazonaws.com%2F29%2F3e%2F626e792f4d08946ceea5adb6613e%2Fimg-8480.png"
              alt=""
              className="img-fluid"
              style={{ Height: '220px' }}
            />
            <p className='mt-2'>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Sed quidem provident fugit aperiam veniam ad magni est harum maxime, dolores natus ratione nihil obcaecati? At est quos quisquam blanditiis aspernatur. </p>
          </div>

          <div className="col-md-4">
            <h5 className="fw-bold">Top Topic</h5>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi vero nesciunt fugiat, alias pariatur ab placeat reprehenderit! Amet ratione provident esse dolorem, quos culpa harum molestiae. Animi possimus maiores esse non ea. Adipisci sunt atque ab dolores repellendus autem, hic enim aperiam modi consectetur obcaecati animi consequuntur, dignissimos expedita error.
            </p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita dolor enim id ad alias aliquid, magnam sapiente asperiores, eius officia mollitia sint vero, architecto laborum inventore! Veritatis, magnam? Consequatur, vitae!
            </p>
          </div>
        </div>
      </section>
      <section className='bg-dark mt-5'>
        <div className="container-fluid">
          <h5 className='text-white p-2 text-center '>Thanks for visiting us 
            <span className='ms-2'>
             <i class="fa-regular fa-face-smile-beam"></i>
            </span>
          </h5>
        </div>
      </section>
    </>
  )
}
