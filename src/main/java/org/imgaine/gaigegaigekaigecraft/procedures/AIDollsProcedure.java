package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Doll1Entity;
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
import net.minecraft.world.level.LevelAccessor;

public class AIDollsProcedure {
   public AIDollsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            int var10000;
            label103: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label103;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < entity.getPersistentData().getDouble("LevelResistance") && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)entity.getPersistentData().getDouble("LevelResistance"), false, false));
               }
            }

            LivingEntity var27;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var27 = _mobEnt.getTarget();
            } else {
               var27 = null;
            }

            if (var27 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  label91: {
                     entity.getPersistentData().putDouble("cnt_x", -10.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt12 = (LivingEntity)entity;
                        if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           break label91;
                        }
                     }

                     if (distance > 4.0 && distance < 16.0 && Math.random() < 0.1) {
                        rnd = 6.0;
                        level = 0.0;
                        tick = 50.0;
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", 1700.0 + rnd);
                     if (level > 0.0) {
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

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }

            int var28;
            if (entity instanceof Doll1Entity) {
               Doll1Entity _datEntI = (Doll1Entity)entity;
               var28 = (Integer)_datEntI.getEntityData().get(Doll1Entity.DATA_move);
            } else {
               var28 = 0;
            }

            if (var28 == 1 && entity.getPersistentData().getDouble("skill") == 0.0 && !entity.level().isClientSide()) {
               entity.discard();
            }

            entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_life") > 1200.0 && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         }

      }
   }
}
