import { Routes, Route, BrowserRouter } from "react-router-dom";

import { GuestRoute } from "./routing/GuestRoute";
import { LoggedUserRoute } from "./routing/LoggedUserRoute";
import { ProtectedRoute } from "./routing/ProtectedRoute";

import { Login } from "./components/login/Login";
import { Register } from "./components/register/Register";
import { Catalog } from "./components/catalog/Catalog";
import { Header } from "./components/Header";
import { Home } from "./components/Home";
import { Contact } from "./components/Contact";
import { About } from "./components/About";
import { Footer } from "./components/Footer";
import { AdminPanel } from "./components/admin-panel/AdminPanel";
import { CreateOffer } from "./components/catalog/offer-crud/create-offer/CreateOffer";
import { ModelViewAudi } from "./components/car-models/ModelViewAudi";
import { ModelViewVw } from "./components/car-models/ModelViewVw";
import { ModelViewMercedesBenz } from "./components/car-models/ModelViewMercedesBenz";
import { ModelViewPorsche } from "./components/car-models/ModelViewPorsche";
import { ModelViewBmw } from "./components/car-models/ModelViewBmw";
import { ModelViewOpel } from "./components/car-models/ModelViewOpel";
import { Logout } from "./components/Logout";
import { Checkout } from "./components/checkout/Checkout";
import { Search } from "./components/search/Search";
import { OfferDetails } from "./components/catalog/offer-crud/offer-details/OfferDetails";

export default function App() {
  return (
    <>
      <BrowserRouter>
        <Header />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/catalog" element={<Catalog />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/models/vw" element={<ModelViewVw />} />
          <Route
            path="/models/mercedes-benz"
            element={<ModelViewMercedesBenz />}
          />
          <Route path="/models/bmw" element={<ModelViewBmw />} />
          <Route path="/models/audi" element={<ModelViewAudi />} />
          <Route path="/models/opel" element={<ModelViewOpel />} />
          <Route path="/models/porsche" element={<ModelViewPorsche />} />
          <Route path="/search" element={<Search />} />
          <Route exact path="offer/details/:id" element={<OfferDetails />} />
          <Route
            path="/checkout"
            element={
              <LoggedUserRoute>
                <Checkout />
              </LoggedUserRoute>
            }
          />
          <Route
            path="/logout"
            element={
              <LoggedUserRoute>
                <Logout />
              </LoggedUserRoute>
            }
          />

          <Route
            path="/create"
            element={
              <LoggedUserRoute>
                <CreateOffer />
              </LoggedUserRoute>
            }
          />
          <Route
            path="/admin"
            element={
              <ProtectedRoute>
                <AdminPanel />
              </ProtectedRoute>
            }
          />
          <Route
            path="/login"
            element={
              <GuestRoute>
                <Login />
              </GuestRoute>
            }
          />
          <Route
            path="/register"
            element={
              <GuestRoute>
                <Register />
              </GuestRoute>
            }
          />
        </Routes>

        <Footer />
      </BrowserRouter>
    </>
  );
}
