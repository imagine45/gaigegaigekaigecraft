package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class NyoiStaffRightclickedOnBlockProcedure {
   public NyoiStaffRightclickedOnBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
      if (direction != null && entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            if (_plrCldCheck1.m_36335_().m_41519_(itemstack.m_41720_())) {
               return;
            }
         }

         x_pos = x + (double)direction.m_122429_();
         y_pos = y + (double)direction.m_122430_();
         z_pos = z + (double)direction.m_122431_();
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ITEM.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
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

               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entityinstance.getPersistentData().m_128347_("Thunder", 6.0);
               if (entityinstance instanceof Player) {
                  Player _player = (Player)entityinstance;
                  _player.m_150109_().f_35975_.set(3, itemstack.m_41777_());
                  _player.m_150109_().m_6596_();
               } else if (entityinstance instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entityinstance;
                  _living.m_8061_(EquipmentSlot.HEAD, itemstack.m_41777_());
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

         label36: {
            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.m_150110_().f_35937_) {
                  break label36;
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_(itemstack.m_41720_(), 100);
            }
         }

         itemstack.m_41774_(1);
      }
   }
}
