package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CopiedCursedTechniqueRightclickedProcedure {
   public CopiedCursedTechniqueRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean used = false;
         double NUM1 = 0.0;
         double skill = 0.0;
         entity.getPersistentData().putBoolean("PRESS_Z", false);
         if (itemstack.getOrCreateTag().getDouble("skill") > 0.0 && !itemstack.getOrCreateTag().getBoolean("Used")) {
            label111: {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5.0) {
                  label110: {
                     if (!LocateRikaProcedure.execute(world, entity)) {
                        if (!(entity instanceof LivingEntity)) {
                           break label110;
                        }

                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (!_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().getBoolean("Failed")) {
                           break label110;
                        }
                     }

                     if (entity.getPersistentData().getDouble("skill") == 0.0) {
                        itemstack.getOrCreateTag().putBoolean("used_item", true);
                        StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                        if (entity.getPersistentData().getDouble("skill") > 0.0) {
                           skill = entity.getPersistentData().getDouble("skill");
                           used = true;
                        }

                        itemstack.getOrCreateTag().putBoolean("used_item", false);
                     }
                     break label111;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                  }
               }
            }
         }

         NUM1 = -230.0 - Math.random();
         if (used && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(entity.getX(), NUM1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }

         used = false;
         Vec3 _center = new Vec3(entity.getX(), NUM1, entity.getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
            if (entityiterator instanceof Bat && entityiterator.isAlive()) {
               used = true;
               if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }

               if (!entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }
               break;
            }
         }

         if (used) {
            entity.getPersistentData().putDouble("skill", skill);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }

            itemstack.getOrCreateTag().putBoolean("Used", true);
            entity.getPersistentData().putBoolean("PRESS_Z", true);
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(itemstack.getDisplayName().getString()), true);
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
            }
         }

      }
   }
}
