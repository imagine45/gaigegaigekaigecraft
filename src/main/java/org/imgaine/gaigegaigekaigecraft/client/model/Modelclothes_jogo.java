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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_jogo"), "main");
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
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.RightLeg2 = root.m_171324_("RightLeg2");
      this.LeftLeg2 = root.m_171324_("LeftLeg2");
      this.bb_main = root.m_171324_("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(48, 64).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(40, 24).m_171488_(-2.0F, -10.57F, -1.9998F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.7F)).m_171514_(24, 12).m_171488_(-2.0F, -10.87F, -2.4998F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(24, 12).m_171488_(-2.0F, -10.87F, 1.0002F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(66, 42).m_171488_(-1.0F, -0.2681F, -1.346F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 0.0436F, 0.0F, 0.0F));
      Head.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(40, 27).m_171488_(3.6F, 9.1F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.2482F, -13.6856F, 1.424F, 0.0F, 0.0F, 0.0436F));
      Head.m_171599_("head_r3", CubeListBuilder.m_171558_().m_171514_(40, 27).m_171480_().m_171488_(-4.6F, 9.1F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(-0.2482F, -13.6856F, 1.424F, 0.0F, 0.0F, -0.0436F));
      Head.m_171599_("head_r4", CubeListBuilder.m_171558_().m_171514_(0, 3).m_171488_(-0.5F, -0.2731F, -1.551F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, -0.2182F, 0.0F, 0.0F));
      Head.m_171599_("head_r5", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171488_(-1.95F, 0.0216F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171488_(-1.85F, -0.4784F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(70, 12).m_171488_(-1.75F, -1.8784F, -2.7792F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171480_().m_171488_(-0.05F, 0.0216F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(72, 17).m_171480_().m_171488_(-0.15F, -0.4784F, -2.8792F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(70, 12).m_171480_().m_171488_(-0.25F, -1.8784F, -2.7792F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, -0.1745F, 0.0F, 0.0F));
      Head.m_171599_("head_r6", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171488_(-0.9051F, 0.6452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171488_(-0.8051F, 0.1452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(70, 12).m_171488_(-0.7051F, -1.2548F, -2.9047F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, -0.5661F, 1.1301F, -0.1954F));
      Head.m_171599_("head_r7", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171480_().m_171488_(-1.0949F, 0.6452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(72, 17).m_171480_().m_171488_(-1.1949F, 0.1452F, -2.8047F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(70, 12).m_171480_().m_171488_(-1.2949F, -1.2548F, -2.9047F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, -0.5661F, -1.1301F, 0.1954F));
      Head.m_171599_("head_r8", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171488_(-3.2318F, 0.3236F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171488_(-3.1318F, -0.1764F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(70, 12).m_171488_(-3.0318F, -1.5764F, -1.6409F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 1.7969F, 1.3304F, 1.8536F));
      Head.m_171599_("head_r9", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171488_(-2.7504F, 0.4314F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171488_(-2.6504F, -0.0686F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(70, 12).m_171488_(-2.5504F, -1.4686F, -2.441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171488_(-1.2582F, 0.2392F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(72, 17).m_171488_(-1.1582F, -0.2608F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171514_(70, 12).m_171488_(-1.0582F, -1.6608F, -2.8843F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 1.666F, 1.3304F, 1.8536F));
      Head.m_171599_("head_r10", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171480_().m_171488_(1.2318F, 0.3236F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(72, 17).m_171480_().m_171488_(1.1318F, -0.1764F, -1.7409F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(70, 12).m_171480_().m_171488_(1.0318F, -1.5764F, -1.6409F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 1.7969F, -1.3304F, -1.8536F));
      Head.m_171599_("head_r11", CubeListBuilder.m_171558_().m_171514_(72, 17).m_171480_().m_171488_(0.7504F, 0.4314F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(72, 17).m_171480_().m_171488_(0.6504F, -0.0686F, -2.541F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(70, 12).m_171480_().m_171488_(0.5504F, -1.4686F, -2.441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(72, 17).m_171480_().m_171488_(-0.7418F, 0.2392F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(72, 17).m_171480_().m_171488_(-0.8418F, -0.2608F, -2.9843F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(70, 12).m_171480_().m_171488_(-0.9418F, -1.6608F, -2.8843F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 1.666F, -1.3304F, -1.8536F));
      Head.m_171599_("head_r12", CubeListBuilder.m_171558_().m_171514_(24, 12).m_171480_().m_171488_(-2.108F, -1.9903F, -2.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 0.0F, 1.5708F, 0.0F));
      Head.m_171599_("head_r13", CubeListBuilder.m_171558_().m_171514_(24, 12).m_171488_(-1.892F, -1.9903F, -2.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(0.0F, -8.7797F, 0.1421F, 0.0F, -1.5708F, 0.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(56, 52).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(42, 6).m_171480_().m_171488_(-4.9562F, 2.5912F, -1.8922F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(0.0F, 8.8377F, -1.3962F, -0.0894F, -0.0338F, 0.1265F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(66, 33).m_171480_().m_171488_(-2.7978F, 1.9477F, -0.3915F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).m_171555_(false), PartPose.m_171423_(-5.0285F, 8.9656F, -0.0367F, -3.1213F, -0.9168F, -2.9913F));
      Body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(40, 58).m_171480_().m_171488_(-1.7978F, -7.3523F, 0.6085F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)).m_171555_(false), PartPose.m_171423_(-5.0285F, 8.9656F, -0.0367F, -3.1213F, -0.9168F, -2.9913F));
      Body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(49, 19).m_171488_(-2.0F, 1.9F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).m_171514_(40, 57).m_171488_(-1.0F, -7.4F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(-4.3377F, 9.031F, 0.0F, 0.0F, 0.0F, 0.1669F));
      Body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(66, 33).m_171488_(-0.0022F, 1.9477F, -1.6085F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(5.0285F, 8.9656F, 0.0367F, 3.1213F, -0.9168F, 2.9913F));
      Body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(40, 58).m_171488_(-0.5F, -4.5F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(4.251F, 6.1866F, 1.4016F, 3.0721F, -0.8277F, 3.0529F));
      Body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(66, 33).m_171480_().m_171488_(-2.9978F, 1.9477F, -1.6085F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).m_171555_(false), PartPose.m_171423_(-5.0285F, 8.9656F, 0.0367F, 3.1213F, 0.9168F, -2.9913F));
      Body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(42, 45).m_171480_().m_171488_(-1.5994F, -7.275F, -0.9972F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)).m_171555_(false), PartPose.m_171423_(-1.9999F, 9.0377F, 1.1962F, 3.059F, 0.0494F, -3.0585F));
      Body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(42, 6).m_171480_().m_171488_(-2.3785F, 2.2723F, -1.9917F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(-1.9999F, 9.0377F, 1.1962F, 0.0784F, -0.0528F, 0.1266F));
      Body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(40, 58).m_171480_().m_171488_(-0.5F, -4.5F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)).m_171555_(false), PartPose.m_171423_(-4.251F, 6.1866F, 1.4016F, 3.0721F, 0.8277F, -3.0529F));
      Body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(42, 6).m_171488_(-2.6215F, 2.2723F, -1.9917F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(1.9999F, 9.0377F, 1.1962F, 0.0784F, 0.0528F, -0.1266F));
      Body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(42, 45).m_171488_(-1.4006F, -7.275F, -0.9972F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(1.9999F, 9.0377F, 1.1962F, 3.059F, -0.0494F, 3.0585F));
      Body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(66, 33).m_171488_(-0.2022F, 1.9477F, -0.3915F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(5.0285F, 8.9656F, -0.0367F, -3.1213F, 0.9168F, 2.9913F));
      Body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(42, 6).m_171488_(-0.0438F, 2.5912F, -1.8922F, 5.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.0F, 8.8377F, -1.3962F, -0.0894F, 0.0338F, -0.1265F));
      Body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(-1.7F, 1.0F, -4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.55F)).m_171514_(23, 3).m_171488_(0.7F, 1.0F, -4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.55F)).m_171514_(10, 69).m_171488_(-1.0F, 0.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, -0.1309F, 0.0F, 0.0F));
      Body.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(-1.201F, 0.3979F, -2.4936F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171514_(23, 3).m_171488_(-3.8625F, -0.9081F, -2.8839F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 1.7555F, -0.7058F, -2.4334F));
      Body.m_171599_("Body_r17", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(-2.7154F, -2.4685F, -3.2433F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 1.6187F, 0.5625F, -2.4404F));
      Body.m_171599_("Body_r18", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(0.1558F, -3.6073F, -2.2512F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 3.0272F, 0.6976F, -1.3189F));
      Body.m_171599_("Body_r19", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(1.7155F, -1.4115F, -4.8203F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 0.7803F, -0.2136F, -0.7936F));
      Body.m_171599_("Body_r20", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(-1.9145F, -4.195F, -1.004F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 1.8607F, 0.7035F, -2.8383F));
      Body.m_171599_("Body_r21", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(0.2877F, -2.0233F, -3.6298F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.5F, 0.572F, 1.5181F, 0.7803F, -0.2136F, -0.7936F));
      Body.m_171599_("Body_r22", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(0.9835F, 0.0335F, -4.1209F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.5F, 0.572F, 1.5181F, 0.3657F, -0.025F, -0.6104F));
      Body.m_171599_("Body_r23", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171488_(-0.512F, -1.3231F, -1.377F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.3084F, 2.0507F, 2.4167F, 0.5644F, -1.2768F));
      Body.m_171599_("Body_r24", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(-1.9835F, 0.0335F, -4.1209F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(-0.5F, 0.572F, 1.5181F, 0.3657F, 0.025F, 0.6104F));
      Body.m_171599_("Body_r25", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(-1.2877F, -2.0233F, -3.6298F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(-0.5F, 0.572F, 1.5181F, 0.7803F, 0.2136F, 0.7936F));
      Body.m_171599_("Body_r26", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(-2.7155F, -1.4115F, -4.8203F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 0.7803F, 0.2136F, 0.7936F));
      Body.m_171599_("Body_r27", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(0.8006F, -4.2388F, -1.4889F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 1.8607F, -0.7035F, 2.8383F));
      Body.m_171599_("Body_r28", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(2.8625F, -0.9081F, -2.8839F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false).m_171514_(23, 3).m_171480_().m_171488_(0.201F, 0.3979F, -2.4936F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 1.7555F, 0.7058F, 2.4334F));
      Body.m_171599_("Body_r29", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(1.7154F, -2.4685F, -3.2433F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 1.6187F, -0.5625F, 2.4404F));
      Body.m_171599_("Body_r30", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(-1.1558F, -3.6073F, -2.2512F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.572F, 1.5181F, 3.0272F, -0.6976F, 1.3189F));
      Body.m_171599_("Body_r31", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(-0.5F, -4.037F, -0.2768F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, -2.9842F, 1.2442F, -2.7925F, 0.0F, 0.0F));
      Body.m_171599_("Body_r32", CubeListBuilder.m_171558_().m_171514_(23, 3).m_171480_().m_171488_(-0.488F, -1.3231F, -1.377F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.3084F, 2.0507F, 2.4167F, -0.5644F, 1.2768F));
      Body.m_171599_("Body_r33", CubeListBuilder.m_171558_().m_171514_(40, 58).m_171488_(0.7978F, -7.3523F, 0.6085F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(5.0285F, 8.9656F, -0.0367F, -3.1213F, 0.9168F, 2.9913F));
      Body.m_171599_("Body_r34", CubeListBuilder.m_171558_().m_171514_(49, 19).m_171480_().m_171488_(-2.0F, 1.9F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).m_171555_(false).m_171514_(40, 57).m_171480_().m_171488_(-1.0F, -7.4F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.75F)).m_171555_(false), PartPose.m_171423_(4.3377F, 9.031F, 0.0F, 0.0F, 0.0F, -0.1669F));
      Body.m_171599_("Body_r35", CubeListBuilder.m_171558_().m_171514_(32, 43).m_171480_().m_171488_(-0.2F, 3.0F, 1.6F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.65F)).m_171555_(false), PartPose.m_171423_(0.2617F, -2.4943F, -2.1F, -0.0028F, 0.0447F, -0.0795F));
      Body.m_171599_("Body_r36", CubeListBuilder.m_171558_().m_171514_(32, 43).m_171488_(-2.8F, 3.0F, 1.6F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.65F)), PartPose.m_171423_(-0.2617F, -2.4943F, -2.1F, -0.0028F, -0.0447F, 0.0795F));
      Body.m_171599_("Body_r37", CubeListBuilder.m_171558_().m_171514_(32, 45).m_171488_(-4.0897F, -7.0689F, -0.8809F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(0.0F, 8.8377F, -1.3962F, -0.0898F, -0.0376F, 0.083F));
      Body.m_171599_("Body_r38", CubeListBuilder.m_171558_().m_171514_(42, 45).m_171488_(1.0897F, -7.0689F, -0.8809F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(0.0F, 8.8377F, -1.3962F, -0.0898F, 0.0376F, -0.083F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(64, 49).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(1, 2).m_171488_(-3.5F, 8.2F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.05F)).m_171514_(40, 56).m_171488_(-2.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      RightArm.m_171599_("head_r14", CubeListBuilder.m_171558_().m_171514_(40, 57).m_171488_(-1.1F, -2.9F, -1.1F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)), PartPose.m_171423_(-1.0F, 2.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(64, 49).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(1, 2).m_171480_().m_171488_(-1.5F, 8.2F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.05F)).m_171555_(false).m_171514_(40, 56).m_171480_().m_171488_(0.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      LeftArm.m_171599_("head_r15", CubeListBuilder.m_171558_().m_171514_(40, 57).m_171480_().m_171488_(-0.9F, -2.9F, -1.1F, 2.0F, 8.0F, 2.0F, new CubeDeformation(1.35F)).m_171555_(false), PartPose.m_171423_(1.0F, 2.0F, 0.0F, 0.0F, -3.1416F, 0.0F));
      partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("RightLeg2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171480_().m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -23.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 80, 80);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
