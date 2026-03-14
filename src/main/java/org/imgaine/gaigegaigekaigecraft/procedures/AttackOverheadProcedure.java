package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AttackOverheadProcedure {
   public AttackOverheadProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = 0.0;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         double var10001;
         double var10002;
         label290: {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            range = ReturnEntitySizeProcedure.execute(entity);
            var10001 = entity.getPersistentData().m_128459_("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt5 = (LivingEntity)entity;
               if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label290;
               }
            }

            var10002 = 0.2;
         }

         CNT6 = 1.0 + var10001 * var10002;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
                  }
               }

               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  distance = GetDistanceProcedure.execute(entity);
                  if (distance > 1.0 && distance < 4.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") == 0.0) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().m_128459_("cnt5") > 0.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") < 5.0) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.125);
                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt2", 0.0);
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var86 = ((Entity)var10000).m_20185_();
                     LivingEntity var87;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var87 = _mobEnt.m_5448_();
                     } else {
                        var87 = null;
                     }

                     double var88 = ((Entity)var87).m_20186_();
                     LivingEntity var89;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var89 = _mobEnt.m_5448_();
                     } else {
                        var89 = null;
                     }

                     RotateEntityProcedure.execute(var86, var88, ((Entity)var89).m_20189_(), entity);
                  }

                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  if (entity.m_20096_()) {
                     entity.m_146922_((float)yaw);
                     entity.m_146926_((float)Math.max(pitch, 90.0));
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     entity.m_146922_((float)yaw);
                     entity.m_146926_((float)Math.max(pitch, 45.0));
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

                  entity.getPersistentData().m_128379_("canFly", true);
                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
                  GetPowerFixProcedure.execute(entity);
                  entity.m_146922_((float)yaw);
                  entity.m_146926_((float)pitch);
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", 4.0);
               DamageFixProcedure.execute(entity);
            } else {
               if (entity.getPersistentData().m_128459_("cnt4") == 0.0 || entity instanceof GeoEntity && GetEntityAnimationProcedure.execute(entity).equals("empty")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity60 = (LivingEntity)entity;
                     if (_livingEntity60.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity60.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-8.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity61 = (LivingEntity)entity;
                     if (_livingEntity61.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity61.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(2.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 2.0, entity.getPersistentData().m_128459_("y_power") * 2.0, entity.getPersistentData().m_128459_("z_power") * 2.0));
               x_power = entity.m_20184_().m_7096_();
               y_power = entity.m_20184_().m_7098_();
               z_power = entity.m_20184_().m_7094_();
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance != 0.0) {
                  x_power /= distance;
                  y_power /= distance;
                  z_power /= distance;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.1);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.1);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.1);

               for(int index0 = 0; index0 < (int)Math.max(distance, 1.0); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", 10.0 * CNT6);
                  entity.getPersistentData().m_128347_("Range", 3.0 * range);
                  entity.getPersistentData().m_128347_("knockback", 0.6);
                  entity.getPersistentData().m_128347_("effect", 5.0);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128347_("x_knockback", 0.0);
               entity.getPersistentData().m_128347_("y_knockback", 0.0);
               entity.getPersistentData().m_128347_("z_knockback", 0.0);
               entity.getPersistentData().m_128379_("attack", true);
               entity.getPersistentData().m_128347_("cnt8", Math.max(entity.getPersistentData().m_128459_("cnt8"), entity.getPersistentData().m_128459_("Damage")));
               if (entity.getPersistentData().m_128459_("cnt2") % 2.0 == 1.0 && entity.getPersistentData().m_128459_("cnt4") >= 1.0) {
                  entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4") - 1.0, 1.0));
               }

               if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt2") > 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  entity.getPersistentData().m_128347_("cnt1", 1.0);
                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  pitch = Math.toRadians(0.0);
                  distance = (double)(1.0F * entity.m_20205_());
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(pitch) * -1.0 * distance);
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
                  if (entity.getPersistentData().m_128459_("cnt4") == 0.0 || entity instanceof GeoEntity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity110 = (LivingEntity)entity;
                        if (_livingEntity110.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity110.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity111 = (LivingEntity)entity;
                        if (_livingEntity111.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity111.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt2") > 80.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") != 0.0) {
            if (entity instanceof GeoEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity116 = (LivingEntity)entity;
                  if (_livingEntity116.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity116.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity117 = (LivingEntity)entity;
                  if (_livingEntity117.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity117.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
               }
            }

            entity.m_20256_(new Vec3(0.0, Math.min(-1.0, entity.m_20184_().m_7098_()), 0.0));
            d = Math.max(Math.sqrt(entity.getPersistentData().m_128459_("cnt8")), 1.0) * range;
            entity.getPersistentData().m_128347_("y_knockback", 0.5);
            if (entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt3", 4.0);
            } else {
               entity.getPersistentData().m_128347_("cnt3", Math.max(entity.getPersistentData().m_128459_("cnt3") - 1.0, 1.0));
            }

            if (!(entity.getPersistentData().m_128459_("cnt3") > 1.0) && !(entity.getPersistentData().m_128459_("cnt4") > 15.0)) {
               entity.getPersistentData().m_128347_("cnt1", 0.0);
               entity.getPersistentData().m_128347_("cnt2", 5.0);
               entity.getPersistentData().m_128347_("cnt3", 1.0);
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") <= 2.0) {
                  if (entity.getPersistentData().m_128459_("cnt4") == 1.0 && entity.getPersistentData().m_128459_("cnt1") <= 2.0 && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)d, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)d, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 0.75F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 0.75F, false);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= 2.0 * d) {
                  if (entity.getPersistentData().m_128459_("cnt1") % 2.0 == 0.0) {
                     entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 0.75);
                     entity.getPersistentData().m_128347_("Range", 6.0 * range);
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("Damage", 12.0 * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 0.5);
                     entity.getPersistentData().m_128347_("Range", 2.0 * d);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("BlockDamage", 1.0 + d * 1.0);
                     entity.getPersistentData().m_128347_("BlockRange", 1.0 * d);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("knockback", 0.5);
                     entity.getPersistentData().m_128347_("Range", 0.5 * d);
                     KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  for(int index1 = 0; index1 < (int)(8.0 * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 4.0, x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), 0.0, 2.0), 0.0, z_pos, z_pos, Math.random() < 0.75 ? "minecraft:crit" : "minecraft:cloud");
                  }

                  for(int index2 = 0; index2 < (int)(8.0 * range); ++index2) {
                     distance = Mth.m_216263_(RandomSource.m_216327_(), 0.0, d * 1.0);
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, distance, distance, 8.0, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:crit");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 15.0) {
                  entity.getPersistentData().m_128347_("BlockRange", 2.0 * d);
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }

            entity.getPersistentData().m_128347_("y_knockback", 0.0);
         }

      }
   }
}
