import * as React from "react";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import userService from "../../../services/user.service";

export const UserEdit = ({ onClose, user, onChange }) => {
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

    console.log(userData);
    userService
      .editUser(user.data.id, userData)
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
            <div className="image-container">
              <img
                src={user.data.imageUrl}
                alt="user-profil-img"
                className="image"
              />
            </div>
            <form onSubmit={onEdit} method="post">
              <TextField
                id="outlined-required"
                label="Username"
                type="text"
                name="username"
                defaultValue={user.data.username}
              />

              <TextField
                id="outlined-required"
                label="First Name"
                type="text"
                name="firstName"
                defaultValue={user.data.firstName}
              />
              <TextField
                id="outlined-required"
                label="Last Name"
                type="text"
                name="lastName"
                defaultValue={user.data.lastName}
              />
              <TextField
                id="outlined-required"
                label="Email"
                type="text"
                name="email"
                defaultValue={user.data.email}
              />
              <TextField
                id="outlined-required"
                label="Profile Picture"
                type="text"
                name="imageUrl"
                defaultValue={user.data.imageUrl}
              />
              <Button type="submit" autoFocus>
                Save
              </Button>
            </form>
          </Box>
        </DialogContent>
      </Dialog>
    </div>
  );
};
