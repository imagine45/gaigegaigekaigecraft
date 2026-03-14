package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackContinueProcedure {
   public AttackContinueProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean sword = false;
         boolean attack = false;
         boolean keep = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double old_skill = 0.0;
         double old_cnt1 = 0.0;
         double range = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         ItemStack item_a = ItemStack.f_41583_;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 1, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", 4.0);
            DamageFixProcedure.execute(entity);
            if ((((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 19.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19.0) && LogicStartPassiveProcedure.execute(entity)) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 9.0));
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            entity.getPersistentData().m_128347_("cnt2", 0.0);
            old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
            old_skill = entity.getPersistentData().m_128459_("skill");
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(0.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            num1 = 1.5;
            if (entity.getPersistentData().m_128459_("cnt5") <= 100.0) {
               if (entity.getPersistentData().m_128459_("cnt7") == 0.0 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 1, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 40.0) {
                  if (entity instanceof Player) {
                     keep = entity.getPersistentData().m_128471_("PRESS_Z");
                  } else {
                     LivingEntity var10000;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity && GetDistanceProcedure.execute(entity) < 4.0) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                           keep = true;
                        }
                     }

                     if (!keep) {
                        distance = 1.5 + (double)entity.m_20205_();
                        Vec3 _center = new Vec3(entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * distance, entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(2.0 * distance / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              keep = true;
                              break;
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt5") > 50.0) {
                     keep = false;
                  }

                  if (keep) {
                     old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
                  } else {
                     entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), 100.0));
                  }
               }

               ItemStack var58;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var58 = _livEnt.m_21205_();
               } else {
                  var58 = ItemStack.f_41583_;
               }

               label158: {
                  item_a = var58.m_41777_();
                  num2 = item_a.m_41720_() == ItemStack.f_41583_.m_41720_() ? 0.0 : Math.max(item_a.m_41784_().m_128459_("Power"), 0.0);
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 21.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 21.0) {
                        break label158;
                     }
                  } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                     break label158;
                  }

                  num2 -= 0.125;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt54 = (LivingEntity)entity;
                  if (_livEnt54.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                     num2 -= 0.125;
                  }
               }

               label148: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var59 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                        break label148;
                     }
                  }

                  var59 = 0;
               }

               if (var59 > 0) {
                  num2 -= 0.25;
               }

               if (item_a.m_41720_() != ItemStack.f_41583_.m_41720_()) {
                  num2 = Math.max(num2, 0.0);
               }

               attack = num2 >= 0.0 ? entity.getPersistentData().m_128459_("cnt5") % (double)(2L + Math.round(num2 / 0.25)) == 1.0 : true;
               if (attack || entity.getPersistentData().m_128459_("cnt5") >= 100.0) {
                  if (entity.getPersistentData().m_128459_("cnt5") >= 100.0) {
                     entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), 2.5));
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", -0.1 + entity.getPersistentData().m_128459_("cnt5") * 0.01);
                     x_pos += (Math.random() - 0.5) * num1 * range;
                     y_pos += (Math.random() - 0.5) * num1 * range;
                     z_pos += (Math.random() - 0.5) * num1 * range;
                  }

                  for(int index0 = 0; index0 < 2; ++index0) {
                     if (entity.getPersistentData().m_128459_("cnt5") >= 100.0) {
                        AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     } else {
                        AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (sword) {
                        break;
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", old_cnt1);
               entity.getPersistentData().m_128347_("skill", old_skill);
            } else if (entity.getPersistentData().m_128459_("cnt5") > 110.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
