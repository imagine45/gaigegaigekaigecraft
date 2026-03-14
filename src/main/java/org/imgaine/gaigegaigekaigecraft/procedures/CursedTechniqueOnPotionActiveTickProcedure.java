package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class CursedTechniqueOnPotionActiveTickProcedure {
   public CursedTechniqueOnPotionActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double num1 = 0.0;
         double skill = 0.0;
         double power = 0.0;
         if (entity.m_6084_()) {
            skill = (double)Math.round(entity.getPersistentData().m_128459_("skill"));
            if (skill == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else {
               num1 = skill % 100.0;
               if (num1 == 21.0) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                  if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_(""), true);
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", 0.0);
                  } else {
                     power = (double)Math.round((20.0 - entity.getPersistentData().m_128459_("cnt3")) * 0.25);
                     STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

                     for(int index0 = 0; index0 < (int)power; ++index0) {
                        STR1 = "■" + STR1 + "■";
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_(STR1), true);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt3") >= 20.0) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_(""), true);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                        }

                        entity.getPersistentData().m_128347_("skill", 0.0);
                        boolean _setval = true;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.noChangeTechnique = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                        KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     }
                  }
               } else if (skill >= -100.0 && num1 >= 0.0 && num1 <= 2.0) {
                  if (skill < 0.0 || skill >= 100.0) {
                     if (num1 == 0.0) {
                        AttackWeakProcedure.execute(world, x, y, z, entity);
                     } else if (num1 == 1.0) {
                        AttackStrongProcedure.execute(world, x, y, z, entity);
                     } else if (num1 == 2.0) {
                        AttackContinueProcedure.execute(world, entity);
                     }
                  }
               } else if (skill >= 500.0) {
                  if (skill >= 1000.0) {
                     CursedTechniqueOnPotionActivetick2Procedure.execute(world, x, y, z, entity);
                  } else if (skill >= 900.0) {
                     CursedTechniqueTsukumoProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= 800.0) {
                     CursedTechniqueDagonProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= 700.0) {
                     CursedTechniqueKashimoProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= 600.0) {
                     CursedTechniqueFushiguroProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= 500.0) {
                     CursedTechniqueOkkotsuProcedure.execute(world, x, y, z, entity);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }
               } else if (skill >= 400.0) {
                  CursedTechniqueJogoProcedure.execute(world, x, y, z, entity);
               } else if (skill >= 300.0) {
                  CursedTechniqueCursedSpeechProcedure.execute(world, x, y, z, entity);
               } else if (skill >= 200.0) {
                  CursedTechniqueGojoProcedure.execute(world, x, y, z, entity);
               } else if (skill >= 100.0) {
                  CursedTechniqueSukunaProcedure.execute(world, x, y, z, entity);
               } else if (skill >= -100.0) {
                  PhysicalGiftedProcedure.execute(world, x, y, z, entity);
               } else if (!(skill <= -999.0)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }
               } else {
                  if (skill == -999.0) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("§k12345678901234567890123456789012345678901234567890123"), false);
                        }
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle minecraft:enchant ~ ~" + entity.m_20206_() + " ~ 0.25 0.25 0.25 1 250 force @s");
                     }

                     ItemStack var10000;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128459_("domain2") >= 100.0) {
                           label208: {
                              if (entity instanceof Player) {
                                 label205: {
                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _plr23 = (ServerPlayer)entity;
                                       if (_plr23.m_9236_() instanceof ServerLevel && _plr23.m_8960_().m_135996_(_plr23.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= 0.0) {
                                          break label205;
                                       }
                                    }

                                    if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") > 0.0)) {
                                       break label208;
                                    }
                                 }

                                 if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 6.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 6.0) {
                                    break label208;
                                 }
                              } else if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") > 0.0)) {
                                 break label208;
                              }

                              ResetCounterProcedure.execute(entity);
                              SummonMahoragaProcedure.execute(world, x, y, z, entity);
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 5, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 1, false, false));
                     }
                  }

                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var40 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var40.ifPresent(_iitemhandlerref::set);
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                        if (entity instanceof Player) {
                           Player _plrCldCheck30 = (Player)entity;
                           if (_plrCldCheck30.m_36335_().m_41519_(itemstackiterator.m_41720_())) {
                              continue;
                           }
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_36335_().m_41524_(itemstackiterator.m_41720_(), 20);
                        }
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt_x", Math.min(entity.getPersistentData().m_128459_("cnt_x"), 0.0));
               }
            }

            if (entity.getPersistentData().m_128471_("betrayal") && entity.getPersistentData().m_128471_("PRESS_Z") && entity.getPersistentData().m_128459_("Damage") == 0.0) {
               entity.getPersistentData().m_128379_("betrayal", false);
            }
         }

      }
   }
}
