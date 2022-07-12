import { useState } from "react";
import { useNavigate } from "react-router-dom";

import { CurrentUserNavigation } from "../components/navigation/CurrentUserNavigation";
import { GuestNavigation } from "../components/navigation/GuestNavigation";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import AuthService from "../services/auth.service";

export const Header = ({ username }) => {
  const [error, setError] = useState("");

  // const { logout } = useAuth();
  const navigate = useNavigate();

  async function handleLogout() {
    setError("");

    try {
      AuthService.logout();
      navigate("/");
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
              {!AuthService.getCurrentUser() ? (
                <>
                  <a href="/login">
                    <i className="fa fa-user" aria-hidden="true"></i>
                  </a>
                </>
              ) : (
                <>
                  <div>Hello, {AuthService.getCurrentUser().username} </div>
                  {AuthService.getCurrentUser().roles.includes(
                    "ROLE_ADMIN"
                  ) && (
                    <a href="/admin">
                      <i className="fa fa-users" aria-hidden="true"></i>
                    </a>
                  )}
                  <a href="/">
                    <i className="fa fa-cart-plus" aria-hidden="true"></i>
                  </a>
                  <a href="/">
                    <i className="fa fa-search" aria-hidden="true"></i>
                  </a>
                  <a href="/logout" onClick={handleLogout}>
                    <i className="fa fa-sign-out" aria-hidden="true"></i>
                  </a>
                </>
              )}
            </div>
          </div>
        </nav>
      </div>
    </header>
  );
};
