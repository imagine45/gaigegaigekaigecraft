package org.imgaine.gaigegaigekaigecraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftModAttributes {
   public static final DeferredRegister<Attribute> REGISTRY;
   public static final RegistryObject<Attribute> SIZE;
   public static final RegistryObject<Attribute> PROFESSION;
   public static final RegistryObject<Attribute> ANIMATION_1;
   public static final RegistryObject<Attribute> ANIMATION_2;

   public JujutsucraftModAttributes() {
   }

   @SubscribeEvent
   public static void addAttributes(EntityAttributeModificationEvent event) {
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)SIZE.get()));
      event.add(EntityType.PLAYER, (Attribute)PROFESSION.get());
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)ANIMATION_1.get()));
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)ANIMATION_2.get()));
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "gaigegaigekaigecraft");
      SIZE = REGISTRY.register("size", () -> (new RangedAttribute("attribute.gaigegaigekaigecraft.size", 1.0, 0.1, 500.0)).setSyncable(true));
      PROFESSION = REGISTRY.register("profession", () -> (new RangedAttribute("attribute.gaigegaigekaigecraft.profession", 0.0, 0.0, 0.0)).setSyncable(true));
      ANIMATION_1 = REGISTRY.register("animation_1", () -> (new RangedAttribute("attribute.gaigegaigekaigecraft.animation_1", 0.0, -1000.0, 1000.0)).setSyncable(true));
      ANIMATION_2 = REGISTRY.register("animation_2", () -> (new RangedAttribute("attribute.gaigegaigekaigecraft.animation_2", 0.0, -1000.0, 1000.0)).setSyncable(true));
   }

   @EventBusSubscriber
   public static class PlayerAttributesSync {
      public PlayerAttributesSync() {
      }

      @SubscribeEvent
      public static void playerClone(PlayerEvent.Clone event) {
         Player oldPlayer = event.getOriginal();
         Player newPlayer = event.getEntity();
         newPlayer.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(oldPlayer.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue());
         newPlayer.getAttribute((Attribute)JujutsucraftModAttributes.PROFESSION.get()).setBaseValue(oldPlayer.getAttribute((Attribute)JujutsucraftModAttributes.PROFESSION.get()).getBaseValue());
         newPlayer.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(oldPlayer.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue());
         newPlayer.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(oldPlayer.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).getBaseValue());
      }
   }
}
