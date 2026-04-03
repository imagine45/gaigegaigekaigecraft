package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityCrackEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ThinIceBreakerProcedure {
   public ThinIceBreakerProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6;
         int var10000;
         label253: {
            boolean logic_a = false;
            boolean player = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            double strength = 0.0;
            double range = 0.0;
            double loop_num = 0.0;
            CNT6 = 0.0;
            double rad_now = 0.0;
            double num1 = 0.0;
            double num3 = 0.0;
            double soundPitch = 0.0;
            double num2 = 0.0;
            double x_center = 0.0;
            double y_center = 0.0;
            double z_center = 0.0;
            player = entity instanceof Player;
            CNT6 = 1.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label253;
               }
            }

            var10000 = 0;
         }

         double var62 = (double)Math.min(var10000, 50);
         double var63 = ReturnEntitySizeProcedure.execute(entity) * (1.0 + var62 * 0.025);
         entity.getPersistentData().putDouble("cnt1", (double)Math.round(entity.getPersistentData().getDouble("cnt1") + 1.0));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         LivingEntity var87;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var87 = _mobEnt.getTarget();
         } else {
            var87 = null;
         }

         if (var87 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var87 = _mobEnt.getTarget();
            } else {
               var87 = null;
            }

            double var53 = ((Entity)var87).getX();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var87 = _mobEnt.getTarget();
            } else {
               var87 = null;
            }

            double var90 = ((Entity)var87).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var55 = var90 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var91;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var91 = _mobEnt.getTarget();
            } else {
               var91 = null;
            }

            double var57 = ((Entity)var91).getZ();
            RotateEntityProcedure.execute(var53, var55, var57, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            double var61 = GetDistanceProcedure.execute(entity);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var87 = _mobEnt.getTarget();
            } else {
               var87 = null;
            }

            if (var87 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (var61 < 3.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var87 = _mobEnt.getTarget();
                  } else {
                     var87 = null;
                  }

                  if (((Entity)var87).getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               } else {
                  label239: {
                     if (!(entity instanceof UroTakakoEntity)) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var87 = _mobEnt.getTarget();
                        } else {
                           var87 = null;
                        }

                        if (((Entity)var87).getPersistentData().getDouble("skill") != 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var87 = _mobEnt.getTarget();
                           } else {
                              var87 = null;
                           }

                           if (((Entity)var87).getPersistentData().getDouble("Damage") != 0.0) {
                              entity.getPersistentData().putBoolean("PRESS_Z", false);
                              break label239;
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

            if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
               entity.getPersistentData().putDouble("cnt6", 5.0);
            } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
               entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 1.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 9.0));
            }

            label260: {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 38.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 38.0) {
                     break label260;
                  }
               } else if (!(entity instanceof UroTakakoEntity)) {
                  break label260;
               }

               label226: {
                  label225: {
                     if (entity instanceof Player) {
                        if (entity.isShiftKeyDown()) {
                           break label225;
                        }
                     } else if (var61 < 3.0) {
                        break label225;
                     }

                     entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.75);
                     entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.75);
                     entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.75);
                     break label226;
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.0);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
               if (entity instanceof Player) {
                  label267: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt66 = (LivingEntity)entity;
                        if (_livEnt66.hasEffect(MobEffects.SLOW_FALLING)) {
                           break label267;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity67 = (LivingEntity)entity;
                        if (_livingEntity67.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity67.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-18.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 5, 0, false, false));
               }
            }

            UroCounterProcedure.execute(world, entity);
         } else {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity74 = (LivingEntity)entity;
                  if (_livingEntity74.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity74.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var59 = Math.toRadians((double)(entity.getYRot() + 90.0F));
               double var60 = Math.toRadians((double)entity.getXRot());
               entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(var59) * Math.cos(var60) * (double)(2.0F + entity.getBbWidth()));
               entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(var60) * -1.0 * (double)(2.0F + entity.getBbWidth()));
               entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(var59) * Math.cos(var60) * (double)(2.0F + entity.getBbWidth()));
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRACK.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos")), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

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
                        LivingEntity _livingEntity100 = (LivingEntity)entityinstance;
                        if (_livingEntity100.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity100.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue((double)((entity.getBbHeight() + entity.getBbWidth()) * 2.0F));
                        }
                     }

                     entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                     if (entity.getPersistentData().getDouble("cnt6") >= 2.5 && entityinstance instanceof EntityCrackEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "attack");
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }

            double var54 = entity.getPersistentData().getDouble("x_pos");
            double var56 = entity.getPersistentData().getDouble("y_pos");
            double var58 = entity.getPersistentData().getDouble("z_pos");
            if (entity.getPersistentData().getDouble("cnt3") <= 0.5 + entity.getPersistentData().getDouble("cnt6") * 0.5) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var54, var56, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 1.0F);
                  } else {
                     _level.playLocalSound(var54, var56, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var54, var56, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 2.0F);
                  } else {
                     _level.playLocalSound(var54, var56, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 2.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), var54, var56, var58, (int)(50.0 * CNT6), 0.25, 0.25, 0.25, 2.0 * CNT6);
               }

               entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
               entity.getPersistentData().putDouble("knockback", 3.0);
               entity.getPersistentData().putDouble("Range", 5.0 * CNT6 * ReturnEntitySizeProcedure.execute(entity));
               entity.getPersistentData().putDouble("projectile_type", 5.0);
               entity.getPersistentData().putBoolean("ignore", true);
               RangeAttackProcedure.execute(world, var54, var56, var58, entity);
               entity.getPersistentData().putDouble("BlockDamage", (2.0 + var62 / 16.0) * CNT6);
               entity.getPersistentData().putDouble("BlockRange", 4.0 * var63 * CNT6);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, var54, var56, var58, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") == 20.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)CNT6, 1.25F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)CNT6, 1.25F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)CNT6, 1.25F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)CNT6, 1.25F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
