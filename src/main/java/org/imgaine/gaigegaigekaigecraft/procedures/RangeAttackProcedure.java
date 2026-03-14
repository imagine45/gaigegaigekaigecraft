package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
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
import net.minecraft.world.item.ItemStack;
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
         boolean useCurse = false;
         boolean highPower = false;
         boolean logic_knockback = false;
         boolean SwordAttack = false;
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
         blackflashable = entity.getPersistentData().m_128459_("Damage") >= 9.0;
         highPower = entity.getPersistentData().m_128459_("Damage") >= 24.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, highPower ? 1 : 0, false, false));
            }
         }

         DamageFixProcedure.execute(entity);
         damage_source_player = entity.getPersistentData().m_128459_("Damage");
         if (entity.getPersistentData().m_128459_("KnockbackFix") != 0.0 && entity.getPersistentData().m_128471_("attack") && entity.getPersistentData().m_128459_("knockback") >= 1.0) {
            entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (1.0 + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6") * 0.2, entity.getPersistentData().m_128459_("cnt5") * 0.005), 1.0) * entity.getPersistentData().m_128459_("KnockbackFix")));
         }

         BlackFlash = false;
         if (blackflashable && entity.getPersistentData().m_128471_("attack")) {
            label561: {
               if (entity instanceof Player) {
                  if (!(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 150.0)) {
                     break label561;
                  }
               } else if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:black_flash_able")))) {
                  break label561;
               }

               if (entity.getPersistentData().m_128459_("skill") != 2105.0 && entity.getPersistentData().m_128459_("cnt6") >= 0.0) {
                  num1 = 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt17 = (LivingEntity)entity;
                     if (_livEnt17.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        double var10000;
                        int var10001;
                        label551: {
                           var10000 = num1 + 2.0;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                                 break label551;
                              }
                           }

                           var10001 = 0;
                        }

                        num1 = var10000 + (double)var10001;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt19 = (LivingEntity)entity;
                     if (_livEnt19.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                        double var160;
                        int var10002;
                        label540: {
                           var160 = num1 + 75.0;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                 var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get()).m_19564_();
                                 break label540;
                              }
                           }

                           var10002 = 0;
                        }

                        num1 = var160 + (double)(5 * (var10002 + 1));
                     }
                  }

                  label531: {
                     if (entity instanceof Player) {
                        if (!(entity instanceof ServerPlayer)) {
                           break label531;
                        }

                        ServerPlayer _plr22 = (ServerPlayer)entity;
                        if (!(_plr22.m_9236_() instanceof ServerLevel) || !_plr22.m_8960_().m_135996_(_plr22.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:black_flash"))).m_8193_()) {
                           break label531;
                        }
                     } else if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:black_flash_able")))) {
                        break label531;
                     }

                     ++num1;
                  }

                  int var161;
                  label521: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                           var161 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).m_19564_();
                           break label521;
                        }
                     }

                     var161 = 0;
                  }

                  if (var161 > 0) {
                     num1 += 5.0;
                  }

                  label515: {
                     if (entity instanceof Player) {
                        if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 21.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 21.0) {
                           break label515;
                        }
                     } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                        break label515;
                     }

                     num1 += 3.0;
                  }

                  float var179;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var179 = _livEnt.m_21223_();
                  } else {
                     var179 = -1.0F;
                  }

                  var179 = Math.max(var179, 1.0F);
                  float var10003;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.m_21233_();
                  } else {
                     var10003 = -1.0F;
                  }

                  num1 += (double)((1.0F - var179 / Math.max(var10003, 1.0F)) * 2.0F);
                  num1 += entity.getPersistentData().m_128459_("cnt6") * 2.0;

                  for(int index0 = 0; index0 < (int)Math.round(num1); ++index0) {
                     if (Math.random() > 0.998) {
                        BlackFlash = true;
                        break;
                     }
                  }
               }
            }
         }

         useCurse = true;
         if (entity.getPersistentData().m_128471_("attack")) {
            label497: {
               if (entity instanceof Player) {
                  if (!(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer < 100.0)) {
                     break label497;
                  }
               } else if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                  break label497;
               }

               useCurse = false;
            }

            ItemStack var162;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var162 = _livEnt.m_21205_();
            } else {
               var162 = ItemStack.f_41583_;
            }

            if (var162.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var162 = _livEnt.m_21205_();
               } else {
                  var162 = ItemStack.f_41583_;
               }

               if (var162.m_41784_().m_128441_("CursePower")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var162 = _livEnt.m_21205_();
                  } else {
                     var162 = ItemStack.f_41583_;
                  }

                  if (var162.m_41784_().m_128459_("CursePower") != 0.0) {
                     useCurse = true;
                  }
               }
            }
         }

         SwordAttack = LogicSwordProcedure.execute(entity);
         if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         }

         if (!(entity_a instanceof LivingEntity)) {
            ;
         }

         x_pos = x;
         y_pos = y;
         z_pos = z;
         range = entity.getPersistentData().m_128459_("Range");
         Y_limit = 1.5;

         for(int index1 = 0; index1 < 2; ++index1) {
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               guard = false;
               logic_knockback = false;
               betrayal = LogicBetrayalProcedure.execute(entity, entityiterator);
               knockback = entity.getPersistentData().m_128459_("knockback");
               if (entity != entityiterator || betrayal) {
                  if (!(entityiterator instanceof LivingEntity) && entity.getPersistentData().m_128471_("ExtinctionBlock")) {
                     if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                     }
                  } else {
                     if (LogicAttackProcedure.execute(world, entity, entityiterator) || betrayal) {
                        EffectConfirmProcedure.execute(world, x, y, z, entity, entityiterator);
                        damage_sorce = damage_source_player;
                        if (BlackFlash) {
                           double var165;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var165 = (double)_livEnt.m_21223_();
                           } else {
                              var165 = -1.0;
                           }

                           old_health = var165;
                           entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), 0.1F);
                           float var166;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var166 = _livEnt.m_21223_();
                           } else {
                              var166 = -1.0F;
                           }

                           if ((double)var166 < old_health) {
                              damage_sorce = damage_source_player * 4.0;
                              highPower = true;
                           } else {
                              BlackFlash = false;
                           }
                        }

                        if (LogicGuardSuccessProcedure.execute(entityiterator, entity)) {
                           guard = true;
                           num1 = Math.max(damage_sorce - entityiterator.getPersistentData().m_128459_("Damage"), 0.0);
                           if (entityiterator.m_20096_()) {
                              label605: {
                                 label475: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt58 = (LivingEntity)entityiterator;
                                       if (_livEnt58.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                          break label475;
                                       }
                                    }

                                    if (!entityiterator.getPersistentData().m_128471_("guard") && !entityiterator.getPersistentData().m_128471_("attack")) {
                                       break label605;
                                    }
                                 }

                                 if (entity.getPersistentData().m_128471_("attack")) {
                                    knockback *= damage_sorce == 0.0 ? 1.0 : num1 / damage_sorce;
                                 } else {
                                    int var167;
                                    label469: {
                                       knockback *= 0.5;
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                             var167 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                             break label469;
                                          }
                                       }

                                       var167 = 0;
                                    }

                                    if (var167 > 0) {
                                       knockback *= 0.5;
                                    }
                                 }
                              }
                           }
                        }

                        damage_sorce *= ChangeDamage1Procedure.execute(world, entity, entityiterator);
                        damage_sorce *= ChangeDamage2Procedure.execute(world, entity, entityiterator);
                        if (damage_sorce > 0.0) {
                           double var168;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var168 = (double)_livEnt.m_21223_();
                           } else {
                              var168 = -1.0;
                           }

                           old_health = var168;
                           entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse"))), entity), (float)damage_sorce);
                           float var169;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var169 = _livEnt.m_21223_();
                           } else {
                              var169 = -1.0F;
                           }

                           if ((double)var169 != old_health) {
                              logic_knockback = true;
                              EffectProcedure.execute(world, x, y, z, entity, entityiterator);
                              if (BlackFlash) {
                                 BlackFlash = false;
                                 if (world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                                    double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame + 200.0;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                       capability.PlayerFame = _setval;
                                       capability.syncPlayerVariables(entity);
                                    });
                                    _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerExperience + 200.0;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                       capability.PlayerExperience = _setval;
                                       capability.syncPlayerVariables(entity);
                                    });
                                    _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber + 2500.0;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                       capability.PlayerTechniqueUsedNumber = _setval;
                                       capability.syncPlayerVariables(entity);
                                    });
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ENTITY_BLACK_FLASH.get()).m_262496_(_level, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                       entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 6000, 0, true, true));
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt73 = (LivingEntity)entity;
                                    if (_livEnt73.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                       label447: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                var170 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19564_();
                                                break label447;
                                             }
                                          }

                                          var170 = 0;
                                       }

                                       label442: {
                                          num1 = (double)Math.max(var170, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                var171 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                                                break label442;
                                             }
                                          }

                                          var171 = 0;
                                       }

                                       num2 = (double)Math.max(var171 - 2000, 0);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get());
                                       }

                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FATIGUE.get(), (int)num2, (int)num1, false, false));
                                          }
                                       }
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt78 = (LivingEntity)entity;
                                    if (_livEnt78.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                       label431: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                var172 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                                                break label431;
                                             }
                                          }

                                          var172 = 0;
                                       }

                                       label426: {
                                          num1 = (double)Math.max(var172, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                var173 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19557_();
                                                break label426;
                                             }
                                          }

                                          var173 = 0;
                                       }

                                       num2 = (double)Math.max(var173 - 2000, 0);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get());
                                       }

                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), (int)num2, (int)num1, false, false));
                                          }
                                       }
                                    }
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:black_flash"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              }

                              logic_swing = true;
                           }
                        }

                        if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entity.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.m_6084_()) {
                           entity.getPersistentData().m_128379_("Stop", true);
                        }
                     }

                     double var174;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var174 = _projEnt.m_20184_().m_82553_();
                     } else {
                        var174 = 0.0;
                     }

                     if (var174 > 0.0 && entity.getPersistentData().m_128459_("projectile_type") != 0.0 && entityiterator.getPersistentData().m_128459_("Damage") < entity.getPersistentData().m_128459_("Damage")) {
                        logic_swing = true;
                        logic_knockback = true;
                     }

                     if (entity != entityiterator && logic_knockback) {
                        x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                        y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                        z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                        if (entityiterator.m_20096_() || y_knockback == 0.0) {
                           y_knockback = Math.max(Math.abs(y_knockback), 0.42);
                        }

                        if (x_knockback == 0.0 && z_knockback == 0.0) {
                           x_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * -1.0, y_knockback);
                           z_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * -1.0, y_knockback);
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
                              float var181;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var181 = _livEnt.m_21223_();
                              } else {
                                 var181 = -1.0F;
                              }

                              var181 = Math.max(var181, 1.0F);
                              float var183;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var183 = _livEnt.m_21233_();
                              } else {
                                 var183 = -1.0F;
                              }

                              label395: {
                                 knockback = (double)(4.0F * (1.0F - var181 / Math.max(var183, 1.0F)));
                                 x_knockback *= knockback;
                                 y_knockback *= knockback;
                                 z_knockback *= knockback;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                       var175 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                       break label395;
                                    }
                                 }

                                 var175 = 0;
                              }

                              if (var175 < 1 && Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback) > 10.0) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_(), 50, 2.0, 2.0, 2.0, 2.0);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_(), 50, 2.0, 2.0, 2.0, 2.0);
                                 }

                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.m_5776_()) {
                                       _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                                    } else {
                                       _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                                    }
                                 }
                              }
                           }

                           x_knockback += entity.getPersistentData().m_128459_("x_knockback");
                           y_knockback += entity.getPersistentData().m_128459_("y_knockback");
                           z_knockback += entity.getPersistentData().m_128459_("z_knockback");
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity124 = (LivingEntity)entity;
                              if (_livingEntity124.m_21204_().m_22171_(Attributes.f_22278_)) {
                                 label387: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livingEntity125 = (LivingEntity)entityiterator;
                                       if (_livingEntity125.m_21204_().m_22171_(Attributes.f_22278_)) {
                                          var174 = _livingEntity125.getAttribute_(Attributes.f_22278_).m_22115_();
                                          break label387;
                                       }
                                    }

                                    var174 = 0.0;
                                 }

                                 knockback = Math.sqrt(Math.max(var174, 0.0) + 1.0);
                                 x_knockback /= knockback;
                                 y_knockback /= knockback;
                                 z_knockback /= knockback;
                              }
                           }

                           entityiterator.m_20256_(new Vec3(x_knockback, y_knockback, z_knockback));
                           entityiterator.getPersistentData().m_128347_("old_x_position", entityiterator.getPersistentData().m_128459_("old_x_position") - x_knockback);
                           entityiterator.getPersistentData().m_128347_("old_y_position", entityiterator.getPersistentData().m_128459_("old_y_position") - y_knockback);
                           entityiterator.getPersistentData().m_128347_("old_z_position", entityiterator.getPersistentData().m_128459_("old_z_position") - z_knockback);
                        }
                     }
                  }
               }
            }

            if (!(entity instanceof LivingEntity)) {
               break;
            }

            LivingEntity _livEnt134 = (LivingEntity)entity;
            if (!_livEnt134.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().m_128471_("Failed") || entity.getPersistentData().m_128471_("attack") || entity.getPersistentData().m_128471_("DomainAttack")) {
               break;
            }

            double var177;
            int var178;
            label363: {
               x_pos = entity.getPersistentData().m_128459_("x_pos_doma");
               y_pos = entity.getPersistentData().m_128459_("y_pos_doma");
               z_pos = entity.getPersistentData().m_128459_("z_pos_doma");
               var177 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var178 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                     break label363;
                  }
               }

               var178 = 0;
            }

            range = var177 * (double)(var178 > 0 ? 6 : 2);
            entity.getPersistentData().m_128379_("DomainAttack", true);
         }

         entity.getPersistentData().m_128347_("effect", 0.0);
         entity.getPersistentData().m_128347_("effectConfirm", 0.0);
         entity.getPersistentData().m_128347_("knockback", 0.0);
         entity.getPersistentData().m_128347_("projectile_type", 0.0);
         entity.getPersistentData().m_128379_("attack", false);
         entity.getPersistentData().m_128379_("ignore", false);
         entity.getPersistentData().m_128379_("DomainAttack", false);
      }
   }
}
