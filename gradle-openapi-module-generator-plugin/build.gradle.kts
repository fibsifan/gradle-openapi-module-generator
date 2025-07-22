plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

val openapiGeneratorVersion = "7.14.0"

dependencies {
	testImplementation(kotlin("test"))
	implementation("org.openapitools:openapi-generator:$openapiGeneratorVersion")
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
