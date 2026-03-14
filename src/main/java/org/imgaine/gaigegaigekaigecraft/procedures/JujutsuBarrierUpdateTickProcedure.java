package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class JujutsuBarrierUpdateTickProcedure {
   public JujutsuBarrierUpdateTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      String old_block = "";
      boolean logic_success = false;
      double cnt = 0.0;
      double x_pos = 0.0;
      double y_pos = 0.0;
      double z_pos = 0.0;
      double y_fix = 0.0;
      double y_fix_height = 0.0;
      double y_floor = 0.0;
      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() == JujutsucraftModBlocks.JUJUTSU_BARRIER.get() && Math.random() < 0.1) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x, y, z, 1, 0.25, 0.25, 0.25, 0.25);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 1.5F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
            }
         }
      }

      old_block = ((<undefinedtype>)(new Object() {
         public String getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "old_block");
      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + old_block);
      }

      if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air");
         }
      } else if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60815_()) {
         Vec3 _center = new Vec3(x + 0.5, y + 0.5, z + 0.5);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (!(entityiterator instanceof DomainExpansionEntityEntity) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
               y_fix = 0.0;

               for(int index0 = 0; index0 < 255; ++index0) {
                  ++y_fix;
                  if (!world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() + y_fix, entityiterator.m_20189_())).m_60815_()) {
                     logic_success = true;
                     y_fix_height = 0.0;

                     for(int index1 = 0; index1 < (int)Math.max(Math.ceil((double)entityiterator.m_20206_()), 1.0); ++index1) {
                        ++y_fix_height;
                        if (world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() + y_fix + y_fix_height, entityiterator.m_20189_())).m_60815_()) {
                           logic_success = false;
                           break;
                        }
                     }

                     if (logic_success) {
                        entityiterator.m_6021_(entityiterator.m_20185_(), entityiterator.m_20186_() + y_fix, entityiterator.m_20189_());
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(entityiterator.m_20185_(), entityiterator.m_20186_() + y_fix, entityiterator.m_20189_(), entityiterator.m_146908_(), entityiterator.m_146909_());
                        }
                        break;
                     }
                  }
               }
            }
         }
      }

   }
}
