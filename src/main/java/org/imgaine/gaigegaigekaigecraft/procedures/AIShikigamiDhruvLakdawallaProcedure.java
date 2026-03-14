package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AIShikigamiDhruvLakdawallaProcedure {
   public AIShikigamiDhruvLakdawallaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logicStart = false;
         boolean placed = false;
         Entity owner_uuid = null;
         double distance = 0.0;
         double level = 0.0;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double x_pos = 0.0;
         double tick = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
               }
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               if (entity.getPersistentData().m_128459_("skill") <= 0.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 10, 0.25, 0.25, 0.25, 0.0);
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            } else {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof ShikigamiPterosaurEntity) {
                  AIActiveFlyingProcedure.execute(world, entity);
               } else if (entity instanceof ShikigamiHeterocephalusGlaberEntity) {
                  double var10000;
                  label225: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity5 = (LivingEntity)entity;
                        if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity5.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label225;
                        }
                     }

                     var10000 = 0.0;
                  }

                  if (var10000 < 6.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity7 = (LivingEntity)entity;
                        if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           double var10001;
                           label217: {
                              var57 = _livingEntity7.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity6 = (LivingEntity)entity;
                                 if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    var10001 = _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                    break label217;
                                 }
                              }

                              var10001 = 0.0;
                           }

                           var57.m_22100_(Math.min(var10001 + 0.1, 6.0));
                        }
                     }

                     entity.m_274367_((float)((double)entity.getStepHeight() + 0.01));
                  }
               }

               double var60;
               label208: {
                  NUM1 = (double)(2L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.5));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity11 = (LivingEntity)entity;
                     if (_livingEntity11.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var60 = _livingEntity11.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label208;
                     }
                  }

                  var60 = 0.0;
               }

               label203: {
                  NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var60 * 3.0) / 4.0, 3.0)));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.m_21023_(MobEffects.f_19600_)) {
                        break label203;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)NUM1, false, false));
                     }
                  }
               }

               int var58;
               label198: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                        var58 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                        break label198;
                     }
                  }

                  var58 = 0;
               }

               if ((double)var58 < NUM2 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)NUM2, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 1.0) {
               AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_x", -100.0);
               if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                  if (entity.getPersistentData().m_128459_("continue") > 0.0) {
                     entity.getPersistentData().m_128347_("continue", entity.getPersistentData().m_128459_("continue") - 1.0);
                     entity.getPersistentData().m_128347_("skill", 1.0);
                  }

                  ResetCounterProcedure.execute(entity);
               }
            } else {
               LivingEntity var59;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var59 = _mobEnt.m_5448_();
               } else {
                  var59 = null;
               }

               if (var59 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     if (entity instanceof ShikigamiPterosaurEntity) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("cnt_x", -50.0);
                        entity.getPersistentData().m_128347_("skill", 1.0);
                        entity.getPersistentData().m_128347_("continue", (double)(Math.random() < 0.75 ? 1 : 0));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
               }
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               placed = true;
            } else if (entity.getPersistentData().m_128459_("skill") > 0.0) {
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 15.0) {
                  placed = true;
               }
            } else if (entity.getPersistentData().m_128459_("skill") == 0.0 && Math.random() < 0.1) {
               placed = true;
            }

            if (placed) {
               x_pos = x + (Math.random() - 0.5) * (double)entity.m_20205_() * 0.5;
               y_pos = y + Math.random() * (double)entity.m_20205_() * 0.5;
               z_pos = z + (Math.random() - 0.5) * (double)entity.m_20205_() * 0.5;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:domain keep");
               }

               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60734_() == JujutsucraftModBlocks.DOMAIN.get()) {
                  if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
                     if (!world.m_5776_()) {
                        BlockPos _bp = BlockPos.m_274561_(x_pos, y_pos, z_pos);
                        BlockEntity _blockEntity = world.m_7702_(_bp);
                        BlockState _bs = world.m_8055_(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           _level.m_7260_(_bp, _bs, _bs, 3);
                        }
                     }
                  } else if (!world.m_5776_()) {
                     BlockPos _bp = BlockPos.m_274561_(x_pos, y_pos, z_pos);
                     BlockEntity _blockEntity = world.m_7702_(_bp);
                     BlockState _bs = world.m_8055_(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.m_7260_(_bp, _bs, _bs, 3);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128471_("Shikigami")) {
            owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if (owner_uuid instanceof LivingEntity) {
               LivingEntity _livEnt67 = (LivingEntity)owner_uuid;
               if (_livEnt67.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         }

      }
   }
}
