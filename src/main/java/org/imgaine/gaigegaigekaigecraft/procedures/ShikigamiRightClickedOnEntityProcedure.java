package org.imgaine.gaigegaigekaigecraft.procedures;

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
         if (!sourceentity.getStringUUID().equals(entity.getPersistentData().getString("OWNER_UUID"))) {
            label155: {
               if (sourceentity instanceof Player) {
                  Player _plr = (Player)sourceentity;
                  if (_plr.getAbilities().instabuild) {
                     break label155;
                  }
               }

               if (!(entity instanceof EntityBroomEntity) || GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity) {
                  return;
               }
            }
         }

         if (entity instanceof Doll1Entity) {
            if (sourceentity.isShiftKeyDown()) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITEM_DOLL.get())).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }
         } else if (entity instanceof EntityBroomEntity) {
            if (sourceentity.isShiftKeyDown()) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }
         } else if (!(entity instanceof MoonDregsEntity) && !(entity instanceof ShikigamiHeterocephalusGlaberEntity) && !(entity instanceof ShikigamiPterosaurEntity) && !(entity instanceof RozetsuShikigamiEntity) && !(entity instanceof RozetsuShikigamiVesselEntity) && !(entity instanceof RozetsuShikigamiVessel2Entity)) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt32 = (LivingEntity)sourceentity;
               if (_livEnt32.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return;
               }
            }

            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt33 = (LivingEntity)sourceentity;
               if (_livEnt33.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  return;
               }
            }

            if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 15.0 || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15.0) {
               if (entity instanceof HumanCarEntity) {
                  if (sourceentity.isShiftKeyDown()) {
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)sourceentity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.HUMAN_STOCK_CAR.get())).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }
                  } else {
                     sourceentity.startRiding(entity);
                  }
               } else if (sourceentity.isShiftKeyDown()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.HUMAN_STOCK.get())).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }
         } else if (sourceentity.isShiftKeyDown()) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)sourceentity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            double var10000 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
            double var10001 = entity.getPersistentData().getDouble("BaseCursePower");
            float var10002;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10002 = _livEnt.getHealth();
            } else {
               var10002 = -1.0F;
            }

            var10002 = Math.max(var10002, 1.0F);
            float var10003;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10003 = _livEnt.getMaxHealth();
            } else {
               var10003 = -1.0F;
            }

            double _setval = var10000 + var10001 * (double)(var10002 / Math.max(var10003, 1.0F));
            sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(sourceentity);
            });
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (entity instanceof MoonDregsEntity) {
            sourceentity.startRiding(entity);
         }

      }
   }
}
