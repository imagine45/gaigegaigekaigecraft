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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelTigerFuneral<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_tiger_funeral"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart Tail;

   public ModelTigerFuneral(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.Tail = root.getChild("Tail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -18.0F));
      Head.addOrReplaceChild("HeadMain_r1", CubeListBuilder.create().texOffs(18, 0).addBox(-3.3F, -1.5F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 1.7716F, -7.9971F, 0.2009F, 0.5148F, 0.0999F));
      Head.addOrReplaceChild("HeadMain_r2", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(1.3F, -1.5F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4F, 1.7716F, -7.9971F, 0.2009F, -0.5148F, -0.0999F));
      Head.addOrReplaceChild("HeadMain_r3", CubeListBuilder.create().texOffs(60, 0).addBox(-2.6F, -2.0F, -2.2F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.99F)).texOffs(22, 0).addBox(-1.5F, -1.0F, -2.2F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3086F, -8.272F, 0.9163F, 0.0F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r4", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -0.3F, -8.2F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(1, 0).addBox(-2.0F, -1.2F, -8.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 2.4032F, -2.9242F, 0.1745F, 0.0F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r5", CubeListBuilder.create().texOffs(24, 8).addBox(-2.3F, -1.5F, -2.2F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8025F, 3.5832F, -7.8886F, 0.1886F, -0.3864F, -0.0718F));
      Head.addOrReplaceChild("HeadMain_r6", CubeListBuilder.create().texOffs(0, 24).addBox(-3.5F, -2.2F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-3.3308F, 5.0344F, -9.7616F, 0.3586F, -0.2635F, -0.6097F));
      Head.addOrReplaceChild("HeadMain_r7", CubeListBuilder.create().texOffs(0, 24).addBox(-3.5F, -2.0F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-3.1884F, 5.1996F, -9.2205F, 0.5641F, 0.2154F, -0.6277F));
      Head.addOrReplaceChild("HeadMain_r8", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-3.5F, -2.0F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)).mirror(false), PartPose.offsetAndRotation(3.1884F, 5.1996F, -9.2205F, 0.5641F, -0.2154F, 0.6277F));
      Head.addOrReplaceChild("HeadMain_r9", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-3.5F, -2.2F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)).mirror(false), PartPose.offsetAndRotation(3.3308F, 5.0344F, -9.7616F, 0.3586F, 0.2635F, 0.6097F));
      Head.addOrReplaceChild("HeadMain_r10", CubeListBuilder.create().texOffs(24, 8).mirror().addBox(0.0F, -1.5F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0031F, 3.6352F, -8.1836F, 0.1886F, 0.3864F, 0.0718F));
      Head.addOrReplaceChild("HeadMain_r11", CubeListBuilder.create().texOffs(110, 110).addBox(-2.0F, -0.4F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 5.6233F, -7.9413F, -0.1745F, 0.0F, -3.1416F));
      Head.addOrReplaceChild("HeadMain_r12", CubeListBuilder.create().texOffs(124, 108).addBox(1.0F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)), PartPose.offsetAndRotation(0.2F, 5.4257F, -9.8834F, -0.3491F, 0.0F, -3.1416F));
      Head.addOrReplaceChild("HeadMain_r13", CubeListBuilder.create().texOffs(124, 108).addBox(1.0F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)), PartPose.offsetAndRotation(0.2F, 5.4257F, -9.8834F, -0.6109F, 0.0F, -3.1416F));
      Head.addOrReplaceChild("HeadMain_r14", CubeListBuilder.create().texOffs(124, 108).mirror().addBox(-2.0F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)).mirror(false), PartPose.offsetAndRotation(-0.2F, 5.4257F, -9.8834F, -0.3491F, 0.0F, -3.1416F));
      Head.addOrReplaceChild("HeadMain_r15", CubeListBuilder.create().texOffs(124, 108).mirror().addBox(-2.0F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)).mirror(false), PartPose.offsetAndRotation(-0.2F, 5.4257F, -9.8834F, -0.6109F, 0.0F, -3.1416F));
      Head.addOrReplaceChild("HeadMain_r16", CubeListBuilder.create().texOffs(0, 8).addBox(-4.0F, -4.2F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.4032F, -2.4242F, 0.1745F, 0.0F, 0.0F));
      Head.addOrReplaceChild("HeadMain_r17", CubeListBuilder.create().texOffs(36, 14).addBox(3.1471F, -1.5F, 2.6013F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.883F, -1.2113F, -0.3492F, 0.886F, -0.2749F));
      Head.addOrReplaceChild("HeadMain_r18", CubeListBuilder.create().texOffs(36, 14).mirror().addBox(-3.1471F, -1.5F, 2.6013F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.883F, -1.2113F, -0.3492F, -0.886F, 0.2749F));
      Head.addOrReplaceChild("HeadMain_r19", CubeListBuilder.create().texOffs(36, 14).mirror().addBox(-0.6F, -1.5F, -1.2F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 5.276F, -5.4717F, 0.2009F, -0.5148F, -0.0999F));
      Head.addOrReplaceChild("HeadMain_r20", CubeListBuilder.create().texOffs(36, 14).mirror().addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.8696F, 7.983F, -3.7113F, -1.2889F, -0.8967F, -0.2226F));
      Head.addOrReplaceChild("HeadMain_r21", CubeListBuilder.create().texOffs(36, 14).mirror().addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.7696F, 6.583F, -4.5113F, -0.5162F, -0.5834F, -0.2307F));
      Head.addOrReplaceChild("HeadMain_r22", CubeListBuilder.create().texOffs(36, 14).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.8696F, 7.983F, -3.7113F, -1.2889F, 0.8967F, 0.2226F));
      Head.addOrReplaceChild("HeadMain_r23", CubeListBuilder.create().texOffs(36, 14).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.7696F, 6.583F, -4.5113F, -0.5162F, 0.5834F, 0.2307F));
      Head.addOrReplaceChild("HeadMain_r24", CubeListBuilder.create().texOffs(36, 14).addBox(0.6F, -1.5F, -1.2F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.0F, 5.276F, -5.4717F, 0.2009F, 0.5148F, 0.0999F));
      Head.addOrReplaceChild("HeadMain_r25", CubeListBuilder.create().texOffs(39, 0).mirror().addBox(-1.1F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3167F, -0.792F, -4.0095F, -0.1821F, 0.4219F, -0.5208F));
      Head.addOrReplaceChild("HeadMain_r26", CubeListBuilder.create().texOffs(39, 0).addBox(-1.9F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3167F, -0.792F, -4.0095F, -0.1821F, -0.4219F, 0.5208F));
      PartDefinition Head2 = Head.addOrReplaceChild("Head2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.518F, -4.5102F, 0.2182F, 0.0F, 0.0F));
      Head2.addOrReplaceChild("HeadMain_r27", CubeListBuilder.create().texOffs(110, 110).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)).texOffs(36, 8).addBox(-2.0F, 0.9F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).texOffs(42, 0).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9165F, -1.7727F, 0.7854F, 0.0F, 0.0F));
      Head2.addOrReplaceChild("HeadMain_r28", CubeListBuilder.create().texOffs(124, 108).mirror().addBox(-0.5F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)).mirror(false), PartPose.offsetAndRotation(-1.3F, 1.6077F, -3.8733F, 0.7854F, 0.3927F, 0.0F));
      Head2.addOrReplaceChild("HeadMain_r29", CubeListBuilder.create().texOffs(124, 108).mirror().addBox(-0.5F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)).mirror(false), PartPose.offsetAndRotation(-1.3F, 1.6077F, -3.8733F, 0.5236F, 0.3927F, 0.0F));
      Head2.addOrReplaceChild("HeadMain_r30", CubeListBuilder.create().texOffs(124, 108).addBox(-0.5F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)), PartPose.offsetAndRotation(1.3F, 1.6077F, -3.8733F, 0.5236F, -0.3491F, 0.0F));
      Head2.addOrReplaceChild("HeadMain_r31", CubeListBuilder.create().texOffs(124, 108).addBox(-0.5F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)), PartPose.offsetAndRotation(1.3F, 1.6077F, -3.8733F, 0.7854F, -0.3491F, 0.0F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(1.1F, 1.6423F, 7.5809F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 47).addBox(-3.5F, -4.2F, -6.3F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1F, 4.1328F, -20.6389F, -0.2618F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 102).addBox(-5.5F, -7.5F, 3.3F, 11.0F, 10.0F, 15.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.1F, 6.4429F, -12.0196F, -0.0873F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 102).addBox(-5.5F, -7.5F, -10.0F, 11.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 6.4429F, -12.0196F, 0.0873F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(109, 30).mirror().addBox(-0.9855F, 15.0549F, -1.7261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-4.563F, 6.7037F, -11.2139F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(112, 17).mirror().addBox(-1.5F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.5097F, 10.918F, 1.6757F, -0.1309F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(106, 0).mirror().addBox(-2.0F, -5.5F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3456F, 2.6213F, 0.7905F, 0.2182F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(109, 30).addBox(-3.0145F, 15.0549F, -1.7261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(4.563F, 6.7037F, -11.2139F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(112, 17).addBox(-2.5F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5097F, 10.918F, 1.6757F, -0.1309F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(106, 0).addBox(-3.0F, -5.5F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3456F, 2.6213F, 0.7905F, 0.2182F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(106, 37).mirror().addBox(-1.4819F, -2.1936F, -3.3638F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(109, 30).mirror().addBox(-0.8594F, 15.8459F, -2.415F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.2529F, 6.1541F, 11.3573F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(88, 0).mirror().addBox(-2.0F, -2.4F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0169F, 9.008F, 0.0726F, 0.2618F, 0.0F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(89, 10).mirror().addBox(-1.5F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.21F)).mirror(false), PartPose.offsetAndRotation(0.6406F, 13.5459F, 0.985F, -0.0873F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(106, 37).addBox(-3.5181F, -2.1936F, -3.3638F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(109, 30).addBox(-3.1406F, 15.8459F, -2.415F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.2529F, 6.1541F, 11.3573F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(88, 0).addBox(-2.0F, -2.4F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0169F, 9.008F, 0.0726F, 0.2618F, 0.0F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(89, 10).addBox(-1.5F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.21F)), PartPose.offsetAndRotation(-1.6406F, 13.5459F, 0.985F, -0.0873F, 0.0F, 0.0F));
      PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(-0.2F, 4.5F, 14.38F));
      Tail.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(106, 117).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.2F, 4.554F, 14.4989F, 0.3927F, 0.0F, 0.0F));
      Tail.addOrReplaceChild("Tail_r2", CubeListBuilder.create().texOffs(106, 117).addBox(-1.5F, -0.5583F, -4.3243F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.2F, 4.2855F, 8.411F, -0.1745F, 0.0F, 0.0F));
      Tail.addOrReplaceChild("Tail_r3", CubeListBuilder.create().texOffs(106, 117).addBox(-1.5F, 1.1727F, -10.5127F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 4.2855F, 8.411F, -0.6981F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
      this.LeftArm.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
