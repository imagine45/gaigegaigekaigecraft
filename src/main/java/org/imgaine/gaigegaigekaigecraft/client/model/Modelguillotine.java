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

public class Modelguillotine<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelguillotine"), "main");
   public final ModelPart bone;

   public Modelguillotine(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(48, 0).addBox(-18.0F, -107.0F, -2.0F, 36.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 96).addBox(-17.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(32, 96).addBox(-5.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(32, 96).addBox(-5.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(32, 96).addBox(-17.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(32, 96).mirror().addBox(4.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 96).mirror().addBox(16.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 96).mirror().addBox(16.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 96).mirror().addBox(4.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 96).addBox(-1.5F, -112.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-0.5F, -176.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(18.0F, -48.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(18.0F, 16.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-30.0F, 16.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(18.0F, -112.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-30.0F, -112.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(18.0F, -176.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-30.0F, -176.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-30.0F, -48.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -32.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -183.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(34, 97).addBox(-18.0F, 4.0F, -0.5F, 46.0F, 6.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0F, -80.5F, -0.5F, 0.0F, 0.0F, 0.5236F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 104).addBox(-18.0F, -13.0F, -0.5F, 45.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -86.5F, -0.5F, 0.0F, 0.0F, 0.5236F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
