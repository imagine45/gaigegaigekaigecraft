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

public class Modelfist<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelfist"), "main");
   public final ModelPart bone;

   public Modelfist(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-0.8104F, 8.4956F, 5.4229F));
      PartDefinition bone7 = bone.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(-1.1871F, -4.538F, -4.0018F));
      bone7.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(21, 19).mirror().addBox(-14.0025F, -11.9576F, 14.5789F, 28.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 10.3402F, 4.3836F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 18).mirror().addBox(-14.0025F, -11.9576F, 14.5789F, 28.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 8.1402F, 0.3836F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-14.0025F, -11.9576F, 6.5789F, 28.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 12).mirror().addBox(-14.0025F, -11.9576F, -9.4211F, 26.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 6.3402F, -2.6164F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 12).mirror().addBox(-17.7861F, -9.9576F, 5.9473F, 6.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 6.3402F, -2.6164F, 0.0F, 0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(14, 12).mirror().addBox(-14.2705F, -11.655F, 0.0722F, 6.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 6.3402F, -2.6164F, -0.0833F, -0.2617F, -0.0445F));
      bone7.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 12).mirror().addBox(-12.0025F, -8.0772F, 0.0993F, 26.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 12).mirror().addBox(-13.9025F, -7.9772F, 0.1993F, 29.8F, 7.8F, 19.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 6.3402F, -2.6164F, -0.3491F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 12).mirror().addBox(11.9975F, -9.9576F, -7.4211F, 4.0F, 12.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 6.3402F, -4.6164F, 0.0F, -0.0873F, 0.0F));
      bone7.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(14, 12).mirror().addBox(10.5513F, -7.8576F, -3.5766F, 11.8F, 13.8F, 19.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 6.3402F, -2.6164F, 0.0F, -0.4363F, 0.0F));
      bone7.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(14, 12).mirror().addBox(14.5513F, -7.8576F, -1.5766F, 7.8F, 13.8F, 15.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.7002F, 5.3402F, -6.6164F, 0.0F, -0.4363F, 0.0F));
      PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-15.3523F, -6.2331F, -8.7054F));
      bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(-3.7F, -4.7F, -4.7F, 7.4F, 9.4F, 9.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6511F, -0.8926F, -1.7391F, 0.0873F, 0.0436F, 0.0F));
      bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-16.1284F, -4.9819F, -3.1872F, 7.4F, 9.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(13.8529F, -0.6528F, 0.8837F, -0.1745F, 0.2182F, 0.0F));
      bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-17.4301F, -12.0456F, -12.1283F, 8.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.8654F, 8.0353F, 2.0873F, -0.0873F, 0.0436F, 0.0F));
      bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-16.3097F, -4.2246F, -3.5315F, 7.4F, 7.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false).texOffs(1, 1).mirror().addBox(-16.9051F, -3.1475F, -2.4608F, 7.4F, 5.4F, 13.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(14.8654F, 8.0353F, 2.0873F, -2.3126F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-17.6051F, -11.077F, -2.2259F, 7.6F, 7.6F, 13.6F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-16.4097F, -12.0097F, -3.306F, 7.6F, 9.6F, 15.6F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(14.8654F, 8.0353F, 2.0873F, 2.4435F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-19.4852F, -12.7089F, -6.3646F, 7.8F, 7.8F, 13.8F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 0).mirror().addBox(-18.2863F, -13.7563F, -7.3867F, 7.8F, 9.8F, 15.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(14.8654F, 8.0353F, 2.0873F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-7.3523F, -6.2331F, -10.7054F));
      bone3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(-8.4686F, -5.6692F, -10.0044F, 7.4F, 9.4F, 9.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(5.8529F, -0.6528F, 2.8837F, 0.0873F, -0.0436F, 0.0F));
      bone3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.2838F, -5.117F, -3.5906F, 7.4F, 9.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(5.8529F, -0.6528F, 2.8837F, -0.1745F, 0.0436F, 0.0F));
      bone3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-9.2375F, -11.9638F, -13.0634F, 8.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.8654F, 8.0353F, 4.0873F, -0.0873F, 0.0436F, 0.0F));
      bone3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-8.1658F, -3.2697F, -2.6565F, 7.4F, 7.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false).texOffs(1, 1).mirror().addBox(-8.7612F, -2.1926F, -1.5858F, 7.4F, 5.4F, 13.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(6.8654F, 8.0353F, 4.0873F, -2.3126F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-9.4612F, -11.9095F, -1.2338F, 7.6F, 7.6F, 13.6F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-8.2658F, -12.8422F, -2.3139F, 7.6F, 9.6F, 15.6F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(6.8654F, 8.0353F, 4.0873F, 2.4435F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-11.58F, -14.836F, -7.3565F, 7.8F, 7.8F, 13.8F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 0).mirror().addBox(-10.3812F, -15.8834F, -8.3786F, 7.8F, 9.8F, 15.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(6.8654F, 8.0353F, 4.0873F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.6477F, -6.2331F, -12.7054F));
      bone4.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(-0.3981F, -5.9525F, -11.8426F, 7.4F, 9.4F, 9.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-2.1471F, -0.6528F, 4.8837F, 0.0873F, -0.0436F, 0.0F));
      bone4.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-7.3437F, -4.9308F, -5.3181F, 7.4F, 9.4F, 15.4F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(4.8728F, -0.6528F, 5.8837F, -0.1745F, -0.0436F, 0.0F));
      bone4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0449F, -11.882F, -13.9986F, 8.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.1346F, 8.0353F, 6.0873F, -0.0873F, 0.0436F, 0.0F));
      bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-0.0219F, -2.3148F, -1.7815F, 7.4F, 7.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false).texOffs(1, 1).mirror().addBox(-0.6173F, -1.2377F, -0.7108F, 7.4F, 5.4F, 13.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-1.1346F, 8.0353F, 6.0873F, -2.3126F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-1.3173F, -12.742F, -0.2416F, 7.6F, 7.6F, 13.6F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-0.1219F, -13.6747F, -1.3218F, 7.6F, 9.6F, 15.6F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-1.1346F, 8.0353F, 6.0873F, 2.4435F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-3.6749F, -16.9632F, -8.3484F, 7.8F, 7.8F, 13.8F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.476F, -18.0106F, -9.3705F, 7.8F, 9.8F, 15.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-1.1346F, 8.0353F, 6.0873F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(8.6477F, -6.2331F, -13.7054F));
      bone5.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(7.7251F, -5.7746F, -10.5085F, 7.4F, 9.4F, 9.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-10.1471F, -0.6528F, 5.8837F, 0.0873F, -0.0436F, 0.0F));
      bone5.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 0).addBox(-15.2923F, -5.2745F, -2.6902F, 7.4F, 9.4F, 15.4F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(12.8728F, -0.6528F, 5.8837F, -0.1745F, -0.0436F, 0.0F));
      bone5.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(7.0172F, -11.8866F, -13.946F, 8.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.1346F, 8.0353F, 7.0873F, -0.0873F, 0.0436F, 0.0F));
      bone5.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(8.0348F, -2.0944F, -1.5795F, 7.4F, 7.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false).texOffs(1, 1).mirror().addBox(7.4394F, -1.0173F, -0.5089F, 7.4F, 5.4F, 13.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-9.1346F, 8.0353F, 7.0873F, -2.3126F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(6.7394F, -12.9341F, -0.0126F, 7.6F, 7.6F, 13.6F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(7.9348F, -13.8669F, -1.0928F, 7.6F, 9.6F, 15.6F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-9.1346F, 8.0353F, 7.0873F, 2.4435F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(4.2739F, -18.1849F, -8.9181F, 7.8F, 7.8F, 13.8F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 0).mirror().addBox(5.4728F, -19.2323F, -9.9402F, 7.8F, 9.8F, 15.8F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-9.1346F, 8.0353F, 7.0873F, 1.1345F, -0.1309F, 0.0F));
      PartDefinition bone6 = bone.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9678F, 21.9377F, -21.0252F, -2.3282F, -0.4851F, 1.3307F));
      bone6.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(2.049F, -19.4219F, 1.3708F, 5.8F, 5.8F, 1.8F, new CubeDeformation(-0.1F)).mirror(false).texOffs(0, 13).mirror().addBox(1.3692F, -20.1388F, 2.4101F, 7.4F, 7.4F, 15.4F, new CubeDeformation(-0.3F)).mirror(false).texOffs(1, 1).mirror().addBox(0.7738F, -19.0617F, 3.4808F, 7.4F, 5.4F, 13.4F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-12.3703F, -17.2535F, -15.7025F, -2.4074F, -0.2936F, 0.0879F));
      bone6.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-1.9262F, -19.707F, -5.0658F, 9.6F, 9.6F, 13.6F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(-0.7308F, -20.6398F, -6.1459F, 9.6F, 11.6F, 15.6F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-12.3703F, -17.2535F, -15.7025F, 2.3486F, -0.2936F, 0.0879F));
      bone6.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(0.0738F, -20.038F, -15.76F, 7.6F, 7.6F, 13.6F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(1.2692F, -20.9707F, -16.8401F, 7.6F, 9.6F, 15.6F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-12.3703F, -17.2535F, -15.7025F, 2.4795F, -0.2936F, 0.0879F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bone.yRot = netHeadYaw / 57.295776F;
      this.bone.xRot = headPitch / 57.295776F;
   }
}
