package com.justinschaaf.llamasteeds.forge.mixin;

import net.minecraft.entity.passive.horse.LlamaEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LlamaEntity.class)
public class LlamaEntityMixin {

    // Lets llamas be saddled
    @Overwrite
    public boolean func_230264_L__() {
        return true;
    }

    // Lets llamas be steered when saddled
    @Overwrite
    public boolean canBeSteered() {
        return true;
    }

}
