plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
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
