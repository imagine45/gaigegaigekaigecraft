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

public class Modelball<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelball"), "main");
   public final ModelPart ball;

   public Modelball(ModelPart root) {
      this.ball = root.getChild("ball");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition ball = partdefinition.addOrReplaceChild("ball", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      ball.addOrReplaceChild("ball_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3655F, 0.147F, 1.2053F));
      ball.addOrReplaceChild("ball_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8567F, 0.274F, -0.8249F));
      ball.addOrReplaceChild("ball_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1572F, 0.3614F, 0.4215F));
      ball.addOrReplaceChild("ball_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1572F, -0.3614F, 2.7201F));
      ball.addOrReplaceChild("ball_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3655F, -0.147F, 1.9363F));
      ball.addOrReplaceChild("ball_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8567F, -0.274F, -2.3166F));
      ball.addOrReplaceChild("ball_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7459F, 0.274F, 1.2859F));
      ball.addOrReplaceChild("ball_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.5261F, 0.5236F, -0.9553F));
      ball.addOrReplaceChild("ball_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3655F, 0.7119F, 0.5299F));
      ball.addOrReplaceChild("ball_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3655F, -0.7119F, 2.6117F));
      ball.addOrReplaceChild("ball_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7459F, -0.274F, 1.8557F));
      ball.addOrReplaceChild("ball_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.5261F, -0.5236F, -2.1863F));
      ball.addOrReplaceChild("ball_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1781F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1493F, 0.3614F, 1.4136F));
      ball.addOrReplaceChild("ball_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.1007F, 0.7119F, -1.2053F));
      ball.addOrReplaceChild("ball_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7459F, 1.0228F, 0.8249F));
      ball.addOrReplaceChild("ball_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7459F, -1.0228F, 2.3166F));
      ball.addOrReplaceChild("ball_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1493F, -0.3614F, 1.728F));
      ball.addOrReplaceChild("ball_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.1007F, -0.7119F, -1.9363F));
      ball.addOrReplaceChild("ball_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.3927F, 1.5708F));
      ball.addOrReplaceChild("ball_r24", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.7854F, -1.5708F));
      ball.addOrReplaceChild("ball_r25", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 1.1781F, 1.5708F));
      ball.addOrReplaceChild("ball_r26", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.1781F, 1.5708F));
      ball.addOrReplaceChild("ball_r27", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.3927F, 1.5708F));
      ball.addOrReplaceChild("ball_r28", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.7854F, -1.5708F));
      ball.addOrReplaceChild("ball_r29", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9635F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r30", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9923F, 0.3614F, 1.728F));
      ball.addOrReplaceChild("ball_r31", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0409F, 0.7119F, -1.9363F));
      ball.addOrReplaceChild("ball_r32", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3957F, 1.0228F, 2.3166F));
      ball.addOrReplaceChild("ball_r33", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3957F, -1.0228F, 0.8249F));
      ball.addOrReplaceChild("ball_r34", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9923F, -0.3614F, 1.4136F));
      ball.addOrReplaceChild("ball_r35", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0409F, -0.7119F, -1.2053F));
      ball.addOrReplaceChild("ball_r36", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r37", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3957F, 0.274F, 1.8557F));
      ball.addOrReplaceChild("ball_r38", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6155F, 0.5236F, -2.1863F));
      ball.addOrReplaceChild("ball_r39", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7761F, 0.7119F, 2.6117F));
      ball.addOrReplaceChild("ball_r40", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7761F, -0.7119F, 0.5299F));
      ball.addOrReplaceChild("ball_r41", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3957F, -0.274F, 1.2859F));
      ball.addOrReplaceChild("ball_r42", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6155F, -0.5236F, -0.9553F));
      ball.addOrReplaceChild("ball_r43", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));
      ball.addOrReplaceChild("ball_r44", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r45", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7761F, 0.147F, 1.9363F));
      ball.addOrReplaceChild("ball_r46", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2849F, 0.274F, -2.3166F));
      ball.addOrReplaceChild("ball_r47", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.9844F, 0.3614F, 2.7201F));
      ball.addOrReplaceChild("ball_r48", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.9844F, -0.3614F, 0.4215F));
      ball.addOrReplaceChild("ball_r49", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7761F, -0.147F, 1.2053F));
      ball.addOrReplaceChild("ball_r50", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2849F, -0.274F, -0.8249F));
      ball.addOrReplaceChild("ball_r51", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5137F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0137F, 0.0F, 0.0F, 3.1416F, 0.0F, 1.5708F));
      ball.addOrReplaceChild("ball_r52", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 1.9635F));
      ball.addOrReplaceChild("ball_r53", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));
      ball.addOrReplaceChild("ball_r54", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 2.7489F));
      ball.addOrReplaceChild("ball_r55", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.3927F));
      ball.addOrReplaceChild("ball_r56", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 1.1781F));
      ball.addOrReplaceChild("ball_r57", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
      return LayerDefinition.create(meshdefinition, 6, 6);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.ball.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.ball.yRot = netHeadYaw / 57.295776F;
      this.ball.xRot = headPitch / 57.295776F;
   }
}
