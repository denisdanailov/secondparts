import { useState, useEffect } from "react";
import Dialog from "@mui/material/Dialog";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import Box from "@mui/material/Box";
import OrderService from "../../services/order.service";
import ModelService from "../../services/models.service";

export const OrderEdit = ({ onClose, order, onChange }) => {
  console.log(order);
  const [transmissions, setTransmissions] = useState([]);
  const [categories, setCategories] = useState([]);
  const [engines, setEngines] = useState([]);
  const [vwModels, setVwModels] = useState([]);
  const [audiModels, setAudiModels] = useState([]);
  const [mercedesModels, setMercedesModels] = useState([]);
  const [bmwModels, setBmwModels] = useState([]);
  const [opelModels, setOpelModels] = useState([]);
  const [porscheModels, setPorscheModels] = useState([]);

  useEffect(() => {
    OrderService.getTransmissions().then((transmissions) =>
      setTransmissions(transmissions.data)
    );

    OrderService.getCategories().then((category) =>
      setCategories(category.data)
    );

    OrderService.getEngines().then((engine) => setEngines(engine.data));

    ModelService.getModelsFromBrandVw().then((model) =>
      setVwModels(model.data)
    );

    ModelService.getModelsFromBrandAudi().then((model) =>
      setAudiModels(model.data)
    );

    ModelService.getModelsFromBrandBmw().then((model) =>
      setBmwModels(model.data)
    );

    ModelService.getModelsFromBrandMercedesBenz().then((model) =>
      setMercedesModels(model.data)
    );

    ModelService.getModelsFromBrandOpel().then((model) =>
      setOpelModels(model.data)
    );

    ModelService.getModelsFromBrandPorsche().then((model) =>
      setPorscheModels(model.data)
    );
  }, []);

  const onEdit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const {
      title,
      price,
      imageUrl,
      kilometers,
      year,
      description,
      vehicleIdentificationNumber,
    } = Object.fromEntries(formData);

    const category = e.target[2].value;
    const model = e.target[3].value;
    const engine = e.target[4].value;
    const transmission = e.target[5].value;

    const orderData = {
      title,
      price,
      imageUrl,
      kilometers,
      year,
      vehicleIdentificationNumber,
      description,
      model,
      transmission,
      engine,
      category,
    };

    console.log(orderData);
    OrderService.editOrder(order.data.id, orderData)
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
                src={order.data.imageUrl}
                alt="user-profil-img"
                className="image"
              />
            </div>
            <h3 className="register-heading">Create your Offer</h3>
            <form onSubmit={onEdit} method="post">
              <div className="row register-form">
                <div className="col-md-6">
                  <div className="form-group-1">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Product Title *"
                      name="title"
                      defaultValue={order.data.title}
                    />
                  </div>
                  <div className="form-group-1">
                    <input
                      type="number"
                      className="form-control"
                      placeholder="Suggested price *"
                      name="price"
                      defaultValue={order.data.price}
                    />
                  </div>
                  <div className="form-group-1">
                    <select
                      className="form-control"
                      defaultValue={order.data.category}
                    >
                      {categories.map((category) => (
                        <option key={category} name={category} id={category}>
                          {category}
                        </option>
                      ))}
                    </select>
                  </div>
                  <div className="form-group-1">
                    <select className="form-control">
                      <option className="hidden">Please select Model *</option>
                      <optgroup label="Audi">
                        {audiModels.map((model) => (
                          <option
                            key={model.id}
                            value={model.name}
                            name={model.name}
                            id={model.id}
                          >
                            {model.name}
                          </option>
                        ))}
                      </optgroup>
                      <optgroup label="Bmw">
                        {bmwModels.map((model) => (
                          <option
                            key={model.id}
                            value={model.name}
                            name={model.name}
                            id={model.id}
                          >
                            {model.name}
                          </option>
                        ))}
                      </optgroup>
                      <optgroup label="Mercedes-Benz">
                        {mercedesModels.map((model) => (
                          <option
                            key={model.id}
                            value={model.name}
                            name={model.name}
                            id={model.id}
                          >
                            {model.name}
                          </option>
                        ))}
                      </optgroup>
                      <optgroup label="Porsche">
                        {porscheModels.map((model) => (
                          <option
                            key={model.id}
                            value={model.name}
                            name={model.name}
                            id={model.id}
                          >
                            {model.name}
                          </option>
                        ))}
                      </optgroup>
                      <optgroup label="Opel">
                        {opelModels.map((model) => (
                          <option
                            key={model.id}
                            value={model.name}
                            name={model.name}
                            id={model.id}
                          >
                            {model.name}
                          </option>
                        ))}
                      </optgroup>
                      <optgroup label="Vw">
                        {vwModels.map((model) => (
                          <option
                            key={model.id}
                            value={model.name}
                            name={model.name}
                            id={model.id}
                          >
                            {model.name}
                          </option>
                        ))}
                      </optgroup>
                    </select>
                  </div>
                  <div className="form-group-1">
                    <select className="form-control">
                      <option className="hidden" defaultValue>
                        Please select Engine type
                      </option>
                      {engines.map((engine) => (
                        <option key={engine} value={engine}>
                          {engine}
                        </option>
                      ))}
                    </select>
                  </div>
                </div>
                <div className="col-md-6">
                  <div className="form-group-1">
                    <select className="form-control">
                      <option className="hidden" defaultValue>
                        Please select Transmission
                      </option>
                      {transmissions.map((transmissions) => (
                        <option key={transmissions} value={transmissions}>
                          {transmissions}
                        </option>
                      ))}
                    </select>
                  </div>
                  <div className="form-group-1">
                    <input
                      type="text"
                      name="vehicleIdentificationNumber"
                      className="form-control"
                      placeholder="Vehicle Identification Number *"
                    />
                  </div>
                  <div className="form-group-1">
                    <input
                      type="text"
                      name="year"
                      className="form-control"
                      placeholder="Year *"
                    />
                  </div>
                  <div className="form-group-1">
                    <input
                      type="text"
                      name="imageUrl"
                      className="form-control"
                      placeholder="Image Url"
                    />
                  </div>
                  <div className="form-group-1">
                    <input
                      type="text"
                      name="kilometers"
                      className="form-control"
                      placeholder="Kilometers"
                    />
                  </div>
                  <div className="form-group-1">
                    <textarea
                      type="text"
                      className="form-control"
                      placeholder="Description"
                      name="description"
                    />
                  </div>
                  <input type="submit" className="btnRegister" />
                </div>
              </div>
            </form>
          </Box>
        </DialogContent>
      </Dialog>
    </div>
  );
};
