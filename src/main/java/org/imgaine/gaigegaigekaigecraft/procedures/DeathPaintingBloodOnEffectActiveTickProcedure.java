package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DeathPaintingBloodOnEffectActiveTickProcedure {
   public DeathPaintingBloodOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean damage = false;
         double playerTechnique1 = 0.0;
         double playerTechnique2 = 0.0;
         double tick = 0.0;
         double level = 0.0;
         if (entity.isAlive()) {
            double var10000;
            label180: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier();
                     break label180;
                  }
               }

               var10000 = 0.0;
            }

            label175: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getDuration();
                     break label175;
                  }
               }

               var10000 = 0.0;
            }

            tick = var10000;
            damage = true;
            if (!(entity instanceof Player)) {
               if (entity instanceof KenjakuEntity || entity instanceof ItadoriYujiEntity || entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                  damage = false;
               }
            } else {
               JujutsucraftModVariables.PlayerVariables cap = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
               playerTechnique1 = cap.PlayerCurseTechnique;
               playerTechnique2 = cap.PlayerCurseTechnique2;
               if (playerTechnique1 == 10.0 || playerTechnique2 == 10.0 || playerTechnique1 == 21.0 || playerTechnique2 == 21.0) {
                  damage = false;
               }

               if (cap.PlayerCursePowerFormer == 0.0) {
                  damage = false;
               }
            }

            if (damage) {
               if (ReturnInsideItemProcedure.execute(entity).getItem() == JujutsucraftModItems.DEATH_PAINTING.get()) {
                  damage = false;
               }

               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                  damage = false;
               }

               if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                  damage = false;
               }
            }

            if (damage) {
               if (tick % 200.0 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
                     }
                  }

                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))), (float)(6.0 * (1.0 + level)));
               }
            } else if (level == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
               }
            } else {
               if (playerTechnique1 == 10.0 || playerTechnique2 == 10.0 || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting")))) {
                  int var32;
                  label140: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                           var32 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier();
                           break label140;
                        }
                     }

                     var32 = 0;
                  }

                  int var10001;
                  label135: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label135;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var32 < var10001 + 1) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           MobEffect var10003;
                           int var10004;
                           int var10005;
                           MobEffectInstance var33;
                           label125: {
                              var10003 = (MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get();
                              var10004 = (int)tick;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label125;
                                 }
                              }

                              var10005 = 0;
                           }

                           var33 = new MobEffectInstance(var10003, var10004, var10005 + 1);
                           _entity.addEffect(var33);
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 2, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, 1, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 219, 0, false, false));
                     }
                  }
               }

               label192: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt26 = (LivingEntity)entity;
                     if (_livEnt26.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label192;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     return;
                  }

                  LivingEntity _livEnt27 = (LivingEntity)entity;
                  if (!_livEnt27.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
               }
            }
         }

      }
   }
}
