package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.TakadaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainExpansionTodoActiveProcedure {
   public DomainExpansionTodoActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_center = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double x_center = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
         x_center = entity.getPersistentData().getDouble("x_pos_doma");
         y_center = entity.getPersistentData().getDouble("y_pos_doma");
         z_center = entity.getPersistentData().getDouble("z_pos_doma");
         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("takada_UUID"));
         if (!entity.getPersistentData().getBoolean("Failed")) {
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F) + 67.5);
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (0.5 + (double)entity.getBbWidth());
            y_pos = entity.getY();
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (0.5 + (double)entity.getBbWidth());
            if (!(entity_a instanceof TakadaEntity)) {
               int var10000;
               label210: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                        break label210;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 % 20 == 10 && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.TAKADA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.getPersistentData().putBoolean("domain_entity", true);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                     }

                     entity.getPersistentData().putString("takada_UUID", entityinstance.getStringUUID());
                     entity_a = entityinstance;
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }
         }

         if (entity_a instanceof TakadaEntity) {
            entity_a.getPersistentData().putBoolean("canFly", true);
            if (!entity_a.getPersistentData().getBoolean("PRESS_Z")) {
               entity_a.getPersistentData().putBoolean("PRESS_Z", entity.getPersistentData().getBoolean("PRESS_Z"));
            } else {
               if (entity.getPersistentData().getDouble("skill") <= 0.0 || entity.getPersistentData().getDouble("skill") % 100.0 == 2.0) {
                  entity_a.getPersistentData().putBoolean("PRESS_Z", entity.getPersistentData().getBoolean("PRESS_Z"));
               }

               if (entity_a.getPersistentData().getDouble("skill") > 0.0 && !entity_a.getPersistentData().getBoolean("PRESS_Z")) {
                  Vec3 _center = new Vec3(x_center, y_center, z_center);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(entity_a.getX(), entity_a.getY(), entity_a.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(entity_a.getX(), entity_a.getY(), entity_a.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        entity_a.teleportTo(entityiterator.getX() - entity_a.getLookAngle().x, entityiterator.getY() - entity_a.getLookAngle().y, entityiterator.getZ() - entity_a.getLookAngle().z);
                        if (entity_a instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                           _serverPlayer.connection.teleport(entityiterator.getX() - entity_a.getLookAngle().x, entityiterator.getY() - entity_a.getLookAngle().y, entityiterator.getZ() - entity_a.getLookAngle().z, entity_a.getYRot(), entity_a.getXRot());
                        }

                        entity_a.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ()));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(entity_a.getX(), entity_a.getY(), entity_a.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(entity_a.getX(), entity_a.getY(), entity_a.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 15, 0, false, false));
                     }
                  }
               }
            }

            entity_a.setSprinting(entity.isSprinting());
            entity_a.setShiftKeyDown(entity.isShiftKeyDown());
            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.level().isClientSide()) {
                  MobEffectInstance var10001;
                  MobEffect var10003;
                  int var10005;
                  label182: {
                     var10003 = MobEffects.DAMAGE_BOOST;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label182;
                        }
                     }

                     var10005 = 0;
                  }

                  var10001 = new MobEffectInstance(var10003, 60, var10005 * 1, false, false);
                  _entity.addEffect(var10001);
               }
            }

            label221: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt68 = (LivingEntity)entity;
                  if (_livEnt68.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     break label221;
                  }
               }

               entity_a.teleportTo(x_pos, y_pos, z_pos);
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity_a.getYRot(), entity_a.getXRot());
               }

               entity_a.setYRot(entity.getYRot());
               entity_a.setXRot(entity.getXRot());
               entity_a.setYBodyRot(entity_a.getYRot());
               entity_a.setYHeadRot(entity_a.getYRot());
               entity_a.yRotO = entity_a.getYRot();
               entity_a.xRotO = entity_a.getXRot();
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            entity_a.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt74 = (LivingEntity)entity;
               if (_livEnt74.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  label232: {
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _livEnt75 = (LivingEntity)entity_a;
                        if (_livEnt75.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                           break label232;
                        }
                     }

                     ResetCounterProcedure.execute(entity_a);
                     entity_a.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_a;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var65;
                           MobEffect var66;
                           int var10004;
                           label163: {
                              var66 = (MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                    var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getDuration();
                                    break label163;
                                 }
                              }

                              var10004 = 0;
                           }

                           int var67;
                           label158: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                    var67 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier();
                                    break label158;
                                 }
                              }

                              var67 = 0;
                           }

                           var65 = new MobEffectInstance(var66, var10004, var67, false, false);
                           _entity.addEffect(var65);
                        }
                     }
                  }
               }
            }

            if (!entity.isAlive() && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
               entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
            }
         }

         if (!entity.getPersistentData().getBoolean("Failed")) {
            dis = range * 0.5 - 4.0;
            yaw = Math.toRadians(Math.random() * 360.0);
            rad_now = Math.toRadians((Math.random() - 0.5) * 180.0);
            logic_a = Math.random() < 0.5;

            for(int index0 = 0; index0 < 72; ++index0) {
               if (Math.random() < 0.5) {
                  if (logic_a) {
                     x_pos = x_center + Math.cos(rad) * (Math.cos(rad_now) + Math.abs(Math.sin(yaw) * Math.sin(rad_now))) * dis;
                     y_pos = y_center + Math.sin(rad) * Math.sin(rad_now) * -1.0 * dis;
                     z_pos = z_center + Math.sin(rad) * (Math.cos(rad_now) + Math.abs(Math.cos(yaw) * Math.sin(rad_now))) * dis;
                  } else {
                     x_pos = x_center + Math.cos(rad) * Math.cos(rad_now) * dis;
                     y_pos = y_center + Math.sin(rad) * dis;
                     z_pos = z_center + Math.cos(rad) * Math.sin(rad_now) * dis;
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x_pos, y_pos, z_pos, 1, 0.5, 0.5, 0.5, 0.0);
                  }
               }

               rad += Math.toRadians(10.0 * Math.random());
            }
         }

      }
   }
}
