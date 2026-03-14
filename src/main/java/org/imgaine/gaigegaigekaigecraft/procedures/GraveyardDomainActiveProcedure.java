package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CoffinEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade05Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GraveyardDomainActiveProcedure {
   public GraveyardDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean failed;
         Entity entity_b;
         double range;
         double var10000;
         label266: {
            boolean GRAVESTONE = false;
            failed = false;
            Entity entity_a = null;
            entity_b = null;
            double old_skill = 0.0;
            double HP = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double z_pos = 0.0;
            double y_pos = 0.0;
            double MAX_ST = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label266;
               }
            }

            var10000 = 0.0;
         }

         double var39 = var10000;
         double var33 = entity.getPersistentData().m_128459_("skill");
         double var37 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         double var38 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var41 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var40 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123783_, var38, var41 + 0.0, var40, 20, range * 0.175, 1.0, range * 0.175, 0.05);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123746_, var38, var41 + 0.0, var40, 1, range * 0.175, 0.1, range * 0.175, 0.05);
         }

         if (!entity.getPersistentData().m_128471_("Failed")) {
            entity.getPersistentData().m_128347_("skill", 2505.0);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", 50.0);
            if (var39 % 100.0 == 1.0) {
               entity.getPersistentData().m_128379_("StartDomainAttack", true);
            }

            if (entity.getPersistentData().m_128471_("StartDomainAttack")) {
               label284: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt13 = (LivingEntity)entity;
                     if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label284;
                     }
                  }

                  boolean var30 = false;
                  Entity _ent = null;
                  if (entity.getPersistentData().m_128459_("NameRanged") != 0.0) {
                     Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entityiterator instanceof CoffinEntity && entityiterator.m_6084_() && entity != entityiterator && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") && entityiterator.getPersistentData().m_128459_("death_count1") == 0.0 && entityiterator.getPersistentData().m_128459_("death_count2") == 0.0) {
                           var30 = true;
                           var38 = entityiterator.m_20185_();
                           var41 = entityiterator.m_20186_();
                           var40 = entityiterator.m_20189_();
                           _ent = entityiterator;
                           entity_b = (new BiFunction<LevelAccessor, String, Entity>() {
                              public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                 if (levelAccessor instanceof ServerLevel serverLevel) {
                                    try {
                                       return serverLevel.m_8791_(UUID.fromString(uuid));
                                    } catch (Exception var5) {
                                    }
                                 }

                                 return null;
                              }
                           }).apply(world, entityiterator.getPersistentData().m_128461_("TARGET"));
                           if (entity_b instanceof LivingEntity && entity_b instanceof LivingEntity) {
                              LivingEntity _livEnt31 = (LivingEntity)entity_b;
                              if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 failed = true;
                              }
                           }
                           break;
                        }
                     }
                  }

                  if (var30) {
                     if (entity instanceof CursedSpiritGrade05Entity) {
                        ((CursedSpiritGrade05Entity)entity).setAnimation("right_arm_up");
                     }

                     if (_ent instanceof LivingEntity && !failed) {
                        int var74;
                        label191: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var74 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label191;
                              }
                           }

                           var74 = 0;
                        }

                        double var35 = 75.0 + (double)var74 * 7.5;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.GRAVESTONE_3.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var38, var41, var40), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                                 if (_livingEntity38.m_21204_().m_22171_(Attributes.f_22276_)) {
                                    _livingEntity38.getAttribute_(Attributes.f_22276_).m_22100_(var35);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.m_21153_((float)var35);
                              }

                              entityinstance.getPersistentData().m_128347_("cnt2", 20.0);
                              entityinstance.m_20256_(new Vec3(0.0, -1.0, 0.0));
                              _ent.getPersistentData().m_128359_("CONNECT_UUID", entityinstance.m_20149_());
                              _serverLevel.m_7967_(entityinstance);
                           }
                        }

                        for(int index0 = 0; index0 < 8; ++index0) {
                           if (world.m_8055_(BlockPos.m_274561_(_ent.m_20185_(), _ent.m_20186_(), _ent.m_20189_())).m_60815_()) {
                              _ent.m_6021_(_ent.m_20185_(), _ent.m_20186_() - (double)_ent.m_20206_(), _ent.m_20189_());
                              if (_ent instanceof ServerPlayer) {
                                 ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                                 _serverPlayer.f_8906_.m_9774_(_ent.m_20185_(), _ent.m_20186_() - (double)_ent.m_20206_(), _ent.m_20189_(), _ent.m_146908_(), _ent.m_146909_());
                              }

                              if (entity_b instanceof LivingEntity) {
                                 entity_b.m_6021_(_ent.m_20185_(), _ent.m_20186_() + 0.25, _ent.m_20189_());
                                 if (entity_b instanceof ServerPlayer) {
                                    ServerPlayer _serverPlayer = (ServerPlayer)entity_b;
                                    _serverPlayer.f_8906_.m_9774_(_ent.m_20185_(), _ent.m_20186_() + 0.25, _ent.m_20189_(), entity_b.m_146908_(), entity_b.m_146909_());
                                 }
                              }
                              break;
                           }

                           _ent.m_6021_(_ent.m_20185_(), _ent.m_20186_() - 1.0, _ent.m_20189_());
                           if (_ent instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                              _serverPlayer.f_8906_.m_9774_(_ent.m_20185_(), _ent.m_20186_() - 1.0, _ent.m_20189_(), _ent.m_146908_(), _ent.m_146909_());
                           }
                        }
                     }

                     if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 6, false, false));
                        }
                     }
                  } else {
                     _ent = null;
                     double var42 = 0.0;
                     Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           label225: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var72 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label225;
                                 }
                              }

                              var72 = 0;
                           }

                           if ((double)var72 >= var42) {
                              _ent = entityiterator;
                              var38 = entityiterator.m_20185_();
                              var41 = entityiterator.m_20186_();
                              var40 = entityiterator.m_20189_();
                           }

                           label219: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label219;
                                 }
                              }

                              var10000 = 0.0;
                           }

                           var42 = var10000;
                        }
                     }

                     if (_ent instanceof LivingEntity) {
                        if (_ent.getPersistentData().m_128471_("attack")) {
                           _ent.getPersistentData().m_128347_("skill", 0.0);
                        }

                        if (!_ent.m_9236_().m_5776_() && _ent.m_20194_() != null) {
                           _ent.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent), "title @s title {\"text\":\"\\uE110\"}");
                        }

                        int var10001;
                        label208: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label208;
                              }
                           }

                           var10001 = 0;
                        }

                        double var34 = (double)(40 + var10001 * 4);
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.COFFIN.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var38, var41, var40), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              entityinstance.m_146922_(_ent.m_146908_());
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
                                 LivingEntity _livingEntity93 = (LivingEntity)entityinstance;
                                 if (_livingEntity93.m_21204_().m_22171_(Attributes.f_22276_)) {
                                    _livingEntity93.getAttribute_(Attributes.f_22276_).m_22100_(var34);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.m_21153_((float)var34);
                              }

                              entityinstance.getPersistentData().m_128359_("TARGET", _ent.m_20149_());
                              _serverLevel.m_7967_(entityinstance);
                           }
                        }

                        for(int index1 = 0; index1 < 2; ++index1) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var38, var41, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.close")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                              } else {
                                 _level.m_7785_(var38, var41, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.close")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var38, var41, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                              } else {
                                 _level.m_7785_(var38, var41, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                              }
                           }
                        }

                        if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 6, false, false));
                           }
                        }
                     }
                  }

                  entity.getPersistentData().m_128379_("StartDomainAttack", false);
               }
            }
         }

         entity.getPersistentData().m_128347_("skill", var33);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var37);
      }
   }
}
