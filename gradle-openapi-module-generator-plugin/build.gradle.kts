plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
	implementation("org.openapitools:openapi-generator:7.8.0")
}

tasks {
	test {
		useJUnitPlatform()
	}
}

kotlin {
	jvmToolchain(17)
}

gradlePlugin {
	plugins {
		create("openapi-module-generator") {
			id = "openapi-module-generator"
			implementationClass = "de.jball.gradle.openapi.OpenApiModuleGeneratorPlugin"
		}
	}
}
