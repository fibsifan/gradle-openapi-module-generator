package de.jball.gradle.openapi

import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty

interface OpenApiModuleSpec {
	val specFile: RegularFileProperty

	val outputDirectory: DirectoryProperty
}
