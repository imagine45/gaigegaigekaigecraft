package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class HanamiHandItemInHandTickProcedure {
   public HanamiHandItemInHandTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double energy = 0.0;
         ItemStack target_item = ItemStack.EMPTY;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == itemstack.getItem()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            target_item = var10000.copy();
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == itemstack.getItem()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               target_item = var10000.copy();
            }
         }

         if (target_item.getItem() == JujutsucraftModItems.HANAMI_HAND.get() && target_item.getOrCreateTag().getDouble("C_Power") > 0.0) {
            energy = 1.0 + Math.sqrt(target_item.getOrCreateTag().getDouble("C_Power"));
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(2.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double)(2.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(2.0F + entity.getBbWidth());
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)Math.round(Math.min(energy * 0.1, 50.0)), 0.1, 0.1, 0.1, Math.min(Math.sqrt(energy) * 0.05, 5.0));
            }
         }

      }
   }
}
