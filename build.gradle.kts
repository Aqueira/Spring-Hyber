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
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.4")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.2")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.1")

    // Spring Data
    implementation("org.springframework.data:spring-data-jpa:3.3.4")

    // Hibernate
    implementation("org.hibernate.orm:hibernate-core:6.6.1.Final")
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

    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")

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
