import { Link } from "react-router-dom";

export const Brands = () => {
  return (
    <section className="shop_section layout_padding">
      <div className="container mt-100">
        <div className="heading_container heading_center">
          <h2>Brands with we work</h2>
          <p>
            We work currently only with the most well-known German brands on the
            car market. In the future we will partner with other brands around
            the world.
          </p>
        </div>
        <div className="row">
          <div className="col-sm-6 col-xl-4">
            <div className="box">
              <Link to="/models/mercedes-benz">
                <div className="img-box">
                  <img
                    src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564730/brands-seconsparts/mercedes-benz-logo1_rlj5rx.png"
                    alt=""
                  />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-4">
            <div className="box">
              <Link to="/models/audi">
                <div className="img-box">
                  <img
                    src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564731/brands-seconsparts/audi-logo_x2bube.png"
                    alt=""
                  />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-4">
            <div className="box">
              <Link to="/models/bmw">
                <div className="img-box">
                  <img
                    src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564729/brands-seconsparts/bmw-logo1_tbwwrg.png"
                    alt=""
                  />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-4">
            <div className="box">
              <Link to="/models/vw">
                <div className="img-box">
                  <img
                    src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564730/brands-seconsparts/vw-logo1_hurg1g.png"
                    alt=""
                  />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-4">
            <div className="box">
              <Link to="/models/porsche">
                <div className="img-box">
                  <img
                    src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564729/brands-seconsparts/porshe-logo_ujcf8w.png"
                    alt=""
                  />
                </div>
              </Link>
            </div>
          </div>
          <div className="col-sm-6 col-xl-4">
            <div className="box">
              <Link to="/models/opel">
                <div className="img-box">
                  <img
                    src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564729/brands-seconsparts/opel-logo1_tu3qnz.png"
                    alt=""
                  />
                </div>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
