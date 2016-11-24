package SafeRX.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object SafeRX_Staging : GitVcsRoot({
    uuid = "3cabf16c-fd91-4834-8a5f-71cd8c3b5ec1"
    extId = "SafeRX_Staging"
    name = "Staging"
    url = "ssh://git@git.itransition.com:7999/saferx/saferx.git"
    branchSpec = "+:refs/heads/master"
    agentCleanPolicy = GitVcsRoot.AgentCleanPolicy.ALWAYS
    authMethod = uploadedKey {
        uploadedKey = "Key"
    }
})
