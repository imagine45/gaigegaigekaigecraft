package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class NishimiyaDomainExpansionActiveProcedure {
   public NishimiyaDomainExpansionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a;
         double num2;
         double range;
         double var10000;
         label168: {
            item_a = ItemStack.EMPTY;
            double ticks = 0.0;
            double HP = 0.0;
            double num1 = 0.0;
            range = 0.0;
            double rnd = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            num2 = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label168;
               }
            }

            var10000 = 0.0;
         }

         double var28 = var10000;
         if (!entity.getPersistentData().getBoolean("Failed") && var28 % 60.0 == 20.0) {
            int var10001;
            label160: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label160;
                  }
               }

               var10001 = 0;
            }

            double var29 = (double)(40 + var10001 * 4);

            for(int index0 = 0; index0 < 8; ++index0) {
               if (Math.random() < 0.5) {
                  final AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var50 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var50.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        if (itemstackiterator.getItem() != ItemStack.EMPTY.getItem()) {
                           ++num2;
                        }
                     }
                  }

                  if (num2 > 0.0) {
                     double var30 = Math.ceil(Math.random() * num2);
                     num2 = 0.0;
                     AtomicReference<IItemHandler> _iitemhandlerref2 = new AtomicReference();
                     var50 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var50.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref2.set(o);
                     }
                  });
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                           ++num2;
                           if (num2 >= var30) {
                              item_a = itemstackiterator.copy();
                              break;
                           }
                        }
                     }
                  } else {
                     double var33 = (double)Mth.nextInt(RandomSource.create(), 1, 10);
                     if (var33 == 1.0) {
                        item_a = (new ItemStack(Items.GOLDEN_SWORD)).copy();
                     } else if (var33 == 2.0) {
                        item_a = (new ItemStack(Items.GOLDEN_HOE)).copy();
                     } else if (var33 == 3.0) {
                        item_a = (new ItemStack(Items.GOLDEN_AXE)).copy();
                     } else if (var33 == 4.0) {
                        item_a = (new ItemStack(Items.WRITABLE_BOOK)).copy();
                     } else if (var33 == 5.0) {
                        item_a = (new ItemStack(Items.GLASS_BOTTLE)).copy();
                     } else if (var33 == 6.0) {
                        item_a = (new ItemStack(Items.AMETHYST_SHARD)).copy();
                     } else if (var33 == 7.0) {
                        item_a = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).copy();
                     } else if (var33 == 8.0) {
                        item_a = (new ItemStack(Blocks.SKELETON_SKULL)).copy();
                     } else if (var33 == 9.0) {
                        item_a = (new ItemStack(Items.CAULDRON)).copy();
                     } else {
                        item_a = (new ItemStack((ItemLike)JujutsucraftModItems.KNIFE.get())).copy();
                     }
                  }

                  double var31 = Math.toRadians(Math.random() * 360.0);
                  double var34 = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(var31) * (range / 2.0 - 4.0);
                  double var35 = entity.getPersistentData().getDouble("y_pos_doma");
                  double var36 = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(var31) * (range / 2.0 - 4.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var34, var35, var36), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity17 = (LivingEntity)entityinstance;
                           if (_livingEntity17.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity17.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity23 = (LivingEntity)entityinstance;
                           if (_livingEntity23.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              AttributeInstance var52;
                              double var53;
                              label130: {
                                 var52 = _livingEntity23.getAttribute(Attributes.ATTACK_DAMAGE);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity19 = (LivingEntity)entityinstance;
                                    if (_livingEntity19.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var53 = _livingEntity19.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label130;
                                    }
                                 }

                                 var53 = 0.0;
                              }

                              double var10002;
                              label125: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity20 = (LivingEntity)entity;
                                    if (_livingEntity20.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var10002 = _livingEntity20.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label125;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              int var10003;
                              label120: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label120;
                                    }
                                 }

                                 var10003 = 0;
                              }

                              var52.setBaseValue(var53 + (var10002 + (double)(var10003 * 3)) * 0.5);
                           }
                        }

                        entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                        entityinstance.getPersistentData().putBoolean("Shikigami", true);
                        entityinstance.getPersistentData().putBoolean("domain_entity", true);
                        if (entityinstance instanceof RozetsuShikigamiEntity) {
                           RozetsuShikigamiEntity animatable = (RozetsuShikigamiEntity)entityinstance;
                           animatable.setTexture("clear");
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           ItemStack _setstack = item_a.copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        entityinstance.setCustomName(Component.literal(""));
                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }
            }
         }

      }
   }
}
