package org.imgaine.gaigegaigekaigecraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade06Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade08Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class GenericItemLayer<T extends LivingEntity & GeoAnimatable> extends BlockAndItemGeoLayer<T> {
   private final DynamicGeoEntityRenderer<T> renderer;

   public GenericItemLayer(DynamicGeoEntityRenderer<T> renderer) {
      super(renderer);
      this.renderer = renderer;
   }

   @Nullable
   protected ItemStack getStackForBone(GeoBone bone, T animatable) {
      ItemStack mainHandItem = animatable.m_21205_();
      ItemStack offhandItem = animatable.m_21206_();
      ItemStack headItem = animatable.m_6844_(EquipmentSlot.HEAD);
      Item var7 = headItem.m_41720_();
      if (var7 instanceof ArmorItem armorItem) {
         if (armorItem.m_40402_().m_20751_().equals("head")) {
            headItem = ItemStack.f_41583_;
         }
      }

      switch (bone.getName()) {
         case "itemMainHand":
            return mainHandItem;
         case "itemOffHand":
            return offhandItem;
         case "itemMainHand2":
         case "itemMainHand3":
            return mainHandItem;
         case "itemOffHand2":
         case "itemOffHand3":
            return offhandItem;
         case "Head":
         case "armorHead":
            return headItem;
         default:
            return null;
      }
   }

   protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, T animatable) {
      switch (bone.getName()) {
         case "itemOffHand":
         case "itemMainHand":
            return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
         case "itemOffHand2":
         case "itemOffHand3":
         case "itemMainHand2":
         case "itemMainHand3":
            return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
         case "Head":
         case "armorHead":
            return ItemDisplayContext.HEAD;
         default:
            return ItemDisplayContext.NONE;
      }
   }

   protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, T animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
      ItemStack mainHandItem = animatable.m_21205_();
      ItemStack offhandItem = animatable.m_21206_();
      ItemStack headItem = animatable.m_6844_(EquipmentSlot.HEAD);
      float scaleFactor = 1.0F;
      if (stack != mainHandItem && stack != offhandItem) {
         if (stack == headItem) {
            scaleFactor = 0.625F;
            poseStack.m_252880_(0.0F, 0.25F, 0.0F);
            poseStack.m_85841_(scaleFactor, scaleFactor, scaleFactor);
         }
      } else {
         if (animatable instanceof CursedSpiritGrade06Entity) {
            scaleFactor = 2.75F;
         }

         if (animatable instanceof CursedSpiritGrade08Entity) {
            scaleFactor = 1.5F;
         }

         poseStack.m_85841_(scaleFactor, scaleFactor, scaleFactor);
         poseStack.m_252781_(Axis.f_252529_.m_252977_(-90.0F));
         if (stack.m_41720_() instanceof ShieldItem && stack == offhandItem) {
            poseStack.m_252880_(0.0F, -0.25F, 0.0F);
            poseStack.m_252781_(Axis.f_252403_.m_252977_(180.0F));
         }
      }

      super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
   }
}
