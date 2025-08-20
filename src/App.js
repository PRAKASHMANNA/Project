import {  BrowserRouter, HashRouter, Route, Routes } from 'react-router-dom';


import Home from './Components/Layout/Home';
import About from './Components/Layout/About';
import Contact from './Components/Layout/Contact';
import Navbar from './Components/Layout/Navbar';
import Login from './Components/User/Login';
import Registration from './Components/User/Registration';
import ProductList from './Components/Product/ProductList';
import ProductDetails from './Components/Product/ProductDetails';
import PageNotFound from './Components/Layout/PageNotFound';
import PersonalInfo from './Components/User/PersonalInfo';
import Order from './Components/User/Order';
import Profile from './Components/User/Profile';
import Footer from './Components/Layout/Footer';


function App() {
  return (
    
      <HashRouter>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/about' element={<About />} />
          <Route path='/contact' element={<Contact />} />
          <Route path='/productList' element={<ProductList />} />
          <Route path='/products/:id' element={<ProductDetails />} />
          <Route path='/userLogin' element={<Login />} />
          <Route path='/userRegistration' element={<Registration />} />
          <Route path='/personalInfo' element={<PersonalInfo />}>
            <Route path='order' element={<Order />} />
            <Route path='profile' element={<Profile />} />
          </Route>
          
          <Route path='*' element={<PageNotFound />} />
        </Routes>
        <Footer />
      </HashRouter>
   
  );
}

export default App;
