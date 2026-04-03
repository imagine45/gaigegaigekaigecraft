package org.imgaine.gaigegaigekaigecraft.item;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelmahoraga;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public abstract class MahoragaWheelItem extends ArmorItem {
   public MahoragaWheelItem(ArmorItem.Type type, Item.Properties properties) {
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
            return "mahoraga_wheel";
         }

         public float getToughness() {
            return 0.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Helmet extends MahoragaWheelItem {
      public Helmet() {
         super(Type.HELMET, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new Modelmahoraga(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmahoraga.LAYER_LOCATION))).head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         list.add(Component.translatable("item.gaigegaigekaigecraft.mahoraga_wheel_helmet.description_0"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "gaigegaigekaigecraft:textures/entities/mahoraga_wheel.png";
      }
   }
}
