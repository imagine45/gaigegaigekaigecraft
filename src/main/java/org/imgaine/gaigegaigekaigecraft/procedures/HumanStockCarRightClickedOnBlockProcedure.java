package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.HumanCarEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HumanStockCarRightClickedOnBlockProcedure {
   public HumanStockCarRightClickedOnBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
      if (direction != null && entity != null) {
         double z_pos = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
               return;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt1 = (LivingEntity)entity;
            if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
               return;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt2 = (LivingEntity)entity;
            if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
               return;
            }
         }

         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 15.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15.0) {
            x_pos = x + (double)direction.getStepX();
            y_pos = y + (double)direction.getStepY();
            z_pos = z + (double)direction.getStepZ();
            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.HUMAN_CAR.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(entity.getYRot());
                  entityToSpawn.setYBodyRot(entity.getYRot());
                  entityToSpawn.setYHeadRot(entity.getYRot());
                  entityToSpawn.setXRot(entity.getXRot());
               }
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
               if (entityiterator instanceof HumanCarEntity && entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
                  entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                  entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label58: {
                           var10003 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label58;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                        _entity.addEffect(var10001);
                     }
                  }

                  entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  entityiterator.getPersistentData().putBoolean("Player", entity.getPersistentData().getBoolean("Player") || entity instanceof Player);
                  break;
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getCooldowns().addCooldown(itemstack.getItem(), 3);
            }

            itemstack.shrink(1);
         }

      }
   }
}
