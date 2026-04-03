package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeiMeiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TodoAoiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SetTagJujutsuSorcererProcedure {
   public SetTagJujutsuSorcererProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         SetTagProcedure.execute(world, entity);
         entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
         if (entity instanceof TodoAoiEntity) {
            entity.getPersistentData().putDouble("IQ", 530000.0);
         }

         if (entity instanceof MeiMeiEntity) {
            SummonCrowProcedure.execute(world, x, y, z, entity);
         }

         if (entity instanceof GojoSatoruEntity) {
            if (world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).isEmpty() && world.getEntitiesOfClass(SukunaPerfectEntity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).isEmpty()) {
               if (!world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> true).isEmpty()) {
                  entity.getPersistentData().putBoolean("GojoNoUseInfinity", true);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_HELMET.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (Math.random() < 0.33) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                  }
               } else if (Math.random() < 0.5) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get()));
                  }
               } else if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
               }
            } else {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with air");
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, ItemStack.EMPTY);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
               }

               if (world.getEntitiesOfClass(SukunaPerfectEntity.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).isEmpty()) {
                  if (world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).isEmpty()) {
                     return;
                  }

                  Entity _datEntSetL = (Entity)world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x, y, z)).findFirst().orElse((SukunaFushiguroEntity) null);
                  if (!(_datEntSetL instanceof SukunaFushiguroEntity)) {
                     return;
                  }

                  SukunaFushiguroEntity _datEntL17 = (SukunaFushiguroEntity)_datEntSetL;
                  if (!(Boolean)_datEntL17.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                     return;
                  }
               }

               if (entity instanceof GojoSatoruEntity) {
                  GojoSatoruEntity _datEntSetL = (GojoSatoruEntity)entity;
                  _datEntSetL.getEntityData().set(GojoSatoruEntity.DATA_ghost, true);
               }

               if (entity instanceof GojoSatoruEntity) {
                  GojoSatoruEntity animatable = (GojoSatoruEntity)entity;
                  animatable.setTexture("gojo_satoru_ghost");
               }

               entity.getPersistentData().putDouble("cnt_learn_domain", 1.0);
            }
         }

      }
   }
}
