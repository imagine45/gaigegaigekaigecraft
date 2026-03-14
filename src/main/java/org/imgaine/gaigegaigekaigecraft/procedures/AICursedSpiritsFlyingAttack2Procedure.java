package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AICursedSpiritsFlyingAttack2Procedure {
   public AICursedSpiritsFlyingAttack2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         Entity owner_entity = null;
         boolean logic_a = false;
         boolean ownerExist = false;
         boolean teleported = false;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            ownerExist = true;
            owner_entity = (new BiFunction<LevelAccessor, String, Entity>() {
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
         }

         if (entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")) && entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("modement_mode") == 0.0) {
               if (entity.getPersistentData().m_128459_("cnt1") > 0.0) {
                  entity.getPersistentData().m_128347_("cnt1", -5.0);
                  if (ownerExist && entity.getPersistentData().m_128459_("friend_num_worker") != 0.0 && entity.getPersistentData().m_128459_("friend_num_worker") == owner_entity.getPersistentData().m_128459_("friend_num") && entity.getPersistentData().m_128459_("friend_num_worker") != owner_entity.getPersistentData().m_128459_("friend_num_worker")) {
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:1b}");
                     }

                     entity.getPersistentData().m_128347_("modement_mode", 1.0);
                     entity.getPersistentData().m_128347_("cnt1", 0.0);
                     LivingEntity var10000;
                     if (owner_entity instanceof Mob) {
                        Mob _mobEnt = (Mob)owner_entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity) {
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        double var69 = ((Entity)var10000).m_20185_();
                        LivingEntity var10001;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10001 = _mobEnt.m_5448_();
                        } else {
                           var10001 = null;
                        }

                        x_pos = var69 + (double)((Entity)var10001).m_20205_() * (Math.random() - 0.5);
                        LivingEntity var70;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var70 = _mobEnt.m_5448_();
                        } else {
                           var70 = null;
                        }

                        double var71 = ((Entity)var70).m_20186_();
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10001 = _mobEnt.m_5448_();
                        } else {
                           var10001 = null;
                        }

                        y_pos = var71 + (double)((Entity)var10001).m_20206_() * Math.random();
                        LivingEntity var72;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var72 = _mobEnt.m_5448_();
                        } else {
                           var72 = null;
                        }

                        double var73 = ((Entity)var72).m_20189_();
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10001 = _mobEnt.m_5448_();
                        } else {
                           var10001 = null;
                        }

                        z_pos = var73 + (double)((Entity)var10001).m_20205_() * (Math.random() - 0.5);
                     } else {
                        x_pos = (double)owner_entity.m_9236_().m_45547_(new ClipContext(owner_entity.m_20299_(1.0F), owner_entity.m_20299_(1.0F).m_82549_(owner_entity.m_20252_(1.0F).m_82490_(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).m_82425_().m_123341_();
                        y_pos = (double)owner_entity.m_9236_().m_45547_(new ClipContext(owner_entity.m_20299_(1.0F), owner_entity.m_20299_(1.0F).m_82549_(owner_entity.m_20252_(1.0F).m_82490_(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).m_82425_().m_123342_();
                        z_pos = (double)owner_entity.m_9236_().m_45547_(new ClipContext(owner_entity.m_20299_(1.0F), owner_entity.m_20299_(1.0F).m_82549_(owner_entity.m_20252_(1.0F).m_82490_(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).m_82425_().m_123343_();
                     }

                     x_pos += (Math.random() - 0.5) * 2.0;
                     y_pos += (Math.random() - 0.5) * 2.0;
                     z_pos += (Math.random() - 0.5) * 2.0;
                     entity.getPersistentData().m_128379_("free", true);
                     GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.m_7618_(Anchor.EYES, new Vec3(x_pos, y_pos, z_pos));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().m_128471_("Stop")) {
                        entity.getPersistentData().m_128379_("Stop", false);
                        entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_settarget", 0.0);
               if (!world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_())).m_60815_()) {
                  x_power = entity.getPersistentData().m_128459_("x_power") * 1.2;
                  y_power = entity.getPersistentData().m_128459_("y_power") * 1.2;
                  z_power = entity.getPersistentData().m_128459_("z_power") * 1.2;
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  dis *= 2.0;
                  if (dis > 1.0) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  }

                  for(int index0 = 0; index0 < (int)Math.max(Math.floor(dis), 1.0); ++index0) {
                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }

                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                     z_pos = entity.m_20189_();
                     entity.getPersistentData().m_128347_("Damage", 9.0);
                     entity.getPersistentData().m_128347_("knockback", Math.random() * 1.0);
                     entity.getPersistentData().m_128347_("Range", (double)(entity.m_20205_() * 2.0F));
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 20.0));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }
                        break;
                     }

                     if (entity.getPersistentData().m_128471_("Stop")) {
                        entity.getPersistentData().m_128379_("Stop", false);
                        entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                        break;
                     }
                  }
               } else {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= 40.0) {
                  teleported = false;
                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  entity.getPersistentData().m_128347_("cnt2", 0.0);
                  entity.getPersistentData().m_128347_("modement_mode", 0.0);
                  if (ownerExist && entity.getPersistentData().m_128459_("friend_num_worker") != 0.0 && owner_entity instanceof Player) {
                     teleported = true;
                     x_pos = 0.0;
                     y_pos = 64.0 + Math.random();
                     z_pos = 0.0;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        Commands var74 = entity.m_20194_().m_129892_();
                        CommandSourceStack var77 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        long var10002 = Math.round(x_pos);
                        var74.m_230957_(var77, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                     }

                     NUM1 = 0.0;

                     for(int index1 = 0; index1 < 10000; ++index1) {
                        ++NUM1;
                        STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                        if (owner_entity.getPersistentData().m_128461_(STR1 + "_name").equals(entity.m_5446_().getString())) {
                           y_pos = owner_entity.getPersistentData().m_128459_(STR1);
                           break;
                        }

                        if (owner_entity.getPersistentData().m_128459_(STR1) == 0.0) {
                           owner_entity.getPersistentData().m_128347_(STR1, y_pos);
                           owner_entity.getPersistentData().m_128359_(STR1 + "_name", entity.m_5446_().getString());
                           break;
                        }
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "execute in jujutsucraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                     }

                     owner_entity.getPersistentData().m_128347_(STR1 + "_num", owner_entity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
                     owner_entity.getPersistentData().m_128379_("UpdateSkills", true);
                  }

                  if (!teleported && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         }

      }
   }
}
