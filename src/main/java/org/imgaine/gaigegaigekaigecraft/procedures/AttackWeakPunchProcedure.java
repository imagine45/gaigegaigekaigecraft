package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackWeakPunchProcedure {
   public AttackWeakPunchProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean combo = false;
         double strength = 0.0;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double old_cnt6 = 0.0;
         double weapon_size = 0.0;
         double loop_num = 0.0;
         double attack_reach = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt6") < 0.0) {
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         } else {
            double var10001;
            double var10002;
            label151: {
               var10001 = entity.getPersistentData().m_128459_("cnt6");
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var10002 = 0.3;
                     break label151;
                  }
               }

               var10002 = 0.2;
            }

            CNT6 = 1.0 + var10001 * var10002;
         }

         int var10000;
         label146: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label146;
               }
            }

            var10000 = 0;
         }

         strength = (double)Math.min(var10000, 50) * CNT6;
         weapon_size = GetWeaponSizeProcedure.execute(entity);
         attack_reach = GetReachProcedure.execute(entity);
         range = ReturnEntitySizeProcedure.execute(entity);
         range = range * range * Math.sqrt(weapon_size * attack_reach);
         if (entity.getPersistentData().m_128459_("cnt1") < 2.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", 4.0);
            DamageFixProcedure.execute(entity);
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               ItemStack var76;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var76 = _livEnt.m_21205_();
               } else {
                  var76 = ItemStack.f_41583_;
               }

               if (var76.m_204117_(ItemTags.create(new ResourceLocation("forge:spear")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        BlockPos var78 = BlockPos.m_274561_(x, y, z);
                        SoundEvent var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var10004 = SoundSource.NEUTRAL;
                        float var10005 = (float)(range * 1.0);
                        ItemStack var10008;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10008 = _livEnt.m_21205_();
                        } else {
                           var10008 = ItemStack.f_41583_;
                        }

                        _level.m_5594_((Player)null, var78, var10003, var10004, var10005, (float)(1.0 / (weapon_size + var10008.m_41784_().m_128459_("Power"))));
                     } else {
                        SoundEvent var81 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var84 = SoundSource.NEUTRAL;
                        float var10006 = (float)(range * 1.0);
                        ItemStack var10009;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10009 = _livEnt.m_21205_();
                        } else {
                           var10009 = ItemStack.f_41583_;
                        }

                        _level.m_7785_(x, y, z, var81, var84, var10006, (float)(1.0 / (weapon_size + var10009.m_41784_().m_128459_("Power"))), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     BlockPos var79 = BlockPos.m_274561_(x, y, z);
                     SoundEvent var80 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var82 = SoundSource.NEUTRAL;
                     float var85 = (float)(range * 0.25);
                     ItemStack var88;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var88 = _livEnt.m_21205_();
                     } else {
                        var88 = ItemStack.f_41583_;
                     }

                     _level.m_5594_((Player)null, var79, var80, var82, var85, (float)(1.0 / (weapon_size + var88.m_41784_().m_128459_("Power"))));
                  } else {
                     SoundEvent var83 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var86 = SoundSource.NEUTRAL;
                     float var87 = (float)(range * 0.25);
                     ItemStack var89;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var89 = _livEnt.m_21205_();
                     } else {
                        var89 = ItemStack.f_41583_;
                     }

                     _level.m_7785_(x, y, z, var83, var86, var87, (float)(1.0 / (weapon_size + var89.m_41784_().m_128459_("Power"))), false);
                  }
               }

               label136: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entity;
                     if (_livingEntity22.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var77 = _livingEntity22.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                        break label136;
                     }
                  }

                  var77 = 0.0;
               }

               if (var77 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entity;
                     if (_livingEntity24.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity24.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(100.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity26 = (LivingEntity)entity;
                     if (_livingEntity26.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity26.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(entity.getPersistentData().m_128459_("cnt5"));
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               entity.getPersistentData().m_128347_("x_pos", x);
               entity.getPersistentData().m_128347_("y_pos", Math.max(y, entity.m_20186_() + (double)entity.m_20206_() * 0.75));
               entity.getPersistentData().m_128347_("z_pos", z);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 0.5 * range);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 0.5 * range);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 0.5 * range);
               loop_num = Math.max(11.0 * attack_reach, 1.0);
               combo = entity.getPersistentData().m_128459_("cnt5") > 0.0 && entity.getPersistentData().m_128459_("cnt5") < 100.0;
               old_cnt6 = entity.getPersistentData().m_128459_("cnt6");
               if (combo) {
                  entity.getPersistentData().m_128347_("cnt6", -1.0);
               }

               for(int index0 = 0; index0 < (int)loop_num; ++index0) {
                  entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128347_("Damage", 9.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", !combo ? 0.25 * (1.0 + Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.0) * 0.5) : 0.01);
                  entity.getPersistentData().m_128347_("Range", 2.0 * range);
                  entity.getPersistentData().m_128347_("effect", 5.0);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("cnt6", old_cnt6);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               weapon_size = GetWeaponSizeProcedure.execute(entity);
               attack_reach = GetReachProcedure.execute(entity);
               range = ReturnEntitySizeProcedure.execute(entity);
               range = range * range * Math.sqrt(weapon_size * attack_reach);
               dis = 2.5 * range;
               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
                  d = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                  entity.getPersistentData().m_128347_("BlockDamage", (0.1 + strength / 16.0) * Math.max(d * 0.25, 1.0));
                  entity.getPersistentData().m_128347_("BlockRange", Math.max(1.0 * range, Math.max(d * 0.5, 1.0)));
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("knockback", 0.25 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.4));
                  entity.getPersistentData().m_128347_("Range", Math.max(6.0 * range, Math.max(d * 1.0, 1.0)));
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") >= 10.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
