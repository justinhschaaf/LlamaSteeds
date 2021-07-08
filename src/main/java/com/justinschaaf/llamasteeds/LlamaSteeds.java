package com.justinschaaf.llamasteeds;

import net.minecraft.entity.passive.EntityChicken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityChicken.class)
public class chickenSteeds {

    /**
     * I mount my steed...
     *
     * @note Stupid stuff required by Gradle to build the jar. WHY?
     * @return Whether or not the llama can be saddled
     * @reason So llamas can be controlled
     * @author justinhschaaf
     */
    @Overwrite
    public boolean canBeSaddled() {
        return true;
    }

    /**
     * ...and I set forth on my journey
     *
     * @note Stupid stuff required by Gradle to build the jar. WHY?
     * @return Whether or not the llama can be controlled by the rider
     * @reason So llamas can be controlled
     * @author justinhschaaf
     */
    @Overwrite
    public boolean canBeControlledByRider() {
        return true;
    }

}
