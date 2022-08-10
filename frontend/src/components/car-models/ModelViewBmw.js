import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewBmw = () => {
  const [models, setModels] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    ModelService.getModelsFromBrandBmw().then((models) =>
      setModels(models.data)
    );
    setIsLoading(false);
  }, []);

  return (
    <div className="catalog-section">
      <div className="container mt-100">
        <div className="heading_container heading_center">
          <div className="img-box">
            <img
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564729/brands-seconsparts/bmw-logo1_tbwwrg.png"
              alt=""
            />
          </div>
          <p>
            BMW is a German company active in the manufacture and sale of motor
            vehicles, spare parts and accessories for motor vehicles,
            engineering products and related services.
          </p>
        </div>
        {isLoading || models.length === 0 ? <LoadingSpinner /> : 
        <div className="row">
          {models.map((models) => (
            <ModelItem key={models.id} models={models} />
          ))}
        </div>
        }
      </div>
    </div>
  );
};
