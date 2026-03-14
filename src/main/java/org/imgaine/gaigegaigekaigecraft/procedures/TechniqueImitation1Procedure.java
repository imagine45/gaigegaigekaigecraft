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
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "give @s jujutsucraft:loudspeaker");
            }

            entity.getPersistentData().m_128347_("skill", 0.0);
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else {
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt4") == 1.0) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() != JujutsucraftModItems.LOUDSPEAKER.get()) {
                  if (entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           CompoundTag _nbtTag = var10000.m_41783_();
                           if (_nbtTag != null) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              var10000.m_41751_(_nbtTag.m_6426_());
                           }
                        }
                     }
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with jujutsucraft:loudspeaker");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128379_("Used", true);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt4") < 4.0 && GetDistanceProcedure.execute(entity) < 16.0) {
               LivingEntity var52;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var52 = _mobEnt.m_5448_();
               } else {
                  var52 = null;
               }

               if (var52 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var52 = _mobEnt.m_5448_();
                  } else {
                     var52 = null;
                  }

                  x_pos = ((Entity)var52).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var52 = _mobEnt.m_5448_();
                  } else {
                     var52 = null;
                  }

                  double var55 = ((Entity)var52).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var55 + (double)((Entity)var10001).m_20206_() * 0.5;
                  LivingEntity var56;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var56 = _mobEnt.m_5448_();
                  } else {
                     var56 = null;
                  }

                  z_pos = ((Entity)var56).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               GetPowerFixProcedure.execute(entity);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * -0.4, 0.4, entity.getPersistentData().m_128459_("z_power") * -0.4));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19596_);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt4") > 10.0 && entity.getPersistentData().m_128459_("cnt5") == 0.0) {
               entity.getPersistentData().m_128347_("cnt5", 1.0);

               for(int index0 = 0; index0 < 128; ++index0) {
                  entity.getPersistentData().m_128347_("skill", (double)(305L + Math.round(Math.random() * 4.0)));
                  if (entity.getPersistentData().m_128459_("skill") != 307.0 || !(Math.random() < 0.9)) {
                     break;
                  }
               }
            }
         }

      }
   }
}
