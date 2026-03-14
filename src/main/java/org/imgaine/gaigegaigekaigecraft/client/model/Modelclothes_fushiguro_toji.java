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

public class Modelclothes_fushiguro_toji<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_fushiguro_toji"), "main");
   public final ModelPart body;
   public final ModelPart himo;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart steve;

   public Modelclothes_fushiguro_toji(ModelPart root) {
      this.body = root.m_171324_("body");
      this.himo = this.body.m_171324_("himo");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.steve = root.m_171324_("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition himo = body.m_171599_("himo", CubeListBuilder.m_171558_().m_171514_(26, 25).m_171488_(-3.0F, -0.85F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(26, 25).m_171488_(-3.0F, -0.55F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(26, 25).m_171480_().m_171488_(-3.0F, -0.55F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(26, 25).m_171480_().m_171488_(-3.0F, -0.85F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171419_(2.5F, 11.9F, 0.0F));
      himo.m_171599_("right_himo_r1", CubeListBuilder.m_171558_().m_171514_(26, 25).m_171480_().m_171488_(-0.9907F, -1.7169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).m_171555_(false).m_171514_(26, 25).m_171480_().m_171488_(-0.9907F, -2.1169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(-3.3695F, 1.2169F, -2.0822F, 0.0F, 0.1745F, 0.0F));
      himo.m_171599_("right_himo_r2", CubeListBuilder.m_171558_().m_171514_(26, 27).m_171480_().m_171488_(-0.3F, -2.0F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)).m_171555_(false), PartPose.m_171423_(-3.56F, 1.3471F, -3.5724F, -0.0872F, 0.0F, 0.0436F));
      himo.m_171599_("right_himo_r3", CubeListBuilder.m_171558_().m_171514_(26, 27).m_171480_().m_171488_(-0.5F, -2.2F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)).m_171555_(false), PartPose.m_171423_(-3.56F, 1.3471F, -3.5724F, -0.0872F, 0.0F, 0.2618F));
      himo.m_171599_("right_himo_r4", CubeListBuilder.m_171558_().m_171514_(26, 27).m_171480_().m_171488_(-0.8F, -2.4F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)).m_171555_(false), PartPose.m_171423_(-3.56F, 1.3471F, -3.5424F, -0.0872F, 0.0F, 0.2618F));
      himo.m_171599_("left_himo_r1", CubeListBuilder.m_171558_().m_171514_(26, 27).m_171488_(-1.2F, -2.4F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(-1.44F, 1.3471F, -3.5424F, -0.0872F, 0.0F, -0.2618F));
      himo.m_171599_("left_himo_r2", CubeListBuilder.m_171558_().m_171514_(26, 27).m_171488_(-1.5F, -2.2F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(-1.44F, 1.3471F, -3.5724F, -0.0872F, 0.0F, -0.2618F));
      himo.m_171599_("left_himo_r3", CubeListBuilder.m_171558_().m_171514_(26, 27).m_171488_(-1.7F, -2.0F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(-1.44F, 1.3471F, -3.5724F, -0.0872F, 0.0F, -0.0436F));
      himo.m_171599_("left_himo_r4", CubeListBuilder.m_171558_().m_171514_(26, 25).m_171488_(-1.0093F, -2.1169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).m_171514_(26, 25).m_171488_(-1.0093F, -1.7169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(-1.6305F, 1.2169F, -2.0822F, 0.0F, -0.1745F, 0.0F));
      partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -0.0648F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).m_171514_(8, 4).m_171480_().m_171488_(-1.5F, 7.3904F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false).m_171514_(8, 4).m_171480_().m_171488_(-1.5F, 7.3904F, 2.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      right_leg.m_171599_("right_leg_r1", CubeListBuilder.m_171558_().m_171514_(6, 3).m_171480_().m_171488_(-3.5F, -0.5F, -1.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(2.0F, 7.1177F, 2.5965F, -1.1781F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r2", CubeListBuilder.m_171558_().m_171514_(6, 3).m_171480_().m_171488_(-3.5F, -0.5F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(2.0F, 7.1177F, -2.5965F, 1.1781F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.4F, -12.0F, 1.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.9F, 12.1932F, 0.5763F, 0.0873F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r4", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -4.2324F, 2.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(1.9F, 8.3144F, -1.9672F, -0.9599F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r5", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(2.1141F, 6.9006F, -1.5013F, 0.9599F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1141F, 5.9006F, -1.5013F, -0.0873F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r7", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 1.4898F, -0.8631F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(2.1141F, 5.9006F, -1.5013F, 0.0F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r8", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(2.1141F, 5.9006F, -1.5013F, 0.9599F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1141F, 5.9006F, 1.5013F, 0.0873F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.397F, 11.9812F, -1.9F, 0.0F, -1.5708F, -0.0873F));
      right_leg.m_171599_("right_leg_r11", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.0754F, 9.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      right_leg.m_171599_("right_leg_r12", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(2.1141F, 6.9006F, 1.5013F, -0.9599F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r13", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 1.4898F, -0.1369F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(2.1141F, 5.9006F, 1.5013F, 0.0F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r14", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -4.6096F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(-0.0333F, 12.0F, -1.9F, 0.0F, -1.5708F, 0.0F));
      right_leg.m_171599_("right_leg_r15", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.0754F, 9.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      right_leg.m_171599_("right_leg_r16", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(2.1141F, 5.9006F, 1.5013F, -0.9599F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r17", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false).m_171514_(8, 4).m_171480_().m_171488_(-0.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, 1.5013F, -0.9599F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r18", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 0.4898F, -0.1369F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, 1.5013F, 0.0F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, 1.5013F, 0.0873F, -0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, -1.5013F, -0.0873F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r21", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false).m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, -1.5013F, 0.9599F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r22", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 0.4898F, -0.8631F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, -1.5013F, 0.0F, 0.7854F, 0.0F));
      right_leg.m_171599_("right_leg_r23", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.0754F, 8.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      right_leg.m_171599_("right_leg_r24", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.0754F, 9.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      right_leg.m_171599_("right_leg_r25", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -5.6096F, -3.2529F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(0.0333F, 12.0F, -1.9F, 0.0F, 1.5708F, 0.0F));
      right_leg.m_171599_("right_leg_r26", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-0.47F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0538F, 8.9677F, 2.1F, -1.3526F, 0.7854F, 3.1416F));
      right_leg.m_171599_("right_leg_r27", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.53F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.0538F, 8.9677F, 2.1F, -1.3526F, -0.7854F, -3.1416F));
      right_leg.m_171599_("right_leg_r28", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.53F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.0538F, 8.9677F, -2.1F, 1.3526F, 0.7854F, -3.1416F));
      right_leg.m_171599_("right_leg_r29", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-0.47F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0538F, 8.9677F, -2.1F, 1.3526F, -0.7854F, 3.1416F));
      right_leg.m_171599_("right_leg_r30", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0538F, 8.7677F, 0.0F, 0.0F, -1.5708F, -1.789F));
      right_leg.m_171599_("right_leg_r31", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.0538F, 8.7677F, 0.0F, 0.0F, 1.5708F, 1.789F));
      right_leg.m_171599_("right_leg_r32", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.397F, 11.9812F, -1.9F, 0.0F, 1.5708F, 0.0873F));
      right_leg.m_171599_("right_leg_r33", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-1.4333F, -2.4051F, -0.9446F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.0667F, 8.7676F, 0.0F, -1.789F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r34", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-1.4333F, -2.4051F, -0.0554F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.0667F, 8.7676F, 0.0F, 1.789F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r35", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -4.2324F, -3.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(1.9F, 8.3144F, 1.9672F, 0.9599F, 0.0F, 0.0F));
      right_leg.m_171599_("right_leg_r36", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.4F, -12.0F, -2.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.9F, 12.1932F, -0.5763F, -0.0873F, 0.0F, 0.0F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-2.0F, -0.0648F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).m_171555_(false).m_171514_(8, 4).m_171488_(-1.5F, 7.3904F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171514_(8, 4).m_171488_(-1.5F, 7.3904F, 2.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      left_leg.m_171599_("left_leg_r1", CubeListBuilder.m_171558_().m_171514_(6, 3).m_171488_(0.5F, -0.5F, -1.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-2.0F, 7.1177F, 2.5965F, -1.1781F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r2", CubeListBuilder.m_171558_().m_171514_(6, 3).m_171488_(0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-2.0F, 7.1177F, -2.5965F, 1.1781F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.4F, -12.0F, 1.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.9F, 12.1932F, 0.5763F, 0.0873F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r4", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -4.2324F, 2.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-1.9F, 8.3144F, -1.9672F, -0.9599F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r5", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 6.9006F, -1.5013F, 0.9599F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, -1.5013F, -0.0873F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r7", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 1.4898F, -0.8631F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, -1.5013F, 0.0F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r8", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, -1.5013F, 0.9599F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, 1.5013F, 0.0873F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.397F, 11.9812F, -1.9F, 0.0F, 1.5708F, 0.0873F));
      left_leg.m_171599_("left_leg_r11", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.0754F, 9.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      left_leg.m_171599_("left_leg_r12", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 6.9006F, 1.5013F, -0.9599F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r13", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 1.4898F, -0.1369F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, 1.5013F, 0.0F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r14", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -4.6096F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(0.0333F, 12.0F, -1.9F, 0.0F, 1.5708F, 0.0F));
      left_leg.m_171599_("left_leg_r15", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-3.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.0754F, 9.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      left_leg.m_171599_("left_leg_r16", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-2.1141F, 5.9006F, 1.5013F, -0.9599F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r17", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171514_(8, 4).m_171488_(-1.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(2.1141F, 5.9006F, 1.5013F, -0.9599F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r18", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 0.4898F, -0.1369F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(2.1141F, 5.9006F, 1.5013F, 0.0F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1141F, 5.9006F, 1.5013F, 0.0873F, 0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1141F, 5.9006F, -1.5013F, -0.0873F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r21", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171514_(8, 4).m_171488_(-1.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(2.1141F, 5.9006F, -1.5013F, 0.9599F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r22", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, 0.4898F, -0.8631F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(2.1141F, 5.9006F, -1.5013F, 0.0F, -0.7854F, 0.0F));
      left_leg.m_171599_("left_leg_r23", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.0754F, 8.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      left_leg.m_171599_("left_leg_r24", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.0754F, 9.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      left_leg.m_171599_("left_leg_r25", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -5.6096F, -3.2529F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(-0.0333F, 12.0F, -1.9F, 0.0F, -1.5708F, 0.0F));
      left_leg.m_171599_("left_leg_r26", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.53F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.0538F, 8.9677F, 2.1F, -1.3526F, -0.7854F, -3.1416F));
      left_leg.m_171599_("left_leg_r27", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-0.47F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0538F, 8.9677F, 2.1F, -1.3526F, 0.7854F, 3.1416F));
      left_leg.m_171599_("left_leg_r28", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-0.47F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0538F, 8.9677F, -2.1F, 1.3526F, -0.7854F, 3.1416F));
      left_leg.m_171599_("left_leg_r29", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-0.53F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.0538F, 8.9677F, -2.1F, 1.3526F, 0.7854F, -3.1416F));
      left_leg.m_171599_("left_leg_r30", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171480_().m_171488_(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.0538F, 8.7677F, 0.0F, 0.0F, 1.5708F, 1.789F));
      left_leg.m_171599_("left_leg_r31", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0538F, 8.7677F, 0.0F, 0.0F, -1.5708F, -1.789F));
      left_leg.m_171599_("left_leg_r32", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.397F, 11.9812F, -1.9F, 0.0F, -1.5708F, -0.0873F));
      left_leg.m_171599_("left_leg_r33", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5667F, -2.4051F, -0.9446F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0667F, 8.7676F, 0.0F, -1.789F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r34", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(-1.5667F, -2.4051F, -0.0554F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0667F, 8.7676F, 0.0F, 1.789F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r35", CubeListBuilder.m_171558_().m_171514_(8, 4).m_171488_(0.4F, -4.2324F, -3.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-1.9F, 8.3144F, 1.9672F, 0.9599F, 0.0F, 0.0F));
      left_leg.m_171599_("left_leg_r36", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.4F, -12.0F, -2.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.9F, 12.1932F, -0.5763F, -0.0873F, 0.0F, 0.0F));
      partdefinition.m_171599_("steve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(40, 16).m_171480_().m_171488_(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(40, 16).m_171488_(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171480_().m_171488_(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 16).m_171488_(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
