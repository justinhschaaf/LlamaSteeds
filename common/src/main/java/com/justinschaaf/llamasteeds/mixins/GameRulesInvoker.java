package com.justinschaaf.llamasteeds.mixins;

import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.class)
public interface GameRulesInvoker {

    @Invoker("register")
    static <T extends GameRules.Value<T>> GameRules.Key<T> register(
            String name,
            GameRules.Category category,
            GameRules.Type<T> type) {
        throw new AssertionError();
    }

}
