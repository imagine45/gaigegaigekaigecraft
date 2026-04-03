package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SummonCrowProcedure {
   public SummonCrowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double loop_num = 0.0;
         double HP = 0.0;
         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         loop_num = (double)(3L + Math.round(Math.random() * 3.0));

         for(int index0 = 0; index0 < (int)loop_num; ++index0) {
            for(int index1 = 0; index1 < 64; ++index1) {
               x_pos = x + (Math.random() - 0.5) * 20.0;
               y_pos = y + 8.0 + Math.random() * 12.0;
               z_pos = z + (Math.random() - 0.5) * 20.0;
               if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.CROW.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (entityinstance instanceof TamableAnimal) {
                           TamableAnimal _toTame = (TamableAnimal)entityinstance;
                           if (entity instanceof Player) {
                              Player _owner = (Player)entity;
                              _toTame.tame(_owner);
                           }
                        }

                        entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
                  break;
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.crow1").getString()), false);
            }
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
         }

      }
   }
}
