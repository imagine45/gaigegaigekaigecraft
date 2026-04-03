package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ItadoriDomainExpansionProcedure {
   public ItadoriDomainExpansionProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double num2 = 0.0;
         dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
         entity.getPersistentData().putDouble("select", 21.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.0));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.0), false);
               }
            }

            if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
               entity.getPersistentData().putDouble("NameRanged", Math.random());
            }

            for(int index0 = 0; index0 < 6; ++index0) {
               for(int index1 = 0; index1 < 32; ++index1) {
                  num2 = Math.random();
                  if (num2 > 0.5) {
                     num2 *= dis - 4.0;
                     break;
                  }
               }

               num1 = Math.toRadians(Math.random() * 90.0 + 180.0);
               x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
               y_pos = entity.getPersistentData().getDouble("y_pos_doma") + 1.0;
               z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;

               for(int index2 = 0; index2 < 16; ++index2) {
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     ++y_pos;
                  } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                     --y_pos;
                  } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                     y_pos = Math.floor(y_pos);
                     break;
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TREE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.setYRot((float)(Math.random() * 360.0));
                     entityinstance.setXRot((float)((Math.random() - 0.5) * 30.0));
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                        if (_livingEntity25.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity25.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0 + Math.random());
                        }
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
