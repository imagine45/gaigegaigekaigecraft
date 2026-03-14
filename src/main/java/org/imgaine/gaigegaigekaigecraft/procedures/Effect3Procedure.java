package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
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
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            label62: {
               if (!entityiterator.m_6084_()) {
                  Entity var11 = (new BiFunction<LevelAccessor, String, Entity>() {
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
                  LivingEntity var10000;
                  if (var11 instanceof Mob) {
                     Mob _mobEnt = (Mob)var11;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 != entityiterator) {
                     break label62;
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", 1.0);
            }
         }

         entityiterator.m_20254_(2);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entityiterator;
            if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()) && entityiterator.m_6060_()) {
               ItemStack var24;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                  var24 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var24 = ItemStack.f_41583_;
               }

               if (var24.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (entityiterator instanceof Player) {
                     Player _player = (Player)entityiterator;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entityiterator instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entityiterator;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                  }
               }
            }
         }

         if (entityiterator instanceof JogoEntity && !entityiterator.m_6084_()) {
            x_pos = entityiterator.m_20185_();
            y_pos = entityiterator.m_20186_();
            z_pos = entityiterator.m_20189_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.JOGO_ASH.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(entityiterator.m_146908_());
                  entityToSpawn.m_5618_(entityiterator.m_146908_());
                  entityToSpawn.m_5616_(entityiterator.m_146908_());
                  entityToSpawn.m_146926_(entityiterator.m_146909_());
               }
            }

            if (!world.m_6443_(JogoAshEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> true).isEmpty()) {
               Entity var23 = (Entity)world.m_6443_(JogoAshEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                  }
               })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null);
               if (var23 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var23;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 40, 10, false, false));
                  }
               }
            }

            if (!entityiterator.m_9236_().m_5776_()) {
               entityiterator.m_146870_();
            }
         }

      }
   }
}
