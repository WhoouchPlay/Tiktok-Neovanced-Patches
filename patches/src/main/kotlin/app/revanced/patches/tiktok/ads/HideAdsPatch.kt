package app.revanced.patches.tiktok.ads

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction11n
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction11x

@Suppress("unused")
val hideAdsPatch = bytecodePatch(
    name = "Hide ads",
    description = "Removes ads from the TikTok feed.",
) {
    compatibleWith("com.zhiliaoapp.musically", "com.ss.android.ugc.trill")

    val isAdFingerprint = fingerprint {
        returns("Z")
        custom { method, _ ->
            method.definingClass == "Lcom/ss/android/ugc/aweme/feed/model/Aweme;" &&
            method.name == "isAd"
        }
    }

    execute {
        val impl = isAdFingerprint.method.implementation!!

        impl.replaceInstruction(0, BuilderInstruction11n(Opcode.CONST_4, 0, 0))
        while (impl.instructions.size > 1) {
            impl.removeInstruction(1)
        }
        impl.addInstruction(BuilderInstruction11x(Opcode.RETURN, 0))
    }
}
