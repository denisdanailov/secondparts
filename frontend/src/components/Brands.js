import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import OfferService from "../services/offer.service";

export const Brands = () => {
  const [offersCount, setOffersCount] = useState([]);

  useEffect(() => {
    OfferService.getOffersCount().then((offersCount) =>
      setOffersCount(offersCount.data)
    );
  }, []);

  return (
    <section className="shop_section layout_padding">
      <div className="container">
        <div className="heading_container heading_center">
          <h2>Brands with we work</h2>
        </div>
        <div className="row">
          <div className="col-md-6">
            <div className="box">
              <Link to="/catalog">
                <div className="img-box">
                  <img src="images/mechanic_2.png" alt="" />
                </div>
                <div className="detail-box">
                  <h6>Available parts:</h6>
                  <h6>
                    {offersCount}
                    <span> Parts </span>
                  </h6>
                </div>
                <div className="new">
                  <span> All offers </span>
                </div>
              </Link>
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
