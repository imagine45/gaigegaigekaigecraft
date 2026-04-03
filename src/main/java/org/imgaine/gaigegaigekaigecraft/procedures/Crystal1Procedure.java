package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade112Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityCrystalEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class Crystal1Procedure {
   public Crystal1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double distance = 0.0;
         double speed = 0.0;
         double size = 0.0;
         double strength = 0.0;
         double range = 0.0;
         String stt1 = "";
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            double var75 = ((Entity)var10000).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var78 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var78 += (double)((Entity)var10002).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var75, var78, ((Entity)var10002).getZ(), entity);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(0.0F + entity.getBbWidth());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().getDouble("cnt1") <= 2.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 1.0));
               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity38 = (LivingEntity)entity;
               if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            distance = (double)(3.0F + entity.getBbWidth());

            for(int index0 = 0; index0 < (int)(2.0 * range); ++index0) {
               yaw = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               pitch = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, distance, x_pos + Math.cos(yaw) * Math.cos(pitch) * distance, x_pos, y_pos + Math.sin(pitch) * -1.0 * distance, y_pos, z_pos + Math.sin(yaw) * Math.cos(pitch) * distance, z_pos, entity.getPersistentData().getDouble("cnt6") >= 5.0 ? "minecraft:enchanted_hit" : "minecraft:crit");
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 3.0) {
            int var80;
            label152: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var80 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label152;
                  }
               }

               var80 = 0;
            }

            HP = (double)(20 + var80 * 4);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = (double)(0.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            speed = 8.0;
            String var77;
            if (entity instanceof CursedSpiritGrade112Entity) {
               CursedSpiritGrade112Entity animatable = (CursedSpiritGrade112Entity)entity;
               var77 = animatable.getTexture();
            } else {
               var77 = "null";
            }

            stt1 = var77;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRYSTAL.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.setYRot(entity.getYRot());
                  entityinstance.setXRot(entity.getXRot());
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
                     LivingEntity _livingEntity59 = (LivingEntity)entityinstance;
                     if (_livingEntity59.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity59.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entityinstance;
                     if (_livingEntity63.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity63.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0);
                     }
                  }

                  entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                  entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * speed);
                  entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * speed);
                  entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * speed);
                  if (entityinstance instanceof EntityCrystalEntity) {
                     PlayAnimationEntity2Procedure.execute(entityinstance, "act1");
                  }

                  if (entity instanceof CursedSpiritGrade112Entity && entityinstance instanceof EntityCrystalEntity) {
                     EntityCrystalEntity animatable = (EntityCrystalEntity)entityinstance;
                     animatable.setTexture(stt1);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 4.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
