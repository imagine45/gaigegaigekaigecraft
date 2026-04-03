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

public class Modelfoot<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelfoot"), "main");
   public final ModelPart head;

   public Modelfoot(ModelPart root) {
      this.head = root.getChild("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -23.0F, 0.0F, -0.0873F, 0.0F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(231, 193).addBox(-14.6F, -31.4F, 20.0F, 31.0F, 29.0F, 20.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.5F, 33.1588F, 10.3005F, 0.1745F, 0.0F, 0.0F));
      PartDefinition bone5 = head.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(53, 311).addBox(-16.7F, -21.5009F, 11.4793F, 32.0F, 14.0F, 36.0F, new CubeDeformation(-0.7F)), PartPose.offset(-0.4F, 31.4009F, -16.4793F));
      bone5.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(246, 150).addBox(-18.0F, -6.1F, -5.0F, 36.0F, 8.0F, 20.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.4F, -7.4009F, -12.1663F, -0.0873F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(92, 254).addBox(-19.2F, -9.1F, -25.1F, 11.0F, 11.0F, 34.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.4F, -7.4009F, 16.4793F, 0.0886F, 0.1739F, 0.0154F));
      bone5.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(0, 224).addBox(-18.0F, -6.1F, -15.0F, 33.0F, 8.0F, 30.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.4F, -7.4009F, 16.4793F, 0.0873F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(0, 139).addBox(-6.3F, -15.1F, -15.0F, 23.0F, 12.0F, 47.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.4F, -7.4009F, 16.4793F, 0.0876F, -0.0869F, -0.0076F));
      PartDefinition bone8 = bone5.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(10.7906F, -13.7718F, -11.3238F));
      bone8.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(118, 79).addBox(-18.0F, -4.1F, -1.0F, 7.0F, 8.0F, 14.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-12.1416F, 5.4044F, 2.9465F, -0.1886F, -0.3864F, 0.0718F));
      PartDefinition bone14 = bone8.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(-10.2906F, 5.3985F, 10.3242F));
      bone14.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(0, 198).addBox(-18.1F, -3.1F, -7.0F, 36.0F, 7.0F, 16.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
      bone14.addOrReplaceChild("head_r8", CubeListBuilder.create().texOffs(275, 337).addBox(-15.0F, -3.9F, -9.0F, 27.0F, 8.0F, 11.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-0.1F, -0.1926F, -10.5733F, -0.1309F, 0.0F, 0.0F));
      bone14.addOrReplaceChild("head_r9", CubeListBuilder.create().texOffs(218, 49).addBox(-18.0F, -4.1F, -5.0F, 36.0F, 8.0F, 11.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.1F, -0.1926F, -10.5733F, -0.1745F, 0.0F, 0.0F));
      PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(109, 193).addBox(-2.6F, -40.4F, 47.0F, 30.0F, 30.0F, 31.0F, new CubeDeformation(-0.1F)).texOffs(109, 193).addBox(-2.6F, -53.4F, 47.0F, 30.0F, 30.0F, 31.0F, new CubeDeformation(-0.2F)), PartPose.offset(-13.0F, 24.0F, -29.0F));
      bone.addOrReplaceChild("head_r10", CubeListBuilder.create().texOffs(228, 79).addBox(-17.0F, -24.9F, 31.8F, 33.0F, 13.0F, 26.0F, new CubeDeformation(-2.4F)), PartPose.offsetAndRotation(12.9F, 19.1085F, 36.3935F, 1.0036F, 0.0F, 0.0F));
      bone.addOrReplaceChild("head_r11", CubeListBuilder.create().texOffs(140, 150).addBox(-18.0F, -39.9F, -1.2F, 36.0F, 9.0F, 34.0F, new CubeDeformation(-2.4F)), PartPose.offsetAndRotation(12.9F, 19.1085F, 36.3935F, 0.5236F, 0.0F, 0.0F));
      bone.addOrReplaceChild("head_r12", CubeListBuilder.create().texOffs(0, 68).addBox(-12.9F, -37.9F, -29.2F, 29.0F, 11.0F, 60.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(12.9F, 19.1085F, 36.3935F, 0.3065F, -0.0832F, -0.0263F));
      bone.addOrReplaceChild("head_r13", CubeListBuilder.create().texOffs(119, 80).addBox(-18.5F, -37.9F, -28.2F, 25.0F, 11.0F, 59.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(12.9F, 19.1085F, 36.3935F, 0.3065F, 0.0832F, 0.0263F));
      bone.addOrReplaceChild("head_r14", CubeListBuilder.create().texOffs(207, 242).addBox(-15.9F, -31.4F, 16.0F, 30.0F, 17.0F, 24.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(13.0F, 19.8136F, 49.4118F, 1.0036F, 0.0F, 0.0F));
      bone.addOrReplaceChild("head_r15", CubeListBuilder.create().texOffs(218, 0).addBox(-16.5F, -19.4F, 16.0F, 31.0F, 19.0F, 30.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(13.2F, 0.0216F, 13.3368F, -0.0873F, 0.0F, 0.0F));
      PartDefinition bone9 = bone.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, 8.2232F, 36.9687F, 0.0F, -0.0873F, 0.0F));
      bone9.addOrReplaceChild("head_r16", CubeListBuilder.create().texOffs(0, 262).addBox(-12.6F, -28.8F, 20.0F, 22.0F, 30.0F, 20.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0709F, -14.0559F, 6.0038F, 0.1579F, 0.0953F, 0.009F));
      bone9.addOrReplaceChild("head_r17", CubeListBuilder.create().texOffs(162, 283).addBox(-15.6F, -20.8F, 20.0F, 25.0F, 14.0F, 20.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.2676F, 0.6073F, 5.3324F, -0.0166F, 0.0953F, 0.009F));
      PartDefinition bone12 = bone.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(10.7754F, 35.181F, -11.5819F));
      bone12.addOrReplaceChild("head_r18", CubeListBuilder.create().texOffs(126, 8).addBox(-19.01F, -37.9F, -29.2F, 16.0F, 11.0F, 60.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(2.1246F, -16.0725F, 50.9754F, 0.3099F, 0.1664F, 0.053F));
      PartDefinition bone13 = bone12.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offsetAndRotation(9.3026F, -3.0653F, 9.7218F, -0.2182F, 0.0F, 0.0F));
      bone13.addOrReplaceChild("head_r19", CubeListBuilder.create().texOffs(0, 31).addBox(-6.4379F, -3.3811F, -2.5726F, 16.0F, 7.0F, 13.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-23.0F, -33.233F, -7.0842F, 0.3099F, -0.1664F, -0.053F));
      PartDefinition bone7 = head.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3F, 24.0F, -3.2F, 0.0873F, 0.0F, 0.0F));
      PartDefinition bone3 = bone7.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(125, 0).addBox(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(118, 101).addBox(-2.0F, -9.0F, -8.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.3F)), PartPose.offset(-8.5F, 0.0F, -30.1F));
      bone3.addOrReplaceChild("head_r20", CubeListBuilder.create().texOffs(252, 283).addBox(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone2 = bone7.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(125, 0).addBox(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(118, 101).addBox(-2.0F, -9.0F, -8.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.3F)), PartPose.offset(-0.2F, 0.0F, -27.1F));
      bone2.addOrReplaceChild("head_r21", CubeListBuilder.create().texOffs(252, 283).addBox(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone4 = bone7.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(125, 0).addBox(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.2F)).texOffs(118, 101).addBox(-2.0F, -9.0F, -8.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.5F)), PartPose.offset(7.8F, 0.0F, -25.6F));
      bone4.addOrReplaceChild("head_r22", CubeListBuilder.create().texOffs(252, 283).addBox(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone6 = bone7.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(125, 0).addBox(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.8F)).texOffs(118, 101).addBox(-2.0F, -9.0F, -9.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(14.9F, 0.0F, -21.8F, 0.0F, -0.0436F, 0.0F));
      bone6.addOrReplaceChild("head_r23", CubeListBuilder.create().texOffs(252, 283).addBox(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone11 = bone7.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(1, 91).addBox(-18.0F, -9.0F, -45.0F, 12.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 68).addBox(-18.0F, -9.0F, -41.0F, 12.0F, 8.0F, 14.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-3.1F, 0.0F, -1.8F, 0.0F, 0.0436F, 0.0F));
      bone11.addOrReplaceChild("head_r24", CubeListBuilder.create().texOffs(93, 150).addBox(-17.0F, -14.4F, -41.0F, 9.0F, 5.0F, 26.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone10 = head.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(13.0F, 24.0F, -29.0F));
      return LayerDefinition.create(meshdefinition, 368, 368);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
