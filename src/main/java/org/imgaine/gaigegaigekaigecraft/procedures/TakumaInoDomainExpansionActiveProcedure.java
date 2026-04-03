package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class TakumaInoDomainExpansionActiveProcedure {
   public TakumaInoDomainExpansionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label72: {
            double old_skill = 0.0;
            double size = 0.0;
            double ticks = 0.0;
            double HP = 0.0;
            double num1 = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label72;
               }
            }

            var10000 = 0.0;
         }

         double var29 = var10000;
         if (!entity.getPersistentData().getBoolean("Failed") && var29 % 60.0 == 20.0) {
            int var10001;
            label64: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label64;
                  }
               }

               var10001 = 0;
            }

            double var30 = (double)(40 + var10001 * 4);
            double var27 = entity.getPersistentData().getDouble("skill");
            double var33 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
            entity.getPersistentData().putDouble("skill", 4005.0);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 75.0);

            for(int index0 = 0; index0 < 2; ++index0) {
               if (Math.random() < 0.5) {
                  double var31 = Math.toRadians(Math.random() * 360.0);
                  double var34 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(var31) * (range / 2.0 - 4.0);
                  double var35 = entity.getPersistentData().getDouble("y_pos_doma");
                  double var36 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(var31) * (range / 2.0 - 4.0);
                  double var28 = 0.5 + Math.random();
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.KAICHI.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var34, var35, var36), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

                        entityinstance.setYRot((float)Math.toDegrees(var31));
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

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity16 = (LivingEntity)entityinstance;
                           if (_livingEntity16.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity16.getAttribute(Attributes.MAX_HEALTH).setBaseValue(var30);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)var30);
                        }

                        entityinstance.getPersistentData().putDouble("cnt3", 1.0);
                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("skill", var27);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", var33);
         }

      }
   }
}
