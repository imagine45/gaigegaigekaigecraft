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

public class Modelticket_machine<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelticket_machine"), "main");
   public final ModelPart ticket_machine;

   public Modelticket_machine(ModelPart root) {
      this.ticket_machine = root.getChild("ticket_machine");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition ticket_machine = partdefinition.addOrReplaceChild("ticket_machine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      ticket_machine.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 102).addBox(-4.0F, -4.0F, 1.0F, 7.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.0F, -12.5F));
      PartDefinition bone2 = ticket_machine.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(4, 62).addBox(-1.5F, -9.4536F, -23.2322F, 3.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(4, 62).addBox(3.5F, -9.4536F, -23.2322F, 3.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(0, 110).mirror().addBox(6.0F, -7.3536F, -5.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 110).mirror().addBox(6.0F, -7.3536F, -24.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 110).addBox(-2.0F, -7.3536F, -24.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 110).addBox(-2.0F, -7.3536F, -5.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(39, 110).addBox(1.5F, -8.3536F, -27.4322F, 7.0F, 8.0F, 5.0F, new CubeDeformation(-2.1F)).texOffs(25, 83).addBox(-1.5F, -7.3536F, -25.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(25, 83).addBox(3.5F, -7.3536F, -25.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(25, 83).addBox(3.5F, -7.3536F, -0.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(25, 83).addBox(-1.5F, -7.3536F, -0.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -3.6464F, 11.7322F));
      bone2.addOrReplaceChild("ticket_machine_r1", CubeListBuilder.create().texOffs(10, 78).mirror().addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(10, 78).addBox(3.48F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("ticket_machine_r2", CubeListBuilder.create().texOffs(10, 78).mirror().addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(10, 78).addBox(3.48F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, 0.0F, -23.4645F, 0.7854F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("ticket_machine_r3", CubeListBuilder.create().texOffs(0, 78).addBox(1.0F, -2.5F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 78).mirror().addBox(-3.98F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.49F, -7.7839F, 0.0171F, 0.7418F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("ticket_machine_r4", CubeListBuilder.create().texOffs(10, 78).mirror().addBox(-4.0F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 109).addBox(1.48F, -1.7F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(29, 102).addBox(1.48F, -1.1F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)).texOffs(24, 109).addBox(1.48F, -0.4F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 78).addBox(0.98F, -2.5F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.51F, -7.7839F, -23.4816F, -0.7418F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("ticket_machine_r5", CubeListBuilder.create().texOffs(0, 78).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.99F, -8.9706F, -2.7306F, 1.7453F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("ticket_machine_r6", CubeListBuilder.create().texOffs(0, 78).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.99F, -8.9706F, -20.7339F, -1.7453F, 0.0F, 0.0F));
      PartDefinition bone = ticket_machine.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(22, 40).addBox(-1.0F, -4.0207F, 2.8848F, 2.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(10, 50).addBox(-1.0F, 0.0793F, 21.8848F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(10, 50).addBox(-1.0F, 0.0793F, -1.1152F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0793F, -12.3848F));
      bone.addOrReplaceChild("ticket_machine_r7", CubeListBuilder.create().texOffs(0, 51).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("ticket_machine_r8", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.7257F, -0.0546F, 0.7854F, 0.0F, 0.0F));
      bone.addOrReplaceChild("ticket_machine_r9", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.7257F, 24.8241F, -0.7854F, 0.0F, 0.0F));
      bone.addOrReplaceChild("ticket_machine_r10", CubeListBuilder.create().texOffs(0, 51).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 24.7696F, 0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("ticket_machine_r11", CubeListBuilder.create().texOffs(0, 44).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -1.6869F, 2.1488F, 2.1817F, 0.0F, 0.0F));
      bone.addOrReplaceChild("ticket_machine_r12", CubeListBuilder.create().texOffs(0, 44).addBox(-1.0F, -2.5F, -2.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -1.8097F, 23.3171F, 0.9599F, 0.0F, 0.0F));
      PartDefinition bone4 = ticket_machine.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(11, 106).addBox(0.0F, -4.0207F, 2.8848F, 0.0F, 3.0F, 19.0F, new CubeDeformation(0.1F)).texOffs(26, 106).addBox(0.0F, 0.0793F, 21.8848F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)).texOffs(26, 106).addBox(0.0F, 0.0793F, -1.1152F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -12.0793F, -12.3848F));
      bone4.addOrReplaceChild("ticket_machine_r13", CubeListBuilder.create().texOffs(26, 106).addBox(0.0F, -1.5F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("ticket_machine_r14", CubeListBuilder.create().texOffs(26, 106).addBox(0.0F, -0.5F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 7.7257F, -0.0546F, 0.7854F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("ticket_machine_r15", CubeListBuilder.create().texOffs(26, 106).addBox(0.0F, -0.5F, -2.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 7.7257F, 24.8241F, -0.7854F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("ticket_machine_r16", CubeListBuilder.create().texOffs(26, 106).addBox(0.0F, -1.5F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 24.7696F, 0.3927F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("ticket_machine_r17", CubeListBuilder.create().texOffs(26, 106).addBox(0.0F, -2.5F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.09F)), PartPose.offsetAndRotation(0.0F, -1.8097F, 1.4525F, -0.9599F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("ticket_machine_r18", CubeListBuilder.create().texOffs(26, 106).addBox(0.0F, -2.5F, -2.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.09F)), PartPose.offsetAndRotation(0.0F, -1.8097F, 23.3171F, 0.9599F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.ticket_machine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
