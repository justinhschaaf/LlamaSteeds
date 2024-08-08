package com.justinschaaf.llamasteeds.neoforge;

import com.justinschaaf.llamasteeds.LlamaSteeds;
import net.neoforged.fml.common.Mod;

@Mod(LlamaSteeds.MOD_ID)
public final class LlamaSteedsNeoForge {

    public LlamaSteedsNeoForge() {
        // We have to reference this to properly instantiate the gamerule or else Java doesn't give a shit about it
        // also NeoForge will crash upon loading the world without it
        LlamaSteeds.init();
    }

}
