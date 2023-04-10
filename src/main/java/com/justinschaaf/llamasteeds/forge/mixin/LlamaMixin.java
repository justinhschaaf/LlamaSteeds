package com.justinschaaf.llamasteeds.forge.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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

    /**
     * ...and I set forth on my journey
     *
     * @note The "canBeControlledByRider" method was removed in 1.19. This
     *      replaces it going forward.
     * @return Tells steering controls there is an entity on the llama that can
     *      control it instead of the Llama class lying saying there's nobody.
     * @reason So llamas can be controlled
     * @author justinhschaaf
     */
    @Overwrite
    public LivingEntity getControllingPassenger() {

        Llama llama = (Llama) (Object) this;

        if (llama.isSaddled()) {

            Entity rider = llama.getFirstPassenger();

            if (rider instanceof LivingEntity)
                return (LivingEntity) rider;

        }

        return null;

    }

}
