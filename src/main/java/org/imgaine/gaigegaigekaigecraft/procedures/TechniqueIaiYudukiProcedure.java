package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueIaiYudukiProcedure {
   public TechniqueIaiYudukiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double level_newShadowStyle = 0.0;
         double dis = 0.0;
         entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof Player) {
            label347: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr4 = (ServerPlayer)entity;
                  if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_4"))).m_8193_()) {
                     level_newShadowStyle = 4.0;
                     break label347;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr5 = (ServerPlayer)entity;
                  if (_plr5.m_9236_() instanceof ServerLevel && _plr5.m_8960_().m_135996_(_plr5.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_3"))).m_8193_()) {
                     level_newShadowStyle = 3.0;
                     break label347;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr6 = (ServerPlayer)entity;
                  if (_plr6.m_9236_() instanceof ServerLevel && _plr6.m_8960_().m_135996_(_plr6.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_2"))).m_8193_()) {
                     level_newShadowStyle = 2.0;
                     break label347;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr7 = (ServerPlayer)entity;
                  if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_1"))).m_8193_()) {
                     level_newShadowStyle = 1.0;
                     break label347;
                  }
               }

               level_newShadowStyle = 1.0;
            }
         } else if (entity instanceof KusakabeAtsuyaEntity) {
            level_newShadowStyle = 4.0;
         } else {
            level_newShadowStyle = 1.0;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= 20.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 19, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-16.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity17.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 19.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 12.0) {
                     label361: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label351: {
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
                                    break label351;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label361;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 19.0));
            }

            num1 = entity.getPersistentData().m_128459_("cnt8") - 1.0;
            if (!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().m_128459_("cnt8") <= 20.0)) {
               num1 = Math.max((num1 - 40.0) * 50.0, 1.0);
               num1 = Math.min(160.0 + num1, 640.0);
            } else {
               num1 = Math.max(num1 * 50.0, 1.0);
               num1 = Math.min(num1, 160.0);
            }

            for(int index0 = 0; index0 < 5; ++index0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)num1, 1, true, true));
                  }
               }

               num1 += 10.0;
               if (num1 > (double)(!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().m_128459_("cnt8") <= 40.0) ? 160 : 640)) {
                  break;
               }
            }

            double var71;
            int var10002;
            label274: {
               var71 = (double)entity.m_20205_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label274;
                  }
               }

               var10002 = 0;
            }

            dis = Math.min(var71 + 0.025 * (double)var10002, level_newShadowStyle >= 4.0 ? 16.0 : 4.0);
            if (entity.getPersistentData().m_128459_("cnt8") > 100.0) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 20.0));
            } else {
               entity.getPersistentData().m_128359_("TARGET", "");
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && entity.m_20186_() + (double)entity.m_20206_() >= entityiterator.m_20186_() && entity.m_20186_() <= entityiterator.m_20186_() + (double)entityiterator.m_20206_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     RotateEntityProcedure.execute(entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_(), entity);
                     entity.getPersistentData().m_128359_("TARGET1", entityiterator.m_20149_());
                     entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 20.0));
                     break;
                  }
               }
            }

            entity.getPersistentData().m_128347_("Damage", 15.0);
            entity.getPersistentData().m_128347_("Range", 1.5);
            entity.getPersistentData().m_128347_("effect", 5.0);
            entity.getPersistentData().m_128347_("projectile_type", 1.0);
            entity.getPersistentData().m_128379_("swing", true);
            DamageFixProcedure.execute(entity);
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 1.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 1.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 1.0);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 19, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().m_128459_("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity81 = (LivingEntity)entity;
                  if (_livingEntity81.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity81.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(101.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity82 = (LivingEntity)entity;
                  if (_livingEntity82.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity82.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(10.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               for(int index1 = 0; index1 < (int)(16.0 * range); ++index1) {
                  if (Math.random() < 0.75 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 0.2);
                  }

                  ++dis;
                  if (dis > 0.0) {
                     entity.getPersistentData().m_128347_("Damage", 24.0 * CNT6);
                     entity.getPersistentData().m_128347_("Range", 5.0 * range);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128347_("projectile_type", 2.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                     dis = 5.0 * range * -0.5;
                  }

                  entity.m_6021_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_() - entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() - entity.getPersistentData().m_128459_("y_power"), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power"), entity.m_146908_(), entity.m_146909_());
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(10.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") == 7.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity153 = (LivingEntity)entity;
                  if (_livingEntity153.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity153.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-16.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity154 = (LivingEntity)entity;
                  if (_livingEntity154.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity154.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt3") > 20.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
