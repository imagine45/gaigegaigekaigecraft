package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HanakoSpawnCursedSpiritProcedure {
   public HanakoSpawnCursedSpiritProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double amount = 0.0;
         double strength = 0.0;
         double kind = 0.0;
         double grade = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         boolean player = false;
         if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         double var10000;
         label184: {
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label184;
               }
            }

            var10000 = 0.0;
         }

         strength = var10000;
         player = entity instanceof Player || entity.getPersistentData().m_128471_("Player");
         grade = Math.random() < 0.2 ? 2.0 : 3.0;
         if (grade == 3.0) {
            int index0 = 0;

            while(index0 < 256) {
               kind = Math.ceil(Math.random() * 18.0);
               if (kind != 1.0 && kind != 2.0 && kind != 3.0 && kind != 5.0 && kind != 16.0) {
                  if (kind == 4.0) {
                     amount = 4.0;
                     break;
                  }

                  if (kind != 6.0 && kind != 14.0 && kind != 15.0 && kind != 17.0) {
                     if (kind != 8.0 && kind != 10.0 && kind != 13.0) {
                        if (kind != 11.0 && kind != 12.0) {
                           if (kind != 9.0 && kind != 13.0 && kind != 18.0) {
                              ++index0;
                              continue;
                           }

                           amount = 4.0;
                           break;
                        }

                        amount = 1.0;
                        break;
                     }

                     amount = 2.0;
                     break;
                  }

                  amount = 4.0;
                  break;
               }

               amount = 2.0;
               break;
            }
         } else if (grade == 2.0) {
            for(int index1 = 0; index1 < 256; ++index1) {
               kind = Math.ceil(Math.random() * 9.0);
               if (kind == 1.0 || kind == 4.0 || kind == 5.0 || kind == 8.0 || kind == 9.0) {
                  amount = 1.0;
                  break;
               }
            }
         }

         for(int index2 = 0; index2 < (int)Math.round(amount); ++index2) {
            entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 360.0));
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

            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(1.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(1.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var45 = _level.m_7654_().m_129892_();
               CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
               long var10002 = Math.round(grade);
               var45.m_230957_(var10001, "summon jujutsucraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof LivingEntity && entityiterator.getPersistentData().m_128459_("friend_num") == 0.0 && entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                  entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                  entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.m_146922_((float)yaw);
                  entityiterator.m_146926_((float)pitch);
                  entityiterator.m_5618_(entityiterator.m_146908_());
                  entityiterator.m_5616_(entityiterator.m_146908_());
                  entityiterator.f_19859_ = entityiterator.m_146908_();
                  entityiterator.f_19860_ = entityiterator.m_146909_();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 9, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entityiterator;
                     if (_livingEntity24.m_21204_().m_22171_(Attributes.f_22281_)) {
                        double var47;
                        label110: {
                           var46 = _livingEntity24.getAttribute_(Attributes.f_22281_);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity23 = (LivingEntity)entityiterator;
                              if (_livingEntity23.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var47 = _livingEntity23.getAttribute_(Attributes.f_22281_).m_22115_();
                                 break label110;
                              }
                           }

                           var47 = 0.0;
                        }

                        var46.m_22100_(var47 + strength * 3.0 * 0.5);
                     }
                  }

                  entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                  entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                  entityiterator.getPersistentData().m_128379_("Player", player);
                  entityiterator.getPersistentData().m_128379_("Shikigami", true);
                  break;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, 0.5, 0.5, 0.5, 0.0);
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

      }
   }
}
