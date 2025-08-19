import React from 'react'
import { Link } from 'react-router-dom'

export default function Home() {
  return (
    <>
      <section className=''>
        <div className="landing-wrapper d-flex flex-column align-items-center justify-content-center">
          <div className="wrapper">
          <div className=' text-center'>
            <h1 className='display-4 text-mix'>Shop With Us For Amazing Offers</h1>
          <p className='lead '>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Non, ratione? Sunt in quibusdam tempore eveniet necessitatibus odio? Qui, aut. Impedit quaerat, sit, sapiente minus tempora perspiciatis hic quisquam illum rem voluptate autem illo est suscipit atque! Necessitatibus earum vero soluta doloribus perspiciatis aliquid facere tempore facilis nobis. Quasi, asperiores alias?</p>
          <Link to="/ProductList" className='btn btn-info'>SHOP NOW</Link>
          </div>
        </div>
        </div>
        </section> 
    </>
  )
}
