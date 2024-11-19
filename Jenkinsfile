pipeline {
    agent any
    environment {
        ANDROID_HOME = 'libs.versions.toml'  // Ensure this matches the path set in Jenkins
        PATH = "${env.ANDROID_HOME}/tools:${env.ANDROID_HOME}/platform-tools:${env.PATH}"
    }
    stages {
        stage('Clone Repository') {
            steps {
                // Clone the GitHub repository using PAT
                git branch: 'main', credentialsId: 'github-pat', url: 'https://github.com/lisadhooghe1/android.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                // Ensure Gradle wrapper has execution permissions
                sh './gradlew --version'
            }
        }
        stage('Build APK') {
            steps {
                // Build the app
                sh './gradlew assembleDebug'
            }
        }
        stage('Archive APK') {
            steps {
                // Archive the APK as a build artifact
                archiveArtifacts artifacts: '**/app/build/outputs/apk/debug/*.apk', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            // Clean workspace after build
            cleanWs()
        }
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed. Check logs for details.'
        }
    }
}
