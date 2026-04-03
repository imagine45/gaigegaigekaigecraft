package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Recommendation1RightClickedInAirProcedure {
   public Recommendation1RightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double num1 = 0.0;
         boolean consume = false;
         consume = true;
         if (itemstack.getItem() == JujutsucraftModItems.RECOMMENDATION_2.get()) {
            label219: {
               label218: {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr2 = (ServerPlayer)entity;
                     if (_plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_special"))).isDone()) {
                        break label218;
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr3 = (ServerPlayer)entity;
                     if (_plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1"))).isDone()) {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_special"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                        break label219;
                     }
                  }
               }

               consume = false;
            }
         } else {
            label202: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr5 = (ServerPlayer)entity;
                  if (_plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_4"))).isDone()) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr7 = (ServerPlayer)entity;
                        if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_3"))).isDone()) {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr9 = (ServerPlayer)entity;
                              if (_plr9.level() instanceof ServerLevel && _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2_semi"))).isDone()) {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr11 = (ServerPlayer)entity;
                                    if (_plr11.level() instanceof ServerLevel && _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2"))).isDone()) {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr13 = (ServerPlayer)entity;
                                          if (_plr13.level() instanceof ServerLevel && _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1_semi"))).isDone()) {
                                             if (entity instanceof ServerPlayer) {
                                                ServerPlayer _plr15 = (ServerPlayer)entity;
                                                if (_plr15.level() instanceof ServerLevel && _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1"))).isDone()) {
                                                   consume = false;
                                                   break label202;
                                                }
                                             }

                                             if (entity instanceof ServerPlayer) {
                                                ServerPlayer _player = (ServerPlayer)entity;
                                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1"));
                                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                   for(String criteria : _ap.getRemainingCriteria()) {
                                                      _player.getAdvancements().award(_adv, criteria);
                                                   }
                                                }
                                             }
                                             break label202;
                                          }
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _player = (ServerPlayer)entity;
                                          Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1_semi"));
                                          AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                          if (!_ap.isDone()) {
                                             for(String criteria : _ap.getRemainingCriteria()) {
                                                _player.getAdvancements().award(_adv, criteria);
                                             }
                                          }
                                       }
                                       break label202;
                                    }
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                                 break label202;
                              }
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _player = (ServerPlayer)entity;
                              Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2_semi"));
                              AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                              if (!_ap.isDone()) {
                                 for(String criteria : _ap.getRemainingCriteria()) {
                                    _player.getAdvancements().award(_adv, criteria);
                                 }
                              }
                           }
                           break label202;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_3"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                     break label202;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_4"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
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

         if (consume) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            itemstack.shrink(1);
            WhenRespawnProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
