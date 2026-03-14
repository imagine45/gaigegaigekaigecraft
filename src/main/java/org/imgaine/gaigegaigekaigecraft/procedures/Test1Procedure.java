package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class Test1Procedure {
   public Test1Procedure() {
   }

   @SubscribeEvent
   public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
      if (event.getHand() == event.getEntity().m_7655_()) {
         execute(event, event.getLevel(), (double)event.getPos().m_123341_(), (double)event.getPos().m_123342_(), (double)event.getPos().m_123343_(), event.getTarget(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      execute((Event)null, world, x, y, z, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         ItemStack ITEM1 = ItemStack.f_41583_;
         boolean SUCCESS = false;
         boolean Friend = false;
         boolean logic_a = false;
         String STR1 = "";
         String Name = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         if (sourceentity instanceof Player && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18.0 || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18.0) {
               label318: {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)sourceentity;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label318;
                     }
                  }

                  if (!(entity instanceof Player) && entity.m_6084_() && entity.getPersistentData().m_128471_("CursedSpirit") && entity.getPersistentData().m_128459_("select") == 0.0) {
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)sourceentity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                     }

                     int var10000;
                     label268: {
                        Friend = sourceentity.m_20149_().equals(entity.getPersistentData().m_128461_("OWNER_UUID")) && sourceentity.getPersistentData().m_128459_("friend_num") != 0.0 && sourceentity.getPersistentData().m_128459_("friend_num") == entity.getPersistentData().m_128459_("friend_num_worker");
                        logic_a = false;
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)sourceentity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label268;
                           }
                        }

                        var10000 = 0;
                     }

                     label263: {
                        NUM1 = (double)(var10000 + 1);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var64 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label263;
                           }
                        }

                        var64 = 0.0;
                     }

                     NUM2 = var64;
                     if (NUM1 >= 13.0) {
                        NUM1 = 13.0 + (NUM1 - 13.0) * 0.3;
                     }

                     if (NUM1 - 8.0 >= NUM2) {
                        logic_a = true;
                     } else {
                        double var65 = NUM2 + 4.0;
                        double var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = (double)_livEnt.m_21223_();
                        } else {
                           var10001 = -1.0;
                        }

                        var10001 = Math.max(var10001, 0.01);
                        double var10002;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10002 = (double)_livEnt.m_21233_();
                        } else {
                           var10002 = -1.0;
                        }

                        NUM3 = var65 * (var10001 / Math.max(var10002, 0.01));
                        if (NUM1 * 0.5 >= NUM3) {
                           logic_a = true;
                        }
                     }

                     if (entity.getPersistentData().m_128459_("friend_num_worker") != 0.0) {
                        logic_a = false;
                     }

                     if (Friend && !sourceentity.m_6144_() && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:rideable_entity")))) {
                        sourceentity.m_20329_(entity);
                     } else {
                        label323: {
                           if (!logic_a) {
                              label254: {
                                 if (sourceentity instanceof Player) {
                                    Player _plr = (Player)sourceentity;
                                    if (_plr.m_150110_().f_35937_) {
                                       break label254;
                                    }
                                 }

                                 if (!Friend) {
                                    break label323;
                                 }
                              }
                           }

                           if (sourceentity.getPersistentData().m_128459_("friend_num") != entity.getPersistentData().m_128459_("friend_num_worker") || sourceentity.getPersistentData().m_128459_("friend_num") != entity.getPersistentData().m_128459_("friend_num")) {
                              entity.getPersistentData().m_128347_("friend_num", 0.0);
                              entity.getPersistentData().m_128347_("friend_num_worker", 0.0);
                           }

                           x_pos = 0.0;
                           z_pos = 0.0;
                           if (!sourceentity.m_9236_().m_5776_() && sourceentity.m_20194_() != null) {
                              Commands var66 = sourceentity.m_20194_().m_129892_();
                              CommandSourceStack var69 = new CommandSourceStack(CommandSource.f_80164_, sourceentity.m_20182_(), sourceentity.m_20155_(), sourceentity.m_9236_() instanceof ServerLevel ? (ServerLevel)sourceentity.m_9236_() : null, 4, sourceentity.m_7755_().getString(), sourceentity.m_5446_(), sourceentity.m_9236_().m_7654_(), sourceentity);
                              long var71 = Math.round(x_pos);
                              var66.m_230957_(var69, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var71 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                           }

                           Name = entity.m_5446_().getString().equals("") ? "No Name" : entity.m_5446_().getString();
                           y_pos = 64.0 + Math.random() * 64.0;
                           NUM1 = 0.0;

                           for(int index0 = 0; index0 < 10000; ++index0) {
                              ++NUM1;
                              STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                              if (sourceentity.getPersistentData().m_128459_(STR1) == 0.0) {
                                 break;
                              }

                              if (sourceentity.getPersistentData().m_128461_(STR1 + "_name").equals(Name)) {
                                 y_pos = sourceentity.getPersistentData().m_128459_(STR1);
                                 break;
                              }
                           }

                           if (!Friend) {
                              ITEM1 = (new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_BALL.get())).m_41777_();
                              ITEM1.m_41784_().m_128359_("name_data", Name);
                              ITEM1.m_41784_().m_128359_("owner_name_data", sourceentity.m_5446_().getString());
                              ITEM1.m_41714_(Component.m_237113_(ITEM1.m_41784_().m_128461_("name_data")));
                              AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                              LazyOptional var67 = sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                              Objects.requireNonNull(_iitemhandlerref);
                              var67.ifPresent(_iitemhandlerref::set);
                              if (_iitemhandlerref.get() != null) {
                                 for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                    ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                    if (ITEM1.m_41611_().getString().equals(itemstackiterator.m_41611_().getString()) && ITEM1.m_41784_().m_128461_("name_data").equals(itemstackiterator.m_41784_().m_128461_("name_data")) && ITEM1.m_41784_().m_128461_("owner_name_data").equals(itemstackiterator.m_41784_().m_128461_("owner_name_data"))) {
                                       y_pos = itemstackiterator.m_41784_().m_128459_("y_data");
                                       break;
                                    }
                                 }
                              }

                              ITEM1.m_41784_().m_128347_("y_data", y_pos);
                              if (sourceentity instanceof Player) {
                                 Player _player = (Player)sourceentity;
                                 ItemStack _setstack = ITEM1.m_41777_();
                                 _setstack.m_41764_(1);
                                 ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 float var70;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var70 = _livEnt.m_21233_();
                                 } else {
                                    var70 = -1.0F;
                                 }

                                 _entity.m_21153_(var70);
                              }
                           }

                           entity.getPersistentData().m_128359_("owner_name_data", sourceentity.m_5446_().getString());
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "execute in jujutsucraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                           }

                           if (!Friend) {
                              EntityDieProcedure.execute(world, x, y, z, new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_286979_)), entity);
                           } else {
                              logic_a = false;
                              if (world instanceof ServerLevel) {
                                 ServerLevel _origLevel = (ServerLevel)world;
                                 LevelAccessor var37 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                                 if (var37 != null) {
                                    Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                                    for(Entity entityiterator : var37.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                       if (sourceentity != entityiterator && entity.m_5446_().getString().equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && sourceentity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                                          if (!logic_a) {
                                             logic_a = true;
                                             NUM1 = 0.0;

                                             for(int index1 = 0; index1 < 10000; ++index1) {
                                                ++NUM1;
                                                STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                                                if (sourceentity.getPersistentData().m_128459_(STR1) == 0.0 || sourceentity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString())) {
                                                   sourceentity.getPersistentData().m_128347_(STR1, y_pos);
                                                   sourceentity.getPersistentData().m_128359_(STR1 + "_name", entityiterator.m_5446_().getString());
                                                   break;
                                                }
                                             }

                                             sourceentity.getPersistentData().m_128347_(STR1 + "_num", 0.0);
                                          }

                                          sourceentity.getPersistentData().m_128347_(STR1 + "_num", sourceentity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
                                       }
                                    }
                                 }
                              }

                              sourceentity.getPersistentData().m_128379_("UpdateSkills", true);
                           }
                        }
                     }
                  }
               }
            }

            if (SUCCESS && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

      }
   }
}
