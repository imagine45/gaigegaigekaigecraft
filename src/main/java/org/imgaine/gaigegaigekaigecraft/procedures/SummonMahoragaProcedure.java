package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonMahoragaProcedure {
   public SummonMahoragaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean flag_a = false;
         String STR1 = "";
         ItemStack ITEM1 = ItemStack.EMPTY;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw_enemy = 0.0;
         double dis = 0.0;
         double x_fix = 0.0;
         double z_fix = 0.0;
         double num = 0.0;
         double NUM1 = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
            }
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.EMPTY;
         }

         ITEM1 = var10000.copy();
         yaw = (double)entity.getYRot();
         picth = (double)entity.getXRot();
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.getPersistentData().putDouble("cnt2", 1.0);
            LivingEntity var106;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var106 = _mobEnt.getTarget();
            } else {
               var106 = null;
            }

            if (var106 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var106 = _mobEnt.getTarget();
               } else {
                  var106 = null;
               }

               x_pos = ((Entity)var106).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var106 = _mobEnt.getTarget();
               } else {
                  var106 = null;
               }

               double var109 = ((Entity)var106).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var109 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var110;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var110 = _mobEnt.getTarget();
               } else {
                  var110 = null;
               }

               z_pos = ((Entity)var110).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            entity.setYRot(entity.getYRot());
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
            if (ITEM1.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
               entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
               entity.getPersistentData().putDouble("y_pos", entity.getY());
               entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
               entity.getPersistentData().putDouble("cnt1", 75.0);
            } else {
               entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
               entity.getPersistentData().putDouble("y_pos", entity.getY());
               entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 70, 0, false, false));
                  }
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
                  if (entityiterator instanceof LivingEntity) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 80, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 9, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 40, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 40, 0, false, false));
                        }
                     }
                  }
               }
            }

            entity.setYRot((float)yaw);
            entity.setXRot((float)picth);
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

         if (entity.getPersistentData().getDouble("cnt1") % 10.0 == 1.0 && entity.getPersistentData().getDouble("cnt1") <= 41.0) {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            dis = 4.0 + entity.getPersistentData().getDouble("cnt3") * 1.5;
            logic_a = false;

            for(int index0 = 0; index0 < 2; ++index0) {
               yaw = Math.toRadians(entity.getPersistentData().getDouble("yaw") + 90.0 + (double)(logic_a ? 20 : -20));
               pitch = Math.toRadians(0.0);
               x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(yaw) * dis;
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(yaw) * dis;
               if (entity.getPersistentData().getDouble("cnt3") % 2.0 == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAHORAGA_DOG.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.setYRot((float)(entity.getPersistentData().getDouble("yaw") + (double)(logic_a ? -90 : 90)));
                        entityinstance.setXRot(-60.0F);
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        entityinstance.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1"));
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

                        entityinstance.setYRot((float)(entity.getPersistentData().getDouble("yaw") + (double)(logic_a ? -90 : 90)));
                        entityinstance.setXRot(-60.0F);
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAHORAGA_FROG.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     entityinstance.setYRot((float)(entity.getPersistentData().getDouble("yaw") + (double)(logic_a ? -90 : 90)));
                     entityinstance.setXRot(-60.0F);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1"));
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.setYRot((float)(entity.getPersistentData().getDouble("yaw") + (double)(logic_a ? -90 : 90)));
                     entityinstance.setXRot(-60.0F);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               logic_a = !logic_a;
            }
         }

         x_pos = entity.getPersistentData().getDouble("x_pos");
         y_pos = entity.getPersistentData().getDouble("y_pos");
         z_pos = entity.getPersistentData().getDouble("z_pos");
         yaw = entity.getPersistentData().getDouble("yaw");
         picth = 0.0;
         if (entity.getPersistentData().getDouble("cnt1") < 70.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 50, 4.0, 0.0, 4.0, 0.0);
            }

            PlayAnimationProcedure.execute(world, entity);
         } else {
            if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
               entity.getPersistentData().putDouble("cnt4", 1.0);
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 0.75F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.5);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.EIGHT_HANDLED_SWORD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     label336: {
                        label416: {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                           entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                           entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                           if (entity.getPersistentData().getDouble("TenShadowsTechnique14") != 1.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label416;
                              }

                              ServerPlayer _plr101 = (ServerPlayer)entity;
                              if (!(_plr101.level() instanceof ServerLevel) || !_plr101.getAdvancements().getOrStartProgress(_plr101.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_mahoraga"))).isDone()) {
                                 break label416;
                              }
                           }

                           entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                           entityinstance.getPersistentData().putBoolean("Ambush", true);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity112 = (LivingEntity)entityinstance;
                              if (_livingEntity112.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 double var114;
                                 AttributeInstance var111;
                                 label323: {
                                    var111 = _livingEntity112.getAttribute(Attributes.ATTACK_DAMAGE);
                                    if (entityinstance instanceof LivingEntity) {
                                       LivingEntity _livingEntity108 = (LivingEntity)entityinstance;
                                       if (_livingEntity108.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                          var114 = _livingEntity108.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                          break label323;
                                       }
                                    }

                                    var114 = 0.0;
                                 }

                                 double var10002;
                                 label318: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity109 = (LivingEntity)entity;
                                       if (_livingEntity109.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                          var10002 = _livingEntity109.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                          break label318;
                                       }
                                    }

                                    var10002 = 0.0;
                                 }

                                 int var10003;

                                 label313: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                          var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                          break label313;
                                       }
                                    }

                                    var10003 = 0;
                                 }

                                 var111.setBaseValue(var114 + (var10002 + (double)(var10003 * 3)) * 0.2);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.level().isClientSide()) {
                                 MobEffectInstance var115;
                                 MobEffect var116;
                                 int var10005;
                                 label305: {
                                    var116 = MobEffects.DAMAGE_RESISTANCE;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                          var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                          break label305;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var115 = new MobEffectInstance(var116, 2147483647, Math.max(var10005, 3), false, false);
                                 _entity.addEffect(var115);
                              }
                           }

                           entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                           entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                           entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                           break label336;
                        }

                        entityinstance.getPersistentData().putString("TARGET_UUID", entity.getStringUUID());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entityinstance;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                           _player.getInventory().setChanged();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                        }
                     }

                     if (ITEM1.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        CompoundTag _nbtTag = ITEM1.getTag();
                        if (_nbtTag != null) {
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityinstance;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.setTag(_nbtTag.copy());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(3, ItemStack.EMPTY);
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }

                        entity.getPersistentData().putDouble("skill", 0.0);
                     }

                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt10"));
                     }

                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(entity.getXRot());
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("TenShadowsTechnique14", -1.0);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
               entity.getPersistentData().putDouble("skill", 0.0);
            } else if (entity.getPersistentData().getDouble("cnt1") > 125.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         if (entity instanceof SukunaFushiguroEntity) {
            entity.getPersistentData().putBoolean("flag_agito", true);
            if (entity.getPersistentData().getDouble("TenShadowsTechnique5") != -1.0) {
               entity.getPersistentData().putDouble("TenShadowsTechnique5", -2.0);
            }

            if (entity.getPersistentData().getDouble("TenShadowsTechnique9") != -1.0) {
               entity.getPersistentData().putDouble("TenShadowsTechnique9", -2.0);
            }

            if (entity.getPersistentData().getDouble("TenShadowsTechnique11") != -1.0) {
               entity.getPersistentData().putDouble("TenShadowsTechnique11", -2.0);
            }
         }

      }
   }
}
