package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CursedToolsAbilityProcedure {
   public CursedToolsAbilityProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double NUM1 = 0.0;
         boolean logic_a = false;
         boolean mahorage = false;
         String STR1 = "";
         Entity entity_a = null;
         ItemStack equipment_item = ItemStack.EMPTY;
         if (entityiterator instanceof LivingEntity) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
            }

            if (entity.getPersistentData().getBoolean("attack")) {
               label190: {
                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  equipment_item = var10000.copy();
                  if (entity instanceof Player) {
                     Player _plrCldCheck3 = (Player)entity;
                     if (_plrCldCheck3.getCooldowns().isOnCooldown(equipment_item.getItem())) {
                        break label190;
                     }
                  }

                  if (equipment_item.is(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) && (equipment_item.getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || equipment_item.getItem() == JujutsucraftModItems.BLACK_ROPE.get())) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                     }

                     if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label165: {
                              var10003 = MobEffects.WEAKNESS;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label165;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001 = new MobEffectInstance(var10003, 10, var10005, false, false);
                           _entity.addEffect(var10001);
                        }
                     }
                  }
               }
            }

            ItemStack var31;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var31 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var31 = ItemStack.EMPTY;
            }

            equipment_item = var31.copy();
            if (entity instanceof Player && entity instanceof Player) {
               Player _plrCldCheck15 = (Player)entity;
               if (_plrCldCheck15.getCooldowns().isOnCooldown(equipment_item.getItem())) {
                  return;
               }
            }

            if (equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               mahorage = entity instanceof Player ? pVars.PlayerCurseTechnique == 16.0 || pVars.PlayerCurseTechnique2 == 16.0 : entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade010Entity;
               NUM1 = 0.0;
               STR1 = "";
               if (NUM1 == 0.0 && entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt21 = (LivingEntity)entityiterator;
                  if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && entity.getPersistentData().getBoolean("attack")) {
                     STR1 = "skill205";
                     if (equipment_item.getOrCreateTag().getDouble(STR1) == 0.0) {
                        NUM1 = 1.0;
                     } else if (equipment_item.getOrCreateTag().getDouble(STR1) >= 100.0 && mahorage) {
                        STR1 = "";
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 1, 1));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }
                     }
                  }
               }

               if (NUM1 == 0.0 && STR1.equals("") && mahorage) {
                  STR1 = "toLiving";
                  if (equipment_item.getOrCreateTag().getDouble(STR1) == 0.0) {
                     NUM1 = 1.0;
                  }
               }

               if (NUM1 > 0.0) {
                  for(int index0 = 0; index0 < 800; ++index0) {
                     if (equipment_item.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("") || equipment_item.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var31 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var31 = ItemStack.EMPTY;
                        }

                        var31.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var31 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var31 = ItemStack.EMPTY;
                        }

                        var31.getOrCreateTag().putDouble(STR1, 1.0);
                        break;
                     }

                     ++NUM1;
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_start").getString()), false);
                     }
                  }
               }
            }
         }

      }
   }
}
