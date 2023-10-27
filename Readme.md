# Activities Service
Basic app to show upcoming events and movies

This app communicates with 2 other service
- event-service (To fetch events data)
- movie-service (To fetch movie data)

## Getting Started
Clone the github Repo and import in intellij (or your choice of IDE) \
**Notes:**
- If you have the zipped project, just unzip it and import in any IDE
- The config file for main program can be found in `src/main/config/` folder
- The config files for test program can be found in `src/test/config/` folder

## Built With
* Java 17
* [Maven](https://maven.apache.org/)

### Prerequisites
- Java 17
- Maven
- Intellij (or your choice of IDE)

### Installing
- Install java 17 \
  You can use [sdman](https://sdkman.io/install) and choose 11.0.9.j9-adpt as java<br>
  `sdk install java 17.0.9-zulu`
- Install Maven \
  Visit [this link](https://maven.apache.org/install.html) in order to install maven in your local.

### Running the project
- To run the program, execute below commands in terminal at root level
    ```
    gradle clean build
    java -jar build/libs/bits-0.0.1-SNAPSHOT.jar
    ```

### Deploying on Kubernetes Minikube
**NOTE** - Kindly install the below softwares before moving ahead
- minikube
- kubectl
- docker

Once you have installed above software, run below commands to get this application deployed
- `gradle clean build`
- `docker build -t activities -f ./Dockerfile . `
- `minikube image load activities`
- Check if the images is available in minikube by running below command
  - `minikube image ls --format table`
- Once image is available run below command
  - `kubectl apply -f deployment.yaml`
- If its your first time deploying the run below command
  - `kubectl expose deployment activities --type=NodePort`
- Lastly run this command - `minikube service activities`

## Acknowledgments
- [Baeldung](https://www.baeldung.com)
- [StackoverFlow](https://stackoverflow.com/)