package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.FrameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillExplodeAirProcedure {
   public SkillExplodeAirProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         boolean move_flag = false;
         String STR1 = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double size = 0.0;
         double dis = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_num = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         Entity entity_ = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            entity.getPersistentData().m_128347_("cnt2", (double)(entity.m_20205_() + 1.0F));
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.5);
         }

         dis = entity.getPersistentData().m_128459_("cnt2");
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 4, 4, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * dis;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.FRAME.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.getPersistentData().m_128347_("NameRanged_ranged", 0.0);
                  entityinstance.getPersistentData().m_128347_("friend_num", 0.0);
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", "");
                  entityinstance.getPersistentData().m_128347_("NameRanged_ranged_keep", entity.getPersistentData().m_128459_("NameRanged"));
                  entityinstance.getPersistentData().m_128347_("friend_num_keep", entity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID_keep", entity.m_20149_());
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity40 = (LivingEntity)entityinstance;
                     if (_livingEntity40.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity40.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(ReturnEntitySizeProcedure.execute(entity));
                     }
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= 10.0) {
            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label134: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label135: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                    break label135;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label134;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }
               }

               if (!entity.getPersistentData().m_128471_("PRESS_Z") || entity.getPersistentData().m_128459_("cnt1") >= 15.0) {
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") != 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().m_128347_("skill", 1900.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 0, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", 2.0);
               if (!(entity instanceof Player) && !world.m_6443_(FrameEntity.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.75, entity.m_20189_()), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity)), (e) -> true).isEmpty()) {
                  entity_ = (Entity)world.m_6443_(FrameEntity.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.75, entity.m_20189_()), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity)), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                     }
                  })).compareDistOf(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.75, entity.m_20189_())).findFirst().orElse((Object)null);
                  RotateEntityProcedure.execute(entity_.m_20185_(), entity_.m_20186_() + (double)entity_.m_20206_() * 0.5, entity_.m_20189_(), entity);
               }
            }
         }

      }
   }
}
