plugins {
    java
    war
}

group = "org.course"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.4") // Это включает JUnit 5 и Mockito
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.2")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.1")
    // Замените на нужную версию Spring
    implementation("org.springframework:spring-test:5.3.25")
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.4") // Укажите совместимые версии
    implementation("org.springframework:spring-core:6.1.13")
    implementation("org.springframework:spring-web:6.1.13")
    implementation("org.springframework:spring-webmvc:6.1.13")
    implementation("org.springframework:spring-aop:6.1.13")
    implementation("org.springframework:spring-context:6.1.13")
    implementation("org.springframework:spring-orm:6.1.13")
    implementation("org.springframework.data:spring-data-jpa:3.3.4")
    implementation("org.springframework.data:spring-data-commons:3.3.4")


    // Hibernate
    implementation("org.hibernate.orm:hibernate-core:6.6.1.Final")
    implementation("org.hibernate:hibernate-entitymanager:5.6.15.Final")
    implementation("com.zaxxer:HikariCP:6.0.0")


    // Logging with Log4j
    implementation("org.apache.logging.log4j:log4j-api:2.17.2")
    implementation("org.apache.logging.log4j:log4j-core:2.17.2")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.17.2")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    // MapStruct
    implementation("org.mapstruct:mapstruct:1.6.2")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.2")

    // Jakarta dependencies
    providedCompile("jakarta.servlet:jakarta.servlet-api:5.0.0")
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("org.hibernate.orm:hibernate-core:6.6.1.Final")


    // Thymeleaf
    implementation("org.thymeleaf:thymeleaf-spring6:3.1.2.RELEASE")
    implementation("org.thymeleaf:thymeleaf:3.1.2.RELEASE")

    // PostgreSQL driver
    implementation("org.postgresql:postgresql:42.7.4")

    // Jackson for JSON processing
    implementation("com.fasterxml.jackson.core:jackson-core:2.18.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")

    // AspectJ for AOP support
    runtimeOnly("org.aspectj:aspectjweaver:1.9.22.1")
    runtimeOnly("org.aspectj:aspectjrt:1.9.22.1")
    implementation("org.aspectj:aspectjtools:1.9.22.1")

    // SLF4J for logging
    implementation("org.slf4j:slf4j-api:2.0.16")
    testImplementation("org.slf4j:slf4j-simple:2.0.16")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

tasks.named<War>("war") {
    archiveBaseName.set("SpringMVCHibernate")
    archiveVersion.set("")
}

tasks.withType<Test> {
    useJUnitPlatform() // Обязательно для использования JUnit 5
}
