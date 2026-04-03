package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WombProfusionProcedure {
   public WombProfusionProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double var10000;
         int var10001;
         label129: {
            double x_center = 0.0;
            double z_center = 0.0;
            double num1 = 0.0;
            double x_pos = 0.0;
            double y_center = 0.0;
            double pitch = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double num3 = 0.0;
            double dis = 0.0;
            double num2 = 0.0;
            var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                  break label129;
               }
            }

            var10001 = 0;
         }

         double var51 = var10000 * (double)(var10001 > 0 ? 18 : 2);
         double var37 = entity.getPersistentData().getDouble("x_pos_doma");
         double var43 = entity.getPersistentData().getDouble("y_pos_doma");
         double var38 = entity.getPersistentData().getDouble("z_pos_doma");
         entity.getPersistentData().putDouble("select", 18.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               Vec3 _center = new Vec3(var37, var43, var38);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(var51 / 2.0), (e) -> true)) {
                  if (entityiterator instanceof LivingEntity && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "effect give @s blindness 2 0 true");
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 33.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
               double var49 = (double)entity.getYRot();
               double var44 = (double)entity.getXRot();
               RotateEntityProcedure.execute(var37, var43, var38, entity);
               entity.setYRot(entity.getYRot());
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               double var40 = var37;
               double var45 = var43;
               double var46 = var38;

               for(int index0 = 0; index0 < 100 && !world.getBlockState(BlockPos.containing(var40, var45 - 1.0, var46)).canOcclude(); ++index0) {
                  --var45;
                  if (var45 <= 0.0) {
                     var45 = 0.0;
                     break;
                  }
               }

               var40 = var37 - Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 6.0);
               var46 = var38 - Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 6.0);
               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WOMB_PROFUSION.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var40, var45, var46), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                     }

                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(0.0F);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("y_pos_doma", var45 + 1.0);
               entity.setYRot((float)var49);
               entity.setXRot((float)var44);
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

            double var39 = Math.toRadians(Math.random() * 360.0);
            double var52 = entity.getPersistentData().getDouble("cnt1") * 1.0;
            double var50 = Math.toRadians(4.0);

            for(int index1 = 0; index1 < 90; ++index1) {
               double var42 = var37 + Math.sin(var39) * var52;
               double var48 = var38 + Math.cos(var39) * var52;
               if (Math.random() < 0.5 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, var42, var43, var48, 1, 0.25, Math.max(var52 / 10.0, 0.25), 0.25, 0.0);
               }

               var39 += var50;
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
