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

public class Modelcursedspirit3_17<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_17"), "main");
   public final ModelPart body;

   public Modelcursedspirit3_17(ModelPart root) {
      this.body = root.getChild("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 20.3889F, -0.9444F));
      body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(3.067F, -6.8792F, 0.3229F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3889F, 0.4444F, 1.5456F, 0.523F, 3.0912F));
      body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 3).addBox(-5.067F, -6.8792F, 0.3229F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.3889F, 0.4444F, 1.5456F, -0.523F, -3.0912F));
      body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 2).addBox(-1.0F, -9.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 12).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).texOffs(2, 1).addBox(-1.5F, -5.0F, -0.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(2, 3).addBox(-1.5F, 2.5F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3889F, 0.4444F, 1.5708F, 0.0F, 3.1416F));
      body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-1.75F, 4.5F, 0.433F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3889F, 0.4444F, 1.5708F, 0.0F, -2.618F));
      body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-1.25F, 4.5F, 0.433F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3889F, 0.4444F, 1.5708F, 0.0F, 2.618F));
      return LayerDefinition.create(meshdefinition, 16, 16);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body.yRot = netHeadYaw / 57.295776F;
      this.body.xRot = headPitch / 57.295776F;
   }
}
