import { Link } from "react-router-dom";

export const MoreProductView = ({ offer }) => {
  return (
    <div class="container">
      <Link to="/catalog">
        <div class="card shadow-sm border-0 rounded">
          <div class="card-body p-0">
            <img src={offer.imageUrl} alt="" class="w-100 card-img-top" />
            <div class="p-4">
              <h5 class="mb-0">{offer.title}</h5>
              <p class="small text-muted">Price {offer.price} $</p>
            </div>
          </div>
        </div>
      </Link>
    </div>
  );
};
