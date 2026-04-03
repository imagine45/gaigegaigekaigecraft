package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CockroachesEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityTsuchigumoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AIRatProcedure {
   public AIRatProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         boolean logic_a = false;
         double rnd = 0.0;
         double speed = 0.0;
         double lv_df = 0.0;
         double lv_st = 0.0;
         double entity_size = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         speed = 0.5;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
               }
            }

            label114: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label114;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }
            }

            label109: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label109;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 1, false, false));
                  }
               }
            }

            label104: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label104;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 0, false, false));
                  }
               }
            }

            if (!(entity instanceof EntityTsuchigumoEntity) && LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
               owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (owner_uuid instanceof LivingEntity) {
                  if (entity.getPersistentData().getDouble("skill") > -900.0) {
                     entity.getPersistentData().putDouble("skill", 2306.0);
                     entity.getPersistentData().putDouble("Damage", 6.0);
                     entity.getPersistentData().putDouble("Range", (double)(2.0F + entity.getBbWidth()));
                     entity.getPersistentData().putDouble("knockback", 0.1);
                     entity.getPersistentData().putDouble("effect", 1.0);
                     RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                     entity.getPersistentData().putDouble("skill", 0.0);
                     entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_life") > 120.0 && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }

                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("skill") > -900.0 && entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.onGround()) {
                     entity.getPersistentData().putDouble("cnt_x", Math.random() * 5.0);
                     if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                        if (entity.getPersistentData().getDouble("friend_num") == owner_uuid.getPersistentData().getDouble("friend_num")) {
                           logic_a = true;
                           LivingEntity var10000;
                           if (owner_uuid instanceof Mob) {
                              Mob _mobEnt = (Mob)owner_uuid;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 instanceof LivingEntity && owner_uuid.getPersistentData().getDouble("cnt_target") > 6.0) {
                              CompoundTag var34 = entity.getPersistentData();
                              LivingEntity var10002;
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10002 = _mobEnt.getTarget();
                              } else {
                                 var10002 = null;
                              }

                              var34.putDouble("x_pos", ((Entity)var10002).getX());
                              var34 = entity.getPersistentData();
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10002 = _mobEnt.getTarget();
                              } else {
                                 var10002 = null;
                              }

                              var34.putDouble("y_pos", ((Entity)var10002).getY());
                              var34 = entity.getPersistentData();
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10002 = _mobEnt.getTarget();
                              } else {
                                 var10002 = null;
                              }

                              var34.putDouble("z_pos", ((Entity)var10002).getZ());
                           } else {
                              entity.getPersistentData().putDouble("x_pos", (double)owner_uuid.level().clip(new ClipContext(owner_uuid.getEyePosition(1.0F), owner_uuid.getEyePosition(1.0F).add(owner_uuid.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, owner_uuid)).getBlockPos().getX());
                              entity.getPersistentData().putDouble("y_pos", (double)owner_uuid.level().clip(new ClipContext(owner_uuid.getEyePosition(1.0F), owner_uuid.getEyePosition(1.0F).add(owner_uuid.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, owner_uuid)).getBlockPos().getY());
                              entity.getPersistentData().putDouble("z_pos", (double)owner_uuid.level().clip(new ClipContext(owner_uuid.getEyePosition(1.0F), owner_uuid.getEyePosition(1.0F).add(owner_uuid.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, owner_uuid)).getBlockPos().getZ());
                           }
                        }

                        if (logic_a) {
                           RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                           GetPowerForwardProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                           if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)), Block.COLLIDER, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                              entity.getPersistentData().putDouble("y_power", Math.max(entity.getPersistentData().getDouble("y_power"), 0.5 * (1.0 / speed)));
                           }

                           entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * speed, Math.max(entity.getPersistentData().getDouble("y_power") * speed, entity instanceof CockroachesEntity ? 0.1 : 0.25), entity.getPersistentData().getDouble("z_power") * speed));
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
