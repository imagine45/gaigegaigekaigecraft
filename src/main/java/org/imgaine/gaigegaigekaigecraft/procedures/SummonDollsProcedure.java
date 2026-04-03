package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SummonDollsProcedure {
   public SummonDollsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double size = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.ITEM_DOLL.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.ITEM_DOLL.get() && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.OFF_HAND, true);
            }
         }

         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.DOLL_1.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity13 = (LivingEntity)entityinstance;
                  if (_livingEntity13.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     double var10001;
                     AttributeInstance var37;
                     label89: {
                        var37 = _livingEntity13.getAttribute(Attributes.ATTACK_DAMAGE);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity9 = (LivingEntity)entityinstance;
                           if (_livingEntity9.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10001 = _livingEntity9.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label89;
                           }
                        }

                        var10001 = 0.0;
                     }

                     int var39;
                     label84: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entity;
                           if (_livEnt10.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              label79: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var39 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label79;
                                    }
                                 }

                                 var39 = 0;
                              }

                              ++var39;
                              break label84;
                           }
                        }

                        var39 = 0;
                     }

                     var37.setBaseValue(var10001 + 0.5 * (double)var39 * 3.0);
                  }
               }

               double var10002;
               CompoundTag var38;
               label70: {
                  var38 = entityinstance.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        var10002 = (double)_livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                        break label70;
                     }
                  }

                  var10002 = 0.0;
               }

               var38.putDouble("LevelResistance", var10002);
               entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
               entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.setYRot(entity.getYRot());
               entityinstance.setXRot(entity.getXRot());
               entityinstance.setYBodyRot(entityinstance.getYRot());
               entityinstance.setYHeadRot(entityinstance.getYRot());
               entityinstance.yRotO = entityinstance.getYRot();
               entityinstance.xRotO = entityinstance.getXRot();
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
               entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
               entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
               _serverLevel.addFreshEntity(entityinstance);
            }
         }

      }
   }
}
