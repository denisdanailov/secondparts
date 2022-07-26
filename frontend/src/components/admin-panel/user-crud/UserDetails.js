import * as React from "react";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import Divider from "@mui/material/Divider";
import List from "@mui/material/List";
import { Typography } from "@mui/material";

export const UserDetails = ({ onClose, user }) => {
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
          {"User Information"}
        </DialogTitle>
        <DialogContent>
          <List>
            <div className="image-container">
              <img
                src={user.data.imageUrl}
                alt="user-profil-img"
                className="image"
              />
            </div>

            <DialogTitle textAlign="center" id="alert-dialog-title">
              {"Username"}
              <Typography>{user.data.username}</Typography>
            </DialogTitle>
            <Divider />
            <DialogTitle textAlign="center" id="alert-dialog-title">
              {"First Name"}
              <Typography>{user.data.firstName}</Typography>
            </DialogTitle>
            <Divider />
            <DialogTitle textAlign="center" id="alert-dialog-title">
              {"Last Name"}
              <Typography>{user.data.lastName}</Typography>
            </DialogTitle>
            <Divider />
            <DialogTitle textAlign="center" id="alert-dialog-title">
              {"Email"}
              <Typography>{user.data.email}</Typography>
            </DialogTitle>
            <Divider />
          </List>
        </DialogContent>
        <DialogActions>
          <Button onClick={onClose} autoFocus>
            Close
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};
