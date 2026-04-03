package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
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

public class AISlashProcedure {
   public AISlashProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double num1;
         double var10000;
         label226: {
            Entity entity_a = null;
            boolean logic_attack = false;
            boolean skull = false;
            boolean flame = false;
            boolean granite = false;
            boolean energy_wave = false;
            logic_a = false;
            boolean vertical = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double dis = 0.0;
            double z_power = 0.0;
            double y_power = 0.0;
            double x_power = 0.0;
            double speed = 0.0;
            double CNT6 = 0.0;
            double speed2 = 0.0;
            double range_fix = 0.0;
            double distance = 0.0;
            double d = 0.0;
            double range2 = 0.0;
            double z_center = 0.0;
            double range = 0.0;
            double y_center = 0.0;
            double yaw = 0.0;
            double x_center = 0.0;
            num1 = 0.0;
            double pitch = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity0 = (LivingEntity)entity;
               if (_livingEntity0.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity0.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                  break label226;
               }
            }

            var10000 = 0.0;
         }

         if (var10000 < entity.getPersistentData().getDouble("size") && entity instanceof LivingEntity) {
            LivingEntity _livingEntity4 = (LivingEntity)entity;
            if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               AttributeInstance var93;
               label217: {
                  var93 = _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entity;
                     if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity2.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label217;
                     }
                  }

                  var10001 = 0.0;
               }

               var93.setBaseValue(Math.min(var10001 + 0.5, entity.getPersistentData().getDouble("size")));
            }
         }

         double var59 = entity.getX();
         double var60 = entity.getY();
         double var61 = entity.getZ();
         double var66 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         double var72 = ReturnEntitySizeProcedure.execute(entity);
         double var69 = Math.max(1.0, Math.sqrt(var72));
         GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         boolean var58 = GetEntityAnimationProcedure.execute(entity).contains("vertical");
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         double var65;
         if (entity.getPersistentData().getBoolean("Stop")) {
            entity.getPersistentData().putBoolean("Stop", false);
            logic_a = true;
            var65 = 0.0;
         } else {
            var65 = 2.0;
         }

         for(int index0 = 0; index0 < (int)(6.0 * var72); ++index0) {
            ParticleGeneratorCircleProcedure.execute(world, 1.0, (double)entity.getXRot(), 0.0 * var72, Mth.nextDouble(RandomSource.create(), 0.5, 1.0) * var72, 4.0, entity.getX() + entity.getPersistentData().getDouble("x_power") * var72, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getPersistentData().getDouble("y_power") * var72, entity.getY() + (double)entity.getBbHeight() * 0.5, (double)entity.getYRot(), entity.getZ() + entity.getPersistentData().getDouble("z_power") * var72, entity.getZ(), "crit");
         }

         double var64 = entity.getPersistentData().getDouble("x_power") * var65;
         double var63 = entity.getPersistentData().getDouble("y_power") * var65;
         double var62 = entity.getPersistentData().getDouble("z_power") * var65;
         entity.setDeltaMovement(new Vec3(var64, var63, var62));
         double var67 = Math.sqrt(var64 * var64 + var63 * var63 + var62 * var62);
         if (var67 > 1.0) {
            var64 /= var67;
            var63 /= var67;
            var62 /= var67;
         }

         for(int index1 = 0; index1 < (int)Math.max(var67, 1.0); ++index1) {
            var59 = entity.getX();
            var60 = entity.getY();
            var61 = entity.getZ();
            ++num1;
            if (num1 > 0.0) {
               num1 = -1.5 * var72 + 1.0;
               double var75;
               double var79;
               if (var58) {
                  var75 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  var79 = Math.toRadians((double)(entity.getXRot() + 90.0F));
               } else {
                  var75 = Math.toRadians((double)(entity.getYRot() + 0.0F));
                  var79 = Math.toRadians(0.0);
               }

               var67 = -1.5 * var72;

               for(int index2 = 0; index2 < 3; ++index2) {
                  double var77 = var59 + Math.cos(var75) * Math.cos(var79) * var67;
                  double var73 = var60 + Math.sin(var79) * -1.0 * var67;
                  double var70 = var61 + Math.sin(var75) * Math.cos(var79) * var67;
                  entity.getPersistentData().putDouble("Damage", 12.0 * var66);
                  entity.getPersistentData().putDouble("Range", 4.0 * var72);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  RangeAttackProcedure.execute(world, var77, var73, var70, entity);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(var77, var73, var70);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           break;
                        }
                     }
                  }

                  var67 += 1.5 * var72;
               }
            }

            entity.teleportTo(entity.getX() + var64 * 1.0, entity.getY(), entity.getZ());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX() + var64 * 1.0, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var58)) {
               logic_a = true;
            }

            entity.teleportTo(entity.getX(), entity.getY() + var63 * 1.0, entity.getZ());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX(), entity.getY() + var63 * 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var58)) {
               entity.teleportTo(entity.getX(), entity.getY() - var63 * 1.0, entity.getZ());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() - var63 * 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
               }

               logic_a = true;
            }

            entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() + var62 * 1.0);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() + var62 * 1.0, entity.getYRot(), entity.getXRot());
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var58)) {
               logic_a = true;
            }

            if (logic_a || ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var58)) {
               double var68 = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
               double var76;
               double var80;
               if (var58) {
                  var76 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  var80 = Math.toRadians((double)(entity.getXRot() + 90.0F));
               } else {
                  var76 = Math.toRadians((double)(entity.getYRot() + 0.0F));
                  var80 = Math.toRadians(0.0);
               }

               var67 = (double)Math.round(Math.max(2.0 * var69, 1.0) * -1.0);

               for(int index3 = 0; index3 < (int)Math.round(Math.max(2.0 * var69, 1.0) * 2.0 + 1.0); ++index3) {
                  double var78 = var59 + Math.cos(var76) * Math.cos(var80) * var67;
                  double var74 = var60 + Math.sin(var80) * -1.0 * var67;
                  double var71 = var61 + Math.sin(var76) * Math.cos(var80) * var67;

                  for(int index4 = 0; index4 < (int)Math.max(Math.round(entity.getPersistentData().getDouble("cnt6") + 1.0), 1L); ++index4) {
                     entity.getPersistentData().putDouble("BlockRange", Math.max(1.0 * var69, 1.0));
                     entity.getPersistentData().putDouble("BlockDamage", 1.0 + var68 * 0.5);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var78, var74, var71, entity);
                     entity.getPersistentData().putBoolean("noEffect", true);
                  }

                  ++var67;
               }
            }

            if (entity.isInWall() && ProjectileSlashInsideWallProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, var58)) {
               logic_a = true;
            } else {
               logic_a = false;
            }
         }

         entity.getPersistentData().putBoolean("noEffect", false);
         if (logic_a || !entity.isAlive() || var65 == 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") - 1.0);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(var59, var60, var61), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(1.0 * var72), (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.0));
               } else {
                  _level.playLocalSound(var59, var60, var61, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(1.0 * var72), (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.0), false);
               }
            }

            for(int index5 = 0; index5 < (int)(8.0 * var72); ++index5) {
               ParticleGeneratorSweepingEffectProcedure.execute(world, 1.0, var58 ? 0.0 : 180.0, (double)entity.getXRot() + (var58 ? 180.0 * Mth.nextDouble(RandomSource.create(), -0.5, 0.5) : 0.0), 0.5 * var72, 2.0 * var72, 0.0, 4.0, var59, var59, var60, var60, (double)entity.getYRot(), var61, var61, "minecraft:crit");
            }
         }

         if ((entity.getPersistentData().getDouble("cnt1") > 10.0 + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0), 5.0) || entity.getPersistentData().getDouble("cnt2") > Math.max(Math.min(entity.getPersistentData().getDouble("cnt6") + 5.0, 15.0), 1.0)) && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
         }

      }
   }
}
