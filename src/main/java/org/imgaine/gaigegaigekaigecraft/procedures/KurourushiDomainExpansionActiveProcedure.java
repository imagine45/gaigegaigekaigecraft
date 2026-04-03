package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class KurourushiDomainExpansionActiveProcedure {
   public KurourushiDomainExpansionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_skill = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
         if (!entity.getPersistentData().getBoolean("Failed")) {
            int var10000;
            label40: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label40;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 45 == 20) {
               old_skill = entity.getPersistentData().getDouble("skill");
               old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
               entity.getPersistentData().putDouble("skill", 2306.0);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 100.0);

               for(int index0 = 0; index0 < 4; ++index0) {
                  if (Math.random() < 0.5) {
                     num1 = Math.toRadians(Math.random() * 360.0);
                     x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                     y_pos = entity.getPersistentData().getDouble("y_pos_doma") + Math.random() * 0.5;
                     z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.COCKROACHES.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           entityinstance.setYRot((float)(Math.toDegrees(num1) - 90.0));
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

                           entityinstance.getPersistentData().putBoolean("domain_entity", true);
                           entityinstance.lookAt(Anchor.EYES, new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma")));
                           entityinstance.getPersistentData().putDouble("x_power", entityinstance.getLookAngle().x);
                           entityinstance.getPersistentData().putDouble("y_power", entityinstance.getLookAngle().y);
                           entityinstance.getPersistentData().putDouble("z_power", entityinstance.getLookAngle().z);
                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  }
               }

               entity.getPersistentData().putDouble("skill", old_skill);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
            }
         }

      }
   }
}
