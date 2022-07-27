import { Slider } from "./Slider";
import { Brands } from "./Brands";
import { Category } from "./categories/Category";
import { Clients } from "./Clients";

export const Home = () => {
  return (
    <div>
      <Slider />
      <Brands />
      <Category />
      <Clients />
    </div>
  );
};
