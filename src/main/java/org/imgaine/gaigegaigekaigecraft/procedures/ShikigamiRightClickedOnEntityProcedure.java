package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.Doll1Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityBroomEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HumanCarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MoonDregsEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class ShikigamiRightClickedOnEntityProcedure {
   public ShikigamiRightClickedOnEntityProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (!sourceentity.m_20149_().equals(entity.getPersistentData().m_128461_("OWNER_UUID"))) {
            label155: {
               if (sourceentity instanceof Player) {
                  Player _plr = (Player)sourceentity;
                  if (_plr.m_150110_().f_35937_) {
                     break label155;
                  }
               }

               if (!(entity instanceof EntityBroomEntity) || (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
                  return;
               }
            }
         }

         if (entity instanceof Doll1Entity) {
            if (sourceentity.m_6144_()) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITEM_DOLL.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }
         } else if (entity instanceof EntityBroomEntity) {
            if (sourceentity.m_6144_()) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }
         } else if (!(entity instanceof MoonDregsEntity) && !(entity instanceof ShikigamiHeterocephalusGlaberEntity) && !(entity instanceof ShikigamiPterosaurEntity) && !(entity instanceof RozetsuShikigamiEntity) && !(entity instanceof RozetsuShikigamiVesselEntity) && !(entity instanceof RozetsuShikigamiVessel2Entity)) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt32 = (LivingEntity)sourceentity;
               if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return;
               }
            }

            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt33 = (LivingEntity)sourceentity;
               if (_livEnt33.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  return;
               }
            }

            if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 15.0 || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15.0) {
               if (entity instanceof HumanCarEntity) {
                  if (sourceentity.m_6144_()) {
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)sourceentity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                     if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.HUMAN_STOCK_CAR.get())).m_41777_();
                        _setstack.m_41764_(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }
                  } else {
                     sourceentity.m_20329_(entity);
                  }
               } else if (sourceentity.m_6144_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.HUMAN_STOCK.get())).m_41777_();
                     _setstack.m_41764_(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }
         } else if (sourceentity.m_6144_()) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)sourceentity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            double var10000 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
            double var10001 = entity.getPersistentData().m_128459_("BaseCursePower");
            float var10002;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10002 = _livEnt.m_21223_();
            } else {
               var10002 = -1.0F;
            }

            var10002 = Math.max(var10002, 1.0F);
            float var10003;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10003 = _livEnt.m_21233_();
            } else {
               var10003 = -1.0F;
            }

            double _setval = var10000 + var10001 * (double)(var10002 / Math.max(var10003, 1.0F));
            sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(sourceentity);
            });
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         } else if (entity instanceof MoonDregsEntity) {
            sourceentity.m_20329_(entity);
         }

      }
   }
}
