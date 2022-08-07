import { Slider } from "../slider/Slider";
import { Brands } from "../brands/Brands";
import { Category } from "../categories/Category";
import { Steps } from "../steps/Steps";

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
