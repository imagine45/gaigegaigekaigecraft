package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityProjectionSorceryEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FrameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenRightClickToEntityProcedure {
   public WhenRightClickToEntityProcedure() {
   }

   @SubscribeEvent
   public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), event.getTarget(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double T1 = 0.0;
         double T2 = 0.0;
         boolean right_clicked = false;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (sourceentity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
            T1 = pVars.PlayerCurseTechnique;
            T2 = pVars.PlayerCurseTechnique2;
         }

         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt1 = (LivingEntity)sourceentity;
            if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && ReturnInsideItemProcedure.execute(sourceentity).getItem() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
               right_clicked = false;
               if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity)) {
                  if (entity instanceof FushiguroMegumiEntity || entity instanceof FushiguroMegumiShibuyaEntity) {
                     right_clicked = true;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.SUKUNA_FUSHIGURO.get()).spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(entity.getYRot());
                           entityToSpawn.setYBodyRot(entity.getYRot());
                           entityToSpawn.setYHeadRot(entity.getYRot());
                           entityToSpawn.setXRot(entity.getXRot());
                        }
                     }
                  }
               } else {
                  right_clicked = true;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.SUKUNA.get()).spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setXRot(entity.getXRot());
                     }
                  }
               }

               if (right_clicked) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
                  }

                  ItemStack _setval = ItemStack.EMPTY;
                  sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.BodyItem = _setval.copy();
                     capability.syncPlayerVariables(sourceentity);
                  });
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  return;
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt23 = (LivingEntity)sourceentity;
            if (_livEnt23.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt24 = (LivingEntity)sourceentity;
                  if (_livEnt24.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     return;
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt25 = (LivingEntity)sourceentity;
                  if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                     return;
                  }
               }
            }
         }

         if (!(entity instanceof DomainExpansionEntityEntity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt27 = (LivingEntity)entity;
               if (_livEnt27.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  return;
               }
            }

            if ((T1 == 19.0 || T2 == 19.0) && !(entity instanceof FrameEntity) && !(entity instanceof EntityProjectionSorceryEntity) && entity.getPersistentData().getDouble("select") == 0.0) {
               label109: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt31 = (LivingEntity)entity;
                     if (_livEnt31.hasEffect((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                        break label109;
                     }
                  }

                  if (pVars.PlayerCursePower + pVars.PlayerCursePowerChange >= 40.0) {
                     pVars.PlayerCursePowerChange -= 40.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 50, 0, false, false));
                        }
                     }

                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)sourceentity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }
                  }
               }
            }

            if ((T1 == 24.0 || T2 == 24.0) && entity.getPercentFrozen() * 100.0F < 5.0F && pVars.PlayerCursePower + pVars.PlayerCursePowerChange >= 40.0) {
               pVars.PlayerCursePowerChange -= 40.0;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 5, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 1, false, false));
                  }
               }

               entity.setTicksFrozen(100);
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            }

         }
      }
   }
}
