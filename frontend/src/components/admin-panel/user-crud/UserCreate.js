import * as React from "react";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import DialogActions from "@mui/material/DialogActions";
import UserService from "../../../services/user.service";

export const UserCreate = ({ onClose, onChange }) => {
  const onCreate = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const { firstName, lastName, email, username, password, imageUrl } =
      Object.fromEntries(formData);
    const userData = {
      firstName,
      lastName,
      email,
      username,
      password,
      imageUrl,
    };
    console.log(userData);
    UserService.createUser(userData)
      .then(() => onChange())
      .then(() => onClose());
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
            <form onSubmit={onCreate} method="post">
              <TextField
                id="outlined-required"
                label="Username"
                type="text"
                name="username"
              />

              <TextField
                id="outlined-required"
                label="First Name"
                type="text"
                name="firstName"
              />
              <TextField
                id="outlined-required"
                label="Last Name"
                type="text"
                name="lastName"
              />
              <TextField
                id="outlined-required"
                label="Email"
                type="text"
                name="email"
              />
              <TextField
                id="outlined-required"
                label="Profile Picture"
                type="text"
                name="imageUrl"
              />
              <TextField
                id="outlined-required"
                label="Password"
                type="password"
                name="password"
              />
              <TextField
                id="outlined-required"
                label="Confirm Password"
                type="password"
                name="confirm-password"
              />
              <DialogActions>
                <Button onClick={onClose}>Disagree</Button>
                <Button type="submit" autoFocus>
                  Agree
                </Button>
              </DialogActions>
            </form>
          </Box>
        </DialogContent>
      </Dialog>
    </div>
  );
};
