import { Navigate } from "react-router-dom";
import AuthService from "../services/auth.service";

export const ProtectedRoute = ({ children }) => {
  const user = AuthService.getCurrentUser();

  if (!user || !user.roles.includes("ROLE_ADMIN")) {
    return <Navigate to="/" />;
  }

  return children;
};
