package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;

public class PlayAnimationItemProcedure {
   public PlayAnimationItemProcedure() {
   }

   public static void execute(Entity entity, ItemStack itemstack, String animation_name) {
      if (entity != null && animation_name != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            Item var5 = itemstack.m_41720_();
            if (var5 instanceof GeoItem) {
               GeoItem geoItem = (GeoItem)var5;
               Level var6 = livingEntity.m_9236_();
               if (var6 instanceof ServerLevel) {
                  ServerLevel serverLevel = (ServerLevel)var6;
                  geoItem.triggerAnim(livingEntity, GeoItem.getOrAssignId(itemstack, serverLevel), "popup_controller", animation_name);
               }
            }
         }

      }
   }
}
