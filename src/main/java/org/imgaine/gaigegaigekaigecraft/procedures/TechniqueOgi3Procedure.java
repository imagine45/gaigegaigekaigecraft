package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
         double CNT6 = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + entity.getPersistentData().getDouble("cnt10"));
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0 && entity.getDeltaMovement().y() >= -0.5 && entity.getDeltaMovement().y() < 0.75) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 1.25, entity.getDeltaMovement().z()));
         }

         if ((entity.getPersistentData().getDouble("cnt1") > 20.0 || entity.getDeltaMovement().y() <= 0.0) && entity.getPersistentData().getDouble("cnt4") == 0.0) {
            entity.getPersistentData().putDouble("cnt4", 1.0);
            entity.getPersistentData().putDouble("cnt5", 0.0);
         }

         if (entity.getPersistentData().getDouble("cnt4") != 0.0) {
            if (entity.getPersistentData().getDouble("cnt5") == 0.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  double var82 = ((Entity)var10000).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var82 + (double)((Entity)var10001).getBbHeight() * 0.5;
                  LivingEntity var83;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var83 = _mobEnt.getTarget();
                  } else {
                     var83 = null;
                  }

                  z_pos = ((Entity)var83).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().putDouble("cnt5", 1.0);
               entity.getPersistentData().putDouble("cnt2", (double)(entity.getXRot() - 120.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               entity.setYRot((float)yaw);
               entity.setXRot((float)Math.max(pitch, 45.0));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entity.getPersistentData().putBoolean("canFly", true);
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               GetPowerFixProcedure.execute(entity);
               entity.setYRot((float)yaw);
               entity.setXRot((float)pitch);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            } else {
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.5, entity.getPersistentData().getDouble("y_power") * 1.5, entity.getPersistentData().getDouble("z_power") * 1.5));
            }

            for(int index0 = 0; index0 < 4; ++index0) {
               dis = 2.0;

               for(int index1 = 0; index1 < (int)(4.0 * range); ++index1) {
                  for(int index2 = 0; index2 < 4; ++index2) {
                     if (Math.random() < 0.5) {
                        rad = Math.toRadians(entity.getPersistentData().getDouble("cnt2"));
                        rad_now = Math.toRadians((double)(entity.getYRot() + 90.0F));
                        x_pos = entity.getX() + Math.cos(rad) * Math.cos(rad_now) * dis;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(rad) * -1.0 * dis;
                        z_pos = entity.getZ() + Math.cos(rad) * Math.sin(rad_now) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.1, 2.0 * range, 10.0, 4.0, x_pos, x_pos + Math.cos(rad) * Math.cos(rad_now) * dis, y_pos, y_pos + Math.sin(rad) * -1.0 * dis, z_pos, z_pos + Math.cos(rad) * Math.sin(rad_now) * dis, "gaigegaigekaigecraft:particle_curse_power_blue");
                     }

                     dis += Math.random() * 0.5;
                  }

                  entity.getPersistentData().putDouble("Damage", 16.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 4.0);
                  entity.getPersistentData().putDouble("knockback", 1.5);
                  entity.getPersistentData().putDouble("effect", 5.0);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  entity.getPersistentData().putBoolean("swing", true);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (y_pos < entity.getY() + (double)entity.getBbHeight() * 0.5 && (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() || entity.getPersistentData().getDouble("cnt3") > 0.0)) {
                     CompoundTag var84;
                     int var10003;
                     label163: {
                        var84 = entity.getPersistentData();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label163;
                           }
                        }

                        var10003 = 0;
                     }

                     var84.putDouble("BlockDamage", 0.25 + (double)var10003 * 0.5);
                     entity.getPersistentData().putDouble("BlockRange", 2.0);
                     entity.getPersistentData().putBoolean("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)(15.0 * range), 0.3 * range, 0.3, 0.3 * range, 0.5 * range);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(4.0 * range), 0.3 * range, 0.3, 0.3 * range, 0.5 * range);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                        }
                     }

                     entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  }
               }

               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + Math.random() * 10.0);
               if (entity.getPersistentData().getDouble("cnt2") > (double)(entity.getXRot() + 45.0F)) {
                  entity.getPersistentData().putDouble("cnt2", (double)(entity.getXRot() + 45.0F));
               }
            }

            if (entity.onGround()) {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity84 = (LivingEntity)entity;
               if (_livingEntity84.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity84.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity85 = (LivingEntity)entity;
               if (_livingEntity85.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity85.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().getDouble("cnt6") == 0.0) {
               entity.getPersistentData().putDouble("cnt6", 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity89 = (LivingEntity)entity;
                  if (_livingEntity89.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity89.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 60.0 || entity.getPersistentData().getDouble("cnt3") > 20.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
