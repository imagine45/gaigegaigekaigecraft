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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modeljogo_head"), "main");
   public final ModelPart head;

   public Modeljogo_head(ModelPart root) {
      this.head = root.getChild("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 21.9283F, -0.0266F));
      head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(9, 25).addBox(-1.4011F, -1.6718F, -0.4603F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0011F, -0.2363F, 0.0865F, 0.3881F, -0.7268F, -1.5513F));
      head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 13).addBox(-2.0011F, -3.1294F, -2.4908F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0011F, -0.2363F, 0.0865F, -0.0482F, -0.7268F, -1.5513F));
      head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(58, 38).addBox(-2.5011F, 0.448F, -2.6183F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.6F)).texOffs(72, 0).addBox(-3.0011F, -2.052F, -2.7183F, 6.0F, 5.0F, 3.0F, new CubeDeformation(-0.9F)).texOffs(60, 23).addBox(-1.0011F, -2.052F, -1.6183F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)).texOffs(60, 23).mirror().addBox(-3.0011F, -2.052F, -1.6183F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)).mirror(false).texOffs(60, 10).mirror().addBox(-2.9011F, -1.952F, -2.6183F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)).mirror(false).texOffs(60, 10).addBox(-1.1011F, -1.952F, -2.6183F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)).texOffs(50, 0).addBox(-3.0011F, -4.252F, -1.7183F, 6.0F, 5.0F, 5.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(0.0011F, -0.2363F, 0.0865F, 0.4754F, -0.7268F, -1.5513F));
      head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 10).addBox(-0.7747F, -1.8544F, -2.6198F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.0011F, -0.2363F, 0.0865F, 0.3713F, -0.7874F, -1.3904F));
      head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(60, 10).mirror().addBox(-3.2274F, -1.8547F, -2.6198F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.7F)).mirror(false), PartPose.offsetAndRotation(0.0011F, -0.2363F, 0.0865F, 0.5732F, -0.6547F, -1.6943F));
      head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(70, 67).addBox(-2.1011F, -1.6776F, -3.6122F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0011F, -0.2363F, 0.0865F, 0.1699F, -0.7268F, -1.5513F));
      PartDefinition bone2 = head.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1143F, -22.5179F, -2.1347F, 0.3927F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(63, 95).addBox(-0.293F, 1.2142F, -4.2137F, 4.0F, 3.0F, 4.6F, new CubeDeformation(-1.3F)), PartPose.offsetAndRotation(0.1153F, 20.6702F, -8.3224F, 0.8944F, -1.0125F, -1.1401F));
      bone2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(73, 28).addBox(-0.6722F, 1.7142F, -2.1351F, 4.0F, 3.0F, 4.6F, new CubeDeformation(-1.1F)).texOffs(73, 28).addBox(-0.6722F, 1.7142F, -4.5351F, 4.0F, 3.0F, 4.6F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(0.1153F, 20.6702F, -8.3224F, 1.2436F, -1.1193F, -1.5374F));
      bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 39).addBox(0.854F, 2.7142F, -3.7425F, 2.0F, 1.0F, 2.6F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.1153F, 20.6702F, -8.3224F, 0.8427F, -0.9843F, -1.0786F));
      bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(63, 39).addBox(0.0012F, 3.2023F, -2.1282F, 2.0F, 1.0F, 3.6F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.1153F, 20.6702F, -8.3224F, 1.0691F, -1.1193F, -1.5374F));
      PartDefinition bone30 = bone2.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1143F, -0.2432F, -1.2062F, 0.6109F, 0.0F, 0.0F));
      bone30.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 25).addBox(-0.8722F, 1.3588F, -4.7424F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)), PartPose.offsetAndRotation(0.0011F, 13.0496F, -17.8246F, -1.8212F, -1.4105F, 1.4793F));
      PartDefinition bone = bone30.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-0.2722F, 1.3588F, -5.0424F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).mirror(false).texOffs(0, 25).mirror().addBox(0.5278F, 1.3588F, -4.0424F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).mirror(false), PartPose.offsetAndRotation(0.0011F, 13.0496F, -17.8246F, -1.8212F, -1.4105F, 1.4793F));
      PartDefinition bone24 = bone2.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offset(-1.2857F, -0.7432F, -1.8462F));
      bone24.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(48, 38).mirror().addBox(-3.1663F, 3.0922F, -2.1131F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.4011F, 21.4134F, -6.4762F, 1.6181F, -0.3587F, -2.5266F));
      bone24.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 38).addBox(1.601F, 1.1261F, -1.0507F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.4011F, 21.4134F, -6.4762F, -0.5313F, -0.6703F, 0.0883F));
      bone24.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(50, 10).addBox(1.0596F, -0.1502F, -2.6454F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.4011F, 21.4134F, -6.4762F, -1.2697F, -0.6162F, 1.1353F));
      PartDefinition bone29 = bone2.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offset(1.5143F, -0.7432F, -1.8462F));
      bone29.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(51, 11).mirror().addBox(-3.0439F, 3.436F, -0.8429F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-1.3989F, 21.4134F, -6.4762F, 0.7596F, 0.1283F, -1.9183F));
      bone29.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(50, 10).mirror().addBox(-3.0439F, 2.4823F, -2.901F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-1.3989F, 21.4134F, -6.4762F, 1.5013F, 0.1283F, -1.9183F));
      PartDefinition bone48 = head.addOrReplaceChild("bone48", CubeListBuilder.create(), PartPose.offset(0.0F, -1.1683F, -2.0318F));
      PartDefinition bone49 = bone48.addOrReplaceChild("bone49", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone49.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(100, 78).mirror().addBox(0.3789F, 0.368F, -0.3383F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(103, 14).mirror().addBox(-0.1211F, -0.132F, -0.8383F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0011F, 0.932F, 2.1183F, 0.4754F, -0.7268F, -1.5513F));
      PartDefinition bone32 = head.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offset(0.0F, -1.1683F, -2.0318F));
      PartDefinition bone33 = bone32.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone33.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(100, 78).addBox(-3.3811F, 0.368F, -0.3383F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(103, 14).addBox(-2.8811F, -0.132F, -0.8383F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0011F, 0.932F, 2.1183F, 0.4754F, -0.7268F, -1.5513F));
      PartDefinition bone27 = head.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offset(0.0F, -25.8283F, -5.0318F));
      PartDefinition bone22 = bone27.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.2F, 0.0F, -0.1309F, 0.0F, 0.0F));
      bone22.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(70, 53).addBox(-0.7722F, -1.1012F, -2.2564F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0011F, 25.1643F, 6.4582F, 0.2166F, -0.5959F, -1.5532F));
      PartDefinition bone25 = bone22.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(0.0F, -0.2F, -0.4F));
      bone25.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 74).mirror().addBox(1.028F, -0.9425F, -2.4836F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(0.0011F, 25.3643F, 6.8582F, 0.2993F, -0.7637F, -1.6151F));
      bone25.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 74).addBox(-2.4401F, -0.7543F, -2.0225F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0011F, 25.3643F, 6.8582F, 0.4263F, -0.2368F, -2.0714F));
      bone25.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 74).addBox(-1.5127F, -1.0425F, -2.0225F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.0011F, 25.3643F, 6.8582F, 0.2362F, -0.4267F, -1.5041F));
      PartDefinition bone31 = bone27.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.3F, 1.3F, -0.3927F, 0.0F, 0.0F));
      bone31.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 25).addBox(-0.0722F, 1.6839F, -2.2526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).texOffs(0, 25).addBox(-0.8722F, 1.5839F, -2.2526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).texOffs(0, 25).mirror().addBox(0.4278F, 1.5839F, -1.9526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).mirror(false).texOffs(0, 25).mirror().addBox(0.9278F, 1.4839F, -1.3526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)).mirror(false).texOffs(0, 25).addBox(-1.2722F, 1.4839F, -1.6526F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.31F)), PartPose.offsetAndRotation(0.0011F, 19.8993F, 10.2107F, 0.3524F, -0.3341F, -1.5554F));
      PartDefinition bone26 = head.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -23.4283F, -3.4318F, -0.1745F, 0.0F, 0.0F));
      bone26.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(73, 36).mirror().addBox(-1.1033F, 1.6964F, -2.3481F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)).mirror(false), PartPose.offsetAndRotation(0.0011F, 22.576F, 5.5225F, 0.6398F, -0.385F, -2.2317F));
      bone26.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(73, 36).mirror().addBox(-0.5401F, 1.3286F, -2.1481F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(31, 14).mirror().addBox(1.0599F, 1.3286F, -1.9481F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false), PartPose.offsetAndRotation(0.0011F, 22.576F, 5.5225F, 0.4319F, -0.6117F, -1.8047F));
      bone26.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(31, 14).addBox(-1.467F, 0.8675F, -1.6067F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0011F, 22.576F, 5.5225F, 0.1807F, -0.467F, -1.3239F));
      bone26.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(73, 36).addBox(-1.5553F, 1.104F, -2.2606F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0011F, 22.576F, 5.5225F, 0.3411F, -0.7078F, -1.6691F));
      PartDefinition bone23 = head.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -23.9283F, -3.9318F, 0.1745F, 0.0F, 0.0F));
      bone23.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(15, 46).addBox(-1.2722F, -0.0179F, -1.6249F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).texOffs(15, 46).mirror().addBox(0.9278F, -0.0179F, -1.6249F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).mirror(false).texOffs(65, 83).addBox(0.0278F, -0.5179F, -2.7404F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.35F)).texOffs(73, 8).addBox(-1.1722F, 0.5821F, -2.4149F, 5.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)).texOffs(107, 23).addBox(-1.1722F, -0.9179F, -2.5149F, 5.0F, 3.0F, 4.0F, new CubeDeformation(-1.2F)).texOffs(73, 19).addBox(-1.1722F, -0.2179F, -2.4149F, 5.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(0.0011F, 23.6826F, -2.1264F, 0.6444F, -0.9013F, -1.5473F));
      PartDefinition bone5 = head.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, -27.7F, -1.1F));
      PartDefinition bone47 = bone5.addOrReplaceChild("bone47", CubeListBuilder.create(), PartPose.offset(0.0F, -1.4F, 0.0F));
      bone47.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(50, 57).addBox(-2.2011F, -3.8226F, -2.1742F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)).texOffs(50, 57).mirror().addBox(1.1989F, -3.8226F, -2.1742F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(59, 33).addBox(-1.5011F, -3.9226F, 1.0258F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(59, 33).addBox(-1.5011F, -3.9226F, -2.4742F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0011F, 28.8637F, 1.1865F, 0.2136F, -0.7268F, -1.5513F));
      PartDefinition bone4 = bone5.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(2.5099F, 0.5064F, -0.1871F));
      PartDefinition bone12 = bone4.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.551F, -1.6153F, 0.3001F, 0.1177F, 0.0443F, 0.0539F));
      bone12.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(98, 75).mirror().addBox(-3.4084F, -2.7173F, -2.5851F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).mirror(false).texOffs(98, 75).mirror().addBox(-2.0594F, -2.9099F, -2.6077F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).mirror(false).texOffs(98, 75).mirror().addBox(-4.5146F, -2.7678F, -2.5867F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).mirror(false), PartPose.offsetAndRotation(2.6186F, 28.1828F, -4.1483F, 0.181F, 0.6564F, -1.1166F));
      bone12.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(80, 112).mirror().addBox(-2.0629F, -3.8779F, -2.5023F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(80, 112).mirror().addBox(-3.4119F, -3.6853F, -2.4798F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(80, 112).mirror().addBox(-4.5182F, -3.7358F, -2.4813F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).mirror(false), PartPose.offsetAndRotation(2.6186F, 28.1828F, -4.1483F, 0.181F, 0.6564F, -1.1166F));
      PartDefinition bone11 = bone4.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4689F, -1.6153F, 1.0E-4F, 0.1177F, -0.0443F, -0.0539F));
      bone11.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(98, 75).addBox(0.1065F, -2.2382F, -5.197F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).texOffs(98, 75).addBox(-1.1935F, -2.2382F, -5.197F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)).texOffs(98, 75).addBox(1.4065F, -2.3382F, -5.197F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-2.6032F, 28.2181F, -3.8508F, 2.7431F, -0.6985F, 2.0483F));
      bone11.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(80, 112).addBox(-1.1899F, -3.2062F, -5.0917F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).texOffs(80, 112).addBox(0.1101F, -3.2062F, -5.0917F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)).texOffs(80, 112).addBox(1.4101F, -3.3062F, -5.0917F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-2.6032F, 28.2181F, -3.8508F, 2.7431F, -0.6985F, 2.0483F));
      PartDefinition bone14 = bone4.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(-3.551F, -0.3153F, 1.0E-4F));
      PartDefinition bone13 = bone14.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(1.0411F, -0.1929F, 2.0429F));
      bone13.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(80, 112).addBox(-2.6811F, -3.6995F, -3.9307F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0011F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone28 = bone13.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone28.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(98, 75).addBox(-2.6811F, -2.6995F, -3.9307F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(0.0011F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone34 = bone14.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offset(2.2411F, -0.1929F, 2.0429F));
      bone34.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(80, 112).addBox(-1.4811F, -3.6995F, -3.9307F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-1.1989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone37 = bone34.addOrReplaceChild("bone37", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone37.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(98, 75).addBox(-1.4811F, -2.6995F, -3.9307F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-1.1989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone38 = bone14.addOrReplaceChild("bone38", CubeListBuilder.create(), PartPose.offset(3.4411F, -0.1929F, 2.0429F));
      bone38.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(80, 112).addBox(-0.2811F, -3.6995F, -3.9307F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-2.3989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone39 = bone38.addOrReplaceChild("bone39", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone39.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(98, 75).addBox(-0.2811F, -2.6995F, -3.9307F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-2.3989F, 27.4655F, -0.6693F, -0.0046F, -0.7268F, -1.5513F));
      PartDefinition bone40 = bone4.addOrReplaceChild("bone40", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.551F, -0.2153F, -0.0727F, -0.48F, 0.0F, 0.0F));
      PartDefinition bone41 = bone40.addOrReplaceChild("bone41", CubeListBuilder.create(), PartPose.offset(1.0411F, -0.1929F, -2.0429F));
      bone41.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(80, 112).addBox(-1.3522F, -3.0829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0011F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone42 = bone41.addOrReplaceChild("bone42", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone42.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(98, 75).addBox(-1.3522F, -1.8829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(0.0011F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone43 = bone40.addOrReplaceChild("bone43", CubeListBuilder.create(), PartPose.offset(2.1411F, -0.1929F, -2.0429F));
      bone43.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(80, 112).addBox(-0.2522F, -3.0829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-1.0989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone44 = bone43.addOrReplaceChild("bone44", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone44.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(98, 75).addBox(-0.2522F, -1.8829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-1.0989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone45 = bone40.addOrReplaceChild("bone45", CubeListBuilder.create(), PartPose.offset(3.4411F, -0.1929F, -2.0429F));
      bone45.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(80, 112).addBox(1.0478F, -3.0829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-2.3989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      PartDefinition bone46 = bone45.addOrReplaceChild("bone46", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone46.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(98, 75).addBox(1.0478F, -1.8829F, 2.3196F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-2.3989F, 24.5509F, 14.0987F, 0.4847F, -0.2469F, -1.5558F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
   }
}
