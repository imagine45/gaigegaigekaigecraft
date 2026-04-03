package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade312Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade313Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade314Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade315Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade317Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade318Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade319Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade31Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade320Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade322Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade323Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade33Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade34Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade35Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade36Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade37Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade39Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit3Procedure {
   public AICursedSpirit3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double speed = 0.0;
         double lv_df = 0.0;
         double lv_st = 0.0;
         Entity owner_uuid = null;
         if (entity instanceof CursedSpiritGrade39Entity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.SOUL, x, y + (double)entity.getBbHeight() * 0.5, z, (int)(1.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.25, 0.1);
         }

         if (entity.isAlive()) {
            label178: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                     break label178;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 2147483647, 9, false, false));
                  }
               }
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label173;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }
            }

            label187: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label187;
                  }
               }

               if (entity instanceof CursedSpiritGrade312Entity) {
                  lv_st = 4.0;
               } else if (!(entity instanceof CursedSpiritGrade35Entity) && !(entity instanceof CursedSpiritGrade36Entity) && !(entity instanceof CursedSpiritGrade313Entity)) {
                  if (!(entity instanceof CursedSpiritGrade31Entity) && !(entity instanceof CursedSpiritGrade34Entity) && !(entity instanceof CursedSpiritGrade314Entity) && !(entity instanceof CursedSpiritGrade318Entity) && !(entity instanceof CursedSpiritGrade319Entity) && !(entity instanceof CursedSpiritGrade320Entity) && !(entity instanceof CursedSpiritGrade322Entity) && !(entity instanceof CursedSpiritGrade323Entity)) {
                     if (!(entity instanceof CursedSpiritGrade33Entity) && !(entity instanceof CursedSpiritGrade37Entity) && !(entity instanceof CursedSpiritGrade317Entity)) {
                        lv_st = 2.0;
                     } else {
                        lv_st = 0.0;
                     }
                  } else {
                     lv_st = 1.0;
                  }
               } else {
                  lv_st = 3.0;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label141: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt28 = (LivingEntity)entity;
                  if (_livEnt28.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label141;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 0, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               AttackJumpProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (!(var10000 instanceof LivingEntity)) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               } else {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity instanceof CursedSpiritGrade312Entity && entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     label129: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt38 = (LivingEntity)entity;
                           if (_livEnt38.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label129;
                           }
                        }

                        entity.getPersistentData().putDouble("cnt_x", -40.0 - Math.random() * 40.0);
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().putDouble("skill", 1.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity instanceof CursedSpiritGrade39Entity && entity.getPersistentData().getBoolean("Shikigami") && entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("friend_num_worker") != 0.0 && (entity instanceof CursedSpiritGrade36Entity || entity instanceof CursedSpiritGrade315Entity)) {
               AICursedSpiritsFlyingAttackProcedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().getBoolean("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         }

      }
   }
}
