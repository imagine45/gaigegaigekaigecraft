package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AITrueSphereProcedure {
   public AITrueSphereProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean LogicOwner = false;
         double x_target = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
               }
            }

            LogicOwner = LogicOwnerExistProcedure.execute(world, entity);
            if (LogicOwner) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                  float var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getHealth();
                  } else {
                     var10000 = -1.0F;
                  }

                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMaxHealth();
                  } else {
                     var10001 = -1.0F;
                  }

                  if (var10000 < var10001) {
                     label211: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt9 = (LivingEntity)entity;
                           if (_livEnt9.hasEffect(MobEffects.REGENERATION)) {
                              break label211;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 51, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity_a;
                     if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                     }
                  }

                  if (entity_a instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 1.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               }

               double var60;
               label201: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entity;
                     if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var60 = _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label201;
                     }
                  }

                  var60 = 0.0;
               }

               if (var60 < 15.0 && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     double var62;
                     AttributeInstance var61;
                     label194: {
                        var61 = _livingEntity17.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity16 = (LivingEntity)entity;
                           if (_livingEntity16.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var62 = _livingEntity16.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                              break label194;
                           }
                        }

                        var62 = 0.0;
                     }

                     var61.setBaseValue(Math.min(var62 + 0.3, 15.0));
                  }
               }

               x_pos = entity.getX();
               y_pos = entity.getY() + (double)(entity.getBbHeight() * 0.0F);
               z_pos = entity.getZ();
               if (entity.getPersistentData().getDouble("move") == 0.0) {
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                        if (entity.getPersistentData().getDouble("cnt_x") == 0.0) {
                           if (entity_a.getPersistentData().getDouble("skill") != 0.0 && entity_a.getPersistentData().getBoolean("attack")) {
                              entity.getPersistentData().putDouble("cnt_x", 1.0);
                           }
                        } else if (entity.getPersistentData().getDouble("cnt_x") == 1.0) {
                           if (entity_a.getPersistentData().getDouble("skill") == 0.0) {
                              entity.getPersistentData().putDouble("cnt_x", 2.0);
                           }
                        } else {
                           entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                           if (entity.getPersistentData().getDouble("cnt_x") > 10.0) {
                              ResetCounterProcedure.execute(entity);
                              entity.getPersistentData().putDouble("cnt_x", 0.0);
                              entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
                              entity.getPersistentData().putDouble("move", entity.getPersistentData().getDouble("cnt_x2"));
                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:1b}");
                              }
                           }
                        }

                        logic_a = true;
                        yaw = (double)entity_a.getYRot();
                        pitch = (double)entity_a.getXRot();
                        x_power = entity.getX();
                        y_power = entity.getY();
                        z_power = entity.getZ();
                        x_target = entity_a.getX() + Math.cos(Math.toRadians(yaw + 90.0 + 180.0)) * 8.0;
                        y_target = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + 2.0;
                        z_target = entity_a.getZ() + Math.sin(Math.toRadians(yaw + 90.0 + 180.0)) * 8.0;
                        if (Math.abs(x_target - x_power) > 0.5) {
                           x_target = x_power + (x_power > x_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(y_target - y_power) > 0.5) {
                           y_target = y_power + (y_power > y_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(z_target - z_power) > 0.5) {
                           z_target = z_power + (z_power > z_target ? -0.5 : 0.5);
                        }

                        entity.teleportTo(x_target, y_target, z_target);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(x_target, y_target, z_target, entity.getYRot(), entity.getXRot());
                        }

                        entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                        entity.setYRot(entity_a.getYRot());
                        entity.setXRot(entity_a.getXRot());
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
                  }

                  if (!logic_a && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               } else {
                  AITrueSphere1Procedure.execute(world, entity);
                  entity.getPersistentData().putDouble("Damage", 30.0);
                  entity.getPersistentData().putDouble("Range", (double)entity.getBbHeight() * 1.2);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  entity.getPersistentData().putBoolean("ignore", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("BlockRange", (double)entity.getBbHeight() * 0.8);
                  entity.getPersistentData().putDouble("BlockDamage", 99999.0);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  entity.getPersistentData().putBoolean("noEffect", true);
                  entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         } else {
            world.levelEvent(2001, BlockPos.containing(x, y + (double)(entity.getBbHeight() * 0.0F), z), Block.getId(((Block)JujutsucraftModBlocks.JUJUTSU_BARRIER.get()).defaultBlockState()));
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y + (double)(entity.getBbHeight() * 0.0F), z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y + (double)(entity.getBbHeight() * 0.0F), z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x, y + (double)(entity.getBbHeight() * 0.0F), z, (int)(ReturnEntitySizeProcedure.execute(entity) * 18.0), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.25);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
