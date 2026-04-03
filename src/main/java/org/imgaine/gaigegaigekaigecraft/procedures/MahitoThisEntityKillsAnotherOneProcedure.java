package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.TransfiguredHumanEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.ModList;

public class MahitoThisEntityKillsAnotherOneProcedure {
   public MahitoThisEntityKillsAnotherOneProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double size = 0.0;
         double NUM1 = 0.0;
         if (!entity.isAlive() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human")))) {
            if (sourceentity.getPersistentData().getDouble("friend_num") == 0.0) {
               sourceentity.getPersistentData().putDouble("friend_num", Math.random());
            }

            x_pos = entity.getX();
            y_pos = entity.getY();
            z_pos = entity.getZ();
            size = 0.75 + Math.random();
            NUM1 = (double)Math.round(Math.ceil(Math.random() * 3.0));
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.TRANSFIGURED_HUMAN.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  entityinstance.getPersistentData().putString("OWNER_UUID", sourceentity.getStringUUID());
                  entityinstance.getPersistentData().putDouble("friend_num", sourceentity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putDouble("friend_num_worker", sourceentity.getPersistentData().getDouble("friend_num"));
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

                  if (ModList.get().isLoaded("pehkui")) {
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "scale set pehkui:height " + size + " @s");
                     }

                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "scale set pehkui:width " + size + " @s");
                     }
                  } else if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity26 = (LivingEntity)entityinstance;
                     if (_livingEntity26.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity26.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
                     }
                  }

                  if (entityinstance instanceof TransfiguredHumanEntity) {
                     TransfiguredHumanEntity animatable = (TransfiguredHumanEntity)entityinstance;
                     animatable.setTexture("idle_transfiguration" + Math.round(NUM1) + "_skin");
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
