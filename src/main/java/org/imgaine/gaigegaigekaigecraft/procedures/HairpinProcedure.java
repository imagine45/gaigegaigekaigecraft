package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HairpinProcedure {
   public HairpinProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         Entity entity_a = null;
         boolean SUCCESS = false;
         boolean player = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         double CNT6 = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.OFF_HAND, true);
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 5.0) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(32.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.getPersistentData().getDouble("Nail") > 0.0) {
                  double var55;
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var55 = _projEnt.getDeltaMovement().length();
                  } else {
                     var55 = 0.0;
                  }

                  if (var55 > 0.0) {
                     SUCCESS = true;
                     x_pos = entityiterator.getX();
                     y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight();
                     z_pos = entityiterator.getZ();
                     x_power = entityiterator.getLookAngle().x;
                     y_power = entityiterator.getLookAngle().y;
                     z_power = entityiterator.getLookAngle().z;
                     CNT6 = 1.0;
                     if (!entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                     }
                     break;
                  }

                  if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     SUCCESS = true;
                     x_pos = entityiterator.getX();
                     y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight();
                     z_pos = entityiterator.getZ();
                     x_power = (Math.random() - 0.5) * 2.0;
                     y_power = (Math.random() - 0.5) * 2.0;
                     z_power = (Math.random() - 0.5) * 2.0;
                     CNT6 = Math.sqrt(entityiterator.getPersistentData().getDouble("Nail"));
                     entityiterator.getPersistentData().putDouble("Nail", 0.0);
                     break;
                  }
               }
            }

            if (SUCCESS) {
               range = 1.0 * CNT6;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)range, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)(10.0 * CNT6), 0.25 * range, 0.25 * range, 0.25 * range, 1.0 * range);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y_pos, z_pos, (int)(5.0 * CNT6), 0.25 * range, 0.25 * range, 0.25 * range, 1.0 * range);
               }

               x_pos -= x_power * 0.25 * 16.0 * range;
               y_pos -= y_power * 0.25 * 16.0 * range;
               z_pos -= z_power * 0.25 * 16.0 * range;

               for(int index0 = 0; index0 < (int)(32.0 * range); ++index0) {
                  ++NUM1;
                  if (NUM1 > 0.0) {
                     entity.getPersistentData().putDouble("Damage", 13.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 3.0 * CNT6);
                     entity.getPersistentData().putDouble("effect", 1.0);
                     entity.getPersistentData().putDouble("effectConfirm", 2.0);
                     entity.getPersistentData().putBoolean("ignore", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().putDouble("BlockRange", 1.0 * CNT6);
                     entity.getPersistentData().putDouble("BlockDamage", 2.0 * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     NUM1 = -4.0;
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)(1.0 + CNT6), 0.1 * range, 0.1 * range, 0.1 * range, 0.0);
                  }

                  x_pos += x_power * 0.25;
                  y_pos += y_power * 0.25;
                  z_pos += z_power * 0.25;
               }
            } else {
               entity.getPersistentData().putDouble("skill", 0.0);
               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
