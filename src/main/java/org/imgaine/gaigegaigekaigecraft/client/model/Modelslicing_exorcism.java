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

public class Modelslicing_exorcism<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelslicing_exorcism"), "main");
   public final ModelPart main;

   public Modelslicing_exorcism(ModelPart root) {
      this.main = root.getChild("main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 3.1416F));
      body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
      body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.3927F, 3.1416F));
      body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
      body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, 3.1416F));
      body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.3927F, 3.1416F));
      body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
      body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
      body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
      body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
      body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
      body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
      body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
      body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-2, 0).addBox(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
      PartDefinition bone6 = body.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition bone2 = bone6.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(1, 3).addBox(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      PartDefinition bone3 = bone6.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
      bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(1, 3).addBox(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      PartDefinition bone4 = bone6.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
      bone4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(1, 3).addBox(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      PartDefinition bone5 = bone6.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      bone5.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone5.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone5.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(1, 3).addBox(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone5.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(-1, 3).addBox(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      return LayerDefinition.create(meshdefinition, 4, 4);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.main.yRot = ageInTicks;
   }
}
