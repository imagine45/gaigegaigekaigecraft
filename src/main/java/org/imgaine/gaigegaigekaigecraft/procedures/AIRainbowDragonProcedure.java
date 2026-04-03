package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AIRainbowDragonProcedure {
   public AIRainbowDragonProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double form = 0.0;
         double tick = 0.0;
         Entity entity_a = null;
         if (entity.isAlive()) {
            label95: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               level_strength = 9.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label95;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)level_strength, false, false));
                  }
               }
            }

            label90: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label90;
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
               AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().putDouble("cnt_x", -100.0);
               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  if (entity.getPersistentData().getDouble("continue") > 0.0) {
                     entity.getPersistentData().putDouble("continue", entity.getPersistentData().getDouble("continue") - 1.0);
                     entity.getPersistentData().putDouble("skill", 1.0);
                  }

                  ResetCounterProcedure.execute(entity);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y + (double)entity.getBbHeight() * 0.5, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle firework ~ ~ ~ 1 1 1 0 10 force");
               }
            } else if (entity.getPersistentData().getDouble("skill") == 2.0) {
               AttackBiteProcedure.execute(world, x, y, z, entity);
            } else {
               if (!entity.isVehicle()) {
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
                        ResetCounterProcedure.execute(entity);
                        if (!(Math.random() < 0.5) && !(GetDistanceNearestEnemyProcedure.execute(world, entity) > 10.0)) {
                           entity.getPersistentData().putDouble("cnt_x", -30.0);
                           entity.getPersistentData().putDouble("skill", 2.0);
                        } else {
                           entity.getPersistentData().putDouble("cnt_x", -50.0);
                           entity.getPersistentData().putDouble("skill", 1.0);
                           entity.getPersistentData().putDouble("continue", (double)(Math.random() < 0.75 ? 1 : 0));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  } else {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                  }

                  if (!entity.onGround()) {
                     if (entity.getDeltaMovement().y() < -0.26) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() + 0.025, entity.getDeltaMovement().z()));
                     } else if (entity.getDeltaMovement().y() > -0.24) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() - 0.025, entity.getDeltaMovement().z()));
                     }
                  }
               }

               AIRideableControlProcedure.execute(entity);
            }
         }

      }
   }
}
