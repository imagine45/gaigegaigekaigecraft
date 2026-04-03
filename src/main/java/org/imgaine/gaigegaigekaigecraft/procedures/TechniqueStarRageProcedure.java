package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.TsukumoYukiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueStarRageProcedure {
   public TechniqueStarRageProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean actived = false;
         double timer = 0.0;
         double strength = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double dis = 0.0;
         if (entity.getPersistentData().getDouble("skill") == 915.0 && entity.getPersistentData().getDouble("cnt1") == 0.0) {
            entity.getPersistentData().putDouble("cnt1", 61.0);
            entity.getPersistentData().putDouble("cnt2", 1.0);
            entity.getPersistentData().putDouble("cnt3", -2.0);
         }

         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt3") <= 0.0) {
            double var10000;
            label304: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                     break label304;
                  }
               }

               var10000 = 0.0;
            }

            strength = var10000;
            actived = true;
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               label297: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        if (strength < 5.0) {
                           strength = 5.0;
                        } else if (strength < 9.0) {
                           strength = 9.0;
                        } else {
                           strength = -1.0;
                        }
                        break label297;
                     }
                  }

                  strength = 2.0;
               }
            } else if (entity.getPersistentData().getDouble("cnt3") == -1.0) {
               if (entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0) {
                  if (strength < 9.0) {
                     strength = Math.min(strength + 1.0, 9.0);
                  } else {
                     actived = false;
                  }
               } else {
                  actived = false;
               }
            } else if (entity.getPersistentData().getDouble("cnt3") == -2.0) {
               if (strength >= 255.0) {
                  entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
                  strength = 255.0 + Math.pow(entity.getPersistentData().getDouble("cnt4") + 1.0, 3.0);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 80.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else {
                  strength = Math.min(Math.max(strength, 9.0) + 20.0, 255.0);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 40.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            } else {
               actived = false;
            }

            if (actived) {
               if (strength >= 0.0) {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s gaigegaigekaigecraft:star_rage infinite " + Math.round(strength) + " true");
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        String var10001 = Component.translatable("effect.star_rage").getString();
                        _player.displayClientMessage(Component.literal(var10001 + ": " + Math.round((strength + 1.0) * 10.0) + "%"), false);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(Component.translatable("effect.star_rage").getString() + ": OFF"), false);
                     }
                  }
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
               }
            }
         }

         if (!(entity instanceof Player)) {
            entity.getPersistentData().putBoolean("PRESS_Z", false);
            LivingEntity var72;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var72 = _mobEnt.getTarget();
            } else {
               var72 = null;
            }

            if (var72 instanceof LivingEntity && entity instanceof TsukumoYukiEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
            }
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (!entity.getPersistentData().getBoolean("PRESS_Z") && !(entity.getPersistentData().getDouble("cnt2") > 0.0)) {
            entity.getPersistentData().putDouble("skill", 0.0);
         } else if (entity.getPersistentData().getDouble("cnt1") > 230.0) {
            label238: {
               if (entity instanceof Player && entity instanceof Player) {
                  Player _plr = (Player)entity;
                  if (_plr.getAbilities().instabuild) {
                     break label238;
                  }
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         } else if (entity.getPersistentData().getDouble("cnt1") > 60.0) {
            if (entity.getPersistentData().getDouble("skill") == 915.0) {
               int var73;
               label282: {
                  entity.getPersistentData().putDouble("cnt2", 1.0);
                  entity.getPersistentData().putDouble("cnt3", -2.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        var73 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                        break label282;
                     }
                  }

                  var73 = 0;
               }

               label277: {
                  strength = (double)Math.round((double)var73 * 0.1);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        var73 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                        break label277;
                     }
                  }

                  var73 = 0;
               }

               timer = (double)Math.round((float)(var73 * 2));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)timer, 1, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)Math.min(timer, 200.0), (int)Math.min(strength, 3.0), false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 61.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") > 100.0) {
                  if (entity.getPersistentData().getDouble("cnt1") == 101.0) {
                     int var75;
                     label264: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var75 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label264;
                           }
                        }

                        var75 = 0;
                     }

                     HP = (double)(500 + var75 * 50);
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLACK_HOLE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                              LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                              if (_livingEntity64.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                 _livingEntity64.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.setHealth((float)HP);
                           }

                           entityinstance.getPersistentData().putDouble("cnt6", 30.0);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity70 = (LivingEntity)entityinstance;
                              if (_livingEntity70.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity70.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(8.0);
                              }
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }

                     entity.getPersistentData().putDouble("x_pos", entity.getX());
                     entity.getPersistentData().putDouble("y_pos", entity.getY());
                     entity.getPersistentData().putDouble("z_pos", entity.getZ());
                  }

                  DamageSource var76 = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC));
                  float var10002;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getHealth();
                  } else {
                     var10002 = -1.0F;
                  }

                  entity.hurt(var76, (float)((double)var10002 * 0.5));
                  if (entity.getPersistentData().getDouble("cnt1") > 140.0) {
                     entity.getPersistentData().putDouble("cnt3", 1.0);
                  }

                  entity.getPersistentData().putDouble("Damage", 35.0);
               } else {
                  entity.getPersistentData().putDouble("Damage", 20.0);
               }

               DamageFixProcedure.execute(entity);
               range = ReturnEntitySizeProcedure.execute(entity);

               for(int index0 = 0; index0 < 8; ++index0) {
                  x_pos = entity.getX() + (Math.random() - 0.5) * 25.0 * range;
                  y_pos = entity.getY() + (Math.random() - 0.5) * 25.0 * range;
                  z_pos = entity.getZ() + (Math.random() - 0.5) * 25.0 * range;
                  x_power = entity.getX() - x_pos;
                  y_power = entity.getY() - y_pos;
                  z_power = entity.getZ() - z_pos;
                  dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                  if (dis != 0.0) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:squid_ink ~ ~ ~ " + x_power * 10000.0 + " " + y_power * 10000.0 + " " + z_power * 10000.0 + " 0.001 0 force");
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") != 915.0) {
               label337: {
                  if (entity instanceof Player) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr94 = (ServerPlayer)entity;
                        if (_plr94.level() instanceof ServerLevel && _plr94.getAdvancements().getOrStartProgress(_plr94.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_black_hole"))).isDone()) {
                           break label337;
                        }
                     }

                     if (entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) {
                           break label337;
                        }
                     }
                  } else if (entity instanceof TsukumoYukiEntity) {
                     break label337;
                  }

                  entity.getPersistentData().putDouble("skill", 0.0);
                  return;
               }

               entity.getPersistentData().putDouble("skill", 915.0);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("cnt3", -1.0);
         } else {
            entity.getPersistentData().putDouble("cnt3", 1.0);
         }

      }
   }
}
