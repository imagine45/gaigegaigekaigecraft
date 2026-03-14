package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import org.imgaine.gaigegaigekaigecraft.entity.CarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade16Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.IshigoriRyuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JujutsuSorcererEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.LarueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MiguelEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NishimiyaMomoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SetTagProcedure {
   public SetTagProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21233_();
         } else {
            var10000 = -1.0F;
         }

         if (!(var10000 >= 200.0F) && !(entity instanceof CursedSpiritGrade16Entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21233_();
            } else {
               var10000 = -1.0F;
            }

            if (!(var10000 >= 100.0F) && !(entity instanceof NishimiyaMomoEntity)) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:24}]}");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:48}]}");
            }
         } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:96}]}");
         }

         entity.getPersistentData().m_128347_("cnt_target", 1.0);
         entity.getPersistentData().m_128379_("jjkChara", true);
         entity.getPersistentData().m_128379_("UseCursedTechnique", true);
         if ((entity instanceof GojoSatoruEntity || entity instanceof SukunaEntity || entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity || entity instanceof ZeninNaoyaCursedSpiritEntity || entity instanceof CursedSpiritGrade13Entity || entity instanceof ShikigamiPterosaurEntity) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Attributes:[{Name:generic.follow_range,Base:200}]}");
         }

         if (!(entity instanceof GojoSatoruEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
            if (entity instanceof ItadoriYujiShinjukuEntity && entity instanceof LivingEntity) {
               LivingEntity _livingEntity24 = (LivingEntity)entity;
               if (_livingEntity24.m_21204_().m_22171_(Attributes.f_22285_)) {
                  _livingEntity24.getAttribute_(Attributes.f_22285_).m_22100_(10.0);
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity22 = (LivingEntity)entity;
            if (_livingEntity22.m_21204_().m_22171_(Attributes.f_22285_)) {
               _livingEntity22.getAttribute_(Attributes.f_22285_).m_22100_(20.0);
            }
         }

         if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity && entity instanceof LivingEntity) {
            LivingEntity _livingEntity26 = (LivingEntity)entity;
            if (_livingEntity26.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               _livingEntity26.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(2.0);
            }
         }

         if (entity instanceof CarEntity && entity instanceof CarEntity) {
            CarEntity animatable = (CarEntity)entity;
            RandomSource var10001 = RandomSource.m_216327_();
            animatable.setTexture("car" + Math.round((float)Mth.m_216271_(var10001, 1, 4)));
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 5, 9, false, false));
            }
         }

         for(Entity entityiterator : new ArrayList(world.m_6907_())) {
            if (entity instanceof HigurumaHiromiEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr32 = (ServerPlayer)entityiterator;
                  if (_plr32.m_9236_() instanceof ServerLevel && _plr32.m_8960_().m_135996_(_plr32.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hiromi_higuruma"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity instanceof KashimoHajimeEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr35 = (ServerPlayer)entityiterator;
                  if (_plr35.m_9236_() instanceof ServerLevel && _plr35.m_8960_().m_135996_(_plr35.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hajime_kashimo"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity instanceof IshigoriRyuEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr38 = (ServerPlayer)entityiterator;
                  if (_plr38.m_9236_() instanceof ServerLevel && _plr38.m_8960_().m_135996_(_plr38.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_ryu_ishigori"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr41 = (ServerPlayer)entityiterator;
                  if (_plr41.m_9236_() instanceof ServerLevel && _plr41.m_8960_().m_135996_(_plr41.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_choso"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else {
               if (!(entity instanceof MiguelEntity) && !(entity instanceof LarueEntity)) {
                  break;
               }

               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr45 = (ServerPlayer)entityiterator;
                  if (_plr45.m_9236_() instanceof ServerLevel && _plr45.m_8960_().m_135996_(_plr45.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_suguru_geto"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     entity.getPersistentData().m_128379_("CurseUser", false);
                     break;
                  }
               }
            }
         }

         if (entity instanceof JujutsuSorcererEntity || entity instanceof CurseUserEntity) {
            NUM1 = (double)Math.round(10.0 * Math.random() * Math.random());
            if (entity instanceof JujutsuSorcererEntity) {
               if (entity instanceof JujutsuSorcererEntity) {
                  JujutsuSorcererEntity _datEntSetI = (JujutsuSorcererEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(JujutsuSorcererEntity.DATA_power, (int)NUM1);
               }
            } else if (entity instanceof CurseUserEntity && entity instanceof CurseUserEntity) {
               CurseUserEntity _datEntSetI = (CurseUserEntity)entity;
               _datEntSetI.m_20088_().m_135381_(CurseUserEntity.DATA_power, (int)NUM1);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity55 = (LivingEntity)entity;
               if (_livingEntity55.m_21204_().m_22171_(Attributes.f_22276_)) {
                  _livingEntity55.getAttribute_(Attributes.f_22276_).m_22100_(40.0 + NUM1 * 12.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               float var161;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var161 = _livEnt.m_21233_();
               } else {
                  var161 = -1.0F;
               }

               _entity.m_21153_(var161);
            }

            if (Math.random() < 0.25) {
               NUM2 = (double)Math.round(Math.random() * 10.0);
               if (NUM2 == 0.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KIRARA_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KIRARA_HELMET.get()));
                  }
               } else if (NUM2 == 1.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_HELMET.get()));
                  }
               } else if (NUM2 == 2.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                  }
               } else if (NUM2 == 3.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_GETO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_GETO_HELMET.get()));
                  }
               } else if (NUM2 == 4.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                  }
               } else if (NUM2 == 5.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_JOGO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_JOGO_HELMET.get()));
                  }
               } else if (NUM2 == 6.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()));
                  }
               } else if (NUM2 == 7.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()));
                  }
               } else if (NUM2 == 8.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                  }
               } else if (NUM2 == 9.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                  }
               } else if (NUM2 == 10.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_HELMET.get()));
                  }
               }
            }

            if (Math.random() < 0.25) {
               NUM2 = (double)Math.round(Math.random() * 10.0);
               if (NUM2 == 0.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                  }
               } else if (NUM2 == 1.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == 2.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == 3.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == 4.0) {
                  if (Math.random() < 0.5) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_CHESTPLATE.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_CHESTPLATE.get()));
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                     }
                  } else {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()));
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()));
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == 5.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == 6.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                  }
               } else if (NUM2 == 7.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_BOOTS.get()));
                  }
               } else if (NUM2 == 8.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == 9.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                  }
               } else if (NUM2 == 10.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               }
            }

            if (Math.random() < 0.5) {
               NUM2 = (double)Math.round(Math.random() * 10.0);
               if (NUM2 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_BLACK.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 2.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 3.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NYOI_STAFF.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 4.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SICKLE.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SICKLE.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.KNIFE.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 6.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42574_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42574_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 7.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42383_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 8.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42386_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 9.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42385_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == 10.0 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack(Items.f_42387_)).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            }
         }

      }
   }
}
