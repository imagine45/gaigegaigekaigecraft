package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SukunaEntityDiesProcedure {
   public SukunaEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean dieOnlySukuna = false;
         if (!entity.isAlive()) {
            ItemStack var10000;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() && (!(sourceentity.getPersistentData().getDouble("skill") > 0.0) || sourceentity.getPersistentData().getBoolean("attack"))) {
               dieOnlySukuna = true;
            }

            if (sourceentity.getPersistentData().getDouble("skill") >= 2800.0 && sourceentity.getPersistentData().getDouble("skill") < 2850.0) {
               dieOnlySukuna = true;
            }

            if (dieOnlySukuna) {
               if (entity instanceof SukunaEntity) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 60, 1, false, false));
                           }
                        }

                        entityinstance.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
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

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var65 = _player.getInventory().armor;
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10002 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var65.set(3, var10002);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var10001 = EquipmentSlot.HEAD;
                           ItemStack var84;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var84 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var84 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var10001, var84);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var66 = _player.getInventory().armor;
                           ItemStack var85;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var85 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var85 = ItemStack.EMPTY;
                           }

                           if (var85.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var85 = ItemStack.EMPTY;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var85 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var85 = ItemStack.EMPTY;
                           }

                           var66.set(2, var85);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var77 = EquipmentSlot.CHEST;
                           ItemStack var87;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var87 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var87 = ItemStack.EMPTY;
                           }

                           if (var87.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var87 = ItemStack.EMPTY;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var87 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var87 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var77, var87);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var67 = _player.getInventory().armor;
                           ItemStack var89;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var89 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                           } else {
                              var89 = ItemStack.EMPTY;
                           }

                           var67.set(1, var89);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var78 = EquipmentSlot.LEGS;
                           ItemStack var90;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var90 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                           } else {
                              var90 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var78, var90);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var68 = _player.getInventory().armor;
                           ItemStack var91;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var91 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                           } else {
                              var91 = ItemStack.EMPTY;
                           }

                           var68.set(0, var91);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var79 = EquipmentSlot.FEET;
                           ItemStack var92;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var92 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                           } else {
                              var92 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var79, var92);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           ItemStack _setstack = var10000.copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           ItemStack _setstack = var10000.copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FUSHIGURO_MEGUMI_SHIBUYA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 60, 1, false, false));
                           }
                        }

                        entityinstance.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
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

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var71 = _player.getInventory().armor;
                           ItemStack var93;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var93 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var93 = ItemStack.EMPTY;
                           }

                           var71.set(3, var93);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var80 = EquipmentSlot.HEAD;
                           ItemStack var94;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var94 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var94 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var80, var94);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var72 = _player.getInventory().armor;
                           ItemStack var95;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var95 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var95 = ItemStack.EMPTY;
                           }

                           if (var95.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var95 = ItemStack.EMPTY;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var95 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var95 = ItemStack.EMPTY;
                           }

                           var72.set(2, var95);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var81 = EquipmentSlot.CHEST;
                           ItemStack var97;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var97 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var97 = ItemStack.EMPTY;
                           }

                           if (var97.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var97 = ItemStack.EMPTY;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var97 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var97 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var81, var97);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var73 = _player.getInventory().armor;
                           ItemStack var99;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var99 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                           } else {
                              var99 = ItemStack.EMPTY;
                           }

                           var73.set(1, var99);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var82 = EquipmentSlot.LEGS;
                           ItemStack var100;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var100 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                           } else {
                              var100 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var82, var100);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var74 = _player.getInventory().armor;
                           ItemStack var101;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var101 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                           } else {
                              var101 = ItemStack.EMPTY;
                           }

                           var74.set(0, var101);
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var83 = EquipmentSlot.FEET;
                           ItemStack var102;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var102 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                           } else {
                              var102 = ItemStack.EMPTY;
                           }

                           _living.setItemSlot(var83, var102);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           ItemStack _setstack = var10000.copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           ItemStack _setstack = var10000.copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         }

      }
   }
}
