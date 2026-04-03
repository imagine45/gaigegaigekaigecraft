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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_1"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_1(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -4.8133F, -4.3021F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(0.0F, -4.8133F, -4.3021F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-5.5F, -10.8133F, -8.3021F, 11.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(2, 41).addBox(-3.5F, -10.8133F, -8.3021F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.1F)).texOffs(40, 29).addBox(4.0F, -11.0133F, -10.3021F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.7F)).texOffs(40, 29).mirror().addBox(-10.0F, -11.0133F, -10.3021F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.7F)).mirror(false).texOffs(0, 59).addBox(-5.0F, -0.8133F, -8.3021F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(58, 51).addBox(-5.6F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(58, 51).mirror().addBox(3.6F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(58, 51).addBox(-3.3F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(58, 51).addBox(1.3F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(58, 51).addBox(-1.0F, -2.6133F, -8.1021F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(36, 56).addBox(-5.0F, -4.8133F, -8.3021F, 10.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F)).texOffs(0, 0).addBox(-10.0F, -4.8133F, -8.3021F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(5.0F, -4.8133F, -8.3021F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.1867F, 2.8021F));
      Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.6F, -4.4133F, -8.6021F, -0.3927F, 0.1745F, -0.3491F));
      Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.6F, -4.4133F, -8.6021F, -0.3927F, -0.1745F, 0.3491F));
      Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 30).addBox(-8.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-10.9F, -3.6633F, -0.3021F, -2.3562F, -1.1781F, -2.8798F));
      Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 30).addBox(-5.2629F, -2.145F, -0.2039F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-10.9F, -3.6633F, -1.3021F, 2.7489F, 1.3963F, -2.8798F));
      Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 30).addBox(-8.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-10.9F, -3.6633F, -0.3021F, 2.3562F, 1.1781F, -2.8798F));
      Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.6779F, -6.4208F, -8.5392F, -0.3359F, 0.1099F, 1.2499F));
      Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-1.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.6779F, -6.4208F, -8.5392F, -0.3359F, -0.1099F, -1.2499F));
      Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.2779F, -11.2057F, -4.0392F, 1.2217F, 1.1781F, 3.1416F));
      Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.2779F, -11.2057F, -4.0392F, 1.2217F, -1.1781F, -3.1416F));
      Head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 30).addBox(-8.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.9F, -6.6633F, -0.3021F, -2.3562F, -1.1781F, -2.4871F));
      Head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 30).addBox(-8.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.9F, -7.6633F, -0.3021F, 2.3562F, 1.1781F, -2.4871F));
      Head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 30).addBox(-4.2781F, -2.2114F, -0.0434F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.9F, -7.6633F, -0.3021F, 2.7489F, 1.3963F, -2.4871F));
      Head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(0.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.9F, -7.6633F, -0.3021F, 2.3562F, -1.1781F, 2.4871F));
      Head.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(0.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.9F, -6.6633F, -0.3021F, -2.3562F, 1.1781F, 2.4871F));
      Head.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-3.7219F, -2.2114F, -0.0434F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.9F, -7.6633F, -0.3021F, 2.7489F, -1.3963F, 2.4871F));
      Head.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.7371F, -2.145F, -0.2039F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(10.9F, -3.6633F, -1.3021F, 2.7489F, -1.3963F, 2.8798F));
      Head.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(0.9348F, -1.3079F, 1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(10.9F, -3.6633F, -0.3021F, -2.3562F, 1.1781F, 2.8798F));
      Head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(0.9348F, -1.3079F, -1.5456F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(10.9F, -3.6633F, -0.3021F, 2.3562F, -1.1781F, 2.8798F));
      Head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(56, 51).addBox(-5.45F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(58, 51).addBox(-2.15F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(58, 51).addBox(0.15F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(56, 51).addBox(2.45F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -3.8133F, -7.6021F, 0.0F, 0.0F, -3.1416F));
      Head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.3F, -7.5F, 5.0F, 8.0F, 15.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(5.8939F, -7.1467F, -0.8021F, 0.0F, 0.0F, -0.6109F));
      Head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.3F, -7.5F, 5.0F, 8.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.8939F, -7.1467F, -0.8021F, 0.0F, 0.0F, 0.6109F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -12.0F, -1.0F, 8.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(0.0F, -12.0F, -1.0F, 8.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-12.0F, -24.0F, -2.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(0.0F, -24.0F, -2.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, -4.0F));
      Body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.0F, -11.1F, 15.1F, 0.7854F, -0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-5.0F, -10.6F, 15.3F, 0.3927F, -0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.0F, -11.1F, 15.1F, 0.7854F, 0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(5.0F, -10.6F, 15.3F, 0.3927F, 0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.0F, -11.1F, -2.1F, -0.7854F, -0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 30).addBox(-2.013F, -2.3642F, -0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-6.0F, -16.85F, 15.2F, 0.3927F, -0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.0F, -16.6F, 15.3F, 0.3927F, 0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 30).addBox(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-6.0F, -16.85F, -2.2F, -0.3927F, 0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.0F, -16.6F, -2.3F, -0.3927F, -0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(5.0F, -10.6F, -2.3F, -0.3927F, -0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.0F, -11.1F, -2.1F, -0.7854F, 0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 30).addBox(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-7.0F, -10.85F, -2.2F, -0.3927F, 0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.0F, -23.1F, 15.1F, 0.7854F, 0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.0F, -23.1F, 15.1F, 0.7854F, -0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-5.0F, -22.6F, 15.3F, 0.3927F, -0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(5.0F, -22.6F, 15.3F, 0.3927F, 0.1745F, 0.0F));
      Body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.0F, -21.8F, -2.5F, -0.3927F, -0.0436F, 0.0F));
      Body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.114F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.5F, -11.85F, 3.2F, -2.3562F, 1.1781F, 3.1416F));
      Body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-5.987F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.5F, -11.85F, 8.8F, 2.7489F, -1.3963F, -3.1416F));
      Body.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.114F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.5F, -11.85F, 9.8F, 2.3562F, -1.1781F, 3.1416F));
      Body.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 30).addBox(-5.886F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.5F, -11.85F, 3.2F, -2.3562F, -1.1781F, -3.1416F));
      Body.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 30).addBox(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.5F, -11.85F, 8.8F, 2.7489F, 1.3963F, 3.1416F));
      Body.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 30).addBox(-5.886F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.5F, -11.85F, 9.8F, 2.3562F, 1.1781F, -3.1416F));
      Body.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-5.987F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.5F, -22.85F, 8.8F, 2.7489F, -1.3963F, -3.1416F));
      Body.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.114F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.5F, -22.85F, 3.2F, -2.3562F, 1.1781F, 3.1416F));
      Body.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.114F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.5F, -22.85F, 9.8F, 2.3562F, -1.1781F, 3.1416F));
      Body.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 30).addBox(-5.886F, -2.2009F, 0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.5F, -22.85F, 3.2F, -2.3562F, -1.1781F, -3.1416F));
      Body.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 30).addBox(-5.886F, -2.2009F, -0.6526F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.5F, -22.85F, 9.8F, 2.3562F, 1.1781F, -3.1416F));
      Body.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.0F, -21.8F, -2.5F, -0.3927F, 0.0436F, 0.0F));
      Body.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 30).addBox(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.5F, -22.85F, 8.8F, 2.7489F, 1.3963F, 3.1416F));
      Body.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-9.0F, -22.7F, -2.1F, -0.7854F, 0.3927F, 0.0F));
      Body.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(9.0F, -22.7F, -2.1F, -0.7854F, -0.3927F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-9.8F, -0.7F, 2.0F));
      RightArm.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-1.3861F, 0.1325F, -1.5998F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 51).addBox(-1.5861F, -2.616F, -0.6801F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1073F, 8.5479F, -11.4206F, 1.7453F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 51).addBox(-0.436F, -4.5953F, 0.7537F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8073F, 8.5479F, -11.4206F, 2.1817F, -0.1745F, 0.0F));
      RightArm.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(0, 51).addBox(-0.5584F, -4.8879F, 0.8602F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0073F, 8.5479F, -11.4206F, 2.1817F, 0.1309F, 0.0F));
      RightArm.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(0, 51).addBox(-0.5446F, -4.8305F, 0.8393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1073F, 8.5479F, -11.2206F, 2.1817F, 0.4363F, 0.0F));
      RightArm.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(-0.5774F, -3.8983F, 0.682F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0073F, 8.5479F, -11.4206F, 2.1817F, -0.6545F, 0.0F));
      RightArm.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.7652F, 4.1076F, -2.8044F, 2.4871F, 1.0472F, 0.0F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(9.8F, -0.7F, 2.0F));
      LeftArm.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(-1.6139F, 0.1325F, -1.5998F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 51).mirror().addBox(-1.4139F, -2.616F, -0.6801F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.1073F, 8.5479F, -11.4206F, 1.7453F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(-0.564F, -4.5953F, 0.7537F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.8073F, 8.5479F, -11.4206F, 2.1817F, 0.1745F, 0.0F));
      LeftArm.addOrReplaceChild("LeftLeg_r4", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(-0.4416F, -4.8879F, 0.8602F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0073F, 8.5479F, -11.4206F, 2.1817F, -0.1309F, 0.0F));
      LeftArm.addOrReplaceChild("LeftLeg_r5", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(-0.4554F, -4.8305F, 0.8393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.1073F, 8.5479F, -11.2206F, 2.1817F, -0.4363F, 0.0F));
      LeftArm.addOrReplaceChild("RightLeg_r6", CubeListBuilder.create().texOffs(0, 51).addBox(-0.4226F, -3.8983F, 0.682F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0073F, 8.5479F, -11.4206F, 2.1817F, 0.6545F, 0.0F));
      LeftArm.addOrReplaceChild("LeftLeg_r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -4.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(2.7652F, 4.1076F, -2.8044F, 2.4871F, -1.0472F, 0.0F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(13, 50).addBox(0.0F, 3.0025F, -14.3453F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.9F, 18.9975F, 2.4453F));
      RightLeg.addOrReplaceChild("RightLeg_r7", CubeListBuilder.create().texOffs(13, 50).addBox(-3.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.1F, 4.0025F, -12.3453F, 0.0F, 0.3054F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r8", CubeListBuilder.create().texOffs(13, 50).addBox(1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.0F, 4.0025F, -12.3453F, 0.0F, -0.3054F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r9", CubeListBuilder.create().texOffs(13, 50).addBox(-1.0F, -4.3526F, -3.131F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.4F, -3.6512F, -9.2608F, 0.1745F, 0.0F, -0.192F));
      RightLeg.addOrReplaceChild("RightLeg_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0642F, -0.3136F, -6.4905F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)).texOffs(21, 46).addBox(-0.0642F, -8.3136F, -4.4905F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-0.7802F, -5.6071F, -2.4482F, 1.0472F, 0.0873F, -0.192F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(13, 50).mirror().addBox(-2.0F, 3.0025F, -14.3453F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.9F, 18.9975F, 2.4453F));
      LeftLeg.addOrReplaceChild("LeftLeg_r7", CubeListBuilder.create().texOffs(13, 50).mirror().addBox(1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-1.1F, 4.0025F, -12.3453F, 0.0F, -0.3054F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r8", CubeListBuilder.create().texOffs(13, 50).mirror().addBox(-3.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0025F, -12.3453F, 0.0F, 0.3054F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r9", CubeListBuilder.create().texOffs(13, 50).mirror().addBox(-1.0F, -4.3526F, -3.131F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.4F, -3.6512F, -9.2608F, 0.1745F, 0.0F, 0.192F));
      LeftLeg.addOrReplaceChild("LeftLeg_r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.9358F, -0.3136F, -6.4905F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)).mirror(false).texOffs(21, 46).mirror().addBox(-1.9358F, -8.3136F, -4.4905F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(0.7802F, -5.6071F, -2.4482F, 1.0472F, -0.0873F, 0.192F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
      this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
