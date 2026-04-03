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

public class Modelgravestone3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelgravestone_3"), "main");
   public final ModelPart bb_main;

   public Modelgravestone3(ModelPart root) {
      this.bb_main = root.getChild("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -48.0F, -32.0F, 64.0F, 96.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(16, 16).addBox(-24.0F, -54.0F, -24.0F, 48.0F, 108.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-24.0F, -38.0F, -40.0F, 48.0F, 76.0F, 80.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -38.0F, -40.0F, 48.0F, 76.0F, 80.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone = bb_main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 198).mirror().addBox(-44.0F, -73.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 198).mirror().addBox(36.0F, -73.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 44.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(23, 221).mirror().addBox(-48.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(23, 221).mirror().addBox(40.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -69.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(23, 221).mirror().addBox(-48.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(23, 221).mirror().addBox(40.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -69.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 198).mirror().addBox(-44.0F, -4.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 198).mirror().addBox(36.0F, -4.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -69.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(19.0F, -56.0F, 41.0F));
      bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(216, 218).mirror().addBox(40.6764F, -12.0F, -18.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).mirror(false).texOffs(216, 218).addBox(-46.6764F, -12.0F, 4.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)), PartPose.offsetAndRotation(-19.0F, 0.0F, -41.0F, -3.1416F, -0.1745F, 3.1416F));
      bone2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(216, 218).addBox(-46.6764F, -12.0F, -18.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).texOffs(216, 218).mirror().addBox(40.6764F, -12.0F, 4.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).mirror(false), PartPose.offsetAndRotation(-19.0F, 0.0F, -41.0F, 0.0F, -0.1745F, 0.0F));
      bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(216, 218).mirror().addBox(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -82.0F, 0.0F, 1.3963F, 0.0F));
      bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(216, 218).addBox(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)), PartPose.offsetAndRotation(-38.0F, 0.0F, -82.0F, 0.0F, -1.3963F, 0.0F));
      bone2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(216, 218).mirror().addBox(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.3963F, 0.0F));
      bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(216, 218).addBox(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)), PartPose.offsetAndRotation(-38.0F, 0.0F, 0.0F, 0.0F, 1.3963F, 0.0F));
      return LayerDefinition.create(meshdefinition, 256, 256);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
