import React from 'react'
import { Link } from 'react-router-dom'

export default function Contact() {
  return (
    <>
    <section className='container-fluid'>
      
        <div
      className="col-9 p-3 mt-3 rounded"
      style={{
        backgroundColor: '#fff8e1',
        border: '1px solid #ffc107',
        borderLeft: '6px solid #f0ad4e',
        color: '#4a3c00',
        fontSize: '15px',
        margin: 'auto',
      }}
    >
          
          <p className='m-auto text-center'>You can view the contact of this page in your preferred language, by  
            <Link> clicking here</Link>. For detailed steps on how to change your language settings, see our <Link>Help</Link> page.</p>
        </div>
         
         <h2 className='mt-4'> Hello. What can we help you with ?</h2>
         <div className='extend-xl'>----------------------------------</div>
          <section className="container-fluid mt-3">
  <div className="row ">
    <div className=" col-md-6">
      <div className="card shadow-sm" 
      style={{ maxWidth: '350px',
       borderLeft: '5px solid #ff9900' }}>
        <div className="card-body d-flex align-items-center ">
          <div>
            <h5 className="mb-0">Account Settings</h5>
            <small className="text-muted">Manage your login, name, and more</small>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
        <p className='text-left mt-4 fw-bold lead'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Hic, voluptates est quibusdam, quae vero a minima velit dignissimos mollitia reprehenderit autem magni quisquam explicabo porro animi qui numquam quas doloribus.
        Ea quidem optio, reprehenderit labore vel perferendis adipisci. Aspernatur odio perspiciatis dignissimos laboriosam! Labore corporis quisquam, illum nesciunt dicta porro ad iure animi illo, incidunt facere tempore sapiente perspiciatis soluta.</p>


        <section className='container-fluid mt-5'>
          <div className="row">
            <div className="col-md-4">
              <div className="card">
                <div className="card-body">
                  <h5>Name:</h5>
                  <h5>Description:</h5>
                  <h5>Category :</h5>
                </div>
              </div>
            </div>
          </div>
        </section>
        <section className='bg-dark mt-5 m-0'>
        <div className="container-fluid ">
          <h5 className='text-white p-2 text-center '>Thanks for visiting us 
            <span className='ms-2'>
             <i class="fa-regular fa-face-smile-beam"></i>
            </span>
          </h5>
        </div>
      </section>
    </section>
    </>
  )
}
