# user-realm

The repository contains a built war file to deploy on tomcat. alternatively, since the project was made with spring boot, a jar file is also avaiable.

# summary

The project was developed with spring boot and jdbcTemplate. It makes large use of annotation driven configuration. 
Rest controllers receive the client requests, handling both json and xml formats. fasterxml.jackson was used to execute the mapping of the DTOs  into xml strings.

H2 is used as a testing database, containing a single table called "Realms"

One of my main objectives was to work on a test driven development basis, release test cases first and then develop functionality over them in a continuous cycle. I however found this to be my major time sink, and for the sake of completion of the project i was only able to make an incomplete test suite for the controller (The positive tests regarding realms creation are missing). With more time at hand, i would have made unit testing the main priority. 

I However strived to minimize the coupling of the modules, and favoured the use of simple atomic interfaces, so that test development could be quick and easy to do.
