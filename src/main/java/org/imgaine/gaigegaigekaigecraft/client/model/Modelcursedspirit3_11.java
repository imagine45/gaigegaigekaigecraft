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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Modelcursedspirit3_11<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_11"), "main");
   public final ModelPart LH;
   public final ModelPart RH;
   public final ModelPart bone8;
   public final ModelPart cube_r5;
   public final ModelPart cube_r4;
   public final ModelPart cube_r3;
   public final ModelPart cube_r2;
   public final ModelPart cube_r1;

   public Modelcursedspirit3_11(ModelPart root) {
      this.LH = root.getChild("LH");
      this.RH = root.getChild("RH");
      this.bone8 = root.getChild("bone8");
      this.cube_r5 = root.getChild("cube_r5");
      this.cube_r4 = root.getChild("cube_r4");
      this.cube_r3 = root.getChild("cube_r3");
      this.cube_r2 = root.getChild("cube_r2");
      this.cube_r1 = root.getChild("cube_r1");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition LH = partdefinition.addOrReplaceChild("LH", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(0.8766F, -1.5F, -9.6667F, 6.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 0).mirror().addBox(6.8766F, -1.5F, -5.6667F, 6.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 0).mirror().addBox(3.8766F, -1.5F, -7.6667F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 0).mirror().addBox(-2.5F, -1.5F, -12.5F, 4.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.5F, 8.5F, 1.5F));
      LH.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-12.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.1949F, 0.0F, -5.8578F, 0.0F, -0.4363F, 0.0F));
      LH.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-12.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.1949F, 0.0F, 6.8578F, 0.0F, 0.4363F, 0.0F));
      PartDefinition bone10 = LH.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-0.8275F, -1.5F, -5.1667F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 0).mirror().addBox(0.1725F, -1.5F, -1.1667F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 0).mirror().addBox(4.1725F, -1.5F, -2.1667F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 0).mirror().addBox(0.1725F, -1.5F, -0.8333F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.7041F, 0.0F, 0.5F));
      bone10.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(0.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5092F, 0.0F, -6.3578F, 0.0F, -0.4363F, 0.0F));
      bone10.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(0.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5092F, 0.0F, 6.3578F, 0.0F, 0.4363F, 0.0F));
      PartDefinition RH = partdefinition.addOrReplaceChild("RH", CubeListBuilder.create().texOffs(24, 0).addBox(-6.8766F, -1.5F, -9.6667F, 6.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-12.8766F, -1.5F, -5.6667F, 6.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-9.8766F, -1.5F, -7.6667F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-1.5F, -1.5F, -12.5F, 4.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, 8.5F, 1.5F));
      RH.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 0).addBox(-0.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1949F, 0.0F, -5.8578F, 0.0F, 0.4363F, 0.0F));
      RH.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 0).addBox(-0.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1949F, 0.0F, 6.8578F, 0.0F, -0.4363F, 0.0F));
      PartDefinition bone4 = RH.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(24, 0).addBox(-5.1725F, -1.5F, -5.1667F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-14.1725F, -1.5F, -1.1667F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-10.1725F, -1.5F, -2.1667F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-14.1725F, -1.5F, -0.8333F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.7041F, 0.0F, 0.5F));
      bone4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(24, 0).addBox(-15.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5092F, 0.0F, -6.3578F, 0.0F, 0.4363F, 0.0F));
      bone4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(24, 0).addBox(-15.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5092F, 0.0F, 6.3578F, 0.0F, -0.4363F, 0.0F));
      PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -3.0F, -31.0F, 14.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)).texOffs(36, 97).addBox(-10.0F, -5.0F, -27.0F, 20.0F, 5.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 16.0F));
      PartDefinition bone5 = bone8.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -2.5F, -1.4139F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -5.5861F));
      bone5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, -2.5F, -18.0F, 7.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1561F, 0.0F, 16.5123F, 0.0F, 0.1745F, 0.0F));
      bone5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -2.5F, -18.0F, 7.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1561F, 0.0F, 16.5123F, 0.0F, -0.1745F, 0.0F));
      PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -2.5F, -0.9131F, 4.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.4993F));
      bone6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, -2.5F, -9.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1561F, 0.0F, 8.013F, 0.0F, 0.1745F, 0.0F));
      bone6.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -2.5F, -9.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1561F, 0.0F, 8.013F, 0.0F, -0.1745F, 0.0F));
      PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -2.5F, -0.8394F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.9262F));
      bone7.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.0F, -2.5F, 5.0F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1561F, 0.0F, -5.9132F, 0.0F, 0.1745F, 0.0F));
      bone7.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -2.5F, 5.0F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1561F, 0.0F, -5.9132F, 0.0F, -0.1745F, 0.0F));
      partdefinition.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 0).addBox(5.0F, -5.0F, -11.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1956F, 11.0F, 10.5857F, 0.0F, -1.1345F, 0.0F));
      partdefinition.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-10.0F, -5.0F, -11.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1956F, 11.0F, 10.5857F, 0.0F, 1.1345F, 0.0F));
      partdefinition.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, -2.5F, -5.5F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1665F, 9.8383F, -14.9986F, 0.2618F, 0.3054F, 0.0F));
      partdefinition.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.5F, -2.5F, -5.5F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.1665F, 9.8383F, -14.9986F, 0.2618F, -0.3054F, 0.0F));
      partdefinition.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 0).addBox(-7.0F, -1.5F, -2.0F, 14.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-7.0F, -1.5F, -2.5F, 14.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2015F, -12.0915F, 0.4712F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.LH.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RH.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RH.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.LH.zRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
