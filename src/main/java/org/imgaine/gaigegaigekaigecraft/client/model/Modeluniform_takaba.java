package org.imgaine.gaigegaigekaigecraft.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modeluniform_takaba<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modeluniform_takaba"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightBoot;
   public final ModelPart armorLeftBoot;

   public Modeluniform_takaba(ModelPart root) {
      this.armorHead = root.getChild("armorHead");
      this.armorBody = root.getChild("armorBody");
      this.armorRightArm = root.getChild("armorRightArm");
      this.armorLeftArm = root.getChild("armorLeftArm");
      this.armorRightLeg = root.getChild("armorRightLeg");
      this.armorLeftLeg = root.getChild("armorLeftLeg");
      this.armorRightBoot = root.getChild("armorRightBoot");
      this.armorLeftBoot = root.getChild("armorLeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-3.0F, -12.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.8F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)).texOffs(20, 10).addBox(-2.0F, 9.7F, -3.1F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-1.1F)).texOffs(20, 10).addBox(-2.0F, -1.7F, -2.7F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-1.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(16, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.29F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.29F)).mirror(false).texOffs(0, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.08F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.08F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.08F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
