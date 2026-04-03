package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.entity.TakabaFumihikoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ComedianEffectExpiresProcedure {
   public ComedianEffectExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_cool = 0.0;
         Gaigegaigekaigecraft.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _livEnt0) {
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                  return;
               }
            }

            if (entity instanceof Player) {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 17.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 17.0) {
                  return;
               }
            } else if (!(entity instanceof TakabaFumihikoEntity)) {
               return;
            }

            entity.getPersistentData().putDouble("COOLDOWN_TICKS_OLD", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1800, 0, false, false));
               }
            }

            entity.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS_OLD"));
         });
      }
   }
}
