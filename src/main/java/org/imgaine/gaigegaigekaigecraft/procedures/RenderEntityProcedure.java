package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@EventBusSubscriber({Dist.CLIENT})
public class RenderEntityProcedure {
   private static RenderLevelStageEvent provider = null;
   private static Map<EntityType, Entity> data = new HashMap();

   public RenderEntityProcedure() {
   }

   public static void renderBackground(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color) {
      Minecraft minecraft = Minecraft.getInstance();
      Font font = minecraft.font;
      MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
      Vec3 pos = provider.getCamera().getPosition();
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, -scale, 1.0F);
      float var10001 = (float)(font.width(texts) - 1) * -0.5F;
      Objects.requireNonNull(font);
      poseStack.translate(var10001, (float)(9 - 1) * -0.5F, 0.0F);
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      font.drawInBatch(texts, 0.0F, 0.0F, 0, false, matrix4f, bufferSource, DisplayMode.SEE_THROUGH, color, 15728880);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   public static void renderBlock(BlockState blockState, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      BlockPos blockPos = BlockPos.containing(x, y, z);
      Vec3 pos = provider.getCamera().getPosition();
      int packedLight = glowing ? 15728880 : LevelRenderer.getLightColor(Minecraft.getInstance().level, blockPos);
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, scale, scale);
      poseStack.translate(-0.5F, -0.5F, -0.5F);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      renderBlockModel(blockState, blockPos, poseStack, packedLight);
      renderBlockEntity(blockState, blockPos, poseStack, packedLight);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   private static void renderBlockEntity(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
      Block var5 = blockState.getBlock();
      if (var5 instanceof EntityBlock entityBlock) {
         Minecraft minecraft = Minecraft.getInstance();
         ClientLevel level = minecraft.level;
         BlockEntity blockEntity = entityBlock.newBlockEntity(blockPos, blockState);
         if (blockEntity != null) {
            BlockEntityRenderer blockEntityRenderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
            if (blockEntityRenderer != null) {
               MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
               blockEntity.setLevel(level);
               blockEntityRenderer.render(blockEntity, 0.0F, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
            }
         }
      }

   }

   private static void renderBlockModel(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
      if (blockState.getRenderShape() == RenderShape.MODEL) {
         Minecraft minecraft = Minecraft.getInstance();
         ClientLevel level = minecraft.level;
         MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
         BlockRenderDispatcher dispatcher = minecraft.getBlockRenderer();
         ModelBlockRenderer renderer = dispatcher.getModelRenderer();
         BakedModel bakedModel = dispatcher.getBlockModel(blockState);
         ModelData modelData = bakedModel.getModelData(level, blockPos, blockState, ModelData.builder().build());
         PoseStack.Pose pose = poseStack.last();
         int color = minecraft.getBlockColors().getColor(blockState, level, blockPos);
         float red = (float)(color >> 16 & 255) / 255.0F;
         float green = (float)(color >> 8 & 255) / 255.0F;
         float blue = (float)(color & 255) / 255.0F;

         for(RenderType renderType : bakedModel.getRenderTypes(blockState, RandomSource.create(42L), modelData)) {
            renderer.renderModel(pose, bufferSource.getBuffer(Sheets.translucentCullBlockSheet()), blockState, bakedModel, red, green, blue, packedLight, OverlayTexture.NO_OVERLAY, modelData, renderType);
         }
      }

   }

   public static void renderEntity(EntityType type, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      if (type != null) {
         ClientLevel level = Minecraft.getInstance().level;
         Entity entity;
         if (data.containsKey(type)) {
            entity = (Entity)data.get(type);
            if (entity.level() != level) {
               entity = type.create(level);
               data.put(type, entity);
            }
         } else {
            entity = type.create(level);
            data.put(type, entity);
         }

         renderEntity(entity, 0.0F, x, y, z, yaw, pitch, roll, scale, glowing ? 15728880 : LevelRenderer.getLightColor(level, BlockPos.containing(x, y, z)));
      }
   }

   public static void renderEntity(Entity entity, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      float partialTick = provider.getPartialTick();
      int packedLight = glowing ? 15728880 : Minecraft.getInstance().getEntityRenderDispatcher().getPackedLightCoords(entity, partialTick);
      renderEntity(entity, partialTick, x, y, z, yaw, pitch, roll, scale, packedLight);
   }

   private static void renderEntity(Entity entity, float partialTick, double x, double y, double z, float yaw, float pitch, float roll, float scale, int packedLight) {
      if (entity != null) {
         Minecraft minecraft = Minecraft.getInstance();
         MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
         EntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(entity);
         Vec3 pos = provider.getCamera().getPosition();
         float offset = entity.getBbHeight() / 2.0F * scale;
         PoseStack poseStack = provider.getPoseStack();
         poseStack.pushPose();
         poseStack.translate(x - pos.x(), y + (double)offset - pos.y(), z - pos.z());
         poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
         poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
         poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
         poseStack.translate(0.0F, -offset, 0.0F);
         poseStack.scale(scale, scale, scale);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         renderer.render(entity, entity.getViewYRot(partialTick), partialTick, poseStack, bufferSource, packedLight);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         poseStack.popPose();
      }
   }

   public static void renderItem(ItemStack itemStack, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean flipping, boolean glowing) {
      Minecraft minecraft = Minecraft.getInstance();
      MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
      ItemRenderer renderer = minecraft.getItemRenderer();
      Vec3 pos = provider.getCamera().getPosition();
      int packedLight = glowing ? 15728880 : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, scale, scale);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      renderer.renderStatic((LivingEntity)null, itemStack, ItemDisplayContext.FIXED, flipping, poseStack, bufferSource, minecraft.level, packedLight, OverlayTexture.NO_OVERLAY, 0);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   public static void renderLine(double x1, double y1, double z1, double x2, double y2, double z2, int color) {
      MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
      Vec3 pos = provider.getCamera().getPosition();
      Vector3f normal = (new Vec3(x2 - x1, y2 - y1, z2 - z1)).normalize().toVector3f();
      Matrix4f matrix4f = provider.getPoseStack().last().pose();
      VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
      vertexConsumer.vertex(matrix4f, (float)(x1 - pos.x()), (float)(y1 - pos.y()), (float)(z1 - pos.z())).color(color).normal(normal.x(), normal.y(), normal.z()).endVertex();
      vertexConsumer.vertex(matrix4f, (float)(x2 - pos.x()), (float)(y2 - pos.y()), (float)(z2 - pos.z())).color(color).normal(normal.x(), normal.y(), normal.z()).endVertex();
   }

   public static void renderTexts(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color, boolean glowing) {
      Minecraft minecraft = Minecraft.getInstance();
      Font font = minecraft.font;
      MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
      Vec3 pos = provider.getCamera().getPosition();
      int packedLight = glowing ? 15728880 : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, -scale, 1.0F);
      float var10001 = (float)(font.width(texts) - 1) * -0.5F;
      Objects.requireNonNull(font);
      poseStack.translate(var10001, (float)(9 - 1) * -0.5F, 0.0F);
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      font.drawInBatch(texts, 0.0F, 0.0F, color, false, matrix4f, bufferSource, DisplayMode.NORMAL, 0, packedLight);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   @SubscribeEvent
   public static void renderModels(RenderLevelStageEvent event) {
      provider = event;
      if (provider.getStage() == Stage.AFTER_ENTITIES) {
         ClientLevel level = Minecraft.getInstance().level;
         Entity entity = provider.getCamera().getEntity();
         Vec3 pos = entity.getPosition(provider.getPartialTick());
         execute(provider, level, (double)provider.getPartialTick());
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(true);
      }

   }

   public static void execute(LevelAccessor world, double partialTick) {
      execute((Event)null, world, partialTick);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double partialTick) {
      double size_width = 0.0;
      double size_height = 0.0;
      Entity entity_a = null;
      if (world instanceof ClientLevel) {
         for(Entity entityiterator : ((ClientLevel)world).entitiesForRendering()) {
            if (entityiterator instanceof LivingEntity && entityiterator.getPercentFrozen() * 100.0F >= 5.0F) {
               size_width = 0.25 * ((double)entityiterator.getBbWidth() / 0.6);
               size_height = 0.25 * ((double)entityiterator.getBbHeight() / 1.8);
               renderEntity((EntityType)JujutsucraftModEntities.ICE_SPEAR_2.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5 - size_height * 0.625, entityiterator.getZ(), entityiterator.getViewYRot((float)partialTick), 0.0F, 0.0F, (float)(0.4 * (size_width + size_height)), false);
            }
         }
      }

   }
}
