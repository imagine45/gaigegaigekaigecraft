package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UzumakiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIUzumakiProcedure {
   public AIUzumakiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean reChange = false;
         boolean logic_attack = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.ASH, x, y + (double)entity.getBbHeight() * 0.5, z, 80, 8.0, 8.0, 8.0, 0.5);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.SOUL, x, y + (double)entity.getBbHeight() * 0.5, z, 1, 8.0, 8.0, 8.0, 0.5);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof UzumakiEntity) {
            UzumakiEntity _datEntL4 = (UzumakiEntity)entity;
            if ((Boolean)_datEntL4.getEntityData().get(UzumakiEntity.DATA_move)) {
               double var65;
               label239: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity45 = (LivingEntity)entity;
                     if (_livingEntity45.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var65 = _livingEntity45.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label239;
                     }
                  }

                  var65 = 0.0;
               }

               if (var65 > 0.1 && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity47 = (LivingEntity)entity;
                  if (_livingEntity47.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     double var67;
                     AttributeInstance var66;
                     label232: {
                        var66 = _livingEntity47.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity46 = (LivingEntity)entity;
                           if (_livingEntity46.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var67 = _livingEntity46.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                              break label232;
                           }
                        }

                        var67 = 0.0;
                     }

                     var66.setBaseValue(Math.max(var67 - 0.1, 0.1));
                  }
               }

               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               if (entity.getPersistentData().getDouble("cnt2") != 0.0) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos") + (entity.getPersistentData().getDouble("cnt2") - 2.0) * 2.0;
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:soul ~ ~ ~ 8 8 8 2 150 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:explosion ~ ~ ~ 8 8 8 1 150 force");
                  }

                  if (entity.getPersistentData().getDouble("cnt2") < 15.0) {
                     entity.getPersistentData().putDouble("Damage", 52.0);
                     entity.getPersistentData().putDouble("Range", 32.0);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("effectConfirm", 2.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt2") < 3.0) {
                     entity.getPersistentData().putDouble("BlockRange", 24.0);
                     entity.getPersistentData().putDouble("BlockDamage", 18.0);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                        }
                     }
                  }
               } else {
                  if (Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0)) < 0.5 && entity.getPersistentData().getDouble("cnt1") > 12.0 || entity.getPersistentData().getDouble("cnt1") > 50.0 || !entity.isAlive()) {
                     entity.getPersistentData().putDouble("cnt2", 1.0);
                  }

                  if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
                     entity.getPersistentData().putDouble("x_pos", x);
                     entity.getPersistentData().putDouble("y_pos", y + (double)entity.getBbHeight() * 0.5);
                     entity.getPersistentData().putDouble("z_pos", z);
                  }

                  if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
                        }
                     }

                     if (!entity.getPersistentData().getBoolean("Stop")) {
                        entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getPersistentData().getDouble("y_power") * 0.5, entity.getPersistentData().getDouble("z_power") * 0.5));
                        BulletDomainHit2Procedure.execute(world, entity);
                     } else {
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        entity.getPersistentData().putBoolean("Stop", true);
                     }

                     entity.getPersistentData().putDouble("Damage", 52.0);
                     entity.getPersistentData().putDouble("Range", 12.0);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("effectConfirm", 2.0);
                     RangeAttackProcedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
                     ParticleGeneratorProcedure.execute(world, range * 0.25, 15.0 * range, 10.0, 1.0, x, x + entity.getPersistentData().getDouble("x_power"), y + (double)entity.getBbHeight() * 0.5, y + (double)entity.getBbHeight() * 0.5 + entity.getPersistentData().getDouble("y_power"), z, z + entity.getPersistentData().getDouble("z_power"), "minecraft:soul");
                  } else {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SOUL, x, y + (double)entity.getBbHeight() * 0.5, z, 50, 1.5 * (double)entity.getBbWidth() * 0.25, 1.5 * (double)entity.getBbHeight() * 0.25, 1.5 * (double)entity.getBbWidth() * 0.25, 0.25);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt2") > 30.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }

               return;
            }
         }

         double var10000;
         label208: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                  break label208;
               }
            }

            var10000 = 0.0;
         }

         if (var10000 < 1.5 && entity instanceof LivingEntity) {
            LivingEntity _livingEntity7 = (LivingEntity)entity;
            if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               AttributeInstance var64;
               label201: {
                  var64 = _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity6 = (LivingEntity)entity;
                     if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label201;
                     }
                  }

                  var10001 = 0.0;
               }

               var64.setBaseValue(var10001 + 0.1);
            }
         }

         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         entity.getPersistentData().putBoolean("Stop", false);
         entity.getPersistentData().putDouble("cnt1", 0.0);
         entity.getPersistentData().putDouble("cnt2", 0.0);
         logic_attack = false;
         if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.getPersistentData().getDouble("skill") > 0.0 && entity_a.getPersistentData().getDouble("cnt1") < 80.0) {
               logic_attack = true;
               entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
               }

               entity.setYRot(entity_a.getYRot());
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
               entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
               entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
            }
         }

         NUM1 = -200.0 - Math.random();
         if ((!logic_attack || !entity.isAlive()) && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CROW.get()).spawn(_level, BlockPos.containing(entity.getX(), NUM1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }

         reChange = false;
         Vec3 _center = new Vec3(entity.getX(), NUM1, entity.getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
            if (entityiterator instanceof CrowEntity && entityiterator.isAlive()) {
               if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }

               if (!entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }

               reChange = true;
               break;
            }
         }

         if (reChange) {
            if (entity instanceof UzumakiEntity) {
               UzumakiEntity _datEntSetL = (UzumakiEntity)entity;
               _datEntSetL.getEntityData().set(UzumakiEntity.DATA_move, true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 0.75F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
               }
            }
         }

      }
   }
}
