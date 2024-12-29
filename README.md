Movie Management App
-------------------
Overview
This application allows the admin to manage movies fetched from the OMDB API, and the regular user can view and rate the movies. It is built using Angular 18+ for the frontend and Spring Boot for the backend.
Features:
•	Admin Dashboard:
o	Login functionality for admin users and normal users.
o	Fetch movie data from OMDB API and display in the admin dashboard.
o	Ability for the admin to add or remove movies from the database.
•	Regular User Dashboard:
o	Login functionality for regular users.
o	Ability to view the full list of movies.
o	View movie details.
o	Search and rate movies.
Technologies:
•	Frontend: Angular 18+
•	Backend: Spring Boot
•	Database: MySQL
______________
Project Structure:
================
Backend: Located in the fawryproject folder (Spring Boot)
Frontend: Located in the fawryfrontpart folder (Angular)
______________
Setup Instructions
================
Prerequisites
================
•	Java 17 or higher
•	Node.js (for Angular)
•	MySQL Database (or any other database)
•	Git
1. Clone the Repository
Clone the project from GitHub:
git clone https://github.com/omaryehia20002018/movietask.git
cd movietask
2. Set Up the Backend (Spring Boot)
•	Navigate to the backend directory.
cd movie-app
•	Ensure the necessary properties are set for the database connection in application.properties (or application.yml).
Example configuration for MySQL:
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/first
spring.datasource.username=root
spring.datasource.password=Iambornin2000
spring.jpa.hibernate.ddl-auto=update
•	Build and run the backend:
                        mvn clean install
                      mvn spring-boot:run
3. Set Up the Frontend (Angular)
•	Install dependencies:
                npm install -g @angular/cli    
•	Navigate to the frontend directory .
cd Movie-Application-master
•	Install dependencies:
                    npm install
•	Start the Angular app:
                       ng serve
The Angular application will now be running at http://localhost:4200.
______________

Notes
Ensure the backend server is running before starting the frontend application.
You may need to adjust your firewall or port configurations depending on your environment.

______________
Conclusion
With these steps, you should now have the application running locally and be able to use both the admin and regular user dashboards. If you have any issues or questions, feel free to open an issue in the repository.
______________
