package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueScissorsProcedure {
   public TechniqueScissorsProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean success = false;
         double HP = 0.0;
         double x_fix = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double z_fix = 0.0;
         double num1 = 0.0;
         double y_fix = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double MAX_ST = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 60, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 19, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var83 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var83 + (double)((Entity)var10001).m_20206_() * 0.7;
               LivingEntity var84;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.m_5448_();
               } else {
                  var84 = null;
               }

               z_pos = ((Entity)var84).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            entity.m_146922_(entity.m_146908_());
            entity.m_146926_(0.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("yaw", (double)(entity.m_146908_() + 90.0F));
            entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 2.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 2.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 2.0);
            entity.getPersistentData().m_128347_("cnt6", 2.5);
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

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity35 = (LivingEntity)entity;
               if (_livingEntity35.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity35.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-16.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity36 = (LivingEntity)entity;
               if (_livingEntity36.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity36.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         int var87;
         label250: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var87 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label250;
               }
            }

            var87 = 0;
         }

         HP = (double)(40 + var87 * 4);

         for(int index0 = 0; index0 < 3; ++index0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            dis = entity.getPersistentData().m_128459_("cnt1") * 1.0;
            num1 = Math.toRadians(entity.getPersistentData().m_128459_("yaw") - 45.0);

            for(int index1 = 0; index1 < 18; ++index1) {
               x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(num1) * dis;
               z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(num1) * dis;
               num1 += Math.toRadians(Math.random() * 10.0);
               success = false;
               if (!success) {
                  y_pos = entity.getPersistentData().m_128459_("y_pos");

                  for(int index2 = 0; index2 < (int)dis; ++index2) {
                     if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        success = true;
                        break;
                     }

                     y_pos += 0.5;
                  }
               }

               if (!success) {
                  y_pos = entity.getPersistentData().m_128459_("y_pos");

                  for(int index3 = 0; index3 < (int)dis; ++index3) {
                     if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        success = true;
                        break;
                     }

                     y_pos -= 0.5;
                  }
               }

               if (success) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.749 0.984 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 1, 0.05, 0.05, 0.05, 0.0);
                  }
               }
            }

            num1 = Math.toRadians(entity.getPersistentData().m_128459_("yaw"));
            x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(num1) * dis;
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(num1) * dis;
            entity.getPersistentData().m_128347_("Range", dis * 2.0);
            entity.getPersistentData().m_128379_("onlyLiving", true);
            entity_a = null;
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt60 = (LivingEntity)entityiterator;
                     if (_livEnt60.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        continue;
                     }
                  }

                  if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     int var85;
                     label225: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var85 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label225;
                           }
                        }

                        var85 = 0;
                     }

                     if ((double)var85 >= MAX_ST) {
                        entity_a = entityiterator;
                     }

                     label219: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var86 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label219;
                           }
                        }

                        var86 = 0.0;
                     }

                     MAX_ST = var86;
                  }
               }
            }

            if (entity_a instanceof LivingEntity) {
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 50, 19, false, false));
                  }
               }

               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 50, 0, false, false));
                  }
               }

               entity_a.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:tinnitus")), SoundSource.NEUTRAL, 0.25F, 1.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:tinnitus")), SoundSource.NEUTRAL, 0.25F, 1.5F, false);
                  }
               }

               for(int index4 = 0; index4 < Math.min(10, Math.round(2.0F * (entity_a.m_20205_() + entity_a.m_20206_()))); ++index4) {
                  num1 = Math.toRadians(Math.random() * 720.0);
                  x_fix = Math.sin(num1) * ((double)(entity_a.m_20205_() * 1.0F) + 0.5);
                  y_fix = (double)(entity_a.m_20206_() + 2.0F) * Math.random() - 1.0;
                  z_fix = Math.cos(num1) * ((double)(entity_a.m_20205_() * 1.0F) + 0.5);
                  x_pos = entity_a.m_20185_() + x_fix;
                  y_pos = entity_a.m_20186_() + y_fix;
                  z_pos = entity_a.m_20189_() + z_fix;
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_SCISSORS.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoGravity:1b,NoAI:1b}");
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity83 = (LivingEntity)entityinstance;
                           if (_livingEntity83.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity83.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        entityinstance.m_7618_(Anchor.EYES, new Vec3(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5 + (double)entity_a.m_20206_() * (Math.random() - 0.5) * 1.0, entity_a.m_20189_()));
                        entityinstance.getPersistentData().m_128347_("x_pos", x_fix);
                        entityinstance.getPersistentData().m_128347_("y_pos", y_fix);
                        entityinstance.getPersistentData().m_128347_("z_pos", z_fix);
                        entityinstance.getPersistentData().m_128359_("TARGET", entity_a.m_20149_());
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }
            }

            entity.getPersistentData().m_128379_("onlyLiving", false);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 22.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
