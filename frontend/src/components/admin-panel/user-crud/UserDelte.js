import * as React from "react";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import userService from "../../../services/admin.service";

export const UserDelete = ({ user, onClose, deleteHandler }) => {
  const onDelete = () => {
    userService.deleteUser(user.data.id);
  };

  return (
    <div>
      <Button variant="outlined">Open alert dialog</Button>
      <Dialog
        open={true}
        onClose={onClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">
          {"Are you sure you want to delete  account?"}
        </DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            Username: {user.data.username}
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <input
            type="submit"
            value="Close"
            className="btn-login"
            onClick={onClose}
          />
          <input
            type="submit"
            value="Delete"
            className="btn-login-delete"
            onClick={() => {
              onDelete();
              deleteHandler(user.data.id);
              onClose();
            }}
          />
        </DialogActions>
      </Dialog>
    </div>
  );
};
