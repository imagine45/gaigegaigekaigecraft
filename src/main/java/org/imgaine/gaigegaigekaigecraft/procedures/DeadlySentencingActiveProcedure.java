package org.imgaine.gaigegaigekaigecraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade22Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWitnessStandEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JudgemanEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class DeadlySentencingActiveProcedure {
   public DeadlySentencingActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean startJudgeman;
         boolean update;
         boolean logic_judgeTarget;
         String guilt_str;
         double guilt_karma;
         Entity entity_target;
         Entity entity_targetJudge;
         double range;
         double var10000;
         label1015: {
            ItemStack itemMainhand = ItemStack.EMPTY;
            ItemStack itemOffhand = ItemStack.EMPTY;
            ItemStack replace_item = ItemStack.EMPTY;
            ItemStack executioners_sword = ItemStack.EMPTY;
            boolean logic_a = false;
            startJudgeman = false;
            update = false;
            boolean logic_hitDomain = false;
            boolean logic_noFriend = false;
            logic_judgeTarget = false;
            guilt_str = "";
            String dd = "";
            String MM = "";
            String pattern = "";
            String yyyy = "";
            String tellrawCommand = "";
            double x_dis = 0.0;
            double distance = 0.0;
            range = 0.0;
            double x_pos = 0.0;
            double z_dis = 0.0;
            double tick = 0.0;
            double z_pos = 0.0;
            double num1 = 0.0;
            double y_pos = 0.0;
            double y_dis = 0.0;
            double num3 = 0.0;
            double num2 = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double num4 = 0.0;
            guilt_karma = 0.0;
            double num_guilt = 0.0;
            double radius = 0.0;
            double skill = 0.0;
            double strength_max = 0.0;
            Entity entity_first = null;
            Entity entity_setStand = null;
            Entity entity_judgeman = null;
            entity_target = null;
            entity_targetJudge = null;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label1015;
               }
            }

            var10000 = 0.0;
         }

         double var106 = var10000;
         double var131 = entity.getPersistentData().getDouble("skill");
         if (entity.getPersistentData().getDouble("cnt_target") > 6.0) {
            LivingEntity var206;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var206 = _mobEnt.getTarget();
            } else {
               var206 = null;
            }

            entity_target = var206;
         }

         Entity _ent = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("takada_UUID"));
         if (!(_ent instanceof JudgemanEntity) && var106 % 20.0 == 10.0) {
            double var122 = (double)entity.getYRot();
            double var120 = (double)entity.getXRot();
            RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
            double var110 = Math.toRadians((double)(entity.getYRot() + 90.0F + 180.0F));
            double var100 = entity.getX() + Math.cos(var110) * (double)(5.0F + entity.getBbWidth());
            double var114 = entity.getY();
            double var107 = entity.getZ() + Math.sin(var110) * (double)(5.0F + entity.getBbWidth());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.JUDGEMAN.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var100, var114, var107), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.setYRot(entity.getYRot());
                  entityinstance.setXRot(0.0F);
                  entityinstance.setYBodyRot(entityinstance.getYRot());
                  entityinstance.setYHeadRot(entityinstance.getYRot());
                  entityinstance.yRotO = entityinstance.getYRot();
                  entityinstance.xRotO = entityinstance.getXRot();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.getPersistentData().putString("takada_UUID", entityinstance.getStringUUID());
                  entityinstance.getPersistentData().putBoolean("domain_entity", true);
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  _ent = entityinstance;
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.setYRot((float)var122);
            entity.setXRot((float)var120);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }

         if (_ent instanceof JudgemanEntity) {
            if (var131 != 2719.0) {
               int var207;
               label1003: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var207 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                        break label1003;
                     }
                  }

                  var207 = 0;
               }

               if (var207 > 0) {
                  _ent.lookAt(Anchor.EYES, new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma")));
               } else {
                  double var111 = (double)(_ent.getYRot() % 360.0F);
                  _ent.setYRot(entity.getYRot() % 360.0F);
                  _ent.setXRot(entity.getXRot());
                  _ent.setYBodyRot(_ent.getYRot());
                  _ent.setYHeadRot(_ent.getYRot());
                  _ent.yRotO = _ent.getYRot();
                  _ent.xRotO = _ent.getXRot();
                  if (_ent instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_ent;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  double var123 = var111 - (double)entity.getYRot();
                  if (Math.abs(var123) > 180.0) {
                     _ent.setYRot((float)(var111 + Math.min(8.0, Math.abs(var123)) * (double)(var123 < 0.0 ? -1 : 1)));
                     _ent.setXRot(entity.getXRot());
                     _ent.setYBodyRot(_ent.getYRot());
                     _ent.setYHeadRot(_ent.getYRot());
                     _ent.yRotO = _ent.getYRot();
                     _ent.xRotO = _ent.getXRot();
                     if (_ent instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)_ent;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  } else {
                     _ent.setYRot((float)(var111 + Math.min(8.0, Math.abs(var123)) * (double)(var123 > 0.0 ? -1 : 1)));
                     _ent.setXRot(entity.getXRot());
                     _ent.setYBodyRot(_ent.getYRot());
                     _ent.setYHeadRot(_ent.getYRot());
                     _ent.yRotO = _ent.getYRot();
                     _ent.xRotO = _ent.getXRot();
                     if (_ent instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)_ent;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }
               }

               double var112 = Math.toRadians((double)(_ent.getYRot() + 90.0F + 180.0F));
               double var101 = entity.getX() + Math.cos(var112) * (double)(5.0F + entity.getBbWidth());
               double var115 = entity.getY();
               double var108 = entity.getZ() + Math.sin(var112) * (double)(5.0F + entity.getBbWidth());
               _ent.teleportTo(_ent.getX() + Math.min(0.5, Math.abs(var101 - _ent.getX())) * (double)(var101 > _ent.getX() ? 1 : -1), _ent.getY() + Math.min(0.5, Math.abs(var115 - _ent.getY())) * (double)(var115 > _ent.getY() ? 1 : -1), _ent.getZ() + Math.min(0.5, Math.abs(var108 - _ent.getZ())) * (double)(var108 > _ent.getZ() ? 1 : -1));
               if (_ent instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                  _serverPlayer.connection.teleport(_ent.getX() + Math.min(0.5, Math.abs(var101 - _ent.getX())) * (double)(var101 > _ent.getX() ? 1 : -1), _ent.getY() + Math.min(0.5, Math.abs(var115 - _ent.getY())) * (double)(var115 > _ent.getY() ? 1 : -1), _ent.getZ() + Math.min(0.5, Math.abs(var108 - _ent.getZ())) * (double)(var108 > _ent.getZ() ? 1 : -1), _ent.getYRot(), _ent.getXRot());
               }

               if (var131 == 0.0 && !entity.getPersistentData().getBoolean("Failed")) {
                  int var208;
                  label997: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var208 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                           break label997;
                        }
                     }

                     var208 = 0;
                  }

                  if (var208 < 200) {
                     ResetCounterProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     entity.getPersistentData().putDouble("skill", 2719.0);
                     entity.getPersistentData().putDouble("cnt3", 20.0);
                  }
               }
            }

            _ent.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (!entity.isAlive() && !_ent.level().isClientSide() && _ent.getServer() != null) {
               _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
            }
         }

         var131 = entity.getPersistentData().getDouble("skill");
         if (!entity.getPersistentData().getBoolean("Failed") || var131 == 2719.0) {
            entity.getPersistentData().putBoolean("DomainAttack", false);
            if (var106 % 20.0 == 10.0) {
               if (var131 == 2719.0 && entity.getPersistentData().getDouble("cnt3") >= 20.0) {
                  update = true;
                  entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                     if (entity.getPersistentData().getDouble("x_power") > 100.0) {
                        if (entity.getPersistentData().getDouble("x_power") - 100.0 > Mth.nextDouble(RandomSource.create(), 0.0, 100.0)) {
                           entity.getPersistentData().putDouble("cnt2", 2.0);
                        } else {
                           entity.getPersistentData().putDouble("cnt2", 0.0);
                        }
                     } else if (entity.getPersistentData().getDouble("x_power") <= 0.0) {
                        entity.getPersistentData().putDouble("cnt2", -1.0);
                     } else if (entity.getPersistentData().getDouble("x_power") > Mth.nextDouble(RandomSource.create(), 0.0, 100.0)) {
                        entity.getPersistentData().putDouble("cnt2", 0.0);
                     } else {
                        entity.getPersistentData().putDouble("cnt2", -1.0);
                     }
                  }
               }

               double var113 = 0.0;
               double var124 = 0.0;
               double var121 = 0.0;
               double var133 = -1.0;
               ItemStack var81 = (new ItemStack((ItemLike)JujutsucraftModItems.EXECUTIONERS_SWORD.get())).copy();
               Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                  if (entityiterator instanceof EntityWitnessStandEntity || entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                     double var93 = entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX();
                     double var117 = entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                     double var103 = entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ();
                     double var96 = var93 * var93 + var117 * var117 + var103 * var103;
                     if (var96 < range * 0.5 * range * 0.5) {
                        if (entityiterator instanceof EntityWitnessStandEntity) {
                           ++var124;
                        } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           if (!entityiterator.level().isClientSide()) {
                              entityiterator.discard();
                           }
                        } else {
                           boolean var83 = LogicAttackDomainProcedure.execute(world, entity, entityiterator);
                           boolean var84 = LogicAttackProcedure.execute(world, entity, entityiterator);
                           if (update) {
                              if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    Commands var209 = entityiterator.getServer().getCommands();
                                    CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator);
                                    double var10002 = entity.getPersistentData().getDouble("cnt2");
                                    var209.performPrefixedCommand(var10001, "title @s title {\"text\":\"" + Component.translatable(var10002 == -1.0 ? "jujutsu.message.higuruma0" : "jujutsu.message.higuruma1").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().getDouble("cnt1") == 2.0) {
                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma2").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().getDouble("cnt1") == 3.0) {
                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma3").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().getDouble("cnt1") >= 5.0 && entity.getPersistentData().getDouble("cnt2") >= 0.0 && var83 && var84 && entity != entityiterator) {
                                 if (entity.getPersistentData().getDouble("cnt2") == 0.0 || entity.getPersistentData().getDouble("cnt2") == 2.0) {
                                    boolean var82 = false;
                                    if (!var82) {
                                       AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                       LazyOptional var210 = entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                       Objects.requireNonNull(_iitemhandlerref);
                                       var210.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                                       if (_iitemhandlerref.get() != null) {
                                          for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                             int final_idx = _idx;
                                             ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                             if ((itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) || itemstackiterator.getOrCreateTag().getDouble("CursePower") != 0.0) && (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:whip"))) || itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:sword"))) || itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:spear"))) || itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:rifle"))) || itemstackiterator.getItem() instanceof SwordItem || itemstackiterator.getItem() instanceof AxeItem || itemstackiterator.getItem() instanceof PickaxeItem || itemstackiterator.getItem() instanceof ShovelItem || itemstackiterator.getItem() instanceof TridentItem || itemstackiterator.getItem() instanceof HoeItem || itemstackiterator.getItem() instanceof BowItem || itemstackiterator.getItem() instanceof CrossbowItem)) {
                                                var82 = true;
                                                ItemStack var80;
                                                if (entityiterator instanceof Player) {
                                                   var80 = (new ItemStack((ItemLike)JujutsucraftModItems.CONFISCATION.get())).copy();
                                                   CompoundTag _nbtTag = itemstackiterator.getTag();
                                                   if (_nbtTag != null) {
                                                      var80.setTag(_nbtTag.copy());
                                                   }

                                                   var80.getOrCreateTag().putString("confiscation_item", ForgeRegistries.ITEMS.getKey(itemstackiterator.getItem()).toString());
                                                   var80.getOrCreateTag().putDouble("CursePower_", itemstackiterator.getOrCreateTag().getDouble("CursePower"));
                                                   var80.getOrCreateTag().putDouble("Power_", itemstackiterator.getOrCreateTag().getDouble("Power"));
                                                   var80.getOrCreateTag().putDouble("Reach_", itemstackiterator.getOrCreateTag().getDouble("Reach"));
                                                   var80.getOrCreateTag().putDouble("Range_", itemstackiterator.getOrCreateTag().getDouble("Range"));
                                                   var80.getOrCreateTag().putDouble("Knockback_", itemstackiterator.getOrCreateTag().getDouble("Knockback"));
                                                   var80.getOrCreateTag().putDouble("CursePower", 0.0);
                                                   var80.getOrCreateTag().putDouble("Power", 0.0);
                                                   var80.getOrCreateTag().putDouble("Reach", 0.0);
                                                   var80.getOrCreateTag().putDouble("Range", 0.0);
                                                   var80.getOrCreateTag().putDouble("Knockback", 0.0);
                                                } else {
                                                   var80 = ItemStack.EMPTY.copy();
                                                }

                                                ItemStack _setstack = var80.copy();
                                                _setstack.setCount(itemstackiterator.getCount());
                                                entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                                                   if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                                                      _modHandlerEntSetSlot.setStackInSlot(final_idx, _setstack);
                                                   }

                                                });
                                             }
                                          }
                                       }
                                    }

                                    if (entityiterator instanceof Player) {
                                       Player _player = (Player)entityiterator;
                                       _player.getCooldowns().addCooldown((Item)JujutsucraftModItems.CONFISCATION.get(), 900);
                                    }

                                    if (!var82) {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 900, 0, false, false));
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 900, 0, false, false));
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             MobEffectInstance var221;
                                             MobEffect var10003;
                                             int var10006;
                                             label931: {
                                                var10003 = MobEffects.WEAKNESS;
                                                if (entityiterator instanceof LivingEntity) {
                                                   LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                   if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                      var10006 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                      break label931;
                                                   }
                                                }

                                                var10006 = 0;
                                             }

                                             var221 = new MobEffectInstance(var10003, 900, (int)(2.0 + (double)var10006 * 0.2), false, false);
                                             _entity.addEffect(var221);
                                          }
                                       }
                                    }
                                 }

                                 if (entity.getPersistentData().getDouble("cnt2") == 1.0 || entity.getPersistentData().getDouble("cnt2") == 2.0) {
                                    var113 = 0.0;

                                    for(int index0 = 0; index0 < 200; ++index0) {
                                       ++var113;
                                       if (var81.getOrCreateTag().getString("TARGET" + Math.round(var113)).isEmpty()) {
                                          var81.getOrCreateTag().putString("TARGET" + Math.round(var113), entityiterator.getStringUUID());
                                          break;
                                       }
                                    }
                                 }
                              }
                           }

                           if (entity != entityiterator) {
                              if (!var83) {
                                 continue;
                              }

                              if (!var84) {
                                 int var211;
                                 label902: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                          var211 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                          break label902;
                                       }
                                    }

                                    var211 = 0;
                                 }

                                 if (var211 < 1) {
                                    continue;
                                 }
                              }
                           }

                           if (entity != entityiterator) {
                              if (entity_target instanceof LivingEntity) {
                                 if (entity_target == entityiterator) {
                                    logic_judgeTarget = true;
                                 }
                              } else if (!(GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity)) {
                                 int var222;
                                 label893: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                          var222 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                          break label893;
                                       }
                                    }

                                    var222 = 0;
                                 }

                                 if (var133 < (double)var222) {
                                    label887: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                             var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                             break label887;
                                          }
                                       }

                                       var10000 = 0.0;
                                    }

                                    var133 = var10000;
                                    entity_target = entityiterator;
                                    logic_judgeTarget = true;
                                 }
                              }
                           }
                           int var213;
                           label882: {
                              ++var121;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    var213 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                    break label882;
                                 }
                              }

                              var213 = 0;
                           }

                           if (var213 < 1) {
                              ++var113;
                           }

                           if (var131 != 2719.0 && var106 % 60.0 == 50.0) {
                              if (entityiterator instanceof Player) {
                                 if (!(entityiterator instanceof LivingEntity)) {
                                    continue;
                                 }

                                 LivingEntity _livEnt203 = (LivingEntity)entityiterator;
                                 if (!_livEnt203.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    continue;
                                 }
                              }


                              int var214;
                              if (entityiterator.getPersistentData().getBoolean("CursedSpirit") && !(entityiterator instanceof CursedSpiritGrade22Entity) && !(entityiterator instanceof RozetsuEntity)) {
                                 label872: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                          var214 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                          break label872;
                                       }
                                    }

                                    var214 = 0;
                                 }

                                 if (var214 < 13) {
                                    continue;
                                 }
                              }

                              if (!entityiterator.getPersistentData().getString("JUDGE_ENTITY").isEmpty() && GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().getString("JUDGE_ENTITY")) == entity) {
                                 label1048: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt212 = (LivingEntity)entityiterator;
                                       if (_livEnt212.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                          break label1048;
                                       }
                                    }

                                    if (!(entity.getPersistentData().getDouble("x_power") > 100.0) || !(entityiterator instanceof ItadoriYujiEntity) && !(entityiterator instanceof ItadoriYujiShibuyaEntity) && !(entityiterator instanceof ItadoriYujiShinjukuEntity)) {
                                       if (Math.random() < 0.75) {
                                          if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                             entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "judgeman_answer plea_deny");
                                          }
                                       } else if (Math.random() < 0.5) {
                                          if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                             entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "judgeman_answer plea_silent");
                                          }
                                       } else if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                          entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "judgeman_answer plea_confess");
                                       }
                                       continue;
                                    }
                                 }

                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "judgeman_answer plea_confess");
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if (update) {
                  if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                     if (entity.getPersistentData().getDouble("cnt2") == -1.0 || entity.getPersistentData().getDouble("cnt2") == 1.0) {
                        entity.getPersistentData().putDouble("cnt1", 3.0);
                     }
                  } else if (entity.getPersistentData().getDouble("cnt1") == 2.0) {
                     if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                        entity.getPersistentData().putDouble("cnt1", 3.0);
                     }
                  } else if (entity.getPersistentData().getDouble("cnt1") == 3.0) {
                     entity.getPersistentData().putDouble("cnt1", 3.0);
                  } else if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
                     if (entity.getPersistentData().getDouble("cnt2") == 1.0 || entity.getPersistentData().getDouble("cnt2") == 2.0) {
                        var81.getOrCreateTag().putString("OWNER_UUID", entity.getStringUUID());
                        if (!(entity instanceof Player)) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = var81.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        } else {
                           ItemStack var218;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var218 = _livEnt.getMainHandItem();
                           } else {
                              var218 = ItemStack.EMPTY;
                           }

                           ItemStack var78 = var218.copy();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var218 = _livEnt.getOffhandItem();
                           } else {
                              var218 = ItemStack.EMPTY;
                           }

                           ItemStack var79 = var218.copy();
                           if (var78.getItem() != JujutsucraftModItems.GAVEL.get() && var78.getItem() != JujutsucraftModItems.GAVEL_LONG.get() && var78.getItem() != JujutsucraftModItems.GAVEL_BIG.get() && var78.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                              if (var79.getItem() != JujutsucraftModItems.GAVEL.get() && var79.getItem() != JujutsucraftModItems.GAVEL_LONG.get() && var79.getItem() != JujutsucraftModItems.GAVEL_BIG.get() && var79.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                 AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                 LazyOptional var220 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                 Objects.requireNonNull(_iitemhandlerref);
                                 var220.ifPresent(new NonNullConsumer<IItemHandler>() {
                                    @Override
                                    public void accept(@NotNull IItemHandler o) {
                                       _iitemhandlerref.set(o);
                                    }
                                 });
                                 if (_iitemhandlerref.get() != null) {
                                    for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                       int final_idx = _idx;
                                       ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                       if (itemstackiterator.getItem() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                          ItemStack _setstack = var81.copy();
                                          _setstack.setCount(1);
                                          entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                                             if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                                                _modHandlerEntSetSlot.setStackInSlot(final_idx, _setstack);
                                             }

                                          });
                                          break;
                                       }
                                    }
                                 }
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = var81.copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = var81.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F);
                           } else {
                              _level.playLocalSound(x, y + (double)entity.getBbHeight() * 0.5, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x, y + (double)entity.getBbHeight() * 0.5, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.FLASH, x, y + (double)entity.getBbHeight() * 0.5, z, 0, 0.0, 0.0, 0.0, 0.0);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.END_ROD, x, y + (double)entity.getBbHeight() * 0.5, z, 5, 0.0, 0.0, 0.0, 0.25);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getCooldowns().addCooldown((Item)JujutsucraftModItems.EXECUTIONERS_SWORD.get(), 0);
                        }
                     }

                     entity.getPersistentData().putDouble("skill", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                     }

                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     return;
                  }
               }

               if (var131 != 2719.0) {
                  if ((var113 >= 2.0 || var113 >= 1.0 && var121 >= 2.0) && var124 < var121) {
                     startJudgeman = true;
                     double var125 = (double)entity.getYRot();
                     double var126 = (double)entity.getXRot();
                     RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
                     double var127 = (double)entity.getYRot();
                     double var130 = Math.min(4.0 + var121 * 0.3, range * 0.5 * 0.5);
                     double var116 = entity.getPersistentData().getDouble("y_pos_doma");
                     Entity var134 = null;
                     _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                        if (entityiterator instanceof EntityWitnessStandEntity || entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                           double var94 = entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX();
                           double var118 = entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                           double var104 = entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ();
                           double var97 = var94 * var94 + var118 * var118 + var104 * var104;
                           if (var97 < range * 0.5 * range * 0.5) {
                              if (entityiterator instanceof EntityWitnessStandEntity) {
                                 if (!entityiterator.level().isClientSide()) {
                                    entityiterator.discard();
                                 }
                              } else {
                                 if (entity != entityiterator) {
                                    if (!LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                                       continue;
                                    }

                                    if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                       int var215;
                                       label790: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                var215 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                                break label790;
                                             }
                                          }

                                          var215 = 0;
                                       }

                                       if (var215 < 1) {
                                          continue;
                                       }
                                    }
                                 }

                                 double var102 = entity.getPersistentData().getDouble("x_pos_doma") + Math.cos(Math.toRadians(var127 + 90.0)) * var130 * -1.0;
                                 double var109 = entity.getPersistentData().getDouble("z_pos_doma") + Math.sin(Math.toRadians(var127 + 90.0)) * var130 * -1.0;
                                 if (var134 == null) {
                                    _ent = entity;
                                    var134 = entityiterator;
                                 } else {
                                    if (entity == entityiterator) {
                                       _ent = var134;
                                    } else {
                                       _ent = entityiterator;
                                    }

                                    if (guilt_str.isEmpty() && (!logic_judgeTarget || entity_target == _ent)) {
                                       entity_targetJudge = _ent;
                                       String var91 = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
                                       String var88 = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
                                       String var87 = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
                                       String var89 = Component.translatable("jujutsu.message.higuruma_date").getString();
                                       var89 = var89.replace("yyyy", "■■■■").replace("MM", "■■").replace("dd", "■■");

                                       while(true) {
                                          double var128 = (double)Mth.nextInt(RandomSource.create(), 24, 29);
                                          if (var128 != 24.0) {
                                             guilt_str = Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable("jujutsu.message.higuruma" + Math.round(var128)).getString()).replace("[date]", var89);
                                             guilt_karma = 90.0;
                                             break;
                                          }

                                          if (!_ent.getPersistentData().getString("crime3").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().getString("crime3");
                                             guilt_karma = 90.0;
                                             break;
                                          }
                                       }

                                       if (_ent instanceof Player && Math.random() < 0.8 || guilt_str.isEmpty()) {
                                          double var129 = (double)Mth.nextInt(RandomSource.create(), 16, 24);
                                          guilt_str = Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable("jujutsu.message.higuruma" + Math.round(var129)).getString()).replace("[date]", var89);
                                          if (var129 != 24.0 && var129 != 16.0) {
                                             guilt_karma = 90.0;
                                          } else {
                                             guilt_karma = 200.0;
                                          }
                                       }

                                       if (_ent.getPersistentData().getString("crime4").isEmpty()) {
                                          ItemStack var223;
                                          if (_ent instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)_ent;
                                             var223 = _livEnt.getMainHandItem();
                                          } else {
                                             var223 = ItemStack.EMPTY;
                                          }

                                          WhenItemPicksUpProcedure.execute(_ent, var223);
                                       }

                                       if (_ent.getPersistentData().getString("crime4").isEmpty()) {
                                          ItemStack var224;
                                          if (_ent instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)_ent;
                                             var224 = _livEnt.getOffhandItem();
                                          } else {
                                             var224 = ItemStack.EMPTY;
                                          }

                                          WhenItemPicksUpProcedure.execute(_ent, var224);
                                       }

                                       if (_ent.getPersistentData().getString("crime4").isEmpty()) {
                                          AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                          LazyOptional var216 = _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                          Objects.requireNonNull(_iitemhandlerref);
                                          var216.ifPresent(new NonNullConsumer<IItemHandler>() {
                                             @Override
                                             public void accept(@NotNull IItemHandler o) {
                                                _iitemhandlerref.set(o);
                                             }
                                          });
                                          if (_iitemhandlerref.get() != null) {
                                             for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                                ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                                if (itemstackiterator.getItem() != ItemStack.EMPTY.getItem()) {
                                                   WhenItemPicksUpProcedure.execute(_ent, itemstackiterator);
                                                   if (!_ent.getPersistentData().getString("crime4").isEmpty()) {
                                                      break;
                                                   }
                                                }
                                             }
                                          }
                                       }

                                       do {
                                          if (Math.random() < (_ent instanceof Player ? 0.33 : 0.33) && !_ent.getPersistentData().getString("crime1").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().getString("crime1");
                                             guilt_karma = 100.0 + _ent.getPersistentData().getDouble("kill_count") * 35.0;
                                             break;
                                          }

                                          if (Math.random() < (_ent instanceof Player ? 0.15 : 0.25) && !_ent.getPersistentData().getString("crime4").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().getString("crime4");
                                             if (guilt_str.contains("§4")) {
                                                guilt_karma = 125.0;
                                             } else {
                                                guilt_karma = 90.0;
                                             }
                                             break;
                                          }

                                          if (Math.random() < (_ent instanceof Player ? 0.15 : 0.25) && !_ent.getPersistentData().getString("crime2").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().getString("crime2");
                                             guilt_karma = 90.0;
                                             break;
                                          }
                                       } while(!(Math.random() < 0.5));

                                       guilt_str = guilt_str.replace("[name]", _ent.getDisplayName().getString());
                                       guilt_str = guilt_str.replace("[place]", Component.translatable("text.minecraft").getString());
                                    }
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _serverLevel = (ServerLevel)world;
                                    Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WITNESS_STAND.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var102, var116, var109), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entityinstance != null) {
                                       entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                                       SetRangedAmmoProcedure.execute(entity, entityinstance);
                                       if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                                          entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                                       }

                                       entityinstance.setYRot((float)var127);
                                       entityinstance.setXRot(0.0F);
                                       entityinstance.setYBodyRot(entityinstance.getYRot());
                                       entityinstance.setYHeadRot(entityinstance.getYRot());
                                       entityinstance.yRotO = entityinstance.getYRot();
                                       entityinstance.xRotO = entityinstance.getXRot();
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityinstance;
                                          _entity.yBodyRotO = _entity.getYRot();
                                          _entity.yHeadRotO = _entity.getYRot();
                                       }

                                       entityinstance.teleportTo(var102, var116, var109);
                                       if (entityinstance instanceof ServerPlayer) {
                                          ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                                          _serverPlayer.connection.teleport(var102, var116, var109, entityinstance.getYRot(), entityinstance.getXRot());
                                       }

                                       entityinstance.getPersistentData().putString("TARGET", _ent.getStringUUID());
                                       _ent.setYRot(entityinstance.getYRot());
                                       _ent.setXRot(0.0F);
                                       _ent.setYBodyRot(_ent.getYRot());
                                       _ent.setYHeadRot(_ent.getYRot());
                                       _ent.yRotO = _ent.getYRot();
                                       _ent.xRotO = _ent.getXRot();
                                       if (_ent instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)_ent;
                                          _entity.yBodyRotO = _entity.getYRot();
                                          _entity.yHeadRotO = _entity.getYRot();
                                       }

                                       _serverLevel.addFreshEntity(entityinstance);
                                    }
                                 }

                                 var127 += 360.0 / Math.max(var121, 1.0);
                              }
                           }
                        }
                     }

                     entity.setYRot((float)var125);
                     entity.setXRot((float)var126);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }

                  if (startJudgeman && !guilt_str.isEmpty()) {
                     entity.getPersistentData().putDouble("x_power", guilt_karma);
                     String var217 = Component.translatable("jujutsu.message.higuruma_answer1").getString();
                     String var92 = "tellraw @s [{\"text\":\"[" + var217 + "] \",\"color\":\"gray\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + Component.translatable("jujutsu.message.higuruma_answer1_").getString() + "\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/judgeman_answer plea_silent\"}},{\"text\":\"[" + Component.translatable("jujutsu.message.higuruma_answer2").getString() + "] \",\"color\":\"white\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + Component.translatable("jujutsu.message.higuruma_answer2_").getString() + "\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/judgeman_answer plea_confess\"}},{\"text\":\"[" + Component.translatable("jujutsu.message.higuruma_answer3").getString() + "] \",\"color\":\"red\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + Component.translatable("jujutsu.message.higuruma_answer3_").getString() + "\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/judgeman_answer plea_deny\"}}]";
                     _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                        double var95 = entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX();
                        double var119 = entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                        double var105 = entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ();
                        double var98 = var95 * var95 + var119 * var119 + var105 * var105;
                        if (var98 < range * 0.5 * range * 0.5) {
                           if (entityiterator instanceof Player) {
                              if (entityiterator instanceof Player) {
                                 Player _player = (Player)entityiterator;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal(guilt_str), false);
                                 }
                              }

                              if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                 entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound entity.wither.spawn master @s");
                              }

                              if (entityiterator == entity_targetJudge && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                 entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), var92);
                              }
                           }

                           if (entityiterator == entity_targetJudge) {
                              entityiterator.getPersistentData().putString("JUDGE_ENTITY", entity.getStringUUID());
                           } else {
                              entityiterator.getPersistentData().remove("JUDGE_ENTITY");
                           }
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().putBoolean("DomainAttack", false);
         }

      }
   }
}
