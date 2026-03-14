package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueKillerProcedure {
   public TechniqueKillerProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double strength = 0.0;
         double HP = 0.0;
         double loop_num = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         boolean player = false;
         boolean target = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         player = entity instanceof Player;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target = var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 10, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            int var10001;
            label206: {
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label206;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(80 + var10001 * 10);

            for(int index0 = 0; index0 < 4; ++index0) {
               ++loop_num;
               y_pos = entity.getPersistentData().m_128459_("y_pos") - 0.0;
               if (loop_num <= 2.0) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + (double)(loop_num % 2.0 == 1.0 ? 2 : -2);
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
               } else {
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + (double)(loop_num % 2.0 == 1.0 ? 2 : -2);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOOR.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.m_146922_(0.0F);
                     entityinstance.m_146926_(0.0F);
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
                        LivingEntity _livingEntity27 = (LivingEntity)entityinstance;
                        if (_livingEntity27.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity27.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            label195: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var54 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label195;
                  }
               }

               var54 = 0.0;
            }

            strength = var54;
            loop_num = Math.ceil(Math.random() * 4.0);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.KILLER_1.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
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

                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var59;
                        MobEffect var10003;
                        int var10005;
                        label185: {
                           var59 = new MobEffectInstance;
                           var10003 = MobEffects.f_19606_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                 break label185;
                              }
                           }

                           var10005 = 0;
                        }

                        var59.<init>(var10003, 2147483647, var10005, false, false);
                        _entity.m_7292_(var59);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var60;
                        MobEffect var64;
                        int var65;
                        label177: {
                           var60 = new MobEffectInstance;
                           var64 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var65 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label177;
                              }
                           }

                           var65 = 0;
                        }

                        var60.<init>(var64, 2147483647, var65, false, false);
                        _entity.m_7292_(var60);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity60 = (LivingEntity)entityinstance;
                     if (_livingEntity60.m_21204_().m_22171_(Attributes.f_22276_)) {
                        double var61;
                        label169: {
                           var55 = _livingEntity60.getAttribute_(Attributes.f_22276_);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity58 = (LivingEntity)entityinstance;
                              if (_livingEntity58.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 var61 = _livingEntity58.getAttribute_(Attributes.f_22276_).m_22115_();
                                 break label169;
                              }
                           }

                           var61 = 0.0;
                        }

                        var55.m_22100_(var61 + strength * 4.0);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                     if (_livingEntity64.m_21204_().m_22171_(Attributes.f_22279_)) {
                        double var62;
                        label161: {
                           var56 = _livingEntity64.getAttribute_(Attributes.f_22279_);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity62 = (LivingEntity)entityinstance;
                              if (_livingEntity62.m_21204_().m_22171_(Attributes.f_22279_)) {
                                 var62 = _livingEntity62.getAttribute_(Attributes.f_22279_).m_22115_();
                                 break label161;
                              }
                           }

                           var62 = 0.0;
                        }

                        var56.m_22100_(var62 + 0.02);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity68 = (LivingEntity)entityinstance;
                     if (_livingEntity68.m_21204_().m_22171_(Attributes.f_22281_)) {
                        double var63;
                        label153: {
                           var57 = _livingEntity68.getAttribute_(Attributes.f_22281_);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity66 = (LivingEntity)entityinstance;
                              if (_livingEntity66.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var63 = _livingEntity66.getAttribute_(Attributes.f_22281_).m_22115_();
                                 break label153;
                              }
                           }

                           var63 = 0.0;
                        }

                        var57.m_22100_(var63 + strength * 3.0 * 0.5);
                     }
                  }

                  entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                  entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                  entityinstance.getPersistentData().m_128379_("Player", player);
                  entityinstance.getPersistentData().m_128379_("Shikigami", true);
                  if (target) {
                     CompoundTag var58 = entityinstance.getPersistentData();
                     LivingEntity var10002;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.m_5448_();
                     } else {
                        var10002 = null;
                     }

                     var58.m_128359_("TARGET_UUID", ((Entity)var10002).m_20149_());
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
