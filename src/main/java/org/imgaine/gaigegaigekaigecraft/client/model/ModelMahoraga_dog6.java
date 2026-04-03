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

public class ModelMahoraga_dog6<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_mahoraga_dog_6"), "main");
   public final ModelPart bone;

   public ModelMahoraga_dog6(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition Tail = bone.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1F, -2.8234F, 4.8331F, 0.3491F, 0.0F, 0.0F));
      Tail.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -1.7247F, 0.613F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(0, 24).addBox(-1.0F, -1.7247F, -4.387F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 3.6481F, 2.9539F, -0.3927F, 0.0F, 0.0F));
      PartDefinition RightLeg = bone.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-3.0F, -11.6751F, 5.7979F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, -5.7296F, -1.4804F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 15).mirror().addBox(-1.0F, 0.2296F, -1.0196F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.1468F, 7.07F, -2.0796F, -2.0944F, 0.3927F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -2.7F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9888F, 7.9751F, -4.094F, 0.3491F, 0.3927F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(22, 3).mirror().addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.1183F, 11.1751F, -4.577F, 0.0F, 0.3927F, 0.0F));
      PartDefinition LeftLeg = bone.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(3.0F, -11.6751F, 5.7979F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -5.7296F, -1.4804F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 15).addBox(-1.0F, 0.2296F, -1.0196F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.1468F, 7.07F, -2.0796F, -2.0944F, -0.3927F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -2.7F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9888F, 7.9751F, -4.094F, 0.3491F, -0.3927F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(22, 3).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.1183F, 11.1751F, -4.577F, 0.0F, -0.3927F, 0.0F));
      PartDefinition RightArm = bone.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(22, 3).mirror().addBox(-0.6F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-2.8F, -11.6751F, -4.2021F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, -5.4633F, -1.5081F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 15).mirror().addBox(-1.0F, -0.2367F, -0.9919F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.4F, 3.3861F, 1.5443F, 0.0436F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 9.6751F, 1.6021F, -0.0436F, 0.0F, 0.0F));
      PartDefinition LeftArm = bone.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(22, 3).addBox(-1.4F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(2.8F, -11.6751F, -4.2021F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -5.4633F, -1.5081F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 15).addBox(-1.0F, -0.2367F, -0.9919F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.4F, 3.3861F, 1.5443F, 0.0436F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 9.6751F, 1.6021F, -0.0436F, 0.0F, 0.0F));
      PartDefinition BodyMain = bone.addOrReplaceChild("BodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 0.7F, -0.3491F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("BodyMain_r1", CubeListBuilder.create().texOffs(8, 23).addBox(-2.0F, -3.4178F, -3.8675F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(0, 20).addBox(-3.0F, -1.9178F, -0.3675F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).texOffs(0, 20).addBox(-3.5F, -2.9178F, -2.8675F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).texOffs(1, 16).addBox(-2.5F, -3.4178F, -1.8675F, 5.0F, 7.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -12.0822F, -6.1325F, -0.48F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("BodyMain_r2", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -2.5F, -3.5F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -14.1998F, -8.3884F, -0.5236F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("BodyMain_r3", CubeListBuilder.create().texOffs(0, 16).addBox(-2.4262F, -8.0F, -10.5F, 5.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0738F, -0.5F, 1.5F, -0.7418F, 0.0F, 0.0F));
      PartDefinition Head = bone.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 5).addBox(-1.6131F, -2.6F, -3.2685F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-0.6131F, -1.5F, -6.0685F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(10, 0).addBox(-1.1131F, -1.2F, -5.7685F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1131F, -16.4F, -5.7315F, -0.7854F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(0.153F, -0.7496F, -1.0553F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-0.1131F, -2.9268F, -0.7685F, -0.8112F, -0.0557F, 0.3699F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(26, 0).addBox(-2.153F, -0.7496F, -1.0553F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1131F, -2.9268F, -0.7685F, -0.8112F, 0.0557F, -0.3699F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.4262F, -19.973F, -14.8042F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3131F, 2.473F, 19.9357F, 0.7854F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -0.3F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1131F, 1.0F, -3.7685F, 0.2618F, 0.0F, 0.0F));
      PartDefinition NeckHair = Head.addOrReplaceChild("NeckHair", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1131F, -1.0213F, 1.6337F, 0.6981F, 0.0F, 0.0F));
      NeckHair.addOrReplaceChild("BodyMain_r4", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.3F, -2.4F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.4393F, -2.1645F, -1.5272F, 0.0F, 0.0F));
      NeckHair.addOrReplaceChild("BodyMain_r5", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, 0.9476F, 1.2719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.397F, -1.7657F, -0.3055F, 0.4929F, 2.6897F));
      NeckHair.addOrReplaceChild("BodyMain_r6", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.4027F, 1.5843F, 0.2506F, -0.7167F, 0.4882F, 1.4423F));
      NeckHair.addOrReplaceChild("BodyMain_r7", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.397F, -0.7657F, -0.5856F, 0.5567F, 1.9062F));
      NeckHair.addOrReplaceChild("BodyMain_r8", CubeListBuilder.create().texOffs(16, 9).addBox(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.4027F, 1.5843F, 0.2506F, -0.7167F, -0.4882F, -1.4423F));
      NeckHair.addOrReplaceChild("BodyMain_r9", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -1.397F, -0.7657F, -0.5856F, -0.5567F, -1.9062F));
      NeckHair.addOrReplaceChild("BodyMain_r10", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.2F, -1.397F, -1.7657F, -0.8384F, 0.6142F, 1.7659F));
      NeckHair.addOrReplaceChild("BodyMain_r11", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.2027F, 1.5843F, -0.7494F, -0.9572F, 0.4483F, 1.3333F));
      NeckHair.addOrReplaceChild("BodyMain_r12", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.5339F, 2.5188F, -2.2462F, -1.3573F, 0.4969F, 0.6107F));
      NeckHair.addOrReplaceChild("BodyMain_r13", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.5339F, 2.5188F, -2.2462F, -1.3573F, -0.4969F, -0.6107F));
      NeckHair.addOrReplaceChild("BodyMain_r14", CubeListBuilder.create().texOffs(16, 9).addBox(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.2027F, 1.5843F, -0.7494F, -0.9572F, -0.4483F, -1.3333F));
      NeckHair.addOrReplaceChild("BodyMain_r15", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 1.4476F, 0.7719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -1.397F, -1.7657F, -0.0873F, 0.0F, -3.1416F));
      NeckHair.addOrReplaceChild("BodyMain_r16", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.2F, -1.397F, -1.7657F, -0.8384F, -0.6142F, -1.7659F));
      NeckHair.addOrReplaceChild("BodyMain_r17", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.9476F, 1.2719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -1.397F, -1.7657F, -0.3055F, -0.4929F, -2.6897F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
