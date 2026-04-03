package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MahoragaSwimmingProcedure {
   public MahoragaSwimmingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean garuda = false;
         double distance = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double yaw_cal = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double pitch_cal = 0.0;
         double old_cnt1 = 0.0;
         double old_skill = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         double dis = 0.0;
         if (entity.getPersistentData().getDouble("cnt10") == 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            entity.fallDistance = 0.0F;
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = (double)(64.0F + entity.getBbWidth());
            double var10000 = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            var10000 = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
            var10000 = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            LivingEntity var81;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var81 = _mobEnt.getTarget();
            } else {
               var81 = null;
            }

            if (var81 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var81 = _mobEnt.getTarget();
               } else {
                  var81 = null;
               }

               double var83 = ((Entity)var81).getX();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               double var86 = ((Entity)var10001).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var86 += (double)((Entity)var10002).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var83, var86, ((Entity)var10002).getZ(), entity);
            }

            yaw = (double)(entity.getYRot() % 360.0F);
            pitch = (double)entity.getXRot();
            RotateEntityProcedure.execute(entity.getX() + entity.getDeltaMovement().x() * 32.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getDeltaMovement().y() * 32.0, entity.getZ() + entity.getDeltaMovement().z() * 32.0, entity);
            entity.setYRot(entity.getYRot() % 360.0F);
            entity.setXRot(entity.getXRot());
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            yaw_cal = (double)entity.getYRot() - yaw;
            if ((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0))) {
               yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 8.0;
            } else {
               yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 8.0;
            }

            pitch_cal = Math.abs((double)entity.getXRot() - pitch);
            if (pitch > (double)entity.getXRot()) {
               pitch -= pitch_cal / 8.0;
            } else {
               pitch += pitch_cal / 8.0;
            }

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

            yaw = (double)(entity.getYRot() % 360.0F);
            pitch = (double)entity.getXRot();
            entity.setYRot((float)yaw);
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.5);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.5);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.5);

            for(int index0 = 0; index0 < (int)(36.0 * range); ++index0) {
               ParticleGeneratorCircleProcedure.execute(world, 1.0, (double)entity.getXRot(), Mth.nextDouble(RandomSource.create(), 0.0, 1.0) * range, Mth.nextDouble(RandomSource.create(), 0.0, 2.0) * range, Mth.nextDouble(RandomSource.create(), 8.0, 12.0), entity.getX(), entity.getX() - entity.getPersistentData().getDouble("x_power") * range, entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getY() + (double)entity.getBbHeight() * 0.25 - entity.getPersistentData().getDouble("y_power") * range, (double)entity.getYRot(), entity.getZ(), entity.getZ() - entity.getPersistentData().getDouble("z_power") * range, "minecraft:crit");
            }

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

            x_power = entity.getPersistentData().getDouble("x_power") * 1.0;
            y_power = entity.getPersistentData().getDouble("y_power") * 1.0;
            z_power = entity.getPersistentData().getDouble("z_power") * 1.0;
            entity.setDeltaMovement(new Vec3(x_power, entity.getDeltaMovement().y(), z_power));
            StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, x_power, y_power, z_power);
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis != 0.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var81 = _mobEnt.getTarget();
            } else {
               var81 = null;
            }

            if (var81 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
               if (GetDistanceProcedure.execute(entity) < 10.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 30.0 && !entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", 60.0);
            }

            x_pos = entity.getX();
            y_pos = entity.getY();
            z_pos = entity.getZ();

            for(int index1 = 0; index1 < (int)Math.max(dis, 1.0); ++index1) {
               entity.getPersistentData().putDouble("Damage", 6.0);
               entity.getPersistentData().putDouble("Range", 3.0 * range);
               entity.getPersistentData().putDouble("knockback", 1.5);
               entity.getPersistentData().putDouble("effect", 5.0);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
            }

            entity.getPersistentData().putBoolean("attack", true);
            if (entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
                  }
               }

               int var10004;
               CompoundTag var85;
               label137: {
                  var85 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10004 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label137;
                     }
                  }

                  var10004 = 0;
               }

               var85.putDouble("BlockDamage", 2.5 + 0.25 * (double)var10004);
               entity.getPersistentData().putDouble("BlockRange", (double)(entity.getBbHeight() + entity.getBbWidth()) * 0.5);
               entity.getPersistentData().putDouble("knockback", 1.0);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") % 14.0 == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity99 = (LivingEntity)entity;
                  if (_livingEntity99.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity99.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-22.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity100 = (LivingEntity)entity;
                  if (_livingEntity100.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity100.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "swim_butterfly");
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 60.0) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt5", 9.0);
               entity.getPersistentData().putDouble("cnt10", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt10") != 0.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
