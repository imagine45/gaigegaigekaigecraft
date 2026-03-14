package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEntityJacobsLadderProcedure {
   public AIEntityJacobsLadderProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         double CNT6 = 0.0;
         double distance = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_pos_center = 0.0;
         double HP = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            logic_attack = false;
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
               if (entity_a.getPersistentData().m_128459_("skill") > 0.0 && entity_a.getPersistentData().m_128459_("cnt1") <= 10.0) {
                  logic_attack = true;
                  entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), entity_a.getPersistentData().m_128459_("cnt6")));
                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123747_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 10, (double)entity.m_20205_() * 0.1, 0.0, (double)entity.m_20205_() * 0.1, 0.0);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entity;
                     if (_livingEntity22.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        AttributeInstance var10000;
                        double var10001;
                        label174: {
                           var10000 = _livingEntity22.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity20 = (LivingEntity)entity;
                              if (_livingEntity20.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity20.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                 break label174;
                              }
                           }

                           var10001 = 0.0;
                        }

                        var10000.m_22100_(Math.max(var10001, entity.getPersistentData().m_128459_("cnt6") + 1.0));
                     }
                  }

                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  x_pos = entity.m_20185_() + Math.min(Math.abs(entity_a.getPersistentData().m_128459_("x_pos") - entity.m_20185_()), 0.25) * (double)(entity_a.getPersistentData().m_128459_("x_pos") > entity.m_20185_() ? 1 : -1);
                  y_pos = entity.m_20186_() + Math.min(Math.abs(entity_a.getPersistentData().m_128459_("y_pos") + 16.0 + 8.0 * CNT6 - entity.m_20186_()), 0.25) * (double)(entity_a.getPersistentData().m_128459_("y_pos") + 16.0 + 8.0 * CNT6 > entity.m_20186_() ? 1 : -1);
                  z_pos = entity.m_20189_() + Math.min(Math.abs(entity_a.getPersistentData().m_128459_("z_pos") - entity.m_20189_()), 0.25) * (double)(entity_a.getPersistentData().m_128459_("z_pos") > entity.m_20189_() ? 1 : -1);
                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            if (!logic_attack) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
               if (entity.m_20185_() != x_pos || entity.m_20186_() != y_pos || entity.m_20189_() != z_pos) {
                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() + 16.0 + 8.0 * CNT6, entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + 16.0 + 8.0 * CNT6, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            range = (double)entity.m_20205_() * 0.5;
            if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123747_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 5, 1.0, 1.0, 1.0, 0.0);
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= 7.0) {
                  for(int index0 = 0; index0 < 128 && world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)); ++index0) {
                     --y_pos;
                  }

                  y_pos_center = y_pos;

                  for(int index1 = 0; index1 < 128; ++index1) {
                     num1 = Math.toRadians(Math.random() * 720.0);
                     distance = (Math.random() - 0.5) * 32.0 * CNT6;
                     x_pos = entity.m_20185_() + Math.sin(num1) * distance;
                     z_pos = entity.m_20189_() + Math.cos(num1) * distance;
                     y_pos = y_pos_center + Math.random() * (entity.m_20186_() - y_pos_center);
                     if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_JACOBS_LADDER_ANGEL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              entityinstance.m_146922_((float)Math.toDegrees(num1));
                              entityinstance.m_146926_(0.0F);
                              entityinstance.m_5618_(entityinstance.m_146908_());
                              entityinstance.m_5616_(entityinstance.m_146908_());
                              entityinstance.f_19859_ = entityinstance.m_146908_();
                              entityinstance.f_19860_ = entityinstance.m_146909_();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.f_20884_ = _entity.m_146908_();
                                 _entity.f_20886_ = _entity.m_146908_();
                              }

                              entityinstance.getPersistentData().m_128347_("Damage", 1.0);
                              if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                                 entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123810_, x_pos, y_pos, z_pos, 15, 0.25, 0.25, 0.25, 0.1);
                        }
                        break;
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt2") < 40.0) {
                  if (entity.getPersistentData().m_128459_("cnt2") <= Math.min(1.0 + entity.getPersistentData().m_128459_("cnt6"), 5.0)) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F);
                        } else {
                           _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F);
                        } else {
                           _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F, false);
                        }
                     }
                  }

                  range = 1.0 * CNT6;
                  logic_attack = false;

                  for(int index2 = 0; index2 < 32; ++index2) {
                     if (logic_attack) {
                        entity.getPersistentData().m_128347_("Damage", 25.0 * CNT6);
                        entity.getPersistentData().m_128347_("Range", 16.0 * CNT6);
                        entity.getPersistentData().m_128347_("knockback", 0.25);
                        entity.getPersistentData().m_128347_("effectConfirm", 4.0);
                        entity.getPersistentData().m_128379_("ignore", true);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flash ~ ~ ~ " + range * 0.5 + " " + range * 0.5 + " " + range * 0.5 + " " + (0.25 + 0.1 * CNT6) + " " + Math.round(40.0 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.5)) + " force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle end_rod ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " " + (0.25 + 0.1 * CNT6) + " " + Math.round(15.0 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.5)) + " force");
                     }

                     y_pos -= 2.0;
                     logic_attack = !logic_attack;
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") > 60.0 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
