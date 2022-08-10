import { useState } from "react";

import Dialog from "@mui/material/Dialog";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import Box from "@mui/material/Box";
import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

import userService from "../../../services/admin.service";

export const UserEdit = ({ onClose, user, onChange }) => {
  const [error, setError] = useState("");

  const BLANK_PROFIL_URL =
    "https://res.cloudinary.com/diozchjq4/image/upload/v1659788286/secondparts-blankimges/blank-profil_jtwg3q.webp";

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

  const onEdit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const { firstName, lastName, email, username, imageUrl } =
      Object.fromEntries(formData);

    const userData = {
      firstName,
      lastName,
      email,
      username,
      imageUrl,
    };

    if (username.length < 5) {
      return setError(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="error">Username musst containt 6 charachters</Alert>
        </Stack>
      );
    }

    try {
      userService
        .editUser(user.data.id, userData)
        .then(() => onChange())
        .then(() => onClose())
        .catch(function (error) {
          if (error.response) {
            // The request was made and the server responded with a status code
            // that falls out of the range of 2xx
            console.log(error.response.data);
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
          {"Edit User Information"}
        </DialogTitle>
        <DialogContent>
          <Box
            sx={{
              "& .MuiTextField-root": { m: 1, width: "100%" },
            }}
            noValidate
            autoComplete="off"
          >
            <div className="image-container">
              <img
                src={user.data.imageUrl || BLANK_PROFIL_URL}
                alt="user-profil-img"
                className="image"
              />
            </div>
            {error ? error : null}
            <form onSubmit={onEdit} method="post">
              <div className="form-group-1">
                <input
                  type="text"
                  className="form-control"
                  placeholder="* Username"
                  min="6"
                  max="30"
                  name="username"
                  required
                  defaultValue={user.data.username}
                  onBlur={handleBlurUsername}
                />
              </div>

              <div className="form-group-1">
                <input
                  type="text"
                  className="form-control"
                  name="firstName"
                  placeholder="Last Name"
                  defaultValue={user.data.firstName}
                />
              </div>

              <div className="form-group-1">
                <input
                  type="text"
                  name="lastName"
                  className="form-control"
                  placeholder="First Name"
                  defaultValue={user.data.lastName}
                />
              </div>

              <div className="form-group-1">
                <input
                  type="text"
                  name="email"
                  placeholder="* Email"
                  className="form-control"
                  defaultValue={user.data.email}
                  pattern="[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}"
                  size="30"
                  required
                />
              </div>

              <div className="form-group-1">
                <input
                  type="text"
                  name="imageUrl"
                  className="form-control"
                  defaultValue={user.data.imageUrl}
                />
              </div>

              <input type="submit" value="Edit user" className="btn-login" />
            </form>
          </Box>
        </DialogContent>
      </Dialog>
    </div>
  );
};
