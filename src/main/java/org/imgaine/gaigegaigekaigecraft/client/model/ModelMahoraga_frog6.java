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

public class ModelMahoraga_frog6<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_mahoraga_frog_6"), "main");
   public final ModelPart body;

   public ModelMahoraga_frog6(ModelPart root) {
      this.body = root.getChild("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, -5.0F));
      PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, -7.0F, -0.2618F, 0.0F, 0.0F));
      PartDefinition head1 = head.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.9888F, -11.7558F, -6.6826F, 14.0F, 4.0F, 13.0F, new CubeDeformation(0.11F)).mirror(false).texOffs(0, 0).addBox(-12.0584F, -5.4743F, -6.6826F, 24.0F, 6.0F, 13.0F, new CubeDeformation(0.1F)).texOffs(0, 0).addBox(-9.0584F, -2.4743F, -6.6826F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offset(-0.0112F, -3.5376F, -5.3345F));
      head1.addOrReplaceChild("head3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.8F, 2.0F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.0584F, 2.417F, -4.6829F, 1.6581F, 0.0F, 0.0F));
      head1.addOrReplaceChild("head3_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 0.7F, 0.1F, 18.0F, 2.0F, 0.0F, new CubeDeformation(0.2F)).texOffs(0, 0).addBox(-9.0F, -2.6F, 0.1F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.0584F, 2.4257F, -4.7826F, 0.0873F, 0.0F, 0.0F));
      head1.addOrReplaceChild("head2_r1", CubeListBuilder.create().texOffs(0, 110).addBox(-8.6F, -24.9919F, -7.8341F, 17.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 103).addBox(-11.6F, -28.9919F, -7.8341F, 23.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0112F, 27.7252F, 5.3158F, 0.0873F, 0.0F, 0.0F));
      head1.addOrReplaceChild("head1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.2948F, -32.5792F, -0.7984F, 5.0F, 9.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(11.6022F, 27.9308F, 6.7687F, 0.3334F, -0.9754F, -0.3962F));
      head1.addOrReplaceChild("head1_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.6471F, -32.4186F, -1.9856F, 5.0F, 9.0F, 8.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-10.9177F, 27.6338F, 7.9047F, 0.3334F, 0.9754F, 0.3962F));
      head1.addOrReplaceChild("head1_r3", CubeListBuilder.create().texOffs(0, 0).addBox(7.4F, -32.1784F, -16.1239F, 11.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.9111F, -13.4042F, 22.4681F, 0.8726F, 0.0F, 3.1416F));
      head1.addOrReplaceChild("head1_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-8.5314F, -1.1064F, -9.4649F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0029F, -2.7312F, -4.6131F, 0.07F, 0.6998F, -2.9297F));
      head1.addOrReplaceChild("head1_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(13.3267F, -30.9997F, -16.0332F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.9619F, -32.2909F, -11.1974F, -0.1138F, -0.6949F, -3.0686F));
      head1.addOrReplaceChild("head1_r6", CubeListBuilder.create().texOffs(0, 0).addBox(3.0457F, -30.9997F, -15.1334F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0474F, -33.6526F, 4.3623F, -0.1138F, 0.6949F, 3.0686F));
      head1.addOrReplaceChild("head1_r7", CubeListBuilder.create().texOffs(0, 0).addBox(2.4542F, -32.3989F, -16.0301F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6469F, -13.5308F, 21.5834F, 0.8461F, 0.6949F, 3.0686F));
      head1.addOrReplaceChild("head1_r8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(13.9182F, -33.1361F, -16.5463F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.6564F, -12.1692F, 6.0237F, 0.8461F, -0.6949F, -3.0686F));
      head1.addOrReplaceChild("head1_r9", CubeListBuilder.create().texOffs(0, 0).addBox(7.3F, -30.9997F, -17.0721F, 11.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.8109F, -33.4553F, 2.1073F, -0.0873F, 0.0F, 3.1416F));
      head1.addOrReplaceChild("head1_r10", CubeListBuilder.create().texOffs(0, 0).addBox(7.2941F, -42.495F, -12.0171F, 8.0F, 4.0F, 13.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-30.1435F, 10.0115F, 5.3345F, 0.0F, 0.0F, 0.8727F));
      head1.addOrReplaceChild("head1_r11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.8219F, -43.5674F, -12.0171F, 8.0F, 4.0F, 13.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(30.6839F, 11.0625F, 5.3345F, 0.0F, 0.0F, -0.8727F));
      head1.addOrReplaceChild("head1_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-0.9405F, -34.4129F, 0.6972F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)).texOffs(0, 0).addBox(-7.0875F, -34.4129F, 0.6972F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0112F, 13.3937F, -17.1193F, -0.733F, 0.0F, 0.0F));
      head1.addOrReplaceChild("head1_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-6.9405F, -34.1448F, 3.5904F, 14.0F, 4.0F, 11.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0483F, -11.1977F, -23.2198F, -1.5708F, 0.0F, 0.0F));
      head1.addOrReplaceChild("head1_r14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-12.2941F, -47.6075F, 2.3255F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(34.0228F, 5.2673F, -12.744F, -0.5713F, -0.5724F, -0.7003F));
      head1.addOrReplaceChild("head1_r15", CubeListBuilder.create().texOffs(0, 0).addBox(7.2941F, -47.6075F, 2.3255F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-34.0005F, 5.2673F, -12.744F, -0.5713F, 0.5724F, 0.7003F));
      head1.addOrReplaceChild("head1_r16", CubeListBuilder.create().texOffs(0, 0).addBox(3.6956F, -37.3418F, -16.1143F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-14.5815F, 1.2737F, 24.2963F, 0.8416F, -0.3346F, 0.2854F));
      head1.addOrReplaceChild("head1_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-2.8F, -2.0F, -0.8F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.09F)), PartPose.offsetAndRotation(9.1409F, -5.7259F, -5.98F, 1.2774F, -0.744F, -0.5135F));
      head1.addOrReplaceChild("head1_r18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.2F, -2.0F, -0.8F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.09F)).mirror(false), PartPose.offsetAndRotation(-9.1186F, -5.7259F, -5.98F, 1.2774F, 0.744F, 0.5135F));
      head1.addOrReplaceChild("head1_r19", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.6956F, -37.3418F, -16.1143F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(14.6038F, 1.2737F, 24.2963F, 0.8416F, 0.3346F, -0.2854F));
      head1.addOrReplaceChild("head1_r20", CubeListBuilder.create().texOffs(112, 0).mirror().addBox(-2.7695F, -37.9789F, -16.3127F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(9.0368F, 7.6273F, 25.796F, 0.9716F, 0.3449F, 0.4597F));
      head1.addOrReplaceChild("head1_r21", CubeListBuilder.create().texOffs(112, 0).addBox(-0.4114F, -37.9789F, -15.5605F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-7.6144F, 7.6273F, 25.796F, 0.9716F, -0.3449F, -0.4597F));
      head1.addOrReplaceChild("head1_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-4.3887F, -37.4789F, -17.9143F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.1001F, 4.5236F, 28.3094F, 0.8901F, 0.0F, 0.0F));
      head1.addOrReplaceChild("head2_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.4086F, 0.5187F, -1.8513F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false).texOffs(0, 87).mirror().addBox(-1.4086F, -0.9813F, -1.8513F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.9556F, -10.7229F, -7.0158F, 0.9741F, 0.4322F, -0.0276F));
      head1.addOrReplaceChild("head1_r23", CubeListBuilder.create().texOffs(112, 0).mirror().addBox(-0.3654F, -1.0408F, 0.1487F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-6.9556F, -10.7229F, -7.0158F, 0.9848F, 0.396F, -0.001F));
      head1.addOrReplaceChild("head1_r24", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5914F, 0.5187F, -1.8513F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 87).addBox(-2.5914F, -0.9813F, -1.8513F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9779F, -10.7229F, -7.0158F, 0.9741F, -0.4322F, 0.0276F));
      head1.addOrReplaceChild("head1_r25", CubeListBuilder.create().texOffs(112, 0).addBox(-1.6346F, -1.0408F, 0.1487F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(6.9779F, -10.7229F, -7.0158F, 0.9848F, -0.396F, 0.001F));
      head1.addOrReplaceChild("mouth1", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(6.8416F, -1.4743F, -1.6826F));
      head1.addOrReplaceChild("mouth2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-6.8192F, -1.4743F, -1.6826F));
      PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.7451F, -9.947F));
      head2.addOrReplaceChild("head2_r3", CubeListBuilder.create().texOffs(0, 103).addBox(-5.5F, -29.2997F, -15.972F, 11.0F, 4.0F, 21.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 26.0528F, 11.085F, 0.0873F, 0.0F, 0.0F));
      head2.addOrReplaceChild("head2_r4", CubeListBuilder.create().texOffs(0, 103).mirror().addBox(0.8543F, -29.2997F, -14.0333F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-4.1247F, 26.556F, 5.3362F, 0.1138F, -0.6949F, -0.073F));
      head2.addOrReplaceChild("head2_r5", CubeListBuilder.create().texOffs(0, 103).mirror().addBox(1.0182F, -31.4361F, -15.4463F, 9.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.5265F, 5.346F, 19.1976F, 1.0737F, -0.6949F, -0.073F));
      head2.addOrReplaceChild("head2_r6", CubeListBuilder.create().texOffs(0, 103).addBox(-10.0182F, -31.4361F, -15.4463F, 9.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5265F, 5.346F, 19.1976F, 1.0737F, 0.6949F, 0.073F));
      head2.addOrReplaceChild("head4_r1", CubeListBuilder.create().texOffs(0, 112).mirror().addBox(-4.5F, -1.0F, -6.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.744F, -2.2987F, -0.2461F, 0.3165F, -0.6384F, -0.399F));
      head2.addOrReplaceChild("head3_r3", CubeListBuilder.create().texOffs(0, 112).addBox(-4.5F, -1.0F, -6.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.744F, -2.2987F, -0.2461F, 0.3165F, 0.6384F, 0.399F));
      head2.addOrReplaceChild("head2_r7", CubeListBuilder.create().texOffs(0, 103).addBox(-9.4267F, -29.2997F, -14.9331F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(4.3756F, 26.4719F, 6.2967F, 0.1138F, 0.6949F, 0.073F));
      head2.addOrReplaceChild("head2_r8", CubeListBuilder.create().texOffs(0, 103).addBox(-5.5F, -30.4784F, -15.0239F, 11.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.4699F, 26.8749F, 1.0472F, 0.0F, 0.0F));
      head.addOrReplaceChild("tong", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -10.85F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.8F)).texOffs(0, 0).addBox(-0.5F, -0.5F, -10.85F, 1.0F, 1.0F, 1.0F, new CubeDeformation(1.25F)), PartPose.offset(0.0F, -5.0F, -3.65F));
      PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, -3.0F, 0.9599F, 0.0F, 0.0F));
      torso.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(61, 88).addBox(-10.7F, -8.5013F, -8.75F, 17.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 10.6013F, -0.35F, 0.2182F, 0.0F, 0.0F));
      torso.addOrReplaceChild("torso_r2", CubeListBuilder.create().texOffs(10, 37).addBox(-9.5F, -8.5F, -3.0F, 19.0F, 15.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 7.8801F, 8.7872F, 0.2182F, 0.0F, 0.0F));
      torso.addOrReplaceChild("torso_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-10.6083F, -12.6013F, -0.75F, 22.0F, 18.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 2).mirror().addBox(-17.6083F, -12.6013F, -0.75F, 23.0F, 18.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(11, 6).mirror().addBox(-13.6083F, 7.3987F, -0.75F, 21.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 102).mirror().addBox(-14.6083F, -12.6013F, -2.75F, 23.0F, 22.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(4, 4).mirror().addBox(-15.6083F, -12.6013F, 1.25F, 25.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1082F, 12.6013F, -4.35F, 0.2182F, 0.0F, 0.0F));
      PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-11.0F, -13.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(1, 37).mirror().addBox(-13.5405F, -2.9663F, -1.3292F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 3.9186F, -2.453F, -0.0272F, -0.147F, 0.3655F));
      PartDefinition right_arm2 = right_arm.addOrReplaceChild("right_arm2", CubeListBuilder.create(), PartPose.offset(-2.7926F, 6.0716F, -2.2583F));
      right_arm2.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-3.0F, -5.0F, -2.0F, 6.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0974F, 6.7173F, -2.4998F, -0.3491F, 0.0F, 0.0F));
      right_arm2.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(1, 37).mirror().addBox(-1.5F, -1.3916F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(1, 37).mirror().addBox(-1.5F, -1.3916F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.4399F, 14.32F, -9.5943F, 0.0873F, 0.3491F, 0.0F));
      right_arm2.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(1, 37).mirror().addBox(-1.4977F, -1.1072F, -2.7722F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 37).mirror().addBox(-1.5023F, -1.1072F, -3.7278F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.3355F, 14.0356F, -10.8463F, 0.0873F, 0.0F, 0.0F));
      right_arm2.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(1, 37).mirror().addBox(-1.5F, -1.1598F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 37).mirror().addBox(-1.5F, -1.1598F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(4.1449F, 14.0882F, -9.7608F, 0.0873F, -0.3491F, 0.0F));
      PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(11.0F, -13.0F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(1, 37).addBox(7.5405F, -2.9663F, -1.3292F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 3.9186F, -2.453F, -0.0272F, 0.147F, -0.3655F));
      PartDefinition left_arm2 = left_arm.addOrReplaceChild("left_arm2", CubeListBuilder.create(), PartPose.offset(2.7926F, 6.0716F, -2.2583F));
      left_arm2.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(0, 36).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0974F, 6.7173F, -2.4998F, -0.3491F, 0.0F, 0.0F));
      left_arm2.addOrReplaceChild("left_arm_r3", CubeListBuilder.create().texOffs(1, 37).addBox(-1.5F, -1.3916F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).texOffs(1, 37).addBox(-1.5F, -1.3916F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4399F, 14.32F, -9.5943F, 0.0873F, -0.3491F, 0.0F));
      left_arm2.addOrReplaceChild("left_arm_r4", CubeListBuilder.create().texOffs(1, 37).addBox(-1.5023F, -1.1072F, -2.7722F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(1, 37).addBox(-1.4977F, -1.1072F, -3.7278F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.3355F, 14.0356F, -10.8463F, 0.0873F, 0.0F, 0.0F));
      left_arm2.addOrReplaceChild("left_arm_r5", CubeListBuilder.create().texOffs(1, 37).addBox(-1.5F, -1.1598F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(1, 37).addBox(-1.5F, -1.1598F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.1449F, 14.0882F, -9.7608F, 0.0873F, 0.3491F, 0.0F));
      PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-10.6F, 5.0F, 17.0F));
      right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-13.2481F, -20.9543F, 1.3822F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.8311F, 3.3132F, -5.1193F, 0.9599F, 0.5236F, 0.0F));
      PartDefinition right_leg2 = right_leg.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(-5.2091F, -10.8573F, -10.3042F));
      right_leg2.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-15.9114F, -15.7316F, -0.9166F, 5.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.1643F, 14.4989F, -3.7601F, 0.48F, 0.5236F, 0.0F));
      right_leg2.addOrReplaceChild("right_leg_r3", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-1.5F, -1.0F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 0).mirror().addBox(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.0958F, 12.8573F, 1.5341F, 0.0873F, 1.0472F, 0.0F));
      right_leg2.addOrReplaceChild("right_leg_r4", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-1.5F, -1.0957F, -2.75F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 0).mirror().addBox(-1.5F, -1.0957F, -3.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-1.6288F, 12.9531F, -1.5739F, 0.0873F, 0.5236F, 0.0F));
      right_leg2.addOrReplaceChild("right_leg_r5", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-1.5F, -1.2636F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 0).mirror().addBox(-1.5F, -1.2636F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(2.2256F, 13.1209F, -2.6334F, 0.0873F, 0.0F, 0.0F));
      PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(10.6F, 5.0F, 17.0F));
      left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(22, 0).addBox(6.2481F, -20.9543F, 1.3822F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8311F, 3.3132F, -5.1193F, 0.9599F, -0.5236F, 0.0F));
      PartDefinition left_leg2 = left_leg.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(5.2091F, -10.8573F, -10.3042F));
      left_leg2.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(22, 0).addBox(10.9114F, -15.7316F, -0.9166F, 5.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.1643F, 14.4989F, -3.7601F, 0.48F, -0.5236F, 0.0F));
      left_leg2.addOrReplaceChild("left_leg_r3", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(22, 0).addBox(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.0958F, 12.8573F, 1.5341F, 0.0873F, -1.0472F, 0.0F));
      left_leg2.addOrReplaceChild("left_leg_r4", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, -1.0957F, -2.75F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(22, 0).addBox(-1.5F, -1.0957F, -3.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.6288F, 12.9531F, -1.5739F, 0.0873F, -0.5236F, 0.0F));
      left_leg2.addOrReplaceChild("left_leg_r5", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, -1.2636F, -2.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(22, 0).addBox(-1.5F, -1.2636F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.2256F, 13.1209F, -2.6334F, 0.0873F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
