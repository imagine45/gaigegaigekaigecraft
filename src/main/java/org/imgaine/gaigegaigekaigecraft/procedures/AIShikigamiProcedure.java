package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIShikigamiProcedure {
   public AIShikigamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double count_a = 0.0;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM1 = 0.0;
         boolean failed = false;
         boolean old_sneak = false;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof RozetsuShikigamiVesselEntity) {
               NUM1 = 3.0;
               NUM2 = 1.0;
            } else if (entity instanceof RozetsuShikigamiVessel2Entity) {
               NUM1 = 6.0;
               NUM2 = 2.0;
            } else {
               double var10001;
               label155: {
                  NUM1 = (double)(2L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.5));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity4 = (LivingEntity)entity;
                     if (_livingEntity4.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity4.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label155;
                     }
                  }

                  var10001 = 0.0;
               }

               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
            }

            label148: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19600_)) {
                     break label148;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label143: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label143;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)NUM2, false, false));
               }
            }

            LivingEntity var35;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var35 = _mobEnt.m_5448_();
            } else {
               var35 = null;
            }

            if (var35 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               entity.getPersistentData().m_128347_("cnt_x2", 0.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  if (entity instanceof RozetsuShikigamiVessel2Entity) {
                     rnd = 0.0;
                     if (LogicStartProcedure.execute(entity)) {
                        rnd = Math.random() < 0.75 ? 8.0 : 7.0;
                        tick = 100.0;
                     }

                     if (rnd > 0.0) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("TenShadowsTechnique4", 1.0);
                        entity.getPersistentData().m_128347_("skill", (double)(600L + Math.round(rnd)));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
               if (entity instanceof RozetsuShikigamiVessel2Entity && entity.getPersistentData().m_128459_("cnt_x2") > 120.0) {
                  entity.getPersistentData().m_128347_("cnt_x2", 0.0);
                  entity.getPersistentData().m_128347_("skill", 1.0);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
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
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_life") > (double)(entity instanceof RozetsuShikigamiEntity ? 400 : 600)) {
                  old_sneak = owner_uuid.m_6144_();
                  owner_uuid.m_20260_(true);
                  ShikigamiRightClickedOnEntityProcedure.execute(world, entity, owner_uuid);
                  owner_uuid.m_20260_(old_sneak);
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }

               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if ((!(entity instanceof RozetsuShikigamiEntity) || entity.getPersistentData().m_128471_("domain_entity")) && owner_uuid instanceof LivingEntity) {
               LivingEntity _livEnt47 = (LivingEntity)owner_uuid;
               if (_livEnt47.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
