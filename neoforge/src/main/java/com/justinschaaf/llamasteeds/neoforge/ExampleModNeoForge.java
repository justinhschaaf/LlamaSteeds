package com.justinschaaf.llamasteeds.neoforge;

import net.neoforged.fml.common.Mod;

import com.justinschaaf.llamasteeds.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
