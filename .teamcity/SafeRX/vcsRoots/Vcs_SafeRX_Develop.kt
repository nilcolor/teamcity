package SafeRX.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Vcs_SafeRX_Develop : GitVcsRoot({
    uuid = "141c7a7d-8fea-46aa-850a-48434bde186a"
    extId = "SafeRX_Develop"
    name = "Develop"
    url = "ssh://git@git.itransition.com:7999/saferx/saferx.git"
    branchSpec = "+:refs/heads/*"
    agentCleanPolicy = GitVcsRoot.AgentCleanPolicy.ALWAYS
    authMethod = uploadedKey {
        uploadedKey = "Key"
    }
})
