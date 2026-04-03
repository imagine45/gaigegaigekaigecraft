package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RangeAttackProcedure {
   public RangeAttackProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logicDamageEffect = false;
         boolean guard = false;
         boolean betrayal = false;
         boolean BlackFlash = false;
         boolean highPower = false;
         boolean logic_knockback = false;
         boolean blackflashable = false;
         boolean logic_swing = false;
         double range = 0.0;
         double x_pos = 0.0;
         double knockback = 0.0;
         double x_knockback = 0.0;
         double num1 = 0.0;
         double z_knockback = 0.0;
         double y_pos = 0.0;
         double damage_source_player = 0.0;
         double num2 = 0.0;
         double old_health = 0.0;
         double z_pos = 0.0;
         double damage_sorce = 0.0;
         double y_knockback = 0.0;
         double distance = 0.0;
         double H_original = 0.0;
         double M_original = 0.0;
         double Y_limit = 0.0;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
         }

         blackflashable = entity.getPersistentData().getDouble("Damage") >= 9.0;
         highPower = entity.getPersistentData().getDouble("Damage") >= 24.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, highPower ? 1 : 0, false, false));
            }
         }

         DamageFixProcedure.execute(entity);
         damage_source_player = entity.getPersistentData().getDouble("Damage");
         if (entity.getPersistentData().getDouble("KnockbackFix") != 0.0 && entity.getPersistentData().getBoolean("attack") && entity.getPersistentData().getDouble("knockback") >= 1.0) {
            entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * (1.0 + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6") * 0.2, entity.getPersistentData().getDouble("cnt5") * 0.005), 1.0) * entity.getPersistentData().getDouble("KnockbackFix")));
         }

         BlackFlash = false;
         if (blackflashable && entity.getPersistentData().getBoolean("attack")) {
            label513: {
               if (entity instanceof Player) {
                  if (!(pVars.PlayerCursePowerFormer > 150.0)) {
                     break label513;
                  }
               } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:black_flash_able")))) {
                  break label513;
               }

               if (entity.getPersistentData().getDouble("skill") != 2105.0 && entity.getPersistentData().getDouble("cnt6") >= 0.0) {
                  num1 = 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt17 = (LivingEntity)entity;
                     if (_livEnt17.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        double var10000;
                        int var10001;
                        label503: {
                           var10000 = num1 + 2.0;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                                 break label503;
                              }
                           }

                           var10001 = 0;
                        }

                        num1 = var10000 + (double)var10001;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt19 = (LivingEntity)entity;
                     if (_livEnt19.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                        double var148;
                        int var10002;
                        label492: {
                           var148 = num1 + 75.0;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                 var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get()).getAmplifier();
                                 break label492;
                              }
                           }

                           var10002 = 0;
                        }

                        num1 = var148 + (double)(5 * (var10002 + 1));
                     }
                  }

                  label483: {
                     if (entity instanceof Player) {
                        if (!(entity instanceof ServerPlayer)) {
                           break label483;
                        }

                        ServerPlayer _plr22 = (ServerPlayer)entity;
                        if (!(_plr22.level() instanceof ServerLevel) || !_plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:black_flash"))).isDone()) {
                           break label483;
                        }
                     } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:black_flash_able")))) {
                        break label483;
                     }

                     ++num1;
                  }

                  int var149;
                  label473: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                           var149 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                           break label473;
                        }
                     }

                     var149 = 0;
                  }

                  if (var149 > 0) {
                     num1 += 5.0;
                  }

                  label467: {
                     if (entity instanceof Player) {
                        if (pVars.PlayerCurseTechnique != 21.0 && pVars.PlayerCurseTechnique2 != 21.0) {
                           break label467;
                        }
                     } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                        break label467;
                     }

                     num1 += 3.0;
                  }

                  float var163;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var163 = _livEnt.getHealth();
                  } else {
                     var163 = -1.0F;
                  }

                  var163 = Math.max(var163, 1.0F);
                  float var10003;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.getMaxHealth();
                  } else {
                     var10003 = -1.0F;
                  }

                  num1 += (double)((1.0F - var163 / Math.max(var10003, 1.0F)) * 2.0F);
                  num1 += entity.getPersistentData().getDouble("cnt6") * 2.0;

                  for(int index0 = 0; index0 < (int)Math.round(num1); ++index0) {
                     if (Math.random() > 0.998) {
                        BlackFlash = true;
                        break;
                     }
                  }
               }
            }
         }

         if (!entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         }

         if (!(entity_a instanceof LivingEntity)) {
            ;
         }

         x_pos = x;
         y_pos = y;
         z_pos = z;
         range = entity.getPersistentData().getDouble("Range");
         Y_limit = 1.5;

         for(int index1 = 0; index1 < 2; ++index1) {
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
               guard = false;
               logic_knockback = false;
               betrayal = LogicBetrayalProcedure.execute(entity, entityiterator);
               knockback = entity.getPersistentData().getDouble("knockback");
               if (entity != entityiterator || betrayal) {
                  if (!(entityiterator instanceof LivingEntity) && entity.getPersistentData().getBoolean("ExtinctionBlock")) {
                     if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                     }
                  } else {
                     if (LogicAttackProcedure.execute(world, entity, entityiterator) || betrayal) {
                        EffectConfirmProcedure.execute(world, x, y, z, entity, entityiterator);
                        damage_sorce = damage_source_player;
                        if (BlackFlash && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           double var150;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var150 = (double)_livEnt.getHealth();
                           } else {
                              var150 = -1.0;
                           }

                           old_health = var150;
                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))), 0.1F);
                           float var151;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var151 = _livEnt.getHealth();
                           } else {
                              var151 = -1.0F;
                           }

                           if ((double)var151 < old_health) {
                              damage_sorce = damage_source_player * 4.0;
                              highPower = true;
                           } else {
                              BlackFlash = false;
                           }
                        }

                        if (LogicGuardSuccessProcedure.execute(entityiterator, entity)) {
                           label556: {
                              label435: {
                                 guard = true;
                                 num1 = Math.max(damage_sorce - entityiterator.getPersistentData().getDouble("Damage"), 0.0);
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt48 = (LivingEntity)entityiterator;
                                    if (_livEnt48.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                       break label435;
                                    }
                                 }

                                 if (!entityiterator.getPersistentData().getBoolean("guard") && !entityiterator.getPersistentData().getBoolean("attack")) {
                                    break label556;
                                 }
                              }

                              knockback *= damage_sorce == 0.0 ? 1.0 : Math.max(num1 / damage_sorce, 0.1);
                           }
                        }

                        damage_sorce *= ChangeDamage1Procedure.execute(world, entity, entityiterator);
                        damage_sorce *= ChangeDamage2Procedure.execute();
                        if (damage_sorce > 0.0) {
                           double var152;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var152 = (double)_livEnt.getHealth();
                           } else {
                              var152 = -1.0;
                           }

                           old_health = var152;
                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse"))), entity), (float)damage_sorce);
                           float var153;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var153 = _livEnt.getHealth();
                           } else {
                              var153 = -1.0F;
                           }

                           if ((double)var153 != old_health) {
                              logic_knockback = true;
                              EffectProcedure.execute(world, x, y, z, entity, entityiterator);
                              if (BlackFlash) {
                                 BlackFlash = false;
                                 if (entity instanceof Player && world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                                    pVars.PlayerFame += 200.0;
                                    pVars.PlayerExperience += 200.0;
                                    pVars.PlayerTechniqueUsedNumber += 2500.0;
                                    pVars.syncPlayerVariables(entity);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ENTITY_BLACK_FLASH.get()).spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                       entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 6000, 0, true, true));
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt62 = (LivingEntity)entity;
                                    if (_livEnt62.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                       int var154;
                                       label416: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                var154 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier();
                                                break label416;
                                             }
                                          }

                                          var154 = 0;
                                       }
                                       int var155;
                                       label411: {
                                          num1 = (double)Math.max(var154, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                var155 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                                                break label411;
                                             }
                                          }

                                          var155 = 0;
                                       }

                                       num2 = (double)Math.max(var155 - 2000, 0);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get());
                                       }

                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FATIGUE.get(), (int)num2, (int)num1, false, false));
                                          }
                                       }
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt67 = (LivingEntity)entity;
                                    if (_livEnt67.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                       int var156;
                                       label400: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                var156 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getAmplifier();
                                                break label400;
                                             }
                                          }

                                          var156 = 0;
                                       }
                                       int var157;
                                       label395: {
                                          num1 = (double)Math.max(var156, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                var157 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getDuration();
                                                break label395;
                                             }
                                          }

                                          var157 = 0;
                                       }

                                       num2 = (double)Math.max(var157 - 2000, 0);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get());
                                       }

                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), (int)num2, (int)num1, false, false));
                                          }
                                       }
                                    }
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:black_flash"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              }

                              logic_swing = true;
                           }
                        }

                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.isAlive()) {
                           entity.getPersistentData().putBoolean("Stop", true);
                        }
                     }

                     double var158;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var158 = _projEnt.getDeltaMovement().length();
                     } else {
                        var158 = 0.0;
                     }

                     if (var158 > 0.0 && entity.getPersistentData().getDouble("projectile_type") != 0.0 && entityiterator.getPersistentData().getDouble("Damage") < entity.getPersistentData().getDouble("Damage")) {
                        logic_swing = true;
                        logic_knockback = true;
                     }

                     if (entity != entityiterator && logic_knockback && knockback > 0.0) {
                        x_knockback = entityiterator.getX() - entity.getX();
                        y_knockback = entityiterator.getY() - entity.getY();
                        z_knockback = entityiterator.getZ() - entity.getZ();
                        if (entityiterator.onGround()) {
                           y_knockback = Math.abs(y_knockback);
                        }

                        if (x_knockback == 0.0 && z_knockback == 0.0) {
                           x_knockback = Mth.nextDouble(RandomSource.create(), y_knockback * -1.0, y_knockback);
                           z_knockback = Mth.nextDouble(RandomSource.create(), y_knockback * -1.0, y_knockback);
                        }

                        distance = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                        if (distance != 0.0) {
                           knockback *= 3.0;
                           x_knockback = x_knockback / distance * knockback;
                           y_knockback = y_knockback / distance * knockback;
                           z_knockback = z_knockback / distance * knockback;
                           if (y_knockback > Y_limit) {
                              M_original = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                              H_original = Math.sqrt(x_knockback * x_knockback + z_knockback * z_knockback);
                              knockback = Math.sqrt(M_original * M_original - Y_limit * Y_limit);
                              knockback /= H_original != 0.0 ? H_original : 1.0;
                              x_knockback *= knockback;
                              y_knockback = Y_limit;
                              z_knockback *= knockback;
                           }

                           if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                              float var165;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var165 = _livEnt.getHealth();
                              } else {
                                 var165 = -1.0F;
                              }

                              var165 = Math.max(var165, 1.0F);
                              float var167;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var167 = _livEnt.getMaxHealth();
                              } else {
                                 var167 = -1.0F;
                              }
                              int var159;
                              label367: {
                                 knockback = (double)(4.0F * (1.0F - var165 / Math.max(var167, 1.0F)));
                                 x_knockback *= knockback;
                                 y_knockback *= knockback;
                                 z_knockback *= knockback;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                       var159 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                       break label367;
                                    }
                                 }

                                 var159 = 0;
                              }

                              if (var159 < 1 && x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback > 100.0) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 50, 2.0, 2.0, 2.0, 2.0);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 50, 2.0, 2.0, 2.0, 2.0);
                                 }

                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                                    } else {
                                       _level.playLocalSound(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                                    }
                                 }
                              }
                           }

                           x_knockback += entity.getPersistentData().getDouble("x_knockback");
                           y_knockback += entity.getPersistentData().getDouble("y_knockback");
                           z_knockback += entity.getPersistentData().getDouble("z_knockback");
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity113 = (LivingEntity)entity;
                              if (_livingEntity113.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                                 label359: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livingEntity114 = (LivingEntity)entityiterator;
                                       if (_livingEntity114.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                                          var158 = _livingEntity114.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue();
                                          break label359;
                                       }
                                    }

                                    var158 = 0.0;
                                 }

                                 knockback = Math.sqrt(Math.max(var158, 0.0) + 1.0);
                                 x_knockback /= knockback;
                                 y_knockback /= knockback;
                                 z_knockback /= knockback;
                              }
                           }

                           entityiterator.setDeltaMovement(new Vec3(x_knockback, y_knockback, z_knockback));
                           entityiterator.getPersistentData().putDouble("old_x_position", entityiterator.getPersistentData().getDouble("old_x_position") - x_knockback);
                           entityiterator.getPersistentData().putDouble("old_y_position", entityiterator.getPersistentData().getDouble("old_y_position") - y_knockback);
                           entityiterator.getPersistentData().putDouble("old_z_position", entityiterator.getPersistentData().getDouble("old_z_position") - z_knockback);
                        }
                     }
                  }
               }
            }

            if (!(entity instanceof LivingEntity)) {
               break;
            }

            LivingEntity _livEnt123 = (LivingEntity)entity;
            if (!_livEnt123.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().getBoolean("Failed") || entity.getPersistentData().getBoolean("attack") || entity.getPersistentData().getBoolean("DomainAttack")) {
               break;
            }

            double var161;
            int var162;
            label333: {
               x_pos = entity.getPersistentData().getDouble("x_pos_doma");
               y_pos = entity.getPersistentData().getDouble("y_pos_doma");
               z_pos = entity.getPersistentData().getDouble("z_pos_doma");
               var161 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var162 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                     break label333;
                  }
               }

               var162 = 0;
            }

            range = var161 * (double)(var162 > 0 ? 6 : 2);
            entity.getPersistentData().putBoolean("DomainAttack", true);
         }

         entity.getPersistentData().putDouble("effect", 0.0);
         entity.getPersistentData().putDouble("effectConfirm", 0.0);
         entity.getPersistentData().putDouble("projectile_type", 0.0);
         entity.getPersistentData().putBoolean("attack", false);
         entity.getPersistentData().putBoolean("ignore", false);
         entity.getPersistentData().putBoolean("DomainAttack", false);
      }
   }
}
