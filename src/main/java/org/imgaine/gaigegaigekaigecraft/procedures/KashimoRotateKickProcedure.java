package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackSlashEntity;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class KashimoRotateKickProcedure {
   public KashimoRotateKickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.EMPTY;
         ItemStack item_a = ItemStack.EMPTY;
         Entity target_entity = null;
         boolean sword = false;
         boolean logic_a = false;
         double old_cnt1 = 0.0;
         double old_skill = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double yaw1 = 0.0;
         double pitch1 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1") + 1.0, 10.0));
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var50 = var10000;
         if (var50 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var50).getX(), ((Entity)var50).getY() + (double)((Entity)var50).getBbHeight() * 0.5, ((Entity)var50).getZ(), entity);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.5, Math.min(entity.getDeltaMovement().y() * 0.5, Math.min(entity.getDeltaMovement().y(), 0.1)), entity.getDeltaMovement().z() * 0.5));
         old_cnt1 = entity.getPersistentData().getDouble("cnt1");
         old_skill = entity.getPersistentData().getDouble("skill");
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(0.0F + entity.getBbWidth());
         double var115 = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         var115 = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         var115 = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().getDouble("cnt5") <= 100.0) {
            ItemStack var118;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var118 = _livEnt.getMainHandItem();
            } else {
               var118 = ItemStack.EMPTY;
            }

            item_a = var118.copy().copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var118 = _livEnt.getOffhandItem();
            } else {
               var118 = ItemStack.EMPTY;
            }

            item_b = var118.copy().copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = ItemStack.EMPTY.copy();
               _setstack.setCount(1);
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = ItemStack.EMPTY.copy();
               _setstack.setCount(1);
               _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (entity.getPersistentData().getDouble("cnt5") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity37 = (LivingEntity)entity;
                  if (_livingEntity37.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity37.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-6.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().putDouble("Damage", 6.0);
               DamageFixProcedure.execute(entity);
            }

            if (entity.getPersistentData().getDouble("cnt5") >= 5.0 && entity.getPersistentData().getDouble("cnt5") < 10.0) {
               if (entity.getPersistentData().getDouble("cnt5") == 5.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (_level.isClientSide()) {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               }

               yaw1 = (double)entity.getYRot();
               pitch1 = (double)entity.getXRot();
               entity.setYRot((float)(yaw1 + (entity.getPersistentData().getDouble("cnt5") - 4.0) * 45.0));
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

               range = ReturnEntitySizeProcedure.execute(entity);
               range *= range;
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               dis = 2.5 * range;
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * dis;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_SLASH.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
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

                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        EntityAttackSlashEntity animatable = (EntityAttackSlashEntity)entityinstance;
                        animatable.setTexture("slash_white");
                     }

                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle1");
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity74 = (LivingEntity)entityinstance;
                        if (_livingEntity74.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity74.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(3.0 * range);
                        }
                     }

                     entityinstance.teleportTo(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F, false);
                  }
               }

               entity.setYRot((float)yaw1);
               entity.setXRot((float)pitch1);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                  x_power = entity.getPersistentData().getDouble("x_power") * 1.0;
                  y_power = entity.getPersistentData().getDouble("y_power") * 1.0;
                  z_power = entity.getPersistentData().getDouble("z_power") * 1.0;
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
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

                  for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }

                     if (logic_a) {
                        break;
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

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

                  if (logic_a || entity.getPersistentData().getDouble("cnt5") >= 9.0) {
                     entity.getPersistentData().putDouble("cnt2", 1.0);
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt5") >= 10.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                  }
               }

               entity.getPersistentData().putDouble("cnt2", 0.0);
               entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
               entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 3.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity119 = (LivingEntity)entity;
                  if (_livingEntity119.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity119.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
                  }
               }

               AttackStrongPunchProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity120 = (LivingEntity)entity;
                  if (_livingEntity120.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity120.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_a.copy();
               _setstack.setCount(item_a.getCount());
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_b.copy();
               _setstack.setCount(item_b.getCount());
               _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            entity.getPersistentData().putDouble("cnt1", old_cnt1);
            entity.getPersistentData().putDouble("skill", old_skill);
         } else if (entity.getPersistentData().getDouble("cnt5") > 110.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
