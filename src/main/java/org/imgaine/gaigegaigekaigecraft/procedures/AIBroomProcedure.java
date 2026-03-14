package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.NishimiyaMomoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class AIBroomProcedure {
   public AIBroomProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double y_power = 0.0;
         double z_power = 0.0;
         double NUM2 = 0.0;
         double x_power = 0.0;
         double speed = 0.0;
         double NUM1 = 0.0;
         owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
         if (owner_uuid instanceof Player) {
            if (!owner_uuid.m_6084_()) {
               if (owner_uuid instanceof Player) {
                  Player _player = (Player)owner_uuid;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            } else if (owner_uuid.m_20202_() != entity) {
               ItemStack var10000;
               if (owner_uuid instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)owner_uuid;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (owner_uuid instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_uuid;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (owner_uuid instanceof Player) {
                  Player _player = (Player)owner_uuid;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else if (owner_uuid instanceof LivingEntity) {
            entity.getPersistentData().m_128379_("flag_pet", true);
         } else if (entity.getPersistentData().m_128471_("flag_pet") && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         if (owner_uuid instanceof LivingEntity && (owner_uuid instanceof NishimiyaMomoEntity || ((JujutsucraftModVariables.PlayerVariables)owner_uuid.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 36.0 || ((JujutsucraftModVariables.PlayerVariables)owner_uuid.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 36.0)) {
            AIRideableControlProcedure.execute(entity);
         }

      }
   }
}
