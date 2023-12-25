package com.justinschaaf.llamasteeds.forge.mixin;

import net.minecraft.world.entity.animal.horse.Llama;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Llama.class)
public class LlamaMixin {

    /**
     * I mount my steed...
     *
     * @note Now Forge wants javadocs too
     * @return Whether the llama can be saddled
     * @reason So llamas can be controlled
     * @author justinhschaaf
     */
    @Overwrite
    public boolean isSaddleable() {
        return true;
    }

    /*
     * ...and I set forth on my journey
     *
     * There was "getControllingPassenger", then "canBeControlledByRider" before
     * 1.19. As of 1.20.2, it's not overriden by the Llama class anymore and is
     * no longer needed for our use.
     */

}
