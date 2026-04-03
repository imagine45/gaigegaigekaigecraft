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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelentity_door"), "main");
   public final ModelPart door;

   public Modelentity_door(ModelPart root) {
      this.door = root.getChild("door");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition door = partdefinition.addOrReplaceChild("door", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -60.0F, -17.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 66).addBox(-16.0F, -4.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 66).addBox(-16.0F, -64.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
      door.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 66).addBox(-16.0F, 30.0F, -1.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 66).addBox(-16.0F, 90.0F, -1.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-16.0F, 34.0F, -1.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -94.0F, 16.0F, 0.0F, 3.1416F, 0.0F));
      door.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-16.0F, 30.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 66).mirror().addBox(-16.0F, 90.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-16.0F, 34.0F, -17.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -94.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
      door.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 66).addBox(-16.0F, 30.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 66).addBox(-16.0F, 90.0F, -17.0F, 32.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 66).mirror().addBox(-13.0F, 60.5F, 16.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 66).addBox(7.0F, 60.5F, -18.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-16.0F, 34.0F, -17.0F, 32.0F, 56.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -94.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      door.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 66).addBox(7.0F, -1.5F, -18.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 66).mirror().addBox(-13.0F, -1.5F, 16.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -32.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
