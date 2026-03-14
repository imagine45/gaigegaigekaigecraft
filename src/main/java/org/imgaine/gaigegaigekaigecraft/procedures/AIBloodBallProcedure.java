package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBloodBallProcedure {
   public AIBloodBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         double yaw_fix = 0.0;
         double old_skill = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         if (entity.getPersistentData().m_128471_("despawn")) {
            logic_a = false;
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
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
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.m_6084_()) {
                  logic_a = true;
                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }

                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               }

               if (entity_a.getPersistentData().m_128459_("skill") <= 0.0) {
                  logic_a = false;
               }

               if (entity_a.getPersistentData().m_128459_("cnt1") > 20.0) {
                  logic_a = false;
               }
            }

            if (!logic_a && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         } else if (entity.m_6084_()) {
            logic_a = false;
            if (entity.getPersistentData().m_128471_("explode")) {
               entity.getPersistentData().m_128347_("cnt_explode", entity.getPersistentData().m_128459_("cnt_explode") + 1.0);
               dis = 0.75 + Math.min(entity.getPersistentData().m_128459_("cnt_explode") * 0.5, 4.0);
               entity.getPersistentData().m_128347_("yaw", entity.getPersistentData().m_128459_("yaw") * 0.75);
               entity.getPersistentData().m_128347_("pitch", entity.getPersistentData().m_128459_("pitch") * 0.75);
            } else {
               dis = 0.75;
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               label130: {
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
                  if (entity_a instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0) {
                        break label130;
                     }
                  } else if (entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
                     break label130;
                  }

                  entity.getPersistentData().m_128379_("explode", true);
               }

               if (entity.getPersistentData().m_128459_("yaw") == 0.0) {
                  entity.getPersistentData().m_128347_("distance", Math.random() * 1.0);
                  entity.getPersistentData().m_128347_("yaw", 180.0 + (Math.random() - 0.5) * 180.0);
                  entity.getPersistentData().m_128347_("pitch", 0.0 + (Math.random() - 0.5) * 90.0);
               }

               dis = dis + (double)entity_a.m_20205_() * 0.5 + entity.getPersistentData().m_128459_("distance");
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.m_6084_()) {
                  logic_a = true;
                  yaw = Math.toRadians((double)(entity_a.m_146908_() + 90.0F) + entity.getPersistentData().m_128459_("yaw"));
                  pitch = Math.toRadians((double)entity_a.m_146909_() + entity.getPersistentData().m_128459_("pitch"));
                  entity.m_6021_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * dis, entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * dis, entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis, entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.getPersistentData().m_128459_("cnt_explode") < 5.0) {
                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                  } else {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  }
               }
            }

            if (!logic_a || entity.getPersistentData().m_128459_("cnt_explode") > 10.0) {
               entity.getPersistentData().m_128347_("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }
         } else {
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            entity.getPersistentData().m_128347_("cnt_die", entity.getPersistentData().m_128459_("cnt_die") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_die") < 4.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, 1.5F, 2.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, 1.5F, 2.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x, y, z, 4, 0.5, 0.5, 0.5, 2.0);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y, z, 25, 0.1, 0.1, 0.1, 2.0);
            }

            entity.getPersistentData().m_128347_("Damage", 20.0);
            entity.getPersistentData().m_128347_("Range", 8.0);
            entity.getPersistentData().m_128347_("knockback", 1.5);
            entity.getPersistentData().m_128347_("effect", 11.0);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("Damage", 17.0);
            entity.getPersistentData().m_128347_("Range", 12.0);
            entity.getPersistentData().m_128347_("knockback", 1.0);
            entity.getPersistentData().m_128347_("effect", 11.0);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("BlockRange", Math.min(entity.getPersistentData().m_128459_("cnt_die"), 6.0));
            entity.getPersistentData().m_128347_("BlockDamage", 0.3);
            BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            if (entity.getPersistentData().m_128459_("cnt_die") > 7.0 && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         if (entity.m_20071_()) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y, z, 8, 0.1, 0.1, 0.1, 0.0);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
