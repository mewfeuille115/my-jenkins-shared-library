/**
 * buildJava.groovy
 * Compila un proyecto Java usando Maven en un agente Docker.
 *
 * Uso en Jenkinsfile:
 *   buildJava()
 *   buildJava(mavenVersion: '3.9.4-eclipse-temurin-17')
 */
def call(Map config = [:]) {

    // Parámetros con valores por defecto
    String mavenImage = config.get('mavenVersion', '3.9.4-eclipse-temurin-17')

    echo "🔨 [buildJava] Iniciando compilación con imagen Maven: maven:${mavenImage}"

    // El agente Docker se define en el Jenkinsfile principal,
    // aquí solo ejecutamos los comandos de compilación
    sh '''
        echo "=== Información del entorno ==="
        java -version
        mvn -version
        echo "================================"
    '''

    sh 'mvn clean compile -B -q'

    echo "✅ [buildJava] Compilación exitosa"
}
