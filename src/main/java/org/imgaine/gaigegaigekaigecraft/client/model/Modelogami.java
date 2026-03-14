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

public class Modelogami<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelogami"), "main");
   public final ModelPart head;
   public final ModelPart bone8;

   public Modelogami(ModelPart root) {
      this.head = root.m_171324_("head");
      this.bone8 = root.m_171324_("bone8");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 8.0F, -4.0F));
      PartDefinition bone6 = head.m_171599_("bone6", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.3842F, -0.6125F, -0.1745F, 0.0F, 0.0F));
      bone6.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 47).m_171488_(0.7F, 0.1158F, -2.1875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-0.1569F, -0.1628F, -0.8787F, 0.0F, 0.0F, 0.0873F));
      bone6.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(38, 51).m_171488_(-2.7F, 0.1158F, -2.1875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(0.1569F, -0.1628F, -0.8787F, 0.0F, 0.0F, -0.0873F));
      bone6.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(25, 29).m_171488_(-1.0F, 0.1144F, -1.195F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(25, 29).m_171488_(-1.0F, 0.1144F, -2.095F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.8199F, -1.0618F, 0.5672F, 0.0F, 0.0F));
      PartDefinition bone5 = head.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -1.2158F, -2.6125F, 0.3491F, 0.0F, 0.0F));
      bone5.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171480_().m_171488_(0.7F, 0.2158F, -2.3875F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.7F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));
      bone5.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171488_(-2.7F, 0.2158F, -2.3875F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
      PartDefinition bone4 = head.m_171599_("bone4", CubeListBuilder.m_171558_().m_171514_(0, 90).m_171488_(-3.9025F, -1.7842F, -2.5978F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 90).m_171480_().m_171488_(-2.9025F, -1.7842F, -2.5978F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(2.9025F, -0.5158F, -1.4022F, -0.2618F, 0.0F, 0.0F));
      bone4.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(93, 96).m_171480_().m_171488_(0.3F, -0.7842F, -1.9875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-4.9398F, 0.1F, -0.0425F, 0.0F, 0.48F, 0.0F));
      bone4.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(93, 96).m_171488_(-2.3F, -0.7842F, -1.9875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.8651F, 0.1F, -0.0425F, 0.0F, -0.48F, 0.0F));
      PartDefinition bone3 = head.m_171599_("bone3", CubeListBuilder.m_171558_().m_171514_(65, 85).m_171488_(-4.9025F, -0.4842F, -2.5978F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(65, 85).m_171480_().m_171488_(-2.9025F, -0.4842F, -2.5978F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(2.9025F, -1.2158F, -1.4022F));
      bone3.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171488_(-2.0F, -1.4842F, 1.2125F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.9025F, 0.0F, -0.7102F, -0.3921F, -0.0095F, 0.0048F));
      PartDefinition bone = head.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -1.8596F, -1.8368F, 0.0873F, 0.0F, 0.0F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(89, 0).m_171488_(-1.0F, 0.6262F, -3.292F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.81F)), PartPose.m_171423_(0.0F, -0.5313F, -0.224F, 0.0873F, 0.0F, 0.0F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(88, 65).m_171488_(-1.0F, -0.1738F, -2.892F, 2.0F, 4.0F, 3.0F, new CubeDeformation(-0.8F)), PartPose.m_171423_(0.0F, 0.4438F, -0.1756F, -0.6109F, 0.0F, 0.0F));
      PartDefinition bone13 = bone.m_171599_("bone13", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.4438F, -0.1756F));
      bone13.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(81, 85).m_171488_(-2.8F, 0.5262F, -3.092F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).m_171514_(48, 19).m_171488_(-2.8F, -1.5738F, -2.992F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3622F, -0.7519F, 0.2533F));
      PartDefinition bone14 = bone.m_171599_("bone14", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.4438F, -0.1756F));
      bone14.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(81, 85).m_171480_().m_171488_(-0.2F, 0.5262F, -3.092F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false).m_171514_(48, 19).m_171480_().m_171488_(-0.2F, -1.5738F, -2.992F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3622F, 0.7519F, -0.2533F));
      PartDefinition bone15 = head.m_171599_("bone15", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -1.0158F, -2.1125F));
      bone15.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(21, 99).m_171488_(-3.5F, -3.7738F, -3.392F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(0, 65).m_171488_(-1.5F, -6.0738F, -1.392F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).m_171514_(0, 65).m_171488_(-1.5F, -4.0738F, -4.192F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.074F, 0.3643F, -0.3054F, 0.0F, 0.0F));
      bone15.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171480_().m_171488_(-1.1F, -3.1738F, -4.292F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.074F, 0.3643F, -1.5708F, -1.2654F, 1.5708F));
      bone15.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171488_(-1.5F, -4.0738F, -4.992F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.074F, 0.3643F, -2.8362F, 0.0F, 3.1416F));
      bone15.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 65).m_171488_(-1.9F, -3.1738F, -4.292F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.074F, 0.3643F, -1.5708F, 1.2654F, -1.5708F));
      PartDefinition bone2 = head.m_171599_("bone2", CubeListBuilder.m_171558_().m_171514_(0, 78).m_171488_(-2.5F, -1.6998F, -0.5276F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(0.0F, -1.0158F, -2.1125F));
      bone2.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(2, 28).m_171480_().m_171488_(-2.5F, -2.6738F, -2.092F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(2, 28).m_171488_(-0.5F, -2.6738F, -2.092F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).m_171514_(21, 58).m_171488_(-2.0F, -2.4738F, -2.592F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
      bone2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(31, 9).m_171488_(-2.5F, -1.3738F, -0.592F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
      PartDefinition bone8 = partdefinition.m_171599_("bone8", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.1259F, 8.8509F, -1.0388F));
      bone8.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(65, 0).m_171488_(-4.5F, -2.0738F, 1.008F, 9.0F, 3.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -1.0457F, 0.0311F, -0.0058F));
      bone8.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(34, 62).m_171488_(-4.5F, -6.6738F, 4.608F, 9.0F, 3.0F, 9.0F, new CubeDeformation(-0.4F)).m_171514_(0, 0).m_171488_(-4.5F, -4.0738F, 1.008F, 9.0F, 4.0F, 13.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.1259F, -1.7928F, -3.7093F, -1.482F, 0.0311F, -0.0058F));
      bone8.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(38, 41).m_171480_().m_171488_(0.5F, -5.2738F, 2.008F, 4.0F, 5.0F, 15.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-0.1259F, -1.7928F, -3.7093F, -1.6034F, -0.041F, -0.256F));
      bone8.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(38, 41).m_171488_(-4.5F, -5.2738F, 2.008F, 4.0F, 5.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-0.1259F, -1.7928F, -3.7093F, -1.6034F, 0.041F, 0.256F));
      bone8.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(25, 22).m_171480_().m_171488_(1.2F, -4.0738F, 1.008F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-0.1259F, -1.7928F, -3.7093F, -1.6154F, -0.0273F, 0.093F));
      bone8.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(25, 22).m_171488_(-5.2F, -4.0738F, 1.008F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.1259F, -1.7928F, -3.7093F, -1.6154F, 0.0273F, -0.093F));
      bone8.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(71, 57).m_171488_(-4.5F, -2.0738F, 1.008F, 9.0F, 3.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.1259F, -1.7928F, -3.7093F, -0.6093F, 0.0311F, -0.0058F));
      bone8.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(58, 99).m_171488_(-4.5F, -2.0738F, 1.008F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.1186F, 4.3358F, 3.0018F, -1.3511F, 0.0311F, -0.0058F));
      PartDefinition right_leg = bone8.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-2.1259F, 11.2072F, -1.7093F));
      right_leg.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(73, 14).m_171488_(-5.7F, -7.0738F, 12.008F, 7.0F, 11.0F, 5.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(2.0F, -13.0F, -2.0F, -1.523F, 0.3362F, 0.0086F));
      PartDefinition right_leg2 = right_leg.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.2473F, 1.6529F, -1.8037F));
      right_leg2.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(53, 80).m_171480_().m_171488_(-2.8F, -13.0738F, 12.008F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(1.7527F, -14.6529F, -1.1963F, -1.6129F, -0.0311F, 0.0058F));
      right_leg2.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(65, 69).m_171488_(-4.5F, -9.2738F, 12.008F, 5.0F, 11.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(1.7527F, -14.6529F, -0.1963F, -1.5256F, 0.0311F, -0.0058F));
      PartDefinition left_leg = bone8.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.8741F, 11.2072F, -1.7093F));
      left_leg.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(73, 14).m_171480_().m_171488_(-1.3F, -7.0738F, 12.008F, 7.0F, 11.0F, 5.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-2.0F, -13.0F, -2.0F, -1.523F, -0.3362F, -0.0086F));
      PartDefinition left_leg2 = left_leg.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.2473F, 1.6529F, -1.8037F));
      left_leg2.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(53, 80).m_171488_(-0.2F, -13.0738F, 12.008F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(-1.7527F, -14.6529F, -1.1963F, -1.6129F, 0.0311F, -0.0058F));
      left_leg2.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(65, 69).m_171480_().m_171488_(-0.5F, -9.2738F, 12.008F, 5.0F, 11.0F, 5.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(-1.7527F, -14.6529F, -0.1963F, -1.5256F, -0.0311F, 0.0058F));
      PartDefinition bone11 = bone8.m_171599_("bone11", CubeListBuilder.m_171558_(), PartPose.m_171423_(-0.7334F, -1.456F, -1.6461F, 0.3927F, -0.0436F, 0.0F));
      bone11.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171488_(0.5F, -6.0738F, 2.008F, 4.0F, 6.0F, 13.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -2.2662F, 0.2522F, -0.5511F));
      bone11.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(67, 43).m_171488_(0.5F, -6.0738F, 8.008F, 4.0F, 6.0F, 6.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.3533F, 0.3128F, 0.5323F, -2.5717F, 0.2522F, -0.5511F));
      PartDefinition bone17 = bone11.m_171599_("bone17", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.3467F, 0.3128F, 0.5323F));
      bone17.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(0.7F, -2.0738F, 7.608F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -2.5717F, 0.2522F, -0.5511F));
      PartDefinition bone10 = bone17.m_171599_("bone10", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.7968F, -2.8777F, 0.4571F));
      bone10.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.2F, 1.7262F, -10.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171514_(24, 17).m_171488_(-1.2F, 1.5262F, -10.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171514_(24, 17).m_171488_(-1.2F, 1.5262F, -11.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171514_(24, 17).m_171488_(-1.2F, 2.2262F, -11.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.215F, 0.0376F, -0.0477F));
      bone10.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.0F, 2.0262F, -11.692F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(-0.4968F, 2.1777F, -0.4571F, -0.218F, 0.0094F, -0.1756F));
      bone10.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.0F, 7.0262F, -3.692F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-0.4968F, 2.1777F, -0.4571F, -1.1343F, 0.0094F, -0.1756F));
      PartDefinition bone12 = bone8.m_171599_("bone12", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.4817F, -1.456F, -1.6461F, 0.3927F, 0.0436F, 0.0F));
      bone12.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171480_().m_171488_(-4.5F, -6.0738F, 2.008F, 4.0F, 6.0F, 13.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -2.2662F, -0.2522F, 0.5511F));
      bone12.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(67, 43).m_171480_().m_171488_(-4.5F, -6.0738F, 8.008F, 4.0F, 6.0F, 6.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-0.3533F, 0.3128F, 0.5323F, -2.5717F, -0.2522F, 0.5511F));
      PartDefinition bone16 = bone12.m_171599_("bone16", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.3467F, 0.3128F, 0.5323F));
      bone16.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171480_().m_171488_(-4.7F, -2.0738F, 7.608F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-1.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -2.5717F, -0.2522F, 0.5511F));
      PartDefinition bone18 = bone16.m_171599_("bone18", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.7968F, -2.8777F, 0.4571F));
      bone18.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171480_().m_171488_(-1.8F, 1.7262F, -10.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171555_(false).m_171514_(24, 17).m_171480_().m_171488_(-1.8F, 1.5262F, -10.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171555_(false).m_171514_(24, 17).m_171480_().m_171488_(-1.8F, 1.5262F, -11.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171555_(false).m_171514_(24, 17).m_171480_().m_171488_(-1.8F, 2.2262F, -11.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.215F, -0.0376F, 0.0477F));
      bone18.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171480_().m_171488_(-2.0F, 2.0262F, -11.692F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-1.1F)).m_171555_(false), PartPose.m_171423_(0.4968F, 2.1777F, -0.4571F, -0.218F, -0.0094F, 0.1756F));
      bone18.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171480_().m_171488_(-2.0F, 7.0262F, -3.692F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false), PartPose.m_171423_(0.4968F, 2.1777F, -0.4571F, -1.1343F, -0.0094F, 0.1756F));
      PartDefinition bone9 = bone8.m_171599_("bone9", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 112, 112);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone8.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
   }
}
