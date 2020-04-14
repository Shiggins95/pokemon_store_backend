FROM openjdk:8-jdk-alpine
# make new dir for dependancy and unpack the jar in it - cant do this on linux (lindoe) without java
# -  so need to do here so it will create dependencies on the docker container that are required
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
# add new user to separate from root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY ${JAR_FILE} app.jar
# where to start the app from
ENTRYPOINT ["java","-cp","app:app/lib/*", "com.stephenhiggins.pokemon_store_backend.PokemonStoreBackendApplication"]