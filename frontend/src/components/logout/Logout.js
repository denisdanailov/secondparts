import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

import AuthService from "../../services/auth.service";

export const Logout = () => {
  const navigate = useNavigate();

  useEffect(() => {
    navigate("/");
    AuthService.logout();
  }, []);

  return null;
};
