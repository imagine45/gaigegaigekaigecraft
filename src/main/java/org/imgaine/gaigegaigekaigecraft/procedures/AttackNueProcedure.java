package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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

public class AttackNueProcedure {
   public AttackNueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_speed = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         double entity_size = 0.0;
         Entity entity_a = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof NueEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "tackle");
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var67 = ((Entity)var10000).getY();
               LivingEntity var69;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var69 = _mobEnt.getTarget();
               } else {
                  var69 = null;
               }

               y_pos = var67 + (double)((Entity)var69).getBbHeight() * 0.5;
               LivingEntity var68;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var68 = _mobEnt.getTarget();
               } else {
                  var68 = null;
               }

               z_pos = ((Entity)var68).getZ();
            } else {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = (double)(64.0F + entity.getBbWidth());
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!(entity instanceof Player)) {
                  rotate = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(24.0), (e) -> true)) {
                     if (!rotate && entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        rotate = true;
                        x_pos = entityiterator.getX();
                        y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                        z_pos = entityiterator.getZ();
                     }
                  }

                  if (!rotate && entity.getPersistentData().getDouble("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                        dis = GetDistanceIteratorProcedure.execute(entity, entity_a);
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

                           double var63 = ((Entity)var10000).getY();
                           LivingEntity var10001;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10001 = _mobEnt.getTarget();
                           } else {
                              var10001 = null;
                           }

                           y_pos = var63 + (double)((Entity)var10001).getBbHeight() * 0.5;
                           LivingEntity var64;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var64 = _mobEnt.getTarget();
                           } else {
                              var64 = null;
                           }

                           z_pos = ((Entity)var64).getZ();
                        } else {
                           x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                           y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                           z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().putBoolean("canFly", true);
            GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 1.0F, 0.75F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") < 30.0) {
            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, entity.getPersistentData().getDouble("y_power") * 0.75, entity.getPersistentData().getDouble("z_power") * 0.75));
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(2.0 * entity_size), 0.4 * (double)entity.getBbWidth(), 0.4 * (double)entity.getBbHeight(), 0.4 * (double)entity.getBbWidth(), 0.1);
         }

         RotateEntityProcedure.execute(entity.getX() + entity.getDeltaMovement().x() * 100.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getDeltaMovement().y() * 100.0, entity.getZ() + entity.getDeltaMovement().z() * 100.0, entity);
         entity.getPersistentData().putDouble("Damage", 12.0);
         entity.getPersistentData().putDouble("Range", (double)(2.0F + entity.getBbHeight()));
         entity.getPersistentData().putDouble("knockback", 0.5 + Math.random());
         entity.getPersistentData().putDouble("effect", 9.0);
         entity.getPersistentData().putBoolean("swing", true);
         entity.getPersistentData().putBoolean("attack", true);
         RangeAttackProcedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 40.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
