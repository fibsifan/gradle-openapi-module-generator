package de.jball.gradle.openapi

import org.gradle.api.Plugin
import org.gradle.api.file.Directory
import org.gradle.api.initialization.Settings
import org.gradle.api.logging.Logging
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.config.CodegenConfigurator

class OpenApiModuleGeneratorPlugin : Plugin<Settings> {
	companion object {
		private val logger = Logging.getLogger(OpenApiModuleGeneratorPlugin::class.java)
	}
	override fun apply(settings: Settings) {
		val openApiModulesExtension = settings.extensions.create("openApiModules",
			OpenApiModulesExtension::class.java, settings)

		logger.lifecycle("Configuring OpenApiModules.")

		settings.gradle.settingsEvaluated {
			openApiModulesExtension.modules.forEach { module ->
				val name = module.name

				logger.lifecycle("Configuring OpenApi module {}", name)

				val projectDir = module.projectDirectory.get()

				generateCodeForModule(module, projectDir)

				settings.include(":$name")
				settings.project(":$name").projectDir = projectDir.asFile
			}
		}
	}

	private fun generateCodeForModule(module: OpenApiModuleSpec, projectDir: Directory) {
		val config = CodegenConfigurator().apply {
			setInputSpec(module.specFile.get().asFile.absolutePath)

			setArtifactId(module.artifactId.get())
			setGroupId(module.group.get())
			setArtifactVersion(module.version.get())

			setOutputDir(projectDir.asFile.absolutePath)
			setGeneratorName(module.generatorName.get())
			setApiPackage(module.apiPackage.get())
			setModelPackage(module.modelPackage.get())
			setInvokerPackage(module.invokerPackage.get())
			setAdditionalProperties(module.additionalProperties.get())
		}
		DefaultGenerator().opts(config.toClientOptInput()).generate()
	}
}
