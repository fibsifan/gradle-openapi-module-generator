package de.jball.gradle.openapi

import org.gradle.api.Action
import org.gradle.api.file.BuildLayout
import org.gradle.api.initialization.Settings
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.Input
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.config.CodegenConfigurator
import javax.inject.Inject

abstract class OpenApiModulesExtension @Inject constructor(
	private val objects: ObjectFactory, private val settings: Settings) {

	@Input
	val modulesDir = objects.directoryProperty()
		.convention(settings.layout.settingsDirectory.dir("openapi-modules"))

	fun include(name: String, spec: Action<OpenApiModuleSpec>) {
		val moduleSpec = objects.newInstance(OpenApiModuleSpec::class.java)
		moduleSpec.outputDirectory.convention(modulesDir.dir(name))
		spec.execute(moduleSpec)

		val configurator = CodegenConfigurator()
		configurator.setInputSpec(moduleSpec.specFile.get().toString())
		configurator.setOutputDir(moduleSpec.outputDirectory.get().toString())
		configurator.setGeneratorName("kotlin")
		configurator.addAdditionalProperty("omitGradleWrapper", true)

		DefaultGenerator().opts(configurator.toClientOptInput()).generate()

		settings.include(name)
		settings.project(":$name").projectDir = moduleSpec.outputDirectory.get().asFile
	}
}
