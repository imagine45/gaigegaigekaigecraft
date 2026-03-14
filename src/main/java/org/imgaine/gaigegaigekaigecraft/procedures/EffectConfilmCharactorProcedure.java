package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TruckEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectConfilmCharactorProcedure {
   public EffectConfilmCharactorProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         Entity entity_b = null;
         String STR1 = "";
         double strength_lv_iterator = 0.0;
         double old_skill = 0.0;
         double old_health = 0.0;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double old_damage = 0.0;
         double NUM1 = 0.0;
         double strength_lv = 0.0;
         if (entityiterator instanceof LivingEntity) {
            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().m_128471_("Ambush") && entity.getPersistentData().m_128459_("friend_num") != entityiterator.getPersistentData().m_128459_("friend_num2")) {
               label393: {
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0) {
                        break label393;
                     }
                  } else if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                     break label393;
                  }

                  entityiterator.getPersistentData().m_128379_("failed_adjustment", true);
               }
            }

            label381: {
               label382: {
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
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                        break label382;
                     }
                  }

                  if (!(entity_b instanceof LivingEntity) || !(entity_b instanceof LivingEntity)) {
                     break label381;
                  }

                  LivingEntity _livEnt12 = (LivingEntity)entity_b;
                  if (!_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     break label381;
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
               }

               entity.getPersistentData().m_128379_("ignore", true);
               if (entity instanceof TruckEntity && (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt19 = (LivingEntity)entityiterator;
               if (_livEnt19.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
                     entity.getPersistentData().m_128379_("Stop", true);
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt24 = (LivingEntity)entity;
                     if (_livEnt24.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity.getPersistentData().m_128471_("attack")) {
                        double var10000;
                        label333: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()).m_19564_();
                                 break label333;
                              }
                           }

                           var10000 = 0.0;
                        }

                        label328: {
                           NUM1 = var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19564_();
                                 break label328;
                              }
                           }

                           var10000 = 0.0;
                        }

                        label323: {
                           NUM2 = var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19557_();
                                 break label323;
                              }
                           }

                           var10000 = 0.0;
                        }

                        NUM3 = var10000;
                        NUM2 = (double)Math.round(NUM2 - Math.ceil((NUM1 + 8.0) / 8.0));
                        NUM1 = (double)Math.round(NUM1 - Math.ceil((NUM1 + 8.0) / 8.0));
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }

                        if (NUM2 >= 0.0 && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), (int)NUM3, (int)NUM2));
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123808_, x, y, z, 10, 0.5, 0.5, 0.5, 1.0);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > 100.0) {
               label400: {
                  if (entity instanceof Player) {
                     Player _plrCldCheck34 = (Player)entity;
                     ItemCooldowns var80 = _plrCldCheck34.m_36335_();
                     ItemStack var10001;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                        var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (var80.m_41519_(var10001.m_41720_())) {
                        break label400;
                     }
                  }

                  ItemStack var81;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                     var81 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var81 = ItemStack.f_41583_;
                  }

                  if (var81.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                        var81 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var81 = ItemStack.f_41583_;
                     }

                     if (var81.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                        break label400;
                     }
                  }

                  if (entityiterator instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                        break label400;
                     }
                  } else if (!(entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) && !(entityiterator instanceof CursedSpiritGrade010Entity)) {
                     break label400;
                  }

                  CompoundTag var83 = entity.getPersistentData();
                  STR1 = "skill" + Math.round(var83.m_128459_("skill"));
                  ItemStack var84;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                     var84 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var84 = ItemStack.f_41583_;
                  }

                  if (var84.m_41784_().m_128459_(STR1) >= 100.0) {
                     old_skill = entityiterator.getPersistentData().m_128459_("skill");
                     old_damage = entityiterator.getPersistentData().m_128459_("Damage");
                     entityiterator.getPersistentData().m_128347_("skill", 0.0);
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var93 = new MobEffectInstance;
                           MobEffect var10003 = (MobEffect)JujutsucraftModMobEffects.GUARD.get();
                           ItemStack var10005;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                              var10005 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10005 = ItemStack.f_41583_;
                           }

                           var93.<init>(var10003, 1, (int)Math.round(Math.floor(var10005.m_41784_().m_128459_(STR1) / 100.0)), false, false);
                           _entity.m_7292_(var93);
                        }
                     }

                     entityiterator.getPersistentData().m_128347_("skill", old_skill);
                     entityiterator.getPersistentData().m_128347_("Damage", Math.max(entityiterator.getPersistentData().m_128459_("Damage"), old_damage));
                     double var85;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var85 = (double)_livEnt.m_21223_();
                     } else {
                        var85 = -1.0;
                     }

                     old_health = var85;
                     entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), 0.01F);
                     float var94;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var94 = _livEnt.m_21223_();
                     } else {
                        var94 = -1.0F;
                     }

                     if (old_health != (double)var94) {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_just")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_just")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                           }
                        }
                     }
                  }
               }
            }

            int var86;
            label290: {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entityiterator;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var86 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label290;
                  }
               }

               var86 = 0;
            }

            if (var86 <= 3 && !(entityiterator instanceof Player)) {
               label283: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var87 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label283;
                     }
                  }

                  var87 = 0.0;
               }

               label278: {
                  strength_lv = var87;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var88 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label278;
                     }
                  }

                  var88 = 0.0;
               }

               strength_lv_iterator = var88;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity64 = (LivingEntity)entity;
                  if (_livingEntity64.m_21204_().m_22171_(Attributes.f_22281_)) {
                     double var95;
                     label271: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity65 = (LivingEntity)entity;
                           if (_livingEntity65.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var95 = _livingEntity65.getAttribute_(Attributes.f_22281_).m_22115_();
                              break label271;
                           }
                        }

                        var95 = 0.0;
                     }

                     strength_lv += var95 * 0.333;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity66 = (LivingEntity)entity;
                  if (_livingEntity66.m_21204_().m_22171_(Attributes.f_22281_)) {
                     double var96;
                     label260: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livingEntity67 = (LivingEntity)entityiterator;
                           if (_livingEntity67.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var96 = _livingEntity67.getAttribute_(Attributes.f_22281_).m_22115_();
                              break label260;
                           }
                        }

                        var96 = 0.0;
                     }

                     strength_lv_iterator += var96 * 0.333;
                  }
               }

               if (strength_lv >= strength_lv_iterator + 2.0) {
                  if (!entity.getPersistentData().m_128471_("ignore")) {
                     double var89 = strength_lv_iterator + 1.0;
                     int var97;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var97 = _livEnt.m_21230_();
                     } else {
                        var97 = 0;
                     }

                     strength_lv_iterator = var89 + (double)(var97 / 60);
                  }

                  label249: {
                     label390: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt70 = (LivingEntity)entityiterator;
                           if (_livEnt70.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label390;
                           }
                        }

                        if (!entityiterator.getPersistentData().m_128471_("attack") || !(entityiterator.getPersistentData().m_128459_("Damage") > 0.0)) {
                           NUM1 = 3.0;
                           break label249;
                        }
                     }

                     NUM1 = 6.0;
                  }

                  NUM1 *= 1.0 + strength_lv_iterator * 0.33;
                  if (entity.getPersistentData().m_128459_("Damage") >= NUM1 * 10.0) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_(MobEffects.f_19606_);
                     }

                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                     }
                  }

                  if (strength_lv >= strength_lv_iterator * 2.0 && strength_lv >= strength_lv_iterator + 10.0) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_(MobEffects.f_19606_);
                     }

                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                     }
                  }
               }
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

            if (var90 == entityiterator) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               if (!((Entity)var90).m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt_target", 0.0);
               }
            }
         }

      }
   }
}
