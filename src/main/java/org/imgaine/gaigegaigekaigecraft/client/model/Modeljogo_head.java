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

public class Modeljogo_head<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modeljogo_head"), "main");
   public final ModelPart head;

   public Modeljogo_head(ModelPart root) {
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 21.9283F, -0.0266F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(9, 25).m_171488_(-1.4011F, -1.6718F, -0.4603F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0011F, -0.2363F, 0.0865F, 0.3881F, -0.7268F, -1.5513F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(17, 13).m_171488_(-2.0011F, -3.1294F, -2.4908F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0011F, -0.2363F, 0.0865F, -0.0482F, -0.7268F, -1.5513F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(58, 38).m_171488_(-2.5011F, 0.448F, -2.6183F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.6F)).m_171514_(72, 0).m_171488_(-3.0011F, -2.052F, -2.7183F, 6.0F, 5.0F, 3.0F, new CubeDeformation(-0.9F)).m_171514_(60, 23).m_171488_(-1.0011F, -2.052F, -1.6183F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)).m_171514_(60, 23).m_171480_().m_171488_(-3.0011F, -2.052F, -1.6183F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)).m_171555_(false).m_171514_(60, 10).m_171480_().m_171488_(-2.9011F, -1.952F, -2.6183F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)).m_171555_(false).m_171514_(60, 10).m_171488_(-1.1011F, -1.952F, -2.6183F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)).m_171514_(50, 0).m_171488_(-3.0011F, -4.252F, -1.7183F, 6.0F, 5.0F, 5.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(0.0011F, -0.2363F, 0.0865F, 0.4754F, -0.7268F, -1.5513F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(60, 10).m_171488_(-0.7747F, -1.8544F, -2.6198F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)), PartPose.m_171423_(0.0011F, -0.2363F, 0.0865F, 0.3713F, -0.7874F, -1.3904F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(60, 10).m_171480_().m_171488_(-3.2274F, -1.8547F, -2.6198F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)).m_171555_(false), PartPose.m_171423_(0.0011F, -0.2363F, 0.0865F, 0.5732F, -0.6547F, -1.6943F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(70, 67).m_171488_(-2.1011F, -1.6776F, -3.6122F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0011F, -0.2363F, 0.0865F, 0.1699F, -0.7268F, -1.5513F));
      PartDefinition bone2 = head.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171423_(-0.1143F, -22.5179F, -2.1347F, 0.3927F, 0.0F, 0.0F));
      bone2.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(63, 95).m_171488_(-0.293F, 1.2142F, -4.2137F, 4.0F, 3.0F, 4.6F, new CubeDeformation(-1.3F)), PartPose.m_171423_(0.1153F, 20.6702F, -8.3224F, 0.8944F, -1.0125F, -1.1401F));
      bone2.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(73, 28).m_171488_(-0.6722F, 1.7142F, -2.1351F, 4.0F, 3.0F, 4.6F, new CubeDeformation(-1.1F)).m_171514_(73, 28).m_171488_(-0.6722F, 1.7142F, -4.5351F, 4.0F, 3.0F, 4.6F, new CubeDeformation(-1.1F)), PartPose.m_171423_(0.1153F, 20.6702F, -8.3224F, 1.2436F, -1.1193F, -1.5374F));
      bone2.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(64, 39).m_171488_(0.854F, 2.7142F, -3.7425F, 2.0F, 1.0F, 2.6F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.1153F, 20.6702F, -8.3224F, 0.8427F, -0.9843F, -1.0786F));
      bone2.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(63, 39).m_171488_(0.0012F, 3.2023F, -2.1282F, 2.0F, 1.0F, 3.6F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.1153F, 20.6702F, -8.3224F, 1.0691F, -1.1193F, -1.5374F));
      PartDefinition bone30 = bone2.m_171599_("bone30", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.1143F, -0.2432F, -1.2062F, 0.6109F, 0.0F, 0.0F));
      bone30.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171488_(-0.8722F, 1.3588F, -4.7424F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)), PartPose.m_171423_(0.0011F, 13.0496F, -17.8246F, -1.8212F, -1.4105F, 1.4793F));
      PartDefinition bone = bone30.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171480_().m_171488_(-0.2722F, 1.3588F, -5.0424F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).m_171555_(false).m_171514_(0, 25).m_171480_().m_171488_(0.5278F, 1.3588F, -4.0424F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).m_171555_(false), PartPose.m_171423_(0.0011F, 13.0496F, -17.8246F, -1.8212F, -1.4105F, 1.4793F));
      PartDefinition bone24 = bone2.m_171599_("bone24", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.2857F, -0.7432F, -1.8462F));
      bone24.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(48, 38).m_171480_().m_171488_(-3.1663F, 3.0922F, -2.1131F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(1.4011F, 21.4134F, -6.4762F, 1.6181F, -0.3587F, -2.5266F));
      bone24.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(48, 38).m_171488_(1.601F, 1.1261F, -1.0507F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(1.4011F, 21.4134F, -6.4762F, -0.5313F, -0.6703F, 0.0883F));
      bone24.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(50, 10).m_171488_(1.0596F, -0.1502F, -2.6454F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(1.4011F, 21.4134F, -6.4762F, -1.2697F, -0.6162F, 1.1353F));
      PartDefinition bone29 = bone2.m_171599_("bone29", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.5143F, -0.7432F, -1.8462F));
      bone29.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(51, 11).m_171480_().m_171488_(-3.0439F, 3.436F, -0.8429F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-1.3989F, 21.4134F, -6.4762F, 0.7596F, 0.1283F, -1.9183F));
      bone29.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(50, 10).m_171480_().m_171488_(-3.0439F, 2.4823F, -2.901F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-1.3989F, 21.4134F, -6.4762F, 1.5013F, 0.1283F, -1.9183F));
      PartDefinition bone48 = head.m_171599_("bone48", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -1.1683F, -2.0318F));
      PartDefinition bone49 = bone48.m_171599_("bone49", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone49.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(100, 78).m_171480_().m_171488_(0.3789F, 0.368F, -0.3383F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(103, 14).m_171480_().m_171488_(-0.1211F, -0.132F, -0.8383F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0011F, 0.932F, 2.1183F, 0.4754F, -0.7268F, -1.5513F));
      PartDefinition bone32 = head.m_171599_("bone32", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -1.1683F, -2.0318F));
      PartDefinition bone33 = bone32.m_171599_("bone33", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone33.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(100, 78).m_171488_(-3.3811F, 0.368F, -0.3383F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(103, 14).m_171488_(-2.8811F, -0.132F, -0.8383F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0011F, 0.932F, 2.1183F, 0.4754F, -0.7268F, -1.5513F));
      PartDefinition bone27 = head.m_171599_("bone27", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -25.8283F, -5.0318F));
      PartDefinition bone22 = bone27.m_171599_("bone22", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -0.2F, 0.0F, -0.1309F, 0.0F, 0.0F));
      bone22.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(70, 53).m_171488_(-0.7722F, -1.1012F, -2.2564F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0011F, 25.1643F, 6.4582F, 0.2166F, -0.5959F, -1.5532F));
      PartDefinition bone25 = bone22.m_171599_("bone25", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -0.2F, -0.4F));
      bone25.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 74).m_171480_().m_171488_(1.028F, -0.9425F, -2.4836F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).m_171555_(false), PartPose.m_171423_(0.0011F, 25.3643F, 6.8582F, 0.2993F, -0.7637F, -1.6151F));
      bone25.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 74).m_171488_(-2.4401F, -0.7543F, -2.0225F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0011F, 25.3643F, 6.8582F, 0.4263F, -0.2368F, -2.0714F));
      bone25.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 74).m_171488_(-1.5127F, -1.0425F, -2.0225F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.m_171423_(0.0011F, 25.3643F, 6.8582F, 0.2362F, -0.4267F, -1.5041F));
      PartDefinition bone31 = bone27.m_171599_("bone31", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 3.3F, 1.3F, -0.3927F, 0.0F, 0.0F));
      bone31.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171488_(-0.0722F, 1.6839F, -2.2526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).m_171514_(0, 25).m_171488_(-0.8722F, 1.5839F, -2.2526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).m_171514_(0, 25).m_171480_().m_171488_(0.4278F, 1.5839F, -1.9526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).m_171555_(false).m_171514_(0, 25).m_171480_().m_171488_(0.9278F, 1.4839F, -1.3526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).m_171555_(false).m_171514_(0, 25).m_171488_(-1.2722F, 1.4839F, -1.6526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)), PartPose.m_171423_(0.0011F, 19.8993F, 10.2107F, 0.3524F, -0.3341F, -1.5554F));
      PartDefinition bone26 = head.m_171599_("bone26", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -23.4283F, -3.4318F, -0.1745F, 0.0F, 0.0F));
      bone26.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(73, 36).m_171480_().m_171488_(-1.1033F, 1.6964F, -2.3481F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)).m_171555_(false), PartPose.m_171423_(0.0011F, 22.576F, 5.5225F, 0.6398F, -0.385F, -2.2317F));
      bone26.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(73, 36).m_171480_().m_171488_(-0.5401F, 1.3286F, -2.1481F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.2F)).m_171555_(false).m_171514_(31, 14).m_171480_().m_171488_(1.0599F, 1.3286F, -1.9481F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false), PartPose.m_171423_(0.0011F, 22.576F, 5.5225F, 0.4319F, -0.6117F, -1.8047F));
      bone26.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(31, 14).m_171488_(-1.467F, 0.8675F, -1.6067F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0011F, 22.576F, 5.5225F, 0.1807F, -0.467F, -1.3239F));
      bone26.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(73, 36).m_171488_(-1.5553F, 1.104F, -2.2606F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0011F, 22.576F, 5.5225F, 0.3411F, -0.7078F, -1.6691F));
      PartDefinition bone23 = head.m_171599_("bone23", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -23.9283F, -3.9318F, 0.1745F, 0.0F, 0.0F));
      bone23.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(15, 46).m_171488_(-1.2722F, -0.0179F, -1.6249F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171514_(15, 46).m_171480_().m_171488_(0.9278F, -0.0179F, -1.6249F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false).m_171514_(65, 83).m_171488_(0.0278F, -0.5179F, -2.7404F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.35F)).m_171514_(73, 8).m_171488_(-1.1722F, 0.5821F, -2.4149F, 5.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)).m_171514_(107, 23).m_171488_(-1.1722F, -0.9179F, -2.5149F, 5.0F, 3.0F, 4.0F, new CubeDeformation(-1.2F)).m_171514_(73, 19).m_171488_(-1.1722F, -0.2179F, -2.4149F, 5.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(0.0011F, 23.6826F, -2.1264F, 0.6444F, -0.9013F, -1.5473F));
      PartDefinition bone5 = head.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -27.7F, -1.1F));
      PartDefinition bone47 = bone5.m_171599_("bone47", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -1.4F, 0.0F));
      bone47.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(50, 57).m_171488_(-2.2011F, -3.8226F, -2.1742F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)).m_171514_(50, 57).m_171480_().m_171488_(1.1989F, -3.8226F, -2.1742F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(59, 33).m_171488_(-1.5011F, -3.9226F, 1.0258F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(59, 33).m_171488_(-1.5011F, -3.9226F, -2.4742F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0011F, 28.8637F, 1.1865F, 0.2136F, -0.7268F, -1.5513F));
      PartDefinition bone4 = bone5.m_171599_("bone4", CubeListBuilder.m_171558_(), PartPose.m_171419_(2.5099F, 0.5064F, -0.1871F));
      PartDefinition bone12 = bone4.m_171599_("bone12", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.551F, -1.6153F, 0.3001F, 0.1177F, 0.0443F, 0.0539F));
      bone12.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171480_().m_171488_(-3.4084F, -2.7173F, -2.5851F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).m_171555_(false).m_171514_(98, 75).m_171480_().m_171488_(-2.0594F, -2.9099F, -2.6077F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).m_171555_(false).m_171514_(98, 75).m_171480_().m_171488_(-4.5146F, -2.7678F, -2.5867F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).m_171555_(false), PartPose.m_171423_(2.6186F, 28.1828F, -4.1483F, 0.181F, 0.6564F, -1.1166F));
      bone12.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171480_().m_171488_(-2.0629F, -3.8779F, -2.5023F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false).m_171514_(80, 112).m_171480_().m_171488_(-3.4119F, -3.6853F, -2.4798F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false).m_171514_(80, 112).m_171480_().m_171488_(-4.5182F, -3.7358F, -2.4813F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false), PartPose.m_171423_(2.6186F, 28.1828F, -4.1483F, 0.181F, 0.6564F, -1.1166F));
      PartDefinition bone11 = bone4.m_171599_("bone11", CubeListBuilder.m_171558_(), PartPose.m_171423_(-1.4689F, -1.6153F, 1.0E-4F, 0.1177F, -0.0443F, -0.0539F));
      bone11.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(0.1065F, -2.2382F, -5.197F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).m_171514_(98, 75).m_171488_(-1.1935F, -2.2382F, -5.197F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).m_171514_(98, 75).m_171488_(1.4065F, -2.3382F, -5.197F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(-2.6032F, 28.2181F, -3.8508F, 2.7431F, -0.6985F, 2.0483F));
      bone11.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(-1.1899F, -3.2062F, -5.0917F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).m_171514_(80, 112).m_171488_(0.1101F, -3.2062F, -5.0917F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).m_171514_(80, 112).m_171488_(1.4101F, -3.3062F, -5.0917F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-2.6032F, 28.2181F, -3.8508F, 2.7431F, -0.6985F, 2.0483F));
      PartDefinition bone14 = bone4.m_171599_("bone14", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.551F, -0.3153F, 1.0E-4F));
      PartDefinition bone13 = bone14.m_171599_("bone13", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.0411F, -0.1929F, 2.0429F));
      bone13.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(-2.6811F, -3.6995F, -3.9307F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0011F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone28 = bone13.m_171599_("bone28", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone28.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(-2.6811F, -2.6995F, -3.9307F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(0.0011F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone34 = bone14.m_171599_("bone34", CubeListBuilder.m_171558_(), PartPose.m_171419_(2.2411F, -0.1929F, 2.0429F));
      bone34.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(-1.4811F, -3.6995F, -3.9307F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-1.1989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone37 = bone34.m_171599_("bone37", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone37.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(-1.4811F, -2.6995F, -3.9307F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(-1.1989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone38 = bone14.m_171599_("bone38", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.4411F, -0.1929F, 2.0429F));
      bone38.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(-0.2811F, -3.6995F, -3.9307F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-2.3989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone39 = bone38.m_171599_("bone39", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone39.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(-0.2811F, -2.6995F, -3.9307F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(-2.3989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone40 = bone4.m_171599_("bone40", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.551F, -0.2153F, -0.0727F, -0.48F, 0.0F, 0.0F));
      PartDefinition bone41 = bone40.m_171599_("bone41", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.0411F, -0.1929F, -2.0429F));
      bone41.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(-1.3522F, -3.0829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0011F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone42 = bone41.m_171599_("bone42", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone42.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(-1.3522F, -1.8829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(0.0011F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone43 = bone40.m_171599_("bone43", CubeListBuilder.m_171558_(), PartPose.m_171419_(2.1411F, -0.1929F, -2.0429F));
      bone43.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(-0.2522F, -3.0829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-1.0989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone44 = bone43.m_171599_("bone44", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone44.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(-0.2522F, -1.8829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(-1.0989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone45 = bone40.m_171599_("bone45", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.4411F, -0.1929F, -2.0429F));
      bone45.m_171599_("cube_r45", CubeListBuilder.m_171558_().m_171514_(80, 112).m_171488_(1.0478F, -3.0829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-2.3989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone46 = bone45.m_171599_("bone46", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone46.m_171599_("cube_r46", CubeListBuilder.m_171558_().m_171514_(98, 75).m_171488_(1.0478F, -1.8829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.m_171423_(-2.3989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
   }
}
