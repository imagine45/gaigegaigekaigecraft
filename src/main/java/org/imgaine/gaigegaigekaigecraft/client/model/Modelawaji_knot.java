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

public class Modelawaji_knot<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelawaji_knot"), "main");
   public final ModelPart body;

   public Modelawaji_knot(ModelPart root) {
      this.body = root.getChild("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 1.0F));
      PartDefinition red = body.addOrReplaceChild("red", CubeListBuilder.create().texOffs(0, 8).addBox(-30.012F, 2.0675F, -0.2364F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 8).addBox(-18.012F, 2.0675F, -0.1364F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 8).addBox(-24.012F, 2.0675F, -0.2364F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 8).addBox(6.4149F, -3.1184F, -0.3048F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.488F, -3.0675F, -0.7636F));
      red.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 8).addBox(-5.3135F, -2.6457F, -1.0516F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0833F, 7.504F, 0.8162F, 0.0873F, 0.0873F, 2.7489F));
      red.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).addBox(-2.2533F, -1.9245F, -1.0246F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0692F, 7.433F, 0.6656F, 0.0436F, 0.0436F, -3.1416F));
      red.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 8).addBox(-4.0008F, -1.9957F, 0.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.4036F, -24.9848F, -0.7405F, 0.0F, 0.0F, -1.7453F));
      red.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 8).addBox(-4.0056F, -1.9789F, 0.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.2292F, -19.2841F, -0.7405F, 0.0F, 0.0F, -1.8326F));
      red.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 8).addBox(-3.0066F, -1.4792F, 0.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7931F, -12.4926F, -0.7405F, 0.0F, 0.0F, -1.8762F));
      red.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 8).addBox(-3.0F, -1.4F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7137F, -1.3447F, 0.7636F, 0.0F, 0.0436F, -1.9635F));
      red.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 8).addBox(-3.0075F, -1.4795F, 0.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8859F, -6.8744F, -0.7405F, 0.0F, 0.0F, -1.9199F));
      red.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 8).addBox(-1.4F, -1.4F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7228F, 5.5365F, 0.6636F, 0.0F, -0.1309F, -2.3562F));
      red.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 8).addBox(0.4846F, -1.8846F, -0.1959F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 4.4759F, 0.1595F, 0.0F, 0.0F, -2.3562F));
      red.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 8).addBox(0.9951F, -2.4494F, -1.0017F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1192F, 7.433F, 0.5905F, 0.0436F, 0.0F, -2.7489F));
      red.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 8).addBox(-4.7359F, -2.4173F, 1.0041F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.9016F, 0.9423F, -1.1013F, 0.0F, -0.0436F, 0.3927F));
      red.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -2.0393F, 1.7041F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0641F, 3.1445F, -1.5824F, 0.0F, 0.0F, 1.5708F));
      red.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.1608F, 5.9147F, 1.0572F, 0.0F, 0.0436F, 1.9635F));
      red.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.2228F, 0.4065F, 0.9305F, -0.0436F, -0.0873F, 1.1781F));
      red.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6876F, 1.1289F, 0.9529F, 0.0F, -0.0873F, -0.7854F));
      red.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 8).addBox(-2.5F, -1.5F, -1.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7686F, -0.8128F, 0.9093F, 0.0F, 0.0873F, -0.3927F));
      red.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 8).addBox(-1.9799F, -1.9917F, -0.1959F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8512F, 3.3783F, -0.0217F, 0.0F, 0.0F, -0.3927F));
      red.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 8).addBox(-2.3F, -1.5F, -0.9F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9095F, 3.5675F, 0.8271F, 0.0F, 0.0873F, 0.0F));
      red.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 8).addBox(-3.1F, -1.5F, -1.2F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.9673F, 3.5675F, 1.1977F, 0.0F, -0.0436F, 0.0F));
      PartDefinition white = body.addOrReplaceChild("white", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(24.012F, 2.0675F, -1.7636F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(12.012F, 2.0675F, -1.8636F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(18.012F, 2.0675F, -1.7636F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-10.4149F, -3.1184F, -1.6952F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.488F, -3.0675F, 0.8636F));
      white.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.3135F, -2.6457F, -0.9484F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0833F, 7.504F, -0.8162F, -0.0873F, 0.0873F, -2.7489F));
      white.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.7467F, -1.9245F, -0.9754F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0692F, 7.433F, -0.6656F, -0.0436F, 0.0436F, 3.1416F));
      white.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9992F, -1.9957F, -2.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.4036F, -24.9848F, 0.7405F, 0.0F, 0.0F, 1.7453F));
      white.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9944F, -1.9789F, -2.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.2292F, -19.2841F, 0.7405F, 0.0F, 0.0F, 1.8326F));
      white.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.9934F, -1.4792F, -2.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7931F, -12.4926F, 0.7405F, 0.0F, 0.0F, 1.8762F));
      white.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -1.4F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7137F, -1.3447F, -0.7636F, 0.0F, 0.0436F, 1.9635F));
      white.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.9925F, -1.4795F, -2.4041F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.8859F, -6.8744F, 0.7405F, 0.0F, 0.0F, 1.9199F));
      white.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.6F, -1.4F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7228F, 5.5365F, -0.6636F, 0.0F, -0.1309F, 2.3562F));
      white.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.4846F, -1.8846F, -1.8041F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.33F, 4.4759F, -0.1595F, 0.0F, 0.0F, 2.3562F));
      white.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.9951F, -2.4494F, -0.9983F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.1192F, 7.433F, -0.5905F, -0.0436F, 0.0F, 2.7489F));
      white.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.7359F, -2.4173F, -3.0041F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.9016F, 0.9423F, 1.1013F, 0.0F, -0.0436F, -0.3927F));
      white.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -2.0393F, -3.7041F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0641F, 3.1445F, 1.5824F, 0.0F, 0.0F, -1.5708F));
      white.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.1608F, 5.9147F, -1.0572F, 0.0F, 0.0436F, -1.9635F));
      white.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.2228F, 0.4065F, -0.9305F, 0.0436F, -0.0873F, -1.1781F));
      white.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6876F, 1.1289F, -0.9529F, 0.0F, -0.0873F, 0.7854F));
      white.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -1.5F, -1.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.7686F, -0.8128F, -0.9093F, 0.0F, 0.0873F, 0.3927F));
      white.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0201F, -1.9917F, -1.8041F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.8512F, 3.3783F, 0.0217F, 0.0F, 0.0F, 0.3927F));
      white.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.7F, -1.5F, -1.1F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9095F, 3.5675F, -0.8271F, 0.0F, 0.0873F, 0.0F));
      white.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.9F, -1.5F, -0.8F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.9673F, 3.5675F, -1.1977F, 0.0F, -0.0436F, 0.0F));
      return LayerDefinition.create(meshdefinition, 16, 16);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body.yRot = netHeadYaw / 57.295776F;
      this.body.xRot = headPitch / 57.295776F;
   }
}
