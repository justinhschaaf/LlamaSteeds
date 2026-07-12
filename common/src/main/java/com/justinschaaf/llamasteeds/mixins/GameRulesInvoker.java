package com.justinschaaf.llamasteeds.mixins;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.class)
public interface GameRulesInvoker {

    @Invoker("registerInteger")
    static GameRule<Integer> registerInteger(
            String name,
            GameRuleCategory category,
            int defaultValue,
            int minValue) {
        throw new AssertionError();
    }

}
