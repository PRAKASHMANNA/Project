import React from 'react'
import { Link } from 'react-router-dom'

export default function PageNotFound() {
  return (
    <>
    <div className='bg-pagenotfound'>
      <section className=' text-center m-auto '>
        <h1 className=' text-white display-1 text-center'>4
        <i class="fas fa-search "></i>
        4</h1>
        <div className='d-flex row  display-1 justify-content-center'>PageNotFound 
          <span className='text-center'> <i class="fa-regular fa-face-frown"></i> </span>
        </div>
        <p className='text-center lead text-muted  m-0'>we're sorry, the page you requested could not be found </p>
        <p className='text-center lead text-muted '>please go back to the homepage</p>
        <Link to="/" className='btn btn-card shadow text-white'>Go TO Home</Link>
      </section>
       
          
    </div>
    </>
    
  )
}
