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

public class Modelcursedspirit3_8<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_8"), "main");
   public final ModelPart Body;

   public Modelcursedspirit3_8(ModelPart root) {
      this.Body = root.getChild("Body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(-1.1833F, 23.5F, 19.4744F));
      PartDefinition Shell = Body.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -1.0F, -8.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(34, 37).addBox(-5.5F, -1.0F, -5.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.4F)).texOffs(34, 37).addBox(-5.5F, -2.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-1.1F)).texOffs(34, 37).addBox(-5.5F, -1.0F, -3.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offset(1.1833F, -16.5F, -17.9744F));
      Shell.addOrReplaceChild("Shell_r1", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      Shell.addOrReplaceChild("Shell_r2", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -7.5F, -8.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.1F)).texOffs(34, 37).addBox(-5.5F, -7.5F, -5.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.5F)).texOffs(34, 37).addBox(-5.5F, -7.5F, -3.5F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 1.5708F, 0.0F, 0.0F));
      Shell.addOrReplaceChild("Shell_r3", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 6.5F, 6.5F, 0.0F, 3.1416F, 0.0F));
      Shell.addOrReplaceChild("Shell_r4", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 6.5F, 3.5F, 0.0F, 3.1416F, 0.0F));
      Shell.addOrReplaceChild("Shell_r5", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
      Shell.addOrReplaceChild("Shell_r6", CubeListBuilder.create().texOffs(34, 37).addBox(-5.5F, -7.5F, -2.0F, 11.0F, 15.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 1.5F, 0.0F, 3.1416F, 0.0F));
      PartDefinition BodyMain = Body.addOrReplaceChild("BodyMain", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -13.1998F, 25.6606F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.5F, -13.1998F, 9.4606F, 11.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.5F, -13.1998F, -0.5394F, 5.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.5F, -13.1998F, -3.3394F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1833F, 11.6998F, -33.935F));
      BodyMain.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.2076F, -14.4743F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.789F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0076F, -16.0743F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8633F, -7.3284F, -2.1817F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.0F, -17.9F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.151F, -0.5268F, -1.4835F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -17.9F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1098F, 9.7566F, -0.7418F, 0.0F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -1.0F, -1.56F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5447F, -12.1998F, -1.2467F, 0.0F, 0.4179F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -1.56F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5447F, -12.1998F, -1.2467F, 0.0F, -0.4179F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9833F, -7.5F, -15.5256F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.3759F, -18.9595F, 14.0261F, 0.4247F, 0.165F, -0.3484F));
      BodyMain.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(0, 0).addBox(0.9833F, -7.5F, -15.5256F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.3759F, -18.9595F, 14.0261F, 0.4247F, -0.165F, 0.3484F));
      BodyMain.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-2.6833F, -2.0F, -12.9743F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3382F, -11.1998F, 14.1129F, 0.0F, -0.3491F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3167F, -2.0F, -12.9743F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3382F, -11.1998F, 14.1129F, 0.0F, 0.3491F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-1.3167F, -2.0F, 10.9744F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7326F, -11.1998F, 15.2305F, 0.0F, -0.3491F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0581F, -2.0F, 17.7212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0581F, -2.0F, 17.2212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.588F, -11.1998F, 23.2957F, 0.0F, -1.0821F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-2.942F, -2.0F, 17.2212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.942F, -2.0F, 17.7212F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.5881F, -11.1998F, 23.2956F, 0.0F, 1.0821F, 0.0F));
      BodyMain.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-2.6833F, -2.0F, 10.9744F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7326F, -11.1998F, 15.2305F, 0.0F, 0.3491F, 0.0F));
      PartDefinition RightEye = Body.addOrReplaceChild("RightEye", CubeListBuilder.create(), PartPose.offset(3.969F, -6.316F, -35.9679F));
      RightEye.addOrReplaceChild("RightEye_r1", CubeListBuilder.create().texOffs(56, 60).addBox(-1.2999F, -1.0065F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2937F, 0.9825F, -0.0239F));
      RightEye.addOrReplaceChild("RightEye_r2", CubeListBuilder.create().texOffs(56, 58).addBox(-1.0065F, -1.2999F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0059F, 0.1245F, 1.817F));
      PartDefinition LeftEye = Body.addOrReplaceChild("LeftEye", CubeListBuilder.create(), PartPose.offset(-1.6024F, -6.316F, -35.9679F));
      LeftEye.addOrReplaceChild("LeftEye_r1", CubeListBuilder.create().texOffs(56, 58).mirror().addBox(-0.9935F, -1.2999F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0059F, -0.1245F, -1.817F));
      LeftEye.addOrReplaceChild("LeftEye_r2", CubeListBuilder.create().texOffs(56, 60).mirror().addBox(-0.7001F, -1.0065F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2937F, -0.9825F, 0.0239F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
