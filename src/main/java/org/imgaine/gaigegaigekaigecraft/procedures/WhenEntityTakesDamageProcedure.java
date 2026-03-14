package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.BulletBallProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenEntityTakesDamageProcedure {
   public WhenEntityTakesDamageProcedure() {
   }

   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getSource(), event.getEntity(), event.getSource().m_7640_(), event.getSource().m_7639_(), (double)event.getAmount());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
      execute((Event)null, world, damagesource, entity, immediatesourceentity, sourceentity, amount);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
      if (damagesource != null && entity != null && immediatesourceentity != null && sourceentity != null) {
         ItemStack mainHandItem = ItemStack.f_41583_;
         Entity entity_a = null;
         double old_health = 0.0;
         double NUM2 = 0.0;
         double old_cooldown = 0.0;
         double NUM1 = 0.0;
         double Damage_amount = 0.0;
         boolean cancel = false;
         boolean changeDamage = false;
         boolean logic_a = false;
         boolean guard = false;
         boolean critical_nanami = false;
         boolean use_curse = false;
         boolean critical_ice = false;
         if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation")))) {
            if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move"))) && LogicStartPassiveProcedure.execute(entity)) {
               label865: {
                  NUM1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                  NUM2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                  if (NUM1 == 38.0 || NUM2 == 38.0 || entity instanceof UroTakakoEntity) {
                     label863: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt4 = (LivingEntity)entity;
                           if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label863;
                           }
                        }

                        if (sourceentity.m_20205_() + sourceentity.m_20206_() <= (entity.m_20205_() + entity.m_20206_()) * 4.0F && entity instanceof LivingEntity) {
                           LivingEntity _livEnt9 = (LivingEntity)entity;
                           if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              cancel = true;
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        break label865;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                        int var10000;
                        label784: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                 var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                 break label784;
                              }
                           }

                           var10000 = 0;
                        }

                        if (var10000 > 0) {
                           cancel = true;
                        }
                     }
                  }
               }
            }

            if (cancel) {
               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            } else if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) && !damagesource.m_276093_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))) {
               cancel = false;
               LivingEntity var119;
               if (sourceentity instanceof Mob) {
                  Mob _mobEnt = (Mob)sourceentity;
                  var119 = _mobEnt.m_5448_();
               } else {
                  var119 = null;
               }

               if (var119 instanceof LivingEntity) {
                  if (sourceentity instanceof Mob) {
                     Mob _mobEnt = (Mob)sourceentity;
                     var119 = _mobEnt.m_5448_();
                  } else {
                     var119 = null;
                  }

                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  if (var119 == var10001) {
                     cancel = true;
                  }
               }

               if (!cancel) {
                  label842: {
                     label814: {
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           if (_tamEnt.m_21824_()) {
                              break label814;
                           }
                        }

                        if (!(sourceentity instanceof TamableAnimal)) {
                           break label842;
                        }

                        TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                        if (!_tamEnt.m_21824_()) {
                           break label842;
                        }
                     }

                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var119 = _tamEnt.m_269323_();
                     } else {
                        var119 = null;
                     }

                     if (var119 != sourceentity) {
                        if (sourceentity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                           var119 = _tamEnt.m_269323_();
                        } else {
                           var119 = null;
                        }

                        if (var119 != entity) {
                           if (entity instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)entity;
                              var119 = _tamEnt.m_269323_();
                           } else {
                              var119 = null;
                           }

                           LivingEntity var140;
                           if (sourceentity instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                              var140 = _tamEnt.m_269323_();
                           } else {
                              var140 = null;
                           }

                           if (var119 != var140) {
                              break label842;
                           }
                        }
                     }

                     cancel = true;
                  }
               }

               if (!world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP) && (sourceentity instanceof Player || sourceentity.getPersistentData().m_128471_("Player")) && (entity instanceof Player || entity.getPersistentData().m_128471_("Player"))) {
                  label868: {
                     label817: {
                        cancel = true;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt34 = (LivingEntity)entity;
                           if (_livEnt34.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label817;
                           }
                        }

                        if (!(sourceentity instanceof LivingEntity)) {
                           break label868;
                        }

                        LivingEntity _livEnt35 = (LivingEntity)sourceentity;
                        if (!_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label868;
                        }
                     }

                     cancel = false;
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var119 = _mobEnt.m_5448_();
               } else {
                  var119 = null;
               }

               label870: {
                  if (var119 != sourceentity || !(entity.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                     if (sourceentity instanceof Mob) {
                        Mob _mobEnt = (Mob)sourceentity;
                        var119 = _mobEnt.m_5448_();
                     } else {
                        var119 = null;
                     }

                     if (var119 != entity || !(sourceentity.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                        break label870;
                     }
                  }

                  cancel = false;
               }

               if (!cancel) {
                  if (sourceentity.getPersistentData().m_128459_("friend_num") != 0.0 && sourceentity.getPersistentData().m_128459_("friend_num") == entity.getPersistentData().m_128459_("friend_num")) {
                     cancel = true;
                  }

                  if (damagesource.m_276093_(DamageTypes.f_268566_) || damagesource.m_276093_(DamageTypes.f_268464_)) {
                     label864: {
                        label821: {
                           if (sourceentity instanceof LivingEntity) {
                              LivingEntity _livEnt47 = (LivingEntity)sourceentity;
                              if (_livEnt47.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt48 = (LivingEntity)sourceentity;
                                 if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                    break label821;
                                 }
                              }
                           }

                           label702: {
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)sourceentity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    var126 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                                    break label702;
                                 }
                              }

                              var126 = 0;
                           }

                           if (var126 <= 0 && !(sourceentity.getPersistentData().m_128459_("skill") <= -999.0)) {
                              break label864;
                           }
                        }

                        cancel = true;
                     }
                  }

                  label694: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt51 = (LivingEntity)entity;
                        if (_livEnt51.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           break label694;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt52 = (LivingEntity)entity;
                        if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                           label687: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                    var127 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                    break label687;
                                 }
                              }

                              var127 = 0;
                           }

                           if (var127 > 0) {
                              cancel = true;
                           }
                        }
                     }
                  }

                  if (immediatesourceentity instanceof BulletBallProjectileEntity) {
                     cancel = true;
                  }

                  if (entity instanceof DomainExpansionEntityEntity) {
                     cancel = true;
                  }
               }

               if (cancel) {
                  if (event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               } else {
                  double var128;
                  if (immediatesourceentity instanceof Projectile) {
                     Projectile _projEnt = (Projectile)immediatesourceentity;
                     var128 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var128 = 0.0;
                  }

                  if (var128 == 0.0) {
                     logic_a = sourceentity.getPersistentData().m_128471_("attack");
                     sourceentity.getPersistentData().m_128379_("attack", true);
                     CursedToolsAbilityProcedure.execute(sourceentity, entity);
                     sourceentity.getPersistentData().m_128379_("attack", logic_a);
                  }
               }
            }
         }

         if (ModList.get().isLoaded("minepiece") && damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse")))) {
            cancel = true;
         }

         if (!cancel && !damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation"))) && !damagesource.m_276093_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))) {
            Damage_amount = amount;
            ItemStack var129;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               var129 = _livEnt.m_21205_();
            } else {
               var129 = ItemStack.f_41583_;
            }

            mainHandItem = var129.m_41777_();
            if (!sourceentity.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || sourceentity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0)) {
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
               }).apply(world, sourceentity.getPersistentData().m_128461_("OWNER_UUID"));
            }

            if (!(entity_a instanceof LivingEntity)) {
               entity_a = sourceentity;
            }

            CounterProcedure.execute(entity);
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               var129 = _livEnt.m_21205_();
            } else {
               var129 = ItemStack.f_41583_;
            }

            SetAttributeMainhandProcedure.execute(var129);
            if ((damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) || damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat")))) && !sourceentity.getPersistentData().m_128471_("attack")) {
               if (mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_() && mainHandItem.m_41784_().m_128441_("CursePower") && mainHandItem.m_41784_().m_128459_("CursePower") != 0.0) {
                  use_curse = true;
               }
            } else if (!damagesource.m_276093_(DamageTypes.f_268534_)) {
               label656: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt76 = (LivingEntity)entity;
                     if (_livEnt76.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                        break label656;
                     }
                  }

                  CursedToolsAbilityProcedure.execute(sourceentity, entity);
                  EffectAttackProcedure.execute(world, entity, sourceentity);
               }

               if (mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                  if (mainHandItem.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     Damage_amount = 1.0;
                     changeDamage = true;
                  }

                  if (mainHandItem.m_41720_() == JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
                     changeDamage = true;
                  }

                  if (mainHandItem.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                     Damage_amount *= 1.25;
                     changeDamage = true;
                  }
               }

               if (mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_() && mainHandItem.m_41784_().m_128441_("CursePower")) {
                  if (mainHandItem.m_41784_().m_128459_("CursePower") > 0.0) {
                     Damage_amount *= 1.0 + Math.abs(mainHandItem.m_41784_().m_128459_("CursePower")) * 0.02;
                     changeDamage = true;
                     use_curse = true;
                  } else if (mainHandItem.m_41784_().m_128459_("CursePower") < 0.0 && entity.getPersistentData().m_128471_("CursedSpirit")) {
                     label644: {
                        if (mainHandItem.m_41720_() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && sourceentity instanceof Player) {
                           Player _plrCldCheck89 = (Player)sourceentity;
                           if (_plrCldCheck89.m_36335_().m_41519_(mainHandItem.m_41720_())) {
                              break label644;
                           }
                        }

                        Damage_amount *= 1.0 + Math.abs(mainHandItem.m_41784_().m_128459_("CursePower")) * 0.2;
                     }

                     changeDamage = true;
                     use_curse = true;
                  }
               }

               label638: {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)sourceentity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                        var131 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).m_19564_();
                        break label638;
                     }
                  }

                  var131 = 0;
               }

               if (var131 >= 1 && entity instanceof LivingEntity) {
                  LivingEntity _livEnt92 = (LivingEntity)entity;
                  if (_livEnt92.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get());
                     }

                     Damage_amount *= 2.0;
                     critical_nanami = true;
                     changeDamage = true;
                  }
               }

               if (entity.m_146889_() * 100.0F >= 5.0F) {
                  entity.m_146917_(0);
                  Damage_amount *= 1.5;
                  critical_ice = true;
                  changeDamage = true;
               }
            }

            if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) && LogicGuardSuccessProcedure.execute(entity, sourceentity)) {
               Damage_amount = Math.max(Damage_amount - entity.getPersistentData().m_128459_("Damage"), 0.01);
               changeDamage = true;
               guard = true;
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _livEnt102 = (LivingEntity)entity_a;
               if (_livEnt102.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity instanceof LivingEntity) {
                  LivingEntity _livEnt103 = (LivingEntity)entity;
                  if (_livEnt103.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                     label627: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var132 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                              break label627;
                           }
                        }

                        var132 = 0;
                     }

                     if (var132 > 0) {
                        int var10002;
                        label621: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label621;
                              }
                           }

                           var10002 = 0;
                        }

                        NUM1 = 15.0 * (1.0 + (double)var10002 * 0.33);
                        if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || sourceentity.getPersistentData().m_128471_("DomainAttack")) {
                           Damage_amount = Math.max(Damage_amount - NUM1, 0.0);
                        }

                        if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           sourceentity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse"))), entity), (float)NUM1);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128471_("CursedSpirit") && !use_curse) {
               label853: {
                  if (sourceentity instanceof Player) {
                     if (!(((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer < 100.0) || LogicUseMinePieceProcedure.execute(sourceentity)) {
                        break label853;
                     }
                  } else if (!sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                     break label853;
                  }

                  Damage_amount = 0.01;
                  changeDamage = true;
               }
            }

            label828: {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 15.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 15.0) {
                     break label828;
                  }
               } else if (!(entity instanceof MahitoEntity)) {
                  break label828;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt116 = (LivingEntity)entity;
                  if (_livEnt116.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label828;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt117 = (LivingEntity)entity;
                  if (_livEnt117.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     break label828;
                  }
               }

               if (entity_a instanceof Player) {
                  if (entity_a instanceof ServerPlayer) {
                     ServerPlayer _plr119 = (ServerPlayer)entity_a;
                     if (_plr119.m_9236_() instanceof ServerLevel && _plr119.m_8960_().m_135996_(_plr119.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:observation_of_the_soul"))).m_8193_()) {
                        break label828;
                     }
                  }
               } else if (entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:soul_perception")))) {
                  break label828;
               }

               if (!sourceentity.getPersistentData().m_128471_("ignore")) {
                  Damage_amount *= 0.5;
                  changeDamage = true;
               }
            }

            if (sourceentity.getPersistentData().m_128471_("ignore")) {
               changeDamage = true;
            }

            if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) && entity instanceof Player && (entity_a.getPersistentData().m_128471_("jjkChara") || entity_a instanceof Player)) {
               Damage_amount *= GetDifficultyLevelProcedure.execute(world);
               changeDamage = true;
            }

            if (sourceentity.getPersistentData().m_128471_("ignore") && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.IGNORE_GUARD.get(), 1, 0, false, false));
               }
            }

            double var133;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var133 = (double)_livEnt.m_21223_();
            } else {
               var133 = -1.0;
            }

            old_health = var133;
            if (Damage_amount > 0.0) {
               if (ModList.get().isLoaded("minepiece")) {
                  entity.m_6469_(damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) ? new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat"))), entity_a) : new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse"))), entity_a), (float)Damage_amount);
               } else {
                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat"))), entity_a), (float)Damage_amount);
               }
            }

            old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            float var134;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var134 = _livEnt.m_21223_();
            } else {
               var134 = -1.0F;
            }

            if ((double)var134 != old_health) {
               float var141;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var141 = _livEnt.m_21223_();
               } else {
                  var141 = -1.0F;
               }

               double var135 = old_health - (double)var141;
               double var142;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var142 = (double)_livEnt.m_21233_();
               } else {
                  var142 = -1.0;
               }

               label553: {
                  NUM1 = var135 / Math.max(var142, 0.1) * (entity instanceof Player ? 0.75 : 1.5);
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)sourceentity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                        var136 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).m_19564_();
                        break label553;
                     }
                  }

                  var136 = 0;
               }

               if (var136 >= 1) {
                  NUM1 += 0.5;
               }

               label831: {
                  label546: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt143 = (LivingEntity)entity;
                        if (_livEnt143.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           break label546;
                        }
                     }

                     if (!guard) {
                        break label831;
                     }
                  }

                  label539: {
                     NUM1 *= 0.5;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var137 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                           break label539;
                        }
                     }

                     var137 = 0;
                  }

                  if (var137 > 0) {
                     NUM1 *= 0.5;
                  }
               }

               if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                  label878: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt147 = (LivingEntity)entity;
                        if (_livEnt147.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                           break label878;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt148 = (LivingEntity)entity;
                        if (_livEnt148.m_21023_((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                           break label878;
                        }
                     }

                     if ((!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) && !damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) || sourceentity.getPersistentData().m_128471_("attack")) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 4, 0, false, false));
                        }
                     }

                     if (NUM1 >= 0.05) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 10, 0, false, false));
                           }
                        }

                        if (NUM1 >= 0.1) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)Math.round(Math.min(NUM1 * 75.0, 60.0)), (int)Math.round(NUM1 * 5.0), false, false));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Math.min(NUM1 * 75.0, 60.0)), 0, false, false));
                              }
                           }

                           if (NUM1 >= 0.2) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), (int)Math.round(Math.min(NUM1 * 75.0, 60.0)), 1, false, false));
                                 }
                              }

                              label507: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var135 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                       break label507;
                                    }
                                 }

                                 var135 = 0.0;
                              }

                              Damage_amount = var135;
                              if (Damage_amount > 0.0 && Damage_amount <= 600.0 && entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                              }
                           }
                        }
                     }
                  }
               }

               if (critical_nanami) {
                  critical_nanami = false;
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 1, 0.5, 0.5, 0.5, 0.25);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123797_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 25, 0.25, 0.25, 0.25, 0.5);
                  }
               }

               if (critical_ice) {
                  critical_ice = false;
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                     }
                  }

                  world.m_46796_(2001, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_()), Block.m_49956_(Blocks.f_50126_.m_49966_()));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var134 = _livEnt.m_21223_();
            } else {
               var134 = -1.0F;
            }

            label836: {
               if ((double)var134 == old_health && entity instanceof LivingEntity) {
                  LivingEntity _livEnt185 = (LivingEntity)entity;
                  if (_livEnt185.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                     break label836;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt186 = (LivingEntity)entity;
                  if (_livEnt186.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     if (!(entity instanceof LivingEntity)) {
                        break label836;
                     }

                     LivingEntity _livEnt187 = (LivingEntity)entity;
                     if (!_livEnt187.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        break label836;
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get(), 3, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity = (LivingEntity)entity;
                  _livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get(), 3, 0, false, false));
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity = (LivingEntity)entity;
                  _livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
               }

               if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat")))) {
                  if (guard) {
                     GuardEffectProcedureProcedure.execute(world, entity.m_20185_() + (double)entity.m_20205_() * (Math.random() - 0.5), entity.m_20186_() + (double)entity.m_20206_() * Math.random(), entity.m_20189_() + (double)entity.m_20205_() * (Math.random() - 0.5), sourceentity, entity);
                  }

                  if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) && !damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) || sourceentity.getPersistentData().m_128471_("attack")) {
                     DamageEffectProcedureProcedure.execute(world, sourceentity, entity, amount);
                  }
               }
            }

            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

      }
   }
}
