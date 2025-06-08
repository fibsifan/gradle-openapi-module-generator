package de.jball.gradle.openapi

import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import javax.inject.Inject

abstract class OpenApiModuleSpec @Inject constructor() {
	lateinit var name: String
	abstract val specFile: RegularFileProperty
	abstract val projectDirectory: DirectoryProperty

	abstract val group: Property<String>
	abstract val artifactId: Property<String>
	abstract val version: Property<String>

	abstract val generatorName: Property<String>
	abstract val packageName: Property<String>
	abstract val apiPackage: Property<String>
	abstract val modelPackage: Property<String>
	abstract val invokerPackage: Property<String>
	abstract val library: Property<String>
	abstract val additionalProperties: MapProperty<String, Any>
	abstract val globalProperties: MapProperty<String, String>

	fun applyConventions(modulesDir: DirectoryProperty) {
		projectDirectory.convention(modulesDir.dir(name))

		artifactId.convention(name)
		version.convention("0.1.0-SNAPSHOT")

		generatorName.convention("kotlin")
		apiPackage.convention("$packageName.api")
		modelPackage.convention("$packageName.model")
		invokerPackage.convention("$packageName.invoker")
		additionalProperties.convention(mapOf("omitGradleWrapper" to "true"))
	}
}
