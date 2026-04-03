package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSukunaCombo1Procedure {
   public SkillSukunaCombo1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double tick = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double HP = 0.0;
         double rnd = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double old_cnt2 = 0.0;
         double old_cnt1 = 0.0;
         double size = 0.0;
         double pitch = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
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

            double var105 = ((Entity)var10000).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var106 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var106 += (double)((Entity)var10002).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var105, var106, ((Entity)var10002).getZ(), entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 12.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity15 = (LivingEntity)entity;
                  if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity16.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4, 4, false, false));
               }
            }

            entity.getPersistentData().putDouble("Damage", 9.0);
            DamageFixProcedure.execute(entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 12.0) {
            if (entity.getPersistentData().getDouble("cnt1") <= 15.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 12.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (_level.isClientSide()) {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                  entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                  entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               }

               x_power = entity.getPersistentData().getDouble("x_power") * 2.0;
               y_power = entity.getPersistentData().getDouble("y_power") * 2.0;
               z_power = entity.getPersistentData().getDouble("z_power") * 2.0;
               if (entity.getPersistentData().getDouble("cnt1") == 12.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * 1.0);
               entity.getPersistentData().putDouble("y_knockback", entity.getPersistentData().getDouble("y_power") * 1.0);
               entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * 1.0);

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  if (!logic_a) {
                     entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 4.0 * range);
                     entity.getPersistentData().putDouble("knockback", 0.1);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
               entity.getPersistentData().putBoolean("attack", true);
               if (logic_a) {
                  if (Math.round(distance) >= 1L) {
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();

                     for(int index1 = 0; index1 < (int)Math.round(distance); ++index1) {
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           x_pos += x_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           y_pos += y_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           z_pos += z_power;
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     entity.teleportTo(x_pos, y_pos, z_pos);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                     }
                  }

                  logic_a = true;
               }

               if (logic_a || entity.getPersistentData().getDouble("cnt1") >= 15.0) {
                  entity.getPersistentData().putDouble("cnt1", 15.0);
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.25);
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }

               ParticleGeneratorCircleProcedure.execute(world, 36.0 * range, entity.getPersistentData().getDouble("pitch"), 1.0 * range, 2.0 * range, 4.0, entity.getX(), entity.getX() - entity.getPersistentData().getDouble("x_power") * range, entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getY() + (double)entity.getBbHeight() * 0.5 - entity.getPersistentData().getDouble("y_power") * range, entity.getPersistentData().getDouble("yaw"), entity.getZ(), entity.getZ() - entity.getPersistentData().getDouble("z_power") * range, "minecraft:crit");
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 15.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 15.0) {
                  old_cnt1 = entity.getPersistentData().getDouble("cnt1");
                  old_cnt2 = entity.getPersistentData().getDouble("cnt2");
                  entity.getPersistentData().putDouble("cnt1", 9.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * 1.0);
                  entity.getPersistentData().putDouble("y_knockback", entity.getPersistentData().getDouble("y_power") * 1.0);
                  entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * 1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity110 = (LivingEntity)entity;
                     if (_livingEntity110.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity110.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
                     }
                  }

                  AttackStrongPunchProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity111 = (LivingEntity)entity;
                     if (_livingEntity111.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity111.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                     }
                  }

                  if (LogicStartPassiveProcedure.execute(entity)) {
                     int var108;
                     label221: {
                        yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                        pitch = Math.toRadians((double)entity.getXRot());
                        distance = 0.5 * (double)entity.getBbWidth();
                        x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                        z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var108 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label221;
                           }
                        }

                        var108 = 0;
                     }

                     HP = (double)(30 + var108 * 7);
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
                              LivingEntity _livingEntity128 = (LivingEntity)entityinstance;
                              if (_livingEntity128.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                 _livingEntity128.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.setHealth((float)HP);
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity132 = (LivingEntity)entityinstance;
                              if (_livingEntity132.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity132.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
                              }
                           }

                           entityinstance.getPersistentData().putDouble("size", size * 1.0);
                           entityinstance.getPersistentData().putDouble("cnt6", 1.0);
                           entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 9.0);
                           entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 9.0);
                           entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 9.0);
                           entityinstance.getPersistentData().putDouble("skill", 105.0);
                           entityinstance.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
                           if (entityinstance instanceof ProjectileSlashEntity) {
                              PlayAnimationEntity2Procedure.execute(entityinstance, "vertical1");
                           }

                           _serverLevel.addFreshEntity(entityinstance);
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

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.75F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("cnt1", old_cnt1);
                  entity.getPersistentData().putDouble("cnt2", old_cnt2);
                  entity.getPersistentData().putDouble("x_knockback", 0.0);
                  entity.getPersistentData().putDouble("y_knockback", 0.0);
                  entity.getPersistentData().putDouble("z_knockback", 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt1") > 23.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
