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
      if (event.getHand() == event.getEntity().m_7655_()) {
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
         T1 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         T2 = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)sourceentity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && ReturnInsideItemProcedure.execute(sourceentity).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
               right_clicked = false;
               if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity)) {
                  if (entity instanceof FushiguroMegumiEntity || entity instanceof FushiguroMegumiShibuyaEntity) {
                     right_clicked = true;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.SUKUNA_FUSHIGURO.get()).m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.m_146922_(entity.m_146908_());
                           entityToSpawn.m_5618_(entity.m_146908_());
                           entityToSpawn.m_5616_(entity.m_146908_());
                           entityToSpawn.m_146926_(entity.m_146909_());
                        }
                     }
                  }
               } else {
                  right_clicked = true;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.SUKUNA.get()).m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.m_146922_(entity.m_146908_());
                        entityToSpawn.m_5618_(entity.m_146908_());
                        entityToSpawn.m_5616_(entity.m_146908_());
                        entityToSpawn.m_146926_(entity.m_146909_());
                     }
                  }
               }

               if (right_clicked) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
                  }

                  ItemStack _setval = ItemStack.f_41583_;
                  sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.BodyItem = _setval.m_41777_();
                     capability.syncPlayerVariables(sourceentity);
                  });
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         }

         if (!right_clicked) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt22 = (LivingEntity)sourceentity;
               if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  return;
               }
            }

            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt23 = (LivingEntity)sourceentity;
               if (_livEnt23.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return;
               }
            }

            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt24 = (LivingEntity)sourceentity;
               if (_livEnt24.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                  return;
               }
            }

            if (!(entity instanceof DomainExpansionEntityEntity)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt26 = (LivingEntity)entity;
                  if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     return;
                  }
               }

               if ((T1 == 19.0 || T2 == 19.0) && !(entity instanceof FrameEntity) && !(entity instanceof EntityProjectionSorceryEntity) && entity.getPersistentData().m_128459_("select") == 0.0) {
                  label155: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt30 = (LivingEntity)entity;
                        if (_livEnt30.m_21023_((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                           break label155;
                        }
                     }

                     if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange >= 40.0) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 40.0;
                        sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(sourceentity);
                        });
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 50, 0, false, false));
                           }
                        }

                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)sourceentity;
                           _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                        }
                     }
                  }
               }

               if ((T1 == 24.0 || T2 == 24.0) && entity.m_146889_() * 100.0F < 5.0F && ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange >= 40.0) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 40.0;
                  sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(sourceentity);
                  });
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 5, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 80, 1, false, false));
                     }
                  }

                  entity.m_146917_(100);
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               }
            }
         }

      }
   }
}
