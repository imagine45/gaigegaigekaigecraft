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

public class Modelcursedspirit3_10<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_10"), "main");
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart Head;

   public Modelcursedspirit3_10(ModelPart root) {
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.Head = root.getChild("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-7.2825F, 16.1735F, 3.1094F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-3.6807F, -8.5791F, 5.3345F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(6.078F, -0.4989F, 10.9941F, 3.1416F, -1.1781F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-4.3113F, -8.9791F, 10.2782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(10.2174F, 11.4421F, 10.0381F, -2.6616F, 0.0F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-4.3113F, -8.4791F, 9.8782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(8.5706F, 11.4421F, 12.0561F, -2.8798F, 0.0F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-4.3113F, -7.6791F, 9.5782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(6.525F, 11.4421F, 13.6222F, -3.098F, 0.0F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-4.3113F, -6.7791F, 9.3782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(4.1884F, 11.4422F, 14.7253F, 2.9671F, 0.0F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r6", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-4.3113F, -5.7791F, 9.2782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(2.2137F, 11.3498F, 15.1746F, 2.7925F, 0.0F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r7", CubeListBuilder.create().texOffs(13, 18).mirror().addBox(-10.6807F, -8.2791F, 6.1345F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.6357F, 0.0143F, 10.7815F, 1.5708F, -1.1781F, 1.5708F));
      RightLeg.addOrReplaceChild("RightLeg_r8", CubeListBuilder.create().texOffs(13, 18).mirror().addBox(-13.2836F, -8.5791F, 3.1673F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(6.078F, -8.8349F, 5.0812F, 0.0F, -0.96F, -1.5708F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(7.2825F, 16.1735F, 3.1094F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(12, 17).addBox(2.6807F, -8.5791F, 5.3345F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-6.078F, -0.4989F, 10.9941F, 3.1416F, 1.1781F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(12, 17).addBox(3.3113F, -8.9791F, 10.2782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-10.2174F, 11.4421F, 10.0381F, -2.6616F, 0.0F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(12, 17).addBox(3.3113F, -8.4791F, 9.8782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-8.5706F, 11.4421F, 12.0561F, -2.8798F, 0.0F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r4", CubeListBuilder.create().texOffs(12, 17).addBox(3.3113F, -7.6791F, 9.5782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-6.525F, 11.4421F, 13.6222F, -3.098F, 0.0F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r5", CubeListBuilder.create().texOffs(12, 17).addBox(3.3113F, -6.7791F, 9.3782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.1884F, 11.4422F, 14.7253F, 2.9671F, 0.0F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r6", CubeListBuilder.create().texOffs(12, 17).addBox(3.3113F, -5.7791F, 9.2782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-2.2137F, 11.3498F, 15.1746F, 2.7925F, 0.0F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r7", CubeListBuilder.create().texOffs(13, 18).addBox(3.6807F, -8.2791F, 6.1345F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6357F, 0.0143F, 10.7815F, 1.5708F, 1.1781F, -1.5708F));
      LeftLeg.addOrReplaceChild("LeftLeg_r8", CubeListBuilder.create().texOffs(13, 18).addBox(7.2836F, -8.5791F, 3.1673F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-6.078F, -8.8349F, 5.0812F, 0.0F, 0.96F, 1.5708F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-7.9151F, 13.7137F, -1.8405F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(13, 19).mirror().addBox(-19.2354F, -11.1159F, 1.0325F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.6596F, -4.4005F, 6.2951F, -0.1481F, -1.0061F, -1.5254F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-22.1561F, -11.464F, 2.5703F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(15.28F, 4.7437F, 6.1752F, -1.4751F, -1.1847F, -0.1714F));
      RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(11, 17).mirror().addBox(-21.9486F, -10.7668F, 1.0325F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(8.1496F, -5.4113F, 5.3166F, -0.1306F, -0.9197F, -1.5466F));
      RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-22.8146F, -11.2668F, 2.0325F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(9.9575F, 5.5624F, 10.6809F, -1.1432F, -1.4839F, -0.5089F));
      RightArm.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-22.1927F, -11.4851F, 1.4089F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(3.029F, 6.6681F, 13.3109F, 1.4367F, -1.2984F, -3.0951F));
      RightArm.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-23.4145F, -10.0066F, 0.533F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-0.7899F, -3.9742F, 9.3503F, 0.7256F, -0.7881F, -2.2958F));
      RightArm.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-24.1267F, -13.2506F, -1.008F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(0.1242F, 1.0427F, 13.4454F, 0.9129F, -0.938F, -2.5411F));
      RightArm.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-24.3267F, -12.9506F, -1.008F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(12.465F, 1.8998F, 9.2609F, -0.2024F, -1.2112F, -1.4339F));
      RightArm.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-24.0267F, -12.3506F, -0.408F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(18.4581F, 2.4809F, 1.5718F, -0.9452F, -0.948F, -0.6639F));
      RightArm.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-23.3267F, -11.2506F, -0.308F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(20.2521F, 4.5385F, -6.3935F, -1.291F, -0.5917F, -0.3472F));
      RightArm.addOrReplaceChild("RightArm_r11", CubeListBuilder.create().texOffs(13, 19).mirror().addBox(-15.4F, -13.7F, -0.7F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(7.208F, -3.9281F, 12.3605F, 1.2322F, -0.2379F, -1.2691F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(7.9151F, 13.7137F, -1.8405F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(13, 19).addBox(12.2354F, -11.1159F, 1.0325F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6596F, -4.4005F, 6.2951F, -0.1481F, 1.0061F, 1.5254F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(12, 18).addBox(20.1561F, -11.464F, 2.5703F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-15.28F, 4.7437F, 6.1752F, -1.4751F, 1.1847F, 0.1714F));
      LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(11, 17).addBox(18.9486F, -10.7668F, 1.0325F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-8.1496F, -5.4113F, 5.3166F, -0.1306F, 0.9197F, 1.5466F));
      LeftArm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(12, 18).addBox(18.8146F, -11.2668F, 2.0325F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-9.9575F, 5.5624F, 10.6809F, -1.1432F, 1.4839F, 0.5089F));
      LeftArm.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(12, 18).addBox(20.1927F, -11.4851F, 1.4089F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-3.029F, 6.6681F, 13.3109F, 1.4367F, 1.2984F, 3.0951F));
      LeftArm.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(12, 18).addBox(21.4145F, -10.0066F, 0.533F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.7899F, -3.9742F, 9.3503F, 0.7256F, 0.7881F, 2.2958F));
      LeftArm.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(12, 18).addBox(22.1267F, -13.2506F, -1.008F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-0.1242F, 1.0427F, 13.4454F, 0.9129F, 0.938F, 2.5411F));
      LeftArm.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(12, 18).addBox(22.3267F, -12.9506F, -1.008F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-12.465F, 1.8998F, 9.2609F, -0.2024F, 1.2112F, 1.4339F));
      LeftArm.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(12, 18).addBox(22.0267F, -12.3506F, -0.408F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-18.4581F, 2.4809F, 1.5718F, -0.9452F, 0.948F, 0.6639F));
      LeftArm.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(12, 18).addBox(21.3267F, -11.2506F, -0.308F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-20.2521F, 4.5385F, -6.3935F, -1.291F, 0.5917F, 0.3472F));
      LeftArm.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(13, 19).addBox(7.4F, -13.7F, -0.7F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-7.208F, -3.9281F, 12.3605F, 1.2322F, 0.2379F, 1.2691F));
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 15.1453F, -0.722F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(10, 10).addBox(-4.0F, -6.0F, -7.5F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(10, 10).addBox(-4.0F, -6.0F, 4.5F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.309F, -1.5708F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(11, 11).addBox(-2.5F, -6.0F, 6.1F, 5.0F, 11.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3622F, -0.7519F, -0.2532F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(11, 11).mirror().addBox(-2.3F, -0.4F, 6.1F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4499F, 0.4804F, 2.333F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(11, 11).addBox(-2.7F, -0.4F, 6.1F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4499F, -0.4804F, -2.333F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(11, 11).addBox(-2.5F, 1.0F, 6.1F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)).texOffs(11, 11).addBox(1.5F, -1.0F, 6.1F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)).texOffs(11, 11).addBox(-2.5F, -6.0F, 6.1F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7794F, -0.7519F, -2.8884F));
      Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(11, 11).addBox(-2.5F, 1.0F, 6.1F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)).texOffs(11, 11).addBox(-2.5F, -1.0F, 6.1F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)).texOffs(11, 11).addBox(-2.5F, -6.0F, 6.1F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7794F, 0.7519F, 2.8884F));
      Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(11, 11).addBox(-2.5F, -6.0F, 6.1F, 5.0F, 11.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3622F, 0.7519F, 0.2532F));
      Head.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(11, 11).addBox(-4.0F, -6.0F, 5.5F, 8.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 1).addBox(-5.5F, 5.0341F, -5.7412F, 11.0F, 3.0F, 12.0F, new CubeDeformation(-1.0F)).texOffs(1, 1).addBox(-5.5F, 4.0341F, -5.7412F, 11.0F, 2.0F, 12.0F, new CubeDeformation(-0.1F)).texOffs(6, 30).addBox(-4.5F, -8.0F, -7.5F, 9.0F, 6.0F, 15.0F, new CubeDeformation(0.15F)).texOffs(29, 30).addBox(-4.0F, -12.8F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-1.0F)).texOffs(12, 36).addBox(-4.5F, -11.5F, -4.5F, 9.0F, 6.0F, 9.0F, new CubeDeformation(0.15F)).texOffs(8, 32).addBox(-4.5F, -10.0F, -6.5F, 9.0F, 6.0F, 13.0F, new CubeDeformation(0.15F)).texOffs(11, 11).addBox(-4.0F, -6.0F, -7.5F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(11, 11).addBox(-4.0F, 1.0F, -7.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(8, 28).addBox(-2.5F, -3.0F, -8.5F, 5.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.8297F, -1.2939F, 2.7794F, 0.7519F, 2.8884F));
      Head.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(8, 28).addBox(-2.5F, -3.0F, -8.5F, 5.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.8297F, -1.2939F, 2.7794F, -0.7519F, -2.8884F));
      Head.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(6, 30).addBox(-4.5F, -3.0F, -7.5F, 9.0F, 6.0F, 15.0F, new CubeDeformation(0.1F)).texOffs(8, 32).addBox(-4.5F, -5.0F, -6.5F, 9.0F, 6.0F, 13.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -4.8297F, -1.2939F, 1.5708F, -1.309F, -1.5708F));
      Head.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(0, 52).addBox(-5.1646F, -3.0F, -9.0646F, 10.0F, 6.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.0F, 0.0715F, -0.2983F, 0.3622F, 0.7519F, 0.2532F));
      Head.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(0, 52).addBox(-4.8354F, -3.0F, -9.0646F, 10.0F, 6.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.0F, 0.0715F, -0.2983F, 0.3622F, -0.7519F, -0.2532F));
      Head.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(0, 52).addBox(-5.0F, -3.0F, -9.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.0F, 0.0768F, -0.3067F, 0.2618F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
