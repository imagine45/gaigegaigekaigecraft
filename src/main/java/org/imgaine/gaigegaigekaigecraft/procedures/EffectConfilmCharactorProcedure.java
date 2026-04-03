package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PurpleEntity;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
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
         double T1 = 0.0;
         double T2 = 0.0;
         ItemStack equipment_item = ItemStack.EMPTY;
         if (entityiterator instanceof LivingEntity) {
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().getBoolean("Ambush") && entity.getPersistentData().getDouble("friend_num") != entityiterator.getPersistentData().getDouble("friend_num2")) {
               label334: {
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0) {
                        break label334;
                     }
                  } else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                     break label334;
                  }

                  entityiterator.getPersistentData().putBoolean("failed_adjustment", true);
               }
            }

            label344: {
               label345: {
                  entity_b = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                        break label345;
                     }
                  }

                  if (!(entity_b instanceof LivingEntity) || !(entity_b instanceof LivingEntity)) {
                     break label344;
                  }

                  LivingEntity _livEnt12 = (LivingEntity)entity_b;
                  if (!_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     break label344;
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
               }

               entity.getPersistentData().putBoolean("ignore", true);
               if (entity instanceof TruckEntity && (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }
            }

            if (entity instanceof PurpleEntity && entity.getPersistentData().getBoolean("explode") && entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt22 = (LivingEntity)entityiterator;
               if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
                     entity.getPersistentData().putBoolean("Stop", true);
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt27 = (LivingEntity)entity;
                     if (_livEnt27.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity.getPersistentData().getBoolean("attack")) {
                        double var10000;
                        label298: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                                 var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()).getAmplifier();
                                 break label298;
                              }
                           }

                           var10000 = 0.0;
                        }

                        label293: {
                           NUM1 = var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                 var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getAmplifier();
                                 break label293;
                              }
                           }

                           var10000 = 0.0;
                        }

                        label288: {
                           NUM2 = var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                 var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getDuration();
                                 break label288;
                              }
                           }

                           var10000 = 0.0;
                        }

                        NUM3 = var10000;
                        NUM2 = (double)Math.round(NUM2 - Math.ceil((NUM1 + 8.0) / 8.0));
                        NUM1 = (double)Math.round(NUM1 - Math.ceil((NUM1 + 8.0) / 8.0));
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }

                        if (NUM2 >= 0.0 && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), (int)NUM3, (int)NUM2));
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 10, 0.5, 0.5, 0.5, 1.0);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") > 100.0) {
               ItemStack var81;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                  var81 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var81 = ItemStack.EMPTY;
               }

               equipment_item = var81.copy();
               if (equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  label366: {
                     if (entity instanceof Player) {
                        Player _plrCldCheck39 = (Player)entity;
                        if (_plrCldCheck39.getCooldowns().isOnCooldown(equipment_item.getItem())) {
                           break label366;
                        }
                     }

                     if (entityiterator instanceof Player) {
                        JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables)null);
                        if (pVars != null) {
                           T1 = pVars.PlayerCurseTechnique;
                           T2 = pVars.PlayerCurseTechnique2;
                        }
                     }

                     if (entityiterator instanceof Player) {
                        if (T1 != 16.0 && T2 != 16.0) {
                           break label366;
                        }
                     } else if (!(entityiterator instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entityiterator instanceof CursedSpiritGrade010Entity)) {
                        break label366;
                     }

                     CompoundTag var82 = entity.getPersistentData();
                     STR1 = "skill" + Math.round(var82.getDouble("skill"));
                     if (equipment_item.getOrCreateTag().getDouble(STR1) >= 100.0) {
                        old_skill = entityiterator.getPersistentData().getDouble("skill");
                        old_damage = entityiterator.getPersistentData().getDouble("Damage");
                        entityiterator.getPersistentData().putDouble("skill", 0.0);
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 1, (int)Math.round(Math.floor(equipment_item.getOrCreateTag().getDouble(STR1) / 100.0)), false, false));
                           }
                        }

                        entityiterator.getPersistentData().putDouble("skill", old_skill);
                        entityiterator.getPersistentData().putDouble("Damage", Math.max(entityiterator.getPersistentData().getDouble("Damage"), old_damage));
                        double var83;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           var83 = (double)_livEnt.getHealth();
                        } else {
                           var83 = -1.0;
                        }

                        old_health = var83;
                        entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))), 0.01F);
                        float var10001;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           var10001 = _livEnt.getHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (old_health != (double)var10001) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              _entity.swing(InteractionHand.MAIN_HAND, true);
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_just")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_just")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                              }
                           }
                        }
                     }
                  }
               }
            }

            int var84;
            label264: {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entityiterator;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var84 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label264;
                  }
               }

               var84 = 0;
            }

            if (var84 <= 3 && !(entityiterator instanceof Player)) {
               double var85;
               label256: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var85 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label256;
                     }
                  }

                  var85 = 0.0;
               }
               double var86;
               label251: {
                  strength_lv = var85;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var86 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label251;
                     }
                  }

                  var86 = 0.0;
               }

               strength_lv_iterator = var86;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity64 = (LivingEntity)entity;
                  if (_livingEntity64.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     double var88;
                     label244: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity65 = (LivingEntity)entity;
                           if (_livingEntity65.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var88 = _livingEntity65.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label244;
                           }
                        }

                        var88 = 0.0;
                     }

                     strength_lv += var88 * 0.333;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity66 = (LivingEntity)entity;
                  if (_livingEntity66.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     double var89;
                     label233: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livingEntity67 = (LivingEntity)entityiterator;
                           if (_livingEntity67.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var89 = _livingEntity67.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label233;
                           }
                        }

                        var89 = 0.0;
                     }

                     strength_lv_iterator += var89 * 0.333;
                  }
               }

               if (strength_lv >= strength_lv_iterator + 2.0) {
                  if (!entity.getPersistentData().getBoolean("ignore")) {
                     double var87 = strength_lv_iterator + 1.0;
                     int var90;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var90 = _livEnt.getArmorValue();
                     } else {
                        var90 = 0;
                     }

                     strength_lv_iterator = var87 + (double)(var90 / 60);
                  }

                  label222: {
                     label353: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt70 = (LivingEntity)entityiterator;
                           if (_livEnt70.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label353;
                           }
                        }

                        if (!entityiterator.getPersistentData().getBoolean("attack") || !(entityiterator.getPersistentData().getDouble("Damage") > 0.0)) {
                           NUM1 = 3.0;
                           break label222;
                        }
                     }

                     NUM1 = 6.0;
                  }

                  NUM1 *= 1.0 + strength_lv_iterator * 0.33;
                  if (entity.getPersistentData().getDouble("Damage") >= NUM1 * 10.0) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                     }

                     if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                     }
                  }

                  if (strength_lv >= strength_lv_iterator * 2.0 && strength_lv >= strength_lv_iterator + 10.0) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                     }

                     if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                     }
                  }
               }
            }

         }
      }
   }
}
