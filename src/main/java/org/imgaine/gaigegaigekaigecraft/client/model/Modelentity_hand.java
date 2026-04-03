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

public class Modelentity_hand<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelentity_hand"), "main");
   public final ModelPart hand;

   public Modelentity_hand(ModelPart root) {
      this.hand = root.getChild("hand");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition hand = partdefinition.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      hand.addOrReplaceChild("hand_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.4046F, -27.3425F, 3.916F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 2.0508F, -1.309F, -1.5708F));
      hand.addOrReplaceChild("hand_r2", CubeListBuilder.create().texOffs(0, 0).addBox(4.0146F, -31.8742F, 1.1871F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 1.8326F, -1.309F, -1.5708F));
      hand.addOrReplaceChild("hand_r3", CubeListBuilder.create().texOffs(0, 0).addBox(4.0146F, -32.6106F, -0.01F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 1.7017F, -1.309F, -1.5708F));
      hand.addOrReplaceChild("hand_r4", CubeListBuilder.create().texOffs(0, 0).addBox(4.0146F, -32.6324F, -2.4694F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 1.5272F, -1.309F, -1.5708F));
      hand.addOrReplaceChild("hand_r5", CubeListBuilder.create().texOffs(0, 0).addBox(4.0146F, -31.1641F, -5.8904F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 1.309F, -1.309F, -1.5708F));
      hand.addOrReplaceChild("hand_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-2.9122F, -23.9435F, -4.676F, 8.0F, 24.0F, 10.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 1.5708F, -1.5272F, -1.5708F));
      hand.addOrReplaceChild("hand_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5555F, -23.2784F, -4.676F, 8.0F, 24.0F, 10.0F, new CubeDeformation(-2.01F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, -1.5708F, -1.4835F, 1.5708F));
      hand.addOrReplaceChild("hand_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-3.8631F, -28.1235F, -5.276F, 8.0F, 10.0F, 11.0F, new CubeDeformation(-2.0F)).texOffs(0, 0).addBox(-5.2631F, 15.6765F, -4.676F, 10.0F, 24.0F, 10.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.4631F, -20.3765F, -0.324F, 0.0F, -1.5708F, 0.0F));
      hand.addOrReplaceChild("hand_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.139F, -12.5F, -0.5871F, 0.0F, -1.5708F, 3.1416F));
      return LayerDefinition.create(meshdefinition, 40, 40);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
