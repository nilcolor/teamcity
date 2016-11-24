package SafeRX.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.BuildStep
import jetbrains.buildServer.configs.kotlin.v10.BuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ExecBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ExecBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.v10.failureConditions.BuildFailureOnMetric.*
import jetbrains.buildServer.configs.kotlin.v10.failureConditions.failOnMetricChange
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object SafeRX_BaseTemplate : Template({
    uuid = "ac0f0cc1-f775-46f5-9729-70e722f4e22f"
    extId = "SafeRX_BaseTemplate"
    name = "BaseTemplate"

    steps {
        script {
            name = "Bundle Install"
            id = "RUNNER_1"
            scriptContent = "bundle install --path ~/.gems"
        }
        script {
            name = "Configs"
            id = "RUNNER_2"
            scriptContent = """
                rm %teamcity.build.checkoutDir%/config/*.yml
                bundle exec tamplier copy
            """.trimIndent()
        }
        script {
            name = "DB prepare"
            id = "RUNNER_3"
            scriptContent = """
                bin/rails db:environment:set RAILS_ENV=test
                RAILS_ENV=test bundle exec rake db:drop db:create db:migrate
            """.trimIndent()
        }
        exec {
            name = "Rubocop"
            id = "RUNNER_4"
            path = "bundle"
            arguments = "exec bin/rubocop"
        }
        step {
            name = "Specs"
            id = "RUNNER_5"
            type = "rake-runner"
            enabled = false
            param("build-file-path", "/%teamcity.build.workingDir%/Rakefile")
            param("ui.rakeRunner.ruby.rvm.gemset.name", "saferx")
            param("ui.rakeRunner.ruby.rvm.sdk.name", "ruby-2.3.1")
        }
    }

    triggers {
        vcs {
            id = "vcsTrigger"
            perCheckinTriggering = true
        }
    }

    failureConditions {
        failOnMetricChange {
            id = "BUILD_EXT_1"
            metric = BuildFailureOnMetric.MetricType.INSPECTION_ERROR_COUNT
            threshold = 0
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
        failOnMetricChange {
            id = "BUILD_EXT_2"
            metric = BuildFailureOnMetric.MetricType.INSPECTION_WARN_COUNT
            threshold = 0
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
    }
})
