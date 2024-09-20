package de.jball.gradle.openapi

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class OpenApiModuleGeneratorPlugin : Plugin<Settings> {
	override fun apply(settings: Settings) {
		println("hello from OpenApiModuleGeneratorPlugin")
		println("Target: $settings")
		println("Extensions: ${settings.extensions}")
		settings.extensions.create("openApiModules", OpenApiModuleGeneratorExtension::class.java, settings)
	}
}
