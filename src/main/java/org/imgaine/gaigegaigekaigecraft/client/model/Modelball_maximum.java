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

public class Modelball_maximum<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelball_maximum"), "main");
   public final ModelPart BallMain;

   public Modelball_maximum(ModelPart root) {
      this.BallMain = root.getChild("BallMain");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition BallMain = partdefinition.addOrReplaceChild("BallMain", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition Circle1 = BallMain.addOrReplaceChild("Circle1", CubeListBuilder.create().texOffs(0, 624).addBox(-64.0F, -96.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offset(16.0F, 48.0F, -112.0F));
      Circle1.addOrReplaceChild("Circle1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-16.0F, -48.4865F, 111.4482F, -2.7489F, 0.0F, 0.0F));
      Circle1.addOrReplaceChild("Circle1_r2", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-16.0F, -48.0608F, 111.7327F, -2.3562F, 0.0F, 0.0F));
      Circle1.addOrReplaceChild("Circle1_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-16.0F, -47.7763F, 112.1584F, -1.9635F, 0.0F, 0.0F));
      Circle1.addOrReplaceChild("Circle1_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-16.0F, -47.8578F, 111.7871F, -1.1781F, 0.0F, 0.0F));
      Circle1.addOrReplaceChild("Circle1_r5", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-16.0F, -48.1422F, 112.2129F, -0.7854F, 0.0F, 0.0F));
      Circle1.addOrReplaceChild("Circle1_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-16.0F, -90.8605F, 8.5255F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle2 = BallMain.addOrReplaceChild("Circle2", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
      Circle2.addOrReplaceChild("Circle2_r1", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle2.addOrReplaceChild("Circle2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle2.addOrReplaceChild("Circle2_r3", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle2.addOrReplaceChild("Circle2_r4", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle2.addOrReplaceChild("Circle2_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle2.addOrReplaceChild("Circle2_r6", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle3 = BallMain.addOrReplaceChild("Circle3", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
      Circle3.addOrReplaceChild("Circle3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle3.addOrReplaceChild("Circle3_r2", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle3.addOrReplaceChild("Circle3_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle3.addOrReplaceChild("Circle3_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle3.addOrReplaceChild("Circle3_r5", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle3.addOrReplaceChild("Circle3_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle4 = BallMain.addOrReplaceChild("Circle4", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
      Circle4.addOrReplaceChild("Circle4_r1", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle4.addOrReplaceChild("Circle4_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle4.addOrReplaceChild("Circle4_r3", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle4.addOrReplaceChild("Circle4_r4", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle4.addOrReplaceChild("Circle4_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle4.addOrReplaceChild("Circle4_r6", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle5 = BallMain.addOrReplaceChild("Circle5", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r2", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.3394F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3236F, 0.6606F, -1.5708F, 0.0F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r6", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle5.addOrReplaceChild("Circle5_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle6 = BallMain.addOrReplaceChild("Circle6", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 3.1416F));
      Circle6.addOrReplaceChild("Circle6_r1", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle6.addOrReplaceChild("Circle6_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle6.addOrReplaceChild("Circle6_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.3394F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.3236F, 0.6606F, -1.5708F, 0.0F, 0.0F));
      Circle6.addOrReplaceChild("Circle6_r4", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle6.addOrReplaceChild("Circle6_r5", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle6.addOrReplaceChild("Circle6_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle6.addOrReplaceChild("Circle6_r7", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle7 = BallMain.addOrReplaceChild("Circle7", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
      Circle7.addOrReplaceChild("Circle7_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle7.addOrReplaceChild("Circle7_r2", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle7.addOrReplaceChild("Circle7_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.3394F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.3236F, 0.6606F, -1.5708F, 0.0F, 0.0F));
      Circle7.addOrReplaceChild("Circle7_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle7.addOrReplaceChild("Circle7_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle7.addOrReplaceChild("Circle7_r6", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle7.addOrReplaceChild("Circle7_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      PartDefinition Circle8 = BallMain.addOrReplaceChild("Circle8", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.0F, -240.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.3927F, 3.1416F));
      Circle8.addOrReplaceChild("Circle8_r1", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.6606F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.4865F, -0.5518F, -2.7489F, 0.0F, 0.0F));
      Circle8.addOrReplaceChild("Circle8_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -48.232F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.0608F, -0.2673F, -2.3562F, 0.0F, 0.0F));
      Circle8.addOrReplaceChild("Circle8_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.3394F, -240.3236F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.3236F, 0.6606F, -1.5708F, 0.0F, 0.0F));
      Circle8.addOrReplaceChild("Circle8_r4", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -47.768F, -240.146F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.2237F, 0.1584F, -1.9635F, 0.0F, 0.0F));
      Circle8.addOrReplaceChild("Circle8_r5", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.2511F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.1422F, -0.2129F, -1.1781F, 0.0F, 0.0F));
      Circle8.addOrReplaceChild("Circle8_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-48.0F, -47.7489F, -240.0499F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -0.1422F, 0.2129F, -0.7854F, 0.0F, 0.0F));
      Circle8.addOrReplaceChild("Circle8_r7", CubeListBuilder.create().texOffs(0, 624).addBox(-48.0F, -48.0F, -128.0F, 96.0F, 96.0F, 480.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -42.8605F, -103.4745F, -0.3927F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 1200, 1200);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.BallMain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
