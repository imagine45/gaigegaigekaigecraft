package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.BathynomusGiganteusEntity;
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

public class AICursedSpirit23Procedure {
   public AICursedSpirit23Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         Entity entity_a = null;
         if (entity.m_6084_() && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_(MobEffects.f_19596_);
            }

            if (entity instanceof BathynomusGiganteusEntity) {
               label160: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                        break label160;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 6, false, false));
                     }
                  }
               }

               label155: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                        break label155;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 2, false, false));
                     }
                  }
               }

               label150: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.m_21023_(MobEffects.f_19593_)) {
                        break label150;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, 2147483647, 4, false, false));
                     }
                  }
               }

               label145: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.m_21023_(MobEffects.f_19608_)) {
                        break label145;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19608_, 2147483647, 0, false, false));
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                  if (LogicOwnerExistProcedure.execute(world, entity)) {
                     label190: {
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
                        if (entity_a.m_6084_()) {
                           label183: {
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _livEnt18 = (LivingEntity)entity_a;
                                 if (_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    break label183;
                                 }
                              }

                              if (entity.getPersistentData().m_128459_("friend_num") != entity_a.getPersistentData().m_128459_("friend_num") && !entity.m_9236_().m_5776_()) {
                                 entity.m_146870_();
                              }
                              break label190;
                           }
                        }

                        if (!entity.m_9236_().m_5776_()) {
                           entity.m_146870_();
                        }
                     }
                  } else if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }

               entity.getPersistentData().m_128347_("cnt_settarget", entity.getPersistentData().m_128459_("cnt_settarget") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_settarget") > 10.0) {
                  entity.getPersistentData().m_128347_("cnt_settarget", -20.0);
                  SetTargetProcedure.execute(world, x, y, z, entity);
               }
            } else {
               label184: {
                  label166: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt28 = (LivingEntity)entity;
                        if (_livEnt28.m_21023_(MobEffects.f_19600_)) {
                           break label166;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 5, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt30 = (LivingEntity)entity;
                     if (_livEnt30.m_21023_(MobEffects.f_19606_)) {
                        break label184;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 1, false, false));
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 1.0) {
               AttackBiteProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("skill") == 2.0) {
               AttackGroundBiteProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt_x", -50.0);
                     ResetCounterProcedure.execute(entity);
                     if (!(Math.random() < 0.5) && !(entity instanceof BathynomusGiganteusEntity)) {
                        entity.getPersistentData().m_128347_("skill", 2.0);
                     } else {
                        entity.getPersistentData().m_128347_("skill", 1.0);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:0b}");
            }
         }

      }
   }
}
