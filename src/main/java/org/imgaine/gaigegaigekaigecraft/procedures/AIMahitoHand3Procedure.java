package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIMahitoHand3Procedure {
   public AIMahitoHand3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean dis = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double loop_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         double entity_size = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         logic_a = false;
         if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
               logic_a = true;
               if (entity_a.getPersistentData().getDouble("skill") <= 0.0) {
                  logic_a = false;
               }

               if (!entity.isAlive()) {
                  entity_a.getPersistentData().putDouble("skill", 0.0);
               }
            }

            if (!entity_a.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         }

         entity.getPersistentData().putDouble("Damage", 11.0);
         entity.getPersistentData().putDouble("Range", 6.5 * entity_size);
         entity.getPersistentData().putDouble("knockback", 1.0);
         entity.getPersistentData().putBoolean("attack", true);
         RangeAttackProcedure.execute(world, x, entity.getY() + (double)entity.getBbHeight() * 0.5, z, entity);
         entity.getPersistentData().putDouble("BlockRange", 1.5 * entity_size);
         entity.getPersistentData().putDouble("BlockDamage", 4.0);
         BlockDestroyAllDirectionProcedure.execute(world, x + (Math.random() - 0.5) * entity_size * 2.0, y + 1.0 * entity_size, z + (Math.random() - 0.5) * entity_size * 2.0, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.CLOUD, x, y, z, (int)(3.0 * entity_size), entity_size, 0.5, entity_size, 0.25);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * entity_size), 0.7F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * entity_size), 0.7F, false);
            }
         }

         if (!logic_a && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
