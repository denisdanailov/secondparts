import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewOpel = () => {
  const [models, setModels] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    ModelService.getModelsFromBrandOpel().then((models) =>
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
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564729/brands-seconsparts/opel-logo1_tu3qnz.png"
              alt=""
            />
          </div>
          <p>
            Opel Automobile GmbH is a German automobile manufacturing company.
            The company was founded on January 21, 1863 and began producing
            automobiles in 1899.
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
