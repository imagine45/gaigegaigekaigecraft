package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class KashimoDomainActiveProcedure {
   public KashimoDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_target;
         double y_target;
         double z_target;
         double dis;
         double num1;
         double power;
         double num3;
         double num2;
         double range;
         double var10000;
         label243: {
            boolean logic_attack = false;
            boolean logic_a = false;
            double repeat_num = 0.0;
            double y_pos_test = 0.0;
            x_target = 0.0;
            double old_skill = 0.0;
            range = 0.0;
            double x_pos = 0.0;
            y_target = 0.0;
            z_target = 0.0;
            dis = 0.0;
            double x_pos_test = 0.0;
            double x_power = 0.0;
            num1 = 0.0;
            double y_pos = 0.0;
            power = 0.0;
            double num4 = 0.0;
            num3 = 0.0;
            double energy = 0.0;
            num2 = 0.0;
            double z_pos_test = 0.0;
            double tick = 0.0;
            double z_pos = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double repeat_num_now = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label243;
               }
            }

            var10000 = 0.0;
         }

         double var88 = var10000;
         double var61 = entity.getPersistentData().getDouble("skill");
         if (!entity.getPersistentData().getBoolean("Failed")) {
            double var63 = entity.getPersistentData().getDouble("x_pos_doma");
            double var77 = entity.getPersistentData().getDouble("y_pos_doma");
            double var89 = entity.getPersistentData().getDouble("z_pos_doma");
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), var63, var77 - 0.75, var89, 15, range * 0.175, 0.1, range * 0.175, 0.05);
            }

            if (var88 % 20.0 == 0.0) {
               boolean var56 = false;
               entity.getPersistentData().putDouble("skill", 705.0);
               Vec3 _center = new Vec3(var63, var77, var89);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator.getPersistentData().getDouble("Thunder") >= 6.0) {
                     boolean var58 = true;
                     var56 = true;
                     power = Math.min(entityiterator.getPersistentData().getDouble("Thunder"), 16.0) - 6.0;
                     dis = Math.sqrt(Math.pow(entityiterator.getX() - var63, 2.0) + Math.pow(entityiterator.getY() - (var77 + range * 0.5 - 2.0), 2.0) + Math.pow(entityiterator.getZ() - var89, 2.0));
                     x_target = entityiterator.getX();
                     y_target = entityiterator.getY();
                     z_target = entityiterator.getZ();
                     entityiterator.getPersistentData().putDouble("Thunder", 0.0);
                     break;
                  }
               }

               if (var56) {
                  var77 = var77 + range * 0.5 - 2.0;
                  double var84 = 1.0 + power * 0.05;
                  double var59 = (double)Math.round(dis * 4.0 + 4.0);
                  double var102 = 0.0;

                  for(int index0 = 0; index0 < (int)var59; ++index0) {
                     var102 = (double)Math.round(var102 + 1.0);
                     double var70 = x_target - var63;
                     double var94 = y_target - var77;
                     double var98 = z_target - var89;
                     dis = Math.sqrt(Math.pow(var70, 2.0) + Math.pow(var94, 2.0) + Math.pow(var98, 2.0));
                     if (dis != 0.0) {
                        var70 /= dis * 4.0;
                        var94 /= dis * 4.0;
                        var98 /= dis * 4.0;
                        if (var102 < var59) {
                           if (var102 % 4.0 == 1.0 || world.getBlockState(BlockPos.containing(var63 + var70 * 2.0, var77 + var94 * 2.0, var89 + var98 * 2.0)).canOcclude()) {
                              for(int index1 = 0; index1 < 32; ++index1) {
                                 var70 = (Math.random() - 0.5) * dis * 3.0;
                                 var94 = (Math.random() - 0.5) * dis * 3.0;
                                 var98 = (Math.random() - 0.5) * dis * 3.0;
                                 var70 = x_target + var70;
                                 var94 = y_target + var94;
                                 var98 = z_target + var98;
                                 num1 = var70 - var63;
                                 num2 = var94 - var77;
                                 num3 = var98 - var89;
                                 double var83 = Math.sqrt(Math.pow(num1, 2.0) + Math.pow(num2, 2.0) + Math.pow(num3, 2.0));
                                 if (var83 != 0.0) {
                                    num1 /= var83 * 4.0;
                                    num2 /= var83 * 4.0;
                                    num3 /= var83 * 4.0;
                                 }

                                 var70 = num1;
                                 var94 = num2;
                                 var98 = num3;
                                 double var69 = var63;
                                 double var60 = var77;
                                 double var87 = var89;
                                 var56 = true;

                                 for(int index2 = 0; index2 < 2; ++index2) {
                                    if (world.getBlockState(BlockPos.containing(var69, var60, var87)).canOcclude()) {
                                       var56 = false;
                                       break;
                                    }

                                    var69 += var70;
                                    var60 += var94;
                                    var87 += var98;
                                 }

                                 if (var56) {
                                    break;
                                 }
                              }
                           }

                           var70 = num1;
                           var94 = num2;
                           var98 = num3;
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(var63, var77, var89), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.973 0.220 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                     }

                     if (var102 % 2.0 == 0.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var63, var77, var89, 1, 0.1, 0.1, 0.1, 0.0);
                        }

                        if (var102 % 4.0 == 0.0) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles(ParticleTypes.FLASH, var63, var77, var89, 1, 0.1, 0.1, 0.1, 0.0);
                           }

                           entity.getPersistentData().putDouble("Damage", 30.0 * var84);
                           entity.getPersistentData().putDouble("Range", 5.0);
                           entity.getPersistentData().putDouble("knockback", 0.1);
                           entity.getPersistentData().putDouble("projectile_type", 1.0);
                           entity.getPersistentData().putDouble("effect", 1.0);
                           RangeAttackProcedure.execute(world, var63, var77, var89, entity);
                           if (world.getBlockState(BlockPos.containing(var63, var77, var89)).canOcclude()) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var63, var77, var89, (int)(4.0 * var84), 0.25, 0.25, 0.25, 0.5 * var84);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.EXPLOSION, var63, var77, var89, (int)(4.0 * var84), 0.25, 0.25, 0.25, 0.5 * var84);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.CLOUD, var63, var77, var89, (int)(4.0 * var84), 0.25, 0.25, 0.25, 0.5 * var84);
                              }
                           }
                        }
                     }

                     if (var102 + 1.0 >= var59) {
                        if (dis > 1.5) {
                           var59 = (double)Math.round(var59 + 1.0);
                        } else if (var102 >= var59) {
                           if (dis < 0.3) {
                              break;
                           }

                           var59 = (double)Math.round(var59 + 1.0);
                        }
                     }

                     var63 += var70;
                     var77 += var94;
                     var89 += var98;
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)var84, 1.5F);
                     } else {
                        _level.playLocalSound(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)var84, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 1.0F);
                     } else {
                        _level.playLocalSound(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 0.5F);
                     } else {
                        _level.playLocalSound(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 1.0F);
                     } else {
                        _level.playLocalSound(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 0.5F);
                     } else {
                        _level.playLocalSound(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var63, var77, var89, (int)(50.0 * var84), 0.5, 0.5, 0.5, 1.0 * var84);
                  }
               }
            }
         }

         double var64 = entity.getPersistentData().getDouble("x_pos_doma");
         double var79 = entity.getPersistentData().getDouble("y_pos_doma");
         double var90 = entity.getPersistentData().getDouble("z_pos_doma");
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), var64, var79 + range / 2.0 * 0.7, var90, 5, range * 0.125, 0.1, range * 0.125, 0.05);
         }

         if (var88 % 10.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
            if (Math.random() < 0.5) {
               num1 = Math.toRadians(Math.random() * 360.0);
               num2 = Math.random() * range - range / 2.0;
               var64 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
               var79 = entity.getPersistentData().getDouble("y_pos_doma");
               var90 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var64, var79, var90, 10, 0.25, 4.0, 0.25, 0.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var64, var79, var90), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 0.1F, 1.0F);
                  } else {
                     _level.playLocalSound(var64, var79, var90, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 0.1F, 1.0F, false);
                  }
               }
            }

            if (var88 % 30.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
               entity.getPersistentData().putBoolean("StartDomainAttack", false);
               entity.getPersistentData().putDouble("skill", 1.0);
               entity.getPersistentData().putDouble("Damage", 1.0);
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putBoolean("swing", false);
               entity.getPersistentData().putBoolean("attack", true);
               entity.getPersistentData().putBoolean("DomainAttack", true);
               RangeAttackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
            }
         }

         if (var88 % 10.0 == 0.0) {
            num1 = Math.toRadians(Math.random() * 720.0);
            var64 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range / 2.0 - 5.0);
            var79 = entity.getPersistentData().getDouble("y_pos_doma");
            var90 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range / 2.0 - 5.0);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var64, var79, var90, 10, 0.1, 4.0, 0.1, 0.1);
            }
         }

         if (entity.getPersistentData().getDouble("cnt2_forDomain") > 20.0) {
            entity.getPersistentData().putDouble("cnt1_forDomain", Math.toRadians((Math.random() - 0.5) * 360.0));
            entity.getPersistentData().putDouble("cnt2_forDomain", 0.0);
         }

         num1 = entity.getPersistentData().getDouble("cnt1_forDomain");
         num2 = entity.getPersistentData().getDouble("cnt2_forDomain");

         for(int index3 = 0; index3 < 40; ++index3) {
            var64 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
            var79 = entity.getPersistentData().getDouble("y_pos_doma") + range * 0.5 - num2;
            var90 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
            if (Math.random() < 0.25 + num2 / (range * 0.5)) {
               if (Math.random() < 0.3 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var64, var79, var90, 1, 0.0, 0.05, 0.0, 0.0);
               }

               if (Math.random() < 0.1 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLASH, var64, var79, var90, 1, 0.0, 0.05, 0.0, 0.0);
               }
            }

            num1 += Math.toRadians((Math.random() - 0.5) * 10.0);
            num2 += 0.1;
            if (num2 > range * 0.5 - 4.0) {
               num1 = Math.toRadians(Math.random() * 720.0);
               num2 = 0.0;
            }
         }

         entity.getPersistentData().putDouble("cnt1_forDomain", num1);
         entity.getPersistentData().putDouble("cnt2_forDomain", num2);
         entity.getPersistentData().putDouble("skill", var61);
      }
   }
}
