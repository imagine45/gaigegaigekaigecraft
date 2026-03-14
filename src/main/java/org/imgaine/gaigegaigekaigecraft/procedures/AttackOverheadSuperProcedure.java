package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackOverheadSuperProcedure {
   public AttackOverheadSuperProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label266: {
            double strength = 0.0;
            double distance = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double dis = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label266;
               }
            }

            var10000 = 0;
         }

         double var31 = (double)Math.min(var10000, 50);
         double var34 = ReturnEntitySizeProcedure.execute(entity) * (1.0 + var31 * 0.025);
         entity.getPersistentData().m_128347_("cnt6", 2.5);
         double var44 = 1.0;
         double var35 = entity.m_20185_();
         double var48 = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         double var38 = entity.m_20189_();
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity13 = (LivingEntity)entity;
               if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity13.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-8.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity14 = (LivingEntity)entity;
               if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity14.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(2.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(10.0 * var34), var34 * 0.25, 0.1, var34 * 0.25, 0.5);
               }

               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.min(Math.max(1.75 * (double)Math.round(ReturnEntitySizeProcedure.execute(entity)), 1.0), 3.0), entity.m_20184_().m_7094_()));
               entity.getPersistentData().m_128347_("cnt3", 1.0);
            } else if (entity.m_20184_().m_7098_() < 0.5 || entity.getPersistentData().m_128459_("cnt2") > 20.0) {
               LivingEntity var82;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var82 = _mobEnt.m_5448_();
               } else {
                  var82 = null;
               }

               if (var82 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var82 = _mobEnt.m_5448_();
                  } else {
                     var82 = null;
                  }

                  double var84 = ((Entity)var82).m_20185_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  double var86 = ((Entity)var10001).m_20186_();
                  LivingEntity var10002;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.m_5448_();
                  } else {
                     var10002 = null;
                  }

                  RotateEntityProcedure.execute(var84, var86, ((Entity)var10002).m_20189_(), entity);
               }

               entity.getPersistentData().m_128347_("cnt1", 1.0);
               double var41 = (double)entity.m_146908_();
               double var51 = (double)entity.m_146909_();
               entity.m_146922_((float)var41);
               entity.m_146926_((float)Math.max(var51, 45.0));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128379_("canFly", true);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               GetPowerFixProcedure.execute(entity);
               entity.m_146922_((float)var41);
               entity.m_146926_((float)var51);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(10.0 * var34), var34 * 0.25, 0.1, var34 * 0.25, 0.5);
               }

               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }
         } else {
            LivingEntity var85;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var85 = _mobEnt.m_5448_();
            } else {
               var85 = null;
            }

            if (var85 instanceof LivingEntity) {
               entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
               entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt4") == 0.0) {
               if (!(entity instanceof Player) || entity.getPersistentData().m_128459_("cnt1") == 2.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entity;
                     if (_livingEntity64.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity64.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-8.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity65 = (LivingEntity)entity;
                     if (_livingEntity65.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity65.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(2.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               double var47 = entity.getPersistentData().m_128459_("x_power") * 2.0;
               double var45 = entity.getPersistentData().m_128459_("y_power") * 2.0;
               double var46 = entity.getPersistentData().m_128459_("z_power") * 2.0;
               entity.m_20256_(new Vec3(var47, var45, var46));
               double var43 = Math.sqrt(var47 * var47 + var45 * var45 + var46 * var46);
               if (var43 != 0.0) {
                  var47 /= var43;
                  var45 /= var43;
                  var46 /= var43;
               }

               var35 = entity.m_20185_();
               var48 = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
               var38 = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.1);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.1);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.1);

               for(int index0 = 0; index0 < (int)Math.max(var43, 1.0); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", 15.0 * var44);
                  entity.getPersistentData().m_128347_("Range", 3.0 * var34);
                  entity.getPersistentData().m_128347_("knockback", 0.6);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, var35, var48, var38, entity);
                  var35 += var47;
                  var48 += var45;
                  var38 += var46;
               }

               entity.getPersistentData().m_128347_("Damage", 25.0 * var44);
               entity.getPersistentData().m_128379_("attack", true);
               DamageFixProcedure.execute(entity);
               entity.getPersistentData().m_128347_("x_knockback", 0.0);
               entity.getPersistentData().m_128347_("y_knockback", 0.0);
               entity.getPersistentData().m_128347_("z_knockback", 0.0);
               if (entity.m_20096_() || entity.getPersistentData().m_128459_("cnt1") > 30.0) {
                  entity.getPersistentData().m_128347_("cnt1", 1.0);
                  entity.getPersistentData().m_128347_("cnt4", 1.0);
                  double var42 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var52 = Math.toRadians(0.0);
                  double var32 = (double)(1.0F * entity.m_20205_());
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var42) * Math.cos(var52) * var32);
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(var52) * -1.0 * var32);
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var42) * Math.cos(var52) * var32);
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity103 = (LivingEntity)entity;
                     if (_livingEntity103.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity103.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity104 = (LivingEntity)entity;
                     if (_livingEntity104.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity104.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt4") > 0.0) {
               if (!(entity instanceof Player) || entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity108 = (LivingEntity)entity;
                     if (_livingEntity108.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity108.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity109 = (LivingEntity)entity;
                     if (_livingEntity109.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity109.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               var35 = entity.getPersistentData().m_128459_("x_pos");
               var48 = entity.getPersistentData().m_128459_("y_pos");
               var38 = entity.getPersistentData().m_128459_("z_pos");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
                  if (entity.getPersistentData().m_128459_("cnt1") <= 3.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var48, var38), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var34, 0.75F);
                        } else {
                           _level.m_7785_(var35, var48, var38, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var34, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var48, var38), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var34, 1.25F);
                        } else {
                           _level.m_7785_(var35, var48, var38, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var34, 1.25F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var48, var38), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var34, 0.75F);
                        } else {
                           _level.m_7785_(var35, var48, var38, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var34, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var48, var38), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var34, 1.25F);
                        } else {
                           _level.m_7785_(var35, var48, var38, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var34, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") <= 2.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var48, var38), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var34, 0.5F);
                           } else {
                              _level.m_7785_(var35, var48, var38, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var34, 0.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var48, var38), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var34, 0.75F);
                           } else {
                              _level.m_7785_(var35, var48, var38, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var34, 0.75F, false);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") < 5.0) {
                     entity.getPersistentData().m_128347_("y_knockback", 0.5);
                     entity.getPersistentData().m_128347_("Damage", 24.0);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("Range", 16.0 * var34);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, var35, var48, var38, entity);
                     entity.getPersistentData().m_128347_("BlockDamage", 6.0 + var31 / 16.0);
                     entity.getPersistentData().m_128347_("BlockRange", 8.0 * var34);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var35, var48, var38, entity);
                     entity.getPersistentData().m_128347_("y_knockback", 0.0);
                     entity.getPersistentData().m_128347_("knockback", 0.75);
                     entity.getPersistentData().m_128347_("Range", 16.0 * var34);
                     KnockbackProcedure.execute(world, var35, var48, var38, entity);
                  }

                  for(int index1 = 0; index1 < (int)(24.0 * var34); ++index1) {
                     double var33 = Mth.m_216263_(RandomSource.m_216327_(), 0.0, 8.0 * var34);
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var33, var33, 8.0, var35, var35 + 0.0, var48, var48 + 1.0, 0.0, var38, var38 + 0.0, "minecraft:crit");
                  }

                  for(int index2 = 0; index2 < (int)(8.0 * var34); ++index2) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 8.0, var35, var35 + 0.0, var48, var48 + Mth.m_216263_(RandomSource.m_216327_(), 0.0, 1.0), 0.0, var38, var38 + 0.0, "minecraft:crit");
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 4.0, var35, var35 + 0.0, var48, var48 + Mth.m_216263_(RandomSource.m_216327_(), 0.0, 0.5), 0.0, var38, var38 + 0.0, "minecraft:cloud");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 25.0) {
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128347_("BlockRange", var31 * 1.0);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, var35, var48, var38, entity);
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * 0.5);
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
      }
   }
}
