package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueBlueProcedure {
   public TechniqueBlueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         boolean logic_a = false;
         boolean picth = false;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
                  label201: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label202: {
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
                                 break label202;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label201;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
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

               x_pos = entity.getX() + entity.getLookAngle().x * 3.0;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + entity.getLookAngle().y * 3.0;
               z_pos = entity.getZ() + entity.getLookAngle().z * 3.0;

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
                           CompoundTag var10001 = entity.getPersistentData();
                           _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.gaigegaigekaigecraft.blue" + Math.round(var10001.getDouble("cnt6"))).getString() + "\""), false);
                        }
                     }

                     ChangeCurseEnergyProcedure.execute(entity, -50.0);
                  }
               } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.5);
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 1.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if ((entity.isShiftKeyDown() || !(entity instanceof Player) && Math.random() < 0.5) && entity.getPersistentData().getDouble("cnt6") > 0.0) {
                  dis = 8.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1);
                  entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
                  entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY());
                  entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
                  entity.getPersistentData().putDouble("cnt2", 1.0);
               } else {
                  dis = 16.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1);
                  entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX());
                  entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY());
                  entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ());
                  entity.getPersistentData().putDouble("cnt2", 0.0);
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

            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            if (entity.getPersistentData().getDouble("cnt1") <= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") * 5.0), 0.25, 0.25, 0.25, 0.5);
               }
            } else {
               int var59;
               label149: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var59 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label149;
                     }
                  }

                  var59 = 0;
               }

               HP = (double)(40 + var59 * 8) * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLUE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity83 = (LivingEntity)entityinstance;
                        if (_livingEntity83.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity83.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                     entityinstance.getPersistentData().putBoolean("circle", entity.getPersistentData().getDouble("cnt2") != 0.0);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity94 = (LivingEntity)entityinstance;
                        if (_livingEntity94.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity94.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(5.0 + entity.getPersistentData().getDouble("cnt6") * 0.5);
                        }
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
