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

public class Modelentity_door<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelentity_door"), "main");
   public final ModelPart door;

   public Modelentity_door(ModelPart root) {
      this.door = root.m_171324_("door");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition door = partdefinition.m_171599_("door", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-16.0F, -60.0F, -17.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 66).m_171488_(-16.0F, -4.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 66).m_171488_(-16.0F, -64.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 22.0F, 0.0F));
      door.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 66).m_171488_(-16.0F, 30.0F, -1.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 66).m_171488_(-16.0F, 90.0F, -1.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-16.0F, 34.0F, -1.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -94.0F, 16.0F, 0.0F, 3.1416F, 0.0F));
      door.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 66).m_171480_().m_171488_(-16.0F, 30.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 66).m_171480_().m_171488_(-16.0F, 90.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-16.0F, 34.0F, -17.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -94.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
      door.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 66).m_171488_(-16.0F, 30.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 66).m_171488_(-16.0F, 90.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 66).m_171480_().m_171488_(-13.0F, 60.5F, 16.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 66).m_171488_(7.0F, 60.5F, -18.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-16.0F, 34.0F, -17.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -94.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      door.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 66).m_171488_(7.0F, -1.5F, -18.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 66).m_171480_().m_171488_(-13.0F, -1.5F, 16.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -32.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.door.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
