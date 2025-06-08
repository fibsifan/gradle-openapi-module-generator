package de.jball.gradle.openapi

import org.gradle.api.Action
import org.gradle.api.initialization.Settings
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.Input
import javax.inject.Inject

abstract class OpenApiModulesExtension @Inject constructor(
	private val objects: ObjectFactory, settings: Settings) {

	@Input
	val modulesDir = objects.directoryProperty()
		.convention(settings.layout.settingsDirectory.dir("openapi-modules"))

	internal val modules = mutableListOf<OpenApiModuleSpec>()

	fun module(name: String, configure: Action<OpenApiModuleSpec>) {
		val moduleSpec = objects.newInstance(OpenApiModuleSpec::class.java).apply {
			this.name = name
			applyConventions(modulesDir)
		}

		configure.execute(moduleSpec)
		modules.add(moduleSpec)
	}
}
