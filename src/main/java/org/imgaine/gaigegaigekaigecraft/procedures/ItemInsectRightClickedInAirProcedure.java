package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ItemInsectRightClickedInAirProcedure {
   public ItemInsectRightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double num1 = 0.0;
         boolean consume = false;
         consume = true;
         if (entity instanceof ServerPlayer) {
            ServerPlayer _plr0 = (ServerPlayer)entity;
            if (_plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:advancement_insect"))).isDone()) {
               consume = false;
            }
         }

         num1 = -200.0 - Math.random() * 20.0;
         if (consume && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(entity.getX(), num1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }

         consume = false;
         Vec3 _center = new Vec3(entity.getX(), num1, entity.getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
            if (entityiterator instanceof Bat && entityiterator.isAlive()) {
               consume = true;
               if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }

               if (!entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }
               break;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
         }

         if (consume) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:advancement_insect"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }

            itemstack.shrink(1);
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
