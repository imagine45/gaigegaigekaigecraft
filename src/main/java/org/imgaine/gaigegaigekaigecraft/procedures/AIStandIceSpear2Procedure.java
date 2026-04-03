package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIStandIceSpear2Procedure {
   public AIStandIceSpear2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean skull = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double size = 0.0;
         double x_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            logic_attack = false;
            entity.getPersistentData().putBoolean("Stop", false);
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && !skull && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.getPersistentData().getDouble("skill") > 0.0) {
                  logic_attack = true;
                  entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.lookAt(Anchor.EYES, new Vec3((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(16.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(16.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(16.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ()));
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

                  entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }

                  entity.getPersistentData().putDouble("cnt6", entity_a.getPersistentData().getDouble("cnt6"));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity34 = (LivingEntity)entity;
                     if (_livingEntity34.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity34.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0 + entity_a.getPersistentData().getDouble("cnt6") * 0.1);
                     }
                  }

                  if (!entity.isAlive()) {
                     entity_a.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            }

            if (!logic_attack || !entity.isAlive()) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            entity.getPersistentData().putDouble("Damage", 6.0);
            entity.getPersistentData().putDouble("Range", 3.0 * size);
            entity.getPersistentData().putDouble("Range", 2.0 * size);
            entity.getPersistentData().putDouble("knockback", 0.25);
            entity.getPersistentData().putDouble("effect", 1.0);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 1, 0.25, 0.25, 0.25, 0.1);
            }

            if (entity.getPersistentData().getBoolean("Stop")) {
               entity.getPersistentData().putBoolean("Stop", true);
            } else {
               x_power = entity.getPersistentData().getDouble("x_power") * 1.5;
               y_power = entity.getPersistentData().getDouble("y_power") * 1.5;
               z_power = entity.getPersistentData().getDouble("z_power") * 1.5;
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > 1.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               } else {
                  dis = 1.0;
               }

               for(int index0 = 0; index0 < (int)dis; ++index0) {
                  if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                     entity.getPersistentData().putDouble("Damage", 9.0);
                  } else {
                     entity.getPersistentData().putDouble("Damage", 15.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.15));
                  }

                  entity.getPersistentData().putDouble("Range", 3.0 * size);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  if (entity.isInWall()) {
                     entity.getPersistentData().putDouble("BlockRange", 2.0 * size);
                     entity.getPersistentData().putDouble("BlockDamage", 4.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.15));
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  } else {
                     entity.teleportTo(entity.getX() + x_power * 1.0, entity.getY() + y_power * 1.0, entity.getZ() + z_power * 1.0);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power * 1.0, entity.getY() + y_power * 1.0, entity.getZ() + z_power * 1.0, entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 40.0 || entity.getPersistentData().getDouble("cnt2") > 10.0) {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 9999.0F);
            }
         }

      }
   }
}
