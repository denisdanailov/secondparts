import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import { Link } from "react-router-dom";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

import { useState } from "react";
import { useNavigate } from "react-router-dom";

import AuthService from "../services/auth.service";

const theme = createTheme();

export default function Register() {
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  async function handleSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);

    const firstName = formData.get("firstName");
    const lastName = formData.get("lastName");
    const username = formData.get("username");
    const email = formData.get("email");
    const password = formData.get("password");
    const rePass = formData.get("rePass");

    if (username.length < 6) {
      return setError(
        <Stack sx={{ width: "100%" }} spacing={2}>
          <Alert severity="error">Username musst containt 6 charachters</Alert>
        </Stack>
      );
    }

    if (password !== rePass) {
      return setError(
        <Stack sx={{ width: "100%" }} spacing={2}>
          <Alert severity="error">Passwords don`t match!</Alert>
        </Stack>
      );
    }

    if (password.length < 6) {
      return setError(
        <Stack sx={{ width: "100%" }} spacing={2}>
          <Alert severity="error">Password musst containt 6 charachters</Alert>
        </Stack>
      );
    }

    try {
      setError("");
      setLoading(true);
      AuthService.register(firstName, lastName, username, email, password).then(
        () => {
          navigate("/login");
        }
      );
    } catch {
      setError(
        <Stack sx={{ width: "100%" }} spacing={2}>
          <Alert severity="error">Failed to Sign in</Alert>
        </Stack>
      );
    }

    setLoading(false);

    navigate("/");
  }

  return (
    <ThemeProvider theme={theme}>
      <Grid container component="main">
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage: `url(${
              process.env.PUBLIC_URL + "/images/register-photo.jpg"
            })`,
            backgroundRepeat: "no-repeat",
            backgroundColor: (t) =>
              t.palette.mode === "light"
                ? t.palette.grey[50]
                : t.palette.grey[900],
            backgroundSize: "cover",
            backgroundPosition: "center",
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
          <Box
            sx={{
              my: 40,
              mx: 4,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
              <LockOutlinedIcon />
            </Avatar>

            <Typography component="h1" variant="h5">
              Sign up
            </Typography>
            {error ? error : null}
            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit}
              sx={{ mt: 3 }}
            >
              <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                  <TextField
                    autoComplete="given-name"
                    name="firstName"
                    fullWidth
                    id="firstName"
                    label="First Name"
                    autoFocus
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    fullWidth
                    id="lastName"
                    label="Last Name"
                    name="lastName"
                    autoComplete="lastName"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="username"
                    label="Username"
                    name="username"
                    autoComplete="username"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="email"
                    label="Email Address"
                    name="email"
                    autoComplete="email"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="imageUrl"
                    label="Profil Picture"
                    name="imageUrl"
                    autoComplete="imageUrl"
                  />
                </Grid>
                <Grid item xs={12}>
                  {!error ? (
                    <TextField
                      required
                      fullWidth
                      name="password"
                      label="Password"
                      type="password"
                      id="password"
                      autoComplete="new-password"
                    />
                  ) : (
                    <TextField
                      error
                      fullWidth
                      id="filled-error-helper-text"
                      type="password"
                      variant="filled"
                    />
                  )}
                </Grid>
                <Grid item xs={12}>
                  {!error ? (
                    <TextField
                      required
                      fullWidth
                      name="rePass"
                      label="Confirm Password"
                      type="password"
                      id="rePass"
                      autoComplete="new-password"
                    />
                  ) : (
                    <TextField
                      error
                      fullWidth
                      id="filled-error-helper-text"
                      type="password"
                      variant="filled"
                    />
                  )}
                </Grid>
                <Grid item xs={12}>
                  <FormControlLabel
                    control={
                      <Checkbox value="allowExtraEmails" color="primary" />
                    }
                    label="I want to receive inspiration, marketing promotions and updates via email."
                  />
                </Grid>
              </Grid>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                disabled={loading}
                sx={{ mt: 3, mb: 2 }}
              >
                Sign Up
              </Button>
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <Link to={"/login"}>Already have an account? Sign in</Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}
