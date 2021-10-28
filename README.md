# products
Simple products microservice which does CRUD operations connecting to MYSQL docker container

# RUN mysql as docker container
https://hub.docker.com/_/mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=D@tabase123 -e MYSQL_DATABASE=product -e MYSQL_USER=varun -e MYSQL_PASSWORD=D@tabase123 --name=mysql mysql:8.0.27

mvn clean install
docker push devopsvarun/products:0.0.1-SNAPSHOT

docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" -e MYSQL_HOSTNAME=mysql --link=mysql devopsvarun/products:0.0.1-SNAPSHOT

# EXECUTE CRUD operations on postman
http://localhost:8080/products (GET/POST/PUT/DELETE)


