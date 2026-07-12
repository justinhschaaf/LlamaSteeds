package com.justinschaaf.llamasteeds;

import com.justinschaaf.llamasteeds.mixins.GameRulesInvoker;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;

public final class LlamaSteeds {

    /**
     * Universal Mod ID for Llama Steeds
     */
    public static final String MOD_ID = "llamasteeds";

    /**
     * The {@link GameRule} for setting the max Llama caravan length
     */
    private static GameRule<Integer> MAX_CARAVAN_LENGTH_RULE;

    /**
     * Common init method for Llama Steeds. This dummy method needs to exist for
     * Java to give a shit about this class and its static fields.
     */
    public static void init() {
        init(GameRulesInvoker.registerInteger("llamasteeds:max_llama_caravan_length", GameRuleCategory.MOBS, 10, 2));
    }

    /**
     * Common init method for Llama Steeds. This method needs to exist for
     * the gamerule to be created on NeoForge's side as they're whiny about us
     * writing to the registry via mixin.
     */
    public static void init(GameRule<Integer> maxCaravanLengthRule) {
        MAX_CARAVAN_LENGTH_RULE = maxCaravanLengthRule;
    }

    /**
     * Gets the {@link GameRule} for setting the max Llama caravan length
     * @return the {@link GameRule} for setting the max Llama caravan length
     */
    public static GameRule<Integer> getMaxCaravanLengthRule() {
        return MAX_CARAVAN_LENGTH_RULE;
    }

}
