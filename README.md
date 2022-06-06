# SpringRunner Class 201: Spring Boot Essential

스프링 부트로 구현하는 실전 멀티 모듈 프로젝트 1

## Div Log

### SpringApplication 살펴보기

Console에서 Argument 전달 방법  

```bash
./gradlew bootRun --args="--app.name=dive-log-cmd"
```

Console에서 build 하는 방법  

```bash
./gradlew clean build
```

빌드시 두개의 jar가 생성되는데 plain jar파일은 일반 적인 배포형태의 jar 파일임

실행가능한 jar 생성  

```bash
unzip dive-log-0.0.1-SNAPSHOT.jar -d executable-jar
```

jar파일 실행  

```bash
java -jar dive-log-0.0.1-SNAPSHOT.jar --app.name=dive-log-jar
```