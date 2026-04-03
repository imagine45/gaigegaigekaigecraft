package org.imgaine.gaigegaigekaigecraft.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY;
   public static final RegistryObject<SoundEvent> GUARD;
   public static final RegistryObject<SoundEvent> SWORD_SWEEP;
   public static final RegistryObject<SoundEvent> FLAME_EXPLODE;
   public static final RegistryObject<SoundEvent> PUNCH;
   public static final RegistryObject<SoundEvent> WIND_CHIME;
   public static final RegistryObject<SoundEvent> SLOW_MOTION_END;
   public static final RegistryObject<SoundEvent> PIANO_HORROR;
   public static final RegistryObject<SoundEvent> TINNITUS;
   public static final RegistryObject<SoundEvent> ELECTRIC_SHOCK;
   public static final RegistryObject<SoundEvent> GUARD_JUST;
   public static final RegistryObject<SoundEvent> FRAME_SET;
   public static final RegistryObject<SoundEvent> STONE_CRASH;
   public static final RegistryObject<SoundEvent> GLASS_CRASH;
   public static final RegistryObject<SoundEvent> GACON;
   public static final RegistryObject<SoundEvent> SCHOOL_BELL;
   public static final RegistryObject<SoundEvent> DEVIL_LAUGH;
   public static final RegistryObject<SoundEvent> STRONG_HIT;
   public static final RegistryObject<SoundEvent> CLAP;
   public static final RegistryObject<SoundEvent> CRUSH;
   public static final RegistryObject<SoundEvent> GUARD_SWORD;
   public static final RegistryObject<SoundEvent> ICE_GENERATE;
   public static final RegistryObject<SoundEvent> HAKARI1;
   public static final RegistryObject<SoundEvent> GAVEL;
   public static final RegistryObject<SoundEvent> CRITICAL;
   public static final RegistryObject<SoundEvent> THUNDER_IMPACT;
   public static final RegistryObject<SoundEvent> GRAVITY;
   public static final RegistryObject<SoundEvent> WATER_SPLASH;

   public JujutsucraftModSounds() {
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "gaigegaigekaigecraft");
      GUARD = REGISTRY.register("guard", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "guard")));
      SWORD_SWEEP = REGISTRY.register("sword_sweep", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "sword_sweep")));
      FLAME_EXPLODE = REGISTRY.register("flame_explode", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "flame_explode")));
      PUNCH = REGISTRY.register("punch", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "punch")));
      WIND_CHIME = REGISTRY.register("wind_chime", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "wind_chime")));
      SLOW_MOTION_END = REGISTRY.register("slow_motion_end", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "slow_motion_end")));
      PIANO_HORROR = REGISTRY.register("piano_horror", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "piano_horror")));
      TINNITUS = REGISTRY.register("tinnitus", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "tinnitus")));
      ELECTRIC_SHOCK = REGISTRY.register("electric_shock", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "electric_shock")));
      GUARD_JUST = REGISTRY.register("guard_just", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "guard_just")));
      FRAME_SET = REGISTRY.register("frame_set", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "frame_set")));
      STONE_CRASH = REGISTRY.register("stone_crash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "stone_crash")));
      GLASS_CRASH = REGISTRY.register("glass_crash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "glass_crash")));
      GACON = REGISTRY.register("gacon", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "gacon")));
      SCHOOL_BELL = REGISTRY.register("school_bell", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "school_bell")));
      DEVIL_LAUGH = REGISTRY.register("devil_laugh", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "devil_laugh")));
      STRONG_HIT = REGISTRY.register("strong_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "strong_hit")));
      CLAP = REGISTRY.register("clap", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "clap")));
      CRUSH = REGISTRY.register("crush", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "crush")));
      GUARD_SWORD = REGISTRY.register("guard_sword", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "guard_sword")));
      ICE_GENERATE = REGISTRY.register("ice_generate", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "ice_generate")));
      HAKARI1 = REGISTRY.register("hakari1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "hakari1")));
      GAVEL = REGISTRY.register("gavel", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "gavel")));
      CRITICAL = REGISTRY.register("critical", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "critical")));
      THUNDER_IMPACT = REGISTRY.register("thunder_impact", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "thunder_impact")));
      GRAVITY = REGISTRY.register("gravity", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "gravity")));
      WATER_SPLASH = REGISTRY.register("water_splash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gaigegaigekaigecraft", "water_splash")));
   }
}
