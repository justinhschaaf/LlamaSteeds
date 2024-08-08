package com.justinschaaf.llamasteeds.mixins;

import com.justinschaaf.llamasteeds.LlamaSteeds;
import net.minecraft.world.entity.ai.goal.LlamaFollowCaravanGoal;
import net.minecraft.world.entity.animal.horse.Llama;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LlamaFollowCaravanGoal.class)
public class CaravanMixin {

    /**
     * This mixin exploits the {@link Llama#isLeashed()} checks in the
     * {@link LlamaFollowCaravanGoal} class by redirecting all calls to said method
     * here. Instead of just checking if the llama is leashed for it to be the
     * leader of the caravan, we also allow a controlled llama to be the lead.
     *
     * @param e The LlamaEntity the {@link Llama#isLeashed()} method would
     *          normally be called on
     * @return true if the llama is leashed or being controlled
     * @author justinhschaaf
     */
    @Redirect(method = { "canUse()Z", "firstIsLeashed" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Llama;isLeashed()Z"))
    private boolean isLeashedOrControlled(Llama e) {
        return e.isLeashed() || e.hasControllingPassenger();
    }

    /**
     * This mixin implements the {@link LlamaSteeds#MAX_CARAVAN_LENGTH_RULE}
     * gamerule. In the {@link LlamaFollowCaravanGoal#firstIsLeashed(Llama, int)}
     * method, the game denies any new llamas from joining a caravan if there
     * are already 8 followers behind the caravan leader and the first follower.
     * This is where the 10-llama cap on caravans comes from. This modifies that
     * check by replacing it with the gamerule's value minus the two
     * aforementioned llamas.
     *
     * @param length The maximum caravan length. This is what we're modifying
     * @param e The {@link Llama} passed to the modified method, see
     *          {@link ModifyConstant} for how this works
     * @return The modified maximum caravan length
     */
    @ModifyConstant(method = "firstIsLeashed", constant = @Constant(intValue = 8))
    private int modifyCaravanLength(int length, Llama e) {
        return Math.max(e.level().getGameRules().getInt(LlamaSteeds.MAX_CARAVAN_LENGTH_RULE) - 2, 0);
    }

}
