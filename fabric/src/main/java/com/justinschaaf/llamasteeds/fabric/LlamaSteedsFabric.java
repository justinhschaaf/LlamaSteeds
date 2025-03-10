package com.justinschaaf.llamasteeds.fabric;

import com.justinschaaf.llamasteeds.fabriclike.LlamaSteedsFabricLike;
import net.fabricmc.api.ModInitializer;

public final class LlamaSteedsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run the Fabric-like setup.
        LlamaSteedsFabricLike.init();
    }

}
