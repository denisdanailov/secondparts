import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import OfferService from "../../services/offer.service";
import ModelService from "../../services/models.service";
import "./CreateOffer.css";

import AuthService from "../../services/auth.service";

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

    OfferService.createOffer(offerData).then(() => {
      navigate("/catalog");
    });
  };

  return (
    <div className="register">
      <div className="row">
        <div className="col-md-3 register-left">
          <h3>Welcome</h3>
          <p>You are 30 seconds away from earning your own money!</p>
          <input type="submit" name="" value="Catalog" />
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
              <h3 className="register-heading">Create your Offer</h3>
              <form onSubmit={onCreate} method="post">
                <div className="row register-form">
                  <div className="col-md-6">
                    <div className="form-group-1">
                      <input
                        type="text"
                        className="form-control"
                        placeholder="Product Title *"
                        name="title"
                      />
                    </div>
                    <div className="form-group-1">
                      <input
                        type="number"
                        className="form-control"
                        placeholder="Suggested price *"
                        name="price"
                      />
                    </div>
                    <div className="form-group-1">
                      <select className="form-control">
                        <option defaultValue disabled>
                          Please select Category *
                        </option>
                        {categories.map((category) => (
                          <option
                            key={category}
                            value={category}
                            name={category}
                            id={category}
                          >
                            {category}
                          </option>
                        ))}
                      </select>
                    </div>
                    <div className="form-group-1">
                      <select className="form-control">
                        <option defaultValue disabled>
                          Please select Model *
                        </option>
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
                        <option defaultValue disabled>
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
                        <option
                          className="hidden"
                          selected
                          disabled
                          defaultValue
                        >
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
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
