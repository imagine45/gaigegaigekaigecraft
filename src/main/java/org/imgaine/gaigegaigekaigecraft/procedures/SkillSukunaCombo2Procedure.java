package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSukunaCombo2Procedure {
   public SkillSukunaCombo2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.EMPTY;
         ItemStack item_a = ItemStack.EMPTY;
         double old_cnt1 = 0.0;
         double old_skill = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double size = 0.0;
         double HP = 0.0;
         Entity target_entity = null;
         boolean sword = false;
         boolean vertical = false;
         entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1") + 1.0, 10.0));
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         entity.getPersistentData().putDouble("cnt2", 0.0);
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
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var55 = var10000;
         if (var55 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var55).getX(), ((Entity)var55).getY() + (double)((Entity)var55).getBbHeight() * 0.5, ((Entity)var55).getZ(), entity);
         }

         old_cnt1 = entity.getPersistentData().getDouble("cnt1");
         old_skill = entity.getPersistentData().getDouble("skill");
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(0.0F + entity.getBbWidth());
         double var86 = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         var86 = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         var86 = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().getDouble("cnt5") <= 100.0) {
            ItemStack var89;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var89 = _livEnt.getMainHandItem();
            } else {
               var89 = ItemStack.EMPTY;
            }

            item_a = var89.copy().copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var89 = _livEnt.getOffhandItem();
            } else {
               var89 = ItemStack.EMPTY;
            }

            item_b = var89.copy().copy();
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
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity39 = (LivingEntity)entity;
                  if (_livingEntity39.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity39.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().putDouble("cnt6", 2.5);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity41 = (LivingEntity)entity;
                  if (_livingEntity41.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity41.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
                  }
               }

               AttackStrongPunchProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity42 = (LivingEntity)entity;
                  if (_livingEntity42.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity42.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt5") >= 8.0 && entity.getPersistentData().getDouble("cnt5") <= 12.0) {
               if (LogicStartPassiveProcedure.execute(entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.75F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.75F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 1.0F, false);
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

                  int var10001;
                  label172: {
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     pitch = Math.toRadians((double)entity.getXRot());
                     distance = 0.5 * (double)entity.getBbWidth();
                     x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label172;
                        }
                     }

                     var10001 = 0;
                  }

                  HP = (double)(30 + var10001 * 7);
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
                           LivingEntity _livingEntity66 = (LivingEntity)entityinstance;
                           if (_livingEntity66.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity66.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity70 = (LivingEntity)entityinstance;
                           if (_livingEntity70.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity70.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
                           }
                        }

                        entityinstance.getPersistentData().putDouble("size", size * 5.0 * (1.0 + 0.5 * entity.getPersistentData().getDouble("cnt6")));
                        entityinstance.getPersistentData().putDouble("cnt6", 1.0 + 0.05 * entity.getPersistentData().getDouble("cnt5"));
                        entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 9.0);
                        entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 9.0);
                        entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 9.0);
                        entityinstance.getPersistentData().putDouble("skill", 105.0);
                        entityinstance.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
                        if (entityinstance instanceof ProjectileSlashEntity) {
                           RandomSource var91 = RandomSource.create();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.nextInt(var91, 1, 5)));
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
               }
            }

            if (entity.getPersistentData().getDouble("cnt5") >= 12.0) {
               entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
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
