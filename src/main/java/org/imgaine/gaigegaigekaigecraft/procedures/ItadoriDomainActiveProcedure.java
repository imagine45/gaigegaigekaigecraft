package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class ItadoriDomainActiveProcedure {
   public ItadoriDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label61: {
            double old_skill = 0.0;
            double ticks = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double num1 = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label61;
               }
            }

            var10000 = 0.0;
         }

         double var24 = var10000;
         if (var24 % 20.0 <= 5.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
            entity.getPersistentData().putBoolean("StartDomainAttack", false);
            double var23 = entity.getPersistentData().getDouble("skill");
            double var26 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 60.0);
            entity.getPersistentData().putDouble("skill", 2108.0);
            entity.getPersistentData().putDouble("Damage", 15.0 + var24 % 20.0);
            entity.getPersistentData().putDouble("Range", range);
            entity.getPersistentData().putDouble("effect", 4.0);
            entity.getPersistentData().putBoolean("swing", false);
            entity.getPersistentData().putBoolean("attack", false);
            entity.getPersistentData().putBoolean("DomainAttack", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
            entity.getPersistentData().putDouble("skill", var23);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", var26);
         }

         if (!entity.getPersistentData().getBoolean("Failed")) {
            int var32;
            label49: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var32 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label49;
                  }
               }

               var32 = 0;
            }

            if (var32 % 90 == 20) {
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  if (Math.random() < 0.5) {
                     double var27 = Math.toRadians(Math.random() * 360.0);
                     double var28 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(var27) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                     double var29 = entity.getPersistentData().getDouble("y_pos_doma") + Math.random() * 0.5;
                     double var30 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(var27) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.CROW.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var28, var29, var30), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           if (entityinstance instanceof CrowEntity) {
                              CrowEntity _datEntSetL = (CrowEntity)entityinstance;
                              _datEntSetL.getEntityData().set(CrowEntity.DATA_object, true);
                           }

                           entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
