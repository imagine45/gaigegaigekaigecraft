package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade39Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueNecklace1Procedure {
   public TechniqueNecklace1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean player = false;
         boolean target = false;
         double amount = 0.0;
         double strength = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 10, false, false));
            }
         }

         amount = 8.0;
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(32.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator instanceof CursedSpiritGrade39Entity) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0 && (entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") || entityiterator.getPersistentData().m_128459_("friend_num") == 0.0)) {
                  if (entityiterator instanceof Mob) {
                     Mob _entity = (Mob)entityiterator;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     LivingEntity var34 = var10000;
                     if (var34 instanceof LivingEntity) {
                        LivingEntity _ent = var34;
                        _entity.m_6710_(_ent);
                     }
                  }

                  CompoundTag var70 = entityiterator.getPersistentData();
                  LivingEntity var10002;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.m_5448_();
                  } else {
                     var10002 = null;
                  }

                  var70.m_128359_("TARGET_UUID", ((Entity)var10002).m_20149_());
                  entityiterator.getPersistentData().m_128347_("cnt_target", Math.max(entityiterator.getPersistentData().m_128459_("cnt_target"), 10.0));
                  entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
               }

               if (entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                  --amount;
               }
            }
         }

         double var71;
         label219: {
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var71 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label219;
               }
            }

            var71 = 0.0;
         }

         strength = var71;
         player = entity instanceof Player;
         LivingEntity var72;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var72 = _mobEnt.m_5448_();
         } else {
            var72 = null;
         }

         target = var72 instanceof LivingEntity;
         if (amount > 0.0) {
            for(int index0 = 0; index0 < (int)amount; ++index0) {
               entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 180.0));
               entity.m_146926_((float)Math.min(pitch, 0.0));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = entity.m_20186_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  y_pos = entity.m_20186_();

                  for(int index1 = 0; index1 < 12; ++index1) {
                     ++y_pos;
                     if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        break;
                     }
                  }
               } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_()) {
                  y_pos = entity.m_20186_();

                  for(int index2 = 0; index2 < 12; ++index2) {
                     --y_pos;
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_()) {
                        break;
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_39.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.m_146922_((float)yaw);
                     entityinstance.m_146926_((float)pitch);
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
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 9, false, false));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity59 = (LivingEntity)entityinstance;
                        if (_livingEntity59.m_21204_().m_22171_(Attributes.f_22276_)) {
                           double var10001;
                           label200: {
                              var73 = _livingEntity59.getAttribute_(Attributes.f_22276_);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity57 = (LivingEntity)entityinstance;
                                 if (_livingEntity57.m_21204_().m_22171_(Attributes.f_22276_)) {
                                    var10001 = _livingEntity57.getAttribute_(Attributes.f_22276_).m_22115_();
                                    break label200;
                                 }
                              }

                              var10001 = 0.0;
                           }

                           var73.m_22100_(var10001 + strength * 4.0);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity63 = (LivingEntity)entityinstance;
                        if (_livingEntity63.m_21204_().m_22171_(Attributes.f_22279_)) {
                           double var78;
                           label189: {
                              var74 = _livingEntity63.getAttribute_(Attributes.f_22279_);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity61 = (LivingEntity)entityinstance;
                                 if (_livingEntity61.m_21204_().m_22171_(Attributes.f_22279_)) {
                                    var78 = _livingEntity61.getAttribute_(Attributes.f_22279_).m_22115_();
                                    break label189;
                                 }
                              }

                              var78 = 0.0;
                           }

                           var74.m_22100_(var78 + 0.02);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity67 = (LivingEntity)entityinstance;
                        if (_livingEntity67.m_21204_().m_22171_(Attributes.f_22281_)) {
                           double var79;
                           label178: {
                              var75 = _livingEntity67.getAttribute_(Attributes.f_22281_);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity65 = (LivingEntity)entityinstance;
                                 if (_livingEntity65.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var79 = _livingEntity65.getAttribute_(Attributes.f_22281_).m_22115_();
                                    break label178;
                                 }
                              }

                              var79 = 0.0;
                           }

                           var75.m_22100_(var79 + strength * 3.0 * 0.5);
                        }
                     }

                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", entity.getPersistentData().m_128471_("CursedSpirit"));
                     entityinstance.getPersistentData().m_128379_("Player", player);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var72 = _mobEnt.m_5448_();
                     } else {
                        var72 = null;
                     }

                     if (var72 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
                        CompoundTag var77 = entityinstance.getPersistentData();
                        LivingEntity var80;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var80 = _mobEnt.m_5448_();
                        } else {
                           var80 = null;
                        }

                        var77.m_128359_("TARGET_UUID", ((Entity)var80).m_20149_());
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 20, 0.5, 0.0, 0.5, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 5, 0.5, 0.5, 0.5, 0.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F, false);
                  }
               }
            }
         }

         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         entity.getPersistentData().m_128347_("skill", 0.0);
      }
   }
}
