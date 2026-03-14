package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi3Procedure {
   public TechniqueOgi3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         double dis = 0.0;
         double rad = 0.0;
         double tsuki7_mode = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos2 = 0.0;
         double y_pos2 = 0.0;
         double z_pos2 = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double x_center = 0.0;
         double y_center = 0.0;
         double z_center = 0.0;
         double y_fix = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.f_19789_ = 0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0 && entity.m_20184_().m_7098_() >= -0.5 && entity.m_20184_().m_7098_() < 0.75) {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), 1.25, entity.m_20184_().m_7094_()));
         }

         if ((entity.getPersistentData().m_128459_("cnt1") > 20.0 || entity.m_20184_().m_7098_() <= 0.0) && entity.getPersistentData().m_128459_("cnt4") == 0.0) {
            entity.getPersistentData().m_128347_("cnt4", 1.0);
            entity.getPersistentData().m_128347_("cnt5", 0.0);
         }

         if (entity.getPersistentData().m_128459_("cnt4") != 0.0) {
            if (entity.getPersistentData().m_128459_("cnt5") == 0.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  double var85 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var85 + (double)((Entity)var10001).m_20206_() * 0.5;
                  LivingEntity var86;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var86 = _mobEnt.m_5448_();
                  } else {
                     var86 = null;
                  }

                  z_pos = ((Entity)var86).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("cnt5", 1.0);
               entity.getPersistentData().m_128347_("cnt2", (double)(entity.m_146909_() - 120.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)Math.max(pitch, 45.0));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128379_("canFly", true);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               GetPowerFixProcedure.execute(entity);
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)pitch);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            } else {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.5, entity.getPersistentData().m_128459_("y_power") * 1.5, entity.getPersistentData().m_128459_("z_power") * 1.5));
            }

            for(int index0 = 0; index0 < 4; ++index0) {
               dis = 2.0;

               for(int index1 = 0; index1 < 16; ++index1) {
                  if (Math.random() < 0.5) {
                     rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt2"));
                     rad_now = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     x_pos = entity.m_20185_() + Math.cos(rad) * Math.cos(rad_now) * dis;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5 + Math.sin(rad) * -1.0 * dis;
                     z_pos = entity.m_20189_() + Math.cos(rad) * Math.sin(rad_now) * dis;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 4, 0.05, 0.1, 0.05, 0.1);
                     }

                     ParticleGeneratorProcedure.execute(world, range * 0.1, 2.0 * range, 10.0, 1.0, x_pos, x_pos + Math.cos(rad) * Math.cos(rad_now) * dis, y_pos, y_pos + Math.sin(rad) * -1.0 * dis, z_pos, z_pos + Math.cos(rad) * Math.sin(rad_now) * dis, "minecraft:flame");
                     entity.getPersistentData().m_128347_("Damage", 16.0);
                     entity.getPersistentData().m_128347_("Range", 4.0);
                     entity.getPersistentData().m_128347_("knockback", 1.5);
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128347_("projectile_type", 1.0);
                     entity.getPersistentData().m_128379_("swing", true);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (y_pos < entity.m_20186_() + (double)entity.m_20206_() * 0.5 && (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() || entity.getPersistentData().m_128459_("cnt3") > 0.0)) {
                        CompoundTag var87;
                        int var10003;
                        label154: {
                           var87 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label154;
                              }
                           }

                           var10003 = 0;
                        }

                        var87.m_128347_("BlockDamage", 0.25 + (double)var10003 * 0.5);
                        entity.getPersistentData().m_128347_("BlockRange", 2.0);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 15, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 4, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                     }
                  }

                  dis += Math.random() * 0.5;
               }

               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + Math.random() * 10.0);
               if (entity.getPersistentData().m_128459_("cnt2") > (double)(entity.m_146909_() + 45.0F)) {
                  entity.getPersistentData().m_128347_("cnt2", (double)(entity.m_146909_() + 45.0F));
               }
            }

            if (entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity83 = (LivingEntity)entity;
               if (_livingEntity83.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity83.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-8.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity84 = (LivingEntity)entity;
               if (_livingEntity84.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity84.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(2.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else {
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().m_128459_("cnt6") == 0.0) {
               entity.getPersistentData().m_128347_("cnt6", 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity88 = (LivingEntity)entity;
                  if (_livingEntity88.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity88.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 60.0 || entity.getPersistentData().m_128459_("cnt3") > 20.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
