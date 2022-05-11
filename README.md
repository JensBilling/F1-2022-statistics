# API that stores and handles race statistics of the 2022 Formula 1 world championship season.
## What is this?
### A Spring boot application featuring Spring JPA, MySQL database, Spring Security and JMS(ActiveMQ).
### If you are not signed in you can only access the sing-up endpoint (http://localhost:8080/api/auth/signup)
### When you sign up you create a new account, it is given the ROLE of USER and are only authorized to send GET-requests
### You need an ADMIN account to send POST- and DELETE-requests
### When the program is started, data is automatically generated to the database and one user and one admin account is created
### Passwords are hashed using BCrypt
### Default user account is user:password and default admin account is admin:password
### Use Basic-Auth with your account details when sending a request to authenticate yourself
___
## Instructions:
### Start a MySQL database with docker command:
```
docker run --name f1-2022-container -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:8
```
### Create a database schema named "f1-2022-db"
### You will need to run a separate JMS receiver and ActiveMQ broker, follow the instructions found at:
```
https://github.com/JensBilling/F1-2022-statistics-JMS-ActiveMQ-Receiver
```
### Start the ActiveMQ broker (docker instructions found in the JMS receiver repository above)
### Run F12022StatisticsApplication (will run on port 8080)
### Run F12022StatisticsJmsActiveMqReceiverApplication (will run on port 8081)
### Test the API with Postman or Insomnia, with the endpoints and inputs listed in the API-section below
### Don't forget to authenticate with Basic-Auth!
___
## Relations:
### A F1 team is an entity that contains a list of drivers and one team boss
### A F1 race is an entity that contains a list of race results
### A User is an entity that contains a list of roles
___

# API endpoints:
## Team management:
### Get all teams
GET @ http://localhost:8080/api/teams

### Get team by id
GET @ http://localhost:8080/api/teams/{id}

### Add a new team
POST http://localhost:8080/api/teams
with JSON request body:
``` Json
{
	"name": "Team name",
	"engineManufacturer": "Engine manufacturer"
}
```

### Delete team
DELETE @ http://localhost:8080/api/teams?id={id}

### Add driver To team
POST @ http://localhost:8080/api/teams/adddrivertoteam?teamid={teamid}&driverid={driverid}

### Add boss To team
POST @ http://localhost:8080/api/teams/addbosstoteam?teamid={teamid}&bossid={bossid}
___
## Driver management:
### Get all drivers
GET @ http://localhost:8080/api/drivers/

### Get driver by id
GET @ http://localhost:8080/api/drivers/{id}

### Add a new driver
POST @ localhost:8080/api/drivers
with JSON request body:
``` Json
{
	"name": "Driver's name",
	"age": "30"
}
```

### Delete driver
DELETE @ http://localhost:8080/api/drivers?id={id}
___
## Boss management:
### Get all bosses
GET @ http://localhost:8080/api/bosses/

### Get boss by id
GET @ http://localhost:8080/api/bosses/{id}

### Create new boss
POST @ http://localhost:8080/api/bosses/
with JSON request body:
``` Json
{
"name" : "Boss' name",
"age" : 50,
"yearsAsTeamBoss" : 10
}
```

### Delete boss
DELETE @ http://localhost:8080/api/bosses?id={id}
___
## User management:
### Create new user account
POST @ http://localhost:8080/api/auth/signup
with JSON request body:
``` Json
{
	"name" : "Real name",
	"username" : "username",
	"email" : "email@address.com",
	"password" : "password"
}
```

### Test you new account
POST @ localhost:8080/api/auth/signin
with JSON request body:
``` Json
{
	"usernameOrEmail": "your username or email-address",
	"password": "your password"
}
```
___
## Race management:
### Get all races
GET @ http://localhost:8080/api/races

### Get race by id
GET @ http://localhost:8080/api/races{id}

### Add new race
POST @ http://localhost:8080/api/races/add with JSON request body:
``` Json
{
"trackName": "Bahrain",
"trackDistance": 53.3,
"driverIdOfFastestLap": 3,
"raceResults": [  
    {
        "driverId": 16,
        "driverPlacement": 1
    }
  ]
}
```

### Delete race
DELETE @ http://localhost:8080/api/races?id={id}

### Add new race result
POST @ http://localhost:8080/api/races/createraceresult
with JSON request body:
``` Json
{
	"driverId" : 3,
	"driverPlacement" : 20
}
```
### Add a race result to race 
POST @ http://localhost:8080/api/races/addraceresulttorace?raceid={raceid}&resultid={raceresultid}