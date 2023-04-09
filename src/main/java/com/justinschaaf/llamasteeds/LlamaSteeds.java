package com.justinschaaf.llamasteeds;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.GameRules;

public class LlamaSteeds implements ModInitializer {

    /**
     * The {@link GameRules.Key} for setting the max llama caravan length.
     * This is private to prevent it from easily being set externally since it
     * isn't final like the Fabric docs recommends.
     */
    private static GameRules.Key<GameRules.IntRule> maxCaravanLengthRule = null;

    /**
     * Runs upon the mod being initialized. We only use it for registering the
     * {@link #maxCaravanLengthRule} if and only if Fabric API is present.
     */
    @Override
    public void onInitialize() {
        if (isFabricApiLoaded()) {
            maxCaravanLengthRule = GameRuleRegistry.register(
                    "maxLlamaCaravanLength",
                    GameRules.Category.MOBS,
                    GameRuleFactory.createIntRule(10, 2)
            );
        }
    }

    /**
     * Gets the {@link GameRules.Key} object for the max llama caravan length
     * @return The Gamerule Key, or null if Fabric API isn't present
     */
    public static GameRules.Key<GameRules.IntRule> getMaxCaravanLengthRule() {
        return maxCaravanLengthRule;
    }

    /**
     * Utility method to check whether Fabric API is present
     * @return true if "fabric-api" is loaded
     */
    public static boolean isFabricApiLoaded() {
        return FabricLoader.getInstance().isModLoaded("fabric-api");
    }

}
