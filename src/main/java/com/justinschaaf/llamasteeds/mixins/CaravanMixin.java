package com.justinschaaf.llamasteeds.mixins;

import com.justinschaaf.llamasteeds.LlamaSteeds;
import net.minecraft.entity.ai.goal.FormCaravanGoal;
import net.minecraft.entity.passive.LlamaEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FormCaravanGoal.class)
public class CaravanMixin {

    /**
     * This mixin exploits the {@link LlamaEntity#isLeashed()} checks in the
     * {@link FormCaravanGoal} class by redirecting all calls to said method
     * here. Instead of just checking if the llama is leashed for it to be the
     * leader of the caravan, we also allow a controlled llama to be the lead.
     *
     * @param e The LlamaEntity the {@link LlamaEntity#isLeashed()} method would
     *          normally be called on
     * @return true if the llama is leashed or being controlled
     * @author justinhschaaf
     */
    @Redirect(method = { "canStart()Z", "canFollow" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/LlamaEntity;isLeashed()Z"))
    private boolean isLeashedOrControlled(LlamaEntity e) {
        return e.isLeashed() || e.hasControllingPassenger();
    }

    /**
     * This mixin implements the {@link LlamaSteeds#getMaxCaravanLengthRule()}
     * gamerule. In the {@link FormCaravanGoal#canFollow(LlamaEntity, int)}
     * method, the game denies any new llamas from joining a caravan if there
     * are already 8 followers behind the caravan leader and the first follower.
     * This is where the 10-llama cap on caravans comes from. This modifies that
     * check by replacing it with the gamerule's value minus the two
     * aforementioned llamas.
     *
     * @param length The maximum caravan length. This is what we're modifying
     * @param e The {@link LlamaEntity} passed to the modified method, see
     *          {@link ModifyConstant} for how this works
     * @return The modified maximum caravan length
     */
    @ModifyConstant(method = "canFollow", constant = @Constant(intValue = 8))
    private int modifyCaravanLength(int length, LlamaEntity e) {
        if (LlamaSteeds.isFabricApiLoaded())
            return e.getWorld().getGameRules().getInt(LlamaSteeds.getMaxCaravanLengthRule()) - 2;
        else return length;
    }

}
