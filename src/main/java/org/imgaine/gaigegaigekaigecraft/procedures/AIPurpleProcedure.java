package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPurpleProcedure {
   public AIPurpleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean big = false;
         boolean logic_attack = false;
         double damage = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double power = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         big = entity.getPersistentData().m_128471_("explode");
         power = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (big) {
            range *= 1.5;
            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
            }
         }

         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
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
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     logic_attack = true;
                     yaw = Math.toRadians((double)(entity_a.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity_a.m_146909_());
                     dis = 1.5 + (double)entity_a.m_20205_();
                     entity.m_6021_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5 + Math.sin(pitch) * -1.0 * dis, entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5 + Math.sin(pitch) * -1.0 * dis, entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis, entity.m_146908_(), entity.m_146909_());
                     }

                     entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                     entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                     entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                     entity.getPersistentData().m_128347_("cnt3", 1.0);
                  }
               }

               if (Math.random() < 0.05 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float)(0.5 + Math.random()));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float)(0.5 + Math.random()), false);
                  }
               }

               if (!logic_attack || !entity.m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               } else {
                  BulletDomainHit2Procedure.execute(world, entity);
                  if (big) {
                     double var10000;
                     label172: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity32 = (LivingEntity)entity;
                           if (_livingEntity32.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var10000 = _livingEntity32.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                              break label172;
                           }
                        }

                        var10000 = 0.0;
                     }

                     if (var10000 < 400.0 && entity instanceof LivingEntity) {
                        LivingEntity _livingEntity34 = (LivingEntity)entity;
                        if (_livingEntity34.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           double var10001;
                           label163: {
                              var64 = _livingEntity34.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity33 = (LivingEntity)entity;
                                 if (_livingEntity33.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    var10001 = _livingEntity33.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                    break label163;
                                 }
                              }

                              var10001 = 0.0;
                           }

                           var64.m_22100_(Math.min(var10001 + 15.0, 400.0));
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") == 10.0 && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") % 4.0 == 1.0 && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float)(1.0 + Math.random()));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float)(1.0 + Math.random()), false);
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(5.0 * range), range, range, range, range);
                  }

                  x_power = entity.getPersistentData().m_128459_("x_power") * 2.0;
                  y_power = entity.getPersistentData().m_128459_("y_power") * 2.0;
                  z_power = entity.getPersistentData().m_128459_("z_power") * 2.0;
                  dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                  if (dis > 0.0) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  }

                  damage = Math.max(80.0 * Math.pow(0.99, entity.getPersistentData().m_128459_("cnt_life")), 55.0) * power;

                  for(int index0 = 0; index0 < (int)Math.round(Math.max(dis, 1.0)); ++index0) {
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();
                     if (!big && entity.getPersistentData().m_128459_("cnt1") >= 12.0) {
                        if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_) && world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, (float)(2.0 * range), ExplosionInteraction.MOB);
                              }
                           }
                        } else if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }

                     if (!big || entity.getPersistentData().m_128459_("cnt1") <= 30.0) {
                        entity.getPersistentData().m_128347_("Damage", damage);
                        entity.getPersistentData().m_128347_("Range", 8.0 * range);
                        entity.getPersistentData().m_128347_("knockback", big ? 1.0 : 0.1);
                        entity.getPersistentData().m_128347_("effectConfirm", 2.0);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!big || entity.getPersistentData().m_128459_("cnt1") % 4.0 == 1.0) {
                        entity.getPersistentData().m_128347_("BlockRange", 3.0 * range);
                        entity.getPersistentData().m_128347_("BlockDamage", 18.0 * power);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, (int)(5.0 * range), range, range, range, range);
                     }

                     if (big) {
                        break;
                     }

                     if (entity.getPersistentData().m_128471_("Stop")) {
                        entity.getPersistentData().m_128379_("Stop", false);
                        break;
                     }

                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  if (big) {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  } else {
                     entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.0, entity.getPersistentData().m_128459_("y_power") * 1.0, entity.getPersistentData().m_128459_("z_power") * 1.0));
                  }

                  entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)(big ? 80 : 30) && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         }

      }
   }
}
