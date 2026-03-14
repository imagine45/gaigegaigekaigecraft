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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modeldhruv_lakdawalla"), "main");
   public final ModelPart bone34;

   public Modeldhruv_lakdawalla(ModelPart root) {
      this.bone34 = root.m_171324_("bone34");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone34 = partdefinition.m_171599_("bone34", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      PartDefinition bone28 = bone34.m_171599_("bone28", CubeListBuilder.m_171558_(), PartPose.m_171423_(3.2F, -18.56F, 3.2F, 0.0F, 0.0F, -0.3927F));
      bone28.m_171599_("bone29", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(1.72F, 2.6F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.72F)).m_171514_(24, 112).m_171488_(1.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.12F)), PartPose.m_171419_(-3.4F, -4.72F, -1.76F));
      PartDefinition bone30 = bone28.m_171599_("bone30", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(1.72F, 3.48F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-1.28F)).m_171514_(24, 112).m_171488_(1.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.24F)), PartPose.m_171423_(-5.24F, 4.12F, -1.76F, 0.0F, 0.0F, -0.4363F));
      PartDefinition bone31 = bone30.m_171599_("bone31", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(-1.72F, 0.48F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).m_171514_(24, 112).m_171488_(-2.56F, 0.04F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).m_171514_(24, 112).m_171488_(-2.92F, -1.6F, -0.48F, 6.0F, 6.0F, 4.0F, new CubeDeformation(-1.4F)), PartPose.m_171423_(4.72F, 11.96F, 0.24F, 0.0F, -0.6981F, 0.0F));
      bone31.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(-2.24F, -1.56F, -5.56F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.56F)), PartPose.m_171423_(1.6438F, -1.5463F, 0.5914F, 0.8743F, -0.0478F, 0.2149F));
      bone31.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(-2.24F, -1.76F, -3.96F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.52F)), PartPose.m_171423_(1.32F, -0.28F, 1.56F, 0.2198F, -0.0478F, 0.2149F));
      bone31.m_171599_("head_r3", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(3.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.m_171423_(-5.68F, -7.4149F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      bone31.m_171599_("head_r4", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(3.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.m_171423_(-4.84F, -6.9749F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone32 = bone31.m_171599_("bone32", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(-1.96F, -2.2F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.6F)), PartPose.m_171423_(1.04F, 2.96F, 1.52F, -1.2217F, 0.0F, 0.0F));
      bone32.m_171599_("head_r5", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(3.12F, 12.72F, 4.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.m_171423_(-5.08F, -11.7511F, 8.293F, -1.0036F, 0.0F, 0.0F));
      bone32.m_171599_("head_r6", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(3.12F, 12.72F, -0.48F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.m_171423_(-5.08F, -10.6549F, 8.6589F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone33 = bone31.m_171599_("bone33", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(3.12F, 8.4549F, -10.6589F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.m_171419_(-6.4F, -8.1349F, 10.1789F));
      bone33.m_171599_("head_r7", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(3.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.72F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
      PartDefinition head = bone34.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(32, 65).m_171488_(-4.4F, -10.84F, -4.52F, 8.0F, 7.0F, 9.0F, new CubeDeformation(-1.16F)).m_171514_(58, 58).m_171488_(-3.92F, -11.36F, -4.0F, 7.0F, 6.0F, 8.0F, new CubeDeformation(-0.84F)).m_171514_(80, 37).m_171488_(-3.4F, -6.24F, -3.92F, 6.0F, 4.0F, 7.0F, new CubeDeformation(-0.68F)).m_171514_(109, 65).m_171488_(-3.4F, -4.84F, -3.92F, 6.0F, 4.0F, 5.0F, new CubeDeformation(-1.08F)), PartPose.m_171419_(0.0F, -17.8F, 0.0F));
      PartDefinition bone13 = head.m_171599_("bone13", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -8.2F, -0.64F));
      PartDefinition bone15 = bone13.m_171599_("bone15", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone15.m_171599_("head_r8", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.92F, -0.48F, 3.52F, 5.0F, 27.0F, 2.0F, new CubeDeformation(-0.88F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
      PartDefinition bone14 = bone13.m_171599_("bone14", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.0713F, 0.0827F, 1.1312F));
      bone14.m_171599_("head_r9", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.68F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.88F)), PartPose.m_171423_(1.0227F, 0.0F, 0.0F, 0.3123F, -0.487F, 0.2933F));
      bone14.m_171599_("head_r10", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.68F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.m_171423_(1.0227F, 0.0F, 0.0F, 0.4586F, -0.3543F, -0.0611F));
      bone14.m_171599_("head_r11", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.68F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.96F)), PartPose.m_171423_(1.0227F, 0.0F, 0.0F, 0.393F, -0.4265F, 0.1108F));
      bone14.m_171599_("head_r12", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.68F, -0.48F, 2.44F, 5.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.m_171423_(1.0227F, 0.0F, 0.0F, 0.2426F, -0.5229F, 0.4372F));
      PartDefinition bone16 = bone13.m_171599_("bone16", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.3913F, 0.0827F, 1.1312F));
      bone16.m_171599_("head_r13", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-3.32F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.88F)), PartPose.m_171423_(-1.0227F, 0.0F, 0.0F, 0.3123F, 0.487F, -0.2933F));
      bone16.m_171599_("head_r14", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.32F, -0.48F, 2.44F, 6.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.m_171423_(-1.0227F, 0.0F, 0.0F, 0.4586F, 0.3543F, 0.0611F));
      bone16.m_171599_("head_r15", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.32F, -0.48F, 2.44F, 5.0F, 26.0F, 2.0F, new CubeDeformation(-0.96F)), PartPose.m_171423_(-1.0227F, 0.0F, 0.0F, 0.393F, 0.4265F, -0.1108F));
      bone16.m_171599_("head_r16", CubeListBuilder.m_171558_().m_171514_(178, 189).m_171488_(-2.32F, -0.48F, 2.44F, 5.0F, 26.0F, 2.0F, new CubeDeformation(-0.92F)), PartPose.m_171423_(-1.0227F, 0.0F, 0.0F, 0.2426F, 0.5229F, -0.4372F));
      PartDefinition bone6 = head.m_171599_("bone6", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -4.48F, 0.0F, 0.2618F, 0.0F, 0.0F));
      bone6.m_171599_("head_r17", CubeListBuilder.m_171558_().m_171514_(0, 126).m_171488_(-1.4F, -0.04F, -4.2F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.72F)).m_171514_(54, 28).m_171488_(-1.4F, -1.32F, -4.2F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.68F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));
      bone6.m_171599_("head_r18", CubeListBuilder.m_171558_().m_171514_(44, 24).m_171488_(-1.4F, -2.64F, -4.2F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.72F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
      PartDefinition bone9 = bone6.m_171599_("bone9", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.2F, 0.0F, 0.0F));
      bone9.m_171599_("head_r19", CubeListBuilder.m_171558_().m_171514_(123, 119).m_171488_(-1.4F, -0.04F, -4.2F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.72F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.4178F, 0.2493F, 0.5149F));
      PartDefinition bone7 = bone6.m_171599_("bone7", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.0F, 0.0F, 0.0F));
      bone7.m_171599_("head_r20", CubeListBuilder.m_171558_().m_171514_(122, 74).m_171488_(-0.6F, -0.04F, -4.2F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.72F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.4178F, -0.2493F, -0.5149F));
      PartDefinition bone8 = head.m_171599_("bone8", CubeListBuilder.m_171558_().m_171514_(80, 60).m_171488_(-2.36F, -0.76F, -4.24F, 4.0F, 3.0F, 2.0F, new CubeDeformation(-0.76F)).m_171514_(36, 0).m_171488_(-2.88F, 0.24F, -4.28F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.84F)).m_171514_(22, 0).m_171488_(-2.88F, -0.76F, -4.32F, 5.0F, 3.0F, 2.0F, new CubeDeformation(-1.08F)), PartPose.m_171419_(0.0F, -4.48F, 0.0F));
      PartDefinition bone12 = bone8.m_171599_("bone12", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-2.36F, 1.04F, -3.92F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.72F)).m_171514_(46, 160).m_171488_(-2.36F, 0.72F, -3.92F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.96F)).m_171514_(0, 32).m_171488_(-2.36F, 0.76F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.76F)).m_171514_(0, 32).m_171488_(-2.64F, 0.36F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.72F)).m_171514_(0, 32).m_171488_(-0.36F, 0.76F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.76F)).m_171514_(0, 32).m_171488_(-0.08F, 0.36F, -4.04F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.72F)), PartPose.m_171419_(0.0F, 0.24F, 0.0F));
      PartDefinition bone10 = bone12.m_171599_("bone10", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-0.92F, 2.04F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.24F)), PartPose.m_171419_(-1.3897F, 2.1959F, 0.0F));
      bone10.m_171599_("head_r21", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-1.04F, 2.24F, -3.24F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(1.3897F, -2.1959F, 0.0F, 0.0F, 0.0F, 0.2618F));
      PartDefinition bone11 = bone12.m_171599_("bone11", CubeListBuilder.m_171558_().m_171514_(6, 6).m_171488_(-0.08F, 2.04F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.24F)).m_171514_(0, 6).m_171488_(-1.56F, 2.04F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.24F)).m_171514_(4, 0).m_171488_(-1.56F, 0.72F, -3.24F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.08F)), PartPose.m_171419_(0.7497F, 2.1959F, 0.0F));
      bone11.m_171599_("head_r22", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.04F, 2.24F, -3.24F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-1.3897F, -2.1959F, 0.0F, 0.0F, 0.0F, -0.2618F));
      PartDefinition bone3 = head.m_171599_("bone3", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -4.48F, 0.28F, 0.0436F, 0.0F, 0.0F));
      PartDefinition bone2 = bone3.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone2.m_171599_("head_r23", CubeListBuilder.m_171558_().m_171514_(78, 102).m_171488_(-4.16F, -4.36F, -4.16F, 3.0F, 6.0F, 7.0F, new CubeDeformation(-0.8F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.0872F, -0.0038F, 0.0874F));
      PartDefinition bone5 = bone2.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.76F, 0.0F, 0.0F));
      bone5.m_171599_("head_r24", CubeListBuilder.m_171558_().m_171514_(99, 30).m_171488_(1.08F, -4.36F, -4.16F, 3.0F, 6.0F, 7.0F, new CubeDeformation(-0.8F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.0872F, 0.0038F, -0.0874F));
      PartDefinition bone4 = bone2.m_171599_("bone4", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.64F, 0.0F, 0.0F));
      PartDefinition bone = bone3.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.68F, 0.0F, 0.0F));
      PartDefinition bone17 = bone34.m_171599_("bone17", CubeListBuilder.m_171558_().m_171514_(101, 43).m_171488_(-3.4F, -0.36F, -2.48F, 6.0F, 5.0F, 5.0F, new CubeDeformation(-1.12F)), PartPose.m_171423_(0.0F, -22.88F, 1.2F, 0.48F, 0.0F, 0.0F));
      bone17.m_171599_("head_r25", CubeListBuilder.m_171558_().m_171514_(88, 60).m_171488_(-4.4F, 2.6F, -1.12F, 8.0F, 5.0F, 5.0F, new CubeDeformation(-0.76F)).m_171514_(90, 70).m_171488_(-4.08F, 9.72F, -1.6F, 7.0F, 6.0F, 5.0F, new CubeDeformation(-1.16F)).m_171514_(90, 81).m_171488_(-4.08F, 9.72F, -1.12F, 7.0F, 6.0F, 5.0F, new CubeDeformation(-0.92F)).m_171514_(80, 24).m_171488_(-4.08F, 6.72F, -1.12F, 7.0F, 8.0F, 5.0F, new CubeDeformation(-1.28F)).m_171514_(14, 79).m_171488_(-4.4F, 1.72F, -1.12F, 8.0F, 9.0F, 5.0F, new CubeDeformation(-1.08F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
      PartDefinition bone18 = bone34.m_171599_("bone18", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -22.88F, 1.2F));
      bone18.m_171599_("bone19", CubeListBuilder.m_171558_().m_171514_(0, 38).m_171488_(-6.08F, 13.16F, -1.16F, 11.0F, 6.0F, 6.0F, new CubeDeformation(-0.96F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition bone20 = bone18.m_171599_("bone20", CubeListBuilder.m_171558_(), PartPose.m_171423_(-4.6437F, 16.3766F, 1.9642F, -0.1678F, -0.2564F, 0.5889F));
      bone20.m_171599_("head_r26", CubeListBuilder.m_171558_().m_171514_(14, 95).m_171488_(-6.644F, -2.7786F, -12.8487F, 8.0F, 6.0F, 4.0F, new CubeDeformation(-1.52F)).m_171514_(22, 6).m_171488_(-4.644F, -2.7786F, -12.8487F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.72F)).m_171514_(22, 22).m_171488_(-4.644F, -2.7786F, -7.5287F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.68F)), PartPose.m_171423_(-5.0F, 2.12F, -3.92F, 0.9747F, -1.3489F, -1.1F));
      bone20.m_171599_("head_r27", CubeListBuilder.m_171558_().m_171514_(34, 87).m_171488_(-4.08F, -0.96F, -1.16F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.44F)), PartPose.m_171423_(-2.76F, -0.72F, -2.84F, 0.5145F, -1.2441F, -0.8039F));
      bone20.m_171599_("head_r28", CubeListBuilder.m_171558_().m_171514_(70, 12).m_171488_(-4.08F, -0.96F, -1.16F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-1.9854F, -0.9022F, -3.2441F, 0.1762F, -0.4488F, -0.3894F));
      PartDefinition bone21 = bone18.m_171599_("bone21", CubeListBuilder.m_171558_(), PartPose.m_171423_(3.9963F, 16.6566F, 1.5242F, 0.0F, 0.0F, -0.6981F));
      bone21.m_171599_("head_r29", CubeListBuilder.m_171558_().m_171514_(90, 92).m_171488_(2.9793F, -1.0762F, -8.2943F, 8.0F, 6.0F, 4.0F, new CubeDeformation(-1.52F)).m_171514_(0, 0).m_171488_(2.9793F, -1.0762F, -8.2943F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.72F)).m_171514_(0, 16).m_171488_(2.9793F, -1.0762F, -2.9743F, 6.0F, 6.0F, 10.0F, new CubeDeformation(-1.6F)), PartPose.m_171423_(-0.1271F, -1.1822F, -0.1241F, 0.9747F, 1.3489F, 1.4491F));
      bone21.m_171599_("head_r30", CubeListBuilder.m_171558_().m_171514_(80, 48).m_171488_(0.8242F, -1.8929F, 0.5243F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.44F)), PartPose.m_171423_(-0.1271F, -1.1822F, -0.1241F, 0.5145F, 1.2441F, 1.1529F));
      bone21.m_171599_("head_r31", CubeListBuilder.m_171558_().m_171514_(70, 0).m_171488_(-2.3568F, -1.8929F, -2.7615F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-0.1271F, -1.1822F, -0.1241F, 0.1762F, 0.4488F, 0.7384F));
      PartDefinition bone22 = bone34.m_171599_("bone22", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.88F, -18.56F, 3.2F, 0.0F, 0.0F, 0.3927F));
      bone22.m_171599_("bone23", CubeListBuilder.m_171558_().m_171514_(24, 112).m_171488_(-6.72F, 2.6F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.72F)).m_171514_(58, 100).m_171488_(-6.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.12F)), PartPose.m_171419_(3.4F, -4.72F, -1.76F));
      PartDefinition bone24 = bone22.m_171599_("bone24", CubeListBuilder.m_171558_().m_171514_(109, 53).m_171488_(-6.72F, 3.48F, -1.12F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-1.28F)).m_171514_(100, 13).m_171488_(-6.72F, 6.0F, -1.12F, 5.0F, 8.0F, 5.0F, new CubeDeformation(-1.24F)), PartPose.m_171423_(5.24F, 4.12F, -1.76F, 0.0F, 0.0F, 0.4363F));
      PartDefinition bone25 = bone24.m_171599_("bone25", CubeListBuilder.m_171558_().m_171514_(78, 118).m_171488_(-2.28F, 0.48F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).m_171514_(0, 116).m_171488_(-1.44F, 0.04F, -0.48F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-1.6F)).m_171514_(44, 113).m_171488_(-3.08F, -1.6F, -0.48F, 6.0F, 6.0F, 4.0F, new CubeDeformation(-1.4F)), PartPose.m_171423_(-4.72F, 11.96F, 0.24F, 0.0F, 0.6981F, 0.0F));
      bone25.m_171599_("head_r32", CubeListBuilder.m_171558_().m_171514_(64, 113).m_171488_(-1.76F, -1.56F, -5.56F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.56F)), PartPose.m_171423_(-1.6438F, -1.5463F, 0.5914F, 0.8743F, 0.0478F, -0.2149F));
      bone25.m_171599_("head_r33", CubeListBuilder.m_171558_().m_171514_(93, 113).m_171488_(-1.76F, -1.76F, -3.96F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.52F)), PartPose.m_171423_(-1.32F, -0.28F, 1.56F, 0.2198F, 0.0478F, -0.2149F));
      bone25.m_171599_("head_r34", CubeListBuilder.m_171558_().m_171514_(123, 106).m_171488_(-7.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.m_171423_(5.68F, -7.4149F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      bone25.m_171599_("head_r35", CubeListBuilder.m_171558_().m_171514_(110, 123).m_171488_(-7.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.m_171423_(4.84F, -6.9749F, 10.1789F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone27 = bone25.m_171599_("bone27", CubeListBuilder.m_171558_().m_171514_(124, 48).m_171488_(-2.04F, -2.2F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.6F)), PartPose.m_171423_(-1.04F, 2.96F, 1.52F, -1.2217F, 0.0F, 0.0F));
      bone27.m_171599_("head_r36", CubeListBuilder.m_171558_().m_171514_(28, 123).m_171488_(-7.12F, 12.72F, 4.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.m_171423_(5.08F, -11.7511F, 8.293F, -1.0036F, 0.0F, 0.0F));
      bone27.m_171599_("head_r37", CubeListBuilder.m_171558_().m_171514_(120, 18).m_171488_(-7.12F, 12.72F, -0.48F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.64F)), PartPose.m_171423_(5.08F, -10.6549F, 8.6589F, -0.7418F, 0.0F, 0.0F));
      PartDefinition bone26 = bone25.m_171599_("bone26", CubeListBuilder.m_171558_().m_171514_(123, 81).m_171488_(-7.12F, 8.4549F, -10.6589F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.68F)), PartPose.m_171419_(6.4F, -8.1349F, 10.1789F));
      bone26.m_171599_("head_r38", CubeListBuilder.m_171558_().m_171514_(44, 123).m_171488_(-7.12F, 12.72F, -0.48F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-1.72F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 256, 256);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone34.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
