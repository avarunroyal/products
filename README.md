# products
Simple products microservice which does CRUD operations connecting to MYSQL docker container

# RUN mysql as docker container
https://hub.docker.com/_/mysql
<br />$ docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=D@tabase123 -e MYSQL_DATABASE=product -e MYSQL_USER=varun -e MYSQL_PASSWORD=D@tabase123 --name=mysql mysql:8.0.27

# Create docker image of products microservice and push to docker repository
$ mvn clean install
<br />$ docker push devopsvarun/products:0.0.1-SNAPSHOT

# RUN products microservice as docker container
$ docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" -e MYSQL_HOSTNAME=mysql --link=mysql devopsvarun/products:0.0.1-SNAPSHOT

# EXECUTE CRUD operations on postman
http://localhost:8080/products (GET/POST/PUT/DELETE)

# DEPLOY to GCP kubernetes
Create gcloud cluster at https://console.cloud.google.com/ - Kubernets Engine -> cluster-1
<br />$ gcloud container clusters get-credentials cluster-1 --zone us-central1-a --project #project-id#
  
<br /> In Local download kompose-windows-amd64 and run:
<br />$ kompose convert -> This will generate all the below files.
  
<br /> Deploy using generated files in GCP
  
<br />$ kubectl apply -f mysql-database-data-volume-persistentvolumeclaim.yaml,mysql-deployment.yaml,mysql-service.yaml
<br />$ kubectl apply -f product-deployment.yaml,product-service.yaml


