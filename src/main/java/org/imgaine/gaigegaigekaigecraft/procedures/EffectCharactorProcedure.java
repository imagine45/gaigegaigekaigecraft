package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.BloodBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ChosoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWater2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EsoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KamoNoritoshiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SlicingExorcismEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class EffectCharactorProcedure {
   public EffectCharactorProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         String STR1 = "";
         Entity entity_a = null;
         Entity entity_b = null;
         boolean logic_start = false;
         boolean logic_a = false;
         boolean cursed_technique = false;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double old_cool = 0.0;
         double y_pos = 0.0;
         double T1 = 0.0;
         double T2 = 0.0;
         ItemStack item_A = ItemStack.EMPTY;
         ItemStack equipment_item_offhand = ItemStack.EMPTY;
         ItemStack equipment_item = ItemStack.EMPTY;
         entity_a = entityiterator;
         if (entityiterator instanceof LivingEntity) {
            cursed_technique = entity.getPersistentData().getDouble("skill") > 100.0 && !entity.getPersistentData().getBoolean("attack");
            x_pos = entityiterator.getX();
            y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
            z_pos = entityiterator.getZ();
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            equipment_item = var10000.copy();
            if (equipment_item.getItem() == JujutsucraftModItems.DRAGON_BONE.get() && entity.getPersistentData().getBoolean("attack")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putDouble("power_energy", Math.min(equipment_item.getOrCreateTag().getDouble("power_energy") + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6"), 0.1), 5.0), 10.0));
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            equipment_item = var10000.copy();
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            equipment_item_offhand = var10000.copy();
            if (equipment_item.getItem() == JujutsucraftModItems.DRAGON_BONE.get() || equipment_item_offhand.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
               label514: {
                  if (!entityiterator.getPersistentData().getBoolean("attack")) {
                     label461: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt19 = (LivingEntity)entityiterator;
                           if (_livEnt19.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label461;
                           }
                        }

                        if (!entityiterator.getPersistentData().getBoolean("guard")) {
                           break label514;
                        }
                     }
                  }

                  if (equipment_item.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("power_energy", Math.min(equipment_item.getOrCreateTag().getDouble("power_energy") + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6"), 0.1), 5.0), 10.0));
                  }

                  if (equipment_item_offhand.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("power_energy", Math.min(equipment_item_offhand.getOrCreateTag().getDouble("power_energy") + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6"), 0.1), 5.0), 10.0));
                  }
               }
            }

            if (entityiterator instanceof Player) {
               JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               T1 = pVars.PlayerCurseTechnique;
               T2 = pVars.PlayerCurseTechnique2;
            }

            label484: {
               label452: {
                  if (entity instanceof EntityWaterEntity) {
                     int var96;
                     if (entity instanceof EntityWaterEntity) {
                        EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                        var96 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                     } else {
                        var96 = 0;
                     }

                     if (var96 == 0) {
                        break label452;
                     }
                  }

                  if (!(entity instanceof EntityWater2Entity)) {
                     break label484;
                  }
               }

               label485: {
                  if (entityiterator instanceof Player) {
                     if (T1 == 10.0 || T2 == 10.0) {
                        break label485;
                     }
                  } else if (entityiterator instanceof ChosoEntity || entityiterator instanceof EsoEntity || entityiterator instanceof KamoNoritoshiEntity) {
                     break label485;
                  }

                  label431: {
                     if (entityiterator instanceof EntityWaterEntity) {
                        int var97;
                        if (entityiterator instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntI = (EntityWaterEntity)entityiterator;
                           var97 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                        } else {
                           var97 = 0;
                        }

                        if (var97 == 2) {
                           break label431;
                        }
                     }

                     if (!(entityiterator instanceof BloodBallEntity) && !(entityiterator instanceof SlicingExorcismEntity)) {
                        break label484;
                     }
                  }

                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }
                  break label484;
               }

               old_cool = entityiterator.getPersistentData().getDouble("COOLDOWN_TICKS");
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 0, false, false));
                  }
               }

               entityiterator.getPersistentData().putDouble("COOLDOWN_TICKS", old_cool);
            }

            if (entity.getPersistentData().getBoolean("attack")) {
               EffectAttackProcedure.execute(world, entityiterator, entity);
            }

            if (cursed_technique && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_cursed_technique"))) && entity.getPersistentData().getDouble("skill") != 705.0) {
               label418: {
                  if (entityiterator instanceof Player) {
                     if (T1 != 5.0 && T2 != 5.0) {
                        break label418;
                     }
                  } else if (!(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity)) {
                     break label418;
                  }

                  if (LocateRikaProcedure.execute(world, entityiterator)) {
                     if (entity.getPersistentData().getDouble("skill") >= 305.0 && entity.getPersistentData().getDouble("skill") < 320.0) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_cursed_speech"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity.getPersistentData().getDouble("skill") == 3810.0 && (entityiterator instanceof Player || entityiterator instanceof OkkotsuYutaCullingGameEntity)) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_takako_uro"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else {
                        if (entityiterator instanceof Player) {
                           logic_a = true;
                           AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                           LazyOptional var100 = entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                           Objects.requireNonNull(_iitemhandlerref);
                           var100.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                           if (_iitemhandlerref.get() != null) {
                              for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                 ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                 if (itemstackiterator.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.getOrCreateTag().getDouble("skill") == entity.getPersistentData().getDouble("skill")) {
                                    if (itemstackiterator.getCount() < 10 && entityiterator instanceof Player) {
                                       Player _player = (Player)entityiterator;
                                       ItemStack _setstack = itemstackiterator.copy();
                                       _setstack.setCount(1);
                                       ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                    }

                                    logic_a = false;
                                    break;
                                 }
                              }
                           }

                           item_A = (new ItemStack((ItemLike)JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get())).copy();
                           item_A.setDamageValue(item_A.getMaxDamage() - 1);
                        } else {
                           logic_a = false;
                           NUM1 = 0.0;

                           for(int index0 = 0; index0 < 4; ++index0) {
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                 var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(Type.ARMOR, (int)NUM1));
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              item_A = var10000;
                              if (item_A.getOrCreateTag().getDouble("skill") == 0.0 || item_A.getOrCreateTag().getDouble("skill") == entity.getPersistentData().getDouble("skill")) {
                                 logic_a = true;
                                 break;
                              }

                              ++NUM1;
                              if (NUM1 > 3.0) {
                                 NUM1 = 0.0;
                              }
                           }

                           if (!logic_a) {
                              logic_a = true;
                              NUM1 = Math.floor(Math.random() * 4.0);
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                 var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(Type.ARMOR, (int)NUM1));
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              item_A = var10000;
                           }
                        }

                        if (logic_a) {
                           double var10002;
                           CompoundTag var101;
                           label357: {
                              entity_b = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) ? GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) : entity;
                              entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                              item_A.getOrCreateTag().putDouble("skill", entity.getPersistentData().getDouble("skill"));
                              item_A.getOrCreateTag().putDouble("effect", entity.getPersistentData().getDouble("effect"));
                              var101 = item_A.getOrCreateTag();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var10002 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                    break label357;
                                 }
                              }

                              var10002 = 0.0;
                           }

                           var101.putDouble("COOLDOWN_TICKS", (double)Math.round(Math.max(Math.max(var10002, entity.getPersistentData().getDouble("COOLDOWN_TICKS")) * 2.0, 50.0)));
                           if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                              item_A.getOrCreateTag().putString("SHIKIGAMI_NAME", ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString());
                              CompoundTag var102 = item_A.getOrCreateTag();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = (double)_livEnt.getMaxHealth();
                              } else {
                                 var10002 = -1.0;
                              }

                              var102.putDouble("SHIKIGAMI_HP", var10002);
                           }

                           if (entity_a instanceof Player) {
                              String var10001 = entity_b.getDisplayName().getString();
                              item_A.setHoverName(Component.literal(var10001 + Component.translatable("jujutsu.message.cursed_technique").getString() + " (" + Component.translatable("jujutsu.overlay.cost").getString() + ": " + Math.round(item_A.getOrCreateTag().getDouble("COOLDOWN_TICKS")) + ")"));
                              if (entity_a instanceof Player) {
                                 Player _player = (Player)entity_a;
                                 ItemStack _setstack = item_A.copy();
                                 _setstack.setCount(1);
                                 ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 2815.0 && entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_cursed_technique"))) && !entity_a.isAlive() && !entity_a.level().isClientSide()) {
               entity_a.discard();
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity_a;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            equipment_item = var10000.copy();
            if (equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               label519: {
                  if (entity_a instanceof Player) {
                     Player _plrCldCheck108 = (Player)entity_a;
                     if (_plrCldCheck108.getCooldowns().isOnCooldown(equipment_item.getItem())) {
                        break label519;
                     }
                  }

                  logic_start = false;
                  if (cursed_technique) {
                     CompoundTag var104 = entity.getPersistentData();
                     STR1 = "skill" + Math.round(var104.getDouble("skill"));
                     logic_start = true;
                  } else if (entity.getPersistentData().getDouble("skill_domain") != 0.0) {
                     CompoundTag var105 = entity.getPersistentData();
                     STR1 = "domain" + Math.round(var105.getDouble("skill_domain"));
                     logic_start = true;
                  }

                  if (logic_start && equipment_item.getOrCreateTag().getDouble(STR1) == 0.0) {
                     NUM1 = 1.0;

                     for(int index1 = 0; index1 < 800; ++index1) {
                        if (equipment_item.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("") || equipment_item.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity_a;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity_a;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble(STR1, 1.0);
                           if (entity_a instanceof Player) {
                              Player _player = (Player)entity_a;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_start").getString()), false);
                              }
                           }
                           break;
                        }

                        ++NUM1;
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            equipment_item = var10000.copy();
            if (equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               label520: {
                  if (entity instanceof Player) {
                     Player _plrCldCheck124 = (Player)entity;
                     if (_plrCldCheck124.getCooldowns().isOnCooldown(equipment_item.getItem())) {
                        break label520;
                     }
                  }

                  if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                     label497: {
                        if (entity instanceof Player) {
                           JujutsucraftModVariables.PlayerVariables pVars_target = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                           T1 = pVars_target.PlayerCurseTechnique;
                           T2 = pVars_target.PlayerCurseTechnique2;
                        }

                        if (entity instanceof Player) {
                           if (T1 != 16.0 && T2 != 16.0) {
                              break label497;
                           }
                        } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof CursedSpiritGrade010Entity)) {
                           break label497;
                        }

                        CompoundTag var109 = equipment_item.getOrCreateTag();
                        CompoundTag var110 = entity_a.getPersistentData();
                        if (var109.getDouble("skill" + Math.round(var110.getDouble("skill"))) >= 100.0 && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
                           entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                        }
                     }
                  }
               }
            }

            if (!entity_a.isAlive() && entity_a instanceof Player && !(entity instanceof Player)) {
               entity_b = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) ? GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) : entity;
               entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
               if (!(entity_b instanceof Player)) {
                  NUM1 = 1.0;

                  for(int index2 = 0; index2 < 128; ++index2) {
                     STR1 = "pName" + Math.round(NUM1);
                     if (entity_b.getPersistentData().getString(STR1).equals("")) {
                        entity_b.getPersistentData().putString(STR1, entity_a.getDisplayName().getString());
                        break;
                     }

                     ++NUM1;
                  }
               }
            }

         }
      }
   }
}
