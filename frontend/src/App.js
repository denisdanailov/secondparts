import { Routes, Route, BrowserRouter } from "react-router-dom";

import { GuestRoute } from "./routing/GuestRoute";
import { LoggedUserRoute } from "./routing/LoggedUserRoute";
import { ProtectedRoute } from "./routing/ProtectedRoute";

import Login from "./components/Login";
import Register from "./components/Register";
import Catalog from "./components/Catalog";
import { Header } from "./components/Header";
import { Home } from "./components/Home";
import { Contact } from "./components/Contact";
import { About } from "./components/About";
import { Footer } from "./components/Footer";
import { AdminPanel } from "./components/AdminPanel/AdminPanel";
import { CreateOffer } from "./components/CreateOffer";

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
