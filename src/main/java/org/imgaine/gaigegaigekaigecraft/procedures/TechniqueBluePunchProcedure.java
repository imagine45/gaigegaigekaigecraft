package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueBluePunchProcedure {
   public TechniqueBluePunchProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double z_center = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double x_center = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double rad = 0.0;
         double x_power = 0.0;
         double num1 = 0.0;
         double z_knockback = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double y_knockback = 0.0;
         ItemStack old_health = ItemStack.EMPTY;
         boolean player = false;
         boolean logic_a = false;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt9", entity.getPersistentData().getDouble("cnt9") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt9") % 4.0 == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity9 = (LivingEntity)entity;
               if (_livingEntity9.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity9.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(207.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity10 = (LivingEntity)entity;
               if (_livingEntity10.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity10.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            double var97 = ((Entity)var10000).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var100 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var100 += (double)((Entity)var10002).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var97, var100, ((Entity)var10002).getZ(), entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_center, y_center, z_center), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
            } else {
               _level.playLocalSound(x_center, y_center, z_center, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 2.0) {
            if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
               entity.getPersistentData().putDouble("Damage", 6.0);
               DamageFixProcedure.execute(entity);
               dis = (double)(1.0F + entity.getBbWidth());
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               x_center = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis;
               y_center = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis;
               z_center = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis;
               entity.getPersistentData().putDouble("x_pos", x_center);
               entity.getPersistentData().putDouble("y_pos", y_center);
               entity.getPersistentData().putDouble("z_pos", z_center);
               x_power = entity.getLookAngle().x * 0.33;
               y_power = entity.getLookAngle().y * 0.33;
               z_power = entity.getLookAngle().z * 0.33;
               num1 = 0.0;

               for(int index0 = 0; index0 < 120; ++index0) {
                  dis += 0.25 * range;
                  rad += Math.toRadians(Math.random() * 20.0);
                  if (Math.random() > 0.5) {
                     if (Math.random() < 0.5) {
                        rad *= -1.0;
                     }

                     x_pos = x_center + Math.cos(rad) * Math.cos(yaw + Math.toRadians(90.0)) * Math.min(dis * 0.25, 4.0 * range);
                     y_pos = y_center + Math.sin(rad) * Math.min(dis * 0.25, 4.0 * range);
                     z_pos = z_center + Math.cos(rad) * Math.sin(yaw + Math.toRadians(90.0)) * Math.min(dis * 0.25, 4.0 * range);
                     ParticleGeneratorProcedure.execute(world, range * 0.1, 1.0, 0.0, dis * 0.25, x_pos, entity.getPersistentData().getDouble("x_pos"), y_pos, entity.getPersistentData().getDouble("y_pos"), z_pos, entity.getPersistentData().getDouble("z_pos"), "minecraft:enchanted_hit");
                  }

                  x_center += x_power;
                  y_center += y_power;
                  z_center += z_power;
                  ++num1;
                  if (num1 >= 12.0) {
                     num1 = 0.0;
                     entity.getPersistentData().putDouble("Range", 10.0 * range);
                     entity.getPersistentData().putDouble("knockback", -3.0);
                     Vec3 _center = new Vec3(x_center, y_center, z_center);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator) {
                           label279: {
                              logic_a = true;
                              if (entityiterator instanceof Player) {
                                 if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                                    break label279;
                                 }
                              } else if (!(entityiterator instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity)) {
                                 break label279;
                              }

                              ItemStack var98;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                 var98 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                              } else {
                                 var98 = ItemStack.EMPTY;
                              }

                              old_health = var98.copy();
                              if (entityiterator instanceof Player) {
                                 Player _plrCldCheck49 = (Player)entityiterator;
                                 if (_plrCldCheck49.getCooldowns().isOnCooldown(old_health.getItem())) {
                                    break label279;
                                 }
                              }

                              if ((old_health.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) && old_health.getOrCreateTag().getDouble("skill206") >= 100.0) {
                                 logic_a = false;
                              }
                           }

                           if ((LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move"))) || !(entityiterator instanceof LivingEntity)) && logic_a) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
                              }

                              player = entityiterator instanceof Player;
                              x_knockback = entityiterator.getX() - (entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(2.0F + entity.getBbWidth()));
                              y_knockback = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5 - (entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * (double)(2.0F + entity.getBbWidth()));
                              z_knockback = entityiterator.getZ() - (entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(2.0F + entity.getBbWidth()));
                              dis = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                              if (GetDistanceIteratorProcedure.execute(entity, entityiterator) < 2.5) {
                                 x_knockback = 0.0;
                                 y_knockback = 0.0;
                                 z_knockback = 0.0;
                              } else {
                                 x_knockback = x_knockback / dis * entity.getPersistentData().getDouble("knockback");
                                 y_knockback = y_knockback / dis * entity.getPersistentData().getDouble("knockback");
                                 z_knockback = z_knockback / dis * entity.getPersistentData().getDouble("knockback");
                                 if (!(x_knockback * 1.1 < entityiterator.getDeltaMovement().x()) && !(x_knockback * 0.9 > entityiterator.getDeltaMovement().x())) {
                                    x_knockback = entityiterator.getDeltaMovement().x();
                                 } else {
                                    x_knockback = entityiterator.getDeltaMovement().x() + x_knockback * (player ? 0.15 : 0.05);
                                 }

                                 if (!(y_knockback * 1.1 < entityiterator.getDeltaMovement().y()) && !(y_knockback * 0.9 > entityiterator.getDeltaMovement().y())) {
                                    y_knockback = entityiterator.getDeltaMovement().y();
                                 } else {
                                    y_knockback = entityiterator.getDeltaMovement().y() + y_knockback * (player ? 0.15 : 0.05);
                                 }

                                 if (!(z_knockback * 1.1 < entityiterator.getDeltaMovement().z()) && !(z_knockback * 0.9 > entityiterator.getDeltaMovement().z())) {
                                    z_knockback = entityiterator.getDeltaMovement().z();
                                 } else {
                                    z_knockback = entityiterator.getDeltaMovement().z() + z_knockback * (player ? 0.15 : 0.05);
                                 }

                                 if (entityiterator.onGround()) {
                                    y_knockback = Math.max(y_knockback, 0.5);
                                 }
                              }

                              EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("knockback", 0.0);
                  }
               }

               entity.getPersistentData().putDouble("effect", 1.0);
               GrabProcedure.execute(world, entity);
               entity.getPersistentData().putDouble("effect", 0.0);
               if (entity.getPersistentData().getDouble("cnt1") >= 13.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                     if (GetDistanceProcedure.execute(entity) < 6.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt5") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                     entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 13.0));
                     entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 0.1);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 16.0) {
               label301: {
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof Player) {
                     if (!entity.isShiftKeyDown()) {
                        break label301;
                     }
                  } else if (!(Math.random() < 0.5)) {
                     break label301;
                  }

                  entity.getPersistentData().putDouble("skill", 1606.0);
                  entity.getPersistentData().putDouble("cnt3", 1.0);
                  entity.getPersistentData().putDouble("cnt6", 2.5);
                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  entity.setYRot((float)yaw);
                  entity.setXRot(90.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.getPersistentData().putBoolean("canFly", true);
                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                  GetPowerFixProcedure.execute(entity);
                  entity.setYRot((float)yaw);
                  entity.setXRot((float)pitch);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  return;
               }

               entity.getPersistentData().putDouble("skill", 101.0);
               entity.getPersistentData().putDouble("cnt1", 8.0);
               entity.getPersistentData().putDouble("cnt6", 5.0);
            }
         }

      }
   }
}
