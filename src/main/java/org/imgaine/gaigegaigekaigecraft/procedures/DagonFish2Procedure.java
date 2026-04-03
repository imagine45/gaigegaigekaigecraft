package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class DagonFish2Procedure {
   public DagonFish2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double size = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         dis = (double)(2.0F + entity.getBbWidth());
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * dis;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis;
         if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
                  label147: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label148: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                 break label148;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label147;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 0.0));
               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 1.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  ChangeCurseEnergyProcedure.execute(entity, -1.0);
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.0);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            int var10001;
            label114: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label114;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(20 + var10001 * 5) * 1.25;
            if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
               entity.getPersistentData().putDouble("NameRanged", Math.random());
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.SEA_SERPENT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.setYRot(entity.getYRot());
                  entityinstance.setXRot(entity.getXRot());
                  entityinstance.setYBodyRot(entityinstance.getYRot());
                  entityinstance.setYHeadRot(entityinstance.getYRot());
                  entityinstance.yRotO = entityinstance.getYRot();
                  entityinstance.xRotO = entityinstance.getXRot();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity56 = (LivingEntity)entityinstance;
                     if (_livingEntity56.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity56.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  entityinstance.getPersistentData().putDouble("movement", 1.0);
                  entityinstance.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 0.5);
                  entityinstance.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 0.5);
                  entityinstance.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 0.5);
                  entityinstance.getPersistentData().putDouble("speed", 0.5);
                  entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity76 = (LivingEntity)entityinstance;
                     if (_livingEntity76.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity76.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.75);
                     }
                  }

                  if (entityinstance instanceof SeaSerpentEntity) {
                     SeaSerpentEntity animatable = (SeaSerpentEntity)entityinstance;
                     double var51 = Math.random();
                     animatable.setTexture("dagon_fish" + Math.round(Math.ceil(var51 * 3.0)));
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
