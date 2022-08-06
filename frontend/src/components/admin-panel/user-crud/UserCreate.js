import { useState } from "react";

import Dialog from "@mui/material/Dialog";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import Box from "@mui/material/Box";
import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

import UserService from "../../../services/admin.service";

export const UserCreate = ({ onClose, onChange }) => {
  const [error, setError] = useState("");

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

  const onCreate = (event) => {
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

    const userData = {
      firstName,
      lastName,
      email,
      username,
      password,
      imageUrl,
    };

    try {
      UserService.createUser(userData)
        .then(() => onChange())
        .then(() => onClose())
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
  };

  return (
    <div>
      <Dialog
        open={true}
        onClose={onClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
        fullWidth
      >
        <DialogTitle textAlign="center" id="alert-dialog-title">
          {"Create User"}
        </DialogTitle>
        <DialogContent>
          <Box
            sx={{
              "& .MuiTextField-root": { m: 1, width: "100%" },
            }}
            noValidate
            autoComplete="off"
          >
            {error ? error : null}
            <form onSubmit={onCreate} method="post">
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
                <input
                  type="submit"
                  value="Create user"
                  className="btn-login"
                />
              </div>
            </form>
          </Box>
        </DialogContent>
      </Dialog>
    </div>
  );
};
