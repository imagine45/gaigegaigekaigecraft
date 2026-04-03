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

public class Modelnaoya_cursed_spirit1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelnaoya_cursed_spirit_1"), "main");
   public final ModelPart Body3;
   public final ModelPart Body2;
   public final ModelPart LeftArm3;
   public final ModelPart LeftArm2;
   public final ModelPart LeftArm;
   public final ModelPart RightArm3;
   public final ModelPart RightArm2;
   public final ModelPart RightArm;
   public final ModelPart Head;

   public Modelnaoya_cursed_spirit1(ModelPart root) {
      this.Body3 = root.getChild("Body3");
      this.Body2 = root.getChild("Body2");
      this.LeftArm3 = root.getChild("LeftArm3");
      this.LeftArm2 = root.getChild("LeftArm2");
      this.LeftArm = root.getChild("LeftArm");
      this.RightArm3 = root.getChild("RightArm3");
      this.RightArm2 = root.getChild("RightArm2");
      this.RightArm = root.getChild("RightArm");
      this.Head = root.getChild("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Body3 = partdefinition.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offset(0.0F, -5.6206F, 12.0432F));
      Body3.addOrReplaceChild("Body3_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -7.8401F, -31.6886F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.8F)), PartPose.offsetAndRotation(0.0F, 3.5272F, -2.6832F, -3.0543F, 0.0F, 0.0F));
      Body3.addOrReplaceChild("Body3_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -8.1262F, -0.6515F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-1.8F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.5272F, -2.6832F, -0.1745F, 0.0F, 0.0F));
      Body3.addOrReplaceChild("Body3_r3", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -0.3786F, -3.7733F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.75F)), PartPose.offsetAndRotation(0.0F, 3.5272F, -2.6832F, 0.4363F, 0.0F, -3.1416F));
      PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 23.0F));
      Body4.addOrReplaceChild("Body4_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -9.5722F, -54.4874F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.2F)), PartPose.offsetAndRotation(0.0F, 3.5272F, -25.6832F, 3.0543F, 0.0F, 0.0F));
      Body4.addOrReplaceChild("Body4_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -12.3538F, 21.8188F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.5272F, -25.6832F, -0.3491F, 0.0F, 0.0F));
      Body4.addOrReplaceChild("Body4_r3", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, 9.5208F, 16.8371F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.15F)), PartPose.offsetAndRotation(0.0F, 3.5272F, -25.6832F, 0.6109F, 0.0F, -3.1416F));
      PartDefinition Body5 = Body4.addOrReplaceChild("Body5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 23.0F));
      Body5.addOrReplaceChild("Body5_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -8.4018F, -31.9124F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.1F)), PartPose.offsetAndRotation(0.0F, 14.5272F, -4.6832F, -3.098F, 0.0F, 0.0F));
      Body5.addOrReplaceChild("Body5_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -7.6416F, -0.2899F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 14.5272F, -4.6832F, -0.2182F, 0.0F, 0.0F));
      Body5.addOrReplaceChild("Body5_r3", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -0.7531F, -3.2986F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.95F)), PartPose.offsetAndRotation(0.0F, 14.5272F, -4.6832F, 0.48F, 0.0F, -3.1416F));
      PartDefinition Body6 = Body5.addOrReplaceChild("Body6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 24.0F));
      Body6.addOrReplaceChild("Body6_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -9.5749F, -23.3553F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.5F)), PartPose.offsetAndRotation(0.0F, 17.5272F, 0.3168F, -2.9234F, 0.0F, 0.0F));
      Body6.addOrReplaceChild("Body6_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -4.2937F, -8.2518F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.5F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.5272F, 0.3168F, -0.0436F, 0.0F, 0.0F));
      Body6.addOrReplaceChild("Body6_r3", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -6.0475F, -10.1227F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.35F)), PartPose.offsetAndRotation(0.0F, 17.5272F, 0.3168F, 0.3054F, 0.0F, -3.1416F));
      PartDefinition Body7 = Body6.addOrReplaceChild("Body7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 19.0F));
      Body7.addOrReplaceChild("Body7_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -7.15F, -22.852F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)), PartPose.offsetAndRotation(0.0F, 20.5272F, -0.6832F, -2.8362F, 0.0F, 0.0F));
      Body7.addOrReplaceChild("Body7_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-15.0F, -6.5057F, -9.3655F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-4.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.5272F, -0.6832F, 0.0436F, 0.0F, 0.0F));
      Body7.addOrReplaceChild("Body7_r3", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -4.1992F, -11.771F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-3.95F)), PartPose.offsetAndRotation(0.0F, 20.5272F, -0.6832F, 0.2182F, 0.0F, -3.1416F));
      PartDefinition Body2 = partdefinition.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.375F, -4.5F, -1.25F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-1.4F)).mirror(false), PartPose.offset(-0.625F, -5.25F, -13.7729F));
      Body2.addOrReplaceChild("Body2_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.35F)), PartPose.offsetAndRotation(0.625F, -3.797F, 8.8722F, 0.2618F, 0.0F, -3.1416F));
      Body2.addOrReplaceChild("Body2_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(1.0F, -3.75F, 18.5846F, -2.8798F, 0.0F, 0.0F));
      PartDefinition LeftArm3 = partdefinition.addOrReplaceChild("LeftArm3", CubeListBuilder.create(), PartPose.offset(7.0F, 9.8556F, 9.8729F));
      LeftArm3.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(133, 52).addBox(-1.2217F, -3.5427F, -3.2219F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(22.4883F, 14.1718F, -1.3733F, -1.8033F, 0.1353F, 0.6054F));
      LeftArm3.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(133, 52).addBox(-0.6416F, -3.4404F, -2.1709F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.4883F, 14.1718F, -1.3733F, -1.2233F, 0.5067F, 0.4383F));
      LeftArm3.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(133, 52).addBox(-0.2458F, -1.4331F, -2.1402F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.4883F, 14.1718F, -1.3733F, -1.2198F, 0.6506F, 0.3866F));
      LeftArm3.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(133, 52).addBox(-0.635F, 0.5856F, -2.1572F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.4883F, 14.1718F, -1.3733F, -1.0159F, 0.7647F, 0.6368F));
      LeftArm3.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(133, 52).addBox(-2.0156F, 2.4193F, -2.0611F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(22.4883F, 14.1718F, -1.3733F, -0.6133F, 1.0965F, 0.5826F));
      LeftArm3.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(131, 50).addBox(-3.9967F, -3.8575F, -2.4226F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.4883F, 14.1718F, -1.3733F, -1.4158F, 0.6492F, 0.0623F));
      LeftArm3.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(130, 49).addBox(-8.1594F, -5.9151F, 0.1063F, 16.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(14.762F, 7.8055F, -0.4659F, -1.1788F, 0.2782F, 0.724F));
      LeftArm3.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(129, 48).addBox(-20.6429F, -10.9391F, -3.4203F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.762F, 8.8055F, -2.4659F, -1.7148F, -0.4436F, 0.6424F));
      PartDefinition LeftArm2 = partdefinition.addOrReplaceChild("LeftArm2", CubeListBuilder.create(), PartPose.offset(8.0F, 9.8556F, -2.6271F));
      LeftArm2.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(133, 52).addBox(-1.3706F, -3.4679F, -3.1082F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(19.3228F, 12.7456F, -6.6508F, -1.6893F, 0.193F, 0.8332F));
      LeftArm2.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(133, 52).addBox(-0.7628F, -3.3424F, -2.1911F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3228F, 12.7456F, -6.6508F, -1.0908F, 0.5824F, 0.7156F));
      LeftArm2.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(133, 52).addBox(-0.3622F, -1.387F, -2.1903F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3228F, 12.7456F, -6.6508F, -1.0651F, 0.7336F, 0.6933F));
      LeftArm2.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().texOffs(133, 52).addBox(-0.8342F, 0.3689F, -2.1538F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3228F, 12.7456F, -6.6508F, -0.7678F, 0.8192F, 1.0152F));
      LeftArm2.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(133, 52).addBox(-2.4766F, 2.0817F, -1.7171F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(19.3228F, 12.7456F, -6.6508F, -0.1037F, 1.1567F, 1.2323F));
      LeftArm2.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(131, 50).addBox(-4.1005F, -3.5791F, -2.3746F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3228F, 12.7456F, -6.6508F, -1.3484F, 0.7463F, 0.3149F));
      LeftArm2.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(130, 49).addBox(-15.2965F, -3.3362F, -2.4377F, 16.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(17.2525F, 11.1356F, -3.8839F, -1.3484F, 0.7463F, 0.664F));
      LeftArm2.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(129, 48).addBox(-16.3218F, -9.7498F, -10.0062F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.3F, 10.6202F, -3.9823F, -1.7821F, -0.3247F, 0.5839F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(6.0928F, 8.9524F, -10.4774F));
      LeftArm.addOrReplaceChild("LeftArm_r17", CubeListBuilder.create().texOffs(133, 52).addBox(-1.4513F, -2.9647F, -2.7993F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(14.0703F, 13.411F, -17.9441F, -0.6752F, 0.6652F, 1.2154F));
      LeftArm.addOrReplaceChild("LeftArm_r18", CubeListBuilder.create().texOffs(133, 52).addBox(-0.6571F, -2.7581F, -2.2424F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0703F, 13.411F, -17.9441F, 0.3004F, 0.9129F, 1.6753F));
      LeftArm.addOrReplaceChild("LeftArm_r19", CubeListBuilder.create().texOffs(133, 52).addBox(-0.1798F, -0.823F, -2.2517F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0703F, 13.411F, -17.9441F, 0.5399F, 0.9417F, 1.9249F));
      LeftArm.addOrReplaceChild("LeftArm_r20", CubeListBuilder.create().texOffs(133, 52).addBox(-0.5528F, 0.8779F, -2.2834F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0703F, 13.411F, -17.9441F, 0.7105F, 0.7146F, 2.0597F));
      LeftArm.addOrReplaceChild("LeftArm_r21", CubeListBuilder.create().texOffs(133, 52).addBox(-2.0379F, 2.4068F, -1.9558F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(14.0703F, 13.411F, -17.9441F, 1.4601F, 0.6095F, 2.4936F));
      LeftArm.addOrReplaceChild("LeftArm_r22", CubeListBuilder.create().texOffs(131, 50).addBox(-3.9598F, -3.0F, -2.3777F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0703F, 13.411F, -17.9441F, 0.657F, 1.2106F, 2.0866F));
      LeftArm.addOrReplaceChild("LeftArm_r23", CubeListBuilder.create().texOffs(130, 49).addBox(-11.7681F, -5.5539F, -2.5768F, 16.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(11.7853F, 9.7568F, -11.9908F, 0.2111F, 0.7574F, 1.5449F));
      LeftArm.addOrReplaceChild("LeftArm_r24", CubeListBuilder.create().texOffs(129, 48).addBox(-16.9809F, -8.077F, -11.6116F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2853F, 7.1587F, -11.9908F, -1.9168F, 0.366F, 0.1199F));
      PartDefinition RightArm3 = partdefinition.addOrReplaceChild("RightArm3", CubeListBuilder.create(), PartPose.offset(-7.0F, 9.8556F, 9.8729F));
      RightArm3.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-3.7783F, -3.5427F, -3.2219F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-22.4883F, 14.1718F, -1.3733F, -1.8033F, -0.1353F, -0.6054F));
      RightArm3.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.3584F, -3.4404F, -2.1709F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.4883F, 14.1718F, -1.3733F, -1.2233F, -0.5067F, -0.4383F));
      RightArm3.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.7542F, -1.4331F, -2.1402F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.4883F, 14.1718F, -1.3733F, -1.2198F, -0.6506F, -0.3866F));
      RightArm3.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.365F, 0.5856F, -2.1572F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.4883F, 14.1718F, -1.3733F, -1.0159F, -0.7647F, -0.6368F));
      RightArm3.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-2.9844F, 2.4193F, -2.0611F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-22.4883F, 14.1718F, -1.3733F, -0.6133F, -1.0965F, -0.5826F));
      RightArm3.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(131, 50).mirror().addBox(-1.0033F, -3.8575F, -2.4226F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.4883F, 14.1718F, -1.3733F, -1.4158F, -0.6492F, -0.0623F));
      RightArm3.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(130, 49).mirror().addBox(-7.8406F, -5.9151F, 0.1063F, 16.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-14.762F, 7.8055F, -0.4659F, -1.1788F, -0.2782F, -0.724F));
      RightArm3.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(129, 48).mirror().addBox(0.6429F, -10.9391F, -3.4203F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.762F, 8.8055F, -2.4659F, -1.7148F, 0.4436F, -0.6424F));
      PartDefinition RightArm2 = partdefinition.addOrReplaceChild("RightArm2", CubeListBuilder.create(), PartPose.offset(-8.0F, 9.8556F, -2.6271F));
      RightArm2.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-3.6294F, -3.4679F, -3.1082F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-19.3228F, 12.7456F, -6.6508F, -1.6893F, -0.193F, -0.8332F));
      RightArm2.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.2372F, -3.3424F, -2.1911F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.3228F, 12.7456F, -6.6508F, -1.0908F, -0.5824F, -0.7156F));
      RightArm2.addOrReplaceChild("RightArm_r11", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.6378F, -1.387F, -2.1903F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.3228F, 12.7456F, -6.6508F, -1.0651F, -0.7336F, -0.6933F));
      RightArm2.addOrReplaceChild("RightArm_r12", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.1658F, 0.3689F, -2.1538F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.3228F, 12.7456F, -6.6508F, -0.7678F, -0.8192F, -1.0152F));
      RightArm2.addOrReplaceChild("RightArm_r13", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-2.5234F, 2.0817F, -1.7171F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-19.3228F, 12.7456F, -6.6508F, -0.1037F, -1.1567F, -1.2323F));
      RightArm2.addOrReplaceChild("RightArm_r14", CubeListBuilder.create().texOffs(131, 50).mirror().addBox(-0.8995F, -3.5791F, -2.3746F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.3228F, 12.7456F, -6.6508F, -1.3484F, -0.7463F, -0.3149F));
      RightArm2.addOrReplaceChild("RightArm_r15", CubeListBuilder.create().texOffs(130, 49).mirror().addBox(-0.7035F, -3.3362F, -2.4377F, 16.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-17.2525F, 11.1356F, -3.8839F, -1.3484F, -0.7463F, -0.664F));
      RightArm2.addOrReplaceChild("RightArm_r16", CubeListBuilder.create().texOffs(129, 48).mirror().addBox(-3.6782F, -9.7498F, -10.0062F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.3F, 10.6202F, -3.9823F, -1.7821F, 0.3247F, -0.5839F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-6.0928F, 8.9524F, -10.4774F));
      RightArm.addOrReplaceChild("RightArm_r17", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-3.5487F, -2.9647F, -2.7993F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-14.0703F, 13.411F, -17.9441F, -0.6752F, -0.6652F, -1.2154F));
      RightArm.addOrReplaceChild("RightArm_r18", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.3429F, -2.7581F, -2.2424F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0703F, 13.411F, -17.9441F, 0.3004F, -0.9129F, -1.6753F));
      RightArm.addOrReplaceChild("RightArm_r19", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.8202F, -0.823F, -2.2517F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0703F, 13.411F, -17.9441F, 0.5399F, -0.9417F, -1.9249F));
      RightArm.addOrReplaceChild("RightArm_r20", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-4.4472F, 0.8779F, -2.2834F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0703F, 13.411F, -17.9441F, 0.7105F, -0.7146F, -2.0597F));
      RightArm.addOrReplaceChild("RightArm_r21", CubeListBuilder.create().texOffs(133, 52).mirror().addBox(-2.9621F, 2.4068F, -1.9558F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-14.0703F, 13.411F, -17.9441F, 1.4601F, -0.6095F, -2.4936F));
      RightArm.addOrReplaceChild("RightArm_r22", CubeListBuilder.create().texOffs(131, 50).mirror().addBox(-1.0402F, -3.0F, -2.3777F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0703F, 13.411F, -17.9441F, 0.657F, -1.2106F, -2.0866F));
      RightArm.addOrReplaceChild("RightArm_r23", CubeListBuilder.create().texOffs(130, 49).mirror().addBox(-4.2319F, -5.5539F, -2.5768F, 16.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-11.7853F, 9.7568F, -11.9908F, 0.2111F, -0.7574F, -1.5449F));
      RightArm.addOrReplaceChild("RightArm_r24", CubeListBuilder.create().texOffs(129, 48).mirror().addBox(-3.0191F, -8.077F, -11.6116F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.2853F, 7.1587F, -11.9908F, -1.9168F, -0.366F, -0.1199F));
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -4.7093F, -8.4062F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 94).addBox(-13.0F, -6.0F, -10.0F, 26.0F, 12.0F, 16.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 5.1906F, -16.5302F, 1.7017F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(13, 55).addBox(-13.0F, -6.0F, -13.0F, 26.0F, 12.0F, 19.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -4.8684F, -16.9129F, 1.7017F, 0.0F, 3.1416F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 94).addBox(-13.0F, -12.7169F, -8.8739F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.8008F, -18.3455F, -1.9635F, 0.0F, 3.1416F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(8, 7).mirror().addBox(-15.0F, -10.0F, -9.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.7093F, -3.0171F, -1.9635F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(2, 52).mirror().addBox(-15.0F, -10.0F, -12.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.2907F, -3.0171F, -1.1781F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(2, 53).mirror().addBox(-15.0F, -10.0F, -25.0F, 30.0F, 19.0F, 22.0F, new CubeDeformation(-2.15F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.7093F, -4.0171F, -1.5708F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(129, 19).addBox(-6.0F, -2.0F, -6.5F, 12.0F, 3.0F, 12.0F, new CubeDeformation(-0.3F)).texOffs(133, 35).addBox(-3.0F, -3.0F, -4.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.3F)).texOffs(133, 35).addBox(-3.0F, -4.3F, -4.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-7.0F, 6.8225F, -22.3277F, 1.5708F, 0.1745F, -0.7854F));
      Head.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(133, 35).mirror().addBox(-5.0F, -4.3F, -4.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(133, 35).mirror().addBox(-5.0F, -3.0F, -4.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(129, 19).mirror().addBox(-6.0F, -2.0F, -6.5F, 12.0F, 3.0F, 12.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(7.0F, 6.8225F, -22.3277F, 1.5708F, -0.1745F, 0.7854F));
      Head.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(133, 35).addBox(-3.1F, -3.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.3F)).texOffs(133, 35).addBox(-3.1F, -4.2F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.2F)).texOffs(129, 19).addBox(-6.1F, -2.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-8.9347F, -3.8377F, -23.0097F, 1.5708F, 0.1309F, 0.1309F));
      Head.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(133, 35).mirror().addBox(-4.9F, -4.2F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.2F)).mirror(false).texOffs(133, 35).mirror().addBox(-4.9F, -3.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(129, 19).mirror().addBox(-5.9F, -2.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(8.9347F, -3.8377F, -23.0097F, 1.5708F, -0.1309F, -0.1309F));
      Head.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(133, 35).addBox(-3.0F, -3.7F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.2F)).texOffs(133, 35).addBox(-3.0F, -2.5F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.3F)).texOffs(129, 19).addBox(-6.0F, -1.5F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -11.2543F, -23.1616F, 1.5708F, 0.1309F, 1.5708F));
      Head.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(140, 19).addBox(2.0F, -13.5F, 1.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(-0.3F)).texOffs(133, 35).addBox(1.0F, -17.5F, 6.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.2F)).texOffs(133, 35).addBox(1.0F, -16.1F, 6.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.3F)).texOffs(128, 0).addBox(0.0F, -15.1F, 4.0F, 10.0F, 4.0F, 12.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-5.0F, 8.3623F, -11.3054F, 1.5708F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(0, 94).addBox(-13.0F, -7.0F, -9.5F, 26.0F, 12.0F, 16.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 8.9654F, -13.3033F, -1.9635F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 256, 256);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.LeftArm3.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightArm2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightArm3.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftArm2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.Body3.yRot = netHeadYaw / 57.295776F;
      this.Body3.xRot = headPitch / 57.295776F;
   }
}
