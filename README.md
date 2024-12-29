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
