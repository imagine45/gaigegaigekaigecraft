package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueBluePunchProcedure {
   public TechniqueBluePunchProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double z_center = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double x_center = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double rad = 0.0;
         double x_power = 0.0;
         double num1 = 0.0;
         double z_knockback = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double y_knockback = 0.0;
         ItemStack old_health = ItemStack.f_41583_;
         boolean player = false;
         boolean logic_a = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt9", entity.getPersistentData().m_128459_("cnt9") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt9") % 4.0 == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity9 = (LivingEntity)entity;
               if (_livingEntity9.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity9.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(207.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity10 = (LivingEntity)entity;
               if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity10.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         LivingEntity var10000;
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

            double var97 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var100 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var100 += (double)((Entity)var10002).m_20206_() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var97, var100, ((Entity)var10002).m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_center, y_center, z_center), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
            } else {
               _level.m_7785_(x_center, y_center, z_center, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 2.0) {
            if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
               entity.getPersistentData().m_128347_("Damage", 6.0);
               DamageFixProcedure.execute(entity);
               dis = (double)(1.0F + entity.m_20205_());
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_center = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis;
               y_center = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * dis;
               z_center = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis;
               entity.getPersistentData().m_128347_("x_pos", x_center);
               entity.getPersistentData().m_128347_("y_pos", y_center);
               entity.getPersistentData().m_128347_("z_pos", z_center);
               x_power = entity.m_20154_().f_82479_ * 0.33;
               y_power = entity.m_20154_().f_82480_ * 0.33;
               z_power = entity.m_20154_().f_82481_ * 0.33;
               num1 = 0.0;

               for(int index0 = 0; index0 < 120; ++index0) {
                  dis += 0.25 * range;
                  rad += Math.toRadians(Math.random() * 20.0);
                  if (Math.random() > 0.5) {
                     if (Math.random() < 0.5) {
                        rad *= -1.0;
                     }

                     x_pos = x_center + Math.cos(rad) * Math.cos(yaw + Math.toRadians(90.0)) * Math.min(dis * 0.25, 4.0 * range);
                     y_pos = y_center + Math.sin(rad) * Math.min(dis * 0.25, 4.0 * range);
                     z_pos = z_center + Math.cos(rad) * Math.sin(yaw + Math.toRadians(90.0)) * Math.min(dis * 0.25, 4.0 * range);
                     ParticleGeneratorProcedure.execute(world, range * 0.1, 1.0, 0.0, dis * 0.25, x_pos, entity.getPersistentData().m_128459_("x_pos"), y_pos, entity.getPersistentData().m_128459_("y_pos"), z_pos, entity.getPersistentData().m_128459_("z_pos"), "minecraft:enchanted_hit");
                  }

                  x_center += x_power;
                  y_center += y_power;
                  z_center += z_power;
                  ++num1;
                  if (num1 >= 12.0) {
                     num1 = 0.0;
                     entity.getPersistentData().m_128347_("Range", 10.0 * range);
                     entity.getPersistentData().m_128347_("knockback", -3.0);
                     Vec3 _center = new Vec3(x_center, y_center, z_center);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator) {
                           label279: {
                              logic_a = true;
                              if (entityiterator instanceof Player) {
                                 if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                                    break label279;
                                 }
                              } else if (!(entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                                 break label279;
                              }

                              ItemStack var98;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                 var98 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var98 = ItemStack.f_41583_;
                              }

                              old_health = var98.m_41777_();
                              if (entityiterator instanceof Player) {
                                 Player _plrCldCheck49 = (Player)entityiterator;
                                 if (_plrCldCheck49.m_36335_().m_41519_(old_health.m_41720_())) {
                                    break label279;
                                 }
                              }

                              if ((old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) && old_health.m_41784_().m_128459_("skill206") >= 100.0) {
                                 logic_a = false;
                              }
                           }

                           if ((LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move"))) || !(entityiterator instanceof LivingEntity)) && logic_a) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
                              }

                              player = entityiterator instanceof Player;
                              x_knockback = entityiterator.m_20185_() - (entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(2.0F + entity.m_20205_()));
                              y_knockback = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5 - (entity.m_20186_() + (double)entity.m_20206_() * 0.5 + Math.sin(pitch) * -1.0 * (double)(2.0F + entity.m_20205_()));
                              z_knockback = entityiterator.m_20189_() - (entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(2.0F + entity.m_20205_()));
                              dis = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                              if (GetDistanceIteratorProcedure.execute(entity, entityiterator) < 2.5) {
                                 x_knockback = 0.0;
                                 y_knockback = 0.0;
                                 z_knockback = 0.0;
                              } else {
                                 x_knockback = x_knockback / dis * entity.getPersistentData().m_128459_("knockback");
                                 y_knockback = y_knockback / dis * entity.getPersistentData().m_128459_("knockback");
                                 z_knockback = z_knockback / dis * entity.getPersistentData().m_128459_("knockback");
                                 if (!(x_knockback * 1.1 < entityiterator.m_20184_().m_7096_()) && !(x_knockback * 0.9 > entityiterator.m_20184_().m_7096_())) {
                                    x_knockback = entityiterator.m_20184_().m_7096_();
                                 } else {
                                    x_knockback = entityiterator.m_20184_().m_7096_() + x_knockback * (player ? 0.15 : 0.05);
                                 }

                                 if (!(y_knockback * 1.1 < entityiterator.m_20184_().m_7098_()) && !(y_knockback * 0.9 > entityiterator.m_20184_().m_7098_())) {
                                    y_knockback = entityiterator.m_20184_().m_7098_();
                                 } else {
                                    y_knockback = entityiterator.m_20184_().m_7098_() + y_knockback * (player ? 0.15 : 0.05);
                                 }

                                 if (!(z_knockback * 1.1 < entityiterator.m_20184_().m_7094_()) && !(z_knockback * 0.9 > entityiterator.m_20184_().m_7094_())) {
                                    z_knockback = entityiterator.m_20184_().m_7094_();
                                 } else {
                                    z_knockback = entityiterator.m_20184_().m_7094_() + z_knockback * (player ? 0.15 : 0.05);
                                 }

                                 if (entityiterator.m_20096_()) {
                                    y_knockback = Math.max(y_knockback, 0.5);
                                 }
                              }

                              EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("knockback", 0.0);
                  }
               }

               entity.getPersistentData().m_128347_("effect", 1.0);
               GrabProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("effect", 0.0);
               if (entity.getPersistentData().m_128459_("cnt1") >= 13.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                     if (GetDistanceProcedure.execute(entity) < 6.0) {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt5") >= 5.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                     entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 13.0));
                     entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 0.1);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 16.0) {
               label301: {
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof Player) {
                     if (!entity.m_6144_()) {
                        break label301;
                     }
                  } else if (!(Math.random() < 0.5)) {
                     break label301;
                  }

                  entity.getPersistentData().m_128347_("skill", 1606.0);
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  entity.getPersistentData().m_128347_("cnt6", 2.5);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  entity.m_146922_((float)yaw);
                  entity.m_146926_(90.0F);
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

                  return;
               }

               entity.getPersistentData().m_128347_("skill", 101.0);
               entity.getPersistentData().m_128347_("cnt1", 8.0);
               entity.getPersistentData().m_128347_("cnt6", 5.0);
            }
         }

      }
   }
}
