package com.justinschaaf.llamasteeds.mixins;

import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.IntegerValue.class)
public interface GameRulesIntegerValueInvoker {

    @Invoker("create")
    static GameRules.Type<GameRules.IntegerValue> create(int initial) {
        throw new AssertionError();
    }

}
