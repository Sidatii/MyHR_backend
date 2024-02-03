# MyHR Backend

Welcome to MyHR backend! This is a Java-based project that serves as the backend for our application. Follow the steps below to set up your development environment and access the Swagger endpoint.

## Prerequisites

Before you start, make sure you have the following installed on your Windows machine:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Setting Up JDK

1. Download and install the latest version of JDK from the official website.

2. Set the JAVA_HOME environment variable:
   - Open the Control Panel.
   - Search for "Environment Variables" and select "Edit the system environment variables."
   - Click on the "Environment Variables" button.
   - Under the "System variables" section, click "New" and add:
     - Variable Name: `JAVA_HOME`
     - Variable Value: `C:\Path\To\Your\JDK`
   - Click "OK" to close the windows.

3. Add JDK to the system's PATH:
   - In the "Environment Variables" window, find the "Path" variable under "System variables" and click "Edit."
   - Click "New" and add: `%JAVA_HOME%\bin`
   - Click "OK" to close the windows.

## Setting Up PostgreSQL with pgAdmin

1. Download and install PostgreSQL from the official website.

2. During the installation, make sure to note the port number (default is 5432) and the password you set for the PostgreSQL superuser (usually 'postgres').

3. Open pgAdmin, which is installed alongside PostgreSQL.

4. In pgAdmin:
   - Connect to the PostgreSQL server using the following details:
     - Host: `localhost`
     - Port: `5432` (or the port you specified during installation)
     - Maintenance Database: `postgres`
     - Username: `postgres` (or the username you specified during installation)
     - Password: [Your Password]

5. Once connected, right-click on "Login/Group Roles" and create a new role with your desired username and password. Ensure this role has the necessary privileges.

6. Create a new database for the project:
   - Right-click on "Databases" and choose "Create > Database..."
   - Enter your desired database name 'my_hr' and set the owner to the role you created earlier.
   - Click "Save" to create the database.

## Building the Project with Maven

1. Download and install [Apache Maven](https://maven.apache.org/download.cgi).

2. Add Maven to your system PATH:
   - Open the Control Panel.
   - Search for "Environment Variables" and select "Edit the system environment variables."
   - Click on the "Environment Variables" button.
   - Under the "System variables" section, find the "Path" variable and click "Edit."
   - Click "New" and add the path to your Maven bin directory (e.g., `C:\Path\To\Maven\bin`).
   - Click "OK" to close the windows.

3. Open a new Command Prompt and verify that Maven is installed by running:
   ```bash
   mvn -v
   ```

This should display Maven's version information.

4. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/Sidatii/MyHR_backend.git
   ```

5. Navigate to the project directory:
   ```bash
   cd MyHR_backend
   ```

6. Build the project using Maven:
   ```bash
   mvn clean install
   ```

   Maven will download the project dependencies and build the project. Make sure you are connected to the internet as Maven fetches dependencies from the central repository.

## Running the Project

1. Using an Integrated Development Environment (IDE)
   Open your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

Import the project into the IDE:

For IntelliJ IDEA: File > Open > Select the project directory.
For Eclipse: File > Import > Existing Projects into Workspace > Select the project directory.
Build the project within the IDE.

Locate the main application class (usually named Application or similar).

Run the main application class. This will start the project, and you can access it at http://localhost:8081.

## Accessing Swagger Endpoint

1. Open your web browser and go to the Swagger UI endpoint:Open your web browser and go to the Swagger UI endpoint:

```bash
http://localhost:8081/swagger-ui.html
```
This will display the Swagger UI, allowing you to explore and interact with the API endpoints.

That's it! You're all set to start working on the frontend. If you have any issues or questions, feel free to reach out.

