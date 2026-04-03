package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AttackOverheadHigurumaProcedure {
   public AttackOverheadHigurumaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = 0.0;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double old_cnt6 = 0.0;
         boolean logic_a = false;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         double var10001;
         double var10002;
         label293: {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            range = ReturnEntitySizeProcedure.execute(entity);
            var10001 = entity.getPersistentData().getDouble("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt5 = (LivingEntity)entity;
               if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label293;
               }
            }

            var10002 = 0.2;
         }

         CNT6 = 1.0 + var10001 * var10002;
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
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
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  distance = GetDistanceProcedure.execute(entity);
                  if (distance > 1.0 && distance < 4.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") == 0.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().getDouble("cnt5") > 0.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.125);
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("cnt3", 1.0);
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

                     double var92 = ((Entity)var10000).getX();
                     LivingEntity var93;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var93 = _mobEnt.getTarget();
                     } else {
                        var93 = null;
                     }

                     double var94 = ((Entity)var93).getY();
                     LivingEntity var95;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.getTarget();
                     } else {
                        var95 = null;
                     }

                     RotateEntityProcedure.execute(var92, var94, ((Entity)var95).getZ(), entity);
                  }

                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  entity.setYRot((float)yaw);
                  entity.setXRot((float)Math.max(pitch, 90.0));
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

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().putDouble("Damage", 4.0);
               DamageFixProcedure.execute(entity);
            } else {
               if (entity.getPersistentData().getDouble("cnt4") == 0.0 || entity instanceof GeoEntity && GetEntityAnimationProcedure.execute(entity).equals("empty")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity58 = (LivingEntity)entity;
                     if (_livingEntity58.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity58.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity59 = (LivingEntity)entity;
                     if (_livingEntity59.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity59.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 2.0, entity.getPersistentData().getDouble("y_power") * 2.0, entity.getPersistentData().getDouble("z_power") * 2.0));
               x_power = entity.getDeltaMovement().x();
               y_power = entity.getDeltaMovement().y();
               z_power = entity.getDeltaMovement().z();
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance != 0.0) {
                  x_power /= distance;
                  y_power /= distance;
                  z_power /= distance;
               }

               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();
               entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.1);
               entity.getPersistentData().putDouble("y_knockback", entity.getDeltaMovement().y() * 1.1);
               entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.1);
               logic_a = false;

               for(int index0 = 0; index0 < (int)Math.max(distance, 1.0); ++index0) {
                  entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 3.0 * range);
                  entity.getPersistentData().putDouble("knockback", 0.6);
                  entity.getPersistentData().putDouble("effect", 5.0);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        logic_a = true;
                        break;
                     }
                  }

                  if (logic_a) {
                     entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
               entity.getPersistentData().putBoolean("attack", true);
               entity.getPersistentData().putDouble("cnt8", Math.max(entity.getPersistentData().getDouble("cnt8"), entity.getPersistentData().getDouble("Damage")));
               if (entity.getPersistentData().getDouble("cnt2") % 2.0 == 1.0 && entity.getPersistentData().getDouble("cnt4") >= 1.0) {
                  entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4") - 1.0, 1.0));
               }

               if (entity.onGround() && entity.getPersistentData().getDouble("cnt2") > 5.0) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  entity.getPersistentData().putDouble("cnt1", 1.0);
                  yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  pitch = Math.toRadians(0.0);
                  distance = 6.0 * range;
                  entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance);
                  entity.getPersistentData().putDouble("y_pos", entity.getY() + Math.sin(pitch) * -1.0 * distance);
                  entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);
                  if (entity.getPersistentData().getDouble("cnt4") == 0.0 || entity instanceof GeoEntity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity116 = (LivingEntity)entity;
                        if (_livingEntity116.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity116.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity117 = (LivingEntity)entity;
                        if (_livingEntity117.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity117.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(4.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               } else if (entity.getPersistentData().getDouble("cnt2") > 80.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") != 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
               }
            }

            d = Math.max(Math.sqrt(entity.getPersistentData().getDouble("cnt8")), 1.0) * range;
            entity.getPersistentData().putDouble("y_knockback", 0.5);
            entity.getPersistentData().putDouble("cnt3", 4.0);
            if (!(entity.getPersistentData().getDouble("cnt3") > 1.0) && !(entity.getPersistentData().getDouble("cnt4") > 15.0)) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt2", 5.0);
               entity.getPersistentData().putDouble("cnt3", 1.0);
            } else if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
               if (entity.getPersistentData().getDouble("cnt1") <= 2.0) {
                  if (entity.getPersistentData().getDouble("cnt4") == 1.0 && entity.getPersistentData().getDouble("cnt1") <= 2.0 && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)d, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)d, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 0.75F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 0.75F, false);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") <= 6.0 * d) {
                  if (entity.getPersistentData().getDouble("cnt1") % 2.0 == 0.0) {
                     old_cnt6 = entity.getPersistentData().getDouble("cnt6");
                     entity.getPersistentData().putDouble("cnt6", -1.0);
                     entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 0.75);
                     entity.getPersistentData().putDouble("Range", 10.0 * range);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().putDouble("cnt6", old_cnt6);
                     entity.getPersistentData().putDouble("BlockDamage", 1.0 + d * 1.0);
                     entity.getPersistentData().putDouble("BlockRange", 1.0 * d);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  for(int index1 = 0; index1 < (int)(8.0 * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 4.0, x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 2.0), 0.0, z_pos, z_pos, Math.random() < 0.75 ? "minecraft:crit" : "minecraft:cloud");
                  }

                  for(int index2 = 0; index2 < (int)(8.0 * range); ++index2) {
                     distance = Mth.nextDouble(RandomSource.create(), 0.0, 5.0 * range);
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, distance, distance, 8.0, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:crit");
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                  entity.getPersistentData().putDouble("BlockRange", 1.0 * d);
                  entity.getPersistentData().putDouble("BlockDamage", 0.33);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            } else if (entity.getPersistentData().getDouble("cnt1") > 25.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            entity.getPersistentData().putDouble("y_knockback", 0.0);
         }

      }
   }
}
