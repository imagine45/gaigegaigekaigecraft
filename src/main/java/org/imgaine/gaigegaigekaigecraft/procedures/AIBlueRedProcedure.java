package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BlueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RedEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AIBlueRedProcedure {
   public AIBlueRedProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         boolean logic_a = false;
         boolean logic_despawn = false;
         boolean logic_attack = false;
         Entity entity_a = null;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            logic_a = false;
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
               label104: {
                  label105: {
                     if (entity instanceof RedEntity) {
                        RedEntity _datEntL3 = (RedEntity)entity;
                        if ((Boolean)_datEntL3.getEntityData().get(RedEntity.DATA_flag_purple)) {
                           break label105;
                        }
                     }

                     if (entity instanceof BlueEntity) {
                        BlueEntity _datEntL4 = (BlueEntity)entity;
                        if ((Boolean)_datEntL4.getEntityData().get(BlueEntity.DATA_flag_purple)) {
                           break label105;
                        }
                     }

                     label106: {
                        label107: {
                           if (entity instanceof RedEntity) {
                              if (!(entity instanceof RedEntity)) {
                                 break label107;
                              }

                              RedEntity _datEntL19 = (RedEntity)entity;
                              if (!(Boolean)_datEntL19.getEntityData().get(RedEntity.DATA_flag_start)) {
                                 break label107;
                              }
                           }

                           if (!(entity instanceof BlueEntity)) {
                              break label106;
                           }

                           if (entity instanceof BlueEntity) {
                              BlueEntity _datEntL21 = (BlueEntity)entity;
                              if ((Boolean)_datEntL21.getEntityData().get(BlueEntity.DATA_flag_start)) {
                                 break label106;
                              }
                           }
                        }

                        if (entity.getPersistentData().getDouble("NameRanged_ranged") != entity_a.getPersistentData().getDouble("NameRanged")) {
                           break label104;
                        }

                        logic_a = true;
                        if (entity instanceof RedEntity) {
                           entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                           entity.setYRot(entity_a.getYRot());
                           entity.setXRot(entity_a.getXRot());
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           if ((!entity.isAlive() || entity_a.getPersistentData().getDouble("skill") == 0.0) && entity instanceof RedEntity) {
                              RedEntity _datEntSetL = (RedEntity)entity;
                              _datEntSetL.getEntityData().set(RedEntity.DATA_flag_start, true);
                           }
                        } else if (entity instanceof BlueEntity && entity instanceof BlueEntity) {
                           BlueEntity _datEntSetL = (BlueEntity)entity;
                           _datEntSetL.getEntityData().set(BlueEntity.DATA_flag_start, true);
                        }

                        entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                        entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                        entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                        break label104;
                     }

                     logic_a = true;
                     break label104;
                  }

                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     logic_a = true;
                     entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                     entity.setYRot(entity_a.getYRot());
                     entity.setXRot(entity_a.getXRot());
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if ((entity_a.getPersistentData().getDouble("cnt1") >= 18.0 || entity_a.getPersistentData().getDouble("skill") == 0.0) && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }

               if (!logic_a && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
