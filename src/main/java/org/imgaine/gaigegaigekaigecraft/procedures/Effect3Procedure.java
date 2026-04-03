package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.JogoAshEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Effect3Procedure {
   public Effect3Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            label62: {
               if (!entityiterator.isAlive()) {
                  Entity var11 = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  LivingEntity var10000;
                  if (var11 instanceof Mob) {
                     Mob _mobEnt = (Mob)var11;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 != entityiterator) {
                     break label62;
                  }
               }

               entity.getPersistentData().putDouble("cnt2", 1.0);
            }
         }

         entityiterator.setSecondsOnFire(2);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entityiterator;
            if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()) && entityiterator.isOnFire()) {
               ItemStack var24;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                  var24 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var24 = ItemStack.EMPTY;
               }

               if (var24.getItem() == ItemStack.EMPTY.getItem()) {
                  if (entityiterator instanceof Player) {
                     Player _player = (Player)entityiterator;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entityiterator instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entityiterator;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                  }
               }
            }
         }

         if (entityiterator instanceof JogoEntity && !entityiterator.isAlive()) {
            x_pos = entityiterator.getX();
            y_pos = entityiterator.getY();
            z_pos = entityiterator.getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.JOGO_ASH.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(entityiterator.getYRot());
                  entityToSpawn.setYBodyRot(entityiterator.getYRot());
                  entityToSpawn.setYHeadRot(entityiterator.getYRot());
                  entityToSpawn.setXRot(entityiterator.getXRot());
               }
            }

            if (!world.getEntitiesOfClass(JogoAshEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> true).isEmpty()) {
               Entity var23 = (Entity)world.getEntitiesOfClass(JogoAshEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((JogoAshEntity) null);
               if (var23 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var23;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 10, false, false));
                  }
               }
            }

            if (!entityiterator.level().isClientSide()) {
               entityiterator.discard();
            }
         }

      }
   }
}
