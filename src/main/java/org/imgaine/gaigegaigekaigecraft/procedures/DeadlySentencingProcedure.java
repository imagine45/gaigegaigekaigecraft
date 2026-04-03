package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityGuillotineEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JudgemanEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DeadlySentencingProcedure {
   public DeadlySentencingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_mainHand = ItemStack.EMPTY;
         Entity entity_a = null;
         double x_center = 0.0;
         double z_center = 0.0;
         double num1 = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double tick = 0.0;
         double num3 = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("select", 27.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity.getPersistentData().getDouble("cnt1") % 10.0 != 1.0) {
               if (entity.getPersistentData().getDouble("cnt1") % 10.0 == 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entity;
                     if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-49.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entity;
                     if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            } else {
               GetGavelProcedure.execute(world, x, y, z, entity);

               for(int index0 = 0; index0 < 5; ++index0) {
                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  item_mainHand = var10000.copy();
                  if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
                     break;
                  }

                  GavelRightClicked2Procedure.execute(world, x, y, z, entity);
               }

               ItemStack var77;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var77 = _livEnt.getMainHandItem();
               } else {
                  var77 = ItemStack.EMPTY;
               }

               if (var77.getItem() == JujutsucraftModItems.GAVEL.get()) {
                  if (entity instanceof Player && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity11 = (LivingEntity)entity;
                     if (_livingEntity11.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity11.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity12 = (LivingEntity)entity;
                     if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(4.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 34.0) {
               entity.getPersistentData().putDouble("x_power", -1.0);
               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               yaw = 0.0;
               x_center = entity.getPersistentData().getDouble("x_pos_doma");
               y_center = entity.getPersistentData().getDouble("y_pos_doma");
               z_center = entity.getPersistentData().getDouble("z_pos_doma");

               for(int index1 = 0; index1 < 20; ++index1) {
                  x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - 7.5);
                  y_pos = y_center - 1.0;
                  z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - 7.5);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_GUILLOTINE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.teleportTo(x_pos, y_pos, z_pos);
                        if (entityinstance instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                           _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
                        }

                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                        }

                        entityinstance.setYRot((float)(yaw + 90.0));
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
                        if (entityinstance instanceof EntityGuillotineEntity) {
                           RandomSource var10001 = RandomSource.create();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.nextInt(var10001, 1, 6)));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity38 = (LivingEntity)entity;
                           if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(dis / 17.0);
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  yaw += 18.0;
                  ++num1;
               }
            }
         }

         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("takada_UUID"));
         if (!(entity_a instanceof JudgemanEntity)) {
            num1 = Math.toRadians((double)(entity.getYRot() + 90.0F + 180.0F));
            x_pos = entity.getX() + Math.cos(num1) * (double)(5.0F + entity.getBbWidth());
            y_pos = entity.getY();
            z_pos = entity.getZ() + Math.sin(num1) * (double)(5.0F + entity.getBbWidth());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.JUDGEMAN.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.setYRot(entity.getYRot());
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

                  entity.getPersistentData().putString("takada_UUID", entityinstance.getStringUUID());
                  entityinstance.getPersistentData().putBoolean("domain_entity", true);
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  entity_a = entityinstance;
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         if (entity_a instanceof JudgemanEntity) {
            num1 = (double)(entity_a.getYRot() % 360.0F);
            entity_a.setYRot(entity.getYRot() % 360.0F);
            entity_a.setXRot(entity.getXRot());
            entity_a.setYBodyRot(entity_a.getYRot());
            entity_a.setYHeadRot(entity_a.getYRot());
            entity_a.yRotO = entity_a.getYRot();
            entity_a.xRotO = entity_a.getXRot();
            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            num2 = num1 - (double)entity.getYRot();
            if (Math.abs(num2) > 180.0) {
               entity_a.setYRot((float)(num1 + Math.min(8.0, Math.abs(num2)) * (double)(num2 < 0.0 ? -1 : 1)));
               entity_a.setXRot(entity.getXRot());
               entity_a.setYBodyRot(entity_a.getYRot());
               entity_a.setYHeadRot(entity_a.getYRot());
               entity_a.yRotO = entity_a.getYRot();
               entity_a.xRotO = entity_a.getXRot();
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            } else {
               entity_a.setYRot((float)(num1 + Math.min(8.0, Math.abs(num2)) * (double)(num2 > 0.0 ? -1 : 1)));
               entity_a.setXRot(entity.getXRot());
               entity_a.setYBodyRot(entity_a.getYRot());
               entity_a.setYHeadRot(entity_a.getYRot());
               entity_a.yRotO = entity_a.getYRot();
               entity_a.xRotO = entity_a.getXRot();
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            num1 = Math.toRadians((double)(entity_a.getYRot() + 90.0F + 180.0F));
            x_pos = entity.getX() + Math.cos(num1) * (double)(5.0F + entity.getBbWidth());
            y_pos = entity.getY();
            z_pos = entity.getZ() + Math.sin(num1) * (double)(5.0F + entity.getBbWidth());
            entity_a.teleportTo(entity_a.getX() + Math.min(0.5, Math.abs(x_pos - entity_a.getX())) * (double)(x_pos > entity_a.getX() ? 1 : -1), entity_a.getY() + Math.min(0.5, Math.abs(y_pos - entity_a.getY())) * (double)(y_pos > entity_a.getY() ? 1 : -1), entity_a.getZ() + Math.min(0.5, Math.abs(z_pos - entity_a.getZ())) * (double)(z_pos > entity_a.getZ() ? 1 : -1));
            if (entity_a instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
               _serverPlayer.connection.teleport(entity_a.getX() + Math.min(0.5, Math.abs(x_pos - entity_a.getX())) * (double)(x_pos > entity_a.getX() ? 1 : -1), entity_a.getY() + Math.min(0.5, Math.abs(y_pos - entity_a.getY())) * (double)(y_pos > entity_a.getY() ? 1 : -1), entity_a.getZ() + Math.min(0.5, Math.abs(z_pos - entity_a.getZ())) * (double)(z_pos > entity_a.getZ() ? 1 : -1), entity_a.getYRot(), entity_a.getXRot());
            }

            entity_a.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (!entity.isAlive() && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
               entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
            }
         }

      }
   }
}
