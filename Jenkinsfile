pipeline {
    agent any
    environment {
        // Set the Android SDK home and add necessary directories to the PATH
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk-amd64"
        ANDROID_HOME = "/opt/android-sdk"
        PATH = "${JAVA_HOME}/bin:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:$PATH"
        GRADLE_USER_HOME = "$WORKSPACE/.gradle"  // Optional: Cache Gradle dependencies
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the GitHub repository
                git branch: 'main', url: 'https://github.com/lisadhooghe1/android.git', credentialsId: 'github-credentials'
            }
        }
        stage('Install Dependencies') {
            steps {
                // Install dependencies and ensure Gradle wrapper is executable
                sh '''
                chmod +x ./gradlew  // Make Gradle wrapper executable
                ./gradlew dependencies  // Install dependencies
                '''
            }
        }
        stage('Build APK') {
            steps {
                // Build the APK using the Gradle wrapper
                sh './gradlew assembleDebug'
            }
        }
        stage('Run Tests') {
            steps {
                // Run the tests using Gradle
                sh './gradlew test'
            }
        }
        stage('Archive APK') {
            steps {
                // Archive the generated APK for further use or download
                archiveArtifacts artifacts: '**/build/outputs/apk/debug/*.apk', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            // Clean workspace after execution
            cleanWs()
        }
    }
}

