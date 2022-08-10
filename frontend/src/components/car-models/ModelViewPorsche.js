import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewPorsche = () => {
  const [models, setModels] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    ModelService.getModelsFromBrandPorsche().then((models) =>
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
              src="https://res.cloudinary.com/diozchjq4/image/upload/v1659564729/brands-seconsparts/porshe-logo_ujcf8w.png"
              alt=""
            />
          </div>
          <p>
            Porsche Engineering ─ the engineering services provider for
            future-oriented mobility. The company therefore approaches the
            technical challenges from a wide range of projects in an accordingly
            holistic and innovative spirit.
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
