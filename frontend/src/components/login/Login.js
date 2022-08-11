import "./Login.css";
import { useState, useContext } from "react";
import { useNavigate, Link } from "react-router-dom";

import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

import AuthService from "../../services/auth.service";

export const Login = () => {
  const [error, setError] = useState("");
  const navigate = useNavigate();

  async function handleSubmit(event) {
    event.preventDefault();

    const formData = new FormData(event.currentTarget);
    const username = formData.get("username");
    const password = formData.get("password");

    try {
      if (username.length === 0 || password.length === 0) {
        setError(
          <Stack sx={{ width: "100%" }} spacing={2}>
            <Alert severity="error">
              Failed to Sign in. Username or password is incorrect
            </Alert>
          </Stack>
        );
      } else {
        setError("");
        await AuthService.login(username, password);

        navigate("/");
      }
    } catch {
      setError(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="error">
            Failed to Sign in. Username or password is incorrect
          </Alert>
        </Stack>
      );
    }
  }

  return (
    <section className="login_section">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="detail-box-reg">
              <div className="heading_container-login">
                <div className="img-wrapper-reg">
                  <img
                    className="reg-icon"
                    src="images/mechanic_2.png"
                    alt="sign-icon"
                  />
                </div>
              </div>
              {error ? error : null}
              <form method="post" onSubmit={handleSubmit}>
                <div className="form-wrapper-login">
                  <div className="col-md-12">
                    <div className="form-group-1">
                      <input
                        type="text"
                        className="form-control"
                        placeholder="* Username"
                        name="username"
                        required
                      />
                    </div>

                    <div className="form-group-1">
                      <input
                        type="password"
                        name="password"
                        className="form-control"
                        placeholder="* Password"
                        required
                      />
                    </div>

                    <div className="reg-btn-wrapper">
                      <input
                        type="submit"
                        value="Sign in"
                        className="btn-login"
                      />
                    </div>
                    <div className="reg-verlink">
                      <Link to="/register">Don't have an account? Sign Up</Link>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div className="col-md-6">
            <div className="img-box">
              <img
                className="login-img-r"
                src="https://res.cloudinary.com/diozchjq4/image/upload/v1659902793/cars/mercedes-car-1_ixzkql.png"
                alt="login-img"
              />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
