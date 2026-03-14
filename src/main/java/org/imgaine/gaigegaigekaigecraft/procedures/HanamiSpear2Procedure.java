package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class HanamiSpear2Procedure {
   public HanamiSpear2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double HP = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            entity.getPersistentData().m_128347_("cnt2", 2.0);
         }

         yaw = (double)entity.m_146908_();
         picth = (double)entity.m_146909_();
         entity.m_146922_((float)(yaw + entity.getPersistentData().m_128459_("cnt1") * (double)(entity.getPersistentData().m_128459_("cnt1") % 2.0 == 1.0 ? 9 : -9)));
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

         entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
         entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
         entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
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

         for(int index0 = 0; index0 < 255; ++index0) {
            if (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) || entity.getPersistentData().m_128459_("y_pos") < 0.0) {
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - 3.0);
               break;
            }

            entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - 1.0);
         }

         yaw = (double)entity.m_146908_();
         picth = (double)entity.m_146909_();
         entity.m_146922_((float)yaw);
         entity.m_146926_(-45.0F);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 1.0);
         entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 1.0);
         entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 1.0);
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

         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         picth = -45.0;
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.WOODEN_SPEAR_1.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               SetRangedAmmoProcedure.execute(entity, entityinstance);
               if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                  entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
               }

               entityinstance.m_146922_((float)yaw);
               entityinstance.m_146926_((float)picth);
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
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10005;
                     label85: {
                        var10001 = new MobEffectInstance;
                        var10003 = MobEffects.f_19606_;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                              break label85;
                           }
                        }

                        var10005 = 0;
                     }

                     var10001.<init>(var10003, 2147483647, var10005, false, false);
                     _entity.m_7292_(var10001);
                  }
               }

               entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power"));
               entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power"));
               entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power"));
               entityinstance.getPersistentData().m_128347_("height", entity.getPersistentData().m_128459_("cnt2"));
               entityinstance.getPersistentData().m_128347_("move", 1.0);
               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") % 2.0 == 0.0) {
            entity.getPersistentData().m_128347_("cnt2", Math.max(entity.getPersistentData().m_128459_("cnt2") - 0.25, 0.0));
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
