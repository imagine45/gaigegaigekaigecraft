package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SummonRoundDeerProcedure {
   public SummonRoundDeerProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double NUM_SUM = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("x_pos", x);
            entity.getPersistentData().m_128347_("y_pos", y);
            entity.getPersistentData().m_128347_("z_pos", z);
            entity.m_146922_(entity.m_146908_());
            entity.m_146926_(0.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 0.5);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 0.5);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 0.5);
            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         }

         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 30, 0.5, 0.0, 0.5, 0.0);
            }

            if (!world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"))).m_60815_()) {
               entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
               entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity40 = (LivingEntity)entity;
               if (_livingEntity40.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity40.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(20.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 30, 0.5, 0.5, 0.5, 0.0);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") == 15.0) {
            if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROUND_DEER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  label147: {
                     label181: {
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("friend_num2", entity.getPersistentData().m_128459_("friend_num"));
                        entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                        if (entity.getPersistentData().m_128459_("TenShadowsTechnique9") != 1.0) {
                           if (!(entity instanceof ServerPlayer)) {
                              break label181;
                           }

                           ServerPlayer _plr61 = (ServerPlayer)entity;
                           if (!(_plr61.m_9236_() instanceof ServerLevel) || !_plr61.m_8960_().m_135996_(_plr61.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_round_deer"))).m_8193_()) {
                              break label181;
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        entityinstance.getPersistentData().m_128379_("Ambush", true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity72 = (LivingEntity)entityinstance;
                           if (_livingEntity72.m_21204_().m_22171_(Attributes.f_22281_)) {
                              AttributeInstance var10000;
                              double var10001;
                              label134: {
                                 var10000 = _livingEntity72.getAttribute_(Attributes.f_22281_);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity68 = (LivingEntity)entityinstance;
                                    if (_livingEntity68.m_21204_().m_22171_(Attributes.f_22281_)) {
                                       var10001 = _livingEntity68.getAttribute_(Attributes.f_22281_).m_22115_();
                                       break label134;
                                    }
                                 }

                                 var10001 = 0.0;
                              }

                              double var10002;
                              label129: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity69 = (LivingEntity)entity;
                                    if (_livingEntity69.m_21204_().m_22171_(Attributes.f_22281_)) {
                                       var10002 = _livingEntity69.getAttribute_(Attributes.f_22281_).m_22115_();
                                       break label129;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              int var10003;
                              label124: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label124;
                                    }
                                 }

                                 var10003 = 0;
                              }

                              var10000.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var45;
                              MobEffect var46;
                              int var10005;
                              label113: {
                                 var45 = new MobEffectInstance;
                                 var46 = MobEffects.f_19606_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                       var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                       break label113;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var45.<init>(var46, 2147483647, Math.max(var10005, 2), false, false);
                              _entity.m_7292_(var45);
                           }
                        }

                        entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                        entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                        entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                        break label147;
                     }

                     entityinstance.getPersistentData().m_128359_("TARGET_UUID", entity.m_20149_());
                  }

                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().m_128347_("BaseCursePower", entity.getPersistentData().m_128459_("cnt10"));
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.getPersistentData().m_128347_("TenShadowsTechnique9", -1.0);
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") > 25.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
