package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.item.ItemCooldowns;
import org.imgaine.gaigegaigekaigecraft.entity.ThrowingItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DragonBoneRightclickedProcedure {
   public DragonBoneRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.EMPTY;
         double old_skill = 0.0;
         double distance = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double entity_size = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double range = 0.0;
         Entity target_entity = null;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            CNT6 = var10000.getOrCreateTag().getDouble("power_energy");
            if (CNT6 >= 5.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putDouble("power_energy", 0.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               item_a = var10000.copy().copy();
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
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               CNT6 = var10000.getOrCreateTag().getDouble("power_energy");
               if (CNT6 >= 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("power_energy", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  item_a = var10000.copy().copy();
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

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.OFF_HAND, true);
                  }
               }
            }
         }

         if (item_a.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
            LivingEntity var81;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var81 = _mobEnt.getTarget();
            } else {
               var81 = null;
            }

            Entity var48 = var81;
            if (var48 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var48).getX(), ((Entity)var48).getY() + (double)((Entity)var48).getBbHeight() * 0.5, ((Entity)var48).getZ(), entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity29 = (LivingEntity)entity;
               if (_livingEntity29.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity29.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity31 = (LivingEntity)entity;
               if (_livingEntity31.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity31.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue((double)Mth.nextInt(RandomSource.create(), 0, 1));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (entity instanceof Player) {
               Item var10001;
               byte var10002;
               ItemCooldowns var82;
               label151: {
                  Player _player = (Player)entity;
                  var82 = _player.getCooldowns();
                  var10001 = (Item)JujutsucraftModItems.DRAGON_BONE.get();
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.getAbilities().instabuild) {
                        var10002 = 20;
                        break label151;
                     }
                  }

                  var10002 = 20;
               }

               var82.addCooldown(var10001, var10002);
            }

            old_skill = entity.getPersistentData().getDouble("skill");
            entity.getPersistentData().putDouble("skill", 1.0);
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = (double)(1.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            x_power = entity.getLookAngle().x * 5.0;
            y_power = entity.getLookAngle().y * 5.0;
            z_power = entity.getLookAngle().z * 5.0;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THROWING_ITEM.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                  if (entityinstance instanceof ThrowingItemEntity) {
                     PlayAnimationEntity2Procedure.execute(entityinstance, "rotation1");
                  }

                  entityinstance.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  entityinstance.getPersistentData().putDouble("x_power", x_power);
                  entityinstance.getPersistentData().putDouble("y_power", y_power);
                  entityinstance.getPersistentData().putDouble("z_power", z_power);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     ItemStack _setstack = item_a.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  entityinstance.getPersistentData().putDouble("cnt6", 2.5 + 0.25 * CNT6);
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 18.0 + CNT6 * 3.0, (double)entity.getXRot(), 0.0, 30.0, 8.0, x_pos, x_pos - x_power, y_pos, y_pos - y_power, (double)entity.getYRot(), z_pos, z_pos - z_power, "crit");
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (CNT6 >= 7.5) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (CNT6 >= 10.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  ParticleGeneratorCircleProcedure.execute(world, 18.0, (double)entity.getXRot(), 0.0, 10.0, 4.0, x_pos, x_pos - x_power, y_pos, y_pos - y_power, (double)entity.getYRot(), z_pos, z_pos - z_power, "cloud");
               }
            }

            entity.getPersistentData().putDouble("skill", old_skill);
         }

      }
   }
}
