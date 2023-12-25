package com.justinschaaf.llamasteeds.mixins;

import net.minecraft.entity.passive.LlamaEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LlamaEntity.class)
public class LlamaMixin {

    /**
     * I mount my steed...
     *
     * @note Gradle wants docs before it builds the jar for...some reason?
     * @return Whether the llama can be saddled
     * @reason So llamas can be controlled
     * @author justinhschaaf
     */
    @Overwrite
    public boolean canBeSaddled() {
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
