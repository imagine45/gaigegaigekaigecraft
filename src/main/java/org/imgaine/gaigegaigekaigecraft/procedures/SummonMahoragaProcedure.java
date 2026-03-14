package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonMahoragaProcedure {
   public SummonMahoragaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean flag_a = false;
         String STR1 = "";
         ItemStack ITEM1 = ItemStack.f_41583_;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw_enemy = 0.0;
         double dis = 0.0;
         double x_fix = 0.0;
         double z_fix = 0.0;
         double num = 0.0;
         double NUM1 = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
            }
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         ITEM1 = var10000.m_41777_();
         yaw = (double)entity.m_146908_();
         picth = (double)entity.m_146909_();
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            entity.getPersistentData().m_128347_("cnt2", 1.0);
            LivingEntity var106;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var106 = _mobEnt.m_5448_();
            } else {
               var106 = null;
            }

            if (var106 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var106 = _mobEnt.m_5448_();
               } else {
                  var106 = null;
               }

               x_pos = ((Entity)var106).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var106 = _mobEnt.m_5448_();
               } else {
                  var106 = null;
               }

               double var109 = ((Entity)var106).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var109 + (double)((Entity)var10001).m_20206_() * 0.5;
               LivingEntity var110;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var110 = _mobEnt.m_5448_();
               } else {
                  var110 = null;
               }

               z_pos = ((Entity)var110).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
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

            entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
            if (ITEM1.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
               entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
               entity.getPersistentData().m_128347_("cnt1", 75.0);
            } else {
               entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 70, 0, false, false));
                  }
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator instanceof LivingEntity) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_216964_, 80, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 9, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 40, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 40, 0, false, false));
                        }
                     }
                  }
               }
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
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

         if (entity.getPersistentData().m_128459_("cnt1") % 10.0 == 1.0 && entity.getPersistentData().m_128459_("cnt1") <= 41.0) {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            dis = 4.0 + entity.getPersistentData().m_128459_("cnt3") * 1.5;
            logic_a = false;

            for(int index0 = 0; index0 < 2; ++index0) {
               yaw = Math.toRadians(entity.getPersistentData().m_128459_("yaw") + 90.0 + (double)(logic_a ? 20 : -20));
               pitch = Math.toRadians(0.0);
               x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(yaw) * dis;
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(yaw) * dis;
               if (entity.getPersistentData().m_128459_("cnt3") % 2.0 == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAHORAGA_DOG.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.m_146922_((float)(entity.getPersistentData().m_128459_("yaw") + (double)(logic_a ? -90 : 90)));
                        entityinstance.m_146926_(-60.0F);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entityinstance.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1"));
                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

                        entityinstance.m_146922_((float)(entity.getPersistentData().m_128459_("yaw") + (double)(logic_a ? -90 : 90)));
                        entityinstance.m_146926_(-60.0F);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAHORAGA_FROG.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_((float)(entity.getPersistentData().m_128459_("yaw") + (double)(logic_a ? -90 : 90)));
                     entityinstance.m_146926_(-60.0F);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1"));
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.m_146922_((float)(entity.getPersistentData().m_128459_("yaw") + (double)(logic_a ? -90 : 90)));
                     entityinstance.m_146926_(-60.0F);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               logic_a = !logic_a;
            }
         }

         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         yaw = entity.getPersistentData().m_128459_("yaw");
         picth = 0.0;
         if (entity.getPersistentData().m_128459_("cnt1") < 70.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 50, 4.0, 0.0, 4.0, 0.0);
            }

            PlayAnimationProcedure.execute(world, entity);
         } else {
            if (entity.getPersistentData().m_128459_("cnt4") == 0.0) {
               entity.getPersistentData().m_128347_("cnt4", 1.0);
               if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 0.75F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123810_, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123815_, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.5);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     label336: {
                        label416: {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           entityinstance.getPersistentData().m_128347_("friend_num2", entity.getPersistentData().m_128459_("friend_num"));
                           entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                           if (entity.getPersistentData().m_128459_("TenShadowsTechnique14") != 1.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label416;
                              }

                              ServerPlayer _plr101 = (ServerPlayer)entity;
                              if (!(_plr101.m_9236_() instanceof ServerLevel) || !_plr101.m_8960_().m_135996_(_plr101.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga"))).m_8193_()) {
                                 break label416;
                              }
                           }

                           entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                           entityinstance.getPersistentData().m_128379_("Ambush", true);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity112 = (LivingEntity)entityinstance;
                              if (_livingEntity112.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 double var114;
                                 label323: {
                                    var111 = _livingEntity112.getAttribute_(Attributes.f_22281_);
                                    if (entityinstance instanceof LivingEntity) {
                                       LivingEntity _livingEntity108 = (LivingEntity)entityinstance;
                                       if (_livingEntity108.m_21204_().m_22171_(Attributes.f_22281_)) {
                                          var114 = _livingEntity108.getAttribute_(Attributes.f_22281_).m_22115_();
                                          break label323;
                                       }
                                    }

                                    var114 = 0.0;
                                 }

                                 double var10002;
                                 label318: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity109 = (LivingEntity)entity;
                                       if (_livingEntity109.m_21204_().m_22171_(Attributes.f_22281_)) {
                                          var10002 = _livingEntity109.getAttribute_(Attributes.f_22281_).m_22115_();
                                          break label318;
                                       }
                                    }

                                    var10002 = 0.0;
                                 }

                                 int var10003;
                                 label313: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label313;
                                       }
                                    }

                                    var10003 = 0;
                                 }

                                 var111.m_22100_(var114 + (var10002 + (double)(var10003 * 3)) * 0.2);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var115;
                                 MobEffect var116;
                                 int var10005;
                                 label305: {
                                    var115 = new MobEffectInstance;
                                    var116 = MobEffects.f_19606_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                          var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                          break label305;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var115.<init>(var116, 2147483647, Math.max(var10005, 3), false, false);
                                 _entity.m_7292_(var115);
                              }
                           }

                           entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                           entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                           entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                           break label336;
                        }

                        entityinstance.getPersistentData().m_128359_("TARGET_UUID", entity.m_20149_());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entityinstance;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                        }
                     }

                     if (ITEM1.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        CompoundTag _nbtTag = ITEM1.m_41783_();
                        if (_nbtTag != null) {
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityinstance;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41751_(_nbtTag.m_6426_());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                        }

                        entity.getPersistentData().m_128347_("skill", 0.0);
                     }

                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", entity.getPersistentData().m_128459_("cnt10"));
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

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               entity.getPersistentData().m_128347_("TenShadowsTechnique14", -1.0);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            } else if (entity.getPersistentData().m_128459_("cnt1") > 125.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         if (entity instanceof SukunaFushiguroEntity) {
            entity.getPersistentData().m_128379_("flag_agito", true);
            if (entity.getPersistentData().m_128459_("TenShadowsTechnique5") != -1.0) {
               entity.getPersistentData().m_128347_("TenShadowsTechnique5", -2.0);
            }

            if (entity.getPersistentData().m_128459_("TenShadowsTechnique9") != -1.0) {
               entity.getPersistentData().m_128347_("TenShadowsTechnique9", -2.0);
            }

            if (entity.getPersistentData().m_128459_("TenShadowsTechnique11") != -1.0) {
               entity.getPersistentData().m_128347_("TenShadowsTechnique11", -2.0);
            }
         }

      }
   }
}
