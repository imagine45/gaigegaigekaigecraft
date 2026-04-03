package org.imgaine.gaigegaigekaigecraft.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.item.renderer.PlayfulCloudItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.Animation.LoopType;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.network.GeckoLibNetwork;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PlayfulCloudItem extends Item implements GeoItem {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private static final RawAnimation IDLE_ANIM;
   private static final RawAnimation SPRINT_ANIM;
   private static final RawAnimation POPUP_ANIM;
   private static final RawAnimation POPUP_ANIM2;
   private static final Random RANDOM;
   private boolean isSwinging = false;
   private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
   public String animationprocedure = "empty";
   String prevAnim = "empty";

   public PlayfulCloudItem() {
      super((new Item.Properties()).durability(2831).rarity(Rarity.EPIC));
      GeckoLibNetwork.registerSyncedAnimatable(this);
   }

   public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
      return false;
   }

   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      super.initializeClient(consumer);
      consumer.accept(new IClientItemExtensions() {
         private final BlockEntityWithoutLevelRenderer renderer = new PlayfulCloudItemRenderer();

         public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return this.renderer;
         }
      });
   }

   private PlayState procedurePredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED || !this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty")) {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      } else if (this.animationprocedure.equals("empty")) {
         this.prevAnim = "empty";
         return PlayState.STOP;
      }

      this.prevAnim = this.animationprocedure;
      return PlayState.CONTINUE;
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
      controllers.add(new AnimationController[]{(new AnimationController(this, "popup_controller", 1, (state) -> PlayState.STOP)).triggerableAnim("swing", POPUP_ANIM).triggerableAnim("swing2", POPUP_ANIM2).triggerableAnim("idle", IDLE_ANIM).triggerableAnim("sprint", SPRINT_ANIM).setSoundKeyframeHandler((state) -> {
         Player player = ClientUtils.getClientPlayer();
      })});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
      if (entity.getMainHandItem() == stack) {
         Level var4 = entity.level();
         if (var4 instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)var4;
            String animName = RANDOM.nextBoolean() ? "swing" : "swing2";
            this.triggerAnim(entity, GeoItem.getOrAssignId(stack, serverLevel), "popup_controller", animName);
            this.isSwinging = true;
            int swingDuration = 10;
            this.scheduler.schedule(() -> this.isSwinging = false, (long)swingDuration * 50L, TimeUnit.MILLISECONDS);
         }
      }

      return super.onEntitySwing(stack, entity);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      String animName = "";
      if (!this.isSwinging && entity instanceof LivingEntity) {
         Level var8 = entity.level();
         if (var8 instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)var8;
            if (selected) {
               animName = entity.isSprinting() ? "sprint" : "idle";
            } else {
               animName = "idle";
            }

            this.triggerAnim(entity, GeoItem.getOrAssignId(itemstack, serverLevel), "popup_controller", animName);
         }
      }

   }

   public int getEnchantmentValue() {
      return 9;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 10.0, Operation.ADDITION));
         builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.getDefaultAttributeModifiers(equipmentSlot);
      }
   }

   public boolean isCorrectToolForDrops(BlockState state) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Special Grade Cursed Tool"));
      list.add(Component.literal("[Ability] Powerful Attack Power and Knockback Power"));
   }

   static {
      IDLE_ANIM = RawAnimation.begin().then("idle", LoopType.LOOP);
      SPRINT_ANIM = RawAnimation.begin().then("sprint", LoopType.LOOP);
      POPUP_ANIM = RawAnimation.begin().thenPlay("swing");
      POPUP_ANIM2 = RawAnimation.begin().thenPlay("swing2");
      RANDOM = new Random();
   }
}
