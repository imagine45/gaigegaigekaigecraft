package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DismantleProcedure {
   public DismantleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean worldCutter;
         boolean canUseWorld;
         label389: {
            label388: {
               boolean logic_a = false;
               worldCutter = false;
               canUseWorld = false;
               boolean vertical = false;
               double dis = 0.0;
               double x_pos = 0.0;
               double y_pos = 0.0;
               double z_pos = 0.0;
               double yaw = 0.0;
               double picth = 0.0;
               double yaw2 = 0.0;
               double pitch2 = 0.0;
               double CNT6 = 0.0;
               double range = 0.0;
               double num1 = 0.0;
               double size = 0.0;
               double HP = 0.0;
               double y_power = 0.0;
               double z_power = 0.0;
               double x_power = 0.0;
               double distance = 0.0;
               double pitch = 0.0;
               Entity target_entity = null;
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               if (entity instanceof Player) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr3 = (ServerPlayer)entity;
                     if (_plr3.m_9236_() instanceof ServerLevel && _plr3.m_8960_().m_135996_(_plr3.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"))).m_8193_()) {
                        break label388;
                     }
                  }
               } else {
                  if (entity instanceof SukunaFushiguroEntity && entity instanceof SukunaFushiguroEntity) {
                     SukunaFushiguroEntity _datEntL5 = (SukunaFushiguroEntity)entity;
                     if ((Boolean)_datEntL5.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_world_cut)) {
                        break label388;
                     }
                  }

                  if (entity instanceof SukunaPerfectEntity) {
                     break label388;
                  }
               }

               canUseWorld = false;
               break label389;
            }

            canUseWorld = true;
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (canUseWorld && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002 = new Vec3;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            double var122 = ((Entity)var10004).m_20185_();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.m_5448_();
            } else {
               var10005 = null;
            }

            double var123 = ((Entity)var10005).m_20186_();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var123 += (double)((Entity)var10006).m_20206_() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var10002.<init>(var122, var123, ((Entity)var10006).m_20189_());
            entity.m_7618_(var10001, var10002);
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 6.0) {
               label404: {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                     label395: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                              break label395;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                           break label404;
                        }
                     }
                  }

                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }
            }

            if (canUseWorld) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               LivingEntity _mobEnt = var10000;
               if (_mobEnt instanceof LivingEntity) {
                  LivingEntity _livEnt30 = _mobEnt;
                  if (_livEnt30.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && !entity.getPersistentData().m_128471_("flag_dismantle")) {
                     entity.getPersistentData().m_128379_("flag_dismantle", true);
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     Entity var72 = var10000;
                     if (var72 instanceof LivingEntity) {
                        RotateEntityProcedure.execute(((Entity)var72).m_20185_(), ((Entity)var72).m_20186_() + (double)((Entity)var72).m_20206_() * 0.5, ((Entity)var72).m_20189_(), entity);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
            label352: {
               label351: {
                  if (entity instanceof Player) {
                     if (entity.m_6144_()) {
                        break label351;
                     }
                  } else if (Math.random() < 0.5) {
                     break label351;
                  }

                  entity.getPersistentData().m_128347_("cnt7", 2.0);
                  break label352;
               }

               entity.getPersistentData().m_128347_("cnt7", 1.0);
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && canUseWorld) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               LivingEntity var110 = var10000;
               if (var110 instanceof LivingEntity) {
                  LivingEntity _livEnt50 = var110;
                  if (_livEnt50.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     entity.getPersistentData().m_128347_("cnt7", 2.0);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 6, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt6", -1.0);
            double var66 = 0.5;
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") <= 1.0) {
               double var62 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var64 = Math.toRadians((double)entity.m_146909_());
               double var56 = entity.m_20185_() + Math.cos(var62) * Math.cos(var64) * (double)(1.0F + entity.m_20205_());
               double var58 = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(var64) * -1.0 * (double)(1.0F + entity.m_20205_());
               double var60 = entity.m_20189_() + Math.sin(var62) * Math.cos(var64) * (double)(1.0F + entity.m_20205_());
               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") < 3.0) {
                     entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt5") > 20.0) {
                        entity.getPersistentData().m_128347_("cnt5", 0.0);
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 1.0);
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              CompoundTag var120 = entity.getPersistentData();
                              _player.m_5661_(Component.m_237113_("§l\"" + Component.m_237115_("chant.jujutsucraft.dismantle" + Math.round(var120.m_128459_("cnt6"))).getString() + "\""), false);
                           }
                        }

                        if (entity instanceof Player) {
                           double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 30.0;
                           entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.PlayerCursePowerChange = _setval;
                              capability.syncPlayerVariables(entity);
                           });
                        }
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt6") < 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, var56, var58, var60, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123808_, var56, var58, var60, 20, 0.25, 0.25, 0.25, 1.0);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     ChargeParticleProcedure.execute(world, entity, 1.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }
               }
            }

            double var67 = 1.0;
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 0.0 && canUseWorld) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity90 = (LivingEntity)entity;
               if (_livingEntity90.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity90.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)(entity.getPersistentData().m_128459_("cnt6") >= 5.0 ? 207 : 120));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         double var65 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (entity.getPersistentData().m_128459_("cnt7") == 1.0) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 5.0));
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity98 = (LivingEntity)entity;
                  if (_livingEntity98.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity98.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(207.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 5.0) {
            if (entity.getPersistentData().m_128459_("cnt6") >= 5.0 && canUseWorld) {
               worldCutter = true;
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= 0.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * var65), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * var65), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * var65), 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * var65), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * var65), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * var65), 1.0F, false);
                  }
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
               }
            }

            boolean var55;
            double var57;
            double var59;
            double var61;
            int var121;
            label332: {
               var55 = Math.random() < 0.5;
               double var63 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var71 = Math.toRadians((double)entity.m_146909_());
               double var70 = (double)(1.0F + entity.m_20205_());
               var57 = entity.m_20185_() + Math.cos(var63) * Math.cos(var71) * var70;
               var59 = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(var71) * -1.0 * var70;
               var61 = entity.m_20189_() + Math.sin(var63) * Math.cos(var71) * var70;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var121 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label332;
                  }
               }

               var121 = 0;
            }

            double var69 = (double)(30 + var121 * 7) * var65;
            double var68 = 1.5 * ReturnEntitySizeProcedure.execute(entity);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.PROJECTILE_SLASH.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var57, var59, var61), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
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
                     LivingEntity _livingEntity122 = (LivingEntity)entityinstance;
                     if (_livingEntity122.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity122.getAttribute_(Attributes.f_22276_).m_22100_(var69);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)var69);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity126 = (LivingEntity)entityinstance;
                     if (_livingEntity126.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity126.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(var68);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("size", var68 * 2.0 * (1.0 + 0.5 * entity.getPersistentData().m_128459_("cnt6")));
                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 9.0);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 9.0);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 9.0);
                  if (worldCutter && entityinstance instanceof ProjectileSlashEntity) {
                     ProjectileSlashEntity _datEntSetI = (ProjectileSlashEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(ProjectileSlashEntity.DATA_mode, 1);
                  }

                  if (var55 && entityinstance instanceof ProjectileSlashEntity) {
                     ((ProjectileSlashEntity)entityinstance).setAnimation("vertical");
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == 1.0) {
               if ((!entity.getPersistentData().m_128471_("PRESS_Z") || !(entity.getPersistentData().m_128459_("cnt8") < 20.0)) && !(entity.getPersistentData().m_128459_("cnt8") < 5.0)) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               } else {
                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + 1.0);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 5.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange <= 0.0) {
                        entity.getPersistentData().m_128347_("skill", 0.0);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
