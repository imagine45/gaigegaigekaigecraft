package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

public class SetAttributeMainhandProcedure {
   public SetAttributeMainhandProcedure() {
   }

   public static void execute(ItemStack targetitem) {
      String color = "";
      double curse_value = 0.0;
      double NUM2 = 0.0;
      double NUM1 = 0.0;
      if (targetitem.m_41720_() != JujutsucraftModItems.MAHITO_HAND_1.get() && targetitem.m_41720_() != JujutsucraftModItems.GAVEL_LONG.get()) {
         if (targetitem.m_41720_() != JujutsucraftModItems.SPLIT_SOUL_KATANA.get() && targetitem.m_41720_() != JujutsucraftModItems.HITEN.get() && targetitem.m_41720_() != JujutsucraftModItems.GARUDA_ITEM.get() && targetitem.m_41720_() != JujutsucraftModItems.NAGINATA.get()) {
            if (targetitem.m_41720_() == JujutsucraftModItems.SLAUGHTER_DEMON.get() || targetitem.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || targetitem.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get() || targetitem.m_41720_() == JujutsucraftModItems.KNIFE.get() || targetitem.m_41720_() == JujutsucraftModItems.SCISSORS.get() || targetitem.m_41720_() == JujutsucraftModItems.CLAWS.get() || targetitem.m_41720_() == JujutsucraftModItems.SICKLE.get() || targetitem.m_41720_() == JujutsucraftModItems.MAHITO_HAND_2.get()) {
               targetitem.m_41784_().m_128347_("Power", 0.1);
               targetitem.m_41784_().m_128347_("Reach", -0.125);
               targetitem.m_41784_().m_128347_("Knockback", -0.25);
            }
         } else {
            targetitem.m_41784_().m_128347_("Power", 0.25);
            targetitem.m_41784_().m_128347_("Range", 0.25);
            targetitem.m_41784_().m_128347_("Reach", 0.25);
         }
      } else {
         targetitem.m_41784_().m_128347_("Reach", 0.75);
      }

      if (targetitem.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
         targetitem.m_41784_().m_128347_("Power", 0.5);
         targetitem.m_41784_().m_128347_("Range", 0.5);
         targetitem.m_41784_().m_128347_("Reach", 0.25);
         targetitem.m_41784_().m_128347_("Knockback", 0.5);
      }

      if (targetitem.m_41720_() == JujutsucraftModItems.MEI_MEI_AXE.get()) {
         targetitem.m_41784_().m_128347_("Power", 0.375);
         targetitem.m_41784_().m_128347_("Range", 0.25);
         targetitem.m_41784_().m_128347_("Reach", 0.25);
      }

      if (!(targetitem.m_41720_() instanceof SwordItem) && targetitem.m_41720_() != JujutsucraftModItems.WEAPON_NANAMI.get() && targetitem.m_41720_() != JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
         if (targetitem.m_41720_() instanceof AxeItem) {
            if (targetitem.m_41784_().m_128459_("Power") == 0.0) {
               targetitem.m_41784_().m_128347_("Power", 0.375);
            }
         } else if ((targetitem.m_41720_() instanceof PickaxeItem || targetitem.m_41720_() instanceof ShovelItem || targetitem.m_41720_() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) && targetitem.m_41784_().m_128459_("Power") == 0.0) {
            targetitem.m_41784_().m_128347_("Power", 0.25);
         }
      } else if (targetitem.m_41784_().m_128459_("Power") == 0.0) {
         targetitem.m_41784_().m_128347_("Power", 0.125);
      }

      if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) && targetitem.m_41784_().m_128459_("CursePower") == 0.0) {
         if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))) {
            if (targetitem.m_41720_() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()) {
               targetitem.m_41784_().m_128347_("CursePower", -10.0);
            } else {
               targetitem.m_41784_().m_128347_("CursePower", 10.0);
            }
         } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))) {
            targetitem.m_41784_().m_128347_("CursePower", 7.0);
         } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))) {
            targetitem.m_41784_().m_128347_("CursePower", 5.0);
         } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))) {
            targetitem.m_41784_().m_128347_("CursePower", 3.0);
         } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))) {
            targetitem.m_41784_().m_128347_("CursePower", 2.0);
         } else {
            targetitem.m_41784_().m_128347_("CursePower", 1.0);
         }
      }

      if (targetitem.m_41720_() == JujutsucraftModItems.BLAZING_COURAGE.get()) {
         NUM1 = 1.0 - Math.random() * 0.5;
         NUM2 = Math.random() * 0.2;
         targetitem.m_41784_().m_128359_("color1", NUM1 + " " + NUM2 + " " + NUM2 + " 1");
         targetitem.m_41784_().m_128359_("color2", targetitem.m_41784_().m_128461_("color1"));
         targetitem.m_41784_().m_128359_("color3", "flame");
         targetitem.m_41784_().m_128359_("slash_color", "slash_flame");
      } else if (targetitem.m_41720_() == JujutsucraftModItems.BLACK_ROPE.get() || targetitem.m_41720_() == JujutsucraftModItems.SICKLE.get() || targetitem.m_41720_() == JujutsucraftModItems.SWORD_BLACK.get()) {
         NUM1 = 0.0 + Math.random() * 0.3;
         targetitem.m_41784_().m_128359_("color1", NUM1 + " " + NUM1 + " " + NUM1 + " 1");
         targetitem.m_41784_().m_128359_("color2", targetitem.m_41784_().m_128461_("color1"));
         targetitem.m_41784_().m_128359_("slash_color", "slash_black");
      }

   }
}
