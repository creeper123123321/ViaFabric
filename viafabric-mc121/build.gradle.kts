dependencies {
    minecraft("com.mojang:minecraft:1.21")
    mappings("net.fabricmc:yarn:1.21+build.2:v2")

    modImplementation("net.fabricmc.fabric-api:fabric-api:0.100.1+1.21")
    modImplementation("com.terraformersmc:modmenu:11.0.0-rc.4")
}

tasks.compileJava {
    options.release.set(21)
}
