package org.imgaine.gaigegaigekaigecraft.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelmahoraga;
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

public abstract class MahoragaBodyItem extends ArmorItem {
   public MahoragaBodyItem(ArmorItem.Type type, Item.Properties properties) {
      super(new ArmorMaterial() {
         public int m_266425_(ArmorItem.Type type) {
            return (new int[]{13, 15, 16, 11})[type.m_266308_().m_20749_()] * 0;
         }

         public int m_7366_(ArmorItem.Type type) {
            return (new int[]{0, 0, 0, 0})[type.m_266308_().m_20749_()];
         }

         public int m_6646_() {
            return 0;
         }

         public SoundEvent m_7344_() {
            return SoundEvents.f_271165_;
         }

         public Ingredient m_6230_() {
            return Ingredient.m_151265_();
         }

         public String m_6082_() {
            return "mahoraga_body";
         }

         public float m_6651_() {
            return 0.0F;
         }

         public float m_6649_() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Helmet extends MahoragaBodyItem {
      public Helmet() {
         super(Type.HELMET, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new Modelmahoraga(Minecraft.m_91087_().m_167973_().m_171103_(Modelmahoraga.LAYER_LOCATION))).head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraft:textures/entities/mahoraga_head.png";
      }

      public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.m_6883_(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player) {
            if (Iterables.contains(player.m_6168_(), itemstack)) {
               KurourushiBodyHelmetTickEventProcedure.execute(entity);
            }
         }

      }
   }

   public static class Chestplate extends MahoragaBodyItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new Modelmahoraga(Minecraft.m_91087_().m_167973_().m_171103_(Modelmahoraga.LAYER_LOCATION))).body, "left_arm", (new Modelmahoraga(Minecraft.m_91087_().m_167973_().m_171103_(Modelmahoraga.LAYER_LOCATION))).left_arm, "right_arm", (new Modelmahoraga(Minecraft.m_91087_().m_167973_().m_171103_(Modelmahoraga.LAYER_LOCATION))).right_arm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraft:textures/entities/mahoraga_body.png";
      }

      public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.m_6883_(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player) {
            if (Iterables.contains(player.m_6168_(), itemstack)) {
               KurourushiBodyHelmetTickEventProcedure.execute(entity);
            }
         }

      }
   }

   public static class Leggings extends MahoragaBodyItem {
      public Leggings() {
         super(Type.LEGGINGS, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("left_leg", (new Modelmahoraga(Minecraft.m_91087_().m_167973_().m_171103_(Modelmahoraga.LAYER_LOCATION))).left_leg, "right_leg", (new Modelmahoraga(Minecraft.m_91087_().m_167973_().m_171103_(Modelmahoraga.LAYER_LOCATION))).right_leg, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraft:textures/entities/mahoraga_leggins.png";
      }
   }
}
