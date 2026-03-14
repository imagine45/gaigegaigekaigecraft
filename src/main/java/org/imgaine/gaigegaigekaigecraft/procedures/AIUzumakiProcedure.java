package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UzumakiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIUzumakiProcedure {
   public AIUzumakiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean reChange = false;
         boolean logic_attack = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123783_, x, y + (double)entity.m_20206_() * 0.5, z, 80, 8.0, 8.0, 8.0, 0.5);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123746_, x, y + (double)entity.m_20206_() * 0.5, z, 1, 8.0, 8.0, 8.0, 0.5);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof UzumakiEntity) {
            UzumakiEntity _datEntL4 = (UzumakiEntity)entity;
            if ((Boolean)_datEntL4.m_20088_().m_135370_(UzumakiEntity.DATA_move)) {
               double var65;
               label239: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity45 = (LivingEntity)entity;
                     if (_livingEntity45.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var65 = _livingEntity45.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label239;
                     }
                  }

                  var65 = 0.0;
               }

               if (var65 > 0.1 && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity47 = (LivingEntity)entity;
                  if (_livingEntity47.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     double var67;
                     label232: {
                        var66 = _livingEntity47.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity46 = (LivingEntity)entity;
                           if (_livingEntity46.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var67 = _livingEntity46.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                              break label232;
                           }
                        }

                        var67 = 0.0;
                     }

                     var66.m_22100_(Math.max(var67 - 0.1, 0.1));
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt2") != 0.0) {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos") + (entity.getPersistentData().m_128459_("cnt2") - 2.0) * 2.0;
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:soul ~ ~ ~ 8 8 8 2 150 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:explosion ~ ~ ~ 8 8 8 1 150 force");
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") < 15.0) {
                     entity.getPersistentData().m_128347_("Damage", 52.0);
                     entity.getPersistentData().m_128347_("Range", 32.0);
                     entity.getPersistentData().m_128347_("knockback", 2.0);
                     entity.getPersistentData().m_128347_("effectConfirm", 2.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") < 3.0) {
                     entity.getPersistentData().m_128347_("BlockRange", 24.0);
                     entity.getPersistentData().m_128347_("BlockDamage", 18.0);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                        }
                     }
                  }
               } else {
                  if (Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7098_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0)) < 0.5 && entity.getPersistentData().m_128459_("cnt1") > 12.0 || entity.getPersistentData().m_128459_("cnt1") > 50.0 || !entity.m_6084_()) {
                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") > 0.0) {
                     entity.getPersistentData().m_128347_("x_pos", x);
                     entity.getPersistentData().m_128347_("y_pos", y + (double)entity.m_20206_() * 0.5);
                     entity.getPersistentData().m_128347_("z_pos", z);
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 60, 1, false, false));
                        }
                     }

                     if (!entity.getPersistentData().m_128471_("Stop")) {
                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.5, entity.getPersistentData().m_128459_("y_power") * 0.5, entity.getPersistentData().m_128459_("z_power") * 0.5));
                        BulletDomainHit2Procedure.execute(world, entity);
                     } else {
                        entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                        entity.getPersistentData().m_128379_("Stop", true);
                     }

                     entity.getPersistentData().m_128347_("Damage", 52.0);
                     entity.getPersistentData().m_128347_("Range", 12.0);
                     entity.getPersistentData().m_128347_("knockback", 2.0);
                     entity.getPersistentData().m_128347_("effectConfirm", 2.0);
                     RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
                     ParticleGeneratorProcedure.execute(world, range * 0.25, 15.0 * range, 10.0, 1.0, x, x + entity.getPersistentData().m_128459_("x_power"), y + (double)entity.m_20206_() * 0.5, y + (double)entity.m_20206_() * 0.5 + entity.getPersistentData().m_128459_("y_power"), z, z + entity.getPersistentData().m_128459_("z_power"), "minecraft:soul");
                  } else {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123746_, x, y + (double)entity.m_20206_() * 0.5, z, 50, 1.5 * (double)entity.m_20205_() * 0.25, 1.5 * (double)entity.m_20206_() * 0.25, 1.5 * (double)entity.m_20205_() * 0.25, 0.25);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") > 30.0 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               return;
            }
         }

         double var10000;
         label208: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity5.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                  break label208;
               }
            }

            var10000 = 0.0;
         }

         if (var10000 < 1.5 && entity instanceof LivingEntity) {
            LivingEntity _livingEntity7 = (LivingEntity)entity;
            if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               label201: {
                  var64 = _livingEntity7.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity6 = (LivingEntity)entity;
                     if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label201;
                     }
                  }

                  var10001 = 0.0;
               }

               var64.m_22100_(var10001 + 0.1);
            }
         }

         entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
         entity.getPersistentData().m_128379_("Stop", false);
         entity.getPersistentData().m_128347_("cnt1", 0.0);
         entity.getPersistentData().m_128347_("cnt2", 0.0);
         logic_attack = false;
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > 0.0 && entity_a.getPersistentData().m_128459_("cnt1") < 80.0) {
               logic_attack = true;
               entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
               }

               entity.m_146922_(entity_a.m_146908_());
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

               entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
               entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
               entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
            }
         }

         NUM1 = -200.0 - Math.random();
         if ((!logic_attack || !entity.m_6084_()) && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CROW.get()).m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), NUM1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }

         reChange = false;
         Vec3 _center = new Vec3(entity.m_20185_(), NUM1, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator instanceof CrowEntity && entityiterator.m_6084_()) {
               if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }

               reChange = true;
               break;
            }
         }

         if (reChange) {
            if (entity instanceof UzumakiEntity) {
               UzumakiEntity _datEntSetL = (UzumakiEntity)entity;
               _datEntSetL.m_20088_().m_135381_(UzumakiEntity.DATA_move, true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
               }
            }
         }

      }
   }
}
