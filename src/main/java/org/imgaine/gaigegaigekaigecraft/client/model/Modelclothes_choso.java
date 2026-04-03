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

public class Modelclothes_choso<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_choso"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_choso(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.RightLeg2 = root.getChild("RightLeg2");
      this.LeftLeg2 = root.getChild("LeftLeg2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 12.5F, 2.5F, 2.8798F, 0.0F, 3.1416F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(21, 20).addBox(-3.0F, -3.0332F, -2.4945F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.1F, 0.4F, 0.0F, 0.3927F, -1.5708F, 0.0F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(21, 20).addBox(-3.0F, -3.0332F, 2.4945F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.1F, 0.4F, 0.0F, -0.3927F, -1.5708F, 0.0F));
      Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(21, 20).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.4F, 2.6F, -2.7489F, 0.0F, -3.1416F));
      Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(21, 20).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.4F, -2.6F, 0.3927F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(20, 20).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 12.5F, -2.5F, -0.2618F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(4, 17).mirror().addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0071F, 2.883F, 1.0436F, 2.7794F, -0.7519F, -2.8883F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(5.0F, 2.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(4, 17).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0071F, 2.883F, 0.9436F, 2.7794F, 0.7519F, 2.8883F));
      partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
