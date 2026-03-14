import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.tasktree)
	alias(libs.plugins.gradle.plugin)
}

group = "de.jball.gradle"
version = "0.1.0-SNAPSHOT"


kotlin {
	jvmToolchain(21)
	compilerOptions {
		allWarningsAsErrors = true
		// https://docs.gradle.org/current/userguide/compatibility.html#kotlin
		apiVersion = KotlinVersion.KOTLIN_2_2
		languageVersion = apiVersion
	}
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
		gradleVersion = "9.4.0"
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
