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

public class ModelGaruda<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_garuda"), "main");
   public final ModelPart BodyMain;

   public ModelGaruda(ModelPart root) {
      this.BodyMain = root.getChild("BodyMain");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition BodyMain = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 13.0F, 20.0F, -0.0894F, -0.2173F, 0.0193F));
      PartDefinition Head = BodyMain.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.3F, -6.3622F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(16, 0).addBox(-1.5F, -1.1F, -8.3622F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 5).addBox(-1.5F, -1.1F, -8.3622F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.05F)).texOffs(0, 0).addBox(-2.9F, -1.3F, -4.3622F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(1.9F, -1.3F, -4.3622F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.2F, -22.1378F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.5328F, 27.7519F, 3.0F, 1.0F, 10.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.1898F, 22.3716F, 2.9671F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.6049F, 28.2471F, 3.0F, 1.0F, 10.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.1898F, 22.3716F, -3.0543F, 0.0F, 0.0F));
      PartDefinition Body1 = BodyMain.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(1, 24).addBox(-2.0F, -2.3483F, -0.8933F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-2.0F, -2.3483F, 2.6067F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.3483F, -22.1067F, 0.0F, 0.0873F, 0.0F));
      Body1.addOrReplaceChild("Body1_r1", CubeListBuilder.create().texOffs(3, 18).addBox(4.664F, -20.6381F, -0.3651F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.41F)).texOffs(0, 13).addBox(5.164F, -20.6381F, -1.3651F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.7381F, 22.3405F, 1.4278F, 0.2201F, -2.1539F));
      Body1.addOrReplaceChild("Body1_r2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-7.164F, -20.6381F, -1.3651F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.4F)).mirror(false).texOffs(3, 18).mirror().addBox(-7.664F, -20.6381F, -0.3651F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.41F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.7381F, 22.3405F, 1.4278F, -0.2201F, 2.1539F));
      Body1.addOrReplaceChild("Body1_r3", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.5F, -22.2338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.7381F, 22.3405F, 0.0F, 0.0F, 1.5708F));
      Body1.addOrReplaceChild("Body1_r4", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, 2.6102F, -21.996F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.7381F, 22.3405F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(1, 24).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-2.0F, -2.0F, 3.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, -0.3483F, 4.1067F, 0.0909F, 0.1722F, 0.023F));
      Body2.addOrReplaceChild("Body2_r1", CubeListBuilder.create().texOffs(3, 18).addBox(2.739F, 15.3357F, 1.6805F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.41F)).texOffs(0, 13).addBox(3.239F, 15.3357F, 0.6805F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.3898F, 18.2338F, -1.4686F, 0.2415F, 1.845F));
      Body2.addOrReplaceChild("Body2_r2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-5.239F, 15.3357F, 0.6805F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.4F)).mirror(false).texOffs(3, 18).mirror().addBox(-5.739F, 15.3357F, 1.6805F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.41F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3898F, 18.2338F, -1.4686F, -0.2415F, -1.845F));
      Body2.addOrReplaceChild("Body2_r3", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.5F, -17.7338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.3898F, 18.2338F, 0.0F, 0.0F, 1.5708F));
      Body2.addOrReplaceChild("Body2_r4", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, 1.3161F, -17.1664F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.3898F, 18.2338F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body3 = Body2.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(1, 24).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-2.0F, -2.0F, 3.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).texOffs(14, 11).addBox(-2.0F, -2.0F, 8.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).texOffs(1, 24).addBox(-2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.1843F, 0.2487F, 0.084F));
      Body3.addOrReplaceChild("Body3_r1", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -1.2721F, -7.5071F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(24, 27).addBox(-0.5F, 0.022F, -12.3368F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.3898F, 13.2338F, -0.2618F, 0.0F, 0.0F));
      Body3.addOrReplaceChild("Body3_r2", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.5F, -7.7338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(24, 17).addBox(-0.1102F, -3.5F, -12.7338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.3898F, 13.2338F, 0.0F, 0.0F, 1.5708F));
      PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(1, 25).addBox(-1.5F, -1.6156F, 1.154F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-1.5F, -1.6156F, 4.654F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.1156F, 8.346F, 0.3043F, 0.2421F, 0.1251F));
      Body4.addOrReplaceChild("Body4_r1", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.0F, -3.2338F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.5054F, 4.8878F, 0.0F, 0.0F, 1.5708F));
      Body4.addOrReplaceChild("Body4_r2", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -1.6299F, -3.2122F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.5054F, 4.8878F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body5 = Body4.addOrReplaceChild("Body5", CubeListBuilder.create().texOffs(1, 25).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, -0.1156F, 6.154F, 0.2684F, 0.3042F, 0.0277F));
      Body5.addOrReplaceChild("Body5_r1", CubeListBuilder.create().texOffs(3, 17).addBox(1.3386F, 1.1819F, 5.6526F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.4F)).texOffs(2, 17).addBox(1.3386F, 1.1819F, 1.6526F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.39F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -1.2662F, 1.5708F, -1.1781F, -1.5708F));
      Body5.addOrReplaceChild("Body5_r2", CubeListBuilder.create().texOffs(3, 17).mirror().addBox(-3.3386F, 1.1819F, 5.6526F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.4F)).mirror(false).texOffs(2, 17).mirror().addBox(-4.3386F, 1.1819F, 1.6526F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.39F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3898F, -1.2662F, 1.5708F, 1.1781F, 1.5708F));
      Body5.addOrReplaceChild("Body5_r3", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.0F, 1.7662F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -1.2662F, 0.0F, 0.0F, 1.5708F));
      Body5.addOrReplaceChild("Body5_r4", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -2.924F, 1.6174F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -1.2662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body6 = Body5.addOrReplaceChild("Body6", CubeListBuilder.create().texOffs(1, 25).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.1F, 0.2265F, 0.3476F, 0.0321F));
      Body6.addOrReplaceChild("Body6_r1", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.0F, 6.8662F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -6.3662F, 0.0F, 0.0F, 1.5708F));
      Body6.addOrReplaceChild("Body6_r2", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -4.244F, 6.5436F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -6.3662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body7 = Body6.addOrReplaceChild("Body7", CubeListBuilder.create().texOffs(1, 25).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0083F, 0.3476F, 0.0321F));
      Body7.addOrReplaceChild("Body7_r1", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -3.0F, 11.8662F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -11.3662F, 0.0F, 0.0F, 1.5708F));
      Body7.addOrReplaceChild("Body7_r2", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -5.5381F, 11.3732F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -11.3662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body8 = Body7.addOrReplaceChild("Body8", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-1.0F, -1.0F, 4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.4F, 0.001F, -0.2608F, -0.023F));
      Body8.addOrReplaceChild("Body8_r1", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -2.0F, 16.7662F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -15.7662F, 0.0F, 0.0F, 1.5708F));
      Body8.addOrReplaceChild("Body8_r2", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -6.48F, 16.4252F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -15.7662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body9 = Body8.addOrReplaceChild("Body9", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0389F, 0.2914F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(14, 11).addBox(-1.0F, -1.0389F, 4.7914F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0389F, 5.7086F, 0.1542F, -0.5919F, -0.3002F));
      Body9.addOrReplaceChild("Body9_r1", CubeListBuilder.create().texOffs(0, 14).addBox(10.7146F, -0.0324F, 18.5405F, 2.0F, 1.0F, 8.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.4287F, -21.4747F, 0.0F, -0.6109F, 0.0F));
      Body9.addOrReplaceChild("Body9_r2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-12.7146F, -0.0324F, 18.5405F, 2.0F, 1.0F, 8.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.4287F, -21.4747F, 0.0F, 0.6109F, 0.0F));
      Body9.addOrReplaceChild("Body9_r3", CubeListBuilder.create().texOffs(24, 17).addBox(-0.1102F, -2.0F, 22.7662F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.4287F, -21.4747F, 0.0F, 0.0F, 1.5708F));
      Body9.addOrReplaceChild("Body9_r4", CubeListBuilder.create().texOffs(24, 27).addBox(-0.5F, -8.0329F, 22.2207F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.4287F, -21.4747F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body10 = Body9.addOrReplaceChild("Body10", CubeListBuilder.create(), PartPose.offset(0.0F, -0.0389F, 6.2566F));
      Body10.addOrReplaceChild("Body10_r1", CubeListBuilder.create().texOffs(1, 26).mirror().addBox(-2.2705F, -0.6102F, 31.1889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)).mirror(false).texOffs(1, 26).mirror().addBox(-2.4705F, -0.6102F, 27.6889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3898F, -27.7313F, 0.0F, 0.0873F, 0.0F));
      Body10.addOrReplaceChild("Body10_r2", CubeListBuilder.create().texOffs(1, 26).addBox(1.2705F, -0.6102F, 31.1889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)).texOffs(1, 26).addBox(1.4705F, -0.6102F, 27.6889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3898F, -27.7313F, 0.0F, -0.0873F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.BodyMain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.BodyMain.yRot = netHeadYaw / 57.295776F;
      this.BodyMain.xRot = headPitch / 57.295776F;
   }
}
