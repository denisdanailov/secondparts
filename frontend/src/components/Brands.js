import { Link } from "react-router-dom";

export const Brands = () => {
  return (
    <section className="shop_section layout_padding">
      <div className="container">
        <div className="heading_container heading_center">
          <h2>Wir arbeiten mit folgenden Marken</h2>
        </div>
        <div className="row">
          <div className="col-md-6">
            <div className="box">
              <a href="/">
                <div className="img-box">
                  <img src="images/mechanic_2.png" alt="" />
                </div>
                <div className="detail-box">
                  <h6>Teile zum verkaufen:</h6>
                  <h6>
                    300.23
                    <span> Teile </span>
                  </h6>
                </div>
                <div className="new">
                  <span> Momentan 1.229 </span>
                </div>
              </a>
            </div>
          </div>
          <div className="col-sm-6 col-xl-3">
            <div className="box">
              <Link to="/models/mercedes-benz">
                <div className="img-box">
                  <img src="images/mercedes-benz-logo.png" alt="" />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-3">
            <div className="box">
              <Link to="/models/audi">
                <div className="img-box">
                  <img src="images/audi-logo.png" alt="" />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-3">
            <div className="box">
              <Link to="/models/bmw">
                <div className="img-box">
                  <img src="images/bmw-logo.png" alt="" />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-3">
            <div className="box">
              <Link to="/models/vw">
                <div className="img-box">
                  <img src="images/vw-logo.png" alt="" />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-3">
            <div className="box">
              <Link to="/models/porsche">
                <div className="img-box">
                  <img src="images/porshe-logo.png" alt="" />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-3">
            <div className="box">
              <Link to="/models/opel">
                <div className="img-box">
                  <img src="images/opel-logo.png" alt="" />
                </div>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
