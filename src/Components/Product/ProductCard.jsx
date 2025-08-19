import { Link } from "react-router-dom";

export default function ProductCard({item}) {
     const { id, image, brand, price } = item;
    return (<>
    <div className="col-md-4 mb-4" key={item.id}>
              <Link to={`/products/${item.id}`}> 
              <div className="card h-100 ">
                <div className="card-header text-center">
                  <img
                    src={image}
                    alt=""
                    className="img-fluid"
                    style={{ height: "200px", objectFit: "contain" }}
                    
                  />
                </div>
                <div className="card-body bg-card">
                  <h1>Brand: {brand}</h1>
                  {/* <h5 className="card-title">Title: {title}</h5>
                  <h3 className="card-text">Category: {category}</h3> */}
                  <h3 className="card-text">Price: ₹{price}</h3>
                  <div className="d-flex justify-content-evenly">
                    <button className="btn btn-one rounded-4">Add To Cart</button>
                  <button className="btn btn-danger rounded-4">🛒buy now</button>
                  </div>
                </div>
              </div>
              </Link>
            </div>
    
    </>)
}