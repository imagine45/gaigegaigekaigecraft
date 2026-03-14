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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelNue<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_nue"), "main");
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg;
   public final ModelPart LeftArm;
   public final ModelPart RightArm;
   public final ModelPart Body;
   public final ModelPart Head;

   public ModelNue(ModelPart root) {
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
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.016F, 14.7065F, 1.5638F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171480_().m_171488_(-0.5869F, -2.3204F, -1.113F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(7.1157F, 7.2802F, -3.0146F, 1.9519F, -0.8846F, -0.1581F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(-0.5378F, -1.7621F, -1.5765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(7.1157F, 7.2802F, -3.0146F, 0.8698F, -0.8846F, -0.1581F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(-0.5373F, -0.7676F, -1.6873F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(7.1157F, 7.2802F, -3.0146F, 0.0408F, -0.8846F, -0.1581F));
      LeftLeg.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(-0.5383F, -4.2358F, -3.328F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(3.7436F, 7.8071F, -1.3695F, 0.657F, -0.4141F, -0.0323F));
      LeftLeg.m_171599_("LeftLeg_r5", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171480_().m_171488_(-0.5874F, -5.0282F, 0.2488F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(3.7436F, 7.8071F, -1.3695F, 1.7391F, -0.4141F, -0.0323F));
      LeftLeg.m_171599_("LeftLeg_r6", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(-0.5378F, -1.1476F, -4.6944F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(3.7436F, 7.8071F, -1.3695F, -0.172F, -0.4141F, -0.0323F));
      LeftLeg.m_171599_("LeftLeg_r7", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171480_().m_171488_(6.5722F, -15.0155F, -6.3052F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-6.1937F, 3.0637F, 7.9124F, 1.6827F, 0.0534F, -0.3657F));
      LeftLeg.m_171599_("LeftLeg_r8", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(6.1118F, -8.3373F, -6.8515F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(-2.6907F, 11.382F, 3.9233F, 0.6006F, 0.0534F, -0.3657F));
      LeftLeg.m_171599_("LeftLeg_r9", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(3.7395F, -2.2929F, -3.0952F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.0572F, 10.0728F, -3.2351F, -0.2284F, 0.0534F, -0.3657F));
      LeftLeg.m_171599_("LeftLeg_r10", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171480_().m_171488_(-0.4403F, 4.1329F, -2.1472F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(3.7436F, 7.8071F, -1.3695F, 1.5505F, -0.4297F, -0.0095F));
      LeftLeg.m_171599_("LeftLeg_r11", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171480_().m_171488_(-0.4732F, 2.4507F, 2.7242F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(3.7436F, 7.8071F, -1.3695F, 0.6516F, -0.4297F, -0.0095F));
      LeftLeg.m_171599_("LeftLeg_r12", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171480_().m_171488_(-3.8731F, -9.8595F, 0.6519F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-3.8731F, -9.8595F, 0.6519F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(44, 34).m_171480_().m_171488_(-2.8731F, -7.3595F, 1.6519F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(6.328F, 8.5198F, -0.0791F, 0.0861F, -0.5338F, -0.3127F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.016F, 14.7065F, 1.5638F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171488_(-0.4131F, -2.3204F, -1.113F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-7.1157F, 7.2802F, -3.0146F, 1.9519F, 0.8846F, 0.1581F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-0.4622F, -1.7621F, -1.5765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-7.1157F, 7.2802F, -3.0146F, 0.8698F, 0.8846F, 0.1581F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-0.4627F, -0.7676F, -1.6873F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.1157F, 7.2802F, -3.0146F, 0.0408F, 0.8846F, 0.1581F));
      RightLeg.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-0.4617F, -4.2358F, -3.328F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-3.7436F, 7.8071F, -1.3695F, 0.657F, 0.4141F, 0.0323F));
      RightLeg.m_171599_("RightLeg_r5", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171488_(-0.4126F, -5.0282F, 0.2488F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-3.7436F, 7.8071F, -1.3695F, 1.7391F, 0.4141F, 0.0323F));
      RightLeg.m_171599_("RightLeg_r6", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-0.4622F, -1.1476F, -4.6944F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.7436F, 7.8071F, -1.3695F, -0.172F, 0.4141F, 0.0323F));
      RightLeg.m_171599_("RightLeg_r7", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171488_(-7.5722F, -15.0155F, -6.3052F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(6.1937F, 3.0637F, 7.9124F, 1.6827F, -0.0534F, 0.3657F));
      RightLeg.m_171599_("RightLeg_r8", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-7.1118F, -8.3373F, -6.8515F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(2.6907F, 11.382F, 3.9233F, 0.6006F, -0.0534F, 0.3657F));
      RightLeg.m_171599_("RightLeg_r9", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-4.7395F, -2.2929F, -3.0952F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0572F, 10.0728F, -3.2351F, -0.2284F, -0.0534F, 0.3657F));
      RightLeg.m_171599_("RightLeg_r10", CubeListBuilder.m_171558_().m_171514_(49, 8).m_171488_(-0.5597F, 4.1329F, -2.1472F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-3.7436F, 7.8071F, -1.3695F, 1.5505F, 0.4297F, 0.0095F));
      RightLeg.m_171599_("RightLeg_r11", CubeListBuilder.m_171558_().m_171514_(44, 34).m_171488_(-0.5268F, 2.4507F, 2.7242F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-3.7436F, 7.8071F, -1.3695F, 0.6516F, 0.4297F, 0.0095F));
      RightLeg.m_171599_("RightLeg_r12", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171488_(0.8731F, -9.8595F, 0.6519F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).m_171514_(0, 55).m_171488_(0.8731F, -9.8595F, 0.6519F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)).m_171514_(44, 34).m_171488_(1.8731F, -7.3595F, 1.6519F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.328F, 8.5198F, -0.0791F, 0.0861F, 0.5338F, 0.3127F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(7.8062F, -0.6974F, 2.0558F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171480_().m_171488_(37.8253F, -32.3976F, -4.7878F, 2.0F, 3.0F, 14.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(17.7068F, 51.7783F, -2.6584F, 1.4381F, -0.7974F, -1.0943F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(29, 5).m_171480_().m_171488_(-0.61F, -6.5F, -0.5F, 1.0F, 12.0F, 7.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(31.3076F, 11.4144F, 10.495F, 2.1624F, -0.7974F, -1.0943F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(16, -8).m_171480_().m_171488_(-3.1F, -6.0F, -10.0F, 1.0F, 6.0F, 20.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(21.4815F, 5.0164F, 9.0655F, 1.938F, -1.1762F, -1.2922F));
      LeftArm.m_171599_("LeftArm_r4", CubeListBuilder.m_171558_().m_171514_(32, -6).m_171480_().m_171488_(-0.4F, -5.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(15.2644F, 4.5211F, 6.0663F, -2.6109F, -1.0686F, -1.8193F));
      LeftArm.m_171599_("LeftArm_r5", CubeListBuilder.m_171558_().m_171514_(32, -6).m_171480_().m_171488_(-0.1309F, -9.6665F, -1.2485F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(18.7686F, 9.6106F, 8.5898F, 3.0236F, -1.1887F, -1.0297F));
      LeftArm.m_171599_("LeftArm_r6", CubeListBuilder.m_171558_().m_171514_(34, -4).m_171480_().m_171488_(0.4F, -5.5F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(15.662F, 7.6749F, 13.1393F, -2.8172F, -0.7634F, -1.2723F));
      LeftArm.m_171599_("LeftArm_r7", CubeListBuilder.m_171558_().m_171514_(34, -4).m_171480_().m_171488_(0.6F, -5.5F, -2.0F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(21.1773F, 11.9502F, 13.8193F, 3.0787F, -0.7974F, -1.0943F));
      LeftArm.m_171599_("LeftArm_r8", CubeListBuilder.m_171558_().m_171514_(19, -5).m_171480_().m_171488_(19.9658F, -33.8566F, -18.376F, 1.0F, 12.0F, 17.0F, new CubeDeformation(0.25F)).m_171555_(false).m_171514_(0, 33).m_171480_().m_171488_(19.6658F, -36.8566F, -23.676F, 2.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.6833F, 27.7396F, 12.3412F, 1.7697F, -0.7974F, -1.0943F));
      LeftArm.m_171599_("LeftArm_r9", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-1.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(4.4667F, 3.5278F, 4.833F, 1.4826F, -0.8024F, -2.0742F));
      LeftArm.m_171599_("LeftArm_r10", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-3.5F, -7.4F, -5.5F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(4.4667F, 3.5278F, 4.833F, 1.4044F, -1.1923F, -1.9829F));
      LeftArm.m_171599_("LeftArm_r11", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171480_().m_171488_(1.0764F, -32.6638F, 2.6463F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(22.4447F, 13.9984F, 19.1926F, 1.4826F, -0.8024F, -2.0742F));
      LeftArm.m_171599_("LeftArm_r12", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-1.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(11.2605F, 1.0812F, 5.9025F, 1.8928F, -0.8024F, -2.0742F));
      LeftArm.m_171599_("LeftArm_r13", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-3.0F, -6.0F, -6.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(11.2605F, 1.0812F, 5.9025F, 2.1533F, -1.1595F, -2.3819F));
      LeftArm.m_171599_("LeftArm_r14", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171480_().m_171488_(9.9849F, -34.0101F, -0.868F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(21.0669F, 25.2038F, 15.6207F, 1.8928F, -0.8024F, -2.0742F));
      LeftArm.m_171599_("LeftArm_r15", CubeListBuilder.m_171558_().m_171514_(32, -6).m_171480_().m_171488_(0.6F, -4.5F, -4.9F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(37.8484F, 9.2233F, 4.5513F, 0.3559F, -0.6367F, -0.821F));
      LeftArm.m_171599_("LeftArm_r16", CubeListBuilder.m_171558_().m_171514_(34, -4).m_171480_().m_171488_(18.5567F, -37.9383F, 2.9125F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(43.5227F, 23.0445F, 13.7327F, 1.4914F, -0.8024F, -2.0742F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-7.8062F, -0.6974F, 2.0558F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171488_(-39.8253F, -32.3976F, -4.7878F, 2.0F, 3.0F, 14.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-17.7068F, 51.7783F, -2.6584F, 1.4381F, 0.7974F, 1.0943F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(29, 5).m_171488_(-0.39F, -6.5F, -0.5F, 1.0F, 12.0F, 7.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(-31.3076F, 11.4144F, 10.495F, 2.1624F, 0.7974F, 1.0943F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(16, -8).m_171488_(2.1F, -6.0F, -10.0F, 1.0F, 6.0F, 20.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-21.4815F, 5.0164F, 9.0655F, 1.938F, 1.1762F, 1.2922F));
      RightArm.m_171599_("RightArm_r4", CubeListBuilder.m_171558_().m_171514_(32, -6).m_171488_(0.4F, -5.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(-15.2644F, 4.5211F, 6.0663F, -2.6109F, 1.0686F, 1.8193F));
      RightArm.m_171599_("RightArm_r5", CubeListBuilder.m_171558_().m_171514_(32, -6).m_171488_(0.1309F, -9.6665F, -1.2485F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-18.7686F, 9.6106F, 8.5898F, 3.0236F, 1.1887F, 1.0297F));
      RightArm.m_171599_("RightArm_r6", CubeListBuilder.m_171558_().m_171514_(34, -4).m_171488_(-0.4F, -5.5F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(-15.662F, 7.6749F, 13.1393F, -2.8172F, 0.7634F, 1.2723F));
      RightArm.m_171599_("RightArm_r7", CubeListBuilder.m_171558_().m_171514_(34, -4).m_171488_(-0.6F, -5.5F, -2.0F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-21.1773F, 11.9502F, 13.8193F, 3.0787F, 0.7974F, 1.0943F));
      RightArm.m_171599_("RightArm_r8", CubeListBuilder.m_171558_().m_171514_(19, -5).m_171488_(-20.9658F, -33.8566F, -18.376F, 1.0F, 12.0F, 17.0F, new CubeDeformation(0.25F)).m_171514_(0, 33).m_171488_(-21.6658F, -36.8566F, -23.676F, 2.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.6833F, 27.7396F, 12.3412F, 1.7697F, 0.7974F, 1.0943F));
      RightArm.m_171599_("RightArm_r9", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(0.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-4.4667F, 3.5278F, 4.833F, 1.4826F, 0.8024F, 2.0742F));
      RightArm.m_171599_("RightArm_r10", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(2.5F, -7.4F, -5.5F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-4.4667F, 3.5278F, 4.833F, 1.4044F, 1.1923F, 1.9829F));
      RightArm.m_171599_("RightArm_r11", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171488_(-3.0764F, -32.6638F, 2.6463F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-22.4447F, 13.9984F, 19.1926F, 1.4826F, 0.8024F, 2.0742F));
      RightArm.m_171599_("RightArm_r12", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(0.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-11.2605F, 1.0812F, 5.9025F, 1.8928F, 0.8024F, 2.0742F));
      RightArm.m_171599_("RightArm_r13", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(2.0F, -6.0F, -6.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-11.2605F, 1.0812F, 5.9025F, 2.1533F, 1.1595F, 2.3819F));
      RightArm.m_171599_("RightArm_r14", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171488_(-11.9849F, -34.0101F, -0.868F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-21.0669F, 25.2038F, 15.6207F, 1.8928F, 0.8024F, 2.0742F));
      RightArm.m_171599_("RightArm_r15", CubeListBuilder.m_171558_().m_171514_(32, -6).m_171488_(-0.6F, -4.5F, -4.9F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-37.8484F, 9.2233F, 4.5513F, 0.3559F, 0.6367F, 0.821F));
      RightArm.m_171599_("RightArm_r16", CubeListBuilder.m_171558_().m_171514_(34, -4).m_171488_(-18.5567F, -37.9383F, 2.9125F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-43.5227F, 23.0445F, 13.7327F, 1.4914F, 0.8024F, 2.0742F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 7.1664F, 3.9725F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171480_().m_171488_(-1.9F, -4.0F, 0.6F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-8.035F, -7.1027F, -6.4095F, -1.181F, 0.2795F, -0.5946F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-2.1F, -4.0F, 0.6F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(8.035F, -7.1027F, -6.4095F, -1.181F, -0.2795F, 0.5946F));
      Body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171480_().m_171488_(-1.5F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-7.0786F, -8.1152F, -6.9292F, -1.1356F, -0.1979F, 0.3968F));
      Body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-2.5F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(7.0786F, -8.1152F, -6.9292F, -1.1356F, 0.1979F, -0.3968F));
      Body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-2.0F, -4.0F, 0.1F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -9.7113F, 0.5231F, 0.0F, -2.0944F, -1.5708F));
      Body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-3.6723F, -2.0F, 0.8196F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.0F, 8.5756F, 8.4625F, -2.618F, 0.4572F, -0.575F));
      Body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-2.6052F, -1.5F, -0.9838F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.0F, 8.5756F, 8.4625F, -2.5285F, 0.7993F, -0.5589F));
      Body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.3277F, -2.0F, 0.8196F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, 8.5756F, 8.4625F, -2.618F, -0.4572F, 0.575F));
      Body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-3.3948F, -1.5F, -0.9838F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, 8.5756F, 8.4625F, -2.5285F, -0.7993F, 0.5589F));
      Body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.0F, -4.0F, 0.7F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 7.4797F, 9.9231F, -3.1416F, -0.9163F, 1.5708F));
      Body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-3.0F, -2.5F, 1.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 4.2924F, 7.8906F, 0.0F, -1.3963F, -1.5708F));
      Body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-4.0F, -3.0F, -0.8F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.5F, 7.4797F, 9.9231F, 3.1416F, -1.2217F, 1.5708F));
      Body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171480_().m_171488_(-1.5F, -1.0F, -2.2F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -2.0197F, -9.3974F, 0.2647F, 0.3193F, -1.7056F));
      Body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-2.5F, -1.0F, -2.2F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -2.0197F, -9.3974F, 0.2647F, -0.3193F, 1.7056F));
      Body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(0, 35).m_171488_(-3.0F, -25.9352F, -4.9565F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.5F, 13.7166F, -10.9557F, -0.2182F, 0.0F, 0.0F));
      Body.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(0, 35).m_171480_().m_171488_(-7.91F, -24.6382F, -4.7804F, 2.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 35).m_171488_(5.91F, -24.6382F, -4.7804F, 2.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(4, 55).m_171488_(-3.0F, -7.6382F, 0.2196F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(2, 53).m_171488_(-4.0F, -9.6382F, -0.7804F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 35).m_171488_(-6.0F, -26.6382F, -6.7804F, 12.0F, 17.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 15.2312F, 6.4029F, 0.48F, 0.0F, 0.0F));
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-4.0F, -5.9446F, -6.9432F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(1, 46).m_171488_(-3.0F, -6.9446F, -5.9432F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 57).m_171488_(-2.5F, 1.5554F, -6.9432F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).m_171514_(0, 57).m_171488_(-2.5F, 0.0554F, -5.9432F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(56, 5).m_171488_(-2.0F, -0.8446F, -6.2432F, 4.0F, 3.0F, 0.0F, new CubeDeformation(-0.5F)).m_171514_(0, 57).m_171488_(-3.5F, 0.0554F, -6.9432F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 57).m_171480_().m_171488_(1.5F, 0.0554F, -6.9432F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(48, 0).m_171488_(-1.0F, -3.8446F, -7.9432F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(48, 0).m_171488_(-1.0F, -1.6446F, -7.9432F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(48, 3).m_171488_(-1.0F, -2.4446F, -7.9432F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).m_171514_(48, 0).m_171480_().m_171488_(-3.5F, -1.6442F, -7.4571F, 7.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(48, 3).m_171480_().m_171488_(-3.5F, -2.1442F, -7.4571F, 7.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(1.5F, -3.0442F, -7.0571F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-2.5F, -3.0442F, -7.0571F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(48, 0).m_171480_().m_171488_(-3.5F, -3.645F, -7.4571F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.11F)).m_171555_(false).m_171514_(48, 0).m_171480_().m_171488_(2.5F, -3.645F, -7.4571F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.11F)).m_171555_(false).m_171514_(48, 0).m_171480_().m_171488_(-3.5F, -3.645F, -7.4571F, 7.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(48, 0).m_171480_().m_171488_(-1.5F, -3.645F, -7.4571F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.11F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, -3.5F));
      PartDefinition Hair = Head.m_171599_("Hair", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.0F, -0.4446F, -5.9432F));
      Hair.m_171599_("Hair_r1", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-9.0F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, -2.8233F, 14.0558F, 0.0F, -1.7453F, -1.5708F));
      Hair.m_171599_("Hair_r2", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171480_().m_171488_(-2.5F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.1256F, -1.1542F, 5.341F, 0.0F, 1.2217F, -0.1745F));
      Hair.m_171599_("Hair_r3", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171488_(-2.5F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(7.1256F, -1.1542F, 5.341F, 0.0F, -1.2217F, 0.1745F));
      Hair.m_171599_("Hair_r4", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171488_(-0.0905F, -4.5209F, -0.513F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(5.8F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.1745F));
      Hair.m_171599_("Hair_r5", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171488_(3.1F, -2.6F, -3.1F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, -0.8209F, -0.613F, 0.0F, -0.7854F, -0.6981F));
      Hair.m_171599_("Hair_r6", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171480_().m_171488_(-4.9095F, -4.5209F, -0.513F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.2F, 0.0F, 0.0F, 0.0F, 0.7854F, -0.1745F));
      Hair.m_171599_("Hair_r7", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171480_().m_171488_(-8.1F, -2.6F, -3.1F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.0F, -0.8209F, -0.613F, 0.0F, 0.7854F, 0.6981F));
      Hair.m_171599_("Hair_r8", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171488_(-2.5F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, -5.7556F, 4.8719F, 0.0F, -1.3963F, -1.5708F));
      Hair.m_171599_("Hair_r9", CubeListBuilder.m_171558_().m_171514_(33, 0).m_171488_(3.1F, -4.0F, -3.5F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, -0.8209F, -0.613F, 0.0F, -0.7854F, -1.5708F));
      Hair.m_171599_("Hair_r10", CubeListBuilder.m_171558_().m_171514_(35, 0).m_171480_().m_171488_(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.0F, 2.3569F, -1.2211F, 0.0F, -0.5236F, -2.3562F));
      Hair.m_171599_("Hair_r11", CubeListBuilder.m_171558_().m_171514_(35, 0).m_171488_(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 2.3569F, -1.2211F, 0.0F, 0.5236F, 2.3562F));
      Hair.m_171599_("Hair_r12", CubeListBuilder.m_171558_().m_171514_(35, 0).m_171488_(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, 2.9239F, -1.4711F, 0.0F, 0.5236F, 1.5708F));
      Hair.m_171599_("Hair_r13", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-4.5F, -3.0F, -1.6F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, 6.2913F, 0.9183F, 0.0F, 0.0436F, 1.5708F));
      Hair.m_171599_("Hair_r14", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-4.5F, -3.0F, -1.6F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, -6.9021F, 0.5183F, 0.0F, 0.0436F, -1.5708F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
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
      this.RightArm.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
