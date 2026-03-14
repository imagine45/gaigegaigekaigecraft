package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class TechniqueFootProcedure {
   public TechniqueFootProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), 1.5, entity.m_20184_().m_7094_()));
               entity.getPersistentData().m_128347_("cnt3", 1.0);
            } else if (entity.m_20184_().m_7098_() < 0.1 || entity.getPersistentData().m_128459_("cnt2") > 30.0) {
               entity.getPersistentData().m_128347_("cnt1", 1.0);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") < 20.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            }

            if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
               if (entity.getPersistentData().m_128459_("cnt1") <= 2.0) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var38 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var38 + (double)((Entity)var10001).m_20206_() * 0.5;
                     LivingEntity var39;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var39 = _mobEnt.m_5448_();
                     } else {
                        var39 = null;
                     }

                     z_pos = ((Entity)var39).m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  int var40;
                  label81: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var40 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label81;
                        }
                     }

                     var40 = 0;
                  }

                  HP = (double)(40 + var40 * 8);
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() - (double)(2.0F + entity.m_20206_());
                  z_pos = entity.m_20189_();
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FOOT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(0.0F);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                           if (_livingEntity38.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity38.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") > 60.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }

               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

      }
   }
}
