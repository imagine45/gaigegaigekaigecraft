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

public class Modeldagon_fish_mini<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modeldagon_fish_mini"), "main");
   public final ModelPart fish;

   public Modeldagon_fish_mini(ModelPart root) {
      this.fish = root.getChild("fish");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition fish = partdefinition.addOrReplaceChild("fish", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -0.5F));
      PartDefinition head = fish.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -3.4F, -2.1F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.02F)).texOffs(28, 0).addBox(0.2F, -3.0F, -2.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(28, 0).mirror().addBox(-1.2F, -3.0F, -2.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(0.0F, 2.5F, -3.7F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(16, 2).addBox(-2.0F, -1.4701F, -8.7881F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)).texOffs(0, 0).addBox(-1.0F, -0.9701F, -7.8881F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3557F, 3.9581F, -0.2618F, 0.0F, -3.1416F));
      head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.2677F, -6.78F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, -2.3557F, 3.9581F, 0.1745F, 0.0F, -3.1416F));
      head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 2.9079F, -4.9821F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -2.3557F, 3.9581F, -0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -4.4739F, -4.9914F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -2.3557F, 3.9581F, 0.5672F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(16, 2).addBox(-2.0F, 3.3333F, -6.9202F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.05F)).texOffs(0, 4).addBox(-1.0F, 2.8333F, -6.0202F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3557F, 3.9581F, -0.6109F, 0.0F, 0.0F));
      PartDefinition body = fish.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -10.6244F, -7.3692F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.05F)).texOffs(0, 21).addBox(-0.5F, -8.1544F, -1.0392F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).texOffs(24, 13).addBox(0.0F, -10.1544F, 1.5608F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)).texOffs(0, 21).addBox(-1.0F, -10.1544F, -7.2392F, 2.0F, 6.0F, 5.0F, new CubeDeformation(-0.04F)), PartPose.offset(0.0F, 8.0F, 3.5F));
      body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(24, 13).mirror().addBox(2.3574F, -2.2987F, -3.5102F, 0.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.8557F, -3.2419F, 0.0F, 0.3927F, 0.0F));
      body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(24, 13).addBox(-2.3574F, -2.2987F, -3.5102F, 0.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -7.8557F, -3.2419F, 0.0F, -0.3927F, 0.0F));
      body.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(26, 24).addBox(0.0F, 3.4336F, -1.0841F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.08F)).texOffs(0, 21).addBox(-1.0F, -0.2792F, -1.0701F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.07F)), PartPose.offsetAndRotation(0.0F, -7.8557F, -3.2419F, 0.5236F, 0.0F, 0.0F));
      body.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -2.8231F, -0.702F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.06F)), PartPose.offsetAndRotation(0.0F, -7.8557F, -3.2419F, -0.5236F, 0.0F, 0.0F));
      PartDefinition bone = fish.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 23).addBox(-1.0F, -1.9F, -1.9F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.89F)), PartPose.offset(0.0F, -3.1544F, -1.5692F));
      bone.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(18, 23).addBox(-1.0F, -4.3205F, -2.5015F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.86F)), PartPose.offsetAndRotation(0.0F, 3.2987F, 1.8273F, -0.8727F, 0.0F, 0.0F));
      bone.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(18, 23).addBox(-1.0F, -5.7138F, -4.7614F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.0F, 3.2987F, 1.8273F, 0.3491F, 0.0F, 0.0F));
      bone.addOrReplaceChild("body_r7", CubeListBuilder.create().texOffs(18, 23).addBox(-1.0F, -4.5333F, -3.1809F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.88F)), PartPose.offsetAndRotation(0.0F, 3.2987F, 1.8273F, -0.5236F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.fish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.fish.yRot = netHeadYaw / 57.295776F;
      this.fish.xRot = headPitch / 57.295776F;
   }
}
