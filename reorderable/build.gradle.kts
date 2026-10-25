import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
}

group = "sh.calvin.reorderable"
version = "3.1.0"

kotlin {
    coreLibrariesVersion = "1.9.0"

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions.languageVersion.set(KotlinVersion.KOTLIN_1_9)

    androidTarget {
        publishLibraryVariants("release")

        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.animation)
            implementation(compose.foundation)
        }
    }
}

android {
    namespace = project.group.toString()
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(
        "io.github.tulis12",
        "reorderable",
        "3.2.1-tulis.1"
    )

    pom {
        name = "Reorderable"
        description = "A fork of a library for reordering items in lazy lists and grids in Compose"
        url = "https://github.com/Tulis12/Reorderable"
        inceptionYear = "2026"

        licenses {
            license {
                name = "The Apache Software License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        scm {
            connection = "scm:git:git://github.com/Tulis12/Reorderable.git"
            url = "https://github.com/Tulis12/Reorderable"
        }

        developers {
            developer {
                name = "Tulis"
                email = "android@tulis.dev"
                url = "https://tulis.dev"
            }

            developer {
                name = "Calvin Liang"
                email = "me@calvin.sh"
                url = "https://calvin.sh"
            }
        }
    }
}
