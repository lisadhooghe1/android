pipeline {
    agent any
    environment {
        ANDROID_HOME = "/opt/android-sdk"
        PATH = "$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/lisadhooghe1/android.git',
                    credentialsId: 'github-credentials'
                        
            }
        }
        stage('Install Dependencies') {
            steps {
                sh '''
                # Ensure Gradle wrapper is executable
                chmod +x ./gradlew
                ./gradlew dependencies
                '''
            }
        }
        stage('Build APK') {
            steps {
                sh './gradlew assembleDebug'
            }
        }
        stage('Run Tests') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Archive APK') {
            steps {
                archiveArtifacts artifacts: '**/build/outputs/apk/debug/*.apk', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            cleanWs() // Clean workspace after execution
        }
    }
}
