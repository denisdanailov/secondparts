# secondparts-app
Аpplication for buying and selling for used car parts.


### Technology Stack
Component         | Technology
---               | ---
Frontend          | React 
Backend           | Spring Boot, Java 
Security          | Spring Security, JWT
Database          | Mysql
Persistence       | JPA 
Client Build      | npm, webpack
Server Build      | gradle


## Install and run

Note: Spring Boot Server App must be running before starting the client!

When the server is running you can try to access the API for example to query all offers
```
url http://localhost:8080/api/offers/all
```
After starting the server you can install and run the client from the `frontend` folder:

1. `npm install` (installs the node modules)
2. `PORT=8081 npm start` 
3. Open `http://localhost:8081`

### Admin Account
- username : admin
- password : topsecreet


### Live Preview
[secondParts](https://secondparts.netlify.app/).


## Feedback

In case you have any comments, questions, bugs, enhancements feel free to open an issue in this repository.
