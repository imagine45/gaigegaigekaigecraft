package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackNue2Procedure {
   public AttackNue2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.f_41583_;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos = 0.0;
         double dis = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt2") % 3.0 == 1.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            dis = 0.0;

            for(int index0 = 0; index0 < 32; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               logic_a = false;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(Math.min(4.0 + dis, 16.0) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     x_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_();
                     y_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_();
                     z_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_();
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }

               dis += 2.0;
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
         } else if (entity.getPersistentData().m_128459_("cnt1") <= 3.0) {
            x_pos = entity.getPersistentData().m_128459_("x_pos") + (Math.random() - 0.5) * 48.0;
            y_pos = entity.getPersistentData().m_128459_("y_pos") + (Math.random() - 0.5) * 48.0;
            z_pos = entity.getPersistentData().m_128459_("z_pos") + (Math.random() - 0.5) * 48.0;
         } else if (entity.getPersistentData().m_128459_("cnt1") <= 6.0) {
            x_pos = entity.m_20185_() + (Math.random() - 0.5) * 64.0;
            y_pos = entity.m_20186_() + (Math.random() - 0.5) * 64.0;
            z_pos = entity.m_20189_() + (Math.random() - 0.5) * 64.0;
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= 6.0) {
            if (entity.getPersistentData().m_128459_("cnt1") > 3.0 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
               for(int index1 = 0; index1 < 16 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index1) {
                  --y_pos;
               }
            }

            if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
               for(int index2 = 0; index2 < 16 && world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index2) {
                  ++y_pos;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THUNDER_IMPACT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > 25.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
