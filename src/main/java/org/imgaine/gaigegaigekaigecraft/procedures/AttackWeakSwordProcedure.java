package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackSlashEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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

public class AttackWeakSwordProcedure {
   public AttackWeakSwordProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean combo = false;
         ItemStack item_a = ItemStack.f_41583_;
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
         double attack_reach = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
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
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt6") < 0.0) {
               CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            } else {
               double var10001;
               double var10002;
               label198: {
                  var10001 = entity.getPersistentData().m_128459_("cnt6");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var10002 = 0.3;
                        break label198;
                     }
                  }

                  var10002 = 0.2;
               }

               CNT6 = 1.0 + var10001 * var10002;
            }

            int var10000;
            label191: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label191;
                  }
               }

               var10000 = 0;
            }

            strength = (double)Math.min(var10000, 50) * CNT6;
            weapon_size = GetWeaponSizeProcedure.execute(entity);
            attack_reach = GetReachProcedure.execute(entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            range = range * range * Math.sqrt(weapon_size * attack_reach);
            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               if (entity.getPersistentData().m_128459_("cnt5") != 0.0 && !(entity.getPersistentData().m_128459_("cnt5") >= 100.0)) {
                  entity.getPersistentData().m_128347_("cnt4", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6));
               } else {
                  entity.getPersistentData().m_128347_("cnt4", (double)(Math.random() < 0.5 ? 1 : 5));
               }

               label179: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity19 = (LivingEntity)entity;
                     if (_livingEntity19.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var72 = _livingEntity19.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                        break label179;
                     }
                  }

                  var72 = 0.0;
               }

               if (var72 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity21 = (LivingEntity)entity;
                     if (_livingEntity21.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity21.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(100.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity23 = (LivingEntity)entity;
                     if (_livingEntity23.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity23.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(entity.getPersistentData().m_128459_("cnt4"));
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               dis = 2.5 * range;
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis);
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * dis);
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               ItemStack var73;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var73 = _livEnt.m_21205_();
               } else {
                  var73 = ItemStack.f_41583_;
               }

               item_a = var73.m_41777_();
               if (item_a.m_41784_().m_128461_("color3").equals("flame") && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_SLASH.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("color3", item_a.m_41784_().m_128461_("color3"));
                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        EntityAttackSlashEntity animatable = (EntityAttackSlashEntity)entityinstance;
                        animatable.setTexture("slash_flame");
                     }

                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        EntityAttackSlashEntity var74 = (EntityAttackSlashEntity)entityinstance;
                        CompoundTag var75 = entity.getPersistentData();
                        var74.setAnimation("idle" + Math.round(var75.m_128459_("cnt4")));
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity54 = (LivingEntity)entityinstance;
                        if (_livingEntity54.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity54.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(3.0 * range);
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
                  }
               }

               if (item_a.m_204117_(ItemTags.create(new ResourceLocation("minecraft:swords"))) && !item_a.m_204117_(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))) && (entity.getPersistentData().m_128459_("cnt5") >= 100.0 || entity.getPersistentData().m_128459_("cnt5") == 0.0 && entity.getPersistentData().m_128459_("cnt6") >= 2.5) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(range * 0.5), (float)(1.0 / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(range * 0.5), (float)(1.0 / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
                  }
               }

               if ((item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:metallic"))) || item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:whip")))) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
                  }
               }

               combo = entity.getPersistentData().m_128459_("cnt5") > 0.0 && entity.getPersistentData().m_128459_("cnt5") < 100.0;
               entity.getPersistentData().m_128347_("Damage", 9.0 * CNT6);
               entity.getPersistentData().m_128347_("knockback", !combo ? 0.25 * (1.0 + Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.0) * 0.5) : 0.01);
               entity.getPersistentData().m_128347_("Range", 6.0 * range);
               entity.getPersistentData().m_128347_("effect", 5.0);
               entity.getPersistentData().m_128347_("projectile_type", 1.0);
               entity.getPersistentData().m_128379_("attack", true);
               old_cnt6 = entity.getPersistentData().m_128459_("cnt6");
               if (combo) {
                  entity.getPersistentData().m_128347_("cnt6", -1.0);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("cnt6", old_cnt6);
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

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
