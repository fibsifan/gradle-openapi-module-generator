pluginManagement {
	includeBuild("gradle-openapi-module-generator-plugin")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
	id("openapi-module-generator")
}

rootProject.name = "openapi-module-generator"

include("gradle-openapi-module-generator-test")

openApiModules {
	module("petstore") {
		group = "org.example"
		version = "1.0.0"
		specFile = file("gradle-openapi-module-generator-test/petstore.yaml")
	}
}
