package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTodoBlackFlashProcedure {
   public AttackTodoBlackFlashProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos;
         double y_pos;
         double z_pos;
         int var10000;
         label172: {
            boolean logic_a = false;
            boolean player = false;
            x_pos = 0.0;
            y_pos = 0.0;
            z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            double strength = 0.0;
            double range = 0.0;
            double loop_num = 0.0;
            double CNT6 = 0.0;
            double entity_size = 0.0;
            double distance = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            player = entity instanceof Player;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label172;
               }
            }

            var10000 = 0;
         }

         double var61 = (double)Math.min(var10000, 50);
         double var64 = ReturnEntitySizeProcedure.execute(entity);
         double var62 = var64 * (1.0 + var61 * 0.025);
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         entity.getPersistentData().putDouble("cnt6", 99999.0);
         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            LivingEntity var91;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var91 = _mobEnt.getTarget();
            } else {
               var91 = null;
            }

            if (var91 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.getTarget();
               } else {
                  var91 = null;
               }

               x_pos = ((Entity)var91).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.getTarget();
               } else {
                  var91 = null;
               }

               double var94 = ((Entity)var91).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var94 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var95;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var95 = _mobEnt.getTarget();
               } else {
                  var95 = null;
               }

               z_pos = ((Entity)var95).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               double var59 = GetDistanceProcedure.execute(entity);
               if (var59 > 4.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") >= 200.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 9.0));
               entity.getPersistentData().putBoolean("free", true);
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               GetPowerFixProcedure.execute(entity);
               if (entity.isShiftKeyDown()) {
                  entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 0.1);
                  entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 0.1);
                  entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 0.1);
               } else {
                  entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 0.2);
                  entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 0.2);
                  entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 0.2);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getDeltaMovement().y(), entity.getPersistentData().getDouble("z_power")));
            }

            PlayAnimationProcedure.execute(world, entity);
            double var55 = (double)entity.getYRot();
            double var57 = (double)entity.getXRot();
            entity.setYRot((float)var55);
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

            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            double var69 = entity.getLookAngle().x;
            double var65 = entity.getLookAngle().y;
            double var67 = entity.getLookAngle().z;
            ParticleGeneratorCircleProcedure.execute(world, 16.0 * var62, (double)entity.getXRot(), 1.0 * var62, 1.5 * var62, 4.0, x_pos, x_pos - var69 * var62, y_pos, y_pos - var65 * var62, (double)entity.getYRot(), z_pos, z_pos - var67 * var62, "minecraft:enchanted_hit");
            ParticleGeneratorProcedure.execute(world, var62 * 1.0, 8.0 * var62, 22.5, 4.0, x_pos, x_pos - var69, y_pos, y_pos - var65, z_pos, z_pos - var67, "minecraft:enchanted_hit");
            entity.setYRot((float)var55);
            entity.setXRot((float)var57);
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
            LivingEntity var96;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var96 = _mobEnt.getTarget();
            } else {
               var96 = null;
            }

            if (var96 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.getTarget();
               } else {
                  var96 = null;
               }

               x_pos = ((Entity)var96).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.getTarget();
               } else {
                  var96 = null;
               }

               double var99 = ((Entity)var96).getY();
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.getTarget();
               } else {
                  var101 = null;
               }

               y_pos = var99 + (double)((Entity)var101).getBbHeight() * 0.5;
               LivingEntity var100;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var100 = _mobEnt.getTarget();
               } else {
                  var100 = null;
               }

               z_pos = ((Entity)var100).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().getDouble("cnt3") <= 1.0) {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * 0.5), 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * 0.5), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var62 * 0.5), 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var62 * 0.5), 0.5F, false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt3") <= 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity82 = (LivingEntity)entity;
                     if (_livingEntity82.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity82.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-6.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity83 = (LivingEntity)entity;
                     if (_livingEntity83.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity83.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            double var63 = (double)Math.round(6.0 * var64);
            double var56 = Math.toRadians((double)(entity.getYRot() + 90.0F));
            double var58 = Math.toRadians((double)entity.getXRot());
            double var60 = 0.0;

            for(int index0 = 0; index0 < (int)var63; ++index0) {
               x_pos = entity.getX() + Math.cos(var56) * Math.cos(var58) * var60;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(var58) * -1.0 * var60;
               z_pos = entity.getZ() + Math.sin(var56) * Math.cos(var58) * var60;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(2.0 * var62), 0.05 * var62, 0.05 * var62, 0.05 * var62, 0.1);
               }

               if (Math.random() < 0.2 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(1.0 * var62), 0.1 * var62, 0.1 * var62, 0.1 * var62, 0.15);
               }

               entity.getPersistentData().putDouble("Damage", 16.0);
               entity.getPersistentData().putDouble("knockback", 2.0);
               entity.getPersistentData().putDouble("Range", 4.0 * var64);
               entity.getPersistentData().putDouble("effect", 5.0);
               entity.getPersistentData().putDouble("projectile_type", 5.0);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("BlockDamage", 0.2 + var61 / 16.0);
               entity.getPersistentData().putDouble("BlockRange", 0.75 * var62);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               var60 += 0.5 * var64;
            }

            double var70 = entity.getLookAngle().x;
            double var66 = entity.getLookAngle().y;
            double var68 = entity.getLookAngle().z;
            ParticleGeneratorCircleProcedure.execute(world, 36.0 * var62, (double)entity.getXRot(), 0.0 * var62, 0.1 * var62, 8.0, x_pos, x_pos - var70 * var62, y_pos, y_pos - var66 * var62, (double)entity.getYRot(), z_pos, z_pos - var68 * var62, "minecraft:enchanted_hit");
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();

            for(int index1 = 0; index1 < (int)(12.0 * var62); ++index1) {
               ParticleGeneratorProcedure.execute(world, var62 * 0.5, 1.0, 0.0, Mth.nextDouble(RandomSource.create(), 4.0, 8.0), x_pos, x_pos + var70, y_pos, y_pos + var66, z_pos, z_pos + var68, "minecraft:enchanted_hit");
            }

            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
