package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.network.KeyAMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyBackstepMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyChangeTechniqueMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyDMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyDomainAmplificationMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyForwardMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyResetTechniqueMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyReverseCursedTechniqueMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeySimpleDomainMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeySpaceMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyStartTechniqueMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeySwitchCursedTechniqueMessage;
import org.imgaine.gaigegaigekaigecraft.network.KeyUseMainSkillMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftModKeyMappings {
   public static final KeyMapping KEY_CHANGE_TECHNIQUE = new KeyMapping("key.gaigegaigekaigecraft.key_change_technique", 82, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyChangeTechniqueMessage(0, 0));
            KeyChangeTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_START_TECHNIQUE = new KeyMapping("key.gaigegaigekaigecraft.key_start_technique", 90, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyStartTechniqueMessage(0, 0));
            KeyStartTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_START_TECHNIQUE_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_START_TECHNIQUE_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyStartTechniqueMessage(1, dt));
            KeyStartTechniqueMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_SIMPLE_DOMAIN = new KeyMapping("key.gaigegaigekaigecraft.key_simple_domain", 71, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeySimpleDomainMessage(0, 0));
            KeySimpleDomainMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_SIMPLE_DOMAIN_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_SIMPLE_DOMAIN_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeySimpleDomainMessage(1, dt));
            KeySimpleDomainMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_RESET_TECHNIQUE = new KeyMapping("key.gaigegaigekaigecraft.key_reset_technique", 88, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyResetTechniqueMessage(0, 0));
            KeyResetTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_REVERSE_CURSED_TECHNIQUE = new KeyMapping("key.gaigegaigekaigecraft.key_reverse_cursed_technique", 77, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyReverseCursedTechniqueMessage(0, 0));
            KeyReverseCursedTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_REVERSE_CURSED_TECHNIQUE_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_REVERSE_CURSED_TECHNIQUE_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyReverseCursedTechniqueMessage(1, dt));
            KeyReverseCursedTechniqueMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_BACKSTEP = new KeyMapping("key.gaigegaigekaigecraft.key_backstep", 83, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyBackstepMessage(0, 0));
            KeyBackstepMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_BACKSTEP_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_BACKSTEP_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyBackstepMessage(1, dt));
            KeyBackstepMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_DOMAIN_AMPLIFICATION = new KeyMapping("key.gaigegaigekaigecraft.key_domain_amplification", 78, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyDomainAmplificationMessage(0, 0));
            KeyDomainAmplificationMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_SPACE = new KeyMapping("key.gaigegaigekaigecraft.key_space", 32, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeySpaceMessage(0, 0));
            KeySpaceMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_SPACE_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_SPACE_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeySpaceMessage(1, dt));
            KeySpaceMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_FORWARD = new KeyMapping("key.gaigegaigekaigecraft.key_forward", 87, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyForwardMessage(0, 0));
            KeyForwardMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_FORWARD_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_FORWARD_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyForwardMessage(1, dt));
            KeyForwardMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_SWITCH_CURSED_TECHNIQUE = new KeyMapping("key.gaigegaigekaigecraft.key_switch_cursed_technique", 67, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeySwitchCursedTechniqueMessage(0, 0));
            KeySwitchCursedTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_USE_MAIN_SKILL = new KeyMapping("key.gaigegaigekaigecraft.key_use_main_skill", 86, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyUseMainSkillMessage(0, 0));
            KeyUseMainSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_USE_MAIN_SKILL_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_USE_MAIN_SKILL_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyUseMainSkillMessage(1, dt));
            KeyUseMainSkillMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_A = new KeyMapping("key.gaigegaigekaigecraft.key_a", 65, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyAMessage(0, 0));
            KeyAMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_A_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_A_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyAMessage(1, dt));
            KeyAMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping KEY_D = new KeyMapping("key.gaigegaigekaigecraft.key_d", 68, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyDMessage(0, 0));
            KeyDMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            JujutsucraftModKeyMappings.KEY_D_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - JujutsucraftModKeyMappings.KEY_D_LASTPRESS);
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new KeyDMessage(1, dt));
            KeyDMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   private static long KEY_START_TECHNIQUE_LASTPRESS = 0L;
   private static long KEY_SIMPLE_DOMAIN_LASTPRESS = 0L;
   private static long KEY_REVERSE_CURSED_TECHNIQUE_LASTPRESS = 0L;
   private static long KEY_BACKSTEP_LASTPRESS = 0L;
   private static long KEY_SPACE_LASTPRESS = 0L;
   private static long KEY_FORWARD_LASTPRESS = 0L;
   private static long KEY_USE_MAIN_SKILL_LASTPRESS = 0L;
   private static long KEY_A_LASTPRESS = 0L;
   private static long KEY_D_LASTPRESS = 0L;

   public JujutsucraftModKeyMappings() {
   }

   @SubscribeEvent
   public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
      event.register(KEY_CHANGE_TECHNIQUE);
      event.register(KEY_START_TECHNIQUE);
      event.register(KEY_SIMPLE_DOMAIN);
      event.register(KEY_RESET_TECHNIQUE);
      event.register(KEY_REVERSE_CURSED_TECHNIQUE);
      event.register(KEY_BACKSTEP);
      event.register(KEY_DOMAIN_AMPLIFICATION);
      event.register(KEY_SPACE);
      event.register(KEY_FORWARD);
      event.register(KEY_SWITCH_CURSED_TECHNIQUE);
      event.register(KEY_USE_MAIN_SKILL);
      event.register(KEY_A);
      event.register(KEY_D);
   }

   @EventBusSubscriber({Dist.CLIENT})
   public static class KeyEventListener {
      public KeyEventListener() {
      }

      @SubscribeEvent
      public static void onClientTick(TickEvent.ClientTickEvent event) {
         if (Minecraft.getInstance().screen == null) {
            JujutsucraftModKeyMappings.KEY_CHANGE_TECHNIQUE.consumeClick();
            JujutsucraftModKeyMappings.KEY_START_TECHNIQUE.consumeClick();
            JujutsucraftModKeyMappings.KEY_SIMPLE_DOMAIN.consumeClick();
            JujutsucraftModKeyMappings.KEY_RESET_TECHNIQUE.consumeClick();
            JujutsucraftModKeyMappings.KEY_REVERSE_CURSED_TECHNIQUE.consumeClick();
            JujutsucraftModKeyMappings.KEY_BACKSTEP.consumeClick();
            JujutsucraftModKeyMappings.KEY_DOMAIN_AMPLIFICATION.consumeClick();
            JujutsucraftModKeyMappings.KEY_SPACE.consumeClick();
            JujutsucraftModKeyMappings.KEY_FORWARD.consumeClick();
            JujutsucraftModKeyMappings.KEY_SWITCH_CURSED_TECHNIQUE.consumeClick();
            JujutsucraftModKeyMappings.KEY_USE_MAIN_SKILL.consumeClick();
            JujutsucraftModKeyMappings.KEY_A.consumeClick();
            JujutsucraftModKeyMappings.KEY_D.consumeClick();
         }

      }
   }
}
