import { useState } from "react";
import AuthService from "../../services/auth.service";

export const CurrentUserNavigation = () => {
  const [error, setError] = useState("");

  async function handleLogout() {
    setError("");

    try {
      AuthService.logout();
    } catch {
      setError("Failed to log out");
    }
  }

  return (
    <header className="header_section">
      <div className="container-fluid">
        <nav className="navbar navbar-expand-lg custom_nav-container">
          <a className="navbar-brand" href="/">
            <span> SecondParts </span>
          </a>

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
                <a className="nav-link" href="/">
                  Home <span className="sr-only">(current)</span>
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/catalog">
                  Catalog
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/about">
                  About
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/contact">
                  Contact
                </a>
              </li>
            </ul>
            <div className="user_option-box">
              <div>Hello, User </div>
              <a href="/">
                <i className="fa fa-cart-plus" aria-hidden="true"></i>
              </a>
              <a href="/">
                <i className="fa fa-search" aria-hidden="true"></i>
              </a>
              <a href="/logout" onClick={handleLogout}>
                <i className="fa fa-sign-out" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </nav>
      </div>
    </header>
  );
};
