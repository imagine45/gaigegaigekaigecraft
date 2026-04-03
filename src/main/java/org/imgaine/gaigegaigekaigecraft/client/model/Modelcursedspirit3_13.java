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

public class Modelcursedspirit3_13<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_13"), "main");
   public final ModelPart head;
   public final ModelPart left_leg1;
   public final ModelPart left_leg2;
   public final ModelPart left_leg3;
   public final ModelPart right_leg1;
   public final ModelPart right_leg2;
   public final ModelPart right_leg3;
   public final ModelPart body;

   public Modelcursedspirit3_13(ModelPart root) {
      this.head = root.getChild("head");
      this.left_leg1 = root.getChild("left_leg1");
      this.left_leg2 = root.getChild("left_leg2");
      this.left_leg3 = root.getChild("left_leg3");
      this.right_leg1 = root.getChild("right_leg1");
      this.right_leg2 = root.getChild("right_leg2");
      this.right_leg3 = root.getChild("right_leg3");
      this.body = root.getChild("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -7.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 30).addBox(-4.0F, -0.75F, -7.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(-0.3F)).texOffs(6, 6).addBox(-4.0F, -1.25F, -7.75F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)).texOffs(24, 4).addBox(-4.0F, -0.5F, -7.25F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)).texOffs(4, 4).addBox(-5.0F, -1.25F, -7.75F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.55F)).texOffs(4, 4).mirror().addBox(2.0F, -1.25F, -7.75F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.55F)).mirror(false), PartPose.offset(0.0F, -12.0F, -14.0F));
      head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(-4.5F, -0.75F, -2.25F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(3, 3).addBox(1.5F, -0.75F, -2.25F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(0.0F, 1.2574F, 0.0074F, -1.9199F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 1.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 1.5237F, -3.2164F, 0.6109F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 4).addBox(-3.0F, -0.5F, 1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 4.5F, -6.25F, 0.6109F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 32).addBox(-3.0F, -0.5F, -2.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 3.75F, -3.0F, 0.6109F, 0.0F, 0.0F));
      PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create(), PartPose.offset(6.0F, -9.0F, -11.0F));
      left_leg1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(21, 22).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(15.6157F, 31.5851F, -15.704F, -0.9599F, 0.0F, 0.0F));
      left_leg1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 16).addBox(3.7693F, -4.204F, 2.2334F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(8.9758F, 15.9773F, -8.1645F, -0.5727F, 1.2422F, -0.743F));
      left_leg1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 16).addBox(4.7597F, -4.204F, -0.8355F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(8.9758F, 15.9773F, -8.1645F, -0.2329F, 0.711F, -0.3486F));
      left_leg1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(40, 18).addBox(-4.2304F, -19.5815F, -8.109F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(8.9758F, 15.9773F, -8.1645F, -1.3712F, -0.9708F, 0.5192F));
      left_leg1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 16).addBox(4.0472F, -19.5815F, -5.8145F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(8.9758F, 15.9773F, -8.1645F, -0.6079F, -0.2499F, -0.6408F));
      left_leg1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(40, 17).addBox(4.1386F, -4.5874F, -1.8355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(8.9758F, 15.9773F, -8.1645F, -0.4575F, 0.6062F, -0.7126F));
      left_leg1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 16).addBox(5.9733F, -19.5815F, -0.8355F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(8.9758F, 15.9773F, -8.1645F, -0.6439F, 0.3979F, -1.0942F));
      PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(6.0F, -8.0F, -7.0F));
      left_leg2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(21, 22).addBox(0.7632F, 7.2806F, 5.3431F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(13.7568F, 20.541F, 3.6444F, -0.5616F, -0.1306F, 0.3776F));
      left_leg2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5076F, -10.7905F, -0.3899F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(13.7568F, 20.541F, 3.6444F, 0.09F, 0.4519F, 0.163F));
      left_leg2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 16).addBox(-0.2568F, -10.7905F, -0.75F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(13.7568F, 20.541F, 3.6444F, 0.0815F, -0.1133F, 0.1144F));
      left_leg2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(40, 18).addBox(-2.0F, -6.5F, -1.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(4.2486F, 3.0695F, 0.6946F, 2.3802F, -1.235F, 2.8537F));
      left_leg2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 16).addBox(-1.2266F, -6.5F, -0.8943F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(4.2486F, 3.0695F, 0.6946F, 0.2926F, -0.6627F, -1.2039F));
      left_leg2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(40, 17).addBox(1.3349F, -12.3775F, -1.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(13.7568F, 20.541F, 3.6444F, 0.1118F, -0.0836F, -0.1911F));
      left_leg2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 16).addBox(-1.2349F, -6.5F, -1.0855F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(4.2486F, 3.0695F, 0.6946F, 0.2305F, 0.0989F, -0.9974F));
      PartDefinition left_leg3 = partdefinition.addOrReplaceChild("left_leg3", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 13.0F));
      left_leg3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(21, 22).addBox(7.3135F, 11.4776F, 8.1774F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(12.9758F, 6.9773F, 2.8355F, -0.6109F, -0.2618F, 0.0F));
      left_leg3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 16).addBox(3.7693F, -4.204F, 2.2334F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(12.9758F, 6.9773F, 2.8355F, 0.0705F, 0.3132F, -0.2315F));
      left_leg3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 16).addBox(4.7597F, -4.204F, -0.8355F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(12.9758F, 6.9773F, 2.8355F, 0.0692F, -0.2527F, -0.2706F));
      left_leg3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(40, 18).addBox(-2.0F, -6.5F, -1.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(3.5541F, 0.5695F, 1.3736F, 2.7177F, -1.0292F, 1.8689F));
      left_leg3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 16).addBox(-1.2266F, -6.5F, -0.8943F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(3.5541F, 0.5695F, 1.3736F, 0.3515F, -0.9075F, -1.923F));
      left_leg3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(40, 17).addBox(4.1386F, -4.5874F, -1.8355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(12.9758F, 6.9773F, 2.8355F, 0.143F, -0.2201F, -0.5831F));
      left_leg3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 16).addBox(-1.2349F, -6.5F, -1.0855F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(3.5541F, 0.5695F, 1.3736F, 0.2161F, -0.149F, -1.6743F));
      PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create(), PartPose.offset(-6.0F, -9.0F, -11.0F));
      right_leg1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(21, 22).mirror().addBox(-2.5F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-15.6157F, 31.5851F, -15.704F, -0.9599F, 0.0F, 0.0F));
      right_leg1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-5.7693F, -4.204F, 2.2334F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-8.9758F, 15.9773F, -8.1645F, -0.5727F, -1.2422F, 0.743F));
      right_leg1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-6.7597F, -4.204F, -0.8355F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offsetAndRotation(-8.9758F, 15.9773F, -8.1645F, -0.2329F, -0.711F, 0.3486F));
      right_leg1.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(40, 18).mirror().addBox(0.2304F, -19.5815F, -8.109F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-8.9758F, 15.9773F, -8.1645F, -1.3712F, 0.9708F, -0.5192F));
      right_leg1.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-6.0472F, -19.5815F, -5.8145F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-8.9758F, 15.9773F, -8.1645F, -0.6079F, 0.2499F, 0.6408F));
      right_leg1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(40, 17).mirror().addBox(-8.1386F, -4.5874F, -1.8355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offsetAndRotation(-8.9758F, 15.9773F, -8.1645F, -0.4575F, -0.6062F, 0.7126F));
      right_leg1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7.9733F, -19.5815F, -0.8355F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(-8.9758F, 15.9773F, -8.1645F, -0.6439F, -0.3979F, 1.0942F));
      PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(-6.0F, -8.0F, -7.0F));
      right_leg2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(21, 22).mirror().addBox(-4.7632F, 7.2806F, 5.3431F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-13.7568F, 20.541F, 3.6444F, -0.5616F, 0.1306F, -0.3776F));
      right_leg2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.4924F, -10.7905F, -0.3899F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-13.7568F, 20.541F, 3.6444F, 0.09F, -0.4519F, -0.163F));
      right_leg2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.7432F, -10.7905F, -0.75F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offsetAndRotation(-13.7568F, 20.541F, 3.6444F, 0.0815F, 0.1133F, -0.1144F));
      right_leg2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(40, 18).mirror().addBox(-2.0F, -6.5F, -1.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-4.2486F, 3.0695F, 0.6946F, 2.3802F, 1.235F, -2.8537F));
      right_leg2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.7734F, -6.5F, -0.8943F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-4.2486F, 3.0695F, 0.6946F, 0.2926F, 0.6627F, 1.2039F));
      right_leg2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(40, 17).mirror().addBox(-5.3349F, -12.3775F, -1.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offsetAndRotation(-13.7568F, 20.541F, 3.6444F, 0.1118F, 0.0836F, 0.1911F));
      right_leg2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.7651F, -6.5F, -1.0855F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(-4.2486F, 3.0695F, 0.6946F, 0.2305F, -0.0989F, 0.9974F));
      PartDefinition right_leg3 = partdefinition.addOrReplaceChild("right_leg3", CubeListBuilder.create(), PartPose.offset(-6.0F, 0.0F, 13.0F));
      right_leg3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(21, 22).mirror().addBox(-11.3135F, 11.4776F, 8.1774F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-12.9758F, 6.9773F, 2.8355F, -0.6109F, 0.2618F, 0.0F));
      right_leg3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-5.7693F, -4.204F, 2.2334F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-12.9758F, 6.9773F, 2.8355F, 0.0705F, -0.3132F, 0.2315F));
      right_leg3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-6.7597F, -4.204F, -0.8355F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offsetAndRotation(-12.9758F, 6.9773F, 2.8355F, 0.0692F, 0.2527F, 0.2706F));
      right_leg3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(40, 18).mirror().addBox(-2.0F, -6.5F, -1.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-3.5541F, 0.5695F, 1.3736F, 2.7177F, 1.0292F, -1.8689F));
      right_leg3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.7734F, -6.5F, -0.8943F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-3.5541F, 0.5695F, 1.3736F, 0.3515F, 0.9075F, 1.923F));
      right_leg3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(40, 17).mirror().addBox(-8.1386F, -4.5874F, -1.8355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false), PartPose.offsetAndRotation(-12.9758F, 6.9773F, 2.8355F, 0.143F, 0.2201F, 0.5831F));
      right_leg3.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.7651F, -6.5F, -1.0855F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(-3.5541F, 0.5695F, 1.3736F, 0.2161F, 0.149F, 1.6743F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -15.0F));
      body.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(16, 16).addBox(-2.0F, -8.0F, 3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 16).addBox(-4.0F, -6.0F, 1.25F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.2F)), PartPose.offsetAndRotation(0.0F, -4.0F, 6.0F, 1.0908F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(40, 18).mirror().addBox(-4.0F, -2.5F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(1.21F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0957F, 26.8521F, 1.4066F, -0.0594F, -0.3442F));
      body.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(40, 18).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(1.2F)), PartPose.offsetAndRotation(3.0F, 0.0957F, 26.8521F, 1.4066F, 0.0594F, 0.3442F));
      body.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(16, 23).addBox(-4.0F, 9.5F, -1.25F, 8.0F, 5.0F, 4.0F, new CubeDeformation(1.0F)).texOffs(40, 18).addBox(-4.0F, 4.5F, -1.25F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(0.0F, -4.7385F, 9.303F, 1.2217F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(40, 18).addBox(-4.0F, -2.5F, -1.25F, 8.0F, 5.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(0.0F, -5.1331F, 10.2259F, 1.2217F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(16, 16).addBox(-3.25F, 13.75F, -1.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(1.19F)).texOffs(16, 16).addBox(-5.25F, -7.25F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(1.19F)), PartPose.offsetAndRotation(0.0F, -6.8828F, 7.5007F, 1.0577F, 0.3463F, -0.189F));
      body.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(1.25F, 13.75F, -1.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(1.19F)).mirror(false).texOffs(16, 16).mirror().addBox(3.25F, -7.25F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(1.19F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.8828F, 7.5007F, 1.0577F, -0.3463F, 0.189F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.right_leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_leg3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_leg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
