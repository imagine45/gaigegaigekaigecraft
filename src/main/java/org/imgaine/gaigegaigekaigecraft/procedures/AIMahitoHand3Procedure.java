package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
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
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         logic_a = false;
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               logic_a = true;
               if (entity_a.getPersistentData().m_128459_("skill") <= 0.0) {
                  logic_a = false;
               }

               if (!entity.m_6084_()) {
                  entity_a.getPersistentData().m_128347_("skill", 0.0);
               }
            }

            if (!entity_a.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

         entity.getPersistentData().m_128347_("Damage", 11.0);
         entity.getPersistentData().m_128347_("Range", 6.5 * entity_size);
         entity.getPersistentData().m_128347_("knockback", 1.0);
         entity.getPersistentData().m_128379_("attack", true);
         RangeAttackProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * 0.5, z, entity);
         entity.getPersistentData().m_128347_("BlockRange", 1.5 * entity_size);
         entity.getPersistentData().m_128347_("BlockDamage", 4.0);
         BlockDestroyAllDirectionProcedure.execute(world, x + (Math.random() - 0.5) * entity_size * 2.0, y + 1.0 * entity_size, z + (Math.random() - 0.5) * entity_size * 2.0, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(3.0 * entity_size), entity_size, 0.5, entity_size, 0.25);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * entity_size), 0.7F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * entity_size), 0.7F, false);
            }
         }

         if (!logic_a && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
