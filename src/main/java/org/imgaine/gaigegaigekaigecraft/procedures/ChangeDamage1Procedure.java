package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KurusuHanaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PurpleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TakabaFumihikoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class ChangeDamage1Procedure {
   public ChangeDamage1Procedure() {
   }

   public static double execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double damage = 0.0;
         double player_ct1 = 0.0;
         double player_ct2 = 0.0;
         double skill = 0.0;
         boolean PhysicalGifted = false;
         boolean Thunder = false;
         boolean Sukuna = false;
         boolean Mahito = false;
         damage = 1.0;
         if (entityiterator instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            pVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables)null);
            player_ct1 = pVars.PlayerCurseTechnique;
            player_ct2 = pVars.PlayerCurseTechnique2;
         }

         int var10000;
         label325: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                  break label325;
               }
            }

            var10000 = 0;
         }

         label343: {
            PhysicalGifted = var10000 > 0;
            if (ReturnInsideItemProcedure.execute(entityiterator).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
               label341: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entityiterator;
                     if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label341;
                     }
                  }

                  var10000 = 0;
                  break label343;
               }
            }

            var10000 = 1;
         }

         label310: {
            label309: {
               label333: {
                  Sukuna = var10000 != 0;
                  if (entityiterator instanceof Player) {
                     if (player_ct1 != 15.0 && player_ct2 != 15.0) {
                        break label333;
                     }
                  } else if (!(entityiterator instanceof MahitoEntity)) {
                     break label333;
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                     if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label333;
                     }
                  }

                  if (!(entityiterator instanceof LivingEntity)) {
                     break label309;
                  }

                  LivingEntity _livEnt7 = (LivingEntity)entityiterator;
                  if (!_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     break label309;
                  }
               }

               var10000 = 0;
               break label310;
            }

            var10000 = 1;
         }

         Mahito = var10000 != 0;
         Thunder = entityiterator instanceof Player ? player_ct1 == 7.0 || player_ct2 == 7.0 : entityiterator instanceof NueEntity || entityiterator instanceof MergedBeastAgitoEntity || entityiterator instanceof KashimoHajimeEntity;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 705.0 && Thunder) {
            damage *= 0.1;
         }

         if (skill == 1505.0) {
            if (Sukuna) {
               DamageSource var10001 = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat"))));
               float var10002;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMaxHealth();
               } else {
                  var10002 = -1.0F;
               }

               entity.hurt(var10001, Math.max(var10002, 50.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 100, 9, false, false));
                  }
               }

               Effect1Procedure.execute(world, entityiterator, entity);
               return 0.0;
            }

            if (!PhysicalGifted && !Mahito) {
               label275: {
                  if (entityiterator instanceof Player) {
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _plr24 = (ServerPlayer)entityiterator;
                        if (_plr24.level() instanceof ServerLevel && _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:observation_of_the_soul"))).isDone()) {
                           break label275;
                        }
                     }
                  } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:soul_perception")))) {
                     break label275;
                  }

                  damage *= 1.25;
               }
            } else {
               damage *= 0.1;
            }
         }

         if (skill == 2815.0) {
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               damage *= 5.0;
            } else if (!entityiterator.getPersistentData().getBoolean("CursedSpirit") && !entityiterator.getPersistentData().getBoolean("CurseUser")) {
               label262: {
                  if (entityiterator instanceof Player) {
                     if (player_ct1 != 28.0 && player_ct2 != 28.0) {
                        break label262;
                     }
                  } else if (!(entityiterator instanceof KurusuHanaEntity)) {
                     break label262;
                  }

                  damage *= 0.1;
               }

               if (entityiterator.getPersistentData().getBoolean("JujutsuSorcerer")) {
                  damage *= 0.5;
               }
            }
         }

         label255: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getAmplifier();
                  break label255;
               }
            }

            var10000 = 0;
         }

         label344: {
            if (var10000 > 0) {
               label342: {
                  if (entityiterator instanceof Player) {
                     if (player_ct1 != 17.0 && player_ct2 != 17.0) {
                        break label342;
                     }
                  } else if (!(entityiterator instanceof TakabaFumihikoEntity)) {
                     break label342;
                  }

                  if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                     ItemStack var51;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var51 = _livEnt.getMainHandItem();
                     } else {
                        var51 = ItemStack.EMPTY;
                     }

                     if (var51.getItem() == JujutsucraftModItems.HARISEN.get()) {
                        if (!(entityiterator instanceof Player)) {
                           break label344;
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt40 = (LivingEntity)entityiterator;
                           if (_livEnt40.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label344;
                           }
                        }

                        if (entityiterator.getPersistentData().getBoolean("attack")) {
                           break label344;
                        }
                     }
                  }
               }
            }

            label228: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getAmplifier();
                     break label228;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0) {
               label222: {
                  if (entity instanceof Player) {
                     if (player_ct1 != 17.0 && player_ct2 != 17.0) {
                        break label222;
                     }
                  } else if (!(entity instanceof TakabaFumihikoEntity)) {
                     break label222;
                  }

                  if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                     damage *= 2.0;
                  }
               }
            }

            if (entity instanceof PurpleEntity && entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged")) {
               damage *= 0.5;
            }

            if (!entity.getPersistentData().getBoolean("attack")) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt82 = (LivingEntity)entityiterator;
                  if (_livEnt82.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     damage *= 0.75;
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt83 = (LivingEntity)entityiterator;
                  if (_livEnt83.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     damage *= 0.9;
                  }
               }
            }

            return damage;
         }

         if (entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
            entityiterator.getPersistentData().putDouble("friend_num", Math.random());
         }

         if (entityiterator.getPersistentData().getDouble("NameRanged") == 0.0) {
            entityiterator.getPersistentData().putDouble("NameRanged", Math.random());
         }

         entity.getPersistentData().putString("OWNER_UUID", entityiterator.getStringUUID());
         entity.getPersistentData().putDouble("friend_num", entityiterator.getPersistentData().getDouble("friend_num"));
         entity.getPersistentData().putDouble("NameRanged_ranged", entityiterator.getPersistentData().getDouble("NameRanged"));
         entity.getPersistentData().putDouble("x_power", entityiterator.getLookAngle().x * 6.0);
         entity.getPersistentData().putDouble("y_power", entityiterator.getLookAngle().y * 6.0);
         entity.getPersistentData().putDouble("z_power", entityiterator.getLookAngle().z * 6.0);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 9, false, false));
            }
         }

         entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
         entity.setYRot(entityiterator.getYRot());
         entity.setXRot(entityiterator.getXRot());
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:critical")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:critical")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (!(entityiterator instanceof GeoEntity) && entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livingEntity72 = (LivingEntity)entityiterator;
            if (_livingEntity72.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity72.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livingEntity73 = (LivingEntity)entityiterator;
            if (_livingEntity73.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
               _livingEntity73.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
            }
         }

         PlayAnimationProcedure.execute(world, entityiterator);
         return 0.0;
      } else {
         return 0.0;
      }
   }
}
