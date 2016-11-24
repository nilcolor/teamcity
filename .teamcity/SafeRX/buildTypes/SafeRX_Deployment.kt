package SafeRX.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.BuildFeature
import jetbrains.buildServer.configs.kotlin.v10.BuildFeature.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object SafeRX_Deployment : BuildType({
    template(SafeRX.buildTypes.SafeRX_BaseTemplate)
    uuid = "5fa96feb-0057-414f-8337-19914620520c"
    extId = "SafeRX_Deployment"
    name = "Deployment"

    artifactRules = """
        coverage/
        tmp/capybara/
    """.trimIndent()

    vcs {
        root(SafeRX.vcsRoots.SafeRX_Staging)

        checkoutMode = CheckoutMode.ON_SERVER
    }

    steps {
        script {
            name = "Deploy"
            id = "RUNNER_6"
            scriptContent = "RAILS_ENV=development bundle exec cap staging deploy"
        }
        stepsOrder = arrayListOf("RUNNER_1", "RUNNER_2", "RUNNER_3", "RUNNER_4", "RUNNER_6")
    }

    features {
        feature {
            id = "BUILD_EXT_3"
            type = "teamcity.stash.status"
            param("secure:stash_username", "zxxe835326279ef034c914e1d33e972a338")
            param("stash_failCancelledBuilds", "true")
            param("stash_host", "https://git.itransition.com")
            param("stash_only_latest", "true")
            param("stash_username", "a2.ponomarenko")
        }
    }
})
