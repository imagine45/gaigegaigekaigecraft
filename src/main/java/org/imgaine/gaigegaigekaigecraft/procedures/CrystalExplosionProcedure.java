package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade112Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityCrystalEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class CrystalExplosionProcedure {
   public CrystalExplosionProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double cnt6 = 0.0;
         double x_target = 0.0;
         double distance = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw = 0.0;
         double speed = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double range = 0.0;
         double num1 = 0.0;
         String stt1 = "";
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 0.0) {
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            picth = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(picth) * -1.0 * (1.5 + (double)entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.2);
               }
            } else {
               entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.5);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
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
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
                  label259: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label260: {
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
                                 break label260;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label259;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt2", Math.min(entity.getPersistentData().getDouble("cnt2"), 0.0));
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().putDouble("x_pos", entity.getX());
               entity.getPersistentData().putDouble("y_pos", entity.getY());
               entity.getPersistentData().putDouble("z_pos", entity.getZ());
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
            entity.getPersistentData().putDouble("cnt2", -3.0);
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity var94;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var94 = _mobEnt.getTarget();
            } else {
               var94 = null;
            }

            if (var94 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               x_target = ((Entity)var94).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               double var97 = ((Entity)var94).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_target = var97 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var98;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var98 = _mobEnt.getTarget();
               } else {
                  var98 = null;
               }

               z_target = ((Entity)var98).getZ();
            } else {
               x_target = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_target = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_target = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            }

            x_power = x_target - entity.getPersistentData().getDouble("x_pos");
            y_power = y_target - entity.getPersistentData().getDouble("y_pos");
            z_power = z_target - entity.getPersistentData().getDouble("z_pos");
            distance = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
            if (distance > 0.0) {
               x_power /= distance;
               y_power /= distance;
               z_power /= distance;
            }

            for(int index0 = 0; index0 < (int)(5.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2)); ++index0) {
               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + x_power);
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + y_power);
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + z_power);
            }

            if (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
               for(int index1 = 0; index1 < 255 && (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))); ++index1) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + 1.0);
               }
            }

            for(int index2 = 0; index2 < 255; ++index2) {
               if (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 3.5 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2));
                  break;
               }

               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 1.0);
            }

            range = 0.1;
            yaw = (double)entity.getYRot();
            picth = (double)entity.getXRot();
            num1 = Math.toRadians((double)(entity.getYRot() + 90.0F));
            x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(num1) * range;
            y_pos = entity.getPersistentData().getDouble("y_pos") - range * 0.17;
            z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(num1) * range;
            logic_a = false;
            entity.setYRot((float)(Math.toDegrees(num1) - 90.0));
            entity.setXRot(-60.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") / 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") / 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") / 3.0);
            String var99;
            if (entity instanceof CursedSpiritGrade112Entity) {
               CursedSpiritGrade112Entity animatable = (CursedSpiritGrade112Entity)entity;
               var99 = animatable.getTexture();
            } else {
               var99 = "null";
            }

            stt1 = var99;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRYSTAL.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                  }

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

                  entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var100;
                        MobEffect var10003;
                        int var10005;
                        label187: {
                           var10003 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label187;
                              }
                           }

                           var10005 = 0;
                        }

                        var100 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                        _entity.addEffect(var100);
                     }
                  }

                  entityinstance.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power"));
                  entityinstance.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power"));
                  entityinstance.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity153 = (LivingEntity)entityinstance;
                     if (_livingEntity153.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity153.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.5 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2));
                     }
                  }

                  if (entityinstance instanceof EntityCrystalEntity) {
                     EntityCrystalEntity _datEntSetI = (EntityCrystalEntity)entityinstance;
                     _datEntSetI.getEntityData().set(EntityCrystalEntity.DATA_mode, 1);
                  }

                  if (entity instanceof CursedSpiritGrade112Entity && entityinstance instanceof EntityCrystalEntity) {
                     EntityCrystalEntity animatable = (EntityCrystalEntity)entityinstance;
                     animatable.setTexture(stt1);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
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

            if (entity.getPersistentData().getDouble("cnt1") > 8.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
