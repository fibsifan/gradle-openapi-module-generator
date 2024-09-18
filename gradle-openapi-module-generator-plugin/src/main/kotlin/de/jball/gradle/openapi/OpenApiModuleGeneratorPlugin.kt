package de.jball.gradle.openapi

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class OpenApiModuleGeneratorPlugin : Plugin<Settings> {
	override fun apply(target: Settings) {
		println("hello from OpenApiModuleGeneratorPlugin")
		println("Target: $target")
		println("Extensions: ${target.extensions}")
	}
}
