package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.BulletBallProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
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
import net.minecraft.world.entity.EquipmentSlot;
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
         execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), (double)event.getAmount());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
      execute((Event)null, world, damagesource, entity, immediatesourceentity, sourceentity, amount);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
      if (damagesource != null && entity != null && immediatesourceentity != null && sourceentity != null) {
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
         ItemStack mainHandItem = ItemStack.EMPTY;
         ItemStack item_head = ItemStack.EMPTY;
         if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation")))) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
            }

            if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move"))) && LogicStartPassiveProcedure.execute(entity)) {
               label933: {
                  if (entity instanceof Player) {
                     NUM1 = pVars.PlayerCurseTechnique;
                     NUM2 = pVars.PlayerCurseTechnique2;
                  }

                  if (NUM1 == 38.0 || NUM2 == 38.0 || entity instanceof UroTakakoEntity) {
                     label924: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt5 = (LivingEntity)entity;
                           if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label924;
                           }
                        }

                        if (sourceentity.getBbWidth() + sourceentity.getBbHeight() <= (entity.getBbWidth() + entity.getBbHeight()) * 4.0F && entity instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entity;
                           if (_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              cancel = true;
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        break label933;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                        int var10000;
                        label856: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                 var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                 break label856;
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

            } else {
               if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse"))) && !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))) {
                  cancel = false;
                  LivingEntity var123;
                  if (sourceentity instanceof Mob) {
                     Mob _mobEnt = (Mob)sourceentity;
                     var123 = _mobEnt.getTarget();
                  } else {
                     var123 = null;
                  }

                  if (var123 instanceof LivingEntity) {
                     if (sourceentity instanceof Mob) {
                        Mob _mobEnt = (Mob)sourceentity;
                        var123 = _mobEnt.getTarget();
                     } else {
                        var123 = null;
                     }

                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     if (var123 == var10001) {
                        cancel = true;
                     }
                  }

                  if (!cancel) {
                     label911: {
                        label892: {
                           if (entity instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)entity;
                              if (_tamEnt.isTame()) {
                                 break label892;
                              }
                           }

                           if (!(sourceentity instanceof TamableAnimal)) {
                              break label911;
                           }

                           TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                           if (!_tamEnt.isTame()) {
                              break label911;
                           }
                        }

                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var123 = _tamEnt.getOwner();
                        } else {
                           var123 = null;
                        }

                        if (var123 != sourceentity) {
                           if (sourceentity instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                              var123 = _tamEnt.getOwner();
                           } else {
                              var123 = null;
                           }

                           if (var123 != entity) {
                              if (entity instanceof TamableAnimal) {
                                 TamableAnimal _tamEnt = (TamableAnimal)entity;
                                 var123 = _tamEnt.getOwner();
                              } else {
                                 var123 = null;
                              }

                              LivingEntity var146;
                              if (sourceentity instanceof TamableAnimal) {
                                 TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                                 var146 = _tamEnt.getOwner();
                              } else {
                                 var146 = null;
                              }

                              if (var123 != var146) {
                                 break label911;
                              }
                           }
                        }

                        cancel = true;
                     }
                  }

                  if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP) && (sourceentity instanceof Player || sourceentity.getPersistentData().getBoolean("Player")) && (entity instanceof Player || entity.getPersistentData().getBoolean("Player"))) {
                     label937: {
                        label895: {
                           cancel = true;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt35 = (LivingEntity)entity;
                              if (_livEnt35.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label895;
                              }
                           }

                           if (!(sourceentity instanceof LivingEntity)) {
                              break label937;
                           }

                           LivingEntity _livEnt36 = (LivingEntity)sourceentity;
                           if (!_livEnt36.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label937;
                           }
                        }

                        cancel = false;
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var123 = _mobEnt.getTarget();
                  } else {
                     var123 = null;
                  }

                  label940: {
                     if (var123 != sourceentity || !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                        if (sourceentity instanceof Mob) {
                           Mob _mobEnt = (Mob)sourceentity;
                           var123 = _mobEnt.getTarget();
                        } else {
                           var123 = null;
                        }

                        if (var123 != entity || !(sourceentity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                           break label940;
                        }
                     }

                     cancel = false;
                  }

                  if (!cancel) {
                     if (sourceentity.getPersistentData().getDouble("friend_num") != 0.0 && sourceentity.getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num")) {
                        cancel = true;
                     }

                     if (damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.PLAYER_ATTACK)) {
                        label925: {
                           label899: {
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt48 = (LivingEntity)sourceentity;
                                 if (_livEnt48.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt49 = (LivingEntity)sourceentity;
                                    if (_livEnt49.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                       break label899;
                                    }
                                 }
                              }
                              int var130;
                              label783: {
                                 if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)sourceentity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var130 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                                       break label783;
                                    }
                                 }

                                 var130 = 0;
                              }

                              if (var130 <= 0 && !(sourceentity.getPersistentData().getDouble("skill") <= -999.0)) {
                                 break label925;
                              }
                           }

                           cancel = true;
                        }
                     }

                     label775: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt52 = (LivingEntity)entity;
                           if (_livEnt52.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label775;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt53 = (LivingEntity)entity;
                           if (_livEnt53.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                              int var131;
                              label768: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                       var131 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                       break label768;
                                    }
                                 }

                                 var131 = 0;
                              }

                              if (var131 > 0) {
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
                  } else if (!(immediatesourceentity instanceof Projectile)) {
                     logic_a = sourceentity.getPersistentData().getBoolean("attack");
                     sourceentity.getPersistentData().putBoolean("attack", true);
                     CursedToolsAbilityProcedure.execute(sourceentity, entity);
                     sourceentity.getPersistentData().putBoolean("attack", logic_a);
                  }
               }

               if (ModList.get().isLoaded("minepiece") && damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse")))) {
                  cancel = true;
               }

               if (!cancel) {
                  if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation"))) && !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))) {
                     JujutsucraftModVariables.PlayerVariables pVarsSource = null;
                     if (sourceentity instanceof Player) {
                        pVarsSource = (JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
                     }

                     Damage_amount = amount;
                     ItemStack var132;
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        var132 = _livEnt.getMainHandItem();
                     } else {
                        var132 = ItemStack.EMPTY;
                     }

                     mainHandItem = var132.copy();
                     if (!sourceentity.getPersistentData().getString("OWNER_UUID").isEmpty() && (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || sourceentity.getPersistentData().getDouble("NameRanged_ranged") != 0.0)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, sourceentity.getPersistentData().getString("OWNER_UUID"));
                     }

                     if (!(entity_a instanceof LivingEntity)) {
                        entity_a = sourceentity;
                     }

                     EntityAutoGuardProcedure.execute(world, entity, entity_a);
                     CounterProcedure.execute(entity);
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        var132 = _livEnt.getMainHandItem();
                     } else {
                        var132 = ItemStack.EMPTY;
                     }

                     SetAttributeMainhandProcedure.execute(var132);
                     if ((damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse"))) || damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat")))) && !sourceentity.getPersistentData().getBoolean("attack")) {
                        if (mainHandItem.getItem() != ItemStack.EMPTY.getItem() && mainHandItem.getOrCreateTag().contains("CursePower") && mainHandItem.getOrCreateTag().getDouble("CursePower") != 0.0) {
                           use_curse = true;
                        }
                     } else if (!(immediatesourceentity instanceof Projectile)) {
                        label733: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt77 = (LivingEntity)entity;
                              if (_livEnt77.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                                 break label733;
                              }
                           }

                           CursedToolsAbilityProcedure.execute(sourceentity, entity);
                           EffectAttackProcedure.execute(world, entity, sourceentity);
                        }

                        if (mainHandItem.is(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                           if (mainHandItem.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                              Damage_amount = 1.0;
                              changeDamage = true;
                           }

                           if (mainHandItem.getItem() == JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
                              changeDamage = true;
                           }
                        }

                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                           var132 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var132 = ItemStack.EMPTY;
                        }

                        label902: {
                           item_head = var132.copy();
                           NUM1 = 0.0;
                           if (sourceentity instanceof Player && sourceentity instanceof Player) {
                              Player _plrCldCheck83 = (Player)sourceentity;
                              if (_plrCldCheck83.getCooldowns().isOnCooldown(item_head.getItem())) {
                                 break label902;
                              }
                           }

                           if (item_head.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_head.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              label939: {
                                 if (sourceentity instanceof Player) {
                                    if (pVarsSource.PlayerCurseTechnique != 16.0 && pVarsSource.PlayerCurseTechnique2 != 16.0) {
                                       break label939;
                                    }
                                 } else if (!(sourceentity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(sourceentity instanceof CursedSpiritGrade010Entity)) {
                                    break label939;
                                 }

                                 if (item_head.getOrCreateTag().getDouble("toLiving") >= 100.0) {
                                    NUM1 = (double)Math.round(Math.floor(item_head.getOrCreateTag().getDouble("toLiving") / 100.0) * 2.5);
                                    NUM1 = entity.getPersistentData().getBoolean("CursedSpirit") ? NUM1 * -1.0 : NUM1;
                                 }
                              }
                           }
                        }

                        if ((mainHandItem.getItem() != ItemStack.EMPTY.getItem() || NUM1 != 0.0) && (mainHandItem.getOrCreateTag().contains("CursePower") || NUM1 != 0.0)) {
                           if (mainHandItem.getItem() != ItemStack.EMPTY.getItem()) {
                              if (NUM1 > 0.0) {
                                 NUM1 += Math.max(mainHandItem.getOrCreateTag().getDouble("CursePower"), 0.0);
                              } else if (NUM1 < 0.0) {
                                 NUM1 += Math.min(mainHandItem.getOrCreateTag().getDouble("CursePower"), 0.0);
                              } else {
                                 NUM1 = mainHandItem.getOrCreateTag().getDouble("CursePower");
                              }
                           }

                           if (NUM1 > 0.0) {
                              Damage_amount *= 1.0 + NUM1 * 0.02;
                              changeDamage = true;
                              use_curse = true;
                           } else if (NUM1 < 0.0 && entity.getPersistentData().getBoolean("CursedSpirit")) {
                              Damage_amount *= 1.0 + Math.abs(NUM1) * 0.2;
                              changeDamage = true;
                              use_curse = true;
                           }
                        }
                        int var135;
                        label702: {
                           if (sourceentity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)sourceentity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                                 var135 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                                 break label702;
                              }
                           }

                           var135 = 0;
                        }

                        if (var135 >= 1 && entity instanceof LivingEntity) {
                           LivingEntity _livEnt102 = (LivingEntity)entity;
                           if (_livEnt102.hasEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get());
                              }

                              Damage_amount *= 1.5;
                              critical_nanami = true;
                              changeDamage = true;
                           }
                        }

                        if (entity.getPercentFrozen() * 100.0F >= 5.0F) {
                           entity.setTicksFrozen(0);
                           Damage_amount *= 1.5;
                           critical_ice = true;
                           changeDamage = true;
                        }
                     }

                     if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat"))) && LogicGuardSuccessProcedure.execute(entity, sourceentity)) {
                        Damage_amount = Math.max(Damage_amount - entity.getPersistentData().getDouble("Damage"), 0.01);
                        changeDamage = true;
                        guard = true;
                     }

                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _livEnt112 = (LivingEntity)entity_a;
                        if (_livEnt112.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity instanceof LivingEntity) {
                           LivingEntity _livEnt113 = (LivingEntity)entity;
                           if (_livEnt113.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                              int var136;
                              label691: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                       var136 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                       break label691;
                                    }
                                 }

                                 var136 = 0;
                              }

                              if (var136 > 0) {
                                 int var10002;
                                 label685: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                          var10002 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                          break label685;
                                       }
                                    }

                                    var10002 = 0;
                                 }

                                 NUM1 = 15.0 * (1.0 + (double)var10002 * 0.33);
                                 if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || sourceentity.getPersistentData().getBoolean("DomainAttack")) {
                                    Damage_amount = Math.max(Damage_amount - NUM1, 0.0);
                                 }

                                 if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                    sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse"))), entity), (float)NUM1);
                                 }
                              }
                           }
                        }
                     }

                     if (entity.getPersistentData().getBoolean("CursedSpirit") && !use_curse) {
                        label673: {
                           if (sourceentity instanceof Player) {
                              if (!(pVarsSource.PlayerCursePowerFormer < 100.0) || LogicUseMinePieceProcedure.execute(sourceentity)) {
                                 break label673;
                              }
                           } else if (!sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                              break label673;
                           }

                           Damage_amount = 0.01;
                           changeDamage = true;
                        }
                     }

                     label905: {
                        if (entity instanceof Player) {
                           if (pVars.PlayerCurseTechnique != 15.0 && pVars.PlayerCurseTechnique2 != 15.0) {
                              break label905;
                           }
                        } else if (!(entity instanceof MahitoEntity)) {
                           break label905;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt126 = (LivingEntity)entity;
                           if (_livEnt126.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                              break label905;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt127 = (LivingEntity)entity;
                           if (_livEnt127.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                              break label905;
                           }
                        }

                        if (entity_a instanceof Player) {
                           if (entity_a instanceof ServerPlayer) {
                              ServerPlayer _plr129 = (ServerPlayer)entity_a;
                              if (_plr129.level() instanceof ServerLevel && _plr129.getAdvancements().getOrStartProgress(_plr129.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:observation_of_the_soul"))).isDone()) {
                                 break label905;
                              }
                           }
                        } else if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:soul_perception")))) {
                           break label905;
                        }

                        if (!sourceentity.getPersistentData().getBoolean("ignore")) {
                           Damage_amount *= 0.5;
                           changeDamage = true;
                        }
                     }

                     if (sourceentity.getPersistentData().getBoolean("ignore")) {
                        changeDamage = true;
                     }

                     if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat"))) && entity instanceof Player && (entity_a.getPersistentData().getBoolean("jjkChara") || entity_a instanceof Player)) {
                        Damage_amount *= GetDifficultyLevelProcedure.execute(world);
                        changeDamage = true;
                     }

                     if (sourceentity.getPersistentData().getBoolean("ignore") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.IGNORE_GUARD.get(), 1, 0, false, false));
                        }
                     }

                     double var137;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var137 = (double)_livEnt.getHealth();
                     } else {
                        var137 = -1.0;
                     }

                     old_health = var137;
                     if (Damage_amount > 0.0) {
                        if (immediatesourceentity instanceof Projectile) {
                           entity_a = immediatesourceentity;
                        }

                        if (ModList.get().isLoaded("minepiece")) {
                           entity.hurt(damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat"))) ? new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat"))), entity_a) : new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse"))), entity_a), (float)Damage_amount);
                        } else {
                           entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat"))), entity_a), (float)Damage_amount);
                        }
                     }

                     old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
                     float var138;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var138 = _livEnt.getHealth();
                     } else {
                        var138 = -1.0F;
                     }

                     if ((double)var138 != old_health) {
                        float var147;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var147 = _livEnt.getHealth();
                        } else {
                           var147 = -1.0F;
                        }

                        double var139 = old_health - (double)var147;
                        double var148;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var148 = (double)_livEnt.getMaxHealth();
                        } else {
                           var148 = -1.0;
                        }
                        int var140;
                        label626: {
                           NUM1 = var139 / Math.max(var148, 0.1) * (entity instanceof Player ? 0.5 : 1.0);
                           if (sourceentity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)sourceentity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                                 var140 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).getAmplifier();
                                 break label626;
                              }
                           }

                           var140 = 0;
                        }

                        if (var140 >= 1) {
                           NUM1 += 0.2;
                        }

                        label907: {
                           label619: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt154 = (LivingEntity)entity;
                                 if (_livEnt154.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                    break label619;
                                 }
                              }

                              if (!guard) {
                                 break label907;
                              }
                           }
                           int var141;
                           label614: {
                              NUM1 *= 0.5;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                    var141 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                    break label614;
                                 }
                              }

                              var141 = 0;
                           }

                           int var142;
                           if (var141 <= 0) {
                              label607: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                                       var142 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).getAmplifier();
                                       break label607;
                                    }
                                 }

                                 var142 = 0;
                              }

                              if (var142 <= 0) {
                                 break label907;
                              }
                           }

                           NUM1 *= 0.5;
                        }

                        if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           label917: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt159 = (LivingEntity)entity;
                                 if (_livEnt159.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                    break label917;
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt160 = (LivingEntity)entity;
                                 if (_livEnt160.hasEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                                    break label917;
                                 }
                              }
                              int var143;
                              label594: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                                       var143 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).getAmplifier();
                                       break label594;
                                    }
                                 }

                                 var143 = 0;
                              }

                              if (var143 < 9) {
                                 if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse"))) || damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat")))) {
                                    if (sourceentity.getPersistentData().getBoolean("attack")) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 4, 0, false, false));
                                          }
                                       }
                                    } else if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 4, 0, false, false));
                                       }
                                    }
                                 }

                                 if (NUM1 >= 0.05) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 10, 0, false, false));
                                       }
                                    }

                                    if (NUM1 >= 0.1) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)Math.round(Math.min(NUM1 * 75.0, 60.0)), (int)Math.round(NUM1 * 5.0), false, false));
                                          }
                                       }

                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Math.min(NUM1 * 75.0, 60.0)), 0, false, false));
                                          }
                                       }

                                       if (NUM1 >= 0.2) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), (int)Math.round(Math.min(NUM1 * 75.0, 60.0)), 1, false, false));
                                             }
                                          }

                                          label579: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   var139 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                                   break label579;
                                                }
                                             }

                                             var139 = 0.0;
                                          }

                                          Damage_amount = var139;
                                          if (Damage_amount > 0.0 && Damage_amount <= 600.0 && entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                          }
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
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                              } else {
                                 _level.playLocalSound(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                              }
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 1, 0.5, 0.5, 0.5, 0.25);
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles(ParticleTypes.CRIT, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 25, 0.25, 0.25, 0.25, 0.5);
                           }
                        }

                        if (critical_ice) {
                           critical_ice = false;
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                              } else {
                                 _level.playLocalSound(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                              }
                           }

                           world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ()), Block.getId(Blocks.ICE.defaultBlockState()));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var138 = _livEnt.getHealth();
                     } else {
                        var138 = -1.0F;
                     }

                     label910: {
                        if ((double)var138 == old_health && entity instanceof LivingEntity) {
                           LivingEntity _livEnt199 = (LivingEntity)entity;
                           if (_livEnt199.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                              break label910;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt200 = (LivingEntity)entity;
                           if (_livEnt200.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                              if (!(entity instanceof LivingEntity)) {
                                 break label910;
                              }

                              LivingEntity _livEnt201 = (LivingEntity)entity;
                              if (!_livEnt201.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                 break label910;
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get(), 3, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                           }
                        }

                        if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat")))) {
                           if (guard) {
                              GuardEffectProcedureProcedure.execute(world, entity.getX() + (double)entity.getBbWidth() * (Math.random() - 0.5), entity.getY() + (double)entity.getBbHeight() * Math.random(), entity.getZ() + (double)entity.getBbWidth() * (Math.random() - 0.5), sourceentity, entity);
                           }

                           if (!(immediatesourceentity instanceof Projectile) && (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse"))) && !damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat"))) || sourceentity.getPersistentData().getBoolean("attack"))) {
                              DamageEffectProcedureProcedure.execute(world, sourceentity, entity, amount);
                           }
                        }
                     }

                     if (immediatesourceentity instanceof Projectile && !immediatesourceentity.level().isClientSide()) {
                        immediatesourceentity.discard();
                     }

                     entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                  }
               }
            }
         }
      }
   }
}
