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
         execute(event, event.getEntity().m_9236_(), event.getSource(), event.getEntity());
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
         if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation"))) && !damagesource.m_276093_(DamageTypes.f_286979_)) {
            label124: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     break label124;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19596_);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19603_);
               }
            }

            if (entity instanceof Player && world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
               T1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
               T2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
               if (T1 > 0.0 || T2 > 0.0) {
                  if (Math.random() < (T1 != 27.0 && T2 != 27.0 ? 0.005 : 0.05)) {
                     label102: {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr7 = (ServerPlayer)entity;
                           if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entity;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                              break label102;
                           }
                        }

                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr10 = (ServerPlayer)entity;
                     if (_plr10.m_9236_() instanceof ServerLevel && _plr10.m_8960_().m_135996_(_plr10.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).m_8193_() && Math.random() < (T1 != 27.0 && T2 != 27.0 ? 0.005 : 0.05) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_amplification"));
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

            OgiZeninPassiveSkillProcedure.execute(entity);
         }

      }
   }
}
