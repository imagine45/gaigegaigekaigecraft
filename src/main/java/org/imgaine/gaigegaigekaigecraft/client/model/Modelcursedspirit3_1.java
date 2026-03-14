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

public class Modelcursedspirit3_1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_1"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_1(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-10.0F, -4.8133F, -4.3021F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(0.0F, -4.8133F, -4.3021F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-5.5F, -10.8133F, -8.3021F, 11.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(2, 41).m_171488_(-3.5F, -10.8133F, -8.3021F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.1F)).m_171514_(40, 29).m_171488_(4.0F, -11.0133F, -10.3021F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.7F)).m_171514_(40, 29).m_171480_().m_171488_(-10.0F, -11.0133F, -10.3021F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.7F)).m_171555_(false).m_171514_(0, 59).m_171488_(-5.0F, -0.8133F, -8.3021F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(58, 51).m_171488_(-5.6F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(58, 51).m_171480_().m_171488_(3.6F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(58, 51).m_171488_(-3.3F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(58, 51).m_171488_(1.3F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(58, 51).m_171488_(-1.0F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(36, 56).m_171488_(-5.0F, -4.8133F, -8.3021F, 10.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F)).m_171514_(0, 0).m_171488_(-10.0F, -4.8133F, -8.3021F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(5.0F, -4.8133F, -8.3021F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -0.1867F, 2.8021F));
      Head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.6F, -4.4133F, -8.6021F, -0.3927F, 0.1745F, -0.3491F));
      Head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.6F, -4.4133F, -8.6021F, -0.3927F, -0.1745F, 0.3491F));
      Head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-8.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-10.9F, -3.6633F, -0.3021F, -2.3562F, -1.1781F, -2.8798F));
      Head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-5.2629F, -2.145F, -0.2039F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-10.9F, -3.6633F, -1.3021F, 2.7489F, 1.3963F, -2.8798F));
      Head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-8.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-10.9F, -3.6633F, -0.3021F, 2.3562F, 1.1781F, -2.8798F));
      Head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.6779F, -6.4208F, -8.5392F, -0.3359F, 0.1099F, 1.2499F));
      Head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-1.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.6779F, -6.4208F, -8.5392F, -0.3359F, -0.1099F, -1.2499F));
      Head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.2779F, -11.2057F, -4.0392F, 1.2217F, 1.1781F, 3.1416F));
      Head.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.2779F, -11.2057F, -4.0392F, 1.2217F, -1.1781F, -3.1416F));
      Head.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-8.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.9F, -6.6633F, -0.3021F, -2.3562F, -1.1781F, -2.4871F));
      Head.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-8.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.9F, -7.6633F, -0.3021F, 2.3562F, 1.1781F, -2.4871F));
      Head.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.2781F, -2.2114F, -0.0434F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.9F, -7.6633F, -0.3021F, 2.7489F, 1.3963F, -2.4871F));
      Head.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(0.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.9F, -7.6633F, -0.3021F, 2.3562F, -1.1781F, 2.4871F));
      Head.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(0.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.9F, -6.6633F, -0.3021F, -2.3562F, 1.1781F, 2.4871F));
      Head.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-3.7219F, -2.2114F, -0.0434F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.9F, -7.6633F, -0.3021F, 2.7489F, -1.3963F, 2.4871F));
      Head.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-2.7371F, -2.145F, -0.2039F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(10.9F, -3.6633F, -1.3021F, 2.7489F, -1.3963F, 2.8798F));
      Head.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(0.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(10.9F, -3.6633F, -0.3021F, -2.3562F, 1.1781F, 2.8798F));
      Head.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(0.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(10.9F, -3.6633F, -0.3021F, 2.3562F, -1.1781F, 2.8798F));
      Head.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(56, 51).m_171488_(-5.45F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(58, 51).m_171488_(-2.15F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(58, 51).m_171488_(0.15F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(56, 51).m_171488_(2.45F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -3.8133F, -7.6021F, 0.0F, 0.0F, -3.1416F));
      Head.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.0F, -3.3F, -7.5F, 5.0F, 8.0F, 15.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(5.8939F, -7.1467F, -0.8021F, 0.0F, 0.0F, -0.6109F));
      Head.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.3F, -7.5F, 5.0F, 8.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-5.8939F, -7.1467F, -0.8021F, 0.0F, 0.0F, 0.6109F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, -12.0F, -1.0F, 8.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(0.0F, -12.0F, -1.0F, 8.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-12.0F, -24.0F, -2.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(0.0F, -24.0F, -2.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 24.0F, -4.0F));
      Body.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.0F, -11.1F, 15.1F, 0.7854F, -0.3927F, 0.0F));
      Body.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-5.0F, -10.6F, 15.3F, 0.3927F, -0.1745F, 0.0F));
      Body.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.0F, -11.1F, 15.1F, 0.7854F, 0.3927F, 0.0F));
      Body.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.0F, -10.6F, 15.3F, 0.3927F, 0.1745F, 0.0F));
      Body.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.0F, -11.1F, -2.1F, -0.7854F, -0.3927F, 0.0F));
      Body.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-2.013F, -2.3642F, -0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, -16.85F, 15.2F, 0.3927F, -0.1745F, 0.0F));
      Body.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.0F, -16.6F, 15.3F, 0.3927F, 0.1745F, 0.0F));
      Body.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, -16.85F, -2.2F, -0.3927F, 0.1745F, 0.0F));
      Body.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.0F, -16.6F, -2.3F, -0.3927F, -0.1745F, 0.0F));
      Body.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.0F, -10.6F, -2.3F, -0.3927F, -0.1745F, 0.0F));
      Body.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.0F, -11.1F, -2.1F, -0.7854F, 0.3927F, 0.0F));
      Body.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-7.0F, -10.85F, -2.2F, -0.3927F, 0.1745F, 0.0F));
      Body.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.0F, -23.1F, 15.1F, 0.7854F, 0.3927F, 0.0F));
      Body.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.0F, -23.1F, 15.1F, 0.7854F, -0.3927F, 0.0F));
      Body.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-5.0F, -22.6F, 15.3F, 0.3927F, -0.1745F, 0.0F));
      Body.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.0F, -22.6F, 15.3F, 0.3927F, 0.1745F, 0.0F));
      Body.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.0F, -21.8F, -2.5F, -0.3927F, -0.0436F, 0.0F));
      Body.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-2.114F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.5F, -11.85F, 3.2F, -2.3562F, 1.1781F, 3.1416F));
      Body.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-5.987F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.5F, -11.85F, 8.8F, 2.7489F, -1.3963F, -3.1416F));
      Body.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-2.114F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.5F, -11.85F, 9.8F, 2.3562F, -1.1781F, 3.1416F));
      Body.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-5.886F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -11.85F, 3.2F, -2.3562F, -1.1781F, -3.1416F));
      Body.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -11.85F, 8.8F, 2.7489F, 1.3963F, 3.1416F));
      Body.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-5.886F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -11.85F, 9.8F, 2.3562F, 1.1781F, -3.1416F));
      Body.m_171599_("cube_r45", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-5.987F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.5F, -22.85F, 8.8F, 2.7489F, -1.3963F, -3.1416F));
      Body.m_171599_("cube_r46", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-2.114F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.5F, -22.85F, 3.2F, -2.3562F, 1.1781F, 3.1416F));
      Body.m_171599_("cube_r47", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-2.114F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.5F, -22.85F, 9.8F, 2.3562F, -1.1781F, 3.1416F));
      Body.m_171599_("cube_r48", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-5.886F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -22.85F, 3.2F, -2.3562F, -1.1781F, -3.1416F));
      Body.m_171599_("cube_r49", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-5.886F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -22.85F, 9.8F, 2.3562F, 1.1781F, -3.1416F));
      Body.m_171599_("cube_r50", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.0F, -21.8F, -2.5F, -0.3927F, 0.0436F, 0.0F));
      Body.m_171599_("cube_r51", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -22.85F, 8.8F, 2.7489F, 1.3963F, 3.1416F));
      Body.m_171599_("cube_r52", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-9.0F, -22.7F, -2.1F, -0.7854F, 0.3927F, 0.0F));
      Body.m_171599_("cube_r53", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171480_().m_171488_(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(9.0F, -22.7F, -2.1F, -0.7854F, -0.3927F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-9.8F, -0.7F, 2.0F));
      RightArm.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-1.3861F, 0.1325F, -1.5998F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 51).m_171488_(-1.5861F, -2.616F, -0.6801F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.1073F, 8.5479F, -11.4206F, 1.7453F, 0.0F, 0.0F));
      RightArm.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.436F, -4.5953F, 0.7537F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.8073F, 8.5479F, -11.4206F, 2.1817F, -0.1745F, 0.0F));
      RightArm.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.5584F, -4.8879F, 0.8602F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.0073F, 8.5479F, -11.4206F, 2.1817F, 0.1309F, 0.0F));
      RightArm.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.5446F, -4.8305F, 0.8393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.1073F, 8.5479F, -11.2206F, 2.1817F, 0.4363F, 0.0F));
      RightArm.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.5774F, -3.8983F, 0.682F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.0073F, 8.5479F, -11.4206F, 2.1817F, -0.6545F, 0.0F));
      RightArm.m_171599_("RightLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -4.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-2.7652F, 4.1076F, -2.8044F, 2.4871F, 1.0472F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(9.8F, -0.7F, 2.0F));
      LeftArm.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-1.6139F, 0.1325F, -1.5998F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 51).m_171480_().m_171488_(-1.4139F, -2.616F, -0.6801F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.1073F, 8.5479F, -11.4206F, 1.7453F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.564F, -4.5953F, 0.7537F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.8073F, 8.5479F, -11.4206F, 2.1817F, 0.1745F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.4416F, -4.8879F, 0.8602F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.0073F, 8.5479F, -11.4206F, 2.1817F, -0.1309F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.4554F, -4.8305F, 0.8393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.1073F, 8.5479F, -11.2206F, 2.1817F, -0.4363F, 0.0F));
      LeftArm.m_171599_("RightLeg_r6", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.4226F, -3.8983F, 0.682F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0073F, 8.5479F, -11.4206F, 2.1817F, 0.6545F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.0F, -4.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(2.7652F, 4.1076F, -2.8044F, 2.4871F, -1.0472F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(0.0F, 3.0025F, -14.3453F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-9.9F, 18.9975F, 2.4453F));
      RightLeg.m_171599_("RightLeg_r7", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(-3.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.1F, 4.0025F, -12.3453F, 0.0F, 0.3054F, 0.0F));
      RightLeg.m_171599_("RightLeg_r8", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.0F, 4.0025F, -12.3453F, 0.0F, -0.3054F, 0.0F));
      RightLeg.m_171599_("RightLeg_r9", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(-1.0F, -4.3526F, -3.131F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-0.4F, -3.6512F, -9.2608F, 0.1745F, 0.0F, -0.192F));
      RightLeg.m_171599_("RightLeg_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0642F, -0.3136F, -6.4905F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)).m_171514_(21, 46).m_171488_(-0.0642F, -8.3136F, -4.4905F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(-0.7802F, -5.6071F, -2.4482F, 1.0472F, 0.0873F, -0.192F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(-2.0F, 3.0025F, -14.3453F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(9.9F, 18.9975F, 2.4453F));
      LeftLeg.m_171599_("LeftLeg_r7", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.1F, 4.0025F, -12.3453F, 0.0F, -0.3054F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r8", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(-3.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.0F, 4.0025F, -12.3453F, 0.0F, 0.3054F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r9", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(-1.0F, -4.3526F, -3.131F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(0.4F, -3.6512F, -9.2608F, 0.1745F, 0.0F, 0.192F));
      LeftLeg.m_171599_("LeftLeg_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.9358F, -0.3136F, -6.4905F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)).m_171555_(false).m_171514_(21, 46).m_171480_().m_171488_(-1.9358F, -8.3136F, -4.4905F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.4F)).m_171555_(false), PartPose.m_171423_(0.7802F, -5.6071F, -2.4482F, 1.0472F, -0.0873F, 0.192F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
