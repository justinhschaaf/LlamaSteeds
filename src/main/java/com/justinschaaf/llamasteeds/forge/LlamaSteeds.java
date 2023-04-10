package com.justinschaaf.llamasteeds.forge;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Method;

@Mod("llamasteeds")
public class LlamaSteeds {

    // Dummy class Forge looks for when loading the mod
    // ...is what I would say if it didn't have a use now
    public static final GameRules.Key<GameRules.IntegerValue> MAX_CARAVAN_LENGTH_RULE =
            GameRules.register("maxLlamaCaravanLength", GameRules.Category.MOBS, createIntValue(10));

    private static GameRules.Type<GameRules.IntegerValue> createIntValue(int val) {

        try {
            // It's stupid that Forge doesn't have a better way of doing this, and if there is no documentation exists on it
            // I had more complaints here, but I've calmed down and decided to remove them to not be overly negative
            // Long story short this is probably the last mod I make directly using Forge, Fabric is just better in terms of friendliness
            // Credit to https://forums.minecraftforge.net/topic/80956-solved-1152-game-rule-registration/ for figuring this out
            // "m_46312_" = "create"
            Method m = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "m_46312_", int.class);
            m.setAccessible(true);
            return (GameRules.Type<GameRules.IntegerValue>) m.invoke(null, val);
        } catch (Exception e) {
            // It's volatile code so this catch block is here, but whatever...
            e.printStackTrace();
        }

        // This crashes the game, but it really should
        return null;

    }

}
