package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ReverseCursedTechniqueOnEffectActiveTickProcedure {
   public ReverseCursedTechniqueOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean using = false;
         boolean Player = false;
         boolean heal = false;
         double Amount = 0.0;
         double old_level = 0.0;
         double old_tick = 0.0;
         double NUM1 = 0.0;
         double distance = 0.0;
         double effectLevel = 0.0;
         double fatigue = 0.0;
         if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
            }
         } else {
            int var10001;
            label229: {
               Player = entity instanceof Player;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                     var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                     break label229;
                  }
               }

               var10001 = 0;
            }

            fatigue = 1.0 + (double)Math.min(Math.max(var10001, 0) / 600, 10) * 0.4;
            if (entity.m_6084_()) {
               double var10000;
               label223: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).m_19564_();
                        break label223;
                     }
                  }

                  var10000 = 0.0;
               }

               effectLevel = var10000;
               Amount = 12.5 + Math.abs(effectLevel) * 1.25;
               using = false;
               heal = entity.getPersistentData().m_128471_("CursedSpirit") ? effectLevel < 0.0 : true;
               if (heal) {
                  float var65;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var65 = _livEnt.m_21223_();
                  } else {
                     var65 = -1.0F;
                  }

                  float var71;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var71 = _livEnt.m_21233_();
                  } else {
                     var71 = -1.0F;
                  }

                  if (var65 < var71) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var65 = _livEnt.m_21233_();
                     } else {
                        var65 = -1.0F;
                     }

                     NUM1 = (double)(var65 / 160.0F) * Amount * 0.1;
                     if (entity.getPersistentData().m_128471_("PRESS_M")) {
                        NUM1 /= fatigue;
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        Commands var67 = entity.m_20194_().m_129892_();
                        CommandSourceStack var72 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        double var10002 = Math.abs(NUM1);
                        var67.m_230957_(var72, "jjc_heal " + var10002 + " " + entity.m_20149_());
                     }

                     using = true;
                  }
               } else {
                  float var68;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var68 = _livEnt.m_21233_();
                  } else {
                     var68 = -1.0F;
                  }

                  NUM1 = (double)var68 * 0.25;
                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), (float)NUM1);
                  using = true;
                  if (!entity.m_6084_()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, y + (double)entity.m_20206_() * 0.5, z, 5, 1.0, 1.0, 1.0, 0.5);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * 0.5, z, 5, 1.0, 1.0, 1.0, 0.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (!Player && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               }

               if (using) {
                  if (effectLevel >= 0.0 && Math.random() < 1.0 / fatigue && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123815_, x, y + (double)entity.m_20206_() * 0.5, z, 1, (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.25, (double)entity.m_20205_() * 0.25, 0.1);
                  }

                  label215: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                           break label215;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt30 = (LivingEntity)entity;
                        if (_livEnt30.m_21023_(MobEffects.f_19597_)) {
                           label208: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                    var10000 = (double)_livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                                    break label208;
                                 }
                              }

                              var10000 = 0.0;
                           }

                           label203: {
                              old_level = var10000;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                    var10000 = (double)_livEnt.m_21124_(MobEffects.f_19597_).m_19557_();
                                    break label203;
                                 }
                              }

                              var10000 = 0.0;
                           }

                           old_tick = var10000;
                           if (old_tick > 4.0 * Amount * 0.1) {
                              old_tick -= 4.0 * Amount * 0.1;
                           } else {
                              --old_level;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_(MobEffects.f_19597_);
                           }

                           if (Math.ceil(old_tick) > 0.0 && old_level >= 0.0 && entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)Math.ceil(old_tick), (int)Math.round(old_level), false, false));
                              }
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128471_("PRESS_M")) {
                     if (Player) {
                        Amount = entity.getPersistentData().m_128471_("CursedSpirit") ? 5.0 : 10.0;
                        Amount /= fatigue;
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Amount;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

                     if (!ActiveTickConditionProcedure.execute(entity) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffect var10003;
                           int var10004;
                           label194: {
                              var73 = new MobEffectInstance;
                              var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                    var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                                    break label194;
                                 }
                              }

                              var10004 = 0;
                           }

                           var73.<init>(var10003, Math.min(var10004 + 20, 6000), 0, false, false);
                           _entity.m_7292_(var73);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_M") && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique_output")))) {
                  distance = (double)(entity.m_20205_() * 1.0F);
                  Vec3 _center = new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(distance * 3.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator instanceof LivingEntity && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entity != entityiterator) {
                        using = false;
                        if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                              using = true;
                           }
                        } else if (!entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                           using = true;
                        }

                        if (using && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, 0));
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
