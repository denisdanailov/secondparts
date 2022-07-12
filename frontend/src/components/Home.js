import { Slider } from "./Slider";
import { ShopSection } from "./ShopSection";
import { FeatureSection } from "./FeatureSection";
import { Clients } from "./Clients";

export const Home = () => {
  return (
    <div>
      <Slider />
      <ShopSection />
      <FeatureSection />
      <Clients />
    </div>
  );
};
