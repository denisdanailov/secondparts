import { Slider } from "./Slider";
import { Brands } from "./Brands";
import { Category } from "./categories/Category";
import { Steps } from "./steps/Steps";

export const Home = () => {
  return (
    <div>
      <Slider />
      <Brands />
      <Category />
      <Steps />
    </div>
  );
};
