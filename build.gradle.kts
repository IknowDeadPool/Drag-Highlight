//plugins {
//    kotlin("multiplatform") version "1.9.0"
//}
//
//group = "me.kashy"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    mavenCentral()
//}
//
//kotlin {
//    jvm {
//        jvmToolchain(17)
//        withJava()
//        testRuns.named("test") {
//            executionTask.configure {
//                useJUnitPlatform()
//            }
//        }
//    }
//    js {
//        browser {
//            commonWebpackConfig {
//                cssSupport {
//                    enabled.set(true)
//                }
//            }
//        }
//    }
//    val hostOs = System.getProperty("os.name")
//    val isArm64 = System.getProperty("os.arch") == "aarch64"
//    val isMingwX64 = hostOs.startsWith("Windows")
//    val nativeTarget = when {
//        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
//        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
//        hostOs == "Linux" && isArm64 -> linuxArm64("native")
//        hostOs == "Linux" && !isArm64 -> linuxX64("native")
//        isMingwX64 -> mingwX64("native")
//        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
//    }
//
//
//    sourceSets {
//        val commonMain by getting
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }
//        val jvmMain by getting
//        val jvmTest by getting
//        val jsMain by getting
//        val jsTest by getting
//        val nativeMain by getting
//        val nativeTest by getting
//    }
//}


//plugins {
//    kotlin("multiplatform") version "1.9.24"
//    id("org.jetbrains.compose") version "1.6.11"
//}
//
//group = "me.kashy"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    google()
//    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//}
//
//kotlin {
//    jvm {
//        jvmToolchain(17)
//        withJava()
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(compose.runtime)
//                implementation(compose.foundation)
//                implementation(compose.ui)
//                implementation(compose.material) // ✅ needed for Text
//            }
//        }
//
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }
//
//        val jvmMain by getting {
//            dependencies {
//                implementation(compose.desktop.currentOs)
//            }
//        }
//
//        val jvmTest by getting
//    }
//}


//
//plugins {
//    kotlin("multiplatform") version "1.9.24"
//    id("org.jetbrains.compose") version "1.6.11"
//}
//
//group = "me.kashy"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    google()
//    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//}
//
//kotlin {
//    jvm {
//        jvmToolchain(17)
//        withJava()
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(compose.runtime)
//                implementation(compose.foundation)
//                implementation(compose.ui)
//            }
//        }
//
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }
//
//        val jvmMain by getting {
//            dependencies {
//                implementation(compose.material3)
//                implementation(compose.desktop.currentOs)
//            }
//        }
//
//        val jvmTest by getting
//    }
//}




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
                implementation(compose.desktop.currentOs) // ✅ required to run desktop demo
            }
        }

        val jvmTest by getting
    }
}







