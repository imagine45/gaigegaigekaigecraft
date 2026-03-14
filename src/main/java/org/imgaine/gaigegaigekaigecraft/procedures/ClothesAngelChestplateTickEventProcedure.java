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
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.CLOTHES_ANGEL_CHESTPLATE.get()) {
               can_fly = true;
               if (!entity.m_20096_()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  Item var9 = var10000.m_41720_();
                  if (var9 instanceof ClothesDagonItem) {
                     ClothesDagonItem armor = (ClothesDagonItem)var9;
                     if (armor instanceof GeoItem) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128359_("geckoAnim", "flying");
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftModItems.CLOTHES_DAGON_CHESTPLATE.get()) {
                  can_fly = true;
                  if (!entity.m_20096_()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     Item var24 = var10000.m_41720_();
                     if (var24 instanceof ClothesDagonItem) {
                        ClothesDagonItem armor = (ClothesDagonItem)var24;
                        if (armor instanceof GeoItem) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128359_("geckoAnim", "flying");
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
               can_fly = true;
               if (!entity.m_20096_()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  Item var23 = var10000.m_41720_();
                  if (var23 instanceof InsectArmorItem) {
                     InsectArmorItem armor = (InsectArmorItem)var23;
                     if (armor instanceof GeoItem) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        var10000.m_41784_().m_128359_("geckoAnim", "fly");
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.WING_KING_CHESTPLATE.get()) {
               can_fly = true;
               if (!LogicStartPassiveProcedure.execute(entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41774_(1);
               }
            }
         }

         if (can_fly) {
            entity.f_19789_ = 0.0F;
            if (entity.m_20096_() || entity.m_20069_()) {
               label134: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                        var36 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).m_19564_();
                        break label134;
                     }
                  }

                  var36 = 0;
               }

               if (var36 < 5 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label126: {
                        var10001 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()).m_19557_();
                              break label126;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001.<init>(var10003, Math.min(var10004 + 4, 60), 0, true, true);
                     _entity.m_7292_(var10001);
                  }
               }
            }
         }

      }
   }
}
