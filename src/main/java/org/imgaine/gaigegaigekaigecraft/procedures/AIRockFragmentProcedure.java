package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityCrystalEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone3Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIRockFragmentProcedure {
   public AIRockFragmentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double loop_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         double entity_size = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         int var10000;
         if (entity instanceof EntityCrystalEntity) {
            EntityCrystalEntity _datEntI = (EntityCrystalEntity)entity;
            var10000 = (Integer)_datEntI.getEntityData().get(EntityCrystalEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 == 1) {
            AICrystalExplodeProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
         } else {
            entity_size = ReturnEntitySizeProcedure.execute(entity);
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity instanceof EntityCrystalEntity) {
               entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_life") < 6.0) {
                  entity.fallDistance = 0.0F;
                  entity.push(0.0, 0.0, 0.0);
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }

               if (entity.getPersistentData().getDouble("cnt_life") == 6.0) {
                  entity.push(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power"));
                  entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
               }

               if (entity.getPersistentData().getDouble("cnt_life") > 30.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               entity.getPersistentData().putDouble("cnt_life", Math.max(entity.getPersistentData().getDouble("cnt_life"), 20.0));
            }

            if (entity.getPersistentData().getDouble("cnt_life") >= 6.0 && entity.getPersistentData().getDouble("skill") != 1706.0) {
               if (entity instanceof Gravestone3Entity && !entity.onGround()) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), Math.min(entity.getDeltaMovement().y(), -0.25), entity.getDeltaMovement().z()));
               }

               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  entity.getPersistentData().putDouble("yaw_fix", (Math.random() - 0.5) * 2.0);
                  entity.getPersistentData().putDouble("pitch_fix", (Math.random() - 0.5) * 2.0);
                  entity.getPersistentData().putDouble("cnt3", 5.0);
                  if (entity.getPersistentData().getDouble("skill") >= 400.0 && entity.getPersistentData().getDouble("skill") < 500.0) {
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntSetL = (RockFragmentEntity)entity;
                        _datEntSetL.getEntityData().set(RockFragmentEntity.DATA_Magma, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2147483647, 0, false, false));
                        }
                     }

                     entity.setSecondsOnFire(30);
                  }
               }

               if (entity.onGround()) {
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") > 0.0 ? entity.getPersistentData().getDouble("cnt3") - 1.0 : 0.0);
                  if (entity instanceof Gravestone3Entity) {
                     entity.getPersistentData().putDouble("cnt_rock", entity.getPersistentData().getDouble("cnt_rock") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_rock") > 4.0) {
                        entity.getPersistentData().putDouble("cnt_rock", 0.0);
                        entity.getPersistentData().putDouble("BlockRange", 3.0 * entity_size);
                        entity.getPersistentData().putDouble("BlockDamage", (double)(entity.getBbHeight() * entity.getBbWidth()) * 0.1 * CNT6);
                        entity.getPersistentData().putBoolean("noParticle", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt2") > 8.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x, y, z, (int)(4.0 * entity_size * entity_size), 0.25 * entity_size, 0.1 * entity_size, 0.25 * entity_size, 0.1 * entity_size);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, (int)(4.0 * entity_size * entity_size), 0.25 * entity_size, 0.1 * entity_size, 0.25 * entity_size, 0.1 * entity_size);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x, y, z, (int)(4.0 * entity_size * entity_size), 0.25 * entity_size, 0.1 * entity_size, 0.25 * entity_size, 0.1 * entity_size);
                     }

                     entity.getPersistentData().putDouble("Damage", 10.0 * entity_size * CNT6);
                     entity.getPersistentData().putDouble("Range", 3.0 * entity_size);
                     entity.getPersistentData().putDouble("knockback", 0.2);
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntL67 = (RockFragmentEntity)entity;
                        if ((Boolean)_datEntL67.getEntityData().get(RockFragmentEntity.DATA_Magma)) {
                           entity.getPersistentData().putDouble("effect", 10.0);
                        }
                     }

                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().putDouble("BlockRange", 3.0 * entity_size);
                     entity.getPersistentData().putDouble("BlockDamage", 2.0 * entity_size * CNT6);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().putDouble("yaw_fix", (Math.random() - 0.5) * 2.0);
                     entity.getPersistentData().putDouble("pitch_fix", (Math.random() - 0.5) * 2.0);
                  } else {
                     entity.getPersistentData().putDouble("Damage", 0.0);
                  }

                  entity.getPersistentData().putDouble("cnt2", 0.0);
               } else {
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  speed = Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z() + entity.getDeltaMovement().y() * entity.getDeltaMovement().y());
                  if (!(entity.getPersistentData().getDouble("cnt2") > 8.0) && !(speed > 1.0)) {
                     entity.getPersistentData().putDouble("Damage", 0.0);
                  } else {
                     entity.getPersistentData().putDouble("Damage", 10.0 * entity_size * CNT6);
                     entity.getPersistentData().putDouble("Range", 3.0 * entity_size);
                     entity.getPersistentData().putDouble("knockback", 0.5);
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntL88 = (RockFragmentEntity)entity;
                        if ((Boolean)_datEntL88.getEntityData().get(RockFragmentEntity.DATA_Magma)) {
                           entity.getPersistentData().putDouble("effect", 10.0);
                        }
                     }

                     RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                     if (speed > 1.0) {
                        x_power = entity.getDeltaMovement().x() / speed;
                        y_power = entity.getDeltaMovement().y() / speed;
                        z_power = entity.getDeltaMovement().z() / speed;
                        x_pos = entity.getX();
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                        z_pos = entity.getZ();

                        for(int index0 = 0; index0 < (int)speed; ++index0) {
                           entity.getPersistentData().putDouble("Damage", Math.min(10.0 * entity_size * (1.0 + speed * 0.2), 18.0) * CNT6);
                           entity.getPersistentData().putDouble("Range", 3.0);
                           entity.getPersistentData().putDouble("knockback", Math.min(0.6 + speed * 0.2, 1.5));
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           x_pos += x_power;
                           y_pos += y_power;
                           z_pos += z_power;
                        }
                     }

                     speed = Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z());
                     if (entity instanceof RockFragmentEntity) {
                        if (!(speed > 0.5) && !(entity.getPersistentData().getDouble("cnt3") > 0.0)) {
                           BulletDomainHit2Procedure.execute(world, entity);
                        } else if (!entity.getPersistentData().getBoolean("Stop")) {
                           for(int index1 = 0; index1 < 25; ++index1) {
                              entity.setYRot((float)((double)entity.getYRot() + entity.getPersistentData().getDouble("yaw_fix")));
                              entity.setXRot((float)((double)entity.getXRot() + entity.getPersistentData().getDouble("pitch_fix")));
                              entity.setYBodyRot(entity.getYRot());
                              entity.setYHeadRot(entity.getYRot());
                              entity.yRotO = entity.getYRot();
                              entity.xRotO = entity.getXRot();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.yBodyRotO = _entity.getYRot();
                                 _entity.yHeadRotO = _entity.getYRot();
                              }
                           }
                        } else {
                           entity.getPersistentData().putBoolean("Stop", false);
                        }
                     }
                  }
               }
            }

            if (!entity.isAlive() || entity.getPersistentData().getDouble("cnt1") > 200.0 || entity.getPersistentData().getDouble("skill") == 0.0) {
               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();
               if (!entity.isAlive()) {
                  label155: {
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntL126 = (RockFragmentEntity)entity;
                        if ((Boolean)_datEntL126.getEntityData().get(RockFragmentEntity.DATA_Magma)) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, (int)(2.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                           }
                           break label155;
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(5.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)(2.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                  }
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
