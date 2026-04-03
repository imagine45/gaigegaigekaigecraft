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
      if (targetitem.getItem() != ItemStack.EMPTY.getItem()) {
         if (targetitem.getItem() != JujutsucraftModItems.BLAZING_COURAGE.get() && targetitem.getItem() != JujutsucraftModItems.MAHITO_HAND_1.get() && targetitem.getItem() != JujutsucraftModItems.GAVEL_LONG.get()) {
            if (targetitem.getItem() != JujutsucraftModItems.SPLIT_SOUL_KATANA.get() && targetitem.getItem() != JujutsucraftModItems.HITEN.get() && targetitem.getItem() != JujutsucraftModItems.GARUDA_ITEM.get() && targetitem.getItem() != JujutsucraftModItems.NAGINATA.get()) {
               if (targetitem.getItem() == JujutsucraftModItems.SLAUGHTER_DEMON.get() || targetitem.getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || targetitem.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get() || targetitem.getItem() == JujutsucraftModItems.KNIFE.get() || targetitem.getItem() == JujutsucraftModItems.SCISSORS.get() || targetitem.getItem() == JujutsucraftModItems.CLAWS.get() || targetitem.getItem() == JujutsucraftModItems.SICKLE.get() || targetitem.getItem() == JujutsucraftModItems.MAHITO_HAND_2.get()) {
                  targetitem.getOrCreateTag().putDouble("Power", 0.1);
                  targetitem.getOrCreateTag().putDouble("Reach", -0.125);
                  targetitem.getOrCreateTag().putDouble("Knockback", -0.25);
               }
            } else {
               targetitem.getOrCreateTag().putDouble("Power", 0.25);
               targetitem.getOrCreateTag().putDouble("Range", 0.25);
               targetitem.getOrCreateTag().putDouble("Reach", 0.25);
            }
         } else {
            targetitem.getOrCreateTag().putDouble("Reach", 0.75);
         }

         if (targetitem.getItem() == JujutsucraftModItems.GAVEL_BIG.get()) {
            targetitem.getOrCreateTag().putDouble("Power", 0.5);
            targetitem.getOrCreateTag().putDouble("Range", 0.75);
            targetitem.getOrCreateTag().putDouble("Reach", 0.75);
            targetitem.getOrCreateTag().putDouble("Knockback", 0.5);
         }

         if (targetitem.getItem() == JujutsucraftModItems.MEI_MEI_AXE.get()) {
            targetitem.getOrCreateTag().putDouble("Power", 0.375);
            targetitem.getOrCreateTag().putDouble("Range", 0.25);
            targetitem.getOrCreateTag().putDouble("Reach", 0.25);
         }

         if (!(targetitem.getItem() instanceof SwordItem) && targetitem.getItem() != JujutsucraftModItems.WEAPON_NANAMI.get() && targetitem.getItem() != JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
            if (targetitem.getItem() instanceof AxeItem) {
               if (targetitem.getOrCreateTag().getDouble("Power") == 0.0) {
                  targetitem.getOrCreateTag().putDouble("Power", 0.375);
               }
            } else if ((targetitem.getItem() instanceof PickaxeItem || targetitem.getItem() instanceof ShovelItem || targetitem.getItem() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) && targetitem.getOrCreateTag().getDouble("Power") == 0.0) {
               targetitem.getOrCreateTag().putDouble("Power", 0.25);
            }
         } else if (targetitem.getOrCreateTag().getDouble("Power") == 0.0) {
            targetitem.getOrCreateTag().putDouble("Power", 0.125);
         }

         if (targetitem.is(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) && targetitem.getOrCreateTag().getDouble("CursePower") == 0.0) {
            if (targetitem.is(ItemTags.create(new ResourceLocation("gaigegaigekaigecraft:cursed_tool_grade0")))) {
               if (targetitem.getItem() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()) {
                  targetitem.getOrCreateTag().putDouble("CursePower", -10.0);
               } else {
                  targetitem.getOrCreateTag().putDouble("CursePower", 10.0);
               }
            } else if (targetitem.is(ItemTags.create(new ResourceLocation("gaigegaigekaigecraft:cursed_tool_grade1")))) {
               targetitem.getOrCreateTag().putDouble("CursePower", 7.0);
            } else if (targetitem.is(ItemTags.create(new ResourceLocation("gaigegaigekaigecraft:cursed_tool_grade2")))) {
               targetitem.getOrCreateTag().putDouble("CursePower", 5.0);
            } else if (targetitem.is(ItemTags.create(new ResourceLocation("gaigegaigekaigecraft:cursed_tool_grade3")))) {
               targetitem.getOrCreateTag().putDouble("CursePower", 3.0);
            } else if (targetitem.is(ItemTags.create(new ResourceLocation("gaigegaigekaigecraft:cursed_tool_grade4")))) {
               targetitem.getOrCreateTag().putDouble("CursePower", 2.0);
            } else {
               targetitem.getOrCreateTag().putDouble("CursePower", 1.0);
            }
         }

         if (targetitem.getItem() == JujutsucraftModItems.BLAZING_COURAGE.get()) {
            NUM1 = 1.0 - Math.random() * 0.2;
            NUM2 = 0.5 + Math.random() * 0.2;
            targetitem.getOrCreateTag().putString("color1", NUM2 + " " + NUM2 + " " + NUM1 + " 1");
            targetitem.getOrCreateTag().putString("color2", targetitem.getOrCreateTag().getString("color1"));
            targetitem.getOrCreateTag().putString("color3", "gaigegaigekaigecraft:particle_curse_power_blue");
            targetitem.getOrCreateTag().putString("slash_color", "slash_flame_blue");
         } else if (targetitem.getItem() != JujutsucraftModItems.BLACK_ROPE.get() && targetitem.getItem() != JujutsucraftModItems.SICKLE.get() && targetitem.getItem() != JujutsucraftModItems.SWORD_BLACK.get()) {
            if (targetitem.getItem() == JujutsucraftModItems.NYOI_STAFF.get() || targetitem.getItem() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
               targetitem.getOrCreateTag().putString("slash_color", "slash_red");
            }
         } else {
            NUM1 = 0.0 + Math.random() * 0.3;
            targetitem.getOrCreateTag().putString("color1", NUM1 + " " + NUM1 + " " + NUM1 + " 1");
            targetitem.getOrCreateTag().putString("color2", targetitem.getOrCreateTag().getString("color1"));
            targetitem.getOrCreateTag().putString("slash_color", "slash_black");
         }

      }
   }
}
