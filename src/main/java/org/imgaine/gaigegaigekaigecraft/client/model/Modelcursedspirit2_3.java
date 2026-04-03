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

public class Modelcursedspirit2_3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_2_3"), "main");
   public final ModelPart Worm;

   public Modelcursedspirit2_3(ModelPart root) {
      this.Worm = root.getChild("Worm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Worm = partdefinition.addOrReplaceChild("Worm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition Head = Worm.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -13.7093F, -8.4062F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 94).addBox(-13.0F, -12.7169F, -8.8739F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.8008F, -18.3455F, -1.9635F, 0.0F, 3.1416F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(8, 7).mirror().addBox(-15.0F, -10.0F, -9.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.7093F, -3.0171F, -1.9635F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(8, 7).mirror().addBox(-15.0F, -10.0F, -12.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.2907F, -3.0171F, -1.1781F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(8, 7).mirror().addBox(-15.0F, -11.0F, -25.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-2.15F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.7093F, -4.0171F, -1.5708F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(0, 94).addBox(-13.0F, -7.0F, -9.5F, 26.0F, 12.0F, 16.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 8.9654F, -13.3033F, -1.9635F, 0.0F, 0.0F));
      PartDefinition bone2 = Head.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-0.1F, 4.3506F, -10.8651F));
      bone2.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(15, 123).addBox(1.3174F, 4.3247F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.0354F, -0.4243F, -1.5708F, 1.0472F, 1.5708F));
      bone2.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(4, 123).mirror().addBox(-12.0F, 4.3247F, -15.8174F, 25.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, -0.0354F, -0.4243F, -0.5236F, 0.0F, -3.1416F));
      bone2.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(0, 94).mirror().addBox(-13.0F, -7.1753F, -0.1826F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(74, 95).mirror().addBox(-7.5F, 4.8247F, -1.1826F, 15.0F, 1.0F, 12.0F, new CubeDeformation(1.1F)).mirror(false), PartPose.offsetAndRotation(0.1F, -0.0354F, -0.4243F, -2.618F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(15, 123).mirror().addBox(-15.3174F, 4.3247F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, -0.0354F, -0.4243F, -1.5708F, -1.0472F, -1.5708F));
      PartDefinition bone = Head.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.125F, -5.8008F, -11.4661F));
      bone.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(15, 123).addBox(-14.6924F, 4.9497F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.125F, 0.0F, 0.1768F, -1.5708F, -1.0472F, 1.5708F));
      bone.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(15, 123).mirror().addBox(0.6924F, 4.9497F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.125F, 0.0F, 0.1768F, -1.5708F, 1.0472F, -1.5708F));
      bone.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(0, 94).mirror().addBox(-13.0F, -6.5503F, -0.8076F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.125F, 0.0F, 0.1768F, -2.618F, 0.0F, 3.1416F));
      bone.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(4, 123).mirror().addBox(-12.0F, 4.9497F, -15.1924F, 25.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.125F, 0.0F, 0.1768F, -0.5236F, 0.0F, 0.0F));
      PartDefinition Body2 = Worm.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-1.4F)).mirror(false), PartPose.offset(0.0F, -14.6206F, -11.9568F));
      Body2.addOrReplaceChild("Body2_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body2.addOrReplaceChild("Body2_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.35F)), PartPose.offsetAndRotation(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body3 = Body2.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-1.8F)).mirror(false), PartPose.offset(0.0F, 0.0F, 24.0F));
      Body3.addOrReplaceChild("Body3_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.8F)), PartPose.offsetAndRotation(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body3.addOrReplaceChild("Body3_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.75F)), PartPose.offsetAndRotation(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.2F)).mirror(false), PartPose.offset(0.0F, 0.0F, 23.0F));
      Body4.addOrReplaceChild("Body4_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.2F)), PartPose.offsetAndRotation(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body4.addOrReplaceChild("Body4_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.15F)), PartPose.offsetAndRotation(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body5 = Body4.addOrReplaceChild("Body5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.1F)).mirror(false), PartPose.offset(0.0F, 0.0F, 23.0F));
      Body5.addOrReplaceChild("Body5_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.1F)), PartPose.offsetAndRotation(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body5.addOrReplaceChild("Body5_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.95F)), PartPose.offsetAndRotation(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body6 = Body5.addOrReplaceChild("Body6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.1294F, -6.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 24.0F));
      Body6.addOrReplaceChild("Body6_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.5F)), PartPose.offsetAndRotation(0.375F, -3.3794F, 13.7685F, -2.8798F, 0.0F, 0.0F));
      Body6.addOrReplaceChild("Body6_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.35F)), PartPose.offsetAndRotation(0.0F, -3.4264F, 4.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body7 = Body6.addOrReplaceChild("Body7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.1294F, -8.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-4.1F)).mirror(false), PartPose.offset(0.0F, 0.0F, 19.0F));
      Body7.addOrReplaceChild("Body7_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)), PartPose.offsetAndRotation(0.375F, -3.3794F, 11.7685F, -2.8798F, 0.0F, 0.0F));
      Body7.addOrReplaceChild("Body7_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-3.95F)), PartPose.offsetAndRotation(0.0F, -3.4264F, 2.0561F, 0.2618F, 0.0F, -3.1416F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Worm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Worm.yRot = netHeadYaw / 57.295776F;
      this.Worm.xRot = headPitch / 57.295776F;
   }
}
