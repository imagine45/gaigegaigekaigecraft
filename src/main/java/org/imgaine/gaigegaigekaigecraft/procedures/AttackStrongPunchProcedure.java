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

public class AttackStrongPunchProcedure {
   public AttackStrongPunchProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double var10001;
         double var10002;
         label130: {
            boolean logic_a = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            double strength = 0.0;
            double range = 0.0;
            double loop_num = 0.0;
            double CNT6 = 0.0;
            double entity_size = 0.0;
            double weapon_size = 0.0;
            double attack_reach = 0.0;
            double d = 0.0;
            double effectConfirm = 0.0;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            var10001 = entity.getPersistentData().m_128459_("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label130;
               }
            }

            var10002 = 0.2;
         }

         double var58;
         int var10000;
         label125: {
            var58 = 1.0 + var10001 * var10002;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label125;
               }
            }

            var10000 = 0;
         }

         double var53 = (double)Math.min(var10000, 50) * var58;
         double var59 = GetWeaponSizeProcedure.execute(entity);
         double var61 = GetReachProcedure.execute(entity);
         double var54 = ReturnEntitySizeProcedure.execute(entity);
         var54 = var54 * var54 * var59;
         if (entity.getPersistentData().m_128459_("cnt1") < 8.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", 5.0);
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
               ItemStack var77;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var77 = _livEnt.m_21205_();
               } else {
                  var77 = ItemStack.f_41583_;
               }

               if (var77.m_204117_(ItemTags.create(new ResourceLocation("forge:spear")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        BlockPos var79 = BlockPos.m_274561_(x, y, z);
                        SoundEvent var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var10004 = SoundSource.NEUTRAL;
                        float var10005 = (float)(var54 * 1.0);
                        ItemStack var10008;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10008 = _livEnt.m_21205_();
                        } else {
                           var10008 = ItemStack.f_41583_;
                        }

                        _level.m_5594_((Player)null, var79, var10003, var10004, var10005, (float)(0.9 / (var59 + var10008.m_41784_().m_128459_("Power"))));
                     } else {
                        SoundEvent var82 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var85 = SoundSource.NEUTRAL;
                        float var10006 = (float)(var54 * 1.0);
                        ItemStack var10009;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10009 = _livEnt.m_21205_();
                        } else {
                           var10009 = ItemStack.f_41583_;
                        }

                        _level.m_7785_(x, y, z, var82, var85, var10006, (float)(0.9 / (var59 + var10009.m_41784_().m_128459_("Power"))), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     BlockPos var80 = BlockPos.m_274561_(x, y, z);
                     SoundEvent var81 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var83 = SoundSource.NEUTRAL;
                     float var86 = (float)(var54 * 0.25);
                     ItemStack var89;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var89 = _livEnt.m_21205_();
                     } else {
                        var89 = ItemStack.f_41583_;
                     }

                     _level.m_5594_((Player)null, var80, var81, var83, var86, (float)(0.9 / (var59 + var89.m_41784_().m_128459_("Power"))));
                  } else {
                     SoundEvent var84 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var87 = SoundSource.NEUTRAL;
                     float var88 = (float)(var54 * 0.25);
                     ItemStack var90;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var90 = _livEnt.m_21205_();
                     } else {
                        var90 = ItemStack.f_41583_;
                     }

                     _level.m_7785_(x, y, z, var84, var87, var88, (float)(0.9 / (var59 + var90.m_41784_().m_128459_("Power"))), false);
                  }
               }

               label115: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entity;
                     if (_livingEntity20.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var78 = _livingEntity20.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                        break label115;
                     }
                  }

                  var78 = 0.0;
               }

               if (var78 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entity;
                     if (_livingEntity22.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity22.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-6.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity23 = (LivingEntity)entity;
                     if (_livingEntity23.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity23.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               entity.getPersistentData().m_128347_("x_pos", x);
               entity.getPersistentData().m_128347_("y_pos", Math.max(y, entity.m_20186_() + (double)entity.m_20206_() * 0.75));
               entity.getPersistentData().m_128347_("z_pos", z);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 0.5 * var54);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 0.5 * var54);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 0.5 * var54);
               double var57 = Math.max(11.0 * var61, 1.0);

               for(int index0 = 0; index0 < (int)var57; ++index0) {
                  entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
                  double var44 = entity.getPersistentData().m_128459_("x_pos");
                  double var46 = entity.getPersistentData().m_128459_("y_pos");
                  double var48 = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128347_("Damage", 11.0 * var58);
                  entity.getPersistentData().m_128347_("knockback", 1.5 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                  entity.getPersistentData().m_128347_("Range", 2.0 * var54);
                  entity.getPersistentData().m_128347_("effect", 5.0);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, var44, var46, var48, entity);
               }

               double var50 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var51 = Math.toRadians((double)entity.m_146909_());
               var59 = GetWeaponSizeProcedure.execute(entity);
               var61 = GetReachProcedure.execute(entity);
               var54 = Math.pow(ReturnEntitySizeProcedure.execute(entity), 2.0) * Math.sqrt(var59 * var61);
               double var52 = 2.5 * var54;
               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var52)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  double var45 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var52)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                  double var47 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var52)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
                  double var49 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var52)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
                  double var63 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                  entity.getPersistentData().m_128347_("BlockDamage", (0.1 + var53 / 16.0) * Math.max(var63 * 0.25, 1.0));
                  entity.getPersistentData().m_128347_("BlockRange", Math.max(1.0 * var54, Math.max(var63 * 0.5, 1.0)));
                  BlockDestroyAllDirectionProcedure.execute(world, var45, var47, var49, entity);
                  entity.getPersistentData().m_128347_("knockback", 0.25 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.4));
                  entity.getPersistentData().m_128347_("Range", Math.max(6.0 * var54, Math.max(var63 * 1.0, 1.0)));
                  KnockbackProcedure.execute(world, var45, var47, var49, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 17.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
