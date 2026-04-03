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

public class Modelcursedspirit3_7<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_7"), "main");
   public final ModelPart Body;

   public Modelcursedspirit3_7(ModelPart root) {
      this.Body = root.getChild("Body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r28_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-2.5F, -2.5F, -3.5F, 5.0F, 5.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 20.7884F, -0.3244F, -0.4014F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r27_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.3F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 21.9033F, 2.768F, -0.2571F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r26_r1", CubeListBuilder.create().texOffs(0, 13).addBox(0.9466F, -2.7414F, -5.8865F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-3.4466F, 22.8987F, 9.4732F, -0.0236F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r25_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-0.519F, -2.7416F, -3.4463F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.981F, 22.8987F, 9.4732F, -0.0261F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r24_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0071F, -2.7437F, -1.2776F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.4929F, 22.8987F, 9.4732F, -0.0418F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r23_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-0.2262F, -2.7437F, 0.0028F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-2.2738F, 22.8987F, 9.4732F, -0.0958F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r22_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.8927F, -5.9761F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.0F, 22.9843F, 17.9342F, -0.1531F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r23_r2", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.8049F, 0.9596F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 22.9843F, 17.9342F, 0.2182F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r22_r2", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.7464F, -3.4345F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.0F, 22.9843F, 17.9342F, -3.0829F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r21_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.8F, -1.7221F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 22.9843F, 17.9342F, 3.113F, 0.0F, 0.0F));
      PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0059F, 20.2808F, -1.9274F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(18, 0).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0059F, -2.6783F, -2.6987F, -2.2602F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(18, 4).addBox(-2.5F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0059F, -3.7585F, -3.5892F, -2.2602F, 0.0F, -3.1416F));
      head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(15, 13).addBox(-3.2071F, -3.0311F, -0.5639F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.2071F, -1.4311F, -1.5639F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.2929F, 1.1689F, -2.5639F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.7071F, 1.1689F, -2.5639F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7012F, -2.0932F, -5.9465F, -0.1309F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(0, 29).addBox(-1.7071F, 1.3908F, -2.9881F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.7012F, -2.0932F, -5.9465F, 0.0873F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.0059F, -0.6428F, -7.7149F, 0.3927F, 0.0F, -3.1416F));
      head.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(16, 24).mirror().addBox(-4.204F, -2.3047F, -3.2639F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)).mirror(false), PartPose.offsetAndRotation(0.7012F, -2.0932F, -5.9465F, -0.0571F, 0.0F, -0.1887F));
      head.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(16, 24).addBox(-1.1495F, -2.0536F, -3.2639F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.7012F, -2.0932F, -5.9465F, -0.1995F, 0.0F, 0.1853F));
      head.addOrReplaceChild("head_r8", CubeListBuilder.create().texOffs(18, 4).addBox(-3.2071F, -2.0844F, 1.2717F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 4).addBox(-3.2071F, -2.0844F, 0.3717F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7012F, -2.0932F, -5.9465F, 0.8814F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
