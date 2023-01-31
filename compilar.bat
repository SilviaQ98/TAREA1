git clone
 && cd ./TAREA1-Distribuida 
 && cd ./app-authors 
 && gradlew quarkusBuild 
 && docker build -t jaimesalvador/app-authors:2.0.0 . 
 && cd .. 
 && cd ./app-books 
 && gradlew installDist 
 && gradlew copyLibs 
 && docker build -t jaimesalvador/app-books:2.0.0 . 
 && docker push jaimesalvador/app-books:2.0.0 
 && docker push jaimesalvador/app-authors:2.0.0 
 && cd .. && docker-compose up
