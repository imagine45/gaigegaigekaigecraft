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

public class Modelcursedspirit3_8<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_8"), "main");
   public final ModelPart Body;

   public Modelcursedspirit3_8(ModelPart root) {
      this.Body = root.m_171324_("Body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.1833F, 23.5F, 19.4744F));
      PartDefinition Shell = Body.m_171599_("Shell", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -1.0F, -8.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(34, 37).m_171488_(-5.5F, -1.0F, -5.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.4F)).m_171514_(34, 37).m_171488_(-5.5F, -2.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-1.1F)).m_171514_(34, 37).m_171488_(-5.5F, -1.0F, -3.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.m_171419_(1.1833F, -16.5F, -17.9744F));
      Shell.m_171599_("Shell_r1", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      Shell.m_171599_("Shell_r2", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -8.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.1F)).m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -5.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.5F)).m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -3.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.m_171423_(0.0F, 6.5F, 0.0F, 1.5708F, 0.0F, 0.0F));
      Shell.m_171599_("Shell_r3", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 6.5F, 6.5F, 0.0F, 3.1416F, 0.0F));
      Shell.m_171599_("Shell_r4", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(0.0F, 6.5F, 3.5F, 0.0F, 3.1416F, 0.0F));
      Shell.m_171599_("Shell_r5", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(0.0F, 3.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      Shell.m_171599_("Shell_r6", CubeListBuilder.m_171558_().m_171514_(34, 37).m_171488_(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 6.5F, 1.5F, 0.0F, 3.1416F, 0.0F));
      PartDefinition BodyMain = Body.m_171599_("BodyMain", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -13.1998F, 25.6606F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.5F, -13.1998F, 9.4606F, 11.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.5F, -13.1998F, -0.5394F, 5.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.5F, -13.1998F, -3.3394F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.1833F, 11.6998F, -33.935F));
      BodyMain.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -4.2076F, -14.4743F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -1.789F, 0.0F, 0.0F));
      BodyMain.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -2.0076F, -16.0743F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.8633F, -7.3284F, -2.1817F, 0.0F, 0.0F));
      BodyMain.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -4.0F, -17.9F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 3.151F, -0.5268F, -1.4835F, 0.0F, 0.0F));
      BodyMain.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -2.0F, -17.9F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.1098F, 9.7566F, -0.7418F, 0.0F, 0.0F));
      BodyMain.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.5F, -1.0F, -1.56F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.5447F, -12.1998F, -1.2467F, 0.0F, 0.4179F, 0.0F));
      BodyMain.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -1.0F, -1.56F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5447F, -12.1998F, -1.2467F, 0.0F, -0.4179F, 0.0F));
      BodyMain.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.9833F, -7.5F, -15.5256F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(1.3759F, -18.9595F, 14.0261F, 0.4247F, 0.165F, -0.3484F));
      BodyMain.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.9833F, -7.5F, -15.5256F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-1.3759F, -18.9595F, 14.0261F, 0.4247F, -0.165F, 0.3484F));
      BodyMain.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.6833F, -2.0F, -12.9743F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.3382F, -11.1998F, 14.1129F, 0.0F, -0.3491F, 0.0F));
      BodyMain.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.3167F, -2.0F, -12.9743F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.3382F, -11.1998F, 14.1129F, 0.0F, 0.3491F, 0.0F));
      BodyMain.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.3167F, -2.0F, 10.9744F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.7326F, -11.1998F, 15.2305F, 0.0F, -0.3491F, 0.0F));
      BodyMain.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0581F, -2.0F, 17.7212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0581F, -2.0F, 17.2212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(16.588F, -11.1998F, 23.2957F, 0.0F, -1.0821F, 0.0F));
      BodyMain.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.942F, -2.0F, 17.2212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.942F, -2.0F, 17.7212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-16.5881F, -11.1998F, 23.2956F, 0.0F, 1.0821F, 0.0F));
      BodyMain.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.6833F, -2.0F, 10.9744F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.7326F, -11.1998F, 15.2305F, 0.0F, 0.3491F, 0.0F));
      PartDefinition RightEye = Body.m_171599_("RightEye", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.969F, -6.316F, -35.9679F));
      RightEye.m_171599_("RightEye_r1", CubeListBuilder.m_171558_().m_171514_(56, 60).m_171488_(-1.2999F, -1.0065F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.2937F, 0.9825F, -0.0239F));
      RightEye.m_171599_("RightEye_r2", CubeListBuilder.m_171558_().m_171514_(56, 58).m_171488_(-1.0065F, -1.2999F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.0059F, 0.1245F, 1.817F));
      PartDefinition LeftEye = Body.m_171599_("LeftEye", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.6024F, -6.316F, -35.9679F));
      LeftEye.m_171599_("LeftEye_r1", CubeListBuilder.m_171558_().m_171514_(56, 58).m_171480_().m_171488_(-0.9935F, -1.2999F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.0059F, -0.1245F, -1.817F));
      LeftEye.m_171599_("LeftEye_r2", CubeListBuilder.m_171558_().m_171514_(56, 60).m_171480_().m_171488_(-0.7001F, -1.0065F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.2937F, -0.9825F, 0.0239F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
