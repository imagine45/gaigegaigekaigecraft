package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WeaponRightClickedWithChargeProcedure {
   public WeaponRightClickedWithChargeProcedure() {
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double ticks = 0.0;
         double skill = 0.0;
         double cnt10 = 0.0;
         itemstack.getOrCreateTag().putDouble("COOLDOWN_TICKS", 0.0);
         if (entity.getPersistentData().getDouble("skill") == 0.0) {
            if (itemstack.getItem() == JujutsucraftModItems.GAVEL_BIG.get()) {
               skill = 2712.0;
               ticks = 200.0;
            }

            if (itemstack.is(ItemTags.create(new ResourceLocation("forge:rifle"))) || itemstack.is(ItemTags.create(new ResourceLocation("forge:bow")))) {
               if (entity.isShiftKeyDown()) {
                  skill = 3201.0;
                  ticks = 20.0;
               } else {
                  skill = 3200.0;
                  ticks = 5.0;
               }

               cnt10 = 1.0;
            }

            if (skill > 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().putDouble("skill", skill);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                  }
               }

               CompoundTag var10000;
               double var10002;
               label34: {
                  entity.getPersistentData().putDouble("COOLDOWN_TICKS", 2.0);
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
                  entity.getPersistentData().putDouble("cnt10", cnt10);
                  var10000 = itemstack.getOrCreateTag();
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.getAbilities().instabuild) {
                        var10002 = 20.0;
                        break label34;
                     }
                  }

                  var10002 = ticks;
               }

               var10000.putDouble("COOLDOWN_TICKS", var10002);
            }
         }

      }
   }
}
