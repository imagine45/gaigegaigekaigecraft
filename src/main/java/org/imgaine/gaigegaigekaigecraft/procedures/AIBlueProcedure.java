package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.BlackHoleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBlueProcedure {
   public AIBlueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack old_health = ItemStack.f_41583_;
         Entity entity_a = null;
         boolean logic_b = false;
         boolean logic_a = false;
         boolean player = false;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double power_attenuation = 0.0;
         double dis = 0.0;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double z_knockback = 0.0;
         double y_pos = 0.0;
         double y_knockback = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         AIBlueRedProcedure.execute(world, entity);
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
         }

         if (entity instanceof BlackHoleEntity) {
            double var10000;
            label375: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity3 = (LivingEntity)entity;
                  if (_livingEntity3.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity3.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getValue();
                     break label375;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 < 64.0 && entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  label368: {
                     var97 = _livingEntity5.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity4 = (LivingEntity)entity;
                        if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity4.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label368;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var97.m_22100_(Math.min(var10001 + 0.8, 64.0));
               }
            }

            label357: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                     break label357;
                  }
               }

               var10000 = 0.0;
            }

            dis = var10000 * 10.0;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x, y, z, (int)dis, dis * 0.05, dis * 0.05, dis * 0.05, 1.0 + dis * 0.02);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123799_, x, y, z, (int)dis, dis * 0.05, dis * 0.05, dis * 0.05, 1.0 + dis * 0.02);
            }

            if (entity_a instanceof LivingEntity) {
               entity_a.m_20256_(new Vec3(0.0, 0.0, 0.0));
               entity_a.m_6021_(x, y, z);
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.f_8906_.m_9774_(x, y, z, entity_a.m_146908_(), entity_a.m_146909_());
               }
            }
         }

         if (entity.getPersistentData().m_128471_("flag_start")) {
            if (entity.getPersistentData().m_128471_("circle")) {
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && entity_a instanceof LivingEntity && entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                  RotateEntityProcedure.execute((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity);
               }

               entity.m_146922_(entity.m_146908_() + 90.0F);
               entity.m_146926_(entity.m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128379_("free", true);
               GetPowerForwardProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(24.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(24.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(24.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_(), entity);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.4, entity.getPersistentData().m_128459_("y_power") * 0.4, entity.getPersistentData().m_128459_("z_power") * 0.4));
            } else {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.0, entity.getPersistentData().m_128459_("y_power") * 0.0, entity.getPersistentData().m_128459_("z_power") * 0.0));
            }

            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 + CNT6), 0.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_();
            if (entity.getPersistentData().m_128459_("cnt1") % 2.0 == 1.0) {
               int var99;
               label347: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var99 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label347;
                     }
                  }

                  var99 = 0;
               }

               range = (double)Math.min(var99, 30) * 0.0333;
               entity.getPersistentData().m_128347_("BlockRange", Math.min(7.0 * CNT6, entity.getPersistentData().m_128459_("cnt1") * 0.5));
               entity.getPersistentData().m_128347_("BlockDamage", 3.5 * (range + 0.01) * CNT6);
               entity.getPersistentData().m_128379_("noParticle", entity instanceof BlackHoleEntity);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("BlockRange", Math.min(9.0 * CNT6, entity.getPersistentData().m_128459_("cnt1") * 1.0));
               entity.getPersistentData().m_128347_("BlockDamage", 1.5 * (range + 0.01) * CNT6);
               entity.getPersistentData().m_128379_("noParticle", entity instanceof BlackHoleEntity);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            power_attenuation = 1.0;
            logic_b = false;

            for(int index0 = 0; index0 < 5; ++index0) {
               entity.getPersistentData().m_128347_("Range", Math.min(45.0 * power_attenuation * CNT6, 75.0));
               entity.getPersistentData().m_128347_("knockback", Math.max(-5.0 * (1.2 - power_attenuation) * CNT6, -8.0));
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator) {
                     label391: {
                        logic_a = true;
                        if (entityiterator instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                              break label391;
                           }
                        } else if (!(entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                           break label391;
                        }

                        ItemStack var100;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                           var100 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var100 = ItemStack.f_41583_;
                        }

                        old_health = var100.m_41777_();
                        if (entityiterator instanceof Player) {
                           Player _plrCldCheck66 = (Player)entityiterator;
                           if (_plrCldCheck66.m_36335_().m_41519_(old_health.m_41720_())) {
                              break label391;
                           }
                        }

                        if (old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                           CompoundTag var101 = old_health.m_41784_();
                           CompoundTag var102 = entity.getPersistentData();
                           if (var101.m_128459_("skill" + Math.round(var102.m_128459_("skill"))) >= 100.0) {
                              logic_a = false;
                           }
                        }
                     }

                     if (logic_a) {
                        player = entityiterator instanceof Player;
                        x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                        y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                        z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                        dis = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                        if (dis < (double)Math.max(entity.m_20205_(), 1.0F) && entity.getPersistentData().m_128459_("NameRanged_ranged") != entityiterator.getPersistentData().m_128459_("NameRanged")) {
                           x_knockback = 0.0;
                           y_knockback = 0.0;
                           z_knockback = 0.0;
                           if (!(entityiterator instanceof LivingEntity) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                              entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                           }

                           if (!entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                              if ((double)entityiterator.m_20206_() > 0.25) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "scale add pehkui:height -0.025 @s");
                                 }

                                 logic_b = true;
                              }

                              if ((double)entityiterator.m_20205_() > 0.25) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "scale add pehkui:width -0.025 @s");
                                 }

                                 logic_b = true;
                              }
                           }
                        } else {
                           x_knockback = x_knockback / dis * entity.getPersistentData().m_128459_("knockback");
                           y_knockback = y_knockback / dis * entity.getPersistentData().m_128459_("knockback");
                           z_knockback = z_knockback / dis * entity.getPersistentData().m_128459_("knockback");
                           if (!(x_knockback * 1.1 < entityiterator.m_20184_().m_7096_()) && !(x_knockback * 0.9 > entityiterator.m_20184_().m_7096_())) {
                              x_knockback = entityiterator.m_20184_().m_7096_();
                           } else {
                              x_knockback = entityiterator.m_20184_().m_7096_() + x_knockback * 0.05;
                           }

                           if (!(y_knockback * 1.1 < entityiterator.m_20184_().m_7098_()) && !(y_knockback * 0.9 > entityiterator.m_20184_().m_7098_())) {
                              y_knockback = entityiterator.m_20184_().m_7098_();
                           } else {
                              y_knockback = entityiterator.m_20184_().m_7098_() + y_knockback * 0.05;
                           }

                           if (!(z_knockback * 1.1 < entityiterator.m_20184_().m_7094_()) && !(z_knockback * 0.9 > entityiterator.m_20184_().m_7094_())) {
                              z_knockback = entityiterator.m_20184_().m_7094_();
                           } else {
                              z_knockback = entityiterator.m_20184_().m_7094_() + z_knockback * 0.05;
                           }

                           if (entityiterator.m_20096_()) {
                              y_knockback = Math.max(y_knockback, 0.5 * (1.2 - power_attenuation) * CNT6);
                           }
                        }

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
                        if (entity.getPersistentData().m_128459_("NameRanged_ranged") != entityiterator.getPersistentData().m_128459_("NameRanged") && (!(entityiterator instanceof Player) || !((<undefinedtype>)(new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                              } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                 return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                              } else {
                                 return false;
                              }
                           }
                        })).checkGamemode(entityiterator) && !((<undefinedtype>)(new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                              } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                 return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                              } else {
                                 return false;
                              }
                           }
                        })).checkGamemode(entityiterator))) {
                           if (entity_a instanceof LivingEntity && entity_a == entityiterator && entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt114 = (LivingEntity)entity_a;
                              if (_livEnt114.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 continue;
                              }
                           }

                           EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                        }
                     }
                  }
               }

               entity.getPersistentData().m_128347_("knockback", 0.0);
               power_attenuation *= 0.75;
            }

            entity.getPersistentData().m_128347_("Damage", 9.0 * CNT6);
            entity.getPersistentData().m_128347_("Range", 4.0 * CNT6);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (logic_b && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128471_("circle")) {
               if (entity.getPersistentData().m_128459_("cnt1") > 45.0 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") > 30.0 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1)) {
               if (entity instanceof BlackHoleEntity && entity_a instanceof LivingEntity) {
                  label404: {
                     entity_a.getPersistentData().m_128347_("skill", 0.0);
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_a;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                     }

                     if (entity_a instanceof Player && entity_a instanceof Player) {
                        Player _plr = (Player)entity_a;
                        if (_plr.m_150110_().f_35937_) {
                           break label404;
                        }
                     }

                     if (!entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
                        entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "kill @s");
                     }
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (!entity.m_6084_()) {
            if (entity instanceof BlackHoleEntity && entity_a instanceof LivingEntity) {
               label406: {
                  entity_a.getPersistentData().m_128347_("skill", 0.0);
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                  }

                  if (entity_a instanceof Player && entity_a instanceof Player) {
                     Player _plr = (Player)entity_a;
                     if (_plr.m_150110_().f_35937_) {
                        break label406;
                     }
                  }

                  if (!entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
                     entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "kill @s");
                  }
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);

         for(int index1 = 0; index1 < 8; ++index1) {
            x_pos = entity.m_20185_() + (Math.random() - 0.5) * 48.0 * range;
            y_pos = entity.m_20186_() + (Math.random() - 0.5) * 48.0 * range;
            z_pos = entity.m_20189_() + (Math.random() - 0.5) * 48.0 * range;
            x_power = entity.m_20185_() - x_pos;
            y_power = entity.m_20186_() - y_pos;
            z_power = entity.m_20189_() - z_pos;
            dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
            if (dis != 0.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:enchanted_hit ~ ~ ~ " + x_power * 10000.0 + " " + y_power * 10000.0 + " " + z_power * 10000.0 + " 0.001 0 force");
               }
            }
         }

      }
   }
}
