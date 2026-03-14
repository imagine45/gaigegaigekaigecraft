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

public class Modelnaoya_cursed_spirit2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelnaoya_cursed_spirit_2"), "main");
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg;
   public final ModelPart LeftArm;
   public final ModelPart RightArm;
   public final ModelPart Body;
   public final ModelPart Head;

   public Modelnaoya_cursed_spirit2(ModelPart root) {
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightArm = root.m_171324_("RightArm");
      this.Body = root.m_171324_("Body");
      this.Head = root.m_171324_("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(2.4638F, 8.944F, 1.5F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.6069F, -3.1194F, -4.3583F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.3656F, 13.1468F, -0.1835F, 0.0F, 1.1781F, 0.0873F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.1083F, -3.1194F, -3.2431F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.3656F, 13.1468F, -0.1835F, 0.0F, -0.3927F, 0.0873F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(1.81F, -8.6139F, -2.4431F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-1.34F, -2.6139F, -2.4431F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.3656F, 13.1468F, -0.1835F, 0.1572F, -0.3614F, -0.3342F));
      LeftLeg.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.5733F, -12.3391F, -3.237F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.3656F, 13.1468F, -0.1835F, 0.0F, -0.7854F, -0.0436F));
      LeftLeg.m_171599_("LeftLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.613F, -12.3391F, -3.8233F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.3656F, 13.1468F, -0.1835F, 0.0F, 0.7854F, -0.0436F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-2.4638F, 8.944F, 1.5F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.3931F, -3.1194F, -4.3583F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.3656F, 13.1468F, -0.1835F, 0.0F, -1.1781F, -0.0873F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.1083F, -3.1194F, -3.2431F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.3656F, 13.1468F, -0.1835F, 0.0F, 0.3927F, -0.0873F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.81F, -8.6139F, -2.4431F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-0.66F, -2.6139F, -2.4431F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.3656F, 13.1468F, -0.1835F, 0.1572F, 0.3614F, 0.3342F));
      RightLeg.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.4267F, -12.3391F, -3.237F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.3656F, 13.1468F, -0.1835F, 0.0F, 0.7854F, 0.0436F));
      RightLeg.m_171599_("RightLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.387F, -12.3391F, -3.8233F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.3656F, 13.1468F, -0.1835F, 0.0F, -0.7854F, 0.0436F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(8.4638F, -14.056F, 1.5F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.8F, -7.45F, -3.05F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.0F, 17.6086F, -0.8625F, 0.0F, 1.1781F, -0.1745F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.8F, -7.45F, -3.05F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.0F, 17.6086F, -0.8625F, 0.0F, -0.3927F, -0.1745F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(5.25F, -13.5F, -2.25F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(2.1F, -7.5F, -2.25F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(6.2605F, 19.0858F, -0.8625F, 0.1572F, -0.3614F, -0.596F));
      LeftArm.m_171599_("LeftArm_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.8F, -5.2F, -3.05F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.8234F, 6.4628F, -0.8625F, 0.0F, -0.7854F, -0.3054F));
      LeftArm.m_171599_("LeftArm_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.8F, -5.2F, -3.05F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.8234F, 6.4628F, -0.8625F, 0.0F, 0.7854F, -0.3054F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-8.4638F, -14.056F, 1.5F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.2F, -7.45F, -3.05F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, 17.6086F, -0.8625F, 0.0F, -1.1781F, 0.1745F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.2F, -7.45F, -3.05F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, 17.6086F, -0.8625F, 0.0F, 0.3927F, 0.1745F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-7.25F, -13.5F, -2.25F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.1F, -7.5F, -2.25F, 2.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.2605F, 19.0858F, -0.8625F, 0.1572F, 0.3614F, 0.596F));
      RightArm.m_171599_("RightArm_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.2F, -5.2F, -3.05F, 2.0F, 18.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.8234F, 6.4628F, -0.8625F, 0.0F, 0.7854F, 0.3054F));
      RightArm.m_171599_("RightArm_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.2F, -5.2F, -3.05F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.8234F, 6.4628F, -0.8625F, 0.0F, -0.7854F, 0.3054F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-2.97F, -57.0359F, -3.8925F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.06F)).m_171514_(0, 48).m_171480_().m_171488_(-5.5F, -38.5512F, 2.8925F, 11.0F, 15.0F, 3.0F, new CubeDeformation(-0.01F)).m_171555_(false).m_171514_(0, 51).m_171480_().m_171488_(-4.0F, -52.0462F, 9.0375F, 8.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 48).m_171480_().m_171488_(-3.005F, -55.0512F, 2.8925F, 6.0F, 6.0F, 3.0F, new CubeDeformation(-0.01F)).m_171555_(false).m_171514_(0, 49).m_171480_().m_171488_(-6.0F, -49.5512F, 2.8925F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(1, 49).m_171480_().m_171488_(-4.255F, -23.5512F, 2.8925F, 8.0F, 15.0F, 3.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-3.775F, -11.225F, -3.025F, 3.0F, 12.0F, 9.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(8.4364F, -45.8159F, -0.8625F, 0.0F, 0.0F, -0.4363F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-1.505F, -3.745F, -3.005F, 5.0F, 9.0F, 9.0F, new CubeDeformation(0.01F)).m_171514_(0, 48).m_171488_(-1.445F, -25.805F, -2.945F, 5.0F, 13.0F, 9.0F, new CubeDeformation(-0.11F)).m_171514_(0, 48).m_171488_(0.005F, -15.755F, -2.995F, 4.0F, 15.0F, 9.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -7.7962F, -0.8625F, 0.0F, 0.0F, 0.1745F));
      Body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-1.495F, -8.755F, -3.745F, 3.0F, 17.0F, 8.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(5.3615F, -34.8615F, 6.3241F, -0.0869F, -0.7816F, 0.1231F));
      Body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-0.745F, -7.505F, -5.745F, 3.0F, 18.0F, 8.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(2.55F, -44.5462F, 9.0375F, 0.0F, -0.3927F, 0.0F));
      Body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-3.0F, -8.5F, -1.5F, 6.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0322F, -26.9792F, 5.9602F, -0.3491F, 0.9599F, -0.2618F));
      Body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(0.925F, 4.175F, -3.05F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(0, 48).m_171480_().m_171488_(-3.55F, 11.15F, -3.025F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-0.45F, -26.3914F, -0.8625F, 0.0F, 0.0F, -0.48F));
      Body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(5.2F, -9.15F, -2.975F, 5.0F, 9.0F, 9.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(0.3F, -26.3914F, -0.8625F, 0.0F, 0.0F, -0.48F));
      Body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(0.65F, -11.65F, -3.1F, 3.0F, 17.0F, 9.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(3.75F, -28.6414F, -0.8625F, 0.0F, 0.0F, 0.48F));
      Body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-5.55F, -13.5F, -3.0F, 6.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.5F, -28.6414F, -0.8625F, 0.0F, 0.0F, 0.48F));
      Body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171480_().m_171488_(-0.35F, -5.7F, -3.05F, 3.0F, 11.0F, 9.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(8.4364F, -39.8159F, -0.8625F, 0.0F, 0.0F, -0.6981F));
      Body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(0.775F, -11.225F, -3.025F, 3.0F, 12.0F, 9.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-8.4364F, -45.8159F, -0.8625F, 0.0F, 0.0F, 0.4363F));
      Body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-3.495F, -3.745F, -3.005F, 5.0F, 9.0F, 9.0F, new CubeDeformation(0.02F)).m_171555_(false).m_171514_(0, 48).m_171480_().m_171488_(-3.555F, -25.805F, -2.945F, 5.0F, 13.0F, 9.0F, new CubeDeformation(-0.11F)).m_171555_(false).m_171514_(0, 48).m_171480_().m_171488_(-4.005F, -15.755F, -2.995F, 4.0F, 15.0F, 9.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(0.0F, -7.7962F, -0.8625F, 0.0F, 0.0F, -0.1745F));
      Body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-1.505F, -8.755F, -3.745F, 3.0F, 17.0F, 8.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-5.3615F, -34.8615F, 6.3241F, -0.0869F, 0.7816F, -0.1231F));
      Body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-2.255F, -7.505F, -5.745F, 3.0F, 18.0F, 8.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-2.55F, -44.5462F, 9.0375F, 0.0F, 0.3927F, 0.0F));
      Body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-3.0F, -8.5F, -1.5F, 6.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0322F, -26.9792F, 5.9602F, -0.3491F, -0.9599F, 0.2618F));
      Body.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-3.5F, -31.25F, 9.75F, 8.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, -7.7962F, -8.3625F, -0.2618F, 0.0F, 0.0F));
      Body.m_171599_("Body_r17", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-5.925F, 4.175F, -3.05F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.1F)).m_171514_(0, 48).m_171488_(-1.45F, 11.15F, -3.025F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.45F, -26.3914F, -0.8625F, 0.0F, 0.0F, 0.48F));
      Body.m_171599_("Body_r18", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-10.2F, -9.15F, -2.975F, 5.0F, 9.0F, 9.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(-0.3F, -26.3914F, -0.8625F, 0.0F, 0.0F, 0.48F));
      Body.m_171599_("Body_r19", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-3.65F, -11.65F, -3.1F, 3.0F, 17.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-3.75F, -28.6414F, -0.8625F, 0.0F, 0.0F, -0.48F));
      Body.m_171599_("Body_r20", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-0.45F, -13.5F, -3.0F, 6.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.5F, -28.6414F, -0.8625F, 0.0F, 0.0F, -0.48F));
      Body.m_171599_("Body_r21", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171488_(-2.65F, -5.7F, -3.05F, 3.0F, 11.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-8.4364F, -39.8159F, -0.8625F, 0.0F, 0.0F, 0.6981F));
      Body.m_171599_("Body_r22", CubeListBuilder.m_171558_().m_171514_(4, 52).m_171488_(-3.0F, -1.35F, -1.1F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -55.4709F, 5.107F, 0.5236F, 0.0F, 0.0F));
      Body.m_171599_("Body2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -37.3914F, -3.1125F, 6.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 1).m_171488_(-6.0F, -47.8914F, -3.1125F, 6.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 1).m_171480_().m_171488_(0.0F, -47.8914F, -3.1125F, 6.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(2, 1).m_171480_().m_171488_(-3.35F, -54.0414F, -3.7625F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(77, 0).m_171488_(-3.5F, 8.8745F, -7.6749F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(80, 9).m_171488_(-3.0F, 3.3745F, -7.1749F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(-4.5F, 8.9995F, -6.4999F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-4.0F, 2.9995F, -6.4999F, 8.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -5.0E-4F, -5.7499F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-4.0F, 17.9995F, -6.4999F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-2.5F, 20.9995F, -5.7499F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -29.3908F, -0.3626F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(78, 17).m_171488_(-3.7F, -6.375F, -3.5F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(0.5F, 20.6245F, -4.1749F, -0.0436F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 96, 96);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.LeftLeg.f_104204_ = netHeadYaw / 57.295776F;
      this.LeftLeg.f_104203_ = headPitch / 57.295776F;
      this.RightArm.f_104204_ = netHeadYaw / 57.295776F;
      this.RightArm.f_104203_ = headPitch / 57.295776F;
      this.RightLeg.f_104204_ = netHeadYaw / 57.295776F;
      this.RightLeg.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104204_ = netHeadYaw / 57.295776F;
      this.LeftArm.f_104203_ = headPitch / 57.295776F;
   }
}
