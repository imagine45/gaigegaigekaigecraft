package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.entity.CarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ChosoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade04Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade08Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade16Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade22Entity;
import org.imgaine.gaigegaigekaigecraft.entity.DagonEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DhruvLakdawallaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HabaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HanamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HanyuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HazenokiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.IshigoriRyuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoAshEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JujutsuSorcererEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.LarueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MiguelDancerEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MiguelEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NishimiyaMomoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NobaraKugisakiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PolymorphicSoulIsomerEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ReggieStarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShigemoHarutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.registries.ForgeRegistries;

public class SetTagProcedure {
   public SetTagProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         String registry_name = "";
         String place = "";
         String date = "";
         String guilt = "";
         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMaxHealth();
         } else {
            var10000 = -1.0F;
         }

         if (!(var10000 >= 200.0F) && !(entity instanceof CursedSpiritGrade16Entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMaxHealth();
            } else {
               var10000 = -1.0F;
            }

            if (!(var10000 >= 100.0F) && !(entity instanceof NishimiyaMomoEntity) && !(entity instanceof PolymorphicSoulIsomerEntity)) {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:24}]}");
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:48}]}");
            }
         } else if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:96}]}");
         }

         entity.getPersistentData().putDouble("cnt_target", 1.0);
         entity.getPersistentData().putBoolean("jjkChara", true);
         entity.getPersistentData().putBoolean("UseCursedTechnique", true);
         if ((entity instanceof GojoSatoruEntity || entity instanceof SukunaEntity || entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity || entity instanceof ZeninNaoyaCursedSpiritEntity || entity instanceof CursedSpiritGrade13Entity || entity instanceof ShikigamiPterosaurEntity) && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Attributes:[{Name:generic.follow_range,Base:200}]}");
         }

         if (!(entity instanceof GojoSatoruEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
            if (entity instanceof ItadoriYujiShinjukuEntity && entity instanceof LivingEntity) {
               LivingEntity _livingEntity25 = (LivingEntity)entity;
               if (_livingEntity25.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                  _livingEntity25.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(10.0);
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity23 = (LivingEntity)entity;
            if (_livingEntity23.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
               _livingEntity23.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(20.0);
            }
         }

         if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity && entity instanceof LivingEntity) {
            LivingEntity _livingEntity27 = (LivingEntity)entity;
            if (_livingEntity27.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               _livingEntity27.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0);
            }
         }

         if (entity instanceof CarEntity && entity instanceof CarEntity) {
            CarEntity animatable = (CarEntity)entity;
            RandomSource var10001 = RandomSource.create();
            animatable.setTexture("car" + Math.round((float)Mth.nextInt(var10001, 1, 4)));
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 9, false, false));
            }
         }

         for(Entity entityiterator : new ArrayList<Entity>(world.players())) {
            if (entity instanceof HigurumaHiromiEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr33 = (ServerPlayer)entityiterator;
                  if (_plr33.level() instanceof ServerLevel && _plr33.getAdvancements().getOrStartProgress(_plr33.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_hiromi_higuruma"))).isDone()) {
                     entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity instanceof KashimoHajimeEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr36 = (ServerPlayer)entityiterator;
                  if (_plr36.level() instanceof ServerLevel && _plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_hajime_kashimo"))).isDone()) {
                     entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity instanceof IshigoriRyuEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr39 = (ServerPlayer)entityiterator;
                  if (_plr39.level() instanceof ServerLevel && _plr39.getAdvancements().getOrStartProgress(_plr39.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_ryu_ishigori"))).isDone()) {
                     entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting")))) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr42 = (ServerPlayer)entityiterator;
                  if (_plr42.level() instanceof ServerLevel && _plr42.getAdvancements().getOrStartProgress(_plr42.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_choso"))).isDone()) {
                     entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else {
               if (!(entity instanceof MiguelEntity) && !(entity instanceof LarueEntity)) {
                  break;
               }

               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr46 = (ServerPlayer)entityiterator;
                  if (_plr46.level() instanceof ServerLevel && _plr46.getAdvancements().getOrStartProgress(_plr46.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_suguru_geto"))).isDone()) {
                     entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
                     entity.getPersistentData().putBoolean("CurseUser", false);
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
                  _datEntSetI.getEntityData().set(JujutsuSorcererEntity.DATA_power, (int)NUM1);
               }
            } else if (entity instanceof CurseUserEntity && entity instanceof CurseUserEntity) {
               CurseUserEntity _datEntSetI = (CurseUserEntity)entity;
               _datEntSetI.getEntityData().set(CurseUserEntity.DATA_power, (int)NUM1);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity56 = (LivingEntity)entity;
               if (_livingEntity56.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                  _livingEntity56.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0 + NUM1 * 12.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               float var169;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var169 = _livEnt.getMaxHealth();
               } else {
                  var169 = -1.0F;
               }

               _entity.setHealth(var169);
            }

            if (Math.random() < 0.25) {
               NUM2 = (double)Math.round(Math.random() * 10.0);
               if (NUM2 == 0.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KIRARA_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KIRARA_HELMET.get()));
                  }
               } else if (NUM2 == 1.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_HELMET.get()));
                  }
               } else if (NUM2 == 2.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                  }
               } else if (NUM2 == 3.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_GETO_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_GETO_HELMET.get()));
                  }
               } else if (NUM2 == 4.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                  }
               } else if (NUM2 == 5.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_JOGO_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_JOGO_HELMET.get()));
                  }
               } else if (NUM2 == 6.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()));
                  }
               } else if (NUM2 == 7.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()));
                  }
               } else if (NUM2 == 8.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                  }
               } else if (NUM2 == 9.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                  }
               } else if (NUM2 == 10.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_HELMET.get()));
                  }
               }
            }

            if (Math.random() < 0.25) {
               NUM2 = (double)Math.round(Math.random() * 10.0);
               if (NUM2 == 0.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                  }
               } else if (NUM2 == 1.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == 2.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == 3.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == 4.0) {
                  if (Math.random() < 0.5) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_CHESTPLATE.get()));
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_CHESTPLATE.get()));
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                     }
                  } else {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()));
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()));
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()));
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()));
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == 5.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == 6.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                  }
               } else if (NUM2 == 7.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_BOOTS.get()));
                  }
               } else if (NUM2 == 8.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == 9.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                  }
               } else if (NUM2 == 10.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               }
            }

            if (Math.random() < 0.5) {
               NUM2 = (double)Math.round(Math.random() * 10.0);
               if (NUM2 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_BLACK.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 2.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 3.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NYOI_STAFF.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 4.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SICKLE.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SICKLE.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.KNIFE.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 6.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.SHEARS)).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.SHEARS)).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 7.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.IRON_SWORD)).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 8.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.IRON_AXE)).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 9.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.IRON_PICKAXE)).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (NUM2 == 10.0 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack(Items.IRON_HOE)).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }
            }
         }

         if (!(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity) && !(entity instanceof JogoEntity) && !(entity instanceof JogoAshEntity) && !(entity instanceof MahitoEntity) && !(entity instanceof DagonEntity) && !(entity instanceof HanamiEntity) && !(entity instanceof ChosoEntity) && !(entity instanceof CursedSpiritGrade22Entity) && !(entity instanceof ShigemoHarutaEntity)) {
            if (entity instanceof HigurumaHiromiEntity) {
               place = Component.translatable("text.morioka").getString();
               date = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2016").replace("MM", GetMonthProcedure.execute("03")).replace("dd", "■■");
               guilt = Component.translatable("jujutsu.message.higuruma14").getString().replace("[entity]", "■■■■, ■■■■");
               entity.getPersistentData().putDouble("kill_count", 2.0);
            } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof NobaraKugisakiEntity)) {
               if (entity instanceof GetoSuguruCurseUserEntity) {
                  place = Component.translatable("text.unknown_village1").getString();
                  date = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2007").replace("MM", GetMonthProcedure.execute("09")).replace("dd", "9");
                  guilt = Component.translatable("jujutsu.message.higuruma15").getString();
                  entity.getPersistentData().putDouble("kill_count", 112.0);
               } else if (!(entity instanceof KenjakuEntity) && (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3"))) && !(entity instanceof CursedSpiritGrade08Entity) || entity instanceof MiguelEntity || entity instanceof MiguelDancerEntity)) {
                  if (!(entity instanceof HigurumaHiromiEntity) && !(entity instanceof KashimoHajimeEntity) && !(entity instanceof ReggieStarEntity) && !(entity instanceof HazenokiEntity) && !(entity instanceof HabaEntity) && !(entity instanceof HanyuEntity)) {
                     if (!(entity instanceof IshigoriRyuEntity) && !(entity instanceof UroTakakoEntity) && !(entity instanceof DhruvLakdawallaEntity) && !(entity instanceof CursedSpiritGrade04Entity)) {
                        registry_name = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString();
                        if (registry_name.contains("cursed_spirit_grade_0")) {
                           entity.getPersistentData().putDouble("kill_count", (double)Mth.nextInt(RandomSource.create(), 10, 20));
                        } else if (registry_name.contains("cursed_spirit_grade_1")) {
                           entity.getPersistentData().putDouble("kill_count", (double)Mth.nextInt(RandomSource.create(), 5, 10));
                        } else if (registry_name.contains("cursed_spirit_grade_2")) {
                           entity.getPersistentData().putDouble("kill_count", (double)Mth.nextInt(RandomSource.create(), 0, 3));
                        } else if (registry_name.contains("cursed_spirit_grade_3")) {
                           entity.getPersistentData().putDouble("kill_count", (double)Mth.nextInt(RandomSource.create(), 0, 1));
                        } else if (entity.getPersistentData().getBoolean("CurseUser") || !entity.getPersistentData().getBoolean("JujutsuSorcerer")) {
                           entity.getPersistentData().putDouble("kill_count", (double)Mth.nextInt(RandomSource.create(), 0, 1));
                        }

                        if (entity.getPersistentData().getDouble("kill_count") > 0.0) {
                           place = "■■";
                           date = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "■■■■").replace("MM", "■■").replace("dd", "■■");
                           guilt = entity.getPersistentData().getDouble("kill_count") >= 3.0 ? Component.translatable("jujutsu.message.higuruma15").getString() : Component.translatable("jujutsu.message.higuruma14").getString().replace("[entity]", "■■■■");
                        }
                     } else {
                        place = Component.translatable("text.miyagi").getString();
                        String var168 = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "1");
                        date = var168 + "-" + Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "12");
                        guilt = Component.translatable("jujutsu.message.higuruma15").getString();
                        entity.getPersistentData().putDouble("kill_count", 20.0);
                     }
                  } else {
                     place = Component.translatable("text.tokyo").getString();
                     String var167 = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "1");
                     date = var167 + "-" + Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "12");
                     guilt = Component.translatable("jujutsu.message.higuruma15").getString();
                     entity.getPersistentData().putDouble("kill_count", 20.0);
                  }
               } else {
                  if (entity instanceof CursedSpiritGrade08Entity) {
                     place = Component.translatable("text.kyoto").getString();
                  } else {
                     place = entity instanceof KenjakuEntity ? Component.translatable("text.shinjuku").getString() + ", " + Component.translatable("text.kyoto").getString() : Component.translatable("text.shinjuku").getString();
                  }

                  date = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2017").replace("MM", GetMonthProcedure.execute("12")).replace("dd", "24");
                  guilt = Component.translatable("jujutsu.message.higuruma15").getString();
                  entity.getPersistentData().putDouble("kill_count", 200.0);
               }
            } else {
               place = Component.translatable("text.saitama").getString();
               date = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", GetMonthProcedure.execute("06")).replace("dd", "9");
               String var166 = Component.translatable("jujutsu.message.higuruma14").getString();
               String var10002 = Component.translatable("entity.gaigegaigekaigecraft.eso").getString();
               guilt = var166.replace("[entity]", var10002 + ", " + Component.translatable("entity.gaigegaigekaigecraft.kechizu").getString());
               entity.getPersistentData().putDouble("kill_count", 2.0);
            }
         } else {
            place = Component.translatable("text.shibuya").getString();
            date = Component.translatable("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", GetMonthProcedure.execute("10")).replace("dd", "31");
            guilt = Component.translatable("jujutsu.message.higuruma15").getString();
            entity.getPersistentData().putDouble("kill_count", 100.0);
         }

         if (entity.getPersistentData().getDouble("kill_count") > 0.0) {
            entity.getPersistentData().putString("crime1", Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", guilt).replace("[date]", date).replace("[place]", place));
         }

         Gaigegaigekaigecraft.queueServerWork(1, () -> {
            if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
               entity.getPersistentData().putString("crime1", "");
            }

         });
      }
   }
}
