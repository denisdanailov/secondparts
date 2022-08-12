import { Link, useNavigate } from "react-router-dom";
import { useContext } from "react";
import { ShoppingCartContext } from "../../contexts/ShoppingCartContext";

import AuthService from "../../services/auth.service";

export const Header = () => {
  const navigate = useNavigate();
  const { offers } = useContext(ShoppingCartContext);

  const currentUser = AuthService.getCurrentUser();

  return (
    <header className="header_section">
      <div className="container-fluid">
        <nav className="navbar navbar-expand-lg custom_nav-container">
          <Link className="navbar-brand" to="/">
            Sec
            <img
              class="header-logo"
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1660316070/Logo-SecondParts_arwqo3.png"
              alt="logo"
            />
            ndParts
          </Link>

          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className=""> </span>
          </button>

          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <Link className="nav-link" to="/">
                  Home
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/about">
                  About
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/contact">
                  Contact
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/catalog">
                  Catalog
                </Link>
              </li>
              {currentUser && (
                <li className="nav-item">
                  <Link className="nav-link" to="/create">
                    Create- Offer
                  </Link>
                </li>
              )}
            </ul>
            <div className="user_option-box">
              {!currentUser ? (
                <>
                  <Link to="/login">
                    <i className="fa fa-user" aria-hidden="true"></i>
                  </Link>
                  <Link to="/search">
                    <i className="fa fa-search" aria-hidden="true"></i>
                  </Link>
                </>
              ) : (
                <>
                  <div>Hello, {currentUser.username} </div>
                  {currentUser.roles.includes("ROLE_ADMIN") && (
                    <Link to="/admin">
                      <i className="fa fa-users" aria-hidden="true"></i>
                    </Link>
                  )}
                  <Link to="/checkout">
                    <i className="fa fa-cart-plus" aria-hidden="true"></i>
                    {offers.length > 0 ? (
                      <span
                        class="badge-checkout badge-warning"
                        id="lblCartCount"
                      ></span>
                    ) : (
                      ""
                    )}
                  </Link>
                  <Link to="/search">
                    <i className="fa fa-search" aria-hidden="true"></i>
                  </Link>
                  <Link to="/logout">
                    <i className="fa fa-sign-out" aria-hidden="true"></i>
                  </Link>
                </>
              )}
            </div>
          </div>
        </nav>
      </div>
    </header>
  );
};
