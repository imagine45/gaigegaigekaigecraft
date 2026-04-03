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
            if (_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
               return;
            }
         }

         x_pos = x + (double)direction.getStepX();
         y_pos = y + (double)direction.getStepY();
         z_pos = z + (double)direction.getStepZ();
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ITEM.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
               entityinstance.setYRot(entity.getYRot());
               entityinstance.setXRot(0.0F);
               entityinstance.setYBodyRot(entityinstance.getYRot());
               entityinstance.setYHeadRot(entityinstance.getYRot());
               entityinstance.yRotO = entityinstance.getYRot();
               entityinstance.xRotO = entityinstance.getXRot();
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
               entityinstance.getPersistentData().putDouble("Thunder", 6.0);
               if (entityinstance instanceof Player) {
                  Player _player = (Player)entityinstance;
                  _player.getInventory().armor.set(3, itemstack.copy());
                  _player.getInventory().setChanged();
               } else if (entityinstance instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entityinstance;
                  _living.setItemSlot(EquipmentSlot.HEAD, itemstack.copy());
               }

               _serverLevel.addFreshEntity(entityinstance);
            }
         }

         label36: {
            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.getAbilities().instabuild) {
                  break label36;
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
            }
         }

         itemstack.shrink(1);
      }
   }
}
