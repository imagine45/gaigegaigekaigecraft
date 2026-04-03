package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.TakabaFumihikoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ComedianOnEffectActiveTickProcedure {
   public ComedianOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            int var10000;
            label141: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getAmplifier();
                     break label141;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0) {
               double var36;
               label135: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                        var36 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getDuration();
                        break label135;
                     }
                  }

                  var36 = 0.0;
               }

               tick = var36;
               if (tick % 10.0 == 0.0) {
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 17.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 17.0) {
                        return;
                     }
                  } else if (!(entity instanceof TakabaFumihikoEntity)) {
                     return;
                  }

                  label162: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                           break label162;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                           break label162;
                        }
                     }

                     if (tick % 100.0 == 0.0) {
                        float var37;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var37 = _livEnt.getHealth();
                        } else {
                           var37 = -1.0F;
                        }

                        double var38 = (double)var37;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var38 <= (double)var10001 * 0.9) {
                           label112: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                    var38 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getAmplifier();
                                    break label112;
                                 }
                              }

                              var38 = 0.0;
                           }

                           label107: {
                              NUM1 = var38;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                    var38 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getDuration();
                                    break label107;
                                 }
                              }

                              var38 = 0.0;
                           }

                           NUM2 = var38;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get(), (int)NUM2, (int)(NUM1 - 1.0)));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getHealth();
                              } else {
                                 var10001 = -1.0F;
                              }

                              double var42 = (double)var10001;
                              float var10002;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = _livEnt.getMaxHealth();
                              } else {
                                 var10002 = -1.0F;
                              }

                              _entity.setHealth((float)(var42 + (double)var10002 * 0.1));
                           }
                        }
                     }

                     if (tick % 100.0 == 0.0) {
                        Vec3 _center = new Vec3(x, y, z);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(24.0), (e) -> true)) {
                           if (entity != entityiterator && !entityiterator.getPersistentData().getBoolean("CursedSpirit") && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get(), 120, 0));
                              }
                           }
                        }
                     }

                     return;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                  }
               }
            }
         }

      }
   }
}
