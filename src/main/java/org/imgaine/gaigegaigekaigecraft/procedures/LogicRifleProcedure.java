package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class LogicRifleProcedure {
   public LogicRifleProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         boolean logic_have_bullet = false;
         double distance = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         item_a = var10000.copy();
         if (item_a.is(ItemTags.create(new ResourceLocation("forge:rifle"))) || item_a.is(ItemTags.create(new ResourceLocation("forge:bow")))) {
            if (!(entity instanceof Player)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt13 = (LivingEntity)entity;
                  if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                     return false;
                  }
               }

               distance = GetDistanceProcedure.execute(entity);
               if (distance < 8.0) {
                  return false;
               }

               if (distance > 24.0) {
                  return false;
               }

               return true;
            }

            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.getAbilities().instabuild) {
                  return true;
               }
            }

            if (item_a.is(ItemTags.create(new ResourceLocation("forge:rifle")))) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var18 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var18.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == JujutsucraftModItems.ITEM_BULLET.get()) {
                        logic_have_bullet = true;
                        break;
                     }
                  }
               }

               if (logic_have_bullet) {
                  return true;
               }
            }

            if (item_a.is(ItemTags.create(new ResourceLocation("forge:bow")))) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var19 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var19.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == Items.ARROW) {
                        logic_have_bullet = true;
                        break;
                     }
                  }
               }

               if (logic_have_bullet) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
