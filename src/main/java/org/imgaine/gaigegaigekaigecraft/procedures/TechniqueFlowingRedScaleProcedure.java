package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueFlowingRedScaleProcedure {
   public TechniqueFlowingRedScaleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10000;
         label70: {
            double timer = 0.0;
            double strength = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                  var10000 = -1;
                  break label70;
               }
            }

            label61: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label61;
                  }
               }

               var10000 = 0;
            }

            ++var10000;
         }

         double var14 = (double)var10000;
         if (var14 >= 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 2147483647, (int)Math.round(var14)));
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.technique.choso5").getString() + ": ON"), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.technique.choso5").getString() + ": OFF"), false);
               }
            }
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
         }

         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
