package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWitnessStandEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JudgemanEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class DeadlySentencingActiveProcedure {
   public DeadlySentencingActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label782: {
            Entity entity_a = null;
            boolean logic_a = false;
            ItemStack item_a = ItemStack.f_41583_;
            double num1 = 0.0;
            range = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double num3 = 0.0;
            double num2 = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label782;
               }
            }

            var10000 = 0.0;
         }

         double var52 = var10000;
         Entity _ent = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("takada_UUID"));
         if (!(_ent instanceof JudgemanEntity) && var52 % 20.0 == 10.0) {
            double var62 = (double)entity.m_146908_();
            double var59 = (double)entity.m_146909_();
            RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            double var43 = Math.toRadians((double)(entity.m_146908_() + 90.0F + 180.0F));
            double var49 = entity.m_20185_() + Math.cos(var43) * (double)(5.0F + entity.m_20205_());
            double var53 = entity.m_20186_();
            double var56 = entity.m_20189_() + Math.sin(var43) * (double)(5.0F + entity.m_20205_());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.JUDGEMAN.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var49, var53, var56), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(0.0F);
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.getPersistentData().m_128359_("takada_UUID", entityinstance.m_20149_());
                  entityinstance.getPersistentData().m_128379_("domain_entity", true);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  _ent = entityinstance;
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.m_146922_((float)var62);
            entity.m_146926_((float)var59);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         }

         if (_ent instanceof JudgemanEntity) {
            if (entity.getPersistentData().m_128459_("skill") != 2719.0) {
               label772: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var141 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                        break label772;
                     }
                  }

                  var141 = 0;
               }

               if (var141 > 0) {
                  _ent.m_7618_(Anchor.EYES, new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma")));
               } else {
                  double var44 = (double)(_ent.m_146908_() % 360.0F);
                  _ent.m_146922_(entity.m_146908_() % 360.0F);
                  _ent.m_146926_(entity.m_146909_());
                  _ent.m_5618_(_ent.m_146908_());
                  _ent.m_5616_(_ent.m_146908_());
                  _ent.f_19859_ = _ent.m_146908_();
                  _ent.f_19860_ = _ent.m_146909_();
                  if (_ent instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_ent;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  double var63 = var44 - (double)entity.m_146908_();
                  if (Math.abs(var63) > 180.0) {
                     _ent.m_146922_((float)(var44 + Math.min(4.0, Math.abs(var63)) * (double)(var63 < 0.0 ? -1 : 1)));
                     _ent.m_146926_(entity.m_146909_());
                     _ent.m_5618_(_ent.m_146908_());
                     _ent.m_5616_(_ent.m_146908_());
                     _ent.f_19859_ = _ent.m_146908_();
                     _ent.f_19860_ = _ent.m_146909_();
                     if (_ent instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)_ent;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     _ent.m_146922_((float)(var44 + Math.min(4.0, Math.abs(var63)) * (double)(var63 > 0.0 ? -1 : 1)));
                     _ent.m_146926_(entity.m_146909_());
                     _ent.m_5618_(_ent.m_146908_());
                     _ent.m_5616_(_ent.m_146908_());
                     _ent.f_19859_ = _ent.m_146908_();
                     _ent.f_19860_ = _ent.m_146909_();
                     if (_ent instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)_ent;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }
               }

               double var45 = Math.toRadians((double)(_ent.m_146908_() + 90.0F + 180.0F));
               double var50 = entity.m_20185_() + Math.cos(var45) * (double)(5.0F + entity.m_20205_());
               double var54 = entity.m_20186_();
               double var57 = entity.m_20189_() + Math.sin(var45) * (double)(5.0F + entity.m_20205_());
               _ent.m_6021_(_ent.m_20185_() + Math.min(0.25, Math.abs(var50 - _ent.m_20185_())) * (double)(var50 > _ent.m_20185_() ? 1 : -1), _ent.m_20186_() + Math.min(0.25, Math.abs(var54 - _ent.m_20186_())) * (double)(var54 > _ent.m_20186_() ? 1 : -1), _ent.m_20189_() + Math.min(0.25, Math.abs(var57 - _ent.m_20189_())) * (double)(var57 > _ent.m_20189_() ? 1 : -1));
               if (_ent instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                  _serverPlayer.f_8906_.m_9774_(_ent.m_20185_() + Math.min(0.25, Math.abs(var50 - _ent.m_20185_())) * (double)(var50 > _ent.m_20185_() ? 1 : -1), _ent.m_20186_() + Math.min(0.25, Math.abs(var54 - _ent.m_20186_())) * (double)(var54 > _ent.m_20186_() ? 1 : -1), _ent.m_20189_() + Math.min(0.25, Math.abs(var57 - _ent.m_20189_())) * (double)(var57 > _ent.m_20189_() ? 1 : -1), _ent.m_146908_(), _ent.m_146909_());
               }
            }

            _ent.m_20256_(new Vec3(0.0, 0.0, 0.0));
            if (!entity.m_6084_() && !_ent.m_9236_().m_5776_() && _ent.m_20194_() != null) {
               _ent.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent), "kill @s");
            }
         }

         if (!entity.getPersistentData().m_128471_("Failed") || entity.getPersistentData().m_128459_("skill") == 2719.0) {
            entity.getPersistentData().m_128379_("DomainAttack", false);
            if (var52 % 20.0 == 10.0) {
               if (entity.getPersistentData().m_128459_("skill") == 2719.0 && entity.getPersistentData().m_128459_("cnt3") >= 20.0) {
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                     double var10001;
                     int var10002;
                     label754: {
                        var10000 = Math.random() * 100.0;
                        var10001 = entity.getPersistentData().m_128459_("cnt4");
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label754;
                           }
                        }

                        var10002 = 0;
                     }

                     if (var10000 <= var10001 * Math.min((double)(var10002 + 1) * 0.1, 1.0)) {
                        entity.getPersistentData().m_128347_("cnt2", 0.0);
                     } else {
                        entity.getPersistentData().m_128347_("cnt2", 1.0);
                     }
                  }
               }

               double var46;
               double var60;
               double var64;
               label749: {
                  var46 = 0.0;
                  var64 = 0.0;
                  var60 = 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var143 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                        break label749;
                     }
                  }

                  var143 = 0;
               }

               if (var143 < 1) {
                  ++var46;
               }

               ItemStack var42 = (new ItemStack((ItemLike)JujutsucraftModItems.EXECUTIONERS_SWORD.get())).m_41777_();
               Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator) {
                     if (entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                        if (entity.getPersistentData().m_128459_("skill") == 2719.0) {
                           if (entity.getPersistentData().m_128459_("cnt3") >= 20.0) {
                              if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma1").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }

                                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                    entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma1").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().m_128459_("cnt1") == 2.0) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma2").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }

                                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                    entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma2").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().m_128459_("cnt1") == 3.0) {
                                 if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma3").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                    }

                                    if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                       entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma3").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                    }
                                 } else {
                                    entity.getPersistentData().m_128347_("cnt1", 4.0);
                                 }
                              } else if (entity.getPersistentData().m_128459_("cnt1") >= 5.0 && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 boolean var41 = false;
                                 AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                 LazyOptional var144 = entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                 Objects.requireNonNull(_iitemhandlerref);
                                 var144.ifPresent(_iitemhandlerref::set);
                                 if (_iitemhandlerref.get() != null) {
                                    for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                       ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                       if (itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                          var41 = true;
                                          if (entityiterator instanceof Player) {
                                             Player _player = (Player)entityiterator;
                                             _player.m_36335_().m_41524_(itemstackiterator.m_41720_(), 1800);
                                          }
                                       }
                                    }
                                 }

                                 if (!(entityiterator instanceof Player)) {
                                    ItemStack var145;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                       var145 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                    } else {
                                       var145 = ItemStack.f_41583_;
                                    }

                                    if (var145.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                       var41 = true;
                                       if (entityiterator instanceof Player) {
                                          Player _player = (Player)entityiterator;
                                          ItemCooldowns var146 = _player.m_36335_();
                                          ItemStack var164;
                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                             var164 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                          } else {
                                             var164 = ItemStack.f_41583_;
                                          }

                                          var146.m_41524_(var164.m_41720_(), 3600);
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       var145 = _livEnt.m_21205_();
                                    } else {
                                       var145 = ItemStack.f_41583_;
                                    }

                                    if (var145.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                       var41 = true;
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                                          _setstack.m_41764_(1);
                                          _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                          if (_entity instanceof Player) {
                                             Player _player = (Player)_entity;
                                             _player.m_150109_().m_6596_();
                                          }
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       var145 = _livEnt.m_21206_();
                                    } else {
                                       var145 = ItemStack.f_41583_;
                                    }

                                    if (var145.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                       var41 = true;
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                                          _setstack.m_41764_(1);
                                          _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                                          if (_entity instanceof Player) {
                                             Player _player = (Player)_entity;
                                             _player.m_150109_().m_6596_();
                                          }
                                       }
                                    }
                                 }

                                 if (!var41) {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 1800, 0, false, false));
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 1800, 2, false, false));
                                       }
                                    }
                                 }

                                 if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
                                    var46 = 0.0;

                                    for(int index0 = 0; index0 < 200; ++index0) {
                                       ++var46;
                                       if (var42.m_41784_().m_128461_("TARGET" + Math.round(var46)).isEmpty()) {
                                          var42.m_41784_().m_128359_("TARGET" + Math.round(var46), entityiterator.m_20149_());
                                          break;
                                       }
                                    }
                                 }
                              }
                           } else if (LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              if (entityiterator instanceof HigurumaHiromiEntity) {
                                 entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4"), 1.0));
                              } else {
                                 label706: {
                                    label705: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt132 = (LivingEntity)entityiterator;
                                          if (_livEnt132.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                             break label705;
                                          }
                                       }

                                       if (!(entityiterator instanceof MahitoEntity)) {
                                          if (!entityiterator.getPersistentData().m_128471_("CurseUser") && !entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof ItadoriYujiEntity) && !(entityiterator instanceof ItadoriYujiShibuyaEntity)) {
                                             if (entityiterator.getPersistentData().m_128471_("JujutsuSorcerer")) {
                                                entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4"), 10.0));
                                             } else {
                                                entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4"), 25.0));
                                             }
                                          } else {
                                             entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4"), 50.0));
                                          }
                                          break label706;
                                       }
                                    }

                                    entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4"), 100.0));
                                 }
                              }
                           }
                        } else if (LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                           label809: {
                              if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 label689: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                          var149 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                          break label689;
                                       }
                                    }

                                    var149 = 0;
                                 }

                                 if (var149 < 1) {
                                    break label809;
                                 }
                              }

                              label682: {
                                 ++var60;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var150 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                       break label682;
                                    }
                                 }

                                 var150 = 0;
                              }

                              if (var150 < 1) {
                                 ++var46;
                              }
                           }
                        }
                     }

                     if (entityiterator.getPersistentData().m_128459_("Damage") > 0.0 || entityiterator.getPersistentData().m_128459_("cnt6") != 0.0) {
                        if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }

                        if (entityiterator.getPersistentData().m_128459_("skill") > 0.0) {
                           entityiterator.getPersistentData().m_128347_("skill", 0.0);
                        }
                     }
                  }

                  if (entityiterator instanceof EntityWitnessStandEntity) {
                     ++var64;
                  }
               }

               if (entity.getPersistentData().m_128459_("skill") == 2719.0) {
                  if (entity.getPersistentData().m_128459_("cnt1") >= 5.0) {
                     if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
                        var42.m_41784_().m_128359_("OWNER_UUID", entity.m_20149_());
                        if (!(entity instanceof Player)) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = var42.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else {
                           ItemStack var155;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var155 = _livEnt.m_21205_();
                           } else {
                              var155 = ItemStack.f_41583_;
                           }

                           label604: {
                              if (var155.m_41720_() != JujutsucraftModItems.GAVEL.get()) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var155 = _livEnt.m_21205_();
                                 } else {
                                    var155 = ItemStack.f_41583_;
                                 }

                                 if (var155.m_41720_() != JujutsucraftModItems.GAVEL_LONG.get()) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var155 = _livEnt.m_21205_();
                                    } else {
                                       var155 = ItemStack.f_41583_;
                                    }

                                    if (var155.m_41720_() != JujutsucraftModItems.GAVEL_BIG.get()) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          var155 = _livEnt.m_21205_();
                                       } else {
                                          var155 = ItemStack.f_41583_;
                                       }

                                       if (var155.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             var155 = _livEnt.m_21206_();
                                          } else {
                                             var155 = ItemStack.f_41583_;
                                          }

                                          if (var155.m_41720_() != JujutsucraftModItems.GAVEL.get()) {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                var155 = _livEnt.m_21206_();
                                             } else {
                                                var155 = ItemStack.f_41583_;
                                             }

                                             if (var155.m_41720_() != JujutsucraftModItems.GAVEL_LONG.get()) {
                                                if (entity instanceof LivingEntity) {
                                                   LivingEntity _livEnt = (LivingEntity)entity;
                                                   var155 = _livEnt.m_21206_();
                                                } else {
                                                   var155 = ItemStack.f_41583_;
                                                }

                                                if (var155.m_41720_() != JujutsucraftModItems.GAVEL_BIG.get()) {
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      var155 = _livEnt.m_21206_();
                                                   } else {
                                                      var155 = ItemStack.f_41583_;
                                                   }

                                                   if (var155.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                                      var46 = 0.0;
                                                      AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                                      LazyOptional var163 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                                      Objects.requireNonNull(_iitemhandlerref);
                                                      var163.ifPresent(_iitemhandlerref::set);
                                                      if (_iitemhandlerref.get() != null) {
                                                         for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                                            ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                                            if (itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                                               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                                                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s container." + Math.round(var46) + " with air");
                                                               }
                                                               break;
                                                            }

                                                            ++var46;
                                                         }
                                                      }

                                                      if (entity instanceof Player) {
                                                         Player _player = (Player)entity;
                                                         ItemStack _setstack = var42.m_41777_();
                                                         _setstack.m_41764_(1);
                                                         ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                                      }
                                                      break label604;
                                                   }
                                                }
                                             }
                                          }

                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             ItemStack _setstack = var42.m_41777_();
                                             _setstack.m_41764_(1);
                                             _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                                             if (_entity instanceof Player) {
                                                Player _player = (Player)_entity;
                                                _player.m_150109_().m_6596_();
                                             }
                                          }
                                          break label604;
                                       }
                                    }
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = var42.m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                           }

                           if (world.m_5776_()) {
                              Minecraft.m_91087_().f_91063_.m_109113_(new ItemStack((ItemLike)JujutsucraftModItems.EXECUTIONERS_SWORD.get()));
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * 0.5, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F);
                           } else {
                              _level.m_7785_(x, y + (double)entity.m_20206_() * 0.5, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * 0.5, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y + (double)entity.m_20206_() * 0.5, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123810_, x, y + (double)entity.m_20206_() * 0.5, z, 25, 0.25, 0.25, 0.25, 0.25);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_36335_().m_41524_((Item)JujutsucraftModItems.EXECUTIONERS_SWORD.get(), 0);
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                     }

                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               } else if (var46 > 1.0 || var46 > 0.0 && var60 > 1.0) {
                  if (var64 < var60) {
                     label665: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                              var151 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                              break label665;
                           }
                        }

                        var151 = 0;
                     }

                     if (var151 >= 1 && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get());
                     }

                     _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                           label649: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    var152 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                    break label649;
                                 }
                              }

                              var152 = 0;
                           }

                           if (var152 >= 1 && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get());
                           }
                        }

                        if (entityiterator instanceof EntityWitnessStandEntity && !entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }
                     }

                     var46 = var60;
                  }

                  var64 = 0.0;
                  var60 = (double)entity.m_146908_();

                  for(int index1 = 0; index1 < (int)Math.round(var46); ++index1) {
                     label802: {
                        ++var64;
                        _ent = null;
                        if (var64 <= 1.0) {
                           label635: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    var153 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                    break label635;
                                 }
                              }

                              var153 = 0;
                           }

                           if (var153 < 1) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 5, 1, false, false));
                                 }
                              }

                              _ent = entity;
                              break label802;
                           }
                        }

                        Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                              label621: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var154 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                       break label621;
                                    }
                                 }

                                 var154 = 0;
                              }

                              if (var154 < 1) {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 5, 1, false, false));
                                    }
                                 }

                                 _ent = entityiterator;
                                 break;
                              }
                           }
                        }
                     }

                     if (!(_ent instanceof LivingEntity)) {
                        break;
                     }

                     double var51 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.cos(Math.toRadians(var60)) * Math.min(4.0 + var46 * 0.3, range * 0.5 * 0.5);
                     double var55 = entity.getPersistentData().m_128459_("y_pos_doma");
                     double var58 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.sin(Math.toRadians(var60)) * Math.min(4.0 + var46 * 0.3, range * 0.5 * 0.5);
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WITNESS_STAND.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var51, var55, var58), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                              entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                           }

                           entityinstance.m_146922_((float)(var60 + 90.0));
                           entityinstance.m_146926_(0.0F);
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           entityinstance.getPersistentData().m_128359_("TARGET", _ent.m_20149_());
                           _ent.m_146922_(entityinstance.m_146908_());
                           _ent.m_146926_(0.0F);
                           _ent.m_5618_(_ent.m_146908_());
                           _ent.m_5616_(_ent.m_146908_());
                           _ent.f_19859_ = _ent.m_146908_();
                           _ent.f_19860_ = _ent.m_146909_();
                           if (_ent instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)_ent;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     var60 += 360.0 / var46;
                  }
               }
            }

            entity.getPersistentData().m_128379_("DomainAttack", false);
         }

      }
   }
}
