/* this project is about storing theaters data in to mysql database and retrieving the data */


// Required software:
        Docker is required to run mysql database
        IntelliJ IDEA or eclipse or JAVA Executable environment

// order of installations
        Install Docker
        Run Docker composite file to create a MYSQL database. This can be done using IDE or cmd.
           CMD: " docker-compose up "
           NOTE: You should be in the directory where .yml file exist.Docker will
                 automatically pick .yml files in that directory.
        By executing above command database container will be created locally.
        Open the springboot application in IDE and execute  GracenoteApplication.java class

// Verifying the code

        After running springboot application, spring will create tables and load data
            using code written in loaddata folder.

        There is rest endpoint which will read all the data from database and return the to the user

           1) http://localhost:8084/theatersData/all    ( this will return all the records inside databse)

           2) http://localhost:8084/theatersData/13     ( this will return record with id 13)

           3) http://localhost:8084/theatersData/chainname/amc  (returns list of all amc records)

           4) http://localhost:8084/theatersData/chainname/regal   (return list of all regal records)

             Normalized the tables for second part and endpoint url to test the code
           5) http://localhost:8084/theaters/refactor/theaterMovies/chain/AMC

