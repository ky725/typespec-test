// build.gradle.kts
plugins {
  `maven-publish`
}

group = "com.github.ky725"
version = System.getenv("VERSION") ?: "0.0.0-SNAPSHOT"

publishing {
  publications {
    create<MavenPublication>("spec") {
      artifactId = "typespec-test"
      artifact(file("tsp-output/schema/openapi.yaml")) {
        extension = "yaml"
      }
    }
  }
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/ky725/typespec-test")
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}
