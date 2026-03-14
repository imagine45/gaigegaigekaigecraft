package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class UnlimitedVoidActiveProcedure {
   public UnlimitedVoidActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double dis;
         double rad;
         double range;
         double var10000;
         label165: {
            boolean logic_a = false;
            double distance = 0.0;
            double ticks = 0.0;
            range = 0.0;
            double rad1 = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            dis = 0.0;
            rad = 0.0;
            double rad_now = 0.0;
            double num1 = 0.0;
            double y_pos = 0.0;
            double num2 = 0.0;
            double x_center = 0.0;
            double y_center = 0.0;
            double z_center = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label165;
               }
            }

            var10000 = 0.0;
         }

         double var42 = var10000;
         double var60 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var61 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var62 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123810_, var60, var61, var62, 2, dis * 0.25, dis * 0.25, dis * 0.25, 0.0);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123809_, var60, var61, var62, 2, dis * 0.25, dis * 0.25, dis * 0.25, 0.0);
         }

         if ((var42 % 5.0 == 0.0 || entity.getPersistentData().m_128471_("StartDomainAttack")) && !entity.getPersistentData().m_128471_("Failed")) {
            entity.getPersistentData().m_128379_("StartDomainAttack", false);
            entity.getPersistentData().m_128379_("onlyLiving", true);
            Vec3 _center = new Vec3(var60, var61, var62);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  double var54;
                  if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                     var54 = 150.0;
                  } else {
                     var54 = 350.0;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 4, false, false));
                        }
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)var54, 99, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, (int)var54, 99, false, false));
                     }
                  }

                  if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ranged_ammo")))) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, (int)var54, 99, false, false));
                        }
                     }

                     if (entityiterator.getPersistentData().m_128459_("skill") != -999.0 && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }

                     entityiterator.getPersistentData().m_128347_("skill", -999.0);
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (int)var54, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)var54, 0, false, false));
                        }
                     }

                     entityiterator.getPersistentData().m_128347_("skill", -999.0);
                  }
               }
            }

            entity.getPersistentData().m_128379_("onlyLiving", false);
            if (Math.random() < 0.25) {
               double var55 = Math.toRadians(Math.random() * 360.0);
               double var59 = range * 0.5 - 6.0;
               double var45 = var60 + Math.sin(var55) * var59;
               double var56 = var61 + 2.0;
               double var48 = var62 + Math.cos(var55) * var59;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID.get(), var45, var56, var48, 10, 2.0, 2.0, 2.0, 0.0);
               }
            }
         }

         dis = range * 0.5 - 8.0;
         double var51 = Math.toRadians(Math.random() * 360.0);
         double var53 = Math.toRadians((Math.random() - 0.5) * 180.0);
         boolean var40 = Math.random() < 0.5;

         for(int index0 = 0; index0 < 72; ++index0) {
            if (Math.random() < 0.25) {
               double var46;
               double var49;
               double var57;
               if (var40) {
                  var46 = var60 + Math.cos(rad) * (Math.cos(var53) + Math.abs(Math.sin(var51) * Math.sin(var53))) * dis;
                  var57 = var61 + Math.abs(Math.sin(rad) * Math.sin(var53) * -1.0 * dis);
                  var49 = var62 + Math.sin(rad) * (Math.cos(var53) + Math.abs(Math.cos(var51) * Math.sin(var53))) * dis;
               } else {
                  var46 = var60 + Math.cos(rad) * Math.cos(var53) * dis;
                  var57 = var61 + Math.abs(Math.sin(rad) * dis);
                  var49 = var62 + Math.cos(rad) * Math.sin(var53) * dis;
               }

               if (!entity.getPersistentData().m_128471_("Failed") && var42 % 40.0 == 0.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID.get(), var46, var57, var49, 1, 1.5, 1.5, 1.5, 0.0);
               }

               if (Math.random() < 0.5 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123810_, var46, var57, var49, 1, 0.5, 0.5, 0.5, 0.0);
               }

               if (Math.random() < 0.5 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123809_, var46, var57, var49, 1, 0.5, 0.5, 0.5, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123760_, var46, var57, var49, 1, 0.5, 0.5, 0.5, 0.0);
               }
            }

            rad += Math.toRadians(10.0 * Math.random());
         }

         double var44 = Math.toRadians(90.0 * (var42 % 4.0));
         double var41 = 4.0 * var42 % (range * 0.5 - 5.0);

         for(int index1 = 0; index1 < 5; ++index1) {
            for(int index2 = 0; index2 < 72; ++index2) {
               var44 += Math.toRadians(10.0 * Math.random());
               if (Math.random() < 0.025) {
                  double var47 = var60 + Math.cos(var44) * var41;
                  double var58 = var61 + 0.5;
                  double var50 = var62 + Math.sin(var44) * var41;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123810_, var47, var58, var50, 1, 0.2, 0.2, 0.2, 0.0);
                  }
               }
            }

            ++var41;
         }

      }
   }
}
