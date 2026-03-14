package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         if (itemstack.m_41720_() == JujutsucraftModItems.RECOMMENDATION_2.get()) {
            label219: {
               label218: {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr2 = (ServerPlayer)entity;
                     if (_plr2.m_9236_() instanceof ServerLevel && _plr2.m_8960_().m_135996_(_plr2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).m_8193_()) {
                        break label218;
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr3 = (ServerPlayer)entity;
                     if (_plr3.m_9236_() instanceof ServerLevel && _plr3.m_8960_().m_135996_(_plr3.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).m_8193_()) {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_special"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
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
                  if (_plr5.m_9236_() instanceof ServerLevel && _plr5.m_8960_().m_135996_(_plr5.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"))).m_8193_()) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr7 = (ServerPlayer)entity;
                        if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"))).m_8193_()) {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr9 = (ServerPlayer)entity;
                              if (_plr9.m_9236_() instanceof ServerLevel && _plr9.m_8960_().m_135996_(_plr9.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"))).m_8193_()) {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr11 = (ServerPlayer)entity;
                                    if (_plr11.m_9236_() instanceof ServerLevel && _plr11.m_8960_().m_135996_(_plr11.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_()) {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr13 = (ServerPlayer)entity;
                                          if (_plr13.m_9236_() instanceof ServerLevel && _plr13.m_8960_().m_135996_(_plr13.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"))).m_8193_()) {
                                             if (entity instanceof ServerPlayer) {
                                                ServerPlayer _plr15 = (ServerPlayer)entity;
                                                if (_plr15.m_9236_() instanceof ServerLevel && _plr15.m_8960_().m_135996_(_plr15.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).m_8193_()) {
                                                   consume = false;
                                                   break label202;
                                                }
                                             }

                                             if (entity instanceof ServerPlayer) {
                                                ServerPlayer _player = (ServerPlayer)entity;
                                                Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"));
                                                AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                                if (!_ap.m_8193_()) {
                                                   for(String criteria : _ap.m_8219_()) {
                                                      _player.m_8960_().m_135988_(_adv, criteria);
                                                   }
                                                }
                                             }
                                             break label202;
                                          }
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _player = (ServerPlayer)entity;
                                          Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"));
                                          AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                          if (!_ap.m_8193_()) {
                                             for(String criteria : _ap.m_8219_()) {
                                                _player.m_8960_().m_135988_(_adv, criteria);
                                             }
                                          }
                                       }
                                       break label202;
                                    }
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                                 break label202;
                              }
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _player = (ServerPlayer)entity;
                              Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"));
                              AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                              if (!_ap.m_8193_()) {
                                 for(String criteria : _ap.m_8219_()) {
                                    _player.m_8960_().m_135988_(_adv, criteria);
                                 }
                              }
                           }
                           break label202;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                     break label202;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            }
         }

         num1 = -200.0 - Math.random() * 20.0;
         if (consume && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.f_20549_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), num1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }

         consume = false;
         Vec3 _center = new Vec3(entity.m_20185_(), num1, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator instanceof Bat && entityiterator.m_6084_()) {
               consume = true;
               if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }
               break;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), 5);
         }

         if (consume) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            itemstack.m_41774_(1);
            WhenRespawnProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
