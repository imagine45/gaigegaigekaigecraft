package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityCrackEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ThinIceBreakerProcedure {
   public ThinIceBreakerProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6;
         int var10000;
         label253: {
            boolean logic_a = false;
            boolean player = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            double strength = 0.0;
            double range = 0.0;
            double loop_num = 0.0;
            CNT6 = 0.0;
            double rad_now = 0.0;
            double num1 = 0.0;
            double num3 = 0.0;
            double soundPitch = 0.0;
            double num2 = 0.0;
            double x_center = 0.0;
            double y_center = 0.0;
            double z_center = 0.0;
            player = entity instanceof Player;
            CNT6 = 1.0 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label253;
               }
            }

            var10000 = 0;
         }

         double var62 = (double)Math.min(var10000, 50);
         double var63 = ReturnEntitySizeProcedure.execute(entity) * (1.0 + var62 * 0.025);
         entity.getPersistentData().m_128347_("cnt1", (double)Math.round(entity.getPersistentData().m_128459_("cnt1") + 1.0));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         LivingEntity var87;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var87 = _mobEnt.m_5448_();
         } else {
            var87 = null;
         }

         if (var87 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var87 = _mobEnt.m_5448_();
            } else {
               var87 = null;
            }

            double var53 = ((Entity)var87).m_20185_();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var87 = _mobEnt.m_5448_();
            } else {
               var87 = null;
            }

            double var90 = ((Entity)var87).m_20186_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var55 = var90 + (double)((Entity)var10001).m_20206_() * 0.5;
            LivingEntity var91;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var91 = _mobEnt.m_5448_();
            } else {
               var91 = null;
            }

            double var57 = ((Entity)var91).m_20189_();
            RotateEntityProcedure.execute(var53, var55, var57, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
            double var61 = GetDistanceProcedure.execute(entity);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var87 = _mobEnt.m_5448_();
            } else {
               var87 = null;
            }

            if (var87 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (var61 < 3.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var87 = _mobEnt.m_5448_();
                  } else {
                     var87 = null;
                  }

                  if (((Entity)var87).getPersistentData().m_128459_("skill") == 0.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               } else {
                  label239: {
                     if (!(entity instanceof UroTakakoEntity)) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var87 = _mobEnt.m_5448_();
                        } else {
                           var87 = null;
                        }

                        if (((Entity)var87).getPersistentData().m_128459_("skill") != 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var87 = _mobEnt.m_5448_();
                           } else {
                              var87 = null;
                           }

                           if (((Entity)var87).getPersistentData().m_128459_("Damage") != 0.0) {
                              entity.getPersistentData().m_128379_("PRESS_Z", false);
                              break label239;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") > 5.0) {
               entity.getPersistentData().m_128347_("cnt6", 5.0);
            } else if (entity.getPersistentData().m_128459_("cnt6") < 5.0) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 1.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 9.0));
            }

            label260: {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 38.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 38.0) {
                     break label260;
                  }
               } else if (!(entity instanceof UroTakakoEntity)) {
                  break label260;
               }

               label226: {
                  label225: {
                     if (entity instanceof Player) {
                        if (entity.m_6144_()) {
                           break label225;
                        }
                     } else if (var61 < 3.0) {
                        break label225;
                     }

                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 0.75);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 0.75);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 0.75);
                     break label226;
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 0.0);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 0.0);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 0.0);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power")));
               if (entity instanceof Player) {
                  label267: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt66 = (LivingEntity)entity;
                        if (_livEnt66.m_21023_(MobEffects.f_19591_)) {
                           break label267;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity67 = (LivingEntity)entity;
                        if (_livingEntity67.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity67.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-18.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 5, 0, false, false));
               }
            }

            UroCounterProcedure.execute(world, entity);
         } else {
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity74 = (LivingEntity)entity;
                  if (_livingEntity74.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity74.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-7.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var59 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var60 = Math.toRadians((double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var59) * Math.cos(var60) * (double)(2.0F + entity.m_20205_()));
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(var60) * -1.0 * (double)(2.0F + entity.m_20205_()));
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var59) * Math.cos(var60) * (double)(2.0F + entity.m_20205_()));
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRACK.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos")), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity100 = (LivingEntity)entityinstance;
                        if (_livingEntity100.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity100.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)((entity.m_20206_() + entity.m_20205_()) * 2.0F));
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     if (entity.getPersistentData().m_128459_("cnt6") >= 2.5 && entityinstance instanceof EntityCrackEntity) {
                        ((EntityCrackEntity)entityinstance).setAnimation("attack");
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            double var54 = entity.getPersistentData().m_128459_("x_pos");
            double var56 = entity.getPersistentData().m_128459_("y_pos");
            double var58 = entity.getPersistentData().m_128459_("z_pos");
            if (entity.getPersistentData().m_128459_("cnt3") <= 0.5 + entity.getPersistentData().m_128459_("cnt6") * 0.5) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var56, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 1.0F);
                  } else {
                     _level.m_7785_(var54, var56, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var56, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 2.0F);
                  } else {
                     _level.m_7785_(var54, var56, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, (float)(var63 * 1.0), 2.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), var54, var56, var58, (int)(50.0 * CNT6), 0.25, 0.25, 0.25, 2.0 * CNT6);
               }

               entity.getPersistentData().m_128347_("Damage", 18.0 * CNT6);
               entity.getPersistentData().m_128347_("knockback", 3.0);
               entity.getPersistentData().m_128347_("Range", 5.0 * CNT6 * ReturnEntitySizeProcedure.execute(entity));
               entity.getPersistentData().m_128347_("projectile_type", 5.0);
               entity.getPersistentData().m_128379_("ignore", true);
               RangeAttackProcedure.execute(world, var54, var56, var58, entity);
               entity.getPersistentData().m_128347_("BlockDamage", (2.0 + var62 / 16.0) * CNT6);
               entity.getPersistentData().m_128347_("BlockRange", 4.0 * var63 * CNT6);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, var54, var56, var58, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 20.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)CNT6, 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)CNT6, 1.25F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)CNT6, 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)CNT6, 1.25F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 20.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
