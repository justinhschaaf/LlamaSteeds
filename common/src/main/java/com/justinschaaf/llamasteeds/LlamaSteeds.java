package com.justinschaaf.llamasteeds;

import com.justinschaaf.llamasteeds.mixins.GameRulesIntegerValueInvoker;
import com.justinschaaf.llamasteeds.mixins.GameRulesInvoker;
import net.minecraft.world.level.GameRules;

public final class LlamaSteeds {

    /**
     * Universal Mod ID for Llama Steeds
     */
    public static final String MOD_ID = "llamasteeds";

    /**
     * The {@link GameRules} for setting the max Llama caravan length
     */
    public static final GameRules.Key<GameRules.IntegerValue> MAX_CARAVAN_LENGTH_RULE =
            GameRulesInvoker.register(
                    "maxLlamaCaravanLength",
                    GameRules.Category.MOBS,
                    GameRulesIntegerValueInvoker.create(10));

    /**
     * Common init method for Llama Steeds. This dummy method needs to exist for
     * Java to give a shit about this class and its static fields.
     */
    public static void init() {}

}
