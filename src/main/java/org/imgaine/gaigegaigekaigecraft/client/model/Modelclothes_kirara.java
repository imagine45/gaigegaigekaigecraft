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

public class Modelclothes_kirara<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_kirara"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightBoot;
   public final ModelPart armorLeftBoot;

   public Modelclothes_kirara(ModelPart root) {
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
      PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      armorHead.addOrReplaceChild("headwear_r1", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-2.2054F, -4.7158F, 0.0378F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.6373F, -1.1107F, 3.8089F, 1.2743F, 0.4754F, 0.1105F));
      armorHead.addOrReplaceChild("headwear_r2", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-0.1887F, -3.4395F, -1.2179F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.4686F, 4.5424F, 0.4605F, -0.1218F, -0.9242F));
      armorHead.addOrReplaceChild("headwear_r3", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.6914F, -0.0765F, 3.6743F, 0.9846F, -1.2457F, -1.3612F));
      armorHead.addOrReplaceChild("headwear_r4", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-2.2846F, -3.2247F, -0.1043F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.6373F, -1.1107F, 3.8089F, 0.7097F, 0.6961F, -0.4519F));
      armorHead.addOrReplaceChild("headwear_r5", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(1.1502F, 1.1239F, 4.7945F, 0.2663F, 0.3226F, -0.1122F));
      armorHead.addOrReplaceChild("headwear_r6", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-1.0413F, -4.1389F, -0.1147F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.6373F, -1.1107F, 3.8089F, 1.7546F, 0.6106F, 0.7003F));
      armorHead.addOrReplaceChild("headwear_r7", CubeListBuilder.create().texOffs(56, 8).addBox(-2.9587F, -4.1389F, -0.1147F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.6373F, -1.1107F, 3.8089F, 1.7546F, -0.6106F, -0.7003F));
      armorHead.addOrReplaceChild("headwear_r8", CubeListBuilder.create().texOffs(56, 8).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.1502F, 1.1239F, 4.7945F, 0.2663F, -0.3226F, 0.1122F));
      armorHead.addOrReplaceChild("headwear_r9", CubeListBuilder.create().texOffs(56, 8).addBox(-1.7154F, -3.2247F, -0.1043F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.6373F, -1.1107F, 3.8089F, 0.7097F, -0.6961F, 0.4519F));
      armorHead.addOrReplaceChild("headwear_r10", CubeListBuilder.create().texOffs(56, 8).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.6914F, -0.0765F, 3.6743F, 0.9846F, 1.2457F, 1.3612F));
      armorHead.addOrReplaceChild("headwear_r11", CubeListBuilder.create().texOffs(56, 8).addBox(-3.8113F, -3.4395F, -1.2179F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 1.4686F, 4.5424F, 0.4605F, 0.1218F, 0.9242F));
      armorHead.addOrReplaceChild("headwear_r12", CubeListBuilder.create().texOffs(56, 8).addBox(-1.7946F, -4.7158F, 0.0378F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.6373F, -1.1107F, 3.8089F, 1.2743F, -0.4754F, -0.1105F));
      PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      armorBody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(19, 40).addBox(-4.0F, -1.05F, 2.7F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 7.7893F, -4.1999F, 0.7854F, 0.0F, 0.0F));
      armorBody.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(19, 37).addBox(-4.0F, -1.5F, 0.1F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 3.47F, -2.6F, -0.3927F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(48, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(32, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(40, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(16, 48).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(0, 32).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(0, 48).addBox(-5.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(1.9F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
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
