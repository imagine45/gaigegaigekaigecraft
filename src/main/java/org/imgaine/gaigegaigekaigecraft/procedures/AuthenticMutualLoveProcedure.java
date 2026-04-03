package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AuthenticMutualLoveProcedure {
   public AuthenticMutualLoveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_center = 0.0;
         double z_center = 0.0;
         double num1 = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("select", 5.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
            if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
               entity.getPersistentData().putDouble("NameRanged", Math.random());
            }

            dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            yaw = 0.0;
            x_center = entity.getPersistentData().getDouble("x_pos_doma");
            y_center = entity.getPersistentData().getDouble("y_pos_doma");
            z_center = entity.getPersistentData().getDouble("z_pos_doma");
            y_pos = y_center + 2.0;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - 4.5);
               z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - 4.5);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_AWAJI_KNOT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.setYRot((float)(yaw + (double)(num1 % 2.0 == 1.0 ? 90 : -90)));
                     entityinstance.setXRot(0.0F);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     entityinstance.teleportTo(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               yaw += 45.0;
               ++num1;
            }

            for(int index1 = 0; index1 < 12; ++index1) {
               num1 = Math.toRadians(Math.random() * 720.0);

               for(int index2 = 0; index2 < 32; ++index2) {
                  num2 = Math.random();
                  if (num2 > 0.45 && num2 < 0.9) {
                     num2 *= dis - 3.0;
                     break;
                  }
               }

               x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
               y_pos = entity.getPersistentData().getDouble("y_pos_doma") - (Math.random() + 1.0);
               z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.GRAVESTONE_4.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.setYRot((float)(Math.random() * 360.0));
                     entityinstance.setXRot((float)((Math.random() - 0.5) * 70.0));
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }

            for(int index3 = 0; index3 < 20; ++index3) {
               num1 = Math.toRadians(Math.random() * 720.0);

               for(int index4 = 0; index4 < 32; ++index4) {
                  num2 = Math.random();
                  if (num2 < 0.9) {
                     num2 *= dis - 3.0;
                     break;
                  }
               }

               pitch = (Math.random() - 0.5) * 30.0;
               x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
               y_pos = entity.getPersistentData().getDouble("y_pos_doma") - (0.0 + Math.sin(Math.toRadians(Math.abs(pitch * 3.0))));
               z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ITEM.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.setYRot((float)(Math.random() * 360.0));
                     entityinstance.setXRot((float)pitch);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     if (entityinstance instanceof EntityItemEntity) {
                        EntityItemEntity _datEntSetL = (EntityItemEntity)entityinstance;
                        _datEntSetL.getEntityData().set(EntityItemEntity.DATA_domain_decoration, true);
                     }

                     if (entityinstance instanceof Player) {
                        Player _player = (Player)entityinstance;
                        _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()));
                        _player.getInventory().setChanged();
                     } else if (entityinstance instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entityinstance;
                        _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()));
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
