package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueWingKingProcedure {
   public TechniqueWingKingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.WING_KING_CHESTPLATE.get()) {
               entity.getPersistentData().m_128347_("cnt5", 1.0);
            } else {
               entity.getPersistentData().m_128347_("cnt5", 0.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y + (double)entity.m_20206_() * 0.5, z, 40, 0.2, 0.2, 0.2, 1.0);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt5") == 0.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y + (double)entity.m_20206_() * 0.5, z, 5, 0.2, 0.2, 0.2, 0.25);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
               ItemStack var18;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var18 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
               } else {
                  var18 = ItemStack.f_41583_;
               }

               if (var18.m_41720_() != JujutsucraftModItems.WING_KING_CHESTPLATE.get() && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var18 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var18 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var18.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.WING_KING_CHESTPLATE.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.WING_KING_CHESTPLATE.get()));
               }

               entity.getPersistentData().m_128347_("cnt1", 0.0);
               entity.getPersistentData().m_128347_("cnt5", 1.0);
            }
         } else {
            WingKingAttackProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
