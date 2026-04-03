package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CoffinEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade05Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GraveyardDomainActiveProcedure {
   public GraveyardDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean failed;
         Entity entity_b;
         double range;
         double var10000;
         label266: {
            boolean GRAVESTONE = false;
            failed = false;
            Entity entity_a = null;
            entity_b = null;
            double old_skill = 0.0;
            double HP = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double z_pos = 0.0;
            double y_pos = 0.0;
            double MAX_ST = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label266;
               }
            }

            var10000 = 0.0;
         }

         double var39 = var10000;
         double var33 = entity.getPersistentData().getDouble("skill");
         double var37 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
         double var38 = entity.getPersistentData().getDouble("x_pos_doma");
         double var41 = entity.getPersistentData().getDouble("y_pos_doma");
         double var40 = entity.getPersistentData().getDouble("z_pos_doma");
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.ASH, var38, var41 + 0.0, var40, 20, range * 0.175, 1.0, range * 0.175, 0.05);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.SOUL, var38, var41 + 0.0, var40, 1, range * 0.175, 0.1, range * 0.175, 0.05);
         }

         if (!entity.getPersistentData().getBoolean("Failed")) {
            entity.getPersistentData().putDouble("skill", 2505.0);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
            if (var39 % 100.0 == 1.0) {
               entity.getPersistentData().putBoolean("StartDomainAttack", true);
            }

            if (entity.getPersistentData().getBoolean("StartDomainAttack")) {
               label284: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt13 = (LivingEntity)entity;
                     if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label284;
                     }
                  }

                  boolean var30 = false;
                  Entity _ent = null;
                  if (entity.getPersistentData().getDouble("NameRanged") != 0.0) {
                     Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                        if (entityiterator instanceof CoffinEntity && entityiterator.isAlive() && entity != entityiterator && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged") && entityiterator.getPersistentData().getDouble("death_count1") == 0.0 && entityiterator.getPersistentData().getDouble("death_count2") == 0.0) {
                           var30 = true;
                           var38 = entityiterator.getX();
                           var41 = entityiterator.getY();
                           var40 = entityiterator.getZ();
                           _ent = entityiterator;
                           entity_b = GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().getString("TARGET"));
                           if (entity_b instanceof LivingEntity && entity_b instanceof LivingEntity) {
                              LivingEntity _livEnt31 = (LivingEntity)entity_b;
                              if (_livEnt31.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 failed = true;
                              }
                           }
                           break;
                        }
                     }
                  }

                  if (var30) {
                     if (entity instanceof CursedSpiritGrade05Entity) {
                        PlayAnimationEntity2Procedure.execute(entity, "right_arm_up");
                     }

                     if (_ent instanceof LivingEntity && !failed) {
                        int var74;
                        label191: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var74 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label191;
                              }
                           }

                           var74 = 0;
                        }

                        double var35 = 75.0 + (double)var74 * 7.5;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.GRAVESTONE_3.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var38, var41, var40), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                                 if (_livingEntity38.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                    _livingEntity38.getAttribute(Attributes.MAX_HEALTH).setBaseValue(var35);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.setHealth((float)var35);
                              }

                              entityinstance.getPersistentData().putDouble("cnt2", 20.0);
                              entityinstance.setDeltaMovement(new Vec3(0.0, -1.0, 0.0));
                              _ent.getPersistentData().putString("CONNECT_UUID", entityinstance.getStringUUID());
                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }

                        for(int index0 = 0; index0 < 8; ++index0) {
                           if (world.getBlockState(BlockPos.containing(_ent.getX(), _ent.getY(), _ent.getZ())).canOcclude()) {
                              _ent.teleportTo(_ent.getX(), _ent.getY() - (double)_ent.getBbHeight(), _ent.getZ());
                              if (_ent instanceof ServerPlayer) {
                                 ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                                 _serverPlayer.connection.teleport(_ent.getX(), _ent.getY() - (double)_ent.getBbHeight(), _ent.getZ(), _ent.getYRot(), _ent.getXRot());
                              }

                              if (entity_b instanceof LivingEntity) {
                                 entity_b.teleportTo(_ent.getX(), _ent.getY() + 0.25, _ent.getZ());
                                 if (entity_b instanceof ServerPlayer) {
                                    ServerPlayer _serverPlayer = (ServerPlayer)entity_b;
                                    _serverPlayer.connection.teleport(_ent.getX(), _ent.getY() + 0.25, _ent.getZ(), entity_b.getYRot(), entity_b.getXRot());
                                 }
                              }
                              break;
                           }

                           _ent.teleportTo(_ent.getX(), _ent.getY() - 1.0, _ent.getZ());
                           if (_ent instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                              _serverPlayer.connection.teleport(_ent.getX(), _ent.getY() - 1.0, _ent.getZ(), _ent.getYRot(), _ent.getXRot());
                           }
                        }
                     }

                     if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 6, false, false));
                        }
                     }
                  } else {
                     _ent = null;
                     double var42 = 0.0;
                     Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           int var72;
                           label225: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var72 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label225;
                                 }
                              }

                              var72 = 0;
                           }

                           if ((double)var72 >= var42) {
                              _ent = entityiterator;
                              var38 = entityiterator.getX();
                              var41 = entityiterator.getY();
                              var40 = entityiterator.getZ();
                           }

                           label219: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label219;
                                 }
                              }

                              var10000 = 0.0;
                           }

                           var42 = var10000;
                        }
                     }

                     if (_ent instanceof LivingEntity) {
                        if (_ent.getPersistentData().getBoolean("attack")) {
                           _ent.getPersistentData().putDouble("skill", 0.0);
                        }

                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                           _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "title @s title {\"text\":\"\\uE110\"}");
                        }

                        int var10001;
                        label208: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label208;
                              }
                           }

                           var10001 = 0;
                        }

                        double var34 = (double)(40 + var10001 * 4);
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.COFFIN.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var38, var41, var40), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              entityinstance.setYRot(_ent.getYRot());
                              entityinstance.setXRot(0.0F);
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
                                 LivingEntity _livingEntity93 = (LivingEntity)entityinstance;
                                 if (_livingEntity93.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                    _livingEntity93.getAttribute(Attributes.MAX_HEALTH).setBaseValue(var34);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.setHealth((float)var34);
                              }

                              entityinstance.getPersistentData().putString("TARGET", _ent.getStringUUID());
                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }

                        for(int index1 = 0; index1 < 2; ++index1) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(var38, var41, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.close")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                              } else {
                                 _level.playLocalSound(var38, var41, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.close")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(var38, var41, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                              } else {
                                 _level.playLocalSound(var38, var41, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                              }
                           }
                        }

                        if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 6, false, false));
                           }
                        }
                     }
                  }

                  entity.getPersistentData().putBoolean("StartDomainAttack", false);
               }
            }
         }

         entity.getPersistentData().putDouble("skill", var33);
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", var37);
      }
   }
}
