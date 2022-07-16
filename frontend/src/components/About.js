export const About = () => {
  return (
    <section className="about_section layout_padding">
      <div className="container">
        <div className="row">
          <div className="col-md-6 col-lg-5">
            <div className="img-box">
              <img src="images/mechanic.png" alt="" />
            </div>
          </div>
          <div className="col-md-6 col-lg-7">
            <div className="detail-box">
              <div className="heading_container">
                <h2>About Us</h2>
              </div>
              <p>
                There are many variations of passages of Lorem Ipsum available,
                but the majority have suffered alteration in some form, by
                injected humour, or randomised words which don't look even
                slightly believable. If you are going to use a passage of Lorem
                Ipsum, you need to be sure there isn't anything embarrassing
                hidden in the middle of text. All
              </p>
              <a href="/"> Read More </a>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
