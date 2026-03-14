package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBigSmokeParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBlackFlash1Particle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBlood2Particle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBloodPurpleParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBloodRedParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBlueParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBrokenGlassParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleBrokenGlassSmallParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleClawsParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleCockroachParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleCursePowerBlueParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleCursePowerGreenParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleCursePowerOrangeParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleCursePowerPurpleParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleCursePowerRedParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleDismantleItadoriParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleFangsParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleFireSparkParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleFlameParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleFlamePurpleParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleFlowerParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleGravityParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleHollowWickerBasketParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleIceParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleLiquidMetalParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleMagmaParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleNanami1Particle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleNanami2Particle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleRedParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleShockHitParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleSlashParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleThunderBlueMiniParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleThunderBlueParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleUnlimitedVoidHoleParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleUnlimitedVoidParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleWater2Particle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleWaterNoGravityParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleWaterParticle;
import org.imgaine.gaigegaigekaigecraft.client.particle.ParticleWiFiParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftModParticles {
   public JujutsucraftModParticles() {
   }

   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), ParticleCursePowerBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), ParticleCursePowerOrangeParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), ParticleCursePowerRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), ParticleBloodRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), ParticleBloodPurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), ParticleShockHitParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), ParticleWaterParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), ParticleBlackFlash1Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), ParticleFireSparkParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FANGS.get(), ParticleFangsParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CLAWS.get(), ParticleClawsParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), ParticleThunderBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), ParticleBrokenGlassParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), ParticleWater2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_1.get(), ParticleNanami1Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), ParticleNanami2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), ParticleBrokenGlassSmallParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WI_FI.get(), ParticleWiFiParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), ParticleMagmaParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), ParticleFlowerParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME.get(), ParticleFlameParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), ParticleBigSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), ParticleCockroachParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), ParticleIceParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_HOLLOW_WICKER_BASKET.get(), ParticleHollowWickerBasketParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_2.get(), ParticleBlood2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_SLASH.get(), ParticleSlashParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID.get(), ParticleUnlimitedVoidParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID_HOLE.get(), ParticleUnlimitedVoidHoleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), ParticleCursePowerGreenParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), ParticleThunderBlueMiniParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), ParticleLiquidMetalParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_NO_GRAVITY.get(), ParticleWaterNoGravityParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_GRAVITY.get(), ParticleGravityParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), ParticleDismantleItadoriParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get(), ParticleCursePowerPurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_RED.get(), ParticleRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLUE.get(), ParticleBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME_PURPLE.get(), ParticleFlamePurpleParticle::provider);
   }
}
