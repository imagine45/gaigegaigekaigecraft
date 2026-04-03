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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_round_deer"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart Tail;

   public ModelRoundDeer(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.Tail = root.getChild("Tail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, -25.0F));
      Head.addOrReplaceChild("HeadMain_r1", CubeListBuilder.create().texOffs(0, 29).addBox(-3.5F, -3.0F, -8.0F, 7.0F, 8.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.0573F, 0.0083F, -0.5236F, 0.0F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5622F, -9.4724F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)).texOffs(0, 0).addBox(-3.0F, -0.5622F, -9.4724F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-4.0F, -2.5622F, -3.4724F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4378F, -7.5276F, 0.7854F, 0.0F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r3", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, -6.8046F, -6.9056F, 0.0F, -0.3927F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r4", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -6.8046F, -6.9056F, 0.0F, 0.3927F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r5", CubeListBuilder.create().texOffs(1, 15).addBox(-3.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(6.8349F, -6.5465F, -6.8449F, 0.7854F, 0.0F, -0.5236F));
      Head.addOrReplaceChild("HeadMain_r6", CubeListBuilder.create().texOffs(1, 15).mirror().addBox(2.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offsetAndRotation(-6.8349F, -6.5465F, -6.8449F, 0.7854F, 0.0F, 0.5236F));
      PartDefinition LeftHorn = Head.addOrReplaceChild("LeftHorn", CubeListBuilder.create(), PartPose.offset(6.8349F, -6.5465F, -1.8449F));
      LeftHorn.addOrReplaceChild("LeftHorn_r1", CubeListBuilder.create().texOffs(19, 0).addBox(-4.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.7854F, 0.0F, -0.5236F));
      LeftHorn.addOrReplaceChild("LeftHorn_r2", CubeListBuilder.create().texOffs(19, 0).addBox(-1.1F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1962F, -2.3F, -5.1F, 1.0151F, -0.2915F, -0.993F));
      LeftHorn.addOrReplaceChild("LeftHorn_r3", CubeListBuilder.create().texOffs(19, 0).addBox(4.7F, 2.5F, -3.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(19, 0).addBox(2.5F, 0.7F, -1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, -0.6109F));
      LeftHorn.addOrReplaceChild("LeftHorn_r4", CubeListBuilder.create().texOffs(19, 0).addBox(1.8F, -0.5F, -0.6F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, 0.0873F));
      LeftHorn.addOrReplaceChild("LeftHorn_r5", CubeListBuilder.create().texOffs(19, 0).addBox(-1.4F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1962F, -2.0F, -5.0F, 1.0151F, -0.2915F, -0.993F));
      LeftHorn.addOrReplaceChild("LeftHorn_r6", CubeListBuilder.create().texOffs(19, 0).addBox(-1.4F, 0.5F, -1.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1962F, -2.0F, -5.0F, 0.2124F, 0.4495F, -0.1289F));
      LeftHorn.addOrReplaceChild("LeftHorn_r7", CubeListBuilder.create().texOffs(19, 0).addBox(-2.0F, -0.1F, -0.9F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, -0.2182F));
      PartDefinition RightHorn = Head.addOrReplaceChild("RightHorn", CubeListBuilder.create(), PartPose.offset(-6.8349F, -6.5465F, -1.8449F));
      RightHorn.addOrReplaceChild("RightHorn_r1", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-2.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.7854F, 0.0F, 0.5236F));
      RightHorn.addOrReplaceChild("RightHorn_r2", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-2.9F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.1962F, -2.3F, -5.1F, 1.0151F, 0.2915F, 0.993F));
      RightHorn.addOrReplaceChild("RightHorn_r3", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-9.7F, 2.5F, -3.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(19, 0).mirror().addBox(-7.5F, 0.7F, -1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, 0.6109F));
      RightHorn.addOrReplaceChild("RightHorn_r4", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-6.8F, -0.5F, -0.6F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, -0.0873F));
      RightHorn.addOrReplaceChild("RightHorn_r5", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-2.6F, -0.5F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1962F, -2.0F, -5.0F, 1.0151F, 0.2915F, 0.993F));
      RightHorn.addOrReplaceChild("RightHorn_r6", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-2.6F, 0.5F, -1.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1962F, -2.0F, -5.0F, 0.2124F, -0.4495F, 0.1289F));
      RightHorn.addOrReplaceChild("RightHorn_r7", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-3.0F, -0.1F, -0.9F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.1962F, -2.0F, -5.0F, 0.7854F, 0.0F, 0.2182F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 89).addBox(-10.6F, -19.0571F, -22.0196F, 19.0F, 20.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(20, 101).addBox(-8.6F, -20.5571F, -25.0196F, 15.0F, 17.0F, 6.0F, new CubeDeformation(-0.01F)).texOffs(9, 90).addBox(-8.6F, -17.0571F, -3.0196F, 15.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(13, 93).addBox(-6.1F, -1.5452F, -3.7279F, 10.0F, 3.0F, 15.0F, new CubeDeformation(-0.1F)).texOffs(16, 98).addBox(-5.1F, 2.9429F, -18.0196F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(9, 91).addBox(-6.1F, 0.9429F, -20.0196F, 10.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(16, 94).addBox(-6.6F, -21.0571F, -3.0196F, 11.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(19, 95).addBox(-6.6F, -25.9571F, -19.0196F, 11.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, 1.6423F, 7.5809F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(23, 102).addBox(-4.0F, -7.5F, -3.0F, 8.0F, 13.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1F, -17.3625F, -28.8436F, -1.5708F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(18, 97).addBox(-6.5F, -8.7F, 7.0F, 13.0F, 10.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1F, -15.6996F, -29.5727F, -1.1781F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(42, 47).mirror().addBox(-4.5F, -5.0F, -6.0F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.7F, -12.6336F, -28.7425F, -0.5148F, -0.1954F, 0.1268F));
      Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(0, 47).addBox(-4.5F, -5.0F, -6.0F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -12.6336F, -28.7425F, -0.5148F, 0.1954F, -0.1268F));
      Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(21, 97).addBox(-2.0F, -4.0F, -5.0F, 6.0F, 8.0F, 11.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.6F, -21.6891F, -4.6422F, 1.5708F, 0.7854F, 1.5708F));
      Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(21, 97).addBox(-2.0F, -4.0F, -6.0F, 5.0F, 8.0F, 11.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.6F, -21.3891F, -20.4196F, -1.5708F, -0.7854F, 1.5708F));
      Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(20, 96).mirror().addBox(-2.0F, -6.0F, -6.0F, 4.0F, 8.0F, 12.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(5.7F, -19.7571F, -13.0196F, 0.0F, 0.0F, -0.5236F));
      Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(20, 96).addBox(-2.0F, -6.0F, -6.0F, 4.0F, 8.0F, 12.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-7.9F, -19.7571F, -13.0196F, 0.0F, 0.0F, 0.5236F));
      Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(25, 103).addBox(-5.5F, -2.0F, -3.0F, 10.0F, 4.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.6F, -17.0571F, 11.6804F, -0.7854F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(11, 89).mirror().addBox(-1.5F, -2.0F, -12.0F, 3.0F, 5.0F, 19.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(3.9F, -18.6571F, 3.9804F, 0.0F, 0.0F, -0.4363F));
      Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(11, 89).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 5.0F, 19.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-6.1F, -18.6571F, 3.9804F, 0.0F, 0.0F, 0.4363F));
      Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(21, 105).addBox(-4.0F, -9.5F, -2.0F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6783F, -9.0571F, -2.251F, 0.0F, 1.0472F, 0.0F));
      Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(21, 105).mirror().addBox(-2.0F, -9.5F, -2.0F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.8783F, -9.0571F, -2.251F, 0.0F, -1.0472F, 0.0F));
      Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, 69).mirror().addBox(-1.5F, -8.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.21F)).mirror(false), PartPose.offsetAndRotation(-8.5F, -11.2571F, -22.8196F, 0.0F, -0.5672F, 0.0F));
      Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 69).addBox(-1.5F, -8.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.21F)), PartPose.offsetAndRotation(6.3F, -11.2571F, -22.8196F, 0.0F, 0.5672F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(90, 107).mirror().addBox(-2.9903F, 17.418F, -0.6243F, 3.0F, 11.0F, 4.0F, new CubeDeformation(-0.01F)).mirror(false).texOffs(90, 100).mirror().addBox(-3.4855F, 28.0549F, -1.6261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-6.563F, -6.2963F, -11.2139F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(90, 107).mirror().addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0451F, -2.3424F, -0.6891F, 0.1309F, 0.0F, 0.2182F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(90, 107).mirror().addBox(-4.0382F, -5.0473F, -4.75F, 9.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6162F, 5.1686F, 0.0405F, 0.1309F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(90, 107).mirror().addBox(-2.5F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1969F, 12.6793F, 0.7667F, 0.0873F, 0.0F, -0.0873F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(90, 107).addBox(-0.0097F, 17.418F, -0.6243F, 3.0F, 11.0F, 4.0F, new CubeDeformation(-0.01F)).texOffs(90, 100).addBox(-0.5145F, 28.0549F, -1.6261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(6.563F, -6.2963F, -11.2139F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(90, 107).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0451F, -2.3424F, -0.6891F, 0.1309F, 0.0F, -0.2182F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(90, 107).addBox(-4.9618F, -5.0473F, -4.75F, 9.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6162F, 5.1686F, 0.0405F, 0.1309F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(90, 107).addBox(-2.5F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1969F, 12.6793F, 0.7667F, 0.0873F, 0.0F, 0.0873F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(97, 79).mirror().addBox(-3.4819F, -0.8615F, -4.3304F, 6.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(98, 80).mirror().addBox(-2.0594F, 15.4691F, 1.521F, 4.0F, 13.0F, 4.0F, new CubeDeformation(-0.21F)).mirror(false).texOffs(90, 100).mirror().addBox(-2.0594F, 26.8459F, 0.685F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.2529F, -4.8459F, 16.3573F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(97, 79).mirror().addBox(-7.7348F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(5.2529F, 13.5907F, 1.3964F, 0.3927F, 0.0F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(97, 79).mirror().addBox(-8.8224F, -5.4157F, -3.7353F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.2529F, 1.1839F, 0.1175F, 0.0F, 0.0F, 0.1745F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(97, 79).addBox(-2.5181F, -0.8615F, -4.3304F, 6.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(98, 80).addBox(-1.9406F, 15.4691F, 1.521F, 4.0F, 13.0F, 4.0F, new CubeDeformation(-0.21F)).texOffs(90, 100).addBox(-1.9406F, 26.8459F, 0.685F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.2529F, -4.8459F, 16.3573F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(97, 79).addBox(2.7348F, -5.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.2529F, 13.5907F, 1.3964F, 0.3927F, 0.0F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(97, 79).addBox(3.8224F, -5.4157F, -3.7353F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2529F, 1.1839F, 0.1175F, 0.0F, 0.0F, -0.1745F));
      PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(-0.2F, -1.5F, 14.38F));
      Tail.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(63, 96).addBox(-2.0F, -1.1F, 3.7F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -9.8266F, 10.124F, -1.3526F, 0.0F, 0.0F));
      Tail.addOrReplaceChild("Tail_r2", CubeListBuilder.create().texOffs(62, 96).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -9.8266F, 10.124F, -1.0472F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
      this.LeftArm.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
