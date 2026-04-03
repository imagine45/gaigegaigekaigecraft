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

public class Modelarmor_naoya_cursed_spirit<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelarmor_naoya_cursed_spirit"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart steve;

   public Modelarmor_naoya_cursed_spirit(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.steve = root.getChild("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 19).addBox(-2.5F, 22.0F, -1.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-2.35F, 3.75F, -2.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.4F, 7.2F, -0.5F, 0.0F, 0.0F, -0.5236F));
      body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(16, 20).addBox(-0.65F, 3.75F, -2.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.4F, 7.2F, -0.5F, 0.0F, 0.0F, 0.5236F));
      body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(16, 20).addBox(-3.0F, -1.0721F, 1.4733F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.5F, 14.1537F, -1.0F, 0.5236F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-3.0F, -1.0721F, -4.4733F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.5F, 14.1537F, 1.0F, -0.5236F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(16, 20).addBox(-2.5F, -4.1062F, 2.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.5F, 17.0799F, 0.0F, 0.5236F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-2.5F, -4.1062F, -5.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.5F, 17.0799F, 0.0F, -0.5236F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-2.5F, -4.1062F, 2.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.5F, 17.0799F, 0.0F, 0.5236F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(16, 20).addBox(-2.5F, -4.1062F, -5.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.5F, 17.0799F, 0.0F, -0.5236F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 19).addBox(-1.5F, -4.0F, -2.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5613F, 20.0929F, 0.0F, 0.0F, 0.0F, 0.2618F));
      body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.5F, -4.0F, -2.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5613F, 20.0929F, 0.0F, 0.0F, 0.0F, -0.2618F));
      body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(2, 21).mirror().addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5745F, 21.3853F, 0.0F, 0.0F, 0.0F, -1.0472F));
      body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(2, 21).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5745F, 21.3853F, 0.0F, 0.0F, 0.0F, 1.0472F));
      body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -4.3968F, -1.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.3968F, 2.5F, -0.1745F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -4.3968F, -2.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.3968F, -2.5F, 0.1745F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 19).addBox(-1.5F, -1.5644F, 2.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 17.0799F, 0.0F, -0.1745F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -1.5644F, -5.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 17.0799F, 0.0F, 0.1745F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-2.5F, -1.5644F, 2.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 17.0799F, 0.0F, -0.1745F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.5F, -1.5644F, -5.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 17.0799F, 0.0F, 0.1745F, 0.7854F, 0.0F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("steve", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16).mirror().addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 16).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 16).mirror().addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
