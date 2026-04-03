package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FrameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;

public class SkillProjectionSorceryProcedure {
   public SkillProjectionSorceryProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         boolean move_flag = false;
         String STR1 = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double size = 0.0;
         double dis = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_num = 0.0;
         double strength = 0.0;

         for(int index0 = 0; index0 < 2; ++index0) {
            int var10001;
            label237: {
               STR1 = entity.getDisplayName().getString();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label237;
                  }
               }

               var10001 = 0;
            }

            strength = 0.5 + (double)Math.min(var10001, 10) * 0.1 * 0.5;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               String var70;
               label230: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _teamEnt = (LivingEntity)entity;
                     Scoreboard var10000 = _teamEnt.level().getScoreboard();
                     String var72;
                     if (_teamEnt instanceof Player) {
                        Player _pl = (Player)_teamEnt;
                        var72 = _pl.getGameProfile().getName();
                     } else {
                        var72 = _teamEnt.getStringUUID();
                     }

                     if (var10000.getPlayersTeam(var72) != null) {
                        var10000 = _teamEnt.level().getScoreboard();
                        if (_teamEnt instanceof Player) {
                           Player _pl = (Player)_teamEnt;
                           var72 = _pl.getGameProfile().getName();
                        } else {
                           var72 = _teamEnt.getStringUUID();
                        }

                        var70 = var10000.getPlayersTeam(var72).getName();
                        break label230;
                     }
                  }

                  var70 = "";
               }

               if (var70.equals(STR1)) {
                  entity.getPersistentData().putDouble("cnt10", 1.0);
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team add " + STR1);
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team join " + STR1 + " @s");
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team modify " + STR1 + " seeFriendlyInvisibles true");
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team modify " + STR1 + " nametagVisibility hideForOwnTeam");
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team modify " + STR1 + " collisionRule pushOwnTeam");
               }
            } else {
               entity.getPersistentData().putDouble("cnt4", Math.sqrt(Math.pow(entity.getPersistentData().getDouble("old_x") - entity.getX(), 2.0) + Math.pow(entity.getPersistentData().getDouble("old_y") - entity.getY(), 2.0) + Math.pow(entity.getPersistentData().getDouble("old_z") - entity.getZ(), 2.0)));
               if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt4"));
               }

               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + (Math.sqrt(Math.max(entity.getPersistentData().getDouble("cnt1") * 0.5, 1.0)) * 0.5 + 0.5) * strength);
               dis = entity.getPersistentData().getDouble("cnt2");
               entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX());
               entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY());
               entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ());
               if (entity.getPersistentData().getDouble("cnt1") <= 21.0 && entity.getPersistentData().getDouble("cnt1") == 2.0) {
                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  x_pos = entity.getX();
                  y_pos = entity.getY();
                  z_pos = entity.getZ();
                  if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                     entity.getPersistentData().putDouble("NameRanged", Math.random());
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_PROJECTION_SORCERY.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.setYRot((float)yaw);
                        entityinstance.setXRot((float)pitch);
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                        }

                        entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                        entityinstance.getPersistentData().putDouble("cnt5", (double)Math.round(1.0F));
                        entityinstance.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos"));
                        entityinstance.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos"));
                        entityinstance.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos"));
                        entityinstance.getPersistentData().putString("owner_name", STR1);
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        entityinstance.setInvisible(true);
                        entityinstance.setCustomName(Component.literal("FRAME" + Math.round(1.0F)));
                        PlayerTeam _pt = entityinstance.level().getScoreboard().getPlayerTeam(STR1);
                        if (_pt != null) {
                           if (entityinstance instanceof Player) {
                              Player _player = (Player)entityinstance;
                              entityinstance.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), _pt);
                           } else {
                              entityinstance.level().getScoreboard().addPlayerToTeam(entityinstance.getStringUUID(), _pt);
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") >= 6.0) {
                  if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                     if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
                        entity.getPersistentData().putDouble("cnt3", 1.0);
                        entity.getPersistentData().putDouble("cnt5", 0.0);
                     }
                  } else {
                     entity.fallDistance = 0.0F;
                     if (entity.getPersistentData().getDouble("cnt7") != 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 20, 0, false, false));
                           }
                        }

                        entity.getPersistentData().putDouble("skill", 0.0);
                        if (entity.getPersistentData().getDouble("cnt10") == 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team remove " + STR1);
                        }
                        break;
                     }

                     entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                     x_power = entity.getX() - entity.getPersistentData().getDouble("old_x");
                     y_power = entity.getY() - entity.getPersistentData().getDouble("old_y");
                     z_power = entity.getZ() - entity.getPersistentData().getDouble("old_z");
                     dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                     if (dis > 0.0) {
                        x_pos = entity.getX();
                        y_pos = entity.getY();
                        z_pos = entity.getZ();
                        x_power /= dis;
                        y_power /= dis;
                        z_power /= dis;

                        for(int index1 = 0; index1 < (int)Math.round(dis); ++index1) {
                           Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos);

                           for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate((2.0 + ReturnEntitySizeProcedure.execute(entity)) / 2.0), (e) -> true)) {
                              if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !(entityiterator instanceof FrameEntity) && !(entityiterator instanceof DomainExpansionEntityEntity) && entityiterator.getPersistentData().getDouble("select") == 0.0) {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt94 = (LivingEntity)entityiterator;
                                    if (_livEnt94.hasEffect((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                                       continue;
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt95 = (LivingEntity)entityiterator;
                                    if (_livEnt95.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       continue;
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.swing(InteractionHand.MAIN_HAND, true);
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 30, 0, false, false));
                                    }
                                 }
                              }
                           }

                           x_pos += x_power * 1.0;
                           y_pos += y_power * 1.0;
                           z_pos += z_power * 1.0;
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt5") >= 20.0) {
                        entity.getPersistentData().putDouble("skill", 0.0);
                        if (entity.getPersistentData().getDouble("cnt10") == 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "team remove " + STR1);
                        }
                        break;
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("old_x", entity.getX());
            entity.getPersistentData().putDouble("old_y", entity.getY());
            entity.getPersistentData().putDouble("old_z", entity.getZ());
         }

      }
   }
}
