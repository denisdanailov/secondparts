import { HeroSocial } from "../hero/HeroSocial";
export const Slider = () => {
  return (
    <div className="hero_area">
      <HeroSocial />
      <section className="slider_section">
        <div
          id="customCarousel1"
          className="carousel slide"
          data-ride="carousel"
        >
          <div className="carousel-inner">
            <div className="carousel-item active">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md-6">
                    <div className="detail-box">
                      <h1>Mercedes-Benz</h1>
                      <p>
                        The Mercedes-Benz Group AG (former Daimler AG) is one of
                        the world's most successful automotive companies. With
                        Mercedes-Benz AG, we are one of the leading global
                        suppliers of premium and luxury cars and vans
                      </p>
                      <div className="btn-box">
                        <a
                          href="https://www.mercedes-benz.de/"
                          className="btn1"
                        >
                          Official page
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="img-box">
                      <img
                        src="https://res.cloudinary.com/diozchjq4/image/upload/v1659559890/Header-img/mercedes-car-5_zt1dgl.png"
                        alt="image-hero"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="carousel-item">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md-6">
                    <div className="detail-box">
                      <h1>Audi</h1>
                      <p>
                        Audi stands for sporty vehicles, premium workmanship and
                        progressive design – for “Vorsprung durch Technik”.
                        Founded in 1899 by August Horch, the Audi Group – which
                        also unites the Bentley, Ducati and Lamborghini brands
                        under one roof.
                      </p>
                      <div className="btn-box">
                        <a href="https://www.audi.de/" className="btn1">
                          Official page
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="img-box">
                      <img
                        src="https://res.cloudinary.com/diozchjq4/image/upload/v1659559854/Header-img/audi-car_tjoqep.png"
                        alt="image-hero"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="carousel-item">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md-6">
                    <div className="detail-box">
                      <h1>Prosche</h1>
                      <p>
                        Porsche Engineering ─ the engineering services provider
                        for future-oriented mobility. The company therefore
                        approaches the technical challenges from a wide range of
                        projects in an accordingly holistic and innovative
                        spirit.
                      </p>
                      <div className="btn-box">
                        <a
                          href="https://www.porscheengineering.com/"
                          className="btn1"
                        >
                          Official page
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="img-box">
                      <img
                        src="https://res.cloudinary.com/diozchjq4/image/upload/v1659559911/Header-img/porshe-12_lj7wgo.png"
                        alt="image-hero"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <ol className="carousel-indicators">
            <li
              data-target="#customCarousel1"
              data-slide-to="0"
              className="active"
            ></li>
            <li data-target="#customCarousel1" data-slide-to="1"></li>
            <li data-target="#customCarousel1" data-slide-to="2"></li>
          </ol>
        </div>
      </section>
    </div>
  );
};
