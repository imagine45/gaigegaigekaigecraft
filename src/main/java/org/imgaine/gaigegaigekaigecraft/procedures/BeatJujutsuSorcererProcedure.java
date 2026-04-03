package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HakariKinjiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HoshiKiraraEntity;
import org.imgaine.gaigegaigekaigecraft.entity.InoTakumaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.InumakiTogeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KamoNoritoshiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MechamaruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeiMeiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MiwaKasumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NanamiKentoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NishimiyaMomoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NobaraKugisakiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PandaNormalEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TodoAoiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TsukumoYukiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.YagaMasamichiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.YoshinoJunpeiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninChojuroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninJinichiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninMakiCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninMakiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaobitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninOgiEntity;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class BeatJujutsuSorcererProcedure {
   public BeatJujutsuSorcererProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         if (entity instanceof YoshinoJunpeiEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:junpei_yoshino"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
            if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
               if (entity instanceof NobaraKugisakiEntity) {
                  if (entityiterator instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entityiterator;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_nobara_kugisaki"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               } else if (entity instanceof YagaMasamichiEntity) {
                  if (entityiterator instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entityiterator;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_masamichi_yaga"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               } else if (entity instanceof PandaNormalEntity) {
                  if (entityiterator instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entityiterator;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_panda"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               } else if (!(entity instanceof ZeninMakiEntity) && !(entity instanceof ZeninMakiCullingGameEntity)) {
                  if (entity instanceof InumakiTogeEntity) {
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_toge_inumaki"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (!(entity instanceof OkkotsuYutaEntity) && !(entity instanceof OkkotsuYutaCullingGameEntity)) {
                     if (entity instanceof HakariKinjiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_kinji_hakari"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof HoshiKiraraEntity && entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_kirara_hoshi"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }

                     if (entity instanceof ZeninOgiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_ogi_zenin"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof ZeninChojuroEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_chojuro_zenin"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof ZeninJinichiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_jinichi_zenin"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof ZeninNaoyaEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_naoya_zenin"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof ZeninNaobitoEntity && entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_naobito_zenin"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }

                     if (entity instanceof MiwaKasumiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_kasumi_miwa"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof NishimiyaMomoEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_momo_nishimiya"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof KamoNoritoshiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_noritoshi_kamo"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof MechamaruEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_mechamaru"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof TodoAoiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_aoi_todo"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof KusakabeAtsuyaEntity && entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_atsuya_kusakabe"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }

                     if (entity instanceof MeiMeiEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_mei_mei"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof InoTakumaEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_takuma_ino"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof NanamiKentoEntity) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_kento_nanami"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity instanceof TsukumoYukiEntity && entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_yuki_tsukumo"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (entity instanceof OkkotsuYutaEntity) {
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_yuta_okkotsu"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (entity instanceof OkkotsuYutaCullingGameEntity && entityiterator instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entityiterator;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_yuta_okkotsu_2"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               } else if (entity instanceof ZeninMakiEntity) {
                  if (entityiterator instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entityiterator;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_maki_zenin"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               } else if (entity instanceof ZeninMakiCullingGameEntity && entityiterator instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entityiterator;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_maki_zenin_2"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            } else if (entity instanceof FushiguroMegumiEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entityiterator;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_megumi_fushiguro"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            } else if (entity instanceof FushiguroMegumiShibuyaEntity && entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_megumi_fushiguro_shibuya"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof ItadoriYujiEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_yuji_itadori"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof ItadoriYujiShibuyaEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_yuji_itadori_shibuya"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof ItadoriYujiShinjukuEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_yuji_itadori_shinjuku"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (entity instanceof GojoSatoruSchoolDaysEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_satoru_gojo"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof GojoSatoruEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_satoru_gojo_2"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (entity instanceof GetoSuguruEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_suguru_geto"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof GetoSuguruCurseUserEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_suguru_geto_2"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

      }
   }
}
