package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillBoogieWoogieProcedure {
   public SkillBoogieWoogieProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         boolean hasCursePower = false;
         boolean SUCCESS = false;
         boolean player = false;
         boolean logic_ = false;
         Entity entity_a = null;
         player = entity instanceof Player;
         SUCCESS = false;
         if (!player) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().m_128459_("Damage") > 0.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (!((Entity)var10000).getPersistentData().m_128471_("attack")) {
                        SUCCESS = true;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        targetUUID = ((Entity)var10000).m_20149_();
                     }
                  }
               }
            }
         }

         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entity != entityiterator) {
               logic_ = LogicAttackProcedure.execute(world, entity, entityiterator);
               if (logic_ && entityiterator.getPersistentData().m_128459_("skill") != 0.0 && entityiterator.getPersistentData().m_128459_("Damage") > 0.0) {
                  entityiterator.getPersistentData().m_128379_("betrayal", true);
                  if (!player && !SUCCESS && !entityiterator.getPersistentData().m_128471_("attack")) {
                     SUCCESS = true;
                     targetUUID = entityiterator.m_20149_();
                  }
               }

               double var84;
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var84 = _projEnt.m_20184_().m_82553_();
               } else {
                  var84 = 0.0;
               }

               if (var84 != 0.0 && entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  if (entity instanceof LivingEntity) {
                     _projEnt.m_5602_((LivingEntity)entity);
                  }
               }

               if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || !logic_) {
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var84 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var84 = 0.0;
                  }

                  if (!(var84 > 0.0)) {
                     continue;
                  }
               }

               if (!entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                  targetUUID = entityiterator.m_20149_();
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
                  }).apply(world, entityiterator.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity_a instanceof LivingEntity) {
                     label301: {
                        if (entity_a instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0 || ((<undefinedtype>)(new Object() {
                              public boolean checkGamemode(Entity _ent) {
                                 if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                                 } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                    return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                                 } else {
                                    return false;
                                 }
                              }
                           })).checkGamemode(entity_a) || ((<undefinedtype>)(new Object() {
                              public boolean checkGamemode(Entity _ent) {
                                 if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                                 } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                    return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                                 } else {
                                    return false;
                                 }
                              }
                           })).checkGamemode(entity_a)) {
                              break label301;
                           }
                        } else if (entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                           break label301;
                        }

                        SUCCESS = true;
                        targetUUID = entityiterator.getPersistentData().m_128461_("OWNER_UUID");
                     }
                  }

                  entityiterator.getPersistentData().m_128359_("OWNER_UUID", "");
                  entityiterator.getPersistentData().m_128379_("betrayal", true);
               }
            }
         }

         if (!SUCCESS) {
            _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(4.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entityiterator.getPersistentData().m_128459_("skill") != 0.0 && entityiterator.getPersistentData().m_128471_("attack") && entityiterator.getPersistentData().m_128471_("PRESS_Z")) {
                  if (entityiterator instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0 || ((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entityiterator) || ((<undefinedtype>)(new Object() {
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
                  } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                     continue;
                  }

                  if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                        entityiterator.getPersistentData().m_128347_("cnt6", 0.0);
                     }

                     SUCCESS = true;
                     targetUUID = entityiterator.m_20149_();
                     break;
                  }
               }
            }
         }

         if (player && !SUCCESS) {
            dis = 32.0;

            for(int index0 = 0; index0 < 6; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
               List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
               Iterator entityiterator = _entfound.iterator();

               label259: {
                  Entity entityiterator;
                  while(true) {
                     if (!entityiterator.hasNext()) {
                        break label259;
                     }

                     entityiterator = (Entity)entityiterator.next();
                     if (entity != entityiterator) {
                        if (entityiterator instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower != 0.0 && !((<undefinedtype>)(new Object() {
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
                           })).checkGamemode(entityiterator)) {
                              break;
                           }
                        } else if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                           break;
                        }
                     }
                  }

                  SUCCESS = true;
                  targetUUID = entityiterator.m_20149_();
               }

               dis -= 4.0;
               if (SUCCESS) {
                  break;
               }
            }
         }

         if (player || SUCCESS) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity58 = (LivingEntity)entity;
               if (_livingEntity58.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity58.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-17.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(1.0F + entity.m_20205_()))), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(1.0F + entity.m_20205_()))), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(1.0F + entity.m_20205_()))), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_(), 1, 0.1, 0.1, 0.1, 0.2);
            }

            _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(12.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  entityiterator.getPersistentData().m_128347_("cnt_target", -5.0);
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }
               }
            }
         }

         if (SUCCESS) {
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
            }).apply(world, targetUUID);
            if (entity_a instanceof LivingEntity) {
               label325: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt73 = (LivingEntity)entity;
                     if (_livEnt73.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt74 = (LivingEntity)entity_a;
                           if (_livEnt74.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label325;
                           }
                        }

                        int var86;
                        label217: {
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity_a;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                 var86 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                 break label217;
                              }
                           }

                           var86 = 0;
                        }

                        if (var86 > 0) {
                           break label325;
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt76 = (LivingEntity)entity;
                     if (_livEnt76.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        return;
                     }
                  }

                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt77 = (LivingEntity)entity_a;
                     if (_livEnt77.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        return;
                     }
                  }
               }

               entity.m_8127_();
               entity_a.m_8127_();
               entity_a.getPersistentData().m_128379_("betrayal", true);
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
               }

               entity_a.getPersistentData().m_128347_("cnt_target", -5.0);
               x_pos = entity_a.m_20185_();
               y_pos = entity_a.m_20186_();
               z_pos = entity_a.m_20189_();
               entity_a.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_a.m_146908_(), entity_a.m_146909_());
               }

               entity.m_6021_(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
               }

               entity.m_146922_(entity.m_146908_() + 180.0F);
               entity.m_146926_(entity.m_146909_() * -1.0F);
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
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 15, 9, false, false));
                  }
               }

               if (!player) {
                  entity.getPersistentData().m_128347_("cnt_boogie_woogie", -40.0);
               }
            }
         }

      }
   }
}
