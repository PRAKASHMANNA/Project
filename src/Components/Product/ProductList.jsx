import React, { useEffect, useState } from 'react';
import ErrorMsg from './ErrorMsg';
import ProductCard from './ProductCard';
import Shimmer from './Shimmer';



export default function ProductList() {
const [products, setProducts] = useState([]);
  const [filteredProducts, setFilteredProducts] = useState([]);
  const [searchText, setSearchText] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState("");


  useEffect(() => {
    fetchProducts();
  }, []);

  async function fetchProducts() {
    try {
      setIsLoading(true);
      const res = await fetch("https://fakestoreapi.in/api/products");
      if (!res.ok) throw new Error("Something went wrong, failed to fetch product information.");
      const data = await res.json();
      setProducts(data.products);
      setFilteredProducts(data.products);
      //const categories = [...new Set(data.products.map((p) => p.category))];
        console.log(data.products.map((e)=>e.category));
      setIsLoading(false);
    } catch (error) {
      setErrorMsg(error.message);
       setIsLoading(false);
    } finally {
      setIsLoading(false);
    }
  }
    function handleSearch() {
    const updatedProducts = products.filter(item =>
      item.brand.toLowerCase().includes(searchText.toLowerCase())
    );
    setFilteredProducts(updatedProducts);
  }


  return (
    <section className="container-fluid  bg-products">
        <section className="container-fluid">
        <div className="row d-flex align-item-center justify-content-end">
       <div  className="col-4 d-flex align-items-center mt-4  ">
        <input
          type="text"
          className="form-control"
          placeholder="Search by brand"
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
        />
        <button className="btn btn-info btn-md" onClick={handleSearch}>Search</button>
      </div>   
        </div>
     </section>
      <h1 className='mt-4 '>Product List</h1>
      <div className="row">
        {isLoading && <Shimmer />}
        {!isLoading && !errorMsg && filteredProducts.map((item) => (
          <ProductCard item={item} key={item.id} />
        ))}
        {errorMsg && <ErrorMsg message={errorMsg} />}
      </div>
    </section>
  );
}
