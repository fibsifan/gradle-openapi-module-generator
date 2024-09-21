package de.jball.gradle.openapi

import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import javax.inject.Inject

abstract class OpenApiModuleSpec @Inject constructor(objects: ObjectFactory) {
	@InputFile
	val specFile = objects.fileProperty()

	@OutputDirectory
	val outpuDirectory = objects.directoryProperty()
}
