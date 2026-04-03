package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade217Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackContinueProcedure {
   public AttackContinueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.EMPTY;
         ItemStack item_a = ItemStack.EMPTY;
         boolean attack = false;
         boolean overhead_continue = false;
         boolean sword = false;
         boolean keep = false;
         Entity target_entity = null;
         double old_skill = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double dis = 0.0;
         double old_cnt1 = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double num2 = 0.0;
         double CT2 = 0.0;
         double CT1 = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double weapon_size = 0.0;
         double attack_reach = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var59 = var10000;
         sword = LogicSwordProcedure.execute(entity);
         if (entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            CT1 = playerVars.PlayerCurseTechnique;
            CT2 = playerVars.PlayerCurseTechnique2;
         }

         if (entity.getPersistentData().getDouble("cnt7") == 0.0 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 1, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
               }
            }

            entity.getPersistentData().putDouble("Damage", 4.0);
            DamageFixProcedure.execute(entity);
            if ((CT1 == 19.0 || CT2 == 19.0) && LogicStartPassiveProcedure.execute(entity)) {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 9.0));
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt2", 0.0);
            old_cnt1 = entity.getPersistentData().getDouble("cnt1");
            old_skill = entity.getPersistentData().getDouble("skill");
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75;
            z_pos = entity.getZ();
            ItemStack var110;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var110 = _livEnt.getMainHandItem();
            } else {
               var110 = ItemStack.EMPTY;
            }

            item_a = var110.copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var110 = _livEnt.getOffhandItem();
            } else {
               var110 = ItemStack.EMPTY;
            }

            item_b = var110.copy();
            if (entity.onGround()) {
               if ((entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || CT1 == 16.0 || CT2 == 16.0) && !(entity instanceof Player) && entity.tickCount % 400 > 200) {
                  overhead_continue = true;
               }

               if ((entity instanceof HigurumaHiromiEntity || CT1 == 27.0 || CT2 == 27.0) && (item_a.getItem() == JujutsucraftModItems.GAVEL.get() || item_b.getItem() == JujutsucraftModItems.GAVEL.get())) {
                  overhead_continue = true;
               }
            }

            if (entity.getPersistentData().getDouble("cnt5") <= 100.0) {
               if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                  if (entity instanceof Player) {
                     keep = entity.getPersistentData().getBoolean("PRESS_Z");
                  } else if (overhead_continue) {
                     keep = true;
                  } else {
                     weapon_size = GetWeaponSizeProcedure.execute(entity);
                     attack_reach = GetReachProcedure.execute(entity);
                     range = ReturnEntitySizeProcedure.execute(entity);
                     range = range * range * Math.sqrt(weapon_size * attack_reach);
                     dis = 2.5 * range;
                     if (var59 instanceof LivingEntity && GetDistanceProcedure.execute(entity) < 6.0 * range && ((Entity)var59).getPersistentData().getBoolean("attack")) {
                        keep = true;
                     }

                     if (!keep) {
                        yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                        pitch = Math.toRadians((double)entity.getXRot());
                        Vec3 _center = new Vec3(entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis, entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0 * range / 2.0), (e) -> true)) {
                           if (entity != entityiterator) {
                              if (entityiterator instanceof Projectile) {
                                 if (DetectEnemyProjectileProcedure.execute(entity, entityiterator)) {
                                    keep = true;
                                    break;
                                 }
                              } else if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 keep = true;
                                 break;
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof CursedSpiritGrade217Entity) {
                     keep = true;
                  } else if (entity.getPersistentData().getDouble("cnt5") > 30.0) {
                     keep = false;
                  }

                  if (!keep) {
                     entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
                  }
               }

               label264: {
                  num2 = item_a.getItem() == ItemStack.EMPTY.getItem() ? 0.0 : Math.max(item_a.getOrCreateTag().getDouble("Power"), 0.0);
                  if (entity instanceof Player) {
                     if (CT1 != 21.0 && CT2 != 21.0) {
                        break label264;
                     }
                  } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                     break label264;
                  }

                  num2 -= 0.125;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt57 = (LivingEntity)entity;
                  if (_livEnt57.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                     num2 -= 0.125;
                  }
               }
               int var112;
               label254: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var112 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                        break label254;
                     }
                  }

                  var112 = 0;
               }

               if (var112 > 0) {
                  num2 -= 0.25;
               }

               if (item_a.getItem() != ItemStack.EMPTY.getItem()) {
                  num2 = Math.max(num2, 0.0);
               }

               if (overhead_continue) {
                  if (entity.getPersistentData().getDouble("cnt5") % 2.0 == 1.0) {
                     attack = true;
                  }
               } else {
                  attack = num2 >= 0.0 ? entity.getPersistentData().getDouble("cnt5") % (double)(2L + Math.round(num2 / 0.25)) == 1.0 : true;
               }

               if (attack || entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                  if (entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                     entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 2.5));
                  } else {
                     entity.getPersistentData().putDouble("cnt6", -0.1 + entity.getPersistentData().getDouble("cnt5") * 0.01);
                  }

                  if (!overhead_continue) {
                     if (entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                        AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     } else {
                        AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }
                  } else {
                     if (var59 instanceof LivingEntity) {
                        RotateEntityProcedure.execute(((Entity)var59).getX(), ((Entity)var59).getY() + (double)((Entity)var59).getBbHeight() * 0.5, ((Entity)var59).getZ(), entity);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity75 = (LivingEntity)entity;
                        if (_livingEntity75.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity75.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var110 = _livEnt.getMainHandItem();
                     } else {
                        var110 = ItemStack.EMPTY;
                     }

                     item_a = var110.copy().copy();
                     if (entity.getPersistentData().getDouble("cnt5") % 4.0 != 1.0 && !(entity.getPersistentData().getDouble("cnt5") >= 100.0)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var110 = _livEnt.getOffhandItem();
                        } else {
                           var110 = ItemStack.EMPTY;
                        }

                        if (var110.getItem() == ItemStack.EMPTY.getItem()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = item_a.copy();
                              _setstack.setCount(item_a.getCount());
                              _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.EMPTY.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity97 = (LivingEntity)entity;
                           if (_livingEntity97.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                              _livingEntity97.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(3.0);
                           }
                        }
                     } else {
                        if (item_a.getItem() == ItemStack.EMPTY.getItem()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var110 = _livEnt.getOffhandItem();
                              } else {
                                 var110 = ItemStack.EMPTY;
                              }

                              ItemStack _setstack = var110.copy().copy();
                              ItemStack var10001;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              _setstack.setCount(var10001.getCount());
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.EMPTY.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity89 = (LivingEntity)entity;
                           if (_livingEntity89.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                              _livingEntity89.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
                           }
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                     entity.getPersistentData().putDouble("Damage", 9.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     DamageFixProcedure.execute(entity);
                     entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("Damage"));
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     pitch = Math.toRadians(0.0);
                     distance = (double)(1.0F * entity.getBbWidth());
                     entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance);
                     entity.getPersistentData().putDouble("y_pos", entity.getY() + Math.sin(pitch) * -1.0 * distance);
                     entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);
                     entity.getPersistentData().putDouble("cnt1", 1.0);
                     entity.getPersistentData().putDouble("cnt3", 2.0);
                     entity.getPersistentData().putDouble("cnt4", 0.0);
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") - 2.0);
                     AttackOverheadProcedure.execute(world, x, y, z, entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 0, false, false));
                        }
                     }

                     x_power = entity.getLookAngle().x * 1.0;
                     y_power = entity.getDeltaMovement().y();
                     z_power = entity.getLookAngle().z * 1.0;
                     entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                     StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, x_power, y_power, z_power);
                  }
               }

               entity.getPersistentData().putDouble("cnt1", old_cnt1);
               entity.getPersistentData().putDouble("skill", old_skill);
            } else if (entity.getPersistentData().getDouble("cnt5") > 110.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
