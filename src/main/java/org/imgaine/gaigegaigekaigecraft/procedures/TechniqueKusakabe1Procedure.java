package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueKusakabe1Procedure {
   public TechniqueKusakabe1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_fix = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix_height = 0.0;
         double speed = 0.0;
         double level_newShadowStyle = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         if (entity instanceof Player) {
            label510: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr1 = (ServerPlayer)entity;
                  if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_4"))).m_8193_()) {
                     level_newShadowStyle = 4.0;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr2 = (ServerPlayer)entity;
                  if (_plr2.m_9236_() instanceof ServerLevel && _plr2.m_8960_().m_135996_(_plr2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_3"))).m_8193_()) {
                     level_newShadowStyle = 3.0;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr3 = (ServerPlayer)entity;
                  if (_plr3.m_9236_() instanceof ServerLevel && _plr3.m_8960_().m_135996_(_plr3.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_2"))).m_8193_()) {
                     level_newShadowStyle = 2.0;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr4 = (ServerPlayer)entity;
                  if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_1"))).m_8193_()) {
                     level_newShadowStyle = 1.0;
                     break label510;
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

         if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
            entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + 1.0);
            if (level_newShadowStyle <= 1.0 || entity.getPersistentData().m_128459_("cnt8") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 9, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt8") == 1.0) {
                  label535: {
                     if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_hollow_wicker_basket")))) {
                        label529: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label529;
                              }
                           }

                           if (!(entity instanceof Player) || num1 != 1.0 && num2 != 1.0 && num1 != 7.0 && num2 != 7.0 && num1 != 12.0 && num2 != 12.0 && num1 != 24.0 && num2 != 24.0) {
                              num1 = -16.0;
                              break label535;
                           }
                        }
                     }

                     num1 = -17.0;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity17 = (LivingEntity)entity;
                     if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity17.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(num1);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            entity.getPersistentData().m_128347_("Damage", 15.0);
            entity.getPersistentData().m_128347_("Range", 1.5);
            entity.getPersistentData().m_128347_("effect", 5.0);
            entity.getPersistentData().m_128347_("projectile_type", 1.0);
            entity.getPersistentData().m_128379_("swing", true);
            DamageFixProcedure.execute(entity);
            num1 = entity.getPersistentData().m_128459_("cnt8") - 1.0;
            if (!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().m_128459_("cnt8") <= 40.0)) {
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
               if (num1 > (double)(!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().m_128459_("cnt8") <= 60.0) ? 160 : 640)) {
                  break;
               }
            }

            double var10000;
            int var10002;
            label427: {
               var10000 = (double)entity.m_20205_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label427;
                  }
               }

               var10002 = 0;
            }

            dis = Math.min(var10000 + 0.025 * (double)var10002, level_newShadowStyle >= 4.0 ? 16.0 : 4.0);
            if (entity.getPersistentData().m_128459_("cnt8") > 200.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               entity.getPersistentData().m_128347_("skill", 0.0);
            } else {
               entity.getPersistentData().m_128359_("TARGET", "");
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && entity.m_20186_() + (double)entity.m_20206_() >= entityiterator.m_20186_() && entity.m_20186_() <= entityiterator.m_20186_() + (double)entityiterator.m_20206_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     entity.getPersistentData().m_128359_("TARGET1", entityiterator.m_20149_());
                     entity.getPersistentData().m_128347_("cnt1", 1.0);
                     entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), 1.0));
                     entity.getPersistentData().m_128347_("cnt7", 1.0);
                     entity.getPersistentData().m_128347_("cnt8", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19597_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }
                     break;
                  }
               }
            }
         }

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
         }).apply(world, entity.getPersistentData().m_128461_("TARGET1"));
         if (entity.getPersistentData().m_128459_("cnt7") == 1.0) {
            if (entity_a instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + 1.0);
               dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.m_20185_() - entity.m_20185_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.m_20186_() - entity.m_20186_()) - (double)(entity_a.m_20206_() + entity.m_20206_()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.m_20189_() - entity.m_20189_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), 0.0), 2.0));
               RotateEntityProcedure.execute(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_(), entity);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               speed = Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("y_power"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("z_power"), 2.0));
               speed *= 4.0;
               if (speed != 0.0) {
                  vx = entity.getPersistentData().m_128459_("x_power") / speed;
                  vy = entity.getPersistentData().m_128459_("y_power") / speed;
                  vz = entity.getPersistentData().m_128459_("z_power") / speed;
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  logic_b = true;

                  for(int index1 = 0; index1 < (int)Math.round(speed * 4.5); ++index1) {
                     dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.m_20185_() - entity.m_20185_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.m_20186_() - entity.m_20186_()) - (double)(entity_a.m_20206_() + entity.m_20206_()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.m_20189_() - entity.m_20189_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), 0.0), 2.0));
                     if (dis < 2.5) {
                        logic_b = false;
                        RotateEntityProcedure.execute(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_(), entity);
                        entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                        entity.getPersistentData().m_128347_("cnt7", 2.0);
                        break;
                     }

                     y_pos += vy;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.m_5830_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        y_pos -= vy;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }

                     x_pos += vx;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.m_5830_()) {
                        x_pos -= vx;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }

                     z_pos += vz;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.m_5830_()) {
                        z_pos -= vz;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }
                  }

                  for(int index2 = 0; index2 < 8; ++index2) {
                     dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.m_20185_() - entity.m_20185_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.m_20186_() - entity.m_20186_()) - (double)(entity_a.m_20206_() + entity.m_20206_()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.m_20189_() - entity.m_20189_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), 0.0), 2.0));
                     if (dis < 2.5) {
                        logic_b = false;
                        RotateEntityProcedure.execute(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_(), entity);
                        entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                        entity.getPersistentData().m_128347_("cnt7", 2.0);
                        break;
                     }

                     logic_a = true;
                     y_fix_height = 0.0;

                     for(int index3 = 0; index3 < (int)Math.ceil((double)(entity.m_20206_() + 0.0F)); ++index3) {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix_height, z_pos)).m_60815_()) {
                           logic_a = false;
                           break;
                        }

                        ++y_fix_height;
                     }

                     if (logic_a) {
                        x_pos += vx;
                        y_pos += vy;
                        z_pos += vz;
                     } else {
                        y_fix = 0.0;

                        for(int index4 = 0; index4 < (int)Math.round(Math.max(speed * 2.0, 1.0)); ++index4) {
                           if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix, z_pos + vz)).m_60815_()) {
                              if (world.m_8055_(BlockPos.m_274561_(x_pos, Math.max(y_pos + vy, y_pos) + y_fix, z_pos)).m_60815_()) {
                                 logic_a = false;
                                 break;
                              }

                              y_fix += 0.5;
                           } else {
                              logic_a = true;
                              y_fix_height = 0.0;

                              for(int index5 = 0; index5 < (int)Math.ceil((double)entity.m_20206_()); ++index5) {
                                 if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_()) {
                                    logic_a = false;
                                    break;
                                 }

                                 ++y_fix_height;
                              }

                              if (logic_a) {
                                 break;
                              }

                              ++y_fix;
                           }
                        }

                        if (logic_a) {
                           y_pos = y_pos + vy + y_fix;
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.m_5830_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              y_pos = y_pos - vy - y_fix;
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }

                           x_pos += vx;
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.m_5830_()) {
                              x_pos -= vx;
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }

                           z_pos += vz;
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.m_5830_()) {
                              z_pos -= vz;
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }
                           continue;
                        }
                     }

                     if (!logic_a) {
                        break;
                     }

                     x_pos += vx;
                     y_pos = y_pos + vy + y_fix;
                     z_pos += vz;
                  }
               }
            } else {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().m_128347_("cnt7", 2.0);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") > 1.0) {
            if (level_newShadowStyle >= 3.0) {
               entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt5") <= (double)(level_newShadowStyle == 3.0 ? 25 : 50)) {
                  if (entity.getPersistentData().m_128459_("cnt2") > 0.0) {
                     entity.getPersistentData().m_128347_("cnt1", 1.0);
                     entity.getPersistentData().m_128347_("cnt2", 0.0);
                     entity.getPersistentData().m_128347_("cnt6", 2.5 + Math.min(entity.getPersistentData().m_128459_("cnt5") * 0.01, 0.5));
                     entity.getPersistentData().m_128347_("cnt7", 1.0);
                     entity.getPersistentData().m_128347_("cnt8", 18.0);
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt6", 10.0);
                  entity.getPersistentData().m_128347_("cnt5", 100.0);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt6", 10.0);
               entity.getPersistentData().m_128347_("cnt5", 100.0);
            }

            for(int index6 = 0; index6 < 5; ++index6) {
               AttackWeakProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("cnt5") >= 100.0) {
                  break;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == 1.0 && entity_a instanceof LivingEntity && !entity_a.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt7", 0.0);
               entity.getPersistentData().m_128347_("cnt8", 100.0);
            }
         }

      }
   }
}
