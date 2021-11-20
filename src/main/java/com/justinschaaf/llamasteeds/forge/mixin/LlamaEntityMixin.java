package com.justinschaaf.llamasteeds.forge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import net.minecraft.world.entity.animal.horse.Llama;

@Mixin(Llama.class)
public class LlamaEntityMixin {

    // Lets llamas be saddled
    @Overwrite
    public boolean isSaddleable() {
        return true;
    }

    // Lets llamas be steered when saddled
    @Overwrite
    public boolean canBeControlledByRider() {
        return true;
    }

}
