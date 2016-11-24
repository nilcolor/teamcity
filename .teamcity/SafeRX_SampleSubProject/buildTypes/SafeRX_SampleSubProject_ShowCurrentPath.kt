package SafeRX_SampleSubProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object SafeRX_SampleSubProject_ShowCurrentPath : BuildType({
    uuid = "ad3b6ac2-1952-4fbb-8a58-b882bba457df"
    extId = "SafeRX_SampleSubProject_ShowCurrentPath"
    name = "Show current path"
    description = "Sample build step to display current path"

    steps {
        script {
            name = "Current path"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            workingDir = "/tmp"
            scriptContent = """/bin/sh -c "ls -al""""
        }
    }
})
