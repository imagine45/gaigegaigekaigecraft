package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.FlameArrowEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFlameArrowProcedure {
   public AIFlameArrowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a;
         double DUST_AMOUNT;
         double var10000;
         label276: {
            boolean logic_attack = false;
            boolean type = false;
            entity_a = null;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double rad = 0.0;
            double range = 0.0;
            double cnt1_local = 0.0;
            double rad_now = 0.0;
            double dis = 0.0;
            double cnt2 = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double strength = 0.0;
            double num1 = 0.0;
            double num2 = 0.0;
            double num3 = 0.0;
            double CNT6 = 0.0;
            DUST_AMOUNT = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label276;
               }
            }

            var10000 = 0.0;
         }

         label280: {
            double var64 = var10000;
            double var67 = 1.0;
            if (entity instanceof FlameArrowEntity) {
               FlameArrowEntity _datEntL1 = (FlameArrowEntity)entity;
               if ((Boolean)_datEntL1.m_20088_().m_135370_(FlameArrowEntity.DATA_sync)) {
                  label295: {
                     entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
                     double var62 = x - entity.getPersistentData().m_128459_("old_x");
                     double var63 = y - entity.getPersistentData().m_128459_("old_y");
                     double var61 = z - entity.getPersistentData().m_128459_("old_z");
                     if (entity instanceof FlameArrowEntity) {
                        FlameArrowEntity _datEntL32 = (FlameArrowEntity)entity;
                        if ((Boolean)_datEntL32.m_20088_().m_135370_(FlameArrowEntity.DATA_sync2)) {
                           if (LogicOwnerExistProcedure.execute(world, entity)) {
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
                              if (entity_a instanceof LivingEntity) {
                                 label229: {
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var96 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label229;
                                       }
                                    }

                                    var96 = 0;
                                 }

                                 if (var96 > 0 && !entity_a.getPersistentData().m_128471_("Failed")) {
                                    entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), entity_a.getPersistentData().m_128459_("dust_amount")));
                                    entity_a.getPersistentData().m_128347_("dust_amount", 0.0);
                                 }
                              }
                           }

                           DUST_AMOUNT = 0.25 + entity.getPersistentData().m_128459_("cnt6") / 75.0;
                           var67 = 1.0 + DUST_AMOUNT * 0.1;
                           entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                           entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                           double var54 = entity.getPersistentData().m_128459_("x_pos");
                           double var58 = entity.getPersistentData().m_128459_("z_pos");
                           double var55 = entity.getPersistentData().m_128459_("y_pos") + (0.5 + 0.5 * Math.random()) * Math.min(entity.getPersistentData().m_128459_("cnt2") * 2.0, 16.0);
                           double var59 = 16.0 * var67;
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_flame ~ ~ ~ " + 2.0 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + 1.0 * DUST_AMOUNT + " " + Math.round(5.0 * DUST_AMOUNT) + " force");
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flame ~ ~ ~ " + 4.0 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + 4.0 * DUST_AMOUNT + " 2 " + Math.round(10.0 * DUST_AMOUNT) + " force");
                           }

                           var55 = entity.getPersistentData().m_128459_("y_pos");
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_flame ~ ~ ~ " + 5.0 * DUST_AMOUNT + " " + 5.0 * DUST_AMOUNT + " " + 5.0 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + Math.round(10.0 * DUST_AMOUNT) + " force");
                           }

                           if (entity.getPersistentData().m_128459_("cnt2") < (var64 - 5.0) * 2.0 * var67 * DUST_AMOUNT) {
                              double var65 = Math.toRadians(Math.random() * 360.0);
                              double var66 = entity.getPersistentData().m_128459_("cnt2");

                              for(int index1 = 0; index1 < 72; ++index1) {
                                 var54 = entity.getPersistentData().m_128459_("x_pos") + Math.sin(var65) * var66;
                                 var58 = entity.getPersistentData().m_128459_("z_pos") + Math.cos(var65) * var66;
                                 if (DUST_AMOUNT > 1.0 && world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_flame ~ ~ ~ " + 2.0 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + 1.0 * DUST_AMOUNT + " " + Math.round(1.0 * DUST_AMOUNT) + " force");
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle cloud ~ ~ ~ " + 2.0 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " 1 " + Math.max(Math.round(1.0 * DUST_AMOUNT), 1L) + " force");
                                 }

                                 var65 += Math.toRadians(Math.random() * 10.0);
                              }
                           }

                           if (!(entity.getPersistentData().m_128459_("cnt2") < 15.0 * var67 * DUST_AMOUNT + 3.0)) {
                              break label295;
                           }

                           entity.getPersistentData().m_128347_("Damage", 35.0 * var67);
                           entity.getPersistentData().m_128347_("Range", 24.0 * var67 * (DUST_AMOUNT + 0.25));
                           entity.getPersistentData().m_128347_("projectile_type", 1.0);
                           entity.getPersistentData().m_128347_("knockback", 0.5);
                           entity.getPersistentData().m_128347_("effect", 3.0);
                           entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                           RangeAttackProcedure.execute(world, var54, var55, var58, entity);
                           entity.getPersistentData().m_128379_("ExtinctionBlock", false);
                           if (entity.getPersistentData().m_128459_("cnt2") < 3.0 * var67 * DUST_AMOUNT + 3.0) {
                              if (entity.getPersistentData().m_128459_("cnt5") <= Math.min(DUST_AMOUNT, 2.0)) {
                                 entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
                                 entity.getPersistentData().m_128347_("BlockRange", 18.0 * var67 * (DUST_AMOUNT + 0.25));
                                 entity.getPersistentData().m_128347_("BlockDamage", 24.0 * var67);
                                 entity.getPersistentData().m_128379_("noParticle", true);
                                 entity.getPersistentData().m_128379_("noEffect", true);
                                 entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                                 BlockDestroyAllDirectionProcedure.execute(world, var54, var55, var58, entity);
                              }

                              if (entity_a instanceof LivingEntity) {
                                 label207: {
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var97 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label207;
                                       }
                                    }

                                    var97 = 0;
                                 }

                                 if (var97 > 0 && !entity_a.getPersistentData().m_128471_("Failed")) {
                                    entity.getPersistentData().m_128347_("Damage", 35.0 * var67);
                                    entity.getPersistentData().m_128347_("Range", 6.0 * JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius);
                                    entity.getPersistentData().m_128347_("projectile_type", 1.0);
                                    entity.getPersistentData().m_128347_("knockback", 0.5);
                                    entity.getPersistentData().m_128347_("effect", 3.0);
                                    RangeAttackProcedure.execute(world, entity_a.getPersistentData().m_128459_("x_pos_doma"), entity_a.getPersistentData().m_128459_("y_pos_doma"), entity_a.getPersistentData().m_128459_("z_pos_doma"), entity);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var55, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F);
                                 } else {
                                    _level.m_7785_(var54, var55, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var55, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F);
                                 } else {
                                    _level.m_7785_(var54, var55, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var55, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F);
                                 } else {
                                    _level.m_7785_(var54, var55, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F, false);
                                 }
                              }
                           }

                           var55 = entity.getPersistentData().m_128459_("y_pos") + (entity.getPersistentData().m_128459_("cnt2") - 2.0) * 2.0;
                           var59 = 5.0 * var67;
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flame ~ ~ ~ " + var59 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + Math.max(2.0 * DUST_AMOUNT, 1.0) + " " + Math.round(Math.max(20.0 * DUST_AMOUNT, 20.0)) + " force");
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle explosion ~ ~ ~ " + var59 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + Math.round(20.0 * DUST_AMOUNT) + " force");
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var54, var55, var58), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle large_smoke ~ ~ ~ " + var59 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + var59 * DUST_AMOUNT + " " + Math.max(2.0 * DUST_AMOUNT, 1.0) + " " + Math.round(10.0 * DUST_AMOUNT) + " force");
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var55, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F);
                              } else {
                                 _level.m_7785_(var54, var55, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var55, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F);
                              } else {
                                 _level.m_7785_(var54, var55, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var55, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.5F);
                              } else {
                                 _level.m_7785_(var54, var55, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.5F, false);
                              }
                           }
                           break label295;
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 50, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 50, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                           }
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
                     }

                     if (Math.random() < 0.05 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123745_, x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
                     }

                     entity.getPersistentData().m_128347_("Damage", 35.0);
                     entity.getPersistentData().m_128347_("Range", 5.0);
                     entity.getPersistentData().m_128347_("knockback", 0.5);
                     entity.getPersistentData().m_128347_("effect", 3.0);
                     entity.getPersistentData().m_128347_("effectConfirm", 2.0);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", false);
                     if ((Math.sqrt(Math.pow(var62, 2.0) + Math.pow(var63, 2.0) + Math.pow(var61, 2.0)) < 1.0 || entity.m_5830_()) && entity.getPersistentData().m_128459_("cnt1") > 5.0 || entity.getPersistentData().m_128459_("cnt1") > 60.0 || !entity.m_6084_()) {
                        entity.getPersistentData().m_128347_("cnt2", 1.0);
                     }

                     if (entity.getPersistentData().m_128459_("cnt2") > 0.0) {
                        if (entity instanceof FlameArrowEntity) {
                           FlameArrowEntity _datEntSetL = (FlameArrowEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(FlameArrowEntity.DATA_sync2, true);
                        }

                        entity.getPersistentData().m_128347_("x_pos", x);
                        entity.getPersistentData().m_128347_("y_pos", y);
                        entity.getPersistentData().m_128347_("z_pos", z);
                     }

                     if (entity.getPersistentData().m_128471_("Stop")) {
                        entity.getPersistentData().m_128379_("Stop", true);
                     } else {
                        for(int index0 = 0; index0 < 3; ++index0) {
                           entity.m_6021_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 0.2, entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * 0.2, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 0.2);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 0.2, entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * 0.2, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 0.2, entity.m_146908_(), entity.m_146909_());
                           }

                           if (world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).m_60815_()) {
                              entity.getPersistentData().m_128347_("cnt2", 1.0);
                              entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                              entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                              entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                              break;
                           }
                        }

                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.0, entity.getPersistentData().m_128459_("y_power") * 1.0, entity.getPersistentData().m_128459_("z_power") * 1.0));
                        BulletDomainHit2Procedure.execute(world, entity);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") >= (15.0 + var64 * 1.0) * (DUST_AMOUNT + 0.5) && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
                  break label280;
               }
            }

            entity.getPersistentData().m_128379_("Stop", false);
            entity.getPersistentData().m_128347_("cnt1", 0.0);
            entity.getPersistentData().m_128347_("cnt2", 0.0);
            boolean var52 = false;
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
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > 0.0) {
                  var52 = true;
                  entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  entity.m_146922_(entity_a.m_146908_());
                  entity.m_146926_(entity_a.m_146909_());
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            if (!var52 || !entity.m_6084_()) {
               if (entity instanceof FlameArrowEntity) {
                  FlameArrowEntity _datEntSetL = (FlameArrowEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(FlameArrowEntity.DATA_sync, true);
               }

               entity.getPersistentData().m_128347_("cnt3", 1.0);
            }
         }

         entity.getPersistentData().m_128347_("old_x", x);
         entity.getPersistentData().m_128347_("old_y", y);
         entity.getPersistentData().m_128347_("old_z", z);
      }
   }
}
