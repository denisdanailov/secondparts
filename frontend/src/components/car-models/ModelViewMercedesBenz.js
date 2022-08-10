import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewMercedesBenz = () => {
  const [models, setModels] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    ModelService.getModelsFromBrandMercedesBenz().then((models) =>
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
