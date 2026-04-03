package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillAntiGravityProcedure {
   public SkillAntiGravityProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label111: {
            boolean logic_a = false;
            double CNT6 = 0.0;
            double strength = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double dis = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label111;
               }
            }

            var10000 = 0;
         }

         double var23 = (double)Math.min(var10000, 50);
         double var24 = ReturnEntitySizeProcedure.execute(entity);
         double var22 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         double var29 = (double)entity.getBbWidth() + 3.0 * var24;
         double var25 = entity.getX();
         double var26 = entity.getY();
         double var28 = entity.getZ();
         LivingEntity var42;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var42 = _mobEnt.getTarget();
         } else {
            var42 = null;
         }

         if (var42 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var42 = _mobEnt.getTarget();
            } else {
               var42 = null;
            }

            double var44 = ((Entity)var42).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var46 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var46 += (double)((Entity)var10002).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var44, var46, ((Entity)var10002).getZ(), entity);
         }

         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.setDeltaMovement(new Vec3(0.0, Math.min(entity.getDeltaMovement().y(), 0.0), 0.0));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(var25, var26, var28), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gravity")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.playLocalSound(var25, var26, var28, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gravity")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, var25, var26, var28, (int)(20.0 * var22), var24 * 2.5, 0.1, var24 * 2.5, 0.6);
            }
         }

         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var42 = _mobEnt.getTarget();
         } else {
            var42 = null;
         }

         if (var42 instanceof LivingEntity) {
            entity.getPersistentData().putBoolean("PRESS_Z", true);
            var29 = GetDistanceNearestEnemyProcedure.execute(world, entity);
            if (var29 > 10.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 20.0));
         }

         if (entity instanceof Player) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         entity.getPersistentData().putDouble("x_knockback", 0.0);
         entity.getPersistentData().putDouble("y_knockback", 0.75);
         entity.getPersistentData().putDouble("z_knockback", 0.0);
         var26 += (double)(6.0F + entity.getBbWidth()) * var24 * 1.5;

         for(int index0 = 0; index0 < 6; ++index0) {
            entity.getPersistentData().putDouble("Damage", 3.0 * var22);
            entity.getPersistentData().putDouble("knockback", 0.001);
            entity.getPersistentData().putDouble("Range", (double)(6.0F + entity.getBbWidth()) * var24);
            entity.getPersistentData().putDouble("effect", 17.0);
            RangeAttackProcedure.execute(world, var25, var26, var28, entity);
            entity.getPersistentData().putDouble("effect", -1.0);
            KnockbackProcedure.execute(world, var25, var26, var28, entity);
            var26 -= (double)(6.0F + entity.getBbWidth()) * var24 * 0.5;
         }

         if (world.getBlockState(BlockPos.containing(var25, var26, var28)).canOcclude() && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.CLOUD, var25, var26, var28, (int)(12.0 * var22), var24 * 2.5, var24 * 0.0, var24 * 2.5, 0.2 * var22);
         }

         entity.getPersistentData().putDouble("x_knockback", 0.0);
         entity.getPersistentData().putDouble("y_knockback", 0.0);
         entity.getPersistentData().putDouble("z_knockback", 0.0);
         entity.getPersistentData().putDouble("Damage", 9.0 * var22);
         DamageFixProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt2") > 120.0 || entity.getPersistentData().getDouble("cnt1") > 20.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
