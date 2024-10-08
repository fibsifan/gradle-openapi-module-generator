pluginManagement {
	includeBuild("../gradle-openapi-module-generator-plugin")
}

plugins {
	id("openapi-module-generator")
}

openApiModules {
	include("petstore") {
		specFile.set(file("petstore.yaml"))
	}
}
