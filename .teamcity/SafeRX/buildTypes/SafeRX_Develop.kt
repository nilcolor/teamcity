package SafeRX.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.BuildFeature
import jetbrains.buildServer.configs.kotlin.v10.BuildFeature.*

object SafeRX_Develop : BuildType({
    template(SafeRX.buildTypes.SafeRX_BaseTemplate)
    uuid = "dbdf770e-85d8-4775-828d-09c6dcf7c1e0"
    extId = "SafeRX_Develop"
    name = "Develop"

    artifactRules = """
        coverage/
        tmp/capybara/
    """.trimIndent()

    vcs {
        root(SafeRX.vcsRoots.Vcs_SafeRX_Develop)

        checkoutMode = CheckoutMode.ON_SERVER
    }

    features {
        feature {
            id = "BUILD_EXT_3"
            type = "teamcity.stash.status"
            param("secure:stash_username", "zxxe835326279ef034c132f1098fbbf040b")
            param("stash_failCancelledBuilds", "true")
            param("stash_host", "https://git.itransition.com")
            param("stash_only_latest", "true")
            param("stash_username", "a2.ponomarenko")
        }
        feature {
            id = "BUILD_EXT_4"
            type = "xml-report-plugin"
            param("xmlReportParsing.reportDirs", "coverage/rubocop.xml")
            param("xmlReportParsing.reportType", "checkstyle")
        }
    }
})
