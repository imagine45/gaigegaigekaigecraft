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

public class Modelcrow<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcrow"), "main");
   public final ModelPart leg1;
   public final ModelPart leg0;
   public final ModelPart tail;
   public final ModelPart wing_right;
   public final ModelPart wing_left;
   public final ModelPart body;
   public final ModelPart head;

   public Modelcrow(ModelPart root) {
      this.leg1 = root.getChild("leg1");
      this.leg0 = root.getChild("leg0");
      this.tail = root.getChild("tail");
      this.wing_right = root.getChild("wing_right");
      this.wing_left = root.getChild("wing_left");
      this.body = root.getChild("body");
      this.head = root.getChild("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(-0.5F, 23.0F, 1.5F));
      leg1.addOrReplaceChild("leg1_r1", CubeListBuilder.create().texOffs(14, 18).addBox(-1.5F, 3.4F, 0.2777F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.4F, -1.2777F, 1.0472F, 0.0F, 0.0F));
      PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create(), PartPose.offset(1.5F, 23.0F, 1.5F));
      leg0.addOrReplaceChild("leg0_r1", CubeListBuilder.create().texOffs(14, 18).addBox(0.5F, 3.4F, 0.2777F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -4.4F, -1.2777F, 1.0472F, 0.0F, 0.0F));
      PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 21.1F, 3.2F));
      tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(22, 1).addBox(-1.5F, -3.0F, 2.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0099F, 3.9837F, 1.7453F, 0.0F, 0.0F));
      PartDefinition wing_right = partdefinition.addOrReplaceChild("wing_right", CubeListBuilder.create(), PartPose.offset(-1.5F, 17.9F, -0.8F));
      wing_right.addOrReplaceChild("wing_right_r1", CubeListBuilder.create().texOffs(19, 8).mirror().addBox(-0.6995F, -0.7199F, -2.0098F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3178F, 0.1516F, 1.4069F, 0.0873F, 0.0436F, 1.5708F));
      PartDefinition wing_left = partdefinition.addOrReplaceChild("wing_left", CubeListBuilder.create(), PartPose.offset(1.5F, 17.9F, -0.8F));
      wing_left.addOrReplaceChild("wing_left_r1", CubeListBuilder.create().texOffs(19, 8).addBox(-0.3005F, -0.7199F, -2.0098F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3178F, 0.1516F, 1.4069F, 0.0873F, -0.0436F, -1.5708F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(1.8178F, 18.0516F, 0.6069F));
      body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(2, 8).addBox(-3.3178F, -2.6473F, -1.6995F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5272F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 17.7F, -1.8F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(16, 7).addBox(-0.5F, -0.9864F, -2.4442F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 0).addBox(-1.0F, -2.6864F, -0.5442F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)).texOffs(0, 1).addBox(-1.0F, -2.1864F, -1.0442F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2661F, -1.8998F, 0.1745F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.wing_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.wing_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.wing_left.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.wing_right.zRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
