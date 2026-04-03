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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelogami"), "main");
   public final ModelPart head;
   public final ModelPart bone8;

   public Modelogami(ModelPart root) {
      this.head = root.getChild("head");
      this.bone8 = root.getChild("bone8");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -4.0F));
      PartDefinition bone6 = head.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.3842F, -0.6125F, -0.1745F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 47).addBox(0.7F, 0.1158F, -2.1875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.1569F, -0.1628F, -0.8787F, 0.0F, 0.0F, 0.0873F));
      bone6.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 51).addBox(-2.7F, 0.1158F, -2.1875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.1569F, -0.1628F, -0.8787F, 0.0F, 0.0F, -0.0873F));
      bone6.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(25, 29).addBox(-1.0F, 0.1144F, -1.195F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(25, 29).addBox(-1.0F, 0.1144F, -2.095F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.8199F, -1.0618F, 0.5672F, 0.0F, 0.0F));
      PartDefinition bone5 = head.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.2158F, -2.6125F, 0.3491F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(0.7F, 0.2158F, -2.3875F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.7F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));
      bone5.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 58).addBox(-2.7F, 0.2158F, -2.3875F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
      PartDefinition bone4 = head.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 90).addBox(-3.9025F, -1.7842F, -2.5978F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 90).mirror().addBox(-2.9025F, -1.7842F, -2.5978F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9025F, -0.5158F, -1.4022F, -0.2618F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(93, 96).mirror().addBox(0.3F, -0.7842F, -1.9875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-4.9398F, 0.1F, -0.0425F, 0.0F, 0.48F, 0.0F));
      bone4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(93, 96).addBox(-2.3F, -0.7842F, -1.9875F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.8651F, 0.1F, -0.0425F, 0.0F, -0.48F, 0.0F));
      PartDefinition bone3 = head.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(65, 85).addBox(-4.9025F, -0.4842F, -2.5978F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(65, 85).mirror().addBox(-2.9025F, -0.4842F, -2.5978F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.9025F, -1.2158F, -1.4022F));
      bone3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -1.4842F, 1.2125F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9025F, 0.0F, -0.7102F, -0.3921F, -0.0095F, 0.0048F));
      PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.8596F, -1.8368F, 0.0873F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(89, 0).addBox(-1.0F, 0.6262F, -3.292F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.81F)), PartPose.offsetAndRotation(0.0F, -0.5313F, -0.224F, 0.0873F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(88, 65).addBox(-1.0F, -0.1738F, -2.892F, 2.0F, 4.0F, 3.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 0.4438F, -0.1756F, -0.6109F, 0.0F, 0.0F));
      PartDefinition bone13 = bone.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(0.0F, 0.4438F, -0.1756F));
      bone13.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(81, 85).addBox(-2.8F, 0.5262F, -3.092F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).texOffs(48, 19).addBox(-2.8F, -1.5738F, -2.992F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3622F, -0.7519F, 0.2533F));
      PartDefinition bone14 = bone.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(0.0F, 0.4438F, -0.1756F));
      bone14.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(81, 85).mirror().addBox(-0.2F, 0.5262F, -3.092F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(48, 19).mirror().addBox(-0.2F, -1.5738F, -2.992F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3622F, 0.7519F, -0.2533F));
      PartDefinition bone15 = head.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0158F, -2.1125F));
      bone15.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(21, 99).addBox(-3.5F, -3.7738F, -3.392F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 65).addBox(-1.5F, -6.0738F, -1.392F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).texOffs(0, 65).addBox(-1.5F, -4.0738F, -4.192F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.074F, 0.3643F, -0.3054F, 0.0F, 0.0F));
      bone15.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 65).mirror().addBox(-1.1F, -3.1738F, -4.292F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.074F, 0.3643F, -1.5708F, -1.2654F, 1.5708F));
      bone15.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 65).addBox(-1.5F, -4.0738F, -4.992F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.074F, 0.3643F, -2.8362F, 0.0F, 3.1416F));
      bone15.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 65).addBox(-1.9F, -3.1738F, -4.292F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.074F, 0.3643F, -1.5708F, 1.2654F, -1.5708F));
      PartDefinition bone2 = head.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 78).addBox(-2.5F, -1.6998F, -0.5276F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -1.0158F, -2.1125F));
      bone2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(2, 28).mirror().addBox(-2.5F, -2.6738F, -2.092F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(2, 28).addBox(-0.5F, -2.6738F, -2.092F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).texOffs(21, 58).addBox(-2.0F, -2.4738F, -2.592F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(31, 9).addBox(-2.5F, -1.3738F, -0.592F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
      PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(0.1259F, 8.8509F, -1.0388F));
      bone8.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(65, 0).addBox(-4.5F, -2.0738F, 1.008F, 9.0F, 3.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0457F, 0.0311F, -0.0058F));
      bone8.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(34, 62).addBox(-4.5F, -6.6738F, 4.608F, 9.0F, 3.0F, 9.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-4.5F, -4.0738F, 1.008F, 9.0F, 4.0F, 13.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1259F, -1.7928F, -3.7093F, -1.482F, 0.0311F, -0.0058F));
      bone8.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(38, 41).mirror().addBox(0.5F, -5.2738F, 2.008F, 4.0F, 5.0F, 15.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.1259F, -1.7928F, -3.7093F, -1.6034F, -0.041F, -0.256F));
      bone8.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(38, 41).addBox(-4.5F, -5.2738F, 2.008F, 4.0F, 5.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.1259F, -1.7928F, -3.7093F, -1.6034F, 0.041F, 0.256F));
      bone8.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(25, 22).mirror().addBox(1.2F, -4.0738F, 1.008F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-0.1259F, -1.7928F, -3.7093F, -1.6154F, -0.0273F, 0.093F));
      bone8.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(25, 22).addBox(-5.2F, -4.0738F, 1.008F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1259F, -1.7928F, -3.7093F, -1.6154F, 0.0273F, -0.093F));
      bone8.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(71, 57).addBox(-4.5F, -2.0738F, 1.008F, 9.0F, 3.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1259F, -1.7928F, -3.7093F, -0.6093F, 0.0311F, -0.0058F));
      bone8.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(58, 99).addBox(-4.5F, -2.0738F, 1.008F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.1186F, 4.3358F, 3.0018F, -1.3511F, 0.0311F, -0.0058F));
      PartDefinition right_leg = bone8.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-2.1259F, 11.2072F, -1.7093F));
      right_leg.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(73, 14).addBox(-5.7F, -7.0738F, 12.008F, 7.0F, 11.0F, 5.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(2.0F, -13.0F, -2.0F, -1.523F, 0.3362F, 0.0086F));
      PartDefinition right_leg2 = right_leg.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(0.2473F, 1.6529F, -1.8037F));
      right_leg2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(53, 80).mirror().addBox(-2.8F, -13.0738F, 12.008F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.7527F, -14.6529F, -1.1963F, -1.6129F, -0.0311F, 0.0058F));
      right_leg2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(65, 69).addBox(-4.5F, -9.2738F, 12.008F, 5.0F, 11.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.7527F, -14.6529F, -0.1963F, -1.5256F, 0.0311F, -0.0058F));
      PartDefinition left_leg = bone8.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.8741F, 11.2072F, -1.7093F));
      left_leg.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(73, 14).mirror().addBox(-1.3F, -7.0738F, 12.008F, 7.0F, 11.0F, 5.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -13.0F, -2.0F, -1.523F, -0.3362F, -0.0086F));
      PartDefinition left_leg2 = left_leg.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(-0.2473F, 1.6529F, -1.8037F));
      left_leg2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(53, 80).addBox(-0.2F, -13.0738F, 12.008F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.7527F, -14.6529F, -1.1963F, -1.6129F, 0.0311F, -0.0058F));
      left_leg2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(65, 69).mirror().addBox(-0.5F, -9.2738F, 12.008F, 5.0F, 11.0F, 5.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-1.7527F, -14.6529F, -0.1963F, -1.5256F, -0.0311F, 0.0058F));
      PartDefinition bone11 = bone8.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7334F, -1.456F, -1.6461F, 0.3927F, -0.0436F, 0.0F));
      bone11.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 58).addBox(0.5F, -6.0738F, 2.008F, 4.0F, 6.0F, 13.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.2662F, 0.2522F, -0.5511F));
      bone11.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(67, 43).addBox(0.5F, -6.0738F, 8.008F, 4.0F, 6.0F, 6.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.3533F, 0.3128F, 0.5323F, -2.5717F, 0.2522F, -0.5511F));
      PartDefinition bone17 = bone11.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offset(-0.3467F, 0.3128F, 0.5323F));
      bone17.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(24, 17).addBox(0.7F, -2.0738F, 7.608F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.5717F, 0.2522F, -0.5511F));
      PartDefinition bone10 = bone17.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(0.7968F, -2.8777F, 0.4571F));
      bone10.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(24, 17).addBox(-1.2F, 1.7262F, -10.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).texOffs(24, 17).addBox(-1.2F, 1.5262F, -10.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).texOffs(24, 17).addBox(-1.2F, 1.5262F, -11.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).texOffs(24, 17).addBox(-1.2F, 2.2262F, -11.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.215F, 0.0376F, -0.0477F));
      bone10.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(24, 17).addBox(-1.0F, 2.0262F, -11.692F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-0.4968F, 2.1777F, -0.4571F, -0.218F, 0.0094F, -0.1756F));
      bone10.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(24, 17).addBox(-1.0F, 7.0262F, -3.692F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-0.4968F, 2.1777F, -0.4571F, -1.1343F, 0.0094F, -0.1756F));
      PartDefinition bone12 = bone8.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4817F, -1.456F, -1.6461F, 0.3927F, 0.0436F, 0.0F));
      bone12.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-4.5F, -6.0738F, 2.008F, 4.0F, 6.0F, 13.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.2662F, -0.2522F, 0.5511F));
      bone12.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(67, 43).mirror().addBox(-4.5F, -6.0738F, 8.008F, 4.0F, 6.0F, 6.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-0.3533F, 0.3128F, 0.5323F, -2.5717F, -0.2522F, 0.5511F));
      PartDefinition bone16 = bone12.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offset(0.3467F, 0.3128F, 0.5323F));
      bone16.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(24, 17).mirror().addBox(-4.7F, -2.0738F, 7.608F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-1.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.5717F, -0.2522F, 0.5511F));
      PartDefinition bone18 = bone16.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(-0.7968F, -2.8777F, 0.4571F));
      bone18.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(24, 17).mirror().addBox(-1.8F, 1.7262F, -10.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).mirror(false).texOffs(24, 17).mirror().addBox(-1.8F, 1.5262F, -10.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).mirror(false).texOffs(24, 17).mirror().addBox(-1.8F, 1.5262F, -11.392F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).mirror(false).texOffs(24, 17).mirror().addBox(-1.8F, 2.2262F, -11.892F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.215F, -0.0376F, 0.0477F));
      bone18.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(24, 17).mirror().addBox(-2.0F, 2.0262F, -11.692F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-1.1F)).mirror(false), PartPose.offsetAndRotation(0.4968F, 2.1777F, -0.4571F, -0.218F, -0.0094F, 0.1756F));
      bone18.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(24, 17).mirror().addBox(-2.0F, 7.0262F, -3.692F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false), PartPose.offsetAndRotation(0.4968F, 2.1777F, -0.4571F, -1.1343F, -0.0094F, 0.1756F));
      PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 112, 112);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
   }
}
