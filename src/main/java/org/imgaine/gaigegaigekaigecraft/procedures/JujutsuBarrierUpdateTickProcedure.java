package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class JujutsuBarrierUpdateTickProcedure {
   public JujutsuBarrierUpdateTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         BlockPos currentPos = BlockPos.containing(x, y, z);
         BlockState currentState = world.getBlockState(currentPos);
         if (currentState.getBlock() == JujutsucraftModBlocks.JUJUTSU_BARRIER.get() && Math.random() < 0.1) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x, y, z, 1, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.playSound((Player)null, currentPos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 1.5F);
            }
         }

         BlockEntity be = world.getBlockEntity(currentPos);
         String oldBlock = be != null ? be.getPersistentData().getString("old_block") : "";
         placeBlockSafe(world, currentPos, oldBlock);
         BlockState restoredState = world.getBlockState(currentPos);
         if (restoredState.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
            world.setBlock(currentPos, Blocks.AIR.defaultBlockState(), 3);
         } else if (restoredState.canOcclude()) {
            for(Entity ent : world.getEntitiesOfClass(Entity.class, new AABB(x, y, z, x + 1.0, y + 1.0, z + 1.0), (e) -> true)) {
               if (!(ent instanceof DomainExpansionEntityEntity) && !ent.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                  double bbWidth = (double)ent.getBbWidth();
                  double bbHeight = (double)ent.getBbHeight();
                  double yFix = 0.0;

                  for(int i = 0; i < 255; ++i) {
                     if (!InsideSolidCalculateProcedure.execute(world, ent.getX(), ent.getY() + yFix, ent.getZ(), bbHeight, bbWidth)) {
                        ent.teleportTo(ent.getX(), ent.getY() + yFix, ent.getZ());
                        if (ent instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)ent;
                           _serverPlayer.connection.teleport(ent.getX(), ent.getY() + yFix, ent.getZ(), ent.getYRot(), ent.getXRot());
                        }
                        break;
                     }

                     ++yFix;
                  }
               }
            }
         }

      }
   }

   private static void placeBlockSafe(LevelAccessor world, BlockPos pos, String blockName) {
      if (!world.isClientSide() && blockName != null && !blockName.isEmpty()) {
         if (blockName.contains("[")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var10000 = _level.getServer().getCommands();
               CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.NULL, new Vec3((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
               int var10002 = pos.getX();
               var10000.performPrefixedCommand(var10001, "setblock " + var10002 + " " + pos.getY() + " " + pos.getZ() + " " + blockName + " replace");
            }
         } else {
            ResourceLocation res = new ResourceLocation(blockName.contains(":") ? blockName : "minecraft:" + blockName);
            world.setBlock(pos, ((Block)ForgeRegistries.BLOCKS.getValue(res)).defaultBlockState(), 3);
         }
      }

   }
}
