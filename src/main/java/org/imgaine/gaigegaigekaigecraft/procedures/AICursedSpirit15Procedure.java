package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit15Procedure {
   public AICursedSpirit15Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double lv = 0.0;
         if (entity.isAlive()) {
            if (entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")) && entity.getPersistentData().getDouble("skill") == 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:0b}");
            }

            label105: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label105;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 9, false, false));
                  }
               }
            }

            label100: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label100;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 2, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               TechniqueNecklace1Procedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().getDouble("skill") == 2.0) {
               AttackGroundBiteProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0 || Math.random() < 0.1) {
                        if (LogicStartProcedure.execute(entity) && Math.random() < 0.8) {
                           rnd = 1.0;
                           lv = 0.0;
                           tick = 50.0;
                        } else {
                           label118: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt19 = (LivingEntity)entity;
                                 if (_livEnt19.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label118;
                                 }
                              }

                              rnd = 2.0;
                              lv = 1.0;
                              tick = 75.0;
                           }
                        }
                     }

                     if (rnd > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        entity.getPersistentData().putDouble("skill", rnd);
                        if (lv > 0.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               }
            }
         }

      }
   }
}
