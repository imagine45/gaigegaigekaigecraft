package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueWingKingProcedure {
   public TechniqueWingKingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.WING_KING_CHESTPLATE.get()) {
               entity.getPersistentData().putDouble("cnt5", 1.0);
            } else {
               entity.getPersistentData().putDouble("cnt5", 0.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y + (double)entity.getBbHeight() * 0.5, z, 40, 0.2, 0.2, 0.2, 1.0);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt5") == 0.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y + (double)entity.getBbHeight() * 0.5, z, 5, 0.2, 0.2, 0.2, 0.25);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
               ItemStack var18;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var18 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var18 = ItemStack.EMPTY;
               }

               if (var18.getItem() != JujutsucraftModItems.WING_KING_CHESTPLATE.get() && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var18 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var18 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var18.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.WING_KING_CHESTPLATE.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.WING_KING_CHESTPLATE.get()));
               }

               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt5", 1.0);
            }
         } else {
            WingKingAttackProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
