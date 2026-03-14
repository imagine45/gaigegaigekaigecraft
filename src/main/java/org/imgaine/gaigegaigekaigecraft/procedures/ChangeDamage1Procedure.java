package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KurusuHanaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class ChangeDamage1Procedure {
   public ChangeDamage1Procedure() {
   }

   public static double execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double damage;
         int var10000;
         label225: {
            boolean logic_a = false;
            boolean Mahito = false;
            boolean PhysicalGifted = false;
            boolean Sukuna = false;
            boolean Thunder = false;
            Entity entity_a = null;
            Entity entity_b = null;
            damage = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double skill = 0.0;
            damage = 1.0;
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                  break label225;
               }
            }

            var10000 = 0;
         }

         boolean var23;
         label239: {
            var23 = var10000 > 0;
            if (ReturnInsideItemProcedure.execute(entityiterator).m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
               label238: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt2 = (LivingEntity)entityiterator;
                     if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label238;
                     }
                  }

                  var10000 = 0;
                  break label239;
               }
            }

            var10000 = 1;
         }

         boolean var24;
         label210: {
            label209: {
               label232: {
                  var24 = (boolean)var10000;
                  if (entityiterator instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 15.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 15.0) {
                        break label232;
                     }
                  } else if (!(entityiterator instanceof MahitoEntity)) {
                     break label232;
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entityiterator;
                     if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label232;
                     }
                  }

                  if (!(entityiterator instanceof LivingEntity)) {
                     break label209;
                  }

                  LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                  if (!_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     break label209;
                  }
               }

               var10000 = 0;
               break label210;
            }

            var10000 = 1;
         }

         boolean var22 = (boolean)var10000;
         boolean var25 = entityiterator instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7.0 : entityiterator instanceof NueEntity || entityiterator instanceof MergedBeastAgitoEntity || entityiterator instanceof KashimoHajimeEntity;
         double var30 = entity.getPersistentData().m_128459_("skill");
         if (var30 == 705.0 && var25) {
            damage *= 0.1;
         }

         if (var30 == 1505.0) {
            if (var23 || var22) {
               damage *= 0.1;
            }

            label174: {
               if (entityiterator instanceof Player) {
                  if (entityiterator instanceof ServerPlayer) {
                     ServerPlayer _plr13 = (ServerPlayer)entityiterator;
                     if (_plr13.m_9236_() instanceof ServerLevel && _plr13.m_8960_().m_135996_(_plr13.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:observation_of_the_soul"))).m_8193_()) {
                        break label174;
                     }
                  }
               } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:soul_perception")))) {
                  break label174;
               }

               damage *= 2.0;
            }

            if (var24) {
               damage *= 0.0;
               DamageSource var10001 = new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat"))));
               float var10002;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.m_21233_();
               } else {
                  var10002 = -1.0F;
               }

               entity.m_6469_(var10001, Math.max(var10002, 50.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 100, 9, false, false));
                  }
               }

               double var27 = entity.m_20185_();
               double var28 = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
               double var29 = entity.m_20189_();
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var27, var28, var29), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(var27, var28, var29, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var27, var28, var29), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(var27, var28, var29, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                  if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("minecraft:skeletons")))) {
                     world.m_46796_(2001, BlockPos.m_274561_(var27, var28, var29), Block.m_49956_(Blocks.f_50453_.m_49966_()));
                  } else if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), var27, var28, var29, 30, 0.2, 0.2, 0.2, 2.0);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), var27, var28, var29, 30, 0.2, 0.2, 0.2, 2.0);
                  }
               }
            }
         }

         if (var30 == 2815.0) {
            label235: {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt37 = (LivingEntity)entityiterator;
                  if (_livEnt37.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     damage *= 1.2;
                     break label235;
                  }
               }

               if (!entityiterator.getPersistentData().m_128471_("CursedSpirit") && !entityiterator.getPersistentData().m_128471_("CurseUser")) {
                  label160: {
                     label159: {
                        if (entityiterator instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 28.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 28.0) {
                              break label159;
                           }
                        } else if (entityiterator instanceof KurusuHanaEntity) {
                           break label159;
                        }

                        if (entityiterator.getPersistentData().m_128471_("JujutsuSorcerer")) {
                           damage *= 0.5;
                        } else {
                           damage *= 0.75;
                        }
                        break label160;
                     }

                     damage *= 0.1;
                  }
               } else {
                  damage *= 1.0;
               }
            }

            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               damage *= 5.0;
            }
         }

         return damage;
      } else {
         return 0.0;
      }
   }
}
