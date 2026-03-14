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

public class ModelRoundDeer<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_round_deer"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart Tail;

   public ModelRoundDeer(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.Tail = root.m_171324_("Tail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -14.0F, -25.0F));
      Head.m_171599_("HeadMain_r1", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-3.5F, -3.0F, -8.0F, 7.0F, 8.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -0.0573F, 0.0083F, -0.5236F, 0.0F, 0.0F));
      Head.m_171599_("HeadMain_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -0.5622F, -9.4724F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)).m_171514_(0, 0).m_171488_(-3.0F, -0.5622F, -9.4724F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 12).m_171488_(-4.0F, -2.5622F, -3.4724F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.4378F, -7.5276F, 0.7854F, 0.0F, 0.0F));
      Head.m_171599_("HeadMain_r3", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171480_().m_171488_(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(2.5F, -6.8046F, -6.9056F, 0.0F, -0.3927F, 0.0F));
      Head.m_171599_("HeadMain_r4", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.5F, -6.8046F, -6.9056F, 0.0F, 0.3927F, 0.0F));
      Head.m_171599_("HeadMain_r5", CubeListBuilder.m_171558_().m_171514_(1, 15).m_171488_(-3.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(6.8349F, -6.5465F, -6.8449F, 0.7854F, 0.0F, -0.5236F));
      Head.m_171599_("HeadMain_r6", CubeListBuilder.m_171558_().m_171514_(1, 15).m_171480_().m_171488_(2.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(-6.8349F, -6.5465F, -6.8449F, 0.7854F, 0.0F, 0.5236F));
      PartDefinition LeftHorn = Head.m_171599_("LeftHorn", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.8349F, -6.5465F, -1.8449F));
      LeftHorn.m_171599_("LeftHorn_r1", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(-4.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, -5.0F, 0.7854F, 0.0F, -0.5236F));
      LeftHorn.m_171599_("LeftHorn_r2", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(-1.1F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.1962F, -2.3F, -5.1F, 1.0151F, -0.2915F, -0.993F));
      LeftHorn.m_171599_("LeftHorn_r3", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(4.7F, 2.5F, -3.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(19, 0).m_171488_(2.5F, 0.7F, -1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, -0.6109F));
      LeftHorn.m_171599_("LeftHorn_r4", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(1.8F, -0.5F, -0.6F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, 0.0873F));
      LeftHorn.m_171599_("LeftHorn_r5", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(-1.4F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1962F, -2.0F, -5.0F, 1.0151F, -0.2915F, -0.993F));
      LeftHorn.m_171599_("LeftHorn_r6", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(-1.4F, 0.5F, -1.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1962F, -2.0F, -5.0F, 0.2124F, 0.4495F, -0.1289F));
      LeftHorn.m_171599_("LeftHorn_r7", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171488_(-2.0F, -0.1F, -0.9F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, -0.2182F));
      PartDefinition RightHorn = Head.m_171599_("RightHorn", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.8349F, -6.5465F, -1.8449F));
      RightHorn.m_171599_("RightHorn_r1", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-2.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, -5.0F, 0.7854F, 0.0F, 0.5236F));
      RightHorn.m_171599_("RightHorn_r2", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-2.9F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-6.1962F, -2.3F, -5.1F, 1.0151F, 0.2915F, 0.993F));
      RightHorn.m_171599_("RightHorn_r3", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-9.7F, 2.5F, -3.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(19, 0).m_171480_().m_171488_(-7.5F, 0.7F, -1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, 0.6109F));
      RightHorn.m_171599_("RightHorn_r4", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-6.8F, -0.5F, -0.6F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, -0.0873F));
      RightHorn.m_171599_("RightHorn_r5", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-2.6F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1962F, -2.0F, -5.0F, 1.0151F, 0.2915F, 0.993F));
      RightHorn.m_171599_("RightHorn_r6", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-2.6F, 0.5F, -1.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1962F, -2.0F, -5.0F, 0.2124F, -0.4495F, 0.1289F));
      RightHorn.m_171599_("RightHorn_r7", CubeListBuilder.m_171558_().m_171514_(19, 0).m_171480_().m_171488_(-3.0F, -0.1F, -0.9F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, 0.2182F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(1, 89).m_171488_(-10.6F, -19.0571F, -22.0196F, 19.0F, 20.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(20, 101).m_171488_(-8.6F, -20.5571F, -25.0196F, 15.0F, 17.0F, 6.0F, new CubeDeformation(-0.01F)).m_171514_(9, 90).m_171488_(-8.6F, -17.0571F, -3.0196F, 15.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)).m_171514_(13, 93).m_171488_(-6.1F, -1.5452F, -3.7279F, 10.0F, 3.0F, 15.0F, new CubeDeformation(-0.1F)).m_171514_(16, 98).m_171488_(-5.1F, 2.9429F, -18.0196F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(9, 91).m_171488_(-6.1F, 0.9429F, -20.0196F, 10.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(16, 94).m_171488_(-6.6F, -21.0571F, -3.0196F, 11.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(19, 95).m_171488_(-6.6F, -25.9571F, -19.0196F, 11.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.1F, 1.6423F, 7.5809F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(23, 102).m_171488_(-4.0F, -7.5F, -3.0F, 8.0F, 13.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-1.1F, -17.3625F, -28.8436F, -1.5708F, 0.0F, 0.0F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(18, 97).m_171488_(-6.5F, -8.7F, 7.0F, 13.0F, 10.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-1.1F, -15.6996F, -29.5727F, -1.1781F, 0.0F, 0.0F));
      Body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(42, 47).m_171480_().m_171488_(-4.5F, -5.0F, -6.0F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.7F, -12.6336F, -28.7425F, -0.5148F, -0.1954F, 0.1268F));
      Body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(0, 47).m_171488_(-4.5F, -5.0F, -6.0F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5F, -12.6336F, -28.7425F, -0.5148F, 0.1954F, -0.1268F));
      Body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(21, 97).m_171488_(-2.0F, -4.0F, -5.0F, 6.0F, 8.0F, 11.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-1.6F, -21.6891F, -4.6422F, 1.5708F, 0.7854F, 1.5708F));
      Body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(21, 97).m_171488_(-2.0F, -4.0F, -6.0F, 5.0F, 8.0F, 11.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-1.6F, -21.3891F, -20.4196F, -1.5708F, -0.7854F, 1.5708F));
      Body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(20, 96).m_171480_().m_171488_(-2.0F, -6.0F, -6.0F, 4.0F, 8.0F, 12.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(5.7F, -19.7571F, -13.0196F, 0.0F, 0.0F, -0.5236F));
      Body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(20, 96).m_171488_(-2.0F, -6.0F, -6.0F, 4.0F, 8.0F, 12.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-7.9F, -19.7571F, -13.0196F, 0.0F, 0.0F, 0.5236F));
      Body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(25, 103).m_171488_(-5.5F, -2.0F, -3.0F, 10.0F, 4.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(-0.6F, -17.0571F, 11.6804F, -0.7854F, 0.0F, 0.0F));
      Body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(11, 89).m_171480_().m_171488_(-1.5F, -2.0F, -12.0F, 3.0F, 5.0F, 19.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(3.9F, -18.6571F, 3.9804F, 0.0F, 0.0F, -0.4363F));
      Body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(11, 89).m_171488_(-1.5F, -2.0F, -12.0F, 3.0F, 5.0F, 19.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-6.1F, -18.6571F, 3.9804F, 0.0F, 0.0F, 0.4363F));
      Body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(21, 105).m_171488_(-4.0F, -9.5F, -2.0F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.6783F, -9.0571F, -2.251F, 0.0F, 1.0472F, 0.0F));
      Body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(21, 105).m_171480_().m_171488_(-2.0F, -9.5F, -2.0F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-7.8783F, -9.0571F, -2.251F, 0.0F, -1.0472F, 0.0F));
      Body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(0, 69).m_171480_().m_171488_(-1.5F, -8.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.21F)).m_171555_(false), PartPose.m_171423_(-8.5F, -11.2571F, -22.8196F, 0.0F, -0.5672F, 0.0F));
      Body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(0, 69).m_171488_(-1.5F, -8.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.21F)), PartPose.m_171423_(6.3F, -11.2571F, -22.8196F, 0.0F, 0.5672F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171480_().m_171488_(-2.9903F, 17.418F, -0.6243F, 3.0F, 11.0F, 4.0F, new CubeDeformation(-0.01F)).m_171555_(false).m_171514_(90, 100).m_171480_().m_171488_(-3.4855F, 28.0549F, -1.6261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(-6.563F, -6.2963F, -11.2139F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171480_().m_171488_(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.0451F, -2.3424F, -0.6891F, 0.1309F, 0.0F, 0.2182F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171480_().m_171488_(-4.0382F, -5.0473F, -4.75F, 9.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.6162F, 5.1686F, 0.0405F, 0.1309F, 0.0F, 0.0F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171480_().m_171488_(-2.5F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1969F, 12.6793F, 0.7667F, 0.0873F, 0.0F, -0.0873F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171488_(-0.0097F, 17.418F, -0.6243F, 3.0F, 11.0F, 4.0F, new CubeDeformation(-0.01F)).m_171514_(90, 100).m_171488_(-0.5145F, 28.0549F, -1.6261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(6.563F, -6.2963F, -11.2139F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171488_(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0451F, -2.3424F, -0.6891F, 0.1309F, 0.0F, -0.2182F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171488_(-4.9618F, -5.0473F, -4.75F, 9.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.6162F, 5.1686F, 0.0405F, 0.1309F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(90, 107).m_171488_(-2.5F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1969F, 12.6793F, 0.7667F, 0.0873F, 0.0F, 0.0873F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(97, 79).m_171480_().m_171488_(-3.4819F, -0.8615F, -4.3304F, 6.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(98, 80).m_171480_().m_171488_(-2.0594F, 15.4691F, 1.521F, 4.0F, 13.0F, 4.0F, new CubeDeformation(-0.21F)).m_171555_(false).m_171514_(90, 100).m_171480_().m_171488_(-2.0594F, 26.8459F, 0.685F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-5.2529F, -4.8459F, 16.3573F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(97, 79).m_171480_().m_171488_(-7.7348F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(5.2529F, 13.5907F, 1.3964F, 0.3927F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(97, 79).m_171480_().m_171488_(-8.8224F, -5.4157F, -3.7353F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.2529F, 1.1839F, 0.1175F, 0.0F, 0.0F, 0.1745F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(97, 79).m_171488_(-2.5181F, -0.8615F, -4.3304F, 6.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(98, 80).m_171488_(-1.9406F, 15.4691F, 1.521F, 4.0F, 13.0F, 4.0F, new CubeDeformation(-0.21F)).m_171514_(90, 100).m_171488_(-1.9406F, 26.8459F, 0.685F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(5.2529F, -4.8459F, 16.3573F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(97, 79).m_171488_(2.7348F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-5.2529F, 13.5907F, 1.3964F, 0.3927F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(97, 79).m_171488_(3.8224F, -5.4157F, -3.7353F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.2529F, 1.1839F, 0.1175F, 0.0F, 0.0F, -0.1745F));
      PartDefinition Tail = partdefinition.m_171599_("Tail", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.2F, -1.5F, 14.38F));
      Tail.m_171599_("Tail_r1", CubeListBuilder.m_171558_().m_171514_(63, 96).m_171488_(-2.0F, -1.1F, 3.7F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.2F, -9.8266F, 10.124F, -1.3526F, 0.0F, 0.0F));
      Tail.m_171599_("Tail_r2", CubeListBuilder.m_171558_().m_171514_(62, 96).m_171488_(-2.5F, 0.0F, -4.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.2F, -9.8266F, 10.124F, -1.0472F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
