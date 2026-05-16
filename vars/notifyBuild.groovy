/**
 * notifyBuild.groovy
 * Notifica el estado de un build de forma estandarizada.
 *
 * Uso en Jenkinsfile:
 *   notifyBuild('SUCCESS')
 *   notifyBuild('FAILURE')
 */
def call(String buildStatus) {

    // Normalizar el estado
    buildStatus = buildStatus ?: 'UNKNOWN'

    String emoji
    String color

    switch (buildStatus) {
        case 'SUCCESS':
            emoji = '✅'
            color = 'GREEN'
            break
        case 'FAILURE':
            emoji = '❌'
            color = 'RED'
            break
        case 'UNSTABLE':
            emoji = '⚠️'
            color = 'YELLOW'
            break
        default:
            emoji = 'ℹ️'
            color = 'BLUE'
    }

    echo """
    ╔══════════════════════════════════════╗
    ║  ${emoji} BUILD ${buildStatus}
    ║  Proyecto : ${env.JOB_NAME}
    ║  Build #  : ${env.BUILD_NUMBER}
    ║  Color    : ${color}
    ╚══════════════════════════════════════╝
    """
}
