package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.item.ClothesDagonItem;
import org.imgaine.gaigegaigekaigecraft.item.InsectArmorItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ClothesAngelChestplateTickEventProcedure {
   public ClothesAngelChestplateTickEventProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         boolean can_fly = false;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.CLOTHES_ANGEL_CHESTPLATE.get()) {
               can_fly = true;
               if (!entity.onGround()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  Item var9 = var10000.getItem();
                  if (var9 instanceof ClothesDagonItem) {
                     ClothesDagonItem armor = (ClothesDagonItem)var9;
                     if (armor instanceof GeoItem) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "flying");
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == JujutsucraftModItems.CLOTHES_DAGON_CHESTPLATE.get()) {
                  can_fly = true;
                  if (!entity.onGround()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     Item var24 = var10000.getItem();
                     if (var24 instanceof ClothesDagonItem) {
                        ClothesDagonItem armor = (ClothesDagonItem)var24;
                        if (armor instanceof GeoItem) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("geckoAnim", "flying");
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
               can_fly = true;
               if (!entity.onGround()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  Item var23 = var10000.getItem();
                  if (var23 instanceof InsectArmorItem) {
                     InsectArmorItem armor = (InsectArmorItem)var23;
                     if (armor instanceof GeoItem) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "fly");
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.WING_KING_CHESTPLATE.get()) {
               can_fly = true;
               if (!LogicStartPassiveProcedure.execute(entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.shrink(1);
               }
            }
         }

         if (can_fly) {
            entity.fallDistance = 0.0F;
            if (entity.onGround() || entity.isInWater()) {
               int var36;
               label134: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                        var36 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).getAmplifier();
                        break label134;
                     }
                  }

                  var36 = 0;
               }

               if (var36 < 5 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label126: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()).getDuration();
                              break label126;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, Math.min(var10004 + 4, 60), 0, true, true);
                     _entity.addEffect(var10001);
                  }
               }
            }
         }

      }
   }
}
