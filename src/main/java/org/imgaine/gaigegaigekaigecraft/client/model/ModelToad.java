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

public class ModelToad<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_toad"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public ModelToad(ModelPart root) {
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
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-7.2F, -15.2934F, -9.0171F, 14.0F, 4.0F, 16.0F, new CubeDeformation(0.11F)).mirror(false).texOffs(0, 38).addBox(-12.2696F, -9.0119F, -9.0171F, 24.0F, 6.0F, 16.0F, new CubeDeformation(0.1F)).texOffs(92, 24).addBox(-9.2696F, -6.0119F, -9.0171F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offset(0.2F, 0.0F, -3.0F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(21, 0).addBox(-5.5F, -29.2997F, -15.972F, 11.0F, 4.0F, 21.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.2F, 24.3078F, 5.1379F, 0.0873F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.8543F, -29.2997F, -14.0333F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.3247F, 24.8109F, -0.6108F, 0.1138F, -0.6949F, -0.073F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(1.0182F, -31.4361F, -15.4463F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.7265F, 3.6009F, 13.2505F, 1.0737F, -0.6949F, -0.073F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 36).addBox(-10.0182F, -31.4361F, -15.4463F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.3265F, 3.6009F, 13.2505F, 1.0737F, 0.6949F, 0.073F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-9.4267F, -29.2997F, -14.9331F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1756F, 24.7269F, 0.3496F, 0.1138F, 0.6949F, 0.073F));
      Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(0, 36).addBox(-5.5F, -30.4784F, -15.0239F, 11.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 2.7249F, 20.9278F, 1.0472F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(0, 36).addBox(-12.6F, -28.9919F, -7.8341F, 25.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 24.1876F, 2.9813F, 0.0873F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(0, 36).addBox(2.2948F, -32.5792F, -0.7984F, 5.0F, 9.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(11.3911F, 24.3932F, 7.4342F, 0.3334F, -0.9754F, -0.3962F));
      Head.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-6.6471F, -32.4186F, -1.9856F, 5.0F, 9.0F, 8.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-11.1289F, 24.0962F, 8.5702F, 0.3334F, 0.9754F, 0.3962F));
      Head.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(0, 36).addBox(7.4F, -32.1784F, -16.1239F, 11.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6999F, -16.9419F, 20.1336F, 0.8726F, 0.0F, 3.1416F));
      Head.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(32, 9).mirror().addBox(13.5639F, -31.9051F, -15.8236F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.2624F, -39.2788F, -9.4846F, 0.07F, -0.6998F, 2.9297F));
      Head.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(32, 9).addBox(2.7831F, -32.1371F, -14.9236F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8829F, -35.369F, 6.1653F, 0.07F, 0.6998F, -2.9297F));
      Head.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(13.3267F, -30.9997F, -16.0332F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.7507F, -35.8285F, -13.532F, -0.1138F, -0.6949F, -3.0686F));
      Head.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(0, 36).addBox(3.0457F, -30.9997F, -15.1334F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8362F, -37.1902F, 2.0277F, -0.1138F, 0.6949F, 3.0686F));
      Head.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(0, 36).addBox(2.4542F, -32.3989F, -16.0301F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.858F, -17.0684F, 19.2489F, 0.8461F, 0.6949F, 3.0686F));
      Head.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(13.9182F, -33.1361F, -16.5463F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.4452F, -15.7069F, 3.6892F, 0.8461F, -0.6949F, -3.0686F));
      Head.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(32, 11).addBox(7.3F, -30.9997F, -17.0721F, 11.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.5998F, -36.9929F, -0.2272F, -0.0873F, 0.0F, 3.1416F));
      Head.addOrReplaceChild("Head_r18", CubeListBuilder.create().texOffs(0, 36).addBox(7.2941F, -42.495F, -12.0171F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-30.3546F, 6.4738F, 3.0F, 0.0F, 0.0F, 0.8727F));
      Head.addOrReplaceChild("Head_r19", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-14.8219F, -43.5674F, -12.0171F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(30.4728F, 7.5249F, 3.0F, 0.0F, 0.0F, -0.8727F));
      Head.addOrReplaceChild("Head_r20", CubeListBuilder.create().texOffs(0, 36).addBox(-0.9405F, -34.4129F, 0.6972F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)).texOffs(0, 36).addBox(-7.0875F, -34.4129F, 0.6972F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.2F, 9.8561F, -16.4538F, -0.733F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r21", CubeListBuilder.create().texOffs(0, 36).addBox(-6.9405F, -34.1448F, 3.5904F, 14.0F, 4.0F, 11.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.2595F, -14.7353F, -22.5544F, -1.5708F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r22", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-12.2941F, -47.6075F, 2.3255F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(33.8117F, 1.7296F, -12.0785F, -0.5713F, -0.5724F, -0.7003F));
      Head.addOrReplaceChild("Head_r23", CubeListBuilder.create().texOffs(0, 36).addBox(7.2941F, -47.6075F, 2.3255F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-34.2117F, 1.7296F, -12.0785F, -0.5713F, 0.5724F, 0.7003F));
      Head.addOrReplaceChild("Head_r24", CubeListBuilder.create().texOffs(0, 36).addBox(3.6956F, -37.3418F, -16.1143F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-14.7926F, -2.264F, 21.9617F, 0.8416F, -0.3346F, 0.2854F));
      Head.addOrReplaceChild("Head_r25", CubeListBuilder.create().texOffs(0, 36).addBox(-2.8F, -2.0F, -0.8F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.09F)), PartPose.offsetAndRotation(8.9298F, -9.2635F, -8.3145F, 1.2774F, -0.744F, -0.5135F));
      Head.addOrReplaceChild("Head_r26", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-1.2F, -2.0F, -0.8F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.09F)).mirror(false), PartPose.offsetAndRotation(-9.3298F, -9.2635F, -8.3145F, 1.2774F, 0.744F, 0.5135F));
      Head.addOrReplaceChild("Head_r27", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-7.6956F, -37.3418F, -16.1143F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(14.3926F, -2.264F, 21.9617F, 0.8416F, 0.3346F, -0.2854F));
      Head.addOrReplaceChild("Head_r28", CubeListBuilder.create().texOffs(122, 0).mirror().addBox(-2.7695F, -37.9789F, -16.3127F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(8.8257F, 4.0897F, 23.4614F, 0.9716F, 0.3449F, 0.4597F));
      Head.addOrReplaceChild("Head_r29", CubeListBuilder.create().texOffs(122, 0).addBox(-0.4114F, -37.9789F, -15.5605F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-7.8256F, 4.0896F, 23.4615F, 0.9716F, -0.3449F, -0.4597F));
      Head.addOrReplaceChild("Head_r30", CubeListBuilder.create().texOffs(0, 36).addBox(-4.3887F, -37.4789F, -17.9143F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.3113F, 0.9859F, 25.9749F, 0.8901F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r31", CubeListBuilder.create().texOffs(112, 121).mirror().addBox(-1.4086F, 0.0187F, -1.8513F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(0, 120).mirror().addBox(-1.4086F, -0.9813F, -1.8513F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.1668F, -14.2606F, -9.3503F, 0.9741F, 0.4322F, -0.0276F));
      Head.addOrReplaceChild("Head_r32", CubeListBuilder.create().texOffs(124, 0).mirror().addBox(-0.3654F, -1.0408F, 0.1487F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-7.1668F, -14.2606F, -9.3503F, 0.9848F, 0.396F, -0.001F));
      Head.addOrReplaceChild("Head_r33", CubeListBuilder.create().texOffs(112, 121).addBox(-2.5914F, 0.0187F, -1.8513F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)).texOffs(0, 120).addBox(-2.5914F, -0.9813F, -1.8513F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7668F, -14.2606F, -9.3503F, 0.9741F, -0.4322F, 0.0276F));
      Head.addOrReplaceChild("Head_r34", CubeListBuilder.create().texOffs(124, 0).addBox(-1.6346F, -1.0408F, 0.1487F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(6.7668F, -14.2606F, -9.3503F, 0.9848F, -0.396F, 0.001F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-0.6082F, 0.0F, -10.0F, 14.0F, 24.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 33).mirror().addBox(-13.3918F, 0.0F, -10.0F, 14.0F, 24.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(62, 91).addBox(-7.7F, 8.1F, -16.0F, 15.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-7.7F, -10.4307F, -12.2885F, 15.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.7006F, -0.244F, 0.9163F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(2.7155F, -15.7F, -14.7933F, 8.0F, 11.0F, 10.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.6889F, 24.0F, -7.5339F, 0.0F, -0.8029F, 0.0F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(2.4155F, -20.8547F, -14.9777F, 7.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.8215F, 22.0163F, -16.4576F, -0.8793F, -0.5837F, 0.5873F));
      Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(2.5155F, -9.7307F, -11.0818F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0189F, 20.7785F, -4.1403F, 1.0811F, -0.4533F, -0.6878F));
      Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(0, 107).addBox(-7.5155F, -9.7307F, -11.0818F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0189F, 20.7785F, -4.1403F, 1.0811F, 0.4533F, 0.6878F));
      Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(62, 81).addBox(-7.7F, -20.9547F, -16.1844F, 15.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.895F, -10.643F, -0.6981F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(0, 107).addBox(-9.4155F, -20.8547F, -14.9777F, 7.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8215F, 22.0163F, -16.4576F, -0.8793F, 0.5837F, -0.5873F));
      Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(0, 107).addBox(-10.7155F, -15.7F, -14.7933F, 8.0F, 11.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.6889F, 24.0F, -7.5339F, 0.0F, 0.8029F, 0.0F));
      Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-1.0785F, -25.4944F, -10.0F, 9.0F, 5.0F, 18.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(16.7824F, 21.7231F, 0.0F, 0.0F, 0.0F, -0.5236F));
      Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(0, 33).addBox(-7.9215F, -25.4944F, -10.0F, 9.0F, 5.0F, 18.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-16.7824F, 21.7231F, 0.0F, 0.0F, 0.0F, 0.5236F));
      Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(0, 33).addBox(-13.0692F, -23.8856F, 5.8054F, 26.0F, 17.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0692F, 26.2452F, 3.5568F, 0.2618F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(0, 33).addBox(-13.0692F, -9.7642F, 1.187F, 26.0F, 8.0F, 6.0F, new CubeDeformation(0.31F)), PartPose.offsetAndRotation(0.0692F, 21.2163F, 1.8231F, -0.5672F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-10.0F, 3.0F, -10.0F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-19.8883F, -31.6046F, -13.177F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.4531F, 28.8563F, 3.4493F, -0.2618F, 0.0F, 1.1345F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-13.1451F, -2.3339F, -24.099F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(0, 37).mirror().addBox(-13.1451F, -2.3339F, -23.099F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.1854F, 19.1117F, 2.7569F, 0.0873F, 0.3927F, -0.0436F));
      RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-13.147F, -2.9763F, -25.8706F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 37).mirror().addBox(-13.147F, -2.9763F, -26.8706F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(9.9876F, 19.2501F, 10.0515F, 0.0873F, 0.0F, -0.0436F));
      RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-13.0677F, -1.9335F, -26.2958F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 37).mirror().addBox(-13.0677F, -1.9335F, -27.2958F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(4.7131F, 18.668F, 14.2894F, 0.0873F, -0.3491F, -0.1309F));
      RightArm.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-16.5535F, -14.4546F, -13.6101F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.6844F, 18.1757F, 4.97F, -0.3491F, 0.0F, -0.1309F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(10.0F, 3.0F, -10.0F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 37).addBox(13.8883F, -31.6046F, -13.177F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.4531F, 28.8563F, 3.4493F, -0.2618F, 0.0F, -1.1345F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(0, 37).addBox(10.1451F, -2.3339F, -24.099F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).texOffs(0, 37).addBox(10.1451F, -2.3339F, -23.099F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.1854F, 19.1117F, 2.7569F, 0.0873F, -0.3927F, 0.0436F));
      LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(0, 37).addBox(10.147F, -2.9763F, -25.8706F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 37).addBox(10.147F, -2.9763F, -26.8706F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-9.9876F, 19.2501F, 10.0515F, 0.0873F, 0.0F, 0.0436F));
      LeftArm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(0, 37).addBox(10.0677F, -1.9335F, -26.2958F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 37).addBox(10.0677F, -1.9335F, -27.2958F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.7131F, 18.668F, 14.2894F, 0.0873F, 0.3491F, 0.1309F));
      LeftArm.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(0, 37).addBox(10.5535F, -14.4546F, -13.6101F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.6844F, 18.1757F, 4.97F, -0.3491F, 0.0F, 0.1309F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-10.6F, 20.0F, 3.0F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-10.2481F, -18.9543F, 1.8822F, 5.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.8311F, 9.3132F, -3.1193F, 0.8727F, 0.7854F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-15.9114F, -14.2316F, -4.9166F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.4552F, 4.6415F, -10.8643F, 0.1309F, 0.5672F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-18.5042F, -1.5651F, -1.8459F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 44).mirror().addBox(-18.5042F, -1.5651F, -2.8459F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-9.2257F, 1.7504F, -21.9022F, -0.4706F, 1.3613F, -0.6186F));
      RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-15.6974F, -1.8302F, -4.8737F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 44).mirror().addBox(-15.6974F, -1.8302F, -5.8737F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-1.1839F, 1.4232F, -19.7282F, -0.1148F, 0.9903F, -0.2403F));
      RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-13.668F, -2.0167F, -7.0026F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 44).mirror().addBox(-13.668F, -2.0167F, -8.0026F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(4.8047F, 1.4866F, -15.3447F, -0.051F, 0.646F, -0.1542F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(10.6F, 20.0F, 3.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 44).addBox(5.2481F, -18.9543F, 1.8822F, 5.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8311F, 9.3132F, -3.1193F, 0.8727F, -0.7854F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 44).addBox(10.9114F, -14.2316F, -4.9166F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4552F, 4.6415F, -10.8643F, 0.1309F, -0.5672F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(0, 44).addBox(15.5042F, -1.5651F, -1.8459F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 44).addBox(15.5042F, -1.5651F, -2.8459F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(9.2257F, 1.7504F, -21.9022F, -0.4706F, -1.3613F, 0.6186F));
      LeftLeg.addOrReplaceChild("LeftLeg_r4", CubeListBuilder.create().texOffs(0, 44).addBox(12.6974F, -1.8302F, -4.8737F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 44).addBox(12.6974F, -1.8302F, -5.8737F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.1839F, 1.4232F, -19.7282F, -0.1148F, -0.9903F, 0.2403F));
      LeftLeg.addOrReplaceChild("LeftLeg_r5", CubeListBuilder.create().texOffs(0, 44).addBox(10.668F, -2.0167F, -7.0026F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 44).addBox(10.668F, -2.0167F, -8.0026F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.8047F, 1.4866F, -15.3447F, -0.051F, -0.646F, 0.1542F));
      return LayerDefinition.create(meshdefinition, 128, 128);
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
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
   }
}
