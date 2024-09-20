package de.jball.gradle.openapi

import org.gradle.api.Action
import org.gradle.api.initialization.Settings
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class OpenApiModuleGeneratorExtension @Inject constructor(
	objects: ObjectFactory, settings: Settings) {
	fun include(name: String, spec: Action<OpenApiModuleSpec>) {
		println("Include called with name: $name and spec: $spec")
	}
}
