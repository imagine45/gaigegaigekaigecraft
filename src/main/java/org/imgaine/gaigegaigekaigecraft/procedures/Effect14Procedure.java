package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.IceSpear2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UraumeEntity;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class Effect14Procedure {
   public Effect14Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entityiterator) {
      if (entityiterator != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double yaw = 0.0;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (entityiterator instanceof Player) {
            if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 24.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24.0) {
               return;
            }
         } else if (entityiterator instanceof UraumeEntity || entityiterator instanceof IceSpearEntity || entityiterator instanceof IceSpear2Entity) {
            return;
         }

         entityiterator.setTicksFrozen(120);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 5, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 1, false, false));
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.25F, 1.0F);
            } else {
               _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
            }
         }

      }
   }
}
