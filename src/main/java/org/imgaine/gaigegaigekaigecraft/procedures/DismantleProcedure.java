package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DismantleProcedure {
   public DismantleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean vertical = false;
         boolean canUseWorld = false;
         boolean worldCutter = false;
         double distance = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         double size = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }
         LivingEntity var38;
         label354: {
            label353: {
               var38 = var10000;
               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               if (entity instanceof Player) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr4 = (ServerPlayer)entity;
                     if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_dismantle_cut_the_world"))).isDone()) {
                        break label353;
                     }
                  }
               } else {
                  if (entity instanceof SukunaFushiguroEntity && entity instanceof SukunaFushiguroEntity) {
                     SukunaFushiguroEntity _datEntL6 = (SukunaFushiguroEntity)entity;
                     if ((Boolean)_datEntL6.getEntityData().get(SukunaFushiguroEntity.DATA_world_cut)) {
                        break label353;
                     }
                  }

                  if (entity instanceof SukunaPerfectEntity) {
                     break label353;
                  }
               }

               canUseWorld = false;
               break label354;
            }

            canUseWorld = true;
         }

         if (var38 instanceof LivingEntity) {
            if (canUseWorld && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
               }
            }

            entity.lookAt(Anchor.EYES, new Vec3(((Entity)var38).getX(), ((Entity)var38).getY() + (double)((Entity)var38).getBbHeight() * 0.5, ((Entity)var38).getZ()));
            entity.getPersistentData().putBoolean("PRESS_Z", false);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 6.0 && (((Entity)var38).getPersistentData().getDouble("skill") == 0.0 || ((Entity)var38).getPersistentData().getDouble("skill") != 0.0 && ((Entity)var38).getPersistentData().getBoolean("attack") || ((Entity)var38).getPersistentData().getDouble("Damage") == 0.0)) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
            }

            if (canUseWorld && var38 instanceof LivingEntity) {
               LivingEntity _livEnt21 = var38;
               if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && !entity.getPersistentData().getBoolean("flag_dismantle")) {
                  entity.getPersistentData().putBoolean("flag_dismantle", true);
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (var38 instanceof LivingEntity) {
                     RotateEntityProcedure.execute(((Entity)var38).getX(), ((Entity)var38).getY() + (double)((Entity)var38).getBbHeight() * 0.5, ((Entity)var38).getZ(), entity);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            label324: {
               label323: {
                  if (entity instanceof Player) {
                     if (entity.isShiftKeyDown()) {
                        break label323;
                     }
                  } else if (Math.random() < 0.5) {
                     break label323;
                  }

                  entity.getPersistentData().putDouble("cnt7", 2.0);
                  break label324;
               }

               entity.getPersistentData().putDouble("cnt7", 1.0);
            }

            if (var38 instanceof LivingEntity && canUseWorld && var38 instanceof LivingEntity) {
               LivingEntity _livEnt38 = var38;
               if (_livEnt38.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  entity.getPersistentData().putDouble("cnt7", 2.0);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 6, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt6", -1.0);
            range = 0.5;
         } else {
            if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               picth = Math.toRadians((double)entity.getXRot());
               distance = (double)(1.0F + entity.getBbWidth());
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(picth) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * distance;
               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
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
                              _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.gaigegaigekaigecraft.dismantle" + Math.round(var10001.getDouble("cnt6"))).getString() + "\""), false);
                           }
                        }

                        if (entity instanceof Player) {
                           double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 30.0;
                           entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.PlayerCursePowerChange = _setval;
                              capability.syncPlayerVariables(entity);
                           });
                        }
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
                        _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.0);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     ChargeParticleProcedure.execute(world, entity, 1.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }
               }
            }

            range = 1.0;
         }

         if (entity.getPersistentData().getDouble("cnt1") == 0.0 && canUseWorld) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity76 = (LivingEntity)entity;
               if (_livingEntity76.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity76.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue((double)(entity.getPersistentData().getDouble("cnt6") >= 5.0 ? 207 : 120));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0 && entity.getPersistentData().getDouble("cnt7") == 1.0) {
            entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 5.0));
         }

         if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
            vertical = Math.random() < 0.5;
            if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && canUseWorld) {
               worldCutter = true;
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 0.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.75F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 1.0F, false);
                  }
               }

               if (!canUseWorld) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (vertical) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity89 = (LivingEntity)entity;
                        if (_livingEntity89.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity89.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(207.0);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity90 = (LivingEntity)entity;
                        if (_livingEntity90.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity90.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity92 = (LivingEntity)entity;
                        if (_livingEntity92.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity92.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue((double)Mth.nextInt(RandomSource.create(), 0, 1));
                        }
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
               }
            }

            int var85;
            label306: {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F) + Mth.nextDouble(RandomSource.create(), -90.0, 90.0));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = 0.5 * (double)entity.getBbWidth();
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var85 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label306;
                  }
               }

               var85 = 0;
            }

            HP = (double)(30 + var85 * 7) * CNT6;
            size = 0.5 * ReturnEntitySizeProcedure.execute(entity);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.PROJECTILE_SLASH.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity111 = (LivingEntity)entityinstance;
                     if (_livingEntity111.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity111.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity115 = (LivingEntity)entityinstance;
                     if (_livingEntity115.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity115.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
                     }
                  }

                  entityinstance.getPersistentData().putDouble("size", size * 5.0 * (1.0 + 0.5 * entity.getPersistentData().getDouble("cnt6")));
                  entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + entity.getPersistentData().getDouble("cnt8") * 0.025);
                  entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 9.0);
                  entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 9.0);
                  entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 9.0);
                  if (worldCutter && entityinstance instanceof ProjectileSlashEntity) {
                     ProjectileSlashEntity _datEntSetI = (ProjectileSlashEntity)entityinstance;
                     _datEntSetI.getEntityData().set(ProjectileSlashEntity.DATA_mode, 1);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 0.0) {
                     if (vertical) {
                        if (entityinstance instanceof ProjectileSlashEntity) {
                           PlayAnimationEntity2Procedure.execute(entityinstance, "vertical1");
                        }
                     } else if (entityinstance instanceof ProjectileSlashEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle1");
                     }
                  } else if (vertical) {
                     if (entityinstance instanceof ProjectileSlashEntity) {
                        RandomSource var86 = RandomSource.create();
                        PlayAnimationEntity2Procedure.execute(entityinstance, "vertical" + Math.round((float)Mth.nextInt(var86, 1, 5)));
                     }
                  } else if (entityinstance instanceof ProjectileSlashEntity) {
                     RandomSource var87 = RandomSource.create();
                     PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.nextInt(var87, 1, 5)));
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
               if (var38 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
               }

               if ((!entity.getPersistentData().getBoolean("PRESS_Z") || !(entity.getPersistentData().getDouble("cnt8") < 16.0)) && !(entity.getPersistentData().getDouble("cnt8") < 8.0)) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               } else {
                  entity.getPersistentData().putDouble("cnt1", 3.0);
                  entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
