package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InfinityActiveTickProcedure {
   public InfinityActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label119: {
            double dis = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double velocity = 0.0;
            boolean logic_infinity = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  break label119;
               }
            }

            int var10000;
            label109: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                     break label109;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0 && ActiveTickConditionProcedure.execute(entity)) {
               if (entity instanceof Player) {
                  label126: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt4 = (LivingEntity)entity;
                        if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                           break label126;
                        }
                     }

                     label99: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                              var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19557_();
                              break label99;
                           }
                        }

                        var10000 = 0;
                     }

                     if (var10000 % 10 == 5) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }
                  }
               }

               Vec3 _center = new Vec3(x, y + (double)entity.m_20206_() * 0.5, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)(4.0F + entity.m_20205_()) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator) {
                     velocity = 0.0;
                     x_power = 0.0;
                     y_power = 0.0;
                     z_power = 0.0;
                     logic_infinity = false;
                     double var38;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var38 = _projEnt.m_20184_().m_82553_();
                     } else {
                        var38 = 0.0;
                     }

                     if (var38 > 0.0) {
                        logic_infinity = false;
                        velocity = Math.sqrt(entityiterator.m_20184_().m_7096_() * entityiterator.m_20184_().m_7096_() + entityiterator.m_20184_().m_7098_() * entityiterator.m_20184_().m_7098_() + entityiterator.m_20184_().m_7094_() * entityiterator.m_20184_().m_7094_());
                        if (velocity > 0.0) {
                           x_power = entityiterator.m_20184_().m_7096_() / velocity;
                           y_power = entityiterator.m_20184_().m_7098_() / velocity;
                           z_power = entityiterator.m_20184_().m_7094_() / velocity;
                           dis = Math.sqrt((entityiterator.m_20185_() - entity.m_20185_()) * (entityiterator.m_20185_() - entity.m_20185_()) + (entityiterator.m_20186_() - entity.m_20186_()) * (entityiterator.m_20186_() - entity.m_20186_()) + (entityiterator.m_20189_() - entity.m_20189_()) * (entityiterator.m_20189_() - entity.m_20189_()));
                           if (dis > Math.sqrt((entityiterator.m_20185_() + x_power * 0.001 - entity.m_20185_()) * (entityiterator.m_20185_() + x_power * 0.001 - entity.m_20185_()) + (entityiterator.m_20186_() + y_power * 0.001 - entity.m_20186_()) * (entityiterator.m_20186_() + y_power * 0.001 - entity.m_20186_()) + (entityiterator.m_20189_() + z_power * 0.001 - entity.m_20189_()) * (entityiterator.m_20189_() + z_power * 0.001 - entity.m_20189_()))) {
                              logic_infinity = true;
                           }
                        }
                     }

                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entityiterator.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
                        logic_infinity = true;
                        if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged"))) {
                           logic_infinity = false;
                        }

                        if (entity.getPersistentData().m_128459_("NameRanged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") || entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged"))) {
                           logic_infinity = false;
                        }
                     }

                     if (logic_infinity) {
                        if (!entity.getPersistentData().m_128471_("Stop")) {
                           entityiterator.getPersistentData().m_128379_("Stop", true);
                        }

                        if (velocity > 0.0) {
                           entityiterator.m_20256_(new Vec3(x_power * 0.01, 0.0, z_power * 0.01));
                        } else {
                           entityiterator.m_20256_(new Vec3(0.0, 0.0, 0.0));
                        }
                     }
                  }
               }

               return;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
         }

      }
   }
}
