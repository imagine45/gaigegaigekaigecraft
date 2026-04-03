package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DivineDogBlackEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogWhiteEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TenShadowsTechniqueProcedure {
   public TenShadowsTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double NUM1 = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         if (sourceentity.isShiftKeyDown()) {
            if (entity.getPersistentData().getBoolean("Ambush") && !entity.getPersistentData().getBoolean("domain_entity") && entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.getPersistentData().getDouble("friend_num") == sourceentity.getPersistentData().getDouble("friend_num")) {
               NUM1 = ReturnTenShadowsNumProcedure.execute(entity);
               sourceentity.getPersistentData().putDouble("TenShadowsTechnique" + Math.round(NUM1), 1.0);
               if (entity instanceof DivineDogTotalityEntity) {
                  if (sourceentity.getPersistentData().getDouble("TenShadowsTechnique1") > -2.0) {
                     sourceentity.getPersistentData().putDouble("TenShadowsTechnique1", 1.0);
                  }

                  if (sourceentity.getPersistentData().getDouble("TenShadowsTechnique2") > -2.0) {
                     sourceentity.getPersistentData().putDouble("TenShadowsTechnique2", 1.0);
                  }
               }

               if (entity instanceof MergedBeastAgitoEntity && sourceentity.getPersistentData().getDouble("TenShadowsTechnique4") > -2.0) {
                  sourceentity.getPersistentData().putDouble("TenShadowsTechnique4", 1.0);
               }

               if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
                  label166: {
                     ItemStack var10000;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           break label166;
                        }
                     }

                     item_a = (new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get())).copy();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     CompoundTag _nbtTag = var10000.getTag();
                     if (_nbtTag != null) {
                        item_a.setTag(_nbtTag.copy());
                     }

                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() != ItemStack.EMPTY.getItem() && sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                           var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        ItemStack _setstack = var10000.copy();
                        ItemStack var10001;
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                           var10001 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        _setstack.setCount(var10001.getCount());
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        _player.getInventory().armor.set(3, item_a);
                        _player.getInventory().setChanged();
                     } else if (sourceentity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)sourceentity;
                        _living.setItemSlot(EquipmentSlot.HEAD, item_a);
                     }
                  }
               }

               if (entity instanceof RabbitEscapeEntity) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(64.0), (e) -> true)) {
                     if (entityiterator instanceof RabbitEscapeEntity && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num") && entityiterator.getPersistentData().getBoolean("Ambush") && !entityiterator.getPersistentData().getBoolean("domain_entity")) {
                        double var42 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                        double var44 = entity.getPersistentData().getDouble("BaseCursePower") * 0.5;
                        float var10002;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getHealth();
                        } else {
                           var10002 = -1.0F;
                        }

                        float var10003;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10003 = _livEnt.getMaxHealth();
                        } else {
                           var10003 = -1.0F;
                        }

                        double _setval = var42 + var44 * (double)(var10002 / Math.max(var10003, 1.0F));
                        sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(sourceentity);
                        });
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.SQUID_INK, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 10, 0.25, 0.25, 0.25, 0.0);
                        }

                        if (!entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }
                     }
                  }
               } else {
                  double var43 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                  double var45 = entity.getPersistentData().getDouble("BaseCursePower") * 0.5;
                  float var46;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var46 = _livEnt.getHealth();
                  } else {
                     var46 = -1.0F;
                  }

                  float var47;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var47 = _livEnt.getMaxHealth();
                  } else {
                     var47 = -1.0F;
                  }

                  double _setval = var43 + var45 * (double)(var46 / Math.max(var47, 1.0F));
                  sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(sourceentity);
                  });
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 80, 0.5, 0.5, 0.5, 0.0);
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         } else if ((entity instanceof DivineDogBlackEntity || entity instanceof DivineDogWhiteEntity) && entity.getPersistentData().getDouble("cnt_howl") >= 0.0) {
            entity.getPersistentData().putDouble("cnt_howl", -60.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

      }
   }
}
