import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewAudi = () => {
  const [models, setModels] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    ModelService.getModelsFromBrandAudi().then((models) =>
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
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564731/brands-seconsparts/audi-logo_x2bube.png"
              alt=""
            />
          </div>
          <p>
            Audi stands for sporty vehicles, premium workmanship and progressive
            design – for “Vorsprung durch Technik”. Founded in 1899 by August
            Horch, the Audi Group – which also unites the Bentley, Ducati and
            Lamborghini brands under one roof.
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
