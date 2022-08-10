import { Routes, Route, BrowserRouter } from "react-router-dom";
import { ShoppingCartProvider } from "./contexts/ShoppingCartContext";

import { GuestRoute } from "./routing/GuestRoute";
import { LoggedUserRoute } from "./routing/LoggedUserRoute";
import { ProtectedRoute } from "./routing/ProtectedRoute";

import { Login } from "./components/login/Login";
import { Register } from "./components/register/Register";
import { Catalog } from "./components/catalog/Catalog";
import { Header } from "./components/header/Header";
import { Home } from "./components/home/Home";
import { Contact } from "./components/contact/Contact";
import { About } from "./components/about/About";
import { Footer } from "./components/footer/Footer";
import { AdminPanel } from "./components/admin-panel/AdminPanel";
import { CreateOffer } from "./components/catalog/offer-crud/create-offer/CreateOffer";
import { ModelViewAudi } from "./components/car-models/ModelViewAudi";
import { ModelViewVw } from "./components/car-models/ModelViewVw";
import { ModelViewMercedesBenz } from "./components/car-models/ModelViewMercedesBenz";
import { ModelViewPorsche } from "./components/car-models/ModelViewPorsche";
import { ModelViewBmw } from "./components/car-models/ModelViewBmw";
import { ModelViewOpel } from "./components/car-models/ModelViewOpel";
import { Logout } from "./components/logout/Logout";
import { Checkout } from "./components/checkout/Checkout";
import { Search } from "./components/search/Search";
import { OfferDetails } from "./components/catalog/offer-crud/offer-details/OfferDetails";
import { CategortOffersList } from "./components/categories/CategoryOffersList";

export default function App() {
  return (
    <>
      <BrowserRouter>
        <ShoppingCartProvider>
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
              exact
              path="category/offers/:id"
              element={<CategortOffersList />}
            />
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
        </ShoppingCartProvider>
        <Footer />
      </BrowserRouter>
    </>
  );
}
