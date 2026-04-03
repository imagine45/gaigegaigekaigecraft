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

public class Modelwooden_spear1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelwooden_spear_1"), "main");
   public final ModelPart body;

   public Modelwooden_spear1(ModelPart root) {
      this.body = root.getChild("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));
      PartDefinition body1 = body.addOrReplaceChild("body1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7804F, -0.748F, -53.6914F, 1.5708F, 0.0F, 0.0F));
      body1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1899F, 0.0F, -2.1884F, -2.8798F, -0.7854F, 3.1416F));
      body1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1899F, 0.0F, 0.6924F, 2.8798F, 0.7854F, 3.1416F));
      body1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2477F, 0.0F, -0.7645F, 0.2618F, 1.5708F, 0.0F));
      body1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9954F, 0.0F, -2.6249F, -2.8798F, 0.3927F, 3.1416F));
      body1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9954F, 0.0F, 1.1289F, 2.8798F, -0.3927F, 3.1416F));
      body1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.766F, 0.0F, -2.7782F, -2.8798F, 0.0F, 3.1416F));
      body1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.766F, 0.0F, 1.2822F, 2.8798F, 0.0F, 3.1416F));
      body1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5366F, 0.0F, -2.6249F, -2.8798F, -0.3927F, 3.1416F));
      body1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5366F, 0.0F, 1.1289F, 2.8798F, 0.3927F, 3.1416F));
      body1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7796F, 0.0F, -0.7645F, 0.2618F, -1.5708F, 0.0F));
      body1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(2, 11).addBox(0.2315F, -8.0F, -0.2523F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.496F, -2.8798F, 0.7854F, 3.1416F));
      body1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(2, 11).addBox(0.2315F, -8.0F, -0.7477F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8798F, -0.7854F, 3.1416F));
      body1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6264F, 0.0F, -1.5351F, -2.8798F, -1.1781F, 3.1416F));
      body1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6264F, 0.0F, 0.0391F, 2.8798F, 1.1781F, 3.1416F));
      body1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.3978F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.496F, -2.8798F, 1.1781F, 3.1416F));
      body1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(2, 11).addBox(-0.5F, -8.0F, -0.6022F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8798F, -1.1781F, 3.1416F));
      PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 1.5708F, 0.0F, 0.0F));
      body2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.8265F, -4.0F, 7.7582F, 0.2618F, -0.7854F, 0.0F));
      body2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.8265F, -4.0F, 7.7582F, 0.2618F, 0.7854F, 0.0F));
      body2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(1.5207F, -39.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.7069F, -4.0F, -3.9524F, -0.2618F, 0.7854F, 0.0F));
      body2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.5207F, -39.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.7069F, -4.0F, -3.9524F, -0.2618F, -0.7854F, 0.0F));
      body2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0683F, -4.0F, 0.0683F, -0.2618F, 1.5708F, 0.0F));
      body2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0683F, -4.0F, 0.0683F, -0.2618F, -1.5708F, 0.0F));
      body2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2357F, -4.0F, 10.1575F, 0.2618F, -0.3927F, 0.0F));
      body2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2357F, -4.0F, 10.1575F, 0.2618F, 0.3927F, 0.0F));
      body2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2357F, -4.0F, -10.1575F, -0.2618F, 0.3927F, 0.0F));
      body2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2357F, -4.0F, -10.1575F, -0.2618F, -0.3927F, 0.0F));
      body2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.2258F, -4.0F, 4.1673F, 0.2618F, -1.1781F, 0.0F));
      body2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2258F, -4.0F, 4.1673F, 0.2618F, 1.1781F, 0.0F));
      body2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.7069F, -4.0F, -3.9524F, -0.2618F, 1.1781F, 0.0F));
      body2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -39.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7069F, -4.0F, -3.9524F, -0.2618F, -1.1781F, 0.0F));
      body2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 11.0F, 0.2618F, 0.0F, 0.0F));
      body2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -11.0F, -0.2618F, 0.0F, 0.0F));
      PartDefinition body3 = body.addOrReplaceChild("body3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 1.5708F, 0.0F, -0.2182F));
      body3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.8265F, 4.0F, 7.7582F, -0.2618F, -0.7854F, 0.0F));
      body3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.8265F, 4.0F, 7.7582F, -0.2618F, 0.7854F, 0.0F));
      body3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).addBox(1.5207F, -14.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.7069F, 4.0F, -3.9524F, 0.2618F, 0.7854F, 0.0F));
      body3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.5207F, -14.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.7069F, 4.0F, -3.9524F, 0.2618F, -0.7854F, 0.0F));
      body3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0683F, 4.0F, 0.0683F, 0.2618F, 1.5708F, 0.0F));
      body3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0683F, 4.0F, 0.0683F, 0.2618F, -1.5708F, 0.0F));
      body3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2357F, 4.0F, 10.1575F, -0.2618F, -0.3927F, 0.0F));
      body3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2357F, 4.0F, 10.1575F, -0.2618F, 0.3927F, 0.0F));
      body3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2357F, 4.0F, -10.1575F, 0.2618F, 0.3927F, 0.0F));
      body3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2357F, 4.0F, -10.1575F, 0.2618F, -0.3927F, 0.0F));
      body3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.2258F, 4.0F, 4.1673F, -0.2618F, -1.1781F, 0.0F));
      body3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2258F, 4.0F, 4.1673F, -0.2618F, 1.1781F, 0.0F));
      body3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.7069F, 4.0F, -3.9524F, 0.2618F, 1.1781F, 0.0F));
      body3.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -14.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7069F, 4.0F, -3.9524F, 0.2618F, -1.1781F, 0.0F));
      body3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 11.0F, -0.2618F, 0.0F, 0.0F));
      body3.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -11.0F, 0.2618F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body.yRot = netHeadYaw / 57.295776F;
      this.body.xRot = headPitch / 57.295776F;
   }
}
