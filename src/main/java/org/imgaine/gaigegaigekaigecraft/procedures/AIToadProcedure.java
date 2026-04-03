package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.Toad2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.ToadEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIToadProcedure {
   public AIToadProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean reChange = false;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double speed = 0.0;
         double NUM1 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            FollowEntityProcedure.execute(world, entity);
            if (entity instanceof ToadEntity) {
               if (entity.onGround()) {
                  speed = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0));
                  if (speed > 0.1) {
                     int var10000;
                     label201: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                              var10000 = _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                              break label201;
                           }
                        }

                        var10000 = 0;
                     }

                     if (var10000 < 9) {
                        entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 1.0, Math.min(entity.getLookAngle().y + 0.6, 1.0), entity.getLookAngle().z * 1.0));
                        if (entity instanceof ToadEntity) {
                           ((ToadEntity)entity).setAnimation("empty");
                        }

                        if (entity instanceof ToadEntity) {
                           PlayAnimationEntity2Procedure.execute(entity, "walk");
                        }
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
                  }
               }
            }

            if (entity instanceof Toad2Entity) {
               entity.setDeltaMovement(new Vec3(0.0, Math.min(entity.getDeltaMovement().y(), -0.25), 0.0));
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(3.0), (e) -> true)) {
                  if (entity != entityiterator) {
                     if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        rnd = -200.0 - Math.random() * 50.0;
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Entity entityToSpawn = EntityType.CHICKEN.spawn(_level, BlockPos.containing(entity.getX(), rnd, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                           }
                        }
                     }

                     reChange = false;
                     if (!world.getEntitiesOfClass(Chicken.class, AABB.ofSize(new Vec3(entity.getX(), rnd, entity.getZ()), 1.0, 1.0, 1.0), (e) -> true).isEmpty()) {
                        if (!((Entity)world.getEntitiesOfClass(Chicken.class, AABB.ofSize(new Vec3(entity.getX(), rnd, entity.getZ()), 1.0, 1.0, 1.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(entity.getX(), rnd, entity.getZ())).findFirst().orElse((Chicken)null)).level().isClientSide()) {
                           ((Entity)world.getEntitiesOfClass(Chicken.class, AABB.ofSize(new Vec3(entity.getX(), rnd, entity.getZ()), 1.0, 1.0, 1.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(entity.getX(), rnd, entity.getZ())).findFirst().orElse((Chicken)null)).discard();
                        }

                        reChange = true;
                        break;
                     }

                     if (reChange) {
                        entityiterator.teleportTo(x, y, z);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.connection.teleport(x, y, z, entityiterator.getYRot(), entityiterator.getXRot());
                        }

                        entityiterator.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
                           }
                        }
                        break;
                     }
                  }
               }
            }

            double var10001;
            label180: {
               NUM1 = (double)(2L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity37 = (LivingEntity)entity;
                  if (_livingEntity37.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity37.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label180;
                  }
               }

               var10001 = 0.0;
            }

            label175: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt38 = (LivingEntity)entity;
                  if (_livEnt38.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label175;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var58;
            label170: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var58 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label170;
                  }
               }

               var58 = 0;
            }

            if ((double)var58 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
               }
            }

            label164: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt42 = (LivingEntity)entity;
                  if (_livEnt42.hasEffect(MobEffects.JUMP)) {
                     break label164;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2147483647, 4, false, false));
                  }
               }
            }

            if (entity.isVehicle()) {
               for(Entity entityiterator : new ArrayList<Entity>(entity.getPassengers())) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, 4, false, false));
                     }
                  }
               }
            }

            if (entity instanceof ToadEntity) {
               LivingEntity var59;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var59 = _mobEnt.getTarget();
               } else {
                  var59 = null;
               }

               if (var59 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     CalculateAttackProcedure.execute(world, entity);
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               }
            }

            if (entity.getPersistentData().getDouble("skill") > 0.0) {
               LivingEntity var60;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var60 = _mobEnt.getTarget();
               } else {
                  var60 = null;
               }

               if (var60 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var60 = _mobEnt.getTarget();
                  } else {
                     var60 = null;
                  }

                  x_pos = ((Entity)var60).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var60 = _mobEnt.getTarget();
                  } else {
                     var60 = null;
                  }

                  double var63 = ((Entity)var60).getY();
                  LivingEntity var65;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var65 = _mobEnt.getTarget();
                  } else {
                     var65 = null;
                  }

                  y_pos = var63 + (double)((Entity)var65).getBbHeight() * 0.5;
                  LivingEntity var64;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var64 = _mobEnt.getTarget();
                  } else {
                     var64 = null;
                  }

                  z_pos = ((Entity)var64).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6, 9, false, false));
                  }
               }
            }
         }

      }
   }
}
