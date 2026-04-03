package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GaragaraProcedure {
   public GaragaraProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         boolean logic_a;
         double CNT6;
         int var10000;
         label490: {
            SUCCESS = false;
            logic_a = false;
            Entity target_entity = null;
            double strength = 0.0;
            double distance = 0.0;
            double HP = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double dis = 0.0;
            CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double old_cnt6 = 0.0;
            double rad = 0.0;
            double x_power = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label490;
               }
            }

            var10000 = 0;
         }

         double var44 = (double)Math.min(var10000, 50);
         double var53 = ReturnEntitySizeProcedure.execute(entity) * (1.0 + var44 * 0.025) * CNT6;
         double var54 = entity.getX();
         double var74 = entity.getY() + (double)entity.getBbHeight() * 0.5;
         double var58 = entity.getZ();
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.fallDistance = 0.0F;
         LivingEntity var127;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var127 = _mobEnt.getTarget();
         } else {
            var127 = null;
         }

         Entity var43 = var127;
         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
            if (var43 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var43).getX(), ((Entity)var43).getY() + (double)((Entity)var43).getBbHeight() * 0.5, ((Entity)var43).getZ(), entity);
            }

            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 3, false, false));
                  }
               }

               if (var43 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 8.0 && (((Entity)var43).getPersistentData().getDouble("skill") == 0.0 || ((Entity)var43).getPersistentData().getDouble("Damage") == 0.0)) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt3", Math.min(entity.getPersistentData().getDouble("cnt3"), 0.0));
                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     ChangeCurseEnergyProcedure.execute(entity, -1.0);
                     if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, var54, var74, var58, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity42 = (LivingEntity)entity;
                  if (_livingEntity42.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity42.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-10.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity43 = (LivingEntity)entity;
                  if (_livingEntity43.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity43.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt3") >= 10.0) {
               if (var43 instanceof LivingEntity) {
                  var54 = ((Entity)var43).getX();
                  var74 = ((Entity)var43).getY() + (double)(((Entity)var43).getBbHeight() * 0.0F);
                  var58 = ((Entity)var43).getZ();
               } else {
                  double var63 = 6.0;

                  for(int index0 = 0; index0 < 6; ++index0) {
                     var54 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var63)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
                     var74 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var63)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
                     var58 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var63)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
                     Vec3 _center = new Vec3(var54, var74, var58);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var54 = entityiterator.getX();
                           var74 = entityiterator.getY() + (double)(entityiterator.getBbHeight() * 0.0F);
                           var58 = entityiterator.getZ();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     var63 += 6.0;
                  }
               }

               double var72 = var54 - entity.getX();
               double var66 = var74 - (entity.getY() + (double)(entity.getBbHeight() * 0.0F));
               double var68 = var58 - entity.getZ();
               double var45 = Math.sqrt(var72 * var72 + var66 * var66 + var68 * var68);
               if (var45 > 1.0) {
                  var72 /= var45;
                  double var128 = var66 / var45;
                  var68 /= var45;
               }

               entity.getPersistentData().putDouble("x_power", var72 * 1.0);
               entity.getPersistentData().putDouble("z_power", var68 * 1.0);
               entity.getPersistentData().putDouble("cnt7", var45 / 2.0);
               entity.getPersistentData().putDouble("cnt9", var74 - (entity.getY() + (double)(entity.getBbHeight() * 0.0F)));
               entity.getPersistentData().putDouble("cnt10", Math.max(Math.sqrt(var45) * 3.0, 3.0));
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               entity.getPersistentData().putDouble("cnt1", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") != 0.0) {
            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               ChargeParticleProcedure.execute(world, entity, 10.0);
            } else {
               ChargeParticleProcedure.execute(world, entity, 0.0);
            }

            if (var43 instanceof LivingEntity) {
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
                  LivingEntity _livingEntity96 = (LivingEntity)entity;
                  if (_livingEntity96.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity96.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity97 = (LivingEntity)entity;
                  if (_livingEntity97.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity97.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var73 = entity.getPersistentData().getDouble("x_power") * 2.0;
               double var67 = entity.getPersistentData().getDouble("y_power") * 2.0;
               double var69 = entity.getPersistentData().getDouble("z_power") * 2.0;
               entity.setDeltaMovement(new Vec3(var73, var67, var69));
               double var64 = Math.sqrt(var73 * var73 + var67 * var67 + var69 * var69);
               if (var64 != 0.0) {
                  var73 /= var64;
                  var67 /= var64;
                  var69 /= var64;
               }

               var54 = entity.getX();
               var74 = entity.getY() + (double)entity.getBbHeight() * 0.5;
               var58 = entity.getZ();
               entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.1);
               entity.getPersistentData().putDouble("y_knockback", entity.getDeltaMovement().y() * 1.1);
               entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.1);

               for(int index1 = 0; index1 < (int)Math.max(var64, 1.0); ++index1) {
                  entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 3.0 * var53);
                  entity.getPersistentData().putDouble("knockback", 0.6);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, var54, var74, var58, entity);
                  Vec3 _center = new Vec3(var54, var74, var58);

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

                  var54 += var73;
                  var74 += var67;
                  var58 += var69;
               }

               entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
               entity.getPersistentData().putBoolean("attack", true);
               DamageFixProcedure.execute(entity);
               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
               if (entity.onGround() && entity.getPersistentData().getDouble("cnt1") > 5.0) {
                  entity.getPersistentData().putDouble("cnt1", 1.0);
                  entity.getPersistentData().putDouble("cnt4", 1.0);
                  double var62 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  double var78 = Math.toRadians(0.0);
                  double var46 = (double)(1.0F * entity.getBbWidth());
                  entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(var62) * Math.cos(var78) * var46);
                  entity.getPersistentData().putDouble("y_pos", entity.getY() + Math.sin(var78) * -1.0 * var46);
                  entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(var62) * Math.cos(var78) * var46);
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity143 = (LivingEntity)entity;
                     if (_livingEntity143.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity143.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity144 = (LivingEntity)entity;
                     if (_livingEntity144.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity144.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
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
                     LivingEntity _livingEntity150 = (LivingEntity)entity;
                     if (_livingEntity150.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity150.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity151 = (LivingEntity)entity;
                     if (_livingEntity151.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity151.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               var54 = entity.getPersistentData().getDouble("x_pos");
               var74 = entity.getPersistentData().getDouble("y_pos");
               var58 = entity.getPersistentData().getDouble("z_pos");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), var54, var74 + 0.5, var58, 1, 0.0, 0.0, 0.0, 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt1") < 5.0) {
                  if (entity.getPersistentData().getDouble("cnt1") <= 3.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 0.75F);
                        } else {
                           _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 1.25F);
                        } else {
                           _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt1") <= 2.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.5F);
                           } else {
                              _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.75F);
                           } else {
                              _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.75F, false);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt1") < 5.0) {
                     entity.getPersistentData().putDouble("y_knockback", 0.5);
                     double var70 = entity.getPersistentData().getDouble("cnt6");
                     entity.getPersistentData().putDouble("cnt6", -1.0);
                     entity.getPersistentData().putDouble("Damage", 35.0);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("Range", 5.0 * var53);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, var54, var74, var58, entity);
                     entity.getPersistentData().putDouble("Damage", 24.0);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("Range", 10.0 * var53);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, var54, var74, var58, entity);
                     entity.getPersistentData().putDouble("cnt6", var70);
                     entity.getPersistentData().putDouble("BlockDamage", 6.0 + var44 / 16.0);
                     entity.getPersistentData().putDouble("BlockRange", 10.0 * var53);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var54, var74, var58, entity);
                  }

                  for(int index2 = 0; index2 < (int)(24.0 * var53); ++index2) {
                     double var47 = Mth.nextDouble(RandomSource.create(), 0.0, 20.0 * var53);
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var47, var47, Mth.nextDouble(RandomSource.create(), 0.0, 4.0), var54, var54 + 0.0, var74 - 1.0, var74 + 0.0, 0.0, var58, var58 + 0.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                  }

                  for(int index3 = 0; index3 < (int)(8.0 * var53); ++index3) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 4.0, var54, var54 + 0.0, var74 - 1.0, var74 + Mth.nextDouble(RandomSource.create(), -1.0, -0.5), 0.0, var58, var58 + 0.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                  }
               }

               for(int index4 = 0; index4 < (int)(24.0 * var53); ++index4) {
                  double var48 = Mth.nextDouble(RandomSource.create(), 0.0, 20.0 * var53);
                  ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var48, var48, Mth.nextDouble(RandomSource.create(), 0.0, 10.0), var54, var54 + 0.0, var74 - 1.0, var74 + 0.0, 0.0, var58, var58 + 0.0, "minecraft:crit");
               }

               for(int index5 = 0; index5 < (int)(8.0 * var53); ++index5) {
                  ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 8.0, var54, var54 + 0.0, var74 + -1.0, var74 + Mth.nextDouble(RandomSource.create(), -1.0, 0.0), 0.0, var58, var58 + 0.0, "minecraft:crit");
               }

               if (entity.getPersistentData().getDouble("cnt1") >= 20.0) {
                  for(int index6 = 0; index6 < (int)(8.0 * var53); ++index6) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 16.0, var54, var54 + 0.0, var74, var74 + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, var58, var58 + 0.0, "minecraft:crit");
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 8.0, var54, var54 + 0.0, var74, var74 + Mth.nextDouble(RandomSource.create(), 0.0, 0.5), 0.0, var58, var58 + 0.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                  }

                  if (entity.getPersistentData().getDouble("cnt1") == 20.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 0.75F);
                        } else {
                           _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 1.25F);
                        } else {
                           _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 1.25F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 0.75F);
                        } else {
                           _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 1.25F);
                        } else {
                           _level.playLocalSound(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * 2.0), 1.25F, false);
                        }
                     }

                     entity.getPersistentData().putDouble("BlockDamage", 0.33);
                     entity.getPersistentData().putDouble("BlockRange", var44 * 1.0);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var54, var74, var58, entity);

                     for(int index7 = 0; index7 < (int)(64.0 * var53); ++index7) {
                        double var49 = Mth.nextDouble(RandomSource.create(), 0.0, 20.0 * var53);
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var49, var49 * var49, 0.0, var54, var54 + 0.0, var74 + Mth.nextDouble(RandomSource.create(), 0.0, 5.0 * var53), var74 + Mth.nextDouble(RandomSource.create(), 0.0, 5.0 * var53), 0.0, var58, var58 + 0.0, "explosion");
                     }

                     for(int index8 = 0; index8 < (int)(64.0 * var53); ++index8) {
                        double var50 = Mth.nextDouble(RandomSource.create(), 0.0, 20.0 * var53);
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var50, var50 * var50, Mth.nextDouble(RandomSource.create(), 0.0, 16.0), var54, var54 + 0.0, var74 - 1.0, var74 + 0.0, 0.0, var58, var58 + 0.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                     }

                     int var10001;
                     label353: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label353;
                           }
                        }

                        var10001 = 0;
                     }

                     double var52 = (double)(20 + var10001 * 4);

                     for(int index9 = 0; index9 < 15; ++index9) {
                        double var51 = Mth.nextDouble(RandomSource.create(), (double)(2.0F + entity.getBbWidth()), 20.0 * var53);
                        double var71 = Mth.nextDouble(RandomSource.create(), -360.0, 360.0);
                        var54 = entity.getPersistentData().getDouble("x_pos") + Math.cos(var71) * var51;
                        var74 = entity.getPersistentData().getDouble("y_pos");
                        var58 = entity.getPersistentData().getDouble("z_pos") + Math.sin(var71) * var51;
                        logic_a = false;
                        if (world.getBlockState(BlockPos.containing(var54, var74, var58)).canOcclude()) {
                           var74 = entity.getPersistentData().getDouble("y_pos");

                           for(int index10 = 0; index10 < (int)Math.round(var51 * 2.0); ++index10) {
                              ++var74;
                              if (!world.getBlockState(BlockPos.containing(var54, var74, var58)).canOcclude()) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        } else if (!world.getBlockState(BlockPos.containing(var54, var74 - 1.0, var58)).canOcclude()) {
                           var74 = entity.getPersistentData().getDouble("y_pos");

                           for(int index11 = 0; index11 < (int)Math.round(var51 * 2.0); ++index11) {
                              --var74;
                              if (world.getBlockState(BlockPos.containing(var54, var74 - 1.0, var58)).canOcclude()) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        } else {
                           logic_a = true;
                        }

                        if (logic_a && world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var54, var74, var58), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity218 = (LivingEntity)entityinstance;
                                 if (_livingEntity218.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                    _livingEntity218.getAttribute(Attributes.MAX_HEALTH).setBaseValue(var52);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.setHealth((float)var52);
                              }

                              entityinstance.setDeltaMovement(new Vec3((Math.random() - 0.5) * 3.0, (Math.random() * 1.5 + 0.75) * CNT6, (Math.random() - 0.5) * 3.0));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity224 = (LivingEntity)entityinstance;
                                 if (_livingEntity224.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    _livingEntity224.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue((Math.random() + 1.5) * CNT6);
                                 }
                              }

                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
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
