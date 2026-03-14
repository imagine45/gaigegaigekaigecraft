package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackStrongMahitoProcedure {
   public AttackStrongMahitoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean player = false;
         String color3 = "";
         String color1 = "";
         String color2 = "";
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
         double count = 0.0;
         double counter = 0.0;
         double size = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double attack_reach = 0.0;
         double dis_start = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         player = entity instanceof Player;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt1") <= 7.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 6.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  dis = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  if (dis > 1.0 && dis < 4.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") == 0.0) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 6.0));
               }

               if (entity.getPersistentData().m_128459_("cnt6") > 5.0) {
                  entity.getPersistentData().m_128347_("cnt6", 5.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  strength = 0.5;
               } else if (entity.getPersistentData().m_128459_("cnt6") == 5.0) {
                  strength = 0.2;
               } else {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.125);
                  if (entity.getPersistentData().m_128459_("cnt6") == 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                  }

                  strength = 0.1;
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= 6.0) {
                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     ChargeParticleProcedure.execute(world, entity, 10.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }
               }
            }
         }

         int var101;
         label174: {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var101 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label174;
               }
            }

            var101 = 0;
         }

         strength = (double)Math.min(var101, 50) * CNT6;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + strength * 0.025);
         if (entity.getPersistentData().m_128459_("cnt1") < 8.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               entity.getPersistentData().m_128347_("cnt5", (double)(entity.m_146908_() + 15.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity43 = (LivingEntity)entity;
                  if (_livingEntity43.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity43.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-5.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            range = ReturnEntitySizeProcedure.execute(entity);
            if (entity.getPersistentData().m_128459_("cnt2") < 4.0) {
               color1 = "1 1 1 1";
               color2 = "0.75 0.75 0.75 1";
               size = Math.max(ReturnEntitySizeProcedure.execute(entity), 0.01);
               attack_reach = GetReachProcedure.execute(entity);
               dis_start = 1.7;
               rad_now = Math.toRadians((double)entity.m_146909_());
               yaw_now = Math.toRadians((double)(entity.m_146908_() + 90.0F));

               for(int index0 = 0; (long)index0 < Math.round(10.0 * size); ++index0) {
                  rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt5") + entity.getPersistentData().m_128459_("cnt4"));
                  dis = dis_start;
                  count = 0.0;
                  counter = 0.0;
                  x_power = Math.cos(rad) * (Math.cos(rad_now) + Math.abs(Math.sin(yaw_now) * Math.sin(rad_now)));
                  y_power = Math.sin(Math.toRadians(entity.getPersistentData().m_128459_("cnt4"))) * Math.sin(rad_now) * -1.0;
                  z_power = Math.sin(rad) * (Math.cos(rad_now) + Math.abs(Math.cos(yaw_now) * Math.sin(rad_now)));
                  ParticleGeneratorProcedure.execute(world, range * 0.1, 2.0 * range, 5.0, 2.0, entity.m_20185_() + x_power * dis_start, entity.m_20185_() + x_power * dis_start + x_power, entity.m_20186_() + (double)entity.m_20206_() * 0.75 + y_power * dis_start, entity.m_20186_() + (double)entity.m_20206_() * 0.75 + y_power * dis_start + y_power, entity.m_20189_() + z_power * dis_start, entity.m_20189_() + z_power * dis_start + z_power, "minecraft:cloud");

                  for(int index1 = 0; (long)index1 < Math.round(20.0 * attack_reach * size * CNT6); ++index1) {
                     x_pos = entity.m_20185_() + x_power * dis;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + y_power * dis;
                     z_pos = entity.m_20189_() + z_power * dis;
                     ++count;
                     counter -= 0.25;
                     if (counter <= 0.0) {
                        counter = 0.5;
                        entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
                        entity.getPersistentData().m_128347_("knockback", 1.5 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                        entity.getPersistentData().m_128347_("Range", 4.0);
                        entity.getPersistentData().m_128347_("effect", 5.0);
                        entity.getPersistentData().m_128347_("projectile_type", 1.0);
                        entity.getPersistentData().m_128379_("attack", true);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 4, 0.1, 0.1, 0.1, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 4, 0.1, 0.1, 0.1, 0.5);
                        }

                        entity.getPersistentData().m_128347_("BlockDamage", 2.0 + strength / 8.0);
                        entity.getPersistentData().m_128347_("BlockRange", 1.0);
                        if (!logic_a) {
                           logic_a = true;
                           entity.getPersistentData().m_128379_("noEffect", false);
                        } else {
                           entity.getPersistentData().m_128379_("noEffect", true);
                        }

                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                           break;
                        }
                     }

                     dis += 0.5;
                  }

                  entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + Math.random() * 10.0 / size);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") > 10.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
