package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityTornadoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AITornadeProcedure {
   public AITornadeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         ItemStack old_health = ItemStack.f_41583_;
         boolean logic_b = false;
         boolean logic_a = false;
         boolean player = false;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double z_knockback = 0.0;
         double z_pos = 0.0;
         double power_attenuation = 0.0;
         double y_knockback = 0.0;
         double num2 = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double yaw = 0.0;
         double height = 0.0;
         if (entity instanceof EntityTornadoEntity) {
            EntityTornadoEntity _datEntSetL = (EntityTornadoEntity)entity;
            _datEntSetL.m_20088_().m_135381_(EntityTornadoEntity.DATA_blue, entity.getPersistentData().m_128459_("skill") >= 3600.0 && entity.getPersistentData().m_128459_("skill") < 3700.0);
         }

         label265: {
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity instanceof EntityTornadoEntity) {
               EntityTornadoEntity _datEntL4 = (EntityTornadoEntity)entity;
               if ((Boolean)_datEntL4.m_20088_().m_135370_(EntityTornadoEntity.DATA_blue)) {
                  if (entity instanceof EntityTornadoEntity) {
                     EntityTornadoEntity animatable = (EntityTornadoEntity)entity;
                     animatable.setTexture("tornado_blue");
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt2") > 60.0 && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  double var10000;
                  label230: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity10 = (LivingEntity)entity;
                        if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity10.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label230;
                        }
                     }

                     var10000 = 0.0;
                  }

                  if (var10000 < 6.0 + entity.getPersistentData().m_128459_("cnt6") && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entity;
                     if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        double var10001;
                        label223: {
                           var84 = _livingEntity14.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity12 = (LivingEntity)entity;
                              if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity12.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                 break label223;
                              }
                           }

                           var10001 = 0.0;
                        }

                        var84.m_22100_(Math.min(var10001 + 0.2 * CNT6, 6.0 + entity.getPersistentData().m_128459_("cnt6")));
                     }
                  }

                  entity.getPersistentData().m_128347_("BlockRange", (double)(2.0F + 2.0F * entity.m_20205_()) * 0.5);
                  entity.getPersistentData().m_128347_("BlockDamage", 0.2 * CNT6);
                  BlockDestroyAllDirectionProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * 0.5, z, entity);
                  BulletDomainHit2Procedure.execute(world, entity);
                  power_attenuation = 1.0;
                  logic_b = false;

                  for(int index0 = 0; index0 < 5; ++index0) {
                     entity.getPersistentData().m_128347_("Range", Math.min(30.0 * power_attenuation * CNT6, 50.0));
                     entity.getPersistentData().m_128347_("knockback", Math.max(-2.5 * (1.2 - power_attenuation) * CNT6, -5.0));
                     Vec3 _center = new Vec3(x, entity.m_20186_() + (double)entity.m_20206_() * 0.5, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator) {
                           label254: {
                              logic_a = true;
                              if (entityiterator instanceof Player) {
                                 if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                                    break label254;
                                 }
                              } else if (!(entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                                 break label254;
                              }

                              ItemStack var85;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                 var85 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var85 = ItemStack.f_41583_;
                              }

                              old_health = var85.m_41777_();
                              if (entityiterator instanceof Player) {
                                 Player _plrCldCheck29 = (Player)entityiterator;
                                 if (_plrCldCheck29.m_36335_().m_41519_(old_health.m_41720_())) {
                                    break label254;
                                 }
                              }

                              if (old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                 CompoundTag var86 = old_health.m_41784_();
                                 CompoundTag var87 = entity.getPersistentData();
                                 if (var86.m_128459_("skill" + Math.round(var87.m_128459_("skill"))) >= 100.0) {
                                    logic_a = false;
                                 }
                              }
                           }

                           if (logic_a) {
                              player = entityiterator instanceof Player;
                              x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                              y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                              z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                              num2 = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                              if (!(num2 < (double)Math.max(entity.m_20205_(), 1.0F)) || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged")) {
                                 x_knockback = x_knockback / num2 * entity.getPersistentData().m_128459_("knockback");
                                 y_knockback = y_knockback / num2 * entity.getPersistentData().m_128459_("knockback");
                                 z_knockback = z_knockback / num2 * entity.getPersistentData().m_128459_("knockback");
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
                                 if (player) {
                                    if (entity_a == entityiterator || !world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
                                       continue;
                                    }

                                    if (entityiterator instanceof Player) {
                                       Player _plr = (Player)entityiterator;
                                       if (_plr.m_150110_().f_35937_) {
                                          continue;
                                       }
                                    }

                                    if (((<undefinedtype>)(new Object() {
                                       public boolean checkGamemode(Entity _ent) {
                                          if (_ent instanceof ServerPlayer _serverPlayer) {
                                             return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                                          } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                             return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                                          } else {
                                             return false;
                                          }
                                       }
                                    })).checkGamemode(entityiterator)) {
                                       continue;
                                    }
                                 } else if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged")) {
                                    continue;
                                 }

                                 EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                              }
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("knockback", 0.0);
                     power_attenuation *= 0.75;
                  }

                  entity.getPersistentData().m_128347_("Damage", 11.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", 1.0);
                  entity.getPersistentData().m_128347_("y_knockback", 1.0 * CNT6);
                  break label265;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
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
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     entity.m_6021_(entity_a.m_20185_(), entity_a.m_20186_() - (double)entity.m_20206_(), entity_a.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_(), entity_a.m_20186_() - (double)entity.m_20206_(), entity_a.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                     if (entity_a.getPersistentData().m_128459_("skill") <= 0.0) {
                        entity.getPersistentData().m_128347_("cnt2", 1.0);
                     }

                     if (!entity.m_6084_()) {
                        entity_a.getPersistentData().m_128347_("skill", 0.0);
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                  }

                  if (!entity_a.m_6084_() && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt2", 1.0);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt2") > 25.0 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               BulletDomainHit2Procedure.execute(world, entity);
            }

            entity.getPersistentData().m_128347_("Damage", 11.0 * CNT6);
            entity.getPersistentData().m_128347_("knockback", 1.0);
            entity.getPersistentData().m_128347_("y_knockback", 0.15 * CNT6);
         }

         entity.getPersistentData().m_128347_("Range", (double)(2.0F + 2.0F * entity.m_20205_()));
         RangeAttackProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * 0.5, z, entity);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.7F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.7F, false);
            }
         }

         for(int index1 = 0; index1 < (int)(4.0F * entity.m_20206_()); ++index1) {
            double var88;
            double var10006;
            double var10008;
            double var10010;
            String var10011;
            label140: {
               yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), 0.0, 360.0));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = Mth.m_216263_(RandomSource.m_216327_(), 0.5, 1.0);
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               double var70 = entity.m_20186_() + Math.sin(pitch) * -1.0 * distance * (double)entity.m_20205_();
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               y_pos = var70 + (distance - 0.5) * 2.0 * (double)entity.m_20206_();
               var88 = (double)entity.m_20205_() * 0.25;
               var10006 = x_pos + Math.cos(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               var10008 = y_pos + Math.sin(pitch) * -1.0 * distance * (double)entity.m_20205_();
               var10010 = z_pos + Math.sin(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               if (entity instanceof EntityTornadoEntity) {
                  EntityTornadoEntity _datEntL123 = (EntityTornadoEntity)entity;
                  if ((Boolean)_datEntL123.m_20088_().m_135370_(EntityTornadoEntity.DATA_blue)) {
                     var10011 = "minecraft:cloud";
                     break label140;
                  }
               }

               var10011 = "minecraft:squid_ink";
            }

            ParticleGeneratorProcedure.execute(world, var88, 1.0, 0.0, 1.0, x_pos, var10006, y_pos, var10008, z_pos, var10010, var10011);
         }

      }
   }
}
