package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.network.PacketDistributor;

@EventBusSubscriber
public class PlayAnimationIfPossibleProcedure {
   public PlayAnimationIfPossibleProcedure() {
   }

   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getSource(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
      execute((Event)null, world, damagesource, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         boolean sword = false;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         String animation_name = "";
         if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:start_animation"))) && entity instanceof Player) {
            double var10000;
            label331: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     var10000 = _livingEntity2.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                     break label331;
                  }
               }

               var10000 = 0.0;
            }

            label326: {
               NUM1 = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity3 = (LivingEntity)entity;
                  if (_livingEntity3.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     var10000 = _livingEntity3.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).getBaseValue();
                     break label326;
                  }
               }

               var10000 = 0.0;
            }

            NUM2 = var10000;
            NUM1 += (double)(NUM1 <= -50.0 && NUM1 >= -100.0 ? 100 : 0);
            NUM3 = NUM1 >= 0.0 ? NUM1 % 100.0 : 100.0;
            sword = LogicSwordProcedure.execute(entity);
            STR1 = Math.random() > 0.5 ? "right" : "left";
            if (NUM3 >= 0.0 && NUM3 <= 4.0) {
               if (sword && NUM2 > 0.0) {
                  if (NUM2 != 1.0 && NUM2 != 2.0 && NUM2 != 3.0) {
                     if (NUM2 == 4.0 || NUM2 == 5.0 || NUM2 == 6.0) {
                        STR1 = "left";
                     }
                  } else {
                     STR1 = "right";
                  }
               }

               if (NUM3 != 0.0 && NUM3 != 2.0 && NUM3 != 3.0) {
                  if (NUM3 == 1.0) {
                     if (sword) {
                        animation_name = "sword_to_right";
                     } else {
                        String var25 = Math.random() < 0.25 ? "punch_" : "kick_";
                        animation_name = var25 + STR1;
                     }
                  } else if (NUM3 == 4.0) {
                     if (NUM2 == 0.0) {
                        animation_name = sword ? "sword_overhead" : "punch_overhead";
                     } else if (NUM2 == 1.0) {
                        animation_name = sword ? "sword_overhead2" : "punch_overhead2";
                     } else if (NUM2 == 2.0) {
                        animation_name = "punch_overhead";
                     } else if (NUM2 == 3.0) {
                        animation_name = "punch_overhead2";
                     } else if (NUM2 == 4.0) {
                        animation_name = "sword_overhead";
                     } else if (NUM2 == 5.0) {
                        animation_name = "sword_overhead2";
                     }
                  }
               } else if (sword) {
                  animation_name = "sword_to_" + STR1;
               } else {
                  String var24 = !(Math.random() < 0.25) && (!(NUM2 > 0.0) || !(NUM2 < 100.0)) ? "kick_" : "punch_";
                  animation_name = var24 + STR1;
               }
            } else if (NUM3 == 20.0) {
               if (NUM1 == 220.0) {
                  animation_name = "red";
               } else {
                  animation_name = "domain_expansion1";
               }
            } else if (NUM1 < 0.0) {
               if (NUM1 >= -10.0) {
                  if (NUM1 == -1.0) {
                     animation_name = "backstep";
                  } else if (NUM1 == -2.0) {
                     animation_name = "death";
                  } else if (NUM1 == -3.0) {
                     animation_name = "right_arm_up";
                  } else if (NUM1 == -4.0) {
                     animation_name = "both_arm_front";
                  } else if (NUM1 == -5.0) {
                     if (NUM2 == 0.0) {
                        animation_name = "sword_to_right";
                     } else if (NUM2 == 1.0) {
                        animation_name = "sword_to_left";
                     }
                  }

                  if (NUM1 == -6.0) {
                     if (NUM2 == 0.0) {
                        animation_name = "kick_" + STR1;
                     } else if (NUM2 == 1.0) {
                        animation_name = "kashimo_kick";
                     } else if (NUM2 == 2.0) {
                        animation_name = "kick_right";
                     } else if (NUM2 == 3.0) {
                        animation_name = "kick_left";
                     } else if (NUM2 == 4.0) {
                        animation_name = "kick_rotate4";
                     }
                  } else if (NUM1 == -7.0) {
                     if (NUM2 == 0.0) {
                        animation_name = "punch_" + STR1;
                     } else if (NUM2 == 1.0) {
                        animation_name = "combo1";
                     } else if (NUM2 == 2.0) {
                        animation_name = "combo2";
                     } else if (NUM2 == 3.0) {
                        animation_name = "combo3";
                     }
                  } else if (NUM1 == -8.0) {
                     if (NUM2 == 0.0) {
                        animation_name = "rotation";
                     } else if (NUM2 == 1.0) {
                        animation_name = "rotation2";
                     } else if (NUM2 == 2.0) {
                        animation_name = "ragnaraku2";
                     }
                  } else if (NUM1 == -9.0) {
                     animation_name = "guard";
                  } else if (NUM1 == -10.0) {
                     animation_name = "fall1";
                  }
               } else if (NUM1 >= -15.0) {
                  animation_name = "dance" + Math.round(NUM1 + 16.0);
               } else if (NUM1 >= -20.0) {
                  if (NUM1 == -16.0) {
                     animation_name = NUM2 == 0.0 ? "simple_domain1" : "simple_domain2";
                  } else if (NUM1 == -17.0) {
                     animation_name = "clap";
                  } else if (NUM1 == -18.0) {
                     animation_name = "fly";
                  } else if (NUM1 == -19.0) {
                     if (NUM2 == 0.0) {
                        animation_name = "breath1";
                     } else if (NUM2 == 1.0) {
                        animation_name = "breath2";
                     }
                  } else if (NUM1 == -20.0) {
                     if (NUM2 == 0.0) {
                        animation_name = "step_back";
                     } else if (NUM2 == 1.0) {
                        animation_name = "step_right";
                     } else if (NUM2 == 2.0) {
                        animation_name = "step_left";
                     } else if (NUM2 == 3.0) {
                        animation_name = "step_front";
                     }
                  }
               } else if (NUM1 >= -25.0) {
                  if (NUM1 == -21.0) {
                     animation_name = "invisibility";
                  } else if (NUM1 == -22.0 && NUM2 == 1.0) {
                     animation_name = "swim_butterfly";
                  }
               }

               if (NUM1 == -49.0) {
                  animation_name = "cancel";
               }
            } else {
               if (NUM1 == 107.0) {
                  animation_name = "open";
               } else if (NUM1 == 207.0) {
                  animation_name = "red";
               } else if (NUM1 == 215.0) {
                  if (NUM2 == 0.0) {
                     animation_name = "charge1";
                  } else if (NUM2 == 1.0) {
                     animation_name = "charge2";
                  }
               } else if (NUM1 == 618.0) {
                  animation_name = "ten_shadows_technique_mahoraga";
               }

               if (NUM1 == 1706.0) {
                  animation_name = "kick_flying";
               } else if (NUM1 == 1715.0) {
                  animation_name = "wifi";
               } else if (NUM1 == 2015.0) {
                  animation_name = "plus_ultra";
               }
            }

            if (!animation_name.isEmpty()) {
               if (world.isClientSide()) {
                  SetupAnimationsProcedure.setAnimationClientside((Player)entity, animation_name, true);
               } else {
                  if (entity instanceof ServerPlayer) {
                     Gaigegaigekaigecraft.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)entity), new SetupAnimationsProcedure.JujutsucraftModAnimationMessage(animation_name, entity.getId(), true));
                  }

                  Gaigegaigekaigecraft.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), new SetupAnimationsProcedure.JujutsucraftModAnimationMessage(animation_name, entity.getId(), true));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

      }
   }
}
