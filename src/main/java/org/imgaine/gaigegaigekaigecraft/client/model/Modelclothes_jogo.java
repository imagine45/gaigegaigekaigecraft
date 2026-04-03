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

public class Modelclothes_jogo<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_jogo"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;
   public final ModelPart bb_main;

   public Modelclothes_jogo(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.RightLeg2 = root.getChild("RightLeg2");
      this.LeftLeg2 = root.getChild("LeftLeg2");
      this.bb_main = root.getChild("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(48, 64).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(40, 24).addBox(-2.0F, -10.57F, -1.9998F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.7F)).texOffs(24, 12).addBox(-2.0F, -10.87F, -2.4998F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(24, 12).addBox(-2.0F, -10.87F, 1.0002F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(66, 42).addBox(-1.0F, -0.2681F, -1.346F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 0.0436F, 0.0F, 0.0F));
      Head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(40, 27).addBox(3.6F, 9.1F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.2482F, -13.6856F, 1.424F, 0.0F, 0.0F, 0.0436F));
      Head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(40, 27).mirror().addBox(-4.6F, 9.1F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(-0.2482F, -13.6856F, 1.424F, 0.0F, 0.0F, -0.0436F));
      Head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -0.2731F, -1.551F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, -0.2182F, 0.0F, 0.0F));
      Head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(72, 17).addBox(-1.95F, 0.0216F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).addBox(-1.85F, -0.4784F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(70, 12).addBox(-1.75F, -1.8784F, -2.7792F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).mirror().addBox(-0.05F, 0.0216F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(72, 17).mirror().addBox(-0.15F, -0.4784F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(70, 12).mirror().addBox(-0.25F, -1.8784F, -2.7792F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, -0.1745F, 0.0F, 0.0F));
      Head.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(72, 17).addBox(-0.9051F, 0.6452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).addBox(-0.8051F, 0.1452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(70, 12).addBox(-0.7051F, -1.2548F, -2.9047F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, -0.5661F, 1.1301F, -0.1954F));
      Head.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(72, 17).mirror().addBox(-1.0949F, 0.6452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(72, 17).mirror().addBox(-1.1949F, 0.1452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(70, 12).mirror().addBox(-1.2949F, -1.2548F, -2.9047F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, -0.5661F, -1.1301F, 0.1954F));
      Head.addOrReplaceChild("head_r8", CubeListBuilder.create().texOffs(72, 17).addBox(-3.2318F, 0.3236F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).addBox(-3.1318F, -0.1764F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(70, 12).addBox(-3.0318F, -1.5764F, -1.6409F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 1.7969F, 1.3304F, 1.8536F));
      Head.addOrReplaceChild("head_r9", CubeListBuilder.create().texOffs(72, 17).addBox(-2.7504F, 0.4314F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).addBox(-2.6504F, -0.0686F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(70, 12).addBox(-2.5504F, -1.4686F, -2.441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).addBox(-1.2582F, 0.2392F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(72, 17).addBox(-1.1582F, -0.2608F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).texOffs(70, 12).addBox(-1.0582F, -1.6608F, -2.8843F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 1.666F, 1.3304F, 1.8536F));
      Head.addOrReplaceChild("head_r10", CubeListBuilder.create().texOffs(72, 17).mirror().addBox(1.2318F, 0.3236F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(72, 17).mirror().addBox(1.1318F, -0.1764F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(70, 12).mirror().addBox(1.0318F, -1.5764F, -1.6409F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 1.7969F, -1.3304F, -1.8536F));
      Head.addOrReplaceChild("head_r11", CubeListBuilder.create().texOffs(72, 17).mirror().addBox(0.7504F, 0.4314F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(72, 17).mirror().addBox(0.6504F, -0.0686F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(70, 12).mirror().addBox(0.5504F, -1.4686F, -2.441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(72, 17).mirror().addBox(-0.7418F, 0.2392F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(72, 17).mirror().addBox(-0.8418F, -0.2608F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false).texOffs(70, 12).mirror().addBox(-0.9418F, -1.6608F, -2.8843F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 1.666F, -1.3304F, -1.8536F));
      Head.addOrReplaceChild("head_r12", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-2.108F, -1.9903F, -2.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 0.0F, 1.5708F, 0.0F));
      Head.addOrReplaceChild("head_r13", CubeListBuilder.create().texOffs(24, 12).addBox(-1.892F, -1.9903F, -2.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(0.0F, -8.7797F, 0.1421F, 0.0F, -1.5708F, 0.0F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(56, 52).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(42, 6).mirror().addBox(-4.9562F, 2.5912F, -1.8922F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.8377F, -1.3962F, -0.0894F, -0.0338F, 0.1265F));
      Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(66, 33).mirror().addBox(-2.7978F, 1.9477F, -0.3915F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-5.0285F, 8.9656F, -0.0367F, -3.1213F, -0.9168F, -2.9913F));
      Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(40, 58).mirror().addBox(-1.7978F, -7.3523F, 0.6085F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offsetAndRotation(-5.0285F, 8.9656F, -0.0367F, -3.1213F, -0.9168F, -2.9913F));
      Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(49, 19).addBox(-2.0F, 1.9F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).texOffs(40, 57).addBox(-1.0F, -7.4F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(-4.3377F, 9.031F, 0.0F, 0.0F, 0.0F, 0.1669F));
      Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(66, 33).addBox(-0.0022F, 1.9477F, -1.6085F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0285F, 8.9656F, 0.0367F, 3.1213F, -0.9168F, 2.9913F));
      Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(40, 58).addBox(-0.5F, -4.5F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(4.251F, 6.1866F, 1.4016F, 3.0721F, -0.8277F, 3.0529F));
      Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(66, 33).mirror().addBox(-2.9978F, 1.9477F, -1.6085F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-5.0285F, 8.9656F, 0.0367F, 3.1213F, 0.9168F, -2.9913F));
      Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(42, 45).mirror().addBox(-1.5994F, -7.275F, -0.9972F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offsetAndRotation(-1.9999F, 9.0377F, 1.1962F, 3.059F, 0.0494F, -3.0585F));
      Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(42, 6).mirror().addBox(-2.3785F, 2.2723F, -1.9917F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-1.9999F, 9.0377F, 1.1962F, 0.0784F, -0.0528F, 0.1266F));
      Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(40, 58).mirror().addBox(-0.5F, -4.5F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offsetAndRotation(-4.251F, 6.1866F, 1.4016F, 3.0721F, 0.8277F, -3.0529F));
      Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(42, 6).addBox(-2.6215F, 2.2723F, -1.9917F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(1.9999F, 9.0377F, 1.1962F, 0.0784F, 0.0528F, -0.1266F));
      Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(42, 45).addBox(-1.4006F, -7.275F, -0.9972F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(1.9999F, 9.0377F, 1.1962F, 3.059F, -0.0494F, 3.0585F));
      Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(66, 33).addBox(-0.2022F, 1.9477F, -0.3915F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0285F, 8.9656F, -0.0367F, -3.1213F, 0.9168F, 2.9913F));
      Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(42, 6).addBox(-0.0438F, 2.5912F, -1.8922F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 8.8377F, -1.3962F, -0.0894F, 0.0338F, -0.1265F));
      Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(23, 3).addBox(-1.7F, 1.0F, -4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.55F)).texOffs(23, 3).addBox(0.7F, 1.0F, -4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.55F)).texOffs(10, 69).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, -0.1309F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(23, 3).addBox(-1.201F, 0.3979F, -2.4936F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).texOffs(23, 3).addBox(-3.8625F, -0.9081F, -2.8839F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 1.7555F, -0.7058F, -2.4334F));
      Body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(23, 3).addBox(-2.7154F, -2.4685F, -3.2433F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 1.6187F, 0.5625F, -2.4404F));
      Body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(23, 3).addBox(0.1558F, -3.6073F, -2.2512F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 3.0272F, 0.6976F, -1.3189F));
      Body.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(23, 3).addBox(1.7155F, -1.4115F, -4.8203F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 0.7803F, -0.2136F, -0.7936F));
      Body.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(23, 3).addBox(-1.9145F, -4.195F, -1.004F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 1.8607F, 0.7035F, -2.8383F));
      Body.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(23, 3).addBox(0.2877F, -2.0233F, -3.6298F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.5F, 0.572F, 1.5181F, 0.7803F, -0.2136F, -0.7936F));
      Body.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(23, 3).addBox(0.9835F, 0.0335F, -4.1209F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.5F, 0.572F, 1.5181F, 0.3657F, -0.025F, -0.6104F));
      Body.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(23, 3).addBox(-0.512F, -1.3231F, -1.377F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(0.0F, 0.3084F, 2.0507F, 2.4167F, 0.5644F, -1.2768F));
      Body.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(-1.9835F, 0.0335F, -4.1209F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.572F, 1.5181F, 0.3657F, 0.025F, 0.6104F));
      Body.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(-1.2877F, -2.0233F, -3.6298F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.572F, 1.5181F, 0.7803F, 0.2136F, 0.7936F));
      Body.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(-2.7155F, -1.4115F, -4.8203F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 0.7803F, 0.2136F, 0.7936F));
      Body.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(0.8006F, -4.2388F, -1.4889F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 1.8607F, -0.7035F, 2.8383F));
      Body.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(2.8625F, -0.9081F, -2.8839F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false).texOffs(23, 3).mirror().addBox(0.201F, 0.3979F, -2.4936F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 1.7555F, 0.7058F, 2.4334F));
      Body.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(1.7154F, -2.4685F, -3.2433F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 1.6187F, -0.5625F, 2.4404F));
      Body.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(-1.1558F, -3.6073F, -2.2512F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.572F, 1.5181F, 3.0272F, -0.6976F, 1.3189F));
      Body.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(-0.5F, -4.037F, -0.2768F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.9842F, 1.2442F, -2.7925F, 0.0F, 0.0F));
      Body.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(23, 3).mirror().addBox(-0.488F, -1.3231F, -1.377F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3084F, 2.0507F, 2.4167F, -0.5644F, 1.2768F));
      Body.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(40, 58).addBox(0.7978F, -7.3523F, 0.6085F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(5.0285F, 8.9656F, -0.0367F, -3.1213F, 0.9168F, 2.9913F));
      Body.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(49, 19).mirror().addBox(-2.0F, 1.9F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false).texOffs(40, 57).mirror().addBox(-1.0F, -7.4F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offsetAndRotation(4.3377F, 9.031F, 0.0F, 0.0F, 0.0F, -0.1669F));
      Body.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(32, 43).mirror().addBox(-0.2F, 3.0F, 1.6F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.65F)).mirror(false), PartPose.offsetAndRotation(0.2617F, -2.4943F, -2.1F, -0.0028F, 0.0447F, -0.0795F));
      Body.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(32, 43).addBox(-2.8F, 3.0F, 1.6F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.65F)), PartPose.offsetAndRotation(-0.2617F, -2.4943F, -2.1F, -0.0028F, -0.0447F, 0.0795F));
      Body.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(32, 45).addBox(-4.0897F, -7.0689F, -0.8809F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(0.0F, 8.8377F, -1.3962F, -0.0898F, -0.0376F, 0.083F));
      Body.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(42, 45).addBox(1.0897F, -7.0689F, -0.8809F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(0.0F, 8.8377F, -1.3962F, -0.0898F, 0.0376F, -0.083F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(64, 49).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(1, 2).addBox(-3.5F, 8.2F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.05F)).texOffs(40, 56).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      RightArm.addOrReplaceChild("head_r14", CubeListBuilder.create().texOffs(40, 57).addBox(-1.1F, -2.9F, -1.1F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(64, 49).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 2).mirror().addBox(-1.5F, 8.2F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.05F)).mirror(false).texOffs(40, 56).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      LeftArm.addOrReplaceChild("head_r15", CubeListBuilder.create().texOffs(40, 57).mirror().addBox(-0.9F, -2.9F, -1.1F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.0F, 0.0F, 0.0F, -3.1416F, 0.0F));
      partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -23.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 80, 80);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
