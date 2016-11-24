package SafeRX

import SafeRX.buildTypes.*
import SafeRX.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature.*

object Project : Project({
    uuid = "bda7f1c9-6dd5-4059-9b05-be40c9976cc0"
    extId = "SafeRX"
    parentId = "_Root"
    name = "SafeRX"

    vcsRoot(SafeRX_Staging)
    vcsRoot(Vcs_SafeRX_Develop)

    buildType(SafeRX_Deployment)
    buildType(SafeRX_Develop)

    template(SafeRX_BaseTemplate)

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "ReportTab"
            param("startPage", "index.html")
            param("title", "Coverage")
            param("type", "BuildReportTab")
        }
        feature {
            id = "PROJECT_EXT_2"
            type = "ReportTab"
            param("startPage", "rubocop.html")
            param("title", "Rubocop")
            param("type", "BuildReportTab")
        }
    }
})
