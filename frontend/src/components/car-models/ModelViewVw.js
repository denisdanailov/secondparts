import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";


export const ModelViewVw = () => {
  const [models, setModels] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);    
    ModelService.getModelsFromBrandVw().then((models) =>
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
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564730/brands-seconsparts/vw-logo1_hurg1g.png"
              alt=""
            />
          </div>
          <p>
            Volkswagen, abbreviated VW, is a German automobile brand, one of
            many belonging to the Volkswagen AG group. It is headquartered in
            Wolfsburg. The group's main market is China, which generates 40% of
            sales and revenue
          </p>
        </div>
        {isLoading || models.length == 0 ? <LoadingSpinner /> : 
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
