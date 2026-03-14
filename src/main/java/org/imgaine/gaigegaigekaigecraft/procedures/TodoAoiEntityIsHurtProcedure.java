package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class TodoAoiEntityIsHurtProcedure {
   public TodoAoiEntityIsHurtProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21223_();
         } else {
            var10000 = -1.0F;
         }

         double var15 = (double)var10000;
         float var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var15 < (double)var10001 * 0.5) {
            ItemStack var16;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var16 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var16 = ItemStack.f_41583_;
            }

            if (var16.m_41720_() == JujutsucraftModItems.PENDANT_TODO_AOI.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y + ((<undefinedtype>)(new Object() {
                     public double getSubmergedHeight(Entity _entity) {
                        for(FluidType fluidType : ((IForgeRegistry)ForgeRegistries.FLUID_TYPES.get()).getValues()) {
                           if (_entity.m_9236_().m_6425_(_entity.m_20183_()).getFluidType() == fluidType) {
                              return _entity.getFluidTypeHeight(fluidType);
                           }
                        }

                        return 0.0;
                     }
                  })).getSubmergedHeight(entity), z, new ItemStack((ItemLike)JujutsucraftModItems.PENDANT_TODO_AOI.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               PendantTodoAoiItemIsDroppedByPlayerProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
