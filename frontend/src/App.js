import { useEffect, useState } from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";

import { Header } from "./components/Header";
import Login from "./components/Login";

import Register from "./components/Register";
import { Home } from "./components/Home";
import { Footer } from "./components/Footer";
import { AdminPanel } from "./components/AdminPanel/AdminPanel";
import { Moderators } from "./components/Moderators";

import AuthService from "./services/auth.service";

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
        <Routes>
          {panel.showAdminBoard && (
            <Route path="/admin" element={<AdminPanel />} />
          )}

          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />

          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
      <Footer />
    </>
  );
}
