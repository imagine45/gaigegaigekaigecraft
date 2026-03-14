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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelfoot"), "main");
   public final ModelPart head;

   public Modelfoot(ModelPart root) {
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, -23.0F, 0.0F, -0.0873F, 0.0F));
      head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(231, 193).m_171488_(-14.6F, -31.4F, 20.0F, 31.0F, 29.0F, 20.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-2.5F, 33.1588F, 10.3005F, 0.1745F, 0.0F, 0.0F));
      PartDefinition bone5 = head.m_171599_("bone5", CubeListBuilder.m_171558_().m_171514_(53, 311).m_171488_(-16.7F, -21.5009F, 11.4793F, 32.0F, 14.0F, 36.0F, new CubeDeformation(-0.7F)), PartPose.m_171419_(-0.4F, 31.4009F, -16.4793F));
      bone5.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(246, 150).m_171488_(-18.0F, -6.1F, -5.0F, 36.0F, 8.0F, 20.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(0.4F, -7.4009F, -12.1663F, -0.0873F, 0.0F, 0.0F));
      bone5.m_171599_("head_r3", CubeListBuilder.m_171558_().m_171514_(92, 254).m_171488_(-19.2F, -9.1F, -25.1F, 11.0F, 11.0F, 34.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(0.4F, -7.4009F, 16.4793F, 0.0886F, 0.1739F, 0.0154F));
      bone5.m_171599_("head_r4", CubeListBuilder.m_171558_().m_171514_(0, 224).m_171488_(-18.0F, -6.1F, -15.0F, 33.0F, 8.0F, 30.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(0.4F, -7.4009F, 16.4793F, 0.0873F, 0.0F, 0.0F));
      bone5.m_171599_("head_r5", CubeListBuilder.m_171558_().m_171514_(0, 139).m_171488_(-6.3F, -15.1F, -15.0F, 23.0F, 12.0F, 47.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.4F, -7.4009F, 16.4793F, 0.0876F, -0.0869F, -0.0076F));
      PartDefinition bone8 = bone5.m_171599_("bone8", CubeListBuilder.m_171558_(), PartPose.m_171419_(10.7906F, -13.7718F, -11.3238F));
      bone8.m_171599_("head_r6", CubeListBuilder.m_171558_().m_171514_(118, 79).m_171488_(-18.0F, -4.1F, -1.0F, 7.0F, 8.0F, 14.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-12.1416F, 5.4044F, 2.9465F, -0.1886F, -0.3864F, 0.0718F));
      PartDefinition bone14 = bone8.m_171599_("bone14", CubeListBuilder.m_171558_(), PartPose.m_171419_(-10.2906F, 5.3985F, 10.3242F));
      bone14.m_171599_("head_r7", CubeListBuilder.m_171558_().m_171514_(0, 198).m_171488_(-18.1F, -3.1F, -7.0F, 36.0F, 7.0F, 16.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
      bone14.m_171599_("head_r8", CubeListBuilder.m_171558_().m_171514_(275, 337).m_171488_(-15.0F, -3.9F, -9.0F, 27.0F, 8.0F, 11.0F, new CubeDeformation(-0.8F)), PartPose.m_171423_(-0.1F, -0.1926F, -10.5733F, -0.1309F, 0.0F, 0.0F));
      bone14.m_171599_("head_r9", CubeListBuilder.m_171558_().m_171514_(218, 49).m_171488_(-18.0F, -4.1F, -5.0F, 36.0F, 8.0F, 11.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-0.1F, -0.1926F, -10.5733F, -0.1745F, 0.0F, 0.0F));
      PartDefinition bone = head.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(109, 193).m_171488_(-2.6F, -40.4F, 47.0F, 30.0F, 30.0F, 31.0F, new CubeDeformation(-0.1F)).m_171514_(109, 193).m_171488_(-2.6F, -53.4F, 47.0F, 30.0F, 30.0F, 31.0F, new CubeDeformation(-0.2F)), PartPose.m_171419_(-13.0F, 24.0F, -29.0F));
      bone.m_171599_("head_r10", CubeListBuilder.m_171558_().m_171514_(228, 79).m_171488_(-17.0F, -24.9F, 31.8F, 33.0F, 13.0F, 26.0F, new CubeDeformation(-2.4F)), PartPose.m_171423_(12.9F, 19.1085F, 36.3935F, 1.0036F, 0.0F, 0.0F));
      bone.m_171599_("head_r11", CubeListBuilder.m_171558_().m_171514_(140, 150).m_171488_(-18.0F, -39.9F, -1.2F, 36.0F, 9.0F, 34.0F, new CubeDeformation(-2.4F)), PartPose.m_171423_(12.9F, 19.1085F, 36.3935F, 0.5236F, 0.0F, 0.0F));
      bone.m_171599_("head_r12", CubeListBuilder.m_171558_().m_171514_(0, 68).m_171488_(-12.9F, -37.9F, -29.2F, 29.0F, 11.0F, 60.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(12.9F, 19.1085F, 36.3935F, 0.3065F, -0.0832F, -0.0263F));
      bone.m_171599_("head_r13", CubeListBuilder.m_171558_().m_171514_(119, 80).m_171488_(-18.5F, -37.9F, -28.2F, 25.0F, 11.0F, 59.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(12.9F, 19.1085F, 36.3935F, 0.3065F, 0.0832F, 0.0263F));
      bone.m_171599_("head_r14", CubeListBuilder.m_171558_().m_171514_(207, 242).m_171488_(-15.9F, -31.4F, 16.0F, 30.0F, 17.0F, 24.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(13.0F, 19.8136F, 49.4118F, 1.0036F, 0.0F, 0.0F));
      bone.m_171599_("head_r15", CubeListBuilder.m_171558_().m_171514_(218, 0).m_171488_(-16.5F, -19.4F, 16.0F, 31.0F, 19.0F, 30.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(13.2F, 0.0216F, 13.3368F, -0.0873F, 0.0F, 0.0F));
      PartDefinition bone9 = bone.m_171599_("bone9", CubeListBuilder.m_171558_(), PartPose.m_171423_(16.0F, 8.2232F, 36.9687F, 0.0F, -0.0873F, 0.0F));
      bone9.m_171599_("head_r16", CubeListBuilder.m_171558_().m_171514_(0, 262).m_171488_(-12.6F, -28.8F, 20.0F, 22.0F, 30.0F, 20.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-2.0709F, -14.0559F, 6.0038F, 0.1579F, 0.0953F, 0.009F));
      bone9.m_171599_("head_r17", CubeListBuilder.m_171558_().m_171514_(162, 283).m_171488_(-15.6F, -20.8F, 20.0F, 25.0F, 14.0F, 20.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-2.2676F, 0.6073F, 5.3324F, -0.0166F, 0.0953F, 0.009F));
      PartDefinition bone12 = bone.m_171599_("bone12", CubeListBuilder.m_171558_(), PartPose.m_171419_(10.7754F, 35.181F, -11.5819F));
      bone12.m_171599_("head_r18", CubeListBuilder.m_171558_().m_171514_(126, 8).m_171488_(-19.01F, -37.9F, -29.2F, 16.0F, 11.0F, 60.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(2.1246F, -16.0725F, 50.9754F, 0.3099F, 0.1664F, 0.053F));
      PartDefinition bone13 = bone12.m_171599_("bone13", CubeListBuilder.m_171558_(), PartPose.m_171423_(9.3026F, -3.0653F, 9.7218F, -0.2182F, 0.0F, 0.0F));
      bone13.m_171599_("head_r19", CubeListBuilder.m_171558_().m_171514_(0, 31).m_171488_(-6.4379F, -3.3811F, -2.5726F, 16.0F, 7.0F, 13.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-23.0F, -33.233F, -7.0842F, 0.3099F, -0.1664F, -0.053F));
      PartDefinition bone7 = head.m_171599_("bone7", CubeListBuilder.m_171558_(), PartPose.m_171423_(-1.3F, 24.0F, -3.2F, 0.0873F, 0.0F, 0.0F));
      PartDefinition bone3 = bone7.m_171599_("bone3", CubeListBuilder.m_171558_().m_171514_(125, 0).m_171488_(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(118, 101).m_171488_(-2.0F, -9.0F, -8.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.3F)), PartPose.m_171419_(-8.5F, 0.0F, -30.1F));
      bone3.m_171599_("head_r20", CubeListBuilder.m_171558_().m_171514_(252, 283).m_171488_(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone2 = bone7.m_171599_("bone2", CubeListBuilder.m_171558_().m_171514_(125, 0).m_171488_(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(118, 101).m_171488_(-2.0F, -9.0F, -8.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.3F)), PartPose.m_171419_(-0.2F, 0.0F, -27.1F));
      bone2.m_171599_("head_r21", CubeListBuilder.m_171558_().m_171514_(252, 283).m_171488_(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone4 = bone7.m_171599_("bone4", CubeListBuilder.m_171558_().m_171514_(125, 0).m_171488_(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.2F)).m_171514_(118, 101).m_171488_(-2.0F, -9.0F, -8.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.5F)), PartPose.m_171419_(7.8F, 0.0F, -25.6F));
      bone4.m_171599_("head_r22", CubeListBuilder.m_171558_().m_171514_(252, 283).m_171488_(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone6 = bone7.m_171599_("bone6", CubeListBuilder.m_171558_().m_171514_(125, 0).m_171488_(-2.0F, -9.0F, -16.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-0.8F)).m_171514_(118, 101).m_171488_(-2.0F, -9.0F, -9.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(14.9F, 0.0F, -21.8F, 0.0F, -0.0436F, 0.0F));
      bone6.m_171599_("head_r23", CubeListBuilder.m_171558_().m_171514_(252, 283).m_171488_(-14.0F, -14.4F, -41.0F, 6.0F, 5.0F, 26.0F, new CubeDeformation(-0.9F)), PartPose.m_171423_(13.0F, 0.0F, 29.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone11 = bone7.m_171599_("bone11", CubeListBuilder.m_171558_().m_171514_(1, 91).m_171488_(-18.0F, -9.0F, -45.0F, 12.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(0, 68).m_171488_(-18.0F, -9.0F, -41.0F, 12.0F, 8.0F, 14.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-3.1F, 0.0F, -1.8F, 0.0F, 0.0436F, 0.0F));
      bone11.m_171599_("head_r24", CubeListBuilder.m_171558_().m_171514_(93, 150).m_171488_(-17.0F, -14.4F, -41.0F, 9.0F, 5.0F, 26.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
      PartDefinition bone10 = head.m_171599_("bone10", CubeListBuilder.m_171558_(), PartPose.m_171419_(13.0F, 24.0F, -29.0F));
      return LayerDefinition.m_171565_(meshdefinition, 368, 368);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
