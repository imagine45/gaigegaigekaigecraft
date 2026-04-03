package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIProjectileSlashProcedure {
   public AIProjectileSlashProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double num1;
         double var10000;
         label245: {
            logic_a = false;
            boolean vertical = false;
            Entity entity_a = null;
            double distance = 0.0;
            double d = 0.0;
            double range2 = 0.0;
            double z_center = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double y_center = 0.0;
            double speed = 0.0;
            double yaw = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_center = 0.0;
            double x_power = 0.0;
            num1 = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity0 = (LivingEntity)entity;
               if (_livingEntity0.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity0.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                  break label245;
               }
            }

            var10000 = 0.0;
         }

         if (var10000 < entity.getPersistentData().getDouble("size") && entity instanceof LivingEntity) {
            LivingEntity _livingEntity4 = (LivingEntity)entity;
            if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               AttributeInstance var85;
               label236: {
                  var85 = _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entity;
                     if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity2.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label236;
                     }
                  }

                  var10001 = 0.0;
               }

               var85.setBaseValue(Math.min(var10001 + 0.5, entity.getPersistentData().getDouble("size")));
            }
         }

         boolean var47;
         double var50;
         double var53;
         double var54;
         double var55;
         double var58;
         double var61;
         double var67;
         label231: {
            var54 = entity.getX();
            var67 = entity.getY();
            var55 = entity.getZ();
            var61 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            var53 = ReturnEntitySizeProcedure.execute(entity);
            var50 = Math.max(1.0, Math.sqrt(var53));
            GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            var47 = GetEntityAnimationProcedure.execute(entity).contains("vertical");
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getBoolean("Stop")) {
               int var86;
               if (entity instanceof ProjectileSlashEntity) {
                  ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                  var86 = (Integer)_datEntI.getEntityData().get(ProjectileSlashEntity.DATA_mode);
               } else {
                  var86 = 0;
               }

               if (var86 != 1) {
                  entity.getPersistentData().putBoolean("Stop", false);
                  logic_a = true;
                  var58 = 0.0;
                  break label231;
               }
            }

            var58 = 2.0;
         }

         double var66 = entity.getPersistentData().getDouble("x_power") * var58;
         double var62 = entity.getPersistentData().getDouble("y_power") * var58;
         double var63 = entity.getPersistentData().getDouble("z_power") * var58;
         entity.setDeltaMovement(new Vec3(var66, var62, var63));
         double var48 = Math.sqrt(var66 * var66 + var62 * var62 + var63 * var63);
         if (var48 > 1.0) {
            var66 /= var48;
            var62 /= var48;
            var63 /= var48;
         }

         for(int index0 = 0; index0 < (int)Math.max(var48, 1.0); ++index0) {
            var54 = entity.getX();
            var67 = entity.getY();
            var55 = entity.getZ();
            ++num1;
            if (num1 > 0.0) {
               num1 = -1.5 * var53 + 1.0;
               double var59;
               double var68;
               if (var47) {
                  var59 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  var68 = Math.toRadians((double)(entity.getXRot() + 90.0F));
               } else {
                  var59 = Math.toRadians((double)(entity.getYRot() + 0.0F));
                  var68 = Math.toRadians(0.0);
               }

               var48 = -3.0 * var53;

               for(int index1 = 0; index1 < 5; ++index1) {
                  double var64 = var54 + Math.cos(var59) * Math.cos(var68) * var48;
                  double var56 = var67 + Math.sin(var68) * -1.0 * var48;
                  double var51 = var55 + Math.sin(var59) * Math.cos(var68) * var48;
                  entity.getPersistentData().putDouble("Damage", 15.0 * var61);
                  entity.getPersistentData().putDouble("Range", 3.0 * var53);
                  entity.getPersistentData().putDouble("effect", 4.0);
                  int var87;
                  if (entity instanceof ProjectileSlashEntity) {
                     ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                     var87 = (Integer)_datEntI.getEntityData().get(ProjectileSlashEntity.DATA_mode);
                  } else {
                     var87 = 0;
                  }

                  if (var87 == 1) {
                     entity.getPersistentData().putBoolean("ignore", true);
                     entity.getPersistentData().putDouble("effectConfirm", 3.0);
                     entity.getPersistentData().putDouble("knockback", 0.5);
                  } else {
                     entity.getPersistentData().putDouble("knockback", 1.0 * var61 * Math.pow(0.95, entity.getPersistentData().getDouble("cnt_life")));
                  }

                  RangeAttackProcedure.execute(world, var64, var56, var51, entity);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(var64, var56, var51);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           break;
                        }
                     }
                  }

                  var48 += 1.5 * var53;
               }
            }

            entity.teleportTo(entity.getX() + var66 * 1.0, entity.getY(), entity.getZ());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX() + var66 * 1.0, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var47)) {
               logic_a = true;
            }

            entity.teleportTo(entity.getX(), entity.getY() + var62 * 1.0, entity.getZ());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX(), entity.getY() + var62 * 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var47)) {
               entity.teleportTo(entity.getX(), entity.getY() - var62 * 1.0, entity.getZ());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() - var62 * 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
               }

               logic_a = true;
            }

            entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() + var63 * 1.0);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() + var63 * 1.0, entity.getYRot(), entity.getXRot());
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var47)) {
               logic_a = true;
            }

            if (logic_a || ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var47)) {
               double var49 = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
               double var60;
               double var69;
               if (var47) {
                  var60 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  var69 = Math.toRadians((double)(entity.getXRot() + 90.0F));
               } else {
                  var60 = Math.toRadians((double)(entity.getYRot() + 0.0F));
                  var69 = Math.toRadians(0.0);
               }

               var48 = (double)Math.round(Math.max(4.0 * var50, 1.0) * -2.0);

               for(int index2 = 0; index2 < (int)Math.round(Math.max(4.0 * var50, 1.0) * 4.0 + 1.0); ++index2) {
                  double var65 = var54 + Math.cos(var60) * Math.cos(var69) * var48;
                  double var57 = var67 + Math.sin(var69) * -1.0 * var48;
                  double var52 = var55 + Math.sin(var60) * Math.cos(var69) * var48;

                  for(int index3 = 0; index3 < (int)Math.max(Math.round(entity.getPersistentData().getDouble("cnt6") + 1.0), 1L); ++index3) {
                     entity.getPersistentData().putDouble("BlockRange", Math.max(1.0 * var50, 1.0));
                     entity.getPersistentData().putDouble("BlockDamage", 1.0 + var49 * 0.5);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var65, var57, var52, entity);
                     entity.getPersistentData().putBoolean("noEffect", true);
                  }

                  ++var48;
               }
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var47)) {
               logic_a = true;
               int var88;
               if (entity instanceof ProjectileSlashEntity) {
                  ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                  var88 = (Integer)_datEntI.getEntityData().get(ProjectileSlashEntity.DATA_mode);
               } else {
                  var88 = 0;
               }

               if (var88 != 1) {
                  break;
               }
            } else {
               logic_a = false;
            }
         }

         entity.getPersistentData().putBoolean("noEffect", false);
         if (logic_a || !entity.isAlive() || var58 == 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") - 1.0);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(var54, var67, var55), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(1.0 * var53), (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.0));
               } else {
                  _level.playLocalSound(var54, var67, var55, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(1.0 * var53), (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.0), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(var54, var67, var55), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, (float)(0.5 * var53), (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
               } else {
                  _level.playLocalSound(var54, var67, var55, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, (float)(0.5 * var53), (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
               }
            }

            for(int index4 = 0; index4 < (int)(8.0 * var53); ++index4) {
               ParticleGeneratorSweepingEffectProcedure.execute(world, 1.0, var47 ? 0.0 : 180.0, (double)entity.getXRot() + (var47 ? 180.0 * Mth.nextDouble(RandomSource.create(), -0.5, 0.5) : 0.0), 0.5 * var53, 2.0 * var53, 0.0, 4.0, var54, var54, var67, var67, (double)entity.getYRot(), var55, var55, "minecraft:crit");
            }
         }

         if ((entity.getPersistentData().getDouble("cnt1") > 10.0 + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0), 5.0) || entity.getPersistentData().getDouble("cnt2") > Math.max(Math.min(entity.getPersistentData().getDouble("cnt6") + 5.0, 15.0), 1.0)) && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
         }

         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
      }
   }
}
