plugins {
    id( "com.android.application" )
    id( "org.jetbrains.kotlin.android" )
    id( "kotlin-kapt" )
    id( "androidx.navigation.safeargs.kotlin" )
}

android {
    namespace = "com.odesa.notify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.odesa.notify"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField( "boolean", "DEBUG", "true" )
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }

    dataBinding {
        enable = true
        enableForTests = true
    }
}

dependencies {

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    val roomVersion = "2.6.0"
    val lifecycleVersion = "2.6.2"
    val navigationVersion = "2.7.5"
    val espressoVersion = "3.5.1"
    val hamcrestVersion = "2.2"
    val timberVersion = "5.0.1"

    // App Dependencies.
    implementation( "androidx.core:core-ktx:1.12.0" )
    implementation( "androidx.appcompat:appcompat:1.6.1" )
    implementation( "com.google.android.material:material:1.12.0-alpha01" )
    implementation( "androidx.constraintlayout:constraintlayout:2.1.4" )
    implementation( "androidx.drawerlayout:drawerlayout:1.2.0" )
    implementation( "com.jakewharton.timber:timber:$timberVersion" )

    // Android Architecture Components
    kapt( "androidx.room:room-compiler:$roomVersion" )
    implementation( "androidx.room:room-runtime:$roomVersion" )
    implementation( "androidx.room:room-ktx:$roomVersion" )

    kapt( "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion" )
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion" )
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion" )

    implementation( "androidx.navigation:navigation-fragment-ktx:$navigationVersion" )
    implementation( "androidx.navigation:navigation-ui-ktx:$navigationVersion" )


    // Local Unit Tests Dependencies
    testImplementation( "junit:junit:4.13.2" )
    testImplementation( "org.hamcrest:hamcrest-core:$hamcrestVersion" )

    // AndroidX Test - JVM Testing

    // AndroidX Test - Instrumented Testing
    androidTestImplementation( "androidx.test.ext:junit:1.1.5" )
    androidTestImplementation( "androidx.test.espresso:espresso-core:$espressoVersion" )
    androidTestImplementation( "androidx.test.espresso:espresso-contrib:$espressoVersion" )
}