dependencies {
    minecraft("com.mojang:minecraft:1.15.2")
    mappings("net.fabricmc:yarn:1.15.2+build.17:v2")

    modImplementation(fabricApi.module("fabric-api-base", "0.28.5+1.15"))
    modImplementation(fabricApi.module("fabric-resource-loader-v0", "0.28.5+1.15"))
    modImplementation(fabricApi.module("fabric-command-api-v1", "0.28.5+1.15"))
    modImplementation(fabricApi.module("fabric-lifecycle-events-v1", "0.28.5+1.15"))
    modImplementation("io.github.prospector:modmenu:1.10.4+build.1")
    modImplementation("io.github.cottonmc:cotton-client-commands:1.1.0+1.15.2")
}
