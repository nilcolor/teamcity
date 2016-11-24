package _Root

import _Root.vcsRoots.*
import _Root.vcsRoots.GithubComNilcolorTeamcityGit
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "ff0d08a3-4a71-4874-b634-76c3b3b07157"
    extId = "_Root"
    name = "<Root project>"
    description = "Contains all other projects"

    vcsRoot(GithubComNilcolorTeamcityGit)

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "OAuthProvider"
            param("clientId", "9a7bb1ebe5a8ee473f5b")
            param("displayName", "GitHub.com")
            param("gitHubUrl", "https://github.com/")
            param("providerType", "GitHub")
            param("secure:clientSecret", "zxx12c42c52beec78b55ece326c571d4b283b24628435b88604159d568b8c4eecf3fe40b607073c8dfb775d03cbe80d301b")
        }
        versionedSettings {
            id = "PROJECT_EXT_3"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = GithubComNilcolorTeamcityGit.extId
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }
})
