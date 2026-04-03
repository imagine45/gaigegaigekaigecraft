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

public class ModelRabbitEscape<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_rabbit_escape"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public ModelRabbitEscape(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -1.8213F, -3.8787F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.4F)).texOffs(0, 28).addBox(-1.5F, -0.1F, -6.4F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 22).addBox(-0.5F, -0.4F, -6.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(0, 21).addBox(-2.5F, -0.1F, -4.6101F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 16.7F, 0.3F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(26, 26).mirror().addBox(0.9292F, -12.8353F, -1.643F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-2.8799F, 5.4623F, -6.3812F, -0.5171F, -0.4326F, 0.5045F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(26, 26).addBox(-2.9292F, -12.8353F, -1.643F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(2.8799F, 5.4623F, -6.3812F, -0.5171F, 0.4326F, -0.5045F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -9.3909F, -5.2406F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 8.1247F, -7.2134F, -0.7854F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(20, 16).addBox(0.542F, -8.8909F, -6.4462F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).texOffs(26, 22).addBox(1.342F, -8.3909F, -5.6462F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.8683F, 8.5533F, -6.4191F, -0.8408F, 0.321F, -0.3389F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-3.542F, -8.8909F, -6.4462F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(26, 22).mirror().addBox(-2.342F, -8.3909F, -5.6462F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-1.8683F, 8.5533F, -6.4191F, -0.8408F, -0.321F, 0.3389F));
      Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(0, 21).addBox(-0.389F, -9.5482F, -4.2201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(6.3321F, 3.8141F, -0.39F, 0.0F, 0.0F, -1.103F));
      Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -10.092F, -1.2768F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 6.7247F, -6.8533F, -0.7854F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-1.611F, -9.5482F, -4.2201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-6.3321F, 3.8141F, -0.39F, 0.0F, 0.0F, 1.103F));
      Head.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(0, 21).addBox(-2.8411F, -7.7F, -4.94F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.1615F, 7.6F, -0.7113F, 0.0F, -0.4625F, 0.0F));
      Head.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(0.8411F, -7.7F, -4.94F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(1.1615F, 7.6F, -0.7113F, 0.0F, 0.4625F, 0.0F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -6.4419F, -0.5537F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 22.6118F, -0.6595F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -6.4182F, 7.5084F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, -0.1746F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -5.8724F, 1.4105F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -1.3499F, -0.5682F, -0.3491F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-0.4F, 4.2F, -4.819F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-3.0F, 18.8F, 0.5F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-3.4F, -6.1043F, 0.416F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 3.8858F, -3.7871F, -0.6632F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 21).addBox(-1.6F, 4.2F, -4.819F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(3.0F, 18.8F, 0.5F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 21).addBox(1.4F, -6.1043F, 0.416F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.8858F, -3.7871F, -0.6632F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-0.7F, 3.3F, -1.419F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.3F, 19.7F, 4.9F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, -4.7204F, 4.0145F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3F, 0.1067F, -5.5871F, -0.5934F, 0.0F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, -2.8828F, 6.4173F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.3F, -5.8392F, 1.0397F, -1.6057F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 21).addBox(-1.3F, 3.3F, -1.419F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.3F, 19.7F, 4.9F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(2.0F, -4.7204F, 4.0145F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3F, 0.1067F, -5.5871F, -0.5934F, 0.0F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(2.0F, -2.8828F, 6.4173F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-3.3F, -5.8392F, 1.0397F, -1.6057F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
      this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
