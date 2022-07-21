import * as React from "react";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";

export const UserEdit = ({ onClose, user }) => {
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
            component="form"
            sx={{
              "& .MuiTextField-root": { m: 1, width: "100%" },
            }}
            noValidate
            autoComplete="off"
          >
            <div className="image-container">
              <img
                src="/images/audi-car.png"
                alt="user-profil-img"
                className="image"
              />
            </div>

            <TextField
              id="outlined-required"
              label="Username"
              defaultValue={user.data.username}
            />

            <TextField
              id="outlined-required"
              label="First Name"
              defaultValue={user.data.firstName}
            />
            <TextField
              id="outlined-required"
              label="Last Name"
              defaultValue={user.data.lastName}
            />
            <TextField
              id="outlined-required"
              label="Email"
              defaultValue={user.data.email}
            />
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={onClose} autoFocus>
            Save
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};
