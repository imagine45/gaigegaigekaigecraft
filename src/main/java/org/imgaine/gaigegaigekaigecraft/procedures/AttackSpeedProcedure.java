package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.item.SwordOptionItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackSpeedProcedure {
   public AttackSpeedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double CNT6 = 0.0;
         double rad_now = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         double strength = 0.0;
         double old_cnt2 = 0.0;
         double old_cnt1 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
         if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
            entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), 2.5));
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         label383: {
            if (var10000.m_41720_() != JujutsucraftModItems.SWORD_OPTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() != JujutsucraftModItems.SWORD_OPTION.get()) {
                  break label383;
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * -1.0 * (double)entity.m_20205_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * -1.0 * (double)entity.m_20205_();
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * -1.0 * (double)entity.m_20205_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.SWORD_OPTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() instanceof SwordOptionItem) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128359_("geckoAnim", "attack");
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftModItems.SWORD_OPTION.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() instanceof SwordOptionItem) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128359_("geckoAnim", "attack");
                  }
               }
            }

            entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), 2.5));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 2, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 2, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }
         }

         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         label369: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var115 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label369;
               }
            }

            var115 = 0;
         }

         strength = (double)Math.min(var115, 50);
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + strength * 0.025);
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         entity.f_19789_ = 0.0F;
         LivingEntity var116;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var116 = _mobEnt.m_5448_();
         } else {
            var116 = null;
         }

         if (var116 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt7") > 1.0) {
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

         if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
            entity.getPersistentData().m_128347_("cnt7", entity.getPersistentData().m_128459_("cnt7") + 1.0);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var116 = _mobEnt.m_5448_();
            } else {
               var116 = null;
            }

            if (var116 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt7") % 20.0 == 1.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var116 = _mobEnt.m_5448_();
               } else {
                  var116 = null;
               }

               double var119 = ((Entity)var116).m_20185_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               double var121 = ((Entity)var10001).m_20186_();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var121 += (double)((Entity)var10002).m_20206_() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var119, var121, ((Entity)var10002).m_20189_(), entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }

            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var116 = _mobEnt.m_5448_();
               } else {
                  var116 = null;
               }

               if (var116 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

               if (entity.getPersistentData().m_128459_("cnt2") >= 9.0 && entity.getPersistentData().m_128459_("cnt2") <= 10.0) {
                  if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                     entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), 9.0));
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") > 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt6") == 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.125);
                     if (entity.getPersistentData().m_128459_("cnt6") == 5.0) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }

               if (entity.getPersistentData().m_128459_("cnt2") >= 10.0 && !entity.getPersistentData().m_128471_("PRESS_Z") && OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("cnt2", 0.0);
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19597_);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(10.0 * range), range * 0.25, 0.1, range * 0.25, 0.5);
                  }

                  if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
                     if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
                        ((EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)entity).setAnimation("form_attack_speed2");
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity105 = (LivingEntity)entity;
                        if (_livingEntity105.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity105.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(3.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity106 = (LivingEntity)entity;
                        if (_livingEntity106.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity106.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            } else {
               if (!(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
                  }
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * 2.0;
               y_power = entity.getPersistentData().m_128459_("y_power") * 2.0;
               z_power = entity.getPersistentData().m_128459_("z_power") * 2.0;
               if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  entity.getPersistentData().m_128347_("Range", 4.0 * range);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128379_("attack", true);
               if (logic_a) {
                  if (Math.round(distance) >= 1L) {
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();

                     for(int index1 = 0; index1 < (int)Math.round(distance); ++index1) {
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           x_pos += x_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           y_pos += y_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           z_pos += z_power;
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     entity.m_6021_(x_pos, y_pos, z_pos);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  logic_a = true;
               }

               if (!logic_a && !(entity.getPersistentData().m_128459_("cnt2") > 6.0)) {
                  if (entity.getPersistentData().m_128459_("cnt2") > 120.0) {
                     entity.getPersistentData().m_128347_("skill", 0.0);
                  }
               } else {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().m_128347_("cnt1", 8.0);
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 1.0);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
               }
            }

            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
            old_cnt2 = entity.getPersistentData().m_128459_("cnt2");
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1"));
            entity.getPersistentData().m_128347_("cnt2", 0.0);
            if (old_cnt1 == 9.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 9.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity157 = (LivingEntity)entity;
                  if (_livingEntity157.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity157.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(1.0);
                  }
               }

               if (LogicSwordProcedure.execute(entity)) {
                  AttackStrongSwordProcedure.execute(world, x, y, z, entity);
               } else {
                  if (old_cnt1 == 9.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity158 = (LivingEntity)entity;
                        if (_livingEntity158.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity158.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-7.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity159 = (LivingEntity)entity;
                        if (_livingEntity159.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity159.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  AttackWeakProcedure.execute(world, x, y, z, entity);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity160 = (LivingEntity)entity;
                  if (_livingEntity160.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity160.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(0.0);
                  }
               }
            }

            entity.getPersistentData().m_128347_("cnt1", old_cnt1);
            entity.getPersistentData().m_128347_("cnt2", old_cnt2);
            if (entity.getPersistentData().m_128459_("cnt1") > 18.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
