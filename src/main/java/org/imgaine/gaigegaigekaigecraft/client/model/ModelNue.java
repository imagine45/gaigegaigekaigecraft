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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_nue"), "main");
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg;
   public final ModelPart LeftArm;
   public final ModelPart RightArm;
   public final ModelPart Body;
   public final ModelPart Head;

   public ModelNue(ModelPart root) {
      this.LeftLeg = root.getChild("LeftLeg");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftArm = root.getChild("LeftArm");
      this.RightArm = root.getChild("RightArm");
      this.Body = root.getChild("Body");
      this.Head = root.getChild("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(3.016F, 14.7065F, 1.5638F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(49, 8).mirror().addBox(-0.5869F, -2.3204F, -1.113F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(7.1157F, 7.2802F, -3.0146F, 1.9519F, -0.8846F, -0.1581F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(-0.5378F, -1.7621F, -1.5765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(7.1157F, 7.2802F, -3.0146F, 0.8698F, -0.8846F, -0.1581F));
      LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(-0.5373F, -0.7676F, -1.6873F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.1157F, 7.2802F, -3.0146F, 0.0408F, -0.8846F, -0.1581F));
      LeftLeg.addOrReplaceChild("LeftLeg_r4", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(-0.5383F, -4.2358F, -3.328F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(3.7436F, 7.8071F, -1.3695F, 0.657F, -0.4141F, -0.0323F));
      LeftLeg.addOrReplaceChild("LeftLeg_r5", CubeListBuilder.create().texOffs(49, 8).mirror().addBox(-0.5874F, -5.0282F, 0.2488F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(3.7436F, 7.8071F, -1.3695F, 1.7391F, -0.4141F, -0.0323F));
      LeftLeg.addOrReplaceChild("LeftLeg_r6", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(-0.5378F, -1.1476F, -4.6944F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7436F, 7.8071F, -1.3695F, -0.172F, -0.4141F, -0.0323F));
      LeftLeg.addOrReplaceChild("LeftLeg_r7", CubeListBuilder.create().texOffs(49, 8).mirror().addBox(6.5722F, -15.0155F, -6.3052F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-6.1937F, 3.0637F, 7.9124F, 1.6827F, 0.0534F, -0.3657F));
      LeftLeg.addOrReplaceChild("LeftLeg_r8", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(6.1118F, -8.3373F, -6.8515F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.6907F, 11.382F, 3.9233F, 0.6006F, 0.0534F, -0.3657F));
      LeftLeg.addOrReplaceChild("LeftLeg_r9", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(3.7395F, -2.2929F, -3.0952F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0572F, 10.0728F, -3.2351F, -0.2284F, 0.0534F, -0.3657F));
      LeftLeg.addOrReplaceChild("LeftLeg_r10", CubeListBuilder.create().texOffs(49, 8).mirror().addBox(-0.4403F, 4.1329F, -2.1472F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(3.7436F, 7.8071F, -1.3695F, 1.5505F, -0.4297F, -0.0095F));
      LeftLeg.addOrReplaceChild("LeftLeg_r11", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(-0.4732F, 2.4507F, 2.7242F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(3.7436F, 7.8071F, -1.3695F, 0.6516F, -0.4297F, -0.0095F));
      LeftLeg.addOrReplaceChild("LeftLeg_r12", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-3.8731F, -9.8595F, 0.6519F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false).texOffs(0, 55).mirror().addBox(-3.8731F, -9.8595F, 0.6519F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(44, 34).mirror().addBox(-2.8731F, -7.3595F, 1.6519F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.328F, 8.5198F, -0.0791F, 0.0861F, -0.5338F, -0.3127F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-3.016F, 14.7065F, 1.5638F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(49, 8).addBox(-0.4131F, -2.3204F, -1.113F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-7.1157F, 7.2802F, -3.0146F, 1.9519F, 0.8846F, 0.1581F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(44, 34).addBox(-0.4622F, -1.7621F, -1.5765F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-7.1157F, 7.2802F, -3.0146F, 0.8698F, 0.8846F, 0.1581F));
      RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(44, 34).addBox(-0.4627F, -0.7676F, -1.6873F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1157F, 7.2802F, -3.0146F, 0.0408F, 0.8846F, 0.1581F));
      RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(44, 34).addBox(-0.4617F, -4.2358F, -3.328F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-3.7436F, 7.8071F, -1.3695F, 0.657F, 0.4141F, 0.0323F));
      RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(49, 8).addBox(-0.4126F, -5.0282F, 0.2488F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.7436F, 7.8071F, -1.3695F, 1.7391F, 0.4141F, 0.0323F));
      RightLeg.addOrReplaceChild("RightLeg_r6", CubeListBuilder.create().texOffs(44, 34).addBox(-0.4622F, -1.1476F, -4.6944F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7436F, 7.8071F, -1.3695F, -0.172F, 0.4141F, 0.0323F));
      RightLeg.addOrReplaceChild("RightLeg_r7", CubeListBuilder.create().texOffs(49, 8).addBox(-7.5722F, -15.0155F, -6.3052F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.1937F, 3.0637F, 7.9124F, 1.6827F, -0.0534F, 0.3657F));
      RightLeg.addOrReplaceChild("RightLeg_r8", CubeListBuilder.create().texOffs(44, 34).addBox(-7.1118F, -8.3373F, -6.8515F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.6907F, 11.382F, 3.9233F, 0.6006F, -0.0534F, 0.3657F));
      RightLeg.addOrReplaceChild("RightLeg_r9", CubeListBuilder.create().texOffs(44, 34).addBox(-4.7395F, -2.2929F, -3.0952F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0572F, 10.0728F, -3.2351F, -0.2284F, -0.0534F, 0.3657F));
      RightLeg.addOrReplaceChild("RightLeg_r10", CubeListBuilder.create().texOffs(49, 8).addBox(-0.5597F, 4.1329F, -2.1472F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.7436F, 7.8071F, -1.3695F, 1.5505F, 0.4297F, 0.0095F));
      RightLeg.addOrReplaceChild("RightLeg_r11", CubeListBuilder.create().texOffs(44, 34).addBox(-0.5268F, 2.4507F, 2.7242F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-3.7436F, 7.8071F, -1.3695F, 0.6516F, 0.4297F, 0.0095F));
      RightLeg.addOrReplaceChild("RightLeg_r12", CubeListBuilder.create().texOffs(0, 58).addBox(0.8731F, -9.8595F, 0.6519F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).texOffs(0, 55).addBox(0.8731F, -9.8595F, 0.6519F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)).texOffs(44, 34).addBox(1.8731F, -7.3595F, 1.6519F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.328F, 8.5198F, -0.0791F, 0.0861F, 0.5338F, 0.3127F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(7.8062F, -0.6974F, 2.0558F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(37.8253F, -32.3976F, -4.7878F, 2.0F, 3.0F, 14.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(17.7068F, 51.7783F, -2.6584F, 1.4381F, -0.7974F, -1.0943F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(29, 5).mirror().addBox(-0.61F, -6.5F, -0.5F, 1.0F, 12.0F, 7.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offsetAndRotation(31.3076F, 11.4144F, 10.495F, 2.1624F, -0.7974F, -1.0943F));
      LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(16, -8).mirror().addBox(-3.1F, -6.0F, -10.0F, 1.0F, 6.0F, 20.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(21.4815F, 5.0164F, 9.0655F, 1.938F, -1.1762F, -1.2922F));
      LeftArm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(32, -6).mirror().addBox(-0.4F, -5.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offsetAndRotation(15.2644F, 4.5211F, 6.0663F, -2.6109F, -1.0686F, -1.8193F));
      LeftArm.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(32, -6).mirror().addBox(-0.1309F, -9.6665F, -1.2485F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(18.7686F, 9.6106F, 8.5898F, 3.0236F, -1.1887F, -1.0297F));
      LeftArm.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(34, -4).mirror().addBox(0.4F, -5.5F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offsetAndRotation(15.662F, 7.6749F, 13.1393F, -2.8172F, -0.7634F, -1.2723F));
      LeftArm.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(34, -4).mirror().addBox(0.6F, -5.5F, -2.0F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(21.1773F, 11.9502F, 13.8193F, 3.0787F, -0.7974F, -1.0943F));
      LeftArm.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(19, -5).mirror().addBox(19.9658F, -33.8566F, -18.376F, 1.0F, 12.0F, 17.0F, new CubeDeformation(0.25F)).mirror(false).texOffs(0, 33).mirror().addBox(19.6658F, -36.8566F, -23.676F, 2.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.6833F, 27.7396F, 12.3412F, 1.7697F, -0.7974F, -1.0943F));
      LeftArm.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(4.4667F, 3.5278F, 4.833F, 1.4826F, -0.8024F, -2.0742F));
      LeftArm.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-3.5F, -7.4F, -5.5F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(4.4667F, 3.5278F, 4.833F, 1.4044F, -1.1923F, -1.9829F));
      LeftArm.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(1.0764F, -32.6638F, 2.6463F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.4447F, 13.9984F, 19.1926F, 1.4826F, -0.8024F, -2.0742F));
      LeftArm.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(11.2605F, 1.0812F, 5.9025F, 1.8928F, -0.8024F, -2.0742F));
      LeftArm.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-3.0F, -6.0F, -6.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(11.2605F, 1.0812F, 5.9025F, 2.1533F, -1.1595F, -2.3819F));
      LeftArm.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(9.9849F, -34.0101F, -0.868F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(21.0669F, 25.2038F, 15.6207F, 1.8928F, -0.8024F, -2.0742F));
      LeftArm.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(32, -6).mirror().addBox(0.6F, -4.5F, -4.9F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(37.8484F, 9.2233F, 4.5513F, 0.3559F, -0.6367F, -0.821F));
      LeftArm.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(34, -4).mirror().addBox(18.5567F, -37.9383F, 2.9125F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(43.5227F, 23.0445F, 13.7327F, 1.4914F, -0.8024F, -2.0742F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-7.8062F, -0.6974F, 2.0558F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 33).addBox(-39.8253F, -32.3976F, -4.7878F, 2.0F, 3.0F, 14.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-17.7068F, 51.7783F, -2.6584F, 1.4381F, 0.7974F, 1.0943F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(29, 5).addBox(-0.39F, -6.5F, -0.5F, 1.0F, 12.0F, 7.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(-31.3076F, 11.4144F, 10.495F, 2.1624F, 0.7974F, 1.0943F));
      RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(16, -8).addBox(2.1F, -6.0F, -10.0F, 1.0F, 6.0F, 20.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-21.4815F, 5.0164F, 9.0655F, 1.938F, 1.1762F, 1.2922F));
      RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(32, -6).addBox(0.4F, -5.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(-15.2644F, 4.5211F, 6.0663F, -2.6109F, 1.0686F, 1.8193F));
      RightArm.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(32, -6).addBox(0.1309F, -9.6665F, -1.2485F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-18.7686F, 9.6106F, 8.5898F, 3.0236F, 1.1887F, 1.0297F));
      RightArm.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(34, -4).addBox(-0.4F, -5.5F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(-15.662F, 7.6749F, 13.1393F, -2.8172F, 0.7634F, 1.2723F));
      RightArm.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(34, -4).addBox(-0.6F, -5.5F, -2.0F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-21.1773F, 11.9502F, 13.8193F, 3.0787F, 0.7974F, 1.0943F));
      RightArm.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(19, -5).addBox(-20.9658F, -33.8566F, -18.376F, 1.0F, 12.0F, 17.0F, new CubeDeformation(0.25F)).texOffs(0, 33).addBox(-21.6658F, -36.8566F, -23.676F, 2.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6833F, 27.7396F, 12.3412F, 1.7697F, 0.7974F, 1.0943F));
      RightArm.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-4.4667F, 3.5278F, 4.833F, 1.4826F, 0.8024F, 2.0742F));
      RightArm.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(24, 0).addBox(2.5F, -7.4F, -5.5F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-4.4667F, 3.5278F, 4.833F, 1.4044F, 1.1923F, 1.9829F));
      RightArm.addOrReplaceChild("RightArm_r11", CubeListBuilder.create().texOffs(0, 33).addBox(-3.0764F, -32.6638F, 2.6463F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.4447F, 13.9984F, 19.1926F, 1.4826F, 0.8024F, 2.0742F));
      RightArm.addOrReplaceChild("RightArm_r12", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -6.0F, -6.0F, 1.0F, 12.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-11.2605F, 1.0812F, 5.9025F, 1.8928F, 0.8024F, 2.0742F));
      RightArm.addOrReplaceChild("RightArm_r13", CubeListBuilder.create().texOffs(24, 0).addBox(2.0F, -6.0F, -6.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-11.2605F, 1.0812F, 5.9025F, 2.1533F, 1.1595F, 2.3819F));
      RightArm.addOrReplaceChild("RightArm_r14", CubeListBuilder.create().texOffs(0, 33).addBox(-11.9849F, -34.0101F, -0.868F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0669F, 25.2038F, 15.6207F, 1.8928F, 0.8024F, 2.0742F));
      RightArm.addOrReplaceChild("RightArm_r15", CubeListBuilder.create().texOffs(32, -6).addBox(-0.6F, -4.5F, -4.9F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-37.8484F, 9.2233F, 4.5513F, 0.3559F, 0.6367F, 0.821F));
      RightArm.addOrReplaceChild("RightArm_r16", CubeListBuilder.create().texOffs(34, -4).addBox(-18.5567F, -37.9383F, 2.9125F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-43.5227F, 23.0445F, 13.7327F, 1.4914F, 0.8024F, 2.0742F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 7.1664F, 3.9725F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-1.9F, -4.0F, 0.6F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-8.035F, -7.1027F, -6.4095F, -1.181F, 0.2795F, -0.5946F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(34, 0).addBox(-2.1F, -4.0F, 0.6F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(8.035F, -7.1027F, -6.4095F, -1.181F, -0.2795F, 0.5946F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-1.5F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-7.0786F, -8.1152F, -6.9292F, -1.1356F, -0.1979F, 0.3968F));
      Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(34, 0).addBox(-2.5F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(7.0786F, -8.1152F, -6.9292F, -1.1356F, 0.1979F, -0.3968F));
      Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, -4.0F, 0.1F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -9.7113F, 0.5231F, 0.0F, -2.0944F, -1.5708F));
      Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-3.6723F, -2.0F, 0.8196F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 8.5756F, 8.4625F, -2.618F, 0.4572F, -0.575F));
      Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-2.6052F, -1.5F, -0.9838F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 8.5756F, 8.4625F, -2.5285F, 0.7993F, -0.5589F));
      Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(32, 0).addBox(-2.3277F, -2.0F, 0.8196F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, 8.5756F, 8.4625F, -2.618F, -0.4572F, 0.575F));
      Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(32, 0).addBox(-3.3948F, -1.5F, -0.9838F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, 8.5756F, 8.4625F, -2.5285F, -0.7993F, 0.5589F));
      Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -4.0F, 0.7F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 7.4797F, 9.9231F, -3.1416F, -0.9163F, 1.5708F));
      Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -2.5F, 1.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.2924F, 7.8906F, 0.0F, -1.3963F, -1.5708F));
      Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -3.0F, -0.8F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.5F, 7.4797F, 9.9231F, 3.1416F, -1.2217F, 1.5708F));
      Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-1.5F, -1.0F, -2.2F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0197F, -9.3974F, 0.2647F, 0.3193F, -1.7056F));
      Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(34, 0).addBox(-2.5F, -1.0F, -2.2F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -2.0197F, -9.3974F, 0.2647F, -0.3193F, 1.7056F));
      Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -25.9352F, -4.9565F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.5F, 13.7166F, -10.9557F, -0.2182F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-7.91F, -24.6382F, -4.7804F, 2.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 35).addBox(5.91F, -24.6382F, -4.7804F, 2.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(4, 55).addBox(-3.0F, -7.6382F, 0.2196F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(2, 53).addBox(-4.0F, -9.6382F, -0.7804F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 35).addBox(-6.0F, -26.6382F, -6.7804F, 12.0F, 17.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.2312F, 6.4029F, 0.48F, 0.0F, 0.0F));
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 51).addBox(-4.0F, -5.9446F, -6.9432F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(1, 46).addBox(-3.0F, -6.9446F, -5.9432F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 57).addBox(-2.5F, 1.5554F, -6.9432F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).texOffs(0, 57).addBox(-2.5F, 0.0554F, -5.9432F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(56, 5).addBox(-2.0F, -0.8446F, -6.2432F, 4.0F, 3.0F, 0.0F, new CubeDeformation(-0.5F)).texOffs(0, 57).addBox(-3.5F, 0.0554F, -6.9432F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 57).mirror().addBox(1.5F, 0.0554F, -6.9432F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 0).addBox(-1.0F, -3.8446F, -7.9432F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-1.0F, -1.6446F, -7.9432F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 3).addBox(-1.0F, -2.4446F, -7.9432F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(48, 0).mirror().addBox(-3.5F, -1.6442F, -7.4571F, 7.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(48, 3).mirror().addBox(-3.5F, -2.1442F, -7.4571F, 7.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false).texOffs(0, 0).mirror().addBox(1.5F, -3.0442F, -7.0571F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-2.5F, -3.0442F, -7.0571F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 0).mirror().addBox(-3.5F, -3.645F, -7.4571F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.11F)).mirror(false).texOffs(48, 0).mirror().addBox(2.5F, -3.645F, -7.4571F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.11F)).mirror(false).texOffs(48, 0).mirror().addBox(-3.5F, -3.645F, -7.4571F, 7.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(48, 0).mirror().addBox(-1.5F, -3.645F, -7.4571F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.11F)).mirror(false), PartPose.offset(0.0F, 0.0F, -3.5F));
      PartDefinition Hair = Head.addOrReplaceChild("Hair", CubeListBuilder.create(), PartPose.offset(-3.0F, -0.4446F, -5.9432F));
      Hair.addOrReplaceChild("Hair_r1", CubeListBuilder.create().texOffs(34, 0).addBox(-9.0F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, -2.8233F, 14.0558F, 0.0F, -1.7453F, -1.5708F));
      Hair.addOrReplaceChild("Hair_r2", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-2.5F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.1256F, -1.1542F, 5.341F, 0.0F, 1.2217F, -0.1745F));
      Hair.addOrReplaceChild("Hair_r3", CubeListBuilder.create().texOffs(33, 0).addBox(-2.5F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(7.1256F, -1.1542F, 5.341F, 0.0F, -1.2217F, 0.1745F));
      Hair.addOrReplaceChild("Hair_r4", CubeListBuilder.create().texOffs(33, 0).addBox(-0.0905F, -4.5209F, -0.513F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(5.8F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.1745F));
      Hair.addOrReplaceChild("Hair_r5", CubeListBuilder.create().texOffs(33, 0).addBox(3.1F, -2.6F, -3.1F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, -0.8209F, -0.613F, 0.0F, -0.7854F, -0.6981F));
      Hair.addOrReplaceChild("Hair_r6", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-4.9095F, -4.5209F, -0.513F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.2F, 0.0F, 0.0F, 0.0F, 0.7854F, -0.1745F));
      Hair.addOrReplaceChild("Hair_r7", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-8.1F, -2.6F, -3.1F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.0F, -0.8209F, -0.613F, 0.0F, 0.7854F, 0.6981F));
      Hair.addOrReplaceChild("Hair_r8", CubeListBuilder.create().texOffs(33, 0).addBox(-2.5F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, -5.7556F, 4.8719F, 0.0F, -1.3963F, -1.5708F));
      Hair.addOrReplaceChild("Hair_r9", CubeListBuilder.create().texOffs(33, 0).addBox(3.1F, -4.0F, -3.5F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, -0.8209F, -0.613F, 0.0F, -0.7854F, -1.5708F));
      Hair.addOrReplaceChild("Hair_r10", CubeListBuilder.create().texOffs(35, 0).mirror().addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(6.0F, 2.3569F, -1.2211F, 0.0F, -0.5236F, -2.3562F));
      Hair.addOrReplaceChild("Hair_r11", CubeListBuilder.create().texOffs(35, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 2.3569F, -1.2211F, 0.0F, 0.5236F, 2.3562F));
      Hair.addOrReplaceChild("Hair_r12", CubeListBuilder.create().texOffs(35, 0).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, 2.9239F, -1.4711F, 0.0F, 0.5236F, 1.5708F));
      Hair.addOrReplaceChild("Hair_r13", CubeListBuilder.create().texOffs(34, 0).addBox(-4.5F, -3.0F, -1.6F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, 6.2913F, 0.9183F, 0.0F, 0.0436F, 1.5708F));
      Hair.addOrReplaceChild("Hair_r14", CubeListBuilder.create().texOffs(34, 0).addBox(-4.5F, -3.0F, -1.6F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.0F, -6.9021F, 0.5183F, 0.0F, 0.0436F, -1.5708F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.yRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
      this.LeftArm.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
