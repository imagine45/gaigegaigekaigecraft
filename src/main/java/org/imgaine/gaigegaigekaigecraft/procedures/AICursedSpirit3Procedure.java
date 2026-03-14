package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade312Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade313Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade314Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade315Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade317Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade318Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade319Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade31Entity;
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
            _level.m_8767_(ParticleTypes.f_123746_, x, y + (double)entity.m_20206_() * 0.5, z, (int)(1.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.25, 0.1);
         }

         if (entity.m_6084_()) {
            label176: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                     break label176;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 2147483647, 9, false, false));
                  }
               }
            }

            label171: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label171;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }
            }

            label185: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.m_21023_(MobEffects.f_19600_)) {
                     break label185;
                  }
               }

               if (entity instanceof CursedSpiritGrade312Entity) {
                  lv_st = 4.0;
               } else if (!(entity instanceof CursedSpiritGrade35Entity) && !(entity instanceof CursedSpiritGrade36Entity) && !(entity instanceof CursedSpiritGrade313Entity)) {
                  if (!(entity instanceof CursedSpiritGrade31Entity) && !(entity instanceof CursedSpiritGrade34Entity) && !(entity instanceof CursedSpiritGrade314Entity) && !(entity instanceof CursedSpiritGrade318Entity) && !(entity instanceof CursedSpiritGrade319Entity) && !(entity instanceof CursedSpiritGrade322Entity) && !(entity instanceof CursedSpiritGrade323Entity)) {
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
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label140: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt27 = (LivingEntity)entity;
                  if (_livEnt27.m_21023_(MobEffects.f_19606_)) {
                     break label140;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 0, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 1.0) {
               AttackJumpProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (!(var10000 instanceof LivingEntity)) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (entity instanceof CursedSpiritGrade312Entity && entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     label128: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt37 = (LivingEntity)entity;
                           if (_livEnt37.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label128;
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_x", -40.0 - Math.random() * 40.0);
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", 1.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity instanceof CursedSpiritGrade39Entity && entity.getPersistentData().m_128471_("Shikigami") && entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num_worker") != 0.0 && (entity instanceof CursedSpiritGrade36Entity || entity instanceof CursedSpiritGrade315Entity)) {
               AICursedSpiritsFlyingAttackProcedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().m_128471_("Shikigami")) {
            owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

      }
   }
}
