package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
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
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               return;
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer _serverPlayer) {
                  return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            num_timer = 20.0;
         } else {
            num_timer = 600.0;
            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt_break", entity.getPersistentData().m_128459_("cnt_break") + 1.0);
               if (!(entity instanceof GojoSatoruEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
                  if (entity.getPersistentData().m_128459_("cnt_break") > 1.0) {
                     entity.getPersistentData().m_128347_("cnt_break", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                        }
                     }
                  }
               } else {
                  logic_a = false;
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     label153: {
                        LivingEntity var22 = var10000;
                        if (var22 instanceof LivingEntity) {
                           LivingEntity _livEnt = var22;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var39 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label153;
                           }
                        }

                        var39 = 0;
                     }

                     int var10001;
                     label148: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label148;
                           }
                        }

                        var10001 = 0;
                     }

                     if (var39 > var10001 - 7) {
                        num_timer = Math.min(num_timer, 300.0);
                        if (entity.getPersistentData().m_128459_("cnt_break") > 3.0) {
                           entity.getPersistentData().m_128347_("cnt_break", 0.0);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 0, false, false));
                              }
                           }

                           logic_a = true;
                        }
                     }
                  }

                  if (!logic_a && entity.getPersistentData().m_128459_("cnt_break") > 3.0) {
                     entity.getPersistentData().m_128347_("cnt_break", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                        }
                     }
                  }
               }
            }
         }

         if (!entity.getPersistentData().m_128471_("DomainDefeated") && !entity.getPersistentData().m_128471_("Failed")) {
            BreakDomainProcedure.execute(world, entity);
         } else {
            entity.getPersistentData().m_128379_("DomainDefeated", false);
         }

         if (!entity.getPersistentData().m_128471_("attack")) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         NUM1 = 0.0;
         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
         LazyOptional var40 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
         Objects.requireNonNull(_iitemhandlerref);
         var40.ifPresent(_iitemhandlerref::set);
         if (_iitemhandlerref.get() != null) {
            for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
               ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
               if (itemstackiterator.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && itemstackiterator.m_41784_().m_128459_("skill") != 0.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/item replace entity @s container." + Math.round(NUM1) + " with air");
               }

               ++NUM1;
            }
         }

         label124: {
            if (entity.getPersistentData().m_128459_("skill_domain") != 6.0) {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 6.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 6.0) {
                     break label124;
                  }
               } else if (!(entity instanceof SukunaFushiguroEntity) && !(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
                  break label124;
               }
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            old_cnt4 = entity.getPersistentData().m_128459_("cnt4");
            entity.getPersistentData().m_128347_("skill", 1.0);
            ReturnShadowProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("skill", old_skill);
            entity.getPersistentData().m_128347_("cnt4", old_cnt4);
         }

         DespawnRangedAmmoProcedure.execute(world, x, y, z, entity);
         if (num_timer >= 600.0) {
            JujutsucraftMod.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 600, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label20: {
                        var10001 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                              break label20;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001.<init>(var10003, var10004 + 600, 0, false, false);
                     _entity.m_7292_(var10001);
                  }
               }

            });
         } else if (num_timer >= 300.0) {
            JujutsucraftMod.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 300, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label20: {
                        var10001 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                              break label20;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001.<init>(var10003, var10004 + 300, 0, false, false);
                     _entity.m_7292_(var10001);
                  }
               }

            });
         } else {
            JujutsucraftMod.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 20, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label20: {
                        var10001 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                              break label20;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001.<init>(var10003, var10004 + 20, 0, false, false);
                     _entity.m_7292_(var10001);
                  }
               }

            });
         }

         JujutsucraftMod.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _entity) {
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 60, 0, true, true));
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
            }

            int var10000;
            label38: {
               if (entity instanceof LivingEntity _livEnt) {
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).m_19564_();
                     break label38;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0 && entity instanceof LivingEntity _entity) {
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
            }

         });
         if (entity.getPersistentData().m_128459_("select") != 0.0) {
            entity.getPersistentData().m_128347_("select", 0.0);
            entity.getPersistentData().m_128347_("skill", 0.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

         if (entity.getPersistentData().m_128459_("dust_amount") != 0.0) {
            entity.getPersistentData().m_128347_("dust_amount", 0.0);
            String _setval = "";
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY1 = _setval;
               capability.syncPlayerVariables(entity);
            });
            _setval = "";
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY2 = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         entity.getPersistentData().m_128347_("skill_domain", 0.0);
         entity.getPersistentData().m_128379_("Failed", false);
         entity.getPersistentData().m_128379_("Cover", false);
         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
