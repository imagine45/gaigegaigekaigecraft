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

public class Modelclothes_maki<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_maki"), "main");
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;

   public Modelclothes_maki(ModelPart root) {
      this.armorBody = root.getChild("armorBody");
      this.armorRightArm = root.getChild("armorRightArm");
      this.armorLeftArm = root.getChild("armorLeftArm");
      this.armorRightLeg = root.getChild("armorRightLeg");
      this.armorLeftLeg = root.getChild("armorLeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 13).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(29, 1).addBox(-4.0F, 10.8555F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(52, 9).addBox(-1.0F, 10.8555F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).texOffs(39, 2).addBox(-1.0F, 10.8555F, -2.2656F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)).texOffs(22, 51).addBox(2.5F, 10.8555F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).texOffs(23, 54).addBox(2.5F, 10.8555F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).texOffs(24, 55).addBox(4.0F, 10.8555F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).texOffs(24, 55).addBox(4.0F, 10.8555F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).texOffs(29, 11).addBox(3.5F, 3.0F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(31, 12).addBox(3.9F, 4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(31, 12).mirror().addBox(-3.9F, 4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.27F)).mirror(false).texOffs(29, 11).mirror().addBox(-3.5F, 3.0F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.27F)).mirror(false).texOffs(24, 55).mirror().addBox(-4.0F, 10.8555F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).mirror(false).texOffs(22, 51).mirror().addBox(-2.5F, 10.8555F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).mirror(false).texOffs(23, 54).mirror().addBox(-2.5F, 10.8555F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).mirror(false).texOffs(24, 55).mirror().addBox(-4.0F, 10.8555F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(112, 0).addBox(-8.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(112, 0).addBox(4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(0, 80).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(7, 42).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.28F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(16, 112).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(7, 42).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.28F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
