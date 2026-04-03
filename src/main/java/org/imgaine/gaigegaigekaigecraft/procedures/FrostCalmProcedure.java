package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostCalmProcedure {
   public FrostCalmProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double CNT6 = 0.0;
         double range_2 = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         picth = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(picth) * -1.0 * (1.5 + (double)entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
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
               if (GetDistanceProcedure.execute(entity) > 8.0) {
                  label287: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label288: {
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
                                 break label288;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label287;
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
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 8.0));
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 8.0) {
               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 1, 0.0, 0.0, 0.0, 0.0);
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                     entity.getPersistentData().putDouble("cnt7", 1.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.5);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 1, 0.0, 0.0, 0.0, 0.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
               }
            }
         }

         LivingEntity var90;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var90 = _mobEnt.getTarget();
         } else {
            var90 = null;
         }

         if (var90 instanceof LivingEntity) {
            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.getTarget();
            } else {
               var10004 = null;
            }

            double var92 = ((Entity)var10004).getX();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.getTarget();
            } else {
               var10005 = null;
            }

            double var93 = ((Entity)var10005).getY();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var93 += (double)((Entity)var10006).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var10002 = new Vec3(var92, var93, ((Entity)var10006).getZ());
            entity.lookAt(var10001, var10002);
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") >= 10.0) {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 10.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().putDouble("cnt7", entity.getLookAngle().x);
               entity.getPersistentData().putDouble("cnt8", entity.getLookAngle().y);
               entity.getPersistentData().putDouble("cnt9", entity.getLookAngle().z);
               entity.getPersistentData().putDouble("x_pos", x_pos);
               entity.getPersistentData().putDouble("y_pos", y_pos);
               entity.getPersistentData().putDouble("z_pos", z_pos);
               entity.getPersistentData().putDouble("cnt10", x_pos);
               entity.getPersistentData().putDouble("cnt4", y_pos);
               entity.getPersistentData().putDouble("cnt5", z_pos);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity77 = (LivingEntity)entity;
                  if (_livingEntity77.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity77.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(207.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            ParticleGeneratorProcedure.execute(world, ReturnEntitySizeProcedure.execute(entity) * 0.1, 10.0 * ReturnEntitySizeProcedure.execute(entity), 15.0, 4.0, entity.getPersistentData().getDouble("cnt10"), entity.getPersistentData().getDouble("cnt10") + entity.getPersistentData().getDouble("cnt7"), entity.getPersistentData().getDouble("cnt4"), entity.getPersistentData().getDouble("cnt4") + entity.getPersistentData().getDouble("cnt8"), entity.getPersistentData().getDouble("cnt5"), entity.getPersistentData().getDouble("cnt5") + entity.getPersistentData().getDouble("cnt9"), "gaigegaigekaigecraft:particle_ice");
            range = Math.min(1.0, entity.getPersistentData().getDouble("cnt2") * 0.075);

            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = entity.getPersistentData().getDouble("x_pos");
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos");
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 0.2F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
                  }
               }

               entity.getPersistentData().putDouble("BlockRange", Math.max(8.0 * range, 3.0));
               BlockToIceProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
               entity.getPersistentData().putDouble("Range", Math.max(16.0 * range, 3.0));
               entity.getPersistentData().putDouble("knockback", 0.01);
               entity.getPersistentData().putDouble("effect", 14.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               logic_a = false;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(Math.max(16.0 * range, 3.0) / 2.0), (e) -> true)) {
                  if (entityiterator.isAlive() && entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     entity.getPersistentData().putDouble("x_pos", entityiterator.getX());
                     entity.getPersistentData().putDouble("y_pos", entityiterator.getY());
                     entity.getPersistentData().putDouble("z_pos", entityiterator.getZ());
                     break;
                  }
               }

               if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() || logic_a) {
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 12.0);
                  yaw = (double)entity.getYRot();
                  picth = (double)entity.getXRot();

                  for(int index1 = 0; index1 < (int)(12.0 * CNT6); ++index1) {
                     range = 6.0 * CNT6 * Math.random();
                     num1 = Math.toRadians(Math.random() * 720.0);
                     x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(num1) * range;
                     y_pos = entity.getPersistentData().getDouble("y_pos");
                     z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(num1) * range;
                     logic_a = false;
                     entity.setYRot((float)(Math.toDegrees(num1) - 90.0));
                     entity.setXRot((float)(30.0 * (range / -8.0) + -90.0));
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     int var91;
                     label232: {
                        entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.0);
                        entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.0);
                        entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var91 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label232;
                           }
                        }

                        var91 = 0;
                     }

                     HP = (double)(40 + var91 * 8);
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ICE_SPEAR_2.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                              entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
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
                              LivingEntity _livingEntity130 = (LivingEntity)entityinstance;
                              if (_livingEntity130.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                 _livingEntity130.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.setHealth((float)HP);
                           }

                           entityinstance.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power"));
                           entityinstance.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power"));
                           entityinstance.getPersistentData().putDouble("move", 0.0);
                           entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity145 = (LivingEntity)entityinstance;
                              if (_livingEntity145.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity145.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(0.1);
                              }
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  }

                  entity.setYRot((float)yaw);
                  entity.setXRot((float)picth);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
                  break;
               }

               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("cnt7"));
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("cnt8"));
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("cnt9"));
            }

            if (entity.getPersistentData().getDouble("cnt3") == 0.0 && entity.getPersistentData().getDouble("cnt2") >= 40.0 || entity.getPersistentData().getDouble("cnt3") >= 12.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
