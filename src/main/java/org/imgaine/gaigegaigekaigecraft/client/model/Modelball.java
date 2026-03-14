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

public class Modelball<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelball"), "main");
   public final ModelPart ball;

   public Modelball(ModelPart root) {
      this.ball = root.m_171324_("ball");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition ball = partdefinition.m_171599_("ball", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      ball.m_171599_("ball_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3655F, 0.147F, 1.2053F));
      ball.m_171599_("ball_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.8567F, 0.274F, -0.8249F));
      ball.m_171599_("ball_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.1572F, 0.3614F, 0.4215F));
      ball.m_171599_("ball_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.1572F, -0.3614F, 2.7201F));
      ball.m_171599_("ball_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3655F, -0.147F, 1.9363F));
      ball.m_171599_("ball_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.8567F, -0.274F, -2.3166F));
      ball.m_171599_("ball_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7459F, 0.274F, 1.2859F));
      ball.m_171599_("ball_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.5261F, 0.5236F, -0.9553F));
      ball.m_171599_("ball_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3655F, 0.7119F, 0.5299F));
      ball.m_171599_("ball_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3655F, -0.7119F, 2.6117F));
      ball.m_171599_("ball_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7459F, -0.274F, 1.8557F));
      ball.m_171599_("ball_r14", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.5261F, -0.5236F, -2.1863F));
      ball.m_171599_("ball_r15", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.1781F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r16", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.1493F, 0.3614F, 1.4136F));
      ball.m_171599_("ball_r17", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.1007F, 0.7119F, -1.2053F));
      ball.m_171599_("ball_r18", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7459F, 1.0228F, 0.8249F));
      ball.m_171599_("ball_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7459F, -1.0228F, 2.3166F));
      ball.m_171599_("ball_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.1493F, -0.3614F, 1.728F));
      ball.m_171599_("ball_r21", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.1007F, -0.7119F, -1.9363F));
      ball.m_171599_("ball_r22", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r23", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 0.3927F, 1.5708F));
      ball.m_171599_("ball_r24", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 0.7854F, -1.5708F));
      ball.m_171599_("ball_r25", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 1.1781F, 1.5708F));
      ball.m_171599_("ball_r26", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, -1.1781F, 1.5708F));
      ball.m_171599_("ball_r27", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, -0.3927F, 1.5708F));
      ball.m_171599_("ball_r28", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, -0.7854F, -1.5708F));
      ball.m_171599_("ball_r29", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.9635F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r30", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.9923F, 0.3614F, 1.728F));
      ball.m_171599_("ball_r31", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.0409F, 0.7119F, -1.9363F));
      ball.m_171599_("ball_r32", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.3957F, 1.0228F, 2.3166F));
      ball.m_171599_("ball_r33", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.3957F, -1.0228F, 0.8249F));
      ball.m_171599_("ball_r34", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.9923F, -0.3614F, 1.4136F));
      ball.m_171599_("ball_r35", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.0409F, -0.7119F, -1.2053F));
      ball.m_171599_("ball_r36", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r37", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.3957F, 0.274F, 1.8557F));
      ball.m_171599_("ball_r38", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.6155F, 0.5236F, -2.1863F));
      ball.m_171599_("ball_r39", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7761F, 0.7119F, 2.6117F));
      ball.m_171599_("ball_r40", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7761F, -0.7119F, 0.5299F));
      ball.m_171599_("ball_r41", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.3957F, -0.274F, 1.2859F));
      ball.m_171599_("ball_r42", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.6155F, -0.5236F, -0.9553F));
      ball.m_171599_("ball_r43", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));
      ball.m_171599_("ball_r44", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7489F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r45", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7761F, 0.147F, 1.9363F));
      ball.m_171599_("ball_r46", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2849F, 0.274F, -2.3166F));
      ball.m_171599_("ball_r47", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.9844F, 0.3614F, 2.7201F));
      ball.m_171599_("ball_r48", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.9844F, -0.3614F, 0.4215F));
      ball.m_171599_("ball_r49", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7761F, -0.147F, 1.2053F));
      ball.m_171599_("ball_r50", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2849F, -0.274F, -0.8249F));
      ball.m_171599_("ball_r51", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5137F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0137F, 0.0F, 0.0F, 3.1416F, 0.0F, 1.5708F));
      ball.m_171599_("ball_r52", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 1.9635F));
      ball.m_171599_("ball_r53", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));
      ball.m_171599_("ball_r54", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 2.7489F));
      ball.m_171599_("ball_r55", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.3927F));
      ball.m_171599_("ball_r56", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 1.1781F));
      ball.m_171599_("ball_r57", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
      return LayerDefinition.m_171565_(meshdefinition, 6, 6);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.ball.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.ball.f_104204_ = netHeadYaw / 57.295776F;
      this.ball.f_104203_ = headPitch / 57.295776F;
   }
}
