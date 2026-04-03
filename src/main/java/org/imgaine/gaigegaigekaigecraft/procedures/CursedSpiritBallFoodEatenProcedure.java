package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritBallFoodEatenProcedure {
   public CursedSpiritBallFoodEatenProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         String STR1 = "";
         double NUM1 = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         boolean logic_a = false;
         itemstack.shrink(1);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 0, false, false));
            }
         }

         if (itemstack.getOrCreateTag().getString("owner_name_data").equals(entity.getDisplayName().getString()) && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18.0)) {
            x_pos = 0.0;
            z_pos = 0.0;
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               Commands var10000 = entity.getServer().getCommands();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
               long var10002 = Math.round(x_pos);
               var10000.performPrefixedCommand(var10001, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _origLevel = (ServerLevel)world;
               LevelAccessor var26 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
               if (var26 != null) {
                  Vec3 _center = new Vec3(x_pos, itemstack.getOrCreateTag().getDouble("y_data"), z_pos);

                  for(Entity entityiterator : var26.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                     if (entity != entityiterator && itemstack.getOrCreateTag().getString("name_data").equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") != entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                        NUM1 = 0.0;

                        for(int index0 = 0; index0 < 10000; ++index0) {
                           ++NUM1;
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                           if (entity.getPersistentData().getDouble(STR1) == 0.0 || entity.getPersistentData().getString(STR1 + "_name").equals(itemstack.getOrCreateTag().getString("name_data"))) {
                              entity.getPersistentData().putDouble(STR1, itemstack.getOrCreateTag().getDouble("y_data"));
                              entity.getPersistentData().putString(STR1 + "_name", itemstack.getOrCreateTag().getString("name_data"));
                              break;
                           }
                        }

                        entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        break;
                     }
                  }

                  logic_a = false;
                  entity.getPersistentData().putDouble(STR1 + "_num", 0.0);
                  _center = new Vec3(x_pos, itemstack.getOrCreateTag().getDouble("y_data"), z_pos);

                  for(Entity entityiterator : var26.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                     if (entity != entityiterator && itemstack.getOrCreateTag().getString("name_data").equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                        entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                     }
                  }
               }

               world = world;
            }

            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 0.0 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 299, 19));
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         Item var44 = itemstack.getItem();
         ItemStack var46;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var46 = _livEnt.getMainHandItem();
         } else {
            var46 = ItemStack.EMPTY;
         }

         if (var44 == var46.getItem()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }
         } else {
            var44 = itemstack.getItem();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var46 = _livEnt.getOffhandItem();
            } else {
               var46 = ItemStack.EMPTY;
            }

            if (var44 == var46.getItem() && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.OFF_HAND, true);
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 1);
         }

      }
   }
}
