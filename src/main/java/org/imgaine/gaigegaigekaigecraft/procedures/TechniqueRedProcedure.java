package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.RedEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueRedProcedure {
   public TechniqueRedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
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

            double var75 = ((Entity)var10000).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var75 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var76;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var76 = _mobEnt.getTarget();
            } else {
               var76 = null;
            }

            z_pos = ((Entity)var76).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
         entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
         entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.getPersistentData().putDouble("cnt2", 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            int var82;
            label220: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var82 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label220;
                  }
               }

               var82 = 0;
            }

            HP = (double)(40 + var82 * 20);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.RED.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                     LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                     if (_livingEntity38.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity38.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
            }
         }

         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 9, false, false));
            }
         }

         logic_a = false;
         Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
            if (entityiterator instanceof RedEntity && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
               logic_a = true;
               entityiterator.getPersistentData().putDouble("cnt6", Math.max(entityiterator.getPersistentData().getDouble("cnt6"), entity.getPersistentData().getDouble("cnt6")));
               entityiterator.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
               entityiterator.teleportTo(x_pos, y_pos, z_pos);
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityiterator.getYRot(), entityiterator.getXRot());
               }
               break;
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 20.0 && logic_a) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
                  label237: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label238: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                 break label238;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label237;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt73 = (LivingEntity)entity;
                  if (_livEnt73.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 20.0));

               for(int index0 = 0; index0 < 2; ++index0) {
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, 2.0, x_pos + (Math.random() - 0.5) * 2.0, x_pos, y_pos + (Math.random() - 0.5) * 2.0, y_pos, z_pos + (Math.random() - 0.5) * 2.0, z_pos, "minecraft:enchanted_hit");
                  } else {
                     ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, 2.0, x_pos + (Math.random() - 0.5) * 2.0, x_pos, y_pos + (Math.random() - 0.5) * 2.0, y_pos, z_pos + (Math.random() - 0.5) * 2.0, z_pos, "minecraft:crit");
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") < 3.0) {
                  entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt5") > 20.0) {
                     entity.getPersistentData().putDouble("cnt5", 0.0);
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.level().isClientSide()) {
                           CompoundTag var83 = entity.getPersistentData();
                           _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.gaigegaigekaigecraft.red" + Math.round(var83.getDouble("cnt6"))).getString() + "\""), false);
                        }
                     }

                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 25.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
