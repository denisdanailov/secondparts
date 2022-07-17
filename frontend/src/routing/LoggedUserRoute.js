import { Navigate } from "react-router-dom";
import AuthService from "../services/auth.service";

export const LoggedUserRoute = ({ children }) => {
  const user = AuthService.getCurrentUser();

  if (!user) {
    return <Navigate to="/" />;
  }

  return children;
};
