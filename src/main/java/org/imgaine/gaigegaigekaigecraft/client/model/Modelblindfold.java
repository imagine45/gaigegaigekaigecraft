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

public class Modelblindfold<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelblindfold"), "main");
   public final ModelPart Head;
   public final ModelPart Head_r1;
   public final ModelPart Head_r2;

   public Modelblindfold(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Head_r1 = this.Head.getChild("Head_r1");
      this.Head_r2 = this.Head.getChild("Head_r2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.4F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 6).addBox(-4.0F, -3.6F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.1F)).texOffs(0, 6).addBox(4.0F, -3.6F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.1F)).texOffs(0, 14).addBox(-4.0F, -3.6F, 4.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(0, 14).addBox(-4.0F, -3.6F, -4.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.4F, 0.0F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.09F)), PartPose.offsetAndRotation(1.9201F, -1.913F, -4.0F, 0.0F, 0.0F, -0.1309F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.09F)), PartPose.offsetAndRotation(-1.9201F, -1.913F, -4.0F, 0.0F, 0.0F, 0.1309F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
