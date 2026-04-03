package org.imgaine.gaigegaigekaigecraft.item;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelmahito_phase2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public abstract class ArmorInstantSpiritBodyofDistortedKillingItem extends ArmorItem {
   public ArmorInstantSpiritBodyofDistortedKillingItem(ArmorItem.Type type, Item.Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(ArmorItem.Type type) {
            return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 0;
         }

         public int getDefenseForType(ArmorItem.Type type) {
            return (new int[]{1, 2, 6, 2})[type.getSlot().getIndex()];
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
            return "armor_instant_spirit_bodyof_distorted_killing";
         }

         public float getToughness() {
            return 0.25F;
         }

         public float getKnockbackResistance() {
            return 0.01F;
         }
      }, type, properties);
   }

   public static class Helmet extends ArmorInstantSpiritBodyofDistortedKillingItem {
      public Helmet() {
         super(Type.HELMET, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new Modelmahito_phase2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahito_phase2.LAYER_LOCATION))).head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/mahito_phase2_head.png";
      }
   }

   public static class Chestplate extends ArmorInstantSpiritBodyofDistortedKillingItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new Modelmahito_phase2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahito_phase2.LAYER_LOCATION))).body, "left_arm", (new Modelmahito_phase2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahito_phase2.LAYER_LOCATION))).left_arm, "right_arm", (new Modelmahito_phase2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahito_phase2.LAYER_LOCATION))).right_arm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/mahito_phase2__body.png";
      }
   }

   public static class Leggings extends ArmorInstantSpiritBodyofDistortedKillingItem {
      public Leggings() {
         super(Type.LEGGINGS, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("left_leg", (new Modelmahito_phase2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahito_phase2.LAYER_LOCATION))).left_leg, "right_leg", (new Modelmahito_phase2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahito_phase2.LAYER_LOCATION))).right_leg, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/mahito_phase2__body.png";
      }
   }
}
