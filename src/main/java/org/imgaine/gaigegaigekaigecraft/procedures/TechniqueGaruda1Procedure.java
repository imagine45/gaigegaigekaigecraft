package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class TechniqueGaruda1Procedure {
   public TechniqueGaruda1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         boolean logic_a = false;
         boolean noControl = false;
         boolean summon = false;
         Entity entity_rika = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            entity.getPersistentData().putDouble("cnt4", (double)(LocateGarudaProcedure.execute(world, entity) ? 1 : 0));
         }

         if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
            if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("GARUDA_UUID"));
               if (entity_rika instanceof GarudaEntity && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
                  entity_rika.getPersistentData().putBoolean("flag_attack", true);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         } else {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            label97: {
               if (var10000.getItem() != JujutsucraftModItems.GARUDA_ITEM.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() != JujutsucraftModItems.GARUDA_ITEM_BALL.get()) {
                     if (entity instanceof Player) {
                        Player _playerHasItem = (Player)entity;
                        if (_playerHasItem.getInventory().contains(new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get()))) {
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get());
                              _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                           }
                           break label97;
                        }
                     }

                     if (entity instanceof Player) {
                        Player _playerHasItem = (Player)entity;
                        if (_playerHasItem.getInventory().contains(new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM_BALL.get())) && entity instanceof Player) {
                           Player _player = (Player)entity;
                           ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM_BALL.get());
                           _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                     break label97;
                  }
               }

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
            }

            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            yaw = (double)entity.getYRot();
            picth = 0.0;
            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.GARUDA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  entityinstance.setYRot((float)yaw);
                  entityinstance.setXRot((float)picth);
                  entityinstance.setYBodyRot(entityinstance.getYRot());
                  entityinstance.setYHeadRot(entityinstance.getYRot());
                  entityinstance.yRotO = entityinstance.getYRot();
                  entityinstance.xRotO = entityinstance.getXRot();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  double var10002;
                  CompoundTag var42;
                  label85: {
                     entity.getPersistentData().putString("GARUDA_UUID", entityinstance.getStringUUID());
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     var42 = entityinstance.getPersistentData();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10002 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label85;
                        }
                     }

                     var10002 = 0.0;
                  }

                  var42.putDouble("Strength", var10002);
                  entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                  entityinstance.getPersistentData().putBoolean("Shikigami", true);
                  entityinstance.getPersistentData().putDouble("skill", 1.0);
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
