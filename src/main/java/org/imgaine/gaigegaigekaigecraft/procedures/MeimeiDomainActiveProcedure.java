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
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MeimeiDomainActiveProcedure {
   public MeimeiDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double num1 = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
         if (!entity.getPersistentData().getBoolean("Failed")) {
            int var10000;
            label58: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label58;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 90 == 20) {
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  if (Math.random() < 0.5) {
                     num1 = Math.toRadians(Math.random() * 360.0);
                     x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                     y_pos = entity.getPersistentData().getDouble("y_pos_doma") + Math.random() * 0.5;
                     z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.CROW.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           if (entityinstance instanceof CrowEntity) {
                              CrowEntity _datEntSetL = (CrowEntity)entityinstance;
                              _datEntSetL.getEntityData().set(CrowEntity.DATA_object, true);
                           }

                           if (entityinstance instanceof TamableAnimal) {
                              TamableAnimal _toTame = (TamableAnimal)entityinstance;
                              if (entity instanceof Player) {
                                 Player _owner = (Player)entity;
                                 _toTame.tame(_owner);
                              }
                           }

                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                           entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                           entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
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
