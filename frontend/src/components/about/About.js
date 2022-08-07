export const About = () => {
  return (
    <section className="about_section layout_padding">
      <div className="container">
        <div className="row">
          <div className="col-md-6 col-lg-5">
            <div className="img-box">
              <img
                src="https://res.cloudinary.com/diozchjq4/image/upload/v1659902833/cars/about-img_owkrc7.png"
                alt=""
              />
            </div>
          </div>
          <div className="col-md-6 col-lg-7">
            <div className="detail-box">
              <div className="heading_container">
                <h2>About Us</h2>
              </div>
              <p>
                The idea of collecting used spare parts from different car
                chippers and selling them across borders started already in 2022
                as University Project. SecondParts wanted to make it cheap and
                convenient for the customer to find the right used spare parts
                in one and the same marketplace.
                <br />
                <br />
                At SecondParts, you can find over 1,500 different auto parts for
                the most popular car brands in Germany. We have the strongest
                network of suppliers in all of Europe, which gives us an
                extensive range of quality auto parts. We exclusively sell
                second-hand and refurbished replacement parts of the highest
                quality, meaning that you can buy second-hand replacement parts
                for your car from us with confidence. It is safe, and easy.
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
