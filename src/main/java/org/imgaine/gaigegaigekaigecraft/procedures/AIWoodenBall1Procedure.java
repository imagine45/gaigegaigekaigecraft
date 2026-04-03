package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.WoodenBall1Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWoodenBall1Procedure {
   public AIWoodenBall1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double move_power = 0.0;
         double dis = 0.0;
         double tick = 0.0;
         double z_fix = 0.0;
         double num1 = 0.0;
         double x_fix = 0.0;
         double y_fix = 0.0;
         double old_distance = 0.0;
         double distance = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         dis = (double)(entity.getBbWidth() * 2.0F);
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.getPersistentData().putDouble("cnt2", 1.0);
            entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
            entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY());
            entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
            entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_pos") + entity.getLookAngle().x);
            entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_pos") + entity.getLookAngle().y);
            entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_pos") + entity.getLookAngle().z);
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).getX();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     double var99 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var99 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var100;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var100 = _mobEnt.getTarget();
                     } else {
                        var100 = null;
                     }

                     z_pos = ((Entity)var100).getZ();
                  } else {
                     x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                     y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                     z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("x_pos", x_pos);
                  entity.getPersistentData().putDouble("y_pos", y_pos);
                  entity.getPersistentData().putDouble("z_pos", z_pos);
                  entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_pos") + entity.getLookAngle().x);
                  entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_pos") + entity.getLookAngle().y);
                  entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_pos") + entity.getLookAngle().z);
               }
            }

            logic_a = false;
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            x_power = entity.getLookAngle().x * 4.0;
            y_power = entity.getLookAngle().y * 4.0;
            z_power = entity.getLookAngle().z * 4.0;

            for(int index0 = 0; index0 < 10; ++index0) {
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(5.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     num1 = Math.toRadians(Math.random() * 720.0);
                     num2 = (double)entityiterator.getBbWidth() * 0.5 + dis * 4.0;
                     x_fix = Math.sin(num1) * num2;
                     y_fix = (double)(entityiterator.getBbHeight() + 2.0F) * Math.random() + 1.0;
                     z_fix = Math.cos(num1) * num2;
                     entity.getPersistentData().putDouble("x_pos", entityiterator.getX() + x_fix);
                     entity.getPersistentData().putDouble("y_pos", entityiterator.getY() + y_fix);
                     entity.getPersistentData().putDouble("z_pos", entityiterator.getZ() + z_fix);
                     entity.getPersistentData().putDouble("x_power", entityiterator.getX());
                     entity.getPersistentData().putDouble("y_power", entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                     entity.getPersistentData().putDouble("z_power", entityiterator.getZ());
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            x_power = entity.getLookAngle().x * 1.0;
            y_power = entity.getLookAngle().y * 1.0;
            z_power = entity.getLookAngle().z * 1.0;
            old_distance = 9999.0;

            for(int index1 = 0; index1 < 3; ++index1) {
               distance = Math.sqrt(Math.pow(entity.getX() - x_pos, 2.0) + Math.pow(entity.getY() - y_pos, 2.0) + Math.pow(entity.getZ() - z_pos, 2.0));
               if (distance > old_distance || distance < dis) {
                  entity.getPersistentData().putDouble("cnt2", 2.0);
                  entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                  BulletDomainHit2Procedure.execute(world, entity);
                  break;
               }

               entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
               }

               old_distance = distance;
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") > 1.0) {
            RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power"), entity);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
               if (entity.getPersistentData().getDouble("cnt3") <= 8.0) {
                  x_pos = entity.getX();
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  z_pos = entity.getZ();
                  if (entity.getPersistentData().getDouble("cnt3") == 1.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.break")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.break")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                        }
                     }

                     if (entity instanceof WoodenBall1Entity) {
                        ((WoodenBall1Entity)entity).setAnimation("empty");
                     }

                     if (entity instanceof WoodenBall1Entity) {
                        PlayAnimationEntity2Procedure.execute(entity, "attack");
                     }
                  }

                  x_power = entity.getLookAngle().x * dis;
                  y_power = entity.getLookAngle().y * dis;
                  z_power = entity.getLookAngle().z * dis;

                  for(int index2 = 0; index2 < (int)entity.getPersistentData().getDouble("cnt3"); ++index2) {
                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

                  entity.getPersistentData().putDouble("Damage", 12.0);
                  entity.getPersistentData().putDouble("Range", dis * 2.0);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     entity.getPersistentData().putDouble("BlockRange", dis);
                     entity.getPersistentData().putDouble("BlockDamage", 2.0);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt3") > 20.0) {
                  entity.getPersistentData().putDouble("move", 0.0);
                  if (entity.getPersistentData().getDouble("position_pitch") == 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               }
            }
         }

      }
   }
}
