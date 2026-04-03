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

public class Modelcursedspirit3_16<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_16"), "main");
   public final ModelPart head;
   public final ModelPart body;

   public Modelcursedspirit3_16(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 1.0F));
      head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 2).addBox(-4.5F, -10.5289F, -3.5896F, 9.0F, 3.0F, 10.0F, new CubeDeformation(-0.1F)).texOffs(0, 0).mirror().addBox(-5.5F, -8.5289F, -1.5896F, 11.0F, 12.0F, 9.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 56).addBox(-4.0F, -1.4323F, -6.1453F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F)).texOffs(0, 46).addBox(-4.5F, -0.3392F, -6.2003F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.1F)).texOffs(0, 2).addBox(-4.0F, -0.3323F, -6.1453F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4272F, -1.8994F, -0.1309F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 56).addBox(-4.0F, -2.4303F, -6.9692F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.15F)).texOffs(0, 46).addBox(-4.5F, -2.5741F, -6.9836F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.1F)).texOffs(0, 3).addBox(-4.5F, -7.5303F, -6.9692F, 9.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4272F, -1.8994F, -0.4363F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 49).addBox(-3.5F, -2.2003F, 0.3392F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.4272F, -1.8994F, 1.4399F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-4.0F, -1.061F, 12.3027F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, -15.0F));
      body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 21).addBox(-1.5F, -1.1078F, -7.9468F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, -2.8523F, 1.1258F, -3.0032F));
      body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 21).addBox(-1.5F, -1.1078F, -7.9468F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, -2.8523F, -1.1258F, 3.0032F));
      body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(2, 21).addBox(-1.5F, -0.5F, -4.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 13.5F, 0.1745F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 21).addBox(-2.0F, -4.3F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, 17.0F, 0.0873F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 5).mirror().addBox(-3.0F, -4.0F, -3.5F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 17.0F, 0.0873F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-5.0F, 0.939F, -2.6258F, 10.0F, 8.0F, 10.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.4272F, 14.1006F, -0.0436F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
   }
}
