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

   public JujutsucraftModSounds() {
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "jujutsucraft");
      GUARD = REGISTRY.register("guard", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "guard")));
      SWORD_SWEEP = REGISTRY.register("sword_sweep", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "sword_sweep")));
      FLAME_EXPLODE = REGISTRY.register("flame_explode", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "flame_explode")));
      PUNCH = REGISTRY.register("punch", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "punch")));
      WIND_CHIME = REGISTRY.register("wind_chime", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "wind_chime")));
      SLOW_MOTION_END = REGISTRY.register("slow_motion_end", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "slow_motion_end")));
      PIANO_HORROR = REGISTRY.register("piano_horror", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "piano_horror")));
      TINNITUS = REGISTRY.register("tinnitus", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "tinnitus")));
      ELECTRIC_SHOCK = REGISTRY.register("electric_shock", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "electric_shock")));
      GUARD_JUST = REGISTRY.register("guard_just", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "guard_just")));
      FRAME_SET = REGISTRY.register("frame_set", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "frame_set")));
      STONE_CRASH = REGISTRY.register("stone_crash", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "stone_crash")));
      GLASS_CRASH = REGISTRY.register("glass_crash", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "glass_crash")));
      GACON = REGISTRY.register("gacon", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "gacon")));
      SCHOOL_BELL = REGISTRY.register("school_bell", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "school_bell")));
      DEVIL_LAUGH = REGISTRY.register("devil_laugh", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "devil_laugh")));
      STRONG_HIT = REGISTRY.register("strong_hit", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "strong_hit")));
      CLAP = REGISTRY.register("clap", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "clap")));
      CRUSH = REGISTRY.register("crush", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "crush")));
      GUARD_SWORD = REGISTRY.register("guard_sword", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "guard_sword")));
      ICE_GENERATE = REGISTRY.register("ice_generate", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "ice_generate")));
      HAKARI1 = REGISTRY.register("hakari1", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "hakari1")));
      GAVEL = REGISTRY.register("gavel", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "gavel")));
      CRITICAL = REGISTRY.register("critical", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "critical")));
      THUNDER_IMPACT = REGISTRY.register("thunder_impact", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "thunder_impact")));
      GRAVITY = REGISTRY.register("gravity", () -> SoundEvent.m_262824_(new ResourceLocation("jujutsucraft", "gravity")));
   }
}
