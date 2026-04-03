package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AITamamonoMaeProcedure {
   public AITamamonoMaeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean tamamo_no_mae = false;
         double rnd = 0.0;
         double tick = 0.0;
         double lv = 0.0;
         double distance = 0.0;
         double skill_num = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         if (entity.isAlive()) {
            label118: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label118;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 13, false, false));
                  }
               }
            }

            label113: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label113;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")) && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num") && entity_a.getPersistentData().getDouble("skill") == 1815.0) {
                  yaw = Math.toRadians((double)(entity_a.getYRot() + 45.0F));
                  pitch = 0.0;
                  distance = (double)(5.0F + entity_a.getBbWidth());
                  entity.teleportTo(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * distance, entity_a.getY() + (double)entity_a.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * distance, entity_a.getY() + (double)entity_a.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance, entity.getYRot(), entity.getXRot());
                  }

                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.fallDistance = 0.0F;
                  entity.setYRot(entity_a.getYRot());
                  entity.setXRot(0.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                     }
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  if (distance < 6.0) {
                     rnd = Math.ceil(Math.random() * 3.0);
                     skill_num = 155.0;
                  } else if (distance < 16.0) {
                     rnd = Math.ceil(Math.random() * 3.0);
                     skill_num = 157.0;
                  } else {
                     rnd = Math.ceil(Math.random() * 3.0);
                     skill_num = 157.0;
                  }

                  if (skill_num > 0.0 && LogicStartProcedure.execute(entity)) {
                     if (skill_num == 155.0) {
                        lv = 0.0;
                        tick = 50.0;
                     } else if (skill_num == 156.0) {
                        lv = 0.0;
                        tick = 75.0;
                     } else if (skill_num == 157.0) {
                        lv = 0.0;
                        tick = 75.0;
                     }

                     entity.getPersistentData().putDouble("skill", skill_num);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (lv > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
