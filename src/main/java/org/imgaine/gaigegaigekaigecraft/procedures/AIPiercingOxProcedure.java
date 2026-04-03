package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPiercingOxProcedure {
   public AIPiercingOxProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double rnd = 0.0;
         double NUM1 = 0.0;
         double distance = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double entity_size = 0.0;
         if (entity.isAlive()) {
            double var10001;
            label88: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)(6L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label88;
                  }
               }

               var10001 = 0.0;
            }

            label83: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               NUM3 = -60.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label83;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label78: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label78;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               AttackPiecingOxProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var49;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.getTarget();
               } else {
                  var49 = null;
               }

               if (var49 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", NUM3 + (double)Math.round(NUM3 / 2.0 * Math.random()));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().putDouble("skill", 1.0);
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               }

               entity.getPersistentData().putDouble("cnt_breath", entity.getPersistentData().getDouble("cnt_breath") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_breath") > 40.0) {
                  if (entity.getPersistentData().getDouble("cnt_breath") == 41.0 && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                     }
                  }

                  if (Math.random() < 0.75) {
                     entity_size = ReturnEntitySizeProcedure.execute(entity);
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     pitch = Math.toRadians((double)entity.getXRot());
                     distance = 0.8 * (double)entity.getBbWidth();
                     x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(1.0 * entity_size), (double)entity.getBbWidth() * 0.1, (double)entity.getBbHeight() * 0.1, (double)entity.getBbWidth() * 0.1, 0.05);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt_breath") > 60.0) {
                     entity.getPersistentData().putDouble("cnt_breath", 0.0);
                  }
               }
            }
         }

      }
   }
}
