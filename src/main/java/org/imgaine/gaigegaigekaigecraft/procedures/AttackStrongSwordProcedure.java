package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackSlashEntity;
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

public class AttackStrongSwordProcedure {
   public AttackStrongSwordProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String color1 = "";
         String color2 = "";
         String color3 = "";
         boolean logic_a = false;
         boolean whip_type = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         double strength = 0.0;
         double range = 0.0;
         double loop_num = 0.0;
         double dis2 = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double dis_start = 0.0;
         double attack_reach = 0.0;
         double size = 0.0;
         double counter = 0.0;
         double rad = 0.0;
         double CNT6 = 0.0;
         double count = 0.0;
         double NUM1 = 0.0;
         double weapon_size = 0.0;
         double d = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
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

            double var10001;
            double var10002;
            label181: {
               var10001 = entity.getPersistentData().getDouble("cnt6");
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var10002 = 0.3;
                     break label181;
                  }
               }

               var10002 = 0.2;
            }

            int var10000;
            label176: {
               CNT6 = 1.0 + var10001 * var10002;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label176;
                  }
               }

               var10000 = 0;
            }

            strength = (double)Math.min(var10000, 50) * CNT6;
            weapon_size = GetWeaponSizeProcedure.execute(entity);
            attack_reach = GetReachProcedure.execute(entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            range = range * range * Math.sqrt(weapon_size * attack_reach);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               double var95;
               label169: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity12 = (LivingEntity)entity;
                     if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var95 = _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getValue();
                        break label169;
                     }
                  }

                  var95 = 0.0;
               }

               if (var95 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity13 = (LivingEntity)entity;
                     if (_livingEntity13.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity13.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entity;
                     if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
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

               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               dis = 2.5 * range;
               entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis);
               entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis);
               entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis);
               x_pos = entity.getPersistentData().getDouble("x_pos");
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos");
               ItemStack var96;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var96 = _livEnt.getMainHandItem();
               } else {
                  var96 = ItemStack.EMPTY;
               }

               item_a = var96.copy();
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_SLASH.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
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

                     entityinstance.getPersistentData().putString("color3", item_a.getOrCreateTag().getString("color3"));
                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        EntityAttackSlashEntity animatable = (EntityAttackSlashEntity)entityinstance;
                        animatable.setTexture(item_a.getOrCreateTag().getString("slash_color").isEmpty() ? "slash_white" : item_a.getOrCreateTag().getString("slash_color"));
                     }

                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle1");
                     }

                     if (item_a.is(ItemTags.create(new ResourceLocation("forge:whip")))) {
                        if (entityinstance instanceof EntityAttackSlashEntity) {
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle1_whip");
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity51 = (LivingEntity)entityinstance;
                           if (_livingEntity51.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity51.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(3.0 * range);
                           }
                        }
                     } else {
                        if (entityinstance instanceof EntityAttackSlashEntity) {
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle1");
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity55 = (LivingEntity)entityinstance;
                           if (_livingEntity55.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity55.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(3.0 * range);
                           }
                        }
                     }

                     entityinstance.teleportTo(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))), false);
                  }
               }

               if (item_a.is(ItemTags.create(new ResourceLocation("minecraft:swords"))) && !item_a.is(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(range * 0.5), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(range * 0.5), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))), false);
                  }
               }

               if ((item_a.is(ItemTags.create(new ResourceLocation("forge:metallic"))) || item_a.is(ItemTags.create(new ResourceLocation("forge:whip")))) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(range * 0.5), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(range * 0.5), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))), false);
                  }
               }

               entity.getPersistentData().putDouble("Damage", 11.0 * CNT6);
               entity.getPersistentData().putDouble("knockback", 1.5 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1));
               entity.getPersistentData().putDouble("Range", 6.0 * range);
               entity.getPersistentData().putDouble("effect", 5.0);
               entity.getPersistentData().putDouble("projectile_type", 1.0);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                  x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX();
                  y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY();
                  z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ();
                  d = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                  entity.getPersistentData().putDouble("BlockDamage", (0.1 + strength / 16.0) * Math.max(d * 0.25, 1.0));
                  entity.getPersistentData().putDouble("BlockRange", Math.max(1.0 * range, Math.max(d * 0.5, 1.0)));
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 17.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

      }
   }
}
