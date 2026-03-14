package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeiMeiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TodoAoiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SetTagJujutsuSorcererProcedure {
   public SetTagJujutsuSorcererProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         SetTagProcedure.execute(world, entity);
         entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
         if (entity instanceof TodoAoiEntity) {
            entity.getPersistentData().m_128347_("IQ", 530000.0);
         }

         if (entity instanceof MeiMeiEntity) {
            SummonCrowProcedure.execute(world, x, y, z, entity);
         }

         if (entity instanceof GojoSatoruEntity) {
            if (world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).isEmpty() && world.m_6443_(SukunaPerfectEntity.class, AABB.m_165882_(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).isEmpty()) {
               if (!world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> true).isEmpty()) {
                  entity.getPersistentData().m_128379_("GojoNoUseInfinity", true);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_HELMET.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (Math.random() < 0.33) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                  }
               } else if (Math.random() < 0.5) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get()));
                  }
               } else if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
               }

               if (world.m_6443_(SukunaPerfectEntity.class, AABB.m_165882_(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).isEmpty()) {
                  if (world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).isEmpty()) {
                     return;
                  }

                  Entity _datEntSetL = (Entity)world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), 48.0, 48.0, 48.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                     }
                  })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
                  if (!(_datEntSetL instanceof SukunaFushiguroEntity)) {
                     return;
                  }

                  SukunaFushiguroEntity _datEntL15 = (SukunaFushiguroEntity)_datEntSetL;
                  if (!(Boolean)_datEntL15.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                     return;
                  }
               }

               if (entity instanceof GojoSatoruEntity) {
                  GojoSatoruEntity _datEntSetL = (GojoSatoruEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(GojoSatoruEntity.DATA_ghost, true);
               }

               if (entity instanceof GojoSatoruEntity) {
                  GojoSatoruEntity animatable = (GojoSatoruEntity)entity;
                  animatable.setTexture("gojo_satoru_ghost");
               }

               entity.getPersistentData().m_128347_("cnt_learn_domain", 1.0);
            }
         }

      }
   }
}
