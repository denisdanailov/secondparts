export const About = () => {
  return (
    <section className="about_section layout_padding">
      <div className="container">
        <div className="row">
          <div className="col-md-6 col-lg-5">
            <div className="img-box">
              <img src="images/about-img.png" alt="" />
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
              </p>
              <a href="/"> Read More </a>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
