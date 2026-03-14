package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
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
         if (entity.getPersistentData().m_128471_("Ambush")) {
            if (!(entity instanceof RabbitEscapeEntity)) {
               entity.getPersistentData().m_128347_("cnt_follow", entity.getPersistentData().m_128459_("cnt_follow") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_follow") > 5.0) {
                  entity.getPersistentData().m_128347_("cnt_follow", -25.0);
                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                     logic_a = false;
                     if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                           logic_a = true;
                           if (!entity.getPersistentData().m_128471_("domain_entity")) {
                              NUM1 = Math.sqrt(Math.pow(entity_a.m_20185_() - entity.m_20185_(), 2.0) + Math.pow(entity_a.m_20186_() - entity.m_20186_(), 2.0) + Math.pow(entity_a.m_20189_() - entity.m_20189_(), 2.0));
                              distance_cap = 16.0;
                              if (!(entity instanceof NueEntity) && !entity.m_20096_()) {
                                 distance_cap = 48.0;
                              }

                              LivingEntity var10000;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
                                 distance_cap = 64.0;
                              }

                              if (NUM1 > distance_cap && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 Commands var18 = entity.m_20194_().m_129892_();
                                 CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                                 double var10002 = entity_a.m_20185_();
                                 var18.m_230957_(var10001, "spreadplayers " + var10002 + " " + entity_a.m_20189_() + " 4 8 false @s");
                              }
                           } else {
                              label132: {
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt26 = (LivingEntity)entity_a;
                                    if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label132;
                                    }
                                 }

                                 despawn_flag = true;
                              }
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128379_("flag_despawn", true);
                     }

                     if (entity.getPersistentData().m_128471_("domain_entity") && (!logic_a || despawn_flag)) {
                        entity.getPersistentData().m_128379_("flag_despawn", true);
                     }
                  }
               }
            } else if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && !LogicOwnerExistProcedure.execute(world, entity)) {
               entity.getPersistentData().m_128379_("flag_despawn", true);
            }
         } else {
            LivingEntity var19;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var19 = _mobEnt.m_5448_();
            } else {
               var19 = null;
            }

            if (var19 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 200.0) {
               double var20 = entity.getPersistentData().m_128459_("friend_num2");
               LivingEntity var21;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var21 = _mobEnt.m_5448_();
               } else {
                  var21 = null;
               }

               if (var20 != ((Entity)var21).getPersistentData().m_128459_("friend_num")) {
                  entity.getPersistentData().m_128379_("failed_adjustment", true);
               }
            }
         }

         if (!entity.getPersistentData().m_128471_("Ambush")) {
            if (entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               entity.getPersistentData().m_128347_("cnt_noTarget", 0.0);
            } else {
               entity.getPersistentData().m_128347_("cnt_noTarget", entity.getPersistentData().m_128459_("cnt_noTarget") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_noTarget") > 220.0) {
                  entity.getPersistentData().m_128379_("flag_despawn", true);
                  entity.getPersistentData().m_128347_("Ambush_Number", 0.0);
               }
            }
         } else if (!LogicOwnerExistProcedure.execute(world, entity)) {
            entity.getPersistentData().m_128379_("flag_despawn", true);
         } else if (!(new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_6084_()) {
            entity.getPersistentData().m_128379_("flag_despawn", true);
         }

         if (entity.getPersistentData().m_128471_("flag_despawn")) {
            if (entity.getPersistentData().m_128471_("Ambush")) {
               entity.getPersistentData().m_128379_("Ambush", false);
               entity.getPersistentData().m_128347_("Ambush_Number", 1.0);
            }

            entity.getPersistentData().m_128379_("Despawn", true);
            DieTenShadowsTechniqueProcedure.execute(world, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(10.0F * entity.m_20206_() * entity.m_20205_() * entity.m_20205_()), 0.2 * (double)entity.m_20205_(), 0.2 * (double)entity.m_20206_(), 0.2 * (double)entity.m_20205_(), 0.0);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
