package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class TakabaLookOutProcedure {
   public TakabaLookOutProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean player = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double NUM_SUM = 0.0;
         double HP = 0.0;
         Entity entity_a = null;
         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            x_pos = ((Entity)var10000).getX();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            double var42 = ((Entity)var10000).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var42 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var43;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var43 = _mobEnt.getTarget();
            } else {
               var43 = null;
            }

            z_pos = ((Entity)var43).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.isPassenger() && entity.getVehicle() instanceof LivingEntity) {
            entity_a = entity.getVehicle();
         }

         if (!(entity_a instanceof LivingEntity)) {
            x_pos = entity.getX();
            y_pos = entity.getY();
            z_pos = entity.getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.TRUCK.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
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

                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  entity_a = entityinstance;
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         if (entity_a instanceof LivingEntity) {
            entity_a.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.level().isClientSide()) {
                  MobEffectInstance var44;
                  MobEffect var10003;
                  int var10005;
                  label101: {
                     var10003 = MobEffects.DAMAGE_BOOST;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label101;
                        }
                     }

                     var10005 = 0;
                  }

                  var44 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                  _entity.addEffect(var44);
               }
            }

            entity_a.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
            entity_a.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
            entity_a.getPersistentData().putBoolean("Shikigami", true);
            entity_a.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
            entity_a.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
            entity_a.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
            entity_a.getPersistentData().putDouble("skill", 158.0);
            entity_a.getPersistentData().putDouble("cnt6", 12.0);
            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }

            entity.stopRiding();
            entity.startRiding(entity_a);
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
