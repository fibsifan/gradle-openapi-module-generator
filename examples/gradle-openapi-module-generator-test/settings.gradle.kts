pluginManagement {
	includeBuild("gradle-openapi-module-generator-plugin")
}

plugins {
	id("openapi-module-generator")
}

openApiModules {
	module("petstore") {
		group = "org.example"
		version = "1.0.0"
		packageName = "org.example.petstore"
		specFile = file("gradle-openapi-module-generator-test/petstore.yaml")
	}
}
