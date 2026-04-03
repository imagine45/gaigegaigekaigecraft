package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class TechniqueImitation1Procedure {
   public TechniqueImitation1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double HP = 0.0;
         boolean logic_a = false;
         boolean pitch = false;
         boolean StrongEnemy = false;
         if (entity instanceof Player) {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "give @s gaigegaigekaigecraft:loudspeaker");
            }

            entity.getPersistentData().putDouble("skill", 0.0);
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else {
            entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
            if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() != JujutsucraftModItems.LOUDSPEAKER.get()) {
                  if (entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with gaigegaigekaigecraft:sword_okkotsu_yuta");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           CompoundTag _nbtTag = var10000.getTag();
                           if (_nbtTag != null) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.setTag(_nbtTag.copy());
                           }
                        }
                     }
                  }

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with gaigegaigekaigecraft:loudspeaker");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putBoolean("Used", true);
               }
            }

            if (entity.getPersistentData().getDouble("cnt4") < 4.0 && GetDistanceProcedure.execute(entity) < 16.0) {
               LivingEntity var52;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var52 = _mobEnt.getTarget();
               } else {
                  var52 = null;
               }

               if (var52 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var52 = _mobEnt.getTarget();
                  } else {
                     var52 = null;
                  }

                  x_pos = ((Entity)var52).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var52 = _mobEnt.getTarget();
                  } else {
                     var52 = null;
                  }

                  double var55 = ((Entity)var52).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var55 + (double)((Entity)var10001).getBbHeight() * 0.5;
                  LivingEntity var56;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var56 = _mobEnt.getTarget();
                  } else {
                     var56 = null;
                  }

                  z_pos = ((Entity)var56).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               GetPowerFixProcedure.execute(entity);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * -0.4, 0.4, entity.getPersistentData().getDouble("z_power") * -0.4));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
               }
            }

            if (entity.getPersistentData().getDouble("cnt4") > 10.0 && entity.getPersistentData().getDouble("cnt5") == 0.0) {
               entity.getPersistentData().putDouble("cnt5", 1.0);

               for(int index0 = 0; index0 < 128; ++index0) {
                  entity.getPersistentData().putDouble("skill", (double)(305L + Math.round(Math.random() * 4.0)));
                  if (entity.getPersistentData().getDouble("skill") != 307.0 || !(Math.random() < 0.9)) {
                     break;
                  }
               }
            }
         }

      }
   }
}
