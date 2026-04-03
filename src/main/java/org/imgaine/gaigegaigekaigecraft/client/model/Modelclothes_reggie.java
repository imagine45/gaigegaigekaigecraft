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

public class Modelclothes_reggie<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_reggie"), "main");
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;

   public Modelclothes_reggie(ModelPart root) {
      this.armorBody = root.getChild("armorBody");
      this.armorRightArm = root.getChild("armorRightArm");
      this.armorLeftArm = root.getChild("armorLeftArm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).texOffs(0, 0).addBox(-4.0F, 3.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      armorBody.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(6, 11).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.0F, 13.3921F, 2.5698F, 0.3927F, -0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(5.0F, 13.3921F, 2.5698F, 0.3927F, 0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(5.0F, 13.3921F, -2.5698F, -0.3927F, -0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(5, 11).mirror().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.5921F, 0.0F, -0.7854F, -1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(5, 11).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.5F, 12.5921F, 0.0F, -0.7854F, 1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(6, 11).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.0F, 13.3921F, -2.5698F, -0.3927F, 0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(6, 11).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.5F, 7.3921F, 2.5698F, 0.3927F, -0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(4, 11).addBox(-4.0F, 2.0F, 2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      armorBody.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.5F, 7.3921F, 2.5698F, 0.3927F, 0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.5F, 7.3921F, -2.5698F, -0.3927F, -0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(5, 11).mirror().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(5.5F, 6.5921F, 0.0F, -0.7854F, -1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(5, 11).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.5F, 6.5921F, 0.0F, -0.7854F, 1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(6, 11).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.5F, 7.3921F, -2.5698F, -0.3927F, 0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(4, 11).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      armorBody.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(5, 11).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.5F, -1.4079F, 0.0F, -1.9635F, 1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(5, 11).mirror().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(5.5F, -1.4079F, 0.0F, -1.9635F, -1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(5, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(5.5F, 1.5921F, -0.5F, -0.3927F, -1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.5F, 2.3921F, 2.5698F, 0.3927F, 0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(4, 11).addBox(-4.0F, 2.0F, 2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      armorBody.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(6, 11).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.5F, 2.3921F, 2.5698F, 0.3927F, -0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.5F, 2.3921F, -2.5698F, -0.3927F, -0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(5, 11).addBox(-3.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.5F, 1.5921F, -0.5F, -0.3927F, 1.5708F, 0.0F));
      armorBody.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(6, 11).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.5F, 2.3921F, -2.5698F, -0.3927F, 0.7854F, 0.0F));
      armorBody.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(4, 11).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(16, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.52F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.52F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
