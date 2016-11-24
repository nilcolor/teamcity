package SafeRX_SampleSubProject

import SafeRX_SampleSubProject.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project

object Project : Project({
    uuid = "7d5a9414-bcfc-495f-a224-7ac45792ee0c"
    extId = "SafeRX_SampleSubProject"
    parentId = "SafeRX"
    name = "Sample SubProject"
    description = "Sample project description"

    buildType(SafeRX_SampleSubProject_ShowCurrentPath)
})
