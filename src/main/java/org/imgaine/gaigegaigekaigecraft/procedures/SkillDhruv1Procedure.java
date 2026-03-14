package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class SkillDhruv1Procedure {
   public SkillDhruv1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

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
         }).apply(world, entity.getPersistentData().m_128461_("SHIKIGAMI_DHRUV1"));
         if (entity_a instanceof ShikigamiHeterocephalusGlaberEntity && !entity_a.m_9236_().m_5776_()) {
            entity_a.m_146870_();
         }

         if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
         x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
         y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
         z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.SHIKIGAMI_HETEROCEPHALUS_GLABER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entity.getPersistentData().m_128359_("SHIKIGAMI_DHRUV1", entityinstance.m_20149_());
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity29 = (LivingEntity)entityinstance;
                  if (_livingEntity29.m_21204_().m_22171_(Attributes.f_22281_)) {
                     AttributeInstance var10000;
                     double var10001;
                     label86: {
                        var10000 = _livingEntity29.getAttribute_(Attributes.f_22281_);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                           if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10001 = _livingEntity25.getAttribute_(Attributes.f_22281_).m_22115_();
                              break label86;
                           }
                        }

                        var10001 = 0.0;
                     }

                     double var10002;
                     label81: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity26 = (LivingEntity)entity;
                           if (_livingEntity26.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10002 = _livingEntity26.getAttribute_(Attributes.f_22281_).m_22115_();
                              break label81;
                           }
                        }

                        var10002 = 0.0;
                     }

                     int var10003;
                     label76: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label76;
                           }
                        }

                        var10003 = 0;
                     }

                     var10000.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * 1.0);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var38;
                     MobEffect var39;
                     int var10005;
                     label65: {
                        var38 = new MobEffectInstance;
                        var39 = MobEffects.f_19606_;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                              break label65;
                           }
                        }

                        var10005 = 0;
                     }

                     var38.<init>(var39, 2147483647, Math.max(var10005, 0), false, false);
                     _entity.m_7292_(var38);
                  }
               }

               entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
               entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
               entityinstance.getPersistentData().m_128379_("Shikigami", true);
               entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
               entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
               entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
               if (entity instanceof Player) {
                  entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

         entity.getPersistentData().m_128347_("skill", 0.0);
      }
   }
}
