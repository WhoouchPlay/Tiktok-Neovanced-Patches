import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "app.neovanced"

patches {
    about {
        name = "TikTok Neovanced Patches"
        description = "Patches for TikTok - ad removal, tracking removal and more"
        source = "https://github.com/whoouchplay/Tiktok-Neovanced-Patches"
        author = "whoouchplay"
        contact = ""
        website = "https://github.com/whoouchplay/Tiktok-Neovanced-Patches"
        license = "GNU General Public License v3.0"
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xcontext-receivers"
    }
}
