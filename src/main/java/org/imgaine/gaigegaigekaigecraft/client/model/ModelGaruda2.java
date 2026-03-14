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

public class ModelGaruda2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_garuda_2"), "main");
   public final ModelPart BodyMain;

   public ModelGaruda2(ModelPart root) {
      this.BodyMain = root.m_171324_("BodyMain");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition BodyMain = partdefinition.m_171599_("BodyMain", CubeListBuilder.m_171558_(), PartPose.m_171423_(1.0F, 19.0F, 0.0F, -0.0894F, -0.2173F, 0.0193F));
      PartDefinition Head = BodyMain.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -2.3F, -6.3622F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(16, 0).m_171488_(-1.5F, -1.1F, -8.3622F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(22, 5).m_171488_(-1.5F, -1.1F, -8.3622F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.05F)).m_171514_(0, 0).m_171488_(-2.9F, -1.3F, -4.3622F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(1.9F, -1.3F, -4.3622F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.882F, -5.219F, -1.4959F, 1.2412F, -0.1172F, -0.3295F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -2.486F, -6.6443F, 3.0F, 1.0F, 10.0F, new CubeDeformation(-0.4F)).m_171514_(0, 0).m_171488_(-1.5F, -2.714F, -6.5557F, 3.0F, 1.0F, 10.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.0F, 0.2932F, -10.801F, -2.4435F, 0.0F, 0.0F));
      PartDefinition Body1 = BodyMain.m_171599_("Body1", CubeListBuilder.m_171558_().m_171514_(1, 24).m_171488_(-2.0F, -2.3483F, -0.8933F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-2.0F, -2.3483F, 2.6067F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-0.882F, -4.6707F, -1.4648F, -0.0511F, 0.0831F, -0.0875F));
      Body1.m_171599_("Body1_r1", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171480_().m_171488_(1.0F, -0.5F, -3.75F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(3, 18).m_171480_().m_171488_(0.5F, -0.5F, -2.75F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.41F)).m_171555_(false), PartPose.m_171423_(5.3233F, 0.6903F, 1.8748F, 1.3485F, -0.1395F, 2.59F));
      Body1.m_171599_("Body1_r2", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.5F, -22.2338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.7381F, 22.3405F, 0.0F, 0.0F, 1.5708F));
      Body1.m_171599_("Body1_r3", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, 2.6102F, -21.996F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.7381F, 22.3405F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body2 = Body1.m_171599_("Body2", CubeListBuilder.m_171558_().m_171514_(1, 24).m_171488_(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-2.0F, -2.0F, 3.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -0.3483F, 4.1067F, -0.7877F, 0.8069F, 0.8069F));
      Body2.m_171599_("Body2_r1", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171480_().m_171488_(-5.239F, 15.3357F, 0.6805F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(3, 18).m_171480_().m_171488_(-5.739F, 15.3357F, 1.6805F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.41F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.3898F, 18.2338F, -1.4686F, -0.2415F, -1.845F));
      Body2.m_171599_("Body2_r2", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.5F, -17.7338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.3898F, 18.2338F, 0.0F, 0.0F, 1.5708F));
      Body2.m_171599_("Body2_r3", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, 1.3161F, -17.1664F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.3898F, 18.2338F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body3 = Body2.m_171599_("Body3", CubeListBuilder.m_171558_().m_171514_(1, 24).m_171488_(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-2.0F, -2.0F, 3.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0F, 5.0F, -0.995F, 0.4197F, -0.466F));
      Body3.m_171599_("Body3_r1", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.5F, -12.7338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.3898F, 13.2338F, 0.0F, 0.0F, 1.5708F));
      Body3.m_171599_("Body3_r2", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, 0.022F, -12.3368F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.3898F, 13.2338F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body3_2 = Body3.m_171599_("Body3_2", CubeListBuilder.m_171558_().m_171514_(1, 24).m_171488_(-2.0F, -1.4482F, 0.2495F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-2.0F, -1.4482F, 3.7495F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -0.5518F, 4.7505F, -0.8373F, 0.5357F, -0.4756F));
      Body3_2.m_171599_("Body3_r3", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -1.2721F, -7.5071F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 0.1621F, 8.4834F, -0.2618F, 0.0F, 0.0F));
      Body3_2.m_171599_("Body3_r4", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.5F, -7.7338F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 0.1621F, 8.4834F, 0.0F, 0.0F, 1.5708F));
      PartDefinition Body4 = Body3_2.m_171599_("Body4", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-1.5F, -1.6156F, 1.154F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-1.5F, -1.6156F, 4.654F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.6675F, 3.5956F, -0.6798F, 0.9904F, -0.6053F));
      Body4.m_171599_("Body4_r1", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.0F, -3.2338F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.5054F, 4.8878F, 0.0F, 0.0F, 1.5708F));
      Body4.m_171599_("Body4_r2", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -1.6299F, -3.2122F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.5054F, 4.8878F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body5 = Body4.m_171599_("Body5", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -0.1156F, 6.154F, 2.0617F, 1.2798F, 2.0253F));
      Body5.m_171599_("Body7_r1", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-5.7146F, -3.0368F, -3.7205F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-5.7146F, -3.0368F, -0.2205F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(2.8193F, 2.3562F, 4.8959F, -0.359F, -0.8429F, -0.8565F));
      Body5.m_171599_("Body7_r2", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-2.0368F, 1.2146F, -3.2205F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(2.8193F, 2.3562F, 4.8959F, -0.8755F, 0.2359F, 0.4411F));
      Body5.m_171599_("Body7_r3", CubeListBuilder.m_171558_().m_171514_(14, 11).m_171488_(-5.3753F, -6.3517F, 1.1635F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(1, 25).m_171488_(-5.3753F, -6.3517F, -2.3365F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.8193F, 2.3562F, 4.8959F, 1.2262F, -0.5094F, 1.8744F));
      Body5.m_171599_("Body7_r4", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-5.3517F, 0.8753F, -1.8365F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(2.8193F, 2.3562F, 4.8959F, -1.0268F, -0.9645F, -1.9017F));
      Body5.m_171599_("Body6_r1", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-4.3412F, -5.3188F, -4.6567F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-4.3412F, -5.3188F, -1.1567F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(2.8193F, 2.3562F, 4.8959F, 0.3611F, -0.1004F, 0.756F));
      Body5.m_171599_("Body6_r2", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-4.3188F, -0.1588F, -4.1567F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(2.8193F, 2.3562F, 4.8959F, -0.1073F, -0.3592F, 2.3647F));
      Body5.m_171599_("Body5_r1", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.0F, 1.7662F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -1.2662F, 0.0F, 0.0F, 1.5708F));
      Body5.m_171599_("Body5_r2", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -2.924F, 1.6174F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -1.2662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body6 = Body5.m_171599_("Body6", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0F, 5.1F, 0.0269F, 0.8247F, 0.7345F));
      Body6.m_171599_("Body8_r1", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(1.1266F, 0.8353F, -1.6614F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(2.642F, -0.072F, 2.5605F, -0.0077F, -0.077F, 0.2414F));
      Body6.m_171599_("Body8_r2", CubeListBuilder.m_171558_().m_171514_(14, 11).m_171488_(-5.3353F, 0.1266F, 1.3386F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(1, 25).m_171488_(-5.3353F, 0.1266F, -2.1614F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.642F, -0.072F, 2.5605F, 0.077F, -0.0077F, -1.33F));
      Body6.m_171599_("Body8_r3", CubeListBuilder.m_171558_().m_171514_(14, 11).m_171488_(-7.6888F, -2.5737F, 0.9038F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(1, 25).m_171488_(-7.6888F, -2.5737F, -2.5962F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.642F, -0.072F, 2.5605F, -0.2198F, 0.2016F, 2.392F));
      Body6.m_171599_("Body8_r4", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.5737F, 3.1888F, -2.0962F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(2.642F, -0.072F, 2.5605F, 0.2064F, 0.2152F, -2.2757F));
      Body6.m_171599_("Body7_r5", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.5136F, 0.4942F, -2.6009F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(2.642F, -0.072F, 2.5605F, -0.0607F, 0.3917F, 2.3226F));
      Body6.m_171599_("Body7_r6", CubeListBuilder.m_171558_().m_171514_(14, 11).m_171488_(-4.9942F, -2.5136F, 0.3991F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(1, 25).m_171488_(-4.9942F, -2.5136F, -3.1009F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.642F, -0.072F, 2.5605F, -0.3924F, -0.0561F, 0.7749F));
      Body6.m_171599_("Body6_r3", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.0F, 6.8662F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -6.3662F, 0.0F, 0.0F, 1.5708F));
      Body6.m_171599_("Body6_r4", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -4.244F, 6.5436F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -6.3662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body7 = Body6.m_171599_("Body7", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0F, 5.0F, 0.0136F, 0.9585F, 0.0404F));
      Body7.m_171599_("Body9_r1", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(1.2602F, 1.4878F, -0.9747F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(3.5119F, -0.1683F, 0.7581F, 0.5716F, -0.9958F, 0.4551F));
      Body7.m_171599_("Body9_r2", CubeListBuilder.m_171558_().m_171514_(14, 11).m_171488_(-5.9878F, 0.2602F, 2.0253F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(1, 25).m_171488_(-5.9878F, 0.2602F, -1.4747F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.5119F, -0.1683F, 0.7581F, 1.0718F, 0.2986F, -0.6206F));
      Body7.m_171599_("Body9_r3", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.3734F, 2.5463F, -3.2025F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(3.5119F, -0.1683F, 0.7581F, 2.11F, 0.6845F, -1.8407F));
      Body7.m_171599_("Body9_r4", CubeListBuilder.m_171558_().m_171514_(1, 25).m_171488_(-7.0463F, -2.3734F, -3.7025F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-7.0463F, -2.3734F, -0.2025F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(3.5119F, -0.1683F, 0.7581F, -2.1324F, 0.7273F, 0.543F));
      Body7.m_171599_("Body8_r5", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-1.3962F, 0.5843F, -1.2869F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(3.5119F, -0.1683F, 0.7581F, -0.1653F, 0.8309F, 1.6491F));
      Body7.m_171599_("Body8_r6", CubeListBuilder.m_171558_().m_171514_(14, 11).m_171488_(-5.0843F, -2.3962F, 1.7131F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(1, 25).m_171488_(-5.0843F, -2.3962F, -1.7869F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.5119F, -0.1683F, 0.7581F, -0.8377F, -0.1112F, 0.2009F));
      Body7.m_171599_("Body7_r7", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -3.0F, 11.8662F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -11.3662F, 0.0F, 0.0F, 1.5708F));
      Body7.m_171599_("Body7_r8", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -5.5381F, 11.3732F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -11.3662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body8 = Body7.m_171599_("Body8", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171488_(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-1.0F, -1.0F, 4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0F, 4.4F, 0.0012F, 0.6555F, -0.022F));
      Body8.m_171599_("Body8_r7", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -2.0F, 16.7662F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -15.7662F, 0.0F, 0.0F, 1.5708F));
      Body8.m_171599_("Body8_r8", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -6.48F, 16.4252F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.3898F, -15.7662F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body9 = Body8.m_171599_("Body9", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171488_(-1.0F, -1.0389F, 0.2914F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(14, 11).m_171488_(-1.0F, -1.0389F, 4.7914F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0389F, 5.7086F, 1.1455F, 1.0582F, 0.5884F));
      Body9.m_171599_("Body9_r5", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171480_().m_171488_(-12.7146F, -0.0324F, 18.5405F, 2.0F, 1.0F, 8.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.4287F, -21.4747F, 0.0F, 0.6109F, 0.0F));
      Body9.m_171599_("Body9_r6", CubeListBuilder.m_171558_().m_171514_(24, 17).m_171488_(-0.1102F, -2.0F, 22.7662F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.4287F, -21.4747F, 0.0F, 0.0F, 1.5708F));
      Body9.m_171599_("Body9_r7", CubeListBuilder.m_171558_().m_171514_(24, 27).m_171488_(-0.5F, -8.0329F, 22.2207F, 1.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.0F, -0.4287F, -21.4747F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Body10 = Body9.m_171599_("Body10", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -0.0389F, 6.2566F, 0.0F, 1.0036F, 0.0F));
      Body10.m_171599_("Body10_r1", CubeListBuilder.m_171558_().m_171514_(1, 26).m_171480_().m_171488_(-2.2705F, -0.6102F, 31.1889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)).m_171555_(false).m_171514_(1, 26).m_171480_().m_171488_(-2.4705F, -0.6102F, 27.6889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.3898F, -27.7313F, 0.0F, 0.0873F, 0.0F));
      Body10.m_171599_("Body10_r2", CubeListBuilder.m_171558_().m_171514_(1, 26).m_171488_(1.2705F, -0.6102F, 31.1889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)).m_171514_(1, 26).m_171488_(1.4705F, -0.6102F, 27.6889F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.3898F, -27.7313F, 0.0F, -0.0873F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.BodyMain.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
