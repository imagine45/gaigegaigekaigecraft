package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityReceiptEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ReceiptHouseProcedure {
   public ReceiptHouseProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double distance = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double NUM1 = 0.0;
         double CNT6 = 0.0;
         double size = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double damage = 0.0;
         double x_center = 0.0;
         double y_center = 0.0;
         double z_center = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity.getPersistentData().getDouble("cnt2") % 10.0 == 1.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var59 = ((Entity)var10000).getX();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               double var60 = ((Entity)var10001).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var60 += (double)((Entity)var10002).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var59, var60, ((Entity)var10002).getZ(), entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            }

            entity.setYRot((float)entity.getPersistentData().getDouble("yaw"));
            entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt1") < 4.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               dis = 6.0;

               for(int index0 = 0; index0 < 8; ++index0) {
                  x_center = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX();
                  y_center = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY();
                  z_center = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ();
                  Vec3 _center = new Vec3(x_center, y_center, z_center);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                     if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        SUCCESS = true;
                        x_center = entityiterator.getX();
                        y_center = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                        z_center = entityiterator.getZ();
                        break;
                     }
                  }

                  if (SUCCESS) {
                     break;
                  }

                  dis += 6.0;
               }

               entity.getPersistentData().putDouble("x_pos", x_center);
               entity.getPersistentData().putDouble("y_pos", y_center);
               entity.getPersistentData().putDouble("z_pos", z_center);
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = 3.0 * size;
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_RECEIPT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entityinstance);
                     entityinstance.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos"));
                     entityinstance.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos"));
                     entityinstance.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos"));
                     if (entityinstance instanceof EntityReceiptEntity) {
                        EntityReceiptEntity _datEntSetI = (EntityReceiptEntity)entityinstance;
                        _datEntSetI.getEntityData().set(EntityReceiptEntity.DATA_mode, 15);
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") > 0.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
