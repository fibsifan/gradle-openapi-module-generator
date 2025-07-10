plugins {
	id("com.dorongold.task-tree") version "4.0.1"
}

group = "de.jball.gradle"
version = "0.1.0-SNAPSHOT"

tasks {
	wrapper {
		gradleVersion = "8.14.3"
		distributionType = Wrapper.DistributionType.ALL
	}
}
