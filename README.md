Event Management System
This repository contains the source code and documentation for an Event Management System developed for managing various events efficiently.

Overview
The Event Management System is designed to streamline the process of organizing and managing events of different scales. It provides features for Event Creation,Event Update,Distance Calculation.

Features

- Event Creation: Users can create new events by providing details such as event name, date, location, and description.
- Event Update: Existing events can be updated with new information or modified details.
- Distance Calculation: Calculate the distance between two geographical coordinates using latitude and longitude.


Technologies Used
Programming Languages: Java
Frameworks: Spring Boot,Rest API,Hibernate
Database: MySQL
Tools: Git, GitHub,Postman
Internet Reference-Chat Gpt


Endpoints
POST /api/events/create: Create a new event.
GET /api/events/find: Find events within the next 14 days based on provided latitude, longitude, and date.
GET /api/events/calculate-distance: Calculate the distance between two geographical points using latitude and longitude.

Setup Instructions
Clone the Repository:

bash
Copy code
git clone https://github.com/RaksheAbhishek/event-management.git
Backend Setup:

Navigate to the backend directory:
bash
Copy code
cd event-management-system/backend
Install dependencies:
Copy code
npm install
Set up the database and configure database connection in application.properties.
Run the backend server:
sql
Copy code
npm start

Install dependencies:
Copy code
npm install
sql
Copy code
npm start
Access the Application:

Once both the backend servers are running, you can access the application at http://localhost:3000 in your web browser.
