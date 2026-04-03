package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade04Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade12Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class Cockroach1Procedure {
   public Cockroach1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double HP = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double num1 = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double xp2 = 0.0;
         double yp2 = 0.0;
         double zp2 = 0.0;
         double CNT6 = 0.0;
         double y_velocity = 0.0;
         boolean logic_a = false;
         boolean pitch = false;
         boolean cockroach = false;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         entity.fallDistance = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            int var10001;
            label167: {
               yaw = (double)entity.getYRot();
               dis = 0.0;
               x_pos = entity.getX();
               y_pos = entity.getY() + -6.0;
               z_pos = entity.getZ();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label167;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(50 + var10001 * 10);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TORNADO.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.setYRot((float)yaw);
                  entityinstance.setXRot((float)dis);
                  entityinstance.setYBodyRot(entityinstance.getYRot());
                  entityinstance.setYHeadRot(entityinstance.getYRot());
                  entityinstance.yRotO = entityinstance.getYRot();
                  entityinstance.xRotO = entityinstance.getXRot();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity18 = (LivingEntity)entityinstance;
                     if (_livingEntity18.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity18.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entityinstance;
                     if (_livingEntity22.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity22.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(6.0);
                     }
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            entity.getPersistentData().putBoolean("PRESS_Z", true);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 12.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (!(entity instanceof Player) && entity.getPersistentData().getDouble("cnt2") >= 80.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 40.0));
            if (entity.getPersistentData().getDouble("cnt2") >= 40.0 && entity instanceof Player) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }

         y_velocity = Math.min(Math.max(y_velocity, -0.5), 0.5);
         if (GetHeightFromGroundProcedure.execute(world, entity) < 6.0) {
            y_velocity = entity.getDeltaMovement().y() + 0.1;
         } else if (GetHeightFromGroundProcedure.execute(world, entity) > 8.0) {
            y_velocity = entity.getDeltaMovement().y() - 0.1;
         } else {
            y_velocity = 0.0;
         }

         if (!(entity instanceof Player) && !(entity instanceof CursedSpiritGrade12Entity)) {
            entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.3, y_velocity, entity.getLookAngle().z * 0.3));
         } else {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), y_velocity, entity.getDeltaMovement().z()));
         }

         num1 = Math.toRadians(entity.getPersistentData().getDouble("cnt3"));
         num2 = (double)entity.getBbWidth() + Math.min(0.1 * entity.getPersistentData().getDouble("cnt1"), 4.0);
         y_pos = y;
         cockroach = entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 23.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 23.0 : entity instanceof CursedSpiritGrade04Entity;
         entity.getPersistentData().putDouble("y_knockback", 0.2);

         for(int index0 = 0; index0 < 4; ++index0) {
            for(int index1 = 0; index1 < 15; ++index1) {
               x_pos = x + Math.sin(num1) * num2;
               z_pos = z + Math.cos(num1) * num2;
               if (Math.random() < 0.5) {
                  if (cockroach) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), x_pos, y_pos, z_pos, 1, 1.0, 1.0, 1.0, 0.1);
                     }
                  } else {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SOUL, x_pos, y_pos, z_pos, 1, 0.5, 0.5, 0.5, 0.1);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 1, 0.5, 0.5, 0.5, 0.1);
                     }
                  }
               }

               num1 += Math.toRadians(Math.random() * 10.0);
            }

            entity.getPersistentData().putDouble("BlockRange", 1.5 + num2);
            entity.getPersistentData().putDouble("BlockDamage", 0.2);
            entity.getPersistentData().putBoolean("noEffect", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            num1 += Math.toRadians(90.0);
            num2 = Math.max(num2 - (double)(entity.getBbWidth() * 2.0F), 1.0);
            --y_pos;
         }

         entity.getPersistentData().putDouble("y_knockback", 0.0);
         entity.getPersistentData().putDouble("cnt3", Math.toDegrees(num1));
         if (cockroach) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.2F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") > 80.0 || entity.getPersistentData().getDouble("cnt1") > 40.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
