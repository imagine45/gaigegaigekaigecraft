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

public class Modelcursedspirit_armoury<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_armoury"), "main");
   public final ModelPart Body;
   public final ModelPart Body_r1;
   public final ModelPart Body_r2;
   public final ModelPart Body_r3;
   public final ModelPart Body_r4;
   public final ModelPart Body_r5;
   public final ModelPart Body_r6;
   public final ModelPart Body_r7;
   public final ModelPart Body_r8;
   public final ModelPart Body_r9;
   public final ModelPart Body_r10;
   public final ModelPart Body_r11;
   public final ModelPart Body_r12;
   public final ModelPart Body_r13;
   public final ModelPart Body_r14;
   public final ModelPart Body_r15;
   public final ModelPart Body_r16;
   public final ModelPart Body_r17;
   public final ModelPart Body_r18;
   public final ModelPart Body_r19;
   public final ModelPart Body_r20;
   public final ModelPart Body_r21;
   public final ModelPart Body_r22;
   public final ModelPart Body_r23;
   public final ModelPart Body_r24;
   public final ModelPart Body_r25;
   public final ModelPart Body_r26;
   public final ModelPart Body_r27;
   public final ModelPart Body_r28;
   public final ModelPart Body_r29;
   public final ModelPart Body_r30;
   public final ModelPart Body_r33_r1;
   public final ModelPart Body_r32_r1;
   public final ModelPart Body_r33_r2;
   public final ModelPart Body_r32_r2;
   public final ModelPart bone;
   public final ModelPart Body_r31;
   public final ModelPart bone2;

   public Modelcursedspirit_armoury(ModelPart root) {
      this.Body = root.getChild("Body");
      this.Body_r1 = this.Body.getChild("Body_r1");
      this.Body_r2 = this.Body.getChild("Body_r2");
      this.Body_r3 = this.Body.getChild("Body_r3");
      this.Body_r4 = this.Body.getChild("Body_r4");
      this.Body_r5 = this.Body.getChild("Body_r5");
      this.Body_r6 = this.Body.getChild("Body_r6");
      this.Body_r7 = this.Body.getChild("Body_r7");
      this.Body_r8 = this.Body.getChild("Body_r8");
      this.Body_r9 = this.Body.getChild("Body_r9");
      this.Body_r10 = this.Body.getChild("Body_r10");
      this.Body_r11 = this.Body.getChild("Body_r11");
      this.Body_r12 = this.Body.getChild("Body_r12");
      this.Body_r13 = this.Body.getChild("Body_r13");
      this.Body_r14 = this.Body.getChild("Body_r14");
      this.Body_r15 = this.Body.getChild("Body_r15");
      this.Body_r16 = this.Body.getChild("Body_r16");
      this.Body_r17 = this.Body.getChild("Body_r17");
      this.Body_r18 = this.Body.getChild("Body_r18");
      this.Body_r19 = this.Body.getChild("Body_r19");
      this.Body_r20 = this.Body.getChild("Body_r20");
      this.Body_r21 = this.Body.getChild("Body_r21");
      this.Body_r22 = this.Body.getChild("Body_r22");
      this.Body_r23 = this.Body.getChild("Body_r23");
      this.Body_r24 = this.Body.getChild("Body_r24");
      this.Body_r25 = this.Body.getChild("Body_r25");
      this.Body_r26 = this.Body.getChild("Body_r26");
      this.Body_r27 = this.Body.getChild("Body_r27");
      this.Body_r28 = this.Body.getChild("Body_r28");
      this.Body_r29 = this.Body.getChild("Body_r29");
      this.Body_r30 = this.Body.getChild("Body_r30");
      this.Body_r33_r1 = this.Body_r30.getChild("Body_r33_r1");
      this.Body_r32_r1 = this.Body_r30.getChild("Body_r32_r1");
      this.Body_r33_r2 = this.Body_r30.getChild("Body_r33_r2");
      this.Body_r32_r2 = this.Body_r30.getChild("Body_r32_r2");
      this.bone = this.Body.getChild("bone");
      this.Body_r31 = this.bone.getChild("Body_r31");
      this.bone2 = root.getChild("bone2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-2.9F, -1.0F, 0.3F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-2.8856F, 2.0234F, -5.8345F, 1.4099F, 0.6932F, 2.1927F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, -0.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(-4.7379F, 8.307F, -2.6814F, 2.0262F, -0.2835F, 1.6435F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, -1.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-4.7379F, 8.307F, -2.6814F, 2.2182F, -0.2835F, 1.6435F));
      Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(0, 13).addBox(-3.4F, -2.6F, 1.4F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.8F)), PartPose.offsetAndRotation(-5.8256F, 8.0448F, 1.1629F, 2.8291F, -0.2835F, 1.6435F));
      Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(0, 13).addBox(-2.9F, -2.1F, 0.2F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.7F)), PartPose.offsetAndRotation(-5.8256F, 8.0448F, 1.1629F, 2.9969F, -0.1171F, 1.5898F));
      Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.8F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.6F)), PartPose.offsetAndRotation(-5.8256F, 8.0448F, 1.1629F, -3.0948F, 0.142F, 1.5521F));
      Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.8F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.5F)), PartPose.offsetAndRotation(-5.8256F, 8.0448F, 1.1629F, -3.0908F, 0.4209F, 1.5662F));
      Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.9F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(-5.2524F, 8.7817F, 2.8147F, -2.5148F, 0.4209F, 1.5662F));
      Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, 0.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.3F)), PartPose.offsetAndRotation(-1.006F, 10.2223F, 4.8525F, -2.044F, 0.4795F, 1.6853F));
      Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.8F, -0.7F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-1.006F, 10.2223F, 4.8525F, -1.6775F, 0.4795F, 1.6853F));
      Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.8F, -2.9F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-1.006F, 10.2223F, 4.8525F, -1.4506F, 0.4795F, 1.6853F));
      Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -3.3F, 2.4F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(5.5199F, 8.4227F, 1.0638F, -1.0492F, 0.4795F, 1.6853F));
      Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -2.5F, 0.7F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(4.9199F, 8.4227F, 1.0638F, -0.6949F, 0.4529F, 1.7358F));
      Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(4.9199F, 8.4227F, 1.0638F, -0.2208F, 0.5723F, 1.7061F));
      Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 13).addBox(-2.8F, -2.8F, -0.3F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(4.099F, 7.4666F, -0.7887F, 0.3028F, 0.5723F, 1.7061F));
      Body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 13).addBox(-2.7F, -3.2F, 2.4F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.4643F, 5.4565F, -3.4884F, 0.7566F, 0.5723F, 1.7061F));
      Body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, -0.1F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.4643F, 5.4565F, -3.4884F, 1.0184F, 0.5723F, 1.7061F));
      Body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, 0.0F, 0.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-1.3079F, 2.8293F, -6.1525F, 1.2835F, 0.6445F, 1.8642F));
      Body.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(0, 13).addBox(-1.7F, -2.5F, 1.2F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-4.7441F, 0.0355F, -3.9705F, 1.6235F, 0.5754F, 2.4298F));
      Body.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-4.7441F, 0.0355F, -3.9705F, 1.9278F, 0.3184F, 2.8528F));
      Body.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(0, 13).addBox(-2.9F, -4.1F, 2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-6.0044F, -1.1758F, 0.7575F, 2.4585F, 0.1408F, 2.998F));
      Body.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(0, 13).addBox(-2.9F, -3.0F, 0.1F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-6.0044F, -1.1758F, 0.7575F, 2.9577F, -0.0137F, 3.0269F));
      Body.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(0, 13).addBox(-2.9F, -2.5F, -1.9F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-6.0044F, -1.1758F, 0.7575F, -2.9078F, -0.1702F, 3.0394F));
      Body.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(0, 13).addBox(-3.1F, -2.5F, 0.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-3.5645F, -0.3904F, 4.7425F, -2.854F, -0.6347F, 2.9061F));
      Body.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(0, 13).addBox(-3.1F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-3.5645F, -0.3904F, 4.7425F, -2.7298F, -0.9637F, 2.7353F));
      Body.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(0, 13).addBox(-1.6F, -3.5F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.4401F, 0.406F, 5.3346F, -2.2071F, -1.2829F, 2.1654F));
      Body.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -3.5F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.4401F, 0.406F, 5.3346F, -0.388F, -0.9228F, 0.2532F));
      Body.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.5F, 2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(6.5F, -2.5F, -0.5F, -0.2705F, -0.5224F, 0.0197F));
      Body.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(18, 4).addBox(-2.5F, -4.1F, -1.4F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 4).addBox(-2.5F, -4.1F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1548F, -3.8975F, 0.3335F, 0.8814F, -0.3927F, 0.0F));
      PartDefinition Body_r30 = Body.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(15, 13).addBox(-2.5F, -4.1F, -2.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.5F, -2.5F, -3.5F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(1.0F, 0.1F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.0F, 0.1F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -2.5F, -0.5F, -0.1309F, -0.3927F, 0.0F));
      Body_r30.addOrReplaceChild("Body_r33_r1", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, 0.1F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.6F, -3.5F, 0.2182F, 0.0F, 0.0F));
      Body_r30.addOrReplaceChild("Body_r32_r1", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.6F, -3.5F, 0.2618F, 0.0F, -3.1416F));
      Body_r30.addOrReplaceChild("Body_r33_r2", CubeListBuilder.create().texOffs(16, 24).mirror().addBox(-5.5F, -2.4F, -1.7F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.2F, -3.5F, 0.0F, 0.0F, -0.1745F));
      Body_r30.addOrReplaceChild("Body_r32_r2", CubeListBuilder.create().texOffs(16, 24).addBox(-2.4F, -1.7F, -1.7F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(2.0F, -1.2F, -3.5F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone = Body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(6.1548F, -3.8975F, 0.3335F, -3.1416F, 0.0F, 3.1416F));
      bone.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(18, 4).addBox(-2.5F, -4.1F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 0).addBox(-2.5F, -4.1F, -2.4F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0397F, 0.3916F, 2.5101F, 0.8814F, -0.3927F, 0.0F));
      PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 50);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
