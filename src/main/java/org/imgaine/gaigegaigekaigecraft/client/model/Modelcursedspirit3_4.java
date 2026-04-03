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

public class Modelcursedspirit3_4<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_4"), "main");
   public final ModelPart bone;

   public Modelcursedspirit3_4(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.0F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.005F)).texOffs(0, 0).addBox(-1.5F, -7.0954F, -1.8613F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(12, -2).addBox(0.0F, -8.0225F, -2.85F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.05F)).texOffs(0, 0).addBox(-1.0F, -4.9143F, 2.3655F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, 10.0F, 0.0F));
      bone.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.4F, -0.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.814F, 4.7867F, 0.5236F, 0.0F, 0.0F));
      bone.addOrReplaceChild("bone_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.3F, -1.3F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -1.1523F, -2.5353F, 2.4435F, 0.0F, 0.0F));
      bone.addOrReplaceChild("bone_r3", CubeListBuilder.create().texOffs(18, 23).mirror().addBox(2.2F, 0.0F, -3.9F, 1.0F, 4.0F, 5.0F, new CubeDeformation(-0.45F)).mirror(false), PartPose.offsetAndRotation(1.0F, -8.1633F, 5.4723F, 0.3927F, 0.829F, 0.0F));
      bone.addOrReplaceChild("bone_r4", CubeListBuilder.create().texOffs(18, 23).addBox(-3.2F, 0.0F, -3.9F, 1.0F, 4.0F, 5.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(-1.0F, -8.1633F, 5.4723F, 0.3927F, -0.829F, 0.0F));
      bone.addOrReplaceChild("bone_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.6F, 1.36F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.02F)).texOffs(0, 0).addBox(-1.5F, -3.6F, -1.6F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -3.5954F, -0.2613F, 0.7854F, 0.0F, 0.0F));
      bone.addOrReplaceChild("bone_r6", CubeListBuilder.create().texOffs(12, -2).addBox(0.0F, -2.9F, 1.3F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -7.1309F, -3.2311F, -0.6109F, 0.0F, 0.0F));
      bone.addOrReplaceChild("bone_r7", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.6F, -3.5F, -1.4F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.5F, -2.5F, 0.0F, 0.3927F, 0.0F));
      bone.addOrReplaceChild("bone_r8", CubeListBuilder.create().texOffs(24, 0).addBox(-0.4F, -3.5F, -1.4F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.0F, -1.5F, -2.5F, 0.0F, -0.3927F, 0.0F));
      PartDefinition bone11 = bone.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3F, -0.5F, 0.7F, 0.165F, -0.4945F, 1.1733F));
      bone11.addOrReplaceChild("cube_r28_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5099F, -0.6944F, -0.1785F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)), PartPose.offsetAndRotation(1.6123F, -0.3482F, 1.4039F, -0.8803F, -0.3515F, -1.8097F));
      bone11.addOrReplaceChild("cube_r27_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5013F, -0.5797F, -0.1795F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)), PartPose.offsetAndRotation(1.6123F, -0.3482F, 1.4039F, -0.9131F, -0.1467F, -1.6431F));
      bone11.addOrReplaceChild("cube_r26_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.6465F, -0.5831F, -0.18F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)), PartPose.offsetAndRotation(1.6123F, -0.3482F, 1.4039F, -0.9165F, -0.043F, -1.5632F));
      bone11.addOrReplaceChild("cube_r25_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.6231F, -0.6178F, -0.1815F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)), PartPose.offsetAndRotation(1.6123F, -0.3482F, 1.4039F, -0.8841F, 0.2318F, -1.345F));
      bone11.addOrReplaceChild("cube_r28_r2", CubeListBuilder.create().texOffs(1, 1).addBox(-1.17F, -0.4518F, -0.1874F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.19F)), PartPose.offsetAndRotation(1.6123F, -0.3482F, 1.4039F, 0.0F, 0.8726F, 0.0F));
      bone11.addOrReplaceChild("cube_r23_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8841F, -0.3518F, -1.3227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.6123F, -0.3482F, 1.4039F, 0.0F, 0.3927F, 0.0F));
      bone11.addOrReplaceChild("bone11_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-1.5221F, -0.4191F, -1.4519F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.508F, -0.2809F, 1.6625F, 0.0F, -0.1309F, 0.0F));
      PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3F, -0.5F, 0.7F, 0.165F, 0.4945F, -1.1733F));
      bone3.addOrReplaceChild("cube_r29_r1", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-0.4901F, -0.6944F, -0.1785F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)).mirror(false), PartPose.offsetAndRotation(-1.6123F, -0.3482F, 1.4039F, -0.8803F, 0.3515F, 1.8097F));
      bone3.addOrReplaceChild("cube_r28_r3", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-0.4987F, -0.5797F, -0.1795F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)).mirror(false), PartPose.offsetAndRotation(-1.6123F, -0.3482F, 1.4039F, -0.9131F, 0.1467F, 1.6431F));
      bone3.addOrReplaceChild("cube_r27_r2", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-0.3535F, -0.5831F, -0.18F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)).mirror(false), PartPose.offsetAndRotation(-1.6123F, -0.3482F, 1.4039F, -0.9165F, 0.043F, 1.5632F));
      bone3.addOrReplaceChild("cube_r26_r2", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-0.3769F, -0.6178F, -0.1815F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.39F)).mirror(false), PartPose.offsetAndRotation(-1.6123F, -0.3482F, 1.4039F, -0.8841F, -0.2318F, 1.345F));
      bone3.addOrReplaceChild("cube_r29_r2", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-0.83F, -0.4518F, -0.1874F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.19F)).mirror(false), PartPose.offsetAndRotation(-1.6123F, -0.3482F, 1.4039F, 0.0F, -0.8726F, 0.0F));
      bone3.addOrReplaceChild("cube_r24_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.1159F, -0.3518F, -1.3227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-1.6123F, -0.3482F, 1.4039F, 0.0F, -0.3927F, 0.0F));
      bone3.addOrReplaceChild("bone12_r1", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-0.4779F, -0.4191F, -1.4519F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.508F, -0.2809F, 1.6625F, 0.0F, 0.1309F, 0.0F));
      PartDefinition bone9 = bone.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.0F, -1.5F, -2.2F, -1.2656F, 0.7739F, 0.7799F));
      bone9.addOrReplaceChild("cube_r38_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.6818F, 0.0597F, -0.4915F, 0.2502F, -0.0779F, 1.7355F));
      bone9.addOrReplaceChild("cube_r37_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.52F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.6855F, -0.0515F, -0.4925F, 0.2427F, 0.0992F, 1.3211F));
      bone9.addOrReplaceChild("cube_r36_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.2536F, -4.0F, -0.8124F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0219F, 3.5F, 0.9279F, 0.0F, 0.2618F, 0.0F));
      bone9.addOrReplaceChild("cube_r35_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.53F, -1.1F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.5522F, -0.0899F, -0.4567F, 0.0914F, 0.2457F, 0.9276F));
      bone9.addOrReplaceChild("cube_r34_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.4F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.616F, 0.255F, -0.4739F, -0.0914F, 0.2457F, -0.9276F));
      PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -1.5F, -2.2F, -1.2656F, -0.7739F, -0.7799F));
      bone2.addOrReplaceChild("cube_r39_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-1.6818F, 0.0597F, -0.4915F, 0.2502F, 0.0779F, -1.7355F));
      bone2.addOrReplaceChild("cube_r38_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.48F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-1.6855F, -0.0515F, -0.4925F, 0.2427F, -0.0992F, -1.3211F));
      bone2.addOrReplaceChild("cube_r37_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.2536F, -4.0F, -0.8124F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(2.0219F, 3.5F, 0.9279F, 0.0F, -0.2618F, 0.0F));
      bone2.addOrReplaceChild("cube_r36_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.47F, -1.1F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-1.5522F, -0.0899F, -0.4567F, 0.0914F, -0.2457F, -0.9276F));
      bone2.addOrReplaceChild("cube_r35_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.6F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-1.616F, 0.255F, -0.4739F, -0.0914F, -0.2457F, 0.9276F));
      PartDefinition bone7 = bone.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 0).addBox(11.0F, -4.3F, -8.1F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(10.9F, -3.3F, -8.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(12.1F, -3.3F, -8.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(12.1F, -4.5F, -8.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(10.9F, -4.5F, -8.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, 1.0F));
      bone7.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).addBox(11.0F, -7.3F, -5.1F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4887F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
