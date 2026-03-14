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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_tiger_funeral"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart Tail;

   public ModelTigerFuneral(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.Tail = root.m_171324_("Tail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 2.0F, -18.0F));
      Head.m_171599_("HeadMain_r1", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171488_(-3.3F, -1.5F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.4F, 1.7716F, -7.9971F, 0.2009F, 0.5148F, 0.0999F));
      Head.m_171599_("HeadMain_r2", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171480_().m_171488_(1.3F, -1.5F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.4F, 1.7716F, -7.9971F, 0.2009F, -0.5148F, -0.0999F));
      Head.m_171599_("HeadMain_r3", CubeListBuilder.m_171558_().m_171514_(60, 0).m_171488_(-2.6F, -2.0F, -2.2F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.99F)).m_171514_(22, 0).m_171488_(-1.5F, -1.0F, -2.2F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.3086F, -8.272F, 0.9163F, 0.0F, 0.0F));
      Head.m_171599_("HeadMain_r4", CubeListBuilder.m_171558_().m_171514_(58, 0).m_171488_(-1.0F, -0.3F, -8.2F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(1, 0).m_171488_(-2.0F, -1.2F, -8.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 2.4032F, -2.9242F, 0.1745F, 0.0F, 0.0F));
      Head.m_171599_("HeadMain_r5", CubeListBuilder.m_171558_().m_171514_(24, 8).m_171488_(-2.3F, -1.5F, -2.2F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.8025F, 3.5832F, -7.8886F, 0.1886F, -0.3864F, -0.0718F));
      Head.m_171599_("HeadMain_r6", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-3.5F, -2.2F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)), PartPose.m_171423_(-3.3308F, 5.0344F, -9.7616F, 0.3586F, -0.2635F, -0.6097F));
      Head.m_171599_("HeadMain_r7", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-3.5F, -2.0F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)), PartPose.m_171423_(-3.1884F, 5.1996F, -9.2205F, 0.5641F, 0.2154F, -0.6277F));
      Head.m_171599_("HeadMain_r8", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171480_().m_171488_(-3.5F, -2.0F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)).m_171555_(false), PartPose.m_171423_(3.1884F, 5.1996F, -9.2205F, 0.5641F, -0.2154F, 0.6277F));
      Head.m_171599_("HeadMain_r9", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171480_().m_171488_(-3.5F, -2.2F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-1.9F)).m_171555_(false), PartPose.m_171423_(3.3308F, 5.0344F, -9.7616F, 0.3586F, 0.2635F, 0.6097F));
      Head.m_171599_("HeadMain_r10", CubeListBuilder.m_171558_().m_171514_(24, 8).m_171480_().m_171488_(0.0F, -1.5F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0031F, 3.6352F, -8.1836F, 0.1886F, 0.3864F, 0.0718F));
      Head.m_171599_("HeadMain_r11", CubeListBuilder.m_171558_().m_171514_(110, 110).m_171488_(-2.0F, -0.4F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 5.6233F, -7.9413F, -0.1745F, 0.0F, -3.1416F));
      Head.m_171599_("HeadMain_r12", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171488_(1.0F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)), PartPose.m_171423_(0.2F, 5.4257F, -9.8834F, -0.3491F, 0.0F, -3.1416F));
      Head.m_171599_("HeadMain_r13", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171488_(1.0F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)), PartPose.m_171423_(0.2F, 5.4257F, -9.8834F, -0.6109F, 0.0F, -3.1416F));
      Head.m_171599_("HeadMain_r14", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171480_().m_171488_(-2.0F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)).m_171555_(false), PartPose.m_171423_(-0.2F, 5.4257F, -9.8834F, -0.3491F, 0.0F, -3.1416F));
      Head.m_171599_("HeadMain_r15", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171480_().m_171488_(-2.0F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)).m_171555_(false), PartPose.m_171423_(-0.2F, 5.4257F, -9.8834F, -0.6109F, 0.0F, -3.1416F));
      Head.m_171599_("HeadMain_r16", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171488_(-4.0F, -4.2F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 2.4032F, -2.4242F, 0.1745F, 0.0F, 0.0F));
      Head.m_171599_("HeadMain_r17", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171488_(3.1471F, -1.5F, 2.6013F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 4.883F, -1.2113F, -0.3492F, 0.886F, -0.2749F));
      Head.m_171599_("HeadMain_r18", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171480_().m_171488_(-3.1471F, -1.5F, 2.6013F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 4.883F, -1.2113F, -0.3492F, -0.886F, 0.2749F));
      Head.m_171599_("HeadMain_r19", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171480_().m_171488_(-0.6F, -1.5F, -1.2F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-4.0F, 5.276F, -5.4717F, 0.2009F, -0.5148F, -0.0999F));
      Head.m_171599_("HeadMain_r20", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171480_().m_171488_(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.8696F, 7.983F, -3.7113F, -1.2889F, -0.8967F, -0.2226F));
      Head.m_171599_("HeadMain_r21", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171480_().m_171488_(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.7696F, 6.583F, -4.5113F, -0.5162F, -0.5834F, -0.2307F));
      Head.m_171599_("HeadMain_r22", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171488_(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.8696F, 7.983F, -3.7113F, -1.2889F, 0.8967F, 0.2226F));
      Head.m_171599_("HeadMain_r23", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171488_(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.7696F, 6.583F, -4.5113F, -0.5162F, 0.5834F, 0.2307F));
      Head.m_171599_("HeadMain_r24", CubeListBuilder.m_171558_().m_171514_(36, 14).m_171488_(0.6F, -1.5F, -1.2F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(4.0F, 5.276F, -5.4717F, 0.2009F, 0.5148F, 0.0999F));
      Head.m_171599_("HeadMain_r25", CubeListBuilder.m_171558_().m_171514_(39, 0).m_171480_().m_171488_(-1.1F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.3167F, -0.792F, -4.0095F, -0.1821F, 0.4219F, -0.5208F));
      Head.m_171599_("HeadMain_r26", CubeListBuilder.m_171558_().m_171514_(39, 0).m_171488_(-1.9F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.3167F, -0.792F, -4.0095F, -0.1821F, -0.4219F, 0.5208F));
      PartDefinition Head2 = Head.m_171599_("Head2", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 5.518F, -4.5102F, 0.2182F, 0.0F, 0.0F));
      Head2.m_171599_("HeadMain_r27", CubeListBuilder.m_171558_().m_171514_(110, 110).m_171488_(-2.0F, -2.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)).m_171514_(36, 8).m_171488_(-2.0F, 0.9F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).m_171514_(42, 0).m_171488_(-2.0F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.9165F, -1.7727F, 0.7854F, 0.0F, 0.0F));
      Head2.m_171599_("HeadMain_r28", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171480_().m_171488_(-0.5F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)).m_171555_(false), PartPose.m_171423_(-1.3F, 1.6077F, -3.8733F, 0.7854F, 0.3927F, 0.0F));
      Head2.m_171599_("HeadMain_r29", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171480_().m_171488_(-0.5F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)).m_171555_(false), PartPose.m_171423_(-1.3F, 1.6077F, -3.8733F, 0.5236F, 0.3927F, 0.0F));
      Head2.m_171599_("HeadMain_r30", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171488_(-0.5F, -1.3898F, -0.5776F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.29F)), PartPose.m_171423_(1.3F, 1.6077F, -3.8733F, 0.5236F, -0.3491F, 0.0F));
      Head2.m_171599_("HeadMain_r31", CubeListBuilder.m_171558_().m_171514_(124, 108).m_171488_(-0.5F, -0.6034F, -0.5259F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.19F)), PartPose.m_171423_(1.3F, 1.6077F, -3.8733F, 0.7854F, -0.3491F, 0.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.1F, 1.6423F, 7.5809F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(0, 47).m_171488_(-3.5F, -4.2F, -6.3F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-1.1F, 4.1328F, -20.6389F, -0.2618F, 0.0F, 0.0F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(0, 102).m_171488_(-5.5F, -7.5F, 3.3F, 11.0F, 10.0F, 15.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-1.1F, 6.4429F, -12.0196F, -0.0873F, 0.0F, 0.0F));
      Body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(0, 102).m_171488_(-5.5F, -7.5F, -10.0F, 11.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.1F, 6.4429F, -12.0196F, 0.0873F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(109, 30).m_171480_().m_171488_(-0.9855F, 15.0549F, -1.7261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(-4.563F, 6.7037F, -11.2139F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(112, 17).m_171480_().m_171488_(-1.5F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(0.5097F, 10.918F, 1.6757F, -0.1309F, 0.0F, 0.0F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171480_().m_171488_(-2.0F, -5.5F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.3456F, 2.6213F, 0.7905F, 0.2182F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(109, 30).m_171488_(-3.0145F, 15.0549F, -1.7261F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(4.563F, 6.7037F, -11.2139F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(112, 17).m_171488_(-2.5F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-0.5097F, 10.918F, 1.6757F, -0.1309F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171488_(-3.0F, -5.5F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.3456F, 2.6213F, 0.7905F, 0.2182F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(106, 37).m_171480_().m_171488_(-1.4819F, -2.1936F, -3.3638F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(109, 30).m_171480_().m_171488_(-0.8594F, 15.8459F, -2.415F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-4.2529F, 6.1541F, 11.3573F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(88, 0).m_171480_().m_171488_(-2.0F, -2.4F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0169F, 9.008F, 0.0726F, 0.2618F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(89, 10).m_171480_().m_171488_(-1.5F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.21F)).m_171555_(false), PartPose.m_171423_(0.6406F, 13.5459F, 0.985F, -0.0873F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(106, 37).m_171488_(-3.5181F, -2.1936F, -3.3638F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(109, 30).m_171488_(-3.1406F, 15.8459F, -2.415F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(4.2529F, 6.1541F, 11.3573F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(88, 0).m_171488_(-2.0F, -2.4F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0169F, 9.008F, 0.0726F, 0.2618F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(89, 10).m_171488_(-1.5F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.21F)), PartPose.m_171423_(-1.6406F, 13.5459F, 0.985F, -0.0873F, 0.0F, 0.0F));
      PartDefinition Tail = partdefinition.m_171599_("Tail", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.2F, 4.5F, 14.38F));
      Tail.m_171599_("Tail_r1", CubeListBuilder.m_171558_().m_171514_(106, 117).m_171488_(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.2F, 4.554F, 14.4989F, 0.3927F, 0.0F, 0.0F));
      Tail.m_171599_("Tail_r2", CubeListBuilder.m_171558_().m_171514_(106, 117).m_171488_(-1.5F, -0.5583F, -4.3243F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.2F, 4.2855F, 8.411F, -0.1745F, 0.0F, 0.0F));
      Tail.m_171599_("Tail_r3", CubeListBuilder.m_171558_().m_171514_(106, 117).m_171488_(-1.5F, 1.1727F, -10.5127F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.2F, 4.2855F, 8.411F, -0.6981F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
