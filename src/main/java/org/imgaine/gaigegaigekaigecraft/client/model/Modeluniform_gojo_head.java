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

public class Modeluniform_gojo_head<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modeluniform_gojo_head"), "main");
   public final ModelPart Head;

   public Modeluniform_gojo_head(ModelPart root) {
      this.Head = root.getChild("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 9).addBox(-4.0F, -3.8F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.1F)).texOffs(0, 9).mirror().addBox(4.0F, -3.8F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(0, 19).addBox(-4.0F, -3.8F, 4.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(0, 17).addBox(-4.0F, -3.8F, -4.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(12, 19).mirror().addBox(-4.0F, 1.2F, -4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.5777F, -2.2324F, 0.0F, 0.0F, 0.0F, 0.6109F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(3, 17).mirror().addBox(-1.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(1.8455F, -3.3131F, -4.01F, 0.0F, 0.0F, -0.0873F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.5112F, -2.4134F, -3.51F, 0.0F, 0.0F, -0.3927F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5112F, -2.4134F, -3.49F, 0.0F, 0.0F, 0.3927F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(12, 19).addBox(2.0F, 1.2F, -4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.5777F, -2.2324F, 0.02F, 0.0F, 0.0F, -0.6109F));
      return LayerDefinition.create(meshdefinition, 32, 20);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
