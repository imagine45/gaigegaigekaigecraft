package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIHanamiProcedure {
   public AIHanamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         boolean domain = false;
         if (entity.isAlive()) {
            label124: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label124;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 14, false, false));
                  }
               }
            }

            label119: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label119;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
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
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  rnd = 0.0;
                  if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.5)) && !domain) {
                     CalculateAttackProcedure.execute(world, entity);
                  } else {
                     if (domain) {
                        tick = 20.0;
                        rnd = 20.0;
                     } else {
                        for(int index0 = 0; index0 < 512; ++index0) {
                           rnd = (double)(5L + Math.round(Math.random() * 15.0));
                           if (rnd == 5.0) {
                              tick = 60.0;
                              break;
                           }

                           if (rnd == 6.0) {
                              tick = 40.0;
                              break;
                           }

                           if (rnd == 10.0) {
                              tick = 250.0;
                              if (!(entity.getPersistentData().getDouble("cnt_target") < 600.0) && !(Math.random() > 0.1)) {
                                 break;
                              }
                           } else if (rnd == 15.0) {
                              tick = 0.0;
                              double var25 = Math.random();
                              float var10002;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = _livEnt.getHealth();
                              } else {
                                 var10002 = -1.0F;
                              }

                              var10002 = Math.max(var10002, 1.0F);
                              float var10003;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10003 = _livEnt.getMaxHealth();
                              } else {
                                 var10003 = -1.0F;
                              }

                              if (!(var25 > (double)(1.0F - var10002 / Math.max(var10003, 1.0F))) && (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).is(BlockTags.create(new ResourceLocation("minecraft:animals_spawnable_on"))) || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).is(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))))) {
                                 break;
                              }
                           } else if (rnd == 20.0) {
                              tick = 20.0;
                              if (!(Math.random() > 0.1) && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                 break;
                              }
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("skill", 1400.0 + rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
