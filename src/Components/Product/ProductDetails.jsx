import { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';


export default function ProductDetails() {
    let [singleProducts,setSingleProducts]=useState([]);
    let {id}=useParams();
    console.log(id);
      
    
    useEffect(()=>{
        getProductsInfo();
    }
    ,[]);
    
    async function getProductsInfo() {
        let res=await fetch(`https://fakestoreapi.in/api/products/${id}`);
        let data= await res.json();
        console.log(data.product);
        setSingleProducts(data.product)
    }
    let{image,brand,price,color,title}=singleProducts;
  return (
    <>
    <div className='bg-productdetails '>
        <p className=' mt-3 ms-3 text-left text-white '>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repudiandae minima enim sapiente eius voluptate delectus reiciendis nostrum doloremque necessitatibus, labore veritatis veniam perspiciatis. Earum, molestias pariatur? Similique, architecto. Distinctio, voluptas!</p>
        <div className='bg-details'>
            <h1 className='mt-2 text-blue  ms-4'>Product details:</h1>
        </div>
        <section className='container-fluid  mt-5'>
        <div className="row m-auto">
            <div className="col-md-8 m-auto">
                <div className="card d-flex justify-content-center align-items-center p-3 ">
                    <div className="d-flex  ">
                        <div className='col-md-6  bg-transparent'><img src={image} alt=""
                        className='img-fluid ' /></div>
                    
                        <div className='col-md-6 ms-2 mt-3'>
                        <h1 className='text-secondary'>Brand:{brand}</h1>
                         <h3>Title:{title}</h3>
                        <h4>Price: ₹ {price}</h4>
                        <h3>Colour: {color}</h3>
                        <p  className='text-success lead'>Stock Is Available</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
       <Link to="/ProductList " className='p-2 btn btn-details btn-sm w-25 m-auto mb-5 mt-4 fs-2 text-white shadow'>Back</Link>
    </div>
        
    
    </>
  )
}
