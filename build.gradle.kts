plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.vasundharainfotech"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.vasundharainfotech"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Add new

    //LifeCycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.4")


    implementation("com.squareup.retrofit2:converter-jackson:2.0.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    //Live Data
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5")

    //jetpack compose
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    //  implementation("androidx.compose.runtime:runtime-livedata:1.7.0-alpha02")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0")
    implementation("androidx.compose.runtime:runtime:1.0.0")
    // implementation "androidx.compose.runtime:runtime-livedata:$compose_version"


    implementation("androidx.compose.ui:ui:1.0.5")
    implementation("androidx.compose.material:material:1.0.5")
    implementation("androidx.activity:activity-compose:1.3.1")

    //compile ‘com.github.bumptech.glide:glide:3.5.2’
    implementation ("com.github.bumptech.glide:glide:4.16.0")


}