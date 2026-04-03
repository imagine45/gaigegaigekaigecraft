package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenBeforeEntityisHurtNoSourceProcedure {
   public WhenBeforeEntityisHurtNoSourceProcedure() {
   }

   @SubscribeEvent
   public static void onEntityAttacked(LivingHurtEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getSource(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
      execute((Event)null, world, damagesource, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         double damageAmount = 0.0;
         double T1 = 0.0;
         double T2 = 0.0;
         if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation"))) && !damagesource.is(DamageTypes.GENERIC_KILL)) {
            label124: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     break label124;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.JUMP);
               }
            }

            if (entity instanceof Player && world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
               JujutsucraftModVariables.PlayerVariables pVars = null;
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
               T1 = pVars.PlayerCurseTechnique;
               T2 = pVars.PlayerCurseTechnique2;
               if (T1 > 0.0 || T2 > 0.0) {
                  if (Math.random() < (T1 != 27.0 && T2 != 27.0 ? 0.005 : 0.05)) {
                     label102: {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr7 = (ServerPlayer)entity;
                           if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"))).isDone()) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entity;
                                 Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_2"));
                                 AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                 if (!_ap.isDone()) {
                                    for(String criteria : _ap.getRemainingCriteria()) {
                                       _player.getAdvancements().award(_adv, criteria);
                                    }
                                 }
                              }
                              break label102;
                           }
                        }

                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr10 = (ServerPlayer)entity;
                     if (_plr10.level() instanceof ServerLevel && _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_expansion"))).isDone() && Math.random() < (T1 != 27.0 && T2 != 27.0 ? 0.005 : 0.05) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_amplification"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }
            }

            OgiZeninPassiveSkillProcedure.execute(entity);
         }

      }
   }
}
