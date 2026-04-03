package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class HorizonOfTheCaptivatingSkandhaActiveProcedure {
   public HorizonOfTheCaptivatingSkandhaActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_skill = 0.0;
         double size = 0.0;
         double HP = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
         if (!entity.getPersistentData().getBoolean("Failed")) {
            int var10000;
            label80: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label80;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 90 == 20) {
               int var10001;
               label74: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label74;
                     }
                  }

                  var10001 = 0;
               }

               HP = (double)(20 + var10001 * 5);
               old_skill = entity.getPersistentData().getDouble("skill");
               old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
               entity.getPersistentData().putDouble("skill", 809.0);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 125.0);

               for(int index0 = 0; index0 < 8; ++index0) {
                  if (Math.random() < 0.5) {
                     num1 = Math.toRadians(Math.random() * 360.0);
                     x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range / 2.0 - 4.0);
                     y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                     z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range / 2.0 - 4.0);
                     size = 0.5 + Math.random();
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.SEA_SERPENT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                              entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                           }

                           entityinstance.setYRot((float)Math.toDegrees(num1));
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
                                 _livingEntity16.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.setHealth((float)HP);
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity20 = (LivingEntity)entityinstance;
                              if (_livingEntity20.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity20.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue((5.0 + Math.random() * 7.5) * 0.1);
                              }
                           }

                           if (entityinstance instanceof SeaSerpentEntity) {
                              SeaSerpentEntity animatable = (SeaSerpentEntity)entityinstance;
                              double var39 = Math.random();
                              animatable.setTexture("dagon_fish" + Math.round(Math.ceil(var39 * 3.0)));
                           }

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
