package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

public class LogicSwordProcedure {
   public LogicSwordProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         ItemStack mainHandItem = ItemStack.f_41583_;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         mainHandItem = var10000.m_41777_();
         if (!(mainHandItem.m_41720_() instanceof SwordItem) && !(mainHandItem.m_41720_() instanceof AxeItem) && !(mainHandItem.m_41720_() instanceof PickaxeItem) && !(mainHandItem.m_41720_() instanceof ShovelItem) && !(mainHandItem.m_41720_() instanceof HoeItem) && !mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:sword"))) && !mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:whip"))) && (!mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:metallic"))) || !mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))))) {
            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:have_claws")))) {
               return true;
            } else if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:iron_body")))) {
               return true;
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               return var10000.m_41720_() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get();
            }
         } else {
            return true;
         }
      }
   }
}
