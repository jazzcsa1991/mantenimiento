# Crear red manualmente teniendo levantado Docker desde cualquier terminal

docker network create hts-backend-network
docker network ls

cd /proyecto
docker-compse up -d
docker-compose down

docker container ls -a // Lista de todos los contenedores
docker logs container_id // Mostrar los logs de un contenedor 

docker-compose build || docker-compse up --build // Generar la imagen nuevamente


grafana credentials
user admin
pass PbV65AYyxGUEgsTL0q0xoP63QjCQ0yaZVUhk