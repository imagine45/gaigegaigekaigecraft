package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityBroomEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AINishimiyaProcedure {
   public AINishimiyaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean weapon = false;
         boolean logicStart = false;
         double rnd = 0.0;
         double distance = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity.isPassenger()) {
               AIActiveFlyingProcedure.execute(world, entity);
            }

            label140: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     break label140;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2147483647, 0, false, false));
                  }
               }
            }

            label135: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label135;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 5, false, false));
                  }
               }
            }

            label130: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label130;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 1, false, false));
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 10.0) {
               if (!(entity.getVehicle() instanceof EntityBroomEntity)) {
                  ItemStack var30;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var30 = _livEnt.getMainHandItem();
                  } else {
                     var30 = ItemStack.EMPTY;
                  }

                  if (var30.getItem() == JujutsucraftModItems.BROOM.get()) {
                     entity.stopRiding();
                     SummonBroomProcedure.execute(world, x, y, z, entity);
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
                     }
                  }
               }

               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_x2", 0.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", -10.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  logicStart = LogicStartProcedure.execute(entity);
                  if ((distance > 4.0 || Math.random() < 0.1) && logicStart) {
                     label150: {
                        if (!(entity.getVehicle() instanceof EntityBroomEntity)) {
                           ItemStack var31;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var31 = _livEnt.getMainHandItem();
                           } else {
                              var31 = ItemStack.EMPTY;
                           }

                           if (var31.getItem() != JujutsucraftModItems.BROOM.get()) {
                              break label150;
                           }
                        }

                        if (Math.random() < 0.5) {
                           rnd = 3605.0;
                           tick = 25.0;
                        } else if (Math.random() < 0.5) {
                           rnd = 3606.0;
                           tick = 60.0;
                        } else {
                           rnd = 3610.0;
                           tick = 200.0;
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", (double)Math.round(rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               if (entity.getVehicle() instanceof EntityBroomEntity) {
                  entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x2") > 200.0) {
                     entity.getPersistentData().putDouble("cnt_x2", 0.0);
                     if (!entity.getVehicle().level().isClientSide()) {
                        entity.getVehicle().discard();
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with gaigegaigekaigecraft:broom");
                     }
                  }
               }
            }
         }

      }
   }
}
