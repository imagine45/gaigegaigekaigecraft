package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class EffectCursedSpeech1Procedure {
   public EffectCursedSpeech1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         String message = "";
         Entity entity_a = null;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
         z_pos = entityiterator.m_20189_();
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, 0.2, 0.4, 0.2, 0.0);
         }

         if (!(entityiterator.getPersistentData().m_128459_("skill") > 0.0) || entityiterator.getPersistentData().m_128459_("select") == 0.0) {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }

            entityiterator.getPersistentData().m_128347_("skill", -1000.0);
            entity.getPersistentData().m_128379_("attack", false);
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 20, 0, false, false));
            }
         }

         if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
            entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "playsound jujutsucraft:tinnitus master @s");
         }

         if (entityiterator instanceof Player) {
            message = "NULL";
            if (entity.getPersistentData().m_128459_("effect") == 305.0) {
               message = Component.m_237115_("jujutsu.technique.explode").getString();
            } else if (entity.getPersistentData().m_128459_("effect") == 306.0) {
               message = Component.m_237115_("jujutsu.technique.get_crushed").getString();
            } else if (entity.getPersistentData().m_128459_("effect") == 307.0) {
               message = Component.m_237115_("jujutsu.technique.crumble_away").getString();
            } else if (entity.getPersistentData().m_128459_("effect") == 308.0) {
               message = Component.m_237115_("jujutsu.technique.dont_move").getString();
            } else if (entity.getPersistentData().m_128459_("effect") == 309.0) {
               message = Component.m_237115_("jujutsu.technique.blast_away").getString();
            }

            if (!message.equals("NULL") && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var10000 = entity.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               String var10002 = entityiterator.m_5446_().getString();
               var10000.m_230957_(var10001, "tell " + var10002 + " " + message);
            }
         }

      }
   }
}
