export const CreateOffer = () => {
  return (
    <section className="contact_section">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="form_container">
              <div className="heading_container">
                <h2>Create Offer</h2>
              </div>
              <form action="">
                <div>
                  <input type="text" placeholder="Full Name " />
                </div>
                <div>
                  <input type="email" placeholder="Email" />
                </div>
                <div>
                  <input type="text" placeholder="Phone number" />
                </div>
                <div>
                  <input
                    type="text"
                    className="message-box"
                    placeholder="Message"
                  />
                </div>
                <div className="d-flex">
                  <button>Create</button>
                </div>
              </form>
            </div>
          </div>
          <div className="col-md-6">
            <div className="img-box">
              <img src="images/porsche-13.png" alt="image-create" />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
