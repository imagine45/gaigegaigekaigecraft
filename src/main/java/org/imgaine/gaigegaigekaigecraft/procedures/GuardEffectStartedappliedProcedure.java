package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DagonEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GuardEffectStartedappliedProcedure {
   public GuardEffectStartedappliedProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double num1 = 0.0;
         double num2 = 0.0;
         double speed = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num3 = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_skill = 0.0;
         if (entity.m_6084_()) {
            if (LogicStartPassiveProcedure.execute(entity)) {
               label96: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt1 = (LivingEntity)entity;
                     if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label96;
                     }
                  }

                  num1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                  num2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                  old_skill = entity.getPersistentData().m_128459_("skill");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        CompoundTag var10000;
                        int var10003;
                        label80: {
                           entity.getPersistentData().m_128347_("skill", 1.0);
                           var10000 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                 var10003 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                 break label80;
                              }
                           }

                           var10003 = 0;
                        }

                        var10000.m_128347_("Damage", (double)(6 + var10003 * 3));
                        entity.getPersistentData().m_128347_("Range", (double)(entity.m_20205_() + 12.0F));
                        entity.getPersistentData().m_128347_("effect", 2.0);
                        entity.getPersistentData().m_128347_("knockback", 0.25);
                        entity.getPersistentData().m_128347_("projectile_type", 1.0);
                        entity.getPersistentData().m_128379_("onlyRanged", true);
                        RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                        entity.getPersistentData().m_128379_("onlyRanged", false);
                     }
                  }

                  label92: {
                     if (num1 != 8.0 && num2 != 8.0) {
                        if (!(entity instanceof DagonEntity)) {
                           break label92;
                        }

                        int var46;
                        if (entity instanceof DagonEntity) {
                           DagonEntity _datEntI = (DagonEntity)entity;
                           var46 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
                        } else {
                           var46 = 0;
                        }

                        if (var46 <= 0) {
                           break label92;
                        }
                     }

                     CompoundTag var47;
                     int var48;
                     label66: {
                        entity.getPersistentData().m_128347_("skill", 1.0);
                        var47 = entity.getPersistentData();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              var48 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                              break label66;
                           }
                        }

                        var48 = 0;
                     }

                     var47.m_128347_("Damage", (double)(6 + var48 * 3) * 0.25);
                     num1 = Math.toRadians(Math.random() * 360.0);
                     num2 = (double)entity.m_20205_() + 1.5;

                     for(int index0 = 0; index0 < 72; ++index0) {
                        if (Math.random() < 0.5) {
                           x_pos = entity.m_20185_() + Math.sin(num1) * num2;
                           y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                           z_pos = entity.m_20189_() + Math.cos(num1) * num2;
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_water_no_gravity ~ ~ ~ 0.1 0.1 0.1 0 1 force");
                           }
                        }

                        num1 += Math.toRadians(Math.random() * 10.0);
                     }

                     entity.getPersistentData().m_128347_("Range", ((double)entity.m_20205_() + 1.5) * 2.0 + 3.0);
                     entity.getPersistentData().m_128347_("knockback", 0.25);
                     entity.getPersistentData().m_128347_("projectile_type", 1.0);
                     entity.getPersistentData().m_128379_("onlyRanged", true);
                     RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                     entity.getPersistentData().m_128379_("onlyRanged", false);
                     entity.getPersistentData().m_128347_("knockback", 0.25);
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     KnockbackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                     entity.getPersistentData().m_128347_("knockback", 0.0);
                     entity.getPersistentData().m_128347_("effect", 0.0);
                  }

                  entity.getPersistentData().m_128347_("skill", old_skill);
                  if (num1 == 38.0 || num2 == 38.0 || entity instanceof UroTakakoEntity) {
                     UroCounterProcedure.execute(world, entity);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               GuardSetDamageProcedure.execute(entity);
            }
         }

      }
   }
}
