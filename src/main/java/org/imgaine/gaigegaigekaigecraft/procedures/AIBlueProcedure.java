package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BlackHoleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.BlueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBlueProcedure {
   public AIBlueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack old_health = ItemStack.EMPTY;
         Entity entity_a = null;
         boolean logic_b = false;
         boolean logic_a = false;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double power_attenuation = 0.0;
         double dis = 0.0;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double z_knockback = 0.0;
         double y_pos = 0.0;
         double y_knockback = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         AIBlueRedProcedure.execute(world, entity);
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         }

         if (entity instanceof BlackHoleEntity) {
            double var10000;
            label381: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity3 = (LivingEntity)entity;
                  if (_livingEntity3.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity3.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                     break label381;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 < 64.0 && entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  AttributeInstance var94;
                  label374: {
                     var94 = _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity4 = (LivingEntity)entity;
                        if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label374;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var94.setBaseValue(Math.min(var10001 + 0.8, 64.0));
               }
            }

            label363: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                     break label363;
                  }
               }

               var10000 = 0.0;
            }

            dis = var10000 * 10.0;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, (int)dis, dis * 0.05, dis * 0.05, dis * 0.05, 1.0 + dis * 0.02);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, (int)dis, dis * 0.05, dis * 0.05, dis * 0.05, 1.0 + dis * 0.02);
            }

            if (entity_a instanceof LivingEntity) {
               entity_a.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity_a.teleportTo(x, y, z);
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.connection.teleport(x, y, z, entity_a.getYRot(), entity_a.getXRot());
               }
            }
         }

         label415: {
            label357: {
               if (entity instanceof BlueEntity) {
                  BlueEntity _datEntL12 = (BlueEntity)entity;
                  if ((Boolean)_datEntL12.getEntityData().get(BlueEntity.DATA_flag_start)) {
                     break label357;
                  }
               }

               if (entity instanceof BlueEntity) {
                  break label415;
               }
            }

            if (entity.getPersistentData().getBoolean("circle")) {
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity_a instanceof LivingEntity && entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                  RotateEntityProcedure.execute((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity);
               }

               entity.setYRot(entity.getYRot() + 90.0F);
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

               entity.getPersistentData().putBoolean("free", true);
               GetPowerForwardProcedure.execute((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(24.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(24.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(24.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ(), entity);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.4, entity.getPersistentData().getDouble("y_power") * 0.4, entity.getPersistentData().getDouble("z_power") * 0.4));
            } else {
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.0, entity.getPersistentData().getDouble("y_power") * 0.0, entity.getPersistentData().getDouble("z_power") * 0.0));
            }

            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               entity.getPersistentData().putDouble("cnt2", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 0.5F, false);
                  }
               }

               entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
            }

            x_pos = entity.getX();
            y_pos = entity.getY();
            z_pos = entity.getZ();
            if (entity.getPersistentData().getDouble("cnt1") % 2.0 == 1.0) {
               int var96;
               label347: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var96 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label347;
                     }
                  }

                  var96 = 0;
               }

               range = (double)Math.min(var96, 30) * 0.0333;
               entity.getPersistentData().putDouble("knockback", -1.0);
               entity.getPersistentData().putDouble("BlockRange", Math.min(7.0 * CNT6, entity.getPersistentData().getDouble("cnt1") * 0.5));
               entity.getPersistentData().putDouble("BlockDamage", 5.0 * (range + 0.01) * CNT6);
               entity.getPersistentData().putBoolean("noParticle", entity instanceof BlackHoleEntity);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("BlockRange", Math.min(9.0 * CNT6, entity.getPersistentData().getDouble("cnt1") * 1.0));
               entity.getPersistentData().putDouble("BlockDamage", 2.5 * (range + 0.01) * CNT6);
               entity.getPersistentData().putBoolean("noParticle", entity instanceof BlackHoleEntity);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            power_attenuation = 1.0;
            logic_b = false;

            for(int index0 = 0; index0 < 5; ++index0) {
               entity.getPersistentData().putDouble("Range", Math.min(45.0 * power_attenuation * CNT6, 75.0));
               entity.getPersistentData().putDouble("knockback", Math.max(-5.0 * (1.2 - power_attenuation) * CNT6, -8.0));
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                  if (entity != entityiterator) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if ((!(entityiterator instanceof Player) || !InlineMethodHandler.checkGamemodeCreative(entityiterator) && !InlineMethodHandler.checkGamemodeSpectator(entityiterator)) && !entity.getPersistentData().getString("OWNER_UUID").equals(entityiterator.getStringUUID()) && entity.getPersistentData().getDouble("NameRanged_ranged") != entityiterator.getPersistentData().getDouble("NameRanged") && (!(entity_a instanceof LivingEntity) || entity_a != entityiterator)) {
                        label397: {
                           if (entityiterator instanceof Player) {
                              if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                                 break label397;
                              }
                           } else if (!(entityiterator instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity)) {
                              break label397;
                           }

                           ItemStack var97;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                              var97 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var97 = ItemStack.EMPTY;
                           }

                           old_health = var97.copy();
                           if (entityiterator instanceof Player) {
                              Player _plrCldCheck79 = (Player)entityiterator;
                              if (_plrCldCheck79.getCooldowns().isOnCooldown(old_health.getItem())) {
                                 break label397;
                              }
                           }

                           if (old_health.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              CompoundTag var98 = old_health.getOrCreateTag();
                              CompoundTag var99 = entity.getPersistentData();
                              if (var98.getDouble("skill" + Math.round(var99.getDouble("skill"))) >= 100.0) {
                                 continue;
                              }
                           }
                        }

                        x_knockback = entityiterator.getX() - entity.getX();
                        y_knockback = entityiterator.getY() - entity.getY();
                        z_knockback = entityiterator.getZ() - entity.getZ();
                        dis = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                        if (dis < (double)Math.max(entity.getBbWidth(), 1.0F)) {
                           x_knockback = 0.0;
                           y_knockback = 0.0;
                           z_knockback = 0.0;
                           if (!(entityiterator instanceof LivingEntity) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                              entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                           }

                           if (!entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                              if ((double)entityiterator.getBbHeight() > 0.25) {
                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "scale add pehkui:height -0.025 @s");
                                 }

                                 logic_b = true;
                              }

                              if ((double)entityiterator.getBbWidth() > 0.25) {
                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "scale add pehkui:width -0.025 @s");
                                 }

                                 logic_b = true;
                              }
                           }
                        } else {
                           x_knockback = x_knockback / dis * entity.getPersistentData().getDouble("knockback");
                           y_knockback = y_knockback / dis * entity.getPersistentData().getDouble("knockback");
                           z_knockback = z_knockback / dis * entity.getPersistentData().getDouble("knockback");
                           if (!(x_knockback * 1.1 < entityiterator.getDeltaMovement().x()) && !(x_knockback * 0.9 > entityiterator.getDeltaMovement().x())) {
                              x_knockback = entityiterator.getDeltaMovement().x();
                           } else {
                              x_knockback = entityiterator.getDeltaMovement().x() + x_knockback * 0.05;
                           }

                           if (!(y_knockback * 1.1 < entityiterator.getDeltaMovement().y()) && !(y_knockback * 0.9 > entityiterator.getDeltaMovement().y())) {
                              y_knockback = entityiterator.getDeltaMovement().y();
                           } else {
                              y_knockback = entityiterator.getDeltaMovement().y() + y_knockback * 0.05;
                           }

                           if (!(z_knockback * 1.1 < entityiterator.getDeltaMovement().z()) && !(z_knockback * 0.9 > entityiterator.getDeltaMovement().z())) {
                              z_knockback = entityiterator.getDeltaMovement().z();
                           } else {
                              z_knockback = entityiterator.getDeltaMovement().z() + z_knockback * 0.05;
                           }

                           if (entityiterator.onGround()) {
                              y_knockback = Math.max(y_knockback, 0.5 * (1.2 - power_attenuation) * CNT6);
                           }
                        }

                        EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                     }
                  }
               }

               entity.getPersistentData().putDouble("knockback", 0.0);
               power_attenuation *= 0.75;
            }

            entity.getPersistentData().putDouble("Damage", 13.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 4.0 * CNT6);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (logic_b && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().getBoolean("circle")) {
               if (entity.getPersistentData().getDouble("cnt1") > 45.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("cnt1") > 30.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1)) {
               if (entity instanceof BlackHoleEntity && entity_a instanceof LivingEntity) {
                  label400: {
                     entity_a.getPersistentData().putDouble("skill", 0.0);
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_a;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                     }

                     if (entity_a instanceof Player && entity_a instanceof Player) {
                        Player _plr = (Player)entity_a;
                        if (_plr.getAbilities().instabuild) {
                           break label400;
                        }
                     }

                     if (!entity_a.level().isClientSide() && entity_a.getServer() != null) {
                        entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                     }
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            range = ReturnEntitySizeProcedure.execute(entity);

            for(int index1 = 0; index1 < 8; ++index1) {
               x_pos = entity.getX() + (Math.random() - 0.5) * 48.0 * range;
               y_pos = entity.getY() + (Math.random() - 0.5) * 48.0 * range;
               z_pos = entity.getZ() + (Math.random() - 0.5) * 48.0 * range;
               x_power = entity.getX() - x_pos;
               y_power = entity.getY() - y_pos;
               z_power = entity.getZ() - z_pos;
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:enchanted_hit ~ ~ ~ " + x_power * 10000.0 + " " + y_power * 10000.0 + " " + z_power * 10000.0 + " 0.0025 0 force");
                  }
               }
            }
         }

         if (!entity.isAlive()) {
            if (entity instanceof BlackHoleEntity && entity_a instanceof LivingEntity) {
               label413: {
                  entity_a.getPersistentData().putDouble("skill", 0.0);
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                  }

                  if (entity_a instanceof Player && entity_a instanceof Player) {
                     Player _plr = (Player)entity_a;
                     if (_plr.getAbilities().instabuild) {
                        break label413;
                     }
                  }

                  if (!entity_a.level().isClientSide() && entity_a.getServer() != null) {
                     entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                  }
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
