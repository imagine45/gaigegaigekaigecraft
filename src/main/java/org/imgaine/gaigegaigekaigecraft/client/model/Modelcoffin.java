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

public class Modelcoffin<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcoffin"), "main");
   public final ModelPart bb_main;

   public Modelcoffin(ModelPart root) {
      this.bb_main = root.getChild("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-10.2F, -20.1F, -8.2F, 1.0F, 48.0F, 16.0F, new CubeDeformation(-0.05F)).texOffs(0, 0).addBox(-10.2F, -20.1F, -8.7F, 20.0F, 1.0F, 17.0F, new CubeDeformation(0.1F)).texOffs(0, 0).addBox(-10.2F, 26.9F, -8.7F, 20.0F, 1.0F, 17.0F, new CubeDeformation(0.1F)).texOffs(0, 0).addBox(8.8F, -20.1F, -8.2F, 1.0F, 48.0F, 16.0F, new CubeDeformation(-0.05F)).texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2F, -3.9F, 0.2F));
      bb_main.addOrReplaceChild("bb_main_r1", CubeListBuilder.create().texOffs(0, 0).addBox(7.5F, -24.0F, -12.0F, 1.0F, 48.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.5F, -24.0F, -12.0F, 1.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.5F, -7.0F, -12.0F, 1.0F, 31.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, 3.9F, -0.2F, 0.0F, -1.5708F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(7.5F, -20.0F, -10.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(7.5F, -19.0F, -8.5F, 1.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(76, 76).mirror().addBox(8.0F, -17.8F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(76, 76).mirror().addBox(8.0F, -10.9F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(71, 75).mirror().addBox(8.5F, -15.7F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(71, 78).mirror().addBox(8.0F, -12.5F, -3.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(60, 28).mirror().addBox(7.0F, -20.0F, -9.5F, 1.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3F, 3.9F, -0.2F, 0.0F, 1.5708F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r3", CubeListBuilder.create().texOffs(71, 78).addBox(-9.0F, -12.5F, -3.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(71, 75).addBox(-9.5F, -15.7F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(76, 76).addBox(-9.0F, -17.8F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(76, 76).addBox(-9.0F, -10.9F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(60, 28).addBox(-8.0F, -20.0F, -9.5F, 1.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.5F, -19.0F, -8.5F, 1.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.5F, -20.0F, -10.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 3.9F, -0.2F, 0.0F, -1.5708F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r4", CubeListBuilder.create().texOffs(69, 77).addBox(-9.5F, -15.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.2F, 4.2F, -0.2F, 0.0F, -1.5708F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r5", CubeListBuilder.create().texOffs(69, 77).mirror().addBox(8.5F, -15.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.8F, 4.2F, -0.2F, 0.0F, 1.5708F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r6", CubeListBuilder.create().texOffs(76, 78).mirror().addBox(8.0F, -16.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3F, 3.9F, -0.3F, 0.0F, 1.5708F, 0.0F));
      bb_main.addOrReplaceChild("bb_main_r7", CubeListBuilder.create().texOffs(76, 78).addBox(-9.0F, -16.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 3.9F, -0.3F, 0.0F, -1.5708F, 0.0F));
      return LayerDefinition.create(meshdefinition, 80, 80);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
