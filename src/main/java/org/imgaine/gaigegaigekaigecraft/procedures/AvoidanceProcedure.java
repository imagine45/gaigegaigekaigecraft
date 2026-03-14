package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AvoidanceProcedure {
   public AvoidanceProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double distance = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double CNT6 = 0.0;
         double degree = 0.0;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            if (entity.getPersistentData().m_128459_("cnt2") > 0.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            }

            entity.getPersistentData().m_128347_("skill", 0.0);
         } else {
            if (entity.getPersistentData().m_128459_("cnt2") == 0.0 && entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt1", 3.0);
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity11 = (LivingEntity)entity;
                  if (_livingEntity11.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity11.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-20.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity12 = (LivingEntity)entity;
                  if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity12.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entity;
                     if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(1.0);
                     }
                  }
               } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D") && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity18 = (LivingEntity)entity;
                  if (_livingEntity18.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity18.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(2.0);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_W")) {
                  degree = Math.toRadians(0.0);
                  if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree += Math.toRadians(45.0);
                  } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree -= Math.toRadians(45.0);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entity;
                     if (_livingEntity24.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity24.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(3.0);
                     }
                  }
               } else if (entity.getPersistentData().m_128471_("PRESS_S")) {
                  degree = Math.toRadians(180.0);
                  if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree -= Math.toRadians(45.0);
                  } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree += Math.toRadians(45.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt3", 1.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity31 = (LivingEntity)entity;
                        if (_livingEntity31.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity31.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                        }
                     }
                  }
               } else if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                  degree += Math.toRadians(90.0);
               } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D")) {
                  degree -= Math.toRadians(90.0);
               } else {
                  degree = Math.toRadians(180.0);
               }

               yaw += degree;
               PlayAnimationProcedure.execute(world, entity);
               pitch = Math.toRadians(0.0);
               distance = 999.0;
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(10.0 * range), range * 0.25, 0.1, range * 0.25, 0.5);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") > 0.0) {
               if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                     }
                  }
               } else if (entity.getPersistentData().m_128459_("cnt2") >= 7.0) {
                  if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                        }
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(1.0 * range), range * 0.1, 0.1, range * 0.1, 0.2);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
                  }
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * 0.75;
               y_power = entity.getPersistentData().m_128459_("y_power") * 0.75;
               z_power = entity.getPersistentData().m_128459_("z_power") * 0.75;
               if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("cnt6", -1.0);

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", 9.0);
                  entity.getPersistentData().m_128347_("Range", 4.0 * range);
                  entity.getPersistentData().m_128347_("knockback", 0.75);
                  entity.getPersistentData().m_128347_("effect", 5.0);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128379_("attack", true);
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            }
         }

      }
   }
}
