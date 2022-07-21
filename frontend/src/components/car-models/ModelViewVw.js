import { useEffect, useState } from "react";

import ModelService from "../../services/models.service";
import { ModelItem } from "./ModelItem";

export const ModelViewVw = () => {
  const [models, setModels] = useState([]);

  useEffect(() => {
    ModelService.getModelsFromBrandVw().then((models) =>
      setModels(models.data)
    );
  }, []);

  return (
    <div className="container py-5">
      <div className="row text-center text-white mb-5">
        <div className="col-lg-7 mx-auto">
          <h1 className="display-4">Product List</h1>
        </div>
      </div>
      <div className="row">
        <div className="col-lg-8 mx-auto">
          <ul key={models.id} className="list-group shadow">
            {models.map((models) => (
              <ModelItem models={models} />
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};
