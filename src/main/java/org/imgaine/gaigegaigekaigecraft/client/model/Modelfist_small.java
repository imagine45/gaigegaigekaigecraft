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

public class Modelfist_small<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelfist_small"), "main");
   public final ModelPart bone;

   public Modelfist_small(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-0.0068F, 17.4956F, 0.8324F));
      PartDefinition bone7 = bone.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.311F, 10.4938F, -5.0676F));
      bone7.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-3.5006F, -2.9894F, 3.1447F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -9.0433F, 5.1631F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 6).mirror().addBox(-3.5006F, -2.9894F, 3.6447F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -9.5933F, 4.1631F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 6).mirror().addBox(-3.5006F, -2.9894F, 1.6447F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-3.5006F, -2.9894F, -2.3553F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.0433F, 3.4131F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.9465F, -2.4894F, 1.9868F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.0433F, 3.4131F, 0.0F, 0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.8676F, -2.9137F, -0.4819F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.0433F, 3.4131F, -0.0833F, -0.2617F, -0.0445F));
      bone7.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-2.5006F, -2.0193F, 0.5248F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-3.9506F, -1.9693F, -0.0252F, 8.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.0433F, 3.4131F, -0.3491F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.9994F, -2.4894F, -1.8553F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.0433F, 2.9131F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(2.6628F, -2.4394F, -0.9691F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.0433F, 3.4131F, 0.0F, -0.4363F, 0.0F));
      bone7.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(3.6628F, -2.4394F, -0.4691F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.4328F, -10.2933F, 2.4131F, 0.0F, -0.4363F, 0.0F));
      PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-3.2303F, 10.07F, -6.2435F));
      bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.85F, -1.5F, -1.4F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-0.195F, -11.7515F, 2.7324F, 0.0873F, 0.0436F, 0.0F));
      bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.9571F, -1.6705F, -0.8218F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(2.8554F, -11.6915F, 3.3881F, -0.1745F, 0.2182F, 0.0F));
      bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.3575F, -3.0114F, -3.0321F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1085F, -9.6195F, 4.589F, -0.0873F, 0.0436F, 0.0F));
      bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0024F, -1.1811F, -0.5079F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(0, 0).mirror().addBox(-4.1513F, -1.2119F, -0.8402F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.1085F, -9.6195F, 4.589F, -2.3126F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.5513F, -2.7192F, -0.7065F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-4.0524F, -3.4524F, -0.5765F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(3.1085F, -9.6195F, 4.589F, 2.4435F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.9463F, -3.3522F, -1.8662F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(3.1085F, -9.6195F, 4.589F, 1.1345F, -0.1309F, 0.0F));
      bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.5466F, -3.6141F, -1.9217F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(3.1085F, -9.5195F, 4.389F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-1.2303F, 10.07F, -6.7435F));
      bone3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0421F, -1.8423F, -2.7261F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8554F, -11.7915F, 4.4881F, 0.0873F, -0.0436F, 0.0F));
      bone3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.996F, -1.7042F, -1.0226F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8554F, -11.7915F, 4.4881F, -0.1745F, 0.0436F, 0.0F));
      bone3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.3094F, -3.0909F, -3.2659F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, -0.0873F, 0.0436F, 0.0F));
      bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9664F, -0.7424F, -0.5891F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.1153F, -0.8731F, -0.7215F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, -2.3126F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.4153F, -2.9274F, -0.4584F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0164F, -3.4606F, -0.2285F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, 2.4435F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.87F, -3.884F, -1.9141F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, 1.1345F, -0.1309F, 0.0F));
      bone3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5703F, -4.1459F, -1.9697F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.5195F, 4.889F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.7697F, 10.07F, -7.1435F));
      bone4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0421F, -1.8423F, -2.7261F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8554F, -11.7915F, 4.4881F, 0.0873F, -0.0436F, 0.0F));
      bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.996F, -1.7042F, -1.0226F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8554F, -11.7915F, 4.4881F, -0.1745F, 0.0436F, 0.0F));
      bone4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.3094F, -3.0909F, -3.2659F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, -0.0873F, 0.0436F, 0.0F));
      bone4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9664F, -0.7424F, -0.5891F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.1153F, -0.8731F, -0.7215F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, -2.3126F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.4153F, -2.9274F, -0.4584F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0164F, -3.4606F, -0.2285F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, 2.4435F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.87F, -3.884F, -1.9141F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, 1.1345F, -0.1309F, 0.0F));
      bone4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5703F, -4.1459F, -1.9697F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.5195F, 4.889F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(2.7697F, 10.07F, -6.8435F));
      bone5.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0421F, -1.8423F, -2.7261F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8554F, -11.7915F, 4.4881F, 0.0873F, -0.0436F, 0.0F));
      bone5.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.996F, -1.7042F, -1.0226F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8554F, -11.7915F, 4.4881F, -0.1745F, 0.0436F, 0.0F));
      bone5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.3094F, -3.0909F, -3.2659F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, -0.0873F, 0.0436F, 0.0F));
      bone5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9664F, -0.7424F, -0.5891F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.1153F, -0.8731F, -0.7215F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, -2.3126F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.4153F, -2.9274F, -0.4584F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0164F, -3.4606F, -0.2285F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, 2.4435F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.87F, -3.884F, -1.9141F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.6195F, 5.089F, 1.1345F, -0.1309F, 0.0F));
      bone5.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5703F, -4.1459F, -1.9697F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.1085F, -9.5195F, 4.889F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone6 = bone.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(12.5997F, 6.1127F, -10.3235F, -2.3282F, -0.4851F, 1.3307F));
      bone6.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.2372F, -4.8305F, 0.2677F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 0).mirror().addBox(0.4173F, -4.9597F, 0.3775F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(0, 0).mirror().addBox(-0.0316F, -5.1904F, 0.6452F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-3.7004F, -15.9417F, 0.1415F, -2.4074F, -0.2936F, 0.0879F));
      bone6.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.2316F, -5.1768F, -1.4165F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-0.6327F, -5.41F, -2.1865F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-3.7004F, -15.9417F, 0.1415F, 2.3486F, -0.2936F, 0.0879F));
      bone6.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.3316F, -5.2595F, -4.09F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(0.4423F, -5.6177F, -4.435F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-3.7004F, -15.9417F, 0.1415F, 2.4795F, -0.2936F, 0.0879F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bone.yRot = netHeadYaw / 57.295776F;
      this.bone.xRot = headPitch / 57.295776F;
   }
}
