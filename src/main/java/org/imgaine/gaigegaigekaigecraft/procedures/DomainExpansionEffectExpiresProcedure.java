package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class DomainExpansionEffectExpiresProcedure {
   public DomainExpansionEffectExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double old_cnt4 = 0.0;
         double num_timer = 0.0;
         double old_skill = 0.0;
         double NUM1 = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               return;
            }
         }

         if (InlineMethodHandler.checkGamemodeCreative(entity)) {
            num_timer = 20.0;
         } else {
            label193: {
               num_timer = 600.0;
               if (!(entity instanceof Player)) {
                  entity.getPersistentData().putDouble("cnt_break", entity.getPersistentData().getDouble("cnt_break") + 1.0);
                  if (!(entity instanceof GojoSatoruEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
                     if (entity.getPersistentData().getDouble("cnt_break") > 1.0) {
                        entity.getPersistentData().putDouble("cnt_break", 0.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                           }
                        }
                     }
                  } else {
                     logic_a = false;
                     LivingEntity var10000;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }
                        int var39;
                        label164: {
                           LivingEntity var22 = var10000;
                           if (var22 instanceof LivingEntity) {
                              LivingEntity _livEnt = var22;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var39 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label164;
                              }
                           }

                           var39 = 0;
                        }

                        int var10001;
                        label159: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label159;
                              }
                           }

                           var10001 = 0;
                        }

                        if (var39 > var10001 - 7) {
                           num_timer = Math.min(num_timer, 300.0);
                           if (entity.getPersistentData().getDouble("cnt_break") > 3.0) {
                              entity.getPersistentData().putDouble("cnt_break", 0.0);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 0, false, false));
                                 }
                              }

                              logic_a = true;
                           }
                        }
                     }

                     if (!logic_a && entity.getPersistentData().getDouble("cnt_break") > 3.0) {
                        entity.getPersistentData().putDouble("cnt_break", 0.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                           }
                        }
                     }
                  }
               }

               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 15.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 15.0) {
                     break label193;
                  }
               } else if (!(entity instanceof MahitoEntity)) {
                  break label193;
               }

               num_timer = Math.min(num_timer, 300.0);
            }
         }

         if (!entity.getPersistentData().getBoolean("DomainDefeated") && !entity.getPersistentData().getBoolean("Failed")) {
            BreakDomainProcedure.execute(world, entity);
         } else {
            entity.getPersistentData().putBoolean("DomainDefeated", false);
         }

         if (!entity.getPersistentData().getBoolean("attack")) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         NUM1 = 0.0;
         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
         LazyOptional var40 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
         Objects.requireNonNull(_iitemhandlerref);
         var40.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
         if (_iitemhandlerref.get() != null) {
            for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
               ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
               if (itemstackiterator.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && itemstackiterator.getOrCreateTag().getDouble("skill") != 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "/item replace entity @s container." + Math.round(NUM1) + " with air");
               }

               ++NUM1;
            }
         }

         label130: {
            if (entity.getPersistentData().getDouble("skill_domain") != 6.0) {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 6.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 6.0) {
                     break label130;
                  }
               } else if (!(entity instanceof SukunaFushiguroEntity) && !(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
                  break label130;
               }
            }

            old_skill = entity.getPersistentData().getDouble("skill");
            old_cnt4 = entity.getPersistentData().getDouble("cnt4");
            entity.getPersistentData().putDouble("skill", 1.0);
            ReturnShadowProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("skill", old_skill);
            entity.getPersistentData().putDouble("cnt4", old_cnt4);
         }

         DespawnRangedAmmoProcedure.execute(world, x, y, z, entity);
         if (num_timer >= 600.0) {
            Gaigegaigekaigecraft.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 600, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label20: {

                        var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                              break label20;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, var10004 + 600, 0, false, false);
                     _entity.addEffect(var10001);
                  }
               }

            });
         } else if (num_timer >= 300.0) {
            Gaigegaigekaigecraft.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 300, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label20: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                              break label20;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, var10004 + 300, 0, false, false);
                     _entity.addEffect(var10001);
                  }
               }

            });
         } else {
            Gaigegaigekaigecraft.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 20, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label20: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                              break label20;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, var10004 + 20, 0, false, false);
                     _entity.addEffect(var10001);
                  }
               }

            });
         }

         Gaigegaigekaigecraft.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 60, 0, true, true));
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
            }

            int var10000;
            label38: {
               if (entity instanceof LivingEntity _livEnt) {
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier();
                     break label38;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0 && entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
            }

         });
         if (entity.getPersistentData().getDouble("select") != 0.0) {
            entity.getPersistentData().putDouble("select", 0.0);
            entity.getPersistentData().putDouble("skill", 0.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

         if (entity.getPersistentData().getDouble("dust_amount") != 0.0) {
            entity.getPersistentData().putDouble("dust_amount", 0.0);
            String _setval1 = "";
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY1 = _setval1;
               capability.syncPlayerVariables(entity);
            });
            String _setval2 = "";
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY2 = _setval2;
               capability.syncPlayerVariables(entity);
            });
         }

         entity.getPersistentData().putDouble("skill_domain", 0.0);
         entity.getPersistentData().putBoolean("Failed", false);
         entity.getPersistentData().putBoolean("Cover", false);
         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
