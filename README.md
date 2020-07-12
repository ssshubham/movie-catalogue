# Movie Catalogue
Microservice based architecture for Movie Catalouge
This backend service uses Client Side Load Balancing and Service discovery from Netflix Eureka.
Netflix Eureka is ingregrated with Spring Cloud.

It hosts 3 service - (1). Ratings-info service (2). Movie-info service (3). Movie-catalogue service
http://localhost:8082/catalogue/foo 
http://localhost:8083/movies/abcd
http://localhost:8084/ratingsdata/foo

Eureka by default gets hosted on 8761 http://localhost:8761/eureka
