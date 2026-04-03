package org.imgaine.gaigegaigekaigecraft.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelkurourushi;
import org.imgaine.gaigegaigekaigecraft.procedures.KurourushiBodyHelmetTickEventProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public abstract class KurourushiBodyItem extends ArmorItem {
   public KurourushiBodyItem(ArmorItem.Type type, Item.Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(ArmorItem.Type type) {
            return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 0;
         }

         public int getDefenseForType(ArmorItem.Type type) {
            return (new int[]{0, 0, 0, 0})[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 0;
         }

         public SoundEvent getEquipSound() {
            return SoundEvents.EMPTY;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "kurourushi_body";
         }

         public float getToughness() {
            return 0.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Helmet extends KurourushiBodyItem {
      public Helmet() {
         super(Type.HELMET, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new Modelkurourushi(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkurourushi.LAYER_LOCATION))).head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/kurourushi.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player) {
            if (Iterables.contains(player.getArmorSlots(), itemstack)) {
               KurourushiBodyHelmetTickEventProcedure.execute(entity);
            }
         }

      }
   }

   public static class Chestplate extends KurourushiBodyItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new Modelkurourushi(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkurourushi.LAYER_LOCATION))).body, "left_arm", (new Modelkurourushi(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkurourushi.LAYER_LOCATION))).LeftArm, "right_arm", (new Modelkurourushi(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkurourushi.LAYER_LOCATION))).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/kurourushi.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player) {
            if (Iterables.contains(player.getArmorSlots(), itemstack)) {
               KurourushiBodyHelmetTickEventProcedure.execute(entity);
            }
         }

      }
   }

   public static class Leggings extends KurourushiBodyItem {
      public Leggings() {
         super(Type.LEGGINGS, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("left_leg", (new Modelkurourushi(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkurourushi.LAYER_LOCATION))).LeftLeg, "right_leg", (new Modelkurourushi(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkurourushi.LAYER_LOCATION))).RightLeg, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/kurourushi.png";
      }
   }
}
