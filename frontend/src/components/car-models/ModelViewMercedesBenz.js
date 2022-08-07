import { useEffect, useState } from "react";

import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewMercedesBenz = () => {
  const [models, setModels] = useState([]);

  useEffect(() => {
    ModelService.getModelsFromBrandMercedesBenz().then((models) =>
      setModels(models.data)
    );
  }, []);

  return (
    <div className="catalog-section">
      <div className="container mt-100">
        <div className="heading_container heading_center">
          <div className="img-box">
            <img
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564730/brands-seconsparts/mercedes-benz-logo1_rlj5rx.png"
              alt=""
            />
          </div>
          <p>
            The Mercedes-Benz Group AG (former Daimler AG) is one of the world's
            most successful automotive companies. With Mercedes-Benz AG, we are
            one of the leading global suppliers of premium and luxury cars and
            vans
          </p>
        </div>
        <div className="row">
          {models.map((models) => (
            <ModelItem key={models.id} models={models} />
          ))}
        </div>
      </div>
    </div>
  );
};
