package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeiMeiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AICrowProcedure {
   public AICrowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         boolean logic_a = false;
         Entity entity_a = null;
         if (entity.isAlive()) {
            if (entity instanceof CrowEntity) {
               CrowEntity _datEntL1 = (CrowEntity)entity;
               if ((Boolean)_datEntL1.getEntityData().get(CrowEntity.DATA_object)) {
                  label289: {
                     entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_life") > 160.0 && !entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           break label289;
                        }
                     }

                     entity.getPersistentData().putDouble("cnt_life2", entity.getPersistentData().getDouble("cnt_life2") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_life2") > 40.0 && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
               AICursedSpirit3FishProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 20.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  logic_a = false;
                  if (!entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity_a instanceof LivingEntity) {
                        entity.getPersistentData().putString("FOLLOW_ID", entity.getPersistentData().getString("OWNER_UUID"));
                        if (Math.random() < 0.25) {
                           if (entity_a.getPersistentData().getDouble("NameRanged") == 0.0) {
                              entity.getPersistentData().putDouble("NameRanged", Math.random());
                           }

                           entity.getPersistentData().putDouble("NameRanged_ranged", entity_a.getPersistentData().getDouble("NameRanged"));
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 MobEffectInstance var10001;
                                 MobEffect var10003;
                                 int var10005;
                                 label221: {
                                    var10003 = MobEffects.DAMAGE_BOOST;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                          var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                          break label221;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var10001 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                                 _entity.addEffect(var10001);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 5, false, false));
                              }
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().getString("FOLLOW_ID").isEmpty()) {
                     label207: {
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           if (_tamEnt.isTame()) {
                              LivingEntity var10000;
                              if (entity instanceof TamableAnimal) {
                                 _tamEnt = (TamableAnimal)entity;
                                 var10000 = _tamEnt.getOwner();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity) {
                                 CompoundTag var84 = entity.getPersistentData();
                                 LivingEntity var10002;
                                 if (entity instanceof TamableAnimal) {
                                    _tamEnt = (TamableAnimal)entity;
                                    var10002 = _tamEnt.getOwner();
                                 } else {
                                    var10002 = null;
                                 }

                                 var84.putString("FOLLOW_ID", ((Entity)var10002).getStringUUID());
                                 break label207;
                              }
                           }
                        }

                        if (!world.getEntitiesOfClass(MeiMeiEntity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).isEmpty()) {
                           entity.getPersistentData().putString("FOLLOW_ID", ((Entity)world.getEntitiesOfClass(MeiMeiEntity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x, y, z)).findFirst().orElse((MeiMeiEntity) null)).getStringUUID());
                        } else {
                           entity.getPersistentData().putDouble("cnt_x", -80.0);
                        }
                     }
                  } else {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("FOLLOW_ID"));
                     if (entity_a instanceof LivingEntity) {
                        logic_a = true;
                        x_pos = entity_a.getX();
                        y_pos = entity_a.getY();
                        z_pos = entity_a.getZ();
                     } else {
                        entity.getPersistentData().putString("FOLLOW_ID", "");
                     }
                  }

                  if (logic_a) {
                     dis = Math.sqrt(Math.pow(entity.getX() - x_pos, 2.0) + Math.pow(entity.getY() - y_pos, 2.0) + Math.pow(entity.getZ() - z_pos, 2.0));
                     if (dis < 24.0) {
                        if (entity instanceof Mob) {
                           Mob _entity = (Mob)entity;
                           _entity.getNavigation().moveTo(x_pos + (Math.random() - 0.5) * 16.0, y_pos + 8.0 + Math.random() * 8.0, z_pos + (Math.random() - 0.5) * 16.0, 1.0);
                        }
                     } else {
                        entity.getPersistentData().putBoolean("canFly", true);
                        GetPowerForwardProcedure.execute(x_pos + (Math.random() - 0.5) * 16.0, y_pos + 8.0 + Math.random() * 8.0, z_pos + (Math.random() - 0.5) * 16.0, entity);
                        entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.25, entity.getPersistentData().getDouble("y_power") * 0.25, entity.getPersistentData().getDouble("z_power") * 0.25));
                        RotateEntityProcedure.execute((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + entity.getDeltaMovement().x() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + entity.getDeltaMovement().y() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + entity.getDeltaMovement().z() * 10.0, entity);
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("skill", 1.0);
               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               logic_a = false;
               if (entity.getPersistentData().getDouble("cnt1") < 3.0) {
                  if (LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                        logic_a = true;
                        LivingEntity var85;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var85 = _mobEnt.getTarget();
                        } else {
                           var85 = null;
                        }

                        if (var85 instanceof LivingEntity) {
                           CompoundTag var86 = entity.getPersistentData();
                           LivingEntity var89;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var89 = _mobEnt.getTarget();
                           } else {
                              var89 = null;
                           }

                           Level var90 = ((Entity)var89).level();
                           ClipContext var95;
                           LivingEntity var98;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var98 = _mobEnt.getTarget();
                           } else {
                              var98 = null;
                           }

                           Vec3 var99 = ((Entity)var98).getEyePosition(1.0F);
                           LivingEntity var10006;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10006 = _mobEnt.getTarget();
                           } else {
                              var10006 = null;
                           }

                           Vec3 var102 = ((Entity)var10006).getEyePosition(1.0F);
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.getTarget();
                           } else {
                              var10007 = null;
                           }

                           var102 = var102.add(((Entity)var10007).getViewVector(1.0F).scale(0.0));
                           ClipContext.Block var107 = Block.OUTLINE;
                           ClipContext.Fluid var10008 = Fluid.NONE;
                           LivingEntity var10009;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.getTarget();
                           } else {
                              var10009 = null;
                           }

                           var95 = new ClipContext(var99, var102, var107, var10008, var10009);
                           var86.putDouble("x_pos", (double)var90.clip(var95).getBlockPos().getX());
                           var86 = entity.getPersistentData();
                           LivingEntity var91;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var91 = _mobEnt.getTarget();
                           } else {
                              var91 = null;
                           }

                           double var92 = ((Entity)var91).getY();
                           LivingEntity var96;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var96 = _mobEnt.getTarget();
                           } else {
                              var96 = null;
                           }

                           var86.putDouble("y_pos", var92 + (double)((Entity)var96).getBbHeight() * 0.5);
                           var86 = entity.getPersistentData();
                           LivingEntity var93;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var93 = _mobEnt.getTarget();
                           } else {
                              var93 = null;
                           }

                           Level var94 = ((Entity)var93).level();
                           ClipContext var97;
                           LivingEntity var100;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var100 = _mobEnt.getTarget();
                           } else {
                              var100 = null;
                           }

                           Vec3 var101 = ((Entity)var100).getEyePosition(1.0F);
                           LivingEntity var104;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var104 = _mobEnt.getTarget();
                           } else {
                              var104 = null;
                           }

                           Vec3 var105 = ((Entity)var104).getEyePosition(1.0F);
                           LivingEntity var108;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var108 = _mobEnt.getTarget();
                           } else {
                              var108 = null;
                           }

                           var105 = var105.add(((Entity)var108).getViewVector(1.0F).scale(0.0));
                           ClipContext.Block var109 = Block.OUTLINE;
                           var10008 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.getTarget();
                           } else {
                              var10009 = null;
                           }

                           var97 = new ClipContext(var101, var105, var109, var10008, var10009);
                           var86.putDouble("z_pos", (double)var94.clip(var97).getBlockPos().getZ());
                        } else {
                           x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                           y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                           z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                           entity.getPersistentData().putDouble("x_pos", x_pos);
                           entity.getPersistentData().putDouble("y_pos", y_pos);
                           entity.getPersistentData().putDouble("z_pos", z_pos);
                           dis = 8.0;
                           logic_a = false;

                           for(int index0 = 0; index0 < 8; ++index0) {
                              Vec3 _center = new Vec3((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());

                              for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> true)) {
                                 if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                    logic_a = true;
                                    entity.getPersistentData().putDouble("x_pos", entityiterator.getX());
                                    entity.getPersistentData().putDouble("y_pos", entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                                    entity.getPersistentData().putDouble("z_pos", entityiterator.getZ());
                                    break;
                                 }
                              }

                              dis += 8.0;
                              if (logic_a) {
                                 break;
                              }
                           }
                        }
                     }
                  }

                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putBoolean("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  x_power = entity.getPersistentData().getDouble("x_power") * 2.0;
                  y_power = entity.getPersistentData().getDouble("y_power") * 2.0;
                  z_power = entity.getPersistentData().getDouble("z_power") * 2.0;
                  entity.getPersistentData().putDouble("old_x", x);
                  entity.getPersistentData().putDouble("old_y", y);
                  entity.getPersistentData().putDouble("old_z", z);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 5, 0.1, 0.1, 0.1, 0.4);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                     }
                  }
               } else {
                  if (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * 2.0) {
                     x_power = entity.getDeltaMovement().x() - 0.15;
                  } else {
                     x_power = entity.getDeltaMovement().x() + 0.15;
                  }

                  if (entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * 2.0) {
                     y_power = entity.getDeltaMovement().y() - 0.15;
                  } else {
                     y_power = entity.getDeltaMovement().y() + 0.15;
                  }

                  if (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * 2.0) {
                     z_power = entity.getDeltaMovement().z() - 0.15;
                  } else {
                     z_power = entity.getDeltaMovement().z() + 0.15;
                  }
               }

               if (!entity.getPersistentData().getBoolean("Stop")) {
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  RotateEntityProcedure.execute((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + entity.getDeltaMovement().x() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + entity.getDeltaMovement().y() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + entity.getDeltaMovement().z() * 10.0, entity);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
                  }
               } else {
                  entity.getPersistentData().putBoolean("Stop", false);
               }

               x_pos = entity.getPersistentData().getDouble("old_x");
               y_pos = entity.getPersistentData().getDouble("old_y");
               z_pos = entity.getPersistentData().getDouble("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;

                  for(int index1 = 0; index1 < (int)Math.ceil(dis * 2.0); ++index1) {
                     entity.getPersistentData().putDouble("Damage", 24.0);
                     entity.getPersistentData().putDouble("Range", 3.0);
                     entity.getPersistentData().putDouble("knockback", 0.25);
                     entity.getPersistentData().putDouble("effect", 1.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     x_pos += x_power * 0.5;
                     y_pos += y_power * 0.5;
                     z_pos += z_power * 0.5;
                  }
               }

               entity.getPersistentData().putDouble("old_x", x);
               entity.getPersistentData().putDouble("old_y", y);
               entity.getPersistentData().putDouble("old_z", z);
               entity.getPersistentData().putDouble("BlockRange", 1.0);
               entity.getPersistentData().putDouble("BlockDamage", 1.0);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.setHealth(0.0F);
                  }

                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))), 9999.0F);
               }
            }
         }

      }
   }
}
