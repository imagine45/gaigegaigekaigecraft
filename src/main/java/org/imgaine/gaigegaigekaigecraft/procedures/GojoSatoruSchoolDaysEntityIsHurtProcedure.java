package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GojoSatoruSchoolDaysEntityIsHurtProcedure {
   public GojoSatoruSchoolDaysEntityIsHurtProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double dis = 0.0;
         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21223_();
         } else {
            var10000 = -1.0F;
         }

         double var41 = (double)var10000;
         float var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var41 <= (double)var10001 * 0.75) {
            ItemStack var42;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var42 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var42 = ItemStack.f_41583_;
            }

            if (var42.m_204117_(ItemTags.create(new ResourceLocation("forge:blindfold")))) {
               if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46135_) && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity var43 = new ItemEntity;
                  double var10003 = entity.m_20185_();
                  double var10004 = entity.m_20186_() + (double)entity.m_20206_() * 0.9;
                  double var10005 = entity.m_20189_();
                  ItemStack var10006;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10006 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10006 = ItemStack.f_41583_;
                  }

                  var43.<init>(_level, var10003, var10004, var10005, var10006);
                  ItemEntity entityToSpawn = var43;
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
               }
            }

            if (entity instanceof GojoSatoruSchoolDaysEntity && entity.m_6084_()) {
               float var44;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var44 = _livEnt.m_21223_();
               } else {
                  var44 = -1.0F;
               }

               double var45 = (double)var44;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21233_();
               } else {
                  var10001 = -1.0F;
               }

               if (var45 <= (double)var10001 * 0.25 && entity.getPersistentData().m_128459_("skill") > 0.0) {
                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity _datEntL18 = (GojoSatoruSchoolDaysEntity)entity;
                     if ((Boolean)_datEntL18.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                        return;
                     }
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(GojoSatoruSchoolDaysEntity.DATA_awaking, true);
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(GojoSatoruSchoolDaysEntity.DATA_dying, true);
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Invulnerable:1b}");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, ItemStack.f_41583_);
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, ItemStack.f_41583_);
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, ItemStack.f_41583_);
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity animatable = (GojoSatoruSchoolDaysEntity)entity;
                     animatable.setTexture("gojo_satoru_school");
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     ((GojoSatoruSchoolDaysEntity)entity).setAnimation("death");
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(25.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.25, (double)entity.m_20205_() * 0.25, 0.5);
                  }
               }
            }
         }

      }
   }
}
