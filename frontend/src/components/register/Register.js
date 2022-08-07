import "./Register.css";

import { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

import AuthService from "../../services/auth.service";

export const Register = () => {
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleBlurUsername = (event) => {
    if (event.target.value.length < 6) {
      return setError(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="error">Username musst containt 6 charachters</Alert>
        </Stack>
      );
    } else {
      setError("");
    }
  };

  const handleBlurPassword = (event) => {
    if (event.target.value.length < 6) {
      return setError(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="error">Password musst containt 6 charachters</Alert>
        </Stack>
      );
    } else {
      setError("");
    }
  };

  async function handleSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);

    const firstName = formData.get("firstName");
    const lastName = formData.get("lastName");
    const username = formData.get("username");
    const email = formData.get("email");
    const password = formData.get("password");
    const rePass = formData.get("rePass");
    const imageUrl = formData.get("imageUrl");

    if (password !== rePass) {
      return setError(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="error">Passwords don't match</Alert>
        </Stack>
      );
    }

    try {
      setError("");
      AuthService.register(
        firstName,
        lastName,
        username,
        email,
        password,
        imageUrl
      )
        .then(() => {
          navigate("/login");
        })
        .catch(function (error) {
          if (error.response) {
            // The request was made and the server responded with a status code
            // that falls out of the range of 2xx
            setError(
              <Stack sx={{ width: "100%" }} spacing={2}>
                <Alert severity="error">{error.response.data.message}</Alert>
              </Stack>
            );
          } else {
            // Something happened in setting up the request that triggered an Error
            console.log("Error", error.message);
          }
          console.log(error.config);
        });
    } catch (error) {
      console.log(error);
      setError(
        <Stack sx={{ width: "100%" }} spacing={2}>
          <Alert severity="error">Failed to Sign in</Alert>
        </Stack>
      );
    }
  }

  return (
    <section className="register_section">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="detail-box-reg">
              <div className="heading_container-reg">
                <div className="img-wrapper-reg">
                  <img
                    className="reg-icon"
                    src="images/mechanic_2.png"
                    alt="signup-icon"
                  />
                </div>
              </div>
              {error ? error : null}
              <form onSubmit={handleSubmit} method="post">
                <div className="reg-form">
                  <div className="col-md-12">
                    <div className="form-group-1">
                      <input
                        type="text"
                        className="form-control"
                        placeholder="First Name"
                        name="firstName"
                      />
                    </div>

                    <div className="form-group-1">
                      <input
                        type="text"
                        className="form-control"
                        placeholder="* Username"
                        min="6"
                        max="30"
                        name="username"
                        required
                        onBlur={handleBlurUsername}
                      />
                    </div>

                    <div className="form-group-1">
                      <input
                        type="password"
                        name="password"
                        className="form-control"
                        placeholder="* Password"
                        required
                        onBlur={handleBlurPassword}
                      />
                    </div>
                  </div>

                  <div className="col-md-12">
                    <div className="form-group-1">
                      <input
                        type="text"
                        name="lastName"
                        className="form-control"
                        placeholder=" Last Name"
                      />
                    </div>

                    <div className="form-group-1">
                      <input
                        type="text"
                        name="email"
                        className="form-control"
                        placeholder="* Email"
                        pattern="[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}"
                        size="30"
                        required
                      />
                    </div>

                    <div className="form-group-1">
                      <input
                        type="password"
                        name="rePass"
                        className="form-control"
                        placeholder="* Confirm Password"
                        required
                      />
                    </div>
                  </div>
                </div>
                <div className="grid-reg">
                  <div className="form-group-1">
                    <input
                      type="text"
                      name="imageUrl"
                      className="form-control"
                      placeholder="Image Url "
                    />
                  </div>
                </div>
                <div className="reg-btn-wrapper-2">
                  <input type="submit" value="Sign up" className="btn-login" />
                  <div className="reg-verlink-2">
                    <Link to="/login">Already have an account? Sign in</Link>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div className="col-md-6">
            <div className="img-box">
              <img
                className="register-img-r"
                src="https://res.cloudinary.com/diozchjq4/image/upload/v1659902793/cars/mercedes-car-1_ixzkql.png"
                alt="reg-img"
              />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
