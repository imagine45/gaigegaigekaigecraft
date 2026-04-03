package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.item.SwordOptionItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackSpeedProcedure {
   public AttackSpeedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double CNT6 = 0.0;
         double rad_now = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         double strength = 0.0;
         double old_cnt2 = 0.0;
         double old_cnt1 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
            entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 2.5));
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         label367: {
            if (var10000.getItem() != JujutsucraftModItems.SWORD_OPTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() != JujutsucraftModItems.SWORD_OPTION.get()) {
                  break label367;
               }
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * -1.0 * (double)entity.getBbWidth();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * -1.0 * (double)entity.getBbWidth();
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * -1.0 * (double)entity.getBbWidth();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.SWORD_OPTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() instanceof SwordOptionItem) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putString("geckoAnim", "attack");
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == JujutsucraftModItems.SWORD_OPTION.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof SwordOptionItem) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "attack");
                  }
               }
            }

            entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 2.5));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 2, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 2, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }
         }

         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }
         int var113;
         label353: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var113 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label353;
               }
            }

            var113 = 0;
         }

         strength = (double)Math.min(var113, 50);
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + strength * 0.025);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         entity.fallDistance = 0.0F;
         LivingEntity var114;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var114 = _mobEnt.getTarget();
         } else {
            var114 = null;
         }

         if (var114 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt7") > 1.0) {
            entity.setYRot((float)entity.getPersistentData().getDouble("yaw"));
            entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
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

         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
            entity.getPersistentData().putDouble("cnt7", entity.getPersistentData().getDouble("cnt7") + 1.0);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var114 = _mobEnt.getTarget();
            } else {
               var114 = null;
            }

            if (var114 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt7") % 20.0 == 1.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var114 = _mobEnt.getTarget();
               } else {
                  var114 = null;
               }

               double var117 = ((Entity)var114).getX();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               double var119 = ((Entity)var10001).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var119 += (double)((Entity)var10002).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var117, var119, ((Entity)var10002).getZ(), entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            }

            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var114 = _mobEnt.getTarget();
               } else {
                  var114 = null;
               }

               if (var114 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }

               if (entity.getPersistentData().getDouble("cnt2") >= 9.0 && entity.getPersistentData().getDouble("cnt2") <= 10.0) {
                  if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                     entity.getPersistentData().putDouble("cnt2", Math.min(entity.getPersistentData().getDouble("cnt2"), 9.0));
                  }

                  if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.125);
                     if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt2") >= 10.0 && !entity.getPersistentData().getBoolean("PRESS_Z") && OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("cnt3", 1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(10.0 * range), range * 0.25, 0.1, range * 0.25, 0.5);
                  }

                  if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
                     if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
                        PlayAnimationEntity2Procedure.execute(entity, "form_attack_speed2");
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity105 = (LivingEntity)entity;
                        if (_livingEntity105.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity105.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(3.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity106 = (LivingEntity)entity;
                        if (_livingEntity106.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity106.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            } else {
               if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
                  }
               }

               x_power = entity.getPersistentData().getDouble("x_power") * 2.0;
               y_power = entity.getPersistentData().getDouble("y_power") * 2.0;
               z_power = entity.getPersistentData().getDouble("z_power") * 2.0;
               if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  entity.getPersistentData().putDouble("Range", 4.0 * range);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().putBoolean("attack", true);
               if (logic_a) {
                  if (Math.round(distance) >= 1L) {
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();

                     for(int index1 = 0; index1 < (int)Math.round(distance); ++index1) {
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           x_pos += x_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           y_pos += y_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           z_pos += z_power;
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     entity.teleportTo(x_pos, y_pos, z_pos);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                     }
                  }

                  logic_a = true;
               }

               if (logic_a || entity.getPersistentData().getDouble("cnt2") > 6.0) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().putDouble("cnt1", 8.0);
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") != 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
               }
            }

            old_cnt1 = entity.getPersistentData().getDouble("cnt1");
            old_cnt2 = entity.getPersistentData().getDouble("cnt2");
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1"));
            entity.getPersistentData().putDouble("cnt2", 0.0);
            if (old_cnt1 == 9.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (entity.getPersistentData().getDouble("cnt1") == 9.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity155 = (LivingEntity)entity;
                  if (_livingEntity155.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity155.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
                  }
               }

               if (LogicSwordProcedure.execute(entity)) {
                  AttackWeakSwordProcedure.execute(world, x, y, z, entity);
               } else {
                  AttackWeakPunchProcedure.execute(world, x, y, z, entity);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity156 = (LivingEntity)entity;
                  if (_livingEntity156.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity156.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                  }
               }
            }

            entity.getPersistentData().putDouble("cnt1", old_cnt1);
            entity.getPersistentData().putDouble("cnt2", old_cnt2);
            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
