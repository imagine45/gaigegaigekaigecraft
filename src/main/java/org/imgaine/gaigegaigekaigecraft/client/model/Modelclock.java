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

public class Modelclock<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclock"), "main");
   public final ModelPart bone;
   public final ModelPart bone2;
   public final ModelPart bone3;
   public final ModelPart bone4;
   public final ModelPart bone5;
   public final ModelPart bone6;

   public Modelclock(ModelPart root) {
      this.bone = root.getChild("bone");
      this.bone2 = root.getChild("bone2");
      this.bone3 = root.getChild("bone3");
      this.bone4 = root.getChild("bone4");
      this.bone5 = root.getChild("bone5");
      this.bone6 = root.getChild("bone6");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(13, 174).addBox(-34.0F, -4.0F, 152.8749F, 68.0F, 8.0F, 48.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(14, 175).addBox(14.4207F, -4.0F, 128.9011F, 68.0F, 8.0F, 47.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.0F, 3.1416F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(29, 190).addBox(-84.4835F, -4.0F, 133.8812F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, 0.0F, 0.7854F, 0.0F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 190).addBox(-73.7548F, -4.0F, 115.9316F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, 0.0F, 1.1781F, 0.0F));
      bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(29, 190).addBox(-36.6952F, -4.0F, 98.3483F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, -3.1416F, 1.1781F, 3.1416F));
      bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(13, 174).addBox(-56.9738F, -4.0F, 103.4541F, 68.0F, 8.0F, 48.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, 0.0F, 1.5708F, 0.0F));
      bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(29, 190).addBox(1.9432F, -4.0F, 112.12F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.3927F, 3.1416F));
      bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(29, 190).addBox(-16.0063F, -4.0F, 101.3913F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.7854F, 3.1416F));
      bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(29, 190).addBox(19.5266F, -4.0F, 149.1797F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, -3.1416F, -0.3927F, 3.1416F));
      bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(29, 190).addBox(-110.6887F, -4.0F, 39.1988F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-133.9011F, 0.0F, -24.4469F, 0.0F, -2.3562F, 0.0F));
      bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(29, 190).addBox(-61.7318F, -4.0F, 18.4283F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-133.9011F, 0.0F, -24.4469F, 0.0F, -1.9635F, 0.0F));
      bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(29, 190).addBox(40.7516F, -4.0F, 37.9045F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-133.9011F, 0.0F, -24.4469F, 0.0F, -1.1781F, 0.0F));
      bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(13, 174).addBox(-8.5531F, -4.0F, 17.9738F, 68.0F, 8.0F, 48.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-133.9011F, 0.0F, -24.4469F, 0.0F, -1.5708F, 0.0F));
      bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(29, 190).addBox(-3.9833F, -4.0F, 0.9707F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-85.4803F, 0.0F, 128.9304F, 0.0F, -0.3927F, 0.0F));
      bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(29, 190).addBox(-64.0167F, -4.0F, 0.9707F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-85.4803F, 0.0F, 128.9304F, 0.0F, -0.7854F, 0.0F));
      bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(29, 190).addBox(-34.0F, -4.0F, -5.0F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(60.0334F, 0.0F, 145.9335F, 0.0F, 0.3927F, 0.0F));
      PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(268, 0).addBox(-32.1913F, -1.0F, -154.5381F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.9619F, 0.0F, 0.8087F, -3.1416F, -2.7489F, 3.1416F));
      bone2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(268, 0).addBox(-31.8087F, -1.0F, -154.5381F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(0.9619F, 0.0F, 0.8087F, -3.1416F, -2.3562F, 3.1416F));
      bone2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(268, 0).addBox(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -1.5708F, 3.1416F));
      bone2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(268, 0).addBox(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -1.9635F, 3.1416F));
      bone2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(268, 0).addBox(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -0.7854F, 3.1416F));
      bone2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(268, 0).addBox(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.07F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -1.1781F, 3.1416F));
      bone2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(268, 0).addBox(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -0.3927F, 3.1416F));
      bone2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(268, 0).addBox(16.4207F, -1.0F, -180.0989F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -23.5989F, -3.1416F, 0.0F, 3.1416F));
      PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(691, 597).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(306, 694).addBox(-16.0F, -2.0F, -16.0F, 32.0F, 1.0F, 32.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(306, 694).addBox(-17.0F, -2.0F, -17.0F, 33.0F, 1.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(691, 597).addBox(-9.0F, -4.0F, -9.0F, 17.0F, 3.0F, 16.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.7854F, 0.0F));
      PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(580, 544).addBox(-25.0F, -2.6F, -8.0F, 108.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -1.2654F, 0.0F));
      PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(580, 544).addBox(-25.0F, -3.0F, -6.0F, 174.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 2.0944F, 0.0F));
      PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone6.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -2.7489F, 3.1416F));
      bone6.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -1.5708F, 3.1416F));
      bone6.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -1.9635F, 3.1416F));
      bone6.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -1.5708F, 3.1416F));
      bone6.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -1.9635F, 3.1416F));
      bone6.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -2.3562F, 3.1416F));
      bone6.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -2.3562F, 3.1416F));
      bone6.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -2.7489F, 3.1416F));
      bone6.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(13, 174).addBox(46.4207F, -2.0F, -128.9011F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.4207F, 0.0F, 23.9738F, 3.1416F, 0.0F, 3.1416F));
      bone6.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -0.3927F, 3.1416F));
      bone6.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(13, 174).addBox(46.4207F, -2.0F, 78.9011F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.0F, 3.1416F));
      bone6.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -0.3927F, 3.1416F));
      bone6.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -0.7854F, 3.1416F));
      bone6.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -0.7854F, 3.1416F));
      bone6.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -3.1416F, -1.1781F, 3.1416F));
      bone6.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(13, 174).addBox(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 3.1416F, -1.1781F, 3.1416F));
      return LayerDefinition.create(meshdefinition, 1024, 1024);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bone5.yRot = ageInTicks;
      this.bone4.yRot = ageInTicks / 20.0F;
   }
}
