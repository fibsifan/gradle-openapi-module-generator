plugins {
	`kotlin-dsl`
	id("com.dorongold.task-tree") version "4.0.1"
}

group = "de.jball.gradle"
version = "0.1.0-SNAPSHOT"


kotlin {
	jvmToolchain(17)
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
	implementation(libs.openapi.generator)
}

tasks {
	test {
		useJUnitPlatform()
	}
}


tasks {
	wrapper {
		gradleVersion = "9.3.1"
		distributionType = Wrapper.DistributionType.ALL
	}
}

gradlePlugin {
	plugins {
		create("openapi-module-generator") {
			id = "openapi-module-generator"
			implementationClass = "de.jball.gradle.openapi.OpenApiModuleGeneratorPlugin"
		}
	}
}
