package org.imgaine.gaigegaigekaigecraft.init;

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Category;
import net.minecraft.world.level.GameRules.IntegerValue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftModGameRules {
   public static final GameRules.Key<GameRules.BooleanValue> JUJUTSUPVP;
   public static final GameRules.Key<GameRules.IntegerValue> JUJUTSUUPGRADEDIFFICULTY;
   public static final GameRules.Key<GameRules.BooleanValue> JUJUTSU_GAIN_FAME;

   public JujutsucraftModGameRules() {
   }

   static {
      JUJUTSUPVP = GameRules.register("jujutsuPVP", Category.PLAYER, BooleanValue.create(true));
      JUJUTSUUPGRADEDIFFICULTY = GameRules.register("jujutsuUpgradeDifficulty", Category.PLAYER, IntegerValue.create(2));
      JUJUTSU_GAIN_FAME = GameRules.register("jujutsuGainFame", Category.PLAYER, BooleanValue.create(true));
   }
}
