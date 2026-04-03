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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_fushiguro_toji"), "main");
   public final ModelPart body;
   public final ModelPart himo;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart steve;

   public Modelclothes_fushiguro_toji(ModelPart root) {
      this.body = root.getChild("body");
      this.himo = this.body.getChild("himo");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.right_leg = root.getChild("right_leg");
      this.left_leg = root.getChild("left_leg");
      this.steve = root.getChild("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition himo = body.addOrReplaceChild("himo", CubeListBuilder.create().texOffs(26, 25).addBox(-3.0F, -0.85F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(26, 25).addBox(-3.0F, -0.55F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(26, 25).mirror().addBox(-3.0F, -0.55F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(26, 25).mirror().addBox(-3.0F, -0.85F, -2.83F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offset(2.5F, 11.9F, 0.0F));
      himo.addOrReplaceChild("right_himo_r1", CubeListBuilder.create().texOffs(26, 25).mirror().addBox(-0.9907F, -1.7169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(26, 25).mirror().addBox(-0.9907F, -2.1169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-3.3695F, 1.2169F, -2.0822F, 0.0F, 0.1745F, 0.0F));
      himo.addOrReplaceChild("right_himo_r2", CubeListBuilder.create().texOffs(26, 27).mirror().addBox(-0.3F, -2.0F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)).mirror(false), PartPose.offsetAndRotation(-3.56F, 1.3471F, -3.5724F, -0.0872F, 0.0F, 0.0436F));
      himo.addOrReplaceChild("right_himo_r3", CubeListBuilder.create().texOffs(26, 27).mirror().addBox(-0.5F, -2.2F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)).mirror(false), PartPose.offsetAndRotation(-3.56F, 1.3471F, -3.5724F, -0.0872F, 0.0F, 0.2618F));
      himo.addOrReplaceChild("right_himo_r4", CubeListBuilder.create().texOffs(26, 27).mirror().addBox(-0.8F, -2.4F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)).mirror(false), PartPose.offsetAndRotation(-3.56F, 1.3471F, -3.5424F, -0.0872F, 0.0F, 0.2618F));
      himo.addOrReplaceChild("left_himo_r1", CubeListBuilder.create().texOffs(26, 27).addBox(-1.2F, -2.4F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.44F, 1.3471F, -3.5424F, -0.0872F, 0.0F, -0.2618F));
      himo.addOrReplaceChild("left_himo_r2", CubeListBuilder.create().texOffs(26, 27).addBox(-1.5F, -2.2F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.44F, 1.3471F, -3.5724F, -0.0872F, 0.0F, -0.2618F));
      himo.addOrReplaceChild("left_himo_r3", CubeListBuilder.create().texOffs(26, 27).addBox(-1.7F, -2.0F, 0.6F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.44F, 1.3471F, -3.5724F, -0.0872F, 0.0F, -0.0436F));
      himo.addOrReplaceChild("left_himo_r4", CubeListBuilder.create().texOffs(26, 25).addBox(-1.0093F, -2.1169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(26, 25).addBox(-1.0093F, -1.7169F, -0.7271F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.6305F, 1.2169F, -2.0822F, 0.0F, -0.1745F, 0.0F));
      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, -0.0648F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).texOffs(8, 4).mirror().addBox(-1.5F, 7.3904F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false).texOffs(8, 4).mirror().addBox(-1.5F, 7.3904F, 2.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-3.5F, -0.5F, -1.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(2.0F, 7.1177F, 2.5965F, -1.1781F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-3.5F, -0.5F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(2.0F, 7.1177F, -2.5965F, 1.1781F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.4F, -12.0F, 1.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 12.1932F, 0.5763F, 0.0873F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r4", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -4.2324F, 2.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(1.9F, 8.3144F, -1.9672F, -0.9599F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r5", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.1141F, 6.9006F, -1.5013F, 0.9599F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, -1.5013F, -0.0873F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r7", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 1.4898F, -0.8631F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, -1.5013F, 0.0F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r8", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, -1.5013F, 0.9599F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, 1.5013F, 0.0873F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r10", CubeListBuilder.create().texOffs(0, 0).addBox(0.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.397F, 11.9812F, -1.9F, 0.0F, -1.5708F, -0.0873F));
      right_leg.addOrReplaceChild("right_leg_r11", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.0754F, 9.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      right_leg.addOrReplaceChild("right_leg_r12", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.1141F, 6.9006F, 1.5013F, -0.9599F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r13", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 1.4898F, -0.1369F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, 1.5013F, 0.0F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r14", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -4.6096F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-0.0333F, 12.0F, -1.9F, 0.0F, -1.5708F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r15", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.0754F, 9.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      right_leg.addOrReplaceChild("right_leg_r16", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, 1.5013F, -0.9599F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r17", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false).texOffs(8, 4).mirror().addBox(-0.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, 1.5013F, -0.9599F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r18", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 0.4898F, -0.1369F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, 1.5013F, 0.0F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r19", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, 1.5013F, 0.0873F, -0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, -1.5013F, -0.0873F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r21", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false).texOffs(8, 4).mirror().addBox(-0.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, -1.5013F, 0.9599F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r22", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 0.4898F, -0.8631F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, -1.5013F, 0.0F, 0.7854F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r23", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.0754F, 8.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      right_leg.addOrReplaceChild("right_leg_r24", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.0754F, 9.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      right_leg.addOrReplaceChild("right_leg_r25", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -5.6096F, -3.2529F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offsetAndRotation(0.0333F, 12.0F, -1.9F, 0.0F, 1.5708F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r26", CubeListBuilder.create().texOffs(8, 4).addBox(-0.47F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0538F, 8.9677F, 2.1F, -1.3526F, 0.7854F, 3.1416F));
      right_leg.addOrReplaceChild("right_leg_r27", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.53F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.0538F, 8.9677F, 2.1F, -1.3526F, -0.7854F, -3.1416F));
      right_leg.addOrReplaceChild("right_leg_r28", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.53F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.0538F, 8.9677F, -2.1F, 1.3526F, 0.7854F, -3.1416F));
      right_leg.addOrReplaceChild("right_leg_r29", CubeListBuilder.create().texOffs(8, 4).addBox(-0.47F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0538F, 8.9677F, -2.1F, 1.3526F, -0.7854F, 3.1416F));
      right_leg.addOrReplaceChild("right_leg_r30", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0538F, 8.7677F, 0.0F, 0.0F, -1.5708F, -1.789F));
      right_leg.addOrReplaceChild("right_leg_r31", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.0538F, 8.7677F, 0.0F, 0.0F, 1.5708F, 1.789F));
      right_leg.addOrReplaceChild("right_leg_r32", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.397F, 11.9812F, -1.9F, 0.0F, 1.5708F, 0.0873F));
      right_leg.addOrReplaceChild("right_leg_r33", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-1.4333F, -2.4051F, -0.9446F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.0667F, 8.7676F, 0.0F, -1.789F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r34", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-1.4333F, -2.4051F, -0.0554F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.0667F, 8.7676F, 0.0F, 1.789F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r35", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -4.2324F, -3.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(1.9F, 8.3144F, 1.9672F, 0.9599F, 0.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r36", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.4F, -12.0F, -2.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 12.1932F, -0.5763F, -0.0873F, 0.0F, 0.0F));
      PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0F, -0.0648F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).mirror(false).texOffs(8, 4).addBox(-1.5F, 7.3904F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).texOffs(8, 4).addBox(-1.5F, 7.3904F, 2.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offset(2.0F, 12.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(6, 3).addBox(0.5F, -0.5F, -1.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-2.0F, 7.1177F, 2.5965F, -1.1781F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(6, 3).addBox(0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-2.0F, 7.1177F, -2.5965F, 1.1781F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.4F, -12.0F, 1.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 12.1932F, 0.5763F, 0.0873F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r4", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -4.2324F, 2.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.9F, 8.3144F, -1.9672F, -0.9599F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r5", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 6.9006F, -1.5013F, 0.9599F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, -1.5013F, -0.0873F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r7", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 1.4898F, -0.8631F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, -1.5013F, 0.0F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r8", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, -1.5013F, 0.9599F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, 1.5013F, 0.0873F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.397F, 11.9812F, -1.9F, 0.0F, 1.5708F, 0.0873F));
      left_leg.addOrReplaceChild("left_leg_r11", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.0754F, 9.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      left_leg.addOrReplaceChild("left_leg_r12", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 6.9006F, 1.5013F, -0.9599F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r13", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 1.4898F, -0.1369F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, 1.5013F, 0.0F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r14", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -4.6096F, -3.2529F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offsetAndRotation(0.0333F, 12.0F, -1.9F, 0.0F, 1.5708F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r15", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-3.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.0754F, 9.8959F, -1.9F, 0.0F, 1.5708F, -0.9599F));
      left_leg.addOrReplaceChild("left_leg_r16", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-2.1141F, 5.9006F, 1.5013F, -0.9599F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r17", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 0.7211F, 1.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).texOffs(8, 4).addBox(-1.5F, -0.4261F, -0.1038F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, 1.5013F, -0.9599F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r18", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 0.4898F, -0.1369F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, 1.5013F, 0.0F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.8895F, -0.4554F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, 1.5013F, 0.0873F, 0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.8895F, -0.5446F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, -1.5013F, -0.0873F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r21", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, -0.4261F, -0.8962F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).texOffs(8, 4).addBox(-1.5F, 0.7211F, -2.5344F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, -1.5013F, 0.9599F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r22", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, 0.4898F, -0.8631F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(2.1141F, 5.9006F, -1.5013F, 0.0F, -0.7854F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r23", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -7.4128F, -2.132F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.0754F, 8.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      left_leg.addOrReplaceChild("left_leg_r24", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -6.8392F, -2.9511F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.0754F, 9.8959F, -1.9F, 0.0F, -1.5708F, 0.9599F));
      left_leg.addOrReplaceChild("left_leg_r25", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -5.6096F, -3.2529F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-0.0333F, 12.0F, -1.9F, 0.0F, -1.5708F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r26", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.53F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.0538F, 8.9677F, 2.1F, -1.3526F, -0.7854F, -3.1416F));
      left_leg.addOrReplaceChild("left_leg_r27", CubeListBuilder.create().texOffs(8, 4).addBox(-0.47F, 0.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0538F, 8.9677F, 2.1F, -1.3526F, 0.7854F, 3.1416F));
      left_leg.addOrReplaceChild("left_leg_r28", CubeListBuilder.create().texOffs(8, 4).addBox(-0.47F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0538F, 8.9677F, -2.1F, 1.3526F, -0.7854F, 3.1416F));
      left_leg.addOrReplaceChild("left_leg_r29", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-0.53F, 0.1F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.0538F, 8.9677F, -2.1F, 1.3526F, 0.7854F, -3.1416F));
      left_leg.addOrReplaceChild("left_leg_r30", CubeListBuilder.create().texOffs(8, 4).mirror().addBox(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.0538F, 8.7677F, 0.0F, 0.0F, 1.5708F, 1.789F));
      left_leg.addOrReplaceChild("left_leg_r31", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0538F, 8.7677F, 0.0F, 0.0F, -1.5708F, -1.789F));
      left_leg.addOrReplaceChild("left_leg_r32", CubeListBuilder.create().texOffs(0, 0).addBox(0.4F, -11.7761F, -2.8269F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.397F, 11.9812F, -1.9F, 0.0F, -1.5708F, -0.0873F));
      left_leg.addOrReplaceChild("left_leg_r33", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5667F, -2.4051F, -0.9446F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0667F, 8.7676F, 0.0F, -1.789F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r34", CubeListBuilder.create().texOffs(8, 4).addBox(-1.5667F, -2.4051F, -0.0554F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0667F, 8.7676F, 0.0F, 1.789F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r35", CubeListBuilder.create().texOffs(8, 4).addBox(0.4F, -4.2324F, -3.0565F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.9F, 8.3144F, 1.9672F, 0.9599F, 0.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r36", CubeListBuilder.create().texOffs(0, 0).addBox(0.4F, -12.0F, -2.7F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 12.1932F, -0.5763F, -0.0873F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("steve", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16).mirror().addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 16).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 16).mirror().addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
