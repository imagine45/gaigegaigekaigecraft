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

public class Modelclock<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclock"), "main");
   public final ModelPart bone;
   public final ModelPart bone2;
   public final ModelPart bone3;
   public final ModelPart bone4;
   public final ModelPart bone5;
   public final ModelPart bone6;

   public Modelclock(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.bone2 = root.m_171324_("bone2");
      this.bone3 = root.m_171324_("bone3");
      this.bone4 = root.m_171324_("bone4");
      this.bone5 = root.m_171324_("bone5");
      this.bone6 = root.m_171324_("bone6");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-34.0F, -4.0F, 152.8749F, 68.0F, 8.0F, 48.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(14, 175).m_171488_(14.4207F, -4.0F, 128.9011F, 68.0F, 8.0F, 47.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.0F, 3.1416F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-84.4835F, -4.0F, 133.8812F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, 0.0F, 0.7854F, 0.0F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-73.7548F, -4.0F, 115.9316F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, 0.0F, 1.1781F, 0.0F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-36.6952F, -4.0F, 98.3483F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, -3.1416F, 1.1781F, 3.1416F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-56.9738F, -4.0F, 103.4541F, 68.0F, 8.0F, 48.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, 0.0F, 1.5708F, 0.0F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(1.9432F, -4.0F, 112.12F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.3927F, 3.1416F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-16.0063F, -4.0F, 101.3913F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.7854F, 3.1416F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(19.5266F, -4.0F, 149.1797F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, -3.1416F, -0.3927F, 3.1416F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-110.6887F, -4.0F, 39.1988F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-133.9011F, 0.0F, -24.4469F, 0.0F, -2.3562F, 0.0F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-61.7318F, -4.0F, 18.4283F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-133.9011F, 0.0F, -24.4469F, 0.0F, -1.9635F, 0.0F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(40.7516F, -4.0F, 37.9045F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-133.9011F, 0.0F, -24.4469F, 0.0F, -1.1781F, 0.0F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-8.5531F, -4.0F, 17.9738F, 68.0F, 8.0F, 48.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-133.9011F, 0.0F, -24.4469F, 0.0F, -1.5708F, 0.0F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-3.9833F, -4.0F, 0.9707F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-85.4803F, 0.0F, 128.9304F, 0.0F, -0.3927F, 0.0F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-64.0167F, -4.0F, 0.9707F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-85.4803F, 0.0F, 128.9304F, 0.0F, -0.7854F, 0.0F));
      bone.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(29, 190).m_171488_(-34.0F, -4.0F, -5.0F, 68.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(60.0334F, 0.0F, 145.9335F, 0.0F, 0.3927F, 0.0F));
      PartDefinition bone2 = partdefinition.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone2.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-32.1913F, -1.0F, -154.5381F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.9619F, 0.0F, 0.8087F, -3.1416F, -2.7489F, 3.1416F));
      bone2.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-31.8087F, -1.0F, -154.5381F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(0.9619F, 0.0F, 0.8087F, -3.1416F, -2.3562F, 3.1416F));
      bone2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -1.5708F, 3.1416F));
      bone2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(-0.02F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -1.9635F, 3.1416F));
      bone2.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -0.7854F, 3.1416F));
      bone2.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.07F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -1.1781F, 3.1416F));
      bone2.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(-32.0F, -1.0F, -155.5F, 64.0F, 2.0F, 309.0F, new CubeDeformation(-0.02F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -0.3927F, 3.1416F));
      bone2.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(268, 0).m_171488_(16.4207F, -1.0F, -180.0989F, 64.0F, 2.0F, 309.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(48.4207F, 0.0F, -23.5989F, -3.1416F, 0.0F, 3.1416F));
      PartDefinition bone3 = partdefinition.m_171599_("bone3", CubeListBuilder.m_171558_().m_171514_(691, 597).m_171488_(-8.0F, -4.0F, -8.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(306, 694).m_171488_(-16.0F, -2.0F, -16.0F, 32.0F, 1.0F, 32.0F, new CubeDeformation(0.02F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone3.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(306, 694).m_171488_(-17.0F, -2.0F, -17.0F, 33.0F, 1.0F, 32.0F, new CubeDeformation(0.0F)).m_171514_(691, 597).m_171488_(-9.0F, -4.0F, -9.0F, 17.0F, 3.0F, 16.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 0.0F, -0.7854F, 0.0F));
      PartDefinition bone4 = partdefinition.m_171599_("bone4", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone4.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(580, 544).m_171488_(-25.0F, -2.6F, -8.0F, 108.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 0.0F, -1.2654F, 0.0F));
      PartDefinition bone5 = partdefinition.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone5.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(580, 544).m_171488_(-25.0F, -3.0F, -6.0F, 174.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 0.0F, 2.0944F, 0.0F));
      PartDefinition bone6 = partdefinition.m_171599_("bone6", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone6.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -2.7489F, 3.1416F));
      bone6.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -1.5708F, 3.1416F));
      bone6.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -1.9635F, 3.1416F));
      bone6.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -1.5708F, 3.1416F));
      bone6.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -1.9635F, 3.1416F));
      bone6.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -2.3562F, 3.1416F));
      bone6.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -2.3562F, 3.1416F));
      bone6.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -2.7489F, 3.1416F));
      bone6.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(46.4207F, -2.0F, -128.9011F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(48.4207F, 0.0F, 23.9738F, 3.1416F, 0.0F, 3.1416F));
      bone6.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -0.3927F, 3.1416F));
      bone6.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(46.4207F, -2.0F, 78.9011F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(48.4207F, 0.0F, -21.9738F, -3.1416F, 0.0F, 3.1416F));
      bone6.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -0.3927F, 3.1416F));
      bone6.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -0.7854F, 3.1416F));
      bone6.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -0.7854F, 3.1416F));
      bone6.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, 101.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, -3.1416F, -1.1781F, 3.1416F));
      bone6.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(13, 174).m_171488_(-2.0F, -2.0F, -151.8749F, 4.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 1.0F, 3.1416F, -1.1781F, 3.1416F));
      return LayerDefinition.m_171565_(meshdefinition, 1024, 1024);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone4.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone5.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone6.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bone5.f_104204_ = ageInTicks;
      this.bone4.f_104204_ = ageInTicks / 20.0F;
   }
}
