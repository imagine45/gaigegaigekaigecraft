package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.ThrowingItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class GavelThrowingProcedure {
   public GavelThrowingProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         double old_skill = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         ItemStack ITEM_A = ItemStack.EMPTY;
         ItemStack item_offHand = ItemStack.EMPTY;
         ItemStack item_mainHand = ItemStack.EMPTY;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            label197: {
               label196: {
                  if (entity instanceof Player) {
                     if (entity.isShiftKeyDown()) {
                        break label196;
                     }
                  } else if (Math.random() < 0.5) {
                     break label196;
                  }

                  entity.getPersistentData().putDouble("cnt2", 2.0);
                  break label197;
               }

               entity.getPersistentData().putDouble("cnt2", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 2.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            Entity var38 = var10000;
            if (var38 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var38).getX(), ((Entity)var38).getY() + (double)((Entity)var38).getBbHeight() * 0.5, ((Entity)var38).getZ(), entity);
            }

            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               if (var38 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt20 = (LivingEntity)entity;
                     if (_livEnt20.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                     }
                  }
               }

               if ((entity.getPersistentData().getBoolean("PRESS_Z") || entity.getPersistentData().getDouble("cnt5") < 15.0) && entity.getPersistentData().getDouble("cnt5") < 40.0) {
                  entity.getPersistentData().putDouble("cnt1", -5.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity26 = (LivingEntity)entity;
               if (_livingEntity26.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity26.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity28 = (LivingEntity)entity;
               if (_livingEntity28.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity28.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue((double)Mth.nextInt(RandomSource.create(), 0, 1));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = 0.5 + (double)entity.getBbWidth();
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            x_power = entity.getLookAngle().x * 9.0;
            y_power = entity.getLookAngle().y * 9.0;
            z_power = entity.getLookAngle().z * 9.0;
            ItemStack var80;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var80 = _livEnt.getMainHandItem();
            } else {
               var80 = ItemStack.EMPTY;
            }

            item_mainHand = var80.copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var80 = _livEnt.getOffhandItem();
            } else {
               var80 = ItemStack.EMPTY;
            }

            item_offHand = var80.copy();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THROWING_ITEM.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  entityinstance.teleportTo(x_pos, y_pos, z_pos);
                  if (entityinstance instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                     _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
                  }

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

                  entityinstance.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  entityinstance.getPersistentData().putDouble("x_power", x_power);
                  entityinstance.getPersistentData().putDouble("y_power", y_power);
                  entityinstance.getPersistentData().putDouble("z_power", z_power);
                  if (entityinstance instanceof ThrowingItemEntity) {
                     PlayAnimationEntity2Procedure.execute(entityinstance, "rotation1");
                  }

                  if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        ItemStack _setstack = item_mainHand.copy().copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }
                  } else if (item_offHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        ItemStack _setstack = item_offHand.copy().copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }
                  } else {
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }

                     AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                     LazyOptional var82 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var82.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                           if (itemstackiterator.getItem() == JujutsucraftModItems.GAVEL.get()) {
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 ItemStack _setstack = itemstackiterator.copy().copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }
                              break;
                           }
                        }
                     }
                  }

                  entityinstance.getPersistentData().putDouble("cnt6", (double)(entity.getPersistentData().getDouble("cnt2") == 1.0 ? -1 : 1));
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
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
            } else if (item_offHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
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
            } else {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var83 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var83.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     ItemStack _entity = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                     if (_entity.getItem() == JujutsucraftModItems.GAVEL.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().clearOrCountMatchingItems((p) -> _entity.getItem() == p.getItem(), _entity.getCount(), _player.inventoryMenu.getCraftSlots());
                        }
                        break;
                     }
                  }
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 18.0 + CNT6 * 3.0, (double)entity.getXRot(), 0.0, 30.0, 8.0, x_pos, x_pos - x_power, y_pos, y_pos - y_power, (double)entity.getYRot(), z_pos, z_pos - z_power, "crit");
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
