package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.SlotEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IdleDeathGambleActiveProcedure {
   public IdleDeathGambleActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double num1;
         double num2;
         double range;
         label284: {
            double z_center = 0.0;
            range = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double y_center = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double num_reserve = 0.0;
            double x_center = 0.0;
            num1 = 0.0;
            double pitch = 0.0;
            double y_pos = 0.0;
            double num3 = 0.0;
            num2 = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  double var77 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label284;
               }
            }

            double var10000 = 0.0;
         }

         if (!entity.getPersistentData().getBoolean("Failed")) {
            if (entity.getPersistentData().getDouble("Reserve") != 0.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (!(entity.getPersistentData().getDouble("Reserve") > 0.0)) {
                  num1 = 0.0;

                  for(int index1 = 0; index1 < 3; ++index1) {
                     ++num1;
                     if (!(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("SLOT" + Math.round(num1))) instanceof LivingEntity)) {
                        num2 = 0.0;
                        entity.getPersistentData().putDouble("Reserve", 0.0);

                        for(int index2 = 0; index2 < 3; ++index2) {
                           ++num2;
                           entity.getPersistentData().putString("SLOT" + Math.round(num1), "");
                        }
                        break;
                     }
                  }
               } else {
                  if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                     entity.getPersistentData().putDouble("NameRanged", Math.random());
                  }

                  double var42 = (double)entity.getYRot();
                  double var47 = (double)entity.getXRot();
                  double var44 = entity.getPersistentData().getDouble("x_pos_doma");
                  double var39 = entity.getPersistentData().getDouble("y_pos_doma");
                  double var35 = entity.getPersistentData().getDouble("z_pos_doma");
                  RotateEntityProcedure.execute(var44, var39, var35, entity);
                  double var48 = var39 + 2.0;
                  double var43 = entity.getPersistentData().getDouble("Reserve");
                  if (var43 < 5.0 && Math.random() < var43 * 0.05) {
                     var43 = 13.0;
                  }

                  for(int index0 = 0; index0 < 3; ++index0) {
                     ++num1;
                     if (num1 == 1.0) {
                        num2 = 0.0;
                     } else if (num1 == 2.0) {
                        num2 = 90.0;
                     } else if (num1 == 3.0) {
                        num2 = -90.0;
                     }

                     double var37 = var44 + Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * (range * 0.5 - 8.0) + Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F) + num2)) * Math.min(4.5, Math.abs(num2));
                     double var40 = var35 + Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * (range * 0.5 - 8.0) + Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F) + num2)) * Math.min(4.5, Math.abs(num2));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(var37, var48, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.playLocalSound(var37, var48, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.SLOT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var37, var48, var40), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                              entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                           }

                           entityinstance.setYRot(entity.getYRot() + 180.0F);
                           entityinstance.setXRot(0.0F);
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                           if (entityinstance instanceof SlotEntity) {
                              SlotEntity _datEntSetI = (SlotEntity)entityinstance;
                              _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_MODE, (int)(4.0 - num1));
                           }

                           entity.getPersistentData().putString("SLOT" + Math.round(4.0 - num1), entityinstance.getStringUUID());
                           double var50 = 0.0;
                           if (!(var43 < 10.0)) {
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 2147483647, 10, false, false));
                                 }
                              }
                           } else {
                              if (var43 > 0.0 && var43 < 5.0) {
                                 var50 = (var43 - 1.0) * 2.0;
                                 if (entity.getPersistentData().getDouble("mode_hakari") == 1.0 || entity.getPersistentData().getDouble("mode_hakari") == 2.0) {
                                    var50 += 4.0;
                                 }

                                 var50 = Math.min(var50, 9.0);
                              } else if (var43 >= 5.0) {
                                 var50 = 10.0;
                              }

                              if (var50 > 0.0 && entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 2147483647, (int)(var50 - 1.0), false, false));
                                 }
                              }
                           }

                           if ((entity.getPersistentData().getDouble("mode_hakari") == 1.0 || entity.getPersistentData().getDouble("mode_hakari") >= 10.0) && entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2147483647, 4, false, false));
                              }
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  }

                  entity.setYRot((float)var42);
                  entity.setXRot((float)var47);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.getPersistentData().putDouble("Reserve", entity.getPersistentData().getDouble("Reserve") * -1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt49 = (LivingEntity)entity;
                     if (_livEnt49.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label241: {
                              var10003 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                    break label241;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001 = new MobEffectInstance(var10003, 100, var10005, false, false);
                           _entity.addEffect(var10001);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("mode_hakari") == 2.0) {
               if (Math.random() < 0.025) {
                  num1 = Math.toRadians(Math.random() * 360.0);
                  num2 = range / 2.0 - 4.0;
                  double var38 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
                  double var49 = entity.getPersistentData().getDouble("y_pos_doma") + 5.0;
                  double var41 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
                  if (Math.random() < 0.25) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var78 = _level.getServer().getCommands();
                        CommandSourceStack var82 = (new CommandSourceStack(CommandSource.NULL, new Vec3(var38, var49, var41), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                        double var10002 = Math.random();
                        var78.performPrefixedCommand(var82, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var10002 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16711680],FadeColors:[I;16711680]}]}}}}");
                     }
                  } else if (Math.random() < 0.25) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var79 = _level.getServer().getCommands();
                        CommandSourceStack var83 = (new CommandSourceStack(CommandSource.NULL, new Vec3(var38, var49, var41), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                        double var86 = Math.random();
                        var79.performPrefixedCommand(var83, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var86 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16774912],FadeColors:[I;16774912]}]}}}}");
                     }
                  } else if (Math.random() < 0.25) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var80 = _level.getServer().getCommands();
                        CommandSourceStack var84 = (new CommandSourceStack(CommandSource.NULL, new Vec3(var38, var49, var41), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                        double var87 = Math.random();
                        var80.performPrefixedCommand(var84, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var87 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;43775],FadeColors:[I;43775]}]}}}}");
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var81 = _level.getServer().getCommands();
                     CommandSourceStack var85 = (new CommandSourceStack(CommandSource.NULL, new Vec3(var38, var49, var41), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                     double var88 = Math.random();
                     var81.performPrefixedCommand(var85, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var88 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;65442],FadeColors:[I;65442]}]}}}}");
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), 10, range * 0.25, range * 0.25, range * 0.25, 0.1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ELECTRIC_SPARK, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), 10, range * 0.25, range * 0.25, range * 0.25, 0.1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.GLOW, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), 10, range * 0.25, range * 0.25, range * 0.25, 0.1);
               }
            }

            if (entity.getPersistentData().getBoolean("StartDomainAttack")) {
               entity.getPersistentData().putBoolean("StartDomainAttack", false);
               Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.technique.hakari1").getString() + "\"}");
                  }

                  if (entity.getPersistentData().getDouble("mode_hakari") == 0.0) {
                     if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s subtitle {\"text\":\"" + Component.translatable("jujutsu.technique.hakari2").getString() + "\"}");
                     }
                  } else if (entity.getPersistentData().getDouble("mode_hakari") == 2.0) {
                     if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s subtitle {\"text\":\"" + Component.translatable("jujutsu.technique.hakari3").getString() + "\"}");
                     }
                  } else if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s subtitle {\"text\":\"" + Component.translatable("jujutsu.technique.hakari4").getString() + "\"}");
                  }
               }
            }
         }

      }
   }
}
