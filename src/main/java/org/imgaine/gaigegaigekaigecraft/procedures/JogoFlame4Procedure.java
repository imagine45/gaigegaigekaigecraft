package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class JogoFlame4Procedure {
   public JogoFlame4Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean blood = false;
         boolean player = false;
         double y_velocity = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double old_skill = 0.0;
         old_skill = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt5") == 0.0) {
            ChojuroStoneHandProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("skill") == 0.0) {
            entity.getPersistentData().m_128347_("cnt5", 1.0);
         }

         double var10000;
         int var10002;
         label55: {
            var10000 = entity.getPersistentData().m_128459_("cnt4");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label55;
               }
            }

            var10002 = 0;
         }

         if (var10000 <= (double)Math.min(10 + var10002, 20)) {
            entity.getPersistentData().m_128347_("skill", old_skill);
            dis = ReturnEntitySizeProcedure.execute(entity);
            yaw = (double)(entity.m_146908_() % 360.0F);
            picth = (double)entity.m_146909_();
            entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0));
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

            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(entity.m_20205_() + 1.0F) + dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(entity.m_20205_() + 1.0F) + dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(entity.m_20205_() + 1.0F) + dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
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

                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 1.25);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 1.25);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 1.25);
                  entityinstance.m_20256_(new Vec3(entity.m_20154_().f_82479_ * 1.25, entity.m_20154_().f_82480_ * 1.25, entity.m_20154_().f_82481_ * 1.25));
                  if (entityinstance instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntSetI = (EntityWaterEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 2);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

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
         } else if (entity.getPersistentData().m_128459_("cnt5") != 0.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
