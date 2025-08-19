export default function Shimmer() {
  // 👇 Dummy array of 6 items (you can change to any number)
  const dummyArray = new Array(6).fill(0);

  return (
    <>
      <section className="container-fluid mt-5">
        <div className="row">
          {dummyArray.map(( index) => (
            <div className="col-md-4 mb-4" key={index}>
              <div className="card h-100">
                <div className="card-header text-center">
                  <img
                    src=""
                    alt=""
                    className="img-fluid"
                    style={{ height: "200px", objectFit: "contain" }}
                  />
                </div>
                <div className="card-body">
                  {/* Optional shimmer text blocks */}
                  <div className="placeholder-glow">
                    <span className="placeholder col-6 mb-2"></span>
                    <span className="placeholder col-7 mb-2"></span>
                    <span className="placeholder col-4"></span>
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </section>
    </>
  );
}