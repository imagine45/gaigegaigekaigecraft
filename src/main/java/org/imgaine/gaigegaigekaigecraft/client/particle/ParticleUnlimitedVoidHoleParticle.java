package org.imgaine.gaigegaigekaigecraft.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ParticleUnlimitedVoidHoleParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private float angularVelocity;
   private float angularAcceleration;

   public static ParticleUnlimitedVoidHoleParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleUnlimitedVoidHoleParticleProvider(spriteSet);
   }

   protected ParticleUnlimitedVoidHoleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.setSize(16.0F, 16.0F);
      this.quadSize = 7.0F;
      this.lifetime = 10;
      this.gravity = 0.0F;
      this.hasPhysics = false;
      this.xd = vx * 0.0;
      this.yd = vy * 0.0;
      this.zd = vz * 0.0;
      this.angularVelocity = 0.03F;
      this.angularAcceleration = 0.0F;
      this.setSpriteFromAge(spriteSet);
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   public void tick() {
      super.tick();
      this.oRoll = this.roll;
      this.roll += this.angularVelocity;
      this.angularVelocity += this.angularAcceleration;
      if (!this.removed) {
         this.setSprite(this.spriteSet.get(this.age / 1 % 1 + 1, 1));
      }

   }

   public static class ParticleUnlimitedVoidHoleParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleUnlimitedVoidHoleParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new ParticleUnlimitedVoidHoleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}
