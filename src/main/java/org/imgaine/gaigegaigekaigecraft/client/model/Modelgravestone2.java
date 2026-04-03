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

public class Modelgravestone2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelgravestone_2"), "main");
   public final ModelPart bb_main;

   public Modelgravestone2(ModelPart root) {
      this.bb_main = root.getChild("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(3, 3).addBox(-5.5F, -2.0F, -5.5F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-6.0F, -15.0F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-6.0F, -23.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(4, 4).addBox(-4.0F, -26.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(8, 8).addBox(-2.0F, -29.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(2, 18).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-4.0F, -17.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(6, 22).addBox(2.0F, -20.0F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 22).mirror().addBox(-4.0F, -20.0F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(6, 22).mirror().addBox(-4.0F, -20.0F, -4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(6, 22).addBox(2.0F, -20.0F, -4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bb_main.yRot = netHeadYaw / 57.295776F;
      this.bb_main.xRot = headPitch / 57.295776F;
   }
}
