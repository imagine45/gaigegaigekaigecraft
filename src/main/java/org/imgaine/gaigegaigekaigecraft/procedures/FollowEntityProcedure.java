package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class FollowEntityProcedure {
   public FollowEntityProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double distance_cap = 0.0;
         boolean logic_a = false;
         boolean despawn_flag = false;
         Entity entity_a = null;
         if (entity.getPersistentData().getBoolean("Ambush")) {
            if (!(entity instanceof RabbitEscapeEntity)) {
               entity.getPersistentData().putDouble("cnt_follow", entity.getPersistentData().getDouble("cnt_follow") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_follow") > 5.0) {
                  entity.getPersistentData().putDouble("cnt_follow", -25.0);
                  if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                     logic_a = false;
                     if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                        if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                           logic_a = true;
                           if (!entity.getPersistentData().getBoolean("domain_entity")) {
                              NUM1 = Math.sqrt(Math.pow(entity_a.getX() - entity.getX(), 2.0) + Math.pow(entity_a.getY() - entity.getY(), 2.0) + Math.pow(entity_a.getZ() - entity.getZ(), 2.0));
                              distance_cap = 16.0;
                              if (!(entity instanceof NueEntity) && !entity.onGround()) {
                                 distance_cap = 48.0;
                              }

                              LivingEntity var10000;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                                 distance_cap = 64.0;
                              }

                              if (NUM1 > distance_cap) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(10.0F * entity.getBbHeight() * entity.getBbWidth() * entity.getBbWidth()), 0.2 * (double)entity.getBbWidth(), 0.2 * (double)entity.getBbHeight(), 0.2 * (double)entity.getBbWidth(), 0.0);
                                 }

                                 if (!entity.level().isClientSide() && entity.getServer() != null) {
                                    Commands var20 = entity.getServer().getCommands();
                                    CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                                    double var10002 = entity_a.getX();
                                    var20.performPrefixedCommand(var10001, "spreadplayers " + var10002 + " " + entity_a.getZ() + " 4 8 false @s");
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(10.0F * entity.getBbHeight() * entity.getBbWidth() * entity.getBbWidth()), 0.2 * (double)entity.getBbWidth(), 0.2 * (double)entity.getBbHeight(), 0.2 * (double)entity.getBbWidth(), 0.0);
                                 }
                              }
                           } else {
                              label141: {
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt48 = (LivingEntity)entity_a;
                                    if (_livEnt48.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label141;
                                    }
                                 }

                                 despawn_flag = true;
                              }
                           }
                        }
                     } else {
                        entity.getPersistentData().putBoolean("flag_despawn", true);
                     }

                     if (entity.getPersistentData().getBoolean("domain_entity") && (!logic_a || despawn_flag)) {
                        entity.getPersistentData().putBoolean("flag_despawn", true);
                     }
                  }
               }
            } else if (entity.getPersistentData().getDouble("friend_num") != 0.0 && !LogicOwnerExistProcedure.execute(world, entity)) {
               entity.getPersistentData().putBoolean("flag_despawn", true);
            }
         } else {
            LivingEntity var21;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var21 = _mobEnt.getTarget();
            } else {
               var21 = null;
            }

            if (var21 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 200.0) {
               double var22 = entity.getPersistentData().getDouble("friend_num2");
               LivingEntity var23;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var23 = _mobEnt.getTarget();
               } else {
                  var23 = null;
               }

               if (var22 != ((Entity)var23).getPersistentData().getDouble("friend_num")) {
                  entity.getPersistentData().putBoolean("failed_adjustment", true);
               }
            }
         }

         if (!entity.getPersistentData().getBoolean("Ambush")) {
            if (entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               entity.getPersistentData().putDouble("cnt_noTarget", 0.0);
            } else {
               entity.getPersistentData().putDouble("cnt_noTarget", entity.getPersistentData().getDouble("cnt_noTarget") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_noTarget") > 220.0) {
                  entity.getPersistentData().putBoolean("flag_despawn", true);
                  entity.getPersistentData().putDouble("Ambush_Number", 0.0);
               }
            }
         } else if (!LogicOwnerExistProcedure.execute(world, entity)) {
            entity.getPersistentData().putBoolean("flag_despawn", true);
         } else if (!GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")).isAlive()) {
            entity.getPersistentData().putBoolean("flag_despawn", true);
         }

         if (entity.getPersistentData().getBoolean("flag_despawn")) {
            if (entity.getPersistentData().getBoolean("Ambush")) {
               entity.getPersistentData().putBoolean("Ambush", false);
               entity.getPersistentData().putDouble("Ambush_Number", 1.0);
            }

            entity.getPersistentData().putBoolean("Despawn", true);
            DieTenShadowsTechniqueProcedure.execute(world, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(10.0F * entity.getBbHeight() * entity.getBbWidth() * entity.getBbWidth()), 0.2 * (double)entity.getBbWidth(), 0.2 * (double)entity.getBbHeight(), 0.2 * (double)entity.getBbWidth(), 0.0);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
