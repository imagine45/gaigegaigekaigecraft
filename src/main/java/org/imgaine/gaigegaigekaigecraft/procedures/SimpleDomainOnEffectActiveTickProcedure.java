package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SimpleDomainOnEffectActiveTickProcedure {
   public SimpleDomainOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10000;
         label130: {
            boolean logic_infinity = false;
            double z_pos = 0.0;
            double num3 = 0.0;
            double strength = 0.0;
            double num1 = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            double yaw = 0.0;
            double num2 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                  break label130;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0 && LogicSimpleDomainProcedure.execute()) {
            label122: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label122;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 5 == 1) {
               if (entity instanceof Player) {
                  label114: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt3 = (LivingEntity)entity;
                        if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                           break label114;
                        }
                     }

                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }

               SimpleDomainEffectStartedappliedProcedure.execute(world, x, y, z, entity);
            }

            if (!ActiveTickConditionProcedure.execute(entity) && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
            }

            label106: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label106;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 2 == 1) {
               label140: {
                  double var34 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                  double var39 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                  if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_hollow_wicker_basket")))) {
                     label137: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt7 = (LivingEntity)entity;
                           if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label137;
                           }
                        }

                        if (!(entity instanceof Player) || var34 != 1.0 && var39 != 1.0 && var34 != 7.0 && var39 != 7.0 && var34 != 12.0 && var39 != 12.0 && var34 != 24.0 && var39 != 24.0) {
                           break label140;
                        }
                     }
                  }

                  double var38 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var37 = Math.toRadians((double)entity.m_146909_());
                  double var35 = entity.m_20185_() + Math.cos(var38) * Math.cos(var37) * (double)(-1.0F - entity.m_20205_());
                  double var36 = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                  double var33 = entity.m_20189_() + Math.sin(var38) * Math.cos(var37) * (double)(-1.0F - entity.m_20205_());
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_HOLLOW_WICKER_BASKET.get(), var35, var36, var33, 0, 0.0, 0.0, 0.0, 0.0);
                  }
               }
            }

            int var10002;
            label81: {
               var52 = (double)entity.m_20205_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label81;
                  }
               }

               var10002 = 0;
            }

            double var40 = var52 + 0.025 * (double)var10002;
            var40 = Math.min(var40, entity.getPersistentData().m_128459_("skill") == 3105.0 ? 16.0 : 4.0);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(var40 * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entity.m_20186_() + (double)entity.m_20206_() >= entityiterator.m_20186_() && entity.m_20186_() <= entityiterator.m_20186_() + (double)entityiterator.m_20206_()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 5, 0, true, true));
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
