package com.justinschaaf.llamasteeds.neoforge;

import com.justinschaaf.llamasteeds.LlamaSteeds;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRuleType;
import net.minecraft.world.level.gamerules.GameRuleTypeVisitor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(LlamaSteeds.MOD_ID)
public final class LlamaSteedsNeoForge {

    private static final DeferredRegister<GameRule<?>> GAMERULES = DeferredRegister.create(BuiltInRegistries.GAME_RULE, LlamaSteeds.MOD_ID);

    public LlamaSteedsNeoForge(IEventBus modBus) {
        // Create the gamerule to set the maximum Llama caravan length
        GameRule<Integer> maxLlamaCaravanLengthRule = new GameRule<>(
                GameRuleCategory.MOBS,
                GameRuleType.INT,
                IntegerArgumentType.integer(2, Integer.MAX_VALUE),
                GameRuleTypeVisitor::visitInteger,
                Codec.intRange(2, Integer.MAX_VALUE),
                (i) -> (i),
                10,
                FeatureFlagSet.of());

        // Register the gamerule, then register the registry
        // This MUST be done on NeoForge's end as it gets really upset when
        // registering via the Mixin, complaining that it's locked the registry.
        //
        // Duplicating code like this is more work for me.
        // https://docs.neoforged.net/docs/concepts/registries
        GAMERULES.register("max_llama_caravan_length", () -> maxLlamaCaravanLengthRule);
        GAMERULES.register(modBus);

        // We have to reference this to properly instantiate the gamerule or else Java doesn't give a shit about it
        // also NeoForge will crash upon loading the world without it
        LlamaSteeds.init(maxLlamaCaravanLengthRule);
    }

}
