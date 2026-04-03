package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackStrikeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AttackStrongPunchProcedure {
   public AttackStrongPunchProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double var10001;
         double var10002;
         label175: {
            boolean logic_a = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            double strength = 0.0;
            double range = 0.0;
            double loop_num = 0.0;
            double CNT6 = 0.0;
            double entity_size = 0.0;
            double weapon_size = 0.0;
            double attack_reach = 0.0;
            double d = 0.0;
            double effectConfirm = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            var10001 = entity.getPersistentData().getDouble("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label175;
               }
            }

            var10002 = 0.2;
         }

         double var65;
         int var10000;
         label170: {
            var65 = 1.0 + var10001 * var10002;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label170;
               }
            }

            var10000 = 0;
         }

         double var60 = (double)Math.min(var10000, 50) * var65;
         double var66 = GetWeaponSizeProcedure.execute(entity);
         double var68 = GetReachProcedure.execute(entity);
         double var61 = ReturnEntitySizeProcedure.execute(entity);
         var61 = var61 * var61 * var66;
         if (entity.getPersistentData().getDouble("cnt1") < 8.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
               }
            }

            entity.getPersistentData().putDouble("Damage", 5.0);
            DamageFixProcedure.execute(entity);
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               double var54 = Math.toRadians((double)(entity.getYRot() + 90.0F));
               double var56 = Math.toRadians((double)entity.getXRot());
               double var58 = 2.5 * var61;
               double var45 = entity.getX() + Math.cos(var54) * Math.cos(var56) * var58;
               double var48 = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(var56) * -1.0 * var58;
               double var51 = entity.getZ() + Math.sin(var54) * Math.cos(var56) * var58;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_STRIKE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var45, var48, var51), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.teleportTo(var45, var48, var51);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(var45, var48, var51, entityinstance.getYRot(), entityinstance.getXRot());
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

                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        EntityAttackStrikeEntity animatable = (EntityAttackStrikeEntity)entityinstance;
                        animatable.setTexture("slash_white");
                     }

                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle3");
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity32 = (LivingEntity)entityinstance;
                        if (_livingEntity32.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity32.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0 * var61);
                        }
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               ItemStack var90;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var90 = _livEnt.getMainHandItem();
               } else {
                  var90 = ItemStack.EMPTY;
               }

               if (var90.is(ItemTags.create(new ResourceLocation("forge:spear")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        BlockPos var92 = BlockPos.containing(x, y, z);
                        SoundEvent var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var10004 = SoundSource.NEUTRAL;
                        float var10005 = (float)(var61 * 1.0);
                        ItemStack var10008;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10008 = _livEnt.getMainHandItem();
                        } else {
                           var10008 = ItemStack.EMPTY;
                        }

                        _level.playSound((Player)null, var92, var10003, var10004, var10005, (float)(0.9 / (var66 + var10008.getOrCreateTag().getDouble("Power"))));
                     } else {
                        SoundEvent var95 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var98 = SoundSource.NEUTRAL;
                        float var10006 = (float)(var61 * 1.0);
                        ItemStack var10009;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10009 = _livEnt.getMainHandItem();
                        } else {
                           var10009 = ItemStack.EMPTY;
                        }

                        _level.playLocalSound(x, y, z, var95, var98, var10006, (float)(0.9 / (var66 + var10009.getOrCreateTag().getDouble("Power"))), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     BlockPos var93 = BlockPos.containing(x, y, z);
                     SoundEvent var94 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var96 = SoundSource.NEUTRAL;
                     float var99 = (float)(var61 * 0.25);
                     ItemStack var102;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var102 = _livEnt.getMainHandItem();
                     } else {
                        var102 = ItemStack.EMPTY;
                     }

                     _level.playSound((Player)null, var93, var94, var96, var99, (float)(0.9 / (var66 + var102.getOrCreateTag().getDouble("Power"))));
                  } else {
                     SoundEvent var97 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var100 = SoundSource.NEUTRAL;
                     float var101 = (float)(var61 * 0.25);
                     ItemStack var103;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var103 = _livEnt.getMainHandItem();
                     } else {
                        var103 = ItemStack.EMPTY;
                     }

                     _level.playLocalSound(x, y, z, var97, var100, var101, (float)(0.9 / (var66 + var103.getOrCreateTag().getDouble("Power"))), false);
                  }
               }
               double var91;
               label157: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity42 = (LivingEntity)entity;
                     if (_livingEntity42.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var91 = _livingEntity42.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                        break label157;
                     }
                  }

                  var91 = 0.0;
               }

               if (var91 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity43 = (LivingEntity)entity;
                     if (_livingEntity43.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity43.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-6.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity44 = (LivingEntity)entity;
                     if (_livingEntity44.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity44.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (entity instanceof GeoEntity) {
                     if (GetEntityAnimationProcedure.execute(entity).equals("empty") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().putDouble("x_pos", x);
               entity.getPersistentData().putDouble("y_pos", Math.max(y, entity.getY() + (double)entity.getBbHeight() * 0.75));
               entity.getPersistentData().putDouble("z_pos", z);
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.5 * var61);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.5 * var61);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.5 * var61);
               double var64 = Math.max(11.0 * var68, 1.0);

               for(int index0 = 0; index0 < (int)var64; ++index0) {
                  entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
                  var45 = entity.getPersistentData().getDouble("x_pos");
                  var48 = entity.getPersistentData().getDouble("y_pos");
                  var51 = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putDouble("Damage", 11.0 * var65);
                  entity.getPersistentData().putDouble("knockback", 1.5 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1));
                  entity.getPersistentData().putDouble("Range", 2.0 * var61);
                  entity.getPersistentData().putDouble("effect", 5.0);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, var45, var48, var51, entity);
               }

               var54 = Math.toRadians((double)(entity.getYRot() + 90.0F));
               var56 = Math.toRadians((double)entity.getXRot());
               var66 = GetWeaponSizeProcedure.execute(entity);
               var68 = GetReachProcedure.execute(entity);
               var61 = Math.pow(ReturnEntitySizeProcedure.execute(entity), 2.0) * Math.sqrt(var66 * var68);
               var58 = 2.5 * var61;
               if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var58)), Block.COLLIDER, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                  var45 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var58)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX();
                  var48 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var58)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY();
                  var51 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var58)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ();
                  double var70 = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                  entity.getPersistentData().putDouble("BlockDamage", (0.1 + var60 / 16.0) * Math.max(var70 * 0.25, 1.0));
                  entity.getPersistentData().putDouble("BlockRange", Math.max(1.0 * var61, Math.max(var70 * 0.5, 1.0)));
                  BlockDestroyAllDirectionProcedure.execute(world, var45, var48, var51, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 17.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
