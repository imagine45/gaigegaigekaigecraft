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

public class ModelMahoraga_dog6<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_mahoraga_dog_6"), "main");
   public final ModelPart bone;

   public ModelMahoraga_dog6(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      PartDefinition Tail = bone.m_171599_("Tail", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.1F, -2.8234F, 4.8331F, 0.3491F, 0.0F, 0.0F));
      Tail.m_171599_("Tail_r1", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-1.0F, -1.7247F, 0.613F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).m_171514_(0, 24).m_171488_(-1.0F, -1.7247F, -4.387F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.1F, 3.6481F, 2.9539F, -0.3927F, 0.0F, 0.0F));
      PartDefinition RightLeg = bone.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.0F, -11.6751F, 5.7979F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.5F, -5.7296F, -1.4804F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-1.0F, 0.2296F, -1.0196F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.1468F, 7.07F, -2.0796F, -2.0944F, 0.3927F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -2.7F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.9888F, 7.9751F, -4.094F, 0.3491F, 0.3927F, 0.0F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171480_().m_171488_(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.1183F, 11.1751F, -4.577F, 0.0F, 0.3927F, 0.0F));
      PartDefinition LeftLeg = bone.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.0F, -11.6751F, 5.7979F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.5F, -5.7296F, -1.4804F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 15).m_171488_(-1.0F, 0.2296F, -1.0196F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.1468F, 7.07F, -2.0796F, -2.0944F, -0.3927F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -2.7F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.9888F, 7.9751F, -4.094F, 0.3491F, -0.3927F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171488_(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.1183F, 11.1751F, -4.577F, 0.0F, -0.3927F, 0.0F));
      PartDefinition RightArm = bone.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171480_().m_171488_(-0.6F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(-2.8F, -11.6751F, -4.2021F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.5F, -5.4633F, -1.5081F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -0.2367F, -0.9919F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.4F, 3.3861F, 1.5443F, 0.0436F, 0.0F, 0.0F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.4F, 9.6751F, 1.6021F, -0.0436F, 0.0F, 0.0F));
      PartDefinition LeftArm = bone.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171488_(-1.4F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(2.8F, -11.6751F, -4.2021F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.5F, -5.4633F, -1.5081F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 15).m_171488_(-1.0F, -0.2367F, -0.9919F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.4F, 3.3861F, 1.5443F, 0.0436F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 9.6751F, 1.6021F, -0.0436F, 0.0F, 0.0F));
      PartDefinition BodyMain = bone.m_171599_("BodyMain", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 2.0F, 0.7F, -0.3491F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r1", CubeListBuilder.m_171558_().m_171514_(8, 23).m_171488_(-2.0F, -3.4178F, -3.8675F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.2F)).m_171514_(0, 20).m_171488_(-3.0F, -1.9178F, -0.3675F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).m_171514_(0, 20).m_171488_(-3.5F, -2.9178F, -2.8675F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).m_171514_(1, 16).m_171488_(-2.5F, -3.4178F, -1.8675F, 5.0F, 7.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -12.0822F, -6.1325F, -0.48F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r2", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.5F, -2.5F, -3.5F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5F, -14.1998F, -8.3884F, -0.5236F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r3", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.4262F, -8.0F, -10.5F, 5.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.0738F, -0.5F, 1.5F, -0.7418F, 0.0F, 0.0F));
      PartDefinition Head = bone.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171488_(-1.6131F, -2.6F, -3.2685F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-0.6131F, -1.5F, -6.0685F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(10, 0).m_171488_(-1.1131F, -1.2F, -5.7685F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1131F, -16.4F, -5.7315F, -0.7854F, 0.0F, 0.0F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171480_().m_171488_(0.153F, -0.7496F, -1.0553F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-0.1131F, -2.9268F, -0.7685F, -0.8112F, -0.0557F, 0.3699F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171488_(-2.153F, -0.7496F, -1.0553F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.1131F, -2.9268F, -0.7685F, -0.8112F, 0.0557F, -0.3699F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.4262F, -19.973F, -14.8042F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.3131F, 2.473F, 19.9357F, 0.7854F, 0.0F, 0.0F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-1.0F, -0.3F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.1131F, 1.0F, -3.7685F, 0.2618F, 0.0F, 0.0F));
      PartDefinition NeckHair = Head.m_171599_("NeckHair", CubeListBuilder.m_171558_(), PartPose.m_171423_(-0.1131F, -1.0213F, 1.6337F, 0.6981F, 0.0F, 0.0F));
      NeckHair.m_171599_("BodyMain_r4", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.3F, -2.4F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 3.4393F, -2.1645F, -1.5272F, 0.0F, 0.0F));
      NeckHair.m_171599_("BodyMain_r5", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, 0.9476F, 1.2719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.397F, -1.7657F, -0.3055F, 0.4929F, 2.6897F));
      NeckHair.m_171599_("BodyMain_r6", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.4027F, 1.5843F, 0.2506F, -0.7167F, 0.4882F, 1.4423F));
      NeckHair.m_171599_("BodyMain_r7", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.397F, -0.7657F, -0.5856F, 0.5567F, 1.9062F));
      NeckHair.m_171599_("BodyMain_r8", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.4027F, 1.5843F, 0.2506F, -0.7167F, -0.4882F, -1.4423F));
      NeckHair.m_171599_("BodyMain_r9", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -1.397F, -0.7657F, -0.5856F, -0.5567F, -1.9062F));
      NeckHair.m_171599_("BodyMain_r10", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.2F, -1.397F, -1.7657F, -0.8384F, 0.6142F, 1.7659F));
      NeckHair.m_171599_("BodyMain_r11", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.2027F, 1.5843F, -0.7494F, -0.9572F, 0.4483F, 1.3333F));
      NeckHair.m_171599_("BodyMain_r12", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.5339F, 2.5188F, -2.2462F, -1.3573F, 0.4969F, 0.6107F));
      NeckHair.m_171599_("BodyMain_r13", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.5339F, 2.5188F, -2.2462F, -1.3573F, -0.4969F, -0.6107F));
      NeckHair.m_171599_("BodyMain_r14", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.2027F, 1.5843F, -0.7494F, -0.9572F, -0.4483F, -1.3333F));
      NeckHair.m_171599_("BodyMain_r15", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 1.4476F, 0.7719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -1.397F, -1.7657F, -0.0873F, 0.0F, -3.1416F));
      NeckHair.m_171599_("BodyMain_r16", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.2F, -1.397F, -1.7657F, -0.8384F, -0.6142F, -1.7659F));
      NeckHair.m_171599_("BodyMain_r17", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.9476F, 1.2719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -1.397F, -1.7657F, -0.3055F, -0.4929F, -2.6897F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
