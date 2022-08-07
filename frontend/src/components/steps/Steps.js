import "./Steps.css";

export const Steps = () => {
  return (
    <section class="testimonial text-center">
      <div class="container">
        <div class="row text-center justify-content-center">
          <div class="col-md-8 col-lg-4 mt-4 mt-lg-0">
            <div className="img-steps">
              <img src="https://res.cloudinary.com/diozchjq4/image/upload/v1659899184/steps/payment_u45dgh.png"></img>
              <h4>1. Payment</h4>
            </div>
          </div>

          <div class="col-md-8 col-lg-4 mt-4 mt-lg-0">
            <div className="img-steps">
              <img src="https://res.cloudinary.com/diozchjq4/image/upload/v1659899184/steps/delivery_yehv8h.png"></img>
              <h4>2. Shipping and delivery</h4>
            </div>
          </div>

          <div class="col-md-8 col-lg-4 mt-4 mt-lg-0">
            <div className="img-steps">
              <img src="https://res.cloudinary.com/diozchjq4/image/upload/v1659899184/steps/unboxing_ycilzh.png"></img>
              <h4>3. Unboxing and Happy Clients</h4>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
