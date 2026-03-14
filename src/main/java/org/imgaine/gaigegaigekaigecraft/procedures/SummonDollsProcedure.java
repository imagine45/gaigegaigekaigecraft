package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SummonDollsProcedure {
   public SummonDollsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double size = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.ITEM_DOLL.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.ITEM_DOLL.get() && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.OFF_HAND, true);
            }
         }

         if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.DOLL_1.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity13 = (LivingEntity)entityinstance;
                  if (_livingEntity13.m_21204_().m_22171_(Attributes.f_22281_)) {
                     double var10001;
                     label89: {
                        var37 = _livingEntity13.getAttribute_(Attributes.f_22281_);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity9 = (LivingEntity)entityinstance;
                           if (_livingEntity9.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10001 = _livingEntity9.getAttribute_(Attributes.f_22281_).m_22115_();
                              break label89;
                           }
                        }

                        var10001 = 0.0;
                     }

                     int var39;
                     label84: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entity;
                           if (_livEnt10.m_21023_(MobEffects.f_19600_)) {
                              label79: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var39 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label79;
                                    }
                                 }

                                 var39 = 0;
                              }

                              ++var39;
                              break label84;
                           }
                        }

                        var39 = 0;
                     }

                     var37.m_22100_(var10001 + 0.5 * (double)var39 * 3.0);
                  }
               }

               double var10002;
               label70: {
                  var38 = entityinstance.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                        var10002 = (double)_livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                        break label70;
                     }
                  }

                  var10002 = 0.0;
               }

               var38.m_128347_("LevelResistance", var10002);
               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
               entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
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

               entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
               entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
               entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
               _serverLevel.m_7967_(entityinstance);
            }
         }

      }
   }
}
