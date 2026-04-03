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

public class ModelMahitoHand3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_mahito_hand_3"), "main");
   public final ModelPart hand_main;

   public ModelMahitoHand3(ModelPart root) {
      this.hand_main = root.getChild("hand_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition hand_main = partdefinition.addOrReplaceChild("hand_main", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));
      PartDefinition hand = hand_main.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition bone2 = hand.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-24.0F, 18.0F, -49.0F));
      bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 4).addBox(28.0F, -7.0F, -7.0F, 8.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(20, 2).addBox(18.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(30, 10).addBox(-36.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(26, 6).addBox(-28.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(20, 2).addBox(-20.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.0F, -9.0F, -9.0F, 28.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -16.0F, 8.0F, 0.0F, 1.5708F, 0.0F));
      PartDefinition bone3 = hand.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(4.4F, 7.1F, -41.0F));
      bone3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(10.5865F, 11.3787F, 15.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, 12.3355F, 5.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, 0.2645F, 7.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, 2.3355F, -4.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.6978F, -8.6213F, -4.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, -2.3562F, 0.7854F, -1.5708F));
      bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(10.5865F, -15.3787F, -19.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, -4.2645F, -11.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, -16.3355F, -9.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, -6.3355F, 0.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.6978F, 4.6213F, 0.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, 0.7854F, 0.7854F, 1.5708F));
      bone3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(10.5865F, 12.1565F, 14.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, 1.0423F, 6.5577F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, 13.1134F, 4.4866F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, 3.1134F, -5.5134F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.6978F, -7.8435F, -5.1565F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, -2.3562F, 0.7854F, -3.1416F));
      bone3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-17.6978F, 4.5506F, 0.4494F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(10.5865F, -15.4494F, -19.5506F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, -16.4062F, -9.1938F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, -6.4062F, 0.8062F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, -4.3352F, -11.2648F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, 0.7854F, 0.7854F, 0.0F));
      PartDefinition hand2 = hand_main.addOrReplaceChild("hand2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition bone4 = hand2.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(-24.0F, 18.0F, 49.0F));
      bone4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 4).addBox(28.0F, -7.0F, -7.0F, 8.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(20, 2).addBox(18.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(30, 10).addBox(-36.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(26, 6).addBox(-28.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(20, 2).addBox(-20.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.0F, -9.0F, -9.0F, 28.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -16.0F, -8.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone5 = hand2.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(4.4F, 7.1F, 41.0F));
      bone5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(10.5865F, 11.3787F, -19.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, 12.3355F, -9.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, 0.2645F, -11.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, 2.3355F, 0.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.6978F, -8.6213F, 0.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, 2.3562F, -0.7854F, -1.5708F));
      bone5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(10.5865F, -15.3787F, 15.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, -4.2645F, 7.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, -16.3355F, 5.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, -6.3355F, -4.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.6978F, 4.6213F, -4.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, -0.7854F, -0.7854F, 1.5708F));
      bone5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(10.5865F, 12.1565F, -18.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, 1.0423F, -10.5577F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, 13.1134F, -8.4866F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, 3.1134F, 1.5134F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.6978F, -7.8435F, 1.1565F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, 2.3562F, -0.7854F, -3.1416F));
      bone5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-17.6978F, 4.5506F, -4.4494F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(10.5865F, -15.4494F, 15.5506F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.5255F, -16.4062F, 5.1938F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.6167F, -6.4062F, -4.8062F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.5456F, -4.3352F, 7.2648F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -5.1F, 0.0F, -0.7854F, -0.7854F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.hand_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.hand_main.yRot = ageInTicks;
   }
}
