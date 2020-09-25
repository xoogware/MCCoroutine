repositories {
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
}

dependencies {
    compileOnly("io.netty:netty-all:4.1.52.Final")
    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    compileOnly("org.jetbrains.kotlin:kotlin-reflect:1.3.72")
    compileOnly("org.spigotmc:spigot-api:1.16.3-R0.1-SNAPSHOT")
    testCompile("org.spigotmc:spigot-api:1.16.3-R0.1-SNAPSHOT")
}
