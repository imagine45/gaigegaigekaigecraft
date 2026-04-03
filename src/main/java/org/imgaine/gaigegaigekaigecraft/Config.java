package org.imgaine.gaigegaigekaigecraft;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig.Type;

@EventBusSubscriber
public class Config {
    public static final ForgeConfigSpec.BooleanValue forceRandomCursedTechnique;
    public static final ForgeConfigSpec.BooleanValue doVanillaMobSpawning;
    public static final ForgeConfigSpec SPEC;

    public Config() {
    }

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("General settings").push("general");
        forceRandomCursedTechnique = builder.define("forceRandomCursedTechnique", false);
        doVanillaMobSpawning = builder.define("doVanillaMobSpawning", false);
        builder.pop();
        SPEC = builder.build();
        ModLoadingContext.get().registerConfig(Type.COMMON, SPEC, "gaigegaigekaigecraft.toml");
    }
}
