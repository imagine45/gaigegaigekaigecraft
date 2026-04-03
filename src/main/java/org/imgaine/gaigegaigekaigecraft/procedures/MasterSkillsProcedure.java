package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MasterSkillsProcedure {
   public MasterSkillsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean consume = false;
         boolean changeTechnique = false;
         double num1 = 0.0;
         consume = true;
         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_SIX_EYES.get()) {
            if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).FlagSixEyes) {
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.FlagSixEyes = _setval;
                  capability.syncPlayerVariables(entity);
               });
            } else {
               consume = false;
            }
         }

         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_REVERSE_CURSED_TECHNIQUE.get()) {
            label322: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr4 = (ServerPlayer)entity;
                  if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"))).isDone()) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr6 = (ServerPlayer)entity;
                        if (_plr6.level() instanceof ServerLevel && _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_2"))).isDone()) {
                           consume = false;
                           break label322;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_2"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                     break label322;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }
         }

         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_DOMAIN_EXPANSION.get()) {
            label296: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr10 = (ServerPlayer)entity;
                  if (_plr10.level() instanceof ServerLevel && _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_expansion"))).isDone()) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr12 = (ServerPlayer)entity;
                        if (_plr12.level() instanceof ServerLevel && _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_open_barrier_type_domain"))).isDone()) {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr14 = (ServerPlayer)entity;
                              if (_plr14.level() instanceof ServerLevel && _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:anti_open_barrier_type_domain"))).isDone()) {
                                 consume = false;
                                 break label296;
                              }
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _player = (ServerPlayer)entity;
                              Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:anti_open_barrier_type_domain"));
                              AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                              if (!_ap.isDone()) {
                                 for(String criteria : _ap.getRemainingCriteria()) {
                                    _player.getAdvancements().award(_adv, criteria);
                                 }
                              }
                           }
                           break label296;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_open_barrier_type_domain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                     break label296;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_expansion"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }
         }

         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_SIMPLE_DOMAIN.get()) {
            label258: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr18 = (ServerPlayer)entity;
                  if (_plr18.level() instanceof ServerLevel && _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_simple_domain"))).isDone()) {
                     consume = false;
                     break label258;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_simple_domain"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }
         }

         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_FALLING_BLOSSOM_EMOTION.get()) {
            label244: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr22 = (ServerPlayer)entity;
                  if (_plr22.level() instanceof ServerLevel && _plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_falling_blossom_emotion"))).isDone()) {
                     consume = false;
                     break label244;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_falling_blossom_emotion"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }
         }

         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_DOMAIN_AMPLIFICATION.get()) {
            label230: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr26 = (ServerPlayer)entity;
                  if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_amplification"))).isDone()) {
                     consume = false;
                     break label230;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_amplification"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }
         }

         if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_PHYSICAL_GIFTED.get()) {
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -1.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 0.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 100, 0.5, 0.5, 0.5, 1.0);
               }

               double _setval1 = 0.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePower = _setval1;
                  capability.syncPlayerVariables(entity);
               });
               double _setval2 = 0.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerFormer = _setval2;
                  capability.syncPlayerVariables(entity);
               });
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:completely_physically_gifted"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:observation_of_the_soul"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get());
               }

               WhenRespawnProcedure.execute(world, x, y, z, entity);
            } else {
               consume = false;
            }
         }

         num1 = -200.0 - Math.random() * 20.0;
         if (consume && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(entity.getX(), num1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }

         consume = false;
         Vec3 _center = new Vec3(entity.getX(), num1, entity.getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
            if (entityiterator instanceof Bat && entityiterator.isAlive()) {
               consume = true;
               if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }

               if (!entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }
               break;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
         }

         if (consume) {
            itemstack.shrink(1);
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
