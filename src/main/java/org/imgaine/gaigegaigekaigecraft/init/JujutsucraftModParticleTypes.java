package org.imgaine.gaigegaigekaigecraft.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftModParticleTypes {
   public static final DeferredRegister<ParticleType<?>> REGISTRY;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_BLUE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_ORANGE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BLOOD_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BLOOD_PURPLE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_SHOCK_HIT;
   public static final RegistryObject<SimpleParticleType> PARTICLE_WATER;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BLACK_FLASH_1;
   public static final RegistryObject<SimpleParticleType> PARTICLE_FIRE_SPARK;
   public static final RegistryObject<SimpleParticleType> PARTICLE_FANGS;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CLAWS;
   public static final RegistryObject<SimpleParticleType> PARTICLE_THUNDER_BLUE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BROKEN_GLASS;
   public static final RegistryObject<SimpleParticleType> PARTICLE_WATER_2;
   public static final RegistryObject<SimpleParticleType> PARTICLE_NANAMI_1;
   public static final RegistryObject<SimpleParticleType> PARTICLE_NANAMI_2;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BROKEN_GLASS_SMALL;
   public static final RegistryObject<SimpleParticleType> PARTICLE_WI_FI;
   public static final RegistryObject<SimpleParticleType> PARTICLE_MAGMA;
   public static final RegistryObject<SimpleParticleType> PARTICLE_FLOWER;
   public static final RegistryObject<SimpleParticleType> PARTICLE_FLAME;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BIG_SMOKE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_COCKROACH;
   public static final RegistryObject<SimpleParticleType> PARTICLE_ICE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_HOLLOW_WICKER_BASKET;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BLOOD_2;
   public static final RegistryObject<SimpleParticleType> PARTICLE_SLASH;
   public static final RegistryObject<SimpleParticleType> PARTICLE_UNLIMITED_VOID;
   public static final RegistryObject<SimpleParticleType> PARTICLE_UNLIMITED_VOID_HOLE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_GREEN;
   public static final RegistryObject<SimpleParticleType> PARTICLE_THUNDER_BLUE_MINI;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIQUID_METAL;
   public static final RegistryObject<SimpleParticleType> PARTICLE_WATER_NO_GRAVITY;
   public static final RegistryObject<SimpleParticleType> PARTICLE_GRAVITY;
   public static final RegistryObject<SimpleParticleType> PARTICLE_DISMANTLE_ITADORI;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_PURPLE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BLUE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_FLAME_PURPLE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_SLASH_LARGE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_WHITE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_THUNDER_PURPLE;

   public JujutsucraftModParticleTypes() {
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "gaigegaigekaigecraft");
      PARTICLE_CURSE_POWER_BLUE = REGISTRY.register("particle_curse_power_blue", () -> new SimpleParticleType(true));
      PARTICLE_CURSE_POWER_ORANGE = REGISTRY.register("particle_curse_power_orange", () -> new SimpleParticleType(true));
      PARTICLE_CURSE_POWER_RED = REGISTRY.register("particle_curse_power_red", () -> new SimpleParticleType(true));
      PARTICLE_BLOOD_RED = REGISTRY.register("particle_blood_red", () -> new SimpleParticleType(false));
      PARTICLE_BLOOD_PURPLE = REGISTRY.register("particle_blood_purple", () -> new SimpleParticleType(false));
      PARTICLE_SHOCK_HIT = REGISTRY.register("particle_shock_hit", () -> new SimpleParticleType(true));
      PARTICLE_WATER = REGISTRY.register("particle_water", () -> new SimpleParticleType(true));
      PARTICLE_BLACK_FLASH_1 = REGISTRY.register("particle_black_flash_1", () -> new SimpleParticleType(true));
      PARTICLE_FIRE_SPARK = REGISTRY.register("particle_fire_spark", () -> new SimpleParticleType(false));
      PARTICLE_FANGS = REGISTRY.register("particle_fangs", () -> new SimpleParticleType(true));
      PARTICLE_CLAWS = REGISTRY.register("particle_claws", () -> new SimpleParticleType(true));
      PARTICLE_THUNDER_BLUE = REGISTRY.register("particle_thunder_blue", () -> new SimpleParticleType(true));
      PARTICLE_BROKEN_GLASS = REGISTRY.register("particle_broken_glass", () -> new SimpleParticleType(false));
      PARTICLE_WATER_2 = REGISTRY.register("particle_water_2", () -> new SimpleParticleType(true));
      PARTICLE_NANAMI_1 = REGISTRY.register("particle_nanami_1", () -> new SimpleParticleType(true));
      PARTICLE_NANAMI_2 = REGISTRY.register("particle_nanami_2", () -> new SimpleParticleType(true));
      PARTICLE_BROKEN_GLASS_SMALL = REGISTRY.register("particle_broken_glass_small", () -> new SimpleParticleType(false));
      PARTICLE_WI_FI = REGISTRY.register("particle_wi_fi", () -> new SimpleParticleType(true));
      PARTICLE_MAGMA = REGISTRY.register("particle_magma", () -> new SimpleParticleType(true));
      PARTICLE_FLOWER = REGISTRY.register("particle_flower", () -> new SimpleParticleType(true));
      PARTICLE_FLAME = REGISTRY.register("particle_flame", () -> new SimpleParticleType(true));
      PARTICLE_BIG_SMOKE = REGISTRY.register("particle_big_smoke", () -> new SimpleParticleType(true));
      PARTICLE_COCKROACH = REGISTRY.register("particle_cockroach", () -> new SimpleParticleType(true));
      PARTICLE_ICE = REGISTRY.register("particle_ice", () -> new SimpleParticleType(true));
      PARTICLE_HOLLOW_WICKER_BASKET = REGISTRY.register("particle_hollow_wicker_basket", () -> new SimpleParticleType(false));
      PARTICLE_BLOOD_2 = REGISTRY.register("particle_blood_2", () -> new SimpleParticleType(true));
      PARTICLE_SLASH = REGISTRY.register("particle_slash", () -> new SimpleParticleType(false));
      PARTICLE_UNLIMITED_VOID = REGISTRY.register("particle_unlimited_void", () -> new SimpleParticleType(true));
      PARTICLE_UNLIMITED_VOID_HOLE = REGISTRY.register("particle_unlimited_void_hole", () -> new SimpleParticleType(true));
      PARTICLE_CURSE_POWER_GREEN = REGISTRY.register("particle_curse_power_green", () -> new SimpleParticleType(false));
      PARTICLE_THUNDER_BLUE_MINI = REGISTRY.register("particle_thunder_blue_mini", () -> new SimpleParticleType(true));
      PARTICLE_LIQUID_METAL = REGISTRY.register("particle_liquid_metal", () -> new SimpleParticleType(false));
      PARTICLE_WATER_NO_GRAVITY = REGISTRY.register("particle_water_no_gravity", () -> new SimpleParticleType(true));
      PARTICLE_GRAVITY = REGISTRY.register("particle_gravity", () -> new SimpleParticleType(true));
      PARTICLE_DISMANTLE_ITADORI = REGISTRY.register("particle_dismantle_itadori", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_PURPLE = REGISTRY.register("particle_curse_power_purple", () -> new SimpleParticleType(true));
      PARTICLE_RED = REGISTRY.register("particle_red", () -> new SimpleParticleType(true));
      PARTICLE_BLUE = REGISTRY.register("particle_blue", () -> new SimpleParticleType(true));
      PARTICLE_FLAME_PURPLE = REGISTRY.register("particle_flame_purple", () -> new SimpleParticleType(true));
      PARTICLE_SLASH_LARGE = REGISTRY.register("particle_slash_large", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_WHITE = REGISTRY.register("particle_curse_power_white", () -> new SimpleParticleType(true));
      PARTICLE_THUNDER_PURPLE = REGISTRY.register("particle_thunder_purple", () -> new SimpleParticleType(true));
   }
}
