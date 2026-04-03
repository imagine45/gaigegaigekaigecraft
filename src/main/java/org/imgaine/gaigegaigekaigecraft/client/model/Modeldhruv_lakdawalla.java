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

public class Modeldhruv_lakdawalla<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modeldhruv_lakdawalla"), "main");
   public final ModelPart bone34;

   public Modeldhruv_lakdawalla(ModelPart root) {
      this.bone34 = root.getChild("bone34");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone34 = partdefinition.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition bone28 = bone34.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(3.2F, -18.56F, 3.2F, 0.0F, 0.0F, -0.3927F));
      bone28.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(24, 112).addBox(1.72F, 2.6F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.72F)).texOffs(24, 112).addBox(1.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.12F)), PartPose.offset(-3.4F, -4.72F, -1.76F));
      PartDefinition bone30 = bone28.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(24, 112).addBox(1.72F, 3.48F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-1.28F)).texOffs(24, 112).addBox(1.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.24F)), PartPose.offsetAndRotation(-5.24F, 4.12F, -1.76F, 0.0F, 0.0F, -0.4363F));
      PartDefinition bone31 = bone30.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(24, 112).addBox(-1.72F, 0.48F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).texOffs(24, 112).addBox(-2.56F, 0.04F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).texOffs(24, 112).addBox(-2.92F, -1.6F, -0.48F, 6.0F, 6.0F, 4.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(4.72F, 11.96F, 0.24F, 0.0F, -0.6981F, 0.0F));
      bone31.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(24, 112).addBox(-2.24F, -1.56F, -5.56F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.56F)), PartPose.offsetAndRotation(1.6438F, -1.5463F, 0.5914F, 0.8743F, -0.0478F, 0.2149F));
      bone31.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(24, 112).addBox(-2.24F, -1.76F, -3.96F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.52F)), PartPose.offsetAndRotation(1.32F, -0.28F, 1.56F, 0.2198F, -0.0478F, 0.2149F));
      bone31.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(24, 112).addBox(3.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.offsetAndRotation(-5.68F, -7.4149F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      bone31.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(24, 112).addBox(3.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.offsetAndRotation(-4.84F, -6.9749F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone32 = bone31.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(24, 112).addBox(-1.96F, -2.2F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.6F)), PartPose.offsetAndRotation(1.04F, 2.96F, 1.52F, -1.2217F, 0.0F, 0.0F));
      bone32.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(24, 112).addBox(3.12F, 12.72F, 4.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.offsetAndRotation(-5.08F, -11.7511F, 8.293F, -1.0036F, 0.0F, 0.0F));
      bone32.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(24, 112).addBox(3.12F, 12.72F, -0.48F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.offsetAndRotation(-5.08F, -10.6549F, 8.6589F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone33 = bone31.addOrReplaceChild("bone33", CubeListBuilder.create().texOffs(24, 112).addBox(3.12F, 8.4549F, -10.6589F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.offset(-6.4F, -8.1349F, 10.1789F));
      bone33.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(24, 112).addBox(3.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.72F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
      PartDefinition head = bone34.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 65).addBox(-4.4F, -10.84F, -4.52F, 8.0F, 7.0F, 9.0F, new CubeDeformation(-1.16F)).texOffs(58, 58).addBox(-3.92F, -11.36F, -4.0F, 7.0F, 6.0F, 8.0F, new CubeDeformation(-0.84F)).texOffs(80, 37).addBox(-3.4F, -6.24F, -3.92F, 6.0F, 4.0F, 7.0F, new CubeDeformation(-0.68F)).texOffs(109, 65).addBox(-3.4F, -4.84F, -3.92F, 6.0F, 4.0F, 5.0F, new CubeDeformation(-1.08F)), PartPose.offset(0.0F, -17.8F, 0.0F));
      PartDefinition bone13 = head.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(0.0F, -8.2F, -0.64F));
      PartDefinition bone15 = bone13.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone15.addOrReplaceChild("head_r8", CubeListBuilder.create().texOffs(178, 189).addBox(-2.92F, -0.48F, 3.52F, 5.0F, 27.0F, 2.0F, new CubeDeformation(-0.88F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
      PartDefinition bone14 = bone13.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(-1.0713F, 0.0827F, 1.1312F));
      bone14.addOrReplaceChild("head_r9", CubeListBuilder.create().texOffs(178, 189).addBox(-2.68F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.88F)), PartPose.offsetAndRotation(1.0227F, 0.0F, 0.0F, 0.3123F, -0.487F, 0.2933F));
      bone14.addOrReplaceChild("head_r10", CubeListBuilder.create().texOffs(178, 189).addBox(-2.68F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.offsetAndRotation(1.0227F, 0.0F, 0.0F, 0.4586F, -0.3543F, -0.0611F));
      bone14.addOrReplaceChild("head_r11", CubeListBuilder.create().texOffs(178, 189).addBox(-2.68F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.96F)), PartPose.offsetAndRotation(1.0227F, 0.0F, 0.0F, 0.393F, -0.4265F, 0.1108F));
      bone14.addOrReplaceChild("head_r12", CubeListBuilder.create().texOffs(178, 189).addBox(-2.68F, -0.48F, 2.44F, 5.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.offsetAndRotation(1.0227F, 0.0F, 0.0F, 0.2426F, -0.5229F, 0.4372F));
      PartDefinition bone16 = bone13.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offset(0.3913F, 0.0827F, 1.1312F));
      bone16.addOrReplaceChild("head_r13", CubeListBuilder.create().texOffs(178, 189).addBox(-3.32F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.88F)), PartPose.offsetAndRotation(-1.0227F, 0.0F, 0.0F, 0.3123F, 0.487F, -0.2933F));
      bone16.addOrReplaceChild("head_r14", CubeListBuilder.create().texOffs(178, 189).addBox(-2.32F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.offsetAndRotation(-1.0227F, 0.0F, 0.0F, 0.4586F, 0.3543F, 0.0611F));
      bone16.addOrReplaceChild("head_r15", CubeListBuilder.create().texOffs(178, 189).addBox(-2.32F, -0.48F, 2.44F, 5.0F, 26.0F, 2.0F, new CubeDeformation(-0.96F)), PartPose.offsetAndRotation(-1.0227F, 0.0F, 0.0F, 0.393F, 0.4265F, -0.1108F));
      bone16.addOrReplaceChild("head_r16", CubeListBuilder.create().texOffs(178, 189).addBox(-2.32F, -0.48F, 2.44F, 5.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.offsetAndRotation(-1.0227F, 0.0F, 0.0F, 0.2426F, 0.5229F, -0.4372F));
      PartDefinition bone6 = head.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.48F, 0.0F, 0.2618F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("head_r17", CubeListBuilder.create().texOffs(0, 126).addBox(-1.4F, -0.04F, -4.2F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.72F)).texOffs(54, 28).addBox(-1.4F, -1.32F, -4.2F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.68F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("head_r18", CubeListBuilder.create().texOffs(44, 24).addBox(-1.4F, -2.64F, -4.2F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.72F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
      PartDefinition bone9 = bone6.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.2F, 0.0F, 0.0F));
      bone9.addOrReplaceChild("head_r19", CubeListBuilder.create().texOffs(123, 119).addBox(-1.4F, -0.04F, -4.2F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.72F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4178F, 0.2493F, 0.5149F));
      PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));
      bone7.addOrReplaceChild("head_r20", CubeListBuilder.create().texOffs(122, 74).addBox(-0.6F, -0.04F, -4.2F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.72F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4178F, -0.2493F, -0.5149F));
      PartDefinition bone8 = head.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(80, 60).addBox(-2.36F, -0.76F, -4.24F, 4.0F, 3.0F, 2.0F, new CubeDeformation(-0.76F)).texOffs(36, 0).addBox(-2.88F, 0.24F, -4.28F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.84F)).texOffs(22, 0).addBox(-2.88F, -0.76F, -4.32F, 5.0F, 3.0F, 2.0F, new CubeDeformation(-1.08F)), PartPose.offset(0.0F, -4.48F, 0.0F));
      PartDefinition bone12 = bone8.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(0, 32).addBox(-2.36F, 1.04F, -3.92F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.72F)).texOffs(46, 160).addBox(-2.36F, 0.72F, -3.92F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.96F)).texOffs(0, 32).addBox(-2.36F, 0.76F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.76F)).texOffs(0, 32).addBox(-2.64F, 0.36F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.72F)).texOffs(0, 32).addBox(-0.36F, 0.76F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.76F)).texOffs(0, 32).addBox(-0.08F, 0.36F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.72F)), PartPose.offset(0.0F, 0.24F, 0.0F));
      PartDefinition bone10 = bone12.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 16).addBox(-0.92F, 2.04F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.24F)), PartPose.offset(-1.3897F, 2.1959F, 0.0F));
      bone10.addOrReplaceChild("head_r21", CubeListBuilder.create().texOffs(3, 3).addBox(-1.04F, 2.24F, -3.24F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.3897F, -2.1959F, 0.0F, 0.0F, 0.0F, 0.2618F));
      PartDefinition bone11 = bone12.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(6, 6).addBox(-0.08F, 2.04F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.24F)).texOffs(0, 6).addBox(-1.56F, 2.04F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.24F)).texOffs(4, 0).addBox(-1.56F, 0.72F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.08F)), PartPose.offset(0.7497F, 2.1959F, 0.0F));
      bone11.addOrReplaceChild("head_r22", CubeListBuilder.create().texOffs(0, 0).addBox(0.04F, 2.24F, -3.24F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.3897F, -2.1959F, 0.0F, 0.0F, 0.0F, -0.2618F));
      PartDefinition bone3 = head.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.48F, 0.28F, 0.0436F, 0.0F, 0.0F));
      PartDefinition bone2 = bone3.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("head_r23", CubeListBuilder.create().texOffs(78, 102).addBox(-4.16F, -4.36F, -4.16F, 3.0F, 6.0F, 7.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0872F, -0.0038F, 0.0874F));
      PartDefinition bone5 = bone2.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-0.76F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("head_r24", CubeListBuilder.create().texOffs(99, 30).addBox(1.08F, -4.36F, -4.16F, 3.0F, 6.0F, 7.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0872F, 0.0038F, -0.0874F));
      PartDefinition bone4 = bone2.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(-0.64F, 0.0F, 0.0F));
      PartDefinition bone = bone3.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-0.68F, 0.0F, 0.0F));
      PartDefinition bone17 = bone34.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(101, 43).addBox(-3.4F, -0.36F, -2.48F, 6.0F, 5.0F, 5.0F, new CubeDeformation(-1.12F)), PartPose.offsetAndRotation(0.0F, -22.88F, 1.2F, 0.48F, 0.0F, 0.0F));
      bone17.addOrReplaceChild("head_r25", CubeListBuilder.create().texOffs(88, 60).addBox(-4.4F, 2.6F, -1.12F, 8.0F, 5.0F, 5.0F, new CubeDeformation(-0.76F)).texOffs(90, 70).addBox(-4.08F, 9.72F, -1.6F, 7.0F, 6.0F, 5.0F, new CubeDeformation(-1.16F)).texOffs(90, 81).addBox(-4.08F, 9.72F, -1.12F, 7.0F, 6.0F, 5.0F, new CubeDeformation(-0.92F)).texOffs(80, 24).addBox(-4.08F, 6.72F, -1.12F, 7.0F, 8.0F, 5.0F, new CubeDeformation(-1.28F)).texOffs(14, 79).addBox(-4.4F, 1.72F, -1.12F, 8.0F, 9.0F, 5.0F, new CubeDeformation(-1.08F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
      PartDefinition bone18 = bone34.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(0.0F, -22.88F, 1.2F));
      bone18.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(0, 38).addBox(-6.08F, 13.16F, -1.16F, 11.0F, 6.0F, 6.0F, new CubeDeformation(-0.96F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition bone20 = bone18.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.6437F, 16.3766F, 1.9642F, -0.1678F, -0.2564F, 0.5889F));
      bone20.addOrReplaceChild("head_r26", CubeListBuilder.create().texOffs(14, 95).addBox(-6.644F, -2.7786F, -12.8487F, 8.0F, 6.0F, 4.0F, new CubeDeformation(-1.52F)).texOffs(22, 6).addBox(-4.644F, -2.7786F, -12.8487F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.72F)).texOffs(22, 22).addBox(-4.644F, -2.7786F, -7.5287F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.68F)), PartPose.offsetAndRotation(-5.0F, 2.12F, -3.92F, 0.9747F, -1.3489F, -1.1F));
      bone20.addOrReplaceChild("head_r27", CubeListBuilder.create().texOffs(34, 87).addBox(-4.08F, -0.96F, -1.16F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.44F)), PartPose.offsetAndRotation(-2.76F, -0.72F, -2.84F, 0.5145F, -1.2441F, -0.8039F));
      bone20.addOrReplaceChild("head_r28", CubeListBuilder.create().texOffs(70, 12).addBox(-4.08F, -0.96F, -1.16F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-1.9854F, -0.9022F, -3.2441F, 0.1762F, -0.4488F, -0.3894F));
      PartDefinition bone21 = bone18.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offsetAndRotation(3.9963F, 16.6566F, 1.5242F, 0.0F, 0.0F, -0.6981F));
      bone21.addOrReplaceChild("head_r29", CubeListBuilder.create().texOffs(90, 92).addBox(2.9793F, -1.0762F, -8.2943F, 8.0F, 6.0F, 4.0F, new CubeDeformation(-1.52F)).texOffs(0, 0).addBox(2.9793F, -1.0762F, -8.2943F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.72F)).texOffs(0, 16).addBox(2.9793F, -1.0762F, -2.9743F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.6F)), PartPose.offsetAndRotation(-0.1271F, -1.1822F, -0.1241F, 0.9747F, 1.3489F, 1.4491F));
      bone21.addOrReplaceChild("head_r30", CubeListBuilder.create().texOffs(80, 48).addBox(0.8242F, -1.8929F, 0.5243F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.44F)), PartPose.offsetAndRotation(-0.1271F, -1.1822F, -0.1241F, 0.5145F, 1.2441F, 1.1529F));
      bone21.addOrReplaceChild("head_r31", CubeListBuilder.create().texOffs(70, 0).addBox(-2.3568F, -1.8929F, -2.7615F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-0.1271F, -1.1822F, -0.1241F, 0.1762F, 0.4488F, 0.7384F));
      PartDefinition bone22 = bone34.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.88F, -18.56F, 3.2F, 0.0F, 0.0F, 0.3927F));
      bone22.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(24, 112).addBox(-6.72F, 2.6F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.72F)).texOffs(58, 100).addBox(-6.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.12F)), PartPose.offset(3.4F, -4.72F, -1.76F));
      PartDefinition bone24 = bone22.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(109, 53).addBox(-6.72F, 3.48F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-1.28F)).texOffs(100, 13).addBox(-6.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.24F)), PartPose.offsetAndRotation(5.24F, 4.12F, -1.76F, 0.0F, 0.0F, 0.4363F));
      PartDefinition bone25 = bone24.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(78, 118).addBox(-2.28F, 0.48F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).texOffs(0, 116).addBox(-1.44F, 0.04F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).texOffs(44, 113).addBox(-3.08F, -1.6F, -0.48F, 6.0F, 6.0F, 4.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(-4.72F, 11.96F, 0.24F, 0.0F, 0.6981F, 0.0F));
      bone25.addOrReplaceChild("head_r32", CubeListBuilder.create().texOffs(64, 113).addBox(-1.76F, -1.56F, -5.56F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.56F)), PartPose.offsetAndRotation(-1.6438F, -1.5463F, 0.5914F, 0.8743F, 0.0478F, -0.2149F));
      bone25.addOrReplaceChild("head_r33", CubeListBuilder.create().texOffs(93, 113).addBox(-1.76F, -1.76F, -3.96F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.52F)), PartPose.offsetAndRotation(-1.32F, -0.28F, 1.56F, 0.2198F, 0.0478F, -0.2149F));
      bone25.addOrReplaceChild("head_r34", CubeListBuilder.create().texOffs(123, 106).addBox(-7.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.offsetAndRotation(5.68F, -7.4149F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      bone25.addOrReplaceChild("head_r35", CubeListBuilder.create().texOffs(110, 123).addBox(-7.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.offsetAndRotation(4.84F, -6.9749F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone27 = bone25.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(124, 48).addBox(-2.04F, -2.2F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.6F)), PartPose.offsetAndRotation(-1.04F, 2.96F, 1.52F, -1.2217F, 0.0F, 0.0F));
      bone27.addOrReplaceChild("head_r36", CubeListBuilder.create().texOffs(28, 123).addBox(-7.12F, 12.72F, 4.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.offsetAndRotation(5.08F, -11.7511F, 8.293F, -1.0036F, 0.0F, 0.0F));
      bone27.addOrReplaceChild("head_r37", CubeListBuilder.create().texOffs(120, 18).addBox(-7.12F, 12.72F, -0.48F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.offsetAndRotation(5.08F, -10.6549F, 8.6589F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone26 = bone25.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(123, 81).addBox(-7.12F, 8.4549F, -10.6589F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.offset(6.4F, -8.1349F, 10.1789F));
      bone26.addOrReplaceChild("head_r38", CubeListBuilder.create().texOffs(44, 123).addBox(-7.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.72F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 256, 256);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone34.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
