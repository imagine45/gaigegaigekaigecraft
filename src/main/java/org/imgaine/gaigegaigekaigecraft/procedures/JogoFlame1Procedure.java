package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletFlameProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class JogoFlame1Procedure {
   public JogoFlame1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double damage = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         Entity target = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var36 = var10000;
         if (var36 instanceof LivingEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 9.0 && var36 instanceof LivingEntity) {
            entity.getPersistentData().putDouble("x_pos", ((Entity)var36).getX());
            entity.getPersistentData().putDouble("y_pos", ((Entity)var36).getY() + (double)((Entity)var36).getBbHeight() * 0.8);
            entity.getPersistentData().putDouble("z_pos", ((Entity)var36).getZ());
         }

         if (var36 instanceof LivingEntity) {
            RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
         }

         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         picth = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(picth) * -1.0 * (1.5 + (double)entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (var36 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0 && (((Entity)var36).getPersistentData().getDouble("skill") == 0.0 || ((Entity)var36).getPersistentData().getDouble("skill") != 0.0 && ((Entity)var36).getPersistentData().getBoolean("attack") || ((Entity)var36).getPersistentData().getDouble("Damage") == 0.0)) {
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().getDouble("skill") == 107.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 8.0));
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 8.0) {
               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               } else {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                     entity.getPersistentData().putDouble("cnt7", 1.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity57 = (LivingEntity)entity;
            if (_livingEntity57.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity57.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(2.0 * CNT6), 0.1, 0.1, 0.1, 0.01 * CNT6);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.DRAGON_BREATH, x_pos, y_pos, z_pos, (int)(2.0 * CNT6), 0.1, 0.1, 0.1, 0.01 * CNT6);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") < 25.0 * CNT6) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(10.0 * CNT6), 0.1, 0.1, 0.1, 0.25 * CNT6);
            }

            entity.getPersistentData().putDouble("Damage", 1.5 * CNT6);
            DamageFixProcedure.execute(entity);
            damage = entity.getPersistentData().getDouble("Damage");
            yaw = (double)entity.getYRot();
            picth = (double)entity.getXRot();

            for(int index0 = 0; index0 < 4; ++index0) {
               entity.setYRot((float)(yaw + (Math.random() - 0.5) * 6.0 * CNT6));
               entity.setXRot((float)(picth + (Math.random() - 0.5) * 6.0 * CNT6));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new InlineMethodHandler() {
                     public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BulletFlameProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_FLAME_PROJECTILE.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        entityToSpawn.setSecondsOnFire(100);
                        return entityToSpawn;
                     }
                  }).getArrowO(projectileLevel, entity, (float)damage, 0, (byte)100);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)((2.5 + Math.random() * 0.2) * CNT6), 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }

            entity.setYRot((float)yaw);
            entity.setXRot((float)picth);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 5.0 * CNT6);
            entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
            entity.getPersistentData().putDouble("effect", 10.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") > 25.0 * CNT6 + 10.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
