import React from "react";
import { Link } from "react-router-dom";

export default function Registration() {
  return (
    <>
      <div className="bg-registration ">
        <section className="container-fluid">
          
            <p className="text-white mt-5 ms-4">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Corrupti dolores odio, pariatur voluptatum repudiandae eveniet fugit nostrum reiciendis officia aut dolor, eum reprehenderit nisi assumenda mollitia repellat itaque! Provident, cum!</p>
          
          <div className="row d-flex justify-content-center align-items-center mt-5">
            <div className="col-md-8">
              <div className="row">
                <div className="col-md-6 ">
                  <div className="p-4 bg-white">
                    <div className="border-0">
                      <h4 className="text-center mt-2 m-0 mb-3 text-dark">
                        Create Your Account
                      </h4>
                    </div>

                    <div className="input-group mb-2">
                      <span className="input-group-text">
                        <i className="fa-solid fa-user"></i>
                      </span>
                      <input
                        type="text"
                        placeholder="Enter Username"
                        className="form-control"
                      />
                    </div>
                    <div className="input-group mb-2">
                      <span className="input-group-text">
                        <i className="fa-solid fa-envelope"></i>
                      </span>
                      <input
                        type="text"
                        placeholder="Enter Email"
                        className="form-control"
                      />
                    </div>
                    <div className="input-group mb-2">
                      <span className="input-group-text">
                        <i className="fa-solid fa-lock"></i>
                      </span>
                      <input
                        type="password"
                        placeholder="Enter Password"
                        className="form-control"
                      />
                    </div>
                    <div className="input-group mb-2">
                      <span className="input-group-text">
                        <i className="fa-solid fa-lock"></i>
                      </span>
                      <input
                        type="password"
                        placeholder="Confirm Password"
                        className="form-control"
                      />
                    </div>
                    <input type="submit" className="btn btn-info btn-sm me-2" />
                    <input type="reset" className="btn btn-info btn-sm" />
                    <p className="mt-2">
                      Already Have An Account?
                      <Link to="/UserLogin"> Sign In</Link>
                    </p>
                  </div>
                </div>

                <div className="col-md-6">
                  <p className="text-white">
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit...
                  </p>
                  <img
                    src="https://smartmeals.ohmylunch.com/illustrations/login-illustration.png"
                    alt=""
                    style={{ height: "300px", width: "100%" }}
                  />
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </>
  );
}
