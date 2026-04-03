package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueInoProcedure {
   public CursedTechniqueInoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 4000.0);
         if (skill == 5.0) {
            SkillKaichiProcedure.execute(world, entity);
         } else if (skill == 6.0) {
            SkillReikiProcedure.execute(world, x, y, z, entity);
         } else if (skill == 7.0) {
            SkillKirinProcedure.execute(world, x, y, z, entity);
         } else if (skill == 8.0) {
            SkillRyuProcedure.execute(world, x, y, z, entity);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.CLOTHES_INO_TAKUMA_1_HELMET.get()) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_INO_TAKUMA_2_HELMET.get())).copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            CompoundTag _nbtTag = var10000.getTag();
            if (_nbtTag != null) {
               item_a.setTag(_nbtTag.copy());
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getInventory().armor.set(3, item_a);
               _player.getInventory().setChanged();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.setItemSlot(EquipmentSlot.HEAD, item_a);
            }
         }

      }
   }
}
