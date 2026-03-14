package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ChosoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EsoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KechizuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class ReturnInsideItemProcedure {
   public ReturnInsideItemProcedure() {
   }

   public static ItemStack execute(Entity entity) {
      if (entity == null) {
         return ItemStack.f_41583_;
      } else {
         ItemStack item_a = ItemStack.f_41583_;
         if (entity instanceof Player) {
            item_a = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41777_();
         } else {
            if (entity instanceof ItadoriYujiShinjukuEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get())).m_41777_();
               item_a.m_41764_(6);
            } else if (entity instanceof ItadoriYujiEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
               item_a.m_41764_(3);
            } else if (entity instanceof ItadoriYujiShibuyaEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
               item_a.m_41764_(16);
            }

            if (entity instanceof ChosoEntity || entity instanceof EsoEntity || entity instanceof KechizuEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get())).m_41777_();
               item_a.m_41764_(1);
            }

            if (!(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
               if (entity instanceof SukunaEntity) {
                  item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
                  item_a.m_41764_(16);
               }
            } else {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
               item_a.m_41764_(20);
            }
         }

         if (entity.getPersistentData().m_128471_("CursedSpirit")) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModBlocks.IN_BARRIER.get())).m_41777_();
         }

         return item_a;
      }
   }
}
