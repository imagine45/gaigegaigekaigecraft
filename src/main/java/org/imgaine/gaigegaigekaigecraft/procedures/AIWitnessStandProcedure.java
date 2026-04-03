package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class AIWitnessStandProcedure {
   public AIWitnessStandProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_target = null;
         Entity entity_owner = null;
         boolean flag_kill = false;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         entity_owner = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         entity_target = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET"));
         flag_kill = true;
         if (entity.isAlive()) {
            if (entity_target instanceof LivingEntity) {
               flag_kill = false;
               if (entity_owner instanceof LivingEntity && entity_owner instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity_owner;
                  if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity_owner.getPersistentData().getBoolean("Failed")) {
                     flag_kill = false;
                     if (!(entity_target instanceof Player)) {
                        entity_target.getPersistentData().putDouble("cnt_x", 0.0);
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                           }
                        }

                        entity_target.setYRot(entity.getYRot());
                        entity_target.setXRot(entity.getXRot());
                        entity_target.setYBodyRot(entity_target.getYRot());
                        entity_target.setYHeadRot(entity_target.getYRot());
                        entity_target.yRotO = entity_target.getYRot();
                        entity_target.xRotO = entity_target.getXRot();
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        entity_target.teleportTo(entity.getX(), entity.getY(), entity.getZ());
                        if (entity_target instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                           _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), entity_target.getYRot(), entity_target.getXRot());
                        }
                     } else {
                        x_power = entity.getX() - entity_target.getX();
                        y_power = entity.getY() - entity_target.getY();
                        z_power = entity.getZ() - entity_target.getZ();
                        if (x_power * x_power + z_power * z_power > (double)((entity_target.getBbWidth() + 0.0F) * (entity_target.getBbWidth() + 0.0F)) || y_power * y_power > (double)(entity_target.getBbWidth() * 8.0F * entity_target.getBbWidth() * 8.0F)) {
                           entity_target.teleportTo(entity.getX(), entity.getY(), entity.getZ());
                           if (entity_target instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                              _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), entity_target.getYRot(), entity_target.getXRot());
                           }
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 20, 0, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20, 1, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 20, 1, false, false));
                        }
                     }

                     if (entity_target.getPersistentData().getDouble("skill") > 0.0 && entity_target.getPersistentData().getDouble("skill") != 2719.0 && entity_target.getPersistentData().getDouble("skill") != 2721.0) {
                        entity_target.getPersistentData().putDouble("skill", 0.0);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity43 = (LivingEntity)entity;
                        if (_livingEntity43.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity43.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(((double)entity_target.getBbWidth() + 1.5) * 0.5);
                        }
                     }
                  }
               }
            }

            if (entity_owner instanceof LivingEntity) {
               label91: {
                  if (entity_owner instanceof LivingEntity) {
                     LivingEntity _livEnt45 = (LivingEntity)entity_owner;
                     if (_livEnt45.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label91;
                     }
                  }

                  flag_kill = true;
               }
            } else {
               flag_kill = true;
            }
         }

         if (flag_kill && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
