package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.IshigoriRyuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class AttackWeakProcedure {
   public AttackWeakProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         double CT2 = 0.0;
         double CT1 = 0.0;
         double dis = 0.0;
         if (entity.getPersistentData().getDouble("cnt5") == 0.0) {
            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               CT1 = playerVars.PlayerCurseTechnique;
               CT2 = playerVars.PlayerCurseTechnique2;
            }

            if ((CT1 == 19.0 || CT2 == 19.0) && LogicStartPassiveProcedure.execute(entity)) {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 1.0));
            }

            if (entity.getPersistentData().getDouble("cnt1") < 2.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 1, false, false));
                  }
               }

               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               Entity var16 = var10000;
               if (var16 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  dis = GetDistanceProcedure.execute(entity);
                  if (dis < 4.0 && ((Entity)var16).getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  label84: {
                     label83: {
                        if (entity instanceof Player) {
                           if (CT1 == 12.0 || CT2 == 12.0 || CT1 == 21.0 || CT2 == 21.0) {
                              break label83;
                           }
                        } else if (entity instanceof IshigoriRyuEntity) {
                           break label83;
                        }

                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.125);
                        break label84;
                     }

                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.25);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     ChargeParticleProcedure.execute(world, entity, 10.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }
               }
            }
         }

         if (LogicRifleProcedure.execute(world, entity)) {
            AttackRifleProcedure.execute(world, entity);
         } else if (LogicSwordProcedure.execute(entity)) {
            AttackWeakSwordProcedure.execute(world, x, y, z, entity);
         } else {
            AttackWeakPunchProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
