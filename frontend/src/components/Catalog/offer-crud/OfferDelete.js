import * as React from "react";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import OfferService from "../../../services/offer.service";

export const OfferDelete = ({ offer, onClose, deleteHandler }) => {
  const onDelete = () => {
    OfferService.deleteOffer(offer.data.id).then(() => onClose());
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
          {"Are you sure you want to delete Offer?"}
        </DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            Offer: {offer.data.title}
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
              deleteHandler(offer.data.id);
            }}
          />
        </DialogActions>
      </Dialog>
    </div>
  );
};
