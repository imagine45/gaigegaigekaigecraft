package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoEntity;

@EventBusSubscriber
public class PlayAnimationEntityProcedure {
   public PlayAnimationEntityProcedure() {
   }

   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getSource(), event.getEntity());
      }

   }

   public static void execute(DamageSource damagesource, Entity entity) {
      execute((Event)null, damagesource, entity);
   }

   private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         boolean sword = false;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double NUM1 = 0.0;
         double rnd = 0.0;
         String ANIME_NAME = "";
         String STR1 = "";
         if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:start_animation"))) && entity instanceof GeoEntity && entity instanceof LivingEntity) {
            LivingEntity _livingEntity2 = (LivingEntity)entity;
            if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               double var10000;
               label341: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity3 = (LivingEntity)entity;
                     if (_livingEntity3.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var10000 = _livingEntity3.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                        break label341;
                     }
                  }

                  var10000 = 0.0;
               }

               label336: {
                  NUM1 = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity4 = (LivingEntity)entity;
                     if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        var10000 = _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).getBaseValue();
                        break label336;
                     }
                  }

                  var10000 = 0.0;
               }

               NUM2 = var10000;
               NUM1 += (double)(NUM1 <= -50.0 && NUM1 >= -100.0 ? 100 : 0);
               NUM3 = NUM1 >= 0.0 ? NUM1 % 100.0 : 100.0;
               sword = LogicSwordProcedure.execute(entity);
               STR1 = GetEntityAnimationProcedure.execute(entity);
               if (STR1.contains("_right")) {
                  STR1 = "left";
               } else if (STR1.contains("_left")) {
                  STR1 = "right";
               } else {
                  STR1 = Math.random() > 0.5 ? "right" : "left";
               }

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
                           ANIME_NAME = "sword_to_right";
                        } else {
                           String var28 = Math.random() < 0.25 ? "punch_" : "kick_";
                           ANIME_NAME = var28 + STR1;
                        }
                     } else if (NUM3 == 4.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = sword ? "sword_overhead" : "punch_overhead";
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = sword ? "sword_overhead2" : "punch_overhead2";
                        } else if (NUM2 == 2.0) {
                           ANIME_NAME = "punch_overhead";
                        } else if (NUM2 == 3.0) {
                           ANIME_NAME = "punch_overhead2";
                        } else if (NUM2 == 4.0) {
                           ANIME_NAME = "sword_overhead";
                        } else if (NUM2 == 5.0) {
                           ANIME_NAME = "sword_overhead2";
                        }
                     }
                  } else if (sword) {
                     ANIME_NAME = "sword_to_" + STR1;
                  } else {
                     String var27 = !(Math.random() < 0.25) && (!(NUM2 > 0.0) || !(NUM2 < 100.0)) ? "kick_" : "punch_";
                     ANIME_NAME = var27 + STR1;
                  }
               } else if (NUM3 == 20.0) {
                  if (NUM1 == 220.0) {
                     ANIME_NAME = "red";
                  } else {
                     ANIME_NAME = "domain_expansion1";
                  }
               } else if (NUM1 < 0.0) {
                  if (NUM1 >= -10.0) {
                     if (NUM1 == -1.0) {
                        ANIME_NAME = "backstep";
                     } else if (NUM1 == -2.0) {
                        ANIME_NAME = "death";
                     } else if (NUM1 == -3.0) {
                        ANIME_NAME = "right_arm_up";
                     } else if (NUM1 == -4.0) {
                        ANIME_NAME = "both_arm_front";
                     } else if (NUM1 == -5.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = "sword_to_right";
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = "sword_to_left";
                        }
                     }

                     if (NUM1 == -6.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = "kick_" + STR1;
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = "kashimo_kick";
                        } else if (NUM2 == 2.0) {
                           ANIME_NAME = "kick_right";
                        } else if (NUM2 == 3.0) {
                           ANIME_NAME = "kick_left";
                        } else if (NUM2 == 4.0) {
                           ANIME_NAME = "kick_rotate4";
                        }
                     } else if (NUM1 == -7.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = "punch_" + STR1;
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = "combo1";
                        } else if (NUM2 == 2.0) {
                           ANIME_NAME = "combo2";
                        } else if (NUM2 == 3.0) {
                           ANIME_NAME = "combo3";
                        }
                     } else if (NUM1 == -8.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = "rotation";
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = "rotation2";
                        } else if (NUM2 == 2.0) {
                           ANIME_NAME = "ragnaraku2";
                        }
                     } else if (NUM1 == -9.0) {
                        ANIME_NAME = "guard";
                     } else if (NUM1 == -10.0) {
                        ANIME_NAME = "fall1";
                     }
                  } else if (NUM1 >= -15.0) {
                     ANIME_NAME = "dance" + Math.round(NUM1 + 16.0);
                  } else if (NUM1 >= -20.0) {
                     if (NUM1 == -16.0) {
                        ANIME_NAME = NUM2 == 0.0 ? "simple_domain1" : "simple_domain2";
                     } else if (NUM1 == -17.0) {
                        ANIME_NAME = "clap";
                     } else if (NUM1 == -18.0) {
                        ANIME_NAME = "fly";
                     } else if (NUM1 == -19.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = "breath1";
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = "breath2";
                        }
                     } else if (NUM1 == -20.0) {
                        if (NUM2 == 0.0) {
                           ANIME_NAME = "step_back";
                        } else if (NUM2 == 1.0) {
                           ANIME_NAME = "step_right";
                        } else if (NUM2 == 2.0) {
                           ANIME_NAME = "step_left";
                        } else if (NUM2 == 3.0) {
                           ANIME_NAME = "step_front";
                        }
                     }
                  } else if (NUM1 >= -25.0) {
                     if (NUM1 == -21.0) {
                        ANIME_NAME = "invisibility";
                     } else if (NUM1 == -22.0 && NUM2 == 1.0) {
                        ANIME_NAME = "swim_butterfly";
                     }
                  }

                  if (NUM1 == -49.0) {
                     ANIME_NAME = "empty";
                  }
               } else {
                  if (NUM1 == 107.0) {
                     ANIME_NAME = "open";
                  } else if (NUM1 == 207.0) {
                     ANIME_NAME = "red";
                  } else if (NUM1 == 215.0) {
                     if (NUM2 == 0.0) {
                        ANIME_NAME = "charge1";
                     } else if (NUM2 == 1.0) {
                        ANIME_NAME = "charge2";
                     }
                  } else if (NUM1 == 618.0) {
                     ANIME_NAME = "ten_shadows_technique_mahoraga";
                  }

                  if (NUM1 == 406.0) {
                     ANIME_NAME = "burn_out";
                  } else if (NUM1 == 415.0) {
                     ANIME_NAME = "meteor";
                  }

                  if (NUM1 == 1706.0) {
                     ANIME_NAME = "kick_flying";
                  } else if (NUM1 == 1715.0) {
                     ANIME_NAME = "wifi";
                  } else if (NUM1 == 2015.0) {
                     ANIME_NAME = "plus_ultra";
                  }
               }

               if (!ANIME_NAME.isEmpty()) {
                  PlayAnimationEntity2Procedure.execute(entity, ANIME_NAME);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity5 = (LivingEntity)entity;
                  if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            }
         }

      }
   }
}
