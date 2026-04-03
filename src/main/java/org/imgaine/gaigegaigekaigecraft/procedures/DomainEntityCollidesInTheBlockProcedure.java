package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DomainEntityCollidesInTheBlockProcedure {
   public DomainEntityCollidesInTheBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_entity = null;
         String STR1 = "";
         ItemStack item_A = ItemStack.EMPTY;
         boolean old_ignore = false;
         boolean logic_attack = false;
         boolean mahorage = false;
         double Damage = 0.0;
         double old_damage = 0.0;
         double NUM1 = 0.0;
         owner_entity = GetEntityFromUUIDProcedure.execute(world, InlineMethodHandler.getValueBlank(world, BlockPos.containing(x, y, z), "OWNER_UUID"));
         Damage = 12.0;
         if (!InlineMethodHandler.getValueBlank(world, BlockPos.containing(x, y, z), "OWNER_UUID").isEmpty()) {
            if (owner_entity instanceof LivingEntity) {
               logic_attack = true;
               if (owner_entity == entity) {
                  logic_attack = false;
               }

               if (owner_entity.getPersistentData().getDouble("friend_num") != 0.0 && owner_entity.getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num")) {
                  logic_attack = false;
               }

               if (owner_entity.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID()) || entity.getPersistentData().getString("OWNER_UUID").equals(owner_entity.getStringUUID())) {
                  logic_attack = false;
               }

               if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP) && (owner_entity instanceof Player || owner_entity.getPersistentData().getBoolean("Player")) && (entity instanceof Player || entity.getPersistentData().getBoolean("Player"))) {
                  logic_attack = false;
               }

               if (logic_attack) {
                  label219: {
                     if (entity instanceof Player) {
                        Player _plrCldCheck18 = (Player)entity;
                        ItemCooldowns var10000 = _plrCldCheck18.getCooldowns();
                        ItemStack var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10001 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (var10000.isOnCooldown(var10001.getItem())) {
                           break label219;
                        }
                     }

                     ItemStack var49;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var49 = ItemStack.EMPTY;
                     }

                     if (var49.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var49 = ItemStack.EMPTY;
                        }

                        if (var49.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                           break label219;
                        }
                     }

                     mahorage = entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16.0 : entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
                     NUM1 = 0.0;
                     STR1 = "";
                     if (NUM1 == 0.0) {
                        STR1 = "skill3705";
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var49 = ItemStack.EMPTY;
                        }

                        if (var49.getOrCreateTag().getDouble(STR1) == 0.0) {
                           NUM1 = 1.0;
                        } else {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var49 = ItemStack.EMPTY;
                           }

                           if (var49.getOrCreateTag().getDouble(STR1) >= 100.0 && mahorage) {
                              STR1 = "";
                              logic_attack = false;
                              DomainOnTickUpdateProcedure.execute(world, x, y, z);
                           }
                        }
                     }

                     if (NUM1 > 0.0) {
                        int index0 = 0;

                        while(index0 < 800) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var49 = ItemStack.EMPTY;
                           }

                           if (!var49.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                              } else {
                                 var49 = ItemStack.EMPTY;
                              }

                              if (!var49.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                                 ++NUM1;
                                 ++index0;
                                 continue;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var49 = ItemStack.EMPTY;
                           }

                           var49.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var49 = ItemStack.EMPTY;
                           }

                           var49.getOrCreateTag().putDouble(STR1, 1.0);
                           break;
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

               if (logic_attack) {
                  int var57;
                  label152: {
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _livEnt39 = (LivingEntity)owner_entity;
                        if (_livEnt39.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           label147: {
                              if (owner_entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)owner_entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var57 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label147;
                                 }
                              }

                              var57 = 0;
                           }

                           ++var57;
                           break label152;
                        }
                     }

                     var57 = 0;
                  }

                  Damage *= 1.0 + 0.333 * (double)var57;
                  if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                     Damage *= 2.5;
                  }

                  old_ignore = owner_entity.getPersistentData().getBoolean("ignore");
                  old_damage = entity.getPersistentData().getDouble("Damage");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                  }

                  owner_entity.getPersistentData().putBoolean("ignore", true);
                  entity.getPersistentData().putDouble("Damage", 0.0);
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse"))), owner_entity), (float)Damage);
                  owner_entity.getPersistentData().putBoolean("ignore", old_ignore);
                  entity.getPersistentData().putDouble("Damage", old_damage);
                  if (entity instanceof Player && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5.0) && entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_dhruv_lakdawalla"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               }

               if (!owner_entity.isAlive()) {
                  DomainOnTickUpdateProcedure.execute(world, x, y, z);
               }
            } else {
               DomainOnTickUpdateProcedure.execute(world, x, y, z);
            }
         } else {
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse")))), (float)Damage);
         }

      }
   }
}
