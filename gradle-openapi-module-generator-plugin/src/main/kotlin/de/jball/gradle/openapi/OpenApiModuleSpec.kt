package de.jball.gradle.openapi

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import java.io.File
import javax.inject.Inject

open class OpenApiModuleSpec @Inject constructor(objects: ObjectFactory) {
    var specFile: File? = null
}
