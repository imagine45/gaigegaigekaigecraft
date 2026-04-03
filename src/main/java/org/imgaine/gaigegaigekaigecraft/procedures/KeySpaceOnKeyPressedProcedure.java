package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class KeySpaceOnKeyPressedProcedure {
   public KeySpaceOnKeyPressedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         entity.getPersistentData().putBoolean("PRESS_SPACE", true);
         if (!entity.onGround() && entity instanceof LivingEntity) {
            LivingEntity _livEnt2 = (LivingEntity)entity;
            if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()) && (!(entity instanceof Player) || !InlineMethodHandler.checkGamemodeCreative(entity) && !InlineMethodHandler.checkGamemodeSpectator(entity))) {
               double var10000;
               label102: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                        var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()).getAmplifier();
                        break label102;
                     }
                  }

                  var10000 = 0.0;
               }

               label97: {
                  NUM1 = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                        var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()).getDuration();
                        break label97;
                     }
                  }

                  var10000 = 0.0;
               }

               NUM2 = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
               }

               if (NUM1 >= 1.0 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), (int)NUM2, (int)(NUM1 - 1.0), false, false));
                  }
               }

               label117: {
                  speed = 1.0;
                  if (!entity.getPersistentData().getBoolean("PRESS_W") && !entity.getPersistentData().getBoolean("PRESS_S")) {
                     LivingEntity var39;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var39 = _mobEnt.getTarget();
                     } else {
                        var39 = null;
                     }

                     if (!(var39 instanceof LivingEntity)) {
                        x_power = entity.getDeltaMovement().x();
                        y_power = entity.getDeltaMovement().y() + 1.0 * speed;
                        z_power = entity.getDeltaMovement().z();
                        break label117;
                     }
                  }

                  x_power = entity.getDeltaMovement().x() + entity.getLookAngle().x * speed * (double)(entity.getPersistentData().getBoolean("PRESS_S") ? -1 : 1);
                  y_power = entity.getDeltaMovement().y() + entity.getLookAngle().y * speed;
                  z_power = entity.getDeltaMovement().z() + entity.getLookAngle().z * speed * (double)(entity.getPersistentData().getBoolean("PRESS_S") ? -1 : 1);
               }

               x_power = x_power < 0.0 ? Math.min(entity.getDeltaMovement().x(), Math.max(x_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().x(), Math.min(x_power, speed * 1.0));
               y_power = y_power < 0.0 ? Math.min(entity.getDeltaMovement().y(), Math.max(y_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().y(), Math.min(y_power, speed * 1.0));
               z_power = z_power < 0.0 ? Math.min(entity.getDeltaMovement().z(), Math.max(z_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().z(), Math.min(z_power, speed * 1.0));
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               entity.fallDistance = 0.0F;

               for(int index0 = 0; index0 < 3; ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x, y, z, 0, 0.0, 0.0, 0.0, 0.0);
               }
            }
         }

      }
   }
}
