package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class HelpMessagesProcedure {
   public HelpMessagesProcedure() {
   }

   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getAdvancement(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Advancement advancement, Entity entity) {
      execute((Event)null, world, advancement, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Advancement advancement, Entity entity) {
      if (advancement != null && entity != null) {
         if (entity.m_9236_().m_5776_()) {
            if (world instanceof Level) {
               Level _lvl0 = (Level)world;
               if (_lvl0.m_7654_() != null && _lvl0.m_7654_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:advancement_select_technique")).equals(advancement) && !ModList.get().isLoaded("minepiece")) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        String var10001 = OverlayKeyRProcedure.execute(entity);
                        _player.m_5661_(Component.m_237113_("§3§n" + var10001 + ": " + Component.m_237115_("minepiece.message.help.change_skill").getString()), false);
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        String var16 = OverlayKeyZProcedure.execute(entity);
                        _player.m_5661_(Component.m_237113_("§3§n" + var16 + ": " + Component.m_237115_("minepiece.message.help.use_skill").getString()), false);
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_("§3§n" + Component.m_237115_("minepiece.message.help.guard").getString()), false);
                     }
                  }
               }
            }

            if (world instanceof Level) {
               Level _lvl8 = (Level)world;
               if (_lvl8.m_7654_() != null && _lvl8.m_7654_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1")).equals(advancement) && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     String var17 = OverlayKeyMProcedure.execute(entity);
                     _player.m_5661_(Component.m_237113_("§3§n" + var17 + Component.m_237115_("jujutsucraft.message.help.use_reverse_cursed_technique").getString()), false);
                  }
               }
            }

            if (world instanceof Level) {
               Level _lvl11 = (Level)world;
               if (_lvl11.m_7654_() != null && _lvl11.m_7654_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_amplification")).equals(advancement) && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     String var18 = OverlayKeyNProcedure.execute(entity);
                     _player.m_5661_(Component.m_237113_("§3§n" + var18 + Component.m_237115_("jujutsucraft.message.help.use_domain_amplification").getString()), false);
                  }
               }
            }

            if (world instanceof Level) {
               Level _lvl14 = (Level)world;
               if (_lvl14.m_7654_() != null && _lvl14.m_7654_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_simple_domain")).equals(advancement) && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     String var19 = OverlayKeyGProcedure.execute(entity);
                     _player.m_5661_(Component.m_237113_("§3§n" + var19 + Component.m_237115_("jujutsucraft.message.help.use_simple_domain").getString()), false);
                  }
               }
            }

            if (world instanceof Level) {
               Level _lvl17 = (Level)world;
               if (_lvl17.m_7654_() != null && _lvl17.m_7654_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_falling_blossom_emotion")).equals(advancement) && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("§3§n" + Component.m_237115_("jujutsucraft.message.help.use_falling_blossom_emotion").getString()), false);
                  }
               }
            }
         }

      }
   }
}
