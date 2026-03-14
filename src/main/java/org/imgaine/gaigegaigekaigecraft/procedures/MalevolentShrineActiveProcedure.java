package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MalevolentShrineActiveProcedure {
   public MalevolentShrineActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double count_A;
         double var10000;
         int var10001;
         label158: {
            String STR1 = "";
            double old_skill = 0.0;
            count_A = 0.0;
            double z_center = 0.0;
            double range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double y_center = 0.0;
            double dis = 0.0;
            double dust_amount = 0.0;
            double x_center = 0.0;
            double num1 = 0.0;
            double y_pos = 0.0;
            double num2 = 0.0;
            var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                  break label158;
               }
            }

            var10001 = 0;
         }

         double var38 = var10000 * (double)(var10001 > 0 ? 18 : 2);
         double var35 = entity.getPersistentData().m_128459_("skill");
         double var39 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", 50.0);
         entity.getPersistentData().m_128347_("y_knockback", -0.1);

         for(int index0 = 0; index0 < 4; ++index0) {
            double var40;
            double var43;
            double var53;
            int var10002;
            label149: {
               double var50 = count_A % 2.0 == 0.0 ? 1.0 : -1.0;
               double var56 = count_A % 4.0 <= 1.0 ? 1.0 : -1.0;
               var40 = entity.getPersistentData().m_128459_("x_pos_doma") + var38 * 0.25 * var50;
               var53 = entity.getPersistentData().m_128459_("y_pos_doma") + var38 * 0.25 - 15.0;
               var43 = entity.getPersistentData().m_128459_("z_pos_doma") + var38 * 0.25 * var56;
               var70 = entity.getPersistentData();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label149;
                  }
               }

               var10002 = 0;
            }

            var70.m_128347_("skill", (double)(var10002 % 2 == 1 ? 105 : 106));
            entity.getPersistentData().m_128347_("Damage", 10.5);
            entity.getPersistentData().m_128347_("Range", var38 * 0.5);
            entity.getPersistentData().m_128347_("effect", 1.0);
            entity.getPersistentData().m_128347_("effectConfirm", 1.0);
            entity.getPersistentData().m_128347_("knockback", (Math.random() - 0.5) * 0.1);
            entity.getPersistentData().m_128379_("swing", false);
            entity.getPersistentData().m_128379_("attack", false);
            entity.getPersistentData().m_128379_("DomainAttack", true);
            entity.getPersistentData().m_128379_("ExtinctionBlock", true);
            RangeAttackProcedure.execute(world, var40, var53, var43, entity);
            ++count_A;
         }

         label141: {
            entity.getPersistentData().m_128379_("ExtinctionBlock", false);
            entity.getPersistentData().m_128347_("y_knockback", 0.0);
            entity.getPersistentData().m_128347_("skill", var35);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var39);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var71 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                  break label141;
               }
            }

            var71 = 0;
         }

         if (var71 > 0) {
            if (entity.getPersistentData().m_128459_("dust_amount") <= 0.0) {
               entity.getPersistentData().m_128347_("dust_amount", 1.0);
            }

            double var49 = entity.getPersistentData().m_128459_("x_pos_doma");
            double var46 = entity.getPersistentData().m_128459_("y_pos_doma");
            double var37 = entity.getPersistentData().m_128459_("z_pos_doma");
            double var51 = 0.0;

            for(int index1 = 0; index1 < 512; ++index1) {
               count_A = Math.toRadians(Math.random() * 360.0);
               double var47 = var38 * 0.5 * (Math.random() * 2.0 - 1.0);
               double var41 = var49 + Math.sin(count_A) * var47;
               double var54 = var46 + Math.random() * var38 * 0.2;
               double var44 = var37 + Math.cos(count_A) * var47;
               if (!world.m_46859_(BlockPos.m_274561_(var41, var54, var44))) {
                  entity.getPersistentData().m_128347_("dust_amount", Math.min(entity.getPersistentData().m_128459_("dust_amount") + 1.0, 200.0));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, var41, var54, var44, 2, 1.5, 1.5, 1.5, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SLASH.get(), var41, var54, var44, 2, 1.5, 1.5, 1.5, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, var41, var54, var44, 2, 1.5, 1.5, 1.5, 0.5);
                  }

                  entity.getPersistentData().m_128379_("noParticle", true);
                  entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                  entity.getPersistentData().m_128347_("BlockRange", 16.0);
                  entity.getPersistentData().m_128347_("BlockDamage", 99.0);
                  BlockDestroyAllDirectionProcedure.execute(world, var41, Math.max(var54, var46 + 8.0), var44, entity);
                  if (var51 < 32.0 || var51 / 512.0 < Math.random()) {
                     break;
                  }
               }

               ++var51;
            }

            double var48 = (double)Math.round(entity.getPersistentData().m_128459_("dust_amount") / 200.0 * 10.0);
            if (entity instanceof Player) {
               label117: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var72 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                        break label117;
                     }
                  }

                  var72 = 0;
               }

               if (var72 % 10 == 0) {
                  String _setval = "DUST";
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY1 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  _setval = "";
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  String _setval = "§l§4";
                  var51 = 0.0;

                  for(int index2 = 0; index2 < 10; ++index2) {
                     if (var51 == var48) {
                        _setval = _setval + "§r§7";
                     }

                     ++var51;
                     _setval = _setval + "■";
                  }

                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            double var42 = entity.getPersistentData().m_128459_("x_pos_doma");
            double var55 = entity.getPersistentData().m_128459_("y_pos_doma");
            double var45 = entity.getPersistentData().m_128459_("z_pos_doma");
            if (entity.getPersistentData().m_128459_("skill") == 107.0) {
               for(int index3 = 0; index3 < (int)(var48 + 1.0); ++index3) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123790_, var42, var55, var45, 50, var38 / 6.0, var38 / 6.0, var38 / 6.0, 0.5);
                  }
               }
            } else {
               for(int index4 = 0; index4 < (int)(var48 + 1.0); ++index4) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123783_, var42, var55, var45, 50, var38 / 6.0, var38 / 6.0, var38 / 6.0, 0.5);
                  }
               }
            }
         }

      }
   }
}
