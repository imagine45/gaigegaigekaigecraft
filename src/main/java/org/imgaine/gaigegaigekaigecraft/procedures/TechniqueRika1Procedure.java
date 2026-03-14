package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class TechniqueRika1Procedure {
   public TechniqueRika1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
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
         boolean summon = false;
         boolean noControl = false;
         Entity entity_rika = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         boolean var10000;
         if (entity instanceof Player) {
            label386: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr3 = (ServerPlayer)entity;
                  if (_plr3.m_9236_() instanceof ServerLevel && _plr3.m_8960_().m_135996_(_plr3.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_rika_control"))).m_8193_()) {
                     var10000 = 0;
                     break label386;
                  }
               }

               var10000 = 1;
            }
         } else {
            label381: {
               if (!(entity instanceof Player)) {
                  label378: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label378;
                        }
                     }

                     var10000 = 0;
                  }

                  if (var10000 < 10) {
                     var10000 = 1;
                     break label381;
                  }
               }

               var10000 = 0;
            }
         }

         noControl = (boolean)var10000;
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (LocateRikaProcedure.execute(world, entity)) {
               entity.getPersistentData().m_128347_("cnt4", 1.0);
            } else {
               entity.getPersistentData().m_128347_("cnt4", 0.0);
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               LivingEntity var86;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var86 = _mobEnt.m_5448_();
               } else {
                  var86 = null;
               }

               if (var86 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var86 = _mobEnt.m_5448_();
                  } else {
                     var86 = null;
                  }

                  label362: {
                     LivingEntity var29 = var86;
                     if (var29 instanceof LivingEntity) {
                        LivingEntity _livEnt = var29;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var88 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label362;
                        }
                     }

                     var88 = 0;
                  }

                  int var10001;
                  label357: {
                     var89 = (double)var88;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label357;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var89 <= (double)var10001 * 0.5) {
                     entity.getPersistentData().m_128347_("cnt2", 0.0);
                  }
               }

               if (noControl || entity.m_6144_()) {
                  entity.getPersistentData().m_128347_("cnt2", 0.0);
               }
            }

            LivingEntity var90;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var90 = _mobEnt.m_5448_();
            } else {
               var90 = null;
            }

            if (var90 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               Level var92 = ((Entity)var90).m_9236_();
               ClipContext var99 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var104 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var111 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var111 = var111.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(-5.0));
               ClipContext.Block var119 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var99.<init>(var104, var111, var119, var10006, var10007);
               x_pos = (double)var92.m_45547_(var99).m_82425_().m_123341_();
               LivingEntity var93;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var93 = _mobEnt.m_5448_();
               } else {
                  var93 = null;
               }

               Level var94 = ((Entity)var93).m_9236_();
               var99 = new ClipContext;
               LivingEntity var105;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.m_5448_();
               } else {
                  var105 = null;
               }

               Vec3 var106 = ((Entity)var105).m_20299_(1.0F);
               LivingEntity var113;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var113 = _mobEnt.m_5448_();
               } else {
                  var113 = null;
               }

               Vec3 var114 = ((Entity)var113).m_20299_(1.0F);
               LivingEntity var120;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var120 = _mobEnt.m_5448_();
               } else {
                  var120 = null;
               }

               var114 = var114.m_82549_(((Entity)var120).m_20252_(1.0F).m_82490_(-5.0));
               ClipContext.Block var121 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var99.<init>(var106, var114, var121, var10006, var10007);
               y_pos = (double)var94.m_45547_(var99).m_82425_().m_123342_();
               LivingEntity var95;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var95 = _mobEnt.m_5448_();
               } else {
                  var95 = null;
               }

               Level var96 = ((Entity)var95).m_9236_();
               var99 = new ClipContext;
               LivingEntity var107;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var107 = _mobEnt.m_5448_();
               } else {
                  var107 = null;
               }

               Vec3 var108 = ((Entity)var107).m_20299_(1.0F);
               LivingEntity var116;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var116 = _mobEnt.m_5448_();
               } else {
                  var116 = null;
               }

               Vec3 var117 = ((Entity)var116).m_20299_(1.0F);
               LivingEntity var122;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var122 = _mobEnt.m_5448_();
               } else {
                  var122 = null;
               }

               var117 = var117.m_82549_(((Entity)var122).m_20252_(1.0F).m_82490_(-5.0));
               ClipContext.Block var123 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var99.<init>(var108, var117, var123, var10006, var10007);
               z_pos = (double)var96.m_45547_(var99).m_82425_().m_123343_();
               LivingEntity var97;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var97 = _mobEnt.m_5448_();
               } else {
                  var97 = null;
               }

               yaw = (double)((Entity)var97).m_146908_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var97 = _mobEnt.m_5448_();
               } else {
                  var97 = null;
               }

               picth = (double)((Entity)var97).m_146909_();
            } else {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               yaw = (double)(entity.m_146908_() + 180.0F);
               picth = (double)(entity.m_146909_() * -1.0F);
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
            entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
         }

         summon = entity.getPersistentData().m_128459_("cnt2") == 1.0;
         if (entity.getPersistentData().m_128459_("cnt4") == 1.0) {
            if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
               entity_rika = (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num")) {
                  label396: {
                     if (entity instanceof Player) {
                        if (!entity.m_6144_()) {
                           break label396;
                        }
                     } else if (!(Math.random() < 0.5)) {
                        break label396;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, entity_rika.m_20185_(), entity_rika.m_20186_(), entity_rika.m_20189_(), 50, 1.0, 1.0, 1.0, 0.0);
                     }

                     entity_rika.m_146922_((float)yaw);
                     entity_rika.m_146926_((float)picth);
                     entity_rika.m_5618_(entity_rika.m_146908_());
                     entity_rika.m_5616_(entity_rika.m_146908_());
                     entity_rika.f_19859_ = entity_rika.m_146908_();
                     entity_rika.f_19860_ = entity_rika.m_146909_();
                     if (entity_rika instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_rika;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entity_rika.m_6021_(x_pos, y_pos, z_pos);
                     if (entity_rika instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity_rika;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity_rika.m_146908_(), entity_rika.m_146909_());
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.25);
                     }
                  }

                  entity_rika.getPersistentData().m_128379_("flag_attack", true);
               }
            }

            entity.getPersistentData().m_128347_("skill", 0.0);
         } else {
            if (summon) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.technique.rika1").getString()), true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                  entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + Math.random() * 0.1);
                  entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", 0.0);
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(noControl ? Component.m_237115_("jujutsu.technique.rika4").getString() : Component.m_237115_("jujutsu.technique.rika3").getString()), true);
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 5.0));
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            yaw = entity.getPersistentData().m_128459_("yaw");
            picth = entity.getPersistentData().m_128459_("pitch");
            if (entity.getPersistentData().m_128459_("cnt1") < 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, 1.0, 1.0, 1.0, 0.25);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") == 5.0) {
               if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               label398: {
                  label399: {
                     if (entity instanceof Player) {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr90 = (ServerPlayer)entity;
                           if (_plr90.m_9236_() instanceof ServerLevel && _plr90.m_8960_().m_135996_(_plr90.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_curseis_lifted"))).m_8193_()) {
                              break label399;
                           }
                        }
                     } else if (entity instanceof OkkotsuYutaCullingGameEntity) {
                        break label399;
                     }

                     if (!(world instanceof ServerLevel)) {
                        break label398;
                     }

                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.RIKA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance == null) {
                        break label398;
                     }

                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_((float)yaw);
                     entityinstance.m_146926_((float)picth);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entity.getPersistentData().m_128359_("RIKA_UUID", entityinstance.m_20149_());
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var102;
                           MobEffect var109;
                           int var124;
                           label306: {
                              var102 = new MobEffectInstance;
                              var109 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var124 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label306;
                                 }
                              }

                              var124 = 0;
                           }

                           var102.<init>(var109, 2147483647, Math.max(var124, entityinstance instanceof RikaEntity ? 20 : 16), false, false);
                           _entity.m_7292_(var102);
                        }
                     }

                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player);
                     if (!summon) {
                        entityinstance.getPersistentData().m_128347_("skill", 11.0);
                        dis = noControl ? 3.0 : 2.0;
                        entityinstance.getPersistentData().m_128347_("despawn_flag", dis);
                     }

                     _serverLevel.m_7967_(entityinstance);
                     break label398;
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.RIKA_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.m_146922_((float)yaw);
                        entityinstance.m_146926_((float)picth);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entity.getPersistentData().m_128359_("RIKA_UUID", entityinstance.m_20149_());
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var103;
                              MobEffect var110;
                              int var125;
                              label297: {
                                 var103 = new MobEffectInstance;
                                 var110 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var125 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label297;
                                    }
                                 }

                                 var125 = 0;
                              }

                              var103.<init>(var110, 2147483647, Math.max(var125, entityinstance instanceof RikaEntity ? 20 : 16), false, false);
                              _entity.m_7292_(var103);
                           }
                        }

                        entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                        entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                        entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player);
                        if (!summon) {
                           entityinstance.getPersistentData().m_128347_("skill", 11.0);
                           dis = noControl ? 3.0 : 2.0;
                           entityinstance.getPersistentData().m_128347_("despawn_flag", dis);
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, 1.0, 1.0, 1.0, 0.75);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
               if (summon) {
                  dis = (entity.getPersistentData().m_128459_("cnt1") - 10.0) * 0.5;

                  for(int index0 = 0; index0 < 72; ++index0) {
                     yaw += Math.toRadians(10.0 * Math.random());
                     x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.sin(yaw) * dis;
                     y_pos = entity.getPersistentData().m_128459_("y_pos");
                     z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.cos(yaw) * dis;
                     if (Math.random() < 0.5 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.25);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            } else {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
