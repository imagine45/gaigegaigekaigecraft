package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.BloodBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ChosoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
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
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectCharactorProcedure {
   public EffectCharactorProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         ItemStack item_A = ItemStack.f_41583_;
         String STR1 = "";
         boolean cursed_technique = false;
         boolean logic_start = false;
         boolean logic_a = false;
         Entity entity_a = null;
         Entity entity_b = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double old_cool = 0.0;
         entity_a = entityiterator;
         if (entityiterator instanceof LivingEntity) {
            label498: {
               label459: {
                  label444: {
                     cursed_technique = entity.getPersistentData().m_128459_("skill") > 100.0 && !entity.getPersistentData().m_128471_("attack");
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                     z_pos = entityiterator.m_20189_();
                     if (entity instanceof EntityWaterEntity) {
                        int var10000;
                        if (entity instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                           var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                        } else {
                           var10000 = 0;
                        }

                        if (var10000 == 0) {
                           break label444;
                        }
                     }

                     if (!(entity instanceof EntityWater2Entity)) {
                        break label459;
                     }
                  }

                  label460: {
                     if (entityiterator instanceof Player) {
                        if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0) {
                           break label460;
                        }
                     } else if (entityiterator instanceof ChosoEntity || entityiterator instanceof EsoEntity || entityiterator instanceof KamoNoritoshiEntity) {
                        break label460;
                     }

                     label425: {
                        if (entityiterator instanceof EntityWaterEntity) {
                           int var79;
                           if (entityiterator instanceof EntityWaterEntity) {
                              EntityWaterEntity _datEntI = (EntityWaterEntity)entityiterator;
                              var79 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                           } else {
                              var79 = 0;
                           }

                           if (var79 == 2) {
                              break label425;
                           }
                        }

                        if (!(entityiterator instanceof BloodBallEntity) && !(entityiterator instanceof SlicingExorcismEntity)) {
                           break label459;
                        }
                     }

                     if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                     }

                     if (!entityiterator.m_9236_().m_5776_()) {
                        entityiterator.m_146870_();
                     }
                     break label459;
                  }

                  old_cool = entityiterator.getPersistentData().m_128459_("COOLDOWN_TICKS");
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 0, false, false));
                     }
                  }

                  entityiterator.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
               }

               if (entity.getPersistentData().m_128471_("attack")) {
                  EffectAttackProcedure.execute(world, entityiterator, entity);
               }

               if (cursed_technique && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_cursed_technique"))) && entity.getPersistentData().m_128459_("skill") != 705.0) {
                  label475: {
                     if (entityiterator instanceof Player) {
                        if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 5.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 5.0) {
                           break label475;
                        }
                     } else if (!(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity)) {
                        break label475;
                     }

                     if (LocateRikaProcedure.execute(world, entityiterator)) {
                        if (entity.getPersistentData().m_128459_("skill") >= 305.0 && entity.getPersistentData().m_128459_("skill") < 320.0) {
                           if (entityiterator instanceof ServerPlayer) {
                              ServerPlayer _player = (ServerPlayer)entityiterator;
                              Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"));
                              AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                              if (!_ap.m_8193_()) {
                                 for(String criteria : _ap.m_8219_()) {
                                    _player.m_8960_().m_135988_(_adv, criteria);
                                 }
                              }
                           }
                        } else if (entity.getPersistentData().m_128459_("skill") != 3810.0 || !(entityiterator instanceof Player) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity)) {
                           if (entityiterator instanceof Player) {
                              logic_a = true;
                              AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                              LazyOptional var80 = entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                              Objects.requireNonNull(_iitemhandlerref);
                              var80.ifPresent(_iitemhandlerref::set);
                              if (_iitemhandlerref.get() != null) {
                                 for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                    ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                    if (itemstackiterator.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.m_41784_().m_128459_("skill") == entity.getPersistentData().m_128459_("skill")) {
                                       if (itemstackiterator.m_41613_() < 10 && entityiterator instanceof Player) {
                                          Player _player = (Player)entityiterator;
                                          ItemStack _setstack = itemstackiterator.m_41777_();
                                          _setstack.m_41764_(1);
                                          ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                       }

                                       logic_a = false;
                                       break;
                                    }
                                 }
                              }

                              item_A = (new ItemStack((ItemLike)JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get())).m_41777_();
                              item_A.m_41721_(item_A.m_41776_() - 1);
                           } else {
                              logic_a = false;
                              NUM1 = 0.0;

                              for(int index0 = 0; index0 < 4; ++index0) {
                                 ItemStack var81;
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                    var81 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)NUM1));
                                 } else {
                                    var81 = ItemStack.f_41583_;
                                 }

                                 item_A = var81;
                                 if (item_A.m_41784_().m_128459_("skill") == 0.0 || item_A.m_41784_().m_128459_("skill") == entity.getPersistentData().m_128459_("skill")) {
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
                                 ItemStack var82;
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                    var82 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)NUM1));
                                 } else {
                                    var82 = ItemStack.f_41583_;
                                 }

                                 item_A = var82;
                              }
                           }

                           if (logic_a) {
                              CompoundTag var83;
                              double var10002;
                              label377: {
                                 entity_b = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) ? (new BiFunction<LevelAccessor, String, Entity>() {
                                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                       if (levelAccessor instanceof ServerLevel serverLevel) {
                                          try {
                                             return serverLevel.m_8791_(UUID.fromString(uuid));
                                          } catch (Exception var5) {
                                          }
                                       }

                                       return null;
                                    }
                                 }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) : entity;
                                 entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                                 item_A.m_41784_().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                                 item_A.m_41784_().m_128347_("effect", entity.getPersistentData().m_128459_("effect"));
                                 var83 = item_A.m_41784_();
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                       var10002 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                       break label377;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              var83.m_128347_("COOLDOWN_TICKS", (double)Math.round(Math.max(Math.max(var10002, entity.getPersistentData().m_128459_("COOLDOWN_TICKS")) * 2.0, 50.0)));
                              if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                 item_A.m_41784_().m_128359_("SHIKIGAMI_NAME", ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString());
                                 var83 = item_A.m_41784_();
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10002 = (double)_livEnt.m_21233_();
                                 } else {
                                    var10002 = -1.0;
                                 }

                                 var83.m_128347_("SHIKIGAMI_HP", var10002);
                              }

                              if (entity_a instanceof Player) {
                                 String var10001 = entity_b.m_5446_().getString();
                                 item_A.m_41714_(Component.m_237113_(var10001 + Component.m_237115_("jujutsu.message.cursed_technique").getString() + " (" + Component.m_237115_("jujutsu.overlay.cost").getString() + ": " + Math.round(item_A.m_41784_().m_128459_("COOLDOWN_TICKS")) + ")"));
                                 if (entity_a instanceof Player) {
                                    Player _player = (Player)entity_a;
                                    ItemStack _setstack = item_A.m_41777_();
                                    _setstack.m_41764_(1);
                                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                 }
                              }
                           }
                        } else if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("skill") == 2815.0 && entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_cursed_technique"))) && !entity_a.m_6084_() && !entity_a.m_9236_().m_5776_()) {
                  entity_a.m_146870_();
               }

               label469: {
                  if (entity_a instanceof Player) {
                     Player _plrCldCheck81 = (Player)entity_a;
                     ItemCooldowns var85 = _plrCldCheck81.m_36335_();
                     ItemStack var100;
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity_a;
                        var100 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var100 = ItemStack.f_41583_;
                     }

                     if (var85.m_41519_(var100.m_41720_())) {
                        break label469;
                     }
                  }

                  ItemStack var86;
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity_a;
                     var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var86 = ItemStack.f_41583_;
                  }

                  if (var86.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity_a;
                        var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var86 = ItemStack.f_41583_;
                     }

                     if (var86.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                        break label469;
                     }
                  }

                  logic_start = false;
                  if (cursed_technique) {
                     CompoundTag var88 = entity.getPersistentData();
                     STR1 = "skill" + Math.round(var88.m_128459_("skill"));
                     logic_start = true;
                  } else if (entity.getPersistentData().m_128459_("skill_domain") != 0.0) {
                     CompoundTag var89 = entity.getPersistentData();
                     STR1 = "domain" + Math.round(var89.m_128459_("skill_domain"));
                     logic_start = true;
                  }

                  if (logic_start) {
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity_a;
                        var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var86 = ItemStack.f_41583_;
                     }

                     if (var86.m_41784_().m_128459_(STR1) == 0.0) {
                        label483: {
                           NUM1 = 1.0;
                           int index1 = 0;

                           while(true) {
                              if (index1 >= 800) {
                                 break label483;
                              }

                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                 var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var86 = ItemStack.f_41583_;
                              }

                              if (var86.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals("")) {
                                 break;
                              }

                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                 var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var86 = ItemStack.f_41583_;
                              }

                              if (var86.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals(STR1)) {
                                 break;
                              }

                              ++NUM1;
                              ++index1;
                           }

                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity_a;
                              var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var86 = ItemStack.f_41583_;
                           }

                           var86.m_41784_().m_128359_("DATA" + Math.round(NUM1), STR1);
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity_a;
                              var86 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var86 = ItemStack.f_41583_;
                           }

                           var86.m_41784_().m_128347_(STR1, 1.0);
                           if (entity_a instanceof Player) {
                              Player _player = (Player)entity_a;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.adaptation_start").getString()), false);
                              }
                           }
                        }
                     }
                  }
               }

               if (entity instanceof Player) {
                  Player _plrCldCheck102 = (Player)entity;
                  ItemCooldowns var95 = _plrCldCheck102.m_36335_();
                  ItemStack var101;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var101 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var101 = ItemStack.f_41583_;
                  }

                  if (var95.m_41519_(var101.m_41720_())) {
                     break label498;
                  }
               }

               ItemStack var96;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var96 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var96 = ItemStack.f_41583_;
               }

               if (var96.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var96 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var96 = ItemStack.f_41583_;
                  }

                  if (var96.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                     break label498;
                  }
               }

               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                     break label498;
                  }
               } else if (!(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof CursedSpiritGrade010Entity)) {
                  break label498;
               }

               if (entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var96 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var96 = ItemStack.f_41583_;
                  }

                  CompoundTag var99 = var96.m_41784_();
                  CompoundTag var102 = entity_a.getPersistentData();
                  if (var99.m_128459_("skill" + Math.round(var102.m_128459_("skill"))) >= 100.0 && !entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
                     entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "kill @s");
                  }
               }
            }
         }

         if (!entity_a.m_6084_() && entity_a instanceof Player && !(entity instanceof Player)) {
            entity_b = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) ? (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) : entity;
            entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
            if (!(entity_b instanceof Player)) {
               NUM1 = 1.0;

               for(int index2 = 0; index2 < 128; ++index2) {
                  STR1 = "pName" + Math.round(NUM1);
                  if (entity_b.getPersistentData().m_128461_(STR1).equals("")) {
                     entity_b.getPersistentData().m_128359_(STR1, entity_a.m_5446_().getString());
                     break;
                  }

                  ++NUM1;
               }
            }
         }

      }
   }
}
