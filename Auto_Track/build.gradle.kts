plugins {
    `java-library`
    `maven-publish`
}

group = "com.github.CapitalRobotics"
version = "1.0.0"

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("org.apache.commons:commons-math3:3.6.1")
    testImplementation("junit:junit:4.13.2")
}

publishing {
    publications {
        create<MavenPublication>("jitpack") {
            from(components["java"])

            pom {
                name.set("AutoTrack")
                description.set("A system for recording and replaying robot movements in FTC.")
                url.set("https://github.com/CapitalRobotics/AutoTrack")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("torinetheridge")
                        name.set("Torin Etheridge")
                        email.set("torinriley220@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/CapitalRobotics/AutoTrack.git")
                    developerConnection.set("scm:git:ssh://github.com/CapitalRobotics/AutoTrack.git")
                    url.set("https://github.com/CapitalRobotics/AutoTrack")
                }
            }
        }
    }
}