package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         if (entity.m_6084_()) {
            int var10000;
            label139: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                     break label139;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0) {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 17.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 17.0) {
                     return;
                  }
               } else if (!(entity instanceof TakabaFumihikoEntity)) {
                  return;
               }

               label160: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label160;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entity;
                     if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        break label160;
                     }
                  }

                  label118: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                           var36 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19557_();
                           break label118;
                        }
                     }

                     var36 = 0.0;
                  }

                  tick = var36;
                  if (tick % 100.0 == 0.0) {
                     float var37;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var37 = _livEnt.m_21223_();
                     } else {
                        var37 = -1.0F;
                     }

                     double var38 = (double)var37;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var38 <= (double)var10001 * 0.9) {
                        label111: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                 var38 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                                 break label111;
                              }
                           }

                           var38 = 0.0;
                        }

                        label106: {
                           NUM1 = var38;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                 var38 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19557_();
                                 break label106;
                              }
                           }

                           var38 = 0.0;
                        }

                        NUM2 = var38;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get(), (int)NUM2, (int)(NUM1 - 1.0)));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21223_();
                           } else {
                              var10001 = -1.0F;
                           }

                           double var42 = (double)var10001;
                           float var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21233_();
                           } else {
                              var10002 = -1.0F;
                           }

                           _entity.m_21153_((float)(var42 + (double)var10002 * 0.1));
                        }
                     }
                  }

                  if (tick % 100.0 == 0.0) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(24.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && !entityiterator.getPersistentData().m_128471_("CursedSpirit") && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get(), 120, 0));
                           }
                        }
                     }
                  }

                  return;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
               }
            }
         }

      }
   }
}
