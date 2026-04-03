package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class TechniqueRika1Procedure {
   public TechniqueRika1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         boolean summon = false;
         boolean noControl = false;
         Entity entity_rika = null;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double HP = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         int var10000;
         if (entity instanceof Player) {
            label400: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr3 = (ServerPlayer)entity;
                  if (_plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_rika_control"))).isDone()) {
                     var10000 = 0;
                     break label400;
                  }
               }

               var10000 = 1;
            }
         } else {
            label395: {
               if (!(entity instanceof Player)) {
                  label392: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label392;
                        }
                     }

                     var10000 = 0;
                  }

                  if (var10000 < 10) {
                     var10000 = 1;
                     break label395;
                  }
               }

               var10000 = 0;
            }
         }

         noControl = var10000 != 0;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            label383: {
               if (entity instanceof Player) {
                  if (!(entity instanceof ServerPlayer)) {
                     break label383;
                  }

                  ServerPlayer _plr8 = (ServerPlayer)entity;
                  if (!(_plr8.level() instanceof ServerLevel) || !_plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_curseis_lifted"))).isDone()) {
                     break label383;
                  }
               } else if (!(entity instanceof OkkotsuYutaCullingGameEntity)) {
                  break label383;
               }

               entity.getPersistentData().putDouble("cnt3", 1.0);
            }

            if (LocateRikaProcedure.execute(world, entity)) {
               entity.getPersistentData().putDouble("cnt4", 1.0);
            } else {
               entity.getPersistentData().putDouble("cnt4", 0.0);
               entity.getPersistentData().putDouble("cnt2", 1.0);
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               if (var94 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var94 = _mobEnt.getTarget();
                  } else {
                     var94 = null;
                  }

                  int var96;
                  label366: {
                     LivingEntity var37 = var94;
                     if (var37 instanceof LivingEntity) {
                        LivingEntity _livEnt = var37;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var96 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label366;
                        }
                     }

                     var96 = 0;
                  }
                  int var10001;
                  double var97;
                  label361: {
                     var97 = (double)var96;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label361;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var97 <= (double)var10001 * 0.5) {
                     entity.getPersistentData().putDouble("cnt2", 0.0);
                  }
               }

               if (noControl || entity.isShiftKeyDown()) {
                  entity.getPersistentData().putDouble("cnt2", 0.0);
               }
            }

            LivingEntity var98;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var98 = _mobEnt.getTarget();
            } else {
               var98 = null;
            }

            if (var98 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var98 = _mobEnt.getTarget();
               } else {
                  var98 = null;
               }

               Level var100 = ((Entity)var98).level();
               ClipContext var107;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var112 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var119 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var119 = var119.add(((Entity)var10005).getViewVector(1.0F).scale(-5.0));
               ClipContext.Block var127 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var107 = new ClipContext(var112, var119, var127, var10006, var10007);
               x_pos = (double)var100.clip(var107).getBlockPos().getX();
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.getTarget();
               } else {
                  var101 = null;
               }

               Level var102 = ((Entity)var101).level();
               LivingEntity var113;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var113 = _mobEnt.getTarget();
               } else {
                  var113 = null;
               }

               Vec3 var114 = ((Entity)var113).getEyePosition(1.0F);
               LivingEntity var121;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var121 = _mobEnt.getTarget();
               } else {
                  var121 = null;
               }

               Vec3 var122 = ((Entity)var121).getEyePosition(1.0F);
               LivingEntity var128;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var128 = _mobEnt.getTarget();
               } else {
                  var128 = null;
               }

               var122 = var122.add(((Entity)var128).getViewVector(1.0F).scale(-5.0));
               ClipContext.Block var129 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var107 = new ClipContext(var114, var122, var129, var10006, var10007);
               y_pos = (double)var102.clip(var107).getBlockPos().getY();
               LivingEntity var103;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var103 = _mobEnt.getTarget();
               } else {
                  var103 = null;
               }

               Level var104 = ((Entity)var103).level();
               LivingEntity var115;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var115 = _mobEnt.getTarget();
               } else {
                  var115 = null;
               }

               Vec3 var116 = ((Entity)var115).getEyePosition(1.0F);
               LivingEntity var124;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.getTarget();
               } else {
                  var124 = null;
               }

               Vec3 var125 = ((Entity)var124).getEyePosition(1.0F);
               LivingEntity var130;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var130 = _mobEnt.getTarget();
               } else {
                  var130 = null;
               }

               var125 = var125.add(((Entity)var130).getViewVector(1.0F).scale(-5.0));
               ClipContext.Block var131 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var107 = new ClipContext(var116, var125, var131, var10006, var10007);
               z_pos = (double)var104.clip(var107).getBlockPos().getZ();
               LivingEntity var105;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.getTarget();
               } else {
                  var105 = null;
               }

               yaw = (double)((Entity)var105).getYRot();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.getTarget();
               } else {
                  var105 = null;
               }

               picth = (double)((Entity)var105).getXRot();
            } else {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               yaw = (double)(entity.getYRot() + 180.0F);
               picth = (double)(entity.getXRot() * -1.0F);
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
            entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
         }

         summon = entity.getPersistentData().getDouble("cnt2") == 1.0;
         if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
            if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
                  label411: {
                     if (entity instanceof Player) {
                        if (!entity.isShiftKeyDown()) {
                           break label411;
                        }
                     } else if (!(Math.random() < 0.5)) {
                        break label411;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, entity_rika.getX(), entity_rika.getY(), entity_rika.getZ(), 50, 1.0, 1.0, 1.0, 0.0);
                     }

                     entity_rika.setYRot((float)yaw);
                     entity_rika.setXRot((float)picth);
                     entity_rika.setYBodyRot(entity_rika.getYRot());
                     entity_rika.setYHeadRot(entity_rika.getYRot());
                     entity_rika.yRotO = entity_rika.getYRot();
                     entity_rika.xRotO = entity_rika.getXRot();
                     if (entity_rika instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_rika;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entity_rika.teleportTo(x_pos, y_pos, z_pos);
                     if (entity_rika instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity_rika;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity_rika.getYRot(), entity_rika.getXRot());
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.25);
                     }
                  }

                  entity_rika.getPersistentData().putBoolean("flag_attack", true);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         } else {
            if (summon) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.technique.rika1").getString()), true);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
                  entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + Math.random() * 0.1);
                  entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
                  entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                  entity.getPersistentData().putDouble("pitch", 0.0);
                  if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity79 = (LivingEntity)entity;
                        if (_livingEntity79.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity79.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity80 = (LivingEntity)entity;
                        if (_livingEntity80.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity80.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(4.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(noControl ? Component.translatable("jujutsu.technique.rika4").getString() : Component.translatable("jujutsu.technique.rika3").getString()), true);
                  }
               }

               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 5.0));
            }

            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            yaw = entity.getPersistentData().getDouble("yaw");
            picth = entity.getPersistentData().getDouble("pitch");
            if (entity.getPersistentData().getDouble("cnt1") < 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 25, 1.0, 1.0, 1.0, 0.25);
               }
            } else if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               if (entity.getPersistentData().getDouble("cnt3") > 0.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.RIKA_2.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.setYRot((float)yaw);
                        entityinstance.setXRot((float)picth);
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        entity.getPersistentData().putString("RIKA_UUID", entityinstance.getStringUUID());
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.level().isClientSide()) {
                              MobEffectInstance var111;
                              MobEffect var118;
                              int var133;
                              label307: {
                                 var118 = MobEffects.DAMAGE_BOOST;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var133 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label307;
                                    }
                                 }

                                 var133 = 0;
                              }

                              var111 = new MobEffectInstance(var118, 2147483647, Math.max(var133, entityinstance instanceof RikaEntity ? 20 : 16), false, false);
                              _entity.addEffect(var111);
                           }
                        }

                        entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                        entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                        entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player);
                        if (!summon) {
                           entityinstance.getPersistentData().putDouble("skill", 11.0);
                           dis = noControl ? 3.0 : 2.0;
                           entityinstance.getPersistentData().putDouble("despawn_flag", dis);
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.RIKA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     entityinstance.setYRot((float)yaw);
                     entityinstance.setXRot((float)picth);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entity.getPersistentData().putString("RIKA_UUID", entityinstance.getStringUUID());
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var110;
                           MobEffect var117;
                           int var132;
                           label316: {
                              var117 = MobEffects.DAMAGE_BOOST;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var132 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label316;
                                 }
                              }

                              var132 = 0;
                           }

                           var110 = new MobEffectInstance(var117, 2147483647, Math.max(var132, entityinstance instanceof RikaEntity ? 20 : 16), false, false);
                           _entity.addEffect(var110);
                        }
                     }

                     entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                     entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                     entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player);
                     if (!summon) {
                        entityinstance.getPersistentData().putDouble("skill", 11.0);
                        dis = noControl ? 3.0 : 2.0;
                        entityinstance.getPersistentData().putDouble("despawn_flag", dis);
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 25, 1.0, 1.0, 1.0, 0.75);
               }
            } else if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
               if (summon) {
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");

                  for(int index0 = 0; index0 < 36; ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 1.0, Mth.nextDouble(RandomSource.create(), 0.0, 2.0), x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), 0.0, z_pos, z_pos, "minecraft:squid_ink");
                  }
               } else {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
