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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackOverheadSuperProcedure {
   public AttackOverheadSuperProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         boolean logic_a;
         int var10000;
         label301: {
            double strength = 0.0;
            double distance = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double dis = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            double old_cnt6 = 0.0;
            Entity target_entity = null;
            SUCCESS = false;
            logic_a = false;
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label301;
               }
            }

            var10000 = 0;
         }

         double var38 = (double)Math.min(var10000, 50);
         double var42 = ReturnEntitySizeProcedure.execute(entity) * (1.0 + var38 * 0.025);
         double var52 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         double var43 = entity.getX();
         double var59 = entity.getY() + (double)entity.getBbHeight() * 0.5;
         double var46 = entity.getZ();
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.fallDistance = 0.0F;
         LivingEntity var94;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var94 = _mobEnt.getTarget();
         } else {
            var94 = null;
         }

         Entity var64 = var94;
         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
            if (var64 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var64).getX(), ((Entity)var64).getY() + (double)((Entity)var64).getBbHeight() * 0.5, ((Entity)var64).getZ(), entity);
            }

            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity23 = (LivingEntity)entity;
                  if (_livingEntity23.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity23.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-10.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity24 = (LivingEntity)entity;
                  if (_livingEntity24.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity24.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt3") >= 10.0) {
               if (var64 instanceof LivingEntity) {
                  var43 = ((Entity)var64).getX();
                  var59 = ((Entity)var64).getY() + (double)(((Entity)var64).getBbHeight() * 0.0F);
                  var46 = ((Entity)var64).getZ();
               } else {
                  double var50 = 6.0;

                  for(int index0 = 0; index0 < 6; ++index0) {
                     var43 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var50)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
                     var59 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var50)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
                     var46 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var50)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
                     Vec3 _center = new Vec3(var43, var59, var46);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var43 = entityiterator.getX();
                           var59 = entityiterator.getY() + (double)(entityiterator.getBbHeight() * 0.0F);
                           var46 = entityiterator.getZ();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     var50 += 6.0;
                  }
               }

               double var57 = var43 - entity.getX();
               double var53 = var59 - (entity.getY() + (double)(entity.getBbHeight() * 0.0F));
               double var55 = var46 - entity.getZ();
               double var39 = Math.sqrt(var57 * var57 + var53 * var53 + var55 * var55);
               if (var39 > 1.0) {
                  var57 /= var39;
                  double var95 = var53 / var39;
                  var55 /= var39;
               }

               entity.getPersistentData().putDouble("x_power", var57 * 1.0);
               entity.getPersistentData().putDouble("z_power", var55 * 1.0);
               entity.getPersistentData().putDouble("cnt7", var39 / 2.0);
               entity.getPersistentData().putDouble("cnt9", var59 - (entity.getY() + (double)(entity.getBbHeight() * 0.0F)));
               entity.getPersistentData().putDouble("cnt10", Math.max(Math.sqrt(var39) * 3.0, 3.0));
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               entity.getPersistentData().putDouble("cnt1", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") != 0.0) {
            if (var64 instanceof LivingEntity) {
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

            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
            entity.getPersistentData().putDouble("y_power", (entity.getPersistentData().getDouble("cnt9") / entity.getPersistentData().getDouble("cnt7") + entity.getPersistentData().getDouble("cnt10") * 4.0 / entity.getPersistentData().getDouble("cnt7") - entity.getPersistentData().getDouble("cnt10") * 8.0 / (entity.getPersistentData().getDouble("cnt7") * entity.getPersistentData().getDouble("cnt7")) * (entity.getPersistentData().getDouble("cnt5") - 0.0)) * 0.5);
            if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity76 = (LivingEntity)entity;
                  if (_livingEntity76.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity76.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity77 = (LivingEntity)entity;
                  if (_livingEntity77.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity77.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var58 = entity.getPersistentData().getDouble("x_power") * 2.0;
               double var54 = entity.getPersistentData().getDouble("y_power") * 2.0;
               double var56 = entity.getPersistentData().getDouble("z_power") * 2.0;
               entity.setDeltaMovement(new Vec3(var58, var54, var56));
               double var51 = Math.sqrt(var58 * var58 + var54 * var54 + var56 * var56);
               if (var51 != 0.0) {
                  var58 /= var51;
                  var54 /= var51;
                  var56 /= var51;
               }

               var43 = entity.getX();
               var59 = entity.getY() + (double)entity.getBbHeight() * 0.5;
               var46 = entity.getZ();
               entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.1);
               entity.getPersistentData().putDouble("y_knockback", entity.getDeltaMovement().y() * 1.1);
               entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.1);

               for(int index1 = 0; index1 < (int)Math.max(var51, 1.0); ++index1) {
                  entity.getPersistentData().putDouble("Damage", 9.0 * var52);
                  entity.getPersistentData().putDouble("Range", 3.0 * var42);
                  entity.getPersistentData().putDouble("knockback", 0.6);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, var43, var59, var46, entity);
                  Vec3 _center = new Vec3(var43, var59, var46);

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

                  var43 += var58;
                  var59 += var54;
                  var46 += var56;
               }

               entity.getPersistentData().putDouble("Damage", 15.0 * var52);
               entity.getPersistentData().putBoolean("attack", true);
               DamageFixProcedure.execute(entity);
               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
               if (entity.onGround() && entity.getPersistentData().getDouble("cnt1") > 5.0) {
                  entity.getPersistentData().putDouble("cnt1", 1.0);
                  entity.getPersistentData().putDouble("cnt4", 1.0);
                  double var49 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  double var62 = Math.toRadians(0.0);
                  double var40 = (double)(1.0F * entity.getBbWidth());
                  entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(var49) * Math.cos(var62) * var40);
                  entity.getPersistentData().putDouble("y_pos", entity.getY() + Math.sin(var62) * -1.0 * var40);
                  entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(var49) * Math.cos(var62) * var40);
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity123 = (LivingEntity)entity;
                     if (_livingEntity123.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity123.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity124 = (LivingEntity)entity;
                     if (_livingEntity124.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity124.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               } else if (entity.getPersistentData().getDouble("cnt1") > 80.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt4") > 0.0) {
               if (!(entity instanceof Player) || entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity130 = (LivingEntity)entity;
                     if (_livingEntity130.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity130.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity131 = (LivingEntity)entity;
                     if (_livingEntity131.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity131.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               var43 = entity.getPersistentData().getDouble("x_pos");
               var59 = entity.getPersistentData().getDouble("y_pos");
               var46 = entity.getPersistentData().getDouble("z_pos");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
                  if (entity.getPersistentData().getDouble("cnt1") <= 3.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 0.75F);
                        } else {
                           _level.playLocalSound(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 1.25F);
                        } else {
                           _level.playLocalSound(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 1.25F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 0.75F);
                        } else {
                           _level.playLocalSound(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 1.25F);
                        } else {
                           _level.playLocalSound(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt1") <= 2.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.5F);
                           } else {
                              _level.playLocalSound(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.75F);
                           } else {
                              _level.playLocalSound(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.75F, false);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt1") < 5.0) {
                     entity.getPersistentData().putDouble("y_knockback", 0.5);
                     double var63 = entity.getPersistentData().getDouble("cnt6");
                     entity.getPersistentData().putDouble("cnt6", -1.0);
                     entity.getPersistentData().putDouble("Damage", 24.0);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("Range", 8.0 * var42);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, var43, var59, var46, entity);
                     entity.getPersistentData().putDouble("cnt6", var63);
                     entity.getPersistentData().putDouble("BlockDamage", 6.0 + var38 / 16.0);
                     entity.getPersistentData().putDouble("BlockRange", 4.0 * var42);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var43, var59, var46, entity);
                  }

                  for(int index2 = 0; index2 < (int)(24.0 * var42); ++index2) {
                     double var41 = Mth.nextDouble(RandomSource.create(), 0.0, 4.0 * var42);
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var41, var41, Mth.nextDouble(RandomSource.create(), 1.0, 8.0), var43, var43 + 0.0, var59, var59 + 1.0, 0.0, var46, var46 + 0.0, "minecraft:crit");
                  }

                  for(int index3 = 0; index3 < (int)(8.0 * var42); ++index3) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 8.0, var43, var43 + 0.0, var59, var59 + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, var46, var46 + 0.0, "minecraft:crit");
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 4.0, var43, var43 + 0.0, var59, var59 + Mth.nextDouble(RandomSource.create(), 0.0, 0.5), 0.0, var46, var46 + 0.0, "minecraft:cloud");
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                  entity.getPersistentData().putDouble("BlockDamage", 0.33);
                  entity.getPersistentData().putDouble("BlockRange", var38 * 1.0);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, var43, var59, var46, entity);
               }

               if (entity.getPersistentData().getDouble("cnt1") > 25.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

         entity.getPersistentData().putDouble("old_x", entity.getX());
         entity.getPersistentData().putDouble("old_y", entity.getY() + (double)entity.getBbHeight() * 0.5);
         entity.getPersistentData().putDouble("old_z", entity.getZ());
      }
   }
}
