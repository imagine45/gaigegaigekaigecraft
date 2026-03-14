package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogBlackEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogWhiteEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
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
         ItemStack item_a = ItemStack.f_41583_;
         if (sourceentity.m_6144_()) {
            if (entity.getPersistentData().m_128471_("Ambush") && !entity.getPersistentData().m_128471_("domain_entity") && entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.getPersistentData().m_128459_("friend_num") == sourceentity.getPersistentData().m_128459_("friend_num")) {
               NUM1 = ReturnTenShadowsNumProcedure.execute(entity);
               sourceentity.getPersistentData().m_128347_("TenShadowsTechnique" + Math.round(NUM1), 1.0);
               if (entity instanceof DivineDogTotalityEntity) {
                  if (sourceentity.getPersistentData().m_128459_("TenShadowsTechnique1") > -2.0) {
                     sourceentity.getPersistentData().m_128347_("TenShadowsTechnique1", 1.0);
                  }

                  if (sourceentity.getPersistentData().m_128459_("TenShadowsTechnique2") > -2.0) {
                     sourceentity.getPersistentData().m_128347_("TenShadowsTechnique2", 1.0);
                  }
               }

               if (entity instanceof MergedBeastAgitoEntity && sourceentity.getPersistentData().m_128459_("TenShadowsTechnique4") > -2.0) {
                  sourceentity.getPersistentData().m_128347_("TenShadowsTechnique4", 1.0);
               }

               if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
                  label166: {
                     ItemStack var10000;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           break label166;
                        }
                     }

                     item_a = (new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get())).m_41777_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     CompoundTag _nbtTag = var10000.m_41783_();
                     if (_nbtTag != null) {
                        item_a.m_41751_(_nbtTag.m_6426_());
                     }

                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_() && sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        ItemStack _setstack = var10000.m_41777_();
                        ItemStack var10001;
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                           var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        _setstack.m_41764_(var10001.m_41613_());
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        _player.m_150109_().f_35975_.set(3, item_a);
                        _player.m_150109_().m_6596_();
                     } else if (sourceentity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)sourceentity;
                        _living.m_8061_(EquipmentSlot.HEAD, item_a);
                     }
                  }
               }

               if (entity instanceof RabbitEscapeEntity) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(64.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator instanceof RabbitEscapeEntity && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") && entityiterator.getPersistentData().m_128471_("Ambush") && !entityiterator.getPersistentData().m_128471_("domain_entity")) {
                        double var42 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                        double var44 = entity.getPersistentData().m_128459_("BaseCursePower") * 0.5;
                        float var10002;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21223_();
                        } else {
                           var10002 = -1.0F;
                        }

                        float var10003;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10003 = _livEnt.m_21233_();
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
                           _level.m_8767_(ParticleTypes.f_123765_, entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), 10, 0.25, 0.25, 0.25, 0.0);
                        }

                        if (!entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }
                     }
                  }
               } else {
                  double var43 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                  double var45 = entity.getPersistentData().m_128459_("BaseCursePower") * 0.5;
                  float var46;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var46 = _livEnt.m_21223_();
                  } else {
                     var46 = -1.0F;
                  }

                  float var47;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var47 = _livEnt.m_21233_();
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
                     _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 80, 0.5, 0.5, 0.5, 0.0);
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         } else if ((entity instanceof DivineDogBlackEntity || entity instanceof DivineDogWhiteEntity) && entity.getPersistentData().m_128459_("cnt_howl") >= 0.0) {
            entity.getPersistentData().m_128347_("cnt_howl", -60.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

      }
   }
}
