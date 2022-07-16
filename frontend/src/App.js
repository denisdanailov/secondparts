import { useEffect, useState } from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";

import AuthService from "./services/auth.service";

import Login from "./components/Login";
import Register from "./components/Register";
import Catalog from "./components/Catalog";
import { Header } from "./components/Header";
import { Home } from "./components/Home";
import { Contact } from "./components/Contact";
import { About } from "./components/About";
import { Footer } from "./components/Footer";
import { AdminPanel } from "./components/AdminPanel/AdminPanel";

export default function App() {
  const [panel, setPanel] = useState({
    guest: true,
    showModeratorBoard: false,
    showAdminBoard: false,
    currentUser: undefined,
  });

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setPanel({
        guest: false,
        currentUser: AuthService.getCurrentUser(),
        showModeratorBoard: user.roles.includes("ROLE_MODERATOR"),
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }, []);

  return (
    <>
      <BrowserRouter>
        <Header />
        {panel.showAdminBoard && (
          <Routes>
            <Route path="/admin" element={<AdminPanel />} />
          </Routes>
        )}

        {panel.currentUser && (
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/catalog" element={<Catalog />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact" element={<Contact />} />
          </Routes>
        )}

        {panel.guest && (
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/catalog" element={<Catalog />} />
            <Route path="/contact" element={<Contact />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Routes>
        )}
      </BrowserRouter>
      <Footer />
    </>
  );
}
