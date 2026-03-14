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
      JUJUTSUPVP = GameRules.m_46189_("jujutsuPVP", Category.PLAYER, BooleanValue.m_46250_(true));
      JUJUTSUUPGRADEDIFFICULTY = GameRules.m_46189_("jujutsuUpgradeDifficulty", Category.PLAYER, IntegerValue.m_46312_(2));
      JUJUTSU_GAIN_FAME = GameRules.m_46189_("jujutsuGainFame", Category.PLAYER, BooleanValue.m_46250_(true));
   }
}
