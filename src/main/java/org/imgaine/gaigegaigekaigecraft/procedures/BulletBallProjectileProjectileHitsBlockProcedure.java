package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityDoorsEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletBallProjectileProjectileHitsBlockProcedure {
   public BulletBallProjectileProjectileHitsBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10001;
         label168: {
            double HP = 0.0;
            double rnd = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double old_rnd = 0.0;
            double NUM1 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label168;
               }
            }

            var10001 = 0;
         }

         double var26 = (double)(50 + var10001 * 5);
         double var29 = x;
         double var30 = y + 2.0;
         double var31 = z;
         Vec3 _center = new Vec3(x, var30, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               var29 = entityiterator.m_20185_();
               var30 = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.75;
               var31 = entityiterator.m_20189_();
               break;
            }
         }

         double var27;
         label151: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt8 = (LivingEntity)entity;
               if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                  int var10000;
                  label145: {
                     var27 = 0.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt10 = (LivingEntity)entity;
                        if (_livEnt10.m_21023_(MobEffects.f_19621_)) {
                           label141: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19621_)) {
                                    var10000 = _livEnt.m_21124_(MobEffects.f_19621_).m_19564_();
                                    break label141;
                                 }
                              }

                              var10000 = 0;
                           }

                           var10000 += 2;
                           break label145;
                        }
                     }

                     var10000 = 1;
                  }

                  double var33 = (double)var10000;
                  var33 += (double)(entity.getPersistentData().m_128459_("mode_hakari") != 1.0 && entity.getPersistentData().m_128459_("mode_hakari") != 2.0 ? 0 : 5);

                  for(int index0 = 0; index0 < (int)var33; ++index0) {
                     double var32 = var27;
                     var27 = Math.random();
                     if (var27 < 0.8) {
                        var27 = 1.0;
                     } else if (var27 < 0.9) {
                        var27 = 2.0;
                     } else if (var27 < 0.95) {
                        var27 = 3.0;
                     } else {
                        if (!(var27 < 0.99)) {
                           var27 = 5.0;
                           break;
                        }

                        var27 = 4.0;
                     }

                     if (var32 > var27) {
                        var27 = var32;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt14 = (LivingEntity)entity;
                     if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().m_128459_("Reserve") == 0.0) {
                        entity.getPersistentData().m_128347_("Reserve", (double)Math.round(var27));
                     }
                  }
                  break label151;
               }
            }

            var27 = 1.0;
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOORS.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var29, var30, var31), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               SetRangedAmmoProcedure.execute(entity, entityinstance);
               if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                  entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
               }

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

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                  if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22276_)) {
                     _livingEntity25.getAttribute_(Attributes.f_22276_).m_22100_(var26);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.m_21153_((float)var26);
               }

               if (var27 == 1.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_white");
                  }
               } else if (var27 == 2.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_green");
                  }
               } else if (var27 == 3.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_red");
                  }
               } else if (var27 == 4.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_gold");
                  }
               } else if (var27 == 5.0 && entityinstance instanceof EntityDoorsEntity) {
                  EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                  animatable.setTexture("door_rainbow");
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

      }
   }
}
