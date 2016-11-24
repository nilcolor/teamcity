package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object GithubComNilcolorTeamcityGit : GitVcsRoot({
    uuid = "253cbb8e-721e-44be-b97e-5dc45eae30d6"
    extId = "GithubComNilcolorTeamcityGit"
    name = "github.com/nilcolor/teamcity.git"
    url = "git@github.com:nilcolor/teamcity.git"
    authMethod = uploadedKey {
        uploadedKey = "Sample key for GH _-_ TeamCity"
    }
})
