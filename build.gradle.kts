
plugins {
    kotlin("multiplatform") version "1.9.24"
    id("org.jetbrains.compose") version "1.6.11"
}

group = "me.kashy"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(17)
        withJava()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material) //  for Text/Button (material)
                implementation(compose.materialIconsExtended)

            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs) //  required to run desktop demo
            }
        }

        val jvmTest by getting
    }
}







