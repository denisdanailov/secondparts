import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import Stack from "@mui/material/Stack";
import Alert from "@mui/material/Alert";
import { Link } from "react-router-dom";

import OfferService from "../../../../services/offer.service";
import ModelService from "../../../../services/models.service";
import "./CreateOffer.css";

import AuthService from "../../../../services/auth.service";

export const CreateOffer = () => {
  const [transmissions, setTransmissions] = useState([]);
  const [categories, setCategories] = useState([]);
  const [engines, setEngines] = useState([]);
  const [vwModels, setVwModels] = useState([]);
  const [audiModels, setAudiModels] = useState([]);
  const [mercedesModels, setMercedesModels] = useState([]);
  const [bmwModels, setBmwModels] = useState([]);
  const [opelModels, setOpelModels] = useState([]);
  const [porscheModels, setPorscheModels] = useState([]);

  const [error, setError] = useState("");

  useEffect(() => {
    OfferService.getTransmissions().then((transmissions) =>
      setTransmissions(transmissions.data)
    );

    OfferService.getCategories().then((category) =>
      setCategories(category.data)
    );

    OfferService.getEngines().then((engine) => setEngines(engine.data));

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

  const navigate = useNavigate();

  const onCreate = (e) => {
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
    const sellerId = AuthService.getCurrentUser().id;

    const offerData = {
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
      sellerId,
    };

    try {
      if (
        Object.values(offerData)[10].charAt(0) === "*" ||
        Object.values(offerData)[9].charAt(0) === "*" ||
        Object.values(offerData)[8].charAt(0) === "*" ||
        Object.values(offerData)[7].charAt(0) === "*"
      ) {
        setError(
          <Stack
            sx={{
              width: "80%",
              paddingTop: "10px",
              m: "0 auto",
            }}
            spacing={2}
          >
            <Alert severity="error">
              All fields marked with an * are required!
            </Alert>
          </Stack>
        );
      } else {
        OfferService.createOffer(offerData).then(() => {
          navigate("/catalog");
        });
      }
    } catch {
      setError(
        <Stack
          sx={{
            width: "80%",
            paddingTop: "10px",
            m: "0 auto",
          }}
          spacing={2}
        >
          <Alert severity="error">Field to Create Offer!</Alert>
        </Stack>
      );
    }
  };

  return (
    <div className="register">
      <div className="row">
        <div className="col-md-3 register-left">
          <h3 className="title-create">How to sell?</h3>
          <p className="create-steps">
            1.Create your Offer
            <br />
            2.Contact with Buyer <br />
            3.Payment <br />
            4.Shipping and delivery
          </p>
          <Link to="/catalog">
            <input
              className="catalog-btn"
              type="submit"
              name=""
              value="Catalog"
            />
          </Link>
          <br />
        </div>
        <div className="col-md-9 register-right">
          <div className="tab-content" id="myTabContent">
            <div
              className="tab-pane fade show active"
              id="home"
              role="tabpanel"
              aria-labelledby="home-tab"
            >
              <h3 className="register-heading">
                Create your Offer
                {error ? error : ""}
              </h3>

              <form onSubmit={onCreate} method="post">
                <div className="row register-form">
                  <div className="col-md-6">
                    <div className="form-group-1">
                      <input
                        type="text"
                        className="form-control"
                        placeholder="* Product Title"
                        name="title"
                        required
                      />
                    </div>
                    <div className="form-group-1">
                      <input
                        type="number"
                        className="form-control"
                        placeholder="* Suggested price"
                        name="price"
                        min="1"
                        required
                      />
                    </div>
                    <div className="form-group-1">
                      <select className="form-control">
                        <option defaultValue>* Please select Category</option>
                        {categories.map((category) => (
                          <option
                            key={category.name}
                            value={category.name}
                            name={category.name}
                            id={category.name}
                            required
                          >
                            {category.name}
                          </option>
                        ))}
                      </select>
                    </div>
                    <div className="form-group-1">
                      <select className="form-control">
                        <option defaultValue>* Please select Model</option>
                        <optgroup label="Audi">
                          {audiModels.map((model) => (
                            <option
                              key={model.id}
                              value={model.name}
                              name={model.name}
                              id={model.id}
                              required
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
                        <option defaultValue>
                          * Please select Engine type
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
                          * Please select Transmission
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
                        placeholder="* Vehicle Identification Number"
                        required
                      />
                    </div>
                    <div className="form-group-1">
                      <input
                        type="number"
                        name="year"
                        min="1788"
                        className="form-control"
                        placeholder="* Year"
                        required
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
                        type="number"
                        min="1"
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
                    <input
                      type="submit"
                      value="Create offer"
                      className="btnRegister"
                    />
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
