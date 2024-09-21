package de.jball.gradle.openapi

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class OpenApiModuleGeneratorPlugin : Plugin<Settings> {
	override fun apply(settings: Settings) {
		val openApiModulesExtension = settings.extensions.create("openApiModules",
			OpenApiModulesExtension::class.java, settings)
	}
}
